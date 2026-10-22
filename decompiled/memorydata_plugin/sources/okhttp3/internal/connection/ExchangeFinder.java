package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010J0\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0010H\u0002J8\u0010%\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\u0006\u0010&\u001a\u00020\u0010J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010'\u001a\u00020\u0010H\u0002J\u0006\u0010(\u001a\u00020)R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "transmitter", "Lokhttp3/internal/connection/Transmitter;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", MemoryKeyInfoEntity.KEY_ADDRESS, "Lokhttp3/Address;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/Transmitter;Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/Call;Lokhttp3/EventListener;)V", "connectingConnection", "Lokhttp3/internal/connection/RealConnection;", "hasStreamFailure", "", "nextRouteToTry", "Lokhttp3/Route;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/Interceptor$Chain;", "doExtensiveHealthChecks", "findConnection", "connectTimeout", "", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "findHealthyConnection", "hasRouteToTry", "retryCurrentRoute", "trackFailure", "", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class ExchangeFinder {
    private final Address address;
    private final Call call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private boolean hasStreamFailure;
    private Route nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;
    private final Transmitter transmitter;

    public ExchangeFinder(Transmitter r3, RealConnectionPool r4, Address r5, Call r6, EventListener r7) {
        Call r8 = (Call) ZeusTransformUtils.wrapperContextForParams(r6, Call.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "transmitter");
        Intrinsics.checkParameterIsNotNull(r4, "connectionPool");
        Intrinsics.checkParameterIsNotNull(r5, MemoryKeyInfoEntity.KEY_ADDRESS);
        Intrinsics.checkParameterIsNotNull(r8, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(r7, "eventListener");
        this.transmitter = r3;
        this.connectionPool = r4;
        this.address = r5;
        this.call = r8;
        this.eventListener = r7;
        this.routeSelector = new RouteSelector(r5, r4.getRouteDatabase(), r8, r7);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [T, okhttp3.internal.connection.RealConnection] */
    /* JADX WARN: Type inference failed for: r8v5, types: [T, okhttp3.internal.connection.RealConnection] */
    private final RealConnection findConnection(int r19, int r20, int r21, int r22, boolean r23) {
        RealConnection r1 = (RealConnection) ZeusTransformUtils.preCheckCast(null, RealConnection.class, "com.obric.memorydata.plugin");
        Route r2 = (Route) ZeusTransformUtils.preCheckCast(null, Route.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        RealConnectionPool r5 = this.connectionPool;
        monitor-enter(r5);
    L135:
        th = move-exception;
        throw th;
    L5:
        if (this.transmitter.isCanceled() == true) goto L134;
        this.hasStreamFailure = false;     // Catch: Throwable -> L135
        r4.element = this.transmitter.getConnection();     // Catch: Throwable -> L135
        if (this.transmitter.getConnection() == null) goto L14;
        RealConnection r7 = this.transmitter.getConnection();     // Catch: Throwable -> L135
        if (r7 != null) goto L12;
        Intrinsics.throwNpe();     // Catch: Throwable -> L135
    L12:
        if (r7.getNoNewExchanges() == false) goto L14;
        Socket r8 = this.transmitter.releaseConnectionNoEvents();     // Catch: Throwable -> L135
    L16:
        if (this.transmitter.getConnection() == null) goto L19;
        r1 = this.transmitter.getConnection();     // Catch: Throwable -> L135
        r4.element = (RealConnection) ZeusTransformUtils.preCheckCast(null, RealConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L135
    L19:
        if (r1 == null) goto L21;
    L32:
        boolean r9 = false;
    L33:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L135
        monitor-exit(r5);
        if (r8 == null) goto L38;
        Util.closeQuietly(r8);
    L38:
        if (((RealConnection) ZeusTransformUtils.preCheckCast(r4.element, RealConnection.class, "com.obric.memorydata.plugin")) == null) goto L43;
        EventListener r6 = this.eventListener;
        Call r11 = this.call;
        RealConnection r12 = (RealConnection) ZeusTransformUtils.preCheckCast(r4.element, RealConnection.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        r6.connectionReleased(r11, (Connection) ZeusTransformUtils.preCheckCast(r12, Connection.class, "com.obric.memorydata.plugin"));
    L43:
        if (r9 == false) goto L48;
        EventListener r13 = this.eventListener;
        Call r14 = this.call;
        if (r1 != null) goto L47;
        Intrinsics.throwNpe();
    L47:
        r13.connectionAcquired(r14, (Connection) ZeusTransformUtils.preCheckCast(r1, Connection.class, "com.obric.memorydata.plugin"));
    L48:
        if (r1 == null) goto L52;
        if (r1 != null) goto L51;
        Intrinsics.throwNpe();
    L51:
        return r1;
    L52:
        if (r2 != null) goto L60;
        RouteSelector.Selection r15 = this.routeSelection;
        if (r15 == null) goto L59;
        if (r15 != null) goto L58;
        Intrinsics.throwNpe();
    L58:
        if (r15.hasNext() == true) goto L60;
    L59:
        this.routeSelection = this.routeSelector.next();
        boolean r16 = true;
    L61:
        List<Route> r17 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
        RealConnectionPool r18 = this.connectionPool;
        monitor-enter(r18);
    L130:
        th = move-exception;
        throw th;
    L64:
        if (this.transmitter.isCanceled() == true) goto L129;
        if (r16 == false) goto L72;
        RouteSelector.Selection r24 = this.routeSelection;     // Catch: Throwable -> L130
        if (r24 != null) goto L69;
        Intrinsics.throwNpe();     // Catch: Throwable -> L130
    L69:
        r17 = r24.getRoutes();     // Catch: Throwable -> L130
        if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, r17, false) == false) goto L72;
        r1 = this.transmitter.getConnection();     // Catch: Throwable -> L130
        r9 = true;
    L72:
        if (r9 == true) goto L82;
        if (r2 != null) goto L78;
        RouteSelector.Selection r3 = this.routeSelection;     // Catch: Throwable -> L130
        if (r3 != null) goto L77;
        Intrinsics.throwNpe();     // Catch: Throwable -> L130
    L77:
        r2 = r3.next();     // Catch: Throwable -> L130
    L78:
        RealConnectionPool r25 = this.connectionPool;     // Catch: Throwable -> L130
        if (r2 != null) goto L81;
        Intrinsics.throwNpe();     // Catch: Throwable -> L130
    L81:
        r1 = new RealConnection(r25, r2);     // Catch: Throwable -> L130
        this.connectingConnection = r1;     // Catch: Throwable -> L130
    L82:
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L130
        monitor-exit(r18);
        if (r9 == false) goto L92;
        EventListener r27 = this.eventListener;
        Call r0 = this.call;
        if (r1 != null) goto L88;
        Intrinsics.throwNpe();
    L88:
        r27.connectionAcquired(r0, (Connection) ZeusTransformUtils.preCheckCast(r1, Connection.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L91;
        Intrinsics.throwNpe();
    L91:
        return r1;
    L92:
        if (r1 != null) goto L94;
        Intrinsics.throwNpe();
    L94:
        r1.connect(r19, r20, r21, r22, r23, this.call, this.eventListener);
        RouteDatabase r28 = this.connectionPool.getRouteDatabase();
        if (r1 != null) goto L97;
        Intrinsics.throwNpe();
    L97:
        r28.connected(r1.route());
        Socket r29 = (Socket) ZeusTransformUtils.preCheckCast(null, Socket.class, "com.obric.memorydata.plugin");
        RealConnectionPool r30 = this.connectionPool;
        monitor-enter(r30);
        this.connectingConnection = (RealConnection) ZeusTransformUtils.preCheckCast(null, RealConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L125
        if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, r17, true) == false) goto L107;
        if (r1 != null) goto L103;
        Intrinsics.throwNpe();     // Catch: Throwable -> L125
    L103:
        r1.setNoNewExchanges(true);     // Catch: Throwable -> L125
        if (r1 != null) goto L106;
        Intrinsics.throwNpe();     // Catch: Throwable -> L125
    L106:
        r29 = r1.socket();     // Catch: Throwable -> L125
        r1 = this.transmitter.getConnection();     // Catch: Throwable -> L125
        this.nextRouteToTry = r2;     // Catch: Throwable -> L125
    L114:
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L125
        monitor-exit(r30);
        if (r29 == null) goto L118;
        Util.closeQuietly(r29);
    L118:
        EventListener r32 = this.eventListener;
        Call r33 = this.call;
        if (r1 != null) goto L121;
        Intrinsics.throwNpe();
    L121:
        r32.connectionAcquired(r33, (Connection) ZeusTransformUtils.preCheckCast(r1, Connection.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L124;
        Intrinsics.throwNpe();
    L124:
        return r1;
    L107:
        RealConnectionPool r34 = this.connectionPool;     // Catch: Throwable -> L125
        if (r1 != null) goto L110;
        Intrinsics.throwNpe();     // Catch: Throwable -> L125
    L110:
        r34.put(r1);     // Catch: Throwable -> L125
        Transmitter r35 = this.transmitter;     // Catch: Throwable -> L125
        if (r1 != null) goto L113;
        Intrinsics.throwNpe();     // Catch: Throwable -> L125
    L113:
        r35.acquireConnectionNoEvents(r1);     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        throw th;
    L129:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Canceled"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
    L60:
        r16 = false;
        goto L61
    L21:
        if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, null, false) == false) goto L23;
        r1 = this.transmitter.getConnection();     // Catch: Throwable -> L135
        r9 = true;
        goto L33
    L23:
        Route r36 = this.nextRouteToTry;     // Catch: Throwable -> L135
        if (r36 == null) goto L27;
        this.nextRouteToTry = (Route) ZeusTransformUtils.preCheckCast(null, Route.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L135
        r2 = r36;
        goto L32
    L27:
        if (retryCurrentRoute() == false) goto L32;
        RealConnection r37 = this.transmitter.getConnection();     // Catch: Throwable -> L135
        if (r37 != null) goto L31;
        Intrinsics.throwNpe();     // Catch: Throwable -> L135
    L31:
        r2 = r37.route();     // Catch: Throwable -> L135
    L14:
        r8 = null;
        goto L16
    L134:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Canceled"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L135
    }

    private final RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) {
    L2:
        RealConnection r0 = findConnection(r4, r5, r6, r7, r8);
        RealConnectionPool r1 = this.connectionPool;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r0.getSuccessCount$okhttp() == 0) goto L6;
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r1);
        if (r0.isHealthy(r9) == true) goto L13;
        r0.noNewExchanges();
        goto L2
    L13:
        return r0;
    L6:
        monitor-exit(r1);
        return r0;
    }

    private final boolean retryCurrentRoute() {
        if (this.transmitter.getConnection() == null) goto L15;
        RealConnection r0 = this.transmitter.getConnection();
        if (r0 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        if (r0.getRouteFailureCount$okhttp() != 0) goto L15;
        RealConnection r1 = this.transmitter.getConnection();
        if (r1 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        if (Util.canReuseConnectionFor(r1.route().address().url(), this.address.url()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public final RealConnection connectingConnection() {
        Thread.holdsLock(this.connectionPool);
        return this.connectingConnection;
    }

    public final ExchangeCodec find(OkHttpClient r10, Interceptor.Chain r11, boolean r12) {
        Interceptor.Chain r13 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r11, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r10, "client");
        Intrinsics.checkParameterIsNotNull(r13, "chain");
        return findHealthyConnection(r13.connectTimeoutMillis(), r13.readTimeoutMillis(), r13.writeTimeoutMillis(), r10.pingIntervalMillis(), r10.retryOnConnectionFailure(), r12).newCodec$okhttp(r10, r13);
    L5:
        e = move-exception;
        trackFailure();
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RouteException(e), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        e = move-exception;
        trackFailure();
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final boolean hasRouteToTry() {
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L5:
        boolean r2 = true;
        if (this.nextRouteToTry == null) goto L10;
        monitor-exit(r0);
        return true;
    L10:
        if (retryCurrentRoute() == false) goto L17;
        RealConnection r1 = this.transmitter.getConnection();     // Catch: Throwable -> L28
        if (r1 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L28
    L14:
        this.nextRouteToTry = r1.route();     // Catch: Throwable -> L28
        monitor-exit(r0);
        return true;
    L17:
        RouteSelector.Selection r3 = this.routeSelection;     // Catch: Throwable -> L28
        if (r3 == null) goto L20;
        boolean r4 = r3.hasNext();     // Catch: Throwable -> L28
    L21:
        if (r4 == false) goto L23;
    L26:
        monitor-exit(r0);
        return r2;
    L23:
        if (this.routeSelector.hasNext() == true) goto L26;
        r2 = false;
        goto L26
    L20:
        r4 = false;
        goto L21
    }

    public final boolean hasStreamFailure() {
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        boolean r1 = this.hasStreamFailure;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void trackFailure() {
        Thread.holdsLock(this.connectionPool);
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.hasStreamFailure = true;     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
