package okio;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class j0 {
    public static final a d = null;
    public boolean a;
    public long b;
    public long c;

    public static final class a extends j0 {
        @Override // okio.j0
        public final j0 e(long r1) {
            return this;
        }

        @Override // okio.j0
        public final void g() {
        }

        @Override // okio.j0
        public final j0 h(long r1, TimeUnit r3) {
            Intrinsics.checkNotNullParameter(r3, "unit");
            return this;
        }

        public a() {
        }
    }

    public static final class b {
    }

    public j0() {
    }

    public j0 b() {
        this.a = false;
        return this;
    }

    static {
        d = new a();
    }

    public j0 c() {
        this.c = 0;
        return this;
    }

    public long d() {
        if (this.a == false) goto L7;
        return this.b;
    L7:
        throw new IllegalStateException("No deadline".toString());
    }

    public void g() throws IOException {
        if (ThreadMethodProxy.currentThread().isInterrupted() == true) goto L13;
        if (this.a == true) goto L7;
        return;
    L7:
        if ((this.b - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    L13:
        throw new InterruptedIOException("interrupted");
    }

    public boolean f() {
        return this.a;
    }

    public long i() {
        return this.c;
    }

    public void a(Condition r10) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(r10, "condition");
        boolean r0 = f();     // Catch: InterruptedException -> L25
        long r1 = i();     // Catch: InterruptedException -> L25
        if (r0 == false) goto L6;
    L9:
        if (r0 == true) goto L11;
    L13:
        if (r0 == true) goto L15;
    L17:
        if (r1 <= 0) goto L24;
        if (r10.awaitNanos(r1) <= 0) goto L22;
        return;
    L22:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L25
    L24:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L25
    L15:
        r1 = d() - System.nanoTime();
        goto L17
    L11:
        if (r1 == 0) goto L13;
        r1 = Math.min(r1, d() - System.nanoTime());     // Catch: InterruptedException -> L25
        goto L17
    L6:
        if (r1 != 0) goto L9;
        r10.await();     // Catch: InterruptedException -> L25
        return;
    L25:
        ThreadMethodProxy.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    public j0 e(long r2) {
        this.a = true;
        this.b = r2;
        return this;
    }

    public j0 h(long r4, TimeUnit r6) {
        Intrinsics.checkNotNullParameter(r6, "unit");
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.c = r6.toNanos(r4);
        return this;
    L10:
        throw new IllegalArgumentException(("timeout < 0: " + r4).toString());
    L5:
        r0 = false;
        goto L6
    }
}
