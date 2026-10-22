package ze;

import cf.o;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.userAware.report.SubwayEvaluationEvent;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import jf.q;
import jf.r;
import jf.x;
import we.a0;
import we.d0;
import we.h;
import we.i;
import we.j;
import we.p;
import we.v;
import we.w;
import we.y;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends cf.g.f implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f14373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f14374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Socket f14375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Socket f14376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f14377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w f14378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cf.g f14379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f14380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f14381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f14385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f14386o;

    public d(i r8, d0 r10) {
        this.f14384m = 1;
        this.f14385n = new ArrayList();
        this.f14386o = Long.MAX_VALUE;
        this.f14373b = r8;
        this.f14374c = r10;
    }

    @Override // cf.g.f
    public final void a(cf.g r8) {
        i r10 = this.f14373b;
        monitor-enter(r10);
        monitor-enter(r8);     // Catch: Throwable -> L14
        p.f r11 = r8.D;     // Catch: Throwable -> L16
        if ((r11.f9887a & 16) == 0) goto L9;
        int r12 = ((int[]) r11.f9888b)[4];     // Catch: Throwable -> L16
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L14
        this.f14384m = r12;     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L9:
        r12 = Integer.MAX_VALUE;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // cf.g.f
    public final void b(o r8) {
        r8.f(cf.b.f3454p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [cf.g, java.net.Socket, jf.q, jf.r, we.p, we.w] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final void c(int r18, int r19, int r20, int r21, boolean r22, we.d r23, we.o r24) {
        if (this.f14378g != null) goto L114;
        we.a r8 = this.f14374c.f13158a;
        List<j> r10 = r8.f13108f;
        b r13 = new b(r10);
        if (r8.f13111i != null) goto L16;
        if (r10.contains(j.f13203f) == false) goto L14;
        String r11 = this.f14374c.f13158a.f13103a.f13244d;
        if (df.f.f7097a.k(r11) == false) goto L12;
    L17:
        ?? r12 = 0;
        e r14 = null;
    L18:
        boolean r15 = true;
        boolean r16 = false;
        d0 r17 = this.f14374c;     // Catch: IOException -> L72
        if (r17.f13158a.f13111i != null) goto L22;
    L24:
        boolean r25 = false;
    L25:
        if (r25 == false) goto L123;
        e(r18, r19, r20, r23, r24);     // Catch: IOException -> L72
        if (this.f14375d == null) goto L34;
    L125:
        f(r13, r21, r23, r24);     // Catch: IOException -> L68
        d0 r26 = this.f14374c;     // Catch: IOException -> L68
        r24.connectEnd(r23, r26.f13160c, r26.f13159b, this.f14378g);     // Catch: IOException -> L68
    L68:
        e = e;
    L74:
        xe.c.g(this.f14376e);
        xe.c.g(this.f14375d);
        this.f14376e = r12;
        this.f14375d = r12;
        this.f14380i = r12;
        this.f14381j = r12;
        this.f14377f = r12;
        this.f14378g = r12;
        this.f14379h = r12;
        d0 r27 = this.f14374c;
        r24.connectFailed(r23, r27.f13160c, r27.f13159b, null, e);
        d0 r28 = this.f14374c;
        e r29 = r14;
        ?? r30 = r12;
        b r31 = r13;
        r24.connectFailed(r23, r28.f13160c, r28.f13159b, null, e, r28.f13161d);
        if (r29 != null) goto L77;
        r14 = new e(e);
    L81:
        if (r22 == false) goto L110;
        r31.f14371d = true;
        if (r31.f14370c == true) goto L86;
    L108:
        if (r16 == false) goto L132;
        r12 = r30;
        r13 = r31;
        goto L18
    L132:
        throw r14;
    L86:
        if ((e instanceof ProtocolException) == true) goto L108;
        if ((e instanceof InterruptedIOException) == true) goto L108;
        boolean r32 = e instanceof SSLHandshakeException;
        if (r32 == false) goto L97;
        if ((e.getCause() instanceof CertificateException) == true) goto L108;
    L97:
        if ((e instanceof SSLPeerUnverifiedException) == true) goto L108;
        if (r32 == false) goto L101;
    L106:
        boolean r110 = true;
    L107:
        r16 = r110;
        goto L108
    L101:
        if ((e instanceof SSLProtocolException) == true) goto L106;
        if ((e instanceof SSLException) == true) goto L106;
        r110 = false;
        goto L107
    L110:
        throw r14;
    L77:
        IOException r33 = r29.f14387a;
        Method r34 = xe.c.f13895p;
        if (r34 != null) goto L116;
    L80:
        r29.f14388b = e;
        r14 = r29;
        goto L81
    L116:
        r34.invoke(r33, new Object[]{e});     // Catch: Throwable -> L115
    L34:
        d0 r35 = this.f14374c;
        if (r35.f13158a.f13111i != null) goto L37;
    L39:
        r15 = false;
    L40:
        if (r15 == false) goto L47;
        if (this.f14375d != null) goto L47;
        throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
    L47:
        if (this.f14379h == null) goto L67;
        i r36 = this.f14373b;
        monitor-enter(r36);
        cf.g r37 = this.f14379h;     // Catch: Throwable -> L64
        monitor-enter(r37);     // Catch: Throwable -> L64
        p.f r38 = r37.D;     // Catch: Throwable -> L61
        if ((r38.f9887a & 16) == 0) goto L56;
        int r39 = ((int[]) r38.f9888b)[4];     // Catch: Throwable -> L61
    L57:
        monitor-exit(r37);     // Catch: Throwable -> L64
        this.f14384m = r39;     // Catch: Throwable -> L64
        monitor-exit(r36);     // Catch: Throwable -> L64
        return;
    L56:
        r39 = Integer.MAX_VALUE;
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;
    L67:
        return;
    L37:
        if (r35.f13159b.type() != Proxy.Type.HTTP) goto L39;
    L123:
        d(r18, r19, r23, r24);     // Catch: IOException -> L70
    L70:
        e = e;
        goto L74
    L22:
        if (r17.f13159b.type() != Proxy.Type.HTTP) goto L24;
        r25 = true;
    L72:
        e = e;
        goto L74
    L12:
        throw new e(new UnknownServiceException(defpackage.b.d("CLEARTEXT communication to ", r11, " not permitted by network security policy")));
    L14:
        throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L16:
        if (r8.f13107e.contains(w.f13323p) == false) goto L17;
        throw new e(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
    L114:
        throw new IllegalStateException("already connected");
    }

    public final void d(int r8, int r10, we.d r11, we.o r12) {
        d0 r13 = this.f14374c;
        Proxy r14 = r13.f13159b;
        if (r14.type() != Proxy.Type.DIRECT) goto L5;
    L8:
        Socket r15 = r13.f13158a.f13105c.createSocket();
    L9:
        this.f14375d = r15;
        InetSocketAddress r16 = r13.f13160c;
        r12.connectStart(r11, r16, r14);
        this.f14375d.setSoTimeout(r10);
        df.f.f7097a.g(this.f14375d, r16, r8);     // Catch: ConnectException -> L19
        this.f14380i = new r(jf.p.d(this.f14375d));     // Catch: NullPointerException -> L13
        this.f14381j = new q(jf.p.b(this.f14375d));     // Catch: NullPointerException -> L13
        return;
    L13:
        e = move-exception;
        if ("throw with null exception".equals(e.getMessage()) == true) goto L18;
        return;
    L18:
        throw new IOException(e);
    L19:
        e = move-exception;
        ConnectException r17 = new ConnectException("Failed to connect to " + r16);
        r17.initCause(e);
        throw r17;
    L5:
        if (r14.type() == Proxy.Type.HTTP) goto L8;
        r15 = new Socket(r14);
        goto L9
    }

    public final void e(int r15, int r16, int r17, we.d r18, we.o r19) {
        y.a r8 = new y.a();
        d0 r10 = this.f14374c;
        r8.f(r10.f13158a.f13103a);
        r8.c(null, "CONNECT");
        we.a r11 = r10.f13158a;
        r8.f13347d.d("Host", xe.c.o(r11.f13103a, true));
        r8.f13347d.d("Proxy-Connection", "Keep-Alive");
        r8.f13347d.d("User-Agent", "okhttp/3.12.13.19");
        y r12 = r8.a();
        a0.a r13 = new a0.a();
        r13.f13126a = r12;
        r13.f13127b = w.f13320m;
        r13.f13128c = 407;
        r13.f13129d = "Preemptive Authenticate";
        r13.f13132g = xe.c.f13882c;
        r13.f13136k = -1;
        r13.f13137l = -1;
        r13.f13131f.d("Proxy-Authenticate", "OkHttp-Preemptive");
        r13.b();
        r11.f13106d.getClass();
        d(r15, r16, r18, r19);
        String r14 = "CONNECT " + xe.c.o(r12.f13337a, true) + " HTTP/1.1";
        r r20 = this.f14380i;
        bf.a r21 = new bf.a(null, null, r20, this.f14381j);
        TimeUnit r22 = TimeUnit.MILLISECONDS;
        r20.timeout().g(r16, r22);
        this.f14381j.timeout().g(r17, r22);
        r21.i(r12.c(), r14);
        r21.a();
        a0.a r23 = r21.e(false);
        r23.f(r12);
        a0 r24 = r23.b();
        long r25 = af.e.a(r24);
        if (r25 != (-1)) goto L5;
        r25 = 0;
    L5:
        bf.a.e r26 = r21.g(r25);
        xe.c.u(r26, Integer.MAX_VALUE, r22);
        r26.close();
        int r27 = r24.i();
        if (r27 == 200) goto L13;
        if (r27 != 407) goto L11;
        r10.a().b().getClass();
        throw new IOException("Failed to authenticate with proxy");
    L11:
        throw new IOException("Unexpected response code for CONNECT: " + r24.i());
    L13:
        if (this.f14380i.b().U() == false) goto L18;
        if (this.f14381j.b().U() == false) goto L18;
        return;
    L18:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    public final void f(b r10, int r11, we.d r12, we.o r13) {
        d0 r8 = this.f14374c;
        we.a r14 = r8.f13158a;
        if (r14.f13111i != null) goto L10;
        w r15 = w.f13323p;
        if (r14.f13107e.contains(r15) == false) goto L8;
        this.f14376e = this.f14375d;
        this.f14378g = r15;
        k(r11);
        return;
    L8:
        this.f14376e = this.f14375d;
        this.f14378g = w.f13320m;
        return;
    L10:
        r13.secureConnectStart(r12);
        we.a r16 = r8.f13158a;
        SSLSocketFactory r17 = r16.f13111i;
        we.r r18 = r16.f13103a;
        String r19 = null;
        SSLSocket r20 = (SSLSocket) r17.createSocket(this.f14375d, r18.f13244d, r18.f13245e, true);     // Catch: Throwable -> L43 AssertionError -> L45
        j r21 = r10.a(r20);     // Catch: Throwable -> L25 AssertionError -> L41
        String r22 = r18.f13244d;
        boolean r23 = r21.f13205b;
        if (r23 == false) goto L16;
        df.f.f7097a.f(r20, r22, r16.f13107e);     // Catch: Throwable -> L25 AssertionError -> L41
    L16:
        r20.startHandshake();     // Catch: Throwable -> L25 AssertionError -> L41
        SSLSession r24 = r20.getSession();     // Catch: Throwable -> L25 AssertionError -> L41
        p r25 = p.a(r24);     // Catch: Throwable -> L25 AssertionError -> L41
        boolean r26 = r16.f13112j.verify(r22, r24);     // Catch: Throwable -> L25 AssertionError -> L41
        List<Certificate> r27 = r25.f13236c;
        if (r26 == false) goto L21;
        r16.f13113k.a(r22, r27);     // Catch: Throwable -> L25 AssertionError -> L41
        if (r23 == false) goto L32;
        r19 = df.f.f7097a.i(r20);     // Catch: Throwable -> L25 AssertionError -> L41
    L32:
        this.f14376e = r20;     // Catch: Throwable -> L25 AssertionError -> L41
        this.f14380i = new r(jf.p.d(r20));     // Catch: Throwable -> L25 AssertionError -> L41
        this.f14381j = new q(jf.p.b(this.f14376e));     // Catch: Throwable -> L25 AssertionError -> L41
        this.f14377f = r25;     // Catch: Throwable -> L25 AssertionError -> L41
        if (r19 == null) goto L35;
        w r28 = w.a(r19);     // Catch: Throwable -> L25 AssertionError -> L41
    L36:
        this.f14378g = r28;     // Catch: Throwable -> L25 AssertionError -> L41
        df.f.f7097a.a(r20);
        r13.secureConnectEnd(r12, this.f14377f);
        if (this.f14378g != w.f13322o) goto L59;
        k(r11);
        return;
    L59:
        return;
    L35:
        r28 = w.f13320m;     // Catch: Throwable -> L25 AssertionError -> L41
        goto L36
    L21:
        if (r27.isEmpty() == true) goto L28;
        X509Certificate r29 = (X509Certificate) r27.get(0);     // Catch: Throwable -> L25 AssertionError -> L41
        throw new SSLPeerUnverifiedException("Hostname " + r22 + " not verified:\n    certificate: " + we.f.b(r29) + "\n    DN: " + r29.getSubjectDN().getName() + "\n    subjectAltNames: " + gf.c.a(r29));     // Catch: Throwable -> L25 AssertionError -> L41
    L28:
        throw new SSLPeerUnverifiedException("Hostname " + r22 + " not verified (no certificates)");     // Catch: Throwable -> L25 AssertionError -> L41
    L41:
        e = e;
    L47:
        if (xe.c.s(e) == true) goto L49;
        throw e;     // Catch: Throwable -> L43
    L49:
        throw new IOException(e);     // Catch: Throwable -> L43
    L25:
        th = th;
    L52:
        if (r20 == null) goto L54;
        df.f.f7097a.a(r20);
    L54:
        xe.c.g(r20);
        throw th;
    L43:
        th = th;
        r20 = null;
    L45:
        e = e;
        goto L47
    }

    public final p g() {
        return this.f14377f;
    }

    public final boolean h(we.a r8, @Nullable d0 r10) {
        if (this.f14385n.size() < this.f14384m) goto L5;
    L35:
        return false;
    L5:
        if (this.f14382k == true) goto L35;
        v.a r11 = xe.a.f13878a;
        d0 r12 = this.f14374c;
        we.a r13 = r12.f13158a;
        r11.getClass();
        if (r13.a(r8) == true) goto L10;
        return false;
    L10:
        we.r r14 = r8.f13103a;
        if (r14.f13244d.equals(r12.f13158a.f13103a.f13244d) == false) goto L14;
        return true;
    L14:
        if (this.f14379h != null) goto L16;
        return false;
    L16:
        if (r10 != null) goto L19;
        return false;
    L19:
        if (r10.f13159b.type() == Proxy.Type.DIRECT) goto L22;
        return false;
    L22:
        if (r12.f13159b.type() == Proxy.Type.DIRECT) goto L25;
        return false;
    L25:
        if (r12.f13160c.equals(r10.f13160c) == true) goto L28;
        return false;
    L28:
        if (r10.f13158a.f13112j == gf.c.f7831a) goto L31;
        return false;
    L31:
        if (l(r14) == true) goto L37;
        return false;
    L37:
        r8.f13113k.a(r14.f13244d, this.f14377f.f13236c);     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    public final boolean i() {
        if (this.f14379h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final af.c j(v r8, af.f r10, g r11) {
        if (this.f14379h != null) goto L5;
        this.f14376e.setSoTimeout(r10.g());
        x r12 = this.f14380i.timeout();
        long r13 = r10.g();
        TimeUnit r14 = TimeUnit.MILLISECONDS;
        r12.g(r13, r14);
        this.f14381j.timeout().g(r10.j(), r14);
        return new bf.a(r8, r11, this.f14380i, this.f14381j);
    L5:
        return new cf.f(r8, r10, r11, this.f14379h);
    }

    public final void k(int r8) {
        this.f14376e.setSoTimeout(0);
        cf.g.d r10 = new cf.g.d();
        Socket r11 = this.f14376e;
        String r12 = this.f14374c.f13158a.f13103a.f13244d;
        r r13 = this.f14380i;
        q r14 = this.f14381j;
        r10.f3522a = r11;
        r10.f3523b = r12;
        r10.f3524c = r13;
        r10.f3525d = r14;
        r10.f3526e = this;
        r10.f3527f = r8;
        cf.g r15 = new cf.g(r10);
        this.f14379h = r15;
        cf.p r16 = r15.F;
        monitor-enter(r16);
    L49:
        th = move-exception;
        throw th;
    L5:
        if (r16.f3592o == true) goto L48;
        if (r16.f3589b == false) goto L13;
        Logger r17 = cf.p.f3587q;     // Catch: Throwable -> L49
        if (r17.isLoggable(Level.FINE) == false) goto L12;
        r17.fine(xe.c.n(">> CONNECTION %s", new Object[]{cf.e.f3485a.f()}));     // Catch: Throwable -> L49
    L12:
        r16.f3588a.write(cf.e.f3485a.o());     // Catch: Throwable -> L49
        r16.f3588a.flush();     // Catch: Throwable -> L49
    L13:
        monitor-exit(r16);
        cf.p r18 = r15.F;
        p.f r19 = r15.C;
        monitor-enter(r18);
    L44:
        th = move-exception;
        throw th;
    L17:
        if (r18.f3592o == true) goto L43;
        r18.k(0, Integer.bitCount(r19.f9887a) * 6, (byte) 4, (byte) 0);     // Catch: Throwable -> L44
        int r20 = 0;
    L20:
        if (r20 >= 10) goto L35;
        if (((1 << r20) & r19.f9887a) == 0) goto L24;
        boolean r21 = true;
    L25:
        if (r21 == false) goto L34;
        if (r20 != 4) goto L30;
        int r22 = 3;
    L33:
        r18.f3588a.writeShort(r22);     // Catch: Throwable -> L44
        r18.f3588a.writeInt(((int[]) r19.f9888b)[r20]);     // Catch: Throwable -> L44
        goto L34
    L30:
        if (r20 != 7) goto L32;
        r22 = 4;
        goto L33
    L32:
        r22 = r20;
    L34:
        r20 = r20 + 1;     // Catch: Throwable -> L44
        goto L20
    L24:
        r21 = false;
        goto L25
    L35:
        r18.f3588a.flush();     // Catch: Throwable -> L44
        monitor-exit(r18);
        int r23 = r15.C.b();
        if (r23 == 65535) goto L40;
        r15.F.x(0, r23 - 65535);
    L40:
        new Thread(r15.G).start();
        return;
    L43:
        throw new IOException("closed");     // Catch: Throwable -> L44
    L48:
        throw new IOException("closed");     // Catch: Throwable -> L49
    }

    public final boolean l(we.r r8) {
        int r10 = r8.f13245e;
        we.r r11 = this.f14374c.f13158a.f13103a;
        if (r10 == r11.f13245e) goto L5;
        return false;
    L5:
        String r12 = r8.f13244d;
        if (r12.equals(r11.f13244d) == true) goto L13;
        p r13 = this.f14377f;
        if (r13 != null) goto L10;
        return false;
    L10:
        if (gf.c.c(r12, (X509Certificate) r13.f13236c.get(0)) == true) goto L12;
        return false;
    L12:
        return true;
    L13:
        return true;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("Connection{");
        d0 r10 = this.f14374c;
        r8.append(r10.f13158a.f13103a.f13244d);
        r8.append(BdimCategoryConstants.SEPARATOR_COLON);
        r8.append(r10.f13158a.f13103a.f13245e);
        r8.append(", proxy=");
        r8.append(r10.f13159b);
        r8.append(" hostAddress=");
        r8.append(r10.f13160c);
        r8.append(" cipherSuite=");
        p r11 = this.f14377f;
        if (r11 == null) goto L5;
        Object r12 = r11.f13235b;
    L6:
        r8.append(r12);
        r8.append(" protocol=");
        r8.append(this.f14378g);
        r8.append('}');
        return r8.toString();
    L5:
        r12 = SubwayEvaluationEvent.VERIFY_METHOD_NONE;
        goto L6
    }
}
