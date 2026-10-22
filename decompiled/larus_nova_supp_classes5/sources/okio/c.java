package okio;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class c extends j0 {
    public static final ReentrantLock h = null;
    public static final Condition i = null;
    public static final long j = 0;
    public static final long k = 0;
    public static c l;
    public int e;
    public c f;
    public long g;

    public static final class a {
        public static c b() throws InterruptedException {
            c r0 = c.l;
            Intrinsics.checkNotNull(r0);
            c r1 = r0.f;
            if (r1 != null) goto L10;
            long r2 = System.nanoTime();
            c.i.await(c.j, TimeUnit.MILLISECONDS);
            c r3 = c.l;
            Intrinsics.checkNotNull(r3);
            if (r3.f == null) goto L7;
            return null;
        L7:
            if ((System.nanoTime() - r2) >= c.k) goto L9;
            return null;
        L9:
            return c.l;
        L10:
            long r4 = System.nanoTime();
            long r5 = r1.g - r4;
            if (r5 <= 0) goto L14;
            c.i.await(r5, TimeUnit.NANOSECONDS);
            return null;
        L14:
            c r6 = c.l;
            Intrinsics.checkNotNull(r6);
            r6.f = r1.f;
            r1.f = null;
            r1.e = 2;
            return r1;
        }

        public a() {
        }

        public static final void a(c r5, long r6, boolean r8) {
            ReentrantLock r0 = c.h;
            if (c.l != null) goto L5;
            c.l = new c();
            ThreadMethodProxy.start(new b());
        L5:
            long r1 = System.nanoTime();
            if (r6 == 0) goto L9;
            if (r8 == false) goto L9;
            r5.g = Math.min(r6, r5.d() - r1) + r1;
        L13:
            long r7 = r5.g - r1;
            c r9 = c.l;
            Intrinsics.checkNotNull(r9);
        L14:
            c r2 = r9.f;
            if (r2 == null) goto L20;
            Intrinsics.checkNotNull(r2);
            if (r7 < (r2.g - r1)) goto L20;
            r9 = r9.f;
            Intrinsics.checkNotNull(r9);
        L20:
            r5.f = r9.f;
            r9.f = r5;
            if (r9 != c.l) goto L28;
            c.i.signal();
            return;
        L28:
            return;
        L9:
            if (r6 == 0) goto L11;
            r5.g = r6 + r1;
            goto L13
        L11:
            if (r8 == false) goto L25;
            r5.g = r5.d();
            goto L13
        L25:
            throw new AssertionError();
        }
    }

    public void m() {
    }

    static {
        new a();
        ReentrantLock r0 = new ReentrantLock();
        h = r0;
        i = r0.newCondition();
        long r1 = TimeUnit.SECONDS.toMillis(60);
        j = r1;
        k = TimeUnit.MILLISECONDS.toNanos(r1);
    }

    public final void j() {
        long r0 = this.c;
        boolean r2 = this.a;
        if (r0 != 0) goto L6;
        if (r2 == true) goto L6;
        return;
    L6:
        ReentrantLock r3 = h;
        r3.lock();
    L17:
        th = move-exception;
        r3.unlock();
        throw th;
    L8:
        if (this.e != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L16;
        this.e = 1;     // Catch: Throwable -> L17
        a.a(this, r0, r2);     // Catch: Throwable -> L17
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r3.unlock();
        return;
    L16:
        throw new IllegalStateException("Unbalanced enter/exit".toString());     // Catch: Throwable -> L17
    L10:
        r4 = false;
        goto L11
    }

    public final boolean k() {
        ReentrantLock r0 = h;
        r0.lock();
        int r1 = this.e;     // Catch: Throwable -> L20
        boolean r2 = false;
        this.e = 0;     // Catch: Throwable -> L20
        if (r1 != 1) goto L16;
        c r3 = l;     // Catch: Throwable -> L20
    L6:
        if (r3 == null) goto L14;
        c r4 = r3.f;     // Catch: Throwable -> L20
        if (r4 == this) goto L9;
        r3 = r4;
        goto L6
    L9:
        r3.f = this.f;     // Catch: Throwable -> L20
        this.f = null;     // Catch: Throwable -> L20
        r0.unlock();
        return false;
    L14:
        throw new IllegalStateException("node was not found in the queue".toString());     // Catch: Throwable -> L20
    L16:
        if (r1 != 2) goto L18;
        r2 = true;
    L18:
        r0.unlock();
        return r2;
    L20:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public c() {
    }

    public IOException l(IOException r3) {
        InterruptedIOException r0 = new InterruptedIOException("timeout");
        if (r3 == null) goto L5;
        r0.initCause(r3);
    L5:
        return r0;
    }
}
