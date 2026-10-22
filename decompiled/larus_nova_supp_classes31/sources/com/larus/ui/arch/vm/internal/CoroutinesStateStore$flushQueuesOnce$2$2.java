package com.larus.ui.arch.vm.internal;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "S", "Lcom/larus/ui/arch/vm/external/ComponentState;", "block", "Lkotlin/Function1;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.CoroutinesStateStore$flushQueuesOnce$2$2", f = "CoroutinesStateStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesStateStore$flushQueuesOnce$2$2 extends SuspendLambda implements Function2<Function1<w1a.b, ? extends Unit>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ n<w1a.b> this$0;

    public CoroutinesStateStore$flushQueuesOnce$2$2(n<w1a.b> r1, Continuation<? super CoroutinesStateStore$flushQueuesOnce$2$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CoroutinesStateStore$flushQueuesOnce$2$2 r0 = new CoroutinesStateStore$flushQueuesOnce$2$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Function1) r1, (Continuation) r2);
    }

    public final Object invoke(Function1<w1a.b, Unit> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        ((Function1) this.L$0).invoke(this.this$0.d);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
