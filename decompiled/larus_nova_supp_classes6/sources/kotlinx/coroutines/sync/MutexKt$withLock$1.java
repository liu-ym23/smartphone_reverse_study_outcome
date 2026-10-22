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
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {120}, m = "withLock", n = {"$this$withLock", "owner", "action"}, s = {"L$0", "L$1", "L$2"})
final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        int r6 = this.label | IWakeupSessionConstant.RC_ERROR;
        this.label = r6;
        b0 r1 = b.a;
        if ((r6 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r6 - IWakeupSessionConstant.RC_ERROR;
        MutexKt$withLock$1<T> r7 = this;
    L6:
        Object r0 = r7.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r7.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        Function0 r3 = (Function0) r7.L$2;
        Object r4 = r7.L$1;
        a r8 = (a) r7.L$0;
        ResultKt.throwOnFailure(r0);
        Object r9 = r3.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        r8.unlock(r4);
        InlineMarker.finallyEnd(1);
        return r9;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r8.unlock(r4);
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r7.L$0 = null;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.label = 1;
        throw null;
    L5:
        r7 = new MutexKt$withLock$1(this);
        goto L6
    }
}
