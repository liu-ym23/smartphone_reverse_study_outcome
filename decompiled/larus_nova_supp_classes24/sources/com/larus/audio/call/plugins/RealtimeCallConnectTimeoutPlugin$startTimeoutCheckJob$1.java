package com.larus.audio.call.plugins;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.call.mgr.AVKitCoreStates$Connecting;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.im.internal.audio.ability.SessionReleaseReason;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.plugins.RealtimeCallConnectTimeoutPlugin$startTimeoutCheckJob$1", f = "RealtimeCallConnectTimeoutPlugin.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallConnectTimeoutPlugin$startTimeoutCheckJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallConnectTimeoutPlugin this$0;

    public RealtimeCallConnectTimeoutPlugin$startTimeoutCheckJob$1(RealtimeCallConnectTimeoutPlugin r1, Continuation<? super RealtimeCallConnectTimeoutPlugin$startTimeoutCheckJob$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallConnectTimeoutPlugin$startTimeoutCheckJob$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L19:
        if (com.larus.audio.call.f.f() == false) goto L21;
        boolean r7 = ((AVKitDuplexState) this.this$0.getContext().a().y().getValue()).getUpState() instanceof AVKitCoreStates$Connecting;
    L22:
        if (r7 == false) goto L26;
        com.larus.audio.call.util.e.a.i(this.this$0.g, "timeout, disconnect");
        id9.d r8 = this.this$0.getContext().j();
        if (r8 == null) goto L28;
        r8.C(SessionReleaseReason.ConnectingTimeLimit);
    L28:
        return Unit.INSTANCE;
    L26:
        com.larus.audio.call.util.e.a.i(this.this$0.g, "current state isn't connecting, " + this.this$0.getContext().a().s1());
        goto L28
    L21:
        r7 = this.this$0.getContext().a().s1() instanceof MajorState.a;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        RealtimeCallConnectTimeoutPlugin r9 = this.this$0;
        if (r9.i == true) goto L12;
        com.larus.audio.call.util.e.a.i(r9.g, "not first connect, skip");
    L12:
        if (r9.i == false) goto L14;
        com.larus.audio.call.util.e.a.i(this.this$0.g, "startTimeoutCheckJob success");
        this.this$0.i = false;
        long r3 = (long) (this.this$0.f * CommandStatus.DORA_TRACE);
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L19;
        return r0;
    L14:
        return Unit.INSTANCE;
    }
}
