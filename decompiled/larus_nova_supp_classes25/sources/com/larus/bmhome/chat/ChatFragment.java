package com.larus.bmhome.chat;

import android.content.ComponentName;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.services.apm.api.EnsureManager;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.bean.BotRecommendMobInfo;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.trace.z$a;
import com.larus.bmhome.chat.trace.appreciable.ConversationPageTrace;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.btm.api.IBTMService;
import com.larus.camera.api.IFlowCamera;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.common_ui.widget.BaseConstraintLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.comment.ICommentService;
import com.larus.platform.service.g;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ic8.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;
import p1a.j;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¬\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0083\u0001\u0018\u0000 \u0090\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002\u0090\u0002B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010(\u001a\u00020\u00132\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b'J\u0012\u0010\u0096\u0001\u001a\u00020\u00132\u0007\u0010\u0097\u0001\u001a\u000201H\u0016J\u0012\u0010\u0098\u0001\u001a\u00020\u00132\u0007\u0010\u0097\u0001\u001a\u00020 H\u0016J\f\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\u0012\u0010\u009b\u0001\u001a\u00020\u00132\u0007\u0010\u009c\u0001\u001a\u000204H\u0002J\u0014\u0010\u009d\u0001\u001a\u00020\u00132\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J\t\u0010\u009f\u0001\u001a\u00020\u0013H\u0002J\t\u0010 \u0001\u001a\u00020\u0013H\u0002J\t\u0010¡\u0001\u001a\u00020\u0013H\u0002J\t\u0010¢\u0001\u001a\u00020\u0013H\u0002J\t\u0010£\u0001\u001a\u00020\u0013H\u0002J\n\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\t\u0010¦\u0001\u001a\u00020\u0013H\u0016J&\u0010§\u0001\u001a\u00020\u00132\u0007\u0010¨\u0001\u001a\u00020\u000b2\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010«\u0001\u001a\u00030ª\u0001H\u0016J\u0013\u0010¬\u0001\u001a\u00030\u00ad\u00012\u0007\u0010¨\u0001\u001a\u00020\u000bH\u0002J\u000b\u0010®\u0001\u001a\u0004\u0018\u000104H\u0016J\n\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\u0007\u0010±\u0001\u001a\u000204J\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001J\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001J\u0012\u0010¶\u0001\u001a\u00020\u00132\u0007\u0010·\u0001\u001a\u000204H\u0016J\u0014\u0010¸\u0001\u001a\u00020\u00132\t\u0010¹\u0001\u001a\u0004\u0018\u000104H\u0016J\u0014\u0010º\u0001\u001a\u00020\u00132\t\u0010»\u0001\u001a\u0004\u0018\u000104H\u0016J\u0013\u0010¼\u0001\u001a\u00020\u00132\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001J\u0013\u0010¿\u0001\u001a\u00020\u00132\n\u0010½\u0001\u001a\u0005\u0018\u00010À\u0001J\u0011\u0010Á\u0001\u001a\u00020\u00132\b\u0010Â\u0001\u001a\u00030\u0095\u0001J,\u0010Ã\u0001\u001a\u0004\u0018\u00010A2\b\u0010Ä\u0001\u001a\u00030Å\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J\u0013\u0010È\u0001\u001a\u00020\u00132\b\u0010É\u0001\u001a\u00030\u00ad\u0001H\u0002J\t\u0010Ê\u0001\u001a\u00020\u0013H\u0002J\t\u0010Ë\u0001\u001a\u00020\u0013H\u0002J\n\u0010Ì\u0001\u001a\u00030\u00ad\u0001H\u0002J\t\u0010Í\u0001\u001a\u00020\u0013H\u0002J\u0013\u0010Î\u0001\u001a\u00020\u00132\b\u0010Ï\u0001\u001a\u00030ª\u0001H\u0002J\u0013\u0010Ð\u0001\u001a\u00020\u00132\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0017J\u0013\u0010Ó\u0001\u001a\u00020\u00132\b\u0010Ô\u0001\u001a\u00030\u00ad\u0001H\u0016J\t\u0010Õ\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ö\u0001\u001a\u00020\u0013H\u0016J\t\u0010×\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ø\u0001\u001a\u00020\u0013H\u0002J\t\u0010Ù\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010Ú\u0001\u001a\u00020\u00132\b\u0010Û\u0001\u001a\u00030\u00ad\u0001J\u0007\u0010Ü\u0001\u001a\u00020\u0013J\t\u0010Ý\u0001\u001a\u00020\u0013H\u0016J\t\u0010Þ\u0001\u001a\u00020\u0013H\u0016J\u001d\u0010ß\u0001\u001a\u00020\u00132\u0007\u0010à\u0001\u001a\u00020A2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010á\u0001\u001a\u00030\u00ad\u0001H\u0002J\u0010\u0010â\u0001\u001a\u00020\u00132\u0007\u0010»\u0001\u001a\u000204J\u0007\u0010ã\u0001\u001a\u00020/J\t\u0010ä\u0001\u001a\u000204H\u0016J\u0013\u0010å\u0001\u001a\u00020\u00132\b\u0010æ\u0001\u001a\u00030ç\u0001H\u0016J\n\u0010è\u0001\u001a\u00030\u00ad\u0001H\u0016J\f\u0010é\u0001\u001a\u0005\u0018\u00010ê\u0001H\u0016J\n\u0010ë\u0001\u001a\u00030\u00ad\u0001H\u0016J\t\u0010ì\u0001\u001a\u00020\u0013H\u0016J\u0011\u0010í\u0001\u001a\u00020\u00132\b\u0010î\u0001\u001a\u00030\u00ad\u0001J\u001c\u0010ï\u0001\u001a\u00020\u00132\u0013\u0010æ\u0001\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020403J\u0007\u0010ð\u0001\u001a\u00020\u0013J\n\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u0001J\t\u0010ó\u0001\u001a\u00020\u0013H\u0016J\t\u0010ô\u0001\u001a\u00020/H\u0016J\u0014\u0010õ\u0001\u001a\u00020\u00132\t\u0010ö\u0001\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010÷\u0001\u001a\u00020\u00132\u0007\u0010»\u0001\u001a\u000204H\u0016J\u000f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0013¢\u0006\u0003\u0010ù\u0001J\u0007\u0010ú\u0001\u001a\u00020\u0013J\t\u0010û\u0001\u001a\u0004\u0018\u00010AJ\b\u0010ü\u0001\u001a\u00030\u00ad\u0001J\u0007\u0010ý\u0001\u001a\u000204J\n\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u000b\u0010\u0080\u0002\u001a\u0004\u0018\u00010AH\u0016J\f\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u0002H\u0016J\f\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0082\u0002H\u0016J\t\u0010\u0084\u0002\u001a\u000204H\u0016J\u001c\u0010\u0085\u0002\u001a\u00020\u00132\u0007\u0010ö\u0001\u001a\u0002042\b\u0010\u0086\u0002\u001a\u00030ª\u0001H\u0016J\u001c\u0010\u0087\u0002\u001a\u00020\u00132\u0007\u0010»\u0001\u001a\u0002042\b\u0010\u0086\u0002\u001a\u00030ª\u0001H\u0016J\u0013\u0010\u0088\u0002\u001a\u00020\u00132\b\u0010\u0086\u0002\u001a\u00030ª\u0001H\u0016J\u0007\u0010\u0089\u0002\u001a\u00020\u0013J\u0016\u0010\u008a\u0002\u001a\u00020\u00132\r\u0010\u008b\u0002\u001a\b\u0012\u0004\u0012\u00020\u00130?J\n\u0010\u008c\u0002\u001a\u00030\u00ad\u0001H\u0016J\n\u0010\u008d\u0002\u001a\u00030\u00ad\u0001H\u0016J\f\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R*\u0010\u001c\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001f\u0010%\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020403X\u0082\u000e¢\u0006\u0002\n\u0000R&\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017R\u001d\u00108\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b9\u0010\rR\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010;\u001a\u0004\bK\u0010LR\u001d\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010;\u001a\u0004\bP\u0010QR\u001d\u0010S\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010;\u001a\u0004\bU\u0010VR\u001d\u0010X\u001a\u0004\u0018\u00010Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010;\u001a\u0004\bZ\u0010[R\u001d\u0010]\u001a\u0004\u0018\u00010^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010;\u001a\u0004\b_\u0010`R\u001d\u0010b\u001a\u0004\u0018\u00010c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010;\u001a\u0004\bd\u0010eR\u0016\u0010g\u001a\u0004\u0018\u00010h8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u001d\u0010k\u001a\u0004\u0018\u00010l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010;\u001a\u0004\bm\u0010nR\u001d\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010;\u001a\u0004\br\u0010sR\u001d\u0010u\u001a\u0004\u0018\u00010v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010;\u001a\u0004\bw\u0010xR\u001d\u0010z\u001a\u0004\u0018\u00010{8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u0010;\u001a\u0004\b|\u0010}R\u000e\u0010\u007f\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0084\u0001R\"\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010;\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008e\u0001\u0010;\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0093\u0001\u0010;\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0012\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0091\u0002"}, d2 = {"Lcom/larus/bmhome/chat/ChatFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/chat/IChatLeave;", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "Lcom/larus/bmhome/chat/multi_tab/IChatMultiTabChildFragment;", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "Lcom/larus/chat/api/IChatFragmentOutAbility;", "Lcom/larus/bmhome/chat/ITraceFragment;", "<init>", "()V", "argumentInViewPager", "Landroid/os/Bundle;", "getArgumentInViewPager$impl_mainlandRelease", "()Landroid/os/Bundle;", "setArgumentInViewPager$impl_mainlandRelease", "(Landroid/os/Bundle;)V", "onBackFromChatTabInterceptor", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "getOnBackFromChatTabInterceptor", "()Lkotlin/jvm/functions/Function1;", "setOnBackFromChatTabInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "onResumeBeforeCall", "Lcom/larus/common_ui/widget/BaseConstraintLayout;", "getOnResumeBeforeCall", "setOnResumeBeforeCall", "onViewCreatedBeforeCall", "getOnViewCreatedBeforeCall", "setOnViewCreatedBeforeCall", "chatTitleBarConfig", "Lcom/larus/bmhome/chat/IChatTitleBarConfig;", "getChatTitleBarConfig", "()Lcom/larus/bmhome/chat/IChatTitleBarConfig;", "setChatTitleBarConfig", "(Lcom/larus/bmhome/chat/IChatTitleBarConfig;)V", "initContainerCustom", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "Lkotlin/ExtensionFunctionType;", "initWith", "init", "chatPageMetrics", "Lcom/larus/bmhome/chat/ChatPageMetrics;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "chatHostConfig", "Lcom/larus/chat/ChatHostConfig;", "customTracingParams", "", "", "onReCreate", "getOnReCreate", "setOnReCreate", "currentArgument", "getCurrentArgument", "currentArgument$delegate", "Lkotlin/Lazy;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "immerseConfigChangedCallback", "Lkotlin/Function0;", "smallWindowTopInsetTarget", "Landroid/view/View;", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "chatTraceAbility", "Lcom/larus/bmhome/chat/component/trace/IChatTraceComponentAbility;", "getChatTraceAbility", "()Lcom/larus/bmhome/chat/component/trace/IChatTraceComponentAbility;", "chatTraceAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatCaseAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getChatCaseAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "chatCaseAbility$delegate", "chatTitleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getChatTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "chatTitleAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "chatContinuousTalkAbility", "Lcom/larus/bmhome/audio/IChatContinuousTalkAbility;", "getChatContinuousTalkAbility", "()Lcom/larus/bmhome/audio/IChatContinuousTalkAbility;", "chatContinuousTalkAbility$delegate", "chatClickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getChatClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "chatClickTalkAbility$delegate", "chatPageStateAbility", "Lcom/larus/bmhome/chat/component/halfscreen/IChatPageStateAbility;", "getChatPageStateAbility", "()Lcom/larus/bmhome/chat/component/halfscreen/IChatPageStateAbility;", "chatPageStateAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "chatCoreContainer", "utilAbility", "Lcom/larus/bmhome/chat/component/util/UtilAbility;", "chatHostConfigAbility", "com/larus/bmhome/chat/ChatFragment$chatHostConfigAbility$1", "Lcom/larus/bmhome/chat/ChatFragment$chatHostConfigAbility$1;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "obricPageStateCoreAbility", "Lcom/obric/assistant/ability/chat/page/IObricFloatChatPageStateCoreAbility;", "getObricPageStateCoreAbility", "()Lcom/obric/assistant/ability/chat/page/IObricFloatChatPageStateCoreAbility;", "obricPageStateCoreAbility$delegate", "doubleTabFragment", "Lcom/larus/bmhome/chat/ChatDoubleTabFragment;", "setChatHostConfig", "config", "applyChatTitleBarConfig", "getChatMessageList", "Landroidx/recyclerview/widget/RecyclerView;", "applyTheme", "tag", "onCreate", "savedInstanceState", "bindVContextArgumentData", "bindVContextData", "bindVContextAbilities", "bindChatHostConfigAbility", "attachComponent", "getContainerFilter", "Lcom/larus/ui/arch/modulizer/di/ContainerFilter;", "lazyAttachComponent", "onResult", "bundle", "requestCode", "", "resultCode", "isResultIntercept", "", "getConversationId", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "getCaseId", "getConversation", "Lcom/larus/im/bean/conversation/Conversation;", "getBotModel", "Lcom/larus/im/bean/bot/BotModel;", "leaveChat", "methodName", "reportEnterPage", "pageName", "performBack", "leaveMethod", "setAddBotListener", "listener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "setChatListener", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "setDoubleTabFragment", "fragment", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupSmallWindowTopInsetAdaptation", "enableSmallWindowTopInsetAdaptation", "clearSmallWindowTopInsetAdaptation", "requestSmallWindowTopInsetAdaptation", "isSmallWindowTopInsetAdaptationActive", "setRootViewBackGround", "applyRootBackgroundColor", "color", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onHiddenChanged", "hidden", "onStart", "onResume", "onPause", "checkAndPopupForceBind", "registerBackPressCallback", "checkOnBoardingTTS", "lastBotIdCheck", "resetEnterPageTraced", "onDestroyView", "onDestroy", "onViewCreated", "view", "shouldDoraGUpdate", "reportLeaveChatBot", "getParam", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "autoLogEnterPage", "referrerTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "isImeShowing", "hideIme", "updateDataWithLastRound", "onlyShowLastRoundChat", "updateTracingArguments", "updateFastButton", "getOnBottomInsetUpdateListener", "Lcom/larus/bmhome/view/ChatConstraintLayout$OnBottomInsetUpdateListener;", "scrollToLatest", "getChatParam", "reportEnterPageByHost", "enterMethod", "reportLeavePageByHost", "scrollToRecordCard", "()Lkotlin/Unit;", "mockLoadingByBotSay", "getTitleBarView", "isMessageGenerating", "getCurrentInputText", "getChatUniqueKey", "", "getRootView", "touchInterceptingView", "Lcom/larus/common_ui/view/TouchInterceptingView;", "topButtonTouchInterceptingView", "scene", "onChatTabSelected", "position", "onChatTabUnselected", "onChatTabReselected", "setLastReadRestore", "setImmerseCallbackOnConfigChanged", "callback", "isMultiWindowMode", "isWidthFitRoot", "getChatBubbleParams", "Lcom/larus/bmhome/chat/ChatBubbleParams;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatFragment extends TraceFragment implements f4, xe8.a, ci8.c, gd8.f, ry8.a, m4 {
    public static boolean N;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public Container G;
    public final ce8.o H;
    public final b I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public ChatDoubleTabFragment M;
    public Bundle e;
    public Function1<? super Fragment, Unit> f;
    public Function1<? super BaseConstraintLayout, Unit> g;
    public Function1<? super BaseConstraintLayout, Unit> h;
    public g4 i;
    public Function1<? super Container, Unit> j;
    public final i1 k;
    public de8.c l;
    public final ChatParam m;
    public qy8.a n;
    public final Map<String, String> o;
    public Function1<? super Bundle, Unit> p;
    public final Lazy q;
    public FragmentExtKt.addOnBackPressed.callback.1 r;
    public Function0<Unit> s;
    public View t;
    public LarusPageChatBinding u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements sd8.a {
        public final /* synthetic */ ChatFragment a;

        @Override // sd8.a
        public final qy8.a yu() {
            qy8.a r0 = this.a.n;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new qy8.a(null, null, null, null, true, null, null, null, null, 32639);
        }

        public b(ChatFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    @Override // ci8.c
    public final void SL() {
    }

    @Override // ci8.c
    public final void jv(String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterMethod");
    }

    @Override // com.larus.bmhome.chat.m4
    public final String scene() {
        return "CHAT_MESSAGE_LIST";
    }

    public final TouchInterceptingView BC() {
        LarusPageChatBinding r0 = this.u;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.v;
    }

    public final TouchInterceptingView Rv() {
        LarusPageChatBinding r0 = this.u;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.u;
    }

    @Override // xe8.a
    public final t1a.b WF() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return s1a.a.g(this);
    }

    public final BotModel X90() {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.w.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j0();
    }

    public final Bundle Z90() {
        return (Bundle) this.q.getValue();
    }

    @Override // xe8.a
    public final void g() {
        ICoreInputAbility r0 = (ICoreInputAbility) this.J.getValue();
        if (r0 == null) goto L6;
        r0.qp(false);
        return;
    }

    @Override // xe8.a
    public final long getChatUniqueKey() {
        de8.c r0 = this.l;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.n;
    }

    @Override // xe8.a
    public final String getConversationId() {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.w.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y1();
    }

    public final View getRootView() {
        LarusPageChatBinding r0 = this.u;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // xe8.a
    public final String k() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        va8.f0 r2 = WF().getAbility(va8.f0.class);     // Catch: Throwable -> L19
        if (r2 == null) goto L8;
        boolean r3 = true;
        if (r2.R() != true) goto L8;
    L9:
        if (r3 == false) goto L17;
        va8.r r4 = WF().getAbility(va8.r.class);     // Catch: Throwable -> L19
        if (r4 == null) goto L29;
        String r5 = r4.J30();     // Catch: Throwable -> L19
        if (r5 != null) goto L16;
        return "chat";
    L16:
        return r5;
    L29:
        return "chat";
    L17:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        com.larus.bmhome.chat.component.trace.z r6 = (com.larus.bmhome.chat.component.trace.z) this.v.getValue();
        if (r6 == null) goto L31;
        String r7 = r6.k();
        if (r7 != null) goto L27;
        return "chat";
    L27:
        return r7;
    L31:
        return "chat";
    L8:
        r3 = false;
    L19:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public final u7 u3() {
        return (u7) this.z.getValue();
    }

    @Override // xe8.a
    public final boolean w() {
        va8.o r0 = (va8.o) this.K.getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.w() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public ChatFragment() {
        this.j = new l0();
        this.k = new i1(System.currentTimeMillis(), AppHost.a.getAppClock().currentTimeMillis(), 1048569);
        this.m = new ChatParam(null, null, null, null, null, 255);
        this.o = MapsKt.emptyMap();
        this.p = new y();
        this.q = LazyKt.lazy(new z(this));
        this.v = LazyKt.lazy(new a0(this));
        this.w = LazyKt.lazy(new b0(this));
        this.x = LazyKt.lazy(new c0(this));
        this.y = LazyKt.lazy(new d0(this));
        this.z = LazyKt.lazy(new e0(this));
        this.A = LazyKt.lazy(new f0(this));
        this.B = LazyKt.lazy(new g0(this));
        this.C = LazyKt.lazy(new m0(this));
        this.D = LazyKt.lazy(new n0(this));
        this.E = LazyKt.lazy(new o0(this));
        this.F = LazyKt.lazy(new p0(this));
        this.H = new ce8.o();
        this.I = new b(this);
        this.J = LazyKt.lazy(new q0(this));
        this.K = LazyKt.lazy(new r0(this));
        this.L = LazyKt.lazy(new x(this));
    }

    @Override // xe8.a
    public final boolean AU() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("isWidthFitRoot", false);
    }

    @Override // gd8.f
    public final void AX() {
        if (isDetached() == false) goto L5;
    L65:
        FLogger.a.e("ChatFragment", "lazyAttachComponent fail: fragment is detached(" + isDetached() + ") or removing(" + isRemoving() + ')');
        return;
    L5:
        if (isRemoving() == true) goto L65;
        ContainerFilter r0 = Y90();
        Container r1 = this.G;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("chatCoreContainer");
        r1 = null;
    L9:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r0, "containerFilter");
        Intrinsics.checkNotNullParameter(r1, "container");
        int r2 = y1a.a.a;
        y1a.a.a("attach", "Fragment lazyAttach container on ".concat("ChatFragment"));
        Attachable.a r3 = Attachable.Companion;
        FragmentActivity r4 = requireActivity();
        r3.getClass();
        Attachable r5 = Attachable.a.a(r4);
        if (r5.getComponentStateController$component_release(this) != null) goto L12;
        FragmentAttachExtKt.a(this, r5);
    L12:
        IComponentRegistry.a.getClass();
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "filter");
        Intrinsics.checkNotNullParameter(r5, "attachable");
        Intrinsics.checkNotNullParameter(r1, "container");
        u1a.d r6 = u1a.d.a;
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "filter");
        Intrinsics.checkNotNullParameter(r5, "attachable");
        Intrinsics.checkNotNullParameter(r1, "container");
        monitor-enter(r6);
        ArrayList r7 = (ArrayList) u1a.d.b.get(r0);     // Catch: Throwable -> L62
        y1a.a.a("ComponentArch", "lazyUpdateAttachContainer " + r1);     // Catch: Throwable -> L62
        if (r7 == null) goto L61;
        ComponentStateController r8 = r5.getComponentStateController$component_release(this);     // Catch: Throwable -> L62
        if (r8 == null) goto L59;
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L62
        Iterator r10 = r7.iterator();     // Catch: Throwable -> L62
    L20:
        if (r10.hasNext() == false) goto L36;
        Function1 r11 = (Function1) r10.next();     // Catch: Throwable -> L62
        if (r1.k.contains(r11) == true) goto L23;
        p1a.b r12 = new p1a.b();     // Catch: Throwable -> L62
        Component r13 = (Component) r11.invoke(r12);     // Catch: Throwable -> L62
        r12.c(r13);     // Catch: Throwable -> L62
        r8.a(r13);     // Catch: Throwable -> L62
        r1.k.add(r11);     // Catch: Throwable -> L62
        Iterator r14 = r13.j.iterator();     // Catch: Throwable -> L62
    L26:
        if (r14.hasNext() == false) goto L28;
        Function1 r15 = (Function1) r14.next();     // Catch: Throwable -> L62
        u1a.d r16 = u1a.d.a;     // Catch: Throwable -> L62
        p1a.e r17 = new p1a.e();     // Catch: Throwable -> L62
        ComponentFeature r18 = (ComponentFeature) r15.invoke(r17);     // Catch: Throwable -> L62
        r17.c(r18);     // Catch: Throwable -> L62
        int r19 = y1a.a.a;     // Catch: Throwable -> L62
        y1a.a.a("ComponentArch", r13 + " attach feature " + r18 + ", isLazyAttach");     // Catch: Throwable -> L62
        r8.a(r18);     // Catch: Throwable -> L62
        r1.h.add(r18);     // Catch: Throwable -> L62
        r9.add(r18);     // Catch: Throwable -> L62
        goto L26
    L28:
        Iterator r20 = r13.i.iterator();     // Catch: Throwable -> L62
    L30:
        if (r20.hasNext() == false) goto L32;
        Function1 r21 = (Function1) r20.next();     // Catch: Throwable -> L62
        u1a.d r22 = u1a.d.a;     // Catch: Throwable -> L62
        j r23 = new j();     // Catch: Throwable -> L62
        ComponentFeature r24 = (ComponentFeature) r21.invoke(r23);     // Catch: Throwable -> L62
        r23.c(r24);     // Catch: Throwable -> L62
        int r25 = y1a.a.a;     // Catch: Throwable -> L62
        y1a.a.a("ComponentArch", r13 + " attach widget " + r24 + ", isLazyAttach");     // Catch: Throwable -> L62
        r8.a(r24);     // Catch: Throwable -> L62
        r1.h.add(r24);     // Catch: Throwable -> L62
        r9.add(r24);     // Catch: Throwable -> L62
        goto L30
    L32:
        Iterator r26 = r13.h.iterator();     // Catch: Throwable -> L62
    L34:
        if (r26.hasNext() == false) goto L20;
        Function1 r27 = (Function1) r26.next();     // Catch: Throwable -> L62
        u1a.d r28 = u1a.d.a;     // Catch: Throwable -> L62
        p1a.a r29 = new p1a.a();     // Catch: Throwable -> L62
        ComponentFeature r30 = (ComponentFeature) r27.invoke(r29);     // Catch: Throwable -> L62
        r29.c(r30);     // Catch: Throwable -> L62
        int r31 = y1a.a.a;     // Catch: Throwable -> L62
        y1a.a.a("ComponentArch", r13 + " attach card " + r30 + ", isLazyAttach");     // Catch: Throwable -> L62
        r8.a(r30);     // Catch: Throwable -> L62
        r1.h.add(r30);     // Catch: Throwable -> L62
        r9.add(r30);     // Catch: Throwable -> L62
        goto L34
    L23:
        int r32 = y1a.a.a;     // Catch: Throwable -> L62
        y1a.a.a("ComponentArch_ContainerRegistry", "component " + r11 + " has been attached to container " + r1 + ", skip");     // Catch: Throwable -> L62
        goto L20
    L36:
        Iterator r33 = r1.h.iterator();     // Catch: Throwable -> L62
    L38:
        if (r33.hasNext() == false) goto L45;
        ComponentFeature r34 = (ComponentFeature) r33.next();     // Catch: Throwable -> L62
        u1a.d r35 = u1a.d.a;     // Catch: Throwable -> L62
        if ((r34 instanceof m1a.b) == false) goto L43;
        r1.i.add(r34);     // Catch: Throwable -> L62
    L43:
        if ((r34 instanceof m1a.e) == false) goto L38;
        r1.j.add(r34);     // Catch: Throwable -> L62
        goto L38
    L45:
        Iterator r36 = r1.h.iterator();     // Catch: Throwable -> L62
    L47:
        if (r36.hasNext() == false) goto L51;
        o1a.a r37 = (ComponentFeature) r36.next();     // Catch: Throwable -> L62
        if ((r37 instanceof o1a.a) == false) goto L47;
        r37.C(r1.i);     // Catch: Throwable -> L62
        goto L47
    L51:
        Iterator r38 = r9.iterator();     // Catch: Throwable -> L62
    L53:
        if (r38.hasNext() == false) goto L55;
        ComponentFeature r39 = (ComponentFeature) r38.next();     // Catch: Throwable -> L62
        int r40 = y1a.a.a;     // Catch: Throwable -> L62
        y1a.a.d("ComponentArch_ContainerRegistry", "changeLazyComponentState " + r39);     // Catch: Throwable -> L62
        r8.c(r39, r5, true);     // Catch: Throwable -> L62
        goto L53
    L55:
        Unit r41 = Unit.INSTANCE;     // Catch: Throwable -> L62
        monitor-exit(r6);
        return;
    L59:
        throw new IllegalStateException("illegal null component state controller");     // Catch: Throwable -> L62
    L61:
        throw new IllegalStateException("lazyUpdateAttach Container illegal null container or component list");     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        throw th;
    }

    @Override // xe8.a
    public final boolean F50() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("isMultiWindowMode", false);
    }

    @Override // xe8.a
    public final ChatBubbleParams Mz() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (ChatBubbleParams) r0.getParcelable("argChatBubbleParamsFromHost");
    }

    public final void W90() {
        WF().n(new dr9.d(this.I.yu().e), dr9.d.class);
        WF().c(this.I, sd8.a.class);
    }

    public final ContainerFilter Y90() {
        Bundle r0 = getArguments();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L9;
        Bundle r2 = getArguments();
        String r3 = WcbRenderStatus.DEFAULT;
        if (r2 == null) goto L17;
        String r4 = r2.getString("as_container", WcbRenderStatus.DEFAULT);
        if (r4 == null) goto L17;
        r3 = r4;
    L17:
        return ContainerFilter.valueOf(r3);
    L9:
        return ContainerFilter.READONLY_FORWARD_DETAIL;
    L5:
        if (r0.getBoolean("preview_collection_readonly") != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // xe8.a
    public final void m8() {
        u7 r0 = u3();
        if (r0 == null) goto L5;
        r0.w70();
    L5:
        LarusPageChatBinding r1 = this.u;
        if (r1 == null) goto L11;
        ChatMessageList r2 = r1.n;
        if (r2 == null) goto L12;
        b0$a.a(r2, false, 0, null, null, 0, 31);
        return;
    L12:
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.n = null;
        com.larus.platform.service.d3.a.d();
        ce8.o r1 = this.H;
        r1.a.shutdown();
        r1.b.close();
        maa.e r2 = (maa.e) this.D.getValue();
        if (r2 == null) goto L5;
        maa.e.a.a(r2, null, null, false, 7);
    L5:
        com.larus.bmhome.utils.q2.b = false;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        LarusPageChatBinding r0 = this.u;
        if (r0 == null) goto L24;
        ChatConstraintLayout r1 = r0.a;
        if (r1 == null) goto L24;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ji9.e.a.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L22
        int r4 = ji9.e.b.size();     // Catch: Throwable -> L22
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L16;
        SparseArray r6 = ji9.e.b;     // Catch: Throwable -> L22
        int r7 = r6.keyAt(r5);     // Catch: Throwable -> L22
        Set r8 = (Set) r6.valueAt(r5);     // Catch: Throwable -> L22
        if (r8 == null) goto L15;
        ji9.e.b(r8, r1);     // Catch: Throwable -> L22
        if (r8.isEmpty() == false) goto L15;
        r3.add(Integer.valueOf(r7));     // Catch: Throwable -> L22
    L15:
        r5 = r5 + 1;     // Catch: Throwable -> L22
        goto L8
    L16:
        Iterator r9 = r3.iterator();     // Catch: Throwable -> L22
    L18:
        if (r9.hasNext() == false) goto L20;
        int r10 = ((Number) r9.next()).intValue();     // Catch: Throwable -> L22
        ji9.e.b.remove(r10);     // Catch: Throwable -> L22
        goto L18
    L20:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        View r12 = this.t;
        if (r12 == null) goto L27;
        ViewCompat.setOnApplyWindowInsetsListener(r12, null);
    L27:
        this.t = null;
        IBTMService r13 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r13 == null) goto L30;
        r13.f(this);
    L30:
        CompletableDeferred r14 = wr8.d.a;
        wr8.d.b.c("ChatFragment#Ondestory");
        t19.s r15 = t19.s.a;
        monitor-enter(r15);
        com.larus.utils.t0.e(new t19.b());     // Catch: Throwable -> L36
        monitor-exit(r15);
        this.u = null;
        return;
    L36:
        th = move-exception;
        throw th;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.r;
        if (r0 == null) goto L5;
        r0.setEnabled(false);
    L5:
        ICommentService.a.getClass();
        ICommentService r1 = (ICommentService) ICommentService.a.b.getValue();
        if (r1 == null) goto L9;
        r1.a(this);
        return;
    }

    public final void onResume() {
        super.onResume();
        i1 r0 = this.k;
        if (r0.g != 0) goto L5;
        long r1 = System.currentTimeMillis();
        r0.g = r1;
        r0.a("resumeStartTime", r1);
    L5:
        FLogger.a.i("ChatFragment", "onResume hashCode=" + hashCode());
        FragmentExtKt.addOnBackPressed.callback.1 r2 = this.r;
        boolean r3 = true;
        if (r2 == null) goto L8;
        r2.setEnabled(true);
    L8:
        IFlowCamera r4 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r4 == null) goto L11;
        r4.l(getChildFragmentManager());
    L11:
        Function1<? super BaseConstraintLayout, Unit> r5 = this.g;
        ChatConstraintLayout r6 = null;
        if (r5 == null) goto L18;
        LarusPageChatBinding r7 = this.u;
        if (r7 == null) goto L16;
        ChatConstraintLayout r8 = r7.a;
    L17:
        r5.invoke(r8);
        goto L18
    L16:
        r8 = null;
    L18:
        LarusPageChatBinding r9 = this.u;
        if (r9 == null) goto L21;
        r6 = r9.a;
    L21:
        if (r6 == null) goto L26;
        if (r9 == null) goto L26;
        ChatConstraintLayout r10 = r9.a;
        if (r10 == null) goto L26;
        r10.S5();
    L26:
        View r11 = this.t;
        if (r11 == null) goto L29;
        ViewCompat.requestApplyInsets(r11);
    L29:
        Bundle r12 = Z90();
        if (r12 != null) goto L32;
    L34:
        r3 = false;
    L35:
        if (r3 == true) goto L37;
        return;
    L37:
        if ((getParentFragment() instanceof ChatDoubleTabFragment) == false) goto L45;
        LarusPageChatBinding r13 = this.u;
        if (r13 == null) goto L46;
        ChatConstraintLayout r14 = r13.a;
        if (r14 == null) goto L47;
        r14.U5();
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L32:
        if (r12.getBoolean("show_two_tab") != true) goto L34;
        goto L34
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        i1 r0 = this.k;
        if (r0.f != 0) goto L6;
        long r1 = System.currentTimeMillis();
        r0.f = r1;
        r0.a("startTime", r1);
        return;
    }

    public final by7.e referrerTrackNode() {
        by7.f r0 = by7.e.a.a(this);
        if (r0 != null) goto L14;
        de8.c r1 = this.l;
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.p();
    L9:
        if (com.larus.utils.o0.d(r3) == false) goto L14;
        r0 = new by7.f();
        TrackParams r4 = r0.a;
        de8.c r5 = this.l;
        if (r5 == null) goto L13;
        r2 = r5.p();
    L13:
        r4.put("current_page", r2);
        goto L14
    L7:
        r3 = null;
    L14:
        return r0;
    }

    @Override // gd8.f
    public final LarusPageChatBinding e() {
        return this.u;
    }

    @Override // xe8.a
    public final ChatParam getChatParam() {
        return this.m;
    }

    @Override // xe8.a
    public final void AY(qy8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.n = r2;
        this.i = r2.g;
        if (isAdded() == false) goto L6;
        W90();
        return;
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Bv(String r10) {
        com.larus.bmhome.chat.component.trace.z r1 = (com.larus.bmhome.chat.component.trace.z) this.v.getValue();
        if (r1 == null) goto L14;
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.w.getValue();
        if (r0 == null) goto L7;
        String r2 = r0.getBotId();
    L8:
        String r3 = r2;
        de8.c r4 = this.l;
        if (r4 == null) goto L11;
        boolean r6 = r4.B();
    L12:
        z$a.a(r1, r3, null, r10, null, r6, false, 84);
        return;
    L11:
        r6 = false;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    @Override // ci8.c
    public final void LY(String r3) {
        Intrinsics.checkNotNullParameter(r3, "leaveMethod");
        AudioServiceDelegate.a.i0().cancel("ChatFragment onPageSelected", true);
        if (w() == false) goto L5;
        g();
    L5:
        xa8.b r4 = (xa8.b) this.C.getValue();
        if (r4 != null) goto L8;
    L10:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r5 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) WF().getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r5 == null) goto L14;
        r5.Ro();
        return;
    L14:
        return;
    L8:
        if (r4.fe() == false) goto L10;
        r4.closeContinuousTalk();
        goto L10
    }

    public final void MQ(boolean r4) {
        FLogger.a.i("ChatFragment", "updateDataWithLastRound, onlyShowLastRoundChat=" + r4);
        u7 r0 = u3();
        if (r0 == null) goto L6;
        r0.MQ(r4);
        return;
    }

    @Override // xe8.a, gd8.f
    public final void N9(String r8) {
        FLogger r0 = FLogger.a;
        r0.i("ChatFragment", "performBack: " + r8);
        ICoreInputAbility r1 = (ICoreInputAbility) this.J.getValue();
        boolean r3 = false;
        if (r1 == null) goto L5;
        r1.qp(false);
    L5:
        boolean r2 = true;
        if (r8 == null) goto L8;
        aa0(r8);
        o5.a(this, "return_method", com.larus.utils.f.c(new Pair[]{TuplesKt.to("return_method", r8)}));
    L8:
        qy8.a r4 = this.n;
        if (r4 == null) goto L11;
        qy8.c r5 = r4.a;
    L12:
        if (r5 != null) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L20;
        r5.c(this);
        r0.i("ChatFragment", "performBack intercept");
        return;
    L20:
        Function1<? super Fragment, Unit> r6 = this.f;
        if (r6 == null) goto L23;
        r6.invoke(this);
        return;
    L23:
        ConversationPageTrace.d();
        taa.a r7 = (taa.a) this.L.getValue();
        if (r7 == null) goto L26;
        r3 = r7.rD(r8);
    L26:
        if (r3 == true) goto L32;
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L33;
        r9.finish();
        return;
    L33:
        return;
    L32:
        return;
    L14:
        if (r5.a() != true) goto L16;
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.f4
    public final void Sk(String r2) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        aa0(r2);
    }

    public final void U90(int r4) {
        FLogger.a.i("ChatFragment", "applyRootBackgroundColor from host config");
        LarusPageChatBinding r0 = this.u;
        if (r0 == null) goto L7;
        ChatConstraintLayout r1 = r0.a;
        if (r1 == null) goto L7;
        r1.setBackgroundColor(r4);
    L7:
        LarusPageChatBinding r2 = this.u;
        if (r2 == null) goto L13;
        BottomMenuGridLayout r3 = r2.e;
        if (r3 == null) goto L14;
        r3.setBackgroundColor(r4);
        return;
    L14:
        return;
    }

    public final void V90(String r3) {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isPlugin() == false) goto L14;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        Resources.Theme r2 = r1.getTheme();
        if (r2 == null) goto L9;
        v19.f.a(r2);
    L9:
        Resources.Theme r4 = r0.getApplication().getTheme();
        if (r4 == null) goto L12;
        v19.f.a(r4);
    L12:
        FLogger.a.i("ChatFragment", r3.concat(" applyTheme"));
        return;
    }

    public final void aa0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "leaveMethod");
        if (isAdded() == false) goto L8;
        com.larus.bmhome.chat.component.trace.z r0 = (com.larus.bmhome.chat.component.trace.z) this.v.getValue();
        if (r0 == null) goto L9;
        r0.DF(r3, null);
        return;
    L9:
        return;
    }

    public final void fillTrackParams(TrackParams r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        com.larus.trace.tracknode.a.a.a(this, r5);
        de8.c r1 = this.l;
        if (r1 == null) goto L55;
        Intrinsics.checkNotNullParameter(r5, "params");
        r5.putIfNull("enter_method", r1.k());
        r5.putIfNull("enter_chat_method", r1.k());
        SearchMobParam r0 = r1.e;
        String r2 = null;
        if (r0 == null) goto L7;
        String r3 = r0.a;
    L8:
        r5.putIfNull("query", r3);
        SearchMobParam r4 = r1.e;
        if (r4 == null) goto L11;
        String r6 = r4.b;
    L12:
        r5.putIfNull("query_id", r6);
        SearchMobParam r7 = r1.e;
        if (r7 == null) goto L15;
        String r8 = r7.c;
    L16:
        r5.putIfNull("search_id", r8);
        SearchMobParam r9 = r1.e;
        if (r9 == null) goto L19;
        String r10 = r9.d;
    L20:
        r5.putIfNull("search_request_id", r10);
        SearchMobParam r11 = r1.e;
        if (r11 == null) goto L23;
        String r12 = r11.e;
    L24:
        r5.putIfNull("search_result_id", r12);
        SearchMobParam r13 = r1.e;
        if (r13 == null) goto L27;
        String r14 = r13.f;
    L28:
        r5.putIfNull("rank", r14);
        RecommendFrom r15 = r1.d;
        if (r15 == null) goto L31;
        String r16 = r15.b;
    L32:
        r5.putIfNull("req_id", r16);
        RecommendFrom r17 = r1.d;
        if (r17 == null) goto L35;
        String r18 = r17.a;
    L36:
        r5.putIfNull("recommend_from", r18);
        Bundle r19 = r1.b;
        if (r19 == null) goto L39;
        r2 = r19.getString("from_notice_type", null);
    L39:
        if (r2 == null) goto L41;
        r5.putIfNull("from_notice_type", r2);
        r5.put("argPreviousPage", "notify");
    L41:
        BotRecommendMobInfo r20 = r1.m;
        if (r20 == null) goto L44;
        r20.b(r5);
    L44:
        r5.putIfNull("is_immersive_background", de8.d.b(Boolean.valueOf(r1.C())));
        r5.putIfNull("previous_page", r1.p());
        Bundle r21 = r1.b;
        if (r21 == null) goto L48;
        Bundle r22 = r21.getBundle("page_track_ext");
        if (r22 == null) goto L48;
    L49:
        Iterator<T> r23 = r22.keySet().iterator();
    L51:
        if (r23.hasNext() == false) goto L55;
        String r24 = (String) r23.next();
        String r25 = r22.getString(r24);
        if (r25 == null) goto L51;
        Intrinsics.checkNotNull(r24);
        r5.putIfNull(r24, r25);
    L48:
        r22 = new Bundle();
        goto L49
    L35:
        r18 = null;
        goto L36
    L31:
        r16 = null;
        goto L32
    L27:
        r14 = null;
        goto L28
    L23:
        r12 = null;
        goto L24
    L19:
        r10 = null;
        goto L20
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = null;
        goto L12
    L7:
        r3 = null;
    L55:
        Iterator<Map.Entry<String, String>> r26 = this.o.entrySet().iterator();
    L57:
        if (r26.hasNext() == false) goto L59;
        Map.Entry<String, String> r27 = r26.next();
        r5.putIfNull(r27.getKey(), r27.getValue());
        goto L57
    }

    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r3);
        if (com.larus.platform.service.e2.a.a(getActivity(), r3) == false) goto L20;
        LarusPageChatBinding r4 = this.u;
        MessageAdapter r0 = null;
        if (r4 == null) goto L9;
        ChatMessageList r5 = r4.n;
        if (r5 == null) goto L9;
        RecyclerView.Adapter r6 = r5.getAdapter();
    L11:
        if ((r6 instanceof MessageAdapter) == false) goto L13;
        r0 = (MessageAdapter) r6;
    L13:
        if (r0 == null) goto L15;
        com.larus.utils.t0.e(new com.larus.bmhome.chat.adapter.x(r0));
    L17:
        Function0<Unit> r7 = this.s;
        if (r7 == null) goto L20;
        r7.invoke();
        goto L20
    L15:
        if (r6 == null) goto L17;
        r6.notifyDataSetChanged();
    L9:
        r6 = null;
    L20:
        View r8 = this.t;
        if (r8 == null) goto L24;
        ViewCompat.requestApplyInsets(r8);
        return;
    }

    public final void onCreate(Bundle r11) {
        i1 r0 = this.k;
        r0.getClass();
        long r1 = System.currentTimeMillis();
        r0.d = r1;
        r0.a("createStartTime", r1);
        V90("onCreate");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(com.larus.bmhome.chat.component.ext.a.a(this, getArguments(), this.e));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L10;
        FLogger.a.e("ChatFragment", "parseArgument failed", r4);
        g.a.ensureNotReachHere(r4, "parseArgument failed");
    L10:
        Container r5 = null;
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        de8.c r6 = (de8.c) r3;
        if (r6 != null) goto L16;
        de8.c r7 = de8.c.s;
        r6 = de8.c.a.a(getArguments());
    L16:
        this.l = r6;
        WF().n(r6, de8.c.class);
        ChatPassThroughParams r8 = r6.b();
        if (r8 == null) goto L19;
        WF().n(r8, ChatPassThroughParams.class);
    L19:
        ChatPageContext r9 = r6.a();
        if (r9 == null) goto L22;
        WF().n(r9, ChatPageContext.class);
    L22:
        super.onCreate(r11);
        WF().n(new de8.a(null), de8.a.class);
        WF().n(this.m, ChatParam.class);
        WF().n(this.k, i1.class);
        t1a.b r12 = WF();
        com.larus.platform.service.z2 r10 = com.larus.platform.service.z2.a;
        r12.n(new e5(r10.enableMdWidgetsMixedArrangement(), r10.enableDataTagOptimize(), r10.enableTypingAsyncOptimize(), r10.enableTrackerOptimize(), r10.getMarkdownTableRenderConfig().c()), e5.class);
        WF().c(this, ry8.a.class);
        WF().c(this, gd8.f.class);
        W90();
        WF().c(new u0(this), va8.m.class);
        WF().c(this.H, ce8.d.class);
        ChatDoubleTabFragment r13 = this.M;
        if (r13 == null) goto L28;
        t1a.b r14 = WF();
        Intrinsics.checkNotNullParameter(r14, "vContext");
        if (r13.W90() == false) goto L27;
        r14.c(r13, ry8.c.class);
    L27:
        r14.c(r13, IChatDoubleTabAbility.class);
        this.M = null;
    L28:
        FLogger.a.i("ChatFragment", "onCreate hashCode=" + hashCode());
        ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).b(false);
        Container r15 = FragmentAttachExtKt.b(this, Y90());     // Catch: Exception -> L60
        this.G = r15;     // Catch: Exception -> L60
        de8.c r16 = this.l;     // Catch: Exception -> L60
        if (r16 == null) goto L32;
        Integer r17 = r16.m();     // Catch: Exception -> L60
    L33:
        de8.c r18 = this.l;     // Catch: Exception -> L60
        if (r18 == null) goto L36;
        long r19 = r18.n;     // Catch: Exception -> L60
    L37:
        fp8.a r20 = new fp8.a(r17, r19);     // Catch: Exception -> L60
        t1a.e r110 = s1a.d.a(r15).p(Reflection.getOrCreateKotlinClass(fp8.a.class));     // Catch: Exception -> L60
        if (r110 == null) goto L41;
        r110.a(new s0(r20));     // Catch: Exception -> L60
    L44:
        AttachReceiver r111 = this.G;     // Catch: Exception -> L60
        if (r111 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("chatCoreContainer");     // Catch: Exception -> L60
        r111 = null;
    L48:
        fp8.b r21 = new fp8.b(this.m.f, 6);     // Catch: Exception -> L60
        t1a.e r112 = s1a.d.a(r111).p(Reflection.getOrCreateKotlinClass(fp8.b.class));     // Catch: Exception -> L60
        if (r112 == null) goto L51;
        r112.a(new t0(r21));     // Catch: Exception -> L60
    L54:
        Function1<? super Container, Unit> r113 = this.j;     // Catch: Exception -> L60
        Container r22 = this.G;     // Catch: Exception -> L60
        if (r22 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("chatCoreContainer");     // Catch: Exception -> L60
    L58:
        r113.invoke(r5);     // Catch: Exception -> L60
        return;
    L57:
        r5 = r22;
        goto L58
    L51:
        x1a.b r114 = x1a.a.c;     // Catch: Exception -> L60
        if (r114 == null) goto L54;
        r114.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(fp8.b.class).getQualifiedName());     // Catch: Exception -> L60
        goto L54
    L41:
        x1a.b r115 = x1a.a.c;     // Catch: Exception -> L60
        if (r115 == null) goto L44;
        r115.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(fp8.a.class).getQualifiedName());     // Catch: Exception -> L60
        goto L44
    L36:
        r19 = 0;
        goto L37
    L32:
        r17 = null;
    L60:
        e = move-exception;
        FLogger.a.e("ChatFragment", "attachComponent chatCoreContainer error, " + e.getClass().getSimpleName() + ", " + e.getMessage());
        g.a.ensureNotReachHere(e, "attachComponent chatCoreContainer error");
        return;
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void onHiddenChanged(boolean r1) {
        super/*androidx.fragment.app.Fragment*/.onHiddenChanged(r1);
        if (r1 == true) goto L8;
        View r2 = this.t;
        if (r2 == null) goto L9;
        ViewCompat.requestApplyInsets(r2);
        return;
    L9:
        return;
    }

    public final void xC(te8.b r4) {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new ChatFragment$setAddBotListener$1(this, r4, null));
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.larus.bmhome.chat.i0] */
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        va8.f0 r8 = WF().getAbility(va8.f0.class);
        boolean r9 = false;
        if (r8 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == true) goto L18;
        va8.f0 r11 = WF().getAbility(va8.f0.class);
        if (r11 != null) goto L12;
    L14:
        boolean r12 = false;
    L15:
        if (r12 == true) goto L18;
        boolean r13 = false;
    L19:
        if (r13 == false) goto L21;
    L24:
        com.larus.bmhome.chat.component.halfscreen.c r14 = (com.larus.bmhome.chat.component.halfscreen.c) this.E.getValue();
        if (r14 == null) goto L27;
        r14.UX(new w(this));
    L27:
        Function1<? super BaseConstraintLayout, Unit> r15 = this.h;
        String r1 = null;
        if (r15 == null) goto L34;
        LarusPageChatBinding r2 = this.u;
        if (r2 == null) goto L32;
        ChatConstraintLayout r3 = r2.a;
    L33:
        r15.invoke(r3);
        goto L34
    L32:
        r3 = null;
    L34:
        ChatParam r16 = this.m;
        de8.c r4 = this.l;
        if (r4 == null) goto L37;
        String r5 = r4.p();
    L38:
        r16.c = r5;
        r16.d = "chat";
        de8.c r17 = this.l;
        if (r17 == null) goto L43;
        Bundle r18 = r17.b;
        if (r18 == null) goto L43;
        String r19 = r18.getString("chat_type");
    L44:
        r16.e = r19;
        com.larus.bmhome.chat.component.cvs.y r20 = (com.larus.bmhome.chat.component.cvs.y) this.w.getValue();
        if (r20 == null) goto L47;
        String r21 = r20.getBotId();
    L48:
        r16.b = r21;
        if (com.larus.bmhome.b0.b(this) == false) goto L51;
    L52:
        FragmentActivity r22 = getActivity();
        if (r22 == null) goto L61;
        Window r23 = r22.getWindow();
        if (r23 == null) goto L61;
        View r24 = r23.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L62;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r25 = ThreadMethodProxy.currentThread();
        if (r25 == com.larus.home.impl.utils.c.a) goto L62;
        com.larus.home.impl.utils.c.a(r25, "getDecorView");
    L62:
        FragmentActivity r26 = getActivity();
        if (r26 == null) goto L67;
        ComponentName r27 = r26.getComponentName();
        if (r27 == null) goto L67;
        r1 = r27.getClassName();
    L67:
        AtomicBoolean r28 = com.larus.bmhome.utils.f2.e;
        if (r28.get() == true) goto L72;
        if (r24 == null) goto L72;
        r24.getViewTreeObserver().addOnPreDrawListener(new com.larus.bmhome.utils.g2(r24, r28, r1));
    L72:
        IFlowSdkDepend r29 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r29 == null) goto L77;
        r29.getAccountService();
        if (com.larus.home.impl.sdk.d.a.O() != true) goto L77;
        boolean r30 = true;
    L79:
        if (r30 == false) goto L92;
        IFlowSdkDepend r31 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r31 == null) goto L85;
        r31.getAccountService();
        if (com.larus.home.impl.sdk.d.a.N() != true) goto L85;
        boolean r32 = true;
    L86:
        if (r32 == true) goto L92;
        if (com.larus.platform.service.i3.a.f() == true) goto L92;
        FLogger.a.i("ChatFragment", "checkAndPopupForceBind pop");
        IFlowSdkDepend r33 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r33 == null) goto L92;
        r33.getAccountService();
        com.larus.home.impl.sdk.d.a.Q(this, getArguments(), new i0(this));
    L85:
        r32 = false;
    L92:
        IBTMService r34 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r34 == null) goto L95;
        r34.a(this, "a35794.b83401");
    L95:
        String r35 = AppHost.a.getApplication().getPackageName();
        if (Intrinsics.areEqual(r35, "com.larus.nova.dorag") == false) goto L104;
        IFlowSdkDepend r36 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r36 == null) goto L105;
        com.larus.home.impl.sdk.s r37 = r36.s0();
        if (r37 == null) goto L105;
        if (r37.u() != true) goto L105;
        r9 = true;
    L105:
        if (r9 == false) goto L112;
        IFlowSdkDepend r38 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r38 == null) goto L113;
        com.larus.home.impl.sdk.s r39 = r38.s0();
        if (r39 == null) goto L114;
        r39.s();
        return;
    L114:
        return;
    L113:
        return;
    L112:
        return;
    L104:
        FLogger.a.i("ChatFragment", "not g package, packageName is " + r35);
    L77:
        r30 = false;
    L61:
        r24 = null;
        goto L62
    L51:
        if (xq8.b.a(this) == false) goto L72;
    L47:
        r21 = null;
    L43:
        r19 = null;
        goto L44
    L37:
        r5 = null;
        goto L38
    L21:
        if (com.larus.bmhome.b0.b(this) == true) goto L24;
        this.r = com.larus.utils.v.a(this, new j0(this));
        goto L24
    L12:
        if (r11.aD() != true) goto L14;
        r12 = true;
    L18:
        r13 = true;
        goto L19
    L5:
        if (r8.R() != true) goto L7;
        r10 = true;
        goto L8
    }

    @Override // xe8.a
    public final void Lc(final Bundle r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "bundle");
        String r1 = "";
        if (Intrinsics.areEqual(r6.getString("selected_result_from", ""), "selected_result_from_action_bar_button_router") == false) goto L7;
        FLogger.a.i("ChatFragment", "onResult intercept");
        return;
    L7:
        if (isDetached() == false) goto L9;
    L54:
        FLogger.a.e("ChatFragment", "on result invalid trigger");
        return;
    L9:
        if (getActivity() == null) goto L54;
        FLogger.a.i("ChatFragment", "on result, code" + r8);
        ry8.b r0 = (ry8.b) this.y.getValue();
        if (r0 == null) goto L13;
        r0.Y9(r6, r7, r8);
    L13:
        taa.a r2 = (taa.a) this.L.getValue();
        if (r2 == null) goto L16;
        r2.Y9(r6, r7, r8);
    L16:
        IAIChatUgcAIGCService.a.F(this, r6);
        com.larus.bmhome.instruction.g r9 = (com.larus.bmhome.instruction.g) this.B.getValue();
        if (r9 == null) goto L19;
        r9.Nb(r6);
    L19:
        u7 r10 = u3();
        if (r10 == null) goto L22;
        r10.ln(r6);
    L22:
        String r11 = r6.getString("KEY_CAMERA_RESULT_PENDING_SESSION_ID");
        if (r11 != null) goto L25;
    L28:
        boolean r12 = true;
    L29:
        if (r12 == true) goto L34;
        t1a.e r13 = WF().e(de8.a.class);
        if (r13 == null) goto L34;
        r13.a(new k0(r6));
    L34:
        if (r8 != 370) goto L39;
        com.larus.bmhome.instruction.g r14 = (com.larus.bmhome.instruction.g) this.B.getValue();
        if (r14 == null) goto L39;
        r14.Ps(r6);
    L39:
        if (r8 != (-1)) goto L56;
        String r15 = r6.getString("result_from", "");
        if (r15 == null) goto L45;
        r1 = r15;
    L45:
        if (Intrinsics.areEqual(r1, "creation") == false) goto L50;
        com.larus.bmhome.chat.component.fastsend.e0 r16 = (com.larus.bmhome.chat.component.fastsend.e0) this.F.getValue();
        if (r16 == null) goto L57;
        r16.Wi("onChatFragmentResult");
        return;
    L57:
        return;
    L50:
        if (Intrinsics.areEqual(r1, "creation_reedit") == false) goto L59;
        com.larus.bmhome.instruction.g r17 = (com.larus.bmhome.instruction.g) this.B.getValue();
        if (r17 == null) goto L60;
        r17.Ps(r6);
        return;
    L60:
        return;
    L59:
        return;
    L56:
        return;
    L25:
        if (r11.length() == 0) goto L28;
        r12 = false;
        goto L29
    }

    public final View onCreateView(LayoutInflater r19, ViewGroup r20, Bundle r21) {
        LayoutInflater r0 = r19;
        Intrinsics.checkNotNullParameter(r0, "inflater");
        i1 r3 = this.k;
        r3.getClass();
        long r4 = System.currentTimeMillis();
        r3.e = r4;
        r3.a("createViewStartTime", r4);
        V90("onCreateView");
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        int r6 = r5.getInt("layout_as", 2131563008);
    L6:
        Bundle r7 = getArguments();
        if (r7 == null) goto L9;
        boolean r10 = r7.getBoolean("out_keyboard", false);
    L10:
        Bundle r8 = getArguments();
        if (r8 != null) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r9 == false) goto L18;
        Configuration r11 = new Configuration(r19.getContext().getResources().getConfiguration());
        r11.uiMode = (r11.uiMode & (-49)) | 32;
        ContextThemeWrapper r12 = new ContextThemeWrapper(r19.getContext(), 0);
        r12.applyOverrideConfiguration(r11);
        v19.f.b(r12.getTheme());
        r0 = r0.cloneInContext(r12);
    L18:
        LayoutInflater r13 = r0;
        if (Y90() == ContainerFilter.READONLY_FORWARD_DETAIL) goto L29;
        Bundle r1 = getArguments();
        if (r1 != null) goto L23;
    L25:
        boolean r2 = false;
    L26:
        if (r2 == true) goto L29;
        boolean r14 = false;
    L30:
        if (r14 == true) goto L39;
        de8.c r15 = this.l;
        if (r15 != null) goto L34;
    L36:
        boolean r16 = false;
    L37:
        if (r16 == false) goto L39;
        boolean r17 = true;
    L40:
        FlowCommonAppCompatActivity r18 = requireActivity();
        if ((r18 instanceof FlowCommonAppCompatActivity) == false) goto L43;
        FlowCommonAppCompatActivity r22 = r18;
    L44:
        if (r22 == null) goto L46;
        boolean r110 = r22.K1();
    L47:
        de8.c r111 = this.l;
        if (r111 == null) goto L56;
        Bundle r112 = r111.a;
        if (r112 == null) goto L56;
        if (r112.getBoolean("disable_top_padding", false) == false) goto L54;
    L55:
        boolean r113 = true;
    L57:
        if (r113 == true) goto L61;
        if (r110 == true) goto L61;
        boolean r114 = false;
    L62:
        if (r22 == null) goto L64;
        boolean r23 = r22.H1();
    L65:
        if (r23 == true) goto L80;
        va8.f0 r24 = WF().getAbility(va8.f0.class);
        if (r24 != null) goto L69;
    L71:
        boolean r25 = false;
    L72:
        if (r25 == false) goto L79;
        IFlowSdkDepend r26 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r26 == null) goto L76;
        r26.D();
        com.larus.home.impl.sdk.x1 r27 = com.larus.home.impl.sdk.x1.a;
        boolean r28 = true;
    L77:
        if (r28 == true) goto L79;
    L76:
        r28 = false;
    L79:
        int r29 = 2131563008;
        boolean r115 = false;
    L81:
        if (r6 != r29) goto L109;
        if (r14 == false) goto L86;
        Intrinsics.checkNotNull(r13);
        FragmentActivity r30 = getActivity();
        Intrinsics.checkNotNullParameter(r13, "inflater");
        LarusPageChatBinding r31 = LarusPageChatBinding.b(r13, r20);
        if (r30 == null) goto L101;
        r31.g.setDisableTopPadding(r114);
        r31.g.setDisableBottomPadding(r115);
        r31.g.k6(r30);
    L101:
        String r116 = "disable_top_padding";
    L122:
        this.u = r31;
        Bundle r32 = Z90();
        if (r32 == null) goto L127;
        ChatPassThroughParams r33 = k.a(r32);
        if (r33 == null) goto L127;
        boolean r34 = r33.getEnableSmallWindowTopInsetAdaptation();
    L133:
        LarusPageChatBinding r35 = this.u;
        if (r35 == null) goto L136;
        ChatConstraintLayout r36 = r35.a;
    L138:
        if ((r36 instanceof BaseConstraintLayout) == true) goto L141;
        r36 = null;
    L141:
        if (r36 == null) goto L143;
        r36.setEnableSmallWindowTopInsetAdaptation(r34);
    L143:
        if (r34 == false) goto L154;
        LarusPageChatBinding r37 = this.u;
        if (r37 == null) goto L154;
        FrameLayout r38 = r37.r;
        if (r38 == null) goto L154;
        this.t = r38;
        ViewCompat.setOnApplyWindowInsetsListener(r38, new h0(this));
        if (r38.isAttachedToWindow() == false) goto L153;
        ViewCompat.requestApplyInsets(r38);
        goto L154
    L153:
        r38.addOnAttachStateChangeListener(new v0(r38));
    L154:
        Bundle r39 = getArguments();
        if (r39 != null) goto L157;
    L162:
        Bundle r40 = getArguments();
        if (r40 != null) goto L165;
    L167:
        boolean r41 = false;
    L168:
        if (r41 == false) goto L183;
        Integer r42 = com.larus.platform.service.o2.a.d();
        if (r42 == null) goto L183;
        int r43 = r42.intValue();
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L174
        Object r45 = Result.constructor-impl(Integer.valueOf(ContextCompat.getColor(AppHost.a.getApplication(), r43)));     // Catch: Throwable -> L174
    L177:
        if (Result.isFailure-impl(r45) == false) goto L179;
        r45 = null;
    L179:
        Integer r46 = (Integer) r45;
        if (r46 == null) goto L183;
        U90(r46.intValue());
    L199:
        IFlowSdkDepend r47 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r47 == null) goto L206;
        r47.r0();
        com.larus.home.impl.sdk.e2 r48 = com.larus.home.impl.sdk.e2.a;
        LarusPageChatBinding r49 = this.u;
        if (r49 == null) goto L204;
        ChatConstraintLayout r50 = r49.a;
    L205:
        r48.s(r50, "bot_create_complete_first_frame");
        goto L206
    L204:
        r50 = null;
    L206:
        IFlowSdkDepend r51 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r51 == null) goto L213;
        r51.r0();
        com.larus.home.impl.sdk.e2 r52 = com.larus.home.impl.sdk.e2.a;
        LarusPageChatBinding r53 = this.u;
        if (r53 == null) goto L211;
        ChatConstraintLayout r54 = r53.a;
    L212:
        r52.s(r54, "bot_create_step_complete_first_frame");
        goto L213
    L211:
        r54 = null;
    L213:
        Bundle r55 = Z90();
        if (r55 == null) goto L216;
        boolean r56 = r55.getBoolean("isMultiWindowMode", false);
    L217:
        if (r56 == true) goto L223;
        com.larus.platform.service.e2 r57 = com.larus.platform.service.e2.a;
        LarusPageChatBinding r58 = this.u;
        if (r58 == null) goto L221;
        ChatConstraintLayout r59 = r58.a;
    L222:
        r57.b(r59, CollectionsKt.mutableListOf(new Integer[]{2131388843, 2131365509, 2131364151, 2131375950, 2131375917, 2131375916}));
        goto L223
    L221:
        r59 = null;
    L223:
        LarusPageChatBinding r60 = this.u;
        if (r60 == null) goto L243;
        ChatConstraintLayout r61 = r60.a;
        if (r61 == null) goto L243;
        r61.setTag(2131377847, this);
        Bundle r62 = getArguments();
        if (r62 != null) goto L230;
    L232:
        boolean r63 = false;
    L233:
        if (r63 == true) goto L241;
        Bundle r64 = getArguments();
        if (r64 != null) goto L237;
    L239:
        boolean r65 = false;
    L240:
        if (r65 == true) goto L241;
    L253:
        return r61;
    L237:
        if (r64.getBoolean("argDisableTopPadding", false) != true) goto L239;
        r65 = true;
    L241:
        r61.setPadding(r61.getPaddingLeft(), 0, r61.getPaddingRight(), r61.getPaddingBottom());
        r61.setDisableTopPadding(true);
        goto L253
    L230:
        if (r62.getBoolean(r116, false) != true) goto L232;
        r63 = true;
    L243:
        return null;
    L216:
        r56 = false;
    L174:
        th = move-exception;
        Result.Companion r66 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
    L183:
        if (AppHost.a.isPlugin() == false) goto L199;
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L197
        int r68 = ContextCompat.getColor(requireContext(), v19.c.b(2130970529, requireContext(), 2131102529));     // Catch: Throwable -> L197
        LarusPageChatBinding r69 = this.u;     // Catch: Throwable -> L197
        if (r69 == null) goto L189;
        ChatConstraintLayout r70 = r69.a;     // Catch: Throwable -> L197
        if (r70 == null) goto L189;
        r70.setBackgroundColor(r68);     // Catch: Throwable -> L197
    L189:
        LarusPageChatBinding r71 = this.u;     // Catch: Throwable -> L197
        if (r71 == null) goto L194;
        BottomMenuGridLayout r72 = r71.e;     // Catch: Throwable -> L197
        if (r72 == null) goto L194;
        r72.setBackgroundColor(r68);     // Catch: Throwable -> L197
        Unit r73 = Unit.INSTANCE;     // Catch: Throwable -> L197
    L195:
        Result.constructor-impl(r73);     // Catch: Throwable -> L197
    L194:
        r73 = null;
    L197:
        th = move-exception;
        Result.Companion r74 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L199
    L165:
        if (r40.getBoolean("argIsHalfScreen") != true) goto L167;
        r41 = true;
        goto L168
    L157:
        if (r39.containsKey("argHostChatBackgroundColor") == true) goto L160;
        r39 = null;
    L160:
        if (r39 == null) goto L162;
        U90(r39.getInt("argHostChatBackgroundColor"));
        goto L199
    L136:
        r36 = null;
    L127:
        Bundle r75 = Z90();
        if (r75 != null) goto L130;
    L132:
        r34 = false;
        goto L133
    L130:
        if (r75.getBoolean("enable_small_window_top_inset_adaptation", false) != true) goto L132;
        r34 = true;
        goto L133
    L86:
        if (r17 == false) goto L91;
        Intrinsics.checkNotNull(r13);
        FragmentActivity r76 = getActivity();
        Intrinsics.checkNotNullParameter(r13, "inflater");
        r31 = LarusPageChatBinding.b(r13, r20);
        if (r76 == null) goto L101;
        if (r10 == true) goto L101;
        r31.g.k6(r76);
        goto L101
    L91:
        Intrinsics.checkNotNull(r13);
        FragmentActivity r77 = getActivity();
        Intrinsics.checkNotNullParameter(r13, "inflater");
        if (r9 == false) goto L247;
    L104:
        r116 = "disable_top_padding";
        LarusPageChatBinding r78 = com.larus.bmhome.utils.m.a(r13, r20, r77, r10, r114, r115);     // Catch: Throwable -> L107
    L121:
        r31 = r78;
    L107:
        th = th;
    L108:
        EnsureManager.ensureNotReachHere("generateChatFragmentView#msg=" + th.getMessage());
        FLogger.a.e("generateChatFragmentView", "err = " + th.getMessage());
        r78 = com.larus.bmhome.utils.m.a(r13, r20, r77, r10, r114, r115);
        goto L121
    L247:
    L102:
        th = th;
        r116 = "disable_top_padding";
        goto L108
    L94:
        if (com.larus.platform.service.z2.a.enablePreloadChatPageView().b() == false) goto L104;
        if (r77 == null) goto L104;
        o37.c.e.getClass();     // Catch: Throwable -> L102
        if (o37.c.f("chat_fragment_nita") == false) goto L104;
        int r79 = gd8.c.b;     // Catch: Throwable -> L102
        r31 = LarusPageChatBinding.a((View) gd8.c.a.a("ChatFragmentRootView", new com.larus.bmhome.utils.l(r77)));     // Catch: Throwable -> L102
        if (r10 == true) goto L101;
        r31.g.setDisableTopPadding(r114);     // Catch: Throwable -> L102
        r31.g.setDisableBottomPadding(r115);     // Catch: Throwable -> L102
        r31.g.k6(r77);     // Catch: Throwable -> L102
        goto L101
    L109:
        r116 = "disable_top_padding";
        Intrinsics.checkNotNull(r13);
        FragmentActivity r80 = getActivity();
        Intrinsics.checkNotNullParameter(r13, "inflater");
        if (r20 == null) goto L120;
        if (r80 == null) goto L120;
        View r81 = r13.inflate(r6, r20, false);
        ViewStub r82 = (ViewStub) r81.findViewById(2131379994);
        ViewStub r83 = (ViewStub) r81.findViewById(2131375324);
        ViewStub r84 = (ViewStub) r81.findViewById(2131364480);
        r82.setLayoutResource(2131562850);
        r83.setLayoutResource(2131562781);
        r84.setLayoutResource(2131562780);
        r82.inflate();
        View r85 = r83.inflate();
        if ((r85 instanceof ViewGroup) == false) goto L116;
        ViewGroup r86 = (ViewGroup) r85;
    L117:
        r84.inflate();
        r78 = LarusPageChatBinding.a(r81);
        InputViewCreatorDelegate.b.b(r86);
        if (r10 == true) goto L121;
        r78.g.setDisableTopPadding(r114);
        r78.g.setDisableBottomPadding(r115);
        r78.g.k6(r80);
        goto L121
    L116:
        r86 = null;
    L120:
        r78 = com.larus.bmhome.utils.m.a(r13, r20, r80, r10, r114, r115);
        goto L121
    L69:
        if (r24.R() != true) goto L71;
        r25 = true;
    L80:
        r29 = 2131563008;
        r115 = true;
        goto L81
    L64:
        r23 = false;
    L61:
        r114 = true;
        goto L62
    L54:
        if (r112.getBoolean("argDisableTopPadding", false) == true) goto L55;
    L56:
        r113 = false;
        goto L57
    L46:
        r110 = false;
        goto L47
    L43:
        r22 = null;
        goto L44
    L34:
        if (r15.E() != true) goto L36;
        r16 = true;
    L39:
        r17 = false;
        goto L40
    L23:
        if (r1.getBoolean("preview_collection_readonly") != true) goto L25;
        r2 = true;
    L29:
        r14 = true;
        goto L30
    L13:
        if (r8.getBoolean("argForceDarkTheme") != true) goto L15;
        r9 = true;
        goto L16
    L9:
        r10 = false;
        goto L10
    L5:
        r6 = 2131563008;
        goto L6
    }
}
