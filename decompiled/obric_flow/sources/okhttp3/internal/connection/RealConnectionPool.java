package okhttp3.internal.connection;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okhttp3.o;
import okhttp3.x0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001-\u0018\u0000 42\u00020\u0001:\u00014B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0012J5\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u001f¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\f008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00103¨\u00065"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "Lokhttp3/internal/connection/RealConnection;", WsConstants.KEY_CONNECTION, "now", "pruneAndGetAllocationCount", "(Lokhttp3/internal/connection/RealConnection;J)I", "idleConnectionCount", "()I", "connectionCount", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "", "Lokhttp3/x0;", "routes", "", "requireMultiplexed", "callAcquirePooledConnection", "(Lokhttp3/a;Lokhttp3/internal/connection/RealCall;Ljava/util/List;Z)Z", "", "put", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionBecameIdle", "(Lokhttp3/internal/connection/RealConnection;)Z", "evictAll", "()V", "cleanup", "(J)J", "keepAliveDurationNs", "J", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "I", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealConnectionPool {
    public static final Companion Companion = null;
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "<init>", "()V", "Lokhttp3/o;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "get", "(Lokhttp3/o;)Lokhttp3/internal/connection/RealConnectionPool;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final RealConnectionPool get(o r5) {
            Intrinsics.checkNotNullParameter(r5, "connectionPool");
            return r5.f20716a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner r5, int r10, long r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r5, "taskRunner");
        Intrinsics.checkNotNullParameter(r12, "timeUnit");
        this.maxIdleConnections = r10;
        this.keepAliveDurationNs = r12.toNanos(r11);
        this.cleanupQueue = r5.newQueue();
        final String r13 = j0.q(new StringBuilder(), Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new RealConnectionPool$cleanupTask$1(this, r13);
        this.connections = new ConcurrentLinkedQueue();
        if (r11 <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(a.j(r11, "keepAliveDuration <= 0: ").toString());
    L5:
        r14 = false;
        goto L6
    }

    private final int pruneAndGetAllocationCount(RealConnection r10, long r11) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        List<Reference<RealCall>> r5 = r10.getCalls();
        int r12 = 0;
    L11:
        if (r12 >= r5.size()) goto L20;
        Reference<RealCall> r13 = r5.get(r12);
        if (r13.get() != null) goto L14;
        Platform.Companion.get().logCloseableLeak("A connection to " + r10.route().f20764a.f20610a + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) r13).getCallStackTrace());
        r5.remove(r12);
        r10.setNoNewExchanges(true);
        if (r5.isEmpty() == false) goto L11;
        r10.setIdleAtNs$okhttp(r11 - this.keepAliveDurationNs);
        return 0;
    L14:
        r12 = r12 + 1;
        goto L11
    L20:
        return r5.size();
    L5:
        if (Thread.holdsLock(r10) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    }

    public final boolean callAcquirePooledConnection(okhttp3.a r5, RealCall r10, List<x0> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "address");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);
        Iterator<RealConnection> r13 = this.connections.iterator();
    L4:
        if (r13.hasNext() == false) goto L24;
        RealConnection r14 = r13.next();
        monitor-enter(r14);
        if (r12 == false) goto L14;
    L11:
        th = move-exception;
        throw th;
    L9:
        if (r14.isMultiplexed$okhttp() == true) goto L14;
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r14);
    L14:
        if (r14.isEligible$okhttp(r5, r11) == false) goto L15;
        r10.acquireConnectionNoEvents(r14);     // Catch: Throwable -> L11
        monitor-exit(r14);
        return true;
    L24:
        return false;
    }

    public final long cleanup(long r12) {
        Iterator<RealConnection> r5 = this.connections.iterator();
        int r10 = 0;
        long r11 = Long.MIN_VALUE;
        RealConnection r13 = null;
        int r14 = 0;
    L4:
        if (r5.hasNext() == false) goto L20;
        RealConnection r15 = r5.next();
        monitor-enter(r15);
        if (pruneAndGetAllocationCount(r15, r12) <= 0) goto L10;
        r14 = r14 + 1;     // Catch: Throwable -> L13
    L16:
        monitor-exit(r15);
        goto L4
    L10:
        r10 = r10 + 1;     // Catch: Throwable -> L13
        long r16 = r12 - r15.getIdleAtNs$okhttp();     // Catch: Throwable -> L13
        if (r16 <= r11) goto L15;
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r13 = r15;
        r11 = r16;
        goto L16
    L15:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L20:
        long r19 = this.keepAliveDurationNs;
        if (r11 < r19) goto L23;
    L32:
        Intrinsics.checkNotNull(r13);
        monitor-enter(r13);
    L50:
        th = move-exception;
        throw th;
    L36:
        if (r13.getCalls().isEmpty() == true) goto L41;
        monitor-exit(r13);
        return 0;
    L41:
        if ((r13.getIdleAtNs$okhttp() + r11) == r12) goto L44;
        monitor-exit(r13);
        return 0;
    L44:
        r13.setNoNewExchanges(true);     // Catch: Throwable -> L50
        this.connections.remove(r13);     // Catch: Throwable -> L50
        monitor-exit(r13);
        Util.closeQuietly(r13.socket());
        if (this.connections.isEmpty() == false) goto L49;
        this.cleanupQueue.cancelAll();
    L49:
        return 0;
    L23:
        if (r10 > this.maxIdleConnections) goto L32;
        if (r10 > 0) goto L27;
        if (r14 <= 0) goto L30;
        return r19;
    L30:
        return -1;
    L27:
        return r19 - r11;
    }

    public final boolean connectionBecameIdle(RealConnection r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(r10) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    L10:
        if (r10.getNoNewExchanges() == false) goto L12;
    L15:
        r10.setNoNewExchanges(true);
        this.connections.remove(r10);
        if (this.connections.isEmpty() == false) goto L19;
        this.cleanupQueue.cancelAll();
    L19:
        return true;
    L12:
        if (this.maxIdleConnections == 0) goto L15;
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        return false;
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Iterator<RealConnection> r5 = this.connections.iterator();
    L4:
        if (r5.hasNext() == false) goto L20;
        RealConnection r10 = r5.next();
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (r10.getCalls().isEmpty() == false) goto L13;
        r5.remove();     // Catch: Throwable -> L11
        r10.setNoNewExchanges(true);     // Catch: Throwable -> L11
        Socket r11 = r10.socket();     // Catch: Throwable -> L11
    L14:
        monitor-exit(r10);
        if (r11 == null) goto L4;
        Util.closeQuietly(r11);
        goto L4
    L13:
        r11 = null;
        goto L14
    L20:
        if (this.connections.isEmpty() == false) goto L30;
        this.cleanupQueue.cancelAll();
        return;
    }

    public final int idleConnectionCount() {
        ConcurrentLinkedQueue<RealConnection> r5 = this.connections;
        int r10 = 0;
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r11 = r5.iterator();
    L9:
        if (r11.hasNext() == false) goto L21;
        RealConnection r12 = (RealConnection) r11.next();
        monitor-enter(r12);
        boolean r13 = r12.getCalls().isEmpty();     // Catch: Throwable -> L18
        monitor-exit(r12);
        if (r13 == false) goto L9;
        r10 = r10 + 1;
        if (r10 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L18:
        th = move-exception;
        throw th;
    L21:
        return r10;
    L5:
        if (r5.isEmpty() == false) goto L7;
        goto L7
    }

    public final void put(RealConnection r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        this.connections.add(r10);
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        return;
    L5:
        if (Thread.holdsLock(r10) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r10);
    }
}
