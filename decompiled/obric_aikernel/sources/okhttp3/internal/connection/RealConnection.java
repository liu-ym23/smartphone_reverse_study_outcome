package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.k;
import okhttp3.q;
import okhttp3.s;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;
import okio.g0;
import okio.t;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nRealConnection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealConnection.kt\nokhttp3/internal/connection/RealConnection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,770:1\n1#2:771\n608#3,4:772\n608#3,4:779\n615#3,4:783\n1747#4,3:776\n*S KotlinDebug\n*F\n+ 1 RealConnection.kt\nokhttp3/internal/connection/RealConnection\n*L\n534#1:772,4\n587#1:779,4\n653#1:783,4\n579#1:776,3\n*E\n"})
public final class RealConnection extends okhttp3.internal.http2.b.c implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b0 f11749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Socket f11750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Socket f11751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handshake f11752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Protocol f11753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private okhttp3.internal.http2.b f11754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private okio.f f11755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private okio.e f11756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f11759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f11760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11761n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f11762o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List<Reference<e>> f11763p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f11764q;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11765a = null;

        static {
            int[] r10 = new int[Proxy.Type.values().length];
            r10[Proxy.Type.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[Proxy.Type.HTTP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11765a = r10;
        }
    }

    static {
        new a(null);
    }

    public RealConnection(f r10, b0 r11) {
        Intrinsics.checkNotNullParameter(r10, "connectionPool");
        Intrinsics.checkNotNullParameter(r11, "route");
        this.f11749b = r11;
        this.f11762o = 1;
        this.f11763p = new ArrayList();
        this.f11764q = Long.MAX_VALUE;
    }

    private final boolean B(List<b0> r10) {
        if ((r10 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L19;
        b0 r12 = (b0) r11.next();
        if (r12.c().type() == Proxy.Type.DIRECT) goto L13;
    L17:
        boolean r13 = false;
    L18:
        if (r13 == false) goto L9;
        return true;
    L13:
        if (this.f11749b.c().type() != Proxy.Type.DIRECT) goto L17;
        if (Intrinsics.areEqual(this.f11749b.e(), r12.e()) == false) goto L17;
        r13 = true;
    L19:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }

    private final void E(int r10) {
        Socket r11 = this.f11751d;
        Intrinsics.checkNotNull(r11);
        okio.f r12 = this.f11755h;
        Intrinsics.checkNotNull(r12);
        okio.e r13 = this.f11756i;
        Intrinsics.checkNotNull(r13);
        r11.setSoTimeout(0);
        okhttp3.internal.http2.b r14 = new okhttp3.internal.http2.b.a(true, jc.e.f9926i).q(r11, this.f11749b.a().m().h(), r12, r13).k(this).l(r10).a();
        this.f11754g = r14;
        this.f11762o = okhttp3.internal.http2.b.H.a().d();
        okhttp3.internal.http2.b.t0(r14, false, null, 3, null);
    }

    private final boolean F(s r10) {
        if (hc.e.f9283g == true) goto L5;
    L9:
        s r11 = this.f11749b.a().m();
        if (r10.n() == r11.n()) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r10.h(), r11.h()) == false) goto L16;
        return true;
    L16:
        if (this.f11758k == true) goto L23;
        Handshake r12 = this.f11752e;
        if (r12 == null) goto L24;
        Intrinsics.checkNotNull(r12);
        if (g(r10, r12) == true) goto L22;
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

    public static final /* synthetic */ Handshake e(RealConnection r10) {
        return r10.f11752e;
    }

    private final boolean g(s r10, Handshake r11) {
        List<Certificate> r12 = r11.d();
        if ((!r12.isEmpty()) == false) goto L8;
        qc.d r13 = qc.d.f12506a;
        String r14 = r10.h();
        Certificate r15 = r12.get(0);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        if (r13.e(r14, (X509Certificate) r15) == false) goto L8;
        return true;
    L8:
        return false;
    }

    private final void j(int r10, int r11, okhttp3.e r12, q r13) {
        Proxy r14 = this.f11749b.c();
        okhttp3.a r15 = this.f11749b.a();
        Proxy.Type r16 = r14.type();
        if (r16 != null) goto L5;
        int r17 = -1;
    L7:
        if (r17 != 1) goto L9;
    L11:
        Socket r18 = r15.j().createSocket();
        Intrinsics.checkNotNull(r18);
    L12:
        this.f11750c = r18;
        r13.l(r12, this.f11749b.e(), r14);
        r18.setSoTimeout(r11);
        okhttp3.internal.platform.h.f11979a.g().f(r18, this.f11749b.e(), r10);     // Catch: ConnectException -> L22
        this.f11755h = t.b(t.h(r18));     // Catch: NullPointerException -> L16
        this.f11756i = t.a(t.e(r18));     // Catch: NullPointerException -> L16
        return;
    L16:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), "throw with null exception") == true) goto L21;
        return;
    L21:
        throw new IOException(e);
    L22:
        e = move-exception;
        ConnectException r19 = new ConnectException("Failed to connect to " + this.f11749b.e());
        r19.initCause(e);
        throw r19;
    L9:
        if (r17 == 2) goto L11;
        r18 = new Socket(r14);
        goto L12
    L5:
        r17 = b.f11765a[r16.ordinal()];
        goto L7
    }

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
    private final void k(okhttp3.internal.connection.b r11) {
        final okhttp3.a r10 = this.f11749b.a();
        SSLSocketFactory r12 = r10.k();
        SSLSocket r13 = null;
        String r14 = null;
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L27
        Socket r15 = r12.createSocket(this.f11750c, r10.m().h(), r10.m().n(), true);     // Catch: Throwable -> L27
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");     // Catch: Throwable -> L27
        SSLSocket r16 = (SSLSocket) r15;     // Catch: Throwable -> L27
        k r17 = r11.a(r16);     // Catch: Throwable -> L25
        if (r17.h() == false) goto L7;
        okhttp3.internal.platform.h.f11979a.g().e(r16, r10.m().h(), r10.f());     // Catch: Throwable -> L25
    L7:
        r16.startHandshake();     // Catch: Throwable -> L25
        SSLSession r18 = r16.getSession();     // Catch: Throwable -> L25
        Handshake.Companion r19 = Handshake.f11661e;     // Catch: Throwable -> L25
        Intrinsics.checkNotNullExpressionValue(r18, "sslSocketSession");     // Catch: Throwable -> L25
        final Handshake r20 = r19.a(r18);     // Catch: Throwable -> L25
        HostnameVerifier r21 = r10.e();     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L25
        if (r21.verify(r10.m().h(), r18) == true) goto L15;
        List<Certificate> r110 = r20.d();     // Catch: Throwable -> L25
        if ((!r110.isEmpty()) == false) goto L14;
        Certificate r111 = r110.get(0);     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: Throwable -> L25
        X509Certificate r112 = (X509Certificate) r111;     // Catch: Throwable -> L25
        throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n              |Hostname " + r10.m().h() + " not verified:\n              |    certificate: " + CertificatePinner.f11653c.a(r112) + "\n              |    DN: " + r112.getSubjectDN().getName() + "\n              |    subjectAltNames: " + qc.d.f12506a.a(r112) + "\n              ", null, 1, null));     // Catch: Throwable -> L25
    L14:
        throw new SSLPeerUnverifiedException("Hostname " + r10.m().h() + " not verified (no certificates)");     // Catch: Throwable -> L25
    L15:
        final CertificatePinner r22 = r10.a();     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L25
        this.f11752e = new Handshake(r20.e(), r20.a(), r20.c(), new RealConnection$connectTls$1(r22, r20, r10));     // Catch: Throwable -> L25
        r22.b(r10.m().h(), new RealConnection$connectTls$2(this));     // Catch: Throwable -> L25
        if (r17.h() == false) goto L18;
        r14 = okhttp3.internal.platform.h.f11979a.g().g(r16);     // Catch: Throwable -> L25
    L18:
        this.f11751d = r16;     // Catch: Throwable -> L25
        this.f11755h = t.b(t.h(r16));     // Catch: Throwable -> L25
        this.f11756i = t.a(t.e(r16));     // Catch: Throwable -> L25
        if (r14 == null) goto L21;
        Protocol r113 = Protocol.Companion.a(r14);     // Catch: Throwable -> L25
    L22:
        this.f11753f = r113;     // Catch: Throwable -> L25
        okhttp3.internal.platform.h.f11979a.g().b(r16);
        return;
    L21:
        r113 = Protocol.HTTP_1_1;     // Catch: Throwable -> L25
    L25:
        th = th;
        r13 = r16;
    L28:
        if (r13 == null) goto L30;
        okhttp3.internal.platform.h.f11979a.g().b(r13);
    L30:
        if (r13 == null) goto L32;
        hc.e.n(r13);
    L32:
        throw th;
    L27:
        th = th;
        goto L28
    }

    private final void l(int r10, int r11, int r12, okhttp3.e r13, q r14) {
        x r15 = n();
        s r16 = r15.l();
        int r17 = 0;
    L4:
        if (r17 >= 21) goto L12;
        j(r10, r11, r13, r14);
        r15 = m(r11, r12, r15, r16);
        if (r15 == null) goto L17;
        Socket r18 = this.f11750c;
        if (r18 == null) goto L11;
        hc.e.n(r18);
    L11:
        this.f11750c = null;
        this.f11756i = null;
        this.f11755h = null;
        r14.i(r13, this.f11749b.e(), this.f11749b.c(), null);
        r17 = r17 + 1;
        goto L4
    L17:
        return;
    }

    private final x m(int r10, int r11, x r12, s r13) {
        String r14 = "CONNECT " + hc.e.R(r13, true) + " HTTP/1.1";
    L3:
        okio.f r15 = this.f11755h;
        Intrinsics.checkNotNull(r15);
        okio.e r16 = this.f11756i;
        Intrinsics.checkNotNull(r16);
        lc.b r17 = new lc.b(null, this, r15, r16);
        TimeUnit r18 = TimeUnit.MILLISECONDS;
        r15.timeout().g(r10, r18);
        r16.timeout().g(r11, r18);
        r17.A(r12.e(), r14);
        r17.a();
        z.a r19 = r17.d(false);
        Intrinsics.checkNotNull(r19);
        z r110 = r19.r(r12).c();
        r17.z(r110);
        int r20 = r110.k();
        if (r20 == 200) goto L18;
        if (r20 != 407) goto L16;
        x r21 = this.f11749b.a().h().a(this.f11749b, r110);
        if (r21 == null) goto L14;
        if (StringsKt.equals("close", z.s(r110, "Connection", null, 2, null), true) == true) goto L11;
        r12 = r21;
        goto L3
    L11:
        return r21;
    L14:
        throw new IOException("Failed to authenticate with proxy");
    L16:
        throw new IOException("Unexpected response code for CONNECT: " + r110.k());
    L18:
        if (r15.b().n() == false) goto L23;
        if (r16.b().n() == false) goto L23;
        return null;
    L23:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private final x n() {
        x r10 = new x.a().l(this.f11749b.a().m()).f("CONNECT", null).d("Host", hc.e.R(this.f11749b.a().m(), true)).d("Proxy-Connection", "Keep-Alive").d("User-Agent", hc.f.a()).b();
        z r11 = new z.a().r(r10).p(Protocol.HTTP_1_1).g(407).m("Preemptive Authenticate").b(hc.e.f9279c).s(-1).q(-1).j("Proxy-Authenticate", "OkHttp-Preemptive").c();
        x r12 = this.f11749b.a().h().a(this.f11749b, r11);
        if (r12 != null) goto L6;
        return r10;
    L6:
        return r12;
    }

    private final void o(okhttp3.internal.connection.b r10, int r11, okhttp3.e r12, q r13) {
        if (this.f11749b.a().k() != null) goto L10;
        List<Protocol> r14 = this.f11749b.a().f();
        Protocol r15 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (r14.contains(r15) == false) goto L8;
        this.f11751d = this.f11750c;
        this.f11753f = r15;
        E(r11);
        return;
    L8:
        this.f11751d = this.f11750c;
        this.f11753f = Protocol.HTTP_1_1;
        return;
    L10:
        r13.F(r12);
        k(r10);
        r13.E(r12, this.f11752e);
        if (this.f11753f != Protocol.HTTP_2) goto L14;
        E(r11);
        return;
    }

    public final synchronized void A() {
        monitor-enter(this);
        this.f11757j = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void C(long r10) {
        this.f11764q = r10;
    }

    public final void D(boolean r10) {
        this.f11757j = r10;
    }

    public final synchronized void G(e r10, IOException r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L28
        if ((r11 instanceof StreamResetException) == false) goto L17;
        if (((StreamResetException) r11).errorCode != ErrorCode.REFUSED_STREAM) goto L12;
        int r12 = this.f11761n + 1;     // Catch: Throwable -> L28
        this.f11761n = r12;     // Catch: Throwable -> L28
        if (r12 <= 1) goto L26;
        this.f11757j = true;     // Catch: Throwable -> L28
        int r13 = this.f11759l;     // Catch: Throwable -> L28
    L10:
        this.f11759l = r13 + 1;     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return;
    L12:
        if (((StreamResetException) r11).errorCode == ErrorCode.CANCEL) goto L14;
    L15:
        this.f11757j = true;     // Catch: Throwable -> L28
        r13 = this.f11759l;     // Catch: Throwable -> L28
        goto L10
    L14:
        if (r10.isCanceled() == true) goto L26;
    L17:
        if (x() == true) goto L19;
    L20:
        this.f11757j = true;     // Catch: Throwable -> L28
        if (this.f11760m != 0) goto L26;
        if (r11 == null) goto L24;
        i(r10.l(), this.f11749b, r11);     // Catch: Throwable -> L28
    L24:
        r13 = this.f11759l;     // Catch: Throwable -> L28
        goto L10
    L19:
        if ((r11 instanceof ConnectionShutdownException) == false) goto L26;
    L28:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.i
    public b0 a() {
        return this.f11749b;
    }

    @Override // okhttp3.i
    public Socket b() {
        Socket r10 = this.f11751d;
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    @Override // okhttp3.internal.http2.b.c
    public synchronized void c(okhttp3.internal.http2.b r10, mc.g r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r11, "settings");     // Catch: Throwable -> L6
        this.f11762o = r11.d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.b.c
    public void d(mc.d r10) {
        Intrinsics.checkNotNullParameter(r10, "stream");
        r10.d(ErrorCode.REFUSED_STREAM, null);
    }

    public final void f() {
        Socket r10 = this.f11750c;
        if (r10 == null) goto L6;
        hc.e.n(r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.net.Socket, okhttp3.Handshake, okhttp3.Protocol, okhttp3.internal.http2.b, okio.e, okio.f] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r1v14 */
    public final void h(int r17, int r18, int r19, int r20, boolean r21, okhttp3.e r22, q r23) {
        q r14 = r23;
        Intrinsics.checkNotNullParameter(r22, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r14, "eventListener");
        int r13 = 1;
        if (this.f11753f != null) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L65;
        List<k> r11 = this.f11749b.a().b();
        okhttp3.internal.connection.b r12 = new okhttp3.internal.connection.b(r11);
        if (this.f11749b.a().k() != null) goto L19;
        if (r11.contains(k.f11987i) == false) goto L17;
        String r15 = this.f11749b.a().m().h();
        if (okhttp3.internal.platform.h.f11979a.g().i(r15) == false) goto L15;
    L20:
        ?? r16 = 0;
        RouteException r110 = null;
    L68:
    L44:
        e = e;
    L47:
        Socket r24 = this.f11751d;
        if (r24 == null) goto L50;
        hc.e.n(r24);
    L50:
        Socket r25 = this.f11750c;
        if (r25 == null) goto L53;
        hc.e.n(r25);
    L53:
        this.f11751d = r16;
        this.f11750c = r16;
        this.f11755h = r16;
        this.f11756i = r16;
        this.f11752e = r16;
        this.f11753f = r16;
        this.f11754g = r16;
        this.f11762o = r13;
        r23.j(r22, this.f11749b.e(), this.f11749b.c(), null, e);
        RouteException r26 = r110;
        ?? r27 = r16;
        okhttp3.internal.connection.b r28 = r12;
        int r29 = r13;
        r23.k(r22, this.f11749b.e(), this.f11749b.c(), null, e, this.f11749b.b());
        if (r26 != null) goto L56;
        r110 = new RouteException(e);
    L57:
        if (r21 == false) goto L61;
        if (r28.b(e) == false) goto L76;
        r14 = r23;
        r16 = r27;
        r12 = r28;
        r13 = r29;
        goto L68
    L76:
        throw r110;
    L61:
        throw r110;
    L56:
        r26.addConnectException(e);
        r110 = r26;
        goto L57
    L22:
        if (this.f11749b.d() == false) goto L70;
        l(r17, r18, r19, r22, r23);     // Catch: IOException -> L44
        if (this.f11750c == null) goto L32;
    L66:
        o(r12, r20, r22, r14);     // Catch: IOException -> L40
        r14.i(r22, this.f11749b.e(), this.f11749b.c(), this.f11753f);     // Catch: IOException -> L40
    L40:
        e = e;
    L32:
        if (this.f11749b.d() == true) goto L34;
    L38:
        this.f11764q = System.nanoTime();
        return;
    L34:
        if (this.f11750c != null) goto L38;
        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
    L70:
        j(r17, r18, r22, r14);     // Catch: IOException -> L42
    L42:
        e = e;
        goto L47
    L15:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + r15 + " not permitted by network security policy"));
    L17:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L19:
        if (this.f11749b.a().f().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L20;
        throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
    L65:
        throw new IllegalStateException("already connected".toString());
    L5:
        r10 = false;
        goto L6
    }

    public final void i(w r10, b0 r11, IOException r12) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "failedRoute");
        Intrinsics.checkNotNullParameter(r12, "failure");
        if (r11.c().type() == Proxy.Type.DIRECT) goto L5;
        okhttp3.a r13 = r11.a();
        r13.i().connectFailed(r13.m().t(), r11.c().address(), r12);
    L5:
        r10.u().b(r11);
    }

    public final List<Reference<e>> p() {
        return this.f11763p;
    }

    public final long q() {
        return this.f11764q;
    }

    public final boolean r() {
        return this.f11757j;
    }

    public final int s() {
        return this.f11759l;
    }

    public Handshake t() {
        return this.f11752e;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Connection{");
        r10.append(this.f11749b.a().m().h());
        r10.append(':');
        r10.append(this.f11749b.a().m().n());
        r10.append(", proxy=");
        r10.append(this.f11749b.c());
        r10.append(" hostAddress=");
        r10.append(this.f11749b.e());
        r10.append(" cipherSuite=");
        Handshake r11 = this.f11752e;
        if (r11 == null) goto L6;
        Object r12 = r11.a();
        if (r12 == null) goto L6;
    L7:
        r10.append(r12);
        r10.append(" protocol=");
        r10.append(this.f11753f);
        r10.append('}');
        return r10.toString();
    L6:
        r12 = "none";
        goto L7
    }

    public final synchronized void u() {
        monitor-enter(this);
        this.f11760m++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean v(okhttp3.a r10, List<b0> r11) {
        Intrinsics.checkNotNullParameter(r10, "address");
        if (hc.e.f9283g == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.f11763p.size() < this.f11762o) goto L12;
    L35:
        return false;
    L12:
        if (this.f11757j == true) goto L35;
        if (this.f11749b.a().d(r10) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r10.m().h(), a().a().m().h()) == false) goto L21;
        return true;
    L21:
        if (this.f11754g != null) goto L23;
        return false;
    L23:
        if (r11 == null) goto L35;
        if (B(r11) == false) goto L35;
        if (r10.e() == qc.d.f12506a) goto L31;
        return false;
    L31:
        if (F(r10.m()) == true) goto L37;
        return false;
    L37:
        CertificatePinner r12 = r10.a();     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.checkNotNull(r12);     // Catch: SSLPeerUnverifiedException -> L36
        String r13 = r10.m().h();     // Catch: SSLPeerUnverifiedException -> L36
        Handshake r14 = t();     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.checkNotNull(r14);     // Catch: SSLPeerUnverifiedException -> L36
        r12.a(r13, r14.d());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    public final boolean w(boolean r10) {
        if (hc.e.f9283g == true) goto L5;
    L9:
        long r11 = System.nanoTime();
        Socket r12 = this.f11750c;
        Intrinsics.checkNotNull(r12);
        Socket r13 = this.f11751d;
        Intrinsics.checkNotNull(r13);
        okio.f r14 = this.f11755h;
        Intrinsics.checkNotNull(r14);
        if (r12.isClosed() == false) goto L12;
        return false;
    L12:
        if (r13.isClosed() == false) goto L14;
        return false;
    L14:
        if (r13.isInputShutdown() == false) goto L16;
        return false;
    L16:
        if (r13.isOutputShutdown() == true) goto L43;
        okhttp3.internal.http2.b r15 = this.f11754g;
        if (r15 != null) goto L21;
        monitor-enter(this);
        long r16 = r11 - this.f11764q;
        monitor-exit(this);
        if (r16 < 10000000000L) goto L31;
        if (r10 == true) goto L30;
        return true;
    L30:
        return hc.e.F(r13, r14);
    L31:
        return true;
    L33:
        th = move-exception;
        throw th;
    L21:
        return r15.f0(r11);
    L43:
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean x() {
        if (this.f11754g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final kc.d y(w r10, kc.g r11) {
        Intrinsics.checkNotNullParameter(r10, "client");
        Intrinsics.checkNotNullParameter(r11, "chain");
        Socket r12 = this.f11751d;
        Intrinsics.checkNotNull(r12);
        okio.f r13 = this.f11755h;
        Intrinsics.checkNotNull(r13);
        okio.e r14 = this.f11756i;
        Intrinsics.checkNotNull(r14);
        okhttp3.internal.http2.b r15 = this.f11754g;
        if (r15 != null) goto L7;
        r12.setSoTimeout(r11.l());
        g0 r16 = r13.timeout();
        long r17 = r11.i();
        TimeUnit r18 = TimeUnit.MILLISECONDS;
        r16.g(r17, r18);
        r14.timeout().g(r11.k(), r18);
        return new lc.b(r10, this, r13, r14);
    L7:
        return new mc.c(r10, this, r11, r15);
    }

    public final synchronized void z() {
        monitor-enter(this);
        this.f11758k = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
