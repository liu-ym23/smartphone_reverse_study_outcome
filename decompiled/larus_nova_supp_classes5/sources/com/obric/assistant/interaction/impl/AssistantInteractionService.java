package com.obric.assistant.interaction.impl;

import android.media.AudioManager;
import com.bytedance.ai.api.AppletService;
import com.bytedance.apm.d;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionService;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.lifecycle.ILifecycleService;
import com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService;
import com.obric.assistant.interaction.api.service.IInteractionStateApi;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.hook.ObricInstrumentation;
import com.obric.assistant.interaction.impl.service.AuthenticationOnLockScreenService;
import com.obric.assistant.interaction.impl.service.EventHubImpl;
import com.obric.assistant.interaction.impl.service.InteractionApiImpl;
import com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.utils.ObricShowArgServiceDelegate;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import zga.b;
import zga.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0018\u0010-\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001bH\u0002J\u0010\u0010/\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0016H\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0004\n\u0002\b\u0017R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/assistant/interaction/impl/AssistantInteractionService;", "Lcom/obric/assistant/interaction/api/IAssistantInteractionService;", "<init>", "()V", "_interactionStateService", "Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "get_interactionStateService", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "_interactionStateApi", "Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "get_interactionStateApi", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "_authenOnLockScreenService", "Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "get_authenOnLockScreenService", "()Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "lifecycleServices", "", "Lcom/obric/assistant/interaction/api/lifecycle/ILifecycleService;", "getLifecycleServices", "()Ljava/util/List;", "TAG", "", "TAG$1", "curBid", "isGenerateStart", "", "", "lastPhase", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/state/api/multitask/ForegroundInteractionPhase;", "curMode", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "appActionCheckJob", "Lkotlinx/coroutines/Job;", "stopVUIJob", "systemStateInit", "", "soundEffectInit", "projectionObserver", "Lcom/obric/assistant/state/api/multitask/InteractionProjectionObserver;", "onDeactivate", "botId", "onThinking", "onGenerating", "onGenerated", "failed", "onActivate", "startAppletListener", "isInterceptedByUiU", "apiName", "isInWhiteListAppAction", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantInteractionService implements IAssistantInteractionService {
    public static final Companion Companion = null;
    private static final long SECOND = 1000;
    private static final String TAG = "AssistantInteractionService";
    private static final long THREE_SECONDS = 3000;
    private static final long TWO_SECONDS = 2000;
    private static final String UIU_GET_UIU_CONTEXT_TOOL = "system_get_uiu_context_tool";
    private static final String UIU_PERFORM_VIEW_OPERATIONS_TOOL = "system_do_view_operations_tool";
    private static final String UIU_PLUGIN = "system_ui_understanding_plugin";
    private static final String WHITE_LIST_AUDIO_PLAYER_ACTION = "plugin_podcast_control.plugin_tool__podcast_control";
    private final String TAG$1;
    private Job appActionCheckJob;
    private String curBid;
    private ConcurrentHashMap<String, ObricInteractionType> curMode;
    private final Map<String, Boolean> isGenerateStart;
    private final ConcurrentHashMap<String, ForegroundInteractionPhase> lastPhase;
    private final c projectionObserver;
    private Job stopVUIJob;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(AssistantInteractionService r0, b r1) {
        projectionObserver$lambda$0(r0, r1);
    }

    public List<ILifecycleService> getLifecycleServices() {
        return CollectionsKt.listOf(new ILifecycleService[]{InteractionStateServiceImpl.INSTANCE, EventHubImpl.INSTANCE});
    }

    public void soundEffectInit() {
        ObricInteractionProjectionDelegate.b.b(null, this.projectionObserver);
        FLogger.a.i(this.TAG$1, "soundEffectInit");
    }

    public void systemStateInit() {
        SystemStateHelper r0 = SystemStateHelper.INSTANCE;
        AppHost.Companion r1 = AppHost.a;
        r0.init(r1.getApplication().getApplicationContext());
        ActivityStackObserver.INSTANCE.init(r1.getApplication().getApplicationContext());
        RealtimeCallLifecycleBridge.INSTANCE.init();
        new ObricInstrumentation().installHook();
        startAppletListener();
        FLogger.a.i(this.TAG$1, "systemStateInit");
    }

    public AssistantInteractionService() {
        this.TAG$1 = TAG;
        this.curBid = "";
        this.isGenerateStart = new LinkedHashMap();
        this.lastPhase = new ConcurrentHashMap();
        this.curMode = new ConcurrentHashMap();
        this.projectionObserver = new f(this);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.assistant.interaction.impl.AssistantInteractionService$startAppletListener$1] */
    private final void startAppletListener() {
        if (d.l() == true) goto L5;
        return;
    L5:
        AppletService r0 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r0 == null) goto L9;
        ?? r1 = new AnonymousClass1(this);
        FLogger.a.d(this.TAG$1, "addAppActionListener to AppletService");
        r0.l(r1);
        return;
    }

    public IAuthenticationOnLockScreenService get_authenOnLockScreenService() {
        return AuthenticationOnLockScreenService.INSTANCE;
    }

    public IInteractionStateApi get_interactionStateApi() {
        return InteractionApiImpl.INSTANCE;
    }

    public IInteractionStateService get_interactionStateService() {
        return InteractionStateServiceImpl.INSTANCE;
    }

    public static final /* synthetic */ Job access$getAppActionCheckJob$p(AssistantInteractionService r0) {
        return r0.appActionCheckJob;
    }

    public static final /* synthetic */ Job access$getStopVUIJob$p(AssistantInteractionService r0) {
        return r0.stopVUIJob;
    }

    public static final /* synthetic */ String access$getTAG$p(AssistantInteractionService r0) {
        return r0.TAG$1;
    }

    private final boolean isInWhiteListAppAction(String r2) {
        return Intrinsics.areEqual(r2, WHITE_LIST_AUDIO_PLAYER_ACTION);
    }

    private final boolean isInterceptedByUiU(String r2) {
        if (Intrinsics.areEqual(r2, "system_ui_understanding_plugin.system_do_view_operations_tool") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, "system_ui_understanding_plugin.system_get_uiu_context_tool") == true) goto L8;
        return false;
    }

    private final void onActivate(String r8) {
        FLogger.a.d(this.TAG$1, "onActivate botId:" + r8 + " curBotId:" + this.curBid);
        this.curBid = r8;
        if (ObricInteractionType.TextMode != this.curMode.get(r8)) goto L5;
    L9:
        this.isGenerateStart.remove(r8);
        return;
    L5:
        if (ObricInteractionType.DefaultMode == this.curMode.get(r8)) goto L9;
        if (ObricInteractionType.RealtimeCallMode == this.curMode.get(r8)) goto L9;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new onActivate.1(null), 3, null);
        goto L9
    }

    private final void onDeactivate(String r5) {
        FLogger.a.d(this.TAG$1, "onDeactivate botId:" + r5 + " curBotId:" + this.curBid);
        this.isGenerateStart.remove(r5);
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupSource();
        ObricShowArgServiceDelegate.b.a(IInteractionStateService.WAKE_UP_SOURCE_OTHER);
    }

    private final void onGenerating(String r5) {
        FLogger.a.d(this.TAG$1, "onGenerating botId:" + r5 + " curBotId:" + this.curBid);
        if (Intrinsics.areEqual(r5, this.curBid) == false) goto L9;
        Boolean r0 = this.isGenerateStart.get(r5);
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L9;
        if (ObricInteractionType.RealtimeCallMode == this.curMode.get(r5)) goto L9;
        this.isGenerateStart.put(r5, r1);
    L9:
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupData();
    }

    private final void onThinking(String r5) {
        FLogger.a.d(this.TAG$1, "onThinking botId:" + r5 + " curBotId:" + this.curBid + " mode:" + this.curMode);
        boolean r2 = true;
        if (this.lastPhase.get(r5) == ForegroundInteractionPhase.Thinking) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L28:
        this.isGenerateStart.remove(r5);
        return;
    L8:
        if (Intrinsics.areEqual(r5, this.curBid) == false) goto L28;
        if (ObricInteractionType.TextMode == this.curMode.get(r5)) goto L28;
        if (ObricInteractionType.RealtimeCallMode == this.curMode.get(r5)) goto L28;
        IBluetoothHeadSetAPI r1 = tha.c.a();
        if (r1 != null) goto L16;
    L18:
        r2 = false;
    L19:
        if (r2 == false) goto L22;
        return;
    L22:
        if (((Boolean) ((Pair) IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().getValue()).getFirst()).booleanValue() == false) goto L24;
        IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().setValue(TuplesKt.to(Boolean.FALSE, "clear"));
        goto L28
    L24:
        Object r3 = AppHost.a.getApplication().getSystemService("audio");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) r3).getRingerMode() != 2) goto L27;
        SoundEffectHelper.INSTANCE.playSendMessage();
    L27:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
        goto L28
    L16:
        if (r1.a() != true) goto L18;
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$isInWhiteListAppAction(AssistantInteractionService r0, String r1) {
        return r0.isInWhiteListAppAction(r1);
    }

    public static final /* synthetic */ boolean access$isInterceptedByUiU(AssistantInteractionService r0, String r1) {
        return r0.isInterceptedByUiU(r1);
    }

    public static final /* synthetic */ void access$setAppActionCheckJob$p(AssistantInteractionService r0, Job r1) {
        r0.appActionCheckJob = r1;
    }

    public static final /* synthetic */ void access$setStopVUIJob$p(AssistantInteractionService r0, Job r1) {
        r0.stopVUIJob = r1;
    }

    private final void onGenerated(String r5, boolean r6) {
        FLogger.a.d(this.TAG$1, "onGenerated botId:" + r5 + " curBotId:" + this.curBid + ", failed:" + r6);
        this.isGenerateStart.remove(r5);
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupData();
    }

    private static final void projectionObserver$lambda$0(AssistantInteractionService r6, b r7) {
        Intrinsics.checkNotNullParameter(r7, "projection");
        String r0 = r7.a;
        if (r0 != null) goto L5;
        return;
    L5:
        ObricInteractionType r1 = r7.c;
        ForegroundInteractionPhase r8 = r7.e;
        FLogger r2 = FLogger.a;
        r2.d(r6.TAG$1, "onProjectionChanged botId:" + r0 + " mode:" + r1 + " phase:" + r8 + " lastPhase:" + r6.lastPhase);
        ObricInteractionType r3 = r6.curMode.put(r0, r1);
        ObricInteractionType r4 = ObricInteractionType.DefaultMode;
        if (r1 != r4) goto L10;
        if (r3 == null) goto L10;
        if (r3 == r4) goto L10;
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupSource();
        ObricShowArgServiceDelegate.b.a(IInteractionStateService.WAKE_UP_SOURCE_OTHER);
    L10:
        int r5 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r5 != 1) goto L13;
    L17:
        String r9 = r0;
    L18:
        r6.curBid = r9;
        if (Intrinsics.areEqual(r0, r9) == false) goto L22;
        ForegroundInteractionPhase r10 = ForegroundInteractionPhase.Idle;
    L22:
        switch(WhenMappings.$EnumSwitchMapping$1[r8.ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L27;
            case 6: goto L25;
            case 7: goto L25;
            default: goto L24;
        };
    L25:
        r2.d(r6.TAG$1, "Ignore phase change, phase:" + r8);
    L37:
        r6.lastPhase.put(r0, r8);
        return;
    L33:
        r6.onThinking(r0);
        goto L37
    L34:
        r6.onGenerated(r0, false);
        goto L37
    L35:
        r6.onGenerating(r0);
        goto L37
    L36:
        r6.onActivate(r0);
        goto L37
    L24:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r6.curMode.get(r0) != ObricInteractionType.AutoHalfDuplex) goto L37;
        if (r6.lastPhase.get(r0) != ForegroundInteractionPhase.Activate) goto L31;
    L32:
        r6.onDeactivate(r0);
        goto L37
    L31:
        if (r6.lastPhase.get(r0) != ForegroundInteractionPhase.Listen) goto L37;
    L13:
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L17;
        r9 = "";
        goto L18
    }
}
