package okhttp3.internal.connection;

import ai.j0;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import f4.b;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.f0;
import nu.k;
import nu.l;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.a;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.e0;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.m0;
import okhttp3.n;
import okhttp3.n0;
import okhttp3.q;
import okhttp3.r0;
import okhttp3.s0;
import okhttp3.w;
import okhttp3.x0;
import okhttp3.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000  \u00012\u00020\u00012\u00020\u0002:\u0002 \u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000f\u0010\u000bJE\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010$\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001e2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 H\u0000¢\u0006\u0004\b\"\u0010#J\u001f\u0010,\u001a\u00020)2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0000¢\u0006\u0004\b*\u0010+J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b0\u00101J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u00103J\r\u00104\u001a\u00020\t¢\u0006\u0004\b4\u0010\u000bJ\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010C\u001a\u00020\t2\u0006\u0010@\u001a\u00020?2\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ\u0011\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bF\u0010GJ'\u0010M\u001a\u00020\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010J\u001a\u00020IH\u0000¢\u0006\u0004\bK\u0010LJ!\u0010R\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0004\bP\u0010QJ\u000f\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XJ7\u0010Y\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\bY\u0010ZJ/\u0010[\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b[\u0010\\J/\u0010_\u001a\u00020\t2\u0006\u0010^\u001a\u00020]2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b_\u0010`J\u0017\u0010a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020\t2\u0006\u0010^\u001a\u00020]H\u0002¢\u0006\u0004\bc\u0010dJ1\u0010i\u001a\u0004\u0018\u00010e2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010f\u001a\u00020e2\u0006\u0010h\u001a\u00020gH\u0002¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020eH\u0002¢\u0006\u0004\bk\u0010lJ\u001d\u0010n\u001a\u00020\u00162\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0004\bn\u0010oJ\u0017\u0010p\u001a\u00020\u00162\u0006\u0010h\u001a\u00020gH\u0002¢\u0006\u0004\bp\u0010qJ\u001f\u0010r\u001a\u00020\u00162\u0006\u0010h\u001a\u00020g2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\br\u0010sR\u0018\u0010t\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010uR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010vR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR'\u0010\f\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0017\u0010\u000e\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010\u0080\u0001R(\u0010\u0085\u0001\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0005\b\u0089\u0001\u0010bR\u0019\u0010\u008a\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0086\u0001R\u0019\u0010\u008b\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0086\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0086\u0001R*\u0010\u008f\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020N0\u008e\u00010\u008d\u00018\u0006¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R*\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\u000f\n\u0005\b\u0004\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0015\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010\u009d\u0001R\u0017\u0010\u009f\u0001\u001a\u00020\u00168@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u0082\u0001¨\u0006¡\u0001"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/n;", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/x0;", "route", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/x0;)V", "", "noNewExchanges$okhttp", "()V", "noNewExchanges", "noCoalescedConnections$okhttp", "noCoalescedConnections", "incrementSuccessCount$okhttp", "incrementSuccessCount", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "Lokhttp3/Call;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/w;", "eventListener", "connect", "(IIIIZLokhttp3/Call;Lokhttp3/w;)V", "Lokhttp3/a;", "address", "", "routes", "isEligible$okhttp", "(Lokhttp3/a;Ljava/util/List;)Z", "isEligible", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "newCodec$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "newCodec", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams$okhttp", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/x0;", "cancel", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "doExtensiveChecks", "isHealthy", "(Z)Z", "Lokhttp3/internal/http2/Http2Stream;", "stream", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "Lokhttp3/a0;", "handshake", "()Lokhttp3/a0;", "failedRoute", "Ljava/io/IOException;", "failure", "connectFailed$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/x0;Ljava/io/IOException;)V", "connectFailed", "Lokhttp3/internal/connection/RealCall;", "e", "trackFailure$okhttp", "(Lokhttp3/internal/connection/RealCall;Ljava/io/IOException;)V", "trackFailure", "Lokhttp3/Protocol;", "protocol", "()Lokhttp3/Protocol;", "", "toString", "()Ljava/lang/String;", "connectTunnel", "(IIILokhttp3/Call;Lokhttp3/w;)V", "connectSocket", "(IILokhttp3/Call;Lokhttp3/w;)V", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectionSpecSelector", "establishProtocol", "(Lokhttp3/internal/connection/ConnectionSpecSelector;ILokhttp3/Call;Lokhttp3/w;)V", "startHttp2", "(I)V", "connectTls", "(Lokhttp3/internal/connection/ConnectionSpecSelector;)V", "Lokhttp3/Request;", "tunnelRequest", "Lokhttp3/e0;", "url", "createTunnel", "(IILokhttp3/Request;Lokhttp3/e0;)Lokhttp3/Request;", "createTunnelRequest", "()Lokhttp3/Request;", "candidates", "routeMatchesAny", "(Ljava/util/List;)Z", "supportsUrl", "(Lokhttp3/e0;)Z", "certificateSupportHost", "(Lokhttp3/e0;Lokhttp3/a0;)Z", "rawSocket", "Ljava/net/Socket;", "Lokhttp3/a0;", "Lokhttp3/Protocol;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "Lnu/l;", "source", "Lnu/l;", "Lnu/k;", "sink", "Lnu/k;", "Z", "getNoNewExchanges", "()Z", "setNoNewExchanges", "(Z)V", "routeFailureCount", "I", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "successCount", "refusedStreamCount", "allocationLimit", "", "Ljava/lang/ref/Reference;", "calls", "Ljava/util/List;", "getCalls", "()Ljava/util/List;", "", "idleAtNs", "J", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "Lokhttp3/internal/connection/RealConnectionPool;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/x0;", "isMultiplexed$okhttp", "isMultiplexed", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealConnection extends Http2Connection.Listener implements n {
    public static final Companion Companion = null;
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;
    private final List<Reference<RealCall>> calls;
    private final RealConnectionPool connectionPool;
    private a0 handshake;
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final x0 route;
    private int routeFailureCount;
    private k sink;
    private Socket socket;
    private l source;
    private int successCount;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "<init>", "()V", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/x0;", "route", "Ljava/net/Socket;", "socket", "", "idleAtNs", "Lokhttp3/internal/connection/RealConnection;", "newTestConnection", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/x0;Ljava/net/Socket;J)Lokhttp3/internal/connection/RealConnection;", "IDLE_CONNECTION_HEALTHY_NS", "J", "", "MAX_TUNNEL_ATTEMPTS", "I", "", "NPE_THROW_WITH_NULL", "Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final RealConnection newTestConnection(RealConnectionPool r5, x0 r10, Socket r11, long r12) {
            Intrinsics.checkNotNullParameter(r5, "connectionPool");
            Intrinsics.checkNotNullParameter(r10, "route");
            Intrinsics.checkNotNullParameter(r11, "socket");
            RealConnection r13 = new RealConnection(r5, r10);
            RealConnection.access$setSocket$p(r13, r11);
            r13.setIdleAtNs$okhttp(r12);
            return r13;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = r5;
            r5[Proxy.Type.DIRECT.ordinal()] = 1;
            r5[Proxy.Type.HTTP.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RealConnection(RealConnectionPool r5, x0 r10) {
        Intrinsics.checkNotNullParameter(r5, "connectionPool");
        Intrinsics.checkNotNullParameter(r10, "route");
        this.connectionPool = r5;
        this.route = r10;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public static final /* synthetic */ a0 access$getHandshake$p(RealConnection r5) {
        return r5.handshake;
    }

    public static final /* synthetic */ Socket access$getSocket$p(RealConnection r5) {
        return r5.socket;
    }

    public static final /* synthetic */ void access$setHandshake$p(RealConnection r5, a0 r10) {
        r5.handshake = r10;
    }

    public static final /* synthetic */ void access$setSocket$p(RealConnection r5, Socket r10) {
        r5.socket = r10;
    }

    private final boolean certificateSupportHost(e0 r5, a0 r10) {
        List r11 = r10.a();
        if (r11.isEmpty() == true) goto L11;
        OkHostnameVerifier r12 = OkHostnameVerifier.INSTANCE;
        String r13 = r5.e;
        Object r14 = r11.get(0);
        if (r14 == null) goto L10;
        if (r12.verify(r13, (X509Certificate) r14) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L11:
        return false;
    }

    private final void connectSocket(int r5, int r10, Call r11, w r12) throws IOException {
        x0 r13 = this.route;
        Proxy r14 = r13.f20765b;
        Proxy.Type r15 = r14.type();
        if (r15 == null) goto L9;
        int r16 = WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
        if (r16 != 1) goto L8;
    L10:
        Socket r17 = r13.f20764a.e.createSocket();
        Intrinsics.checkNotNull(r17);
    L11:
        this.rawSocket = r17;
        InetSocketAddress r18 = this.route.f20766c;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r18, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r14, "proxy");
        r17.setSoTimeout(r10);
        Platform.Companion.get().connectSocket(r17, this.route.f20766c, r5);     // Catch: ConnectException -> L21
        this.source = b.e(b.q(r17));     // Catch: NullPointerException -> L15
        this.sink = b.d(b.o(r17));     // Catch: NullPointerException -> L15
        return;
    L15:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), NPE_THROW_WITH_NULL) == true) goto L20;
        return;
    L20:
        throw new IOException(e);
    L21:
        e = move-exception;
        ConnectException r19 = new ConnectException("Failed to connect to " + this.route.f20766c);
        r19.initCause(e);
        throw r19;
    L8:
        if (r16 == 2) goto L10;
    L9:
        r17 = new Socket(r14);
        goto L11
    }

    private final void connectTls(ConnectionSpecSelector r12) throws IOException {
        final a r5 = this.route.f20764a;
        SSLSocketFactory r10 = r5.f;
        e0 r11 = r5.f20610a;
        SSLSocket r13 = null;
        String r14 = null;
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L34
        Socket r15 = r10.createSocket(this.rawSocket, r11.e, r11.f, true);     // Catch: Throwable -> L34
        if (r15 == null) goto L37;
        SSLSocket r16 = (SSLSocket) r15;     // Catch: Throwable -> L34
        q r17 = r12.configureSecureSocket(r16);     // Catch: Throwable -> L10
        boolean r18 = r17.f20724b;     // Catch: Throwable -> L10
        String r19 = r11.e;
        if (r18 == false) goto L12;
        Platform.Companion.get().configureTlsExtensions(r16, r19, r5.f20611b);     // Catch: Throwable -> L10
    L12:
        r16.startHandshake();     // Catch: Throwable -> L10
        SSLSession r20 = r16.getSession();     // Catch: Throwable -> L10
        final a0 r21 = z.e(r20);     // Catch: Throwable -> L10
        HostnameVerifier r22 = r5.g;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L10
        if (r22.verify(r19, r20) == true) goto L24;
        List r110 = r21.a();     // Catch: Throwable -> L10
        if (r110.isEmpty() == true) goto L23;
        Object r111 = r110.get(0);     // Catch: Throwable -> L10
        if (r111 == null) goto L19;
        X509Certificate r112 = (X509Certificate) r111;     // Catch: Throwable -> L10
        StringBuilder r23 = new StringBuilder("\n              |Hostname ");     // Catch: Throwable -> L10
        r23.append(r19);     // Catch: Throwable -> L10
        r23.append(" not verified:\n              |    certificate: ");     // Catch: Throwable -> L10
        okhttp3.k r24 = okhttp3.k.f20666c;     // Catch: Throwable -> L10
        r23.append(z.m(r112));     // Catch: Throwable -> L10
        r23.append("\n              |    DN: ");     // Catch: Throwable -> L10
        r23.append(r112.getSubjectDN().getName());     // Catch: Throwable -> L10
        r23.append("\n              |    subjectAltNames: ");     // Catch: Throwable -> L10
        r23.append(OkHostnameVerifier.INSTANCE.allSubjectAltNames(r112));     // Catch: Throwable -> L10
        r23.append("\n              ");     // Catch: Throwable -> L10
        throw new SSLPeerUnverifiedException(StringsKt.f0(r23.toString()));     // Catch: Throwable -> L10
    L19:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: Throwable -> L10
    L23:
        throw new SSLPeerUnverifiedException("Hostname " + r19 + " not verified (no certificates)");     // Catch: Throwable -> L10
    L24:
        final okhttp3.k r25 = r5.f20613h;     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L10
        this.handshake = new a0(r21.f20617b, r21.f20618c, r21.d, new AnonymousClass1(r25, r21, r5));     // Catch: Throwable -> L10
        r25.b(r19, new AnonymousClass2(this));     // Catch: Throwable -> L10
        if (r17.f20724b == false) goto L27;
        r14 = Platform.Companion.get().getSelectedProtocol(r16);     // Catch: Throwable -> L10
    L27:
        this.socket = r16;     // Catch: Throwable -> L10
        this.source = b.e(b.q(r16));     // Catch: Throwable -> L10
        this.sink = b.d(b.o(r16));     // Catch: Throwable -> L10
        if (r14 == null) goto L30;
        Protocol.Companion.getClass();     // Catch: Throwable -> L10
        Protocol r113 = m0.a(r14);     // Catch: Throwable -> L10
    L31:
        this.protocol = r113;     // Catch: Throwable -> L10
        Platform.Companion.get().afterHandshake(r16);
        return;
    L30:
        r113 = Protocol.HTTP_1_1;     // Catch: Throwable -> L10
    L10:
        th = th;
        r13 = r16;
    L38:
        if (r13 == null) goto L40;
        Platform.Companion.get().afterHandshake(r13);
    L40:
        if (r13 == null) goto L42;
        Util.closeQuietly(r13);
    L42:
        throw th;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");     // Catch: Throwable -> L34
    L34:
        th = th;
        goto L38
    }

    private final void connectTunnel(int r10, int r11, int r12, Call r13, w r14) throws IOException {
        Request r5 = createTunnelRequest();
        e0 r15 = r5.url();
        int r16 = 0;
    L4:
        if (r16 >= 21) goto L11;
        connectSocket(r10, r11, r13, r14);
        r5 = createTunnel(r11, r12, r5, r15);
        if (r5 == null) goto L16;
        Socket r17 = this.rawSocket;
        if (r17 == null) goto L10;
        Util.closeQuietly(r17);
    L10:
        this.rawSocket = null;
        this.sink = null;
        this.source = null;
        x0 r18 = this.route;
        r14.a(r13, r18.f20766c, r18.f20765b, null);
        r16 = r16 + 1;
        goto L4
    L16:
        return;
    }

    private final Request createTunnel(int r10, int r11, Request r12, e0 r13) throws IOException {
        String r14 = "CONNECT " + Util.toHostHeader(r13, true) + " HTTP/1.1";
        l r5 = this.source;
        Intrinsics.checkNotNull(r5);
        k r15 = this.sink;
        Intrinsics.checkNotNull(r15);
        Http1ExchangeCodec r16 = new Http1ExchangeCodec(null, this, r5, r15);
        f0 r17 = r5.timeout();
        long r18 = r10;
        TimeUnit r19 = TimeUnit.MILLISECONDS;
        r17.timeout(r18, r19);
        r15.timeout().timeout(r11, r19);
        r16.writeRequest(r12.headers(), r14);
        r16.finishRequest();
        r0 r20 = r16.readResponseHeaders(false);
        Intrinsics.checkNotNull(r20);
        r20.getClass();
        Intrinsics.checkNotNullParameter(r12, "request");
        r20.f20735a = r12;
        s0 r21 = r20.a();
        r16.skipConnectBody(r21);
        int r110 = r21.e;
        if (r110 == 200) goto L11;
        if (r110 != 407) goto L9;
        this.route.f20764a.f20614i.getClass();
        Intrinsics.checkNotNullParameter(r21, "response");
        throw new IOException("Failed to authenticate with proxy");
    L9:
        throw new IOException(j0.g(r110, "Unexpected response code for CONNECT: "));
    L11:
        if (r5.h().y() == false) goto L16;
        if (r15.h().y() == false) goto L16;
        return null;
    L16:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private final Request createTunnelRequest() throws IOException {
        n0 r5 = new n0();
        e0 r10 = this.route.f20764a.f20610a;
        Intrinsics.checkNotNullParameter(r10, "url");
        r5.f20713a = r10;
        r5.d("CONNECT", null);
        r5.c("Host", Util.toHostHeader(this.route.f20764a.f20610a, true));
        r5.c("Proxy-Connection", "Keep-Alive");
        r5.c("User-Agent", Util.userAgent);
        Request r11 = r5.b();
        r0 r12 = new r0();
        Intrinsics.checkNotNullParameter(r11, "request");
        r12.f20735a = r11;
        r12.d(Protocol.HTTP_1_1);
        r12.f20737c = 407;
        Intrinsics.checkNotNullParameter("Preemptive Authenticate", "message");
        r12.d = "Preemptive Authenticate";
        r12.g = Util.EMPTY_RESPONSE;
        r12.f20741k = -1;
        r12.f20742l = -1;
        Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
        Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
        b0 r13 = r12.f;
        r13.getClass();
        Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
        Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
        z.b("Proxy-Authenticate");
        z.c("OkHttp-Preemptive", "Proxy-Authenticate");
        r13.f("Proxy-Authenticate");
        r13.c("Proxy-Authenticate", "OkHttp-Preemptive");
        s0 r14 = r12.a();
        this.route.f20764a.f20614i.getClass();
        Intrinsics.checkNotNullParameter(r14, "response");
        return r11;
    }

    private final void establishProtocol(ConnectionSpecSelector r5, int r10, Call r11, w r12) throws IOException {
        a r13 = this.route.f20764a;
        if (r13.f != null) goto L10;
        Protocol r14 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (r13.f20611b.contains(r14) == false) goto L8;
        this.socket = this.rawSocket;
        this.protocol = r14;
        startHttp2(r10);
        return;
    L8:
        this.socket = this.rawSocket;
        this.protocol = Protocol.HTTP_1_1;
        return;
    L10:
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        connectTls(r5);
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        if (this.protocol != Protocol.HTTP_2) goto L14;
        startHttp2(r10);
        return;
    }

    private final boolean routeMatchesAny(List<x0> r5) {
        if (r5 != null) goto L5;
    L7:
        Iterator<T> r10 = r5.iterator();
    L9:
        if (r10.hasNext() == false) goto L27;
        x0 r11 = (x0) r10.next();
        Proxy.Type r12 = r11.f20765b.type();
        Proxy.Type r13 = Proxy.Type.DIRECT;
        if (r12 != r13) goto L9;
        if (this.route.f20765b.type() != r13) goto L9;
        if (Intrinsics.areEqual(this.route.f20766c, r11.f20766c) == false) goto L9;
        return true;
    L27:
        return false;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return false;
    }

    private final void startHttp2(int r10) throws IOException {
        Socket r5 = this.socket;
        Intrinsics.checkNotNull(r5);
        l r11 = this.source;
        Intrinsics.checkNotNull(r11);
        k r12 = this.sink;
        Intrinsics.checkNotNull(r12);
        r5.setSoTimeout(0);
        Http2Connection r13 = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(r5, this.route.f20764a.f20610a.e, r11, r12).listener(this).pingIntervalMillis(r10).build();
        this.http2Connection = r13;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(r13, false, null, 3, null);
    }

    private final boolean supportsUrl(e0 r5) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        e0 r10 = this.route.f20764a.f20610a;
        if (r5.f == r10.f) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r5.e, r10.e) == false) goto L16;
        return true;
    L16:
        if (this.noCoalescedConnections == true) goto L23;
        a0 r11 = this.handshake;
        if (r11 == null) goto L24;
        Intrinsics.checkNotNull(r11);
        if (certificateSupportHost(r5, r11) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        return false;
    L23:
        return false;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void cancel() {
        Socket r5 = this.rawSocket;
        if (r5 == null) goto L6;
        Util.closeQuietly(r5);
        return;
    }

    public final void connect(int r15, int r16, int r17, int r18, boolean r19, Call r20, w r21) {
        Intrinsics.checkNotNullParameter(r20, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r21, "eventListener");
        if (this.protocol != null) goto L71;
        List r5 = this.route.f20764a.f20612c;
        ConnectionSpecSelector r10 = new ConnectionSpecSelector(r5);
        a r11 = this.route.f20764a;
        if (r11.f != null) goto L16;
        if (r5.contains(q.f) == false) goto L14;
        String r12 = this.route.f20764a.f20610a.e;
        if (Platform.Companion.get().isCleartextTrafficPermitted(r12) == false) goto L12;
    L17:
        RouteException r13 = null;
    L76:
        x0 r14 = this.route;     // Catch: IOException -> L31
        if (r14.f20764a.f != null) goto L22;
    L24:
        boolean r22 = false;
    L25:
        if (r22 == false) goto L72;
        connectTunnel(r15, r16, r17, r20, r21);     // Catch: IOException -> L31
        if (this.rawSocket == null) goto L38;
    L74:
        establishProtocol(r10, r18, r20, r21);     // Catch: IOException -> L49
        x0 r23 = this.route;     // Catch: IOException -> L49
        r21.a(r20, r23.f20766c, r23.f20765b, this.protocol);     // Catch: IOException -> L49
    L49:
        e = e;
    L53:
        Socket r24 = this.socket;
        if (r24 == null) goto L56;
        Util.closeQuietly(r24);
    L56:
        Socket r25 = this.rawSocket;
        if (r25 == null) goto L59;
        Util.closeQuietly(r25);
    L59:
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        this.http2Connection = null;
        this.allocationLimit = 1;
        x0 r26 = this.route;
        InetSocketAddress r27 = r26.f20766c;
        Proxy r28 = r26.f20765b;
        r21.getClass();
        Intrinsics.checkNotNullParameter(r20, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r27, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r28, "proxy");
        Intrinsics.checkNotNullParameter(e, "ioe");
        if (r13 != null) goto L62;
        r13 = new RouteException(e);
    L63:
        if (r19 == false) goto L83;
        if (r10.connectionFailed(e) == true) goto L76;
        throw r13;
    L83:
        throw r13;
    L62:
        r13.addConnectException(e);
    L38:
        x0 r29 = this.route;
        if (r29.f20764a.f != null) goto L41;
    L47:
        this.idleAtNs = System.nanoTime();
        return;
    L41:
        if (r29.f20765b.type() != Proxy.Type.HTTP) goto L47;
        if (this.rawSocket != null) goto L47;
        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
    L72:
        connectSocket(r15, r16, r20, r21);     // Catch: IOException -> L51
    L51:
        e = e;
        goto L53
    L22:
        if (r14.f20765b.type() != Proxy.Type.HTTP) goto L24;
        r22 = true;
    L31:
        e = e;
        goto L53
    L12:
        throw new RouteException(new UnknownServiceException(j0.k("CLEARTEXT communication to ", r12, " not permitted by network security policy")));
    L14:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L16:
        if (r11.f20611b.contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L17;
        throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
    L71:
        throw new IllegalStateException("already connected");
    }

    public final void connectFailed$okhttp(OkHttpClient r5, x0 r10, IOException r11) {
        Intrinsics.checkNotNullParameter(r5, "client");
        Intrinsics.checkNotNullParameter(r10, "failedRoute");
        Intrinsics.checkNotNullParameter(r11, "failure");
        if (r10.f20765b.type() == Proxy.Type.DIRECT) goto L5;
        a r12 = r10.f20764a;
        r12.f20615j.connectFailed(r12.f20610a.k(), r10.f20765b.address(), r11);
    L5:
        r5.B.failed(r10);
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public a0 handshake() {
        return this.handshake;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        monitor-enter(this);
        this.successCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean isEligible$okhttp(a r5, List<x0> r10) {
        Intrinsics.checkNotNullParameter(r5, "address");
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.calls.size() < this.allocationLimit) goto L12;
    L35:
        return false;
    L12:
        if (this.noNewExchanges == true) goto L35;
        if (this.route.f20764a.a(r5) == true) goto L17;
        return false;
    L17:
        e0 r11 = r5.f20610a;
        if (Intrinsics.areEqual(r11.e, route().f20764a.f20610a.e) == false) goto L21;
        return true;
    L21:
        if (this.http2Connection != null) goto L23;
        return false;
    L23:
        if (r10 == null) goto L35;
        if (routeMatchesAny(r10) == false) goto L35;
        if (r5.g == OkHostnameVerifier.INSTANCE) goto L31;
        return false;
    L31:
        if (supportsUrl(r11) == true) goto L37;
        return false;
    L37:
        okhttp3.k r12 = r5.f20613h;     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.checkNotNull(r12);     // Catch: SSLPeerUnverifiedException -> L36
        String r13 = r11.e;     // Catch: SSLPeerUnverifiedException -> L36
        a0 r14 = handshake();     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.checkNotNull(r14);     // Catch: SSLPeerUnverifiedException -> L36
        r12.a(r13, r14.a());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    public final boolean isHealthy(boolean r10) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        long r5 = System.nanoTime();
        Socket r11 = this.rawSocket;
        Intrinsics.checkNotNull(r11);
        Socket r12 = this.socket;
        Intrinsics.checkNotNull(r12);
        l r13 = this.source;
        Intrinsics.checkNotNull(r13);
        if (r11.isClosed() == false) goto L12;
        return false;
    L12:
        if (r12.isClosed() == false) goto L14;
        return false;
    L14:
        if (r12.isInputShutdown() == false) goto L16;
        return false;
    L16:
        if (r12.isOutputShutdown() == true) goto L43;
        Http2Connection r14 = this.http2Connection;
        if (r14 != null) goto L21;
        monitor-enter(this);
        long r15 = r5 - this.idleAtNs;
        monitor-exit(this);
        if (r15 < IDLE_CONNECTION_HEALTHY_NS) goto L31;
        if (r10 == true) goto L30;
        return true;
    L30:
        return Util.isHealthy(r12, r13);
    L31:
        return true;
    L33:
        th = move-exception;
        throw th;
    L21:
        return r14.isHealthy(r5);
    L43:
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean isMultiplexed$okhttp() {
        if (this.http2Connection == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient r10, RealInterceptorChain r11) throws SocketException {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "chain");
        Socket r5 = this.socket;
        Intrinsics.checkNotNull(r5);
        l r12 = this.source;
        Intrinsics.checkNotNull(r12);
        k r13 = this.sink;
        Intrinsics.checkNotNull(r13);
        Http2Connection r14 = this.http2Connection;
        if (r14 != null) goto L7;
        r5.setSoTimeout(r11.readTimeoutMillis());
        f0 r15 = r12.timeout();
        long r16 = r11.getReadTimeoutMillis$okhttp();
        TimeUnit r17 = TimeUnit.MILLISECONDS;
        r15.timeout(r16, r17);
        r13.timeout().timeout(r11.getWriteTimeoutMillis$okhttp(), r17);
        return new Http1ExchangeCodec(r10, this, r12, r13);
    L7:
        return new Http2ExchangeCodec(r10, this, r11, r14);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(final Exchange r10) throws SocketException {
        Intrinsics.checkNotNullParameter(r10, "exchange");
        Socket r5 = this.socket;
        Intrinsics.checkNotNull(r5);
        final l r11 = this.source;
        Intrinsics.checkNotNull(r11);
        final k r12 = this.sink;
        Intrinsics.checkNotNull(r12);
        r5.setSoTimeout(0);
        noNewExchanges$okhttp();
        final boolean r13 = true;
        return new RealConnection$newWebSocketStreams$1(r10, r11, r12, r13, r11, r12);
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        monitor-enter(this);
        this.noCoalescedConnections = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void noNewExchanges$okhttp() {
        monitor-enter(this);
        this.noNewExchanges = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void onSettings(Http2Connection r5, Settings r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r10, "settings");     // Catch: Throwable -> L6
        this.allocationLimit = r10.getMaxConcurrentStreams();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "stream");
        r5.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.n
    public Protocol protocol() {
        Protocol r5 = this.protocol;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public x0 route() {
        return this.route;
    }

    public final void setIdleAtNs$okhttp(long r5) {
        this.idleAtNs = r5;
    }

    public final void setNoNewExchanges(boolean r5) {
        this.noNewExchanges = r5;
    }

    public final void setRouteFailureCount$okhttp(int r5) {
        this.routeFailureCount = r5;
    }

    public Socket socket() {
        Socket r5 = this.socket;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Connection{");
        r5.append(this.route.f20764a.f20610a.e);
        r5.append(':');
        r5.append(this.route.f20764a.f20610a.f);
        r5.append(", proxy=");
        r5.append(this.route.f20765b);
        r5.append(" hostAddress=");
        r5.append(this.route.f20766c);
        r5.append(" cipherSuite=");
        a0 r10 = this.handshake;
        if (r10 == null) goto L7;
        Object r11 = r10.f20618c;
        if (r11 == null) goto L7;
    L8:
        r5.append(r11);
        r5.append(" protocol=");
        r5.append(this.protocol);
        r5.append('}');
        return r5.toString();
    L7:
        r11 = "none";
        goto L8
    }

    public final synchronized void trackFailure$okhttp(RealCall r5, IOException r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L10
        if ((r10 instanceof StreamResetException) == false) goto L19;
        if (((StreamResetException) r10).errorCode != ErrorCode.REFUSED_STREAM) goto L13;
        int r11 = this.refusedStreamCount + 1;     // Catch: Throwable -> L10
        this.refusedStreamCount = r11;     // Catch: Throwable -> L10
        if (r11 <= 1) goto L27;
        this.noNewExchanges = true;     // Catch: Throwable -> L10
        this.routeFailureCount++;     // Catch: Throwable -> L10
    L27:
        monitor-exit(this);
        return;
    L13:
        if (((StreamResetException) r10).errorCode == ErrorCode.CANCEL) goto L15;
    L17:
        this.noNewExchanges = true;     // Catch: Throwable -> L10
        this.routeFailureCount++;     // Catch: Throwable -> L10
        goto L27
    L15:
        if (r5.isCanceled() == false) goto L17;
    L19:
        if (isMultiplexed$okhttp() == true) goto L21;
    L22:
        this.noNewExchanges = true;     // Catch: Throwable -> L10
        if (this.successCount != 0) goto L27;
        if (r10 == null) goto L26;
        connectFailed$okhttp(r5.getClient(), this.route, r10);     // Catch: Throwable -> L10
    L26:
        this.routeFailureCount++;     // Catch: Throwable -> L10
        goto L27
    L21:
        if ((r10 instanceof ConnectionShutdownException) == false) goto L27;
    L10:
        th = move-exception;
        throw th;
    }
}
