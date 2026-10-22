package com.obric.audio.continuous_talk;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.ObricContTalkStateMachine;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.assistant.audio.service.ObricAssistantAudioVisualizerState;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import laa.d;
import laa.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$invokeOnSpeak$1$4$1$1", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$invokeOnSpeak$1$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $speakTaskId;
    final /* synthetic */ AVKitDuplexState $state;
    int label;
    final /* synthetic */ ObricContinuousTalkUIComponent this$0;

    public ObricContinuousTalkUIComponent$invokeOnSpeak$1$4$1$1(ObricContinuousTalkUIComponent r1, AVKitDuplexState r2, String r3, Continuation<? super ObricContinuousTalkUIComponent$invokeOnSpeak$1$4$1$1> r4) {
        this.this$0 = r1;
        this.$state = r2;
        this.$speakTaskId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricContinuousTalkUIComponent$invokeOnSpeak$1$4$1$1(this.this$0, this.$state, this.$speakTaskId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L114;
        ResultKt.throwOnFailure(r13);
        ObricContinuousTalkUIComponent r14 = this.this$0;
        AVKitDuplexState r0 = this.$state;
        String r1 = this.$speakTaskId;
        if (Intrinsics.areEqual(r14.H, r1) == true) goto L7;
        FLogger.a.i("ObricContinuousTalkUIComponent", "updateTalkStateUI ignored stale sessionId:" + r1);
    L112:
        return Unit.INSTANCE;
    L7:
        FLogger r2 = FLogger.a;
        r2.i("ObricContinuousTalkUIComponent", "updateTalkStateUI: " + r0);
        r14.v = r0;
        d r3 = (d) r14.t.getValue();
        if (r3 == null) goto L10;
        r3.Bn(r0);
    L10:
        boolean r4 = false;
        if ((r0.getUpState() instanceof AVKitCoreStates.Listening) == true) goto L13;
    L15:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L19;
        r14.C3(false);
    L49:
        if ((r0.getUpState() instanceof AVKitDuplexState.UpState.Active) == false) goto L60;
        r2.i("ObricContinuousTalkUIComponent", "updateTalkStateUI: onAsrStart");
        IAgentVoiceInteractionIDL r6 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r6 == null) goto L54;
        r6.onAsrStart(null);
    L54:
        if (r14.K == true) goto L81;
        String r7 = r14.H;
        if (r7 == null) goto L59;
        VoiceCaptureStateProducerDelegate.b.c(r14.I, VoiceCaptureScene.CONTINUOUS_TALK, r7, Integer.valueOf(r14.J));
    L59:
        r14.K = true;
    L81:
        if ((r0.getDownState() instanceof AVKitCoreStates.Speaking) == true) goto L83;
        zh8.a.a.x1().c().r6(null);
        ObricContinuousTalkUIComponent.B3(false);
    L83:
        AVKitDuplexState.UpState r8 = r0.getUpState();
        if ((r8 instanceof AVKitCoreStates.Connecting) == true) goto L101;
        if ((r8 instanceof AVKitCoreStates.Paused) == true) goto L101;
        if ((r8 instanceof AVKitCoreStates.Listening) == true) goto L101;
        if ((r8 instanceof AVKitCoreStates.Recognizing) == true) goto L101;
        if ((r8 instanceof AVKitCoreStates.Finished) == false) goto L98;
        c r9 = r14.p3();
        if (r9 == null) goto L101;
        c.a.a(r9, null, null, false, true, 7);
        goto L101
    L98:
        if ((r8 instanceof AVKitCoreStates.Invalid) == true) goto L101;
        boolean r10 = r8 instanceof AVKitCoreStates.Error;
    L101:
        if ((r0.getDownState() instanceof AVKitCoreStates.Speaking) == false) goto L110;
        hia.a r15 = r14.n;
        if (r15 != null) goto L105;
    L107:
        boolean r16 = false;
    L108:
        if (r16 == false) goto L110;
        r4 = true;
        goto L110
    L105:
        if (r15.k() == true) goto L107;
        r16 = true;
    L110:
        ObricContinuousTalkUIComponent.B3(r4);
        goto L112
    L60:
        r2.i("ObricContinuousTalkUIComponent", "updateTalkStateUI: onAsrEnd");
        IAgentVoiceInteractionIDL r11 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r11 == null) goto L64;
        r11.onAsrEnd();
    L64:
        if (r14.K == false) goto L81;
        StateTriggerEvent.QueryEnd r12 = r0.getUpState().getTriggerBy();
        if ((r12 instanceof StateTriggerEvent.QueryEnd) == false) goto L68;
        StateTriggerEvent.QueryEnd r17 = r12;
    L69:
        if (r17 != null) goto L71;
    L73:
        boolean r18 = false;
    L74:
        if (r18 == false) goto L79;
        String r19 = r14.H;
        if (r19 == null) goto L79;
        VoiceCaptureStateProducerDelegate.b.e(r14.I, VoiceCaptureScene.CONTINUOUS_TALK, r19, Integer.valueOf(r14.J));
    L79:
        r14.K = false;
        goto L81
    L71:
        if (r17.a == true) goto L73;
        r18 = true;
        goto L74
    L68:
        r17 = null;
        goto L69
    L19:
        ObricAssistantForAudioDelegate r20 = ObricAssistantForAudioDelegate.b;
        f r21 = r14.z3();
        if (r21 == null) goto L22;
        iga.a r22 = r21.Zs();
    L23:
        AVKitDuplexState.UpState r23 = r0.getUpState();
        if ((r23 instanceof AVKitCoreStates.Listening) == false) goto L41;
        if ((r0.getDownState() instanceof AVKitCoreStates.DownWaiting) == false) goto L29;
        r14.w = 0;
        ObricAssistantAudioVisualizerState r24 = ObricAssistantAudioVisualizerState.TtsEnd;
    L47:
        r20.f5(r22, r24, null);
        goto L49
    L29:
        if ((r0.getDownState() instanceof AVKitCoreStates.Thinking) == false) goto L32;
        r14.w = 0;
        r24 = ObricAssistantAudioVisualizerState.Thinking;
        goto L47
    L32:
        if ((r0.getDownState() instanceof AVKitCoreStates.Speaking) == false) goto L39;
        IObricChatService.a.getClass();
        IObricChatService r25 = IObricChatService.a.a();
        if (r25 == null) goto L36;
        boolean r26 = r25.k();
    L37:
        if (r26 == true) goto L39;
        r14.w = 0;
        r24 = ObricAssistantAudioVisualizerState.TtsEnd;
        goto L47
    L36:
        r26 = true;
    L39:
        r14.C3(false);
        r24 = ObricAssistantAudioVisualizerState.SpeechStarted;
        goto L47
    L41:
        if ((r23 instanceof AVKitCoreStates.Recognizing) == false) goto L44;
        r14.C3(true);
        r24 = ObricAssistantAudioVisualizerState.SpeechStarted;
        goto L47
    L44:
        if ((r23 instanceof AVKitCoreStates.Finished) == false) goto L46;
        r14.C3(false);
        r24 = ObricAssistantAudioVisualizerState.FinishSession;
        goto L47
    L46:
        r24 = null;
        goto L47
    L22:
        r22 = null;
        goto L23
    L13:
        if (Intrinsics.areEqual(r0.getUpState().getTriggerBy(), ObricContTalkStateMachine.TriggerEvent.QueryRejected.INSTANCE) == false) goto L15;
        r5 = true;
        goto L17
    L114:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
