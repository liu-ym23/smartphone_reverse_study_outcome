package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0015\u0010\u0005\u001a\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u00052\u0015\u0010\u0007\u001a\u00110\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", "Lkotlin/ParameterName;", "name", "cause", "", "attempt", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;Ljava/lang/Throwable;J)Z"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<h, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ long $retries;
    /* synthetic */ long J$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$3(long r5, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> r10, Continuation<? super FlowKt__ErrorsKt$retry$3> r11) {
        this.$retries = r5;
        this.$predicate = r10;
        super(4, r11);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(h r10, Throwable r11, Long r12, Continuation<? super Boolean> r13) {
        return invoke(r10, r11, r12.longValue(), r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        boolean r12 = true;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        if (((Boolean) r10).booleanValue() == true) goto L18;
    L16:
        r12 = false;
    L18:
        return Boxing.boxBoolean(r12);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Throwable r13 = (Throwable) this.L$0;
        if (this.J$0 >= this.$retries) goto L16;
        Function2<Throwable, Continuation<? super Boolean>, Object> r14 = this.$predicate;
        this.label = 1;
        r10 = r14.mo2invoke(r13, this);
        if (r10 != r5) goto L14;
        return r5;
    }

    public final Object invoke(h r5, Throwable r10, long r11, Continuation<? super Boolean> r12) {
        FlowKt__ErrorsKt$retry$3 r13 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, r12);
        r13.L$0 = r10;
        r13.J$0 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }
}
