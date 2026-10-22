package com.obric.audio.continuous_talk;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import by7.e;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantAudioVisualizerState;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.audio.continuous_talk.session.impl.ObricContTalkMgrImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.z0;
import laa.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ¢\u00012\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0002¢\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u000109H\u0016J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020@H\u0016J\u0010\u0010E\u001a\u00020@2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020@H\u0016J\b\u0010I\u001a\u00020@H\u0016J\u00ad\u0001\u0010O\u001a\u0004\u0018\u0001092\u0006\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u0002092\b\u0010R\u001a\u0004\u0018\u00010\b2\b\u0010S\u001a\u0004\u0018\u00010\b2\b\u0010T\u001a\u0004\u0018\u00010\b2\u0006\u0010U\u001a\u0002092\u0006\u00108\u001a\u0002092\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u0001092\b\u0010]\u001a\u0004\u0018\u0001092\b\u0010^\u001a\u0004\u0018\u0001092\u0006\u0010_\u001a\u0002012\u0006\u0010`\u001a\u00020a2\u0014\u0010b\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020@\u0018\u00010cH\u0016¢\u0006\u0002\u0010dJ \u0010e\u001a\u00020@2\u0006\u0010f\u001a\u00020\u000e2\u0006\u0010g\u001a\u0002092\u0006\u0010h\u001a\u000209H\u0002J\u001a\u0010i\u001a\u00020@2\b\u0010j\u001a\u0004\u0018\u00010<2\u0006\u0010k\u001a\u00020\bH\u0002J\u0010\u0010l\u001a\u00020@2\u0006\u0010m\u001a\u000201H\u0016J8\u0010n\u001a\u00020@2\b\u0010j\u001a\u0004\u0018\u00010<2\u0006\u0010o\u001a\u0002092\u0006\u0010p\u001a\u0002092\u0014\b\u0002\u0010q\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u0002090rH\u0002J\"\u0010s\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002010t2\u0006\u0010u\u001a\u000209H\u0014J\u0018\u0010v\u001a\u00020@2\u0006\u0010w\u001a\u00020.2\u0006\u0010x\u001a\u000209H\u0002J\b\u0010y\u001a\u00020@H\u0002J\b\u0010z\u001a\u00020@H\u0002J\u001a\u0010z\u001a\u00020@2\b\u0010g\u001a\u0004\u0018\u0001092\u0006\u0010h\u001a\u000209H\u0002J\u001a\u0010{\u001a\u00020@2\b\u0010g\u001a\u0004\u0018\u0001092\u0006\u0010h\u001a\u000209H\u0002J\u0010\u0010|\u001a\u00020@2\u0006\u0010w\u001a\u00020.H\u0002J\u0010\u0010}\u001a\u00020@2\u0006\u0010~\u001a\u000201H\u0016J\b\u0010\u007f\u001a\u000201H\u0016J\t\u0010\u0080\u0001\u001a\u00020@H\u0002J\u0012\u0010\u0081\u0001\u001a\u00020@2\u0007\u0010\u0082\u0001\u001a\u000209H\u0002J\t\u0010\u0083\u0001\u001a\u00020@H\u0002J \u0010\u0084\u0001\u001a\u00020@2\u0015\u0010\u0085\u0001\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u000209\u0018\u00010rH\u0016J\u0014\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0006\u0010w\u001a\u00020.H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020@2\u0007\u0010\u0089\u0001\u001a\u000201H\u0002J\u0013\u0010\u008e\u0001\u001a\u00020@2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0002J\u0013\u0010\u0091\u0001\u001a\u00020@2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\t\u0010\u0094\u0001\u001a\u000201H\u0002J\t\u0010\u0095\u0001\u001a\u00020@H\u0002J\u0016\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\t\u0010\u0096\u0001\u001a\u00020@H\u0002J\u0012\u0010\u0097\u0001\u001a\u00020@2\u0007\u0010\u0098\u0001\u001a\u000201H\u0002J\t\u0010\u0099\u0001\u001a\u000201H\u0016J\t\u0010\u009a\u0001\u001a\u00020>H\u0016J\u0012\u0010\u009b\u0001\u001a\u00020@2\u0007\u0010\u009c\u0001\u001a\u000201H\u0016J\u0013\u0010\u009d\u0001\u001a\u0002012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0014\u0010 \u0001\u001a\u00020@2\t\u0010¡\u0001\u001a\u0004\u0018\u000109H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008b\u0001\u001a\u0002012\u0007\u0010\u008a\u0001\u001a\u000201@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006£\u0001"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricContinuousTalkUIComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "flowAsrSession", "Lcom/obric/audio/continuous_talk/session/api/IObricContTalkMgr;", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "llmContextProvider", "Lcom/obric/audio/continuous_talk/ObricContinuousLLMContextProvider;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "latestPhotoShortcutAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "getLatestPhotoShortcutAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/ILatestPhotoShortcutAbility;", "latestPhotoShortcutAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "talkState", "Lcom/larus/audio/call/mgr/AVKitDuplexState;", "rejectCnt", "pendingFirstRejectTimeout", "", "pendingCloseAfterRejectAnimation", "stateCollectJob", "Lkotlinx/coroutines/Job;", "recordDataCollectJob", "talkEventCollectJob", "ttsObserveJob", "botId", "", "nextStartupAttemptId", "currentStartupSession", "Lcom/obric/assistant/spi/startup/AssistantStartupAudioSession;", "businessStatus", "Lcom/obric/audio/continuous_talk/ContinuousTalkStatus;", "bindStartupAttempt", "", "attemptId", "onCreate", "onStart", "onAttach", "onViewCreated", "view", "Landroid/view/View;", "onPause", "onDestroy", "runningSpeakTaskId", "clickTalkSessionId", "clickTalkConversationId", "clickTalkSourceType", "isClickTalkListening", "invokeOnSpeak", "callId", "taskId", "vuiId", "wakeupId", "sourceType", "convId", "voiceType", "Lcom/larus/im/bean/bot/SpeakerVoice;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "traceNode", "Lcom/ixigua/lib/track/ITrackNode;", "enterMethod", "botModelName", "personalCtx", "personalCtxIsFinish", "oneshotParams", "Lcom/larus/audio/call/RealtimeCallParam$OneshotParams;", "onFinishCall", "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/SpeakerVoice;Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;Lcom/ixigua/lib/track/ITrackNode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/larus/audio/call/RealtimeCallParam$OneshotParams;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "cleanupFailedSessionStart", "session", "conversationId", "speakTaskId", "markStartupRecordReady", "startupSession", "readSize", "stop", "immediately", "finishStartupSession", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "attributes", "", "createAsrSession", "Lkotlin/Triple;", "asrTaskId", "updateTalkStateUI", "state", "expectedSessionId", "dispatchClickTalkQueryBegin", "dispatchClickTalkQueryEnd", "dispatchClickTalkEnd", "checkQueryEndEvent", "setTtsMute", "mute", "isAudioPlaying", "observeTtsSwitchState", "syncTtsMuteWithTitleBar", "scene", "stopObserveTtsSwitchState", "updateIntentExt", "ext", "convertToRealtimeCallLifeState", "Lcom/obric/assistant/audio/service/ObricAssistantAudioVisualizerState;", "notifyContinuousTtsPlayState", "isPlaying", "value", "isRecognizing", "setRecognizing", "(Z)V", "processRecordedAudio", "audioData", "Lcom/larus/audio/audiov3/audio/record/RecordedAudioData;", "handleTalkEvent", "event", "Lcom/obric/audio/continuous_talk/session/api/ObricContTalkEvent;", "shouldStartFirstRejectTimeout", "startFirstRejectTimeout", "cancelFlowCollectJobs", "updateContinuesUIParam", "reset", "isSpeaking", "getTalkStatus", "onChatStyleChanged", "isChatWindow", "requestChat", "params", "Lorg/json/JSONObject;", "updateScreenshotForAsr", "tosKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricContinuousTalkUIComponent extends BaseContentWidget implements com.obric.audio.continuous_talk.b, hca.b {
    public static final /* synthetic */ int M = 0;
    public Job A;
    public Job B;
    public Job C;
    public volatile String D;
    public volatile uga.b E;
    public ContinuousTalkStatus F;
    public String G;
    public String H;
    public String I;
    public int J;
    public boolean K;
    public boolean L;
    public int m;
    public hia.a n;
    public final f2a.d o;
    public final i p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public AVKitDuplexState v;
    public int w;
    public boolean x;
    public boolean y;
    public Job z;

    public static final class a {
    }

    public static final class b implements Function0<f> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(f.class));
        }
    }

    public static final class c implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class d implements Function0<com.obric.audio.continuous_talk.c> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.c.class));
        }
    }

    static {
    }

    public final void onDestroy() {
        stop(true);
        laa.d r0 = (laa.d) this.t.getValue();
        if (r0 == null) goto L6;
        r0.AN(this);
        return;
    }

    public final void onPause() {
    }

    public final boolean E3() {
        if (this.x == true) goto L5;
    L15:
        return false;
    L5:
        if (m0() == false) goto L15;
        if (this.L == true) goto L15;
        AVKitDuplexState r0 = this.v;
        if (r0 == null) goto L11;
        AVKitDuplexState.UpState r1 = r0.getUpState();
    L13:
        if ((r1 instanceof AVKitCoreStates.Finished) == true) goto L15;
        return true;
    L11:
        r1 = null;
        goto L13
    }

    public final void Y2() {
        Job r0 = this.z;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.z = null;
        Job r1 = this.A;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.A = null;
        Job r2 = this.B;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        this.B = null;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final boolean a0() {
        hia.a r0 = this.n;
        if (r0 != null) goto L5;
        r0 = hia.c.a.get();
    L5:
        if (r0 != null) goto L9;
        return false;
    L9:
        return r0.a0();
    }

    @Override // com.obric.audio.continuous_talk.b
    public final boolean m0() {
        ContinuousTalkStatus r0 = this.F;
        if (r0 != ContinuousTalkStatus.RUNNING) goto L5;
    L8:
        return true;
    L5:
        if (r0 == ContinuousTalkStatus.STOPPING) goto L8;
        return false;
    }

    public final void onCreate() {
        FLogger.a.i("ObricContinuousTalkUIComponent", "[onCreate]");
    }

    public final void onStart() {
        FLogger.a.i("ObricContinuousTalkUIComponent", "onStart " + hashCode());
    }

    public final com.obric.audio.continuous_talk.c p3() {
        return (com.obric.audio.continuous_talk.c) this.u.getValue();
    }

    public final void y2() {
        FLogger.a.i("ObricContinuousTalkUIComponent", "[onAttach]");
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.obric.audio.continuous_talk.b.class);
    }

    public final f z3() {
        return (f) this.s.getValue();
    }

    public ObricContinuousTalkUIComponent() {
        this.m = 2131387057;
        FLogger.a.i("ObricContinuousTalkUIComponent", "init ChatBottomSpeakerComponent");
        this.o = new f2a.d("VoiceInput", "ObricContinuousTalkUIComponent");
        this.p = new i();
        this.q = LazyKt.lazy(new i0(this));
        this.r = LazyKt.lazy(new j0(this));
        this.s = LazyKt.lazy(new b(this));
        this.t = LazyKt.lazy(new c(this));
        this.u = LazyKt.lazy(new d(this));
        this.F = ContinuousTalkStatus.STOPPED;
        this.J = -1;
    }

    public final void G3() {
        if (E3() == true) goto L5;
        return;
    L5:
        this.x = false;
        ObricAssistantForAudioDelegate r0 = ObricAssistantForAudioDelegate.b;
        f r1 = z3();
        if (r1 == null) goto L8;
        iga.a r2 = r1.Zs();
    L9:
        r0.f5(r2, ObricAssistantAudioVisualizerState.TtsEnd, null);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final int U2() {
        return this.m;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final ContinuousTalkStatus u10() {
        return this.F;
    }

    public static void B3(boolean r3) {
        FLogger.a.i("ObricContinuousTalkUIComponent", "notifyContinuousTtsPlayState: " + r3);
        if (r3 == false) goto L5;
        PlayStateEnum r0 = PlayStateEnum.PLAY_STATE_PLAYING;
    L6:
        if (r3 == false) goto L12;
        String r4 = zh8.a.a.x1().c().o6();
        if (r4 == null) goto L12;
        IObricChatService.a.getClass();
        IObricChatService r1 = IObricChatService.a.a();
        if (r1 == null) goto L12;
        r1.f(r4);
    L12:
        AudioServiceDelegate.a.r0().n(r0);
        return;
    L5:
        r0 = PlayStateEnum.PLAY_STATE_STOPPED;
        goto L6
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void B6(String r1) {
        this.D = r1;
    }

    public final void C3(boolean r3) {
        boolean r0 = this.L;
        this.L = r3;
        if (r0 == r3) goto L10;
        ObricAssistantForAudioDelegate r1 = ObricAssistantForAudioDelegate.b;
        f r2 = z3();
        if (r2 == null) goto L7;
        iga.a r4 = r2.Zs();
    L8:
        r1.Q4(r4, r3);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void D3(boolean r4) {
        FLogger.a.i("ObricContinuousTalkUIComponent", "setTtsMute: " + r4);
        hia.a r0 = this.n;
        if (r0 != null) goto L5;
        r0 = hia.c.a.get();
    L5:
        if (r0 == null) goto L8;
        r0.j(r4);
        return;
    }

    public final void H3(String r6) {
        IObricChatService.a.getClass();
        IObricChatService r0 = IObricChatService.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.k();
    L6:
        FLogger.a.i("ObricContinuousTalkUIComponent", "syncTtsMuteWithTitleBar: scene=" + r6 + ", isTtsOn=" + r1);
        D3(r1 ^ true);
        return;
    L5:
        r1 = true;
        goto L6
    }

    @Override // com.obric.audio.continuous_talk.b
    public final boolean I0(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        FLogger.a.i("ObricContinuousTalkUIComponent", "requestChat called, params=" + r4);
        hia.a r0 = this.n;
        if (r0 == null) goto L5;
        hia.a.d r5 = r0.I0(r4);
    L7:
        return Intrinsics.areEqual(r5, hia.a.d.b.a);
    L5:
        r5 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q3(boolean r5) {
        ObricAssistantForAudioDelegate r0 = ObricAssistantForAudioDelegate.b;
        f r1 = z3();
        l0 r2 = 0;
        if (r1 == null) goto L5;
        iga.a r3 = r1.Zs();
    L6:
        boolean r4 = !r5;
        if (r5 == true) goto L9;
        r2 = new l0(this);
    L9:
        r0.T4(r3, r4, r2);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.audio.continuous_talk.h0] */
    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ObricAssistantForAudioDelegate r4 = ObricAssistantForAudioDelegate.b;
        f r0 = z3();
        if (r0 == null) goto L5;
        iga.a r1 = r0.Zs();
    L6:
        r4.W4(r1, new h0(this));
        laa.d r5 = (laa.d) this.t.getValue();
        if (r5 == null) goto L10;
        r5.HU(this);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void r2(boolean r6) {
        laa.d r0 = (laa.d) this.t.getValue();
        iga.a r1 = null;
        if (r0 == null) goto L5;
        ObricFloatChatPageState r2 = r0.getPageState();
    L6:
        if (r6 == false) goto L28;
        boolean r7 = false;
        if (r2 == null) goto L14;
        ObricFloatChatPageState r3 = r2.getPreviousState();
        if (r3 == null) goto L14;
        ObricFloatChatPageData.Companion.getClass();
        if ((r3 instanceof vda.b) != true) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L23;
        if (r2 == null) goto L22;
        ObricFloatChatPageState r5 = r2.getPreviousState();
        if (r5 == null) goto L22;
        ObricFloatChatPageData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof com.obric.assistant.data.a) != true) goto L22;
        r7 = true;
    L22:
        if (r7 == true) goto L23;
        return;
    L23:
        ObricAssistantForAudioDelegate r8 = ObricAssistantForAudioDelegate.b;
        f r9 = z3();
        if (r9 == null) goto L26;
        r1 = r9.Zs();
    L26:
        r8.S4(r1);
        return;
    L14:
        r4 = false;
        goto L15
    L28:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void stop(boolean r8) {
        ContinuousTalkStatus r0 = this.F;
        ContinuousTalkStatus r1 = ContinuousTalkStatus.STOPPED;
        if (r0 != r1) goto L5;
        return;
    L5:
        if (r8 == false) goto L7;
    L9:
        if (r8 == true) goto L12;
        r1 = ContinuousTalkStatus.STOPPING;
    L12:
        this.F = r1;
        if (r0 != ContinuousTalkStatus.RUNNING) goto L18;
        uga.b r2 = this.E;
        if (r2 == null) goto L17;
        m3(r2, "cancelled", "continuous_talk_stopped_before_pcm", MapsKt.emptyMap());
    L17:
        Y2();
        this.x = false;
        this.y = false;
        this.w = 0;
        this.v = null;
        C3(false);
        Q3(true);
    L18:
        hia.a r3 = this.n;
        String r4 = this.H;
        if (r4 == null) goto L21;
        h3(this.I, r4);
    L21:
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = -1;
        if (r8 == false) goto L29;
        if (r3 == null) goto L25;
        r3.c();
    L25:
        hia.c.a(r3);
        this.n = null;
        Job r9 = this.C;
        if (r9 == null) goto L28;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L28:
        this.C = null;
        zh8.a.a.x1().c().r6(null);
        B3(false);
        return;
    L29:
        if (r3 == null) goto L33;
        r3.e(new k0(r3, this));
        return;
    L33:
        return;
    L7:
        if (r0 != ContinuousTalkStatus.STOPPING) goto L9;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void updateIntentExt(Map<String, String> r5) {
        FLogger r0 = FLogger.a;
        r0.i("ObricContinuousTalkUIComponent", "updateIntentExt: " + r5);
        i r1 = this.p;
        r1.getClass();
        r0.i("ObricContinuousLLMContextProvider", "updateIntentExt called : isAgentExtCompleted=" + r1.c.get() + ", ext=" + r5);
        if (r1.c.get() == true) goto L9;
        r1.c.set(false);
        Function1<? super Map<String, String>, Unit> r2 = r1.a;
        if (r2 == null) goto L7;
        r2.invoke(r5);
    L7:
        r1.a = null;
        return;
    }

    @Override // com.obric.audio.continuous_talk.b
    public final void updateScreenshotForAsr(String r4) {
        if (ObricAsrDelegate.b.q() == true) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r4 != null) goto L8;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        JSONObject r1 = new JSONObject();
        r1.put("image_url", r4);
        r1.put("update_nonstream_context_finish", true);
        hia.a r5 = this.n;
        if (r5 == null) goto L19;
        r5.d(r1);
        return;
    L19:
        return;
    L8:
        if (r4.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 != true) goto L13;
        r0 = true;
        goto L13
    L10:
        r2 = false;
        goto L11
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
    }

    public final void h3(String r4, String r5) {
        VoiceCaptureStateProducerDelegate.b.d(r4, VoiceCaptureScene.CONTINUOUS_TALK, r5, Integer.valueOf(this.J));
        if (Intrinsics.areEqual(this.H, r5) == false) goto L5;
        this.H = null;
        this.I = null;
        this.J = -1;
    L5:
        this.K = false;
    }

    public final void m3(uga.b r8, String r9, String r10, Map<String, String> r11) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.c() == false) goto L8;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r8.a, r9, r10, r11, 8);
    L8:
        if (this.E != r8) goto L11;
        this.E = null;
        return;
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [com.obric.audio.continuous_talk.n0, java.lang.Object] */
    @Override // com.obric.audio.continuous_talk.b
    public final String hr(String r31, String r32, Integer r33, Integer r34, String r35, String r36, SpeakerVoice r37, de8.c r38, e r39, String r40, String r41, String r42, boolean r43, RealtimeCallParam.l r44) {
        Intrinsics.checkNotNullParameter(r31, "callId");
        Intrinsics.checkNotNullParameter(r32, "taskId");
        Intrinsics.checkNotNullParameter(r35, "convId");
        Intrinsics.checkNotNullParameter(r36, "botId");
        Intrinsics.checkNotNullParameter(r38, "chatArgumentData");
        Intrinsics.checkNotNullParameter(r44, "oneshotParams");
        String r3 = this.D;
        if (r3 == null) goto L5;
        uga.b r7 = new uga.b(r3);
    L6:
        this.D = null;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getFragmentManager() == null) goto L60;
        String r6 = UUID.randomUUID().toString();
        this.G = r6;
        this.H = r6;
        this.I = r35;
        if (r34 == null) goto L11;
        int r4 = r34.intValue();
    L12:
        this.J = r4;
        this.K = false;
        f2a.c r5 = this.o.b("param");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put(new f2a.f("callId"), r31);
        r8.put(new f2a.f("taskId"), r32);
        r8.put(new f2a.f("vuiId"), String.valueOf(r33));
        r8.put(f2a.f.h, r35);
        r8.put(f2a.f.e, r36);
        r8.put(new f2a.f("voiceType"), String.valueOf(r37));
        r8.put(new f2a.f("chatArgumentData"), r38.toString());
        r5.d(r8);
        r5.c.d = "invokeOnSpeak";
        f2a.c.c(r5, null, 15);
        com.larus.bmhome.chat.component.bottom.multimodal.latest.a r2 = (com.larus.bmhome.chat.component.bottom.multimodal.latest.a) this.r.getValue();
        if (r2 == null) goto L15;
        r2.g0("ChatBottomSpeakerComponent#invokeOnSpeak");
    L15:
        Q3(false);
        Intrinsics.checkNotNullParameter(r6, "asrTaskId");
        Intrinsics.checkNotNullParameter(this, "<this>");
        final Fragment r9 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        hia.a.C0057a r10 = hia.a.a;
        ?? r11 = new n0(r9);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "lifecycleScope");
        ObricContTalkMgrImpl r12 = new ObricContTalkMgrImpl(r11);
        i r13 = this.p;
        com.larus.bmhome.chat.component.cvs.y r14 = (com.larus.bmhome.chat.component.cvs.y) this.q.getValue();
        if (r14 == null) goto L18;
        wc9.e r15 = r14.h();
    L19:
        r13.getClass();
        FLogger r16 = FLogger.a;
        r16.i("ObricContinuousLLMContextProvider", "updateConversation called : cov=" + r15);
        r13.b = r15;
        ((com.obric.audio.continuous_talk.session.impl.plugin.b) LLMCallController.w(r12, Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.b.class))).B0(this.p);
        Triple r0 = new Triple(r12, Boolean.TRUE, Boolean.FALSE);
        boolean r17 = ((Boolean) r0.getSecond()).booleanValue();
        boolean r23 = ((Boolean) r0.getThird()).booleanValue();
        hia.a r18 = (hia.a) r0.getFirst();
        f2a.c r1 = this.o.b("createAsrSession");
        LinkedHashMap r19 = new LinkedHashMap();
        f2a.f r20 = new f2a.f("session_type");
        String r21 = Reflection.getOrCreateKotlinClass(r18.getClass()).getSimpleName();
        if (r21 != null) goto L22;
        r21 = "";
    L22:
        r19.put(r20, r21);
        r19.put(new f2a.f("is_speak"), String.valueOf(r17));
        r19.put(new f2a.f("reset_task_id"), String.valueOf(r23));
        r1.d(r19);
        r1.c.d = "invokeOnSpeak";
        f2a.c.c(r1, null, 15);
        IFlowTtsClientService.a.getClass();
        if (IFlowTtsClientService.a.a().a() == false) goto L25;
        IFlowTtsClientService.a.a().f("");
    L25:
        uga.b r22 = this.E;
        if (r22 == null) goto L28;
        m3(r22, "cancelled", "continuous_talk_replaced_before_pcm", MapsKt.emptyMap());
    L28:
        this.E = r7;
        Y2();
        AtomicReference<hia.a> r24 = hia.c.a;
        Intrinsics.checkNotNullParameter("ObricContinuousTalkUIComponent#invokeOnSpeak", WindowEvent.Params.REASON);
        hia.a r25 = hia.c.a.getAndSet(r18);
        if (r25 == null) goto L32;
        if (r25 == r18) goto L32;
        r16.i("ObricContTalkSessionStore", "replace: stopPreviousImmediately, reason=ObricContinuousTalkUIComponent#invokeOnSpeak");
        r25.c();
    L32:
        this.n = r18;
        H3("invokeOnSpeakBeforeStart");
        uga.b r110 = r7;
        this.z = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$4(r18, this, r7, r42, r43, r6, null), 3, null);
        this.A = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$5(r18, this, r110, null), 3, null);
        this.B = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$6(r18, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricContinuousTalkUIComponent$invokeOnSpeak$1$7(r35, null), 2, null);
        IVoiceCaptureStateProducerService.a.a(VoiceCaptureStateProducerDelegate.b, r35, VoiceCaptureScene.CONTINUOUS_TALK, r6, Integer.valueOf(this.J));
        hia.a.d r26 = r18.f(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r44);
        if (r23 == false) goto L36;
        this.G = null;
    L36:
        if ((r26 instanceof hia.a.d.C0058a) == false) goto L47;
        m3(r110, "dropped", "continuous_talk_start_failed", MapsKt.mapOf(TuplesKt.to("error_code", String.valueOf(((hia.a.d.C0058a) r26).a))));
        Y2();
        this.x = false;
        this.y = false;
        this.w = 0;
        this.v = null;
        C3(false);
        Q3(true);
        h3(r35, r6);
        this.G = null;
        r18.c();
        hia.c.a(r18);
        if (this.n != r18) goto L40;
        this.n = null;
    L40:
        this.F = ContinuousTalkStatus.STOPPED;
        Job r27 = this.C;
        if (r27 == null) goto L43;
        Job.DefaultImpls.cancel$default(r27, null, 1, null);
    L43:
        this.C = null;
        zh8.a.a.x1().c().r6(null);
        B3(false);
        com.obric.audio.continuous_talk.c r28 = p3();
        if (r28 == null) goto L47;
        com.obric.audio.continuous_talk.c.a.a(r28, null, null, false, true, 7);
    L47:
        if (this.G == null) goto L61;
        this.F = ContinuousTalkStatus.RUNNING;
        H3("invokeOnSpeakAfterStart");
        Job r29 = this.C;
        if (r29 == null) goto L51;
        Job.DefaultImpls.cancel$default(r29, null, 1, null);
    L51:
        IObricChatUIService r30 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r30 == null) goto L54;
        z0 r45 = r30.D();
    L55:
        if (r45 != null) goto L57;
        r16.w("ObricContinuousTalkUIComponent", "observeTtsSwitchState: ttsEnabledStateFlow is null, skip");
        goto L61
    L57:
        this.C = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkUIComponent$observeTtsSwitchState$1(r45, this, null), 3, null);
        goto L61
    L54:
        r45 = null;
    L61:
        return this.G;
    L18:
        r15 = null;
        goto L19
    L11:
        r4 = -1;
        goto L12
    L60:
        return null;
    L5:
        r7 = null;
        goto L6
    }
}
