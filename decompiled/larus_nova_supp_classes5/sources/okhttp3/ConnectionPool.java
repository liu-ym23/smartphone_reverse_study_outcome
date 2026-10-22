package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import hvc.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.connection.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ConnectionPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Executor executor = null;
    private final Runnable cleanupRunnable;
    boolean cleanupRunning;
    private final Deque<d> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    final okhttp3.internal.connection.e routeDatabase;

    public class a implements Runnable {
        public final /* synthetic */ ConnectionPool a;

        @Override // java.lang.Runnable
        public final void run() {
        L25:
            long r0 = this.a.cleanup(System.nanoTime());     // Catch: Throwable -> L19
            if (r0 == (-1)) goto L22;
            if (r0 <= 0) goto L25;
            long r4 = r0 / 1000000;     // Catch: Throwable -> L19
            Long.signum(r4);
            long r1 = r0 - (1000000 * r4);
            ConnectionPool r2 = this.a;     // Catch: Throwable -> L19
            monitor-enter(r2);     // Catch: Throwable -> L19
            this.a.wait(r4, (int) r1);     // Catch: Throwable -> L13 InterruptedException -> L24
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L15:
            monitor-exit(r2);     // Catch: Throwable -> L13
            goto L25
        L22:
            return;
        L19:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L34;
            throw th;
        }

        public a(ConnectionPool r1) {
            this.a = r1;
        }
    }

    public synchronized int connectionCount() {
        monitor-enter(this);
        int r0 = this.connections.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int idleConnectionCount() {
        monitor-enter(this);
        Iterator<d> r0 = this.connections.iterator();     // Catch: Throwable -> L11
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L9;
        if (((ArrayList) r0.next().n).isEmpty() == false) goto L5;
        r1 = r1 + 1;
        goto L5
    L9:
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    static {
        TimeUnit r6 = TimeUnit.SECONDS;
        SynchronousQueue r7 = new SynchronousQueue();
        byte[] r1 = cvc.c.a;
        executor = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r6, r7, new cvc.d("OkHttp ConnectionPool", true));
    }

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public void evictAll() {
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator<d> r1 = this.connections.iterator();     // Catch: Throwable -> L16
    L6:
        if (r1.hasNext() == false) goto L10;
        d r2 = r1.next();     // Catch: Throwable -> L16
        if (((ArrayList) r2.n).isEmpty() == false) goto L6;
        r2.k = true;     // Catch: Throwable -> L16
        r0.add(r2);     // Catch: Throwable -> L16
        r1.remove();     // Catch: Throwable -> L16
        goto L6
    L10:
        monitor-exit(this);     // Catch: Throwable -> L16
        Iterator r3 = r0.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        cvc.c.f(((d) r3.next()).e);
        goto L13
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public long cleanup(long r12) {
        monitor-enter(this);
        Iterator<d> r0 = this.connections.iterator();     // Catch: Throwable -> L32
        d r2 = null;
        long r3 = Long.MIN_VALUE;
        int r5 = 0;
        int r6 = 0;
    L5:
        if (r0.hasNext() == false) goto L12;
        d r7 = r0.next();     // Catch: Throwable -> L32
        if (pruneAndGetAllocationCount(r7, r12) > 0) goto L8;
        r5 = r5 + 1;     // Catch: Throwable -> L32
        long r8 = r12 - r7.o;     // Catch: Throwable -> L32
        if (r8 <= r3) goto L5;
        r2 = r7;
        r3 = r8;
        goto L5
    L8:
        r6 = r6 + 1;     // Catch: Throwable -> L32
        goto L5
    L12:
        long r13 = this.keepAliveDurationNs;     // Catch: Throwable -> L32
        if (r3 < r13) goto L15;
    L28:
        this.connections.remove(r2);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        cvc.c.f(r2.e);
        return 0;
    L15:
        if (r5 > this.maxIdleConnections) goto L28;
        if (r5 <= 0) goto L21;
        long r14 = r13 - r3;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return r14;
    L21:
        if (r6 <= 0) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L32
        return r13;
    L24:
        this.cleanupRunning = false;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return -1;
    L32:
        th = move-exception;
        throw th;
    }

    public boolean connectionBecameIdle(d r2) {
        if (r2.k == false) goto L5;
    L9:
        this.connections.remove(r2);
        return true;
    L5:
        if (this.maxIdleConnections == 0) goto L9;
        notifyAll();
        return false;
    }

    public void put(d r3) {
        if (this.cleanupRunning == true) goto L5;
        this.cleanupRunning = true;
        executor.execute(this.cleanupRunnable);
    L5:
        this.connections.add(r3);
    }

    private int pruneAndGetAllocationCount(d r8, long r9) {
        List r0 = r8.n;
        int r2 = 0;
    L3:
        ArrayList r3 = (ArrayList) r0;
        if (r2 >= r3.size()) goto L13;
        StreamAllocation.a r4 = (Reference) ListProtector.get(r3, r2);
        if (r4.get() != null) goto L7;
        g.a.n("A connection to " + r8.c.address().a + " was leaked. Did you forget to close a response body?", r4.a);
        ListProtector.remove(r3, r2);
        r8.k = true;
        if (r3.isEmpty() == false) goto L3;
        r8.o = r9 - this.keepAliveDurationNs;
        return 0;
    L7:
        r2 = r2 + 1;
        goto L3
    L13:
        return r3.size();
    }

    @Nullable
    public Socket deduplicate(okhttp3.a r4, StreamAllocation r5) {
        Iterator<d> r0 = this.connections.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        d r1 = r0.next();
        if (r1.g(r4, null) == false) goto L4;
        if (r1.h == null) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L4;
        if (r1 == r5.connection()) goto L4;
        return r5.releaseAndAcquire(r1);
    L10:
        r2 = false;
        goto L11
    L16:
        return null;
    }

    public ConnectionPool(int r3, long r4, TimeUnit r6) {
        this.cleanupRunnable = new a(this);
        this.connections = new ArrayDeque();
        this.routeDatabase = new okhttp3.internal.connection.e();
        this.maxIdleConnections = r3;
        this.keepAliveDurationNs = r6.toNanos(r4);
        if (r4 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + r4);
    }

    @Nullable
    public d get(okhttp3.a r4, StreamAllocation r5, Route r6) {
        Iterator<d> r0 = this.connections.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        d r1 = r0.next();
        if (r1.g(r4, r6) == false) goto L4;
        r5.acquire(r1, true);
        return r1;
    L9:
        return null;
    }
}
