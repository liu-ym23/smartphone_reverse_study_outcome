package com.obric.assistant.omnidetailpage.componment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.api.q0;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.gallery.api.DisplayGravity;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.block.AttachmentBlock;
import com.larus.im.bean.message.block.AttachmentExtra;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.LocalFileBlock;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.im.bean.message.block.OOmniDetailGUIProcessBlock;
import com.larus.im.bean.message.block.OOmniDetailPlanStateBlock;
import com.larus.im.bean.message.block.OSearchQueryResultBlock;
import com.larus.im.bean.message.block.OTaskInfo;
import com.larus.im.bean.message.block.OTipBlock;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.UploadFile;
import com.larus.im.bean.message.block.UploadImage;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.card.databinding.ObricFragmentOmniDetailBinding;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.omnidetailpage.TaskDetailAdapter;
import com.obric.assistant.omnidetailpage.localmedia.OmniDetailInputFileCache;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import com.obric.cae.libs.useraware.ApWakeEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.MutexImpl;
import v19.i5;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u008f\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b*\u00010\u0018\u0000 ¸\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002¸\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020=H\u0016J\u0018\u0010A\u001a\u0004\u0018\u00010*2\u0006\u0010B\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020=H\u0002J\b\u0010E\u001a\u00020!H\u0002J\u0018\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020!2\u0006\u0010G\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020=2\u0006\u0010G\u001a\u00020LH\u0002J\u0018\u0010N\u001a\u00020=2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010O\u001a\u00020=2\u0006\u0010G\u001a\u00020PH\u0002J\u0018\u0010Q\u001a\u00020=2\u0006\u0010G\u001a\u00020R2\u0006\u0010S\u001a\u00020\u0014H\u0002J\u0010\u0010T\u001a\u00020=2\u0006\u0010G\u001a\u00020LH\u0002J\u0018\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020!2\u0006\u0010G\u001a\u00020LH\u0002J\u0010\u0010Z\u001a\u00020!2\u0006\u0010G\u001a\u00020LH\u0002J \u0010[\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010\\\u001a\u00020L2\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010[\u001a\u00020\u00142\u0006\u0010G\u001a\u00020P2\u0006\u0010V\u001a\u00020\u0014H\u0002J\n\u0010]\u001a\u0004\u0018\u00010^H\u0002J\n\u0010_\u001a\u0004\u0018\u00010^H\u0002J\u0016\u0010`\u001a\u00020=2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001b0bH\u0002J\u0018\u0010c\u001a\u0004\u0018\u00010*2\u0006\u0010d\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010CJ\u0016\u0010e\u001a\u00020=2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001aH\u0002J&\u0010h\u001a\u00020\u0014*\u00020i2\b\u0010j\u001a\u0004\u0018\u00010\u00142\u0006\u0010k\u001a\u00020J2\u0006\u0010l\u001a\u00020JH\u0002J \u0010m\u001a\u00020=2\u0006\u0010n\u001a\u00020,2\u0006\u0010>\u001a\u00020?2\u0006\u0010o\u001a\u00020JH\u0002J&\u0010p\u001a\u00020=2\u0006\u0010n\u001a\u00020,2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020,0\u001a2\u0006\u0010r\u001a\u00020?H\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010t2\u0006\u0010u\u001a\u00020,H\u0002J\u0010\u0010v\u001a\u00020w2\u0006\u0010r\u001a\u00020?H\u0002J\u0018\u0010x\u001a\u00020=2\u0006\u0010u\u001a\u00020,2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010y\u001a\u00020=2\u0006\u0010u\u001a\u00020,2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010z\u001a\u00020=2\u0006\u0010u\u001a\u00020,2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010{\u001a\u00020=2\u0006\u0010u\u001a\u00020,2\u0006\u0010>\u001a\u00020?H\u0002J,\u0010|\u001a\u00020=2\u0006\u0010u\u001a\u00020,2\u0006\u0010>\u001a\u00020?2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020=0~H\u0002J\u0012\u0010\u007f\u001a\u0004\u0018\u00010\u00142\u0006\u0010u\u001a\u00020,H\u0002J\"\u0010\u0080\u0001\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010u\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\u0014H\u0002J\"\u0010\u0082\u0001\u001a\u00020=2\u0007\u0010\u0083\u0001\u001a\u00020\u00142\u0007\u0010\u0084\u0001\u001a\u00020\u0014H\u0082@¢\u0006\u0003\u0010\u0085\u0001J\u0010\u0010\u0086\u0001\u001a\u00020=H\u0082@¢\u0006\u0003\u0010\u0087\u0001J\u001e\u0010\u0088\u0001\u001a\u00020=2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0082@¢\u0006\u0003\u0010\u0089\u0001J*\u0010\u008a\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u008b\u00010\u001a2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001aH\u0002J4\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\u001a\u0010\u008d\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u008b\u00010\u001a2\u0007\u0010\u008e\u0001\u001a\u00020!H\u0002J \u0010\u008f\u0001\u001a\u00020=2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001a2\u0007\u0010\u008e\u0001\u001a\u00020!H\u0002J/\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001a2\t\b\u0002\u0010\u0091\u0001\u001a\u00020!H\u0082@¢\u0006\u0003\u0010\u0092\u0001J\u0017\u0010\u0093\u0001\u001a\u00020!2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001aH\u0002J:\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001a2\t\b\u0002\u0010\u0091\u0001\u001a\u00020!2\u0010\b\u0002\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u001aH\u0002J\u001e\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u001a2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001aH\u0002J9\u0010\u0098\u0001\u001a\u00020=2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u001b0b2\u000e\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u001a2\u0007\u0010\u0091\u0001\u001a\u00020!2\u0007\u0010\u009a\u0001\u001a\u00020!H\u0002J\u001d\u0010\u009b\u0001\u001a\u00020!2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020=H\u0002J\t\u0010 \u0001\u001a\u00020=H\u0002J\t\u0010¡\u0001\u001a\u00020=H\u0016J\u001d\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020g0\u001a2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u001aH\u0002J*\u0010£\u0001\u001a\u00020=2\u0007\u0010¤\u0001\u001a\u00020\u00142\u0007\u0010¥\u0001\u001a\u00020J2\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020g0\u001aH\u0002J\u0012\u0010§\u0001\u001a\u00020=2\u0007\u0010¨\u0001\u001a\u00020!H\u0002J\t\u0010©\u0001\u001a\u00020=H\u0016J\t\u0010ª\u0001\u001a\u00020=H\u0016J\t\u0010«\u0001\u001a\u00020=H\u0002J\u0013\u0010¬\u0001\u001a\u00020=2\b\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0002J\t\u0010¯\u0001\u001a\u00020!H\u0002J\u0018\u0010°\u0001\u001a\u00020=2\r\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0013\u0010²\u0001\u001a\u00020=2\b\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0002J\u0013\u0010³\u0001\u001a\u00020!2\b\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0002J\t\u0010´\u0001\u001a\u00020=H\u0016J\t\u0010µ\u0001\u001a\u00020=H\u0002J\t\u0010¶\u0001\u001a\u00020=H\u0002J\t\u0010·\u0001\u001a\u00020=H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140#j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u00107R\u000e\u00108\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¹\u0001"}, d2 = {"Lcom/obric/assistant/omnidetailpage/componment/OmniDetailContentComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/assistant/omnidetailpage/componment/IOmniDetailContentAbility;", "<init>", "()V", "binding", "Lcom/obric/assistant/card/databinding/ObricFragmentOmniDetailBinding;", "getBinding", "()Lcom/obric/assistant/card/databinding/ObricFragmentOmniDetailBinding;", "binding$delegate", "Lkotlin/Lazy;", "omniParam", "Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "getOmniParam", "()Lcom/obric/assistant/omnidetailpage/model/OmniDetailParam;", "omniParam$delegate", "localVideoAutoPlayManager", "Lcom/obric/assistant/omnidetailpage/localmedia/TaskLocalVideoAutoPlayManager;", "resourceId", "", "getResourceId", "()Ljava/lang/String;", "resourceId$delegate", "_blockDataFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem;", "adapter", "Lcom/obric/assistant/omnidetailpage/TaskDetailAdapter;", "controller", "Lcom/larus/im/DeepResearchController;", "hasBeenStopped", "", "additionTipsByBlockId", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "blockDataMutex", "Lkotlinx/coroutines/sync/Mutex;", "latestBlockData", "entryMessageDeferred", "Lkotlinx/coroutines/Deferred;", "Lcom/larus/im/bean/message/Message;", "headerAttachments", "Lcom/obric/assistant/omnidetailpage/model/HeaderAttachment;", "downloadingAttachmentIds", "", "headerAttachmentClickDelegate", "com/obric/assistant/omnidetailpage/componment/OmniDetailContentComponent$headerAttachmentClickDelegate$2$1", "getHeaderAttachmentClickDelegate", "()Lcom/obric/assistant/omnidetailpage/componment/OmniDetailContentComponent$headerAttachmentClickDelegate$2$1;", "headerAttachmentClickDelegate$delegate", "isAutoFollowBottomAllowedByUser", "shouldKeepHeaderPlaceholder", "shouldAutoScrollOnInitialLoad", "Ljava/lang/Boolean;", "isTaskFinishedForAutoFollow", "hasPerformedInitialAutoScroll", "isUserDraggingList", "reportedMembershipGuidanceShows", "onViewCreated", "", "view", "Landroid/view/View;", "onAttach", "getTaskMessage", "queryId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTitle", "isTaskFinished", "handleQuickReplyClick", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$QuickReply;", "index", "", "shouldOpenQuickReplySchema", "Lcom/larus/im/bean/message/block/QuickReplyItem;", "openQuickReplySchema", "handleQuickReplyShow", "handleContentShow", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Content;", "handleModeSettingClick", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$ModeSetting;", "clickAction", "reportMembershipGuidanceShowIfNeeded", "reportMembershipGuidanceShow", "targetUrl", "membershipService", "Lcom/larus/commercemembership/api/ICommerceMembershipService;", "openMembershipGuidanceUrlIfNeeded", "isMembershipGuidanceItem", "buildMembershipGuidanceShowKey", "quickReplyItem", "getHeaderFromDetailCache", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Header;", "buildHeaderItem", "upsertHeader", "items", "", "getEntryMessage", "messageId", "syncHeaderAttachments", "blocks", "Lcom/larus/im/bean/message/block/Block;", "stableAttachmentKey", "Lcom/larus/im/bean/message/block/AttachmentItem;", "blockId", "blockIndex", "itemIndex", "handleHeaderAttachmentClick", "clickedAttachment", "event", "openHeaderImageGallery", "currentAttachments", "startView", "toHeaderLocalMediaItem", "Lcom/obric/assistant/omnidetailpage/model/LocalMediaPreviewItem$Image;", "attachment", "buildHeaderGalleryDisplayConfig", "Lcom/larus/gallery/api/DisplayConfig;", "openHeaderFile", "openHeaderVideo", "openHeaderAudio", "openHeaderLarkDoc", "openOrDownloadHeaderAttachment", "onReady", "Lkotlin/Function1;", "findExistingHeaderAttachmentPath", "showHeaderAttachmentOpenFailed", WindowEvent.Params.REASON, "updateHeaderAttachmentLocalPath", "displayKey", "path", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitHeaderUpdate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitBlockData", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractAdditionTips", "Lkotlin/Pair;", "mergeAdditionTips", "incoming", "isIncrementalUpdate", "syncAdditionTip", "buildWrappedItems", "taskFinished", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasLocalResourceBlocks", "wrapBlocks", "localResultEntries", "Lcom/obric/assistant/omnidetailpage/model/LocalResultEntry;", "extractAndFilterLocalResults", "appendLocalResultItems", "entries", "currentPlanStateFinished", "isSameLocalMediaBlock", "first", "Lcom/obric/assistant/omnidetailpage/model/LocalResultEntry$Media;", "second", "updateContent", "loadContentCache", "fetchData", "appendBlocks", "fetchDeepResearchBySSE", "resId", "curCursor", "originBLocks", "updateSkeletonScreen", "show", "onStop", "onResume", "initViews", "initRecyclerAutoScroll", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "canAutoFollowBottomAfterInitialLoad", "maybeAutoScrollToBottom", "data", "scrollToBottomEdge", "isNearBottom", "onDestroy", "releaseVisibleLocalMediaVideos", "pauseVisibleLocalMediaVideos", "checkVisibleLocalMediaAutoPlay", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniDetailContentComponent extends BaseContentWidget implements com.obric.assistant.omnidetailpage.componment.b {
    public static final /* synthetic */ int I = 0;
    public final Lazy A;
    public boolean B;
    public boolean C;
    public Boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public final Set<String> H;
    public final Lazy m;
    public final Lazy n;
    public final com.obric.assistant.omnidetailpage.localmedia.w o;
    public final Lazy p;
    public final MutableSharedFlow<List<ifa.f>> q;
    public TaskDetailAdapter r;
    public com.larus.im.internal.research.d.a s;
    public boolean t;
    public final LinkedHashMap<String, String> u;
    public final MutexImpl v;
    public List<? extends ifa.f> w;
    public Deferred<Message> x;
    public List<ifa.a> y;
    public final Set<String> z;

    public static final class a {
    }

    public static final class b implements lr8.a {
        public final /* synthetic */ OmniDetailContentComponent a;

        public final void a() {
        }

        public final /* bridge */ /* synthetic */ com.larus.trace.tracknode.a f() {
            return null;
        }

        public final /* bridge */ /* synthetic */ q0 getAdapter() {
            return null;
        }

        public final boolean i0() {
            return false;
        }

        public final CoroutineScope c() {
            return LifecycleOwnerKt.getLifecycleScope(this.a);
        }

        public final FragmentManager getFragmentManager() {
            Fragment r0 = s1a.a.c(this.a);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getParentFragmentManager();
        }

        public final wc9.e h() {
            IObricChatService.a.getClass();
            IObricChatService r0 = IObricChatService.a.a();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.h();
        }

        public final BotModel i() {
            IObricChatService.a.getClass();
            IObricChatService r0 = IObricChatService.a.a();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.j0();
        }

        public b(OmniDetailContentComponent r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void onStop() {
        this.t = true;
        this.G = false;
        this.o.b();
        com.larus.im.internal.research.d.a r0 = this.s;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final ifa.f.c G3() {
        List<ifa.f> r1 = OmniPageUtil.b.get(W3());
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        Iterator<T> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if ((((ifa.f) r3) instanceof ifa.f.c) == false) goto L7;
    L13:
        if ((r3 instanceof ifa.f.c) == false) goto L15;
        ifa.f.c r4 = (ifa.f.c) r3;
    L16:
        boolean r5 = false;
        if (this.C == false) goto L45;
        ifa.e r6 = V3();
        if (r6 == null) goto L30;
        String r7 = r6.a;
        if (r7 == null) goto L30;
        if (r7.length() <= 0) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L29;
        r7 = null;
    L29:
        if (r7 == null) goto L30;
    L57:
        if (this.C == false) goto L85;
        ifa.e r9 = V3();
        if (r9 == null) goto L70;
        String r10 = r9.b;
        if (r10 == null) goto L70;
        if (r10.length() <= 0) goto L65;
        boolean r11 = true;
    L66:
        if (r11 == true) goto L69;
        r10 = null;
    L69:
        if (r10 == null) goto L70;
    L94:
        String r12 = r10;
    L96:
        ifa.e r13 = V3();
        if (r13 == null) goto L105;
        List<String> r14 = r13.c;
        if (r14 == null) goto L105;
        if ((!r14.isEmpty()) == true) goto L104;
        r14 = null;
    L104:
        if (r14 == null) goto L105;
    L112:
        List<ifa.a> r15 = this.y;
        if (this.C == false) goto L132;
        if (r7 != null) goto L116;
    L119:
        boolean r16 = true;
    L120:
        if (r16 == false) goto L132;
        List<String> r17 = r14;
        if (r17 != null) goto L124;
    L127:
        boolean r18 = true;
    L128:
        if (r18 == false) goto L132;
        if (r15.isEmpty() == false) goto L132;
        boolean r19 = true;
    L133:
        if (r19 == true) goto L151;
        if (r7 != null) goto L136;
    L139:
        boolean r20 = true;
    L140:
        if (r20 == false) goto L151;
        List<String> r21 = r14;
        if (r21 != null) goto L144;
    L145:
        r5 = true;
    L146:
        if (r5 == false) goto L151;
        if (r15.isEmpty() == false) goto L151;
        return null;
    L144:
        if (r21.isEmpty() == false) goto L146;
    L136:
        if (r7.length() == 0) goto L139;
        r20 = false;
    L151:
        if (r7 != null) goto L153;
        r7 = "";
    L153:
        Block r22 = new Block(0, "-1", null, new BlockContent(new TextBlock(r7, null, null, r12, 0, 22, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null), false, null, null, null, 229, null);
        if (r14 != null) goto L157;
        r14 = CollectionsKt.emptyList();
    L157:
        return new ifa.f.c(r22, r14, r19, r15);
    L124:
        if (r17.isEmpty() == true) goto L127;
        r18 = false;
        goto L128
    L116:
        if (r7.length() == 0) goto L119;
        r16 = false;
    L132:
        r19 = false;
    L105:
        if (r4 == null) goto L111;
        r14 = r4.h;
        if (r14 == null) goto L111;
        if ((!r14.isEmpty()) == true) goto L112;
    L111:
        r14 = null;
        goto L112
    L65:
        r11 = false;
    L70:
        if (r4 == null) goto L95;
        Block r23 = r4.b;
        if (r23 == null) goto L95;
        BlockContent r24 = r23.getContent();
        if (r24 == null) goto L95;
        TextBlock r25 = r24.getTextBlock();
        if (r25 == null) goto L95;
        r10 = r25.summary;
        if (r10 == null) goto L95;
        if (r10.length() <= 0) goto L82;
        boolean r26 = true;
    L83:
        if (r26 == false) goto L95;
    L82:
        r26 = false;
    L95:
        r12 = null;
        goto L96
    L85:
        ifa.e r27 = V3();
        if (r27 == null) goto L95;
        r10 = r27.b;
        if (r10 == null) goto L95;
        if (r10.length() <= 0) goto L92;
        boolean r28 = true;
    L93:
        if (r28 == false) goto L95;
    L92:
        r28 = false;
        goto L93
    L25:
        r8 = false;
    L30:
        if (r4 == null) goto L55;
        Block r29 = r4.b;
        if (r29 == null) goto L55;
        BlockContent r30 = r29.getContent();
        if (r30 == null) goto L55;
        TextBlock r31 = r30.getTextBlock();
        if (r31 == null) goto L55;
        r7 = r31.text;
        if (r7 == null) goto L55;
        if (r7.length() <= 0) goto L42;
        boolean r32 = true;
    L43:
        if (r32 == false) goto L55;
    L42:
        r32 = false;
    L55:
        r7 = null;
        goto L57
    L45:
        ifa.e r33 = V3();
        if (r33 == null) goto L55;
        r7 = r33.a;
        if (r7 == null) goto L55;
        if (r7.length() <= 0) goto L52;
        boolean r34 = true;
    L53:
        if (r34 == false) goto L55;
    L52:
        r34 = false;
        goto L53
    L15:
        r4 = null;
        goto L16
    L11:
        r3 = null;
        goto L13
    }

    public final ifa.e V3() {
        return (ifa.e) this.n.getValue();
    }

    public final String W3() {
        return (String) this.p.getValue();
    }

    public final void onDestroy() {
        com.larus.im.internal.research.d.a r0 = this.s;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        Deferred<Message> r1 = this.x;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.z.clear();
        com.obric.assistant.omnidetailpage.localmedia.w r2 = this.o;
        Iterator r3 = CollectionsKt.toList(r2.a).iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        ((com.obric.assistant.omnidetailpage.localmedia.y) r3.next()).i3();
        goto L10
    L12:
        r2.a.clear();
        ((LinkedHashMap) r2.b).clear();
        r2.c.clear();
        r2.d = null;
        com.obric.assistant.omnidetailpage.localmedia.v.a.d();
        OmniPageUtil.a.clear();
    }

    public final void onResume() {
        ObricFragmentOmniDetailBinding r0 = (ObricFragmentOmniDetailBinding) this.m.getValue();
        if (r0 == null) goto L8;
        RecyclerView r1 = r0.g;
        if (r1 == null) goto L8;
        r1.post(new p(this));
    L8:
        if (this.t == false) goto L11;
        this.t = false;
        fetchData();
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if (r0 == null) goto L6;
        s1a.a.a(r0, this, com.obric.assistant.omnidetailpage.componment.b.class);
        return;
    }

    public OmniDetailContentComponent() {
        this.m = LazyKt.lazy(new r(this));
        this.n = LazyKt.lazy(new s(this));
        this.o = new com.obric.assistant.omnidetailpage.localmedia.w();
        this.p = LazyKt.lazy(new t(this));
        this.q = SharedFlowKt.MutableSharedFlow(1, 5, BufferOverflow.DROP_OLDEST);
        this.u = new LinkedHashMap();
        this.v = kotlinx.coroutines.sync.b.a();
        this.w = CollectionsKt.emptyList();
        this.y = CollectionsKt.emptyList();
        this.z = new LinkedHashSet();
        this.A = LazyKt.lazy(LazyThreadSafetyMode.NONE, new u(this));
        this.B = true;
        this.C = true;
        this.H = new LinkedHashSet();
    }

    @Override // com.obric.assistant.omnidetailpage.componment.b
    public final void fetchData() {
        if (W3().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.D = null;
        this.E = false;
        com.larus.im.e r1 = com.larus.im.c.a;
        com.larus.im.internal.research.a.a.a(W3(), new AnonymousClass1(this));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static com.larus.gallery.api.b E3(View r14) {
        FragmentActivity r15 = r14.getContext();
        Integer r1 = null;
        if ((r15 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r0 = r15;
    L6:
        Integer r2 = Integer.valueOf(com.larus.utils.u.b(r0));
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        r1 = r2;
    L12:
        if (r1 == null) goto L14;
        int r4 = r1.intValue();
    L16:
        return new com.larus.gallery.api.b(new com.larus.gallery.api.a(m0.b(r15), RangesKt.coerceAtLeast((m0.a(r15) - i5.n()) - r4, 0), DisplayGravity.TOP, new com.larus.gallery.adapter.ui.i(i5.Z())), false, Bitmap.Config.ARGB_8888, 0, false, false, false, null, null, false, 31198);
    L14:
        r4 = i5.h();
        goto L16
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    public static String Q3(ifa.a r2) {
        String r3 = r2.d;
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L17;
        File r1 = new PolarisFileWrapper(r3);
        if (r1.isFile() == true) goto L13;
        r1 = null;
    L13:
        if (r1 != null) goto L15;
        return null;
    L15:
        return r1.getAbsolutePath();
    L17:
        return null;
    }

    public static boolean X3(QuickReplyItem r1) {
        Map r2 = r1.getExtraParams();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("source");
    L7:
        return Intrinsics.areEqual(r3, "cta_button");
    L5:
        r3 = null;
        goto L7
    }

    public final Object H3(Continuation<? super Unit> r7) {
        if ((r7 instanceof OmniDetailContentComponent$emitHeaderUpdate$1) == false) goto L7;
        OmniDetailContentComponent$emitHeaderUpdate$1 r0 = (OmniDetailContentComponent$emitHeaderUpdate$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L27:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r4.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r5 = r4;
    L32:
        r5.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r5 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L36:
        List<ifa.f> r10 = CollectionsKt.toMutableList(this.w);     // Catch: Throwable -> L31
        d4(r10);     // Catch: Throwable -> L31
        this.w = r10;     // Catch: Throwable -> L31
        MutableSharedFlow<List<ifa.f>> r6 = this.q;     // Catch: Throwable -> L31
        r0.L$0 = r5;     // Catch: Throwable -> L31
        r0.label = 2;     // Catch: Throwable -> L31
        if (r6.emit(r10, r0) != r2) goto L26;
        return r2;
    L26:
        r4 = r5;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r8);
        r5 = this.v;
        r0.L$0 = r5;
        r0.label = 1;
        if (r5.a(null, r0) != r2) goto L36;
        return r2;
    L7:
        r0 = new OmniDetailContentComponent$emitHeaderUpdate$1(this, r7);
        goto L8
    }

    public final void d4(List<ifa.f> r5) {
        Iterator<ifa.f> r0 = r5.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if ((r0.next() instanceof ifa.f.c) == true) goto L10;
        r2 = r2 + 1;
    L10:
        ifa.f.c r1 = G3();
        if (r1 != null) goto L15;
        if (r2 < 0) goto L21;
        ListProtector.remove(r5, r2);
        return;
    L21:
        return;
    L15:
        if (r2 < 0) goto L17;
        Object r3 = ListProtector.get(r5, r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.assistant.omnidetailpage.model.OmniTaskItem.Header");
        ifa.f.c r4 = (ifa.f.c) r3;
        r1.c = r4.c;
        r1.d = r4.d;
        r1.e = r4.e;
        r1.f = r4.f;
        r1.g = r4.g;
        Unit r6 = Unit.INSTANCE;
        ListProtector.set(r5, r2, r1);
        return;
    L17:
        ListProtector.add(r5, 0, r1);
        return;
    L9:
        r2 = -1;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.omnidetailpage.componment.m] */
    public final void onViewCreated(View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        ObricFragmentOmniDetailBinding r16 = (ObricFragmentOmniDetailBinding) this.m.getValue();
        if (r16 == null) goto L11;
        r16.g.setLayoutManager(new LinearLayoutManager(getContext()));
        SimpleItemAnimator r1 = r16.g.getItemAnimator();
        if ((r1 instanceof SimpleItemAnimator) == false) goto L7;
        SimpleItemAnimator r2 = r1;
    L8:
        if (r2 == null) goto L10;
        r2.setSupportsChangeAnimations(false);
    L10:
        TaskDetailAdapter r3 = new TaskDetailAdapter(this.o, new m(this));
        Function0<String> r4 = new n(this);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r3.c = r4;
        OmniDetailContentComponent$initViews$1$2$2 r5 = new OmniDetailContentComponent$initViews$1$2$2(this);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.d = r5;
        OmniDetailContentComponent$initViews$1$2$3 r6 = new OmniDetailContentComponent$initViews$1$2$3(this);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.e = r6;
        OmniDetailContentComponent$initViews$1$2$4 r7 = new OmniDetailContentComponent$initViews$1$2$4(this);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.f = r7;
        OmniDetailContentComponent$initViews$1$2$5 r8 = new OmniDetailContentComponent$initViews$1$2$5(this);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r3.g = r8;
        OmniDetailContentComponent$initViews$1$2$6 r9 = new OmniDetailContentComponent$initViews$1$2$6(this);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r3.h = r9;
        this.r = r3;
        r16.g.setAdapter(r3);
        ExposureTrackerExtKt.b(r16.g);
        r16.g.addOnScrollListener(new OmniDetailContentComponent$initRecyclerAutoScroll$1(this));
        goto L11
    L7:
        r2 = null;
    L11:
        fetchData();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailContentComponent$updateTitle$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailContentComponent$loadContentCache$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailContentComponent$updateContent$1(this, null), 3, null);
        ObricFragmentOmniDetailBinding r17 = (ObricFragmentOmniDetailBinding) this.m.getValue();
        if (r17 == null) goto L16;
        ImageView r18 = r17.h;
        if (r18 == null) goto L16;
        pla.j.h(r18, true);
    L16:
        OmniDetailInputFileCache.a.getClass();
        OmniDetailInputFileCache.e();
    }

    public static final List Y2(OmniDetailContentComponent r84, List r85) {
        r84.getClass();
        ArrayList r0 = new ArrayList(r85);
        ListIterator r1 = r0.listIterator();
    L4:
        if (r1.hasNext() == false) goto L56;
        Block r2 = (Block) r1.next();
        int r3 = r1.previousIndex();
        List r4 = r2.getAppendFields();
        int r5 = 0;
        if (r4 == null) goto L10;
        boolean r6 = true;
        if (r4.contains(5) != true) goto L10;
    L11:
        if (r6 == true) goto L12;
    L14:
        if (r5 >= r3) goto L19;
        if (Intrinsics.areEqual(((Block) ListProtector.get(r0, r5)).getBlockId(), r2.getBlockId()) == true) goto L20;
        r5 = r5 + 1;
    L20:
        if (r5 == (-1)) goto L4;
        Block r7 = (Block) ListProtector.get(r0, r5);
        int r8 = r2.getBlockType();
        BlockType r9 = BlockType.BLOCK_TYPE_TEXT;
        if (r8 != r9.getValue()) goto L54;
        if (r7.getBlockType() != r9.getValue()) goto L54;
        BlockContent r10 = r7.getContent();
        TextBlock r11 = null;
        if (r10 == null) goto L30;
        TextBlock r12 = r10.getTextBlock();
        if (r12 == null) goto L30;
        String r13 = r12.text;
    L31:
        String r14 = "";
        if (r13 != null) goto L34;
        r13 = "";
    L34:
        BlockContent r15 = r2.getContent();
        if (r15 == null) goto L39;
        TextBlock r16 = r15.getTextBlock();
        if (r16 == null) goto L39;
        String r17 = r16.text;
    L40:
        if (r17 == null) goto L43;
        r14 = r17;
    L43:
        String r18 = r13.concat(r14);
        BlockContent r19 = r7.getContent();
        if (r19 == null) goto L51;
        BlockContent r20 = r7.getContent();
        if (r20 == null) goto L50;
        TextBlock r21 = r20.getTextBlock();
        if (r21 == null) goto L50;
        r11 = TextBlock.copy$default(r21, r18, null, null, null, 0, 30, null);
    L50:
        BlockContent r110 = BlockContent.copy$default(r19, r11, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, -1, 31, null);
    L52:
        ListProtector.set(r0, r5, Block.copy$default(r7, 0, null, null, r110, false, null, null, null, 247, null));
        r1.remove();
        goto L4
    L51:
        r110 = null;
    L39:
        r17 = null;
    L30:
        r13 = null;
    L54:
        if (r2.getBlockType() == r9.getValue()) goto L4;
        ListProtector.set(r0, r5, r2);
        r1.remove();
        goto L4
    L19:
        r5 = -1;
        goto L20
    L12:
        r1.remove();
    L10:
        r6 = false;
        goto L11
    L56:
        return r0;
    }

    public static void a4(String r16, ICommerceMembershipService r17) {
        uz8.c r0 = r17.z(r16);
        if (r0 == null) goto L5;
        String r3 = r0.a;
    L7:
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L14:
        if ((true ^ r5) == true) goto L17;
        r3 = null;
    L17:
        if (r3 != null) goto L20;
        r3 = "answer_quota_limit";
    L20:
        if (r0 == null) goto L22;
        String r6 = r0.b;
    L23:
        if (r0 == null) goto L25;
        String r7 = r0.c;
    L26:
        if (r0 == null) goto L28;
        String r8 = r0.d;
    L29:
        if (r0 == null) goto L31;
        String r9 = r0.f;
    L33:
        if (r0 == null) goto L35;
        String r10 = r0.e;
    L36:
        ICommerceMembershipService.b.b(r17, r3, "obric_omni_task_detail", r6, r7, r8, r9, null, r10, null, null, null, null, 3904);
        return;
    L35:
        r10 = null;
        goto L36
    L31:
        r9 = null;
        goto L33
    L28:
        r8 = null;
        goto L29
    L25:
        r7 = null;
        goto L26
    L22:
        r6 = null;
        goto L23
    L9:
        if (r3.length() == 0) goto L12;
        r5 = false;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean z3(OmniDetailContentComponent r3, RecyclerView r4) {
        r3.getClass();
        RecyclerView.Adapter r5 = r4.getAdapter();
        if (r5 != null) goto L5;
        return true;
    L5:
        if (r5.getItemCount() == 0) goto L13;
        float r6 = ApWakeEvent.WALKING_START;
        Resources r1 = r4.getResources();
        if (((r4.computeVerticalScrollRange() - r4.computeVerticalScrollOffset()) - r4.computeVerticalScrollExtent()) <= ((int) (r6 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density))) goto L14;
        return false;
    L14:
        return true;
    L13:
        return true;
    }

    public static final void B3(OmniDetailContentComponent r7, List r8, boolean r9) {
        r7.getClass();
        ArrayList r0 = new ArrayList();
        Iterator r10 = r8.iterator();
    L3:
        boolean r2 = true;
        Pair r3 = null;
        if (r10.hasNext() == false) goto L38;
        Block r1 = (Block) r10.next();
        if (r1.getBlockType() != BlockType.BLOCK_TYPE_O_TIP_BLOCK.getValue()) goto L36;
        String r4 = r1.getBlockId();
        if (r4 == null) goto L36;
        if (r4.length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L17;
        r4 = null;
    L17:
        if (r4 == null) goto L36;
        BlockContent r6 = r1.getContent();
        if (r6 == null) goto L36;
        OTipBlock r11 = r6.getOTipBlock();
        if (r11 == null) goto L36;
        String r12 = r11.content;
        if (r12 == null) goto L36;
        String r13 = StringsKt.trim(r12).toString();
        if (r13 == null) goto L36;
        if (r13.length() > 0) goto L31;
        r2 = false;
    L31:
        if (r2 == true) goto L34;
        r13 = null;
    L34:
        if (r13 == null) goto L36;
        r3 = TuplesKt.to(r4, r13);
        goto L36
    L13:
        r5 = false;
    L36:
        if (r3 == null) goto L3;
        r0.add(r3);
        goto L3
    L38:
        ifa.e r14 = r7.V3();
        if (r14 != null) goto L41;
        return;
    L41:
        if ((!r0.isEmpty()) == false) goto L49;
        if (r9 == true) goto L44;
        r7.u.clear();
    L44:
        Iterator r15 = r0.iterator();
    L46:
        if (r15.hasNext() == false) goto L48;
        Pair r16 = (Pair) r15.next();
        r7.u.put((String) r16.component1(), (String) r16.component2());
        goto L46
    L48:
        Pair r17 = CollectionsKt.toList(r7.u.values());
    L57:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r14.c = r17;
        return;
    L49:
        if (r9 == false) goto L56;
        ifa.e r18 = r7.V3();
        if (r18 == null) goto L53;
        r3 = r18.c;
    L53:
        if (r3 != null) goto L55;
        r17 = CollectionsKt.emptyList();
        goto L57
    L55:
        r17 = r3;
        goto L57
    L56:
        r7.u.clear();
        r17 = CollectionsKt.emptyList();
        goto L57
    }

    public static void c4(View r3, ifa.a r4, String r5) {
        FLogger.a.e("OmniDetailContentComponent", "open header attachment failed, reason=" + r5 + ", displayKey=" + r4.a);
        t19.s r6 = t19.s.a;
        Context r7 = r3.getContext();
        String r8 = r3.getContext().getString(2131905676);
        r6.getClass();
        t19.s.c(r7, r8);
    }

    public static final Object m3(OmniDetailContentComponent r6, List r7, Continuation r8) {
        r6.getClass();
        if ((r8 instanceof OmniDetailContentComponent$emitBlockData$1) == false) goto L7;
        OmniDetailContentComponent$emitBlockData$1 r0 = (OmniDetailContentComponent$emitBlockData$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
    L27:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r10.unlock(null);
        return Unit.INSTANCE;
    L15:
        Throwable th = th;
        kotlinx.coroutines.sync.a r12 = r10;
    L33:
        r12.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r0.L$1;
        List r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r9);
        r12 = r13;
        r7 = r4;
    L37:
        r6.w = r7;     // Catch: Throwable -> L31
        MutableSharedFlow<List<ifa.f>> r14 = r6.q;     // Catch: Throwable -> L31
        r0.L$0 = r12;     // Catch: Throwable -> L31
        r0.L$1 = null;     // Catch: Throwable -> L31
        r0.label = 2;     // Catch: Throwable -> L31
        if (r14.emit(r7, r0) == r2) goto L40;
        r10 = r12;
        goto L27
    L40:
        return r2;
    L31:
        th = move-exception;
        th = th;
        goto L33
    L20:
        ResultKt.throwOnFailure(r9);
        r12 = r6.v;
        r0.L$0 = r7;
        r0.L$1 = r12;
        r0.label = 1;
        if (r12.a(null, r0) != r2) goto L37;
        return r2;
    L7:
        r0 = new OmniDetailContentComponent$emitBlockData$1(r6, r8);
        goto L8
    }

    public static final Object p3(OmniDetailContentComponent r7, String r8, Continuation r9) {
        Deferred<Message> r0 = r7.x;
        if (r0 != null) goto L6;
        r0 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(r7), Dispatchers.getIO(), null, new OmniDetailContentComponent$getEntryMessage$deferred$1(r8, null), 2, null);
        r7.x = r0;
    L6:
        return r0.await(r9);
    }

    public final void Z3(ifa.a r16, View r17, Function1<? super String, Unit> r18) {
        UplinkEntityContent r0 = r16.c.getUplinkEntityContent();
        if (r0 == null) goto L5;
        UplinkFileInfo r6 = r0.getUplinkFileInfo();
    L6:
        OmniDetailInputFileCache r1 = OmniDetailInputFileCache.a;
        AttachmentItem r2 = r16.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "item");
        String r3 = r2.getIdentifier();
        if (r3 != null) goto L9;
    L11:
        r3 = null;
    L12:
        if (r6 == null) goto L32;
        if (r3 == null) goto L32;
        String r4 = Q3(r16);
        if (r4 != null) goto L18;
        r4 = r1.c(r3);
    L18:
        if (r4 == null) goto L24;
        r18.invoke(r4);
        if (Intrinsics.areEqual(r16.d, r4) == true) goto L34;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailContentComponent$openOrDownloadHeaderAttachment$1(this, r16, r4, null), 3, null);
        return;
    L34:
        return;
    L24:
        if (NetworkUtils.isNetworkAvailable(r17.getContext()) == true) goto L28;
        t19.s.a.g(r17.getContext(), 2131908080, false);
        return;
    L28:
        if (this.z.add(r16.a) == true) goto L30;
        return;
    L30:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OmniDetailContentComponent$openOrDownloadHeaderAttachment$2(r17, r3, this, r16, r18, r6, null), 3, null);
        return;
    L32:
        c4(r17, r16, "file info or identifier is missing");
        return;
    L9:
        if ((!StringsKt.isBlank(r3)) == false) goto L11;
    L5:
        r6 = null;
        goto L6
    }

    public static final Object C3(OmniDetailContentComponent r6, String r7, String r8, Continuation r9) {
        List<ifa.a> r0 = r6.y;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        ifa.a r3 = (ifa.a) r2.next();
        if (Intrinsics.areEqual(r3.a, r7) == false) goto L12;
        OmniDetailInputFileCache r4 = OmniDetailInputFileCache.a;
        AttachmentItem r5 = r3.b;
        r4.getClass();
        AttachmentItem r10 = OmniDetailInputFileCache.g(r5, r8);
        UplinkFileEntity r11 = ic8.h.g(r10, r8);
        if (r11 != null) goto L11;
        r11 = r3.c;
    L11:
        String r12 = r3.a;
        Intrinsics.checkNotNullParameter(r12, "displayKey");
        Intrinsics.checkNotNullParameter(r10, "attachmentItem");
        Intrinsics.checkNotNullParameter(r11, "entity");
        r3 = new ifa.a(r12, r10, r11, r8);
    L12:
        r1.add(r3);
        goto L4
    L13:
        r6.y = r1;
        Object r13 = r6.H3(r9);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r13;
    L17:
        return Unit.INSTANCE;
    }

    public static final Object h3(OmniDetailContentComponent r21, List r22, boolean r23, Continuation r24) {
        List r1 = r22;
        r21.getClass();
        if ((r24 instanceof OmniDetailContentComponent$buildWrappedItems$1) == false) goto L7;
        OmniDetailContentComponent$buildWrappedItems$1 r3 = (OmniDetailContentComponent$buildWrappedItems$1) r24;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        List r8 = null;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        boolean r7 = r3.Z$0;
        List r9 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
        boolean r10 = r7;
        r1 = r9;
    L71:
        List r11 = (List) r2;
    L73:
        LinkedHashSet r12 = new LinkedHashSet();
        List r13 = r1;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
        int r16 = 0;
    L75:
        if (r15.hasNext() == false) goto L198;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L79;
        CollectionsKt.throwIndexOverflow();
    L79:
        Block r19 = (Block) r17;
        if (r19.getBlockType() == BlockType.BLOCK_TYPE_ATTACHMENT.getValue()) goto L82;
        List r110 = CollectionsKt.emptyList();
        LinkedHashSet r25 = r12;
        Iterator r26 = r15;
    L197:
        CollectionsKt.addAll(r14, r110);
        r12 = r25;
        r15 = r26;
        r16 = r18;
        r8 = null;
        goto L75
    L82:
        BlockContent r111 = r19.getContent();
        if (r111 == null) goto L87;
        AttachmentBlock r112 = r111.getAttachmentBlock();
        if (r112 == null) goto L87;
        List r113 = r112.getAttachments();
    L88:
        if (r113 != null) goto L90;
        r113 = CollectionsKt.emptyList();
    L90:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
        int r116 = 0;
    L92:
        if (r115.hasNext() == false) goto L196;
        Object r117 = r115.next();
        int r118 = r116 + 1;
        if (r116 >= 0) goto L96;
        CollectionsKt.throwIndexOverflow();
    L96:
        AttachmentItem r20 = (AttachmentItem) r117;
        String r119 = r19.getBlockId();
        String r120 = r20.getIdentifier();
        if (r120 != null) goto L99;
    L105:
        UploadFile r27 = r20.getFile();
        if (r27 == null) goto L115;
        String r28 = r27.getUri();
        if (r28 == null) goto L115;
        if ((!StringsKt.isBlank(r28)) == true) goto L113;
        r28 = null;
    L113:
        if (r28 == null) goto L115;
        String r29 = "file:".concat(r28);
    L156:
        if (r12.add(r29) == true) goto L158;
        LinkedHashSet r210 = r12;
        Iterator r211 = r15;
    L191:
        ifa.a r30 = null;
    L193:
        if (r30 == null) goto L195;
        r114.add(r30);
    L195:
        r12 = r210;
        r15 = r211;
        r116 = r118;
        goto L92
    L158:
        OmniDetailInputFileCache r31 = OmniDetailInputFileCache.a;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r20, "item");
        AttachmentExtra r121 = r20.getExtra();
        r210 = r12;
        if (r121 == null) goto L163;
        Map r32 = r121.getExtra();
        r211 = r15;
        if (r32 == null) goto L164;
        String r33 = (String) r32.get("o_omni_local_single_file_path");
    L165:
        String r34 = OmniDetailInputFileCache.f(r33, OmniDetailInputFileCache.b());
        if (r34 != null) goto L175;
        Intrinsics.checkNotNullParameter(r20, "item");
        String r35 = r20.getIdentifier();
        if (r35 != null) goto L171;
    L173:
        r35 = null;
    L174:
        r34 = r31.c(r35);
        goto L175
    L171:
        if ((!StringsKt.isBlank(r35)) == false) goto L173;
    L175:
        if (r34 == null) goto L180;
        AttachmentItem r36 = OmniDetailInputFileCache.g(r20, r34);
        if (r36 == null) goto L180;
        r20 = r36;
    L180:
        UplinkFileEntity r37 = ic8.h.g(r20, r34);
        if (r37 == null) goto L191;
        if (n1.d(r37) == false) goto L186;
    L192:
        r30 = new ifa.a(r29, r20, r37, r34);
        goto L193
    L186:
        if (n1.e(r37) == true) goto L192;
        if (n1.a(r37) == true) goto L192;
        if (n1.b(r37) == true) goto L192;
    L164:
        r33 = null;
        goto L165
    L163:
        r211 = r15;
    L115:
        UploadImage r38 = r20.getImage();
        if (r38 == null) goto L125;
        String r39 = r38.getUri();
        if (r39 == null) goto L125;
        if ((!StringsKt.isBlank(r39)) == true) goto L123;
        r39 = null;
    L123:
        if (r39 == null) goto L125;
        r29 = "image:".concat(r39);
    L126:
        if (r29 != null) goto L156;
        UploadFile r40 = r20.getFile();
        if (r40 == null) goto L137;
        String r41 = r40.getMd5();
        if (r41 == null) goto L137;
        if ((!StringsKt.isBlank(r41)) == true) goto L135;
        r41 = null;
    L135:
        if (r41 == null) goto L137;
        r29 = "md5:".concat(r41);
    L138:
        if (r29 != null) goto L156;
        UploadImage r42 = r20.getImage();
        if (r42 == null) goto L149;
        String r43 = r42.getMd5();
        if (r43 == null) goto L149;
        if ((!StringsKt.isBlank(r43)) == true) goto L147;
        r43 = null;
    L147:
        if (r43 == null) goto L149;
        r29 = "md5:".concat(r43);
    L150:
        if (r29 != null) goto L156;
        StringBuilder r44 = new StringBuilder("block:");
        if (r119 != null) goto L154;
        r119 = "";
    L154:
        r44.append(r119);
        r44.append(':');
        r44.append(r16);
        r44.append(':');
        r44.append(r116);
        r29 = r44.toString();
    L149:
        r29 = null;
    L137:
        r29 = null;
    L125:
        r29 = null;
        goto L126
    L99:
        if ((!StringsKt.isBlank(r120)) == false) goto L101;
        String r45 = r120;
    L102:
        if (r45 == null) goto L105;
        r29 = "identifier:".concat(r45);
        if (r29 != null) goto L156;
    L101:
        r45 = null;
        goto L102
    L196:
        r25 = r12;
        r26 = r15;
        r110 = r114;
    L87:
        r113 = r8;
        goto L88
    L198:
        r21.y = r14;
        ArrayList r46 = new ArrayList();
        ifa.f.c r47 = r21.G3();
        if (r47 == null) goto L201;
        r47.e = r10;
        r46.add(r47);
    L201:
        Object r48 = CollectionsKt.lastOrNull(r46);
        ArrayList r49 = new ArrayList();
        Iterator r50 = r13.iterator();
        boolean r51 = false;
        boolean r52 = false;
    L203:
        if (r50.hasNext() == false) goto L366;
        Block r53 = (Block) r50.next();
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_O_OMNI_DETAIL_PLAN_STATE.getValue()) goto L238;
        BlockContent r122 = r53.getContent();
        if (r122 == null) goto L209;
        OOmniDetailPlanStateBlock r123 = r122.getOOmniDetailPlanStateBlock();
    L210:
        if (r123 == null) goto L238;
        r51 = r53.isFinish();
        if (r51 == false) goto L223;
        BlockContent r54 = r53.getContent();
        if (r54 == null) goto L220;
        OOmniDetailPlanStateBlock r55 = r54.getOOmniDetailPlanStateBlock();
        if (r55 == null) goto L220;
        if (r55.getNotNeedLine() != true) goto L220;
        boolean r56 = true;
    L221:
        if (r56 == true) goto L223;
        r52 = true;
    L224:
        ifa.f r124 = new ifa.f.j(r53);
        BlockContent r57 = r53.getContent();
        if (r57 == null) goto L231;
        OOmniDetailPlanStateBlock r58 = r57.getOOmniDetailPlanStateBlock();
        if (r58 == null) goto L231;
        if (r58.getHasNotAnimation() == true) goto L231;
        boolean r59 = true;
    L232:
        if (r59 == false) goto L235;
        if (r10 == true) goto L235;
        boolean r60 = true;
    L236:
        r124.d = r60;
    L346:
        if (r124 == null) goto L363;
        r124.c = r52;
        r124.e = r10;
        r124.f = r51;
        if ((r124 instanceof ifa.f.b) == false) goto L350;
    L351:
        if (r10 == false) goto L355;
        if (r51 == false) goto L355;
        if (r52 == true) goto L355;
        boolean r61 = true;
    L356:
        if (r61 == true) goto L358;
    L360:
        int r62 = 0;
    L361:
        r124.g = r62;
    L362:
        r48 = r124;
    L364:
        if (r124 == null) goto L203;
        r49.add(r124);
        goto L203
    L358:
        if ((r48 instanceof ifa.f.j) == false) goto L360;
        r62 = 8;
    L355:
        r61 = false;
        goto L356
    L350:
        if ((r124 instanceof ifa.f.g) == false) goto L362;
    L363:
        r124 = null;
    L235:
        r60 = false;
    L231:
        r59 = false;
    L220:
        r56 = false;
    L223:
        r52 = false;
        goto L224
    L209:
        r123 = null;
    L238:
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L246;
        BlockContent r125 = r53.getContent();
        if (r125 == null) goto L242;
        TextBlock r126 = r125.getTextBlock();
    L243:
        if (r126 == null) goto L246;
        r124 = new ifa.f.b(r53);
        goto L346
    L242:
        r126 = null;
    L246:
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_QUICK_REPLY.getValue()) goto L266;
        BlockContent r127 = r53.getContent();
        if (r127 == null) goto L250;
        QuickReplyBlock r128 = r127.getQuickReplyBlock();
    L251:
        if (r128 == null) goto L266;
        BlockContent r129 = r53.getContent();
        if (r129 == null) goto L262;
        QuickReplyBlock r130 = r129.getQuickReplyBlock();
        if (r130 == null) goto L262;
        Integer r131 = r130.getStatus();
        int r132 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        if (r131 == null) goto L262;
        if (r131.intValue() != r132) goto L262;
        boolean r133 = true;
    L263:
        if (r133 == true) goto L266;
        r124 = new ifa.f.i(r53);
    L262:
        r133 = false;
        goto L263
    L250:
        r128 = null;
    L266:
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_O_OMNI_DETAIL_GUI_PROGRESS.getValue()) goto L279;
        BlockContent r134 = r53.getContent();
        if (r134 == null) goto L270;
        OOmniDetailGUIProcessBlock r135 = r134.getOOmniDetailGUIBlock();
    L271:
        if (r135 == null) goto L279;
        r124 = new ifa.f.h(r53);
        if (r53.isFinish() == true) goto L276;
        if (r10 == true) goto L276;
        boolean r63 = true;
    L277:
        r124.d = r63;
    L276:
        r63 = false;
        goto L277
    L270:
        r135 = null;
    L279:
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_O_SEARCH_QUERY_RESULT.getValue()) goto L287;
        BlockContent r136 = r53.getContent();
        if (r136 == null) goto L283;
        OSearchQueryResultBlock r137 = r136.getOSearchQueryResultBlock();
    L284:
        if (r137 == null) goto L287;
        r124 = new ifa.f.C0060f(r53);
        r124.d = !r10;
        goto L346
    L283:
        r137 = null;
    L287:
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_O_TIP_BLOCK.getValue()) goto L295;
        BlockContent r138 = r53.getContent();
        if (r138 == null) goto L291;
        OTipBlock r139 = r138.getOTipBlock();
    L292:
        if (r139 == null) goto L295;
    L345:
        r124 = null;
        goto L346
    L291:
        r139 = null;
    L295:
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_O_NORMAL_CLICK_INTENT.getValue()) goto L321;
        BlockContent r140 = r53.getContent();
        if (r140 == null) goto L299;
        OClickActionBlock r141 = r140.getOClickActionBlock();
    L300:
        if (r141 == null) goto L321;
        BlockContent r142 = r53.getContent();
        if (r142 == null) goto L304;
        OClickActionBlock r143 = r142.getOClickActionBlock();
    L305:
        if (r143 == null) goto L307;
        String r144 = r143.scene;
    L309:
        if (Intrinsics.areEqual(r144, "mode_setting") == false) goto L311;
        r124 = new ifa.f.g(r53);
        goto L346
    L311:
        com.obric.assistant.omnidetailpage.componment.a r64 = (com.obric.assistant.omnidetailpage.componment.a) s1a.d.a(r21).getAbility(com.obric.assistant.omnidetailpage.componment.a.class);
        if (r64 == null) goto L317;
        if (r143 == null) goto L315;
        String r145 = r143.scene;
    L316:
        r64.qJ(r145);
        goto L317
    L315:
        r145 = null;
    L317:
        d r65 = (d) s1a.d.a(r21).getAbility(d.class);
        if (r65 == null) goto L345;
        r65.QV(-1, -1);
        goto L345
    L307:
        r144 = null;
        goto L309
    L304:
        r143 = null;
        goto L305
    L299:
        r141 = null;
    L321:
        if (r53.getBlockType() != BlockType.BLOCK_TYPE_O_TASK_INFO.getValue()) goto L345;
        BlockContent r146 = r53.getContent();
        if (r146 == null) goto L325;
        OTaskInfo r147 = r146.getOTaskInfo();
    L326:
        if (r147 == null) goto L345;
        d r148 = (d) s1a.d.a(r21).getAbility(d.class);
        if (r148 == null) goto L345;
        BlockContent r149 = r53.getContent();
        long r150 = 0;
        if (r149 == null) goto L336;
        OTaskInfo r151 = r149.getOTaskInfo();
        if (r151 == null) goto L336;
        Long r152 = r151.getStartTime();
        if (r152 == null) goto L336;
        long r153 = r152.longValue();
    L337:
        BlockContent r66 = r53.getContent();
        if (r66 == null) goto L344;
        OTaskInfo r67 = r66.getOTaskInfo();
        if (r67 == null) goto L344;
        Long r68 = r67.getEndTime();
        if (r68 == null) goto L344;
        r150 = r68.longValue();
    L344:
        r148.QV(r153, r150);
    L336:
        r153 = 0;
        goto L337
    L325:
        r147 = null;
        goto L326
    L366:
        r46.addAll(r49);
        List r69 = r11;
        ArrayList r0 = new ArrayList();
        Iterator r70 = r69.iterator();
    L368:
        if (r70.hasNext() == false) goto L372;
        Object r71 = r70.next();
        if ((r71 instanceof ifa.d.b) == false) goto L368;
        r0.add(r71);
        goto L368
    L372:
        ArrayList r72 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r73 = r0.iterator();
    L374:
        if (r73.hasNext() == false) goto L376;
        r72.add(((ifa.d.b) r73.next()).b);
        goto L374
    L376:
        ArrayList r74 = new ArrayList();
        Iterator r75 = r69.iterator();
    L378:
        if (r75.hasNext() == false) goto L411;
        ifa.d r76 = (ifa.d) r75.next();
        if ((r76 instanceof ifa.d.a) == true) goto L381;
        if ((r76 instanceof ifa.d.b) == false) goto L410;
        if ((!r74.isEmpty()) == false) goto L408;
        ifa.d.b r77 = (ifa.d.b) CollectionsKt.first(r74);
        ifa.d.b r78 = (ifa.d.b) r76;
        String r154 = r77.a.getBlockId();
        String r155 = r78.a.getBlockId();
        if (r154 != null) goto L389;
    L392:
        boolean r156 = true;
    L393:
        if (r156 == true) goto L403;
        if (r155 != null) goto L396;
    L399:
        boolean r157 = true;
    L400:
        if (r157 == true) goto L403;
        boolean r79 = Intrinsics.areEqual(r154, r155);
    L406:
        if (r79 == true) goto L408;
        D3(r74, r46, r72, r10, r51);
        goto L408
    L396:
        if (StringsKt.isBlank(r155) == true) goto L399;
        r157 = false;
    L403:
        if (r77.a != r78.a) goto L405;
        r79 = true;
        goto L406
    L405:
        r79 = false;
        goto L406
    L389:
        if (StringsKt.isBlank(r154) == true) goto L392;
        r156 = false;
    L408:
        r74.add(r76);
        goto L378
    L410:
        throw new NoWhenBranchMatchedException();
    L381:
        D3(r74, r46, r72, r10, r51);
        ifa.d.a r80 = (ifa.d.a) r76;
        ifa.f.d r81 = new ifa.f.d(r80.a, r80.b);
        r81.e = r10;
        r81.c = false;
        r81.f = r51;
        r46.add(r81);
        goto L378
    L411:
        D3(r74, r46, r72, r10, r51);
        Object r82 = r46;
    L412:
        return r82;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if ((r1 instanceof Collection) == true) goto L17;
    L19:
        Iterator r83 = r22.iterator();
    L21:
        if (r83.hasNext() == false) goto L66;
        Block r84 = (Block) r83.next();
        int r85 = r84.getBlockType();
        if (r85 != BlockType.BLOCK_TYPE_LOCAL_FILE.getValue()) goto L31;
        BlockContent r86 = r84.getContent();
        if (r86 == null) goto L27;
        LocalFileBlock r87 = r86.getLocalFileBlock();
    L28:
        if (r87 != null) goto L62;
    L63:
        boolean r88 = false;
    L64:
        if (r88 == false) goto L21;
        boolean r89 = true;
    L67:
        if (r89 == false) goto L72;
        CoroutineDispatcher r90 = Dispatchers.getIO();
        OmniDetailContentComponent$buildWrappedItems$localEntries$1 r91 = new OmniDetailContentComponent$buildWrappedItems$localEntries$1(r21, r1, null);
        r3.L$0 = r1;
        r10 = r23;
        r3.Z$0 = r10;
        r3.label = 1;
        r2 = BuildersKt.withContext(r90, r91, r3);
        r82 = r5;
        if (r2 != r5) goto L71;
    L72:
        r10 = r23;
        r11 = CollectionsKt.emptyList();
    L62:
        r88 = true;
        goto L64
    L27:
        r87 = null;
        goto L28
    L31:
        if (r85 != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L63;
        BlockContent r92 = r84.getContent();
        if (r92 == null) goto L37;
        CreationBlock r93 = r92.getCreationBlock();
        if (r93 == null) goto L37;
        List r94 = r93.creations;
    L38:
        if (r94 != null) goto L40;
        r94 = CollectionsKt.emptyList();
    L40:
        List r95 = r94;
        if ((r95 instanceof Collection) == true) goto L43;
    L45:
        Iterator r96 = r95.iterator();
    L47:
        if (r96.hasNext() == false) goto L63;
        CreationItem r97 = (CreationItem) r96.next();
        Integer r158 = r97.type;
        if (r158 != null) goto L52;
    L53:
        Integer r98 = r97.type;
        if (r98 != null) goto L57;
    L59:
        boolean r99 = false;
    L61:
        if (r99 == false) goto L47;
    L57:
        if (r98.intValue() != 4) goto L59;
    L60:
        r99 = true;
        goto L61
    L52:
        if (r158.intValue() == 3) goto L60;
    L43:
        if (r95.isEmpty() == false) goto L45;
    L37:
        r94 = null;
    L66:
        r89 = false;
        goto L67
    L17:
        if (r22.isEmpty() == false) goto L19;
    L7:
        r3 = new OmniDetailContentComponent$buildWrappedItems$1(r21, r24);
        goto L8
    }

    public static final void D3(List<ifa.d.b> r4, List<ifa.f> r5, List<? extends ifa.c> r6, boolean r7, boolean r8) {
        ArrayList r0 = (ArrayList) r4;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        Block r1 = ((ifa.d.b) CollectionsKt.first(r4)).a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r9 = r4.iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        r2.add(((ifa.d.b) r9.next()).b);
        goto L7
    L9:
        ifa.f.e r10 = new ifa.f.e(r1, r2, r6);
        r10.e = r7;
        r10.c = false;
        r10.f = r8;
        ((ArrayList) r5).add(r10);
        r0.clear();
    }
}
