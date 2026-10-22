package okhttp3.internal.connection;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 p2\u00020\u00012\u00020\u0002:\u0001pB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00105\u001a\u000206J>\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J(\u0010A\u001a\u0002062\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0002J0\u0010E\u001a\u0002062\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J*\u0010F\u001a\u0004\u0018\u00010G2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020GH\u0002J(\u0010L\u001a\u0002062\u0006\u0010C\u001a\u00020D2\u0006\u0010;\u001a\u00020\t2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J%\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020O2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010QH\u0000¢\u0006\u0002\bRJ\u000e\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u0017J\u001d\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J\u0015\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0000¢\u0006\u0002\b`J\u0006\u0010\u0019\u001a\u000206J\u0010\u0010a\u001a\u0002062\u0006\u0010b\u001a\u00020\u000fH\u0016J\u0010\u0010c\u001a\u0002062\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010f\u001a\u00020\u00172\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00060QH\u0002J\b\u0010)\u001a\u00020 H\u0016J\u0010\u0010h\u001a\u0002062\u0006\u0010;\u001a\u00020\tH\u0002J\u000e\u0010i\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JJ\b\u0010j\u001a\u00020kH\u0016J\u0017\u0010l\u001a\u0002062\b\u0010m\u001a\u0004\u0018\u00010nH\u0000¢\u0006\u0002\boR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006q"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "allocationLimit", "", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "handshake", "Lokhttp3/Handshake;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "idleAtNanos", "", "getIdleAtNanos$okhttp", "()J", "setIdleAtNanos$okhttp", "(J)V", "isMultiplexed", "", "()Z", "noNewExchanges", "getNoNewExchanges", "setNoNewExchanges", "(Z)V", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "refusedStreamCount", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "sink", "Lokio/BufferedSink;", "socket", AILabCheckPermissionTask.KEY_SOURCE, "Lokio/BufferedSource;", "successCount", "getSuccessCount$okhttp", "setSuccessCount$okhttp", "transmitters", "", "Ljava/lang/ref/Reference;", "Lokhttp3/internal/connection/Transmitter;", "getTransmitters", "()Ljava/util/List;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "connect", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "connectSocket", "connectTls", "connectionSpecSelector", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectTunnel", "createTunnel", "Lokhttp3/Request;", "tunnelRequest", "url", "Lokhttp3/HttpUrl;", "createTunnelRequest", "establishProtocol", "isEligible", MemoryKeyInfoEntity.KEY_ADDRESS, "Lokhttp3/Address;", "routes", "", "isEligible$okhttp", "isHealthy", "doExtensiveChecks", "newCodec", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/Interceptor$Chain;", "newCodec$okhttp", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "exchange", "Lokhttp3/internal/connection/Exchange;", "newWebSocketStreams$okhttp", "onSettings", WsConstants.KEY_CONNECTION, "onStream", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Lokhttp3/internal/http2/Http2Stream;", "routeMatchesAny", "candidates", "startHttp2", "supportsUrl", "toString", "", "trackFailure", "e", "Ljava/io/IOException;", "trackFailure$okhttp", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = null;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;
    private final RealConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNanos;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    private int successCount;
    private final List<Reference<Transmitter>> transmitters;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "()V", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNanos", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final RealConnection newTestConnection(RealConnectionPool r1, Route r2, Socket r3, long r4) {
            Intrinsics.checkParameterIsNotNull(r1, "connectionPool");
            Intrinsics.checkParameterIsNotNull(r2, "route");
            Intrinsics.checkParameterIsNotNull(r3, "socket");
            RealConnection r0 = new RealConnection(r1, r2);
            RealConnection.access$setSocket$p(r0, r3);
            r0.setIdleAtNanos$okhttp(r4);
            return r0;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Proxy.Type.DIRECT.ordinal()] = 1;
            r0[Proxy.Type.HTTP.ordinal()] = 2;
            int[] r1 = new int[ErrorCode.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[ErrorCode.REFUSED_STREAM.ordinal()] = 1;
            r1[ErrorCode.CANCEL.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RealConnection(RealConnectionPool r2, Route r3) {
        Intrinsics.checkParameterIsNotNull(r2, "connectionPool");
        Intrinsics.checkParameterIsNotNull(r3, "route");
        this.connectionPool = r2;
        this.route = r3;
        this.allocationLimit = 1;
        this.transmitters = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.idleAtNanos = Long.MAX_VALUE;
    }

    public static final /* synthetic */ Handshake access$getHandshake$p(RealConnection r0) {
        return r0.handshake;
    }

    public static final /* synthetic */ Socket access$getSocket$p(RealConnection r0) {
        return r0.socket;
    }

    public static final /* synthetic */ void access$setHandshake$p(RealConnection r0, Handshake r1) {
        r0.handshake = r1;
    }

    public static final /* synthetic */ void access$setSocket$p(RealConnection r0, Socket r1) {
        r0.socket = r1;
    }

    private final void connectSocket(int r6, int r7, Call r8, EventListener r9) {
        Call r10 = (Call) ZeusTransformUtils.wrapperContextForParams(r8, Call.class, "com.obric.memorydata.plugin");
        Proxy r0 = this.route.proxy();
        Address r2 = this.route.address();
        Proxy.Type r3 = r0.type();
        if (r3 == null) goto L9;
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r4 != 1) goto L8;
    L10:
        Socket r5 = r2.socketFactory().createSocket();
        if (r5 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        this.rawSocket = r5;
        r9.connectStart(r10, this.route.socketAddress(), r0);
        r5.setSoTimeout(r7);
        Platform.Companion.get().connectSocket(r5, this.route.socketAddress(), r6);     // Catch: ConnectException -> L23
        this.source = Okio.buffer(Okio.source(r5));     // Catch: NullPointerException -> L17
        this.sink = Okio.buffer(Okio.sink(r5));     // Catch: NullPointerException -> L17
        return;
    L17:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), NPE_THROW_WITH_NULL) == true) goto L22;
        return;
    L22:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L23:
        e = move-exception;
        ConnectException r11 = new ConnectException("Failed to connect to " + this.route.socketAddress());
        r11.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        if (r4 == 2) goto L10;
    L9:
        r5 = new Socket(r0);
        goto L13
    }

    private final void connectTls(ConnectionSpecSelector r12) {
        final Address r0 = this.route.address();
        SSLSocketFactory r1 = r0.sslSocketFactory();
        String r3 = null;
        SSLSocket r2 = (SSLSocket) ZeusTransformUtils.preCheckCast(null, SSLSocket.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L50;
    L5:
        Socket r4 = r1.createSocket(this.rawSocket, r0.url().host(), r0.url().port(), true);     // Catch: Throwable -> L44
        if (r4 == null) goto L43;
        SSLSocket r5 = (SSLSocket) ZeusTransformUtils.preCheckCast(r4, SSLSocket.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        ConnectionSpec r13 = r12.configureSecureSocket(r5);     // Catch: Throwable -> L40
        if (r13.supportsTlsExtensions() == false) goto L11;
        Platform.Companion.get().configureTlsExtensions(r5, r0.url().host(), r0.protocols());     // Catch: Throwable -> L40
    L11:
        r5.startHandshake();     // Catch: Throwable -> L40
        SSLSession r6 = r5.getSession();     // Catch: Throwable -> L40
        Handshake.Companion r7 = Handshake.Companion;     // Catch: Throwable -> L40
        Intrinsics.checkExpressionValueIsNotNull(r6, "sslSocketSession");     // Catch: Throwable -> L40
        final Handshake r8 = r7.get(r6);     // Catch: Throwable -> L40
        HostnameVerifier r9 = r0.hostnameVerifier();     // Catch: Throwable -> L40
        if (r9 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Throwable -> L40
    L15:
        if (r9.verify(r0.url().host(), r6) == true) goto L26;
        List<Certificate> r11 = r8.peerCertificates();     // Catch: Throwable -> L40
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L25;
        Certificate r14 = r11.get(0);     // Catch: Throwable -> L40
        if (r14 == null) goto L21;
        X509Certificate r15 = (X509Certificate) ZeusTransformUtils.preCheckCast(r14, X509Certificate.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        StringBuilder r10 = new StringBuilder().append("\n              |Hostname ").append(r0.url().host()).append(" not verified:\n              |    certificate: ").append(CertificatePinner.Companion.pin((Certificate) ZeusTransformUtils.preCheckCast(r15, Certificate.class, "com.obric.memorydata.plugin"))).append("\n              |    DN: ");     // Catch: Throwable -> L40
        Principal r16 = r15.getSubjectDN();     // Catch: Throwable -> L40
        Intrinsics.checkExpressionValueIsNotNull(r16, "cert.subjectDN");     // Catch: Throwable -> L40
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SSLPeerUnverifiedException(StringsKt.trimMargin$default(r10.append(r16.getName()).append("\n              |    subjectAltNames: ").append(OkHostnameVerifier.INSTANCE.allSubjectAltNames(r15)).append("\n              ").toString(), null, 1, null)), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: Throwable -> L40
    L25:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new SSLPeerUnverifiedException("Hostname " + r0.url().host() + " not verified (no certificates)"), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
    L26:
        final CertificatePinner r17 = r0.certificatePinner();     // Catch: Throwable -> L40
        if (r17 != null) goto L29;
        Intrinsics.throwNpe();     // Catch: Throwable -> L40
    L29:
        this.handshake = new Handshake(r8.tlsVersion(), r8.cipherSuite(), r8.localCertificates(), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r17, r8, r0), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        r17.check$okhttp(r0.url().host(), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L40
        if (r13.supportsTlsExtensions() == false) goto L32;
        r3 = Platform.Companion.get().getSelectedProtocol(r5);     // Catch: Throwable -> L40
    L32:
        this.socket = (Socket) ZeusTransformUtils.preCheckCast(r5, Socket.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        this.source = Okio.buffer(Okio.source((Socket) ZeusTransformUtils.preCheckCast(r5, Socket.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L40
        this.sink = Okio.buffer(Okio.sink((Socket) ZeusTransformUtils.preCheckCast(r5, Socket.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L40
        if (r3 == null) goto L35;
        Protocol r18 = Protocol.Companion.get(r3);     // Catch: Throwable -> L40
    L36:
        this.protocol = r18;     // Catch: Throwable -> L40
        if (r5 == null) goto L52;
        Platform.Companion.get().afterHandshake(r5);
        return;
    L52:
        return;
    L35:
        r18 = Protocol.HTTP_1_1;     // Catch: Throwable -> L40
    L40:
        th = th;
        r2 = r5;
    L45:
        if (r2 == null) goto L47;
        Platform.Companion.get().afterHandshake(r2);
    L47:
        if (r2 == null) goto L49;
        Util.closeQuietly((Socket) ZeusTransformUtils.preCheckCast(r2, Socket.class, "com.obric.memorydata.plugin"));
    L49:
        throw th;
    L43:
        throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");     // Catch: Throwable -> L44
    L50:
        Intrinsics.throwNpe();     // Catch: Throwable -> L44
    L44:
        th = th;
        goto L45
    }

    private final void connectTunnel(int r8, int r9, int r10, Call r11, EventListener r12) {
        Call r13 = (Call) ZeusTransformUtils.wrapperContextForParams(r11, Call.class, "com.obric.memorydata.plugin");
        Request r0 = createTunnelRequest();
        HttpUrl r2 = r0.url();
        int r3 = 0;
    L4:
        if (r3 >= 21) goto L11;
        connectSocket(r8, r9, r13, r12);
        r0 = createTunnel(r9, r10, r0, r2);
        if (r0 == null) goto L16;
        Socket r4 = this.rawSocket;
        if (r4 == null) goto L10;
        Util.closeQuietly(r4);
    L10:
        this.rawSocket = (Socket) ZeusTransformUtils.preCheckCast(null, Socket.class, "com.obric.memorydata.plugin");
        this.sink = (BufferedSink) ZeusTransformUtils.preCheckCast(null, BufferedSink.class, "com.obric.memorydata.plugin");
        this.source = (BufferedSource) ZeusTransformUtils.preCheckCast(null, BufferedSource.class, "com.obric.memorydata.plugin");
        r12.connectEnd(r13, this.route.socketAddress(), this.route.proxy(), null);
        r3 = r3 + 1;
        goto L4
    L16:
        return;
    }

    private final Request createTunnel(int r10, int r11, Request r12, HttpUrl r13) {
        String r14 = "CONNECT " + Util.toHostHeader(r13, true) + " HTTP/1.1";
    L3:
        BufferedSource r0 = this.source;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        BufferedSink r2 = this.sink;
        if (r2 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        Http1ExchangeCodec r3 = new Http1ExchangeCodec(null, null, r0, r2);
        r0.timeout().timeout(r10, TimeUnit.MILLISECONDS);
        r2.timeout().timeout(r11, TimeUnit.MILLISECONDS);
        r3.writeRequest(r12.headers(), r14);
        r3.finishRequest();
        Response.Builder r5 = r3.readResponseHeaders(false);
        if (r5 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        Response r15 = r5.request(r12).build();
        r3.skipConnectBody(r15);
        int r4 = r15.code();
        if (r4 == 200) goto L27;
        if (r4 != 407) goto L25;
        Request r1 = this.route.address().proxyAuthenticator().authenticate(this.route, r15);
        if (r1 == null) goto L23;
        if (StringsKt.equals(IslandSession.REOPEN_VALUE_CLOSE, Response.header$default(r15, "Connection", null, 2, null), true) == true) goto L20;
        r12 = r1;
        goto L3
    L20:
        return r1;
    L23:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Failed to authenticate with proxy"), Throwable.class, "com.obric.memorydata.plugin"));
    L25:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("Unexpected response code for CONNECT: " + r15.code()), Throwable.class, "com.obric.memorydata.plugin"));
    L27:
        if (r0.getBuffer().exhausted() == false) goto L32;
        if (r2.getBuffer().exhausted() == false) goto L32;
        return null;
    L32:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IOException("TLS tunnel buffered too many bytes!"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final Request createTunnelRequest() {
        Request r0 = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent).build();
        Response r1 = new Response.Builder().request(r0).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        Request r4 = this.route.address().proxyAuthenticator().authenticate(this.route, r1);
        if (r4 != null) goto L5;
        return r0;
    L5:
        return r4;
    }

    private final void establishProtocol(ConnectionSpecSelector r3, int r4, Call r5, EventListener r6) {
        Call r7 = (Call) ZeusTransformUtils.wrapperContextForParams(r5, Call.class, "com.obric.memorydata.plugin");
        if (this.route.address().sslSocketFactory() == null) goto L5;
        r6.secureConnectStart(r7);
        connectTls(r3);
        r6.secureConnectEnd(r7, this.handshake);
        if (this.protocol != Protocol.HTTP_2) goto L14;
        startHttp2(r4);
        return;
    L14:
        return;
    L5:
        if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L8;
        this.socket = this.rawSocket;
        this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        startHttp2(r4);
        return;
    L8:
        this.socket = this.rawSocket;
        this.protocol = Protocol.HTTP_1_1;
    }

    private final boolean routeMatchesAny(List<Route> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L19;
        Route r0 = (Route) ZeusTransformUtils.preCheckCast(r9.next(), Route.class, "com.obric.memorydata.plugin");
        if (r0.proxy().type() == Proxy.Type.DIRECT) goto L13;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L9;
        return true;
    L13:
        if (this.route.proxy().type() != Proxy.Type.DIRECT) goto L17;
        if (Intrinsics.areEqual(this.route.socketAddress(), r0.socketAddress()) == false) goto L17;
        r1 = true;
    L19:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final void startHttp2(int r8) {
        Socket r0 = this.socket;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        BufferedSource r1 = this.source;
        if (r1 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        BufferedSink r2 = this.sink;
        if (r2 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r0.setSoTimeout(0);
        Http2Connection r9 = new Http2Connection.Builder(true).socket(r0, this.route.address().url().host(), r1, r2).listener((Http2Connection.Listener) ZeusTransformUtils.preCheckCast(this, Http2Connection.Listener.class, "com.obric.memorydata.plugin")).pingIntervalMillis(r8).build();
        this.http2Connection = r9;
        Http2Connection.start$default(r9, false, 1, null);
    }

    public final void cancel() {
        Socket r0 = this.rawSocket;
        if (r0 == null) goto L6;
        Util.closeQuietly(r0);
        return;
    }

    public final void connect(int r17, int r18, int r19, int r20, boolean r21, Call r22, EventListener r23) {
        Call r9 = (Call) ZeusTransformUtils.wrapperContextForParams(r22, Call.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(r23, "eventListener");
        if (this.protocol != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L75;
        RouteException r1 = (RouteException) ZeusTransformUtils.preCheckCast(null, RouteException.class, "com.obric.memorydata.plugin");
        List<ConnectionSpec> r2 = this.route.address().connectionSpecs();
        ConnectionSpecSelector r11 = new ConnectionSpecSelector(r2);
        if (this.route.address().sslSocketFactory() != null) goto L19;
        if (r2.contains(ConnectionSpec.CLEARTEXT) == false) goto L17;
        String r3 = this.route.address().url().host();
        if (Platform.Companion.get().isCleartextTrafficPermitted(r3) == false) goto L15;
    L20:
        RouteException r12 = r1;
    L80:
    L53:
        e = e;
    L56:
        Socket r4 = this.socket;
        if (r4 == null) goto L59;
        Util.closeQuietly(r4);
    L59:
        Socket r5 = this.rawSocket;
        if (r5 == null) goto L62;
        Util.closeQuietly(r5);
    L62:
        this.socket = (Socket) ZeusTransformUtils.preCheckCast(null, Socket.class, "com.obric.memorydata.plugin");
        this.rawSocket = (Socket) ZeusTransformUtils.preCheckCast(null, Socket.class, "com.obric.memorydata.plugin");
        this.source = (BufferedSource) ZeusTransformUtils.preCheckCast(null, BufferedSource.class, "com.obric.memorydata.plugin");
        this.sink = (BufferedSink) ZeusTransformUtils.preCheckCast(null, BufferedSink.class, "com.obric.memorydata.plugin");
        this.handshake = (Handshake) ZeusTransformUtils.preCheckCast(null, Handshake.class, "com.obric.memorydata.plugin");
        this.protocol = (Protocol) ZeusTransformUtils.preCheckCast(null, Protocol.class, "com.obric.memorydata.plugin");
        this.http2Connection = (Http2Connection) ZeusTransformUtils.preCheckCast(null, Http2Connection.class, "com.obric.memorydata.plugin");
        r23.connectFailed(r9, this.route.socketAddress(), this.route.proxy(), null, e);
        if (r12 != null) goto L65;
        r12 = new RouteException(e);
    L66:
        if (r21 == false) goto L71;
        if (r11.connectionFailed(e) == true) goto L80;
    L71:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r12, Throwable.class, "com.obric.memorydata.plugin"));
    L65:
        r12.addConnectException(e);
        goto L66
    L22:
        if (this.route.requiresTunnel() == false) goto L82;
        connectTunnel(r17, r18, r19, r9, r23);     // Catch: IOException -> L53
        if (this.rawSocket == null) goto L32;
    L76:
        establishProtocol(r11, r20, r9, r23);     // Catch: IOException -> L49
        r23.connectEnd(r9, this.route.socketAddress(), this.route.proxy(), this.protocol);     // Catch: IOException -> L49
    L49:
        e = e;
    L32:
        if (this.route.requiresTunnel() == true) goto L34;
    L38:
        Http2Connection r6 = this.http2Connection;
        if (r6 == null) goto L48;
        RealConnectionPool r7 = this.connectionPool;
        monitor-enter(r7);
        this.allocationLimit = r6.maxConcurrentStreams();     // Catch: Throwable -> L45
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r7);
        return;
    L45:
        th = move-exception;
        throw th;
    L48:
        return;
    L34:
        if (this.rawSocket != null) goto L38;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RouteException((IOException) ZeusTransformUtils.preCheckCast(new ProtocolException("Too many tunnel connections attempted: 21"), IOException.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L82:
        connectSocket(r17, r18, r9, r23);     // Catch: IOException -> L51
    L51:
        e = e;
        goto L56
    L15:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RouteException((IOException) ZeusTransformUtils.preCheckCast(new UnknownServiceException("CLEARTEXT communication to " + r3 + " not permitted by network security policy"), IOException.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RouteException((IOException) ZeusTransformUtils.preCheckCast(new UnknownServiceException("CLEARTEXT communication not enabled for client"), IOException.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L20;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RouteException((IOException) ZeusTransformUtils.preCheckCast(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"), IOException.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    L75:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("already connected".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNanos$okhttp() {
        return this.idleAtNanos;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final int getSuccessCount$okhttp() {
        return this.successCount;
    }

    public final List<Reference<Transmitter>> getTransmitters() {
        return this.transmitters;
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public final boolean isEligible$okhttp(Address r4, List<Route> r5) {
        List<Route> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, MemoryKeyInfoEntity.KEY_ADDRESS);
        if (this.transmitters.size() < this.allocationLimit) goto L5;
    L34:
        return false;
    L5:
        if (this.noNewExchanges == true) goto L34;
        if (this.route.address().equalsNonHost$okhttp(r4) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r4.url().host(), route().address().url().host()) == false) goto L14;
        return true;
    L14:
        if (this.http2Connection != null) goto L16;
        return false;
    L16:
        if (r6 == null) goto L34;
        if (routeMatchesAny(r6) == false) goto L34;
        if (r4.hostnameVerifier() == OkHostnameVerifier.INSTANCE) goto L24;
        return false;
    L24:
        if (supportsUrl(r4.url()) == true) goto L36;
        return false;
    L36:
        CertificatePinner r7 = r4.certificatePinner();     // Catch: SSLPeerUnverifiedException -> L35
        if (r7 != null) goto L29;
        Intrinsics.throwNpe();     // Catch: SSLPeerUnverifiedException -> L35
    L29:
        String r8 = r4.url().host();     // Catch: SSLPeerUnverifiedException -> L35
        Handshake r3 = handshake();     // Catch: SSLPeerUnverifiedException -> L35
        if (r3 != null) goto L32;
        Intrinsics.throwNpe();     // Catch: SSLPeerUnverifiedException -> L35
    L32:
        r7.check(r8, r3.peerCertificates());     // Catch: SSLPeerUnverifiedException -> L35
        return true;
    }

    public final boolean isHealthy(boolean r5) {
        Socket r0 = this.socket;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        BufferedSource r1 = this.source;
        if (r1 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        if (r0.isClosed() == false) goto L11;
    L30:
        return false;
    L11:
        if (r0.isInputShutdown() == true) goto L30;
        if (r0.isOutputShutdown() == true) goto L30;
        Http2Connection r4 = this.http2Connection;
        if (r4 != null) goto L18;
        if (r5 == true) goto L34;
    L29:
        return true;
    L34:
        int r6 = r0.getSoTimeout();     // Catch: IOException -> L28 SocketTimeoutException -> L31
        r0.setSoTimeout(1);     // Catch: Throwable -> L25
        boolean r7 = !r1.exhausted();
        r0.setSoTimeout(r6);     // Catch: IOException -> L28 SocketTimeoutException -> L31
        return r7;
    L25:
        th = move-exception;
        r0.setSoTimeout(r6);     // Catch: IOException -> L28 SocketTimeoutException -> L31
        throw th;     // Catch: IOException -> L28 SocketTimeoutException -> L31
    L28:
        return false;
    L18:
        return !r4.isShutdown();
    }

    public final boolean isMultiplexed() {
        if (this.http2Connection == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient r8, Interceptor.Chain r9) {
        Interceptor.Chain r10 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r9, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, "client");
        Intrinsics.checkParameterIsNotNull(r10, "chain");
        Socket r0 = this.socket;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        BufferedSource r2 = this.source;
        if (r2 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        BufferedSink r3 = this.sink;
        if (r3 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        Http2Connection r4 = this.http2Connection;
        if (r4 == null) goto L14;
        Object r7 = ZeusTransformUtils.preCheckCast(new Http2ExchangeCodec(r8, this, r10, r4), ExchangeCodec.class, "com.obric.memorydata.plugin");
    L16:
        return (ExchangeCodec) r7;
    L14:
        r0.setSoTimeout(r10.readTimeoutMillis());
        r2.timeout().timeout(r10.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        r3.timeout().timeout(r10.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        r7 = ZeusTransformUtils.preCheckCast(new Http1ExchangeCodec(r8, this, r2, r3), ExchangeCodec.class, "com.obric.memorydata.plugin");
        goto L16
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(final Exchange r9) {
        Intrinsics.checkParameterIsNotNull(r9, "exchange");
        Socket r0 = this.socket;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        final BufferedSource r6 = this.source;
        if (r6 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        final BufferedSink r7 = this.sink;
        if (r7 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r0.setSoTimeout(0);
        noNewExchanges();
        final boolean r5 = true;
        return (RealWebSocket.Streams) ZeusTransformUtils.preCheckCast(new RealConnection$newWebSocketStreams$1(r9, r6, r7, r5, r6, r7), RealWebSocket.Streams.class, "com.obric.memorydata.plugin");
    }

    public final void noNewExchanges() {
        Thread.holdsLock(this.connectionPool);
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.noNewExchanges = true;     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection r2) {
        Intrinsics.checkParameterIsNotNull(r2, WsConstants.KEY_CONNECTION);
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.allocationLimit = r2.maxConcurrentStreams();     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream r2) {
        Intrinsics.checkParameterIsNotNull(r2, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
        r2.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        Protocol r0 = this.protocol;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r0;
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.route;
    }

    public final void setIdleAtNanos$okhttp(long r1) {
        this.idleAtNanos = r1;
    }

    public final void setNoNewExchanges(boolean r1) {
        this.noNewExchanges = r1;
    }

    public final void setRouteFailureCount$okhttp(int r1) {
        this.routeFailureCount = r1;
    }

    public final void setSuccessCount$okhttp(int r1) {
        this.successCount = r1;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        Socket r0 = this.socket;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r0;
    }

    public final boolean supportsUrl(HttpUrl r6) {
        Intrinsics.checkParameterIsNotNull(r6, "url");
        HttpUrl r0 = this.route.address().url();
        if (r6.port() == r0.port()) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r6.host(), r0.host()) == false) goto L9;
        return true;
    L9:
        if (this.handshake == null) goto L20;
        OkHostnameVerifier r1 = OkHostnameVerifier.INSTANCE;
        String r7 = r6.host();
        Handshake r5 = this.handshake;
        if (r5 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        Certificate r8 = r5.peerCertificates().get(0);
        if (r8 == null) goto L19;
        if (r1.verify(r7, (X509Certificate) ZeusTransformUtils.preCheckCast(r8, X509Certificate.class, "com.obric.memorydata.plugin")) == true) goto L22;
        return false;
    L22:
        return true;
    L19:
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L20:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(':').append(this.route.address().url().port()).append(',').append(" proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
        Handshake r1 = this.handshake;
        if (r1 == null) goto L7;
        Object r2 = r1.cipherSuite();
        if (r2 == null) goto L7;
    L9:
        return r0.append(r2).append(" protocol=").append(this.protocol).append('}').toString();
    L7:
        r2 = "none";
        goto L9
    }

    public final void trackFailure$okhttp(IOException r5) {
        Thread.holdsLock(this.connectionPool);
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, StreamResetException.class) == false) goto L16;
        ErrorCode r6 = ((StreamResetException) ZeusTransformUtils.preCheckCast(r5, StreamResetException.class, "com.obric.memorydata.plugin")).errorCode;     // Catch: Throwable -> L27
        int r7 = WhenMappings.$EnumSwitchMapping$1[r6.ordinal()];     // Catch: Throwable -> L27
        if (r7 != 1) goto L9;
        int r8 = this.refusedStreamCount + 1;     // Catch: Throwable -> L27
        this.refusedStreamCount = r8;     // Catch: Throwable -> L27
        if (r8 <= 1) goto L24;
        this.noNewExchanges = true;     // Catch: Throwable -> L27
        int r9 = this.routeFailureCount;     // Catch: Throwable -> L27
    L11:
        this.routeFailureCount = r9 + 1;     // Catch: Throwable -> L27
    L24:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r0);
        return;
    L9:
        if (r7 == 2) goto L24;
        this.noNewExchanges = true;     // Catch: Throwable -> L27
        r9 = this.routeFailureCount;     // Catch: Throwable -> L27
        goto L11
    L16:
        if (isMultiplexed() == true) goto L18;
    L19:
        this.noNewExchanges = true;     // Catch: Throwable -> L27
        if (this.successCount != 0) goto L24;
        if (r5 == null) goto L23;
        this.connectionPool.connectFailed(this.route, r5);     // Catch: Throwable -> L27
    L23:
        r9 = this.routeFailureCount;     // Catch: Throwable -> L27
        goto L11
    L18:
        if (ZeusTransformUtils.instanceOf(r5, ConnectionShutdownException.class) == false) goto L24;
        goto L19
    }
}
