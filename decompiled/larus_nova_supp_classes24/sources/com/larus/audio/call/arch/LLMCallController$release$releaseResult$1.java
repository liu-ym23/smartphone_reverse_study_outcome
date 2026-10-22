package com.larus.audio.call.arch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
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
@DebugMetadata(c = "com.larus.audio.call.arch.LLMCallController$release$releaseResult$1", f = "LLMCallController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LLMCallController$release$releaseResult$1 extends SuspendLambda implements Function1<Continuation<? super LLMCallController.b>, Object> {
    int label;
    final /* synthetic */ LLMCallController<C> this$0;

    public LLMCallController$release$releaseResult$1(LLMCallController<C> r1, Continuation<? super LLMCallController$release$releaseResult$1> r2) {
        this.this$0 = r1;
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r3) {
        return new LLMCallController$release$releaseResult$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super LLMCallController.b> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r4);
        LLMCallController<C> r0 = this.this$0;     // Catch: Throwable -> L8
        r0.t(r0.f);     // Catch: Throwable -> L8
        k0 r1 = this.this$0.x();     // Catch: Throwable -> L8
        r1.getClass();     // Catch: Throwable -> L8
        r1.b("onRelease", new d0());     // Catch: Throwable -> L8
        LLMCallController.b.c r2 = new LLMCallController.b.c(LifecycleStage.RELEASE);     // Catch: Throwable -> L8
        this.this$0.o = true;
        return r2;
    L8:
        th = move-exception;
        this.this$0.o = true;
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
