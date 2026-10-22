package okhttp3.internal.connection;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import evc.c;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.l;
import okhttp3.ttnet.TTConfigManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final okhttp3.a address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private int canceledReason;
    private c codec;
    private d connection;
    private final ConnectionPool connectionPool;
    public final i eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private f.a routeSelection;
    private final f routeSelector;

    public synchronized d connection() {
        monitor-enter(this);
        d r0 = this.connection;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private Socket releaseIfNoNewStreams() {
        d r0 = this.connection;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.k == true) goto L7;
        return null;
    L7:
        return deallocate(false, false, true);
    }

    private e routeDatabase() {
        return cvc.a.a.b(this.connectionPool);
    }

    public c codec() {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        c r1 = this.codec;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasMoreRoutes() {
        if (this.route != null) goto L12;
        f.a r0 = this.routeSelection;
        if (r0 == null) goto L9;
        if (r0.a() == true) goto L12;
    L9:
        if (this.routeSelector.b() == true) goto L12;
        return false;
    L12:
        return true;
    }

    public void noNewStreams() {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        Connection r1 = this.connection;     // Catch: Throwable -> L12
        Socket r2 = deallocate(true, false, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r1 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        cvc.c.f(r2);
        if (r1 == null) goto L17;
        this.eventListener.connectionReleased(this.call, r1);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void release() {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        Connection r1 = this.connection;     // Catch: Throwable -> L12
        Socket r2 = deallocate(false, true, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r1 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        cvc.c.f(r2);
        if (r1 == null) goto L17;
        OkHttpClient.a r3 = cvc.a.a;
        Call r4 = this.call;
        r3.getClass();
        ((l) r4).d(null);
        this.eventListener.connectionReleased(this.call, r1);
        this.eventListener.callEnd(this.call);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public String toString() {
        d r0 = connection();
        if (r0 == null) goto L6;
        return r0.toString();
    L6:
        return this.address.toString();
    }

    static {
    }

    public Route route() {
        return this.route;
    }

    private void release(d r4) {
        int r0 = ((ArrayList) r4.n).size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        if (((Reference) ListProtector.get(r4.n, r1)).get() == this) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        ListProtector.remove(r4.n, r1);
        return;
    L10:
        throw new IllegalStateException();
    }

    public void cancel(int r3) {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.canceled = true;     // Catch: Throwable -> L12
        this.canceledReason = r3;     // Catch: Throwable -> L12
        c r4 = this.codec;     // Catch: Throwable -> L12
        d r1 = this.connection;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        r4.cancel();
        return;
    L9:
        if (r1 == null) goto L18;
        cvc.c.f(r1.d);
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public Socket releaseAndAcquire(d r4) {
        if (this.codec != null) goto L9;
        if (((ArrayList) this.connection.n).size() != 1) goto L9;
        Reference r0 = (Reference) ListProtector.get(this.connection.n, 0);
        Socket r1 = deallocate(true, false, false);
        this.connection = r4;
        ((ArrayList) r4.n).add(r0);
        return r1;
    L9:
        throw new IllegalStateException();
    }

    public void resetRouteSelector(int r4) {
        f r0 = this.routeSelector;
        okhttp3.a r1 = r0.a;
        r0.d(r1.a, r1.h);
        r0.i.clear();
        ((ArrayList) r0.j).clear();
        r0.e = r4;
        r0.f = null;
        this.routeSelection = null;
    }

    public void streamFailed(IOException r7) {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        Connection r4 = null;
        if ((r7 instanceof StreamResetException) == false) goto L14;
        ErrorCode r8 = ((StreamResetException) r7).errorCode;     // Catch: Throwable -> L31
        if (r8 != ErrorCode.REFUSED_STREAM) goto L12;
        int r9 = this.refusedStreamCount + 1;     // Catch: Throwable -> L31
        this.refusedStreamCount = r9;     // Catch: Throwable -> L31
        if (r9 <= 1) goto L33;
        this.route = null;     // Catch: Throwable -> L31
    L30:
        boolean r10 = true;
    L34:
        Connection r1 = this.connection;     // Catch: Throwable -> L31
        Socket r11 = deallocate(r10, false, true);     // Catch: Throwable -> L31
        if (this.connection == null) goto L37;
    L40:
        monitor-exit(r0);     // Catch: Throwable -> L31
        cvc.c.f(r11);
        if (r4 == null) goto L49;
        this.eventListener.connectionReleased(this.call, r4);
        return;
    L49:
        return;
    L37:
        if (this.reportedAcquired == false) goto L40;
        r4 = r1;
    L33:
        r10 = false;
        goto L34
    L12:
        if (r8 == ErrorCode.CANCEL) goto L33;
        this.route = null;     // Catch: Throwable -> L31
        goto L30
    L14:
        d r2 = this.connection;     // Catch: Throwable -> L31
        if (r2 == null) goto L33;
        if (r2.h == null) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L24;
        if ((r7 instanceof ConnectionShutdownException) == false) goto L33;
    L24:
        if (r2.l != 0) goto L30;
        Route r3 = this.route;     // Catch: Throwable -> L31
        if (r3 == null) goto L29;
        if (r7 == null) goto L29;
        this.routeSelector.a(r3, r7);     // Catch: Throwable -> L31
    L29:
        this.route = null;     // Catch: Throwable -> L31
        goto L30
    L19:
        r5 = false;
    L31:
        th = move-exception;
        throw th;
    }

    public void acquire(d r2, boolean r3) {
        if (this.connection != null) goto L7;
        this.connection = r2;
        this.reportedAcquired = r3;
        List r4 = r2.n;
        ArrayList r5 = (ArrayList) r4;
        r5.add(new a(this, this.callStackTrace));
        return;
    L7:
        throw new IllegalStateException();
    }

    private Socket deallocate(boolean r2, boolean r3, boolean r4) {
        if (r4 == false) goto L6;
        this.codec = null;
    L6:
        if (r3 == false) goto L8;
        this.released = true;
    L8:
        d r5 = this.connection;
        if (r5 == null) goto L26;
        if (r2 == false) goto L13;
        r5.k = true;
    L13:
        if (this.codec == null) goto L15;
        return null;
    L15:
        if (this.released == false) goto L17;
    L18:
        release(r5);
        if (((ArrayList) this.connection.n).isEmpty() == false) goto L23;
        this.connection.o = System.nanoTime();
        OkHttpClient.a r6 = cvc.a.a;
        ConnectionPool r7 = this.connectionPool;
        d r8 = this.connection;
        r6.getClass();
        if (r7.connectionBecameIdle(r8) == false) goto L23;
        Socket r9 = this.connection.e;
    L24:
        this.connection = null;
        return r9;
    L23:
        r9 = null;
        goto L24
    L17:
        if (r5.k == true) goto L18;
        return null;
    L26:
        return null;
    }

    public c newStream(OkHttpClient r8, Interceptor.Chain r9, boolean r10) {
        int r1 = r9.connectTimeoutMillis();
        int r2 = r9.readTimeoutMillis();
        int r3 = r9.writeTimeoutMillis();
        int r0 = r8.pingIntervalMillis();
        Call r4 = this.call;
        if (r4 == null) goto L23;
        if (r4.request() == null) goto L23;
        if (this.call.request().url() == null) goto L23;
        if (this.call.request().url().host() == null) goto L23;
        r0 = r8.pingIntervalMillisWithHostPort(this.call.request().url().host(), this.call.request().url().port());
    L23:
        c r11 = findHealthyConnection(r1, r2, r3, r0, r8.retryOnConnectionFailure(), r10).i(r8, r9, this);     // Catch: IOException -> L20
        ConnectionPool r12 = this.connectionPool;     // Catch: IOException -> L20
        monitor-enter(r12);     // Catch: IOException -> L20
        this.codec = r11;     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r11;
    L17:
        th = move-exception;
        throw th;     // Catch: IOException -> L20
    L20:
        e = move-exception;
        throw new RouteException(e);
    }

    public void streamFinished(boolean r4, c r5, long r6, IOException r8) {
        this.eventListener.responseBodyEnd(this.call, r6);
        ConnectionPool r7 = this.connectionPool;
        monitor-enter(r7);
        if (r5 == null) goto L24;
    L25:
        th = move-exception;
        throw th;
    L6:
        if (r5 != this.codec) goto L24;
        if (r4 == true) goto L10;
        this.connection.l++;     // Catch: Throwable -> L25
    L10:
        Connection r9 = this.connection;     // Catch: Throwable -> L25
        Socket r10 = deallocate(r4, false, true);     // Catch: Throwable -> L25
        if (this.connection == null) goto L13;
        r9 = null;
    L13:
        boolean r11 = this.released;     // Catch: Throwable -> L25
        monitor-exit(r7);     // Catch: Throwable -> L25
        cvc.c.f(r10);
        if (r9 == null) goto L18;
        this.eventListener.connectionReleased(this.call, r9);
    L18:
        if (r8 == null) goto L20;
        OkHttpClient.a r12 = cvc.a.a;
        Call r13 = this.call;
        r12.getClass();
        this.eventListener.callFailed(this.call, ((l) r13).d(r8));
        return;
    L20:
        if (r11 == false) goto L30;
        OkHttpClient.a r14 = cvc.a.a;
        Call r15 = this.call;
        r14.getClass();
        ((l) r15).d(null);
        this.eventListener.callEnd(this.call);
        return;
    L30:
        return;
    L24:
        throw new IllegalStateException("expected " + this.codec + " but was " + r5);     // Catch: Throwable -> L25
    }

    public StreamAllocation(ConnectionPool r2, okhttp3.a r3, Call r4, i r5, Object r6) {
        this.canceledReason = -1;
        this.connectionPool = r2;
        this.address = r3;
        this.call = r4;
        this.eventListener = r5;
        this.routeSelector = new f(r3, routeDatabase(), r4, r5);
        this.callStackTrace = r6;
    }

    private d findConnection(int r20, int r21, int r22, int r23, boolean r24) throws IOException {
        ConnectionPool r3 = this.connectionPool;
        monitor-enter(r3);
    L108:
        th = move-exception;
        throw th;
    L5:
        if (this.released == true) goto L107;
        if (this.codec != null) goto L105;
        if (this.canceled == true) goto L103;
        Connection r2 = this.connection;     // Catch: Throwable -> L108
        Socket r4 = releaseIfNoNewStreams();     // Catch: Throwable -> L108
        d r5 = this.connection;     // Catch: Throwable -> L108
        Socket r6 = null;
        if (r5 == null) goto L13;
        r2 = null;
    L15:
        if (this.reportedAcquired == true) goto L17;
        r2 = null;
    L17:
        boolean r7 = false;
        if (r5 != null) goto L23;
        OkHttpClient.a r9 = cvc.a.a;     // Catch: Throwable -> L108
        ConnectionPool r10 = this.connectionPool;     // Catch: Throwable -> L108
        okhttp3.a r11 = this.address;     // Catch: Throwable -> L108
        r9.getClass();     // Catch: Throwable -> L108
        r10.get(r11, this, null);     // Catch: Throwable -> L108
        d r12 = this.connection;     // Catch: Throwable -> L108
        if (r12 == null) goto L22;
        r5 = r12;
        boolean r13 = true;
        Route r14 = null;
    L25:
        monitor-exit(r3);     // Catch: Throwable -> L108
        cvc.c.f(r4);
        if (r2 == null) goto L29;
        this.eventListener.connectionReleased(this.call, r2);
    L29:
        if (r13 == false) goto L31;
        this.eventListener.connectionAcquired(this.call, r5);
    L31:
        if (r5 == null) goto L34;
        this.route = this.connection.c;
        return r5;
    L34:
        if (r14 != null) goto L45;
        f.a r8 = this.routeSelection;
        if (r8 != null) goto L38;
    L39:
        this.routeSelection = this.routeSelector.c();
        if (TTConfigManager.inst().getReconnctTimeout() > 0) goto L42;
    L43:
        this.routeSelection.c = false;
    L44:
        boolean r15 = true;
    L46:
        ConnectionPool r16 = this.connectionPool;
        monitor-enter(r16);
    L99:
        th = move-exception;
        throw th;
    L49:
        if (this.canceled == true) goto L98;
        if (r15 == false) goto L57;
        f.a r0 = this.routeSelection;     // Catch: Throwable -> L99
        r0.getClass();     // Catch: Throwable -> L99
        ArrayList r17 = new ArrayList(r0.a);     // Catch: Throwable -> L99
        int r1 = r17.size();     // Catch: Throwable -> L99
        int r18 = 0;
    L52:
        if (r18 >= r1) goto L57;
        Route r19 = (Route) r17.get(r18);     // Catch: Throwable -> L99
        OkHttpClient.a r110 = cvc.a.a;     // Catch: Throwable -> L99
        ConnectionPool r111 = this.connectionPool;     // Catch: Throwable -> L99
        okhttp3.a r112 = this.address;     // Catch: Throwable -> L99
        r110.getClass();     // Catch: Throwable -> L99
        r111.get(r112, this, r19);     // Catch: Throwable -> L99
        d r113 = this.connection;     // Catch: Throwable -> L99
        if (r113 != null) goto L55;
        r18 = r18 + 1;     // Catch: Throwable -> L99
        goto L52
    L55:
        this.route = r19;     // Catch: Throwable -> L99
        r5 = r113;
        r13 = true;
    L57:
        if (r13 == true) goto L65;
        if (r14 != null) goto L64;
        f.a r25 = this.routeSelection;     // Catch: Throwable -> L99
        if (r25.a() == false) goto L63;
        List r26 = r25.a;     // Catch: Throwable -> L99
        int r27 = r25.b;     // Catch: Throwable -> L99
        r25.b = r27 + 1;     // Catch: Throwable -> L99
        r14 = (Route) ListProtector.get(r26, r27);     // Catch: Throwable -> L99
        goto L64
    L63:
        throw new NoSuchElementException();     // Catch: Throwable -> L99
    L64:
        this.route = r14;     // Catch: Throwable -> L99
        this.refusedStreamCount = 0;     // Catch: Throwable -> L99
        r5 = new d(this.connectionPool, r14);     // Catch: Throwable -> L99
        acquire(r5, false);     // Catch: Throwable -> L99
    L65:
        monitor-exit(r16);     // Catch: Throwable -> L99
        if (r13 == false) goto L69;
        this.eventListener.connectionAcquired(this.call, r5);
        return r5;
    L69:
        f.a r28 = this.routeSelection;
        if (r28 != null) goto L72;
    L74:
        int r29 = r20;
    L76:
        if (this.routeSelection == null) goto L78;
    L84:
        r5.c(r29, r21, r22, r23, r24, this.call, this.eventListener);
        routeDatabase().a(r5.c);
        ConnectionPool r30 = this.connectionPool;
        monitor-enter(r30);
        this.reportedAcquired = true;     // Catch: Throwable -> L94
        OkHttpClient.a r31 = cvc.a.a;     // Catch: Throwable -> L94
        ConnectionPool r32 = this.connectionPool;     // Catch: Throwable -> L94
        r31.getClass();     // Catch: Throwable -> L94
        r32.put(r5);     // Catch: Throwable -> L94
        if (r5.h == null) goto L89;
        r7 = true;
    L89:
        if (r7 == false) goto L91;
        OkHttpClient.a r33 = cvc.a.a;     // Catch: Throwable -> L94
        ConnectionPool r34 = this.connectionPool;     // Catch: Throwable -> L94
        okhttp3.a r35 = this.address;     // Catch: Throwable -> L94
        r33.getClass();     // Catch: Throwable -> L94
        r6 = r34.deduplicate(r35, this);     // Catch: Throwable -> L94
        r5 = this.connection;     // Catch: Throwable -> L94
    L91:
        monitor-exit(r30);     // Catch: Throwable -> L94
        cvc.c.f(r6);
        this.eventListener.connectionAcquired(this.call, r5);
        return r5;
    L94:
        th = move-exception;
        throw th;
    L78:
        if (this.route == null) goto L84;
        if (TTConfigManager.inst().isIpReconnQuickTestEnable() == false) goto L84;
        if (TTConfigManager.inst().getReconnctTimeout() <= 0) goto L84;
        r29 = TTConfigManager.inst().getReconnctTimeout();
        goto L84
    L72:
        if (r28.c == false) goto L74;
        r29 = TTConfigManager.inst().getReconnctTimeout();
        goto L76
    L98:
        throw new IOException("Canceled#Reason=" + this.canceledReason);     // Catch: Throwable -> L99
    L42:
        if (TTConfigManager.inst().isIpReconnQuickTestEnable() == true) goto L44;
    L38:
        if (r8.a() == false) goto L39;
    L45:
        r15 = false;
        goto L46
    L22:
        r14 = this.route;     // Catch: Throwable -> L108
    L24:
        r13 = false;
        goto L25
    L23:
        r14 = null;
        goto L24
    L13:
        r5 = null;
        goto L15
    L103:
        throw new IOException("Canceled#Reason=" + this.canceledReason);     // Catch: Throwable -> L108
    L105:
        throw new IllegalStateException("codec != null");     // Catch: Throwable -> L108
    L107:
        throw new IllegalStateException("released");     // Catch: Throwable -> L108
    }

    private d findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws IOException {
    L2:
        d r0 = findConnection(r4, r5, r6, r7, r8);
        ConnectionPool r1 = this.connectionPool;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r0.l == 0) goto L7;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (r0.h(r9) == true) goto L19;
        noNewStreams();
        goto L2
    L19:
        return r0;
    L7:
        if (r0.h == null) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r0;
    L9:
        r2 = false;
        goto L10
    }
}
