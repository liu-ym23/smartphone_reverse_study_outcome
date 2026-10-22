package ze;

import cf.s;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import we.d0;
import we.i;
import we.n;
import we.o;
import we.r;
import we.v;
import we.x;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final we.a f14400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f.a f14401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f14402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f14403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final we.d f14404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f14405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f14406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f14407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f14409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f14410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14411l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f14412m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14413n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public af.c f14414o;

    public static final class a extends WeakReference<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14415a;

        public a(g r8, Object r10) {
            super(r8);
            this.f14415a = r10;
        }
    }

    public g(i r8, we.a r10, we.d r11, o r12, Object r13) {
        this.f14413n = -1;
        this.f14403d = r8;
        this.f14400a = r10;
        this.f14404e = r11;
        this.f14405f = r12;
        xe.a.f13878a.getClass();
        this.f14407h = new f(r10, r8.f13199e, r11, r12);
        this.f14406g = r13;
    }

    public final void a(d r8, boolean r10) {
        if (this.f14409j != null) goto L7;
        this.f14409j = r8;
        this.f14410k = r10;
        r8.f14385n.add(new a(this, this.f14406g));
        return;
    L7:
        throw new IllegalStateException();
    }

    public final synchronized d b() {
        monitor-enter(this);
        d r8 = this.f14409j;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public final Socket c(boolean r8, boolean r10, boolean r11) {
        if (r11 == false) goto L5;
        this.f14414o = null;
    L5:
        boolean r12 = true;
        if (r10 == false) goto L8;
        this.f14411l = true;
    L8:
        d r13 = this.f14409j;
        if (r13 == null) goto L38;
        if (r8 == false) goto L13;
        r13.f14382k = true;
    L13:
        if (this.f14414o == null) goto L15;
        return null;
    L15:
        if (this.f14411l == false) goto L17;
    L18:
        ArrayList r14 = r13.f14385n;
        int r15 = r14.size();
        int r16 = 0;
    L19:
        if (r16 >= r15) goto L37;
        if (((Reference) r14.get(r16)).get() == this) goto L22;
        r16 = r16 + 1;
        goto L19
    L22:
        r14.remove(r16);
        if (this.f14409j.f14385n.isEmpty() == false) goto L33;
        this.f14409j.f14386o = System.nanoTime();
        v.a r17 = xe.a.f13878a;
        d r18 = this.f14409j;
        r17.getClass();
        i r19 = this.f14403d;
        r19.getClass();
        if (r18.f14382k == false) goto L27;
    L30:
        r19.f13198d.remove(r18);
    L31:
        if (r12 == false) goto L33;
        Socket r20 = this.f14409j.f14376e;
    L34:
        this.f14409j = null;
        return r20;
    L27:
        if (r19.f13195a == 0) goto L30;
        r19.notifyAll();
        r12 = false;
    L33:
        r20 = null;
        goto L34
    L37:
        throw new IllegalStateException();
    L17:
        if (r13.f14382k == true) goto L18;
        return null;
    L38:
        return null;
    }

    public final d d(int r26, int r27, int r28, boolean r29, int r30) {
        i r8 = this.f14403d;
        monitor-enter(r8);
    L192:
        th = move-exception;
        throw th;
    L5:
        if (this.f14411l == true) goto L191;
        if (this.f14414o != null) goto L189;
        if (this.f14412m == true) goto L187;
        d r10 = this.f14409j;     // Catch: Throwable -> L192
        String r11 = null;
        if (r10 != null) goto L13;
    L15:
        Socket r12 = null;
    L16:
        d r13 = this.f14409j;     // Catch: Throwable -> L192
        if (r13 == null) goto L19;
        r10 = null;
    L21:
        if (this.f14410k == true) goto L23;
        r10 = null;
    L23:
        if (r13 != null) goto L28;
        xe.a.f13878a.b(this.f14403d, this.f14400a, this, null);     // Catch: Throwable -> L192
        d r14 = this.f14409j;     // Catch: Throwable -> L192
        if (r14 == null) goto L27;
        r13 = r14;
        boolean r15 = true;
    L29:
        d0 r16 = null;
    L30:
        monitor-exit(r8);     // Catch: Throwable -> L192
        xe.c.g(r12);
        if (r10 == null) goto L34;
        this.f14405f.connectionReleased(this.f14404e, r10);
    L34:
        if (r15 == false) goto L36;
        this.f14405f.connectionAcquired(this.f14404e, r13);
    L36:
        if (r13 == null) goto L39;
        this.f14402c = this.f14409j.f14374c;
        return r13;
    L39:
        if (r16 != null) goto L127;
        f.a r17 = this.f14401b;
        if (r17 != null) goto L43;
    L44:
        f r18 = this.f14407h;
        if (r18.f14394f >= r18.f14393e.size()) goto L47;
        boolean r19 = true;
    L48:
        if (r19 == false) goto L50;
    L53:
        boolean r20 = true;
    L54:
        if (r20 == false) goto L126;
        ArrayList r21 = new ArrayList();
    L57:
        if (r18.f14394f >= r18.f14393e.size()) goto L59;
        boolean r22 = true;
    L60:
        if (r22 == false) goto L117;
        if (r18.f14394f >= r18.f14393e.size()) goto L64;
        boolean r23 = true;
    L65:
        we.a r110 = r18.f14389a;
        if (r23 == false) goto L115;
        List<Proxy> r24 = r18.f14393e;
        int r111 = r18.f14394f;
        r18.f14394f = r111 + 1;
        Proxy r25 = r24.get(r111);
        r18.f14395g = new ArrayList();
        if (r25.type() != Proxy.Type.DIRECT) goto L70;
    L81:
        r r112 = r110.f13103a;
        String r113 = r112.f13244d;
        int r114 = r112.f13245e;
    L82:
        if (r114 < 1) goto L113;
        if (r114 > 65535) goto L113;
        if (r25.type() != Proxy.Type.SOCKS) goto L88;
        r18.f14395g.add(InetSocketAddress.createUnresolved(r113, r114));
    L93:
        int r31 = r18.f14395g.size();
        int r115 = 0;
    L94:
        if (r115 >= r31) goto L107;
        d0 r116 = new d0(r18.f14389a, r25, r18.f14395g.get(r115));
        qd.a r117 = r18.f14390b;
        monitor-enter(r117);
        boolean r118 = ((Set) r117.f11296a).contains(r116);     // Catch: Throwable -> L103
        monitor-exit(r117);
        if (r118 == false) goto L101;
        r18.f14396h.add(r116);
    L102:
        r115 = r115 + 1;
        goto L94
    L101:
        r21.add(r116);
    L103:
        th = move-exception;
        throw th;
    L107:
        if (r21.isEmpty() == false) goto L117;
        r11 = null;
        goto L57
    L88:
        o r119 = r18.f14392d;
        we.d r120 = r18.f14391c;
        r119.dnsStart(r120, r113);
        new ArrayList();
        r110.getClass();
        n r121 = r110.f13104b;
        List<InetAddress> r122 = r121.lookup(r113);
        r119.dnsEnd(r120, r113, r122, r11);
        if (r122.isEmpty() == true) goto L111;
        r119.dnsEnd(r120, r113, r122);
        int r123 = r122.size();
        int r124 = 0;
    L91:
        if (r124 >= r123) goto L93;
        r18.f14395g.add(new InetSocketAddress(r122.get(r124), r114));
        r124 = r124 + 1;
        goto L91
    L111:
        throw new UnknownHostException(r121 + " returned no addresses for " + r113);
    L113:
        throw new SocketException("No route to " + r113 + BdimCategoryConstants.SEPARATOR_COLON + r114 + "; port is out of range");
    L70:
        if (r25.type() == Proxy.Type.SOCKS) goto L81;
        SocketAddress r125 = r25.address();
        if ((r125 instanceof InetSocketAddress) == false) goto L80;
        InetSocketAddress r126 = (InetSocketAddress) r125;
        InetAddress r127 = r126.getAddress();
        if (r127 != null) goto L77;
        r113 = r126.getHostName();
    L78:
        r114 = r126.getPort();
        goto L82
    L77:
        r113 = r127.getHostAddress();
        goto L78
    L80:
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + r125.getClass());
    L115:
        throw new SocketException("No route to " + r110.f13103a.f13244d + "; exhausted proxy configurations: " + r18.f14393e);
    L64:
        r23 = false;
    L117:
        if (r21.isEmpty() == false) goto L119;
        r21.addAll(r18.f14396h);
        r18.f14396h.clear();
    L119:
        this.f14401b = new f.a(r21);
        if (p000if.a.b().f8335e.get() > 0) goto L122;
    L123:
        this.f14401b.f14399c = false;
    L124:
        boolean r32 = true;
    L128:
        i r33 = this.f14403d;
        monitor-enter(r33);
    L183:
        th = move-exception;
        throw th;
    L131:
        if (this.f14412m == true) goto L182;
        if (r32 == false) goto L139;
        f.a r34 = this.f14401b;     // Catch: Throwable -> L183
        r34.getClass();     // Catch: Throwable -> L183
        ArrayList r35 = new ArrayList(r34.f14397a);     // Catch: Throwable -> L183
        int r36 = r35.size();     // Catch: Throwable -> L183
        int r37 = 0;
    L134:
        if (r37 >= r36) goto L139;
        d0 r128 = (d0) r35.get(r37);     // Catch: Throwable -> L183
        xe.a.f13878a.b(this.f14403d, this.f14400a, this, r128);     // Catch: Throwable -> L183
        d r129 = this.f14409j;     // Catch: Throwable -> L183
        if (r129 != null) goto L137;
        r37 = r37 + 1;     // Catch: Throwable -> L183
        goto L134
    L137:
        this.f14402c = r128;     // Catch: Throwable -> L183
        r15 = true;
        r13 = r129;
    L139:
        if (r15 == true) goto L147;
        if (r16 != null) goto L146;
        f.a r38 = this.f14401b;     // Catch: Throwable -> L183
        if (r38.a() == false) goto L145;
        int r39 = r38.f14398b;     // Catch: Throwable -> L183
        r38.f14398b = r39 + 1;     // Catch: Throwable -> L183
        r16 = r38.f14397a.get(r39);     // Catch: Throwable -> L183
        goto L146
    L145:
        throw new NoSuchElementException();     // Catch: Throwable -> L183
    L146:
        this.f14402c = r16;     // Catch: Throwable -> L183
        this.f14408i = 0;     // Catch: Throwable -> L183
        r13 = new d(this.f14403d, r16);     // Catch: Throwable -> L183
        a(r13, false);     // Catch: Throwable -> L183
    L147:
        monitor-exit(r33);     // Catch: Throwable -> L183
        if (r15 == true) goto L176;
        f.a r40 = this.f14401b;
        if (r40 != null) goto L153;
    L155:
        int r41 = r26;
    L157:
        if (this.f14401b == null) goto L159;
    L165:
        r13.c(r41, r27, r28, r30, r29, this.f14404e, this.f14405f);
        xe.a.f13878a.getClass();
        this.f14403d.f13199e.a(r13.f14374c);
        i r42 = this.f14403d;
        monitor-enter(r42);
        this.f14410k = true;     // Catch: Throwable -> L178
        v.a r43 = xe.a.f13878a;     // Catch: Throwable -> L178
        i r44 = this.f14403d;     // Catch: Throwable -> L178
        r43.getClass();     // Catch: Throwable -> L178
        if (r44.f13200f == true) goto L170;
        r44.f13200f = true;     // Catch: Throwable -> L178
        i.f13194g.execute(r44.f13197c);     // Catch: Throwable -> L178
    L170:
        r44.f13198d.add(r13);     // Catch: Throwable -> L178
        if (r13.i() == false) goto L173;
        Socket r45 = xe.a.f13878a.a(this.f14403d, this.f14400a, this);     // Catch: Throwable -> L178
        r13 = this.f14409j;     // Catch: Throwable -> L178
    L174:
        monitor-exit(r42);     // Catch: Throwable -> L178
        xe.c.g(r45);
        goto L176
    L173:
        r45 = null;
    L178:
        th = move-exception;
        throw th;
    L159:
        if (this.f14402c == null) goto L165;
        if (p000if.a.b().f8334d.get() == false) goto L165;
        if (p000if.a.b().f8335e.get() <= 0) goto L165;
        r41 = p000if.a.b().f8335e.get();
        goto L165
    L153:
        if (r40.f14399c == false) goto L155;
        r41 = p000if.a.b().f8335e.get();
    L176:
        this.f14405f.connectionAcquired(this.f14404e, r13);
        return r13;
    L182:
        throw new IOException("Canceled#Reason=" + this.f14413n);     // Catch: Throwable -> L183
    L122:
        if (p000if.a.b().f8334d.get() == true) goto L124;
    L59:
        r22 = false;
        goto L60
    L126:
        throw new NoSuchElementException();
    L50:
        if (r18.f14396h.isEmpty() == false) goto L53;
        r20 = false;
        goto L54
    L47:
        r19 = false;
        goto L48
    L43:
        if (r17.a() == false) goto L44;
    L127:
        r32 = false;
        goto L128
    L27:
        r16 = this.f14402c;     // Catch: Throwable -> L192
        r15 = false;
        goto L30
    L28:
        r15 = false;
        goto L29
    L19:
        r13 = null;
        goto L21
    L13:
        if (r10.f14382k == false) goto L15;
        r12 = c(false, false, true);     // Catch: Throwable -> L192
        goto L16
    L187:
        throw new IOException("Canceled#Reason=" + this.f14413n);     // Catch: Throwable -> L192
    L189:
        throw new IllegalStateException("codec != null");     // Catch: Throwable -> L192
    L191:
        throw new IllegalStateException("released");     // Catch: Throwable -> L192
    }

    public final d e(int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
    L2:
        d r8 = d(r10, r11, r12, r14, r13);
        i r16 = this.f14403d;
        monitor-enter(r16);
    L50:
        th = move-exception;
        throw th;
    L5:
        if (r8.f14383l == 0) goto L7;
    L10:
        monitor-exit(r16);     // Catch: Throwable -> L50
        if (r8.f14376e.isClosed() == false) goto L14;
    L46:
        boolean r17 = false;
    L47:
        if (r17 == true) goto L49;
        f();
        goto L2
    L49:
        return r8;
    L14:
        if (r8.f14376e.isInputShutdown() == true) goto L46;
        if (r8.f14376e.isOutputShutdown() == true) goto L46;
        cf.g r18 = r8.f14379h;
        r17 = true;
        if (r18 == null) goto L37;
        long r19 = System.nanoTime();
        monitor-enter(r18);
    L34:
        th = move-exception;
        throw th;
    L23:
        if (r18.f3505q == false) goto L26;
    L30:
        monitor-exit(r18);
        goto L46
    L26:
        if (r18.f3512x >= r18.f3511w) goto L32;
        if (r19 >= r18.f3514z) goto L30;
    L32:
        monitor-exit(r18);
        goto L47
    L37:
        if (r15 == false) goto L47;
        int r20 = r8.f14376e.getSoTimeout();     // Catch: IOException -> L54 SocketTimeoutException -> L53
        r8.f14376e.setSoTimeout(1);     // Catch: Throwable -> L43
        if (r8.f14380i.U() == false) goto L42;
        r8.f14376e.setSoTimeout(r20);     // Catch: IOException -> L54 SocketTimeoutException -> L53
        goto L46
    L42:
        r8.f14376e.setSoTimeout(r20);     // Catch: IOException -> L54 SocketTimeoutException -> L53
    L43:
        th = move-exception;
        r8.f14376e.setSoTimeout(r20);     // Catch: IOException -> L54 SocketTimeoutException -> L53
        throw th;     // Catch: IOException -> L54 SocketTimeoutException -> L53
    L7:
        if (r8.i() == true) goto L10;
        monitor-exit(r16);     // Catch: Throwable -> L50
        return r8;
    }

    public final void f() {
        i r8 = this.f14403d;
        monitor-enter(r8);
        d r10 = this.f14409j;     // Catch: Throwable -> L12
        Socket r11 = c(true, false, false);     // Catch: Throwable -> L12
        if (this.f14409j == null) goto L7;
        r10 = null;
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L12
        xe.c.g(r11);
        if (r10 == null) goto L17;
        this.f14405f.connectionReleased(this.f14404e, r10);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void g() {
        i r8 = this.f14403d;
        monitor-enter(r8);
        d r10 = this.f14409j;     // Catch: Throwable -> L12
        Socket r11 = c(false, true, false);     // Catch: Throwable -> L12
        if (this.f14409j == null) goto L7;
        r10 = null;
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L12
        xe.c.g(r11);
        if (r10 == null) goto L17;
        v.a r12 = xe.a.f13878a;
        we.d r13 = this.f14404e;
        r12.getClass();
        ((x) r13).g(null);
        this.f14405f.connectionReleased(this.f14404e, r10);
        this.f14405f.callEnd(this.f14404e);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void h(IOException r8) {
        i r10 = this.f14403d;
        monitor-enter(r10);
        d r11 = null;
        if ((r8 instanceof s) == false) goto L14;
        cf.b r12 = ((s) r8).f3602a;     // Catch: Throwable -> L39
        if (r12 != cf.b.f3454p) goto L12;
        int r13 = this.f14408i + 1;     // Catch: Throwable -> L39
        this.f14408i = r13;     // Catch: Throwable -> L39
        if (r13 > 1) goto L13;
    L27:
        boolean r14 = false;
    L28:
        d r15 = this.f14409j;     // Catch: Throwable -> L39
        Socket r16 = c(r14, false, true);     // Catch: Throwable -> L39
        if (this.f14409j == null) goto L31;
    L34:
        monitor-exit(r10);     // Catch: Throwable -> L39
        xe.c.g(r16);
        if (r11 == null) goto L44;
        this.f14405f.connectionReleased(this.f14404e, r11);
        return;
    L44:
        return;
    L31:
        if (this.f14410k == false) goto L34;
        r11 = r15;
    L13:
        this.f14402c = null;     // Catch: Throwable -> L39
    L26:
        r14 = true;
        goto L28
    L12:
        if (r12 == cf.b.f3455q) goto L27;
    L14:
        d r17 = this.f14409j;     // Catch: Throwable -> L39
        if (r17 == null) goto L27;
        if (r17.i() == false) goto L21;
        if ((r8 instanceof cf.a) == false) goto L27;
    L21:
        if (this.f14409j.f14383l != 0) goto L26;
        d0 r18 = this.f14402c;     // Catch: Throwable -> L39
        if (r18 == null) goto L13;
        if (r8 == null) goto L13;
        this.f14407h.a(r18, r8);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    public final void i(boolean r8, af.c r10, long r11, IOException r12) {
        this.f14405f.responseBodyEnd(this.f14404e, r11);
        i r13 = this.f14403d;
        monitor-enter(r13);
        if (r10 == null) goto L24;
    L25:
        th = move-exception;
        throw th;
    L6:
        if (r10 != this.f14414o) goto L24;
        if (r8 == true) goto L10;
        this.f14409j.f14383l++;     // Catch: Throwable -> L25
    L10:
        d r14 = this.f14409j;     // Catch: Throwable -> L25
        Socket r15 = c(r8, false, true);     // Catch: Throwable -> L25
        if (this.f14409j == null) goto L13;
        r14 = null;
    L13:
        boolean r16 = this.f14411l;     // Catch: Throwable -> L25
        monitor-exit(r13);     // Catch: Throwable -> L25
        xe.c.g(r15);
        if (r14 == null) goto L18;
        this.f14405f.connectionReleased(this.f14404e, r14);
    L18:
        if (r12 == null) goto L20;
        v.a r17 = xe.a.f13878a;
        we.d r18 = this.f14404e;
        r17.getClass();
        this.f14405f.callFailed(this.f14404e, ((x) r18).g(r12));
        return;
    L20:
        if (r16 == false) goto L30;
        v.a r19 = xe.a.f13878a;
        we.d r20 = this.f14404e;
        r19.getClass();
        ((x) r20).g(null);
        this.f14405f.callEnd(this.f14404e);
        return;
    L30:
        return;
    L24:
        throw new IllegalStateException("expected " + this.f14414o + " but was " + r10);     // Catch: Throwable -> L25
    }

    public final String toString() {
        d r8 = b();
        if (r8 == null) goto L6;
        return r8.toString();
    L6:
        return this.f14400a.toString();
    }
}
