package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<d<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ErrorsKt$retry$3(long r10, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super FlowKt__ErrorsKt$retry$3> r12) {
        this.$retries = r10;
        this.$predicate = r11;
        super(4, r12);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(d<Object> r10, Throwable r11, Long r12, Continuation<? super Boolean> r13) {
        return invoke(r10, r11, r12.longValue(), r13);
    }

    public final Object invoke(d<Object> r10, Throwable r11, long r12, Continuation<? super Boolean> r13) {
        FlowKt__ErrorsKt$retry$3 r14 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, r13);
        r14.L$0 = r11;
        r14.J$0 = r12;
        return r14.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        boolean r13 = true;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        if (((Boolean) r10).booleanValue() == true) goto L18;
    L16:
        r13 = false;
    L18:
        return Boxing.boxBoolean(r13);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Throwable r14 = (Throwable) this.L$0;
        if (this.J$0 >= this.$retries) goto L16;
        Function2<Throwable, Continuation<? super Boolean>, Object> r15 = this.$predicate;
        this.label = 1;
        r10 = r15.invoke(r14, this);
        if (r10 != r11) goto L14;
        return r11;
    }
}
