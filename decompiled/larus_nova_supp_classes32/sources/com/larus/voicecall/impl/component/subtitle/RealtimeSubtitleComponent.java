package com.larus.voicecall.impl.component.subtitle;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.bytedance.keva.Keva;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.a1;
import com.larus.audio.call.subtitle.SubtitleAction;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.larus.platform.service.z2;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.larus.voicecall.impl.subtitle.q0;
import com.larus.voicecall.impl.ui.VoiceCallBgLayout;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.util.t0;
import com.larus.voicecall.impl.util.y0;
import com.lynx.canvas.camera.CameraSize;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ¥\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¥\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020kH\u0016J\u0010\u0010p\u001a\u00020k2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020k2\u0006\u0010t\u001a\u00020iH\u0002J\b\u0010u\u001a\u00020kH\u0002J\u0018\u0010v\u001a\u00020k2\u0006\u0010q\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0002J\u0018\u0010z\u001a\b\u0012\u0004\u0012\u00020|0{2\b\u0010}\u001a\u0004\u0018\u00010~H\u0002J\b\u0010\u007f\u001a\u00020kH\u0016J\u0013\u0010\u0080\u0001\u001a\u00020k2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\u001c\u0010\u0083\u0001\u001a\u00020k2\u0007\u0010\u0084\u0001\u001a\u00020i2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\u001c\u0010\u0085\u0001\u001a\u00020k2\u0007\u0010\u0086\u0001\u001a\u00020i2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016J\t\u0010\u0087\u0001\u001a\u00020iH\u0016J\t\u0010\u0088\u0001\u001a\u00020iH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020k2\u0007\u0010\u0084\u0001\u001a\u00020iH\u0002J\t\u0010\u008a\u0001\u001a\u00020kH\u0002J\u001c\u0010\u008b\u0001\u001a\u00020k2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010iH\u0002¢\u0006\u0003\u0010\u008d\u0001J\t\u0010\u008e\u0001\u001a\u00020kH\u0002J\u0019\u0010\u008f\u0001\u001a\u00020k2\u000e\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010{H\u0016J\u001f\u0010\u0092\u0001\u001a\u00020k2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J'\u0010\u0096\u0001\u001a\u0004\u0018\u00010S2\u0014\u0010\u0097\u0001\u001a\u000f\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020i0\u0098\u0001H\u0016¢\u0006\u0003\u0010\u0099\u0001J\u0013\u0010\u009a\u0001\u001a\u00020k2\b\u0010\u009b\u0001\u001a\u00030\u0082\u0001H\u0016J/\u0010\u009c\u0001\u001a\u00020k2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020S2\b\u0010 \u0001\u001a\u00030\u009e\u00012\u0007\u0010¡\u0001\u001a\u00020SH\u0016J\t\u0010¢\u0001\u001a\u00020kH\u0016J\u000b\u0010£\u0001\u001a\u0004\u0018\u00010gH\u0016J\t\u0010¤\u0001\u001a\u00020kH\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bO\u0010PR\u000e\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010T\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u000b\u001a\u0004\bV\u0010WR\u001d\u0010Y\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u000b\u001a\u0004\b[\u0010\\R\u001d\u0010^\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u000b\u001a\u0004\b`\u0010aR\u001b\u0010c\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u000b\u001a\u0004\bd\u0010FR\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/subtitle/RealtimeSubtitleComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "Lcom/larus/voicecall/impl/subtitle/ISubtitleHolderActionProvider;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "vlmAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVlmAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "vlmAbility$delegate", "videoSubtitleAbility", "Lcom/larus/voicecall/impl/component/videosubtitle/IVideoSubtitleAbility;", "getVideoSubtitleAbility", "()Lcom/larus/voicecall/impl/component/videosubtitle/IVideoSubtitleAbility;", "videoSubtitleAbility$delegate", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "feedbackAbility", "Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "getFeedbackAbility", "()Lcom/larus/voicecall/impl/component/feedback/IRealtimeCallFeedbackAbility;", "feedbackAbility$delegate", "curUiState", NameKeys.UnloadStrategy_No_Strategy, "voiceCallSubtitleLayout", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout;", "getVoiceCallSubtitleLayout", "()Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleLayout;", "voiceCallSubtitleLayout$delegate", "voiceCallContentLayout", "Lcom/larus/voicecall/impl/ui/VoiceCallContentLayout;", "getVoiceCallContentLayout", "()Lcom/larus/voicecall/impl/ui/VoiceCallContentLayout;", "voiceCallContentLayout$delegate", "subtitleButton", "Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "getSubtitleButton", "()Lcom/larus/common_ui/widget/roundlayout/CustomRoundImageView;", "subtitleButton$delegate", "stateManager", "getStateManager", "stateManager$delegate", "subtitleViewModel", "Lcom/larus/voicecall/impl/subtitle/RealtimeCallSubtitleViewModel;", "floatSubtitleMode", NameKeys.UnloadStrategy_No_Strategy, "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onConnectionStateChanged", "state", "Lcom/larus/im/internal/audio/context/SessionState;", "onVContextReady", "onViewCreated", "view", "Landroid/view/View;", "onSubtitleChange", "toOpen", "setupSubtitleListener", "tryShowPopupMenu", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", LynxResourceModule.DATA_KEY, "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "buildSubtitleMenuItems", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "message", "Lcom/larus/im/bean/message/Message;", "onSubtitleButtonClick", "closeSubtitle", "reason", NameKeys.UnloadStrategy_No_Strategy, "openSubtitle", "isAuto", "switchSubtitle", "floatSubtitle", "isSubtitleOpen", "isFloatSubtitle", "showSubtitleView", "dimInBackgroundContent", "dimOutBackgroundContent", "disableAnim", "(Ljava/lang/Boolean;)V", "hideSubtitleView", "insertFakePhotoPlaceHolder", "photoList", "Lcom/larus/voicecall/impl/subtitle/bean/ImageProcessorWrapper;", "appendImgMsgToQueue", "res", "Lcom/larus/bmhome/upload/audio/AudioUploadImgRes;", "rawData", "findLastTarHolderPos", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "appendSuggest", "suggest", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "onDestroy", "getSubtitleViewModel", "tryChangePipDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeSubtitleComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.subtitle.a, com.larus.voicecall.impl.subtitle.g {
    public static final /* synthetic */ int J = 0;
    public final Lazy A;
    public final Lazy B;
    public int C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public q0 H;
    public boolean I;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements y3a.a {
        public final /* synthetic */ RealtimeSubtitleComponent a;

        public b(RealtimeSubtitleComponent r1) {
            this.a = r1;
        }

        @Override // y3a.a
        public final void a(y3a.c r5) {
            Intrinsics.checkNotNullParameter(r5, "newEvent");
            if ((r5 instanceof y3a.d) == false) goto L39;
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[realtime_ball_video_debug] subtitle view visible change, toVisible=");
            y3a.d r6 = (y3a.d) r5;
            r1.append(r6.a);
            r1.append(", subtitleOpen=");
            RealtimeCallUtil.a.getClass();
            r1.append(RealtimeCallUtil.z);
            r1.append(", floatSubtitleMode=");
            r1.append(this.a.I);
            r1.append(", isFullVideo=");
            r1.append(((h88.b) this.a.C3()).r);
            r1.append(", isPipVideo=");
            r1.append(((h88.b) this.a.C3()).s);
            r1.append(", isVideoFullPreview=");
            com.larus.voicecall.impl.component.vlm.b r2 = this.a.E3();
            LinearLayout r3 = null;
            if (r2 == null) goto L7;
            Boolean r4 = Boolean.valueOf(r2.s6());
        L8:
            r1.append(r4);
            r1.append(", useTwoLine=");
            r1.append(z2.a.realtimeCallUseTwoLineStyle());
            r0.i("RealtimeSubtitleComponent", r1.toString());
            g3a.a r7 = this.a.B3();
            if (r7 == null) goto L14;
            VoiceCallBgLayout r8 = r7.Nl();
            if (r8 == null) goto L14;
            r3 = r8.a.d;
        L14:
            if (r6.a == false) goto L25;
            if (r3 == null) goto L17;
            e1.x(r3);
        L17:
            g3a.a r9 = this.a.B3();
            if (r9 == null) goto L32;
            VoiceCallContentLayout r10 = r9.dg();
            if (r10 == null) goto L32;
            Intrinsics.checkNotNullParameter("subtitle_view_visible_change_to_visible", "caller");
            if (r10.g == false) goto L32;
            r10.a.i.i();
            e1.o(r10.a.i);
        L32:
            FragmentActivity r11 = s1a.a.c(this.a).getActivity();
            if (r11 == null) goto L50;
            boolean r12 = v19.h.a;
            boolean r13 = v19.h.b(r11);
            if (r6.a == false) goto L37;
            y0.a(r11, !r13);
            return;
        L37:
            y0.a(r11, false);
            return;
        L50:
            return;
        L25:
            g3a.a r14 = this.a.B3();
            if (r14 == null) goto L30;
            VoiceCallContentLayout r15 = r14.dg();
            if (r15 == null) goto L30;
            r15.n6("subtitle_view_visible_change_to_gone");
        L30:
            if (r3 == null) goto L32;
            e1.o(r3);
            goto L32
        L7:
            r4 = null;
            goto L8
        L39:
            if ((r5 instanceof y3a.b) == false) goto L49;
            RealtimeSubtitleComponent r16 = this.a;
            int r17 = RealtimeSubtitleComponent.J;
            g3a.a r18 = r16.B3();
            if (r18 == null) goto L53;
            VoiceCallBgLayout r19 = r18.Nl();
            if (r19 == null) goto L54;
            LinearLayout r20 = r19.a.d;
            if (r20 == null) goto L55;
            r20.setAlpha(((y3a.b) r5).a);
            return;
        L55:
            return;
        L54:
            return;
        L53:
            return;
        L49:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void Ab() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onSubtitleButtonClick, useTwoLine=");
        r1.append(z2.a.realtimeCallUseTwoLineStyle());
        r1.append(", subtitleOpen=");
        RealtimeCallUtil.a.getClass();
        r1.append(RealtimeCallUtil.z);
        r1.append(", enableSubtitle=");
        r1.append(RealtimeCallUtil.k());
        r1.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r1.append(", shouldUseVideoSubtitle=");
        com.larus.voicecall.impl.component.videosubtitle.a r3 = D3();
        if (r3 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r3.Tr());
    L10:
        r1.append(r4);
        r1.append(", floatSubtitleMode=");
        r1.append(this.I);
        r1.append(", isFullVideo=");
        r1.append(((h88.b) C3()).r);
        r1.append(", isPipVideo=");
        r1.append(((h88.b) C3()).s);
        r1.append(", isScreenShare=");
        r1.append(((h88.b) C3()).t);
        r1.append(", useNewInteractionStyle=");
        r1.append(((h88.a) p3()).k0);
        r0.i("RealtimeSubtitleComponent", r1.toString());
        g3a.a r5 = B3();
        if (r5 == null) goto L18;
        SimpleDraweeView r6 = r5.kj();
        if (r6 == null) goto L18;
        Animation r7 = r6.getAnimation();
        if (r7 == null) goto L18;
        r7.cancel();
    L18:
        if (RealtimeCallUtil.z == false) goto L20;
        Zk("click_btn");
        return;
    L20:
        nV(false, "click_btn");
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public final g3a.a B3() {
        return (g3a.a) this.s.getValue();
    }

    public final e3a.b C3() {
        return (e3a.b) this.o.getValue();
    }

    public final com.larus.voicecall.impl.component.videosubtitle.a D3() {
        return (com.larus.voicecall.impl.component.videosubtitle.a) this.y.getValue();
    }

    public final com.larus.voicecall.impl.component.vlm.b E3() {
        return (com.larus.voicecall.impl.component.vlm.b) this.x.getValue();
    }

    public final VoiceCallContentLayout G3() {
        return (VoiceCallContentLayout) this.E.getValue();
    }

    public final RealtimeCallSubtitleLayout H3() {
        return (RealtimeCallSubtitleLayout) this.D.getValue();
    }

    public final void onDestroy() {
        RealtimeCallUtil.a.getClass();
        boolean r0 = RealtimeCallUtil.z;
        if (((Boolean) RealtimeCallUtil.C.getValue()).booleanValue() == false) goto L6;
        ((Keva) RealtimeCallUtil.n.getValue()).storeBoolean("key_record_subtitle_state", r0);
    L6:
        if (((h88.b) C3()).d == false) goto L11;
        if (RealtimeCallUtil.z == false) goto L11;
        FLogger.a.i("RealtimeSubtitleComponent", "rememberVideoSubtitleModeIfNeeded store, isFloatSubtitle=" + this.I);
        t0 r1 = t0.a;
        boolean r2 = this.I;
        r1.getClass();
        ((Keva) t0.b.getValue()).storeInt("VIDEO_SUBTITLE_MODE_WHEN_EXIT_REALTIME", r2 ? 1 : 0);
    L11:
        if (com.larus.voicecall.impl.tracer.w.a <= 0) goto L13;
        com.larus.voicecall.impl.tracer.w.b += System.currentTimeMillis() - com.larus.voicecall.impl.tracer.w.a;
    L13:
        q0 r3 = this.H;
        if (r3 == null) goto L26;
        FLogger r4 = FLogger.a;
        r4.i("RealtimeCallSubtitleViewModel", "destroy");
        r4.j("Realtime call", "Realtime call destroy");
        r3.a("destroy()");
        r3.p.removeCallbacksAndMessages(null);
        ReentrantLock r5 = r3.e;
        r5.lock();
        LinkedList<a78.a> r6 = r3.f;     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r6, "$this$operateDataSource");     // Catch: Throwable -> L23
        r6.clear();     // Catch: Throwable -> L23
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r5.unlock();
        r3.o.clear();
        Handler r8 = r3.l;
        if (r8 == null) goto L20;
        r8.removeCallbacksAndMessages(null);
    L20:
        r3.k.quitSafely();
        RealtimeCallUtil.z = false;
        com.larus.voicecall.impl.tracer.w.a = 0;
        com.larus.voicecall.impl.tracer.w.b = 0;
        com.larus.voicecall.impl.tracer.w.c = false;
        com.larus.voicecall.impl.tracer.w.d = null;
        if (ObricFeatureServiceDelegate.b.a() == false) goto L29;
        GlobalAudioObserver.a.c("tts_real_time_call", GlobalAudioStateEnum.STOPPED, null);
        return;
    L29:
        return;
    L23:
        th = move-exception;
        r5.unlock();
        throw th;
    }

    public final e3a.a p3() {
        return (e3a.a) this.n.getValue();
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final boolean xU() {
        RealtimeCallUtil.a.getClass();
        return RealtimeCallUtil.z;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.subtitle.a.class);
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.subtitle.b.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, c.class);
        return;
    }

    public final RealtimeCallService z3() {
        return (RealtimeCallService) this.q.getValue();
    }

    public RealtimeSubtitleComponent() {
        this.n = LazyKt.lazy(new o(this));
        this.o = LazyKt.lazy(new f(this));
        this.p = LazyKt.lazy(new g(this));
        this.q = LazyKt.lazy(new h(this));
        this.r = LazyKt.lazy(new i(this));
        this.s = LazyKt.lazy(new j(this));
        this.t = LazyKt.lazy(new k(this));
        this.u = LazyKt.lazy(new l(this));
        this.v = LazyKt.lazy(new m(this));
        this.w = LazyKt.lazy(new n(this));
        this.x = LazyKt.lazy(new z(this));
        this.y = LazyKt.lazy(new b0(this));
        this.z = LazyKt.lazy(new c0(this));
        this.A = LazyKt.lazy(new d0(this));
        this.B = LazyKt.lazy(new e0(this));
        this.C = -1;
        this.D = LazyKt.lazy(new f0(this));
        this.E = LazyKt.lazy(new g0(this));
        this.F = LazyKt.lazy(new h0(this));
        this.G = LazyKt.lazy(new e(this));
    }

    public final void A0() {
        p3();
        C3();
        z3();
        com.larus.voicecall.impl.component.scene.a r0 = (com.larus.voicecall.impl.component.scene.a) this.t.getValue();
        com.larus.voicecall.impl.component.core.a r1 = (com.larus.voicecall.impl.component.core.a) this.u.getValue();
        m3a.a r2 = (m3a.a) this.v.getValue();
        E3();
    }

    @Override // com.larus.voicecall.impl.subtitle.g
    public final void b0() {
        com.larus.voicecall.impl.component.vlm.b r0 = E3();
        if (r0 == null) goto L6;
        r0.X60();
        return;
    }

    public final void h3() {
        if (((h88.b) C3()).i == ThemeType.MAIN_BOT) goto L5;
    L9:
        ConstraintLayout r0 = G3();
        boolean r1 = true;
        if (r0 != null) goto L12;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == false) goto L23;
        ConstraintLayout r3 = G3();
        if (r3 == null) goto L23;
        float r4 = r3.getAlpha();
    L25:
        if (r4 == 1.0f) goto L28;
        r1 = false;
    L28:
        if (r1 == false) goto L30;
        return;
    L30:
        ConstraintLayout r5 = G3();
        if (r5 == null) goto L33;
        e1.x(r5);
    L33:
        VoiceCallContentLayout r6 = G3();
        if (r6 != null) goto L36;
    L41:
        VoiceCallContentLayout r7 = G3();
        if (r7 == null) goto L47;
        com.larus.voicecall.impl.utils.c.e(r7, r4, 1.0f);
        return;
    L47:
        return;
    L36:
        if (r6.d == false) goto L39;
        r6.a.s.setVisibility(0);
        goto L41
    L39:
        if (r6.e == false) goto L41;
        r6.a.q.setVisibility(0);
    L23:
        r4 = 0.0f;
        goto L25
    L12:
        if (r0.getVisibility() != 0) goto L14;
        boolean r8 = true;
    L15:
        if (r8 != true) goto L17;
        r2 = true;
        goto L18
    L14:
        r8 = false;
        goto L15
    L5:
        if (NewThemeSwitchAvatar.a() == false) goto L9;
        ConstraintLayout r9 = G3();
        if (r9 == null) goto L45;
        r9.setAlpha(1.0f);
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final q0 G00() {
        return this.H;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final boolean NT() {
        return this.I;
    }

    public final void I6(jd9.c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
        if ((r2 instanceof jd9.c.a) == false) goto L13;
        a1 r3 = z3().w();
        if (r3 == null) goto L8;
        r3.h2(((h88.a) p3()).k0);
    L8:
        if (z2.a.updateNetInfoAndSubtitleStatusEnabled() == false) goto L14;
        a1 r4 = z3().w();
        if (r4 == null) goto L15;
        RealtimeCallUtil.a.getClass();
        r4.e2(RealtimeCallUtil.z);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void Q3(boolean r3) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L6;
        ((w3a.k) this.G.getValue()).d(new w3a.m(r3));
    L6:
        if (z2.a.updateNetInfoAndSubtitleStatusEnabled() == false) goto L11;
        a1 r0 = z3().w();
        if (r0 == null) goto L12;
        r0.e2(r3);
        return;
    L12:
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final void Qn(String r12) {
        Intrinsics.checkNotNullParameter(r12, "suggest");
        q0 r1 = this.H;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r12, "suggest");
        q0.s(r1, SubtitleListUpdateType.ASR_NEW, null, r12, null, null, UUID.randomUUID().toString(), null, null, SpeechEvent.SERVER_DOWNLINK_EVENT_BOT_TRIGGERED);
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final void Va(List<x3a.a> r13) {
        Intrinsics.checkNotNullParameter(r13, "photoList");
        q0 r11 = this.H;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNullParameter(r13, "photoList");
        Iterator<T> r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        x3a.a r5 = (x3a.a) r14.next();
        q0.s(r11, SubtitleListUpdateType.INSERT_PHOTO, null, r5.a.e, r5, null, null, null, null, 240);
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r4v17, types: [android.view.View, com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout] */
    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void Zk(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == true) goto L5;
        return;
    L5:
        com.larus.voicecall.impl.component.vlm.b r0 = E3();
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[realtime_ball_video_debug] closeSubtitle begin, reason=");
        r4.append(r8);
        r4.append(", subtitleOpen=");
        r4.append(RealtimeCallUtil.z);
        r4.append(", floatSubtitleMode=");
        r4.append(this.I);
        r4.append(", isFullVideo=");
        r4.append(((h88.b) C3()).r);
        r4.append(", isPipVideo=");
        r4.append(((h88.b) C3()).s);
        r4.append(", isScreenShare=");
        r4.append(((h88.b) C3()).t);
        r4.append(", isVideoFullPreview=");
        r4.append(r2);
        r4.append(", useTwoLine=");
        r4.append(z2.a.realtimeCallUseTwoLineStyle());
        r4.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L14;
        boolean r5 = true;
    L15:
        r4.append(r5);
        r3.i("RealtimeSubtitleComponent", r4.toString());
        Q3(!RealtimeCallUtil.z);
        int r6 = c68.b.a;
        c68.b.d("RealtimeSubtitleComponent", "closeSubtitle, reason: ".concat(r8));
        ((IRealtimeCallTracer) this.r.getValue()).B(IRealtimeCallTracer.TotalTimeType.SUBTITLE, false);
        RealtimeCallUtil.z = false;
        CustomRoundImageView r7 = (CustomRoundImageView) this.F.getValue();
        if (r7 == null) goto L18;
        int r9 = com.larus.utils.j0.a;
        r7.setContentDescription(com.larus.utils.j0.d(2131900495));
    L18:
        m3a.a r10 = (m3a.a) this.v.getValue();
        if (r10 == null) goto L21;
        r10.cu();
    L21:
        ?? r11 = H3();
        if (r11 != 0) goto L24;
    L29:
        com.larus.voicecall.impl.component.videosubtitle.a r12 = D3();
        if (r12 == null) goto L32;
        r12.aX(false, LynxTouchEvent.EVENT_CLICK);
    L32:
        if (r2 == true) goto L40;
        StringBuilder r13 = new StringBuilder("[realtime_ball_video_debug] closeSubtitle will switchFullMode, reason=");
        r13.append(r8);
        r13.append(", runtimeFull=");
        r13.append(((h88.b) C3()).r);
        r13.append(", runtimePip=");
        r13.append(((h88.b) C3()).s);
        r13.append(", videoCaptureMayStartedByAbility=");
        if (E3() != null) goto L37;
        r1 = false;
    L37:
        r13.append(r1);
        r3.i("RealtimeSubtitleComponent", r13.toString());
        com.larus.voicecall.impl.component.vlm.b r14 = E3();
        if (r14 == null) goto L42;
        r14.m20();
        return;
    L42:
        return;
    L40:
        r3.i("RealtimeSubtitleComponent", "[realtime_ball_video_debug] closeSubtitle skip switchFullMode, reason=" + r8 + ", isVideoFullPreview=true");
        return;
    L24:
        if (r11.getVisibility() != 0) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == false) goto L29;
        r11.Z5();
        h3();
        goto L29
    L26:
        r15 = false;
        goto L27
    L14:
        r5 = false;
        goto L15
    L8:
        if (r0.s6() != true) goto L10;
        r2 = true;
        goto L11
    }

    public final void m3(Boolean r7) {
        boolean r0 = false;
        if (r7 == null) goto L5;
        boolean r8 = r7.booleanValue();
    L11:
        ConstraintLayout r2 = G3();
        if (r2 == null) goto L14;
        float r3 = r2.getAlpha();
    L16:
        if (((h88.b) C3()).i == ThemeType.MAIN_BOT) goto L18;
    L35:
        if (r8 == false) goto L45;
        ConstraintLayout r9 = G3();
        if (r9 == null) goto L39;
        r9.setAlpha(0.0f);
    L39:
        ConstraintLayout r10 = G3();
        if (r10 == null) goto L42;
        e1.o(r10);
    L42:
        VoiceCallContentLayout r11 = G3();
        if (r11 == null) goto L59;
        r11.a.q.setVisibility(4);
        r11.a.s.setVisibility(4);
        return;
    L59:
        return;
    L45:
        VoiceCallContentLayout r12 = G3();
        if (r12 == null) goto L48;
        com.larus.voicecall.impl.utils.c.e(r12, r3, 0.0f);
    L48:
        View r13 = s1a.a.getActivity(this).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L53;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L53;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L53:
        SafeExtKt.b(r13, new d(this), 300);
        return;
    L18:
        if (NewThemeSwitchAvatar.a() == false) goto L35;
        boolean r4 = v19.h.a;
        if (v19.h.a(null) == false) goto L22;
        float r5 = 0.15f;
    L24:
        if (r3 != r5) goto L26;
        r0 = true;
    L26:
        if (r0 == false) goto L28;
        return;
    L28:
        if (r8 == false) goto L32;
        ConstraintLayout r14 = G3();
        if (r14 == null) goto L55;
        r14.setAlpha(r5);
        return;
    L55:
        return;
    L32:
        VoiceCallContentLayout r15 = G3();
        if (r15 == null) goto L57;
        com.larus.voicecall.impl.utils.c.e(r15, r3, r5);
        return;
    L57:
        return;
    L22:
        r5 = 0.1f;
        goto L24
    L14:
        r3 = 0.0f;
        goto L16
    L5:
        com.larus.voicecall.impl.component.vlm.b r16 = E3();
        if (r16 != null) goto L8;
    L10:
        r8 = false;
        goto L11
    L8:
        if (r16.s6() != true) goto L10;
        r8 = true;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.voicecall.impl.component.subtitle.w] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.voicecall.impl.component.subtitle.v] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.voicecall.impl.component.subtitle.u] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.larus.voicecall.impl.component.subtitle.y] */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.larus.voicecall.impl.component.subtitle.t] */
    public final void onViewCreated(final View r13) {
        Intrinsics.checkNotNullParameter(r13, "view");
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.k() == true) goto L5;
        return;
    L5:
        z2 r0 = z2.a;
        boolean r2 = false;
        if (r0.realtimeCallUseTwoLineStyle() == false) goto L18;
        Pair<Boolean, Boolean> r1 = com.larus.voicecall.impl.l.i;
        if (com.larus.voicecall.impl.l.a.b(s1a.a.getActivity(this)) == true) goto L18;
        if (RealtimeCallUtil.z == false) goto L12;
        FLogger.a.i("RealtimeSubtitleComponent", "reset subtitle state for two-line style because record permission is missing");
    L12:
        RealtimeCallUtil.z = false;
        CustomRoundImageView r3 = (CustomRoundImageView) this.F.getValue();
        if (r3 == null) goto L15;
        int r4 = com.larus.utils.j0.a;
        r3.setContentDescription(com.larus.utils.j0.d(2131900495));
    L15:
        m3a.a r5 = (m3a.a) this.v.getValue();
        if (r5 == null) goto L18;
        r5.cu();
    L18:
        r13.post(new p(r13));
        RealtimeCallSubtitleLayout r14 = H3();
        if (r14 == null) goto L21;
        r14.setBotSpeakingProvider(new q(this));
    L21:
        RealtimeCallSubtitleLayout r15 = H3();
        if (r15 == null) goto L24;
        r15.setCurrentSceneMode(new r(this));
    L24:
        com.larus.voicecall.impl.component.scene.a r16 = (com.larus.voicecall.impl.component.scene.a) this.t.getValue();
        if (r16 == null) goto L27;
        r16.getCurrentScene();
    L27:
        RealtimeCallSubtitleLayout r17 = H3();
        if (r17 == null) goto L31;
        r17.setGetRealtimeCallTracer(new s(this));
    L31:
        if (com.larus.audio.call.f.f() == false) goto L33;
        final StateFlowImpl r6 = ((com.larus.audio.call.a) z3()).o;
        Flow<Integer> r7 = new RealtimeSubtitleComponent$onViewCreated$$inlined$map$1(r6);
    L34:
        com.larus.voicecall.impl.component.scene.a r8 = (com.larus.voicecall.impl.component.scene.a) this.t.getValue();
        if (r8 == null) goto L37;
        LiveData<com.larus.voicecall.impl.scene.m> r9 = r8.getCurrentScene();
    L38:
        Intrinsics.checkNotNullParameter(this, "<this>");
        q0 r18 = new q0(r7, r9, com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new com.larus.voicecall.impl.tracer.w.a(((h88.a) p3()).d, ((h88.b) C3()).a, ((h88.a) p3()).f, ((h88.a) p3()).t), (IRealtimeCallTracer) this.r.getValue(), new t(this));
        RealtimeCallService r10 = z3();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r18, "listener");
        r10.q().C0(r18);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new RealtimeSubtitleComponent$onViewCreated$7$1(r18, this, null), 3, null);
        this.H = r18;
        int r19 = m0.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (m0.b(com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext()) <= c7.b(Integer.valueOf(CameraSize.mediumHeight))) goto L47;
        ConstraintLayout r110 = H3();
        if (r110 == null) goto L47;
        ViewGroup.LayoutParams r11 = r110.getLayoutParams();
        if (r11 == null) goto L46;
        r11.width = c7.b(Integer.valueOf(CameraSize.mediumHeight));
        r110.setLayoutParams(r11);
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L47:
        CustomRoundImageView r111 = (CustomRoundImageView) this.F.getValue();
        if (r111 == null) goto L50;
        e1.d(r111, new x(this));
    L50:
        com.larus.voicecall.impl.component.scene.a r112 = (com.larus.voicecall.impl.component.scene.a) this.t.getValue();
        if (r112 == null) goto L55;
        LiveData<com.larus.voicecall.impl.scene.m> r113 = r112.getCurrentScene();
        if (r113 == null) goto L55;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r113.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new i0(new y(this)));
    L55:
        RealtimeCallSubtitleLayout r114 = H3();
        if (r114 == null) goto L59;
        r114.setSubtitleLongClickListener(new a0(this));
    L59:
        if (RealtimeCallUtil.f(((h88.b) C3()).d) == true) goto L61;
    L76:
        a1 r115 = z3().w();
        if (r115 == null) goto L79;
        r115.D1(new u(this));
    L79:
        a1 r116 = z3().w();
        if (r116 == null) goto L82;
        r116.w2(new v(this));
    L82:
        a1 r117 = z3().w();
        if (r117 == null) goto L86;
        r117.t2(new w(this));
        return;
    L86:
        return;
    L61:
        if (((h88.a) p3()).T == true) goto L76;
        if (((h88.a) p3()).k0 == true) goto L76;
        CustomRoundImageView r118 = (CustomRoundImageView) this.F.getValue();
        if (r118 != null) goto L67;
    L72:
        if (r2 == false) goto L74;
    L75:
        nV(true, "auto_open");
        goto L76
    L74:
        if (r0.realtimeCallUseTwoLineStyle() == false) goto L76;
    L67:
        if (r118.getVisibility() != 0) goto L69;
        boolean r119 = true;
    L70:
        if (r119 != true) goto L72;
        r2 = true;
        goto L72
    L69:
        r119 = false;
        goto L70
    L37:
        r9 = null;
        goto L38
    L33:
        r7 = ((com.larus.audio.call.a) z3()).k;
        goto L34
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final Integer wi(com.larus.voicecall.impl.component.picture.e r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        q0 r1 = this.H;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(r3, "block");
        ArrayList<com.larus.voicecall.impl.subtitle.c> r0 = r1.o;
        ListIterator<com.larus.voicecall.impl.subtitle.c> r2 = r0.listIterator(r0.size());
    L6:
        if (r2.hasPrevious() == false) goto L10;
        if (((Boolean) r3.invoke(r2.previous())).booleanValue() == false) goto L6;
        int r4 = r2.nextIndex();
    L17:
        return Integer.valueOf(r4);
    L10:
        r4 = -1;
        goto L17
    L12:
        return null;
    }

    /* JADX WARN: Type inference failed for: r9v16, types: [android.view.View, com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout] */
    /* JADX WARN: Type inference failed for: r9v19, types: [android.view.View, com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout] */
    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void Cf(boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == true) goto L6;
        FLogger.a.i("RealtimeSubtitleComponent", "switchSubtitle skip, subtitleOpen=false, floatSubtitle=" + r9 + ", reason=" + r10);
        return;
    L6:
        int r0 = c68.b.a;
        c68.b.d("RealtimeSubtitleComponent", "switchSubtitle, floatSubtitle: " + r9 + ", reason: " + r10);
        boolean r1 = true;
        if (r9 == true) goto L9;
    L11:
        boolean r4 = false;
    L12:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("switchSubtitle target, requestFloat=");
        r6.append(r9);
        r6.append(", targetFloat=");
        r6.append(r4);
        r6.append(", reason=");
        r6.append(r10);
        r6.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L15;
        boolean r11 = true;
    L16:
        r6.append(r11);
        r6.append(", currentFloatSubtitle=");
        r6.append(this.I);
        r6.append(", isFullVideo=");
        r6.append(((h88.b) C3()).r);
        r6.append(", isPipVideo=");
        r6.append(((h88.b) C3()).s);
        r5.i("RealtimeSubtitleComponent", r6.toString());
        this.I = r4;
        if (r4 == false) goto L29;
        com.larus.voicecall.impl.component.videosubtitle.a r12 = D3();
        if (r12 == null) goto L21;
        r12.aX(true, r10);
    L21:
        ?? r13 = H3();
        if (r13 != 0) goto L24;
        return;
    L24:
        if (r13.getVisibility() == 0) goto L27;
        r1 = false;
    L27:
        if (r1 == false) goto L42;
        r13.Z5();
        h3();
        return;
    L42:
        return;
    L29:
        com.larus.voicecall.impl.component.videosubtitle.a r14 = D3();
        if (r14 == null) goto L32;
        r14.aX(false, r10);
    L32:
        ?? r15 = H3();
        if (r15 != 0) goto L35;
        return;
    L35:
        if (r15.getVisibility() == 0) goto L38;
        r1 = false;
    L38:
        if (r1 == true) goto L45;
        r15.V5(this.H, C3(), this);
        r15.setVisible(false);
        m3(null);
        return;
    L45:
        return;
    L15:
        r11 = false;
        goto L16
    L9:
        if (D3() == null) goto L11;
        r4 = true;
        goto L12
    }

    @Override // com.larus.voicecall.impl.component.subtitle.c
    public final void TW(com.larus.bmhome.upload.audio.i r4, x3a.a r5) {
        Intrinsics.checkNotNullParameter(r4, "res");
        q0 r1 = this.H;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "res");
        if (r1.x.contains(r5.e) == false) goto L7;
        FLogger.a.e("RealtimeCallSubtitleViewModel", "appendImgMsgToQueue the same key add to queue. key=" + r5.e + " remote_url=" + r5.g);
        return;
    L7:
        r1.x.add(r5.e);
        r1.v.setValue(TuplesKt.to(r4, r5));
        return;
    }

    @Override // com.larus.voicecall.impl.component.subtitle.b
    public final void nV(boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "reason");
        Pair<Boolean, Boolean> r0 = com.larus.voicecall.impl.l.i;
        if (com.larus.voicecall.impl.l.a.b(s1a.a.getActivity(this)) == true) goto L6;
        FLogger.a.i("RealtimeSubtitleComponent", "openSubtitle skip, record permission is missing");
        return;
    L6:
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == false) goto L11;
        FLogger.a.i("RealtimeSubtitleComponent", "openSubtitle skip, already open, isAuto=" + r14 + ", reason=" + r15);
        return;
    L11:
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L17;
        if (com.larus.voicecall.impl.l.a.b(s1a.a.getActivity(this)) == true) goto L17;
        FLogger.a.i("RealtimeSubtitleComponent", "openSubtitle ignored because record permission is missing in two-line style, isAuto=" + r14 + ", reason=" + r15);
        return;
    L17:
        if (((h88.b) C3()).t == false) goto L20;
        FLogger.a.i("RealtimeSubtitleComponent", "openSubtitle ignored when screen sharing, isAuto=" + r14 + ", reason=" + r15);
        return;
    L20:
        com.larus.voicecall.impl.component.videosubtitle.a r1 = D3();
        boolean r3 = false;
        if (r1 != null) goto L23;
    L25:
        boolean r2 = false;
    L26:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("openSubtitle check float, isAuto=");
        r6.append(r14);
        r6.append(", reason=");
        r6.append(r15);
        r6.append(", useNewInteractionStyle=");
        r6.append(((h88.a) p3()).k0);
        r6.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L29;
        boolean r7 = true;
    L30:
        r6.append(r7);
        r6.append(", shouldUseVideoSubtitle=");
        r6.append(r2);
        r6.append(", isFullVideo=");
        r6.append(((h88.b) C3()).r);
        r6.append(", isPipVideo=");
        r6.append(((h88.b) C3()).s);
        r5.i("RealtimeSubtitleComponent", r6.toString());
        if (((h88.a) p3()).k0 == false) goto L36;
        if (r2 == true) goto L36;
        r5.i("RealtimeSubtitleComponent", "openSubtitle, isAuto: " + r14 + ", reason: " + r15 + ", useNewInteractionStyle: " + ((h88.a) p3()).k0);
        com.larus.voicecall.impl.component.vlm.b r8 = E3();
        if (r8 == null) goto L36;
        r8.Y80("onSubtitleOpen");
    L36:
        Q3(!RealtimeCallUtil.z);
        int r9 = c68.b.a;
        c68.b.d("RealtimeSubtitleComponent", "openSubtitle, isAuto: " + r14 + ", reason: " + r15);
        ((IRealtimeCallTracer) this.r.getValue()).B(IRealtimeCallTracer.TotalTimeType.SUBTITLE, true);
        RealtimeCallUtil.z = true;
        this.I = r2;
        StringBuilder r16 = new StringBuilder("openSubtitle result, floatSubtitleMode=");
        r16.append(this.I);
        r16.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L39;
        boolean r4 = true;
    L40:
        r16.append(r4);
        r16.append(", isFullVideo=");
        r16.append(((h88.b) C3()).r);
        r16.append(", isPipVideo=");
        r16.append(((h88.b) C3()).s);
        r5.i("RealtimeSubtitleComponent", r16.toString());
        CustomRoundImageView r17 = (CustomRoundImageView) this.F.getValue();
        if (r17 == null) goto L43;
        int r10 = com.larus.utils.j0.a;
        r17.setContentDescription(com.larus.utils.j0.d(2131900491));
    L43:
        m3a.a r18 = (m3a.a) this.v.getValue();
        if (r18 == null) goto L46;
        r18.kz();
    L46:
        StringBuilder r19 = new StringBuilder("showSubtitleView, isAuto=");
        r19.append(r14);
        r19.append(", floatSubtitleMode=");
        r19.append(this.I);
        r19.append(", videoSubtitleAbilityNull=");
        if (D3() != null) goto L49;
        r3 = true;
    L49:
        r19.append(r3);
        r19.append(", isFullVideo=");
        r19.append(((h88.b) C3()).r);
        r19.append(", isPipVideo=");
        r19.append(((h88.b) C3()).s);
        r5.i("RealtimeSubtitleComponent", r19.toString());
        if (this.I == false) goto L54;
        com.larus.voicecall.impl.component.videosubtitle.a r110 = D3();
        if (r110 == null) goto L64;
        r110.aX(true, LynxTouchEvent.EVENT_CLICK);
    L64:
        if (this.I == true) goto L69;
        com.larus.voicecall.impl.component.vlm.b r111 = E3();
        if (r111 == null) goto L70;
        r111.Y80("onSubtitleOpen");
        return;
    L70:
        return;
    L69:
        return;
    L54:
        RealtimeCallSubtitleLayout r112 = H3();
        if (r112 == null) goto L57;
        r112.V5(this.H, C3(), this);
    L57:
        RealtimeCallSubtitleLayout r113 = H3();
        if (r113 == null) goto L60;
        r113.setVisible(r14);
    L60:
        if (r14 == false) goto L62;
        m3(Boolean.TRUE);
        goto L64
    L62:
        m3(null);
        goto L64
    L39:
        r4 = false;
        goto L40
    L29:
        r7 = false;
        goto L30
    L23:
        if (r1.Tr() != true) goto L25;
        r2 = true;
        goto L26
    }

    public final void o1(MajorState r11, int r12, MajorState r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "currentMajorState");
        Intrinsics.checkNotNullParameter(r13, "newMajorState");
        q0 r0 = this.H;
        if (r0 != null) goto L5;
    L26:
        if (r14 == 14) goto L30;
        if (r14 == 15) goto L31;
        FLogger.a.i("RealtimeSubtitleComponent", "onUpdateUIState_RealtimeSubtitleComponent currentMajorState=" + r11 + " currentState=" + r12 + " newMajorState=" + r13 + " newState=" + r14);
        this.C = r14;
        return;
    L31:
        return;
    L30:
        return;
    L5:
        if (r14 == 14) goto L9;
        if (r14 == 15) goto L9;
        r0.q = r14;
    L9:
        if (ArraysKt.contains(new Integer[]{14, 7}, Integer.valueOf(r14)) == false) goto L13;
        if (r12 != 3) goto L13;
        int r3 = 2;
    L16:
        FLogger.a.i("RealtimeCallSubtitleViewModel", "updateCallState state:" + r3 + ", uiState:" + r12 + ", newState:" + r14);
        if (r3 == 2) goto L25;
        if (r3 != 3) goto L20;
        r0.h.tryEmit(new com.larus.voicecall.impl.subtitle.y0(SubtitleAction.LISTENING, 0, 0, false, 14));
        goto L26
    L20:
        if (r3 == 9) goto L25;
        if (r3 != 14) goto L26;
        r0.h.tryEmit(new com.larus.voicecall.impl.subtitle.y0(SubtitleAction.OTHER, 0, 0, false, 14));
    L25:
        r0.h.tryEmit(new com.larus.voicecall.impl.subtitle.y0(SubtitleAction.WAIT, 0, 0, false, 14));
    L13:
        if (ArraysKt.contains(new Integer[]{14, 15, 7, 8}, Integer.valueOf(r14)) == false) goto L15;
        r3 = r12;
        goto L16
    L15:
        r3 = r14;
        goto L16
    }
}
