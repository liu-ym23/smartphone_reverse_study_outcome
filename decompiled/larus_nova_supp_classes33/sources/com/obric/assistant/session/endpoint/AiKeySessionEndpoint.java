package com.obric.assistant.session.endpoint;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.AppletExtService;
import com.larus.account.base.api.ILoginService;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.utils.g1;
import com.larus.common.apphost.AppHost;
import com.larus.livetutor.api.ILiveTutorService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.IObricRealtimeCallService;
import com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector;
import com.obric.assistant.ObricAssistantDelegate;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.h1;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.ISystemKeySettings;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.interact.CustomBarAction;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.ipc.IpcMessenger;
import com.obric.assistant.session.bean.ActivateEventType;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IAssistActivateOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.IOAutoOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.singleton.AiKeyActionDetector;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.spi.audio.CallType;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.assistant.spi.chat.ObricInteractionServiceDelegate;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricWakeupLatencyTrackService;
import com.obric.assistant.state.api.v2.ObricStateService;
import com.obric.assistant.t1;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.audio.continuous_talk.ObricContinuousTalkEndType;
import com.obric.audio.tts.IObricChainTtsService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u007f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002~\u007fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001f0,2\u0006\u0010.\u001a\u00020/H\u0096@¢\u0006\u0002\u00100J\u0012\u00101\u001a\u0002022\b\u0010.\u001a\u0004\u0018\u00010/H\u0017J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J<\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0;H\u0002J\u0010\u0010<\u001a\u0002022\u0006\u0010.\u001a\u00020/H\u0002J\b\u0010=\u001a\u000202H\u0002J&\u0010>\u001a\u0002022\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f09H\u0002J$\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001f2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u001fH\u0002J*\u0010C\u001a\u0002022\u0006\u0010.\u001a\u00020/2\b\u0010D\u001a\u0004\u0018\u00010\u001f2\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001fH\u0002JL\u0010E\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f092\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001f2\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0;H\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010A\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010B\u001a\u00020\u001fH\u0002J\u0018\u0010I\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u0017H\u0002J\b\u0010K\u001a\u00020\u0017H\u0002J\b\u0010L\u001a\u000202H\u0016J\b\u0010M\u001a\u000202H\u0016J\b\u0010N\u001a\u000202H\u0016J\b\u0010O\u001a\u000202H\u0016J\b\u0010P\u001a\u000202H\u0016J\u0012\u0010Q\u001a\u0002022\b\u0010R\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010S\u001a\u000202H\u0002J\b\u0010T\u001a\u000202H\u0016J\b\u0010U\u001a\u000202H\u0016J\b\u0010V\u001a\u000202H\u0016J\b\u0010W\u001a\u000202H\u0002J\u0010\u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u001fH\u0002J\b\u0010Z\u001a\u000202H\u0002J\b\u0010[\u001a\u000202H\u0002J\u0014\u0010\\\u001a\u0002022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u001fH\u0002J\u0014\u0010^\u001a\u0002022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u001fH\u0002J\u001e\u0010_\u001a\u0002022\b\b\u0002\u0010`\u001a\u00020\u00172\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u001fH\u0002J6\u0010a\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u001f2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u001f2\u0018\b\u0002\u0010b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u000202\u0018\u00010cH\u0002J\b\u0010d\u001a\u00020\u0017H\u0002J\b\u0010e\u001a\u000202H\u0002J\u0014\u0010f\u001a\u0002022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u001fH\u0002J\u0014\u0010g\u001a\u0002022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010h\u001a\u0004\u0018\u00010/*\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010i\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u001fH\u0002J\u0019\u0010j\u001a\u0004\u0018\u00010\u001f2\b\u0010k\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010lJ\u001a\u0010m\u001a\u0002022\b\u0010]\u001a\u0004\u0018\u00010\u001f2\u0006\u0010A\u001a\u00020\u001fH\u0002J)\u0010n\u001a\u0002022\u0006\u0010o\u001a\u00020\u00172\b\u0010k\u001a\u0004\u0018\u00010&2\b\u0010]\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010pJ\b\u0010q\u001a\u000202H\u0016J\b\u00106\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010r\u001a\u0002022\b\u0010]\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010s\u001a\u00020\u0017H\u0002J\b\u0010w\u001a\u00020\u0017H\u0002J\b\u0010x\u001a\u000202H\u0002J\u0010\u0010y\u001a\u0002022\u0006\u00106\u001a\u00020zH\u0002J\u0018\u0010{\u001a\u0002022\u0006\u0010|\u001a\u00020\u001f2\u0006\u0010}\u001a\u00020\u001fH\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010t\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010u¨\u0006\u0080\u0001"}, d2 = {"Lcom/obric/assistant/session/endpoint/AiKeySessionEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/singleton/AiKeyActionDetector$KeyActionListener;", "Lcom/obric/assistant/session/model/IAiKeyOperation;", "<init>", "()V", "systemKeySettings", "Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "getSystemKeySettings", "()Lcom/obric/assistant/interaction/api/ISystemKeySettings;", "systemKeySettings$delegate", "Lkotlin/Lazy;", "obricRealtimeCallService", "Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "getObricRealtimeCallService", "()Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "obricRealtimeCallService$delegate", "appLaunchService", "Lcom/obric/assistant/spi/app/IObricLaunchService;", "getAppLaunchService", "()Lcom/obric/assistant/spi/app/IObricLaunchService;", "appLaunchService$delegate", "isAiKeyPressing", "", "mAiKeyDownTimeStamp", "", "mAiKeyDownEventTime", "hasChildOwnedAiKeyPresentation", "mAiKeyMainReceivedTimeStamp", "mAiKeyStartElapsedMs", "mAiKeyStartClock", "", "mAiKeyAttemptId", "suppressRemainingAiKeyPress", "pendingChildFirstFrame", "Lcom/obric/assistant/session/endpoint/AiKeySessionEndpoint$PendingChildFirstFrame;", "liveTutorPressStartSkipped", "processOrder", "", "getProcessOrder", "()I", "pocketModeDetector", "Lcom/obric/aiagent/product/platform/api/pocketmode/PocketModeDetector;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAiKeyDown", "", "getAiKeyDownTimeStamp", "getAiKeyDownEventTime", "beginAiKeyAttempt", "action", "target", "requiredMilestones", "", "extraAttributes", "", "captureChildFirstFrame", "markPendingChildFirstFrameIfReady", "updateAiKeyAttempt", "finishAiKeyAttempt", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "attemptId", "reportPreclassifiedAiKeyTerminal", "fallbackAttemptId", "reportReservedAiKeyTerminal", "attributes", "discardAiKeyAttempt", "clearPendingChildFirstFrame", "suppressAiKeyPressSemanticIfNeeded", "terminal", "shouldPreloadWindowOnAiKeyDown", "onAiKeySinglePress", "onAiKeyDoublePress", "onAiKeyLongPressFailed", "onAiKeyCancelled", "onAiKeyGestureTimeout", "onAiKeyPressStart", "rawLaunchMethod", "refreshIntercomConditionStatusOnAiKeyPressStart", "onAiKeyLongPress", "onAiKeyShortPress", "onAiKeyLongPressStop", "playAiKeyStartListeningFeedbackIfNeeded", "shouldKeepLiveTutorInPlaceRecording", "scene", "handlePowerKeySingleClick", "handlePowerKeySingleClickBackground", "launchAssistantFloatingWindowForSingleClick", "startupAttemptId", "openAssistantFloatingWindowForSingleClick", "launchAssistantDirectlyForSingleClick", "checkScreenLock", "requestDismissKeyguardIfUserGuideNotShownForAiKeyPress", "onDismissSucceeded", "Lkotlin/Function1;", "shouldBlockAiKeyPressBeforeUserGuideOnKeyguard", "handlePowerKeySingleClickForeground", "routeAiKeyAttemptToChat", "routeAiKeyAttemptToWindow", "toStartupBundle", "tryInterruptActiveTts", "beginDoublePressAttempt", "doubleClickFunction", "(Ljava/lang/Integer;)Ljava/lang/String;", "finishOrDiscardDoublePressAttempt", "handlePowerKeyDoubleClick", "isMicInUse", "(ZLjava/lang/Integer;Ljava/lang/String;)V", "startLauncherIntent", "launchDoubaoCamera", "isNotSupportDoubleClickPage", "isBackgroundInOAuto", "()Z", "isDoraPressing", "isBlockedByDoraPressing", "finishChildOwnedAiKeyPresentation", "acknowledgeChildOwnedAiKeyPresentation", "Lcom/obric/assistant/activation/presentation/contract/gesture/ObricAiKeyGestureAction;", "reportAiKeyButtonWakeup", "pressType", "launchService", "PendingChildFirstFrame", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiKeySessionEndpoint implements ISessionEndPoint, AiKeyActionDetector.a, IAiKeyOperation {
    public static final /* synthetic */ int p = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public volatile boolean d;
    public long e;
    public long f;
    public boolean g;
    public long h;
    public long i;
    public String j;
    public String k;
    public boolean l;
    public b m;
    public volatile boolean n;
    public final PocketModeDetector o;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final long b;
        public final int c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c;
        }

        public final String toString() {
            return "PendingChildFirstFrame(attemptId=" + this.a + ", timestampElapsedRealtimeMs=" + this.b + ", generation=" + this.c + ')';
        }

        public b(String r2, long r3, int r5) {
            Intrinsics.checkNotNullParameter(r2, "attemptId");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CallType.values().length];
            r0[CallType.Audio.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CallType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CallType.ScreenShare.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // com.obric.assistant.session.model.IAiKeyOperation
    public final AiKeySessionEndpoint action() {
        return this;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 80;
    }

    public static boolean L() {
        if (t1.a.m0() == false) goto L5;
        return false;
    L5:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L16;
        IObricUserGuide r0 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r0.a() != true) goto L11;
        r1 = true;
        goto L12
    L16:
        return false;
    }

    public final void A() {
        FLogger r0 = FLogger.a;
        r0.w(ISessionEndPoint.a.b(this), "single click foreground");
        FragmentActivity r1 = AppHost.a.a().getCurrentActivity();
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = null;
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = r1;
    L6:
        if (r2 == null) goto L8;
        t1a.b r3 = aga.j.g(r2);
    L9:
        if (r2 == null) goto L13;
        t1a.b r5 = aga.j.g(r2);
        if (r5 == null) goto L13;
        com.obric.audio.continuous_talk.c r6 = (com.obric.audio.continuous_talk.c) r5.getAbility(com.obric.audio.continuous_talk.c.class);
    L14:
        boolean r7 = true;
        if (r3 == null) goto L21;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r8 = r3.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r8 == null) goto L21;
        if (r8.m0() != true) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L24;
    L33:
        ISessionMaintaining r10 = bga.j.b();
        if (r10 != null) goto L36;
    L38:
        boolean r11 = false;
    L39:
        if (r11 == false) goto L42;
        r0.w(ISessionEndPoint.a.b(this), "finishChatActivity");
        aga.j.m();
        v("closed_existing_chat");
        return;
    L42:
        if (r3 == null) goto L44;
        maa.e r12 = (maa.e) r3.getAbility(maa.e.class);
    L45:
        if (r3 == null) goto L51;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r13 = r3.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r13 == null) goto L51;
        if (r13.m0() != true) goto L51;
        boolean r14 = true;
    L52:
        if (r14 == false) goto L65;
        laa.d r15 = r3.getAbility(laa.d.class);
        if (r15 != null) goto L56;
    L58:
        boolean r16 = false;
    L59:
        if (r16 == true) goto L61;
        if (r12 == null) goto L65;
    L61:
        if (r12 == null) goto L63;
        maa.e.a.a(r12, null, null, false, 7);
    L63:
        aga.j.m();
        v("closed_existing_click_talk");
        return;
    L56:
        if (r15.Da() != true) goto L58;
        r16 = true;
    L65:
        if (r6 != null) goto L67;
    L69:
        boolean r17 = false;
    L70:
        if (r17 == false) goto L82;
        t1a.b r18 = aga.j.g(r2);
        if (r18 == null) goto L78;
        laa.d r19 = r18.getAbility(laa.d.class);
        if (r19 == null) goto L78;
        if (r19.Da() != true) goto L78;
        boolean r20 = true;
    L79:
        if (r20 == false) goto L82;
        com.obric.audio.continuous_talk.c.a.a(r6, ObricContinuousTalkEndType.MANUAL, null, false, true, 6);
        v("closed_existing_continuous_talk");
        return;
    L78:
        r20 = false;
    L82:
        ObricStateService r21 = ObricStateService.a;
        if (r21.a() == true) goto L97;
        IAssistantChatWindow r22 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r22 != null) goto L87;
    L89:
        boolean r23 = false;
    L90:
        if (r23 == false) goto L97;
        if (r3 == null) goto L93;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r24 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r3.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
    L94:
        if (r24 != null) goto L97;
        D(this);
        return;
    L93:
        r24 = null;
        goto L94
    L87:
        if (r22.isWindowMode() != true) goto L89;
        r23 = true;
    L97:
        if (r21.a() == true) goto L113;
        IAssistActivateOperation r25 = bga.d.a();
        if (r25 != null) goto L101;
    L103:
        r7 = false;
    L104:
        if (r7 == false) goto L113;
        if (r3 == null) goto L107;
        r4 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r3.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
    L107:
        if (r4 != null) goto L113;
        IAssistantChatWindow r26 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r26 == null) goto L111;
        r26.onWakeupBlockedBySystemAlertWindowPermission();
    L111:
        w("blocked", "system_alert_window_permission", this.k);
        return;
    L101:
        if (r25.m() != (-15)) goto L103;
    L113:
        v("handled_existing_foreground_surface");
        return;
    L67:
        if (r6.m0() != true) goto L69;
        r17 = true;
    L51:
        r14 = false;
        goto L52
    L44:
        r12 = null;
        goto L45
    L36:
        if (r10.j() != true) goto L38;
        r11 = true;
        goto L39
    L24:
        if (O("single click foreground") == false) goto L33;
        if (r6 != null) goto L27;
    L29:
        boolean r27 = false;
    L30:
        if (r27 == true) goto L33;
        v("interrupted_existing_tts");
        return;
    L27:
        if (r6.m0() != true) goto L29;
        r27 = true;
    L21:
        r9 = false;
    L13:
        r6 = null;
        goto L14
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void F() {
        final b r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        AssistantStartupTelemetry r7 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r7.h(), r0.a) == true) goto L10;
        this.m = null;
        return;
    L10:
        if (Intrinsics.areEqual(r7.i("first_frame_ready"), r0.a) == true) goto L13;
        this.m = null;
        FLogger.a.g(ISessionEndPoint.a.b(this), new d0(r0));
        return;
    L13:
        IAssistantStartupTelemetry.a.e(r7, r0.a, null, null, MapsKt.mapOf(TuplesKt.to("child_surface_generation", String.valueOf(r0.c))), 14);
        final boolean r1 = r7.k(r0.a, r0.b, "child_first_frame");
        final boolean r2 = r7.d(r0.a, "first_frame_ready", r0.b);
        this.m = null;
        FLogger.a.g(ISessionEndPoint.a.b(this), new e0(r0, r1, r2));
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void c() {
        FLogger.a.i(ISessionEndPoint.a.b(this), "onAiKeyLongPressFailed");
        this.l = false;
        this.d = false;
        this.n = false;
        ObricInteractDelegate r1 = ObricInteractDelegate.b;
        r1.notifyAiKeyEvent(0);
        r1.resetIsAiKeyLongPress();
        IAssistActivateOperation r0 = bga.d.a();
        if (r0 == null) goto L6;
        r0.q();
        return;
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void g() {
        FLogger.a.d(ISessionEndPoint.a.b(this), "onAiKeyCancelled");
        String r4 = this.k;
        if (w("cancelled", "ai_key_cancelled", r4) == true) goto L16;
        if (r4 == null) goto L16;
        AssistantStartupTelemetry r2 = AssistantStartupTelemetry.a;
        Long r3 = Long.valueOf(this.i);
        if (r3.longValue() <= 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        long r9 = r3.longValue();
    L15:
        IAssistantStartupTelemetry.a.d(r2, new uga.a(r4, "ai_key", "physical_press", "assistant", r9, this.j, SetsKt.setOf("route_ready"), MapsKt.mapOf(TuplesKt.to("request_from", bga.j.a()))), "cancelled", "ai_key_cancelled");
        goto L16
    L14:
        r9 = SystemClock.elapsedRealtime();
        goto L15
    L8:
        r8 = false;
    L16:
        this.l = false;
        this.d = false;
        ObricInteractDelegate r0 = ObricInteractDelegate.b;
        r0.notifyAiKeyEvent(0);
        r0.resetIsAiKeyLongPress();
        x();
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "AiKeySessionEndpoint";
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void i() {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyShortPress");
        if (N("short_press", true) == false) goto L5;
        return;
    L5:
        s("short_press", "click_talk", SetsKt.setOf(new String[]{"first_frame_ready", "asr_record_ready"}), MapsKt.emptyMap());
        boolean r3 = false;
        this.d = false;
        ObricInteractDelegate r4 = ObricInteractDelegate.b;
        r4.notifyAiKeyEvent(0);
        r4.resetIsAiKeyLongPress();
        if (this.n == false) goto L9;
        this.n = false;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyShortPress, start LiveTutor click talk after skipped press start");
    L13:
        if (J("short press", this.k, new f0(this)) == false) goto L16;
        x();
        return;
    L16:
        IAssistActivateOperation r5 = bga.d.a();
        if (r5 == null) goto L19;
        boolean r6 = r5.j();
    L21:
        if (r6 == false) goto L42;
        ObricWakeupLatencyTrackService r7 = ObricWakeupLatencyTrackService.b;
        r7.d("WAKEUP_SOURCE_AI_KEY_DOWN", "AI_KEY_SHORT_PRESS", this.e);
        r7.b(this.h);
        ILaunchMethodOperation r8 = bga.g.a();
        if (r8 == null) goto L25;
        r8.k("open_voice_input");
    L25:
        IWakeupLatencyTrackService.a.a(r7);
        IAssistActivateOperation r9 = bga.d.a();
        if (r9 == null) goto L38;
        bga.a.b r10 = new bga.a.b(false);
        String r11 = this.k;
        if (r11 != null) goto L30;
    L36:
        Bundle r12 = null;
    L37:
        r3 = IAssistActivateOperation.a.a(r9, r10, r12, null, 8);
        goto L38
    L30:
        if ((!StringsKt.isBlank(r11)) == true) goto L33;
        r11 = null;
    L33:
        if (r11 == null) goto L36;
        r12 = new Bundle();
        r12.putString("obric_startup_attempt_id", r11);
    L38:
        if (r3 == false) goto L40;
        H("short_press", "open_voice_input");
    L41:
        r0.i(ISessionEndPoint.a.b(this), "short press routeAccepted=" + r3 + ", activation result=" + j0.a(true));
        return;
    L40:
        w("blocked", "click_talk_activation_failed", this.k);
        r4.notifyAiKeyEvent(2);
        goto L41
    L42:
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyShortPress result=" + j0.a(false));
        w("blocked", "intercom_condition_failed", this.k);
        x();
        return;
    L19:
        r6 = false;
        goto L21
    L9:
        if (M("short_press") == false) goto L13;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyShortPress, keep LiveTutor in-place recording");
        x();
    }

    @Override // com.obric.assistant.session.model.IAiKeyOperation
    public final boolean isAiKeyPressing() {
        boolean r0 = this.d;
        FLogger.a.i(ISessionEndPoint.a.b(this), "isAiKeyPressing " + r0);
        return r0;
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void j() {
        FLogger.a.d(ISessionEndPoint.a.b(this), "onAiKeyGestureTimeout");
        Set r12 = SetsKt.setOf("route_ready");
        Map r1 = MapsKt.emptyMap();
        String r2 = this.k;
        if (r2 == null) goto L26;
        boolean r5 = true;
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L26;
        AssistantStartupTelemetry r15 = AssistantStartupTelemetry.a;
        Long r4 = Long.valueOf(this.i);
        if (r4.longValue() > 0) goto L14;
        r5 = false;
    L14:
        if (r5 == true) goto L17;
        r4 = null;
    L17:
        if (r4 == null) goto L19;
        long r6 = r4.longValue();
    L21:
        if (IAssistantStartupTelemetry.a.d(r15, new uga.a(r2, "ai_key", "physical_press", "assistant", r6, this.j, r12, MapsKt.plus(MapsKt.mapOf(TuplesKt.to("request_from", bga.j.a())), r1)), "timeout", "ai_key_gesture_timeout") == true) goto L23;
    L25:
        u(r2);
        goto L26
    L23:
        if (Intrinsics.areEqual(this.k, r2) == false) goto L25;
        this.k = null;
        goto L25
    L19:
        r6 = SystemClock.elapsedRealtime();
    L26:
        this.l = false;
        this.d = false;
        ObricInteractDelegate r3 = ObricInteractDelegate.b;
        r3.notifyAiKeyEvent(0);
        r3.resetIsAiKeyLongPress();
        x();
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void k() {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyLongPress");
        boolean r2 = false;
        if (N("long_press", false) == false) goto L5;
        return;
    L5:
        s("long_press", "touch_speak", SetsKt.setOf(new String[]{"first_frame_ready", "asr_record_ready"}), MapsKt.emptyMap());
        if (J("long press", this.k, new h0(this)) == false) goto L9;
        ObricInteractDelegate r1 = ObricInteractDelegate.b;
        r1.notifyAiKeyEvent(0);
        r1.resetIsAiKeyLongPress();
        x();
        return;
    L9:
        IAssistActivateOperation r3 = bga.d.a();
        if (r3 == null) goto L12;
        boolean r4 = r3.j();
    L14:
        if (r4 == false) goto L49;
        ObricWakeupLatencyTrackService r5 = ObricWakeupLatencyTrackService.b;
        r5.d("WAKEUP_SOURCE_AI_KEY_DOWN", "AI_KEY_LONG_PRESS", this.e);
        r5.b(this.h);
        IFlowTtsClientService.a.getClass();
        PlayStateEnum r6 = IFlowTtsClientService.a.a().m();
        if (r6 != PlayStateEnum.PLAY_STATE_STOPPED) goto L18;
    L20:
        ILaunchMethodOperation r7 = bga.g.a();
        if (r7 == null) goto L23;
        r7.k("open_radio_mode");
    L23:
        ObricInteractDelegate.b.notifyAiKeyEvent(3);
        if (this.n == false) goto L32;
        this.n = false;
        IWakeupLatencyTrackService.a.a(r5);
        IAssistActivateOperation r8 = bga.d.a();
        if (r8 == null) goto L28;
        Bundle r9 = new Bundle();
        r9.putBoolean("arg_long_press_ai", true);
        boolean r10 = IAssistActivateOperation.a.b(r8, r9, false, new AiKeySessionEndpoint$onAiKeyLongPress$showResult$2(this), 6);
    L29:
        if (r10 == true) goto L32;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyLongPress, show LiveTutor listening UI failed");
        x();
        return;
    L28:
        r10 = false;
    L32:
        IAssistActivateOperation r11 = bga.d.a();
        if (r11 == null) goto L45;
        bga.a.c r12 = new bga.a.c();
        String r13 = this.k;
        if (r13 != null) goto L37;
    L43:
        Bundle r14 = null;
    L44:
        r2 = IAssistActivateOperation.a.a(r11, r12, r14, null, 8);
        goto L45
    L37:
        if ((!StringsKt.isBlank(r13)) == true) goto L40;
        r13 = null;
    L40:
        if (r13 == null) goto L43;
        r14 = new Bundle();
        r14.putString("obric_startup_attempt_id", r13);
    L45:
        if (r2 == false) goto L47;
        H("long_press", "open_radio_mode");
    L48:
        r0.i(ISessionEndPoint.a.b(this), "long press routeAccepted=" + r2 + ", activation result=" + j0.a(true));
        return;
    L47:
        w("blocked", "touch_speak_activation_failed", this.k);
        goto L48
    L18:
        if (r6 == PlayStateEnum.PLAY_STATE_FAIL) goto L20;
        aga.j.m();
        goto L20
    L49:
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyLongPress result=" + j0.a(false));
        w("blocked", "intercom_condition_failed", this.k);
        ObricInteractDelegate r15 = ObricInteractDelegate.b;
        r15.notifyAiKeyEvent(0);
        r15.resetIsAiKeyLongPress();
        x();
        return;
    L12:
        r4 = false;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v35, types: [com.obric.assistant.session.endpoint.g] */
    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void l() {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeySinglePress");
        ObricAiKeyGestureAction r1 = ObricAiKeyGestureAction.SINGLE_PRESS;
        boolean r3 = false;
        if (this.g == false) goto L7;
        this.g = false;
        int r2 = sha.b.a;
        Intrinsics.checkNotNullParameter(r1, "action");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "action");
        ObricListeningMainProcessManager.k(new com.obric.assistant.activation.presentation.runtime.manager.x0(r1));
    L7:
        if (M("single_press") == false) goto L10;
        this.d = false;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeySinglePress, keep LiveTutor in-place recording");
        x();
        return;
    L10:
        ISystemKeySettings r4 = (ISystemKeySettings) this.a.getValue();
        if (r4 == null) goto L13;
        Integer r5 = Integer.valueOf(r4.getSingleClickAction());
    L15:
        if (r5 != null) goto L18;
    L35:
        if (r5 != null) goto L38;
    L40:
        boolean r6 = false;
    L41:
        if (r6 == false) goto L43;
        String r7 = "window";
    L44:
        if (r6 == false) goto L46;
        String r8 = "window_content_ready";
    L47:
        s("single_press", r7, SetsKt.setOf(r8), MapsKt.emptyMap());
        IAssistActivateOperation r9 = bga.d.a();
        if (r9 == null) goto L50;
        Integer r10 = Integer.valueOf(r9.m());
    L52:
        if (r10 != null) goto L55;
    L56:
        if (r10 != null) goto L59;
    L61:
        if (r10 != null) goto L64;
    L67:
        if (r10 != null) goto L70;
    L72:
        if (r10 == null) goto L86;
        if (r10.intValue() != (-11)) goto L86;
        IAssistantChatWindow r11 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r11 != null) goto L79;
    L81:
        boolean r12 = false;
    L82:
        if (r12 == true) goto L86;
        w("blocked", "screen_rotated", this.k);
        aga.j.l(2131911966);
        return;
    L79:
        if (r11.isWindowMode() != true) goto L81;
        r12 = true;
    L86:
        if (this.o.c() == false) goto L88;
    L95:
        ISessionMaintaining r13 = bga.j.b();
        if (r13 == null) goto L98;
        r13.closeSystemDialogs();
    L98:
        ILaunchMethodOperation r14 = bga.g.a();
        if (r14 == null) goto L101;
        ILaunchMethodOperation.a.a(r14, ActivateEventType.SinglePress, null, 2);
    L101:
        r0.w(ISessionEndPoint.a.b(this), "power key click");
        AppHost.Companion r15 = AppHost.a;
        if (r15.a().isAppBackground() == true) goto L122;
        IOAutoOperation r16 = bga.h.a();
        if (r16 != null) goto L106;
    L108:
        boolean r17 = false;
    L109:
        if (r17 == true) goto L122;
        Activity r18 = r15.a().getCurrentActivity();
        if (r18 == null) goto L118;
        AppletExtService r19 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r19 == null) goto L115;
        Boolean r20 = Boolean.valueOf(r19.o(r18));
    L116:
        if (r20 == null) goto L118;
        boolean r21 = r20.booleanValue();
    L119:
        if (r21 == true) goto L122;
        ObricInteractionServiceDelegate.b.b(null);
        A();
        return;
    L115:
        r20 = null;
    L118:
        r21 = false;
        goto L119
    L106:
        if (r16.c() != true) goto L108;
        r17 = true;
    L122:
        r0.w(ISessionEndPoint.a.b(this), "app background");
        IObricContinuousTalkService r22 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r22 != null) goto L125;
    L127:
        boolean r23 = false;
    L128:
        if (r23 == false) goto L131;
        r0.i(ISessionEndPoint.a.b(this), "stop continuous talk tts");
        r22.c();
        v("stopped_existing_continuous_talk");
        return;
    L131:
        if (O("single click background") == false) goto L133;
        v("interrupted_existing_tts");
        return;
    L133:
        r0.i(ISessionEndPoint.a.b(this), "IExternalInputTask::class.getService() = " + ServiceManager.get().getService(ISpecialInputTask.class));
        ISystemKeySettings r24 = (ISystemKeySettings) this.a.getValue();
        if (r24 != null) goto L136;
    L138:
        boolean r25 = false;
    L139:
        if (r25 == false) goto L154;
        if (ObricStateService.a.a() == true) goto L154;
        IAssistActivateOperation r26 = bga.d.a();
        if (r26 != null) goto L145;
    L147:
        boolean r27 = false;
    L148:
        if (r27 == false) goto L154;
        IAssistantChatWindow r28 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r28 == null) goto L152;
        r28.onWakeupBlockedBySystemAlertWindowPermission();
    L152:
        w("blocked", "system_alert_window_permission", this.k);
        return;
    L145:
        if (r26.m() != (-15)) goto L147;
        r27 = true;
    L154:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L181;
        if (ObricStateService.a.a() == false) goto L165;
        v("existing_rtc_not_tracked_in_phase1");
        ILaunchMethodOperation r29 = bga.g.a();
        if (r29 == null) goto L160;
        r29.k("open_doubao");
    L160:
        final ?? r30 = new g(this);
        if (t1.a.i() == false) goto L163;
        r30.run();
        return;
    L163:
        com.obric.assistant.spi.keyguard.a.a(new h(r30), new i(), null, false, 28);
        return;
    L165:
        if (t1.a.i() == false) goto L171;
        if (r25 == false) goto L171;
        if (J("single click open chat window", this.k, new j(this)) == true) goto L235;
        C(this, false, null, 3);
        return;
    L235:
        return;
    L171:
        if (r25 == true) goto L173;
        ILaunchMethodOperation r31 = bga.g.a();
        if (r31 == null) goto L179;
        r31.k("open_doubao");
    L179:
        final String r32 = this.k;
        com.obric.assistant.spi.keyguard.a.a(new m(this, r32), new n(this, r32), null, false, 28);
        return;
    L173:
        if (J("single click open chat window", this.k, new k(this)) == true) goto L236;
        C(this, true, null, 2);
        return;
    L236:
        return;
    L181:
        if (ObricStateService.a.a() == false) goto L191;
        v("existing_rtc_not_tracked_in_phase1");
        ILaunchMethodOperation r33 = bga.g.a();
        if (r33 == null) goto L185;
        r33.k("open_doubao");
    L185:
        IObricLaunchService r34 = z();
        if (r34 == null) goto L188;
        r34.resumeOrLaunchNewTask(true);
    L188:
        IOAutoOperation r35 = bga.h.a();
        if (r35 == null) goto L230;
        IOAutoOperation.a.a(r35);
        return;
    L230:
        return;
    L191:
        ISystemKeySettings r36 = (ISystemKeySettings) this.a.getValue();
        if (r36 != null) goto L194;
    L196:
        boolean r37 = false;
    L197:
        if (r37 == false) goto L200;
        D(this);
        return;
    L200:
        if (aga.j.h() == false) goto L202;
        gd9.i r38 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r38);
        Toast.makeText(r38.getApplication(), 2131912394, 0).show();
        w("blocked", "screen_landscape", this.k);
        return;
    L202:
        K(this.k);
        ILaunchMethodOperation r39 = bga.g.a();
        if (r39 == null) goto L205;
        r39.k("open_doubao");
    L205:
        IObricLaunchService r40 = z();
        if (r40 == null) goto L208;
        r40.resumeOrLaunchNewTask(true);
    L208:
        IOAutoOperation r41 = bga.h.a();
        if (r41 == null) goto L234;
        IOAutoOperation.a.a(r41);
        return;
    L234:
        return;
    L194:
        if (r36.getSingleClickAction() != 0) goto L196;
        r37 = true;
        goto L197
    L136:
        if (r24.getSingleClickAction() != 0) goto L138;
        r25 = true;
        goto L139
    L125:
        if (r22.isActive() != true) goto L127;
        r23 = true;
        goto L128
    L88:
        if (AppHost.a.a().isAppBackground() == false) goto L95;
        if (O("single click pocket mode background") == false) goto L93;
        v("interrupted_existing_tts");
        return;
    L93:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_WARNING);
        this.o.g();
        w("blocked", "pocket_mode", this.k);
        return;
    L70:
        if (r10.intValue() != (-3)) goto L72;
        w("blocked", "user_not_login", this.k);
        goto L72
    L64:
        if (r10.intValue() != (-16)) goto L67;
        r0.i(ISessionEndPoint.a.b(this), "single press blocked for current disabled chat input");
        w("blocked", "chat_input_disabled", this.k);
        return;
    L59:
        if (r10.intValue() != (-14)) goto L61;
    L212:
        O("single click condition failed");
        w("blocked", "intercom_condition_" + r10, this.k);
        String r42 = ISessionEndPoint.a.b(this);
        if (r10 != null) goto L216;
    L218:
        String r43 = "ai key disabled when screen off";
    L219:
        r0.i(r42, r43);
        return;
    L216:
        if (r10.intValue() != (-14)) goto L218;
        r43 = "ai key fingerprint enrolling";
        goto L219
    L55:
        if (r10.intValue() == (-12)) goto L212;
    L50:
        r10 = null;
        goto L52
    L46:
        r8 = "chat_content_ready";
        goto L47
    L43:
        r7 = "chat";
        goto L44
    L38:
        if (r5.intValue() != 0) goto L40;
        r6 = true;
        goto L41
    L18:
        if (r5.intValue() != 2) goto L35;
        r0.w(ISessionEndPoint.a.b(this), "do nothing!");
        if (AppHost.a.a().isAppBackground() == true) goto L30;
        IOAutoOperation r44 = bga.h.a();
        if (r44 != null) goto L24;
    L26:
        if (r3 == true) goto L30;
        A();
    L33:
        v("configured_do_nothing");
        return;
    L24:
        if (r44.c() != true) goto L26;
        r3 = true;
    L30:
        if (O("single click do nothing background") == false) goto L33;
        v("configured_do_nothing");
        return;
    L13:
        r5 = null;
        goto L15
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void o() {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyLongPressStop");
        boolean r2 = true;
        if (N("long_press_stop", true) == false) goto L5;
        return;
    L5:
        this.d = false;
        if (this.n == false) goto L10;
        this.n = false;
        ObricInteractDelegate r1 = ObricInteractDelegate.b;
        r1.notifyAiKeyEvent(0);
        r1.resetIsAiKeyLongPress();
        x();
        return;
    L10:
        if (L() == false) goto L13;
        r0.i(ISessionEndPoint.a.b(this), "long press stop blocked before user guide");
        ObricInteractDelegate.b.notifyAiKeyEvent(0);
        w("cancelled", "stopped_before_user_guide", this.k);
        x();
        return;
    L13:
        IAssistActivateOperation r3 = bga.d.a();
        if (r3 != null) goto L16;
    L18:
        r2 = false;
    L19:
        if (r2 == true) goto L22;
        w("cancelled", "long_press_stopped_before_ready", this.k);
        return;
    L22:
        return;
    L16:
        if (r3.k() != true) goto L18;
        goto L18
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void q() {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyDoublePress");
        ObricAiKeyGestureAction r1 = ObricAiKeyGestureAction.DOUBLE_PRESS;
        if (this.g == false) goto L6;
        this.g = false;
        int r2 = sha.b.a;
        Intrinsics.checkNotNullParameter(r1, "action");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "action");
        ObricListeningMainProcessManager.k(new com.obric.assistant.activation.presentation.runtime.manager.x0(r1));
    L6:
        ISystemKeySettings r3 = (ISystemKeySettings) this.a.getValue();
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf(r3.getDoubleClickAction());
    L11:
        if (r4 == null) goto L18;
        if (r4.intValue() != 4) goto L18;
        r0.i(ISessionEndPoint.a.b(this), "double click do nothing");
        v("double_press_configured_do_nothing");
        return;
    L18:
        if (r4 != null) goto L21;
    L23:
        if (r4 != null) goto L26;
    L28:
        boolean r5 = false;
    L29:
        String r8 = "camera";
        if (r4 != null) goto L33;
    L35:
        if (r4 != null) goto L38;
    L40:
        if (r4 != null) goto L43;
    L45:
        String r9 = "video";
    L46:
        if (r5 == true) goto L49;
        r8 = "realtime_call";
    L49:
        if (r5 == false) goto L51;
        String r6 = "camera_content_ready";
    L52:
        final String r7 = s("double_press", r8, SetsKt.setOf(r6), MapsKt.mapOf(TuplesKt.to("call_type", r9)));
        if ((!StringsKt.isBlank(r7)) == true) goto L56;
    L55:
        r7 = null;
    L56:
        IAssistActivateOperation r10 = bga.d.a();
        if (r10 == null) goto L59;
        Integer r11 = Integer.valueOf(r10.m());
    L60:
        if (r11 != null) goto L63;
    L66:
        String r12 = "intercom_condition_failed";
        if (r11 != null) goto L70;
    L73:
        if (r11 == null) goto L87;
        if (r11.intValue() != (-11)) goto L87;
        IAssistantChatWindow r13 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r13 != null) goto L80;
    L82:
        boolean r14 = false;
    L83:
        if (r14 == true) goto L87;
        y(r7, "screen_rotated");
        aga.j.l(2131911966);
        return;
    L80:
        if (r13.isWindowMode() != true) goto L82;
        r14 = true;
    L87:
        if (aga.j.h() == false) goto L90;
        aga.j.l(2131912394);
        y(r7, "screen_landscape");
        return;
    L90:
        if (r11 == null) goto L97;
        if (r11.intValue() != (-14)) goto L97;
        r0.i(ISessionEndPoint.a.b(this), "ai key fingerprint enrolling");
        y(r7, "intercom_condition_failed");
        return;
    L97:
        if (this.o.c() == true) goto L111;
        if (r4 != null) goto L101;
    L109:
        this.o.f(true, AppHost.a.a().isAppBackground(), new p());
        y(r7, "pocket_mode");
        return;
    L101:
        if (r4.intValue() != 0) goto L109;
        IBluetoothHeadSetAPI r15 = tha.c.a();
        if (r15 != null) goto L105;
    L107:
        boolean r16 = false;
    L108:
        if (r16 == true) goto L111;
    L105:
        if (r15.a() != true) goto L107;
        r16 = true;
    L111:
        Iterator r17 = AppHost.a.a().g().iterator();
    L113:
        if (r17.hasNext() == false) goto L122;
        Object r18 = r17.next();
        Activity r19 = (Activity) r18;
        ILiveTutorService r110 = (ILiveTutorService) ServiceManager.get().getService(ILiveTutorService.class);
        if (r110 != null) goto L117;
    L119:
        boolean r111 = false;
    L120:
        if (r111 == false) goto L113;
    L123:
        Activity r20 = (Activity) r18;
        if (r20 != null) goto L126;
    L129:
        boolean r21 = false;
    L130:
        if (r21 == false) goto L133;
        y(r7, "intercom_condition_failed");
        return;
    L133:
        ISessionMaintaining r22 = bga.j.b();
        if (r22 == null) goto L136;
        r22.closeSystemDialogs();
    L136:
        ILaunchMethodOperation r23 = bga.g.a();
        if (r23 == null) goto L140;
        ILaunchMethodOperation.a.a(r23, ActivateEventType.DoublePress, null, 2);
    L140:
        if (ILoginService.a.getAccountInfo().a == false) goto L213;
        FLogger r24 = FLogger.a;
        r24.i(ISessionEndPoint.a.b(this), "goto realtime call");
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().n(false);
        boolean r112 = com.obric.assistant.common.utils.p.g();
        r24.i(ISessionEndPoint.a.b(this), "double click function " + r4);
        wna.a.a();
        ISessionMaintaining r113 = bga.j.b();
        if (r113 == null) goto L144;
        r113.v();
    L144:
        if (r4 == null) goto L156;
        if (r4.intValue() != 3) goto L156;
        ILaunchMethodOperation r25 = bga.g.a();
        if (r25 == null) goto L152;
        r25.k("open_doubao_camera");
    L152:
        if (t1.a.i() == false) goto L154;
        r24.w(ISessionEndPoint.a.b(this), "locked screen use enabled");
        E(r7);
        return;
    L154:
        r24.w(ISessionEndPoint.a.b(this), "locked screen use disabled");
        com.obric.assistant.spi.keyguard.a.a(new s(this, r7), new t(this, r7), null, false, 28);
        return;
    L156:
        if (r112 == false) goto L161;
        if (com.obric.assistant.common.utils.p.c() == false) goto L161;
        aga.j.l(2131911951);
        w("blocked", "mic_in_use_by_camera", r7);
        return;
    L161:
        if (CollectionsKt.listOf(new Integer[]{2, 1}).contains(Integer.valueOf(ISessionEndPoint.a.a().getMode())) == false) goto L163;
    L212:
        aga.j.l(2131911952);
        w("blocked", "in_call_mode", r7);
        return;
    L163:
        if (ISessionEndPoint.a.a().getMode() == 3) goto L165;
    L167:
        if (r112 == false) goto L169;
    L208:
        aga.j.l(2131911952);
        if (r112 == false) goto L211;
        r12 = "mic_in_use";
    L211:
        w("blocked", r12, r7);
        return;
    L169:
        if (com.obric.assistant.voice.n.a == true) goto L208;
        if (r4 != null) goto L174;
    L176:
        if (r4 != null) goto L179;
    L181:
        if (r4 != null) goto L184;
    L186:
        final CallType r26 = CallType.Video;
    L187:
        ILaunchMethodOperation r27 = bga.g.a();
        if (r27 == null) goto L200;
        int r28 = c.a[r26.ordinal()];
        if (r28 == 1) goto L197;
        if (r28 == 2) goto L196;
        if (r28 != 3) goto L195;
        String r29 = "open_share_screen_call";
    L198:
        r27.k(r29);
        goto L200
    L195:
        throw new NoWhenBranchMatchedException();
    L196:
        r29 = "open_video_call";
        goto L198
    L197:
        r29 = "open_voice_call";
    L200:
        if (t1.a.i() == true) goto L202;
        com.obric.assistant.spi.keyguard.a.a(new x(this, r26, r7), new y(this, r7), null, false, 28);
        return;
    L202:
        if (c.a[r26.ordinal()] != 3) goto L204;
        com.obric.assistant.spi.keyguard.a.a(new u(r26, r7), new v(this, r7), null, false, 28);
        return;
    L204:
        ISessionMaintaining r30 = bga.j.b();
        if (r30 == null) goto L224;
        r30.u(r26, r7);
        return;
    L224:
        return;
    L184:
        if (r4.intValue() != 2) goto L186;
        r26 = CallType.ScreenShare;
        goto L187
    L179:
        if (r4.intValue() != 1) goto L181;
        r26 = CallType.Video;
        goto L187
    L174:
        if (r4.intValue() != 0) goto L176;
        r26 = CallType.Audio;
        goto L187
    L165:
        if (ObricStateService.a.a() == true) goto L167;
    L213:
        y(r7, "user_not_login");
        com.obric.assistant.spi.keyguard.a.a(new q(this), new r(), null, false, 28);
        return;
    L126:
        if (AppHost.a.a().isAppBackground() == false) goto L128;
        r20.finish();
        goto L129
    L128:
        aga.j.l(2131911964);
        r21 = true;
        goto L130
    L117:
        if (r110.b(r19) != true) goto L119;
        r111 = true;
        goto L120
    L122:
        r18 = null;
        goto L123
    L70:
        if (r11.intValue() != (-12)) goto L73;
        r0.i(ISessionEndPoint.a.b(this), "ai key disabled when screen off");
        y(r7, "intercom_condition_failed");
        return;
    L63:
        if (r11.intValue() != (-1)) goto L66;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyDoublePress, in user guide");
        y(r7, "user_guide_showing");
        return;
    L59:
        r11 = null;
        goto L60
    L51:
        r6 = "rtc_call_content_ready";
        goto L52
    L43:
        if (r4.intValue() != 3) goto L45;
        r9 = "camera";
        goto L46
    L38:
        if (r4.intValue() != 2) goto L40;
        r9 = "screen_share";
        goto L46
    L33:
        if (r4.intValue() != 0) goto L35;
        r9 = "audio";
        goto L46
    L26:
        if (r4.intValue() != 3) goto L28;
        r5 = true;
        goto L29
    L21:
        if (r4.intValue() != 4) goto L23;
    L9:
        r4 = null;
        goto L11
    }

    public final void x() {
        if (this.g == true) goto L5;
        return;
    L5:
        this.g = false;
        int r0 = sha.b.a;
        ObricListeningMainProcessManager r1 = ObricListeningMainProcessManager.a;
        ObricListeningViewState r2 = ObricListeningViewState.d;
        r1.getClass();
        ObricListeningMainProcessManager.p(r2);
    }

    public final IObricLaunchService z() {
        return (IObricLaunchService) this.c.getValue();
    }

    public AiKeySessionEndpoint() {
        this.a = LazyKt.lazy(new l());
        this.b = LazyKt.lazy(new w());
        this.c = LazyKt.lazy(new c0());
        this.j = "receiver_elapsed_fallback";
        this.o = PocketModeDetector.a;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IAiKeyOperation
    public final void startLauncherIntent() {
        IObricLaunchService r0 = z();
        if (r0 == null) goto L6;
        r0.startLauncherIntent();
        return;
    }

    @Override // com.obric.assistant.session.model.IAiKeyOperation
    public final long e() {
        return this.e;
    }

    @Override // com.obric.assistant.session.model.IAiKeyOperation
    public final long m() {
        return this.f;
    }

    public static void D(final AiKeySessionEndpoint r4) {
        String r0 = r4.k;
        r4.getClass();
        if (aga.j.i() == false) goto L6;
        FLogger.a.i(ISessionEndPoint.a.b(r4), "skip open chat window, user guide is showing");
        r4.w("blocked", "user_guide_showing", r0);
        return;
    L6:
        if (r4.J("single click open chat window", r0, new o(r4)) == true) goto L11;
        r4.G(r0);
        return;
    }

    public static void K(String r6) {
        if (r6 == null) goto L8;
        AssistantStartupTelemetry r0 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r0.i("first_frame_ready"), r6) == true) goto L9;
        IAssistantStartupTelemetry.a.e(r0, r6, "chat", SetsKt.setOf("chat_content_ready"), MapsKt.mapOf(TuplesKt.to("route", "activity")), 2);
        return;
    L9:
        return;
    }

    public static final void r(AiKeySessionEndpoint r2) {
        r2.getClass();
        int r3 = com.obric.assistant.feedback.a.a;
        boolean r1 = false;
        if (ISessionEndPoint.a.a().getRingerMode() != 2) goto L12;
        IDoraOperation r4 = bga.f.a();
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
        r1 = true;
        goto L12
    L7:
        if (r4.b() != true) goto L9;
        r5 = true;
    L12:
        com.obric.assistant.feedback.a.b(r1);
    }

    public final void E(final String r13) {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "launchDoubaoCamera");
        ada.d r1 = null;
        boolean r2 = true;
        if (r13 == null) goto L12;
        AtomicReference<String> r3 = uga.c.a;
        Intrinsics.checkNotNullParameter(r13, "attemptId");
        if ((!StringsKt.isBlank(r13)) == false) goto L7;
        String r4 = r13;
    L8:
        if (r4 == null) goto L11;
        uga.c.a.set(r4);
    L11:
        g1.a.postDelayed(new b0(r13), 15000);
        goto L12
    L7:
        r4 = null;
    L12:
        IObricRealtimeCallService r5 = (IObricRealtimeCallService) ServiceManager.get().getService(IObricRealtimeCallService.class);
        AppHost.Companion r6 = AppHost.a;
        FragmentActivity r7 = r6.a().getCurrentActivity();
        if (r7 == null) goto L21;
        if (r5 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L21;
    L23:
        if ((r7 instanceof FragmentActivity) == false) goto L26;
        if (r5 == null) goto L26;
        r5.k(r7);
    L26:
        r0.i(ISessionEndPoint.a.b(this), "launchDoubaoCamera rtcActivity is : " + r7);
        IAssistantChatWindow r9 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r9 == null) goto L31;
        t1a.b r10 = r9.provideWindowVContext();
        if (r10 == null) goto L31;
        ada.d r11 = (ada.d) r10.getAbility(ada.d.class);
    L32:
        FragmentActivity r12 = r6.a().getCurrentActivity();
        if ((r12 instanceof FragmentActivity) == false) goto L35;
        FragmentActivity r14 = r12;
    L36:
        boolean r15 = r6.a().isAppBackground();
        if (r14 == null) goto L45;
        boolean r16 = r14.hasWindowFocus();
        if (com.larus.home.impl.utils.c.e == false) goto L43;
        r0.i("DecorViewLancet", "hasWindowFocus");
        Thread r17 = ThreadMethodProxy.currentThread();
        if (r17 == com.larus.home.impl.utils.c.a) goto L43;
        com.larus.home.impl.utils.c.a(r17, "hasWindowFocus");
    L43:
        if (r16 != true) goto L45;
        boolean r18 = true;
    L46:
        ObricInteractionServiceDelegate.b.b(r14);
        if (r14 == null) goto L51;
        t1a.b r19 = aga.j.g(r14);
        if (r19 == null) goto L51;
        r1 = (ada.d) r19.getAbility(ada.d.class);
    L51:
        IAssistantChatWindow r20 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r20 != null) goto L54;
    L56:
        boolean r21 = false;
    L58:
        if (r21 == false) goto L74;
        r0.i(ISessionEndPoint.a.b(this), "tryDirectOpenPlusCamera from chat window");
        if (r11 != null) goto L62;
    L64:
        boolean r22 = false;
    L65:
        if (r22 == true) goto L110;
        if (r13 != null) goto L72;
        ObricAssistantDelegate r110 = ObricAssistantDelegate.b;
        if (r7 != null) goto L71;
        r2 = false;
    L71:
        r110.j(r2);
        return;
    L72:
        uga.c.a(r13);
        w("blocked", "camera_ability_unavailable", r13);
        return;
    L110:
        return;
    L62:
        if (r11.WV(r13) != true) goto L64;
        r22 = true;
        goto L65
    L74:
        if (r1 == null) goto L86;
        if (r18 == false) goto L86;
        if (r15 == true) goto L86;
        r0.i(ISessionEndPoint.a.b(this), "tryDirectOpenPlusCamera from current chat page");
        if (r1.WV(r13) == true) goto L111;
        if (r13 != null) goto L85;
        ObricAssistantDelegate r111 = ObricAssistantDelegate.b;
        if (r7 != null) goto L84;
        r2 = false;
    L84:
        r111.j(r2);
        return;
    L85:
        uga.c.a(r13);
        w("blocked", "camera_ability_unavailable", r13);
        return;
    L111:
        return;
    L86:
        if (r1 == null) goto L93;
        if (r18 == true) goto L93;
        if (r15 == true) goto L93;
        r0.i(ISessionEndPoint.a.b(this), "skip opening camera during app background transition");
        if (r13 == null) goto L92;
        uga.c.a(r13);
    L92:
        w("dropped", "camera_background_transition", r13);
        return;
    L93:
        r0.i(ISessionEndPoint.a.b(this), "routeToCameraCapture, isAppBackground=" + r15 + ", hasWindowFocus=" + r18);
        if (r13 != null) goto L101;
        ObricAssistantDelegate r112 = ObricAssistantDelegate.b;
        if (r7 != null) goto L99;
        r2 = false;
    L99:
        r112.j(r2);
        return;
    L101:
        ObricAssistantDelegate r23 = ObricAssistantDelegate.b;
        if (r7 != null) goto L106;
        r2 = false;
    L106:
        if (r23.e(r2, r13) == true) goto L115;
        uga.c.a(r13);
        w("blocked", "camera_already_foreground", r13);
        return;
    L115:
        return;
    L54:
        if (r20.isShowing() != true) goto L56;
        r21 = true;
    L45:
        r18 = false;
        goto L46
    L35:
        r14 = null;
    L31:
        r11 = null;
        goto L32
    L16:
        if (r5.s(r7) != true) goto L18;
        r8 = true;
    L21:
        r7 = null;
        goto L23
    }

    public final void G(String r12) {
        IAssistActivateOperation r0 = bga.d.a();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        IAssistantInteractionServiceKt.getInteractionStateService().addCustomBarAction(new CustomBarAction("obric_screen_qa", null, null, null, 14, null));
    L10:
        C(this, false, r12, 1);
        return;
    L5:
        if (r0.l() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean M(String r12) {
        AppHost.Companion r0 = AppHost.a;
        boolean r2 = false;
        if (r0.a().isAppBackground() == false) goto L5;
        return false;
    L5:
        Lazy r1 = aga.j.a;
        FragmentActivity r5 = null;
        if (Build.VERSION.SDK_INT < 29) goto L46;
        long r6 = System.currentTimeMillis();
        Object r3 = r0.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.ActivityManager");
        String r4 = r0.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r7 = ((ActivityManager) r3).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r7);
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L9:
        if (r9.hasNext() == false) goto L17;
        Object r10 = r9.next();
        ComponentName r11 = ((ActivityManager.RecentTaskInfo) r10).baseActivity;
        if (r11 == null) goto L13;
        String r13 = r11.getPackageName();
    L15:
        if (Intrinsics.areEqual(r13, r4) == false) goto L9;
        r8.add(r10);
        goto L9
    L13:
        r13 = null;
        goto L15
    L17:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r15 = r8.iterator();
    L19:
        if (r15.hasNext() == false) goto L21;
        r14.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r15.next()).taskId));
        goto L19
    L21:
        List r16 = AppHost.a.a().m();
        ListIterator r17 = r16.listIterator(r16.size());
    L23:
        if (r17.hasPrevious() == false) goto L34;
        Object r18 = r17.previous();
        Activity r19 = (Activity) r18;
        if ((r19 instanceof FragmentActivity) == true) goto L27;
    L31:
        boolean r20 = false;
    L32:
        if (r20 == false) goto L23;
    L35:
        FragmentActivity r21 = (FragmentActivity) r18;
        Activity r22 = AppHost.a.a().getCurrentActivity();
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r24.append(r14);
        r24.append(",result=");
        r24.append(r21);
        r24.append(':');
        if ((r21 instanceof Activity) == false) goto L38;
        Activity r110 = r21;
    L39:
        if (r110 == null) goto L41;
        Integer r111 = Integer.valueOf(r110.getTaskId());
    L42:
        r24.append(r111);
        r24.append(", cur=");
        r24.append(r22);
        r24.append(':');
        if (r22 == null) goto L45;
        r5 = Integer.valueOf(r22.getTaskId());
    L45:
        r24.append(r5);
        r24.append(",cost:");
        r24.append(System.currentTimeMillis() - r6);
        r23.d("AiIsland-SessionUtils", r24.toString());
    L51:
        if (r21 != null) goto L53;
        return false;
    L53:
        ILiveTutorService r25 = (ILiveTutorService) ServiceManager.get().getService(ILiveTutorService.class);
        if (r25 != null) goto L56;
    L58:
        boolean r26 = false;
    L59:
        if (r26 == true) goto L61;
        return false;
    L61:
        Lazy r27 = aga.j.a;
        Intrinsics.checkNotNullParameter(r21, "<this>");
        aga.j.a r28 = aga.j.c(r21);
        if (r28 != null) goto L65;
        return false;
    L65:
        if (r28.b == false) goto L67;
        return false;
    L67:
        t1a.b r29 = r28.a;
        maa.e r30 = r29.getAbility(maa.e.class);
        if (r30 != null) goto L70;
    L72:
        boolean r31 = false;
    L73:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r32 = r29.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r32 != null) goto L76;
    L78:
        boolean r33 = false;
    L79:
        if (r31 == true) goto L81;
        if (r33 == true) goto L81;
    L82:
        FLogger.a.i(ISessionEndPoint.a.b(this), "shouldKeepLiveTutorInPlaceRecording scene=" + r12 + ", isClickTalking=" + r31 + ", isSpeaking=" + r33 + ", shouldKeep=" + r2);
        return r2;
    L81:
        r2 = true;
        goto L82
    L76:
        if (r32.m0() != true) goto L78;
        r33 = true;
        goto L79
    L70:
        if (r30.x3() != true) goto L72;
        r31 = true;
        goto L73
    L56:
        if (r25.b(r21) != true) goto L58;
        r26 = true;
        goto L59
    L41:
        r111 = null;
        goto L42
    L38:
        r110 = null;
        goto L39
    L27:
        if (r14.contains(Integer.valueOf(r19.getTaskId())) == false) goto L29;
    L30:
        r20 = true;
        goto L32
    L29:
        if (r19.getTaskId() != 0) goto L31;
    L34:
        r18 = null;
        goto L35
    L46:
        FragmentActivity r34 = r0.a().getCurrentActivity();
        if ((r34 instanceof FragmentActivity) == false) goto L50;
        r5 = r34;
    L50:
        r21 = r5;
        goto L51
    }

    public final boolean O(String r9) {
        String r0 = "AiKeySessionEndpoint.tryInterruptActiveTts:".concat(r9);
        IFlowTtsClientService.a.getClass();
        PlayStateEnum r1 = IFlowTtsClientService.a.a().m();
        boolean r4 = false;
        if (r1 != PlayStateEnum.PLAY_STATE_STOPPED) goto L5;
    L9:
        boolean r2 = false;
    L10:
        IObricChainTtsService.a.getClass();
        IObricChainTtsService r3 = IObricChainTtsService.a.a();
        if (r3 != null) goto L13;
    L15:
        if (r4 == false) goto L20;
        if (ObricStateService.a.a() == true) goto L20;
        FLogger.a.i(ISessionEndPoint.a.b(this), r9.concat(", interrupt active obric tts"));
        r3.c(r0);
        return true;
    L20:
        return r2;
    L13:
        if (r3.b() != true) goto L15;
        r4 = true;
        goto L15
    L5:
        if (r1 == PlayStateEnum.PLAY_STATE_FAIL) goto L9;
        if (ObricStateService.a.a() == true) goto L9;
        FLogger.a.i(ISessionEndPoint.a.b(this), r9 + ", interrupt active flow tts, ttsState=" + r1);
        aga.j.m();
        r2 = true;
        goto L10
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void a(Bundle r24) {
        if (r24 == null) goto L9;
        String r4 = r24.getString("obric_startup_attempt_id");
        if (r4 == null) goto L9;
        if ((!StringsKt.isBlank(r4)) == false) goto L9;
    L11:
        if (r24 == null) goto L13;
        long r8 = r24.getLong("android.intent.extra.TIME", -1);
    L14:
        long r10 = SystemClock.uptimeMillis();
        if (r24 == null) goto L17;
        long r12 = r24.getLong("android.intent.extra.TIME", -1);
    L19:
        if (r12 <= 0) goto L21;
        long r13 = RangesKt.coerceAtLeast(r10 - r12, 0);
    L23:
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_AI_KEY_DOWN") == false) goto L64;
        final String r2 = this.k;
        if (r2 != null) goto L27;
    L31:
        boolean r14 = false;
    L32:
        if (r14 == false) goto L34;
        FLogger.a.g(ISessionEndPoint.a.b(this), new e(r2));
    L35:
        this.l = false;
        long r6 = System.currentTimeMillis();
        long r15 = SystemClock.uptimeMillis();
        long r21 = SystemClock.elapsedRealtime();
        if (r24 == null) goto L43;
        String r3 = r4;
        Long r5 = Long.valueOf(r24.getLong("android.intent.extra.TIME", -1));
        if (r5.longValue() <= 0) goto L40;
        boolean r7 = true;
    L41:
        if (r7 == false) goto L44;
        Long r16 = r5;
    L45:
        if (r16 == null) goto L47;
        long r9 = 0;
        long r17 = r6 - RangesKt.coerceAtLeast(r15 - r16.longValue(), 0);
    L48:
        this.e = r17;
        if (r16 == null) goto L51;
        long r18 = r16.longValue();
    L52:
        this.f = r18;
        this.h = r6;
        if (r16 == null) goto L55;
        r21 = uga.e.a(r16.longValue());
    L55:
        this.i = r21;
        if (r16 == null) goto L58;
        String r11 = "uptime_converted_to_elapsed";
    L59:
        this.j = r11;
        if (r3 != null) goto L62;
        String r19 = UUID.randomUUID().toString();
    L63:
        this.k = r19;
        goto L64
    L62:
        r19 = r3;
        goto L63
    L58:
        r11 = "receiver_elapsed_fallback";
        goto L59
    L51:
        r18 = r9;
        goto L52
    L47:
        r9 = 0;
        r17 = r6;
    L44:
        r16 = null;
        goto L45
    L40:
        r7 = false;
        goto L41
    L43:
        r3 = r4;
        goto L44
    L34:
        w("cancelled", "new_ai_key_sequence", this.k);
        goto L35
    L27:
        if (uga.c.b(r2) == false) goto L31;
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.h(), r2) == false) goto L31;
        r14 = true;
    L64:
        this.d = true;
        this.n = false;
        ILaunchMethodOperation r20 = bga.g.a();
        if (r20 == null) goto L67;
        r20.g();
    L67:
        FLogger.a.i(ISessionEndPoint.a.b(this), "onAiKeyDown: eventTime=" + r8 + ", currentUptime=" + r10 + ", backtrackDurationMs=" + r13);
        IAssistActivateOperation r22 = bga.d.a();
        if (r22 == null) goto L70;
        r22.e(r24, r13);
    L70:
        this.o.b();
        g1.a.post(new f(this));
        return;
    L21:
        r13 = 100;
        goto L23
    L17:
        r12 = -1;
        goto L19
    L13:
        r8 = -1;
    L9:
        r4 = null;
        goto L11
    }

    @Override // com.obric.assistant.session.singleton.AiKeyActionDetector.a
    public final void b(String r8) {
        FLogger r0 = FLogger.a;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyPressStart");
        s("long_press", "touch_speak", SetsKt.setOf(new String[]{"first_frame_ready", "asr_record_ready"}), MapsKt.emptyMap());
        Integer r3 = null;
        if (com.larus.utils.o0.d(r8) == false) goto L7;
        ILaunchMethodOperation r1 = bga.g.a();
        if (r1 == null) goto L11;
        ILaunchMethodOperation.a.a(r1, null, r8, 1);
    L11:
        if (J("long press start", this.k, new i0(this)) == false) goto L14;
        this.l = true;
        ObricInteractDelegate r9 = ObricInteractDelegate.b;
        r9.notifyAiKeyEvent(0);
        r9.resetIsAiKeyLongPress();
        x();
        return;
    L14:
        IAssistActivateOperation r10 = bga.d.a();
        if (r10 == null) goto L17;
        r3 = Integer.valueOf(r10.m());
    L17:
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyPressStart currentIntercomConditionStatus: " + r3);
        if (r3 != null) goto L21;
    L28:
        IAssistActivateOperation r11 = bga.d.a();
        if (r11 == null) goto L31;
        boolean r12 = r11.j();
    L33:
        if (r12 == true) goto L35;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyPressStart, onAiKeyLongPressFailed");
        IAssistActivateOperation r13 = bga.d.a();
        if (r13 == null) goto L63;
        r13.a();
    L63:
        this.l = true;
        w("blocked", "intercom_condition_failed", this.k);
        x();
        return;
    L35:
        if (this.o.c() == true) goto L47;
        IBluetoothHeadSetAPI r14 = tha.c.a();
        if (r14 != null) goto L39;
    L41:
        boolean r15 = false;
    L42:
        if (r15 == true) goto L47;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyPressStart, pocket mode detected, block it!");
        IAssistActivateOperation r16 = bga.d.a();
        if (r16 == null) goto L46;
        r16.b(-13);
    L46:
        this.l = true;
        w("blocked", "pocket_mode", this.k);
        x();
        this.o.f(true, AppHost.a.a().isAppBackground(), new com.obric.assistant.session.endpoint.b());
        return;
    L39:
        if (r14.a() != true) goto L41;
        r15 = true;
    L47:
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyPressStart, notify ai key press start");
        if (M("press_start") == false) goto L51;
        this.n = true;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyPressStart, keep LiveTutor in-place recording");
        x();
        return;
    L51:
        ObricInteractDelegate.b.notifyAiKeyEvent(1);
        ILaunchMethodOperation r17 = bga.g.a();
        if (r17 == null) goto L54;
        r17.k("open_radio_mode");
    L54:
        IWakeupLatencyTrackService.a.a(ObricWakeupLatencyTrackService.b);
        IAssistActivateOperation r18 = bga.d.a();
        if (r18 == null) goto L66;
        Bundle r2 = new Bundle();
        r2.putBoolean("arg_long_press_ai", true);
        String r4 = this.k;
        if (r4 == null) goto L59;
        r2.putString("obric_startup_attempt_id", r4);
    L59:
        IAssistActivateOperation.a.b(r18, r2, false, new AiKeySessionEndpoint$onAiKeyPressStart$4(this), 6);
        return;
    L66:
        return;
    L31:
        r12 = false;
        goto L33
    L21:
        if (r3.intValue() != 0) goto L28;
        Lazy r19 = aga.j.a;
        int r20 = aga.j.a(com.obric.assistant.common.utils.a0.a(), false);
        if (r20 == r3.intValue()) goto L28;
        r0.i(ISessionEndPoint.a.b(this), "onAiKeyPressStart refresh intercomConditionCheckResult: " + r3 + " -> " + r20);
        IAssistActivateOperation r5 = bga.d.a();
        if (r5 == null) goto L28;
        r5.b(r20);
        goto L28
    L7:
        ILaunchMethodOperation r21 = bga.g.a();
        if (r21 == null) goto L11;
        ILaunchMethodOperation.a.a(r21, ActivateEventType.LongPress, null, 2);
        goto L11
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r1) {
        ISessionEndPoint.a.c(this, r1);
    }

    public final void t(Bundle r7) {
        final String r0 = r7.getString("obric_startup_attempt_id");
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L23;
        final long r1 = r7.getLong("obric_child_first_frame_elapsed_ms", -1);
        final int r8 = r7.getInt("obric_child_first_frame_generation", -1);
        if (r1 <= 0) goto L24;
        if (r8 < 0) goto L25;
        b r3 = this.m;
        if (r3 != null) goto L16;
    L19:
        this.m = new b(r0, r1, r8);
    L20:
        FLogger.a.g(ISessionEndPoint.a.b(this), new com.obric.assistant.session.endpoint.a(r0, r8, r1));
        return;
    L16:
        if (Intrinsics.areEqual(r3.a, r0) == false) goto L19;
        if (r1 >= r3.b) goto L20;
    L25:
        return;
    L24:
        return;
    }

    public final void u(String r3) {
        b r0 = this.m;
        if (r0 == null) goto L5;
        String r1 = r0.a;
    L7:
        if (Intrinsics.areEqual(r1, r3) == false) goto L10;
        this.m = null;
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void v(final String r6) {
        String r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L20;
        AssistantStartupTelemetry r1 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r1.h(), r0) == false) goto L13;
        r1.f(r0);
        FLogger.a.g(ISessionEndPoint.a.b(this), new com.obric.assistant.session.endpoint.c(r6));
    L15:
        if (Intrinsics.areEqual(this.k, r0) == false) goto L17;
        this.k = null;
    L17:
        u(r0);
        return;
    L13:
        FLogger.a.g(ISessionEndPoint.a.b(this), new d(r6));
        goto L15
    }

    public static void B(boolean r6, String r7) {
        if (r7 == null) goto L7;
        AssistantStartupTelemetry r0 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r0.i("first_frame_ready"), r7) == true) goto L7;
        IAssistantStartupTelemetry.a.e(r0, r7, "window", SetsKt.setOf("window_content_ready"), MapsKt.mapOf(TuplesKt.to("route", "window")), 2);
    L7:
        ILaunchMethodOperation r1 = bga.g.a();
        if (r1 == null) goto L10;
        r1.k("open_floating_window");
    L10:
        ISessionMaintaining r2 = bga.j.b();
        if (r2 == null) goto L17;
        Bundle r3 = new Bundle();
        r3.putBoolean("arg_long_press_ai", false);
        if (r7 == null) goto L15;
        r3.putString("obric_startup_attempt_id", r7);
    L15:
        Unit r8 = Unit.INSTANCE;
        ISessionMaintaining.a.a(r2, r3, null, r6, 13);
        return;
    }

    public final void H(String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("press_type", r4);
        r0.put("wakeup_from", "WAKEUP_SOURCE_AI_KEY_DOWN");
        r0.put(WindowEvent.Params.LAUNCH_SERVICE, r5);
        r0.put("trigger_timestamp_ms", this.e);
        IpcMessenger.k(IpcMessenger.a, 11, 0, r0.toString(), 6);
    }

    public final boolean N(final String r5, boolean r6) {
        if (this.l == true) goto L5;
        return false;
    L5:
        FLogger.a.g(ISessionEndPoint.a.b(this), new g0(r5));
        if (r6 == false) goto L8;
        this.l = false;
    L8:
        this.d = false;
        ObricInteractDelegate r7 = ObricInteractDelegate.b;
        r7.notifyAiKeyEvent(0);
        r7.resetIsAiKeyLongPress();
        x();
        return true;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r17, Continuation<? super Pair<? extends ErrorCode, String>> r18) {
        if ((r18 instanceof AiKeySessionEndpoint$onSessionProcess$1) == false) goto L7;
        AiKeySessionEndpoint$onSessionProcess$1 r9 = (AiKeySessionEndpoint$onSessionProcess$1) r18;
        int r10 = r9.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r9.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r0 = r9.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r9.label;
        boolean r13 = true;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        Bundle r14 = (Bundle) r9.L$0;
        ResultKt.throwOnFailure(r0);
        Bundle r1 = r14;
    L17:
        com.obric.assistant.common.utils.i.a r15 = com.obric.assistant.common.utils.i.a("ObricAiKey.sessionProcess");
    L107:
        th = move-exception;
        if (r15 == null) goto L110;
        r15.a();
    L110:
        throw th;
    L19:
        if (ArraysKt.contains(new String[]{"WAKEUP_SOURCE_AI_KEY_DOWN", "WAKEUP_SOURCE_AI_KEY_UP", "WAKEUP_SOURCE_AI_KEY_CANCEL"}, bga.j.a()) == false) goto L102;
        t(r1);     // Catch: Throwable -> L107
        int r16 = r1.getInt("obric_listening_show_owner", -1);     // Catch: Throwable -> L107
        boolean r19 = Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_AI_KEY_DOWN");     // Catch: Throwable -> L107
        boolean r110 = false;
        if (r19 == false) goto L26;
        if (r16 != 1) goto L24;
        boolean r111 = true;
    L25:
        this.g = r111;     // Catch: Throwable -> L107
        goto L26
    L24:
        r111 = false;
    L26:
        CoWakeupApi r112 = uha.a.a();     // Catch: Throwable -> L107
        if (r112 != null) goto L29;
    L31:
        boolean r113 = false;
    L32:
        if (r113 == false) goto L41;
        IDoraOperation r114 = bga.f.a();     // Catch: Throwable -> L107
        if (r114 != null) goto L36;
    L38:
        boolean r115 = false;
    L39:
        if (r115 == false) goto L41;
        boolean r116 = true;
    L43:
        if (r116 == false) goto L66;
        FLogger.a.i(ISessionEndPoint.a.b(this), "isDoraPressing, ignore AI KEY action");     // Catch: Throwable -> L107
        String r2 = r1.getString("obric_startup_attempt_id");     // Catch: Throwable -> L107
        if (r2 != null) goto L47;
    L52:
        String r117 = this.k;     // Catch: Throwable -> L107
    L54:
        if (w("blocked", "dora_pressing", r117) == true) goto L56;
        I(r1, r117, "blocked", "dora_pressing");     // Catch: Throwable -> L107
    L56:
        AiKeyActionDetector.a.getClass();     // Catch: Throwable -> L107
        if (((cba.b) AiKeyActionDetector.f.getValue()).d != ObricAiKeyGestureState.IDLE) goto L60;
        r13 = false;
    L60:
        if (r13 == false) goto L62;
        AiKeyActionDetector.b(r1);     // Catch: Throwable -> L107
    L62:
        this.l = false;     // Catch: Throwable -> L107
        this.d = false;     // Catch: Throwable -> L107
        ObricInteractDelegate r3 = ObricInteractDelegate.b;     // Catch: Throwable -> L107
        r3.notifyAiKeyEvent(0);     // Catch: Throwable -> L107
        r3.resetIsAiKeyLongPress();     // Catch: Throwable -> L107
        x();     // Catch: Throwable -> L107
        Pair r4 = TuplesKt.to(ErrorCode.QUIT_SESSION, "aiKey-doraPressing");     // Catch: Throwable -> L107
        if (r15 == null) goto L65;
        r15.a();
    L65:
        return r4;
    L47:
        if ((!StringsKt.isBlank(r2)) == false) goto L49;
        r117 = r2;
    L50:
        if (r117 == null) goto L52;
    L49:
        r117 = null;
        goto L50
    L66:
        if (r19 == true) goto L84;
        AiKeyActionDetector.a.getClass();     // Catch: Throwable -> L107
        if (((cba.b) AiKeyActionDetector.f.getValue()).d == ObricAiKeyGestureState.IDLE) goto L70;
        r110 = true;
    L70:
        if (r110 == true) goto L84;
        FLogger.a.i(ISessionEndPoint.a.b(this), "drop unresolved orphan AI key UP/CANCEL, owner=" + r16);     // Catch: Throwable -> L107
        String r5 = r1.getString("obric_startup_attempt_id");     // Catch: Throwable -> L107
        if (r5 != null) goto L75;
    L80:
        String r118 = this.k;     // Catch: Throwable -> L107
    L82:
        if (w("dropped", "ai_key_orphan_up_cancel", r118) == true) goto L92;
        I(r1, r118, "dropped", "ai_key_orphan_up_cancel");     // Catch: Throwable -> L107
    L92:
        ILaunchMethodOperation r6 = bga.g.a();     // Catch: Throwable -> L107
        if (r6 == null) goto L95;
        r6.j();     // Catch: Throwable -> L107
    L95:
        IObricChatService.a.getClass();     // Catch: Throwable -> L107
        IObricChatService r7 = IObricChatService.a.a();     // Catch: Throwable -> L107
        if (r7 == null) goto L98;
        r7.e();     // Catch: Throwable -> L107
    L98:
        Pair r8 = TuplesKt.to(ErrorCode.QUIT_SESSION, "aiKey OP");     // Catch: Throwable -> L107
        if (r15 == null) goto L101;
        r15.a();
    L101:
        return r8;
    L75:
        if ((!StringsKt.isBlank(r5)) == false) goto L77;
        r118 = r5;
    L78:
        if (r118 == null) goto L80;
    L77:
        r118 = null;
    L84:
        String r20 = bga.j.a();     // Catch: Throwable -> L107
        if (Intrinsics.areEqual(r20, "WAKEUP_SOURCE_AI_KEY_DOWN") == false) goto L88;
        AiKeyActionDetector.a.getClass();     // Catch: Throwable -> L107
        AiKeyActionDetector.c(r1);     // Catch: Throwable -> L107
    L91:
        F();     // Catch: Throwable -> L107
        goto L92
    L88:
        if (Intrinsics.areEqual(r20, "WAKEUP_SOURCE_AI_KEY_UP") == false) goto L90;
        AiKeyActionDetector.a.getClass();     // Catch: Throwable -> L107
        AiKeyActionDetector.d(r1);     // Catch: Throwable -> L107
        goto L91
    L90:
        AiKeyActionDetector.a.getClass();     // Catch: Throwable -> L107
        AiKeyActionDetector.b(r1);     // Catch: Throwable -> L107
        goto L91
    L36:
        if (r114.b() != true) goto L38;
        r115 = true;
    L41:
        r116 = false;
        goto L43
    L29:
        if (r112.b() != true) goto L31;
        r113 = true;
        goto L32
    L102:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L107
        if (r15 == null) goto L106;
        r15.a();
    L106:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r1 = r17;
        r9.L$0 = r1;
        r9.label = 1;
        if (ISessionEndPoint.a.e(this) != r11) goto L17;
        return r11;
    L7:
        r9 = new AiKeySessionEndpoint$onSessionProcess$1(this, r18);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r1, Bundle r2) {
        ISessionEndPoint.a.d(this, r1, r2);
    }

    public final void y(String r2, String r3) {
        if (r2 == null) goto L4;
        w("blocked", r3, r2);
        return;
    L4:
        v("double_press_".concat(r3));
    }

    public final boolean J(final String r6, final String r7, final Function1<? super String, Unit> r8) {
        if (L() == true) goto L6;
        return false;
    L6:
        if (KeyguardService.a.isRequestingDismissKeyguard() == false) goto L9;
        FLogger.a.i(ISessionEndPoint.a.b(this), r6.concat(" blocked before user guide, dismiss keyguard already requesting"));
        w("blocked", "dismiss_keyguard_in_progress", r7);
        return true;
    L9:
        FLogger.a.i(ISessionEndPoint.a.b(this), r6.concat(" blocked before user guide, request dismiss keyguard"));
        com.obric.assistant.spi.keyguard.a.a(new z(this, r6, r8, r7), new a0(this, r6, r7), null, false, 28);
        return true;
    }

    public final boolean w(String r10, String r11, String r12) {
        boolean r0 = false;
        if (r12 != null) goto L5;
    L17:
        return r0;
    L5:
        if ((!StringsKt.isBlank(r12)) == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L17;
        AssistantStartupTelemetry r3 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r3.h(), r12) == false) goto L14;
        r0 = IAssistantStartupTelemetry.a.a(r3, r12, r10, r11, null, 24);
    L14:
        if (Intrinsics.areEqual(this.k, r12) == false) goto L16;
        this.k = null;
    L16:
        u(r12);
        goto L17
    }

    public static /* synthetic */ void C(AiKeySessionEndpoint r1, boolean r2, String r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = r1.k;
    L8:
        r1.getClass();
        B(r2, r3);
    }

    public final void I(Bundle r17, String r18, String r19, String r20) {
        String r2 = r17.getString("obric_startup_attempt_id");
        boolean r3 = true;
        Long r4 = null;
        if (r2 != null) goto L5;
    L10:
        if (r18 != null) goto L12;
    L14:
        r2 = null;
    L15:
        if (r2 != null) goto L17;
        return;
    L17:
        Long r1 = Long.valueOf(r17.getLong("android.intent.extra.TIME", -1));
        long r5 = r1.longValue();
        if (Intrinsics.areEqual(bga.j.a(), "WAKEUP_SOURCE_AI_KEY_DOWN") == true) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == true) goto L26;
        r1 = null;
    L26:
        AssistantStartupTelemetry r15 = AssistantStartupTelemetry.a;
        if (r1 == null) goto L29;
        int r7 = uga.e.a;
        long r8 = uga.e.a(r1.longValue());
    L38:
        if (r1 == null) goto L41;
        String r9 = "uptime_converted_to_elapsed";
    L44:
        IAssistantStartupTelemetry.a.d(r15, new uga.a(r2, "ai_key", "physical_press", "assistant", r8, r9, SetsKt.setOf("route_ready"), MapsKt.mapOf(TuplesKt.to("request_from", bga.j.a()))), r19, r20);
        u(r2);
        return;
    L41:
        if (this.i <= 0) goto L43;
        r9 = this.j;
        goto L44
    L43:
        r9 = "receiver_elapsed_fallback";
        goto L44
    L29:
        Long r10 = Long.valueOf(this.i);
        if (r10.longValue() > 0) goto L33;
        r3 = false;
    L33:
        if (r3 == false) goto L35;
        r4 = r10;
    L35:
        if (r4 == null) goto L37;
        r8 = r4.longValue();
        goto L38
    L37:
        r8 = SystemClock.elapsedRealtime();
        goto L38
    L20:
        if (r5 <= 0) goto L22;
        r6 = true;
        goto L23
    L12:
        if ((!StringsKt.isBlank(r18)) == false) goto L14;
        r2 = r18;
        goto L15
    L5:
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        goto L10
    }

    public final String s(String r21, String r22, Set<String> r23, Map<String, String> r24) {
        Map<String, String> r10 = MapsKt.plus(MapsKt.mapOf(TuplesKt.to("request_from", bga.j.a())), r24);
        String r1 = this.k;
        if (r1 != null) goto L5;
    L7:
        String r7 = null;
    L9:
        if (r7 == null) goto L18;
        AssistantStartupTelemetry r2 = AssistantStartupTelemetry.a;
        if (Intrinsics.areEqual(r2.h(), r7) == false) goto L18;
        if (r2.g(r7, r21, r22, r23, r10) == false) goto L18;
        if (r23.contains("first_frame_ready") == false) goto L17;
        F();
        int r3 = sha.b.a;
        Intrinsics.checkNotNullParameter(r7, "attemptId");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "attemptId");
        ObricListeningMainProcessManager.k(new h1(r7, true));
    L17:
        return r7;
    L18:
        AssistantStartupTelemetry r9 = AssistantStartupTelemetry.a;
        String r8 = r9.h();
        this.k = null;
        Long r4 = Long.valueOf(this.i);
        if (r4.longValue() <= 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L27;
        long r6 = r4.longValue();
    L28:
        String r11 = r9.a(new uga.a(r7, "ai_key", r21, r22, r6, this.j, r23, r10));
        if ((!StringsKt.isBlank(r11)) == false) goto L31;
        String r13 = r11;
    L32:
        this.k = r13;
        if (r13 != null) goto L35;
    L42:
        return r11;
    L35:
        if (r8 == null) goto L40;
        if (Intrinsics.areEqual(r8, r13) == true) goto L40;
        uga.c.a(r8);
    L40:
        if (r23.contains("first_frame_ready") == false) goto L42;
        F();
        int r12 = sha.b.a;
        Intrinsics.checkNotNullParameter(r13, "attemptId");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r13, "attemptId");
        ObricListeningMainProcessManager.k(new h1(r13, true));
        goto L42
    L31:
        r13 = null;
        goto L32
    L27:
        r6 = SystemClock.elapsedRealtime();
        goto L28
    L21:
        r5 = false;
        goto L22
    L5:
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
        r7 = r1;
        goto L9
    }
}
