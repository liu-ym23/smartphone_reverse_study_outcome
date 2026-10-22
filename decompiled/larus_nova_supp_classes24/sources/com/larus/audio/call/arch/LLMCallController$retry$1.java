package com.larus.audio.call.arch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.RealtimeCallParam;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/audio/call/arch/LLMCallController$Result;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.arch.LLMCallController$retry$1", f = "LLMCallController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LLMCallController$retry$1 extends SuspendLambda implements Function1<Continuation<? super LLMCallController.b>, Object> {
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ long $version;
    int label;
    final /* synthetic */ LLMCallController<c> this$0;

    public LLMCallController$retry$1(LLMCallController<c> r1, RealtimeCallParam r2, long r3, Continuation<? super LLMCallController$retry$1> r5) {
        this.this$0 = r1;
        this.$params = r2;
        this.$version = r3;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new LLMCallController$retry$1(this.this$0, this.$params, this.$version, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super LLMCallController.b> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r9);
        this.this$0.t(this.$params);
        if (this.this$0.E(this.$version) == true) goto L7;
        k0<C> r10 = this.this$0.x();
        r10.getClass();
        r10.b("onRetry", new i0());
        return LLMCallController.l(this.this$0, this.$params, true, LifecycleStage.RETRY, this.$version);
    L7:
        return this.this$0.Q(LifecycleStage.RETRY, false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
