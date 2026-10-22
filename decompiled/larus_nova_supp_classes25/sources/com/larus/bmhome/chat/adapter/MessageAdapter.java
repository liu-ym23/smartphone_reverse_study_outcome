package com.larus.bmhome.chat.adapter;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmAgent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.interceptor.IMessageRenderInterceptor;
import com.larus.bmhome.chat.interceptor.MessageRenderState;
import com.larus.bmhome.chat.list.base.MessageCellPagingAdapter;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.social.page.datasource.diff.ActionListDiffer;
import com.larus.bmhome.utils.ListMonitor;
import com.larus.bmhome.utils.u2;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.textview.impl.SelectorRestore;
import com.larus.bmhome.view.textview.impl.SelectorTextView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageContentType;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.list.arch.IFlowListCell;
import com.larus.platform.api.ISdkPerfDegradeService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.c1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 ×\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u00020\u0007:\u0002×\u0001Bi\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012&\b\u0002\u0010\f\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010H\u001a\u0004\u0018\u00010\u000e2\u0006\u0010I\u001a\u00020\u000eH\u0016J\b\u0010J\u001a\u00020\u0000H\u0016J\b\u0010K\u001a\u00020\u0000H\u0017J5\u0010\u0086\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030w0v2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u000e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u008a\u0001H\u0014J\u000e\u0010\u008b\u0001\u001a\u0007\u0012\u0002\b\u00030\u008c\u0001H\u0016J\u000f\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030<H\u0016J\u001f\u0010\u008e\u0001\u001a\u00020\u00112\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030wH\u0096@¢\u0006\u0003\u0010\u0090\u0001J\u0019\u0010\u0091\u0001\u001a\u00020\u00112\u000e\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0093\u0001H\u0016J\u0019\u0010\u0094\u0001\u001a\u00020\u00112\u000e\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0093\u0001H\u0016J\u000f\u0010\u0095\u0001\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u0010J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u0007\u0010\u0098\u0001\u001a\u00020\u0011J\t\u0010\u0099\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0011H\u0016J\u0013\u0010\u009b\u0001\u001a\u00020\u00112\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020\u000f2\u0007\u0010\u009f\u0001\u001a\u00020\u0003H\u0016J\u0013\u0010 \u0001\u001a\u00020\u00112\b\u0010¡\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010¢\u0001\u001a\u00020\u00112\b\u0010¡\u0001\u001a\u00030\u0097\u0001H\u0016J\u0010\u0010©\u0001\u001a\u00020\u00102\u0007\u0010\u009f\u0001\u001a\u00020\u000eJ\u0007\u0010ª\u0001\u001a\u00020\u0010J#\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030¬\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u00012\u0007\u0010¯\u0001\u001a\u00020\u000fH\u0016J\"\u0010°\u0001\u001a\u00020\u00112\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030¬\u00012\u0007\u0010²\u0001\u001a\u00020\u000fH\u0016J%\u0010³\u0001\u001a\u00020\u00112\u0007\u0010²\u0001\u001a\u00020\u000f2\u0007\u0010\u009f\u0001\u001a\u00020\u00032\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u001d\u0010¶\u0001\u001a\u00020\u00102\u0007\u0010·\u0001\u001a\u00020E2\t\b\u0001\u0010¸\u0001\u001a\u00020\u000fH\u0016J%\u0010¹\u0001\u001a\u00020\u00102\u0007\u0010·\u0001\u001a\u00020E2\u000b\b\u0001\u0010¸\u0001\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0003\u0010º\u0001J%\u0010»\u0001\u001a\u00020\u00112\u000e\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010<2\n\u0010½\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0016J\u0012\u0010¾\u0001\u001a\u00020\u00112\u0007\u0010·\u0001\u001a\u00020EH\u0016J\u001d\u0010¿\u0001\u001a\u00020\u00102\u0007\u0010·\u0001\u001a\u00020E2\t\b\u0001\u0010¸\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010À\u0001\u001a\u00020\u00112\u0007\u0010²\u0001\u001a\u00020\u000fH\u0002J\u001b\u0010Á\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020E2\u0007\u0010¸\u0001\u001a\u00020\u000fH\u0016J\u001b\u0010Ã\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020E2\u0007\u0010¸\u0001\u001a\u00020\u000fH\u0002J\u001b\u0010Ä\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020E2\u0007\u0010¸\u0001\u001a\u00020\u000fH\u0002J<\u0010Ê\u0001\u001a\u00020\u00062\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u00012\u0007\u0010´\u0001\u001a\u00020\u00032\r\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050<H\u0016J$\u0010Ï\u0001\u001a\u00020\u00112\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u0001H\u0016J$\u0010Ð\u0001\u001a\u00020\u00112\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u0001H\u0016J$\u0010Ñ\u0001\u001a\u00020\u00112\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u0001H\u0016J\u0014\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010Ë\u0001\u001a\u00020EH\u0016J\t\u0010Ó\u0001\u001a\u00020,H\u0002J\u001b\u0010Ô\u0001\u001a\u00020\u00112\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010Õ\u0001H\u0016J\n\u0010Ö\u0001\u001a\u0005\u0018\u00010\u0083\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR2\u0010\f\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001b\u00101\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00100\u001a\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0<8VX\u0097\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020TX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u001a\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030<0XX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010Y\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\u00100\u00100ZX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00103\"\u0004\b`\u0010aR\u001b\u0010b\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u00100\u001a\u0004\bd\u0010eR\u001c\u0010g\u001a\u0004\u0018\u00010EX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001c\u0010l\u001a\u0004\u0018\u00010EX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010i\"\u0004\bn\u0010kR\u000e\u0010o\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u00100\u001a\u0004\br\u0010sR-\u0010u\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030w0v8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bz\u00100\u001a\u0004\bx\u0010yR\u0016\u0010{\u001a\u0004\u0018\u00010E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010iR\u001f\u0010}\u001a\u0004\u0018\u00010~8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u00100\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¤\u00010ZX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010¥\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030<0¦\u0001¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R,\u0010Å\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060Æ\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bÉ\u0001\u00100\u001a\u0006\bÇ\u0001\u0010È\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/larus/bmhome/chat/adapter/MessageAdapter;", "Lcom/larus/bmhome/chat/list/base/MessageCellPagingAdapter;", "Lcom/larus/bmhome/chat/adapter/IMessageListAdapter;", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/bmhome/chat/adapter/component/IContextManager;", "Lcom/larus/bmhome/chat/cell/text/components/BaseComponent;", "Lcom/larus/bmhome/chat/adapter/text/TextComponentContextImpl;", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "msgActionCallback", "Lkotlin/Function4;", "Lcom/larus/im/bean/message/Message;", "", "", "", "immerseBgColor", "hostFragment", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "componentFeature", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "provider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "<init>", "(Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;Lcom/larus/bmhome/chat/ChatParam;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;)V", "getLoader", "()Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "getMsgActionCallback", "()Lkotlin/jvm/functions/Function4;", "getImmerseBgColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHostFragment", "()Lkotlin/jvm/functions/Function0;", "getComponentFeature", "()Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "getProvider", "()Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "cutCellType", "Lcom/larus/bmhome/chat/list/cell/text/TextCellCutType;", "getCutCellType", "()Lcom/larus/bmhome/chat/list/cell/text/TextCellCutType;", "cutCellType$delegate", "Lkotlin/Lazy;", "cachedHistoryMsgEditable", "getCachedHistoryMsgEditable", "()Z", "cachedHistoryMsgEditable$delegate", "botMakerEventListener", "Lcom/larus/platform/model/bot/IBotMakerEventListener;", "getBotMakerEventListener", "()Lcom/larus/platform/model/bot/IBotMakerEventListener;", "setBotMakerEventListener", "(Lcom/larus/platform/model/bot/IBotMakerEventListener;)V", "currentList", "", "getCurrentList$annotations", "()V", "getCurrentList", "()Ljava/util/List;", "currentMessageCellStateList", "getCurrentMessageCellStateList", "mobCardIdCache", "Lcom/larus/bmhome/chat/search/LruSet;", "", "getMobCardIdCache", "()Lcom/larus/bmhome/chat/search/LruSet;", "findQuestionOrLast", "message", "asRecycleAdapter", "asContextManager", "chatMessageList", "Lcom/larus/bmhome/view/ChatMessageList;", "getChatMessageList", "()Lcom/larus/bmhome/view/ChatMessageList;", "setChatMessageList", "(Lcom/larus/bmhome/view/ChatMessageList;)V", "isMainBot", "itemShowHelper", "Lcom/larus/bmhome/utils/MessageListItemShowHelper;", "getItemShowHelper", "()Lcom/larus/bmhome/utils/MessageListItemShowHelper;", "onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "initialMessageListLoaded", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getInitialMessageListLoaded$impl_mainlandRelease", "()Landroidx/lifecycle/MutableLiveData;", "pendingInitialMessageListLoaded", "getPendingInitialMessageListLoaded$impl_mainlandRelease", "setPendingInitialMessageListLoaded$impl_mainlandRelease", "(Z)V", "listMonitor", "Lcom/larus/bmhome/utils/ListMonitor;", "getListMonitor", "()Lcom/larus/bmhome/utils/ListMonitor;", "listMonitor$delegate", "modifyId", "getModifyId", "()Ljava/lang/String;", "setModifyId", "(Ljava/lang/String;)V", "canModifyId", "getCanModifyId", "setCanModifyId", "enableTrackerOptimize", "chatPageMetrics", "Lcom/larus/bmhome/chat/ChatPageMetrics;", "getChatPageMetrics", "()Lcom/larus/bmhome/chat/ChatPageMetrics;", "chatPageMetrics$delegate", "differ", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;", "getDiffer", "()Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "differ$delegate", "curSecId", "getCurSecId", "cutMultipleCellNotifyManager", "Lcom/larus/mainbot/api/ICutMultipleCellNotify;", "getCutMultipleCellNotifyManager", "()Lcom/larus/mainbot/api/ICutMultipleCellNotify;", "cutMultipleCellNotifyManager$delegate", "selectorRestore", "Lcom/larus/bmhome/view/textview/impl/SelectorRestore;", "holdAnchor", "Lcom/larus/bmhome/view/textview/impl/SelectorTextView;", "createDiff", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diff", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "asRecyclerViewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getMessageList", "submitEvent", "event", "(Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerObserver", "observer", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingDataSourceObserver;", "unregisterObserver", "setIsMainBot", "getAttachedView", "Landroidx/recyclerview/widget/RecyclerView;", "notifyDataSetChangedSafely", "onPageResume", "onPagePause", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "getIndexOfData", "data", "onAttachedToRecyclerView", "recyclerView", "onDetachedFromRecyclerView", "notifyItemChangedLiveData", "", "listUpdatedLive", "Landroidx/lifecycle/MediatorLiveData;", "getListUpdatedLive", "()Landroidx/lifecycle/MediatorLiveData;", "needChangeViewAlpha", "isShareMode", "onCreateViewHolder", "Lcom/larus/list/arch/FlowListViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "tryUpdateMessageRenderStateForInterceptor", "state", "Lcom/larus/bmhome/chat/interceptor/MessageRenderState;", "notifyItemChanged", "messageId", "contentType", "notifyAllRelatedCell", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "notifyMultipleDeepThinkCutCellItemChanged", "Lcom/larus/bmhome/list/ICoreMessageCellState;", "payload", "setUpNotifyItemChangedLiveData", "newNotifyItemChanged", "notifyItemChangedSafely", "notifyLocalMessageIdItemChanged", "localMessageId", "oldNotifyLocalMessageIdItemChanged", "newNotifyLocalMessageIdItemChanged", "contextManager", "Lcom/larus/bmhome/chat/adapter/component/ContextManagerImpl;", "getContextManager", "()Lcom/larus/bmhome/chat/adapter/component/ContextManagerImpl;", "contextManager$delegate", "bindCell", "key", "cell", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "components", "unbindCell", "onCellAttachedToWindow", "onCellDetachedFromWindow", "getComponentContext", "getCutTextCellType", "cellAttachIfNeed", "Lcom/larus/list/arch/IFlowListCell;", "getSelectorRestoreInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class MessageAdapter extends MessageCellPagingAdapter implements i<xc8.b>, dc8.c<bd8.b, ec8.b>, q0 {
    public static final MessageAdapter$Companion$diff$1 M = null;
    public final Lazy A;
    public String B;
    public String C;
    public final boolean D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final SelectorRestore H;
    public SelectorTextView I;
    public final MutableLiveData<Object> J;
    public final MediatorLiveData<List<xc8.b>> K;
    public final Lazy L;
    public final ChatParam k;
    public final Function4<q0, Message, Integer, Boolean, Unit> l;
    public final Integer m;
    public final Function0<Fragment> n;
    public final ComponentFeature o;
    public final q0.a p;
    public final Lazy q;
    public final Lazy r;
    public nq9.e s;
    public final LruSet<String> t;
    public ChatMessageList u;
    public boolean v;
    public final u2 w;
    public final MutableSharedFlow<List<xc8.b>> x;
    public final MutableLiveData<Boolean> y;
    public boolean z;

    public static final class a implements kf8.a {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c implements tt8.a {
        public final /* synthetic */ MessageAdapter a;

        public final SelectorTextView b() {
            return this.a.I;
        }

        public c(MessageAdapter r1) {
            this.a = r1;
        }

        public final void a(SelectorTextView r2) {
            this.a.I = r2;
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(p r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final MessageAdapter F7() {
        return this;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final MessageAdapter L7() {
        return this;
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final Object k1(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r1, Continuation<? super Unit> r2) {
        return L2(this, r1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.adapter.MessageAdapter$Companion$diff$1] */
    static {
        M = new MessageAdapter$Companion$diff$1();
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.h0 A7() {
        return new com.larus.bmhome.chat.api.h0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.l0 D9() {
        return new com.larus.bmhome.chat.api.l0(this);
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public final com.larus.bmhome.social.page.datasource.diff.b<xc8.b, com.larus.bmhome.social.page.datasource.event.c<xc8.b>> F2() {
        return (com.larus.bmhome.social.page.datasource.diff.b) this.F.getValue();
    }

    public final ListMonitor H2() {
        return (ListMonitor) this.A.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.n0 M7() {
        return new com.larus.bmhome.chat.api.n0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.i0 N7() {
        return new com.larus.bmhome.chat.api.i0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.o0 P7() {
        return new com.larus.bmhome.chat.api.o0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.k0 Q7() {
        return new com.larus.bmhome.chat.api.k0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.g0 a9() {
        return new com.larus.bmhome.chat.api.g0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.m0 i2() {
        return new com.larus.bmhome.chat.api.m0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.f0 s5() {
        return new com.larus.bmhome.chat.api.f0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.j0 y7() {
        return new com.larus.bmhome.chat.api.j0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.p0 z7() {
        return new com.larus.bmhome.chat.api.p0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final List<xc8.b> D7() {
        return z2();
    }

    public final Message I2() {
        Object r1 = null;
        if (s0() == false) goto L21;
        Iterator<T> r0 = getCurrentList().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Object r2 = r0.next();
        Message r3 = (Message) r2;
        String r4 = T1();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != null) goto L11;
        boolean r5 = false;
    L12:
        if (r5 == false) goto L7;
        r1 = r2;
        goto L15
    L11:
        r5 = Intrinsics.areEqual(r3.getLocalMessageId(), r4);
    L15:
        return (Message) r1;
    L21:
        return null;
    }

    public final List<Message> getCurrentList() {
        List<xc8.b> r0 = z2();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((xc8.b) r2.next()).getMessage());
        goto L4
    L6:
        return r1;
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final List<xc8.b> getMessageList() {
        return z2();
    }

    public final boolean s0() {
        if (T1() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final ChatMessageList B7() {
        return this.u;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final LruSet<String> E7() {
        return this.t;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final u2 G7() {
        return this.w;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final nq9.e H7() {
        return this.s;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Integer I7() {
        return this.m;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final ComponentFeature J7() {
        return this.o;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Function4<q0, Message, Integer, Boolean, Unit> K7() {
        return this.l;
    }

    public final String T1() {
        return this.B;
    }

    public final String W() {
        return this.C;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final ChatParam getChatParam() {
        return this.k;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Function0<Fragment> getHostFragment() {
        return this.n;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final q0.a getProvider() {
        return this.p;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Message C7(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        List<xc8.b> r0 = z2();
        String r1 = r7.getReplyId();
        Message r2 = null;
        if (r1 == null) goto L16;
        Iterator<T> r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((xc8.b) r4).getMessage().getMessageId(), r1) == false) goto L6;
    L11:
        xc8.b r5 = (xc8.b) r4;
        if (r5 == null) goto L14;
        Message r6 = r5.getMessage();
    L15:
        if (r6 == null) goto L16;
        return r6;
    L14:
        r6 = null;
        goto L15
    L10:
        r4 = null;
    L16:
        Iterator<xc8.b> r8 = r0.iterator();
        int r9 = 0;
    L18:
        if (r8.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(r8.next().getMessage(), r7) == true) goto L24;
        r9 = r9 + 1;
    L24:
        xc8.b r10 = (xc8.b) CollectionsKt.getOrNull(r0, r9 + 1);
        if (r10 == null) goto L28;
        r2 = r10.getMessage();
    L28:
        return r2;
    L23:
        r9 = -1;
        goto L24
    }

    public final void F1(String r1) {
        this.B = r1;
    }

    public final void K2(boolean r3) {
        if (this.v != r3) goto L5;
        return;
    L5:
        this.v = r3;
        if (getItemCount() > 0) goto L8;
        return;
    L8:
        if (((xc8.b) ListProtector.get(z2(), 0)).getMessage().getContentType() != 2) goto L12;
        notifyItemChanged(0);
        return;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final void R7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        this.J.setValue(r2);
    }

    @Override // dc8.c
    public final dc8.b X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (ec8.b) ((dc8.a) this.L.getValue()).X0(r2);
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public final void onAttachedToRecyclerView(RecyclerView r6) {
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        super.onAttachedToRecyclerView(r6);
        ListMonitor r1 = H2();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        r6.addOnScrollListener(r1.l);
        boolean r0 = this.k.f;
        WeakHashMap<Object, e2a.a> r2 = j0.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        WeakHashMap<Object, e2a.a> r3 = j0.a;
        e2a.a r4 = r3.get(this);
        if (r4 != null) goto L5;
        r4 = new i0(this);
        r3.put(this, r4);
    L5:
        CopyOnWriteArrayList r5 = (CopyOnWriteArrayList) e2a.e.a;
        if (r5.contains(r4) == true) goto L9;
        r5.add(r4);
    L9:
        if ((r6 instanceof ChatMessageList) == false) goto L11;
        ChatMessageList r7 = (ChatMessageList) r6;
    L12:
        this.u = r7;
        SelectorRestore r8 = this.H;
        com.larus.bmhome.chat.component.bottom.reference.a r9 = this.p.N9();
        c r10 = new c(this);
        r6.addOnScrollListener(r8.f);
        r6.addOnScrollListener(r8.g);
        r8.d = r9;
        r8.h = r10;
        r8.a = null;
        r8.c = false;
        ((LinkedHashMap) r8.b).clear();
        return;
    L11:
        r7 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public final void onDetachedFromRecyclerView(RecyclerView r9) {
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        super.onDetachedFromRecyclerView(r9);
        ListMonitor r1 = H2();
        String r2 = this.k.a;
        com.larus.im.internal.stream.b r3 = r1.g;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r3.e(r2, r1.k);
        r1.i = false;
        ListMonitor r4 = H2();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        r9.removeOnScrollListener(r4.l);
        r4.a(r9, ISdkPerfDegradeService.ScrollState.DETACH);
        com.larus.bmhome.utils.p0 r0 = r4.f;
        String r5 = r0.k;
        JSONObject r6 = new JSONObject();
        r6.put("scene", r0.a);
        Iterator r7 = r0.d.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r8 = (Map.Entry) r7.next();
        r6.put((String) r8.getKey(), ((Number) r8.getValue()).intValue());
        goto L7
    L9:
        ApmAgent.monitorEvent(r5, r6, null, null);
        String r10 = r0.l;
        JSONObject r11 = new JSONObject();
        r11.put("scene", r0.a);
        Iterator r12 = r0.e.entrySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        Map.Entry r13 = (Map.Entry) r12.next();
        r11.put((String) r13.getKey(), ((Number) r13.getValue()).intValue());
        goto L11
    L13:
        ApmAgent.monitorEvent(r10, r11, null, null);
        WeakHashMap<Object, e2a.a> r14 = j0.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        WeakHashMap<Object, e2a.a> r15 = j0.a;
        e2a.a r16 = r15.get(this);
        if (r16 == null) goto L16;
        ((CopyOnWriteArrayList) e2a.e.a).remove(r16);
        e2a.a r17 = r15.remove(this);
    L16:
        this.u = null;
        SelectorRestore r18 = this.H;
        r9.removeOnScrollListener(r18.f);
        r9.removeOnScrollListener(r18.g);
        tt8.a r19 = r18.h;
        if (r19 == null) goto L19;
        r19.a(null);
    L19:
        r18.d = null;
        r18.h = null;
        r18.a = null;
        r18.c = false;
        ((LinkedHashMap) r18.b).clear();
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final void p1(com.larus.bmhome.social.page.datasource.diff.c<xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Intrinsics.checkNotNullParameter(r3, "observer");
        com.larus.bmhome.social.page.datasource.diff.b<xc8.b, com.larus.bmhome.social.page.datasource.event.c<xc8.b>> r1 = F2();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r1.c.contains(r3) == true) goto L7;
        r1.c.add(r3);
        return;
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final void r1(com.larus.bmhome.social.page.datasource.diff.c<xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Intrinsics.checkNotNullParameter(r3, "observer");
        com.larus.bmhome.social.page.datasource.diff.b<xc8.b, com.larus.bmhome.social.page.datasource.event.c<xc8.b>> r1 = F2();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r1.c.contains(r3) == false) goto L7;
        r1.c.remove(r3);
        return;
    }

    public final void y2(IFlowListCell<? super xc8.b> r3) {
        if ((r3 instanceof BaseCellComponentFeature) == false) goto L6;
        BaseCellComponentFeature r4 = (BaseCellComponentFeature) r3;
        ComponentFeature r0 = this.o;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "value");
        r4.a = r0;
        return;
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public final void B2(FlowListViewHolder<xc8.b> r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "holder");
        Intrinsics.checkNotNullParameter(r18, "holder");
        ei9.f r3 = (ei9.f) ListProtector.get(z2(), r19);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r3, "state");
        IFlowListCell r4 = r18.b;
        boolean r5 = true;
        if (r4 == null) goto L7;
        View r6 = r18.c;
        if (r6 == null) goto L7;
        boolean r7 = r4.shouldBindCell(r6, r3, r19);
    L9:
        if (r7 == false) goto L65;
        ListMonitor r8 = H2();
        String r9 = this.k.a;
        String r10 = "";
        if (((Boolean) r8.j.getValue()).booleanValue() == true) goto L14;
    L21:
        com.larus.bmhome.utils.p0 r11 = H2().f;
        r11.getClass();
        r11.c = SystemClock.uptimeMillis();
        if (r19 >= 0) goto L24;
    L26:
        r5 = false;
    L27:
        if (r5 == false) goto L29;
        xc8.b r12 = (xc8.b) ListProtector.get(z2(), r19);
    L30:
        if (r12 != null) goto L32;
        return;
    L32:
        Message r13 = r12.getMessage();
        if (com.larus.im.bean.message.a.w0(r12.getMessage()) == true) goto L40;
        if (r12.getMessage().getMessageStatusLocal() != 11) goto L37;
    L38:
        FLogger.a.i("MessageAdapter", "onBindViewHolder onStart pos=" + r19 + " index=" + r13.getServerIndex() + '_' + r13.getLocalIndex() + " msg_id=" + r13.getMessageId() + " conversation_id=" + r13.getConversationId() + " content_type=" + r13.getContentType());
        goto L40
    L37:
        if (r12.getMessage().getMessageStatusLocal() == 21) goto L38;
    L40:
        com.larus.bmhome.chat.trace.container.b r14 = com.larus.bmhome.chat.trace.container.b.a;
        Message r15 = r12.getMessage();
        xc8.b r16 = r12;
        com.larus.bmhome.chat.trace.container.b.p(r16, r15);
        MessageRenderState r17 = MessageRenderState.START;
        IMessageRenderInterceptor r20 = IMessageRenderInterceptor.a;
        String r21 = r16.getMessage().getMessageId();
        if (r21 != null) goto L43;
        r21 = "";
    L43:
        r20.a(r21, r17, r16.getMessage());
        super.B2(r18, r19);
        if (((Boolean) H2().j.getValue()).booleanValue() == true) goto L46;
    L49:
        IFlowListCell r1 = r18.b;
        if (r1 == null) goto L52;
        ListMonitor r22 = H2();
        String r23 = r1.getClass().getSimpleName();
        Map r2 = r1.appendPerfMonitorParams(r16);
        r2.put("view_type", Integer.valueOf(getItemViewType(r19)));
        r2.put("content_type", Integer.valueOf(r16.getMessage().getContentType()));
        r2.put("msg_id", r16.getMessage().getMessageId());
        Unit r24 = Unit.INSTANCE;
        r22.b(r23, r2);
    L53:
        com.larus.bmhome.chat.trace.container.b.i(r16, r16.getMessage());
        MessageRenderState r25 = MessageRenderState.FINISH;
        String r26 = r16.getMessage().getMessageId();
        if (r26 == null) goto L57;
        r10 = r26;
    L57:
        r20.a(r10, r25, r16.getMessage());
        if (com.larus.im.bean.message.a.w0(r16.getMessage()) == false) goto L60;
        return;
    L60:
        if (r16.getMessage().getMessageStatusLocal() != 11) goto L62;
    L63:
        FLogger.a.i("MessageAdapter", "onBindViewHolder onEnd pos=" + r19 + " index=" + r13.getServerIndex() + '_' + r13.getLocalIndex() + " msg_id=" + r13.getMessageId() + " conversation_id=" + r13.getConversationId() + " content_type=" + r13.getContentType());
        return;
    L62:
        if (r16.getMessage().getMessageStatusLocal() == 21) goto L63;
        return;
    L52:
        H2().b("", null);
        goto L53
    L46:
        if (com.larus.bmhome.chat.bean.d.Q0(r16.getMessage()) == true) goto L53;
        if (com.larus.im.bean.message.a.A0(r16.getMessage()) == true) goto L53;
    L29:
        r12 = null;
        goto L30
    L24:
        if (r19 >= z2().size()) goto L26;
    L14:
        if (r8.i == true) goto L21;
        if (com.larus.utils.o0.d(r9) == false) goto L21;
        r8.i = true;
        com.larus.im.internal.stream.b r27 = r8.g;
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        r27.b(r9, r8.k);
        goto L21
    L65:
        return;
    L7:
        r7 = true;
        goto L9
    }

    public final FlowListViewHolder<xc8.b> C2(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        com.larus.bmhome.utils.p0 r0 = H2().f;
        r0.getClass();
        r0.b = SystemClock.uptimeMillis();
        com.larus.bmhome.chat.trace.container.b r1 = com.larus.bmhome.chat.trace.container.b.a;
        com.larus.bmhome.chat.trace.container.b.q();
        FlowListViewHolder<xc8.b> r13 = super.C2(r11, r12);
        IFlowListCell r2 = r13.b;
        if (r2 == null) goto L5;
        String r3 = r2.getClass().getSimpleName();
    L6:
        ListMonitor r4 = H2();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("view_type", Integer.valueOf(r12));
        Unit r14 = Unit.INSTANCE;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r5, "extraParams");
        com.larus.bmhome.utils.p0 r6 = r4.f;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r5, "extraParams");
        long r7 = SystemClock.uptimeMillis() - r6.b;
        boolean r8 = Intrinsics.areEqual(ThreadMethodProxy.currentThread(), (Thread) r6.g.getValue());
        ArrayMap r9 = r6.d;
        Integer r10 = (Integer) r9.get(r3);
        if (r10 == null) goto L9;
        int r15 = r10.intValue();
    L10:
        r9.put(r3, Integer.valueOf(r15 + 1));
        String r16 = r6.i;
        JSONObject r17 = new JSONObject();
        r17.put("scene", r6.a);
        r17.put("type", r3);
        r17.put("duration", r7);
        r17.put("isMainThread", r8);
        Iterator r18 = r5.entrySet().iterator();
    L12:
        if (r18.hasNext() == false) goto L14;
        Map.Entry r19 = (Map.Entry) r18.next();
        r17.put((String) r19.getKey(), r19.getValue());
        goto L12
    L14:
        ApmAgent.monitorEvent(r16, r17, null, null);
        if (com.larus.platform.exp.h.a == false) goto L17;
        long r20 = ((Number) r6.f.getValue()).longValue();
    L19:
        if (r7 < r20) goto L21;
        FLogger.a.i("HolderTracker", "onCreateVHEnd scene=" + r6.a + " type=" + r3 + " duration=" + r7 + " isMainThread=" + r8);
    L21:
        com.larus.bmhome.chat.trace.container.b r110 = com.larus.bmhome.chat.trace.container.b.a;
        com.larus.bmhome.chat.trace.container.b.j();
        return r13;
    L17:
        r20 = z2.a.openTraceExecuteThreshold();
        goto L19
    L9:
        r15 = 0;
        goto L10
    L5:
        r3 = "";
        goto L6
    }

    @Override // com.larus.bmhome.chat.list.base.MessageCellPagingAdapter, com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public final ActionListDiffer E2(PagingAdapterListUpdateCallback r3, DiffUtil.ItemCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "updateCallback");
        Intrinsics.checkNotNullParameter(r4, "diff");
        return new ActionListDiffer(r3, r4, new u(this));
    }

    public final void J2(List<? extends wq8.a> r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        gk9.a r0 = (gk9.a) this.G.getValue();
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    @Override // dc8.c
    public final void N1(String r2, BaseCompositeTextCell<? extends xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "cell");
        ((dc8.a) this.L.getValue()).N1(r2, r3);
    }

    @Override // dc8.c
    public final void S(String r2, BaseCompositeTextCell<? extends xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "cell");
        ((dc8.a) this.L.getValue()).S(r2, r3);
    }

    public final boolean S3(String r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "localMessageId");
        boolean r2 = false;
        final int r6 = -1;
        if (((TextCellCutType) this.q.getValue()) != TextCellCutType.NewCutThreeTextCell) goto L5;
    L27:
        List<xc8.b> r0 = z2();
        ArrayList r1 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L29:
        if (r3.hasNext() == false) goto L38;
        Object r7 = r3.next();
        xc8.b r8 = (xc8.b) r7;
        if (Intrinsics.areEqual(r8.getMessage().getLocalMessageId(), r11) == true) goto L33;
    L35:
        boolean r9 = false;
    L36:
        if (r9 == false) goto L29;
        r1.add(r7);
        goto L29
    L33:
        if (r8.getMessage().getContentType() != r12) goto L35;
        r9 = true;
        goto L36
    L38:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r4 = r1.iterator();
    L40:
        if (r4.hasNext() == false) goto L42;
        r13.add(Integer.valueOf(z2().indexOf((xc8.b) r4.next())));
        goto L40
    L42:
        ChatMessageList r5 = this.u;
        Integer r10 = null;
        if (r5 == null) goto L45;
        RecyclerView.LayoutManager r14 = r5.getLayoutManager();
    L47:
        if ((r14 instanceof LinearLayoutManager) == false) goto L49;
        LinearLayoutManager r15 = (LinearLayoutManager) r14;
    L50:
        if (r15 == null) goto L52;
        Integer r16 = Integer.valueOf(r15.findFirstVisibleItemPosition());
    L53:
        if (r15 == null) goto L55;
        r10 = Integer.valueOf(r15.findLastVisibleItemPosition());
    L55:
        if (r16 == null) goto L73;
        if (r10 == null) goto L73;
        if (r16.intValue() == (-1)) goto L73;
        if (r10.intValue() == (-1)) goto L73;
        ArrayList r17 = new ArrayList();
        Iterator r18 = r13.iterator();
    L63:
        if (r18.hasNext() == false) goto L72;
        Object r19 = r18.next();
        int r20 = ((Number) r19).intValue();
        if (r16.intValue() <= r20) goto L67;
    L69:
        boolean r21 = false;
    L70:
        if (r21 == false) goto L63;
        r17.add(r19);
        goto L63
    L67:
        if (r20 > r10.intValue()) goto L69;
        r21 = true;
        goto L70
    L72:
        int r22 = r17.size();
    L78:
        Integer r110 = (Integer) CollectionsKt.firstOrNull(r13);
        if (r110 == null) goto L81;
        r6 = r110.intValue();
    L81:
        notifyItemRangeChanged(r6, r22);
        this.J.setValue(r11);
    L82:
        return true;
    L73:
        FLogger.a.e("streamService", "positionList = " + r13 + ", localMessageId = " + r11);
        int r23 = r13.size();
        ChatMessageList r24 = this.u;
        if (r24 == null) goto L76;
        int r25 = r24.getChildCount();
    L77:
        r22 = RangesKt.coerceAtMost(r23, r25);
        goto L78
    L76:
        r25 = Integer.MAX_VALUE;
        goto L77
    L52:
        r16 = null;
        goto L53
    L49:
        r15 = null;
        goto L50
    L45:
        r14 = null;
        goto L47
    L5:
        if (((TextCellCutType) this.q.getValue()) == TextCellCutType.DeepThinkCutMultipleCell) goto L27;
        Iterator<xc8.b> r26 = z2().iterator();
        int r27 = 0;
    L9:
        if (r26.hasNext() == false) goto L19;
        xc8.b r28 = r26.next();
        if (Intrinsics.areEqual(r28.getMessage().getLocalMessageId(), r11) == true) goto L13;
    L15:
        boolean r29 = false;
    L16:
        if (r29 == true) goto L17;
        r27 = r27 + 1;
        goto L9
    L17:
        r6 = r27;
        goto L19
    L13:
        if (r28.getMessage().getContentType() != r12) goto L15;
        r29 = true;
    L19:
        if (r6 >= 0) goto L21;
    L23:
        if (r2 == false) goto L25;
        t0.e(new w(this, r6));
    L26:
        this.J.setValue(r11);
        goto L82
    L25:
        FLogger.a.e("streamService", "position = " + r6 + ", localMessageId = " + r11);
        goto L26
    L21:
        if (r6 >= getItemCount()) goto L23;
        r2 = true;
        goto L23
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final boolean l3(String r7, @MessageContentType Integer r8) {
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Iterator<xc8.b> r0 = z2().iterator();
        boolean r1 = false;
        final int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L15;
        xc8.b r3 = r0.next();
        if (Intrinsics.areEqual(r3.getMessage().getMessageId(), r7) == false) goto L11;
        if (r8 != null) goto L9;
    L10:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L16;
        r2 = r2 + 1;
    L16:
        if (r2 >= 0) goto L18;
    L20:
        if (r1 == false) goto L22;
        t0.e(new v(this, r2));
    L23:
        this.J.setValue(r7);
        return true;
    L22:
        FLogger.a.d("streamService", "position = " + r2 + ", messageId = " + r7);
        goto L23
    L18:
        if (r2 >= getItemCount()) goto L20;
        r1 = true;
        goto L20
    L9:
        if (r3.getMessage().getContentType() == r8.intValue()) goto L10;
    L11:
        r4 = false;
        goto L12
    L15:
        r2 = -1;
        goto L16
    }

    @Override // dc8.c
    public final void u1(String r2, BaseCompositeTextCell<? extends xc8.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "cell");
        ((dc8.a) this.L.getValue()).u1(r2, r3);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final boolean x7(String r20, @MessageContentType int r21) {
        Intrinsics.checkNotNullParameter(r20, "messageId");
        Iterator<T> r3 = z2().iterator();
    L3:
        final LinearLayoutManager r7 = null;
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        xc8.b r8 = (xc8.b) r4;
        if (Intrinsics.areEqual(r8.getMessage().getMessageId(), r20) == true) goto L8;
    L10:
        boolean r9 = false;
    L11:
        if (r9 == false) goto L3;
    L14:
        xc8.b r5 = (xc8.b) r4;
        if (r5 != null) goto L18;
        return true;
    L18:
        if (((TextCellCutType) this.q.getValue()) != TextCellCutType.NewCutThreeTextCell) goto L43;
        List<xc8.b> r6 = z2();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r6.iterator();
    L21:
        if (r11.hasNext() == false) goto L30;
        Object r12 = r11.next();
        xc8.b r13 = (xc8.b) r12;
        if (Intrinsics.areEqual(r13.getMessage().getMessageId(), r20) == true) goto L25;
    L27:
        boolean r14 = false;
    L28:
        if (r14 == false) goto L21;
        r10.add(r12);
        goto L21
    L25:
        if (r13.getMessage().getContentType() != r21) goto L27;
        r14 = true;
        goto L28
    L30:
        final ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r2 = r10.iterator();
    L32:
        if (r2.hasNext() == false) goto L34;
        r15.add(Integer.valueOf(z2().indexOf((xc8.b) r2.next())));
        goto L32
    L34:
        ChatMessageList r16 = this.u;
        if (r16 == null) goto L37;
        RecyclerView.LayoutManager r17 = r16.getLayoutManager();
    L39:
        if ((r17 instanceof LinearLayoutManager) == false) goto L41;
        r7 = (LinearLayoutManager) r17;
    L41:
        t0.e(new m(r7, r15, this));
        FLogger.a.d("streamService", "position = " + CollectionsKt.joinToString$default(r15, ",", null, null, 0, null, null, 62, null) + ", messageId = " + r20);
        this.J.setValue(r20);
    L50:
        return true;
    L37:
        r17 = null;
        goto L39
    L43:
        if (((TextCellCutType) this.q.getValue()) == TextCellCutType.DeepThinkCutMultipleCell) goto L45;
    L49:
        l3(r20, Integer.valueOf(r21));
        goto L50
    L45:
        if (com.larus.im.bean.message.a.f0(r5.getMessage()) == false) goto L49;
        gk9.a r18 = (gk9.a) this.G.getValue();
        if (r18 != null) goto L64;
        return false;
    L64:
        return r18.a(r5, r20, r21);
    L8:
        if (r8.getMessage().getContentType() != r21) goto L10;
        r9 = true;
        goto L11
    L13:
        r4 = null;
        goto L14
    }

    public static Object L2(MessageAdapter r5, com.larus.bmhome.social.page.datasource.event.c<xc8.b> r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof MessageAdapter$submitEvent$1) == false) goto L7;
        MessageAdapter$submitEvent$1 r0 = (MessageAdapter$submitEvent$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r9 = (com.larus.bmhome.social.page.datasource.event.c) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L26:
        FLogger.a.i("MsgRefreshFlow_MessageAdapter", "submitEvent listSize=" + r9.a.size() + " dataVersion=" + r9.b + " rt=" + r9.d);
        List r10 = r9.c;
        if ((r10 instanceof Collection) == true) goto L29;
    L31:
        Iterator r11 = r10.iterator();
    L33:
        if (r11.hasNext() == false) goto L37;
        if ((((com.larus.bmhome.social.page.datasource.event.b) r11.next()) instanceof com.larus.bmhome.social.page.datasource.event.b.d) == false) goto L33;
    L38:
        if (r4 == false) goto L43;
        if (r9.a.isEmpty() == false) goto L43;
        CompletableDeferred r12 = wr8.d.a;
        wr8.d.b.c("adapter#submit empty data");
    L43:
        return Unit.INSTANCE;
    L37:
        r4 = false;
        goto L38
    L29:
        if (r10.isEmpty() == false) goto L31;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (com.larus.bmhome.social.page.datasource.event.c) r0.L$1;
        r5 = (MessageAdapter) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L22:
        r5.y.setValue(Boxing.boxBoolean(r5.z));
        MutableSharedFlow<List<xc8.b>> r13 = r5.x;
        List r14 = r6.a;
        r0.L$0 = r6;
        r0.L$1 = null;
        r0.label = 2;
        if (r13.emit(r14, r0) != r2) goto L25;
        return r2;
    L25:
        r9 = r6;
        goto L26
    L16:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r5;
        r0.L$1 = r6;
        r0.label = 1;
        Object r15 = r5.F2().b(r6, r0);
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        r15 = Unit.INSTANCE;
    L20:
        if (r15 != r2) goto L22;
        return r2;
    L7:
        r0 = new MessageAdapter$submitEvent$1(r5, r7);
        goto L8
    }

    @Override // dc8.c
    public final dc8.b I1(String r2, BaseCompositeTextCell r3, xc8.b r4, List<? extends bd8.b> r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "cell");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "components");
        return (ec8.b) ((dc8.a) this.L.getValue()).I1(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.bmhome.chat.adapter.p] */
    public MessageAdapter(vr8.a r7, ChatParam r8, Function4<? super q0, ? super Message, ? super Integer, ? super Boolean, Unit> r9, Integer r10, Function0<? extends Fragment> r11, ComponentFeature r12, q0.a r13) {
        Intrinsics.checkNotNullParameter(r7, "loader");
        Intrinsics.checkNotNullParameter(r8, "chatParam");
        Intrinsics.checkNotNullParameter(r9, "msgActionCallback");
        Intrinsics.checkNotNullParameter(r11, "hostFragment");
        Intrinsics.checkNotNullParameter(r12, "componentFeature");
        Intrinsics.checkNotNullParameter(r13, "provider");
        super(M, r7);
        this.k = r8;
        this.l = r9;
        this.m = r10;
        this.n = r11;
        this.o = r12;
        this.p = r13;
        this.q = LazyKt.lazy(new a0(this));
        this.r = LazyKt.lazy(new b0());
        this.t = new LruSet(50);
        this.w = new u2();
        MutableSharedFlow<List<xc8.b>> r14 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.x = r14;
        this.y = new MutableLiveData(Boolean.FALSE);
        this.A = LazyKt.lazy(new c0(this));
        this.D = z2.a.enableTrackerOptimize();
        this.E = LazyKt.lazy(new d0(this));
        this.F = LazyKt.lazy(new n(this));
        this.G = LazyKt.lazy(new o(this));
        this.H = new SelectorRestore();
        CopyOnWriteArraySet r15 = xc8.f.a;
        xc8.f.d(this);
        s1a.a.g((Fragment) r11.invoke()).c(new a(), kf8.a.class);
        MutableLiveData<Object> r16 = new MutableLiveData();
        this.J = r16;
        final MediatorLiveData<List<xc8.b>> r17 = new MediatorLiveData();
        r17.addSource(FlowLiveDataConversions.asLiveData$default(new c1(new MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1(r14, null, this)), null, 0, 3, null), new d(new p(r17)));
        r17.addSource(r16, new q(r17));
        this.K = r17;
        this.L = LazyKt.lazy(new r());
    }
}
