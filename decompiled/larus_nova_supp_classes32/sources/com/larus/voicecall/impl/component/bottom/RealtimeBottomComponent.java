package com.larus.voicecall.impl.component.bottom;

import android.app.Application;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.component.BaseRealtimeBottomComponent;
import com.larus.av_call.databinding.LarusFragmentInstantCallBaseBinding;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.z0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeCallSuggestManager;
import com.larus.voicecall.impl.utils.RealtimeServerErrorDetail;
import com.larus.voicecall.impl.video.VideoPreviewState;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0098\u00012\u00020\u00012\u00020\u0002:\u0002\u0098\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020lH\u0016J\u0010\u0010n\u001a\u00020l2\u0006\u0010o\u001a\u00020pH\u0016J\u0012\u0010q\u001a\u00020l2\b\u0010r\u001a\u0004\u0018\u00010sH\u0002J\u0010\u0010t\u001a\u00020l2\u0006\u0010u\u001a\u00020[H\u0016J\u0010\u0010v\u001a\u00020l2\u0006\u0010w\u001a\u00020]H\u0016J\b\u0010x\u001a\u00020lH\u0016J\b\u0010y\u001a\u00020lH\u0002J\u0010\u0010z\u001a\u00020l2\u0006\u0010{\u001a\u00020]H\u0002J\u0010\u0010|\u001a\u00020l2\u0006\u0010}\u001a\u00020]H\u0002J\u0010\u0010~\u001a\u00020l2\u0006\u0010\u007f\u001a\u00020jH\u0002J\t\u0010\u0080\u0001\u001a\u00020lH\u0002J\u0012\u0010\u0081\u0001\u001a\u00020l2\u0007\u0010\u0082\u0001\u001a\u00020jH\u0002J\t\u0010\u0083\u0001\u001a\u00020lH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020l2\u0007\u0010\u0085\u0001\u001a\u00020]H\u0016J\u0014\u0010\u0086\u0001\u001a\u00020l2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010sH\u0016J\n\u0010d\u001a\u0004\u0018\u00010eH\u0016J\t\u0010\u0088\u0001\u001a\u00020]H\u0016J\u001b\u0010\u0089\u0001\u001a\u00020l2\u0007\u0010\u008a\u0001\u001a\u00020j2\u0007\u0010\u008b\u0001\u001a\u00020jH\u0016J1\u0010\u008c\u0001\u001a\u00020l2\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u008e\u00012\b\u0010\u0092\u0001\u001a\u00030\u0090\u0001H\u0016J\u0014\u0010\u0093\u0001\u001a\u00020l2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010jH\u0002J\u0013\u0010\u0095\u0001\u001a\u00020l2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000e\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000e\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000e\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u000e\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u000e\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u000e\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u000e\u001a\u0004\bM\u0010NR\u001d\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u000e\u001a\u0004\bR\u0010SR\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u000e\u001a\u0004\bW\u0010XR\u000e\u0010Z\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\u00020]8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010^R\u001d\u0010_\u001a\u0004\u0018\u00010`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u000e\u001a\u0004\ba\u0010bR\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020j0iX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/bottom/RealtimeBottomComponent;", "Lcom/larus/av_call/component/BaseRealtimeBottomComponent;", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "viewBinding", "Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "<init>", "(Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;)V", "getViewBinding", "()Lcom/larus/av_call/databinding/LarusFragmentInstantCallBaseBinding;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "interviewAbility", "Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "getInterviewAbility", "()Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "interviewAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "pictureAbility", "Lcom/larus/voicecall/impl/component/picture/IRealtimePictureAbility;", "getPictureAbility", "()Lcom/larus/voicecall/impl/component/picture/IRealtimePictureAbility;", "pictureAbility$delegate", "vlmAbility", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "getVlmAbility", "()Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "vlmAbility$delegate", "traceAbility", "Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "getTraceAbility", "()Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "traceAbility$delegate", "subtitleAbility", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "getSubtitleAbility", "()Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "subtitleAbility$delegate", "netNoticeAbility", "Lcom/larus/voicecall/impl/component/net/IRealtimeNetNoticeAbility;", "getNetNoticeAbility", "()Lcom/larus/voicecall/impl/component/net/IRealtimeNetNoticeAbility;", "netNoticeAbility$delegate", "continueTalkAbility", "Lcom/larus/voicecall/impl/continue_talk/IRealtimeCallContinuousTalkAbility;", "getContinueTalkAbility", "()Lcom/larus/voicecall/impl/continue_talk/IRealtimeCallContinuousTalkAbility;", "continueTalkAbility$delegate", "suggestManager", "Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager;", "getSuggestManager", "()Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager;", "suggestManager$delegate", "curTaskState", "Lcom/larus/im/internal/audio/context/SessionState;", "isCurStatePseudo", NameKeys.UnloadStrategy_No_Strategy, "()Z", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "voiceCallBottomLayout", "Lcom/larus/av_call/view/VoiceCallBottomLayout;", "lastSceneIsInterpret", "hasAppliedInterpretPlayerMute", "displayedServerErrorKeys", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onVContextReady", "onViewCreated", "view", "Landroid/view/View;", "updateBottomUIForInterpret", "selected", "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "onConnectionStateChanged", "state", "setBadNetStateNoticeVisible", "isVisible", "onDestroy", "setListeners", "updateMoreButtonClickForScreenShare", "isScreenShare", "handleScreenShareClick", "isScreenShareSelected", "trackPlayerMuteEvent", "toStatus", "initRealtimeSuggest", "showRealtimeSuggest", "showFrom", "hideRealtimeSuggest", "onUpdatePermission", "hasPermission", "updateScene", "scene", "isUsingDoubleLineCallUI", "showVoiceCallConnectInfo", "info", "copyText", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", NameKeys.UnloadStrategy_No_Strategy, "newMajorState", "newState", "showServerErrorIfNeeded", "rawDetail", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeBottomComponent extends BaseRealtimeBottomComponent implements com.larus.voicecall.impl.component.bottom.b {
    public static final /* synthetic */ int Q = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public jd9.c K;
    public final Lazy L;
    public VoiceCallBottomLayout M;
    public boolean N;
    public boolean O;
    public final Set<String> P;
    public final LarusFragmentInstantCallBaseBinding t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RealtimeServerErrorDetail.Presentation.values().length];
            r0[RealtimeServerErrorDetail.Presentation.TOAST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[RealtimeServerErrorDetail.Presentation.ALERT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[RealtimeServerErrorDetail.Presentation.SILENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[RealtimeServerErrorDetail.Presentation.HANGUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements w3a.i {
        public final /* synthetic */ RealtimeBottomComponent a;

        public c(RealtimeBottomComponent r1) {
            this.a = r1;
        }

        @Override // w3a.i
        public final void a(w3a.h r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            if ((r6 instanceof w3a.o) == false) goto L17;
            VoiceCallBottomLayout r0 = this.a.M;
            if (r0 == null) goto L7;
            r0.T7();
        L7:
            RealtimeBottomComponent r1 = this.a;
            jd9.c.a r2 = r1.K;
            if (((w3a.o) r6).a != VideoPreviewState.close) goto L10;
            return;
        L10:
            if ((r2 instanceof jd9.c.a) == true) goto L12;
            return;
        L12:
            if (r2.c == false) goto L69;
            VoiceCallBottomLayout r7 = r1.M;
            if (r7 == null) goto L70;
            r7.A8();
            return;
        L70:
            return;
        L69:
            return;
        L17:
            if ((r6 instanceof w3a.l) == false) goto L55;
            z2 r3 = z2.a;
            boolean r4 = true;
            if (r3.realtimeCallUseTwoLineStyle() == false) goto L40;
            w3a.l r5 = (w3a.l) r6;
            if (r5.a == false) goto L25;
            RealtimeBottomComponent r8 = this.a;
            int r9 = RealtimeBottomComponent.Q;
            com.larus.voicecall.impl.component.subtitle.a r10 = r8.C3();
            if (r10 == null) goto L25;
            r10.Zk("open_screen_share");
        L25:
            VoiceCallBottomLayout r11 = this.a.M;
            if (r11 == null) goto L28;
            r11.setSubtitleButtonClickEnabled(!r5.a);
        L28:
            VoiceCallBottomLayout r12 = this.a.M;
            if (r12 == null) goto L31;
            r12.a8();
        L31:
            RealtimeBottomComponent r13 = this.a;
            boolean r14 = r5.a;
            r13.getClass();
            if (r3.realtimeCallUseTwoLineStyle() == false) goto L40;
            VoiceCallBottomLayout r15 = r13.M;
            if (r15 == null) goto L40;
            RealtimeBottomMoreBtn r16 = r15.y7();
            if (r16 == null) goto L40;
            e1.d(r16, new w(r14, r13));
        L40:
            if (((w3a.l) r6).a == false) goto L72;
            RealtimeBottomComponent r17 = this.a;
            jd9.c.a r18 = r17.K;
            if ((r18 instanceof jd9.c.a) == false) goto L44;
            jd9.c.a r19 = r18;
        L45:
            if (r19 != null) goto L47;
        L49:
            r4 = false;
        L50:
            if (r4 == false) goto L73;
            VoiceCallBottomLayout r20 = r17.M;
            if (r20 == null) goto L74;
            r20.A8();
            return;
        L74:
            return;
        L73:
            return;
        L47:
            if (r19.c != true) goto L49;
        L44:
            r19 = null;
            goto L45
        L72:
            return;
        L55:
            if ((r6 instanceof w3a.a) == false) goto L60;
            VoiceCallBottomLayout r21 = this.a.M;
            if (r21 == null) goto L76;
            r21.a8();
            return;
        L76:
            return;
        L60:
            if ((r6 instanceof w3a.m) == true) goto L62;
            return;
        L62:
            if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L79;
            VoiceCallBottomLayout r22 = this.a.M;
            if (r22 == null) goto L80;
            r22.S9(((w3a.m) r6).a);
            return;
        L80:
            return;
        }
    }

    public static final class d implements l3a.c {
        public final /* synthetic */ RealtimeBottomComponent a;

        public d(RealtimeBottomComponent r1) {
            this.a = r1;
        }

        @Override // l3a.c
        public final void a(com.larus.voicecall.impl.scene.m r11) {
            boolean r0 = true;
            com.larus.av_call.view.c r1 = null;
            if (r11 == null) goto L17;
            RealtimeBottomComponent r3 = this.a;
            jd9.c.a r4 = r3.K;
            if ((r4 instanceof jd9.c.a) == false) goto L7;
            jd9.c.a r5 = r4;
        L8:
            if (r5 != null) goto L10;
        L12:
            boolean r6 = false;
        L13:
            if (r6 == false) goto L17;
            VoiceCallBottomLayout r7 = r3.M;
            if (r7 == null) goto L17;
            r7.n8();
            r7.E8();
            goto L17
        L10:
            if (r5.c != true) goto L12;
            r6 = true;
            goto L13
        L7:
            r5 = null;
        L17:
            z2 r8 = z2.a;
            if (r8.getRealtimeCallTranslatorConfig().c() == true) goto L20;
            return;
        L20:
            if (this.a.Z40() == true) goto L80;
            RealtimeBottomComponent r9 = this.a;
            if (r11 == null) goto L59;
            r9.getClass();
            if (u3a.f.e() == false) goto L59;
            r9.N = true;
            FLogger.a.d("RealtimeBottomComponent", "enabledTtsInitialStatus = " + r8.getRealtimeCallTranslatorConfig().d());
            Keva r10 = u3a.f.a();
            String r12 = u3a.f.c;
            boolean r13 = r10.getBoolean(r12, r8.getRealtimeCallTranslatorConfig().d());
            ((h88.b) r9.z3()).v = r13;
            if (r11.b != 2) goto L36;
            if (r13 == false) goto L32;
            com.larus.voicecall.impl.component.core.a r14 = r9.p3();
            if (r14 == null) goto L31;
            r14.nr();
        L31:
            u3a.f.a().storeBoolean(r12, true);
            r9.O = true;
            goto L36
        L32:
            com.larus.voicecall.impl.component.core.a r15 = r9.p3();
            if (r15 == null) goto L35;
            r15.cJ();
        L35:
            u3a.f.a().storeBoolean(r12, false);
            r9.O = false;
        L36:
            VoiceCallBottomLayout r16 = r9.M;
            if (r16 == null) goto L81;
            com.larus.av_call.view.c r17 = r16.a;
            if (r17 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        L42:
            FrameLayout r18 = (FrameLayout) r16.findViewById(2131392668);
            if (r18 == null) goto L45;
            e1.o(r18);
        L45:
            FrameLayout r19 = (FrameLayout) r16.findViewById(2131383816);
            if (r19 == null) goto L48;
            e1.x(r19);
        L48:
            View r2 = r1.e();
            if (r2 == null) goto L57;
            Application r20 = i88.e.a;
            h88.b r21 = r16.f;
            if (r21 != null) goto L53;
        L55:
            r0 = false;
        L56:
            i88.e.f(r2, r0, r16.i);
            goto L57
        L53:
            if (r21.v != true) goto L55;
        L57:
            r16.c6();
            return;
        L41:
            r1 = r17;
            goto L42
        L81:
            return;
        L59:
            if (r9.N == true) goto L61;
        L68:
            if (r11 != null) goto L70;
        L72:
            r0 = false;
        L73:
            if (r0 == true) goto L75;
            r9.N = false;
        L75:
            VoiceCallBottomLayout r110 = r9.M;
            if (r110 == null) goto L83;
            r110.w8();
            return;
        L83:
            return;
        L70:
            if (r11.b != 2) goto L72;
        L61:
            if (((h88.b) r9.z3()).v == false) goto L68;
            FLogger.a.i("RealtimeBottomComponent", "restore player mute state on scene change. selected=" + r11 + " room_id=" + ((h88.b) r9.z3()).c);
            ((h88.b) r9.z3()).v = false;
            if (r9.O == false) goto L68;
            com.larus.voicecall.impl.component.core.a r22 = r9.p3();
            if (r22 == null) goto L67;
            r22.cJ();
        L67:
            r9.O = false;
            goto L68
        }
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.u.getValue();
    }

    public final com.larus.voicecall.impl.component.scene.a B3() {
        return (com.larus.voicecall.impl.component.scene.a) this.C.getValue();
    }

    public final com.larus.voicecall.impl.component.subtitle.a C3() {
        return (com.larus.voicecall.impl.component.subtitle.a) this.G.getValue();
    }

    public final RealtimeCallSuggestManager D3() {
        return (RealtimeCallSuggestManager) this.J.getValue();
    }

    public final n3a.a E3() {
        return (n3a.a) this.F.getValue();
    }

    @Override // com.larus.voicecall.impl.component.bottom.b
    public final boolean Z40() {
        VoiceCallBottomLayout r0 = this.M;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.p != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final e3a.a h3() {
        return (e3a.a) this.v.getValue();
    }

    public final RealtimeCallService m3() {
        return (RealtimeCallService) this.x.getValue();
    }

    public final void onDestroy() {
        VoiceCallBottomLayout r0 = this.M;
        if (r0 == null) goto L14;
        com.larus.av_call.view.c r1 = r0.a;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r1 = null;
    L7:
        com.larus.av_call.view.o r2 = r1.i().getDelegate();
        Handler r3 = r2.d;
        if (r3 != null) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L15;
        l0.b(new com.larus.av_call.view.j(r3));
        r2.a.invoke(null, -1);
        r2.g = 0;
        return;
    L15:
        return;
    }

    public final com.larus.voicecall.impl.component.core.a p3() {
        return (com.larus.voicecall.impl.component.core.a) this.A.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.bottom.b.class);
    }

    public final e3a.b z3() {
        return (e3a.b) this.w.getValue();
    }

    public final void A0() {
        h3();
        z3();
        m3();
        com.larus.voicecall.impl.component.window.b r0 = (com.larus.voicecall.impl.component.window.b) this.z.getValue();
        p3();
        B3();
        com.larus.voicecall.impl.component.picture.b r1 = (com.larus.voicecall.impl.component.picture.b) this.D.getValue();
        com.larus.voicecall.impl.component.vlm.b r2 = (com.larus.voicecall.impl.component.vlm.b) this.E.getValue();
        E3();
        C3();
    }

    public final void G3() {
        RealtimeCallSuggestManager r0 = D3();
        RealtimeBottomComponent$hideRealtimeSuggest$1 r1 = new RealtimeBottomComponent$hideRealtimeSuggest$1(this, null);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        boolean r2 = ((h88.a) r0.b).m;
    }

    @Override // com.larus.voicecall.impl.component.bottom.b
    public final VoiceCallBottomLayout BT() {
        return this.M;
    }

    public RealtimeBottomComponent(LarusFragmentInstantCallBaseBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "viewBinding");
        super(r2);
        this.t = r2;
        this.u = LazyKt.lazy(new e(this));
        this.v = LazyKt.lazy(new m(this));
        this.w = LazyKt.lazy(new o(this));
        this.x = LazyKt.lazy(new p(this));
        this.y = LazyKt.lazy(new q(this));
        this.z = LazyKt.lazy(new r(this));
        this.A = LazyKt.lazy(new s(this));
        this.B = LazyKt.lazy(new t(this));
        this.C = LazyKt.lazy(new u(this));
        this.D = LazyKt.lazy(new v(this));
        this.E = LazyKt.lazy(new f(this));
        this.F = LazyKt.lazy(new g(this));
        this.G = LazyKt.lazy(new h(this));
        this.H = LazyKt.lazy(new i(this));
        this.I = LazyKt.lazy(new j(this));
        this.J = LazyKt.lazy(new k(this));
        this.K = jd9.c.f.c;
        this.L = LazyKt.lazy(new l(this));
        this.P = new LinkedHashSet();
    }

    public final void D9(z0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        boolean r1 = false;
        if ((r4 instanceof pf9.o) == false) goto L14;
        VoiceCallBottomLayout r5 = this.M;
        if (r5 == null) goto L25;
        h88.b r0 = r5.f;
        if (r0 != null) goto L9;
    L11:
        if (r1 == false) goto L26;
        r5.H6(true);
        return;
    L26:
        return;
    L9:
        if (r0.m == true) goto L11;
        r1 = true;
        goto L11
    L25:
        return;
    L14:
        if ((r4 instanceof pf9.z) == false) goto L20;
        VoiceCallBottomLayout r6 = this.M;
        if (r6 == null) goto L18;
        r6.H7();
    L18:
        G3();
        boolean r7 = ((h88.a) D3().b).m;
        return;
    L20:
        if ((r4 instanceof pf9.a0) == false) goto L29;
        VoiceCallBottomLayout r8 = this.M;
        if (r8 == null) goto L30;
        int r2 = VoiceCallBottomLayout.D;
        r8.J7(false);
        return;
    L30:
        return;
    }

    public final void H3(String r5) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("call_id", z3().a().e);
        r1.put("call_background_mode", LynxResourceModule.AUDIO_TYPE);
        r1.put("to_status", r5);
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r6 = RealtimeCallUtil.l;
        if (r6 == null) goto L8;
        SceneModel r7 = r6.a;
        if (r7 == null) goto L8;
        String r8 = r7.getKey();
        if (r8 == null) goto L8;
    L9:
        r1.put("call_scene", r8);
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("click_speaker", r1);
        return;
    L8:
        r8 = "other";
        goto L9
    }

    public final void I6(jd9.c r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r4, "state");
        FLogger.a.d("RealtimeBottomComponent", "onConnectionStateChanged new state=" + r4);
        this.K = r4;
    }

    @Override // com.larus.voicecall.impl.component.bottom.b
    public final void O1(boolean r5) {
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L24;
        boolean r0 = true;
        if (r5 == true) goto L16;
        com.larus.voicecall.impl.component.subtitle.a r2 = C3();
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L16;
        com.larus.voicecall.impl.component.subtitle.a r4 = C3();
        if (r4 == null) goto L16;
        r4.Zk("no_record_permission");
        goto L16
    L9:
        if (r2.xU() != true) goto L11;
        r3 = true;
    L16:
        VoiceCallBottomLayout r6 = this.M;
        if (r6 == null) goto L24;
        if (r5 == true) goto L20;
    L22:
        r0 = false;
    L23:
        r6.setSubtitleButtonClickEnabled(r0);
        goto L24
    L20:
        if (((h88.b) z3()).t == true) goto L22;
    L24:
        VoiceCallBottomLayout r1 = this.M;
        if (r1 == null) goto L28;
        r1.E9(r5);
        return;
    }

    @Override // com.larus.voicecall.impl.component.bottom.b
    public final void QT(com.larus.voicecall.impl.scene.m r2) {
        VoiceCallBottomLayout r0 = this.M;
        if (r0 == null) goto L11;
        if (r2 == null) goto L8;
        SceneModel r3 = r2.a;
        if (r3 == null) goto L8;
        String r4 = r3.getKey();
    L9:
        r0.K9(r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.larus.voicecall.impl.component.bottom.b
    public final void ci(boolean r2) {
        VoiceCallBottomLayout r0 = this.M;
        if (r0 == null) goto L6;
        r0.N8(r2);
        return;
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        this.t.b.setLayoutResource(2131562428);
        ConstraintLayout r7 = this.t.b.inflate();
        int r0 = 2131367685;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131367685)) == null) goto L105;
        r0 = 2131392657;
        VoiceCallBottomLayout r1 = ViewBindings.findChildViewById(r7, 2131392657);
        if (r1 == null) goto L105;
        this.M = r1;
        r1.setNeedShowBadNetNoticeBlock(new com.larus.voicecall.impl.component.bottom.c(this));
        VoiceCallBottomLayout r8 = this.M;
        if (r8 == null) goto L9;
        r8.setTracerProvider(new n(this));
    L9:
        VoiceCallBottomLayout r9 = this.M;
        if (r9 == null) goto L12;
        r9.setInSceneMode(new y(this));
    L12:
        z2 r10 = z2.a;
        boolean r2 = false;
        if (r10.realtimeCallUseTwoLineStyle() == false) goto L32;
        VoiceCallBottomLayout r3 = this.M;
        if (r3 == null) goto L23;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.k() == true) goto L19;
    L21:
        boolean r4 = false;
    L22:
        r3.setSubtitleButtonEnabled(r4);
        goto L23
    L19:
        if (C3() == null) goto L21;
        r4 = true;
    L23:
        VoiceCallBottomLayout r5 = this.M;
        if (r5 == null) goto L32;
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L30;
        r11.getAccountService();
        if (com.larus.home.impl.sdk.d.a.a() != true) goto L30;
        boolean r12 = true;
    L31:
        r5.setMinorModeEnabled(r12);
    L30:
        r12 = false;
    L32:
        VoiceCallBottomLayout r13 = this.M;
        if (r13 == null) goto L36;
        r13.o7(h3(), z3());
    L36:
        if (r10.realtimeCallUseTwoLineStyle() == false) goto L52;
        Pair<Boolean, Boolean> r14 = com.larus.voicecall.impl.l.i;
        boolean r15 = com.larus.voicecall.impl.l.a.b(getActivity());
        VoiceCallBottomLayout r16 = this.M;
        if (r16 == null) goto L45;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.z == false) goto L43;
        if (r15 == false) goto L43;
        boolean r17 = true;
    L44:
        r16.S9(r17);
    L43:
        r17 = false;
    L45:
        VoiceCallBottomLayout r18 = this.M;
        if (r18 == null) goto L52;
        if (r15 == true) goto L49;
    L51:
        r18.setSubtitleButtonClickEnabled(r2);
        goto L52
    L49:
        if (((h88.b) z3()).t == true) goto L51;
        r2 = true;
    L52:
        VoiceCallBottomLayout r19 = this.M;
        if (r19 == null) goto L55;
        r19.setNeedRefreshMoreBtn(new c0(this));
    L55:
        int r20 = com.larus.utils.u.b(getActivity());
        ViewStub r21 = this.t.b;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L103;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        r23.bottomMargin = r20;
        r21.setLayoutParams(r23);
        VoiceCallBottomLayout r24 = this.M;
        if (r24 == null) goto L60;
        View r25 = r24.getVoiceCallHangup();
    L61:
        e1.d(r25, new d0(this));
        VoiceCallBottomLayout r26 = this.M;
        if (r26 == null) goto L65;
        r26.setTakePhotoBtnClickListener(new e0(this));
    L65:
        if (r10.realtimeCallUseTwoLineStyle() == false) goto L77;
        boolean r27 = ((h88.b) z3()).t;
        if (r10.realtimeCallUseTwoLineStyle() == false) goto L74;
        VoiceCallBottomLayout r28 = this.M;
        if (r28 == null) goto L74;
        RealtimeBottomMoreBtn r29 = r28.y7();
        if (r29 == null) goto L74;
        e1.d(r29, new w(r27, this));
    L74:
        VoiceCallBottomLayout r30 = this.M;
        if (r30 == null) goto L77;
        r30.setSubtitleBtnClickListener(new f0(this));
    L77:
        VoiceCallBottomLayout r31 = this.M;
        if (r31 == null) goto L80;
        View r32 = r31.getRealtimeCallMute();
    L81:
        e1.d(r32, new g0(this));
        VoiceCallBottomLayout r33 = this.M;
        if (r33 == null) goto L86;
        View r34 = r33.getPlayerMuteBtn();
        if (r34 == null) goto L86;
        e1.d(r34, new h0(this));
    L86:
        VoiceCallBottomLayout r35 = this.M;
        if (r35 == null) goto L89;
        View r36 = r35.getRealtimeCallHotArea();
    L90:
        e1.d(r36, new i0(this));
        VoiceCallBottomLayout r37 = this.M;
        if (r37 == null) goto L95;
        View r38 = r37.getScreenShareButton();
        if (r38 == null) goto L95;
        e1.d(r38, new com.larus.voicecall.impl.component.bottom.d(this));
    L95:
        RealtimeCallSuggestManager r39 = D3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleOwner r40 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner();
        RealtimeBottomComponent$initRealtimeSuggest$1 r41 = new RealtimeBottomComponent$initRealtimeSuggest$1(this, null);
        RealtimeBottomComponent$initRealtimeSuggest$2 r42 = new RealtimeBottomComponent$initRealtimeSuggest$2(this, null);
        r39.getClass();
        Intrinsics.checkNotNullParameter(r40, "lifecycle");
        Intrinsics.checkNotNullParameter(r41, "onInit");
        Intrinsics.checkNotNullParameter(r42, "onUpdate");
        boolean r43 = ((h88.a) r39.b).m;
        w3a.k r44 = (w3a.k) this.L.getValue();
        if (r44 == null) goto L98;
        r44.c(new c(this));
    L98:
        com.larus.voicecall.impl.component.scene.a r45 = B3();
        if (r45 == null) goto L106;
        r45.yM(new d(this));
        return;
    L106:
        return;
    L89:
        r36 = null;
        goto L90
    L80:
        r32 = null;
        goto L81
    L60:
        r25 = null;
        goto L61
    L103:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L105:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }

    @Override // com.larus.voicecall.impl.component.bottom.b
    public final void sG(final String r4, final String r5) {
        Intrinsics.checkNotNullParameter(r4, "info");
        Intrinsics.checkNotNullParameter(r5, "copyText");
        Lazy r0 = com.larus.voicecall.impl.p.a;
        AppHost.Companion r1 = AppHost.a;
        boolean r2 = false;
        if (r1.isDebug() == false) goto L5;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        r2 = ((Keva) com.larus.voicecall.impl.p.a.getValue()).getBoolean("realtime_call_hide_connect_info", false);
    L14:
        if (r2 == false) goto L16;
        return;
    L16:
        this.t.a.post(new z(this, r4, r5));
        return;
    L5:
        if (r1.isTestChannel() == true) goto L10;
        if (r1.isDebugChannel() == true) goto L10;
        r3 = false;
        goto L11
    }

    public final void o1(MajorState r23, int r24, MajorState r25, int r26) {
        Intrinsics.checkNotNullParameter(r23, "currentMajorState");
        Intrinsics.checkNotNullParameter(r25, "newMajorState");
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[CALL] onUpdateUIState, current state : ");
        r5.append(r23);
        r5.append(',');
        r5.append(r24);
        r5.append(',');
        InstanceCallState.Companion.getClass();
        r5.append(InstanceCallState.a.a(r24));
        r5.append(" --> new state: ");
        r5.append(r25);
        r5.append(',');
        r5.append(r26);
        r5.append(',');
        r5.append(InstanceCallState.a.a(r26));
        r4.d("RealtimeBottomComponent", r5.toString());
        VoiceCallBottomLayout r1 = this.M;
        if (r1 == null) goto L5;
        r1.l9(r26, r25 instanceof MajorState.i.a);
    L5:
        boolean r2 = ((h88.a) D3().b).m;
        boolean r3 = ((h88.a) D3().b).m;
        int r6 = 0;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
        MajorState.f r8 = null;
        if (r26 != 6) goto L8;
    L10:
        MajorState.f r9 = m3().h();
        if ((r9 instanceof MajorState.f) == false) goto L13;
        MajorState.f r10 = r9;
    L14:
        if (r10 == null) goto L53;
        String r11 = r10.e;
        if (z2.a.realtimeClientRetryConfig().c() == false) goto L53;
        AtomicReference<String> r12 = com.larus.voicecall.impl.utils.r.a;
        if (r11 != null) goto L21;
    L24:
        boolean r13 = true;
    L25:
        if (r13 == false) goto L27;
        boolean r14 = false;
    L28:
        if (r14 == true) goto L53;
        RealtimeServerErrorDetail.f.getClass();
        RealtimeServerErrorDetail r15 = RealtimeServerErrorDetail.a.a(r11);
        if (r15 == null) goto L53;
        String r16 = r15.c;
        if (r16 == null) goto L53;
        int r17 = b.a[r15.b.ordinal()];
        if (r17 == 1) goto L44;
        if (r17 == 2) goto L53;
        if (r17 == 3) goto L53;
        if (r17 == 4) goto L53;
        throw new NoWhenBranchMatchedException();
    L44:
        Set<String> r18 = this.P;
        Object[] r19 = new Object[4];
        String r110 = r15.e;
        if (r110 != null) goto L47;
        r110 = NameKeys.UnloadStrategy_No_Strategy;
    L47:
        r19[0] = r110;
        r19[1] = Integer.valueOf(r15.a);
        r19[2] = r15.b.name();
        String r20 = r15.c;
        if (r20 != null) goto L50;
        r20 = NameKeys.UnloadStrategy_No_Strategy;
    L50:
        r19[3] = r20;
        if (r18.add(CollectionsKt.joinToString$default(CollectionsKt.listOf(r19), "|", null, null, 0, null, null, 62, null)) == false) goto L53;
        t19.s.j(t19.s.a, getActivity(), r16, null, false, 28);
        goto L53
    L27:
        r14 = Intrinsics.areEqual(com.larus.voicecall.impl.utils.r.a.getAndSet(null), r11);
        goto L28
    L21:
        if (StringsKt.isBlank(r11) == true) goto L24;
        r13 = false;
    L53:
        switch(r26) {
            case 1: goto L142;
            case 2: goto L139;
            case 3: goto L135;
            case 4: goto L106;
            case 5: goto L102;
            case 6: goto L89;
            case 7: goto L85;
            case 8: goto L77;
            case 9: goto L106;
            case 10: goto L169;
            case 11: goto L169;
            case 12: goto L73;
            case 13: goto L169;
            case 14: goto L70;
            case 15: goto L67;
            case 16: goto L62;
            case 17: goto L58;
            case 18: goto L55;
            default: goto L169;
        };
    L55:
        VoiceCallBottomLayout r21 = this.M;
        if (r21 == null) goto L147;
        r21.C7();
        return;
    L147:
        return;
    L58:
        VoiceCallBottomLayout r22 = this.M;
        if (r22 == null) goto L149;
        r4.d("VoiceCallBottomLayout", "onListeningAndSpeaking");
        r22.d8();
        r22.E8();
        return;
    L149:
        return;
    L67:
        VoiceCallBottomLayout r27 = this.M;
        if (r27 == null) goto L152;
        r27.R7();
        return;
    L152:
        return;
    L70:
        VoiceCallBottomLayout r28 = this.M;
        if (r28 == null) goto L154;
        r28.E7();
        return;
    L154:
        return;
    L73:
        VoiceCallBottomLayout r29 = this.M;
        if (r29 == null) goto L156;
        r29.L7();
        return;
    L156:
        return;
    L85:
        VoiceCallBottomLayout r30 = this.M;
        if (r30 == null) goto L88;
        r30.g8();
        r30.E8();
    L88:
        G3();
        return;
    L89:
        MajorState r31 = m3().h();
        if ((r31 instanceof MajorState.f) == false) goto L92;
        r8 = (MajorState.f) r31;
    L92:
        if (r8 == null) goto L97;
        int r32 = r8.d;
        r7 = r8.e;
        Integer r33 = r8.f;
        if (r33 == null) goto L96;
        r6 = r33.intValue();
    L96:
        RealtimeCallUtil r34 = RealtimeCallUtil.a;
        int r35 = r8.c;
        Integer r36 = r8.f;
        r34.getClass();
        boolean r37 = RealtimeCallUtil.x(r35, r36);
        int r210 = r6;
        r6 = r32;
        int r38 = r210;
    L98:
        VoiceCallBottomLayout r39 = this.M;
        if (r39 == null) goto L101;
        r39.G7(r6, r7, r37, r38);
    L101:
        G3();
        return;
    L97:
        r38 = 0;
        r37 = false;
        goto L98
    L102:
        VoiceCallBottomLayout r40 = this.M;
        if (r40 == null) goto L161;
        r40.E8();
        r40.V8(false, false, false);
        return;
    L161:
        return;
    L135:
        boolean r41 = ((h88.a) D3().b).m;
        VoiceCallBottomLayout r42 = this.M;
        if (r42 == null) goto L138;
        r42.e8();
        r42.E8();
    L138:
        G3();
        boolean r43 = ((h88.a) D3().b).m;
        return;
    L139:
        VoiceCallBottomLayout r44 = this.M;
        if (r44 == null) goto L166;
        r44.n8();
        r44.E8();
        return;
    L166:
        return;
    L142:
        VoiceCallBottomLayout r45 = this.M;
        if (r45 == null) goto L168;
        r45.A8();
        return;
    L168:
        return;
    L169:
        return;
    L62:
        if (com.larus.audio.call.f.f() == true) goto L66;
        com.larus.voicecall.impl.component.core.a r46 = p3();
        if (r46 == null) goto L66;
        r46.lN();
    L66:
        G3();
        return;
    L77:
        if (u3a.f.e() == false) goto L81;
        VoiceCallBottomLayout r47 = this.M;
        if (r47 == null) goto L84;
        r47.e8();
        r47.E8();
    L84:
        boolean r48 = ((h88.a) D3().b).m;
        return;
    L81:
        VoiceCallBottomLayout r49 = this.M;
        if (r49 == null) goto L84;
        r49.E8();
        goto L84
    L106:
        if (r26 != 9) goto L126;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.u >= 0) goto L122;
        com.larus.voicecall.impl.scene.o r50 = RealtimeCallUtil.l;
        if (r50 == null) goto L118;
        SceneModel r51 = r50.a;
        if (r51 == null) goto L118;
        String r52 = r51.getKey();
        if (r52 == null) goto L118;
        String r53 = u3a.f.a;
        if (r52.equals("interpret_v2") != true) goto L118;
        boolean r54 = true;
    L119:
        if (r54 == true) goto L122;
        if (((h88.a) h3()).T == false) goto L126;
    L118:
        r54 = false;
    L122:
        boolean r55 = ((h88.a) D3().b).m;
        VoiceCallBottomLayout r56 = this.M;
        if (r56 == null) goto L146;
        r56.n8();
        r56.E8();
        return;
    L146:
        return;
    L126:
        if (r26 != 9) goto L130;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.l != null) goto L130;
        return;
    L130:
        if (r26 != 9) goto L132;
        boolean r57 = ((h88.a) D3().b).m;
    L132:
        VoiceCallBottomLayout r58 = this.M;
        if (r58 == null) goto L163;
        r58.V8(false, r25 instanceof MajorState.i.a, true);
        r58.E8();
        return;
    L163:
        return;
    L13:
        r10 = null;
        goto L14
    L8:
        if (r26 == 16) goto L10;
        goto L10
    }
}
