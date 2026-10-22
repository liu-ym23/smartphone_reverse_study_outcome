package com.obric.audio.continuous_talk;

import android.app.Application;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.asr.VoiceInputType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import laa.d;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1", f = "ObricContinuousTalkCtrlComponent.kt", i = {0, 1}, l = {669, 670, 708, 738}, m = "invokeSuspend", n = {"conv", "resolvedBot"}, s = {"L$0", "L$0"})
final class ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $breathWakeup;
    final /* synthetic */ String $callID;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ String $startupAttemptId;
    final /* synthetic */ String $startupRequestToken;
    final /* synthetic */ VoiceInputType $voiceInputType;
    final /* synthetic */ Integer $vuiId;
    Object L$0;
    int label;
    final /* synthetic */ ObricContinuousTalkCtrlComponent this$0;

    public ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1(ObricContinuousTalkCtrlComponent r1, String r2, String r3, String r4, String r5, Integer r6, VoiceInputType r7, boolean r8, Continuation<? super ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1> r9) {
        this.this$0 = r1;
        this.$startupRequestToken = r2;
        this.$callID = r3;
        this.$startupAttemptId = r4;
        this.$enterMethod = r5;
        this.$vuiId = r6;
        this.$voiceInputType = r7;
        this.$breathWakeup = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1(this.this$0, this.$startupRequestToken, this.$callID, this.$startupAttemptId, this.$enterMethod, this.$vuiId, this.$voiceInputType, this.$breathWakeup, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        e r11 = null;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
    L91:
        BotModel r4 = (BotModel) r3;
        if (Intrinsics.areEqual(this.this$0.E, this.$startupRequestToken) == false) goto L94;
        if (r4 == null) goto L98;
        ObricContinuousTalkCtrlComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$breathWakeup, this.$startupAttemptId, this.$startupRequestToken);
        return Unit.INSTANCE;
    L98:
        this.this$0.Z3(false, ObricAssistantForAudioDelegate.b.Y4());
        this.this$0.p3("dropped", "bot_unavailable", this.$startupAttemptId);
        return Unit.INSTANCE;
    L94:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r21);
        Object r5 = r21;
    L74:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.this$0.E, this.$startupRequestToken) == false) goto L77;
        if (r6 == null) goto L81;
        ObricContinuousTalkCtrlComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$breathWakeup, this.$startupAttemptId, this.$startupRequestToken);
        return Unit.INSTANCE;
    L81:
        this.this$0.Z3(false, ObricAssistantForAudioDelegate.b.U4());
        this.this$0.p3("dropped", "conversation_unavailable", this.$startupAttemptId);
        return Unit.INSTANCE;
    L77:
        return Unit.INSTANCE;
    L12:
        BotModel r7 = (BotModel) this.L$0;
        ResultKt.throwOnFailure(r21);
        Object r8 = r21;
    L50:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.this$0.E, this.$startupRequestToken) == false) goto L53;
        if (r7 == null) goto L58;
        if (r9 == null) goto L58;
        ObricContinuousTalkCtrlComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$breathWakeup, this.$startupAttemptId, this.$startupRequestToken);
        return Unit.INSTANCE;
    L58:
        com.larus.bmhome.chat.component.cvs.y r10 = this.this$0.u0();
        if (r10 == null) goto L61;
        r11 = r10.h();
    L61:
        if (r11 != null) goto L63;
        this.this$0.Z3(false, ObricAssistantForAudioDelegate.b.U4());
        this.this$0.p3("dropped", "conversation_unavailable", this.$startupAttemptId);
    L65:
        return Unit.INSTANCE;
    L63:
        this.this$0.Z3(false, ObricAssistantForAudioDelegate.b.Y4());
        this.this$0.p3("dropped", "bot_unavailable", this.$startupAttemptId);
        goto L65
    L53:
        return Unit.INSTANCE;
    L13:
        Deferred r12 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r21);
        Object r13 = r21;
    L46:
        BotModel r14 = (BotModel) r13;
        this.L$0 = r14;
        this.label = 2;
        r8 = r12.await(this);
        if (r8 != r1) goto L49;
        return r1;
    L49:
        r7 = r14;
        goto L50
    L14:
        ResultKt.throwOnFailure(r21);
        if (Intrinsics.areEqual(this.this$0.E, this.$startupRequestToken) == false) goto L17;
        ObricContinuousTalkCtrlComponent r15 = this.this$0;
        r15.A = this.$callID;
        int r16 = com.larus.utils.f0.a;
        if (com.larus.utils.f0.a(r15.getContext()) == true) goto L23;
        t19.s r17 = t19.s.a;
        Application r18 = AppHost.a.getApplication();
        r17.getClass();
        t19.s.s(r18, 2131908080);
        this.this$0.Z3(false, ObricAssistantForAudioDelegate.b.e5());
        this.this$0.p3("blocked", "network_unavailable", this.$startupAttemptId);
        return Unit.INSTANCE;
    L23:
        if (this.this$0.u0() != null) goto L33;
        d r19 = (d) this.this$0.u.getValue();
        if (r19 != null) goto L27;
    L29:
        boolean r20 = false;
    L30:
        if (r20 == true) goto L33;
        ObricContinuousTalkCtrlComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$breathWakeup, this.$startupAttemptId, this.$startupRequestToken);
        return Unit.INSTANCE;
    L27:
        if (r19.Da() != true) goto L29;
        r20 = true;
    L33:
        com.larus.bmhome.chat.component.cvs.y r22 = this.this$0.u0();
        if (r22 == null) goto L36;
        e r23 = r22.h();
    L37:
        if (r23 != null) goto L66;
        com.larus.bmhome.chat.component.cvs.y r24 = this.this$0.u0();
        if (r24 == null) goto L41;
        BotModel r25 = r24.j0();
    L42:
        if (r25 != null) goto L66;
        Deferred r110 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$bot$1(this.this$0, null), 3, null);
        r12 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$conv$1(this.this$0, null), 3, null);
        this.L$0 = r12;
        this.label = 1;
        r13 = r110.await(this);
        if (r13 != r1) goto L46;
        return r1;
    L41:
        r25 = null;
    L66:
        com.larus.bmhome.chat.component.cvs.y r26 = this.this$0.u0();
        if (r26 == null) goto L69;
        e r27 = r26.h();
    L70:
        if (r27 != null) goto L83;
        Deferred r28 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$conv$2(this.this$0, null), 3, null);
        this.label = 3;
        r5 = r28.await(this);
        if (r5 != r1) goto L74;
        return r1;
    L83:
        com.larus.bmhome.chat.component.cvs.y r29 = this.this$0.u0();
        if (r29 == null) goto L86;
        BotModel r30 = r29.j0();
    L87:
        if (r30 != null) goto L100;
        Deferred r31 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ObricContinuousTalkCtrlComponent$prepareAndOpenContinuousTalk$1$1$bot$2(this.this$0, null), 3, null);
        this.label = 4;
        r3 = r31.await(this);
        if (r3 != r1) goto L91;
        return r1;
    L100:
        ObricContinuousTalkCtrlComponent.h3(this.this$0, this.$enterMethod, this.$callID, this.$vuiId, this.$voiceInputType, this.$breathWakeup, this.$startupAttemptId, this.$startupRequestToken);
        return Unit.INSTANCE;
    L86:
        r30 = null;
        goto L87
    L69:
        r27 = null;
        goto L70
    L36:
        r23 = null;
        goto L37
    L17:
        return Unit.INSTANCE;
    }
}
