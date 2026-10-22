package kotlinx.coroutines.sync;

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
@DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {121}, m = "withLock", n = {"$this$withLock", "owner", "action"}, s = {"L$0", "L$1", "L$2"})
final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r10 = this.label | Integer.MIN_VALUE;
        this.label = r10;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r10 - Integer.MIN_VALUE;
    L6:
        Object r11 = this.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L18;
        if (r12 != 1) goto L17;
        Function0 r13 = (Function0) this.L$2;
        Object r14 = this.L$1;
        a r15 = (a) this.L$0;
        ResultKt.throwOnFailure(r11);
        Object r16 = r13.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        ((d) r15).d(r14);
        InlineMarker.finallyEnd(1);
        return r16;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        ((d) r15).d(r14);
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 1;
        throw null;
    L5:
        MutexKt$withLock$1<T> this = new MutexKt$withLock$1(this);
        goto L6
    }
}
