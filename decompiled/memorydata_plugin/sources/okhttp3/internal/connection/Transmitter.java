package okhttp3.internal.connection;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001 \u0018\u00002\u00020\u0001:\u0001FB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010#\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020\tJ\u0006\u0010'\u001a\u00020$J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0006\u0010,\u001a\u00020$J;\u0010-\u001a\u0002H.\"\n\b\u0000\u0010.*\u0004\u0018\u00010/2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u0002H.H\u0000¢\u0006\u0004\b3\u00104J\u0006\u00105\u001a\u00020\tJ)\u00106\u001a\u0002H.\"\n\b\u0000\u0010.*\u0004\u0018\u00010/2\u0006\u00102\u001a\u0002H.2\u0006\u00107\u001a\u00020\tH\u0002¢\u0006\u0002\u00108J\u001d\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\tH\u0000¢\u0006\u0002\b=J\u0012\u0010\u001c\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u00010/J\u000e\u0010>\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010?\u001a\u0004\u0018\u00010@J\u0006\u0010\u001f\u001a\u00020AJ\u0006\u0010\"\u001a\u00020$J\u0006\u0010B\u001a\u00020$J!\u0010C\u001a\u0002H.\"\n\b\u0000\u0010.*\u0004\u0018\u00010/2\u0006\u0010D\u001a\u0002H.H\u0002¢\u0006\u0002\u0010ER\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lokhttp3/internal/connection/Transmitter;", "", "client", "Lokhttp3/OkHttpClient;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "(Lokhttp3/OkHttpClient;Lokhttp3/Call;)V", "callStackTrace", "canceled", "", WsConstants.KEY_CONNECTION, "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "setConnection", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "eventListener", "Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeRequestDone", "exchangeResponseDone", "isCanceled", "()Z", "noMoreExchanges", Ext.KEY_REQUEST, "Lokhttp3/Request;", LocationMonitorConst.TIMEOUT, "okhttp3/internal/connection/Transmitter$timeout$1", "Lokhttp3/internal/connection/Transmitter$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callStart", "canRetry", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "exchangeDoneDueToException", "exchangeMessageDone", ExifInterface.LONGITUDE_EAST, "Ljava/io/IOException;", "requestDone", "responseDone", "e", "exchangeMessageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "hasExchange", "maybeReleaseConnection", "force", "(Ljava/io/IOException;Z)Ljava/io/IOException;", "newExchange", "chain", "Lokhttp3/Interceptor$Chain;", "doExtensiveHealthChecks", "newExchange$okhttp", "prepareToConnect", "releaseConnectionNoEvents", "Ljava/net/Socket;", "Lokio/Timeout;", "timeoutEnter", "timeoutExit", "cause", "(Ljava/io/IOException;)Ljava/io/IOException;", "TransmitterReference", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Transmitter {
    private final Call call;
    private Object callStackTrace;
    private boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean noMoreExchanges;
    private Request request;
    private final AnonymousClass1 timeout;
    private boolean timeoutEarlyExit;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/Transmitter$TransmitterReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/Transmitter;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/Transmitter;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class TransmitterReference extends WeakReference<Transmitter> {
        private final Object callStackTrace;

        public TransmitterReference(Transmitter r2, Object r3) {
            Intrinsics.checkParameterIsNotNull(r2, "referent");
            super(r2);
            this.callStackTrace = r3;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [okhttp3.internal.connection.Transmitter$timeout$1] */
    public Transmitter(OkHttpClient r3, Call r4) {
        Call r5 = (Call) ZeusTransformUtils.wrapperContextForParams(r4, Call.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "client");
        Intrinsics.checkParameterIsNotNull(r5, NotificationCompat.CATEGORY_CALL);
        this.client = r3;
        this.call = r5;
        this.connectionPool = r3.connectionPool().getDelegate$okhttp();
        this.eventListener = r3.eventListenerFactory().create(r5);
        ?? r6 = new AnonymousClass1(this);
        r6.timeout(r3.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = r6;
    }

    private final Address createAddress(HttpUrl r19) {
        SSLSocketFactory r1 = (SSLSocketFactory) ZeusTransformUtils.preCheckCast(null, SSLSocketFactory.class, "com.obric.memorydata.plugin");
        HostnameVerifier r4 = (HostnameVerifier) ZeusTransformUtils.preCheckCast(null, HostnameVerifier.class, "com.obric.memorydata.plugin");
        CertificatePinner r2 = (CertificatePinner) ZeusTransformUtils.preCheckCast(null, CertificatePinner.class, "com.obric.memorydata.plugin");
        if (r19.isHttps() == false) goto L5;
        r1 = this.client.sslSocketFactory();
        r4 = this.client.hostnameVerifier();
        r2 = this.client.certificatePinner();
    L5:
        CertificatePinner r12 = r2;
        String r6 = r19.host();
        int r7 = r19.port();
        Dns r8 = this.client.dns();
        SocketFactory r9 = this.client.socketFactory();
        return new Address(r6, r7, r8, r9, r1, r4, r12, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    /* JADX WARN: Type inference failed for: r4v15, types: [T, okhttp3.Connection] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, okhttp3.Connection] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final <E extends IOException> E maybeReleaseConnection(E r8, boolean r9) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        RealConnectionPool r1 = this.connectionPool;
        monitor-enter(r1);
        boolean r2 = false;
        if (r9 == true) goto L56;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L53;
        r0.element = (Connection) ZeusTransformUtils.preCheckCast(this.connection, Connection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (this.connection != null) goto L17;
    L22:
        Socket r10 = null;
    L24:
        if (this.connection == null) goto L27;
        r0.element = (Connection) ZeusTransformUtils.preCheckCast(null, Connection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L27:
        if (this.noMoreExchanges == true) goto L29;
    L31:
        boolean r5 = false;
    L32:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r1);
        if (r10 == null) goto L37;
        Util.closeQuietly(r10);
    L37:
        if (((Connection) ZeusTransformUtils.preCheckCast(r0.element, Connection.class, "com.obric.memorydata.plugin")) == null) goto L42;
        EventListener r11 = this.eventListener;
        Call r3 = this.call;
        Connection r7 = (Connection) ZeusTransformUtils.preCheckCast(r0.element, Connection.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        r11.connectionReleased(r3, r7);
    L42:
        if (r5 == false) goto L51;
        if (r8 == null) goto L45;
        r2 = true;
    L45:
        r8 = (E) timeoutExit(r8);
        EventListener r12 = this.eventListener;
        Call r13 = this.call;
        if (r2 == false) goto L50;
        if (r8 != null) goto L49;
        Intrinsics.throwNpe();
    L49:
        r12.callFailed(r13, r8);
        goto L51
    L50:
        r12.callEnd(r13);
    L51:
        return r8;
    L29:
        if (this.exchange != null) goto L31;
        r5 = true;
        goto L32
    L17:
        if (this.exchange != null) goto L22;
        if (r9 == false) goto L20;
    L21:
        r10 = releaseConnectionNoEvents();     // Catch: Throwable -> L10
        goto L24
    L20:
        if (this.noMoreExchanges == false) goto L22;
    L53:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("cannot release connection while it is in use".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L56:
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.exchange == null) goto L12;
        r4 = false;
        goto L13
    }

    private final <E extends IOException> E timeoutExit(E r3) {
        if (this.timeoutEarlyExit == false) goto L6;
        return r3;
    L6:
        if (exit() == true) goto L8;
        return r3;
    L8:
        InterruptedIOException r2 = new InterruptedIOException(LocationMonitorConst.TIMEOUT);
        if (r3 == null) goto L12;
        r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
    L12:
        return (E) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.memorydata.plugin");
    }

    public final void acquireConnectionNoEvents(RealConnection r3) {
        Intrinsics.checkParameterIsNotNull(r3, WsConstants.KEY_CONNECTION);
        Thread.holdsLock(this.connectionPool);
        if (this.connection != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.connection = r3;
        r3.getTransmitters().add(new TransmitterReference(this, this.callStackTrace));
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    public final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this.call);
    }

    public final boolean canRetry() {
        ExchangeFinder r0 = this.exchangeFinder;
        if (r0 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        if (r0.hasStreamFailure() == false) goto L13;
        ExchangeFinder r1 = this.exchangeFinder;
        if (r1 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        if (r1.hasRouteToTry() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final void cancel() {
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.canceled = true;     // Catch: Throwable -> L18
        Exchange r1 = this.exchange;     // Catch: Throwable -> L18
        ExchangeFinder r2 = this.exchangeFinder;     // Catch: Throwable -> L18
        if (r2 == null) goto L10;
        RealConnection r3 = r2.connectingConnection();     // Catch: Throwable -> L18
        if (r3 == null) goto L10;
    L11:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        if (r1 == null) goto L15;
        r1.cancel();
        return;
    L15:
        if (r3 == null) goto L24;
        r3.cancel();
        return;
    L24:
        return;
    L10:
        r3 = this.connection;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void exchangeDoneDueToException() {
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((!this.noMoreExchanges) == false) goto L10;
        this.exchange = (Exchange) ZeusTransformUtils.preCheckCast(null, Exchange.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    }

    public final <E extends IOException> E exchangeMessageDone$okhttp(Exchange r4, boolean r5, boolean r6, E r7) {
        Intrinsics.checkParameterIsNotNull(r4, "exchange");
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
    L36:
        th = move-exception;
        throw th;
    L5:
        boolean r1 = true;
        if ((!Intrinsics.areEqual(r4, this.exchange)) == false) goto L10;
        monitor-exit(r0);
        return r7;
    L10:
        if (r5 == false) goto L12;
        boolean r8 = !this.exchangeRequestDone;     // Catch: Throwable -> L36
        this.exchangeRequestDone = true;     // Catch: Throwable -> L36
    L13:
        if (r6 == false) goto L19;
        if (this.exchangeResponseDone == true) goto L17;
        r8 = true;
    L17:
        this.exchangeResponseDone = true;     // Catch: Throwable -> L36
    L19:
        if (this.exchangeRequestDone == true) goto L21;
    L30:
        r1 = false;
    L31:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r0);
        if (r1 == true) goto L35;
        return r7;
    L35:
        return (E) maybeReleaseConnection(r7, false);
    L21:
        if (this.exchangeResponseDone == false) goto L30;
        if (r8 == false) goto L30;
        Exchange r10 = this.exchange;     // Catch: Throwable -> L36
        if (r10 != null) goto L26;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L26:
        RealConnection r11 = r10.connection();     // Catch: Throwable -> L36
        if (r11 != null) goto L29;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L29:
        r11.setSuccessCount$okhttp(r11.getSuccessCount$okhttp() + 1);     // Catch: Throwable -> L36
        this.exchange = (Exchange) ZeusTransformUtils.preCheckCast(null, Exchange.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        goto L31
    L12:
        r8 = false;
        goto L13
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final boolean hasExchange() {
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        if (this.exchange == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);
        return r1;
    L7:
        r1 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final boolean isCanceled() {
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        boolean r1 = this.canceled;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final Exchange newExchange$okhttp(Interceptor.Chain r11, boolean r12) {
        Interceptor.Chain r13 = (Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r11, Interceptor.Chain.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r13, "chain");
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        boolean r2 = true;
        if ((!this.noMoreExchanges) == false) goto L30;
        if (this.exchange == null) goto L10;
        r2 = false;
    L10:
        if (r2 == false) goto L28;
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r0);
        ExchangeFinder r3 = this.exchangeFinder;
        if (r3 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        ExchangeCodec r9 = r3.find(this.client, r13, r12);
        Call r6 = this.call;
        EventListener r7 = this.eventListener;
        ExchangeFinder r8 = this.exchangeFinder;
        if (r8 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        Exchange r14 = new Exchange(this, r6, r7, r8, r9);
        RealConnectionPool r15 = this.connectionPool;
        monitor-enter(r15);
        this.exchange = r14;     // Catch: Throwable -> L24
        this.exchangeRequestDone = false;     // Catch: Throwable -> L24
        this.exchangeResponseDone = false;     // Catch: Throwable -> L24
        monitor-exit(r15);
        return r14;
    L24:
        th = move-exception;
        throw th;
    L28:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
    L30:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("released".toString()), Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public final IOException noMoreExchanges(IOException r3) {
        RealConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.noMoreExchanges = true;     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        return maybeReleaseConnection(r3, false);
    L9:
        th = move-exception;
        throw th;
    }

    public final void prepareToConnect(Request r8) {
        Intrinsics.checkParameterIsNotNull(r8, Ext.KEY_REQUEST);
        Request r0 = this.request;
        if (r0 == null) goto L25;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        if (Util.canReuseConnectionFor(r0.url(), r8.url()) == false) goto L15;
        ExchangeFinder r1 = this.exchangeFinder;
        if (r1 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        if (r1.hasRouteToTry() == false) goto L15;
        return;
    L15:
        if (this.exchange != null) goto L17;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L24;
        if (this.exchangeFinder == null) goto L25;
        maybeReleaseConnection(null, true);
        this.exchangeFinder = (ExchangeFinder) ZeusTransformUtils.preCheckCast(null, ExchangeFinder.class, "com.obric.memorydata.plugin");
        goto L25
    L24:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        r2 = false;
    L25:
        this.request = r8;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(r8.url()), this.call, this.eventListener);
    }

    public final Socket releaseConnectionNoEvents() {
        Thread.holdsLock(this.connectionPool);
        RealConnection r1 = this.connection;
        if (r1 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        Iterator<Reference<Transmitter>> r2 = r1.getTransmitters().iterator();
        boolean r3 = false;
        int r4 = 0;
    L7:
        if (r2.hasNext() == false) goto L12;
        if (Intrinsics.areEqual((Transmitter) ZeusTransformUtils.preCheckCast(((Reference) ZeusTransformUtils.preCheckCast(r2.next(), Reference.class, "com.obric.memorydata.plugin")).get(), Transmitter.class, "com.obric.memorydata.plugin"), (Transmitter) ZeusTransformUtils.preCheckCast(this, Transmitter.class, "com.obric.memorydata.plugin")) == true) goto L13;
        r4 = r4 + 1;
    L13:
        if (r4 == (-1)) goto L15;
        r3 = true;
    L15:
        if (r3 == false) goto L27;
        RealConnection r0 = this.connection;
        if (r0 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r0.getTransmitters().remove(r4);
        this.connection = (RealConnection) ZeusTransformUtils.preCheckCast(null, RealConnection.class, "com.obric.memorydata.plugin");
        if (r0.getTransmitters().isEmpty() == false) goto L25;
        r0.setIdleAtNanos$okhttp(System.nanoTime());
        if (this.connectionPool.connectionBecameIdle(r0) == false) goto L25;
        return r0.socket();
    L25:
        return null;
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L12:
        r4 = -1;
        goto L13
    }

    public final void setConnection(RealConnection r1) {
        this.connection = r1;
    }

    public final Timeout timeout() {
        return (Timeout) ZeusTransformUtils.preCheckCast(this.timeout, Timeout.class, "com.obric.memorydata.plugin");
    }

    public final void timeoutEarlyExit() {
        if ((!this.timeoutEarlyExit) == false) goto L7;
        this.timeoutEarlyExit = true;
        exit();
        return;
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Check failed.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void timeoutEnter() {
        enter();
    }
}
