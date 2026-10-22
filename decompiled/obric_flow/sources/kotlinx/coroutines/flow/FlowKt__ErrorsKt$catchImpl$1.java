package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0}, l = {152}, m = "catchImpl", n = {"fromDownstream"}, s = {"L$0"})
final class FlowKt__ErrorsKt$catchImpl$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public FlowKt__ErrorsKt$catchImpl$1(Continuation<? super FlowKt__ErrorsKt$catchImpl$1> r5) {
        super(r5);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [int, kotlin.jvm.internal.Ref$ObjectRef] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label = (this.label | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r10 = this.label;
        Throwable r11 = null;
        if (r10 == 0) goto L12;
        if (r10 != 1) goto L11;
        Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L8
    L31:
        return r11;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r5);
        this.L$0 = new Ref.ObjectRef();     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        throw null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r11 = th;
        Throwable r13 = (Throwable) r10.element;
        if (r13 != null) goto L18;
    L19:
        Job r14 = (Job) getContext().get(Job.Key);
        if (r14 != null) goto L22;
    L30:
        if (r13 == null) goto L31;
        if ((r11 instanceof CancellationException) == false) goto L36;
        ExceptionsKt.addSuppressed(r13, r11);
        throw r13;
    L36:
        ExceptionsKt.addSuppressed(r11, r13);
        throw r11;
    L22:
        if (r14.isCancelled() == false) goto L30;
        CancellationException r15 = r14.getCancellationException();
        if (r15 == null) goto L30;
        if (Intrinsics.areEqual(r15, r11) == false) goto L30;
        throw r11;
    L18:
        if (Intrinsics.areEqual(r13, r11) == false) goto L19;
        throw r11;
    }
}
