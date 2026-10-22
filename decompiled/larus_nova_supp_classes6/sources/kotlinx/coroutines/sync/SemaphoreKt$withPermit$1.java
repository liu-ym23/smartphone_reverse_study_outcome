package kotlinx.coroutines.sync;

import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {81}, m = "withPermit", n = {"$this$withPermit", "action"}, s = {"L$0", "L$1"})
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        int r5 = this.label | IWakeupSessionConstant.RC_ERROR;
        this.label = r5;
        int r1 = d.a;
        if ((r5 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r5 - IWakeupSessionConstant.RC_ERROR;
        SemaphoreKt$withPermit$1<T> r6 = this;
    L6:
        Object r0 = r6.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        Function0 r3 = (Function0) r6.L$1;
        c r7 = (c) r6.L$0;
        ResultKt.throwOnFailure(r0);
        Object r8 = r3.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        r7.release();
        InlineMarker.finallyEnd(1);
        return r8;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r7.release();
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r6.L$0 = null;
        r6.L$1 = null;
        r6.label = 1;
        throw null;
    L5:
        r6 = new SemaphoreKt$withPermit$1(this);
        goto L6
    }
}
