package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u000b\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "afterCompletion", "", "state", "", "afterResume", "getResult", "getResult$kotlinx_coroutines_core", "tryResume", "", "trySuspend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class aw<T> extends kotlinx.coroutines.internal.af<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17223b = null;
    private volatile /* synthetic */ int _decision$volatile;

    static {
        f17223b = AtomicIntegerFieldUpdater.newUpdater(aw.class, "_decision$volatile");
    }

    public aw(CoroutineContext r3, Continuation<? super T> r4) {
        super((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater g() {
        return f17223b;
    }

    private final boolean t() {
        AtomicIntegerFieldUpdater r0 = g();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (g().compareAndSet(this, 0, 1) == false) goto L3;
        return true;
    L6:
        if (r1 != 2) goto L9;
        return false;
    L9:
        throw new IllegalStateException("Already suspended".toString());
    }

    private final boolean u() {
        AtomicIntegerFieldUpdater r0 = g();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L5;
        if (g().compareAndSet(this, 0, 2) == false) goto L3;
        return true;
    L5:
        if (r1 != 1) goto L8;
        return false;
    L8:
        throw new IllegalStateException("Already resumed".toString());
    }

    @Override // kotlinx.coroutines.internal.af, kotlinx.coroutines.a
    public void c(Object r3) {
        if (u() == false) goto L5;
        return;
    L5:
        kotlinx.coroutines.internal.m.a(IntrinsicsKt.intercepted(this.c), ad.a(r3, this.c), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.af, kotlinx.coroutines.ce
    public void d(Object r1) {
        c(r1);
    }

    public final Object f() {
        if (t() == true) goto L5;
        Object r2 = cf.b(o());
        if (ZeusTransformUtils.instanceOf(r2, ab.class) == true) goto L10;
        return r2;
    L10:
        throw ((ab) ZeusTransformUtils.preCheckCast(r2, ab.class, "com.obric.memorydata.plugin")).f17205a;
    L5:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
