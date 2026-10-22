package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.b0;
import okhttp3.q;
import okhttp3.s;
import okhttp3.ttnet.TTNetDnsResult;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f11829k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.a f11830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f11831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final okhttp3.e f11832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f11833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<? extends Proxy> f11834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<? extends InetSocketAddress> f11836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<b0> f11837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f11839j;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(InetSocketAddress r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            InetAddress r11 = r10.getAddress();
            if (r11 != null) goto L7;
            String r12 = r10.getHostName();
            String r13 = "hostName";
        L5:
            Intrinsics.checkNotNullExpressionValue(r12, r13);
            return r12;
        L7:
            r12 = r11.getHostAddress();
            r13 = "address.hostAddress";
            goto L5
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b0> f11840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f11841b;

        public b(List<b0> r10) {
            Intrinsics.checkNotNullParameter(r10, "routes");
            this.f11840a = r10;
        }

        public final List<b0> a() {
            return this.f11840a;
        }

        public final boolean b() {
            if (this.f11841b >= this.f11840a.size()) goto L5;
            return true;
        L5:
            return false;
        }

        public final b0 c() {
            if (b() == false) goto L7;
            List<b0> r10 = this.f11840a;
            int r11 = this.f11841b;
            this.f11841b = r11 + 1;
            return r10.get(r11);
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        f11829k = new a(null);
    }

    public h(okhttp3.a r10, g r11, okhttp3.e r12, q r13) {
        Intrinsics.checkNotNullParameter(r10, "address");
        Intrinsics.checkNotNullParameter(r11, "routeDatabase");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r13, "eventListener");
        this.f11830a = r10;
        this.f11831b = r11;
        this.f11832c = r12;
        this.f11833d = r13;
        this.f11834e = CollectionsKt.emptyList();
        this.f11836g = CollectionsKt.emptyList();
        this.f11837h = new ArrayList();
        g(r10.m(), r10.g());
    }

    private final boolean b() {
        if (this.f11835f >= this.f11834e.size()) goto L5;
        return true;
    L5:
        return false;
    }

    private final Proxy d() {
        if (b() == false) goto L7;
        List<? extends Proxy> r10 = this.f11834e;
        int r11 = this.f11835f;
        this.f11835f = r11 + 1;
        Proxy r12 = r10.get(r11);
        e(r12);
        return r12;
    L7:
        throw new SocketException("No route to " + this.f11830a.m().h() + "; exhausted proxy configurations: " + this.f11834e);
    }

    private final void e(Proxy r10) {
        ArrayList r11 = new ArrayList();
        this.f11836g = r11;
        if (r10.type() != Proxy.Type.DIRECT) goto L5;
    L12:
        String r12 = this.f11830a.m().h();
        int r13 = this.f11830a.m().n();
    L13:
        boolean r14 = false;
        if (1 <= r13) goto L16;
    L18:
        boolean r15 = false;
    L19:
        if (r15 == false) goto L54;
        if (r10.type() != Proxy.Type.SOCKS) goto L24;
        r11.add(InetSocketAddress.createUnresolved(r12, r13));
        return;
    L24:
        if (hc.e.i(r12) == false) goto L26;
        List<InetAddress> r16 = CollectionsKt.listOf(InetAddress.getByName(r12));
    L46:
        Iterator<InetAddress> r17 = r16.iterator();
    L48:
        if (r17.hasNext() == false) goto L56;
        r11.add(new InetSocketAddress(r17.next(), r13));
        goto L48
    L56:
        return;
    L26:
        this.f11833d.q(this.f11832c, r12);
        if (this.f11830a.l() == null) goto L43;
        TTNetDnsResult r18 = this.f11830a.l().lookup(r12, this.f11838i);
        String r19 = null;
        if (r18 == null) goto L31;
        List<InetAddress> r20 = r18.getInetAddressList();
    L32:
        if (r18 == null) goto L34;
        r19 = r18.getDnsInfoJson();
    L34:
        this.f11833d.p(this.f11832c, r12, r20, r19);
        this.f11839j = r19;
        if (r20 != null) goto L37;
    L38:
        r14 = true;
    L39:
        if (r14 == true) goto L42;
        r16 = r20;
        goto L46
    L42:
        throw new UnknownHostException(this.f11830a.l() + " returned no addresses for " + r12);
    L37:
        if (r20.isEmpty() == false) goto L39;
    L31:
        r20 = null;
        goto L32
    L43:
        List<InetAddress> r110 = this.f11830a.c().a(r12);
        if (r110.isEmpty() == true) goto L52;
        this.f11833d.o(this.f11832c, r12, r110);
        r16 = r110;
        goto L46
    L52:
        throw new UnknownHostException(this.f11830a.c() + " returned no addresses for " + r12);
    L54:
        throw new SocketException("No route to " + r12 + ':' + r13 + "; port is out of range");
    L16:
        if (r13 >= 65536) goto L18;
        r15 = true;
        goto L19
    L5:
        if (r10.type() == Proxy.Type.SOCKS) goto L12;
        SocketAddress r21 = r10.address();
        if ((r21 instanceof InetSocketAddress) == false) goto L11;
        a r22 = f11829k;
        Intrinsics.checkNotNullExpressionValue(r21, "proxyAddress");
        InetSocketAddress r23 = (InetSocketAddress) r21;
        r12 = r22.a(r23);
        r13 = r23.getPort();
        goto L13
    L11:
        throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + r21.getClass()).toString());
    }

    private final void g(s r10, Proxy r11) {
        this.f11833d.s(this.f11832c, r10);
        List<Proxy> r12 = h(r11, r10, this);
        this.f11834e = r12;
        this.f11835f = 0;
        this.f11833d.r(this.f11832c, r10, r12);
    }

    private static final List<Proxy> h(Proxy r10, s r11, h r12) {
        if (r10 != null) goto L4;
        URI r13 = r11.t();
        if (r13.getHost() == null) goto L8;
        List<Proxy> r14 = r12.f11830a.i().select(r13);
        if (r14 != null) goto L12;
    L15:
        boolean r15 = true;
    L16:
        if (r15 == true) goto L18;
        Intrinsics.checkNotNullExpressionValue(r14, "proxiesOrNull");
        return hc.e.T(r14);
    L18:
        return hc.e.w(new Proxy[]{Proxy.NO_PROXY});
    L12:
        if (r14.isEmpty() == true) goto L15;
        r15 = false;
        goto L16
    L8:
        return hc.e.w(new Proxy[]{Proxy.NO_PROXY});
    L4:
        return CollectionsKt.listOf(r10);
    }

    public final boolean a() {
        if (b() == false) goto L5;
        return true;
    L5:
        if ((!this.f11837h.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final b c() {
        if (a() == false) goto L22;
        ArrayList r10 = new ArrayList();
    L6:
        if (b() == false) goto L17;
        Proxy r11 = d();
        Iterator<? extends InetSocketAddress> r12 = this.f11836g.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        b0 r13 = new b0(this.f11830a, r11, r12.next(), this.f11839j);
        if (this.f11831b.c(r13) == true) goto L12;
        r10.add(r13);
        goto L9
    L12:
        this.f11837h.add(r13);
        goto L9
    L15:
        if ((!r10.isEmpty()) == false) goto L6;
    L17:
        if (r10.isEmpty() == false) goto L20;
        CollectionsKt.addAll(r10, this.f11837h);
        this.f11837h.clear();
    L20:
        return new b(r10);
    L22:
        throw new NoSuchElementException();
    }

    public final void f(int r10) {
        g(this.f11830a.m(), this.f11830a.g());
        this.f11838i = r10;
        this.f11839j = null;
        this.f11836g = CollectionsKt.emptyList();
        this.f11837h.clear();
    }
}
