package okhttp3.internal.connection;

import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\n\u0018\u0000 12\u00020\u0001:\u00011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020\u0003J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0014J.\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010/2\u0006\u00100\u001a\u00020\rR\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool;", "", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(IJLjava/util/concurrent/TimeUnit;)V", "cleanupRunnable", "okhttp3/internal/connection/RealConnectionPool$cleanupRunnable$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupRunnable$1;", "cleanupRunning", "", "getCleanupRunning", "()Z", "setCleanupRunning", "(Z)V", "connections", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", SlardarSettingsConstants.SETTING_GENERAL_CLEANUP, "now", "connectFailed", "", "failedRoute", "Lokhttp3/Route;", "failure", "Ljava/io/IOException;", "connectionBecameIdle", WsConstants.KEY_CONNECTION, "connectionCount", "evictAll", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "transmitterAcquirePooledConnection", MemoryKeyInfoEntity.KEY_ADDRESS, "Lokhttp3/Address;", "transmitter", "Lokhttp3/internal/connection/Transmitter;", "routes", "", "requireMultiplexed", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class RealConnectionPool {
    public static final Companion Companion = null;
    private static final ThreadPoolExecutor executor = null;
    private final RealConnectionPool$cleanupRunnable$1 cleanupRunnable;
    private boolean cleanupRunning;
    private final ArrayDeque<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    private final RouteDatabase routeDatabase;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool r1) {
            Intrinsics.checkParameterIsNotNull(r1, "connectionPool");
            return r1.getDelegate$okhttp();
        }
    }

    static {
        Companion = new Companion(null);
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new SynchronousQueue(), BlockingQueue.class, "com.obric.memorydata.plugin"), Util.threadFactory("OkHttp ConnectionPool", true));
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [okhttp3.internal.connection.RealConnectionPool$cleanupRunnable$1] */
    public RealConnectionPool(int r3, long r4, TimeUnit r6) {
        Intrinsics.checkParameterIsNotNull(r6, "timeUnit");
        this.maxIdleConnections = r3;
        this.keepAliveDurationNs = r6.toNanos(r4);
        this.cleanupRunnable = new RealConnectionPool$cleanupRunnable$1(this);
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        if (r4 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return;
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("keepAliveDuration <= 0: " + r4).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L6
    }

    private final int pruneAndGetAllocationCount(RealConnection r7, long r8) {
        List<Reference<Transmitter>> r0 = r7.getTransmitters();
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L16;
        Reference r3 = (Reference) ZeusTransformUtils.preCheckCast(r0.get(r2), Reference.class, "com.obric.memorydata.plugin");
        if (r3.get() != null) goto L7;
        if (r3 == null) goto L14;
        Transmitter.TransmitterReference r4 = (Transmitter.TransmitterReference) ZeusTransformUtils.preCheckCast(r3, Transmitter.TransmitterReference.class, "com.obric.memorydata.plugin");
        Platform.Companion.get().logCloseableLeak("A connection to " + r7.route().address().url() + " was leaked. Did you forget to close a response body?", r4.getCallStackTrace());
        r0.remove(r2);
        r7.setNoNewExchanges(true);
        if (r0.isEmpty() == false) goto L4;
        r7.setIdleAtNanos$okhttp(r8 - this.keepAliveDurationNs);
        return 0;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.connection.Transmitter.TransmitterReference");
    L7:
        r2 = r2 + 1;
        goto L4
    L16:
        return r0.size();
    }

    public final long cleanup(long r12) {
        RealConnection r0 = (RealConnection) ZeusTransformUtils.preCheckCast(null, RealConnection.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        Iterator<RealConnection> r1 = this.connections.iterator();     // Catch: Throwable -> L32
        long r3 = Long.MIN_VALUE;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r1.hasNext() == false) goto L13;
        RealConnection r7 = (RealConnection) ZeusTransformUtils.preCheckCast(r1.next(), RealConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        Intrinsics.checkExpressionValueIsNotNull(r7, WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L32
        if (pruneAndGetAllocationCount(r7, r12) > 0) goto L9;
        r5 = r5 + 1;     // Catch: Throwable -> L32
        long r8 = r12 - r7.getIdleAtNanos$okhttp();     // Catch: Throwable -> L32
        if (r8 <= r3) goto L6;
        r0 = r7;
        r3 = r8;
        goto L6
    L9:
        r6 = r6 + 1;     // Catch: Throwable -> L32
        goto L6
    L13:
        long r13 = this.keepAliveDurationNs;     // Catch: Throwable -> L32
        if (r3 < r13) goto L16;
    L26:
        this.connections.remove(r0);     // Catch: Throwable -> L32
        monitor-exit(this);
        if (r0 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        Util.closeQuietly(r0.socket());
        return 0;
    L16:
        if (r5 > this.maxIdleConnections) goto L26;
        if (r5 <= 0) goto L22;
        long r14 = r13 - r3;
    L20:
        monitor-exit(this);
        return r14;
    L22:
        if (r6 <= 0) goto L25;
        monitor-exit(this);
        return r13;
    L25:
        this.cleanupRunning = false;     // Catch: Throwable -> L32
        r14 = -1;
    L32:
        th = move-exception;
        throw th;
    }

    public final void connectFailed(Route r4, IOException r5) {
        Intrinsics.checkParameterIsNotNull(r4, "failedRoute");
        Intrinsics.checkParameterIsNotNull(r5, "failure");
        if (r4.proxy().type() == Proxy.Type.DIRECT) goto L5;
        Address r0 = r4.address();
        r0.proxySelector().connectFailed(r0.url().uri(), r4.proxy().address(), r5);
    L5:
        this.routeDatabase.failed(r4);
    }

    public final boolean connectionBecameIdle(RealConnection r2) {
        Intrinsics.checkParameterIsNotNull(r2, WsConstants.KEY_CONNECTION);
        Thread.holdsLock(this);
        if (r2.getNoNewExchanges() == false) goto L5;
    L8:
        this.connections.remove(r2);
        return true;
    L5:
        if (this.maxIdleConnections == 0) goto L8;
        ZeusTransformUtils.preCheckCast(this, Object.class, "com.obric.memorydata.plugin").notifyAll();
        return false;
    }

    public final synchronized int connectionCount() {
        monitor-enter(this);
        int r0 = this.connections.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void evictAll() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        Iterator<RealConnection> r1 = this.connections.iterator();     // Catch: Throwable -> L17
        Intrinsics.checkExpressionValueIsNotNull(r1, "connections.iterator()");     // Catch: Throwable -> L17
    L6:
        if (r1.hasNext() == false) goto L10;
        RealConnection r2 = (RealConnection) ZeusTransformUtils.preCheckCast(r1.next(), RealConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r2.getTransmitters().isEmpty() == false) goto L6;
        r2.setNoNewExchanges(true);     // Catch: Throwable -> L17
        Intrinsics.checkExpressionValueIsNotNull(r2, WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L17
        r0.add(r2);     // Catch: Throwable -> L17
        r1.remove();     // Catch: Throwable -> L17
        goto L6
    L10:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        Iterator r5 = r0.iterator();
    L14:
        if (r5.hasNext() == false) goto L16;
        Util.closeQuietly(((RealConnection) ZeusTransformUtils.preCheckCast(r5.next(), RealConnection.class, "com.obric.memorydata.plugin")).socket());
        goto L14
    L16:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean getCleanupRunning() {
        return this.cleanupRunning;
    }

    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    public final synchronized int idleConnectionCount() {
        monitor-enter(this);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.connections, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L6;
    L8:
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L19
    L9:
        if (r1.hasNext() == false) goto L17;
        if (((RealConnection) ZeusTransformUtils.preCheckCast(r1.next(), RealConnection.class, "com.obric.memorydata.plugin")).getTransmitters().isEmpty() == false) goto L9;
        r2 = r2 + 1;     // Catch: Throwable -> L19
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return r2;
    L6:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L8;
    L19:
        th = move-exception;
        throw th;
    }

    public final void put(RealConnection r5) {
        Intrinsics.checkParameterIsNotNull(r5, WsConstants.KEY_CONNECTION);
        Thread.holdsLock(this);
        if (this.cleanupRunning == true) goto L5;
        this.cleanupRunning = true;
        executor.execute((Runnable) ZeusTransformUtils.preCheckCast(this.cleanupRunnable, Runnable.class, "com.obric.memorydata.plugin"));
    L5:
        this.connections.add(r5);
    }

    public final void setCleanupRunning(boolean r1) {
        this.cleanupRunning = r1;
    }

    public final boolean transmitterAcquirePooledConnection(Address r4, Transmitter r5, List<Route> r6, boolean r7) {
        List<Route> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, MemoryKeyInfoEntity.KEY_ADDRESS);
        Intrinsics.checkParameterIsNotNull(r5, "transmitter");
        Thread.holdsLock(this);
        Iterator<RealConnection> r3 = this.connections.iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        RealConnection r0 = (RealConnection) ZeusTransformUtils.preCheckCast(r3.next(), RealConnection.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L11;
        if (r0.isMultiplexed() == false) goto L4;
    L11:
        if (r0.isEligible$okhttp(r4, r8) == false) goto L4;
        Intrinsics.checkExpressionValueIsNotNull(r0, WsConstants.KEY_CONNECTION);
        r5.acquireConnectionNoEvents(r0);
        return true;
    L15:
        return false;
    }
}
