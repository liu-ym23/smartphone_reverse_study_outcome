package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
final class f<T> extends a<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Thread f10385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final f1 f10386j;

    public f(CoroutineContext r10, Thread r11, f1 r12) {
        super(r10, true, true);
        this.f10385i = r11;
        this.f10386j = r12;
    }

    @Override // kotlinx.coroutines.c2
    protected boolean A0() {
        return true;
    }

    @Override // kotlinx.coroutines.c2
    protected void Z(Object r10) {
        if (Intrinsics.areEqual(Thread.currentThread(), this.f10385i) == true) goto L6;
        Thread r11 = this.f10385i;
        c.a();
        LockSupport.unpark(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T j1() {
        c.a();
        f1 r10 = this.f10386j;     // Catch: Throwable -> L33
        b0 r11 = null;
        if (r10 == null) goto L36;
        f1.i0(r10, false, 1, null);     // Catch: Throwable -> L33
    L36:
    L28:
        th = move-exception;
        f1 r12 = this.f10386j;     // Catch: Throwable -> L33
        if (r12 == null) goto L32;
        f1.d0(r12, false, 1, null);     // Catch: Throwable -> L33
    L32:
        throw th;     // Catch: Throwable -> L33
    L7:
        if (Thread.interrupted() == true) goto L26;
        f1 r13 = this.f10386j;     // Catch: Throwable -> L28
        if (r13 == null) goto L11;
        long r14 = r13.l0();     // Catch: Throwable -> L28
    L13:
        if (a() == true) goto L16;
        c.a();     // Catch: Throwable -> L28
        LockSupport.parkNanos(this, r14);     // Catch: Throwable -> L28
        goto L36
    L16:
        f1 r15 = this.f10386j;     // Catch: Throwable -> L33
        if (r15 == null) goto L19;
        f1.d0(r15, false, 1, null);     // Catch: Throwable -> L33
    L19:
        c.a();
        T r16 = (T) d2.h(w0());
        if ((r16 instanceof b0) == false) goto L22;
        r11 = (b0) r16;
    L22:
        if (r11 != null) goto L25;
        return r16;
    L25:
        throw r11.f10244a;
    L11:
        r14 = Long.MAX_VALUE;
        goto L13
    L26:
        InterruptedException r17 = new InterruptedException();     // Catch: Throwable -> L28
        d0(r17);     // Catch: Throwable -> L28
        throw r17;     // Catch: Throwable -> L28
    L33:
        th = move-exception;
        c.a();
        throw th;
    }
}
