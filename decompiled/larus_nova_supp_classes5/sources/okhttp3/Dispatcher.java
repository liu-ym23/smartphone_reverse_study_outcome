package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import cvc.d;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private ExecutorService executorService;

    @Nullable
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final Deque<l.b> readyAsyncCalls;
    private final Deque<l.b> runningAsyncCalls;
    private final Deque<l> runningSyncCalls;

    public synchronized void cancelAll() {
        monitor-enter(this);
        Iterator<l.b> r0 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L18
    L5:
        if (r0.hasNext() == false) goto L7;
        r0.next().c.a(-1);     // Catch: Throwable -> L18
        goto L5
    L7:
        Iterator<l.b> r1 = this.runningAsyncCalls.iterator();     // Catch: Throwable -> L18
    L9:
        if (r1.hasNext() == false) goto L11;
        r1.next().c.a(-1);     // Catch: Throwable -> L18
        goto L9
    L11:
        Iterator<l> r2 = this.runningSyncCalls.iterator();     // Catch: Throwable -> L18
    L12:
        if (r2.hasNext() == false) goto L16;
        r2.next().a(-1);     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized ExecutorService executorService() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.executorService != null) goto L6;
        TimeUnit r6 = TimeUnit.SECONDS;     // Catch: Throwable -> L9
        SynchronousQueue r7 = new SynchronousQueue();     // Catch: Throwable -> L9
        byte[] r8 = cvc.c.a;     // Catch: Throwable -> L9
        this.executorService = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, r6, r7, new d("OkHttp Dispatcher", false));     // Catch: Throwable -> L9
    L6:
        ExecutorService r0 = this.executorService;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized int getMaxRequests() {
        monitor-enter(this);
        int r0 = this.maxRequests;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getMaxRequestsPerHost() {
        monitor-enter(this);
        int r0 = this.maxRequestsPerHost;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<Call> queuedCalls() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<l.b> r1 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.add(r1.next().c);     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Call> r2 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized int queuedCallsCount() {
        monitor-enter(this);
        int r0 = this.readyAsyncCalls.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<Call> runningCalls() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L10
        r0.addAll(this.runningSyncCalls);     // Catch: Throwable -> L10
        Iterator<l.b> r1 = this.runningAsyncCalls.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L7;
        r0.add(r1.next().c);     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Call> r2 = Collections.unmodifiableList(r0);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized int runningCallsCount() {
        monitor-enter(this);
        int r0 = this.runningAsyncCalls.size() + this.runningSyncCalls.size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean promoteAndExecute() {
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator<l.b> r1 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L33
    L6:
        if (r1.hasNext() == false) goto L14;
        l.b r2 = r1.next();     // Catch: Throwable -> L33
        if (this.runningAsyncCalls.size() >= this.maxRequests) goto L14;
        if (runningCallsForHost(r2) >= this.maxRequestsPerHost) goto L6;
        r1.remove();     // Catch: Throwable -> L33
        r0.add(r2);     // Catch: Throwable -> L33
        this.runningAsyncCalls.add(r2);     // Catch: Throwable -> L33
    L14:
        int r3 = 0;
        if (runningCallsCount() <= 0) goto L17;
        boolean r4 = true;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L33
        int r5 = r0.size();
    L20:
        if (r3 >= r5) goto L32;
        l.b r6 = (l.b) ListProtector.get(r0, r3);
        ExecutorService r7 = executorService();
        r6.getClass();
        r7.execute(r6);     // Catch: Throwable -> L24 RejectedExecutionException -> L26
    L29:
        r3 = r3 + 1;
    L26:
        e = move-exception;
        InterruptedIOException r8 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L24
        r8.initCause(e);     // Catch: Throwable -> L24
        r6.c.d.callFailed(r6.c, r8);     // Catch: Throwable -> L24
        r6.b.onFailure(r6.c, r8);     // Catch: Throwable -> L24
        r6.c.a.dispatcher().finished(r6);
    L24:
        th = move-exception;
        r6.c.a.dispatcher().finished(r6);
        throw th;
    L32:
        return r4;
    L17:
        r4 = false;
    L33:
        th = move-exception;
        throw th;
    }

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    static {
    }

    public Dispatcher(ExecutorService r2) {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
        this.executorService = r2;
    }

    private int runningCallsForHost(l.b r5) {
        Iterator<l.b> r0 = this.runningAsyncCalls.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L11;
        l r2 = r0.next().c;
        if (r2.f == true) goto L4;
        if (r2.e.url().host().equals(r5.c.e.url().host()) == false) goto L4;
        r1 = r1 + 1;
        goto L4
    L11:
        return r1;
    }

    public void enqueue(l.b r2) {
        monitor-enter(this);
        this.readyAsyncCalls.add(r2);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        promoteAndExecute();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void executed(l r2) {
        monitor-enter(this);
        this.runningSyncCalls.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void finished(l.b r2) {
        finished(this.runningAsyncCalls, r2);
    }

    public synchronized void setIdleCallback(@Nullable Runnable r1) {
        monitor-enter(this);
        this.idleCallback = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setMaxRequests(int r4) {
        if (r4 < 1) goto L13;
        monitor-enter(this);
        this.maxRequests = r4;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        promoteAndExecute();
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("max < 1: " + r4);
    }

    public void setMaxRequestsPerHost(int r4) {
        if (r4 < 1) goto L13;
        monitor-enter(this);
        this.maxRequestsPerHost = r4;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        promoteAndExecute();
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("max < 1: " + r4);
    }

    public void finished(l r2) {
        finished(this.runningSyncCalls, r2);
    }

    private <T> void finished(Deque<T> r1, T r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r1.remove(r2) == false) goto L13;
        Runnable r3 = this.idleCallback;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (promoteAndExecute() == true) goto L18;
        if (r3 == null) goto L19;
        r3.run();
        return;
    L19:
        return;
    L18:
        return;
    L13:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L14
    }
}
