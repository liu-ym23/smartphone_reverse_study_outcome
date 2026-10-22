package com.obric.assistant.state.impl.v2.power;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.IObricAudioStatusMonitorService;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockState;
import com.obric.assistant.state.api.v2.core.bean.ObricAssistantAliveLockStateType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerManager$powerLockStatusChangedCallback$1$onAssistantAliveStateChanged$1", f = "ObricPowerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricPowerManager$powerLockStatusChangedCallback$1$onAssistantAliveStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ObricAssistantAliveLockState $state;
    int label;

    public ObricPowerManager$powerLockStatusChangedCallback$1$onAssistantAliveStateChanged$1(ObricAssistantAliveLockState r1, Continuation<? super ObricPowerManager$powerLockStatusChangedCallback$1$onAssistantAliveStateChanged$1> r2) {
        this.$state = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricPowerManager$powerLockStatusChangedCallback$1$onAssistantAliveStateChanged$1(this.$state, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r8);
        ObricAssistantAliveLockState r9 = ObricPowerManager.h;
        ObricAssistantAliveLockState r0 = this.$state;
        if (r9 == r0) goto L12;
        FLogger r10 = FLogger.a;
        StringBuilder r1 = new StringBuilder("lock=assistant action=skip_stale_state state=");
        r1.append(this.$state.getCurrentState());
        r1.append(" currentState=");
        ObricAssistantAliveLockState r2 = ObricPowerManager.h;
        if (r2 == null) goto L9;
        ObricAssistantAliveLockStateType r3 = r2.getCurrentState();
    L10:
        r1.append(r3);
        r10.i("[ObricPowerManager]", r1.toString());
        return Unit.INSTANCE;
    L9:
        r3 = null;
        goto L10
    L12:
        boolean r4 = true;
        if (r0.getCurrentState() == ObricAssistantAliveLockStateType.ACQUIRED) goto L15;
        boolean r11 = true;
    L16:
        FLogger.a.i("[ObricPowerManager]", "lock=assistant action=state_changed state=" + this.$state.getCurrentState() + " blockAudio=" + r11 + " reason=" + this.$state.getExt().get("state_change_reason"));
        IObricAudioStatusMonitorService r5 = (IObricAudioStatusMonitorService) ServiceManager.get().getService(IObricAudioStatusMonitorService.class);     // Catch: Exception -> L24
        if (r5 == null) goto L27;
        if (r11 == true) goto L22;
        r4 = false;
    L22:
        r5.a(r4);     // Catch: Exception -> L24
    L27:
        return Unit.INSTANCE;
    L24:
        e = move-exception;
        FLogger r6 = FLogger.a;
        CoroutineScope r7 = ObricPowerManager.a;
        r6.e("[ObricPowerManager]", "lock=assistant action=notify_audio result=failed blockAudio=" + r11, e);
        goto L27
    L15:
        r11 = false;
        goto L16
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
