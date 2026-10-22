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
@DebugMetadata(c = "com.larus.audio.call.arch.LLMCallController$start$1", f = "LLMCallController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LLMCallController$start$1 extends SuspendLambda implements Function1<Continuation<? super LLMCallController.b>, Object> {
    final /* synthetic */ boolean $fromRetry;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ long $version;
    int label;
    final /* synthetic */ LLMCallController<c> this$0;

    public LLMCallController$start$1(LLMCallController<c> r1, RealtimeCallParam r2, boolean r3, long r4, Continuation<? super LLMCallController$start$1> r6) {
        this.this$0 = r1;
        this.$params = r2;
        this.$fromRetry = r3;
        this.$version = r4;
        super(1, r6);
    }

    public final Continuation<Unit> create(Continuation<?> r9) {
        return new LLMCallController$start$1(this.this$0, this.$params, this.$fromRetry, this.$version, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super LLMCallController.b> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r8);
        if (this.this$0.l == true) goto L8;
        LLMCallController<c> r9 = this.this$0;
        r9.t(r9.f);
    L8:
        return LLMCallController.l(this.this$0, this.$params, this.$fromRetry, LifecycleStage.START, this.$version);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
