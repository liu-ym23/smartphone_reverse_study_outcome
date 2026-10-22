package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class co<T> extends cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<T> f17298a;

    /* JADX WARN: Multi-variable type inference failed */
    public co(o<? super T> r1) {
        this.f17298a = r1;
    }

    @Override // kotlinx.coroutines.bt
    public void a(Throwable r3) {
        Object r4 = c().o();
        if (an.a() == true) goto L5;
    L9:
        boolean r0 = ZeusTransformUtils.instanceOf(r4, ab.class);
        o<T> r2 = this.f17298a;
        if (r0 == false) goto L12;
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r1 = Result.Companion;
        Object r6 = ResultKt.createFailure(((ab) ZeusTransformUtils.preCheckCast(r4, ab.class, "com.obric.memorydata.plugin")).f17205a);
    L13:
        r5.resumeWith(Result.m1421constructorimpl(r6));
        return;
    L12:
        r5 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r7 = Result.Companion;
        r6 = cf.b(r4);
        goto L13
    L5:
        if ((!ZeusTransformUtils.instanceOf(r4, br.class)) == true) goto L9;
        throw new AssertionError();
    }
}
