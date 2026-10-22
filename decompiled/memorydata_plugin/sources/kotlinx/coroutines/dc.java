package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0014J\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadLocalIsSet", "", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "afterResume", "", "state", "clearThreadContext", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class dc<T> extends kotlinx.coroutines.internal.af<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadLocal<Pair<CoroutineContext, Object>> f17309b;
    private volatile boolean threadLocalIsSet;

    public dc(CoroutineContext r4, Continuation<? super T> r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if (r6.get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(dd.f17310a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")) != null) goto L5;
        CoroutineContext r0 = r6.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(dd.f17310a, CoroutineContext.class, "com.obric.memorydata.plugin"));
    L6:
        super(r0, r7);
        this.f17309b = new ThreadLocal();
        if (ZeusTransformUtils.instanceOf(r7.getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(ContinuationInterceptor.Key, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), ah.class) == true) goto L10;
        Object r8 = kotlinx.coroutines.internal.an.a(r6, null);
        kotlinx.coroutines.internal.an.b(r6, r8);
        a(r6, r8);
        return;
    L10:
        return;
    L5:
        r0 = r6;
        goto L6
    }

    public final void a(CoroutineContext r3, Object r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        this.threadLocalIsSet = true;
        this.f17309b.set(TuplesKt.to(r5, r4));
    }

    @Override // kotlinx.coroutines.internal.af, kotlinx.coroutines.a
    public void c(Object r6) {
        if (this.threadLocalIsSet == false) goto L8;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(this.f17309b.get(), Pair.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        kotlinx.coroutines.internal.an.b((CoroutineContext) ZeusTransformUtils.preCheckCast(r0.component1(), CoroutineContext.class, "com.obric.memorydata.plugin"), r0.component2());
    L7:
        this.f17309b.remove();
    L8:
        Object r7 = ad.a(r6, this.c);
        Continuation<T> r1 = this.c;
        CoroutineContext r2 = r1.getContext();
        dc<?> r3 = null;
        Object r4 = kotlinx.coroutines.internal.an.a(r2, null);
        if (r4 == kotlinx.coroutines.internal.an.f17564a) goto L23;
        r3 = ag.a(r1, r2, r4);
    L23:
        this.c.resumeWith(r7);     // Catch: Throwable -> L17
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L17
        if (r3 != null) goto L14;
    L15:
        kotlinx.coroutines.internal.an.b(r2, r4);
        return;
    L14:
        if (r3.g() == true) goto L15;
        return;
    L17:
        th = move-exception;
        if (r3 != null) goto L20;
    L21:
        kotlinx.coroutines.internal.an.b(r2, r4);
    L22:
        throw th;
    L20:
        if (r3.g() == false) goto L22;
        goto L21
    }

    public final boolean g() {
        if (this.threadLocalIsSet == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.f17309b.remove();
        return !r0;
    L5:
        if (this.f17309b.get() != null) goto L7;
        r0 = true;
        goto L8
    }
}
