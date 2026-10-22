package com.obric.assistant.state.impl.v2.core;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.aiagent.assistant.idl.IAgentDMStateManagerIDL;
import com.obric.aiagent.assistant.idl.f;
import com.obric.assistant.component.ObricAppeaseComponent;
import com.obric.assistant.live.service.ObricLiveService;
import com.obric.assistant.state.api.v2.core.AssistantAliveReason;
import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandPriority;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.assistant.state.impl.v2.core.statehandler.complextask.ComplexTaskStateHandler;
import com.obric.assistant.state.impl.v2.power.ObricPowerManager;
import com.obric.assistant.state.impl.v2.wakelock.ObricWakelockManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import hha.a;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J+\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u001aJ+\u0010\u001b\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u001aJ+\u0010\u001c\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u001aJ\"\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016J$\u0010!\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016¨\u0006,"}, d2 = {"Lcom/obric/assistant/state/impl/v2/core/ObricStateDispatcherServiceImpl;", "Lcom/obric/assistant/state/api/v2/core/IObricStateDispatcherService;", "<init>", "()V", "initObricStateMachine", "", "registerOnObricStateChangeChangedObserver", "conversationId", "", "changedListener", "Lcom/obric/assistant/state/api/v2/core/observer/OnStateChangedObserverV2;", "unregisterOnObricStateChangeChangedObserver", "registerOnGlobalObricStateObserver", "unregisterOnGlobalObricStateObserver", "registerOnObricPowerLockStateObserver", "Lcom/obric/assistant/state/api/v2/core/observer/OnPowerLockStateChangedObserver;", "unregisterOnObricPowerLockObserver", "registerGlobalAudioState", "observer", "Lcom/obric/assistant/state/api/v2/core/observer/OnAudioStateChangedObserver;", "unregisterGlobalAudioState", "mobClickTalkStart", "cvsId", "sourceType", "", "sessionId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "mobClickTalkQueryBegin", "mobClickTalkQueryEnd", "mobClickTalkEnd", "onRealtimeStateChange", "prev", "current", "onContinuousTalkTtsStateChange", DBDefinition.TASK_ID, "isPlaying", "", "getCurrentAssistantLiveState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricAssistantAliveLockState;", "getCurrentAssistantAliveReasons", "", "Lcom/obric/assistant/state/api/v2/core/AssistantAliveReason;", "onAutoDismissTaskAdd", "onAutoDismissTaskRemove", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricStateDispatcherServiceImpl implements IObricStateDispatcherService {
    public ObricStateDispatcherServiceImpl() {
    }

    public final ObricAssistantAliveLockState a() {
        CoroutineScope r0 = ObricPowerManager.a;
        ObricAssistantAliveLockState r1 = ObricPowerManager.h;
        if (r1 == null) goto L5;
        return r1;
    L5:
        return new ObricAssistantAliveLockState(ObricAssistantAliveLockStateType.RELEASED, "", null, 4, null);
    }

    public final void c() {
        a r0 = g.a;
        r0.getClass();
        com.larus.im.d.e().registerOnGlobalMessageObserver(r0.f);
        fha.a r1 = g.b;
        r1.getClass();
        AudioServiceDelegate.a.P().j(r1.e);
        GlobalAudioObserver.a.b(r1.f);
        iha.a r2 = g.d;
        r2.getClass();
        ObricRealtimeCallServiceDelegate.b.l(r2.b);
        final ComplexTaskStateHandler r3 = g.e;
        r3.getClass();
        FLogger.a.d("[ComplexTaskStateHandler]", "initComplexTaskListener, start");
        f.b(Reflection.getOrCreateKotlinClass(IAgentDMStateManagerIDL.class), new com.obric.assistant.state.impl.v2.core.statehandler.complextask.a(r3));
    }

    public final List<AssistantAliveReason> j() {
        CoroutineScope r0 = ObricPowerManager.a;
        return Collections.list(ObricPowerManager.f.keys());
    }

    public final void k() {
        ObricWakelockManager.d(ObricWakelockManager.a, ObricWakelockManager.LockReason.AUTO_DISMISS);
    }

    public final void l() {
        ObricWakelockManager r0 = ObricWakelockManager.a;
        ObricWakelockManager.LockReason r1 = ObricWakelockManager.LockReason.AUTO_DISMISS;
        r0.getClass();
        ObricWakelockManager.a(r1);
    }

    public final void e(ObricLiveService.e r2) {
        Intrinsics.checkNotNullParameter(r2, "changedListener");
        ObricStateDispatcher r0 = ObricStateDispatcher.a;
        Intrinsics.checkNotNullParameter(r2, "observer");
        ObricStateDispatcher.c.add(r2);
    }

    public final void g(ObricAppeaseComponent.c r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        ObricStateDispatcher r1 = ObricStateDispatcher.a;
        Intrinsics.checkNotNullParameter(r3, "observer");
        ObricStateDispatcher.e.remove(r3);
    }

    public final void i(cha.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        ObricStateDispatcher r1 = ObricStateDispatcher.a;
        Intrinsics.checkNotNullParameter(r3, "observer");
        ObricStateDispatcher.e.add(r3);
    }

    public final void o(cha.b r2) {
        Intrinsics.checkNotNullParameter(r2, "changedListener");
        ObricStateDispatcher r0 = ObricStateDispatcher.a;
        Intrinsics.checkNotNullParameter(r2, "observer");
        ObricStateDispatcher.d.add(r2);
    }

    public final void b(String r12, Integer r13) {
        g.c.getClass();
        if (r12 == null) goto L11;
        ObricIslandStateType r2 = ObricIslandStateType.CLICK_TALK_ASR_END;
        ObricInteractionScene r4 = ObricInteractionScene.DEFAULT;
        ObricIslandPriority r5 = ObricIslandPriority.LOW;
        LinkedHashMap r8 = new LinkedHashMap();
        if (r13 != null) goto L8;
    L10:
        Unit r0 = Unit.INSTANCE;
        g.a(new ObricState(r2, r12, r4, r5, null, null, r8, 48, null));
        goto L11
    L8:
        if (r13.intValue() != 4) goto L10;
        r8.put("is_from_continuous_intents", "1");
    L11:
        FLogger.a.i("[ClickTalkStateHandler]", "setClickTalkQueryEnd, " + r12 + ", " + r13 + ", " + AudioServiceDelegate.a.e());
    }

    public final void h(String r12, Integer r13) {
        g.c.getClass();
        if (r12 == null) goto L11;
        ObricIslandStateType r2 = ObricIslandStateType.CLICK_TALK_ASR_START;
        ObricInteractionScene r4 = ObricInteractionScene.DEFAULT;
        ObricIslandPriority r5 = ObricIslandPriority.LOW;
        LinkedHashMap r8 = new LinkedHashMap();
        if (r13 != null) goto L8;
    L10:
        Unit r0 = Unit.INSTANCE;
        g.a(new ObricState(r2, r12, r4, r5, null, null, r8, 48, null));
        goto L11
    L8:
        if (r13.intValue() != 4) goto L10;
        r8.put("is_from_continuous_intents", "1");
    L11:
        FLogger.a.i("[ClickTalkStateHandler]", "setClickTalkQueryBegin, " + r12 + ", " + r13 + ", " + AudioServiceDelegate.a.e());
    }

    public final void m(String r13, Integer r14) {
        g.c.getClass();
        ObricWakelockManager r0 = ObricWakelockManager.a;
        ObricWakelockManager.LockReason r1 = ObricWakelockManager.LockReason.CLICK_TALK;
        r0.getClass();
        ObricWakelockManager.a(r1);
        if (r13 == null) goto L11;
        ObricIslandStateType r3 = ObricIslandStateType.CLICK_TALK_START;
        ObricInteractionScene r5 = ObricInteractionScene.DEFAULT;
        ObricIslandPriority r6 = ObricIslandPriority.LOW;
        LinkedHashMap r9 = new LinkedHashMap();
        if (r14 != null) goto L8;
    L10:
        Unit r2 = Unit.INSTANCE;
        g.a(new ObricState(r3, r13, r5, r6, null, null, r9, 48, null));
        goto L11
    L8:
        if (r14.intValue() != 4) goto L10;
        r9.put("is_from_continuous_intents", "1");
    L11:
        FLogger.a.i("[ClickTalkStateHandler]", "setClickTalkStart, " + r13 + ", " + r14 + ", " + AudioServiceDelegate.a.e());
        if (com.obric.assistant.state.impl.v2.utils.f.a == true) goto L15;
        CoroutineScope r15 = ObricPowerManager.a;
        ObricPowerManager.c(AssistantAliveReason.CLICK_TALK_IN_PROGRESS);
        return;
    }

    public final void n(String r13, Integer r14) {
        g.c.getClass();
        FLogger.a.i("[ClickTalkStateHandler]", "setClickTalkEnd, " + r13 + ", " + r14 + ", " + AudioServiceDelegate.a.e());
        ObricWakelockManager.d(ObricWakelockManager.a, ObricWakelockManager.LockReason.CLICK_TALK);
        if (r13 == null) goto L12;
        ObricIslandStateType r3 = ObricIslandStateType.CLICK_TALK_END;
        ObricInteractionScene r5 = ObricInteractionScene.DEFAULT;
        ObricIslandPriority r6 = ObricIslandPriority.LOW;
        LinkedHashMap r9 = new LinkedHashMap();
        if (r14 != null) goto L8;
    L10:
        Unit r15 = Unit.INSTANCE;
        g.a(new ObricState(r3, r13, r5, r6, null, null, r9, 48, null));
        goto L12
    L8:
        if (r14.intValue() != 4) goto L10;
        r9.put("is_from_continuous_intents", "1");
    L12:
        if (com.obric.assistant.state.impl.v2.utils.f.a == true) goto L15;
        CoroutineScope r16 = ObricPowerManager.a;
        ObricPowerManager.f(AssistantAliveReason.CLICK_TALK_IN_PROGRESS);
        return;
    }

    public final void d(int r12, int r13, String r14) {
        iha.a r1 = g.d;
        r1.getClass();
        FLogger.a.i("[RealtimeCallStateHandler]", "onRealtimeStateChange, " + r12 + " -> " + r13 + ", " + r14);
        if (r1.a == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        return;
    L9:
        if (r13 != 9) goto L11;
        if (r14 == null) goto L64;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_WAITING_HELLO, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        return;
    L64:
        return;
    L11:
        if (r13 != 14) goto L13;
        if (r14 == null) goto L62;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_MUTE, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        return;
    L62:
        return;
    L13:
        if (r13 == 15) goto L39;
        switch(r13) {
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L30;
            case 4: goto L25;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            default: goto L66;
        };
    L16:
        if (r14 == null) goto L46;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_PAUSED, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        return;
    L46:
        return;
    L18:
        if (r14 == null) goto L48;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        return;
    L48:
        return;
    L20:
        if (r14 == null) goto L23;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_SPEAKING, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
    L23:
        if (com.obric.assistant.state.impl.v2.utils.f.a == true) goto L50;
        CoroutineScope r0 = ObricPowerManager.a;
        ObricPowerManager.c(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS);
        return;
    L50:
        return;
    L25:
        if (r14 == null) goto L28;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_THINKING, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
    L28:
        if (com.obric.assistant.state.impl.v2.utils.f.a == true) goto L52;
        CoroutineScope r3 = ObricPowerManager.a;
        ObricPowerManager.c(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS);
        return;
    L52:
        return;
    L30:
        if (r14 == null) goto L33;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_LISTENING, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
    L33:
        if (com.obric.assistant.state.impl.v2.utils.f.a == true) goto L54;
        CoroutineScope r4 = ObricPowerManager.a;
        ObricPowerManager.c(AssistantAliveReason.REALTIME_CALL_IN_PROGRESS);
        return;
    L54:
        return;
    L35:
        if (r14 == null) goto L56;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_WAITING, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        return;
    L56:
        return;
    L37:
        if (r14 == null) goto L58;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_CONNECTING, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        return;
    L58:
        return;
    L66:
        return;
    L39:
        if (r14 == null) goto L60;
        g.a(new ObricState(ObricIslandStateType.REALTIME_CALL_UN_MUTE, r14, ObricInteractionScene.REALTIME_CALL_SCENE, ObricIslandPriority.MEDIUM, null, null, null, 112, null));
        return;
    L60:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void f(String r12, String r13, boolean r14) {
        if (r12 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        a r1 = g.a;
        if (r14 == false) goto L13;
        ObricIslandStateType r15 = ObricIslandStateType.TTS_PLAYING;
    L14:
        g.a(new ObricState(r15, r12, ObricInteractionScene.DEFAULT, ObricIslandPriority.LOW, r13, null, MapsKt.mapOf(TuplesKt.to("is_from_continuous_talk_tts", "1")), 32, null));
        return;
    L13:
        r15 = ObricIslandStateType.TTS_END;
        goto L14
    L4:
        if (r12.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
