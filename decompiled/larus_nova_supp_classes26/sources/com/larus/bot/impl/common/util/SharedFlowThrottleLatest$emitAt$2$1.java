package com.larus.bot.impl.common.util;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.SharedFlowThrottleLatest$emitAt$2$1", f = "FlowExt.kt", i = {}, l = {96, 97}, m = "invokeSuspend", n = {}, s = {})
final class SharedFlowThrottleLatest$emitAt$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f.a<Object> $it;
    final /* synthetic */ long $timeSinceLastEmit;
    int label;
    final /* synthetic */ f<Object> this$0;

    public SharedFlowThrottleLatest$emitAt$2$1(f<Object> r1, long r2, f.a<Object> r4, Continuation<? super SharedFlowThrottleLatest$emitAt$2$1> r5) {
        this.this$0 = r1;
        this.$timeSinceLastEmit = r2;
        this.$it = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SharedFlowThrottleLatest$emitAt$2$1(this.this$0, this.$timeSinceLastEmit, this.$it, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        f<Object> r10 = this.this$0;
        Object r2 = this.$it.a;
        this.label = 2;
        r10.f = null;
        r10.e = System.currentTimeMillis();
        Object r11 = r10.c.emit(r2, this);
        if (r11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        r11 = Unit.INSTANCE;
    L17:
        if (r11 != r0) goto L20;
        return r0;
    L10:
        ResultKt.throwOnFailure(r9);
        long r4 = this.this$0.b - this.$timeSinceLastEmit;
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L13;
        return r0;
    }
}
