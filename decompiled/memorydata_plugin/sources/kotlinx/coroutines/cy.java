package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\rR\t\u0010\u0005\u001a\u00020\u0006X\u0082\u0004R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlinx/coroutines/InternalCompletionHandler;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "_state", "Lkotlinx/atomicfu/AtomicInt;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "", "invalidState", "", "state", "", "invoke", "cause", "", "setup", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class cy implements bt {
    private static final /* synthetic */ AtomicIntegerFieldUpdater d = null;
    private volatile /* synthetic */ int _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bx f17304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread f17305b;
    private bc c;

    static {
        d = AtomicIntegerFieldUpdater.newUpdater(cy.class, "_state$volatile");
    }

    public cy(bx r3) {
        this.f17304a = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        this.f17305b = Thread.currentThread();
    }

    private final Void a(int r3) {
        throw new IllegalStateException(("Illegal state " + r3).toString());
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater c() {
        return d;
    }

    public final void a() {
        this.c = ca.a(this.f17304a, true, true, (bt) ZeusTransformUtils.preCheckCast(this, bt.class, "com.obric.memorydata.plugin"));
        AtomicIntegerFieldUpdater r0 = c();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (c().compareAndSet(this, r1, 0) == false) goto L3;
        return;
    L6:
        if (r1 != 2) goto L8;
        return;
    L8:
        if (r1 == 3) goto L19;
        a(r1);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.bt
    public void a(Throwable r5) {
        AtomicIntegerFieldUpdater r6 = c();
    L3:
        int r0 = r6.get(this);
        if (r0 != 0) goto L6;
        if (c().compareAndSet(this, r0, 2) == false) goto L3;
        this.f17305b.interrupt();
        c().set(this, 3);
        return;
    L6:
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L21;
        a(r0);
        throw new KotlinNothingValueException();
    L21:
        return;
    L20:
        return;
    }

    public final void b() {
        AtomicIntegerFieldUpdater r0 = c();
    L3:
        int r1 = r0.get(this);
        if (r1 != 0) goto L6;
        if (c().compareAndSet(this, r1, 1) == false) goto L3;
        bc r4 = this.c;
        if (r4 == null) goto L26;
        r4.dispose();
        return;
    L26:
        return;
    L6:
        if (r1 == 2) goto L3;
        if (r1 != 3) goto L11;
        Thread.interrupted();
        return;
    L11:
        a(r1);
        throw new KotlinNothingValueException();
    }
}
