package com.larus.bmhome.chat.markdown.code;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageWebpLoadingBgView;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.bmhome.web.IAiChatHostWebService;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui.MaxHeightLinearLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.MarkdownRenderCodeViewLayoutBinding;
import com.larus.mainbot.impl.databinding.MarkdownSubRenderCodeViewLayoutBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.platform.api.u2;
import com.larus.platform.service.c1;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import hq9.e3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 Ò\u00012\u00020\u0001:\u0002Ò\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ¸\u0003\u0010f\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u00182\b\u0010g\u001a\u0004\u0018\u0001092\b\b\u0002\u0010h\u001a\u00020\u000e2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\u0010j\u001a\u0004\u0018\u00010k2:\b\u0002\u0010l\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00152\u0012\b\u0002\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u0001042\u0012\b\u0002\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u0001042%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r2>\b\u0002\u0010\u001a\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00152\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010m\u001a\u0004\u0018\u0001012 \b\u0002\u00103\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010%\u0018\u0001042\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \b\u0002\u0010G\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010H\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00152\b\b\u0002\u0010(\u001a\u00020\u000e¢\u0006\u0002\u0010nJ!\u0010o\u001a\u00020\u000f2\b\u0010X\u001a\u0004\u0018\u00010\u00072\b\u0010p\u001a\u0004\u0018\u00010qH\u0002¢\u0006\u0002\u0010rJa\u0010s\u001a\u00020\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010h\u001a\u00020\u000e2\b\u0010i\u001a\u0004\u0018\u00010\u001b2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010j\u001a\u0004\u0018\u00010k2\u0010\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u0001042\u0010\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u000104H\u0003¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u00020\u000fH\u0002J\b\u0010v\u001a\u00020\u000eH\u0002J\u001c\u0010w\u001a\u00020\u000f2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\u0010\u0010y\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020\u0018H\u0002J\u0010\u0010{\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020\u0007H\u0002J\u0006\u0010|\u001a\u00020\u0018J\u0006\u0010}\u001a\u00020\u0018J\u0006\u0010~\u001a\u00020\u000eJp\u0010\u007f\u001a\u00020\u000f2\u0007\u0010\u0080\u0001\u001a\u00020\u00182\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u000e2\u0017\b\u0002\u0010\u0082\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010%2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010'\u001a\u00020\u000e2\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010\u0086\u0001J\t\u0010\u0087\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u0088\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u0089\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008a\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008b\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008c\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u008e\u0001\u001a\u00020\u000fH\u0002J\u001a\u0010\u008f\u0001\u001a\u00020\u000f2\u0007\u0010\u0090\u0001\u001a\u00020H2\u0006\u0010g\u001a\u000209H\u0002J\t\u0010\u0091\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u0092\u0001\u001a\u00020\u000fH\u0002J'\u0010\u0093\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0015\u0010\u0082\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010%J\t\u0010\u0094\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u0095\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u0096\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u0097\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u0098\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u0099\u0001\u001a\u00020\u000fH\u0002J%\u0010\u009a\u0001\u001a\u00020\u00072\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u009d\u0001J\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u009f\u0001J\u001b\u0010 \u0001\u001a\u00020\u000f2\u0007\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010¢\u0001\u001a\u00020\u000eH\u0002J\t\u0010£\u0001\u001a\u00020\u000fH\u0002J)\u0010¤\u0001\u001a\u00020\u000e2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0015\u0010\u0082\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010%H\u0002J\u0012\u0010¨\u0001\u001a\u00020\u000f2\u0007\u0010©\u0001\u001a\u00020HH\u0002J\t\u0010ª\u0001\u001a\u00020\u000fH\u0002J\u0015\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\u0007\u0010\u00ad\u0001\u001a\u00020HH\u0002J%\u0010®\u0001\u001a\u00020\u000f2\u0007\u0010\u0090\u0001\u001a\u00020H2\u0007\u0010\u00ad\u0001\u001a\u00020H2\b\u0010¯\u0001\u001a\u00030°\u0001H\u0002J(\u0010±\u0001\u001a\u000f\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020q0²\u00012\u0007\u0010\u0090\u0001\u001a\u00020H2\u0007\u0010\u00ad\u0001\u001a\u00020HH\u0002J\u0013\u0010³\u0001\u001a\u00020\u000f2\b\u0010´\u0001\u001a\u00030¬\u0001H\u0002J\t\u0010µ\u0001\u001a\u00020\u000fH\u0002J\u001a\u0010¶\u0001\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0007\u0010·\u0001\u001a\u00020\u0018H\u0002J\t\u0010¸\u0001\u001a\u00020\u000fH\u0002J\t\u0010¹\u0001\u001a\u00020\u000fH\u0002J\t\u0010º\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010»\u0001\u001a\u00020\u000f2\u0007\u0010¼\u0001\u001a\u00020.H\u0002J\t\u0010½\u0001\u001a\u00020\u000fH\u0002J\t\u0010¾\u0001\u001a\u00020\u000fH\u0002J\u0018\u0010¿\u0001\u001a\u00020\u000f2\t\u0010À\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010Á\u0001J\u001a\u0010Â\u0001\u001a\u00020\u000f2\u000b\b\u0001\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010Á\u0001J\u0018\u0010Ä\u0001\u001a\u00020\u000f2\t\u0010Å\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010Á\u0001J\t\u0010Æ\u0001\u001a\u00020\u000fH\u0002J\t\u0010Ç\u0001\u001a\u00020\u000fH\u0002J\u0011\u0010È\u0001\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0007\u0010É\u0001\u001a\u00020\u000fJ\t\u0010Ê\u0001\u001a\u00020\u000fH\u0002J\t\u0010Ë\u0001\u001a\u00020\u000fH\u0002Je\u0010Ì\u0001\u001a\u00020\u000e2\u0007\u0010\u0080\u0001\u001a\u00020\u00182\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u000e2\u0015\u0010\u0082\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010%2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010Í\u0001J\u0007\u0010Î\u0001\u001a\u00020\u0018J\t\u0010Ï\u0001\u001a\u00020\u000eH\u0002J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0007\u0010Ð\u0001\u001a\u00020\u000eJ\u0015\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u00182\b\u0010A\u001a\u0004\u0018\u00010BH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000RD\u0010\u001a\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0012\u0010+\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010,\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u00103\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010%\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010G\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010H\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bL\u0010MR\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010§\u0001\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ó\u0001"}, d2 = {"Lcom/larus/bmhome/chat/markdown/code/ClickableMarkdownCodeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "codePreviewer", "Lcom/larus/bmhome/chat/markdown/code/MarkdownCodePreviewer;", "onFullscreenListener", "Lkotlin/Function1;", "", "", "refreshWidget", "Lkotlin/ParameterName;", "name", "isPreview", "clickListenerCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/chat/markdown/code/CodeClickActionEnum;", "action", "", "cardType", "onRenderFinish", "", "timeCost", "isSuccess", "isInit", "isFold", "Ljava/lang/Boolean;", "isInPreviewTab", "currentCode", "currentLanguage", "currentExtraMap", "", "currentTitle", "enableDynamicCodeFence", "codeDetailDefaultNoWrap", "currentAddedLines", "Ljava/lang/Integer;", "currentDeletedLines", "isFinish", "currentRenderStatus", "Lcom/larus/bmhome/chat/markdown/code/CodeRenderStatus;", "cardId", "uiConfig", "Lcom/larus/bmhome/chat/markdown/code/module/MarkdownCodeViewUIConfig;", "initTimeStamp", "eventExtra", "Lkotlin/Function0;", "", "mobCurrentPage", "messageId", "message", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "shareMessageListAdapter", "Lcom/larus/chat/api/ShareMessageListAdapterWrapper;", "botId", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "getBotModel", "Lcom/larus/im/bean/bot/BotModel;", "getChatParam", "Lcom/larus/bmhome/chat/ChatParam;", "codeSelectionHandler", "Landroid/view/View;", "needPreload", "highlight", "Lio/noties/markwon/syntax/Prism4jSyntaxHighlight;", "getHighlight", "()Lio/noties/markwon/syntax/Prism4jSyntaxHighlight;", "highlight$delegate", "Lkotlin/Lazy;", "highlightDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "highlightScope", "Lkotlinx/coroutines/CoroutineScope;", "MAX_LINE", "DEFAULT_MAX_HEIGHT", "DEFAULT_PURE_IMAGE_MAX_HEIGHT", "LOADING_PURE_IMAGE_HEIGHT", "maxHeight", "binding", "Lcom/larus/mainbot/impl/databinding/MarkdownRenderCodeViewLayoutBinding;", "renderSubBinding", "Lcom/larus/mainbot/impl/databinding/MarkdownSubRenderCodeViewLayoutBinding;", "loadingJob", "Lkotlinx/coroutines/Job;", "webpLoadingBgInited", "renderRetryCount", "markDownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/larus/bmhome/chat/markdown/code/render/CodeRenderResponse;", "init", "data", "isImmersive", "uniqueKey", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onClickListener", "markdownCodeViewUIConfig", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;ZLjava/lang/Long;Lcom/ixigua/lib/track/ITrackNode;Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/markdown/code/module/MarkdownCodeViewUIConfig;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lcom/larus/bmhome/chat/api/MessageAdapter;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;Lcom/larus/chat/api/ShareMessageListAdapterWrapper;Lkotlin/jvm/functions/Function2;Z)V", "initViews", "textSize", "", "(Ljava/lang/Integer;Ljava/lang/Float;)V", "initClickListeners", "(Ljava/lang/String;ZLjava/lang/Long;Lcom/ixigua/lib/track/ITrackNode;Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "saveRenderImage", "needStoragePermission", "requestStoragePermission", "block", "copyCode", "clickFrom", "initLayoutChangeListener", "getLanguage", "getCode", "getFinishState", "bindData", "code", "language", "extraMap", "title", "addedLines", "deletedLines", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "tryPreloadWebView", "isLatestMsg", "refreshCopyButton", "refreshDownloadButton", "refreshRenderContainer", "setupSwitchRender", "setupPureImageRender", "bindCodeRenderLongPressMenuIfFinished", "showCodeRenderLongPressMenu", "view", "setupNormalCode", "refreshChangedLines", "canShowRenderTab", "isPureModeRender", "isPureModeRenderByHTML", "isPureModeRenderByLynx", "initWebpLoadingBgIfNeeded", "applyRenderCorners", "applyRenderImageScaleType", "computeCloudRenderHeight", "imageWidth", "imageHeight", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "computeCachedRenderHeight", "()Ljava/lang/Integer;", "updatePureImageContainerHeight", "targetHeight", "notifyRefresh", "applyLoadingAppearance", "shouldUseNormalHtmlStyle", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "currentLynxContainerId", "createLynxView", "containerView", "captureAndSaveLynxBitmap", "generateBitmapFromLynxView", "Landroid/graphics/Bitmap;", "rootView", "drawTextureViews", "canvas", "Landroid/graphics/Canvas;", "getViewPositionInRoot", "Lkotlin/Pair;", "saveLynxBitmapToAlbum", "bitmap", "copyRenderImageToClipboard", "blockFileEgressIfNeeded", "entry", "refreshCodeRenderView", "requestCloudRenderImage", "applyFailedAppearance", "updateCodeRenderStatus", "status", "refreshPreviewButton", "refreshGravity", "setupMarkdownCodeLinearLayoutRes", "backgroundRes", "(Ljava/lang/Integer;)V", "setupCodeViewSeparatorColor", "color", "setupExpandAllBackgroundResult", "expandAllBackgroundResult", "refreshText", "refreshHafFoldStatus", "refreshRenderTab", "onRecycle", "startLoading", "cancelLoading", "needRefresh", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Z", "getCardType", "enableAsync", "needShowCodeArea", "getCurrentPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ClickableMarkdownCodeView extends FrameLayout {
    public static final List<String> H0 = null;
    public static final List<String> L0 = null;
    public static final Lazy<Boolean> P0 = null;
    public static final Lazy<Boolean> V0 = null;
    public com.larus.bmhome.chat.api.q0.a A;
    public ry8.d B;
    public String C;
    public by7.e D;
    public Function0<BotModel> E;
    public Function0<ChatParam> F;
    public Function2<? super View, ? super Message, Boolean> G;
    public boolean H;
    public final Lazy I;
    public final ExecutorCoroutineDispatcher J;
    public final CoroutineScope K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public int P;
    public MarkdownRenderCodeViewLayoutBinding Q;
    public MarkdownSubRenderCodeViewLayoutBinding R;
    public Job S;
    public boolean T;
    public int U;
    public final com.larus.bmhome.chat.api.z V;
    public final w W;
    public final t0 a;
    public r b;
    public Function1<? super Boolean, Unit> c;
    public Function2<? super CodeClickActionEnum, ? super String, Unit> d;
    public Function2<? super Long, ? super Boolean, Unit> e;
    public boolean f;
    public Boolean g;
    public Boolean h;
    public String i;
    public String j;
    public Map<String, String> k;
    public e4 k0;
    public String l;
    public boolean m;
    public boolean n;
    public Integer o;
    public Integer p;
    public String p0;
    public boolean q;
    public CodeRenderStatus r;
    public String s;
    public hh8.a t;
    public long u;
    public Function0<? extends Map<String, ? extends Object>> v;
    public String w;
    public String x;
    public Message y;
    public com.larus.bmhome.chat.api.q0 z;

    public static final class a {
        public static boolean c() {
            String r0 = PollingConfigService.a.f("main_bot_downgrade");
            if (r0 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            return false;
        L12:
            if (new JSONObject(r0).optInt("hide_cr_preview", 0) == 1) goto L16;
            return false;
        L16:
            return true;
        L5:
            if (r0.length() == 0) goto L8;
            r3 = false;
            goto L9
        }

        public static boolean a(String r6) {
            Intrinsics.checkNotNullParameter(r6, "language");
            if (b(r6) == false) goto L6;
            return true;
        L6:
            if (c() == false) goto L8;
            return false;
        L8:
            AppHost.Companion r0 = AppHost.a;
            if (r0.isOversea() == true) goto L11;
            List<String> r3 = CollectionsKt.listOf("html");
        L13:
            if (((Boolean) ClickableMarkdownCodeView.P0.getValue()).booleanValue() == true) goto L15;
        L29:
            List<String> r4 = r3;
            if ((r4 instanceof Collection) == true) goto L32;
        L34:
            Iterator r1 = r4.iterator();
        L36:
            if (r1.hasNext() == false) goto L40;
            if (StringsKt.startsWith$default(r6, (String) r1.next(), false, 2, null) == false) goto L36;
            boolean r7 = true;
        L41:
            if (r7 == false) goto L48;
            AiChatHostWebService.a.getClass();
            if (((IAiChatHostWebService) AiChatHostWebService.b.getValue()) == null) goto L45;
            boolean r8 = true;
        L46:
            if (r8 == false) goto L48;
            return true;
        L45:
            r8 = false;
        L48:
            return false;
        L40:
            r7 = false;
            goto L41
        L32:
            if (r4.isEmpty() == false) goto L34;
        L15:
            if (r0.isOversea() == false) goto L17;
            List<String> r2 = ClickableMarkdownCodeView.H0;
        L18:
            r3 = r2;
            z2 r5 = z2.a;
            List r9 = r5.getMarkdownCodeRenderConfig().b;
            if (r9 != null) goto L21;
        L23:
            boolean r10 = false;
        L24:
            if (r10 == false) goto L29;
            List<String> r11 = r5.getMarkdownCodeRenderConfig().b;
            if (r11 != null) goto L28;
            r11 = CollectionsKt.emptyList();
        L28:
            r3 = r11;
            goto L29
        L21:
            if ((!r9.isEmpty()) != true) goto L23;
            r10 = true;
            goto L24
        L17:
            r2 = ClickableMarkdownCodeView.L0;
            goto L18
        L11:
            r3 = CollectionsKt.emptyList();
            goto L13
        }

        public static boolean b(String r4) {
            boolean r0 = true;
            if (r4 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            return false;
        L11:
            e3 r3 = z2.a.getMarkdownCodeRenderConfig();
            String r5 = r3.h;
            if (r5 != null) goto L14;
        L17:
            boolean r6 = true;
        L18:
            if (r6 == false) goto L20;
            return false;
        L20:
            List r7 = r3.i;
            List r8 = r7;
            if (r8 != null) goto L23;
        L26:
            if (r0 == false) goto L29;
            return false;
        L29:
            return r7.contains(r4);
        L23:
            if (r8.isEmpty() == true) goto L26;
            r0 = false;
            goto L26
        L14:
            if (r5.length() == 0) goto L17;
            r6 = false;
            goto L18
        L5:
            if (r4.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CodeRenderStatus.values().length];
            r0[CodeRenderStatus.Success.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CodeRenderStatus.Failed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CodeRenderStatus.Loading.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CodeRenderStatus.Placeholder.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c extends BaseControllerListener<Object> {
        public final /* synthetic */ ClickableMarkdownCodeView a;
        public final /* synthetic */ String b;

        public c(ClickableMarkdownCodeView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailure(String r5, Throwable r6) {
            super.onFailure(r5, r6);
            ClickableMarkdownCodeView r7 = this.a;
            CodeRenderStatus r8 = CodeRenderStatus.Failed;
            List<String> r0 = ClickableMarkdownCodeView.H0;
            r7.w(r8);
            FLogger.a.i("MarkdownCodeView", "ClickableMarkdownCodeView observer url is failed, url: " + this.b + ", timeCost: " + (System.currentTimeMillis() - this.a.u));
            Function2<? super Long, ? super Boolean, Unit> r9 = this.a.e;
            if (r9 == null) goto L6;
            r9.invoke(Long.valueOf(System.currentTimeMillis() - this.a.u), Boolean.FALSE);
            return;
        }

        public final void onSubmit(String r1, Object r2) {
            super.onSubmit(r1, r2);
        }

        public final void onFinalImageSet(String r3, Object r4, Animatable r5) {
            super.onFinalImageSet(r3, r4, r5);
            ClickableMarkdownCodeView r6 = this.a;
            CodeRenderStatus r7 = CodeRenderStatus.Success;
            List<String> r8 = ClickableMarkdownCodeView.H0;
            r6.w(r7);
            Function2<? super Long, ? super Boolean, Unit> r9 = this.a.e;
            if (r9 == null) goto L5;
            r9.invoke(Long.valueOf(System.currentTimeMillis() - this.a.u), Boolean.TRUE);
        L5:
            this.a.r();
        }
    }

    public ClickableMarkdownCodeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ClickableMarkdownCodeView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void p() {
        this.G = null;
        CoroutineScopeKt.cancel$default(this.K, null, 1, null);
        this.J.close();
        g();
        this.a.b.removeObserver(this.W);
        String r1 = this.x;
        if (r1 == null) goto L5;
        com.larus.bmhome.chat.detail.code.preview.m.a.getClass();
        com.larus.bmhome.chat.detail.code.preview.m.b(r1);
    L5:
        this.H = false;
        String r2 = this.p0;
        if (r2 == null) goto L8;
        eh8.a.b(r2);
    L8:
        this.p0 = null;
        this.T = false;
        this.U = 0;
    }

    static {
        List<String> r0 = CollectionsKt.listOf(new String[]{"mindmap", "mermaid", "vega-lite", "svg"});
        H0 = r0;
        L0 = CollectionsKt.plus(r0, "html");
        P0 = LazyKt.lazy(new b0());
        V0 = LazyKt.lazy(new c0());
    }

    private final etc.b getHighlight() {
        return (etc.b) this.I.getValue();
    }

    public final void g() {
        Job r0 = this.S;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        MarkdownSubRenderCodeViewLayoutBinding r1 = this.R;
        if (r1 == null) goto L11;
        ProgressBar r2 = r1.h;
        if (r2 == null) goto L12;
        r2.setProgress(0);
        return;
    L12:
        return;
    }

    public final String getCardType() {
        if (f(this.j, this.k) == 0) goto L5;
        return "code_render";
    L5:
        return "code";
    }

    public final void h() {
        MarkdownSubRenderCodeViewLayoutBinding r0 = this.R;
        if (r0 == null) goto L5;
        FrameLayout r1 = r0.n;
    L7:
        if (r1 != null) goto L26;
        FLogger.a.w("MarkdownCodeView", "captureAndSaveLynxBitmap: rootView is null");
        t19.s r2 = t19.s.a;
        Context r3 = getContext();
        r2.getClass();
        t19.s.b(r3, 2131908982, false);
        return;
    L26:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
        Object r4 = Result.constructor-impl(l(r1));     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r4);
        if (r6 == null) goto L18;
        FLogger.a.e("MarkdownCodeView", "captureAndSaveLynxBitmap fail", r6);
    L18:
        if (Result.isFailure-impl(r4) == false) goto L20;
        r4 = null;
    L20:
        Bitmap r7 = (Bitmap) r4;
        if (r7 != null) goto L24;
        FLogger.a.w("MarkdownCodeView", "captureAndSaveLynxBitmap: bitmap is null");
        t19.s r8 = t19.s.a;
        Context r9 = getContext();
        r8.getClass();
        t19.s.b(r9, 2131908982, false);
        return;
    L24:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ClickableMarkdownCodeView$saveLynxBitmapToAlbum$1(r7, this, null), 3, null);
        return;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final boolean o() {
        if (f(this.j, this.k) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final void q() {
        MarkdownRenderCodeViewLayoutBinding r1 = this.Q;
        if (r1 == null) goto L209;
        final String r5 = "";
        if (this.R != null) goto L86;
        LayoutInflater r2 = LayoutInflater.from(getContext());
        FrameLayout r7 = r1.p;
        if (r7 == null) goto L85;
        r2.inflate(2131563623, r7);
        int r3 = 2131379557;
        ImageWebpLoadingBgView r8 = (ImageWebpLoadingBgView) ViewBindings.findChildViewById(r7, 2131379557);
        if (r8 == null) goto L83;
        r3 = 2131379558;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r7, 2131379558);
        if (r9 == null) goto L83;
        r3 = 2131379559;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r7, 2131379559);
        if (r10 == null) goto L83;
        r3 = 2131379560;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r7, 2131379560);
        if (r11 == null) goto L83;
        r3 = 2131379562;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r7, 2131379562);
        if (r12 == null) goto L83;
        r3 = 2131379563;
        CodeRenderGestureLayout r15 = (CodeRenderGestureLayout) ViewBindings.findChildViewById(r7, 2131379563);
        if (r15 == null) goto L83;
        r3 = 2131379565;
        ProgressBar r14 = (ProgressBar) ViewBindings.findChildViewById(r7, 2131379565);
        if (r14 == null) goto L83;
        r3 = 2131379566;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r7, 2131379566);
        if (r16 == null) goto L83;
        r3 = 2131379567;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r7, 2131379567);
        if (r17 == null) goto L83;
        r3 = 2131379568;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r7, 2131379568);
        if (r18 == null) goto L83;
        r3 = 2131379569;
        SimpleDraweeView r19 = ViewBindings.findChildViewById(r7, 2131379569);
        if (r19 == null) goto L83;
        r3 = 2131379570;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r7, 2131379570);
        if (r20 == null) goto L83;
        r3 = 2131379571;
        FrameLayout r21 = (FrameLayout) ViewBindings.findChildViewById(r7, 2131379571);
        if (r21 == null) goto L83;
        this.R = new MarkdownSubRenderCodeViewLayoutBinding(r7, r8, r9, r10, r11, r12, r15, r14, r16, r17, r18, r19, r20, r21);
        e1.d(r15, new d0(this));
        MarkdownSubRenderCodeViewLayoutBinding r4 = this.R;
        if (r4 == null) goto L46;
        TextView r6 = r4.f;
        if (r6 == null) goto L46;
        Context r13 = r6.getContext();
        if (r13 == null) goto L43;
        String r22 = r13.getString(2131906292);
        if (r22 == null) goto L43;
    L44:
        r6.setText(r22);
        e1.d(r6, new e0(this));
    L43:
        r22 = "";
    L46:
        if (a.b(this.j) == false) goto L62;
        MarkdownSubRenderCodeViewLayoutBinding r23 = this.R;
        if (r23 == null) goto L52;
        SimpleDraweeView r24 = r23.l;
        if (r24 == null) goto L52;
        r24.setVisibility(8);
    L52:
        MarkdownSubRenderCodeViewLayoutBinding r25 = this.R;
        if (r25 == null) goto L57;
        FrameLayout r26 = r25.n;
        if (r26 == null) goto L57;
        r26.setVisibility(0);
    L57:
        MarkdownSubRenderCodeViewLayoutBinding r27 = this.R;
        if (r27 == null) goto L77;
        TextView r28 = r27.f;
        if (r28 == null) goto L77;
        r28.setVisibility(8);
    L77:
        MarkdownSubRenderCodeViewLayoutBinding r29 = this.R;
        if (r29 == null) goto L86;
        CodeRenderGestureLayout r30 = r29.g;
        if (r30 == null) goto L86;
        r30.setBlockParentHorizontalScroll(a.b(this.j));
        goto L86
    L62:
        MarkdownSubRenderCodeViewLayoutBinding r31 = this.R;
        if (r31 == null) goto L67;
        SimpleDraweeView r32 = r31.l;
        if (r32 == null) goto L67;
        r32.setVisibility(0);
    L67:
        MarkdownSubRenderCodeViewLayoutBinding r33 = this.R;
        if (r33 == null) goto L72;
        FrameLayout r34 = r33.n;
        if (r34 == null) goto L72;
        r34.setVisibility(8);
    L72:
        MarkdownSubRenderCodeViewLayoutBinding r35 = this.R;
        if (r35 == null) goto L77;
        TextView r36 = r35.f;
        if (r36 == null) goto L77;
        r36.setVisibility(0);
    L83:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r3)));
    L85:
        throw new NullPointerException("parent");
    L86:
        float r37 = MarkdownDimensExtKt.b();
        if (o() == false) goto L89;
        RoundingParams r38 = RoundingParams.fromCornersRadii(r37, r37, r37, r37);
    L90:
        MarkdownSubRenderCodeViewLayoutBinding r39 = this.R;
        if (r39 == null) goto L97;
        SimpleDraweeView r40 = r39.l;
        if (r40 == null) goto L97;
        GenericDraweeHierarchy r41 = r40.getHierarchy();
        if (r41 == null) goto L97;
        r41.setRoundingParams(r38);
    L97:
        MarkdownSubRenderCodeViewLayoutBinding r42 = this.R;
        boolean r43 = true;
        if (r42 == null) goto L113;
        SimpleDraweeView r44 = r42.l;
        if (r44 == null) goto L113;
        GenericDraweeHierarchy r45 = r44.getHierarchy();
        if (r45 == null) goto L113;
        if (o() == true) goto L107;
    L109:
        boolean r46 = false;
    L110:
        if (r46 == false) goto L112;
        r45.setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP);
        r45.setActualImageFocusPoint(new PointF(0.5f, 0.0f));
        goto L113
    L112:
        r45.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        goto L113
    L107:
        if (StringsKt.equals(this.j, "html", true) == false) goto L109;
        r46 = true;
    L113:
        final String r47 = null;
        if (o() == false) goto L127;
        if (this.T == true) goto L127;
        MarkdownSubRenderCodeViewLayoutBinding r48 = this.R;
        if (r48 == null) goto L124;
        DraweeView r49 = r48.b;
        if (r49 == null) goto L124;
        r49.getHierarchy().setPlaceholderImage(2131239857);
        com.larus.bmhome.chat.layout.holder.progressloading.e r50 = IAIChatUgcAIGCService.a.x0();
        int r51 = ImageWebpLoadingBgView.d;
        r49.f(r50, false, null, "gen_ppt_preview_loading_bg");
        w0.e(r49, MarkdownDimensExtKt.b());
    L124:
        this.T = true;
    L127:
        if (this.R != null) goto L129;
        return;
    L129:
        if (this.q == true) goto L131;
        w(CodeRenderStatus.Loading);
        return;
    L131:
        if (this.r == CodeRenderStatus.Success) goto L212;
        w(CodeRenderStatus.Loading);
        if (a.b(this.j) == false) goto L204;
        FrameLayout r52 = r1.p;
        c1 r53 = c1.a;
        if (r53.d() == true) goto L138;
        r53.f();
    L138:
        String r54 = this.p0;
        if (r54 == null) goto L141;
        eh8.a.b(r54);
    L141:
        this.p0 = null;
        String r55 = z2.a.getMarkdownCodeRenderConfig().h;
        if (r55 != null) goto L144;
    L147:
        boolean r56 = true;
    L148:
        if (r56 == false) goto L152;
        FLogger.a.w("MarkdownCodeView", "createLynxView: previewLynxviewTemplateUrl is empty, skip lynx preview");
        w(CodeRenderStatus.Failed);
        Function2<? super Long, ? super Boolean, Unit> r57 = this.e;
        if (r57 == null) goto L207;
        r57.invoke(Long.valueOf(System.currentTimeMillis() - this.u), Boolean.FALSE);
        return;
    L207:
        return;
    L152:
        e4 r58 = u2.a.a(r52.getContext(), r55, new JSONObject().put("message_data", this.i).put("message_type", this.j).toString(), 8);
        this.k0 = r58;
        if (r58 == null) goto L165;
        View r59 = r58.getView();
        if (r59 == null) goto L165;
        MarkdownSubRenderCodeViewLayoutBinding r60 = this.R;
        if (r60 == null) goto L165;
        final FrameLayout r61 = r60.n;
        if (r61 == null) goto L165;
        r61.addView(r59, new ConstraintLayout.LayoutParams(-1, -1));
        if (o() == false) goto L163;
        int r62 = 0;
    L164:
        r61.setOutlineProvider(new j0(r62));
        r61.setClipToOutline(true);
        r61.post(new h0(r61));
        goto L165
    L163:
        r62 = -MarkdownDimensExtKt.b();
    L165:
        MarkdownSubRenderCodeViewLayoutBinding r63 = this.R;
        if (r63 == null) goto L170;
        CodeRenderGestureLayout r64 = r63.g;
        if (r64 == null) goto L170;
        r64.setVisibility(4);
    L170:
        e4 r65 = this.k0;
        if (r65 == null) goto L173;
        String r66 = r65.getContainerId();
    L174:
        if (r66 == null) goto L177;
        r5 = r66;
    L177:
        this.p0 = r5;
        final ry8.d r67 = this.B;
        if (r67 == null) goto L180;
        r67.l();
    L181:
        String r68 = this.x;
        if (r68 == null) goto L199;
        String r69 = StringsKt.removePrefix(r68, "long_screenshot_");
        if (r69 == null) goto L199;
        if (r5.length() <= 0) goto L188;
        boolean r70 = true;
    L189:
        if (r70 == true) goto L191;
    L196:
        r43 = false;
    L197:
        if (r43 == false) goto L199;
        r47 = r69;
        goto L199
    L191:
        if (r69.length() <= 0) goto L193;
        boolean r71 = true;
    L194:
        if (r71 == false) goto L196;
    L193:
        r71 = false;
        goto L194
    L188:
        r70 = false;
    L199:
        if (r67 == null) goto L202;
        if (r47 == null) goto L202;
        r67.l0(new com.larus.bmhome.chat.markdown.code.b(r47));
    L202:
        eh8.a.a(r5, new com.larus.bmhome.chat.markdown.code.c(r5, this, r67, r47));
        return;
    L180:
        r67 = null;
        goto L181
    L173:
        r66 = null;
        goto L174
    L144:
        if (r55.length() == 0) goto L147;
        r56 = false;
        goto L148
    L204:
        post(new d(this));
        return;
    L212:
        return;
    L89:
        r38 = RoundingParams.fromCornersRadii(0.0f, 0.0f, r37, r37);
        goto L90
    }

    public final void r() {
        MarkdownRenderCodeViewLayoutBinding r0 = this.Q;
        if (r0 == null) goto L55;
        ImageView r1 = r0.g;
        if (r1 == null) goto L56;
        hh8.a r2 = this.t;
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L17;
        r1.setVisibility(8);
        return;
    L17:
        if (((Boolean) P0.getValue()).booleanValue() == true) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == true) goto L25;
        r1.setVisibility(8);
        return;
    L25:
        r1.setVisibility(0);
        if (Intrinsics.areEqual(this.h, Boolean.TRUE) == false) goto L51;
        if (a.b(this.j) == true) goto L30;
        MarkdownSubRenderCodeViewLayoutBinding r5 = this.R;
        if (r5 == null) goto L46;
        SimpleDraweeView r6 = r5.l;
        if (r6 == null) goto L46;
        Uri r7 = r6.getImageUri();
        if (r7 == null) goto L46;
        String r8 = r7.toString();
        if (r8 == null) goto L46;
        if (r8.length() <= 0) goto L43;
        boolean r9 = true;
    L44:
        if (r9 != true) goto L46;
    L45:
        boolean r10 = true;
    L47:
        if (r10 == false) goto L49;
        r1.setAlpha(1.0f);
        r1.setEnabled(true);
        return;
    L49:
        r1.setAlpha(0.4f);
        r1.setEnabled(false);
        return;
    L43:
        r9 = false;
    L46:
        r10 = false;
        goto L47
    L30:
        if (this.r != CodeRenderStatus.Success) goto L46;
    L51:
        if (this.q == false) goto L53;
        r1.setAlpha(1.0f);
        r1.setEnabled(true);
        return;
    L53:
        r1.setAlpha(0.4f);
        r1.setEnabled(false);
        return;
    L19:
        if (a.c() == true) goto L21;
        r4 = true;
        goto L22
    L9:
        if (r2.f != true) goto L11;
        r3 = true;
        goto L13
    L56:
        return;
    }

    public final void s() {
        Boolean r0 = this.g;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.q == true) goto L8;
        MarkdownRenderCodeViewLayoutBinding r1 = this.Q;
        if (r1 == null) goto L31;
        TextView r2 = r1.h;
        if (r2 == null) goto L32;
        r2.setVisibility(8);
        return;
    L32:
        return;
    L31:
        return;
    L8:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L14;
        MarkdownRenderCodeViewLayoutBinding r3 = this.Q;
        if (r3 == null) goto L25;
        TextView r4 = r3.h;
        if (r4 == null) goto L26;
        r4.setVisibility(0);
        return;
    L26:
        return;
    L25:
        return;
    L14:
        MarkdownRenderCodeViewLayoutBinding r5 = this.Q;
        if (r5 == null) goto L28;
        TextView r6 = r5.h;
        if (r6 == null) goto L29;
        r6.setVisibility(8);
        return;
    L29:
        return;
    }

    public final void v() {
        if (e("save_album", "code_render_save") == false) goto L5;
        return;
    L5:
        boolean r1 = true;
        if (a.b(this.j) == true) goto L8;
        MarkdownSubRenderCodeViewLayoutBinding r0 = this.R;
        if (r0 == null) goto L27;
        SimpleDraweeView r2 = r0.l;
        if (r2 == null) goto L27;
        Uri r3 = r2.getImageUri();
        if (r3 == null) goto L27;
        final String r4 = r3.toString();
    L29:
        if (Build.VERSION.SDK_INT <= 29) goto L31;
    L33:
        r1 = false;
    L34:
        if (r1 == false) goto L36;
        u(new n(r4));
    L40:
        Function2<? super CodeClickActionEnum, ? super String, Unit> r5 = this.d;
        if (r5 == null) goto L45;
        r5.invoke(CodeClickActionEnum.CLICK_ACTION_DOWNLOAD_PICTURE, getCardType());
        return;
    L45:
        return;
    L36:
        ImageSave r6 = ImageSave.a;
        if (r4 != null) goto L39;
        r4 = "";
    L39:
        ImageSave.x(r6, r4, null, null, null, false, 62);
        goto L40
    L31:
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L33;
    L27:
        r4 = null;
        goto L29
    L8:
        if (Build.VERSION.SDK_INT <= 29) goto L10;
    L12:
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        u(new m(this));
    L16:
        Function2<? super CodeClickActionEnum, ? super String, Unit> r7 = this.d;
        if (r7 == null) goto L44;
        r7.invoke(CodeClickActionEnum.CLICK_ACTION_DOWNLOAD_PICTURE, getCardType());
        return;
    L44:
        return;
    L15:
        h();
        goto L16
    L10:
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L12;
        goto L12
    }

    public final String getCode() {
        return this.i;
    }

    public final boolean getFinishState() {
        return this.q;
    }

    public final String getLanguage() {
        return this.j;
    }

    public static final /* synthetic */ etc.b a(ClickableMarkdownCodeView r0) {
        return r0.getHighlight();
    }

    public static Bitmap l(View r4) {
        int r0 = r4.getWidth();
        int r1 = r4.getHeight();
        if (r0 <= 0) goto L8;
        if (r1 <= 0) goto L8;
        Bitmap r2 = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        r4.draw(r3);
        k(r4, r4, r3);
        return r2;
    L8:
        FLogger.a.w("MarkdownCodeView", "generateBitmapFromLynxView, invalid size: " + r0 + 'x' + r1);
        return null;
    }

    public final void j(String r51) {
        Message r1 = this.y;
        post(new j(this));
        ClipData r2 = ClipData.newPlainText("info", this.i);
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L5;
        r3.d0();
        i1 r4 = i1.a;
        Context r5 = getContext();
        Intrinsics.checkNotNull(r2);
        r4.i(r5, r2, "bpea-markdown-text-copy");
    L5:
        com.larus.audio.p0 r6 = AudioServiceDelegate.a.getAudioConfig();
        Function0<BotModel> r7 = this.E;
        String r8 = null;
        if (r7 == null) goto L8;
        BotModel r9 = (BotModel) r7.invoke();
    L10:
        if (r6.n(r9) == false) goto L12;
        String r10 = "1";
    L13:
        String r19 = r10;
        Function0<ChatParam> r11 = this.F;
        if (r11 == null) goto L17;
        ChatParam r12 = (ChatParam) r11.invoke();
        if (r12 == null) goto L17;
    L18:
        String r13 = this.C;
        String r14 = r12.e;
        String r15 = r12.c;
        String r16 = m(this.D);
        if (r1 == null) goto L21;
        String r17 = r1.getMessageId();
    L22:
        String r18 = this.j;
        if (r1 == null) goto L25;
        String r110 = r1.getConversationId();
    L26:
        if (r1 == null) goto L28;
        String r111 = r1.getSectionId();
    L29:
        if (r1 == null) goto L31;
        Boolean r112 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.Q0(r1));
    L32:
        by7.e r20 = this.D;
        StateFlowImpl r21 = ce8.c.a;
        JSONObject r45 = new JSONObject();
        ce8.c.c(r45);
        if (r1 == null) goto L35;
        String r25 = com.larus.bmhome.chat.bean.d.u(r1);
    L36:
        String r113 = ko8.a.d;
        String r26 = ko8.a.b;
        String r27 = ko8.a.c;
        Function0<? extends Map<String, ? extends Object>> r22 = this.v;
        if (r1 == null) goto L39;
        r8 = com.larus.im.bean.message.a.r(r1);
    L39:
        tx9.j0.a(r13, r14, r51, r16, null, r17, r15, r113, null, 1L, r18, r110, r111, r112, r19, null, "bot", ChatDraftItem.TYPE_TEXT, null, null, r25, r26, r27, null, null, null, null, null, null, null, null, null, null, null, "code", null, null, null, r8, null, r45, r20, r22, 1678765680, 778236);
        Function2<? super CodeClickActionEnum, ? super String, Unit> r23 = this.d;
        if (r23 == null) goto L43;
        r23.invoke(CodeClickActionEnum.CLICK_ACTION_COPY, getCardType());
        return;
    L43:
        return;
    L35:
        r25 = null;
        goto L36
    L31:
        r112 = null;
        goto L32
    L28:
        r111 = null;
        goto L29
    L25:
        r110 = null;
        goto L26
    L21:
        r17 = null;
    L17:
        r12 = new ChatParam(null, null, null, null, null, 255);
        goto L18
    L12:
        r10 = "0";
        goto L13
    L8:
        r9 = null;
        goto L10
    }

    public final String m(by7.e r2) {
        if ((r2 instanceof TraceFragment) == false) goto L5;
        TraceFragment r3 = (TraceFragment) r2;
    L6:
        if (r3 == null) goto L10;
        String r4 = r3.k();
        if (r4 == null) goto L10;
        return r4;
    L10:
        return this.w;
    L5:
        r3 = null;
        goto L6
    }

    public final void setupCodeViewSeparatorColor(Integer r2) {
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
        MarkdownRenderCodeViewLayoutBinding r0 = this.Q;
        if (r0 == null) goto L10;
        View r1 = r0.b;
        if (r1 == null) goto L11;
        r1.setBackgroundColor(r3);
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void setupExpandAllBackgroundResult(Integer r5) {
        if (r5 == null) goto L31;
        r5.intValue();
        MarkdownRenderCodeViewLayoutBinding r0 = this.Q;
        if (r0 == null) goto L8;
        TextView r1 = r0.h;
        if (r1 == null) goto L8;
        r1.setBackgroundResource(r5.intValue());
    L8:
        MarkdownRenderCodeViewLayoutBinding r6 = this.Q;
        GradientDrawable r2 = null;
        if (r6 == null) goto L15;
        TextView r7 = r6.h;
        if (r7 == null) goto L15;
        Drawable r8 = r7.getBackground();
        if (r8 == null) goto L15;
        Drawable r9 = r8.mutate();
    L17:
        if ((r9 instanceof GradientDrawable) == false) goto L19;
        r2 = (GradientDrawable) r9;
    L19:
        if (r2 == null) goto L32;
        hh8.a r10 = this.t;
        if (r10 == null) goto L25;
        Float r11 = r10.e;
        if (r11 == null) goto L25;
        float r12 = r11.floatValue();
        r2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r12, r12, r12, r12});
    L25:
        MarkdownRenderCodeViewLayoutBinding r13 = this.Q;
        if (r13 == null) goto L33;
        TextView r14 = r13.h;
        if (r14 == null) goto L34;
        r14.setBackground(r2);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L15:
        r9 = null;
        goto L17
    }

    public final void setupMarkdownCodeLinearLayoutRes(Integer r2) {
        if (r2 == null) goto L9;
        r2.intValue();
        MarkdownRenderCodeViewLayoutBinding r0 = this.Q;
        if (r0 == null) goto L10;
        MaxHeightLinearLayout r1 = r0.l;
        if (r1 == null) goto L11;
        r1.setBackgroundResource(r2.intValue());
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void t(boolean r4) {
        MarkdownRenderCodeViewLayoutBinding r0 = this.Q;
        if (r0 == null) goto L12;
        FrameLayout r1 = r0.p;
        if (r1 == null) goto L12;
        boolean r2 = true;
        if (r1.getVisibility() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r4 != r3) goto L12;
    L13:
        if (r2 == false) goto L16;
        return;
    L16:
        if (r4 == false) goto L27;
        MarkdownRenderCodeViewLayoutBinding r5 = this.Q;
        if (r5 == null) goto L22;
        FrameLayout r6 = r5.p;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
    L22:
        MarkdownRenderCodeViewLayoutBinding r7 = this.Q;
        if (r7 == null) goto L37;
        FrameLayout r8 = r7.d;
        if (r8 == null) goto L37;
        r8.setVisibility(8);
    L37:
        Function1<? super Boolean, Unit> r9 = this.c;
        if (r9 == null) goto L41;
        r9.invoke(Boolean.valueOf(r4));
        return;
    L41:
        return;
    L27:
        MarkdownRenderCodeViewLayoutBinding r10 = this.Q;
        if (r10 == null) goto L32;
        FrameLayout r11 = r10.p;
        if (r11 == null) goto L32;
        r11.setVisibility(8);
    L32:
        MarkdownRenderCodeViewLayoutBinding r12 = this.Q;
        if (r12 == null) goto L37;
        FrameLayout r13 = r12.d;
        if (r13 == null) goto L37;
        r13.setVisibility(0);
        goto L37
    L9:
        r3 = false;
    L12:
        r2 = false;
        goto L13
    }

    public final void u(final Function1<? super Boolean, Unit> r5) {
        FragmentActivity r0 = getContext();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        i2.b.a(r1, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new o(r5));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void w(CodeRenderStatus r11) {
        this.r = r11;
        MarkdownSubRenderCodeViewLayoutBinding r0 = this.R;
        if (r0 == null) goto L81;
        int r12 = b.a[r11.ordinal()];
        boolean r1 = true;
        if (r12 != 1) goto L7;
        r0.g.setVisibility(0);
        r0.j.setVisibility(8);
        r0.m.setVisibility(8);
        r0.b.setVisibility(8);
        g();
        return;
    L7:
        if (r12 != 2) goto L9;
        r0.g.setVisibility(8);
        r0.j.setVisibility(0);
        r0.m.setVisibility(8);
        r0.b.setVisibility(8);
        MarkdownSubRenderCodeViewLayoutBinding r13 = this.R;
        if (r13 == null) goto L78;
        r13.i.setImageResource(2131233292);
        r13.k.setText(getContext().getString(2131900894));
        e1.d(r13.j, new e(this));
    L78:
        g();
        return;
    L9:
        if (r12 != 3) goto L11;
        r0.g.setVisibility(8);
        r0.j.setVisibility(8);
        r0.m.setVisibility(0);
        MarkdownSubRenderCodeViewLayoutBinding r14 = this.R;
        if (r14 != null) goto L18;
    L66:
        Job r15 = this.S;
        if (r15 != null) goto L69;
    L71:
        r1 = false;
    L72:
        if (r1 == true) goto L85;
        this.S = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ClickableMarkdownCodeView$startLoading$1(this, null), 3, null);
        return;
    L85:
        return;
    L69:
        if (r15.isActive() != true) goto L71;
    L18:
        if (o() == false) goto L61;
        r14.b.setVisibility(0);
        LinearLayout r4 = r14.m;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if (r6 == null) goto L60;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        r7.setMargins(i5.Y(), i5.Y(), i5.Y(), i5.Y());
        r4.setLayoutParams(r7);
        r14.m.setBackground(ContextCompat.getDrawable(getContext(), 2131243904));
        r14.c.setVisibility(0);
        r14.e.setVisibility(0);
        r14.d.setVisibility(8);
        r14.h.setVisibility(8);
        if (o() == true) goto L24;
    L26:
        boolean r16 = false;
    L27:
        if (r16 == true) goto L35;
        boolean r17 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L32;
        String r18 = "dark";
    L33:
        Lazy<Keva> r3 = t0.d;
        ih8.b r19 = t0.a.b(this.s, r18);
        if (r19 == null) goto L35;
        Integer r5 = r19.c();
        if (r5 != null) goto L39;
    L44:
        r5 = null;
    L45:
        Integer r110 = r19.a();
        if (r110 != null) goto L48;
    L53:
        r110 = null;
    L54:
        Integer r111 = Integer.valueOf(i(r5, r110));
    L55:
        if (r111 == null) goto L57;
        int r112 = r111.intValue();
    L58:
        x(r112, false);
        goto L66
    L57:
        r112 = this.O;
        goto L58
    L48:
        if (r110.intValue() <= 0) goto L50;
        boolean r8 = true;
    L51:
        if (r8 == false) goto L53;
    L50:
        r8 = false;
        goto L51
    L39:
        if (r5.intValue() <= 0) goto L41;
        boolean r9 = true;
    L42:
        if (r9 == false) goto L44;
    L41:
        r9 = false;
        goto L42
    L32:
        r18 = "light";
    L35:
        r111 = null;
        goto L55
    L24:
        if (a.b(this.j) == false) goto L26;
        r16 = true;
        goto L27
    L60:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L61:
        r14.b.setVisibility(8);
        LinearLayout r10 = r14.m;
        ViewGroup.LayoutParams r20 = r10.getLayoutParams();
        if (r20 == null) goto L65;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        r21.setMargins(0, 0, 0, 0);
        r10.setLayoutParams(r21);
        r14.m.setBackground(null);
        r14.c.setVisibility(8);
        r14.e.setVisibility(8);
        r14.d.setVisibility(0);
        r14.h.setVisibility(0);
        goto L66
    L65:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L11:
        if (r12 != 4) goto L14;
        r0.g.setVisibility(0);
        r0.j.setVisibility(8);
        r0.m.setVisibility(8);
        r0.b.setVisibility(8);
        g();
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public static int f(String r6, Map r7) {
        Intrinsics.checkNotNullParameter(r6, "language");
        z2 r1 = z2.a;
        boolean r5 = false;
        if (r1.getMarkdownCodeRenderConfig().j == false) goto L9;
        if (r7 == null) goto L9;
        if (StringsKt.equals(r6, "html", true) == false) goto L9;
        boolean r8 = !Intrinsics.areEqual(r7.get("type"), "renderer");
    L11:
        if (r8 == false) goto L14;
        return 0;
    L14:
        if (a.a(r6) == true) goto L16;
    L41:
        return 0;
    L16:
        if (((Boolean) P0.getValue()).booleanValue() == true) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L41;
        Intrinsics.checkNotNullParameter(r6, "language");
        e3 r10 = r1.getMarkdownCodeRenderConfig();
        if (StringsKt.equals(r6, "html", true) == false) goto L27;
        r5 = r10.k;
    L38:
        if (r5 == false) goto L42;
        return 2;
    L42:
        return 1;
    L27:
        if (StringsKt.equals(r6, "mindmap", true) == false) goto L30;
        r5 = r10.l;
        goto L38
    L30:
        if (StringsKt.equals(r6, "mermaid", true) == false) goto L33;
        r5 = r10.m;
        goto L38
    L33:
        if (StringsKt.equals(r6, "svg", true) == false) goto L36;
        r5 = r10.n;
        goto L38
    L36:
        if (StringsKt.equals(r6, "echarts", true) == false) goto L38;
        r5 = r10.o;
        goto L38
    L18:
        if (a.c() == true) goto L20;
        r9 = true;
    L9:
        r8 = false;
        goto L11
    }

    public final boolean e(String r10, String r11) {
        FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
        return false;
    L10:
        FLogger.a.i("MarkdownCodeView", "file egress blocked action=" + r10 + " entry=" + r11);
        com.larus.platform.service.o r1 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        r4.put("action", r10);
        r4.put("entry", r11);
        if (Intrinsics.areEqual(r10, "save_album") == false) goto L13;
        String r12 = "album";
    L14:
        r4.put("channel", r12);
        r4.put("content_type", "image");
        Unit r13 = Unit.INSTANCE;
        r1.reportEvent("flow_enterprise_file_egress_block", r4);
        String r14 = r0.H0();
        if (r14 != null) goto L17;
    L23:
        return true;
    L17:
        if ((!StringsKt.isBlank(r14)) == true) goto L20;
        r14 = null;
    L20:
        String r5 = r14;
        if (r5 == null) goto L23;
        t19.s.j(t19.s.a, getContext(), r5, null, false, 28);
        goto L23
    L13:
        r12 = "clipboard";
        goto L14
    L5:
        if (r0.I0() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final int i(Integer r5, Integer r6) {
        if (r5 == null) goto L27;
        boolean r1 = true;
        if (r5.intValue() <= 0) goto L6;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L27;
        int r7 = r5.intValue();
        if (r6 == null) goto L25;
        if (r6.intValue() > 0) goto L18;
        r1 = false;
    L18:
        if (r1 == true) goto L21;
        r6 = null;
    L21:
        if (r6 == null) goto L25;
        return (int) (RangesKt.coerceIn(r6.intValue() / r7, 0.5f, 1.3333334f) * this.N);
    L25:
        return this.N;
    L6:
        r0 = false;
    L27:
        return this.N;
    }

    public final void x(int r3, boolean r4) {
        MarkdownRenderCodeViewLayoutBinding r0 = this.Q;
        if (r0 == null) goto L23;
        MaxHeightLinearLayout r1 = r0.a;
        if (r1 == null) goto L26;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L10;
        int r5 = r2.height;
    L11:
        if (r3 != r5) goto L13;
        return;
    L13:
        ViewGroup.LayoutParams r6 = r1.getLayoutParams();
        if (r6 == null) goto L22;
        r6.height = r3;
        r1.setLayoutParams(r6);
        if (r4 == false) goto L24;
        Function1<? super Boolean, Unit> r7 = this.c;
        if (r7 == null) goto L25;
        r7.invoke(Boolean.FALSE);
        return;
    L25:
        return;
    L24:
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L10:
        r5 = Integer.MIN_VALUE;
        goto L11
    L26:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v17, types: [com.larus.bmhome.chat.markdown.code.w] */
    public ClickableMarkdownCodeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new t0();
        this.i = "";
        this.j = "";
        this.I = LazyKt.lazy(new com.larus.bmhome.chat.markdown.code.a());
        ExecutorCoroutineDispatcher r5 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new l()));
        this.J = r5;
        this.K = CoroutineScopeKt.CoroutineScope(r5.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.L = 20;
        int r6 = ((Number) MarkdownDimensExtKt.T.getValue()).intValue();
        this.M = r6;
        this.N = ((Number) i5.K1.getValue()).intValue();
        this.O = ((Number) i5.f1.getValue()).intValue();
        this.P = r6;
        this.V = ILegacyChatUiServiceDelegate.b.F8();
        this.W = new w(this);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bmhome.chat.markdown.code.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.markdown.code.g] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.chat.markdown.code.h] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.bmhome.chat.markdown.code.i] */
    public static final void b(final ClickableMarkdownCodeView r9, View r10, Message r11) {
        r9.getClass();
        IAIChatService.a.C7(r11, r9.z, r9.A, a.b(r9.j), new f(r9), new g(r9), new h(r9), new i(r9)).onLongClick(r10);
    }

    public static void k(View r6, View r7, Canvas r8) {
        int r1 = 0;
        if ((r6 instanceof TextureView) == false) goto L8;
        Bitmap r0 = ((TextureView) r6).getBitmap();
        if (r0 == null) goto L8;
        int[] r3 = new int[2];
        r6.getLocationOnScreen(r3);
        int[] r2 = new int[2];
        r7.getLocationOnScreen(r2);
        Pair r4 = new Pair(Float.valueOf(r3[0] - r2[0]), Float.valueOf(r3[1] - r2[1]));
        r8.drawBitmap(r0, ((Number) r4.component1()).floatValue(), ((Number) r4.component2()).floatValue(), null);
    L8:
        if ((r6 instanceof ViewGroup) == false) goto L12;
        ViewGroup r9 = (ViewGroup) r6;
        int r5 = r9.getChildCount();
    L10:
        if (r1 >= r5) goto L14;
        k(r9.getChildAt(r1), r7, r8);
        r1 = r1 + 1;
        goto L10
    L14:
        return;
    }

    public /* synthetic */ ClickableMarkdownCodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static /* synthetic */ void d(ClickableMarkdownCodeView r9, String r10, String r11, boolean r12) {
        r9.c(r10, r11, r12, null, null, false, null, null);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [android.view.ViewGroup, com.larus.bmhome.chat.detail.code.view.PreviewSwitchButton] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void c(String r13, String r14, boolean r15, Map<String, String> r16, String r17, boolean r18, Integer r19, Integer r20) {
        Intrinsics.checkNotNullParameter(r13, "code");
        Intrinsics.checkNotNullParameter(r14, "language");
        if (Intrinsics.areEqual(r14, "STDOUT") == false) goto L5;
        return;
    L5:
        this.i = r13;
        this.j = r14;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.o = r19;
        this.p = r20;
        this.q = r15;
        if (r15 == true) goto L8;
        this.H = true;
    L8:
        if (r15 == false) goto L10;
        int r3 = rw8.a.a;
        String r0 = rw8.a.a(r13, this.L);
    L11:
        MarkdownRenderCodeViewLayoutBinding r4 = this.Q;
        boolean r6 = false;
        if (r4 == null) goto L41;
        CustomMarkdownTextView r5 = r4.o;
        if (r5 == null) goto L41;
        if (z2.a.getMarkdownOptimizeConfig().g == true) goto L19;
        r5.setText(new lsc.y(getHighlight().a(this.j, r0)).h());
        goto L41
    L19:
        if (Intrinsics.areEqual(this.g, Boolean.TRUE) == true) goto L30;
        CharSequence r8 = r5.getText();
        if (r8 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L30;
        r5.setText(getHighlight().a(this.j, r0));
        goto L41
    L23:
        if (r8.length() == 0) goto L26;
        r9 = false;
    L30:
        CharSequence r10 = r5.getText();
        if (r10 != null) goto L33;
    L36:
        boolean r11 = true;
    L37:
        if (r11 == false) goto L39;
        r5.setText(r0);
    L39:
        BuildersKt.launch$default(this.K, null, null, new ClickableMarkdownCodeView$refreshText$1(this, r0, r5, null), 3, null);
        goto L41
    L33:
        if (r10.length() == 0) goto L36;
        r11 = false;
    L41:
        int r1 = f(this.j, this.k);
        if (r1 != 1) goto L44;
        MarkdownRenderCodeViewLayoutBinding r2 = this.Q;
        if (r2 == null) goto L150;
        MaxHeightLinearLayout r7 = r2.a;
        if (r7 == null) goto L150;
        ViewGroup.LayoutParams r12 = r7.getLayoutParams();
        if (r12 == null) goto L149;
        r12.height = this.P;
        r7.setLayoutParams(r12);
        goto L150
    L149:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L150:
        MarkdownRenderCodeViewLayoutBinding r21 = this.Q;
        if (r21 == null) goto L155;
        RelativeLayout r22 = r21.j;
        if (r22 == null) goto L155;
        r22.setVisibility(0);
    L155:
        MarkdownRenderCodeViewLayoutBinding r23 = this.Q;
        if (r23 == null) goto L160;
        View r24 = r23.b;
        if (r24 == null) goto L160;
        r24.setVisibility(0);
    L160:
        MarkdownRenderCodeViewLayoutBinding r25 = this.Q;
        if (r25 == null) goto L165;
        TextView r26 = r25.k;
        if (r26 == null) goto L165;
        r26.setVisibility(8);
    L165:
        MarkdownRenderCodeViewLayoutBinding r27 = this.Q;
        if (r27 == null) goto L180;
        ConstraintLayout r28 = r27.n;
        if (r28 == null) goto L180;
        hh8.a r29 = this.t;
        if (r29 != null) goto L172;
    L174:
        boolean r30 = false;
    L175:
        if (r30 == false) goto L177;
        int r31 = 8;
    L178:
        r28.setVisibility(r31);
        goto L180
    L177:
        r31 = 0;
        goto L178
    L172:
        if (r29.f != true) goto L174;
        r30 = true;
    L180:
        if (this.h != null) goto L182;
    L183:
        this.h = Boolean.valueOf(this.q);
    L184:
        MarkdownRenderCodeViewLayoutBinding r32 = this.Q;
        if (r32 == null) goto L206;
        ?? r33 = r32.n;
        if (r33 == 0) goto L206;
        hh8.a r34 = this.t;
        if (r34 != null) goto L191;
    L193:
        boolean r35 = false;
    L194:
        if (r35 == false) goto L196;
        int r36 = 8;
    L197:
        r33.setVisibility(r36);
        Boolean r37 = this.h;
        if (r37 == null) goto L200;
        boolean r38 = r37.booleanValue();
    L201:
        r33.setState(r38);
        Boolean r39 = this.h;
        if (r39 == null) goto L204;
        boolean r40 = r39.booleanValue();
    L205:
        t(r40);
        goto L206
    L204:
        r40 = false;
        goto L205
    L200:
        r38 = false;
        goto L201
    L196:
        r36 = 0;
        goto L197
    L191:
        if (r34.f != true) goto L193;
        r35 = true;
    L206:
        q();
    L208:
        if (f(this.j, this.k) != 0) goto L210;
        boolean r41 = true;
    L211:
        MarkdownRenderCodeViewLayoutBinding r42 = this.Q;
        if (r42 == null) goto L224;
        TextView r43 = r42.c;
        if (r43 == null) goto L224;
        Integer r44 = this.o;
        if (r44 == null) goto L223;
        r44.intValue();
        if (r41 == true) goto L221;
        r44 = null;
    L221:
        if (r44 == null) goto L223;
        r43.setText(r43.getContext().getString(2131900895, new Object[]{Integer.valueOf(r44.intValue())}));
        r43.setVisibility(0);
    L223:
        r43.setVisibility(8);
    L224:
        MarkdownRenderCodeViewLayoutBinding r45 = this.Q;
        if (r45 == null) goto L237;
        TextView r46 = r45.f;
        if (r46 == null) goto L237;
        Integer r47 = this.p;
        if (r47 == null) goto L236;
        r47.intValue();
        if (r41 == true) goto L234;
        r47 = null;
    L234:
        if (r47 == null) goto L236;
        r46.setText(r46.getContext().getString(2131900896, new Object[]{Integer.valueOf(r47.intValue())}));
        r46.setVisibility(0);
    L236:
        r46.setVisibility(8);
    L237:
        MarkdownRenderCodeViewLayoutBinding r48 = this.Q;
        if (r48 == null) goto L240;
        CustomMarkdownTextView r49 = r48.o;
    L241:
        if (r49 != null) goto L244;
    L250:
        s();
        r();
        MarkdownRenderCodeViewLayoutBinding r50 = this.Q;
        if (r50 == null) goto L258;
        ImageView r51 = r50.e;
        if (r51 == null) goto L258;
        if (this.q == false) goto L257;
        r51.setAlpha(1.0f);
        r51.setEnabled(true);
        goto L258
    L257:
        r51.setAlpha(0.4f);
        r51.setEnabled(false);
    L258:
        hh8.a r52 = this.t;
        if (r52 != null) goto L261;
    L263:
        boolean r53 = false;
    L264:
        if (r53 == false) goto L271;
        MarkdownRenderCodeViewLayoutBinding r54 = this.Q;
        if (r54 == null) goto L287;
        ImageView r55 = r54.m;
        if (r55 == null) goto L287;
        r55.setVisibility(8);
    L287:
        if (this.q == true) goto L290;
        return;
    L290:
        if (a.a(this.j) == true) goto L293;
        return;
    L293:
        if (f(this.j, this.k) != 0) goto L296;
        return;
    L296:
        if (((Boolean) V0.getValue()).booleanValue() == false) goto L376;
        String r56 = this.x;
        if (r56 == null) goto L324;
        com.larus.bmhome.chat.api.q0 r57 = this.z;
        if (r57 == null) goto L322;
        List<wq8.a> r58 = r57.D7();
        if (r58 == null) goto L322;
        Iterator<T> r59 = r58.iterator();
    L307:
        if (r59.hasNext() == false) goto L316;
        Object r60 = r59.next();
        wq8.a r61 = (wq8.a) r60;
        if (com.larus.bmhome.chat.bean.d.O0(r61.getMessage()) == false) goto L311;
    L313:
        boolean r62 = false;
    L314:
        if (r62 == false) goto L307;
    L317:
        wq8.a r63 = (wq8.a) r60;
        if (r63 == null) goto L322;
        Message r64 = r63.getMessage();
        if (r64 == null) goto L322;
        String r65 = r64.getMessageId();
    L323:
        r6 = Intrinsics.areEqual(r65, r56);
        goto L324
    L311:
        if (com.larus.bmhome.chat.bean.d.c0(r61.getMessage()) == true) goto L313;
        r62 = true;
        goto L314
    L316:
        r60 = null;
    L322:
        r65 = null;
    L324:
        if (r6 == true) goto L327;
        return;
    L327:
        if (this.H == true) goto L330;
        return;
    L330:
        if (a.b(this.j) == true) goto L379;
        FragmentActivity r66 = getContext();
        if ((r66 instanceof FragmentActivity) == false) goto L335;
        FragmentActivity r67 = r66;
    L336:
        if (r67 == null) goto L380;
        final String r68 = this.s;
        if (r68 != null) goto L342;
        return;
    L342:
        if (this.x == null) goto L382;
        com.larus.bmhome.chat.detail.code.preview.m r69 = com.larus.bmhome.chat.detail.code.preview.m.a;
        final String r70 = this.i;
        final String r71 = this.j;
        final Message r72 = this.y;
        r69.getClass();
        Intrinsics.checkNotNullParameter(r67, "activity");
        Intrinsics.checkNotNullParameter(r70, "code");
        Intrinsics.checkNotNullParameter(r71, "language");
        Intrinsics.checkNotNullParameter(r68, "codeId");
        if (r72 == null) goto L383;
        final FragmentActivity r110 = r67;
        com.larus.bmhome.chat.detail.code.preview.m.c = new com.larus.bmhome.chat.detail.code.preview.l(r110, r70, r71, r68, r72);
        if (com.larus.bmhome.chat.bean.d.Q0(r72) == true) goto L364;
        FLogger.a.d("PreloadCodeWebViewManager", "tryPreload, preload, conversationId[" + r72.getConversationId() + "], messageId[" + r72.getMessageId() + ']');
        Runnable r73 = com.larus.bmhome.chat.detail.code.preview.m.c;
        if (r73 == null) goto L362;
        r73.run();
    L362:
        com.larus.bmhome.chat.detail.code.preview.m.c = null;
        return;
    L364:
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L354
        FLogger.a.d("PreloadCodeWebViewManager", "tryPreload, addStreamObserver, conversationId[" + r72.getConversationId() + "], messageId[" + r72.getMessageId() + ']');     // Catch: Throwable -> L354
        int r75 = com.larus.im.d.a;     // Catch: Throwable -> L354
        com.larus.im.internal.stream.b r76 = com.larus.im.internal.stream.b.a;     // Catch: Throwable -> L354
        String r77 = r72.getConversationId();     // Catch: Throwable -> L354
        if (r77 != null) goto L352;
        r77 = "";
    L352:
        r76.b(r77, com.larus.bmhome.chat.detail.code.preview.m.d);     // Catch: Throwable -> L354
        Object r78 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L354
    L357:
        if (Result.exceptionOrNull-impl(r78) == null) goto L371;
        FLogger.a.e("PreloadCodeWebViewManager", "tryPreload failed, addStreamObserver failed, conversationId[" + r72.getConversationId() + "], messageId[" + r72.getMessageId() + ']');
        return;
    L371:
        return;
    L354:
        th = move-exception;
        Result.Companion r79 = Result.Companion;
        r78 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L357
    L383:
        return;
    L382:
        return;
    L380:
        return;
    L335:
        r67 = null;
        goto L336
    L379:
        return;
    L376:
        return;
    L271:
        if (a.a(this.j) == true) goto L273;
    L281:
        MarkdownRenderCodeViewLayoutBinding r80 = this.Q;
        if (r80 == null) goto L287;
        ImageView r81 = r80.m;
        if (r81 == null) goto L287;
        r81.setVisibility(8);
        goto L287
    L273:
        if (this.q == false) goto L281;
        if (f(this.j, this.k) != 0) goto L281;
        MarkdownRenderCodeViewLayoutBinding r82 = this.Q;
        if (r82 == null) goto L287;
        ImageView r83 = r82.m;
        if (r83 == null) goto L287;
        r83.setVisibility(0);
        goto L287
    L261:
        if (r52.f != true) goto L263;
        r53 = true;
        goto L264
    L244:
        if (this.q == false) goto L246;
        int r84 = 48;
    L248:
        if ((r49.getGravity() & DoraCallStateCode.DOUBAO_CMD_12) == r84) goto L250;
        r49.setGravity(r84 | (r49.getGravity() & 7));
        r49.requestLayout();
        goto L250
    L246:
        r84 = 80;
        goto L248
    L240:
        r49 = null;
        goto L241
    L210:
        r41 = false;
        goto L211
    L182:
        if (this.q == false) goto L184;
    L44:
        if (r1 == 2) goto L93;
        MarkdownRenderCodeViewLayoutBinding r85 = this.Q;
        if (r85 == null) goto L54;
        MaxHeightLinearLayout r86 = r85.a;
        if (r86 == null) goto L54;
        ViewGroup.LayoutParams r87 = r86.getLayoutParams();
        if (r87 == null) goto L53;
        r87.height = -2;
        r86.setLayoutParams(r87);
        goto L54
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L54:
        MarkdownRenderCodeViewLayoutBinding r88 = this.Q;
        if (r88 == null) goto L59;
        RelativeLayout r89 = r88.j;
        if (r89 == null) goto L59;
        r89.setVisibility(0);
    L59:
        MarkdownRenderCodeViewLayoutBinding r90 = this.Q;
        if (r90 == null) goto L64;
        View r91 = r90.b;
        if (r91 == null) goto L64;
        r91.setVisibility(0);
    L64:
        MarkdownRenderCodeViewLayoutBinding r92 = this.Q;
        if (r92 == null) goto L69;
        TextView r93 = r92.k;
        if (r93 == null) goto L69;
        r93.setVisibility(0);
    L69:
        MarkdownRenderCodeViewLayoutBinding r94 = this.Q;
        if (r94 == null) goto L74;
        ConstraintLayout r95 = r94.n;
        if (r95 == null) goto L74;
        r95.setVisibility(8);
    L74:
        MarkdownRenderCodeViewLayoutBinding r96 = this.Q;
        if (r96 == null) goto L79;
        FrameLayout r97 = r96.p;
        if (r97 == null) goto L79;
        r97.setVisibility(8);
    L79:
        MarkdownRenderCodeViewLayoutBinding r99 = this.Q;
        if (r99 == null) goto L84;
        FrameLayout r100 = r99.d;
        if (r100 == null) goto L84;
        r100.setVisibility(0);
    L84:
        MarkdownRenderCodeViewLayoutBinding r101 = this.Q;
        if (r101 == null) goto L208;
        TextView r102 = r101.k;
        if (r102 == null) goto L208;
        String r103 = this.l;
        if (r103 != null) goto L92;
        r103 = this.j;
    L92:
        r102.setText(r103);
        goto L208
    L93:
        MarkdownRenderCodeViewLayoutBinding r104 = this.Q;
        if (r104 == null) goto L102;
        MaxHeightLinearLayout r105 = r104.a;
        if (r105 == null) goto L102;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L101;
        r106.height = this.N;
        r105.setLayoutParams(r106);
        goto L102
    L101:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L102:
        MarkdownRenderCodeViewLayoutBinding r107 = this.Q;
        if (r107 == null) goto L107;
        RelativeLayout r108 = r107.j;
        if (r108 == null) goto L107;
        r108.setVisibility(8);
    L107:
        MarkdownRenderCodeViewLayoutBinding r109 = this.Q;
        if (r109 == null) goto L112;
        View r111 = r109.b;
        if (r111 == null) goto L112;
        r111.setVisibility(8);
    L112:
        MarkdownRenderCodeViewLayoutBinding r112 = this.Q;
        if (r112 == null) goto L117;
        TextView r113 = r112.k;
        if (r113 == null) goto L117;
        r113.setVisibility(8);
    L117:
        MarkdownRenderCodeViewLayoutBinding r114 = this.Q;
        if (r114 == null) goto L122;
        ConstraintLayout r115 = r114.n;
        if (r115 == null) goto L122;
        r115.setVisibility(8);
    L122:
        MarkdownRenderCodeViewLayoutBinding r116 = this.Q;
        if (r116 == null) goto L127;
        FrameLayout r117 = r116.d;
        if (r117 == null) goto L127;
        r117.setVisibility(8);
    L127:
        MarkdownRenderCodeViewLayoutBinding r118 = this.Q;
        if (r118 == null) goto L132;
        FrameLayout r119 = r118.p;
        if (r119 == null) goto L132;
        r119.setVisibility(0);
    L132:
        this.h = Boolean.TRUE;
        q();
        if (o() == false) goto L208;
        MarkdownSubRenderCodeViewLayoutBinding r120 = this.R;
        if (r120 == null) goto L208;
        CodeRenderGestureLayout r121 = r120.g;
        if (r121 == null) goto L208;
        r121.setOnLongPressCallback(new g0(this));
        goto L208
    L10:
        int r122 = rw8.a.a;
        r0 = rw8.a.b(r13, this.L);
        goto L11
    }

    public static void n(final ClickableMarkdownCodeView r35, final String r36, Message r37, boolean r38, Long r39, by7.e r40, final RecyclerView r41, Function2 r42, Function0 r43, Function0 r44, qj8.d r45, qj8.e r46, Integer r47, String r48, hh8.a r49, Function0 r50, String r51, com.larus.bmhome.chat.api.q0 r52, com.larus.bmhome.chat.api.q0.a r53, ry8.d r54, Function2 r55, boolean r56, int r57) {
        if ((r57 & 4) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r57 & 8) == 0) goto L9;
        Long r5 = null;
    L11:
        if ((r57 & 16) == 0) goto L13;
        by7.e r7 = null;
    L15:
        if ((r57 & 64) == 0) goto L17;
        Function2 r8 = null;
    L19:
        if ((r57 & 128) == 0) goto L21;
        Function0 r9 = null;
    L23:
        if ((r57 & 256) == 0) goto L25;
        Function0 r10 = null;
    L27:
        if ((r57 & 512) == 0) goto L29;
        qj8.d r11 = null;
    L31:
        if ((r57 & 1024) == 0) goto L33;
        qj8.e r12 = null;
    L35:
        if ((r57 & 2048) == 0) goto L37;
        Integer r13 = null;
    L39:
        if ((r57 & 4096) == 0) goto L41;
        String r14 = null;
    L43:
        if ((r57 & 8192) == 0) goto L45;
        hh8.a r15 = null;
    L47:
        if ((r57 & 16384) == 0) goto L49;
        Function0 r6 = null;
    L51:
        if ((r57 & 32768) == 0) goto L53;
        String r4 = null;
    L55:
        if ((r57 & 65536) == 0) goto L57;
        com.larus.bmhome.chat.api.q0 r16 = null;
    L58:
        final Long r310 = r5;
        if ((r57 & 131072) == 0) goto L61;
        com.larus.bmhome.chat.api.q0.a r17 = null;
    L62:
        Integer r410 = r13;
        if ((r57 & 262144) == 0) goto L65;
        ry8.d r18 = null;
    L67:
        if ((r57 & 524288) == 0) goto L69;
        Function2 r19 = null;
    L71:
        if ((r57 & 1048576) == 0) goto L73;
        boolean r2 = false;
    L74:
        r35.c = r11;
        r35.d = r8;
        r35.s = r14;
        r35.t = r15;
        r35.v = r6;
        r35.w = r4;
        r35.e = r12;
        if (r37 == null) goto L77;
        String r20 = r37.getMessageId();
    L78:
        r35.x = r20;
        r35.y = r37;
        r35.z = r16;
        r35.A = r17;
        r35.B = r18;
        r35.C = r36;
        r35.D = r7;
        r35.E = r9;
        r35.F = r10;
        r35.G = r19;
        r35.n = r2;
        if (r35.f == true) goto L351;
        Float r21 = Float.valueOf(we8.a.a(i5.m(), false));
        MaxHeightLinearLayout r22 = LayoutInflater.from(r35.getContext()).inflate(2131563622, r35, false);
        r35.addView(r22);
        int r23 = 2131367074;
        View r24 = ViewBindings.findChildViewById(r22, 2131367074);
        if (r24 == null) goto L350;
        r23 = 2131379546;
        TextView r25 = (TextView) ViewBindings.findChildViewById(r22, 2131379546);
        if (r25 == null) goto L350;
        r23 = 2131379548;
        FrameLayout r26 = (FrameLayout) ViewBindings.findChildViewById(r22, 2131379548);
        if (r26 == null) goto L350;
        r23 = 2131379549;
        ImageView r27 = (ImageView) ViewBindings.findChildViewById(r22, 2131379549);
        if (r27 == null) goto L350;
        r23 = 2131379550;
        TextView r28 = (TextView) ViewBindings.findChildViewById(r22, 2131379550);
        if (r28 == null) goto L350;
        r23 = 2131379551;
        ImageView r29 = (ImageView) ViewBindings.findChildViewById(r22, 2131379551);
        if (r29 == null) goto L350;
        r23 = 2131379552;
        TextView r210 = (TextView) ViewBindings.findChildViewById(r22, 2131379552);
        if (r210 == null) goto L350;
        r23 = 2131379553;
        ImageView r211 = (ImageView) ViewBindings.findChildViewById(r22, 2131379553);
        if (r211 == null) goto L350;
        r23 = 2131379554;
        RelativeLayout r212 = (RelativeLayout) ViewBindings.findChildViewById(r22, 2131379554);
        if (r212 == null) goto L350;
        r23 = 2131379555;
        TextView r213 = (TextView) ViewBindings.findChildViewById(r22, 2131379555);
        if (r213 == null) goto L350;
        MaxHeightLinearLayout r30 = r22;
        r23 = 2131379561;
        ImageView r31 = (ImageView) ViewBindings.findChildViewById(r22, 2131379561);
        if (r31 == null) goto L350;
        r23 = 2131379564;
        PreviewSwitchButton r32 = (PreviewSwitchButton) ViewBindings.findChildViewById(r22, 2131379564);
        if (r32 == null) goto L350;
        r23 = 2131379572;
        CustomMarkdownTextView r33 = ViewBindings.findChildViewById(r22, 2131379572);
        if (r33 == null) goto L350;
        r23 = 2131379573;
        if (ViewBindings.findChildViewById(r22, 2131379573) == null) goto L350;
        r23 = 2131379580;
        FrameLayout r34 = (FrameLayout) ViewBindings.findChildViewById(r22, 2131379580);
        if (r34 == null) goto L350;
        MarkdownRenderCodeViewLayoutBinding r58 = new MarkdownRenderCodeViewLayoutBinding(r30, r24, r25, r26, r27, r28, r29, r210, r211, r212, r213, r30, r31, r32, r33, r34);
        MarkdownRenderCodeViewLayoutBinding r59 = r35.Q;
        if (r59 == null) goto L116;
        CustomMarkdownTextView r60 = r59.o;
        if (r60 == null) goto L116;
        TextViewCompat.setLineHeight(r60, ((Number) MarkdownDimensExtKt.s.getValue()).intValue());
    L116:
        r35.Q = r58;
        if (r410 == null) goto L119;
        int r61 = r410.intValue();
    L120:
        r35.P = r61;
        MarkdownRenderCodeViewLayoutBinding r62 = r35.Q;
        if (r62 == null) goto L125;
        ImageView r63 = r62.i;
        if (r63 == null) goto L125;
        int r64 = 0;
        r63.setVisibility(0);
    L126:
        MarkdownRenderCodeViewLayoutBinding r65 = r35.Q;
        if (r65 == null) goto L131;
        ImageView r66 = r65.e;
        if (r66 == null) goto L131;
        r66.setVisibility(r64);
    L131:
        hh8.a r67 = r35.t;
        if (r67 != null) goto L134;
    L136:
        boolean r68 = false;
    L138:
        if (r68 == false) goto L168;
        MarkdownRenderCodeViewLayoutBinding r69 = r35.Q;
        if (r69 == null) goto L144;
        ImageView r70 = r69.g;
        if (r70 == null) goto L144;
        r70.setVisibility(8);
    L144:
        MarkdownRenderCodeViewLayoutBinding r71 = r35.Q;
        if (r71 == null) goto L149;
        ImageView r72 = r71.i;
        if (r72 == null) goto L149;
        r72.setVisibility(8);
    L149:
        MarkdownRenderCodeViewLayoutBinding r73 = r35.Q;
        if (r73 == null) goto L154;
        ImageView r74 = r73.m;
        if (r74 == null) goto L154;
        r74.setVisibility(8);
    L154:
        MarkdownRenderCodeViewLayoutBinding r75 = r35.Q;
        if (r75 == null) goto L159;
        ConstraintLayout r76 = r75.n;
        if (r76 == null) goto L159;
        r76.setVisibility(8);
    L159:
        MarkdownRenderCodeViewLayoutBinding r77 = r35.Q;
        if (r77 == null) goto L168;
        ImageView r78 = r77.e;
        if (r78 == null) goto L168;
        ViewGroup.LayoutParams r79 = r78.getLayoutParams();
        if (r79 == null) goto L167;
        RelativeLayout.LayoutParams r80 = (RelativeLayout.LayoutParams) r79;
        r80.removeRule(16);
        r80.addRule(21);
        r78.setLayoutParams(r80);
        goto L168
    L167:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L168:
        MarkdownRenderCodeViewLayoutBinding r81 = r35.Q;
        if (r81 == null) goto L179;
        TextView r82 = r81.h;
        if (r82 == null) goto L179;
        Context r83 = r35.getContext();
        if (r83 == null) goto L177;
        String r84 = r83.getString(2131906292);
        if (r84 == null) goto L177;
    L178:
        r82.setText(r84);
    L177:
        r84 = "";
    L179:
        MarkdownRenderCodeViewLayoutBinding r85 = r35.Q;
        if (r85 == null) goto L184;
        MaxHeightLinearLayout r86 = r85.a;
        if (r86 == null) goto L184;
        r86.setMaxHeight(r35.P);
    L184:
        if (r21 == null) goto L196;
        float r87 = r21.floatValue();
        MarkdownRenderCodeViewLayoutBinding r88 = r35.Q;
        if (r88 == null) goto L190;
        TextView r89 = r88.k;
        if (r89 == null) goto L190;
        int r90 = 0;
        r89.setTextSize(0, r87);
    L191:
        MarkdownRenderCodeViewLayoutBinding r91 = r35.Q;
        if (r91 == null) goto L196;
        CustomMarkdownTextView r92 = r91.o;
        if (r92 == null) goto L196;
        r92.setTextSize(r90, r87);
    L190:
        r90 = 0;
    L196:
        MarkdownRenderCodeViewLayoutBinding r93 = r35.Q;
        if (r93 == null) goto L201;
        TextView r94 = r93.h;
        if (r94 == null) goto L201;
        r94.setBackgroundResource(2131243916);
    L201:
        MarkdownRenderCodeViewLayoutBinding r95 = r35.Q;
        if (r95 == null) goto L208;
        TextView r96 = r95.h;
        if (r96 == null) goto L208;
        Drawable r97 = r96.getBackground();
        if (r97 == null) goto L208;
        Drawable r99 = r97.mutate();
    L210:
        if ((r99 instanceof GradientDrawable) == false) goto L212;
        GradientDrawable r100 = (GradientDrawable) r99;
    L213:
        if (r100 == null) goto L224;
        hh8.a r101 = r35.t;
        if (r101 == null) goto L219;
        Float r102 = r101.e;
        if (r102 == null) goto L219;
        float r103 = r102.floatValue();
        r100.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r103, r103, r103, r103});
    L219:
        MarkdownRenderCodeViewLayoutBinding r104 = r35.Q;
        if (r104 == null) goto L224;
        TextView r105 = r104.h;
        if (r105 == null) goto L224;
        r105.setBackground(r100);
    L224:
        hh8.a r106 = r35.t;
        if (r106 != null) goto L227;
    L299:
        r35.b = new r(r35, r9, r310, r10, r3, r36, r7);
        MarkdownRenderCodeViewLayoutBinding r107 = r35.Q;
        if (r107 == null) goto L304;
        ImageView r108 = r107.i;
        if (r108 == null) goto L304;
        e1.d(r108, new s(r35));
    L304:
        MarkdownRenderCodeViewLayoutBinding r109 = r35.Q;
        if (r109 == null) goto L309;
        ImageView r110 = r109.e;
        if (r110 == null) goto L309;
        e1.d(r110, new t(r35));
    L309:
        MarkdownRenderCodeViewLayoutBinding r111 = r35.Q;
        if (r111 == null) goto L314;
        ImageView r112 = r111.m;
        if (r112 == null) goto L314;
        e1.d(r112, new u(r35));
    L314:
        MarkdownRenderCodeViewLayoutBinding r113 = r35.Q;
        if (r113 == null) goto L319;
        TextView r114 = r113.h;
        if (r114 == null) goto L319;
        e1.d(r114, new v(r35));
    L319:
        MarkdownRenderCodeViewLayoutBinding r115 = r35.Q;
        if (r115 == null) goto L324;
        CustomMarkdownTextView r116 = r115.o;
        if (r116 == null) goto L324;
        e1.d(r116, new x(r35));
    L324:
        MarkdownRenderCodeViewLayoutBinding r117 = r35.Q;
        if (r117 == null) goto L329;
        CustomMarkdownTextView r118 = r117.o;
        if (r118 == null) goto L329;
        final by7.e r411 = r7;
        final Function0 r412 = r9;
        r118.setOnLongClickListener(new y(r35, r411, r36, r412, r310, r41));
    L329:
        MarkdownRenderCodeViewLayoutBinding r1 = r35.Q;
        if (r1 == null) goto L334;
        PreviewSwitchButton r119 = r1.n;
        if (r119 == null) goto L334;
        r119.setOnStateChangeListener(new k0(r35));
    L334:
        MarkdownRenderCodeViewLayoutBinding r120 = r35.Q;
        if (r120 == null) goto L339;
        ImageView r121 = r120.g;
        if (r121 == null) goto L339;
        e1.d(r121, new z(r35));
    L339:
        if (r410 == null) goto L341;
        final int r122 = r410.intValue();
    L342:
        MarkdownRenderCodeViewLayoutBinding r123 = r35.Q;
        if (r123 == null) goto L347;
        MaxHeightLinearLayout r124 = r123.a;
        if (r124 == null) goto L347;
        r124.addOnLayoutChangeListener(new p(r35, r122));
    L347:
        r35.u = System.currentTimeMillis();
        r35.f = true;
        return;
    L341:
        r122 = r35.M;
        goto L342
    L227:
        if (r106.b == false) goto L239;
        MarkdownRenderCodeViewLayoutBinding r125 = r35.Q;
        if (r125 == null) goto L233;
        RelativeLayout r126 = r125.j;
        if (r126 == null) goto L233;
        r126.setBackground(ContextCompat.getDrawable(r35.getContext(), 2131243915));
    L233:
        MarkdownRenderCodeViewLayoutBinding r127 = r35.Q;
        if (r127 == null) goto L267;
        View r128 = r127.b;
        if (r128 == null) goto L267;
        r128.setBackgroundColor(ContextCompat.getColor(r35.getContext(), v19.c.b(2130972087, r35.getContext(), 2131103162)));
    L267:
        if (Build.VERSION.SDK_INT < 23) goto L299;
        if (r106.a == false) goto L294;
        MarkdownRenderCodeViewLayoutBinding r129 = r35.Q;
        if (r129 == null) goto L275;
        MaxHeightLinearLayout r130 = r129.a;
        if (r130 == null) goto L275;
        r130.setForeground(ContextCompat.getDrawable(r35.getContext(), 2131243914));
    L275:
        MarkdownRenderCodeViewLayoutBinding r131 = r35.Q;
        if (r131 == null) goto L282;
        MaxHeightLinearLayout r132 = r131.a;
        if (r132 == null) goto L282;
        Drawable r133 = r132.getForeground();
        if (r133 == null) goto L282;
        Drawable r134 = r133.mutate();
    L284:
        if ((r134 instanceof GradientDrawable) == false) goto L286;
        GradientDrawable r135 = (GradientDrawable) r134;
    L287:
        if (r135 == null) goto L299;
        Integer r136 = r106.d;
        if (r136 == null) goto L291;
        r135.setStroke(r35.getContext().getResources().getDimensionPixelSize(2131165851), r136.intValue());
    L291:
        Float r137 = r106.e;
        if (r137 == null) goto L299;
        r135.setCornerRadius(r137.floatValue());
        goto L299
    L286:
        r135 = null;
    L282:
        r134 = null;
        goto L284
    L294:
        MarkdownRenderCodeViewLayoutBinding r138 = r35.Q;
        if (r138 == null) goto L299;
        MaxHeightLinearLayout r139 = r138.a;
        if (r139 == null) goto L299;
        r139.setForeground(null);
        goto L299
    L239:
        if (r106.c == false) goto L256;
        MarkdownRenderCodeViewLayoutBinding r140 = r35.Q;
        if (r140 == null) goto L245;
        MaxHeightLinearLayout r141 = r140.l;
        if (r141 == null) goto L245;
        Drawable r142 = null;
        r141.setBackground(null);
    L246:
        MarkdownRenderCodeViewLayoutBinding r143 = r35.Q;
        if (r143 == null) goto L251;
        RelativeLayout r144 = r143.j;
        if (r144 == null) goto L251;
        r144.setBackground(r142);
    L251:
        MarkdownRenderCodeViewLayoutBinding r145 = r35.Q;
        if (r145 == null) goto L267;
        View r146 = r145.b;
        if (r146 == null) goto L267;
        r146.setBackgroundColor(ContextCompat.getColor(r35.getContext(), v19.c.b(2130972087, r35.getContext(), 2131103162)));
    L245:
        r142 = null;
        goto L246
    L256:
        MarkdownRenderCodeViewLayoutBinding r147 = r35.Q;
        if (r147 == null) goto L261;
        RelativeLayout r148 = r147.j;
        if (r148 == null) goto L261;
        r148.setBackground(null);
    L261:
        MarkdownRenderCodeViewLayoutBinding r149 = r35.Q;
        if (r149 == null) goto L267;
        View r150 = r149.b;
        if (r150 == null) goto L267;
        r150.setBackgroundColor(ContextCompat.getColor(r35.getContext(), v19.c.b(2130970533, r35.getContext(), 2131102542)));
        goto L267
    L212:
        r100 = null;
    L208:
        r99 = null;
        goto L210
    L134:
        if (r67.f != true) goto L136;
        r68 = true;
    L125:
        r64 = 0;
        goto L126
    L119:
        r61 = r35.M;
    L350:
        throw new NullPointerException("Missing required view with ID: ".concat(r22.getResources().getResourceName(r23)));
    L351:
        return;
    L77:
        r20 = null;
        goto L78
    L73:
        r2 = r56;
        goto L74
    L69:
        r19 = r55;
        goto L71
    L65:
        r18 = r54;
        goto L67
    L61:
        r17 = r53;
        goto L62
    L57:
        r16 = r52;
        goto L58
    L53:
        r4 = r51;
        goto L55
    L49:
        r6 = r50;
        goto L51
    L45:
        r15 = r49;
        goto L47
    L41:
        r14 = r48;
        goto L43
    L37:
        r13 = r47;
        goto L39
    L33:
        r12 = r46;
        goto L35
    L29:
        r11 = r45;
        goto L31
    L25:
        r10 = r44;
        goto L27
    L21:
        r9 = r43;
        goto L23
    L17:
        r8 = r42;
        goto L19
    L13:
        r7 = r40;
        goto L15
    L9:
        r5 = r39;
        goto L11
    L5:
        r3 = r38;
        goto L7
    }
}
