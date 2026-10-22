package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.a;
import okhttp3.e0;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.w;
import okhttp3.x0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ?\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u0017\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u0015\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)J\u0015\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010:R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010>R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010?¨\u0006@"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/a;", "address", "Lokhttp3/internal/connection/RealCall;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/w;", "eventListener", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/a;Lokhttp3/internal/connection/RealCall;Lokhttp3/w;)V", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lokhttp3/internal/connection/RealConnection;", "findHealthyConnection", "(IIIIZZ)Lokhttp3/internal/connection/RealConnection;", "findConnection", "(IIIIZ)Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/x0;", "retryRoute", "()Lokhttp3/x0;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "find", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "Ljava/io/IOException;", "e", "", "trackFailure", "(Ljava/io/IOException;)V", "retryAfterFailure", "()Z", "Lokhttp3/e0;", "url", "sameHostAndPort", "(Lokhttp3/e0;)Z", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "Lokhttp3/internal/connection/RouteSelector;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "refusedStreamCount", "I", "connectionShutdownCount", "otherFailureCount", "nextRouteToTry", "Lokhttp3/x0;", "Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/a;", "getAddress$okhttp", "()Lokhttp3/a;", "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/w;", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ExchangeFinder {
    private final a address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final w eventListener;
    private x0 nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool r5, a r10, RealCall r11, w r12) {
        Intrinsics.checkNotNullParameter(r5, "connectionPool");
        Intrinsics.checkNotNullParameter(r10, "address");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r12, "eventListener");
        this.connectionPool = r5;
        this.address = r10;
        this.call = r11;
        this.eventListener = r12;
    }

    private final RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) throws IOException {
        if (this.call.isCanceled() == true) goto L72;
        RealConnection r5 = this.call.getConnection();
        if (r5 == null) goto L29;
        monitor-enter(r5);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (r5.getNoNewExchanges() == false) goto L10;
    L15:
        Socket r10 = this.call.releaseConnectionNoEvents$okhttp();     // Catch: Throwable -> L13
    L16:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r5);
        if (this.call.getConnection() == null) goto L24;
        if (r10 != null) goto L23;
        return r5;
    L23:
        throw new IllegalStateException("Check failed.");
    L24:
        if (r10 == null) goto L26;
        Util.closeQuietly(r10);
    L26:
        this.eventListener.c(this.call, r5);
        goto L29
    L10:
        if (sameHostAndPort(r5.route().f20764a.f20610a) == false) goto L15;
        r10 = null;
    L29:
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false) == false) goto L33;
        RealConnection r12 = this.call.getConnection();
        Intrinsics.checkNotNull(r12);
        this.eventListener.b(this.call, r12);
        return r12;
    L33:
        x0 r13 = this.nextRouteToTry;
        if (r13 == null) goto L37;
        Intrinsics.checkNotNull(r13);
        this.nextRouteToTry = null;
    L36:
        List<x0> r14 = null;
    L52:
        RealConnection r110 = new RealConnection(this.connectionPool, r13);
        this.call.setConnectionToCancel(r110);
        r110.connect(r15, r16, r17, r18, r19, this.call, this.eventListener);     // Catch: Throwable -> L66
        this.call.setConnectionToCancel(null);
        this.call.getClient().B.connected(r110.route());
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, r14, true) == false) goto L58;
        RealConnection r20 = this.call.getConnection();
        Intrinsics.checkNotNull(r20);
        this.nextRouteToTry = r13;
        Util.closeQuietly(r110.socket());
        this.eventListener.b(this.call, r20);
        return r20;
    L58:
        monitor-enter(r110);
        this.connectionPool.put(r110);     // Catch: Throwable -> L63
        this.call.acquireConnectionNoEvents(r110);     // Catch: Throwable -> L63
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r110);
        this.eventListener.b(this.call, r110);
        return r110;
    L63:
        th = move-exception;
        throw th;
    L66:
        th = move-exception;
        this.call.setConnectionToCancel(null);
        throw th;
    L37:
        RouteSelector.Selection r22 = this.routeSelection;
        if (r22 == null) goto L42;
        Intrinsics.checkNotNull(r22);
        if (r22.hasNext() == false) goto L42;
        RouteSelector.Selection r23 = this.routeSelection;
        Intrinsics.checkNotNull(r23);
        r13 = r23.next();
    L42:
        RouteSelector r24 = this.routeSelector;
        if (r24 != null) goto L45;
        r24 = new RouteSelector(this.address, this.call.getClient().B, this.call, this.eventListener);
        this.routeSelector = r24;
    L45:
        RouteSelector.Selection r25 = r24.next();
        this.routeSelection = r25;
        r14 = r25.getRoutes();
        if (this.call.isCanceled() == true) goto L70;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, r14, false) == false) goto L51;
        RealConnection r26 = this.call.getConnection();
        Intrinsics.checkNotNull(r26);
        this.eventListener.b(this.call, r26);
        return r26;
    L51:
        r13 = r25.next();
        goto L52
    L70:
        throw new IOException("Canceled");
    L72:
        throw new IOException("Canceled");
    }

    private final RealConnection findHealthyConnection(int r5, int r10, int r11, int r12, boolean r13, boolean r14) throws IOException {
    L2:
        RealConnection r15 = findConnection(r5, r10, r11, r12, r13);
        if (r15.isHealthy(r14) == true) goto L4;
        r15.noNewExchanges$okhttp();
        if (this.nextRouteToTry != null) goto L2;
        RouteSelector.Selection r16 = this.routeSelection;
        boolean r17 = true;
        if (r16 == null) goto L11;
        boolean r18 = r16.hasNext();
    L12:
        if (r18 == true) goto L2;
        RouteSelector r19 = this.routeSelector;
        if (r19 == null) goto L17;
        r17 = r19.hasNext();
    L17:
        if (r17 == true) goto L2;
        throw new IOException("exhausted all routes");
    L11:
        r18 = true;
        goto L12
    L4:
        return r15;
    }

    private final x0 retryRoute() {
        if (this.refusedStreamCount <= 1) goto L5;
    L26:
        return null;
    L5:
        if (this.connectionShutdownCount > 1) goto L26;
        if (this.otherFailureCount > 0) goto L26;
        RealConnection r5 = this.call.getConnection();
        if (r5 == null) goto L26;
        monitor-enter(r5);
    L23:
        th = move-exception;
        throw th;
    L13:
        if (r5.getRouteFailureCount$okhttp() == 0) goto L17;
        monitor-exit(r5);
        return null;
    L17:
        if (Util.canReuseConnectionFor(r5.route().f20764a.f20610a, this.address.f20610a) == true) goto L20;
        monitor-exit(r5);
        return null;
    L20:
        x0 r10 = r5.route();     // Catch: Throwable -> L23
        monitor-exit(r5);
        return r10;
    }

    public final ExchangeCodec find(OkHttpClient r10, RealInterceptorChain r11) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "chain");
        int r5 = r11.getConnectTimeoutMillis$okhttp();     // Catch: IOException -> L5 RouteException -> L7
        int r12 = r11.getReadTimeoutMillis$okhttp();     // Catch: IOException -> L5 RouteException -> L7
        int r13 = r11.getWriteTimeoutMillis$okhttp();     // Catch: IOException -> L5 RouteException -> L7
        r10.getClass();     // Catch: IOException -> L5 RouteException -> L7
        return findHealthyConnection(r5, r12, r13, 0, r10.f, !Intrinsics.areEqual(r11.getRequest$okhttp().method(), "GET")).newCodec$okhttp(r10, r11);
    L5:
        e = move-exception;
        trackFailure(e);
        throw new RouteException(e);
    L7:
        e = move-exception;
        trackFailure(e.getLastConnectException());
        throw e;
    }

    public final a getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        if (this.refusedStreamCount != 0) goto L11;
        if (this.connectionShutdownCount != 0) goto L11;
        if (this.otherFailureCount != 0) goto L11;
        return false;
    L11:
        if (this.nextRouteToTry == null) goto L13;
        return true;
    L13:
        x0 r5 = retryRoute();
        if (r5 == null) goto L17;
        this.nextRouteToTry = r5;
        return true;
    L17:
        RouteSelector.Selection r10 = this.routeSelection;
        if (r10 != null) goto L20;
    L22:
        RouteSelector r11 = this.routeSelector;
        if (r11 != null) goto L25;
        return true;
    L25:
        return r11.hasNext();
    L20:
        if (r10.hasNext() != true) goto L22;
        return true;
    }

    public final boolean sameHostAndPort(e0 r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        e0 r10 = this.address.f20610a;
        if (r5.f == r10.f) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r5.e, r10.e) == false) goto L7;
        return true;
    }

    public final void trackFailure(IOException r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        this.nextRouteToTry = null;
        if ((r5 instanceof StreamResetException) == false) goto L8;
        if (((StreamResetException) r5).errorCode != ErrorCode.REFUSED_STREAM) goto L8;
        this.refusedStreamCount++;
        return;
    L8:
        if ((r5 instanceof ConnectionShutdownException) == false) goto L10;
        this.connectionShutdownCount++;
        return;
    L10:
        this.otherFailureCount++;
    }
}
