package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", ST.IMPLICIT_ARG_NAME, "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;Lkotlin/Array;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", i = {}, l = {288, 288}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combine$6$2 extends SuspendLambda implements Function3<h, Object[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object[], Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$6$2(Function2<? super Object[], ? super Continuation<Object>, ? extends Object> r5, Continuation<? super FlowKt__ZipKt$combine$6$2> r10) {
        this.$transform = r5;
        super(3, r10);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(h r5, Object[] r10, Continuation<? super Unit> r11) {
        return invoke2(r5, r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        h r12 = (h) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r12.emit(r10, this) != r5) goto L17;
        return r5;
    L10:
        ResultKt.throwOnFailure(r10);
        r12 = (h) this.L$0;
        Object[] r13 = (Object[]) this.L$1;
        Function2<Object[], Continuation<Object>, Object> r14 = this.$transform;
        this.L$0 = r12;
        this.label = 1;
        r10 = r14.mo2invoke(r13, this);
        if (r10 != r5) goto L13;
        return r5;
    }

    public final Object invokeSuspend$$forInline(Object r5) {
        h r10 = (h) this.L$0;
        Object[] r11 = (Object[]) this.L$1;
        Object r12 = this.$transform.mo2invoke(r11, this);
        InlineMarker.mark(0);
        r10.emit(r12, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(h r5, Object[] r10, Continuation<? super Unit> r11) {
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$6$2 r12 = new FlowKt__ZipKt$combine$6$2(this.$transform, r11);
        r12.L$0 = r5;
        r12.L$1 = r10;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
