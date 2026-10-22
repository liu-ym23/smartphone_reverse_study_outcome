package ze;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import we.d0;
import we.o;
import we.r;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final we.a f14389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qd.a f14390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final we.d f14391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f14392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Proxy> f14393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<InetSocketAddress> f14395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f14396h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d0> f14397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14399c;

        public a(ArrayList r8) {
            this.f14398b = 0;
            this.f14399c = false;
            this.f14397a = r8;
            if (r8.size() >= p000if.a.b().f8336f.get()) goto L6;
            ArrayList r10 = new ArrayList(r8);
            r8.addAll(r10);
            r8.addAll(r10);
            this.f14399c = true;
        L6:
            if (r8.size() <= 1) goto L9;
            this.f14399c = true;
            return;
        }

        public final boolean a() {
            boolean r8 = this.f14399c;
            List<d0> r10 = this.f14397a;
            if (r8 == false) goto L8;
            if (this.f14398b != r10.size()) goto L8;
            this.f14398b = 0;
            this.f14399c = false;
        L8:
            if (this.f14398b >= r10.size()) goto L11;
            return true;
        L11:
            return false;
        }
    }

    public f(we.a r8, qd.a r10, we.d r11, o r12) {
        this.f14393e = Collections.emptyList();
        this.f14395g = Collections.emptyList();
        this.f14396h = new ArrayList();
        this.f14389a = r8;
        this.f14390b = r10;
        this.f14391c = r11;
        this.f14392d = r12;
        b(r8.f13103a, r8.f13110h);
    }

    public final void a(d0 r8, IOException r10) {
        if (r8.f13159b.type() == Proxy.Type.DIRECT) goto L7;
        we.a r11 = this.f14389a;
        ProxySelector r12 = r11.f13109g;
        if (r12 == null) goto L7;
        r12.connectFailed(r11.f13103a.n(), r8.f13159b.address(), r10);
    L7:
        qd.a r13 = this.f14390b;
        monitor-enter(r13);
        ((Set) r13.f11296a).add(r8);     // Catch: Throwable -> L12
        monitor-exit(r13);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void b(r r8, Proxy r10) {
        if (r10 == null) goto L5;
        List<Proxy> r11 = Collections.singletonList(r10);
    L4:
        this.f14393e = r11;
        this.f14394f = 0;
        return;
    L5:
        List<Proxy> r12 = this.f14389a.f13109g.select(r8.n());
        if (r12 != null) goto L8;
    L10:
        r11 = xe.c.q(new Proxy[]{Proxy.NO_PROXY});
        goto L4
    L8:
        if (r12.isEmpty() == true) goto L10;
        r11 = xe.c.p(r12);
        goto L4
    }
}
