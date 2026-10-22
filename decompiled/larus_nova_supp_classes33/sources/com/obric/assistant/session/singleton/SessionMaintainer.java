package com.obric.assistant.session.singleton;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.service.voice.VoiceInteractionSession;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.account.base.api.ILoginService;
import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrResultValue;
import com.larus.audio.audiov3.task.asr.AsrStopType;
import com.larus.audio.flow.client.FlowTtsClientImpl;
import com.larus.bmhome.a0;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.permission.api.IPermissionX;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.h1;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.IWindowEffectsKt;
import com.obric.assistant.interaction.api.WeakUpState;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.base.interact.CustomBarAction;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.lifecycle.BluetoothSoundEffectPlayer;
import com.obric.assistant.session.model.IAiKeyOperation;
import com.obric.assistant.session.model.IAssistActivateOperation;
import com.obric.assistant.session.model.IAutoMicOperation;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import com.obric.assistant.session.model.IOAutoOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.model.IVoiceWakeupOperation;
import com.obric.assistant.special_input.ISpecialInputTask;
import com.obric.assistant.spi.audio.CallType;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.obric.assistant.spi.chat.ObricInteractionServiceDelegate;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService;
import com.obric.assistant.spi.wakeup.ObricOneshotDelegate;
import com.obric.assistant.spi.wakeup.WakeupLatencyTrackDelegate;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.obric.assistant.state.api.v2.ObricStateService;
import com.obric.assistant.storage.ObricLowStorageServiceDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.utils.ObricShowArgServiceDelegate;
import com.obric.assistant.voice.ContentScene;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g78.g0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u0084\u00012\u00020\u00012\u00020\u0002:\u0002\u0084\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020\fH\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\u0012\u0010/\u001a\u0004\u0018\u00010\u00182\u0006\u0010)\u001a\u00020*H\u0002J9\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010*2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u001b2\u0006\u00105\u001a\u00020\u001bH\u0016¢\u0006\u0002\u00106JC\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010*2\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u00010\u001b2\u0006\u00105\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u00108J\b\u00109\u001a\u00020$H\u0016J\u0018\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001bH\u0016J\"\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010=\u001a\u00020$H\u0016J\u001a\u0010>\u001a\u00020$2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u0018H\u0002J\u001a\u0010B\u001a\u00020$2\u0006\u0010A\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u000e\u0010C\u001a\u00020\u001b*\u0004\u0018\u00010*H\u0002J\b\u0010D\u001a\u00020\u001bH\u0016J\b\u0010E\u001a\u00020$H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010F\u001a\u00020\u001bH\u0002J\b\u0010G\u001a\u00020\u001bH\u0016J\b\u0010H\u001a\u00020$H\u0016J\u0010\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020\u0018H\u0016J\b\u0010K\u001a\u00020$H\u0002J\b\u0010L\u001a\u00020\u001bH\u0002J\b\u0010M\u001a\u00020$H\u0016J\u0012\u0010N\u001a\u00020$2\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J \u0010Q\u001a\u00020$2\b\b\u0002\u0010R\u001a\u00020\u001b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020$0TH\u0003J\u001a\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020W2\b\u00107\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010X\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u00010\u00182\u0006\u0010Y\u001a\u00020ZH\u0002J\"\u0010[\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u00010\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u0018H\u0002J\u001a\u0010]\u001a\u00020$2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010^\u001a\u00020\u001bH\u0016J\b\u0010_\u001a\u00020$H\u0016J\b\u0010`\u001a\u00020$H\u0016J\b\u0010a\u001a\u00020$H\u0016J\u0018\u0010b\u001a\u00020$2\u0006\u0010c\u001a\u00020\u00182\u0006\u0010d\u001a\u00020\u001fH\u0016J\u0012\u0010e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010c\u001a\u00020\u0018H\u0016J\u0018\u0010f\u001a\u00020$2\u0006\u0010%\u001a\u00020\f2\u0006\u0010)\u001a\u00020*H\u0016J\u0016\u0010g\u001a\u00020h2\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u0010iJ\u0018\u0010j\u001a\u00020$2\u0006\u0010k\u001a\u00020h2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010l\u001a\u00020$2\u0006\u0010Y\u001a\u00020mH\u0016J0\u0010n\u001a\u00020$2\u0006\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010\u00182\u0014\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010sH\u0016J\b\u0010v\u001a\u00020$H\u0016J\u0012\u0010w\u001a\u00020\u001b2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010x\u001a\u00020\u001b2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0014\u0010y\u001a\u00020\u001b*\u00020z2\u0006\u0010{\u001a\u00020,H\u0002J\b\u0010|\u001a\u00020$H\u0016J\u001e\u0010}\u001a\u00020$2\b\b\u0002\u0010~\u001a\u00020\u00182\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u007f\u001a\u0004\u0018\u00010**\u0004\u0018\u00010\u0018H\u0002J:\u0010\u0080\u0001\u001a\u00020$2\b\u0010A\u001a\u0004\u0018\u00010\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020\u00182\u0015\b\u0002\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180sH\u0002J\u001c\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u0083\u0001\u001a\u00020h2\u0006\u0010\\\u001a\u00020\u0018H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020uX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/obric/assistant/session/singleton/SessionMaintainer;", "Lcom/obric/assistant/session/model/ISessionMaintaining;", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/AsrLifeStateListener;", "<init>", "()V", "obricRealtimeCallService", "Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "getObricRealtimeCallService", "()Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "obricRealtimeCallService$delegate", "Lkotlin/Lazy;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "session", "Landroid/service/voice/VoiceInteractionSession;", "getSession", "()Landroid/service/voice/VoiceInteractionSession;", "setSession", "(Landroid/service/voice/VoiceInteractionSession;)V", "mAssistantRequestFrom", "", "mWakeupSessionName", "isAutoMicRequest", "", "mSessionStartupAttemptId", "dataMap", "", "", "asrListenerOwner", "Ljava/lang/ref/WeakReference;", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "init", "", "context", "interactionSession", "getContext", "distinguishWakeupSource", "args", "Landroid/os/Bundle;", "showFlags", "", "getAssistantRequestFrom", "getWakeupSessionName", "beginSessionAttemptIfNeeded", "launchAssistantDirectly", "isMicInUse", "extra", "ignoreSpecialInput", "wakeUpClickTalk", "checkScreenLock", "(ZLandroid/os/Bundle;ZLjava/lang/Boolean;Z)V", "startupAttemptId", "(ZLandroid/os/Bundle;ZLjava/lang/Boolean;ZLjava/lang/String;)V", "closeSystemDialogs", "launchAssistant", "showOnLauncherOrKeyguard", "needUpdate", "markActivateToRecordStart", "bindStartupAttempt", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "attemptId", "markStartupRouteReady", "hasWakeProcessAsrReady", "launchAssistantNow", "tryClearOneshotOrDoraState", "canLaunchAssistant", "tryFinishChatActivity", "startAsrTimeout", "stopAsrTimeout", "str", "launchTalkPage", "tryFinishChatActivityIfNeed", "interruptMovingBackground", "dismissAllVisibleDialogFragments", "activity", "Landroidx/fragment/app/FragmentActivity;", "dealWithScreenLocked", "addScreenShotAction", "failed", "Lkotlin/Function0;", "launchRealtimeCall", "callType", "Lcom/obric/assistant/spi/audio/CallType;", "finishRealtimeCallStartupAttemptOnLaunchResult", WindowEvent.Params.RESULT, "Lcom/obric/assistant/spi/audio/LaunchRealtimeCallResult;", "finishRealtimeCallStartupAttempt", WindowEvent.Params.REASON, "checkOpenSpecialInput", "isVoiceInput", "unregisterAsrListener", "registerAsrListener", "onStopIntercom", "store", "key", "value", "get", "onSessionPrepare", "onSessionProcess", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionComplete", "errorCode", "onResult", "Lcom/larus/audio/audiov3/config/task/sami/asr/AsrResultData;", "onLifeStateChanged", "lifeState", "Lcom/larus/audio/audiov3/task/asr/AsrLifeState;", "taskId", "extraMap", "", "asrTimeOutTask", "Ljava/lang/Runnable;", "closeClickTalk", "tryFinishApplet", "tryFinishDialogFragment", "isChatPage", "Landroidx/fragment/app/Fragment;", "depth", "reset", "reportLaunchFailed", "message", "toStartupBundle", "finishSessionAttempt", "attributes", "terminalResultForSession", "code", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionMaintainer implements ISessionMaintaining, com.larus.bmhome.chat.component.bottom.core.speaker.b {
    public static final Lazy<String> k = null;
    public final Lazy a;
    public Context b;
    public VoiceInteractionSession c;
    public volatile String d;
    public volatile String e;
    public volatile boolean f;
    public String g;
    public final Map<String, Object> h;
    public WeakReference<com.larus.bmhome.chat.component.bottom.core.speaker.l> i;
    public final j j;

    public static final class a {
        public static String a() {
            return (String) SessionMaintainer.k.getValue();
        }
    }

    public /* synthetic */ class b {
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
        k = LazyKt.lazy(new k());
    }

    public final Context C() {
        Context r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
        return null;
    }

    public final VoiceInteractionSession D() {
        VoiceInteractionSession r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("session");
        return null;
    }

    public final void J() {
        FLogger r0 = FLogger.a;
        String r1 = a.a();
        StringBuilder r2 = new StringBuilder("tryClearOneshotOrDoraState ...... from ");
        r2.append(this.d);
        r2.append(" , doraWakeup ");
        IDoraOperation r3 = bga.f.a();
        if (r3 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r3.c());
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L11;
        IVoiceWakeupOperation r5 = (IVoiceWakeupOperation) ServiceManager.get().getService(IVoiceWakeupOperation.class);
        if (r5 == null) goto L11;
        r5.a();
    L11:
        IDoraOperation r6 = bga.f.a();
        if (r6 == null) goto L16;
        boolean r7 = true;
        if (r6.c() != true) goto L16;
    L17:
        if (r7 == false) goto L20;
        DoraWakeupDetector r8 = DoraWakeupDetector.a;
        DoraWakeupDetector.f();
        ObricOneshotDelegate.b.g();
        return;
    L20:
        return;
    L16:
        r7 = false;
        goto L17
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void c() {
        WeakReference<com.larus.bmhome.chat.component.bottom.core.speaker.l> r0 = this.i;
        if (r0 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = r0.get();
    L6:
        this.i = null;
        FLogger.a.i(a.a(), "unregisterAsrListener, registeredSpeaker: " + r1);
        if (r1 == null) goto L10;
        r1.K8(this);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void closeSystemDialogs() {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        D().closeSystemDialogs();
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void i() {
        FLogger.a.i(a.a(), "startAsrTimeout , will timeout in 10 secs");
        y.b().removeCallbacks(this.j);
        y.b().postDelayed(this.j, ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS);
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final boolean j() {
        FLogger.a.i(a.a(), "tryFinishChatActivityIfNeed");
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        com.obric.audio.continuous_talk.b r2 = null;
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 == null) goto L10;
        t1a.b r3 = aga.j.g(r1);
        if (r3 == null) goto L10;
        laa.d r4 = (laa.d) r3.getAbility(laa.d.class);
    L12:
        if (r1 != null) goto L14;
        return false;
    L14:
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L21;
        return false;
    L21:
        if (r4.aF() == false) goto L24;
        r4.Gm(false);
    L40:
        return true;
    L24:
        if (r4.Xh() == true) goto L27;
        ObricFloatChatPageData.a r6 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r7 = r4.getPageState();
        r6.getClass();
        if ((r7 instanceof vda.f) == true) goto L27;
        return false;
    L27:
        t1a.b r8 = aga.j.g(r1);
        if (r8 == null) goto L31;
        r2 = (com.obric.audio.continuous_talk.b) r8.getAbility(com.obric.audio.continuous_talk.b.class);
    L31:
        if (((FlowTtsClientImpl) g0.a.getValue()).a() == true) goto L45;
        if (r2 != null) goto L34;
    L36:
        boolean r9 = false;
    L37:
        if (r9 == true) goto L46;
        r4.Gm(false);
        goto L40
    L46:
        return false;
    L34:
        if (r2.a0() != true) goto L36;
        r9 = true;
        goto L37
    L45:
        return false;
    L16:
        if (r4.Da() != true) goto L18;
        r5 = true;
    L10:
        r4 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.obric.assistant.session.singleton.m] */
    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void l() {
        FLogger r0 = FLogger.a;
        r0.i(a.a(), "launchAssistantNow 🚀");
        Object r1 = B("disableScreenShot");
        if ((r1 instanceof Boolean) == false) goto L5;
        Boolean r2 = (Boolean) r1;
    L6:
        boolean r3 = false;
        if (r2 == null) goto L9;
        final boolean r4 = r2.booleanValue();
    L10:
        Object r5 = C().getSystemService("keyguard");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.app.KeyguardManager");
        if (((KeyguardManager) r5).isKeyguardLocked() == false) goto L27;
        r0.w(a.a(), "keyguard locked, request dismiss");
        if (Build.VERSION.SDK_INT < 31) goto L26;
        final ?? r6 = new m(this);
        final String r7 = this.g;
        ILaunchMethodOperation r8 = bga.g.a();
        if (r8 == null) goto L18;
        r8.k("open_voice_input");
    L18:
        if (ILoginService.a.getAccountInfo().a == false) goto L25;
        r0.w(a.a(), "user is login");
        if (t1.a.i() == false) goto L24;
        r0.w(a.a(), "locked screen use enabled");
        if (Boolean.valueOf(s(true, false)).booleanValue() == true) goto L34;
        r6.invoke();
        return;
    L34:
        return;
    L24:
        r0.w(a.a(), "locked screen use disabled");
        com.obric.assistant.spi.keyguard.a.a(new n(this, r4, r7, r6), new o(this, r7, r6), null, false, 28);
        return;
    L25:
        r0.w(a.a(), "user not login");
        com.obric.assistant.spi.keyguard.a.a(new p(this, r7, r6), new q(this, r7, r6), null, false, 28);
        return;
    L26:
        H("Build.VERSION < 31", this.g);
        return;
    L27:
        r0.w(a.a(), "keyguard not locked, launch assistant");
        IAssistActivateOperation r9 = bga.d.a();
        if (r9 == null) goto L31;
        r3 = r9.l();
    L31:
        if (Boolean.valueOf(s(r3, true)).booleanValue() == true) goto L39;
        J();
        return;
    L39:
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void v() {
        t1a.b r0 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.b);
        FLogger r1 = FLogger.a;
        String r2 = a.a();
        StringBuilder r3 = new StringBuilder("closeClickTalk: hasChatContext=");
        boolean r5 = true;
        if (r0 == null) goto L5;
        boolean r6 = true;
    L6:
        r3.append(r6);
        r1.i(r2, r3.toString());
        if (r0 == null) goto L9;
        laa.d r4 = (laa.d) r0.getAbility(laa.d.class);
    L10:
        if (r0 == null) goto L12;
        com.larus.bmhome.chat.component.showcase.y r7 = (com.larus.bmhome.chat.component.showcase.y) r0.getAbility(com.larus.bmhome.chat.component.showcase.y.class);
    L13:
        if (r4 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L33;
        if (r7 != null) goto L21;
    L23:
        r5 = false;
    L24:
        if (r5 == false) goto L26;
        return;
    L26:
        if (r4.isVisible() == false) goto L35;
        if (r0 == null) goto L29;
        maa.e r9 = (maa.e) r0.getAbility(maa.e.class);
    L30:
        if (r9 == null) goto L36;
        maa.e.a.a(r9, null, null, false, 7);
        return;
    L36:
        return;
    L29:
        r9 = null;
        goto L30
    L35:
        return;
    L21:
        if (r7.iQ() != true) goto L23;
    L33:
        return;
    L15:
        if (r4.Da() != true) goto L17;
        r8 = true;
        goto L18
    L12:
        r7 = null;
        goto L13
    L9:
        r4 = null;
        goto L10
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void y() {
        FLogger.a.i(a.a(), "onStopIntercom, current is main thread " + Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
        I("onStopIntercom");
        y.c(new l(this));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SessionMaintainer$onStopIntercom$2(null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.session.singleton.j] */
    public SessionMaintainer() {
        this.a = LazyKt.lazy(new i());
        this.d = "";
        this.e = "";
        this.h = new LinkedHashMap();
        this.j = new j(this);
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public Context getContext() {
        return C();
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void interruptMovingBackground() {
        IAssistActivateOperation r0 = bga.d.a();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        FLogger.a.i(a.a(), "interruptMovingBackground showOnLauncher");
        IAssistantInteractionServiceKt.getInteractionStateService().clearCustomBarActions(true);
    L10:
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 == null) goto L14;
        r2.interruptMovingBackground();
        return;
    L14:
        return;
    L5:
        if (r0.o() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void m() {
        Object r0 = B("wakeupArgs");
        if ((r0 instanceof Bundle) == false) goto L5;
        Bundle r1 = (Bundle) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        long r2 = r1.getLong("o_dispatch_to_main_process_time", -1);
        if (r2 > 0) goto L11;
        return;
    L11:
        WakeupLatencyTrackDelegate r3 = WakeupLatencyTrackDelegate.b;
        ILaunchMethodOperation r4 = bga.g.a();
        if (r4 == null) goto L15;
        String r5 = r4.a();
        if (r5 == null) goto L15;
    L16:
        r3.a(r2, r5, r1.getBoolean("o_main_process_ready"));
        return;
    L15:
        r5 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void x() {
        c();
        Lazy r0 = aga.j.a;
        WeakReference<com.larus.bmhome.chat.component.bottom.core.speaker.l> r2 = null;
        if (Build.VERSION.SDK_INT < 29) goto L44;
        long r1 = System.currentTimeMillis();
        AppHost.Companion r3 = AppHost.a;
        Object r4 = r3.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.ActivityManager");
        String r5 = r3.getApplication().getPackageName();
        List<ActivityManager.RecentTaskInfo> r6 = ((ActivityManager) r4).getRecentTasks(Integer.MAX_VALUE, 1);
        Intrinsics.checkNotNull(r6);
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L6:
        if (r8.hasNext() == false) goto L14;
        Object r9 = r8.next();
        ComponentName r10 = ((ActivityManager.RecentTaskInfo) r9).baseActivity;
        if (r10 == null) goto L10;
        String r11 = r10.getPackageName();
    L12:
        if (Intrinsics.areEqual(r11, r5) == false) goto L6;
        r7.add(r9);
        goto L6
    L10:
        r11 = null;
        goto L12
    L14:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r13 = r7.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        r12.add(Integer.valueOf(((ActivityManager.RecentTaskInfo) r13.next()).taskId));
        goto L16
    L18:
        List r14 = AppHost.a.a().m();
        ListIterator r15 = r14.listIterator(r14.size());
    L20:
        if (r15.hasPrevious() == false) goto L31;
        Object r16 = r15.previous();
        Activity r17 = (Activity) r16;
        if ((r17 instanceof FragmentActivity) == true) goto L24;
    L28:
        boolean r18 = false;
    L29:
        if (r18 == false) goto L20;
    L32:
        Activity r19 = (FragmentActivity) r16;
        Activity r20 = AppHost.a.a().getCurrentActivity();
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("findLastStartedActivity -> hostTaskIdList:");
        r22.append(r12);
        r22.append(",result=");
        r22.append(r19);
        r22.append(':');
        if ((r19 instanceof Activity) == false) goto L35;
        Activity r23 = r19;
    L36:
        if (r23 == null) goto L38;
        Integer r24 = Integer.valueOf(r23.getTaskId());
    L39:
        r22.append(r24);
        r22.append(", cur=");
        r22.append(r20);
        r22.append(':');
        if (r20 == null) goto L42;
        Integer r25 = Integer.valueOf(r20.getTaskId());
    L43:
        r22.append(r25);
        r22.append(",cost:");
        r22.append(System.currentTimeMillis() - r1);
        r21.d("AiIsland-SessionUtils", r22.toString());
    L49:
        if ((r19 instanceof FragmentActivity) == true) goto L52;
        r19 = null;
    L52:
        if (r19 == null) goto L56;
        t1a.b r26 = aga.j.g(r19);
        if (r26 == null) goto L56;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r27 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r26.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
    L57:
        if (r27 == null) goto L59;
        r2 = new WeakReference(r27);
    L59:
        this.i = r2;
        FLogger.a.i(a.a(), "registerAsrListener " + r27);
        if (r27 == null) goto L74;
        r27.A4(this);
        return;
    L74:
        return;
    L56:
        r27 = null;
        goto L57
    L42:
        r25 = null;
        goto L43
    L38:
        r24 = null;
        goto L39
    L35:
        r23 = null;
        goto L36
    L24:
        if (r12.contains(Integer.valueOf(r17.getTaskId())) == false) goto L26;
    L27:
        r18 = true;
        goto L29
    L26:
        if (r17.getTaskId() != 0) goto L28;
    L31:
        r16 = null;
        goto L32
    L44:
        Activity r28 = AppHost.a.a().getCurrentActivity();
        if ((r28 instanceof FragmentActivity) == true) goto L47;
        r28 = null;
    L47:
        r19 = (FragmentActivity) r28;
        goto L49
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final boolean g() {
        return this.f;
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final String o() {
        return this.e;
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final String w() {
        return this.d;
    }

    public final Object B(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return ((LinkedHashMap) this.h).get(r2);
    }

    public final void I(String r5) {
        Intrinsics.checkNotNullParameter(r5, "str");
        FLogger.a.i(a.a(), "stopAsrTimeout from [" + r5 + ']');
        y.b().removeCallbacks(this.j);
    }

    public final void a(y58.b r5) {
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.RESULT);
        FLogger.a.i(a.a(), "onResult: " + r5);
        if (r5.g != AsrResultState.SUCCESS) goto L6;
        I("onResult from asr callback");
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final boolean e(Bundle r37) {
        Intrinsics.checkNotNullParameter(r37, "args");
        String r2 = r37.getString("REQUEST_FROM", "");
        Intrinsics.checkNotNull(r2);
        if (r2.length() <= 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L27;
        int r5 = r2.hashCode();
        if (r5 == (-2072330345)) goto L24;
        if (r5 == (-1012176807)) goto L20;
        if (r5 == 333419062) goto L16;
    L25:
        String r6 = r2;
    L28:
        this.f = r37.getBoolean("AUTO_MIC_REQUEST", false);
        FLogger r10 = FLogger.a;
        r10.i(a.a(), "distinguishWakeupSource isAutoMicRequest " + this.f);
        int r11 = r37.getInt("invocation_type", -1);
        if (r11 == (-2)) goto L52;
        switch(r11) {
            case -103: goto L37;
            case -102: goto L36;
            case -101: goto L35;
            case -100: goto L34;
            default: goto L31;
        };
    L31:
        switch(r11) {
            case 6: goto L41;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L38;
            default: goto L32;
        };
    L32:
        switch(r11) {
            case 20: goto L51;
            case 21: goto L50;
            case 22: goto L49;
            case 23: goto L48;
            case 24: goto L47;
            case 25: goto L46;
            case 26: goto L43;
            default: goto L54;
        };
    L46:
        r6 = "WAKEUP_SOURCE_DORA_KEY_CANCEL";
        goto L54
    L47:
        r6 = IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_KEY_UP;
        goto L54
    L48:
        r6 = "WAKEUP_SOURCE_DORA_KEY_DOWN";
        goto L54
    L49:
        r6 = "WAKEUP_SOURCE_AI_KEY_CANCEL";
        goto L54
    L50:
        r6 = "WAKEUP_SOURCE_AI_KEY_UP";
        goto L54
    L51:
        r6 = "WAKEUP_SOURCE_AI_KEY_DOWN";
        goto L54
    L43:
        if (this.f == false) goto L45;
        r6 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
        goto L54
    L45:
        r6 = IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP;
    L54:
        if (r6.length() != 0) goto L56;
        boolean r13 = true;
    L57:
        if (r13 == false) goto L60;
        r6 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
    L60:
        if (Intrinsics.areEqual(r6, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L68;
        String r14 = r37.getString("sessionName");
        if (r14 != null) goto L64;
        r14 = "";
    L64:
        this.e = r14;
        if (ArraysKt.contains(new String[]{"VOICE", "BREATH"}, this.e) == true) goto L70;
        this.e = "";
    L70:
        r10.i(a.a(), "onShow login , the wakeup type is " + r11 + ", the wakeup source is : [ " + r6 + " ], the sourceFrom is : [ " + r2 + " ] and session is " + this.e);
        if (aga.c.b.contains(r6) == false) goto L74;
        r10.i(a.a(), "ignore wakeup source ".concat(r6));
        return false;
    L74:
        this.d = r6;
        String r7 = "obric_startup_attempt_id";
        if (r37.getInt("REQUEST_PULL_UP_ONCE") != 1) goto L77;
        String r8 = "obric_startup_attempt_id";
    L183:
        String r3 = null;
    L184:
        if (r3 != null) goto L186;
    L188:
        String r9 = null;
    L189:
        this.g = r9;
        if (r9 == null) goto L192;
        r37.putString(r8, r9);
    L192:
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpSource(this.d);
        ObricShowArgServiceDelegate.b.a(this.d);
        return true;
    L186:
        if ((!StringsKt.isBlank(r3)) == false) goto L188;
        r9 = r3;
        goto L189
    L77:
        Long r12 = Long.valueOf(r37.getLong("android.intent.extra.TIME", -1));
        if (r12.longValue() <= 0) goto L80;
        boolean r15 = true;
    L81:
        if (r15 == true) goto L84;
        r12 = null;
    L84:
        Long r16 = Long.valueOf(r37.getLong("REQUEST_TIME", -1));
        if (r16.longValue() <= 0) goto L87;
        boolean r17 = true;
    L88:
        if (r17 == true) goto L91;
        r16 = null;
    L91:
        if (r12 == null) goto L93;
        int r18 = uga.e.a;
        long r19 = uga.e.a(r12.longValue());
    L99:
        long r31 = r19;
    L100:
        String r20 = "auto_mic";
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L106;
        if (Intrinsics.areEqual(this.e, "BREATH") == false) goto L106;
        String r21 = "breath";
    L118:
        if (Intrinsics.areEqual(r21, "breath") == false) goto L121;
        r20 = "breath_wakeup";
    L129:
        String r29 = r20;
        Long r22 = Long.valueOf(r37.getLong("obric_wake_process_asr_ready_elapsed_ms", -1));
        long r23 = r22.longValue();
        if (Intrinsics.areEqual(r21, "voice") == true) goto L136;
    L138:
        boolean r24 = false;
    L139:
        if (r24 == true) goto L142;
        r22 = null;
    L142:
        AssistantStartupTelemetry r25 = AssistantStartupTelemetry.a;
        r8 = r7;
        String r26 = r37.getString(r8);
        if (r26 != null) goto L145;
    L147:
        String r27 = null;
    L149:
        if (r12 == null) goto L152;
        String r28 = "uptime_converted_to_elapsed";
    L151:
        String r33 = r28;
        Set r30 = SetsKt.createSetBuilder();
        r30.add("asr_record_ready");
        if (Intrinsics.areEqual(r21, "voice") == false) goto L158;
    L159:
        r30.add("first_frame_ready");
    L160:
        if (r22 == null) goto L162;
        r30.add("route_ready");
    L162:
        Unit r32 = Unit.INSTANCE;
        Set r34 = SetsKt.build(r30);
        Map r35 = MapsKt.createMapBuilder();
        r35.put("request_from", this.d);
        if (Intrinsics.areEqual(r21, "voice") == false) goto L165;
    L166:
        r35.put("origin_process_role", "interactor");
        r35.put("main_handoff_completed", "1");
    L167:
        if (r22 == null) goto L170;
        r35.put("asr_ready_source", "interactor_oneshot");
    L170:
        if (this.e.length() <= 0) goto L172;
        boolean r110 = true;
    L173:
        if (r110 == false) goto L175;
        r35.put("session_name", this.e);
    L175:
        r3 = r25.a(new uga.a(r27, r21, r29, "assistant", r31, r33, r34, MapsKt.build(r35)));
        if (Intrinsics.areEqual(r21, "voice") == false) goto L178;
    L179:
        int r36 = sha.b.a;
        Intrinsics.checkNotNullParameter(r3, "attemptId");
        ObricListeningMainProcessManager.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "attemptId");
        ObricListeningMainProcessManager.k(new h1(r3, true));
    L180:
        if (r22 == null) goto L184;
        r25.d(r3, "asr_record_ready", r22.longValue());
        goto L184
    L178:
        if (Intrinsics.areEqual(r21, "breath") == false) goto L180;
    L172:
        r110 = false;
        goto L173
    L165:
        if (Intrinsics.areEqual(r21, "breath") == false) goto L167;
    L158:
        if (Intrinsics.areEqual(r21, "breath") == false) goto L160;
    L152:
        if (r16 == null) goto L154;
        r28 = "wall_converted_to_elapsed";
        goto L151
    L154:
        r28 = "receiver_elapsed_fallback";
        goto L151
    L145:
        if ((!StringsKt.isBlank(r26)) == false) goto L147;
        r27 = r26;
        goto L149
    L136:
        if (r23 <= 0) goto L138;
        r24 = true;
        goto L139
    L121:
        if (Intrinsics.areEqual(r21, "voice") == false) goto L124;
        r20 = "voice_wakeup";
        goto L129
    L124:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP) == false) goto L127;
        r20 = "dora_voice_wakeup";
        goto L129
    L127:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKE_UP_SOURCE_BLUETOOTH) == false) goto L131;
        r20 = "voice_command";
        goto L129
    L131:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == true) goto L129;
    L182:
        r8 = r7;
    L106:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L109;
        r21 = "voice";
        goto L118
    L109:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP) == false) goto L112;
        r21 = "dora";
        goto L118
    L112:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKE_UP_SOURCE_BLUETOOTH) == false) goto L115;
        r21 = "bluetooth";
        goto L118
    L115:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == false) goto L182;
        r21 = "auto_mic";
        goto L118
    L93:
        if (r16 == null) goto L98;
        int r111 = uga.e.a;
        long r112 = r16.longValue();
        long r210 = SystemClock.elapsedRealtime();
        if (r112 > 0) goto L97;
        r7 = "obric_startup_attempt_id";
        r31 = r210;
        goto L100
    L97:
        r19 = RangesKt.coerceIn(r210 - RangesKt.coerceAtLeast(System.currentTimeMillis() - r112, 0), 0, r210);
        goto L99
    L98:
        r19 = SystemClock.elapsedRealtime();
        goto L99
    L87:
        r17 = false;
        goto L88
    L80:
        r15 = false;
        goto L81
    L68:
        if (Intrinsics.areEqual(r6, "WAKEUP_SOURCE_RELAUNCH_FOR_SCREENSHOT") == true) goto L70;
        this.e = "";
        goto L70
    L56:
        r13 = false;
        goto L57
    L38:
        r6 = "WAKEUP_SOURCE_POWER_KEY_DOUBLE_PRESS";
        goto L54
    L39:
        r6 = "WAKEUP_SOURCE_EYES_TRACKING";
        goto L54
    L40:
        r6 = "WAKEUP_SOURCE_POWER_KEY_CLICK";
        goto L54
    L41:
        r6 = "WAKEUP_SOURCE_POWER_KEY_LONG_PRESS";
        goto L54
    L34:
        r6 = "WAKEUP_SOURCE_RELAUNCH_FOR_SCREENSHOT";
        goto L54
    L35:
        r6 = "WAKEUP_SOURCE_ALL_SEARCH";
        goto L54
    L36:
        r6 = "WAKEUP_SOURCE_CANVAS_PS";
        goto L54
    L37:
        r6 = "WAKEUP_SOURCE_CAMERA_RESULT_PS";
        goto L54
    L52:
        r6 = "WAKEUP_SOURCE_POWER_KEY_LONG_PRESS_SHUTDOWN_MENU";
        goto L54
    L16:
        if (r2.equals("VOICE_ASSIST") == false) goto L25;
        r6 = IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE;
        goto L28
    L20:
        if (r2.equals("android.intent.action.VOICE_COMMAND") == false) goto L25;
        r6 = IInteractionStateService$Companion.WAKE_UP_SOURCE_BLUETOOTH;
        goto L28
    L24:
        if (r2.equals("AUTO_MIC") == false) goto L25;
        r6 = IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC;
        goto L28
    L27:
        r6 = "";
        goto L28
    L5:
        r4 = false;
        goto L7
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final boolean f(FragmentActivity r9) {
        boolean r0 = false;
        if (r9 != null) goto L6;
        return false;
    L6:
        if (ChatWindowServiceDelegate.b.c(r9) == false) goto L9;
        return false;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        D().closeSystemDialogs();
    L11:
        List r1 = r9.getSupportFragmentManager().getFragments();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L29
        boolean r4 = false;
    L32:
    L27:
        th = th;
        r0 = r4;
    L30:
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return r0;
    L15:
        if (r3.hasNext() == false) goto L25;
        Fragment r6 = (Fragment) r3.next();     // Catch: Throwable -> L27
        if (r6.isAdded() == false) goto L32;
        if (r6.isVisible() == false) goto L32;
        if ((r6 instanceof DialogFragment) == false) goto L32;
        if (E(r6, 0) == true) goto L32;
        r9.getSupportFragmentManager().beginTransaction().remove(r6).commitAllowingStateLoss();     // Catch: Throwable -> L27
        FLogger.a.i(a.a(), "tryFinishDialogFragment, remove " + r6.getClass().getSimpleName());     // Catch: Throwable -> L27
        r4 = true;
        goto L32
    L25:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
        return r4;
    L29:
        th = th;
        goto L30
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final boolean n(FragmentActivity r8) {
        boolean r0 = false;
        if (r8 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        D().closeSystemDialogs();
    L8:
        List r1 = r8.getSupportFragmentManager().getFragments();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L24
    L11:
        if (r3.hasNext() == false) goto L22;
        Fragment r4 = (Fragment) r3.next();     // Catch: Throwable -> L24
        if ((r4 instanceof a0) == true) goto L14;
        if (r4.isAdded() == false) goto L11;
        if (r4.isVisible() == false) goto L11;
        if ((r4 instanceof xe8.a) == true) goto L11;
        r8.getSupportFragmentManager().beginTransaction().remove(r4).commitAllowingStateLoss();     // Catch: Throwable -> L24
        FLogger.a.i(a.a(), "tryFinishApplet, remove " + r4.getClass().getSimpleName());     // Catch: Throwable -> L24
        r0 = true;
        goto L11
    L14:
        FLogger.a.i(a.a(), "tryFinishApplet, keep sidebar host " + r4.getClass().getSimpleName());     // Catch: Throwable -> L24
        goto L11
    L22:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L29;
        FLogger.a.i(a.a(), "tryFinishApplet, but failed, reason is " + r10);
    L29:
        return r0;
    L24:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    public static boolean E(Fragment r4, int r5) {
        if (s1a.a.g(r4).getAbility(maa.e.class) == null) goto L6;
        return true;
    L6:
        if (r5 < 4) goto L8;
        return false;
    L8:
        List r6 = r4.getChildFragmentManager().getFragments();
        if ((r6 instanceof Collection) == true) goto L11;
    L13:
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        Fragment r0 = (Fragment) r7.next();
        Intrinsics.checkNotNull(r0);
        if (E(r0, r5 + 1) == false) goto L15;
        return true;
    L19:
        return false;
    L11:
        if (r6.isEmpty() == false) goto L13;
        goto L13
    }

    public final void H(String r5, String r6) {
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        String r1 = "launch_failed";
    L10:
        A(r6, "blocked", r1, MapsKt.emptyMap());
        String r7 = "VOICE";
        if (ArraysKt.contains(new String[]{"VOICE", "BREATH"}, this.e) == false) goto L35;
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        Object r4 = B("wakeupArgs");     // Catch: Throwable -> L19
        if ((r4 instanceof Bundle) == false) goto L16;
        Bundle r8 = (Bundle) r4;     // Catch: Throwable -> L19
    L17:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r9) == true) goto L25;
        r2 = r9;
    L25:
        Bundle r10 = (Bundle) r2;
        com.obric.assistant.utils.o.a.getClass();
        if (r10 == null) goto L31;
        String r11 = r10.getString("sessionName", "VOICE");
        if (r11 == null) goto L31;
        r7 = r11;
    L31:
        com.obric.assistant.utils.o.b("launch_failed", r5, r7);
        return;
    L16:
        r8 = null;
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L35:
        return;
    L9:
        r1 = r5;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final Object d(Bundle r11, Continuation<? super ErrorCode> r12) {
        if ((r12 instanceof SessionMaintainer$onSessionProcess$1) == false) goto L7;
        SessionMaintainer$onSessionProcess$1 r0 = (SessionMaintainer$onSessionProcess$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r5 = null;
        boolean r6 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r14 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L24:
        Pair r15 = (Pair) r13;
        ErrorCode r4 = (ErrorCode) r15.getFirst();
        String r16 = (String) r15.getSecond();
        if (SetsKt.setOf(new String[]{"aiKey OP", "dora-not-in-wakeup", "System-dismiss-keyguard"}).contains(r16) == false) goto L28;
    L32:
        if (r5 != null) goto L34;
    L41:
        FLogger.a.i(a.a(), "onSessionProcess: -------2---------> 📌 end @errorCode : " + r4 + "  @errorReason " + r16 + "  [ wakeupFrom " + bga.j.a() + " wakeupSession " + bga.j.c() + ']');
        return r4;
    L34:
        if (r16.length() == 0) goto L37;
        r6 = false;
    L37:
        if (r6 == false) goto L39;
        String r7 = r4.name().toLowerCase(Locale.ROOT);
    L40:
        A(r14, r5, r7, MapsKt.mapOf(TuplesKt.to("session_error_code", r4.name())));
        goto L41
    L39:
        r7 = r16;
        goto L40
    L28:
        if (r4 != ErrorCode.QUIT_SESSION) goto L30;
    L31:
        r5 = "blocked";
        goto L32
    L30:
        if (r4 != ErrorCode.ONLY_END) goto L32;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i(a.a(), "onSessionProcess --------2---------> start [ wakeupFrom " + bga.j.a() + " wakeupSession " + bga.j.c() + ']');
        String r17 = r11.getString("obric_startup_attempt_id");
        if (r17 != null) goto L17;
    L19:
        r17 = null;
    L20:
        SessionEndpointMgr r8 = SessionEndpointMgr.a;
        r0.L$0 = r17;
        r0.label = 1;
        Object r18 = r8.b(r11, r0);
        if (r18 != r2) goto L23;
        return r2;
    L23:
        String r9 = r17;
        r13 = r18;
        r14 = r9;
        goto L24
    L17:
        if ((!StringsKt.isBlank(r17)) == false) goto L19;
    L7:
        r0 = new SessionMaintainer$onSessionProcess$1(this, r12);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void h(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.h.put(r2, r3);
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void k(t1a.b r2, boolean r3) {
        if (r2 != null) goto L5;
        FLogger.a.i(a.a(), "checkOpenSpecialInput: vContext is null");
        return;
    L5:
        laa.k r4 = r2.getAbility(laa.k.class);
        if (r4 == null) goto L9;
        r4.Z00(r3);
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void p(Context r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "args");
        FLogger r1 = FLogger.a;
        r1.i(a.a(), "onSessionPrepare--------1--------> start");
        SessionEndpointMgr r2 = SessionEndpointMgr.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        r1.i("AiIsland->SessionEndpointMgr", "onSessionPrepare " + r6);
        if (r6 == null) goto L9;
        Iterator r0 = ((List) SessionEndpointMgr.c.getValue()).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((ISessionEndPoint) r0.next()).p(r5, r6);
    L9:
        h("wakeupArgs", r6);
        FLogger.a.i(a.a(), "onSessionPrepare--------1--------> end [ wakeupFrom " + bga.j.a() + " wakeupSession " + bga.j.c() + ']');
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void r(ErrorCode r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "errorCode");
        Intrinsics.checkNotNullParameter(r8, "args");
        FLogger r0 = FLogger.a;
        r0.i(a.a(), "onSessionComplete --------3---------> start with " + r7 + " [ wakeupFrom " + bga.j.a() + " wakeupSession " + bga.j.c() + ']');
        if (r7 != ErrorCode.NA) goto L11;
        String r9 = r8.getString("obric_startup_attempt_id");
        if (r9 != null) goto L7;
    L9:
        r9 = null;
    L10:
        A(r9, "dropped", "session_processing_exception", MapsKt.emptyMap());
        goto L11
    L7:
        if ((!StringsKt.isBlank(r9)) == false) goto L9;
    L11:
        SessionEndpointMgr r10 = SessionEndpointMgr.a;
        Intrinsics.checkNotNullParameter(r7, "code");
        r0.i("AiIsland->SessionEndpointMgr", "onSessionComplete " + r7);
        Iterator r11 = ((List) SessionEndpointMgr.d.getValue()).iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        ((ISessionEndPoint) r11.next()).n(r7);
        goto L13
    L15:
        FLogger.a.i(a.a(), "onSessionComplete: -------3---------> end [ wakeupFrom " + bga.j.a() + " wakeupSession " + bga.j.c() + ']');
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final boolean s(boolean r2, boolean r3) {
        return F(r2, r3, this.g);
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void t(Context r2, VoiceInteractionSession r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "interactionSession");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.c = r3;
        IAssistantChatWindow r4 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r4 == null) goto L6;
        r4.createChatWindow();
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void u(CallType r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "callType");
        if (ObricLowStorageServiceDelegate.b.a() == false) goto L6;
        FLogger.a.i(a.a(), "launchRealtimeCall blocked by low storage, callType: " + r11);
        z(r12, "blocked", "low_storage");
        return;
    L6:
        IObricRealtimeCallExtService r2 = (IObricRealtimeCallExtService) this.a.getValue();
        if (r2 != null) goto L10;
        FLogger.a.w(a.a(), "launchRealtimeCall: realtime call service unavailable");
        z(r12, "dropped", "realtime_call_launch_failed");
        return;
    L10:
        FLogger.a.i(a.a(), "launchRealtimeCall: " + r11);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new uga.d(r12))), null, null, new SessionMaintainer$launchRealtimeCall$1(r2, r11, this, r12, null), 3, null);
    }

    public static void z(String r6, String r7, String r8) {
        if (r6 != null) goto L4;
        return;
    L4:
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r6, r7, r8, null, 24);
    }

    public final boolean F(boolean r25, boolean r26, String r27) {
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 23) goto L6;
        H("Build.VERSION < 23", r27);
        return false;
    L6:
        FLogger r5 = FLogger.a;
        r5.w(a.a(), "launchAssistant showOnLauncherOrKeyguard: " + r25);
        boolean r10 = true;
        if (ObricStateService.a.a() == false) goto L29;
        IObricRealtimeCallExtService r6 = (IObricRealtimeCallExtService) this.a.getValue();
        if (r6 == null) goto L11;
        CallType r7 = r6.getCurrentCallType();
    L12:
        if (r7 != null) goto L14;
        int r8 = -1;
    L15:
        if (r8 == 1) goto L22;
        if (r8 != 2) goto L18;
        String r9 = "open_video_call";
    L23:
        ILaunchMethodOperation r12 = bga.g.a();
        if (r12 == null) goto L26;
        r12.k(r9);
    L26:
        if (r2 < 23) goto L28;
        Intent r3 = new Intent();
        r3.setPackage(C().getPackageName());
        r5.i(a.a(), "canLaunchAssistant launchTalkPage");
        r3.setComponent(new ComponentName(C(), ObricRealtimeCallServiceDelegate.b.u()));
        r3.setFlags(872415232);
        r3.putExtra("obric_allow_show_when_locked", true);
        interruptMovingBackground();
        C().startActivity(r3);
    L28:
        boolean r4 = false;
    L30:
        if (r4 == true) goto L33;
        H("canLaunchAssistant: false", r27);
        return false;
    L33:
        m();
        if (r27 != null) goto L36;
    L38:
        String r11 = null;
    L39:
        r5.w(a.a(), "launchAssistant closeSystemDialogs");
        D().closeSystemDialogs();
        r5.w(a.a(), "launchAssistant playTone starting ....");
        BluetoothSoundEffectPlayer r1 = BluetoothSoundEffectPlayer.b;
        IBluetoothHeadSetAPI r13 = tha.c.a();
        if (r13 != null) goto L42;
    L44:
        boolean r14 = false;
    L45:
        if (r14 == false) goto L61;
        IBluetoothHeadSetAPI r15 = tha.c.a();
        if (r15 != null) goto L49;
    L51:
        boolean r16 = false;
    L52:
        if (r16 == true) goto L61;
        CoWakeupApi r17 = uha.a.a();
        if (r17 != null) goto L56;
    L58:
        boolean r18 = false;
    L59:
        if (r18 == true) goto L61;
        boolean r19 = true;
    L62:
        r1.e(r19, false);
        if (r25 == true) goto L66;
        IAssistantInteractionServiceKt.getInteractionStateService().addCustomBarAction(new CustomBarAction("obric_screen_qa", null, null, null, 14, null));
    L66:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L70;
        IWakeupStatisticsAPI r0 = wha.a.a();
        if (r0 == null) goto L70;
        r0.b("wakeup_stage3_3_activate", false, 0);
    L70:
        Activity r20 = AppHost.a.a().getCurrentActivity();
        if ((r20 instanceof FragmentActivity) == false) goto L73;
        FragmentActivity r110 = (FragmentActivity) r20;
    L74:
        ObricInteractionServiceDelegate.b.b(r110);
        r5.w(a.a(), "launchAssistant currentActivity is : " + r110);
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L85;
        if (r110 == null) goto L85;
        Lazy r21 = aga.j.a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Iterator r22 = CollectionsKt.asReversedMutable(r110.getSupportFragmentManager().getFragments()).iterator();
    L79:
        if (r22.hasNext() == false) goto L85;
        Fragment r23 = (Fragment) r22.next();
        if ((r23 instanceof DialogFragment) == false) goto L79;
        Lazy r111 = aga.j.a;
        ArrayList r112 = new ArrayList();
        aga.j.b(r23, 0, r112);
        aga.j.a r24 = aga.j.j(r112);
        if (r24 == null) goto L79;
    L86:
        if (r24 == null) goto L89;
        t1a.b r28 = r24.a;
        if (r28 == null) goto L89;
    L91:
        t1a.b r113 = r28;
    L93:
        if (r110 == null) goto L134;
        FragmentManager r29 = r110.getSupportFragmentManager();
        if (r29 == null) goto L134;
        List r114 = r29.getFragments();
        if (r114 == null) goto L134;
        Class r115 = Boolean.TYPE;     // Catch: Throwable -> L104
        Method r30 = DialogFragment.class.getDeclaredMethod("dismissInternal", new Class[]{r115, r115});     // Catch: Throwable -> L104
        r30.setAccessible(true);     // Catch: Throwable -> L102
    L107:
        Iterator r31 = r114.iterator();
    L109:
        if (r31.hasNext() == false) goto L134;
        Fragment r32 = (Fragment) r31.next();
        if ((r32 instanceof CommonDialog) == true) goto L130;
        if (IPermissionX.a.k(r32) == r10) goto L130;
        if (r32 == null) goto L133;
        FragmentManager r33 = r32.getChildFragmentManager();
        if (r33 == null) goto L133;
        List r34 = r33.getFragments();
        if (r34 == null) goto L133;
        Iterator r35 = r34.iterator();
    L123:
        if (r35.hasNext() == false) goto L109;
        Fragment r36 = (Fragment) r35.next();
        if (IPermissionX.a.k(r36) != r10) goto L123;
        FLogger.a.i(a.a(), "dismiss child fragment DialogFragment: " + r36);
        if (r30 == null) goto L129;
        r30.invoke(r36, new Object[]{Boolean.FALSE, Boolean.TRUE});
    L129:
        r10 = true;
    L133:
        r10 = true;
    L130:
        FLogger.a.i(a.a(), "dismissInternal DialogFragment: " + r32);
        if (r30 == null) goto L133;
        r30.invoke(r32, new Object[]{Boolean.FALSE, Boolean.TRUE});
    L102:
        th = th;
    L106:
        FLogger.a.e(a.a(), "get method dismissInternal of DialogFragment error", th);
    L104:
        th = th;
        r30 = null;
    L134:
        if (r113 == null) goto L136;
        laa.d r37 = (laa.d) r113.getAbility(laa.d.class);
    L137:
        if (r113 == null) goto L139;
        com.larus.bmhome.chat.component.showcase.y r38 = (com.larus.bmhome.chat.component.showcase.y) r113.getAbility(com.larus.bmhome.chat.component.showcase.y.class);
    L141:
        if (((List) aga.c.c.getValue()).contains(this.d) == false) goto L143;
        boolean r116 = true;
        IWindowEffectsKt.getWindowEffects().setWakeupState(new WeakUpState(true, sha.b.b()));
    L144:
        IOAutoOperation r39 = bga.h.a();
        if (r39 != null) goto L147;
    L149:
        boolean r40 = false;
    L150:
        if (r113 == null) goto L152;
        maa.e r41 = (maa.e) r113.getAbility(maa.e.class);
    L153:
        if (r113 == null) goto L155;
        com.obric.audio.continuous_talk.c r42 = (com.obric.audio.continuous_talk.c) r113.getAbility(com.obric.audio.continuous_talk.c.class);
    L156:
        if (r37 == null) goto L160;
        boolean r117 = true;
        if (r37.Da() != true) goto L161;
        boolean r118 = true;
    L162:
        if (r118 == false) goto L172;
        if (r38 != null) goto L165;
    L167:
        boolean r43 = false;
    L168:
        if (r43 == true) goto L172;
        if (r37.isVisible() == false) goto L172;
        boolean r44 = true;
    L173:
        if (r41 == null) goto L175;
        boolean r45 = true;
    L176:
        if (r24 != null) goto L178;
    L180:
        boolean r119 = false;
    L181:
        boolean r120 = !r119;
        FLogger r121 = FLogger.a;
        r121.i(a.a(), "launchAssistant voiceWakeupInputContext=" + r24 + ", canHandleByChatMain=" + r44 + ", canHandleByIntercom=" + r45);
        if (r44 == true) goto L184;
        if (r45 == true) goto L184;
    L286:
        r121.i(a.a(), "onShow start assistant activity");
        FragmentActivity r46 = ObricChatContextServiceDelegate.b.d();
        String r47 = a.a();
        StringBuilder r48 = new StringBuilder("chatActivityInStack: ");
        r48.append(r46);
        r48.append(", ");
        if (r46 == null) goto L289;
        Boolean r49 = Boolean.valueOf(r46.isFinishing());
    L290:
        r48.append(r49);
        r48.append(", ");
        if (r46 == null) goto L293;
        Boolean r50 = Boolean.valueOf(r46.isDestroyed());
    L294:
        r48.append(r50);
        r48.append(", finish current, ");
        r48.append(IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        r121.w(r47, r48.toString());
        if (r46 != null) goto L297;
    L310:
        if (r26 == false) goto L314;
        ILaunchMethodOperation r51 = bga.g.a();
        if (r51 == null) goto L314;
        r51.k("open_voice_input");
    L314:
        Set r52 = com.obric.assistant.common.utils.p.a;
        AppHost.Companion r53 = AppHost.a;
        long r54 = 0;
        G(com.obric.assistant.common.utils.p.f(r53.getApplication(), com.obric.assistant.common.utils.p.b(r53.getApplication())), null, false, null, false, r11);
    L315:
        IWakeupLatencyTrackService.a.a(WakeupLatencyTrackDelegate.b);
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L320;
        IWakeupStatisticsAPI r55 = wha.a.a();
        if (r55 == null) goto L320;
        r55.b("wakeup_stage3_4_no_sleep_draw", true, r54);
        return true;
    L320:
        return true;
    L297:
        if (r46.isFinishing() == true) goto L310;
        if (r46.isDestroyed() == true) goto L310;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L310;
        IAssistantChatWindow r56 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r56 != null) goto L305;
    L307:
        boolean r57 = false;
    L308:
        if (r57 == false) goto L310;
        r121.w(a.a(), "chatActivityInStack is already in stack, finish all");
        AppHost.a.a().finishAllActivities();
        goto L310
    L305:
        if (r56.isWindowMode() == true) goto L307;
        r57 = true;
        goto L308
    L293:
        r50 = null;
        goto L294
    L289:
        r49 = null;
    L184:
        if (r40 == true) goto L286;
        if (r11 == null) goto L241;
        Object r58 = B("wakeupArgs");
        if ((r58 instanceof Bundle) == false) goto L189;
        Bundle r59 = (Bundle) r58;
    L191:
        if (r59 != null) goto L193;
    L199:
        boolean r122 = false;
    L200:
        AssistantStartupTelemetry r123 = AssistantStartupTelemetry.a;
        if (r44 == false) goto L209;
        if (r42 != null) goto L204;
    L206:
        boolean r60 = false;
    L207:
        if (r60 == true) goto L209;
        String r61 = "touch_speak";
    L210:
        Set r62 = SetsKt.createSetBuilder();
        t1a.b r210 = r113;
        r62.add("asr_record_ready");
        boolean r211 = r120;
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == false) goto L213;
        r62.add("first_frame_ready");
    L215:
        if (r122 == false) goto L217;
        r62.add("route_ready");
    L217:
        Unit r124 = Unit.INSTANCE;
        boolean r212 = r44;
        maa.e r213 = r41;
        t1a.b r63 = r210;
        com.obric.audio.continuous_talk.c r214 = r42;
        String r125 = r61;
        FragmentActivity r64 = r110;
        IAssistantStartupTelemetry.a.e(r123, r11, r125, SetsKt.build(r62), MapsKt.mapOf(TuplesKt.to("route", "reuse_current_chat")), 2);
        if (r63 == null) goto L229;
        de8.c r65 = r63.a(de8.c.class);
        if (r65 == null) goto L229;
        Bundle r126 = r65.b;
        if (r126 == null) goto L225;
        r126.putString("obric_startup_attempt_id", r11);
    L225:
        Bundle r66 = r65.a;
        if (r66 == null) goto L229;
        r66.putString("obric_startup_attempt_id", r11);
    L229:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE) == true) goto L231;
        IAssistantStartupTelemetry.a.c(r123, r11, "chat_content_ready");
    L231:
        if (r59 == null) goto L242;
        Long r67 = Long.valueOf(r59.getLong("obric_wake_process_asr_ready_elapsed_ms", -1));
        long r127 = 0;
        if (r67.longValue() <= 0) goto L235;
        boolean r68 = true;
    L236:
        if (r68 == true) goto L239;
        r67 = null;
    L239:
        if (r67 == null) goto L243;
        r123.d(r11, "route_ready", r67.longValue());
    L243:
        int r69 = com.obric.assistant.h1.a;
        boolean r70 = false;
        int r71 = com.obric.assistant.h1.a(this.d, 0);
        k(r63, true);
        IAutoMicOperation r72 = bga.e.a();
        if (r72 == null) goto L246;
        zfa.a r73 = r72.getToken();
    L248:
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == false) goto L258;
        if (r73 == null) goto L258;
        LinkedHashMap r74 = new LinkedHashMap();
        ContentScene r75 = r73.a;
        if (r75 == null) goto L254;
        String r76 = r75.getStr();
        if (r76 == null) goto L254;
    L255:
        r74.put("scene", r76);
        Parcelable r77 = r73.b;
        if (r77 == null) goto L259;
        r74.put("data", r77);
    L259:
        IDoraOperation r78 = bga.f.a();
        if (r78 == null) goto L262;
        Integer r79 = r78.g();
    L263:
        IDoraOperation r80 = bga.f.a();
        if (r80 == null) goto L266;
        Boolean r81 = Boolean.valueOf(r80.c());
    L267:
        r121.i(a.a(), "isDoraProxyWakeup " + r81 + ", vuiId " + r79);
        if (r212 == false) goto L277;
        if (r214 == null) goto L273;
        com.obric.audio.continuous_talk.c r82 = r214;
        if (r82.qO(-1) != true) goto L274;
        r70 = true;
    L274:
        if (r70 == true) goto L277;
        if (r82 == null) goto L279;
        r82.Yd(r71, r74, r79);
    L279:
        if (r212 == false) goto L285;
        if (r211 == false) goto L285;
        IAssistantChatWindow r83 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r83 == null) goto L284;
        r83.dismissAllChildDialogs();
    L284:
        n(r64);
        f(r64);
    L285:
        interruptMovingBackground();
        r54 = r127;
        goto L315
    L273:
        r82 = r214;
    L277:
        if (r213 == null) goto L279;
        r213.nO(r71, r74, r79);
        goto L279
    L266:
        r81 = null;
        goto L267
    L262:
        r79 = null;
    L254:
        r76 = ContentScene.UNKNOWN.getStr();
    L258:
        r74 = null;
        goto L259
    L246:
        r73 = null;
        goto L248
    L235:
        r68 = false;
    L242:
        r127 = 0;
        goto L243
    L213:
        r62.add("chat_content_ready");
        goto L215
    L204:
        if (r42.qO(-1) != true) goto L206;
        r60 = true;
    L209:
        r61 = "click_talk";
        goto L210
    L193:
        if (r59.getLong("obric_wake_process_asr_ready_elapsed_ms", -1) <= 0) goto L195;
        boolean r128 = true;
    L197:
        if (r128 != true) goto L199;
        r122 = true;
        goto L200
    L195:
        r128 = false;
        goto L197
    L189:
        r59 = null;
        goto L191
    L241:
        r212 = r44;
        r213 = r41;
        r214 = r42;
        r211 = r120;
        r63 = r113;
        r64 = r110;
        goto L242
    L178:
        if (r24.b == true) goto L180;
        r119 = true;
        goto L181
    L175:
        r45 = false;
        goto L176
    L165:
        if (r38.iQ() != r117) goto L167;
        r43 = true;
    L172:
        r44 = false;
    L161:
        r118 = false;
        goto L162
    L160:
        r117 = true;
        goto L161
    L155:
        r42 = null;
        goto L156
    L152:
        r41 = null;
        goto L153
    L147:
        if (r39.c() != r116) goto L149;
        r40 = true;
        goto L150
    L143:
        r116 = true;
        goto L144
    L139:
        r38 = null;
        goto L141
    L136:
        r37 = null;
    L89:
        if (r110 == null) goto L92;
        r28 = aga.j.g(r110);
        goto L91
    L92:
        r113 = null;
    L85:
        r24 = null;
        goto L86
    L73:
        r110 = null;
        goto L74
    L56:
        if (r17.b() != true) goto L58;
        r18 = true;
        goto L59
    L49:
        if (r15.i() != true) goto L51;
        r16 = true;
    L61:
        r19 = false;
        goto L62
    L42:
        if (r13.a() != true) goto L44;
        r14 = true;
        goto L45
    L36:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.h(), r27) == false) goto L38;
        r11 = r27;
        goto L39
    L18:
        if (r8 == 3) goto L20;
        r9 = "open_doubao";
        goto L23
    L20:
        r9 = "open_share_screen_call";
        goto L23
    L22:
        r9 = "open_voice_call";
        goto L23
    L14:
        r8 = b.a[r7.ordinal()];
        goto L15
    L11:
        r7 = null;
        goto L12
    L29:
        r4 = true;
        goto L30
    }

    public final void q(AsrLifeState r5, String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r5, "lifeState");
        FLogger r0 = FLogger.a;
        r0.i(a.a(), "onLifeStateChanged lifeState: " + r5 + ", taskId: " + r6 + ", extraMap: " + r7);
        String r1 = null;
        if (r5 != AsrLifeState.ASR_STOP) goto L10;
        if (r7 == null) goto L7;
        r1 = r7.get("scene_from");
    L7:
        if (Intrinsics.areEqual(r1, AsrStopType.USER_CANCEL.getType()) == false) goto L35;
        r0.i(a.a(), "onLifeStateChanged user cancel, stop intercom");
        aga.j.k();
        y();
        return;
    L35:
        return;
    L10:
        if (r5 != AsrLifeState.ASR_RESULT) goto L32;
        if (r7 == null) goto L13;
        String r8 = r7.get("res_text");
    L14:
        if (r7 == null) goto L16;
        r1 = r7.get("res_type");
    L16:
        r0.i(a.a(), "onLifeStateChanged result: " + r8 + ", resType: " + r1);
        AsrResultValue r9 = AsrResultValue.FINAL_ASR;
        if (Intrinsics.areEqual(r1, r9.getValue()) == false) goto L27;
        if (r8 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L27;
        r0.i(a.a(), "onLifeStateChanged final asr is empty, stop intercom");
        aga.j.k();
        y();
        return;
    L20:
        if (r8.length() == 0) goto L23;
        r10 = false;
    L27:
        if (Intrinsics.areEqual(r1, r9.getValue()) == true) goto L29;
        return;
    L29:
        if (o0.d(r8) == false) goto L39;
        r0.i(a.a(), "onLifeStateChanged final asr is not empty, unregister");
        c();
        I("final asr");
        return;
    L39:
        return;
    L13:
        r8 = null;
        goto L14
    L32:
        if (r5 != AsrLifeState.ASR_ERROR) goto L41;
        r0.i(a.a(), "onLifeStateChanged asr error, stop intercom");
        aga.j.k();
        y();
        return;
    }

    public final void A(String r9, String r10, String r11, Map<String, String> r12) {
        if (r9 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r9)) == true) goto L7;
        r9 = null;
    L7:
        if (r9 == null) goto L15;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r9, r10, r11, r12, 8);
        if (Intrinsics.areEqual(this.g, r9) == false) goto L14;
        this.g = null;
        return;
    L14:
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionMaintaining
    public final void b(boolean r9, Bundle r10, boolean r11, Boolean r12, boolean r13) {
        if (r10 == null) goto L11;
        String r0 = r10.getString("obric_startup_attempt_id");
        if (r0 == null) goto L11;
        if ((!StringsKt.isBlank(r0)) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
    L12:
        G(r9, r10, r11, r12, r13, r0);
        return;
    L11:
        r0 = this.g;
        goto L12
    }

    public final void G(boolean r18, Bundle r19, boolean r20, Boolean r21, boolean r22, String r23) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        D().closeSystemDialogs();
    L5:
        LinkedHashMap r10 = new LinkedHashMap();
        if (Intrinsics.areEqual(this.d, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == false) goto L23;
        IAutoMicOperation r2 = bga.e.a();
        if (r2 == null) goto L15;
        zfa.a r3 = r2.getToken();
        if (r3 == null) goto L15;
        ContentScene r4 = r3.a;
        if (r4 == null) goto L15;
        String r5 = r4.getStr();
        if (r5 == null) goto L15;
    L16:
        r10.put("scene", r5);
        IAutoMicOperation r6 = bga.e.a();
        if (r6 == null) goto L23;
        zfa.a r7 = r6.getToken();
        if (r7 == null) goto L23;
        Parcelable r8 = r7.b;
        if (r8 == null) goto L23;
        r10.put("data", r8);
    L15:
        r5 = ContentScene.UNKNOWN.getStr();
    L23:
        FLogger.a.i(a.a(), "launchAssistantDirectly requestFrom " + this.d);
        interruptMovingBackground();
        IAiKeyOperation r9 = bga.b.a();
        if (r9 == null) goto L26;
        long r11 = r9.e();
    L27:
        long r12 = System.currentTimeMillis();
        boolean r13 = false;
        if (SetsKt.setOf(new String[]{"WAKEUP_SOURCE_AI_KEY_DOWN", "WAKEUP_SOURCE_AI_KEY_UP"}).contains(this.d) == true) goto L30;
    L55:
        ObricInteractDelegate r14 = ObricInteractDelegate.b;
        ILoginService.Companion r15 = ILoginService.a;
        r14.notifyWakeupEvent(r15.getAccountInfo().a);
        if (r15.getAccountInfo().a == true) goto L61;
        H("user not login", r23);
        IAiKeyOperation r1 = bga.b.a();
        if (r1 == null) goto L131;
        r1.startLauncherIntent();
        return;
    L131:
        return;
    L61:
        ISpecialInputTask r16 = com.obric.assistant.special_input.c.a();
        if (r16 == null) goto L65;
        StateInfo r17 = r16.g();
        if (r17 == null) goto L65;
    L69:
        Object r24 = B("wakeupArgs");
        if ((r24 instanceof Bundle) == false) goto L72;
        Bundle r25 = (Bundle) r24;
    L73:
        IAssistantChatWindow r26 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r26 == null) goto L132;
        String r27 = this.d;
        if (r21 == null) goto L78;
        boolean r28 = r21.booleanValue();
    L79:
        Boolean r29 = Boolean.valueOf(r18);
        if (r19 != null) goto L82;
        Bundle r30 = new Bundle();
    L83:
        if (r25 != null) goto L85;
    L93:
        String r110 = r30.getString("obric_startup_attempt_id");
        if (r110 != null) goto L96;
    L99:
        boolean r111 = true;
    L100:
        if (r111 == false) goto L103;
        if (r23 == null) goto L103;
        r30.putString("obric_startup_attempt_id", r23);
    L103:
        ILaunchMethodOperation r31 = bga.g.a();
        if (r31 == null) goto L108;
        String r32 = r31.a();
        if (r32 == null) goto L108;
        r30.putString("obric_launch_method", r32);
    L108:
        if (r20 == false) goto L110;
    L125:
        Unit r33 = Unit.INSTANCE;
        IDoraOperation r34 = bga.f.a();
        if (r34 == null) goto L128;
        Integer r112 = r34.g();
    L129:
        IAssistantChatWindow$DefaultImpls.openChatWindow$default(r26, r27, r28, r29, r30, r22, false, r10, r112, true, false, 512, null);
        return;
    L128:
        r112 = null;
        goto L129
    L110:
        if (r30.containsKey("arg_long_press_ai") == false) goto L120;
        if (r17 == null) goto L113;
        Map r35 = r17.getExt();
    L115:
        if ((r35 instanceof LinkedHashMap) == false) goto L117;
        LinkedHashMap r36 = (LinkedHashMap) r35;
    L118:
        if (r36 == null) goto L120;
        String r37 = (String) r36.put("source_from", "dynamic_island");
        goto L120
    L117:
        r36 = null;
        goto L118
    L113:
        r35 = null;
    L120:
        if (r17 == null) goto L122;
        r13 = true;
    L122:
        r30.putBoolean("obric_open_special_input", r13);
        r30.putParcelable("obric_special_input_state_info", r17);
        if (r17 == null) goto L125;
        r30.putString("obric_special_input_task_type", r17.getTaskType());
        goto L125
    L96:
        if (StringsKt.isBlank(r110) == true) goto L99;
        r111 = false;
        goto L100
    L85:
        if (r25.containsKey("o_main_process_ready") == false) goto L88;
        r30.putBoolean("o_main_process_ready", r25.getBoolean("o_main_process_ready"));
    L88:
        if (r25.containsKey("o_dispatch_to_main_process_time") == false) goto L91;
        r30.putLong("o_dispatch_to_main_process_time", r25.getLong("o_dispatch_to_main_process_time"));
    L91:
        if (r25.containsKey("obric_wake_process_asr_ready_elapsed_ms") == false) goto L93;
        r30.putLong("obric_wake_process_asr_ready_elapsed_ms", r25.getLong("obric_wake_process_asr_ready_elapsed_ms"));
        goto L93
    L82:
        r30 = r19;
        goto L83
    L78:
        r28 = ((List) aga.c.c.getValue()).contains(this.d);
        goto L79
    L132:
        return;
    L72:
        r25 = null;
    L65:
        ISpecialInputTask r38 = com.obric.assistant.special_input.c.a();
        if (r38 == null) goto L68;
        r17 = r38.a();
        goto L69
    L68:
        r17 = null;
        goto L69
    L30:
        if (r12 <= r11) goto L55;
        if (r11 <= 0) goto L55;
        ILaunchMethodOperation r39 = bga.g.a();
        if (r39 == null) goto L55;
        int r40 = (int) (r12 - r11);
        IAiKeyOperation r41 = bga.b.a();
        if (r41 == null) goto L38;
        long r113 = r41.m();
    L39:
        long r114 = SystemClock.uptimeMillis();
        if (r113 > 0) goto L42;
    L53:
        Integer r42 = null;
    L54:
        r39.i(r40, r42, r12);
        goto L55
    L42:
        if (r114 < r113) goto L53;
        Long r43 = Long.valueOf(r114 - r113);
        if (r43.longValue() > 2147483647L) goto L47;
        boolean r44 = true;
    L48:
        if (r44 == true) goto L51;
        r43 = null;
    L51:
        if (r43 == null) goto L53;
        r42 = Integer.valueOf((int) r43.longValue());
        goto L54
    L47:
        r44 = false;
        goto L48
    L38:
        r113 = 0;
        goto L39
    L26:
        r11 = 0;
        goto L27
    }
}
