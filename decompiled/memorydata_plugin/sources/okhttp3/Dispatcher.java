package okhttp3;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0019\u0010 \u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000¢\u0006\u0002\b$J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b%J\u0016\u0010&\u001a\b\u0018\u00010\u001aR\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002J)\u0010)\u001a\u00020\u001f\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,2\u0006\u0010!\u001a\u0002H*H\u0002¢\u0006\u0002\u0010-J\u0015\u0010)\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001bH\u0000¢\u0006\u0002\b.J\u0019\u0010)\u001a\u00020\u001f2\n\u0010!\u001a\u00060\u001aR\u00020\u001bH\u0000¢\u0006\u0002\b.J\b\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00104\u001a\u00020\u0010J\f\u00105\u001a\b\u0012\u0004\u0012\u00020302J\u0006\u00106\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u001aR\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lokhttp3/Dispatcher;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Ljava/util/concurrent/ExecutorService;)V", "()V", "()Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "<set-?>", "Ljava/lang/Runnable;", "idleCallback", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "maxRequests", "", "getMaxRequests", "()I", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "Lokhttp3/RealCall$AsyncCall;", "Lokhttp3/RealCall;", "runningAsyncCalls", "runningSyncCalls", "cancelAll", "", "enqueue", NotificationCompat.CATEGORY_CALL, "enqueue$okhttp", "executed", "executed$okhttp", "-deprecated_executorService", "findExistingCallWithHost", "host", "", "finished", ExifInterface.GPS_DIRECTION_TRUE, "calls", "Ljava/util/Deque;", "(Ljava/util/Deque;Ljava/lang/Object;)V", "finished$okhttp", "promoteAndExecute", "", "queuedCalls", "", "Lokhttp3/Call;", "queuedCallsCount", "runningCalls", "runningCallsCount", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    public Dispatcher(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "executorService");
        this();
        this.executorServiceOrNull = r4;
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String r5) {
        Iterator<RealCall.AsyncCall> r0 = this.runningAsyncCalls.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        RealCall.AsyncCall r1 = (RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r0.next(), RealCall.AsyncCall.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r1.host(), r5) == false) goto L4;
        return r1;
    L8:
        Iterator<RealCall.AsyncCall> r4 = this.readyAsyncCalls.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        RealCall.AsyncCall r2 = (RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r4.next(), RealCall.AsyncCall.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2.host(), r5) == false) goto L10;
        return r2;
    L14:
        return null;
    }

    private final <T> void finished(Deque<T> r3, T r4) {
        Deque r5 = (Deque) ZeusTransformUtils.wrapperContextForParams(r3, Deque.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r5.remove(r4) == false) goto L14;
        Runnable r6 = this.idleCallback;     // Catch: Throwable -> L15
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        if (promoteAndExecute() == true) goto L19;
        if (r6 == null) goto L20;
        r6.run();
        return;
    L20:
        return;
    L19:
        return;
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("Call wasn't in-flight!"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    }

    private final boolean promoteAndExecute() {
        Thread.holdsLock(this);
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        Iterator<RealCall.AsyncCall> r1 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L24
        Intrinsics.checkExpressionValueIsNotNull(r1, "readyAsyncCalls.iterator()");     // Catch: Throwable -> L24
    L6:
        if (r1.hasNext() == false) goto L14;
        RealCall.AsyncCall r2 = (RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r1.next(), RealCall.AsyncCall.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (this.runningAsyncCalls.size() >= this.maxRequests) goto L14;
        if (r2.callsPerHost().get() >= this.maxRequestsPerHost) goto L6;
        r1.remove();     // Catch: Throwable -> L24
        r2.callsPerHost().incrementAndGet();     // Catch: Throwable -> L24
        Intrinsics.checkExpressionValueIsNotNull(r2, "asyncCall");     // Catch: Throwable -> L24
        r0.add(r2);     // Catch: Throwable -> L24
        this.runningAsyncCalls.add(r2);     // Catch: Throwable -> L24
    L14:
        int r3 = 0;
        if (runningCallsCount() <= 0) goto L17;
        boolean r4 = true;
    L18:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(this);
        int r6 = r0.size();
    L21:
        if (r3 >= r6) goto L23;
        ((RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r0.get(r3), RealCall.AsyncCall.class, "com.obric.memorydata.plugin")).executeOn(executorService());
        r3 = r3 + 1;
        goto L21
    L23:
        return r4;
    L17:
        r4 = false;
    L24:
        th = move-exception;
        throw th;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "executorService", imports = {}))
    /* JADX INFO: renamed from: -deprecated_executorService, reason: not valid java name */
    public final ExecutorService m2952deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        monitor-enter(this);
        Iterator<RealCall.AsyncCall> r0 = this.readyAsyncCalls.iterator();     // Catch: Throwable -> L18
    L5:
        if (r0.hasNext() == false) goto L7;
        ((RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r0.next(), RealCall.AsyncCall.class, "com.obric.memorydata.plugin")).get().cancel();     // Catch: Throwable -> L18
        goto L5
    L7:
        Iterator<RealCall.AsyncCall> r1 = this.runningAsyncCalls.iterator();     // Catch: Throwable -> L18
    L9:
        if (r1.hasNext() == false) goto L11;
        ((RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r1.next(), RealCall.AsyncCall.class, "com.obric.memorydata.plugin")).get().cancel();     // Catch: Throwable -> L18
        goto L9
    L11:
        Iterator<RealCall> r2 = this.runningSyncCalls.iterator();     // Catch: Throwable -> L18
    L12:
        if (r2.hasNext() == false) goto L16;
        ((RealCall) ZeusTransformUtils.preCheckCast(r2.next(), RealCall.class, "com.obric.memorydata.plugin")).cancel();     // Catch: Throwable -> L18
        goto L12
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void enqueue$okhttp(RealCall.AsyncCall r2) {
        Intrinsics.checkParameterIsNotNull(r2, NotificationCompat.CATEGORY_CALL);
        monitor-enter(this);
        this.readyAsyncCalls.add(r2);     // Catch: Throwable -> L13
        if (r2.get().getForWebSocket() == true) goto L9;
        RealCall.AsyncCall r0 = findExistingCallWithHost(r2.host());     // Catch: Throwable -> L13
        if (r0 == null) goto L9;
        r2.reuseCallsPerHostFrom(r0);     // Catch: Throwable -> L13
    L9:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        promoteAndExecute();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void executed$okhttp(RealCall r2) {
        monitor-enter(this);
        Intrinsics.checkParameterIsNotNull(r2, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L6
        this.runningSyncCalls.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized ExecutorService executorService() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.executorServiceOrNull != null) goto L6;
        this.executorServiceOrNull = (ExecutorService) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new SynchronousQueue(), BlockingQueue.class, "com.obric.memorydata.plugin"), Util.threadFactory("OkHttp Dispatcher", false)), ExecutorService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L6:
        ExecutorService r0 = this.executorServiceOrNull;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        Intrinsics.throwNpe();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r0;
    }

    public final void finished$okhttp(RealCall.AsyncCall r4) {
        Intrinsics.checkParameterIsNotNull(r4, NotificationCompat.CATEGORY_CALL);
        r4.callsPerHost().decrementAndGet();
        finished((Deque) ZeusTransformUtils.preCheckCast(this.runningAsyncCalls, Deque.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void finished$okhttp(RealCall r4) {
        Intrinsics.checkParameterIsNotNull(r4, NotificationCompat.CATEGORY_CALL);
        finished((Deque) ZeusTransformUtils.preCheckCast(this.runningSyncCalls, Deque.class, "com.obric.memorydata.plugin"), r4);
    }

    public final synchronized Runnable getIdleCallback() {
        monitor-enter(this);
        Runnable r0 = this.idleCallback;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int getMaxRequests() {
        monitor-enter(this);
        int r0 = this.maxRequests;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int getMaxRequestsPerHost() {
        monitor-enter(this);
        int r0 = this.maxRequestsPerHost;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Call> queuedCalls() {
        monitor-enter(this);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.readyAsyncCalls, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Iterator r2 = r0.iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L7;
        r1.add(((RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r2.next(), RealCall.AsyncCall.class, "com.obric.memorydata.plugin")).get());     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Call> r3 = Collections.unmodifiableList((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        Intrinsics.checkExpressionValueIsNotNull(r3, "Collections.unmodifiable…ncCalls.map { it.get() })");     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized int queuedCallsCount() {
        monitor-enter(this);
        int r0 = this.readyAsyncCalls.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized List<Call> runningCalls() {
        monitor-enter(this);
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(this.runningSyncCalls, Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.runningAsyncCalls, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L10
    L5:
        if (r3.hasNext() == false) goto L7;
        r2.add(((RealCall.AsyncCall) ZeusTransformUtils.preCheckCast(r3.next(), RealCall.AsyncCall.class, "com.obric.memorydata.plugin")).get());     // Catch: Throwable -> L10
        goto L5
    L7:
        List<Call> r4 = Collections.unmodifiableList(CollectionsKt.plus(r0, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
        Intrinsics.checkExpressionValueIsNotNull(r4, "Collections.unmodifiable…ncCalls.map { it.get() })");     // Catch: Throwable -> L10
        monitor-exit(this);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized int runningCallsCount() {
        monitor-enter(this);
        int r0 = this.runningAsyncCalls.size() + this.runningSyncCalls.size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void setIdleCallback(Runnable r3) {
        monitor-enter(this);
        this.idleCallback = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setMaxRequests(int r2) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L16;
        monitor-enter(this);
        this.maxRequests = r2;     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        promoteAndExecute();
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("max < 1: " + r2).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void setMaxRequestsPerHost(int r2) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L16;
        monitor-enter(this);
        this.maxRequestsPerHost = r2;     // Catch: Throwable -> L12
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        promoteAndExecute();
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("max < 1: " + r2).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
