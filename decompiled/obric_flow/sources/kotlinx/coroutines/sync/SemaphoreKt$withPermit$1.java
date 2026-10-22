package kotlinx.coroutines.sync;

import ai.j0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {81}, m = "withPermit", n = {"$this$withPermit", "action"}, s = {"L$0", "L$1"})
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r10 = this.label | Integer.MIN_VALUE;
        this.label = r10;
        int r11 = h.f19018a;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r10 - Integer.MIN_VALUE;
    L6:
        Object r12 = this.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = this.label;
        if (r13 == 0) goto L17;
        if (r13 != 1) goto L16;
        Function0 r14 = (Function0) this.L$1;
        j0.A(this.L$0);
        ResultKt.throwOnFailure(r12);
        r14.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        throw null;
    L13:
        InlineMarker.finallyStart(1);
        throw null;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r12);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 1;
        throw null;
    L5:
        SemaphoreKt$withPermit$1<T> this = new SemaphoreKt$withPermit$1(this);
        goto L6
    }
}
