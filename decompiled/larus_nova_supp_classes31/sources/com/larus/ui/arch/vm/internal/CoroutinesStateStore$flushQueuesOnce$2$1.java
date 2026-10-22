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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\b\u0006H\n"}, d2 = {"<anonymous>", "", "S", "Lcom/larus/ui/arch/vm/external/ComponentState;", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.CoroutinesStateStore$flushQueuesOnce$2$1", f = "CoroutinesStateStore.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
final class CoroutinesStateStore$flushQueuesOnce$2$1 extends SuspendLambda implements Function2<Function1<w1a.b, w1a.b>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ n<w1a.b> this$0;

    public CoroutinesStateStore$flushQueuesOnce$2$1(n<w1a.b> r1, Continuation<? super CoroutinesStateStore$flushQueuesOnce$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CoroutinesStateStore$flushQueuesOnce$2$1 r0 = new CoroutinesStateStore$flushQueuesOnce$2$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Function1) r1, (Continuation) r2);
    }

    public final Object invoke(Function1<w1a.b, w1a.b> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        S r6 = (S) ((Function1) this.L$0).invoke(this.this$0.d);
        if (Intrinsics.areEqual(r6, this.this$0.d) == true) goto L14;
        n<w1a.b> r2 = this.this$0;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.d = r6;
        MutableSharedFlow<S> r3 = this.this$0.c;
        this.label = 1;
        if (r3.emit(r6, this) != r0) goto L14;
        return r0;
    }
}
