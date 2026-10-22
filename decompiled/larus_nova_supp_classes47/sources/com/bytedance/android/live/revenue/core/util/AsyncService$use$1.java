package com.bytedance.android.live.revenue.core.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/core/util/d;", "T", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.bytedance.android.live.revenue.core.util.AsyncService$use$1", f = "AsyncService.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
final class AsyncService$use$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ d $this_use;
    int label;

    public AsyncService$use$1(d r1, Function1 r2, Continuation r3) {
        this.$this_use = r1;
        this.$block = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new AsyncService$use$1(this.$this_use, this.$block, r4);
    }

    public final Object invoke(Object r2) {
        return create((Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        this.$block.invoke(this.$this_use);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        d r5 = this.$this_use;
        this.label = 1;
        if (r5.g(this) != r0) goto L11;
        return r0;
    }
}
