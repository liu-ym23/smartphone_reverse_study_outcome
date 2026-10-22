package com.ss.android.socialbase.downloader.impls;

import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import ib.d0;
import ib.k0;
import ib.n0;
import ib.u;
import java.util.Iterator;
import java.util.List;
import jb.o;

/* JADX INFO: loaded from: classes2.dex */
public class l implements jb.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.impls.a f8022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final jb.i f8023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f8024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f8025d;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f8026c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f8027g;

        a(l r10, com.ss.android.socialbase.downloader.model.d r11) {
            this.f8027g = r10;
            this.f8026c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.M(this.f8027g).y(this.f8026c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f8028c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f8029g;

        b(l r10, com.ss.android.socialbase.downloader.model.d r11) {
            this.f8029g = r10;
            this.f8028c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.M(this.f8029g).C(this.f8028c);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8030c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f8031g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f8032h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ l f8033i;

        c(l r10, int r11, long r12, int r13) {
            this.f8033i = r10;
            this.f8030c = r11;
            this.f8031g = r12;
            this.f8032h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8033i).W(this.f8030c, this.f8031g, this.f8032h);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8034c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f8035g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f8036h;

        d(l r10, int r11, boolean r12) {
            this.f8036h = r10;
            this.f8034c = r11;
            this.f8035g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8036h).V(this.f8034c, this.f8035g);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8037c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f8038g;

        e(l r10, int r11) {
            this.f8038g = r10;
            this.f8037c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8038g).G(this.f8037c);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8039c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f8040g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f8041h;

        f(l r10, int r11, boolean r12) {
            this.f8041h = r10;
            this.f8039c = r11;
            this.f8040g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8041h).f(this.f8039c, this.f8040g);
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8042c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f8043g;

        g(l r10, int r11) {
            this.f8043g = r10;
            this.f8042c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8043g).T(this.f8042c);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8044c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f8045g;

        h(l r10, int r11) {
            this.f8045g = r10;
            this.f8044c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8045g).P(this.f8044c);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f8046c;

        i(l r10) {
            this.f8046c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8046c).X();
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f8047c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f8048g;

        j(l r10, List r11) {
            this.f8048g = r10;
            this.f8047c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8048g).Q(this.f8047c);
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f8049c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l f8050g;

        k(l r10, List r11) {
            this.f8050g = r10;
            this.f8049c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8050g).R(this.f8049c);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.l$l, reason: collision with other inner class name */
    class RunnableC0147l implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8051c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f8052g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f8053h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ l f8054i;

        RunnableC0147l(l r10, int r11, boolean r12, boolean r13) {
            this.f8054i = r10;
            this.f8051c = r11;
            this.f8052g = r12;
            this.f8053h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8054i).h(this.f8051c, this.f8052g, this.f8053h);
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8055c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f8056g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f8057h;

        m(l r10, int r11, boolean r12) {
            this.f8057h = r10;
            this.f8055c = r11;
            this.f8056g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.H(this.f8057h).M(this.f8055c, this.f8056g);
        }
    }

    public l() {
        this(false);
    }

    public l(boolean r10) {
        this.f8022a = com.ss.android.socialbase.downloader.downloader.a.s();
        this.f8023b = com.ss.android.socialbase.downloader.downloader.a.o();
        if (r10 == true) goto L5;
        o r11 = com.ss.android.socialbase.downloader.downloader.a.z();
    L6:
        this.f8024c = r11;
        if (rb.a.j().n("single_async_handle_operation") <= 0) goto L9;
        boolean r12 = true;
    L10:
        this.f8025d = r12;
        return;
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = com.ss.android.socialbase.downloader.downloader.a.I();
        goto L6
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.impls.a H(l r10) {
        return r10.f8022a;
    }

    static /* synthetic */ o M(l r10) {
        return r10.f8024c;
    }

    private void Q(Runnable r10) {
        if (this.f8025d == false) goto L5;
        com.ss.android.socialbase.downloader.downloader.a.M0(r10);
        return;
    L5:
        r10.run();
    }

    @Override // jb.m
    public boolean A() {
        o r10 = this.f8024c;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.A() == false) goto L7;
        return true;
    }

    @Override // jb.m
    public void B() {
    }

    @Override // jb.m
    public void C(com.ss.android.socialbase.downloader.model.d r10) {
        com.ss.android.socialbase.downloader.downloader.a.O0(r10, true);
        Q(new b(this, r10));
    }

    @Override // jb.m
    public void D(int r10, boolean r11) {
        jb.c.i().t(r10, r11);
    }

    @Override // jb.m
    public void E(int r10, int r11, a0 r12, ListenerType r13, boolean r14) {
        this.f8022a.J(r10, r11, r12, r13, r14);
    }

    @Override // jb.m
    public void F(int r10, int r11, a0 r12, ListenerType r13, boolean r14, boolean r15) {
        this.f8022a.d(r10, r11, r12, r13, r14, r15);
    }

    @Override // jb.m
    public k0 F0(int r10) {
        k0 r11 = this.f8022a.B(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return com.ss.android.socialbase.downloader.downloader.a.O();
    }

    @Override // jb.m
    @Nullable
    public DownloadInfo G(String r10, String r11) {
        return a(com.ss.android.socialbase.downloader.downloader.a.u(r10, r11));
    }

    @Override // jb.m
    public void H0(int r10, boolean r11, boolean r12) {
        Q(new RunnableC0147l(this, r10, r11, r12));
    }

    @Override // jb.m
    public void I(int r10, int r11, a0 r12, ListenerType r13, boolean r14) {
        this.f8022a.c(r10, r11, r12, r13, r14);
    }

    @Override // jb.m
    public void J(int r10, d0 r11) {
        this.f8022a.U(r10, r11);
    }

    @Override // jb.m
    public void J0(int r10, int r11) {
        if (com.ss.android.socialbase.downloader.downloader.a.P() == null) goto L10;
        Iterator<n0> r12 = com.ss.android.socialbase.downloader.downloader.a.P().iterator();
    L6:
        if (r12.hasNext() == false) goto L16;
        n0 r13 = r12.next();
        if (r13 == null) goto L6;
        r13.x0(r11, r10);
        goto L6
    L16:
        return;
    }

    @Override // jb.m
    public void K(n0 r10) {
        com.ss.android.socialbase.downloader.downloader.a.c(r10);
    }

    @Override // jb.m
    public boolean L(DownloadInfo r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        boolean r11 = com.ss.android.socialbase.downloader.utils.g.J(r10.getStatus(), r10.getSavePath(), r10.getName());
        if (r11 == false) goto L8;
        N(r10.getId(), true);
    L8:
        return r11;
    }

    public void N(int r10, boolean r11) {
        Q(new m(this, r10, r11));
    }

    @Override // jb.m
    public d0 O(int r10) {
        return this.f8022a.w(r10);
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> P(String r10) {
        return this.f8022a.A(r10);
    }

    @Override // jb.m
    public boolean Y() {
        return com.ss.android.socialbase.downloader.downloader.a.a0();
    }

    @Override // jb.m
    @Nullable
    public DownloadInfo a(int r10) {
        return this.f8022a.s(r10);
    }

    @Override // jb.m
    public boolean b(DownloadInfo r10) {
        return this.f8023b.b(r10);
    }

    @Override // jb.m
    public int b0(String r10, String r11) {
        return com.ss.android.socialbase.downloader.downloader.a.u(r10, r11);
    }

    @Override // jb.m
    public void c() {
        this.f8023b.c();
    }

    @Override // jb.m
    public boolean d() {
        return this.f8023b.d();
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> e(String r10) {
        return this.f8023b.e(r10);
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> f(String r10) {
        return this.f8023b.f(r10);
    }

    @Override // jb.m
    public boolean f0(int r10) {
        com.ss.android.socialbase.downloader.impls.a r11 = this.f8022a;
        if (r11 != null) goto L5;
        return false;
    L5:
        return r11.D(r10);
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> g(String r10) {
        return this.f8023b.g(r10);
    }

    @Override // jb.m
    public boolean h(int r10) {
        return this.f8023b.h(r10);
    }

    @Override // jb.m
    public void i(int r10) {
        this.f8023b.i(r10);
    }

    @Override // jb.m
    public long i0(int r10) {
        jb.i r11 = this.f8023b;
        if (r11 != null) goto L5;
        return 0;
    L5:
        DownloadInfo r12 = r11.a(r10);
        if (r12 != null) goto L9;
        return 0;
    L9:
        return r12.getCurBytes();
    }

    @Override // jb.m
    public boolean j(int r10) {
        return this.f8023b.j(r10);
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> k() {
        jb.i r10 = this.f8023b;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.k();
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> l(String r10) {
        return this.f8022a.u(r10);
    }

    @Override // jb.m
    public List<DownloadInfo> m(String r10, String r11) {
        jb.i r12 = this.f8023b;
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.m(r10, r11);
    }

    @Override // jb.m
    public int n(int r10) {
        DownloadInfo r11 = this.f8022a.s(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.getStatus();
    }

    @Override // jb.m
    public boolean o(int r10) {
        return this.f8022a.C(r10);
    }

    @Override // jb.m
    public void o0(int r10, boolean r11) {
        e r12 = new e(this, r10);
        if (r11 == false) goto L5;
        r12.run();
        return;
    L5:
        Q(r12);
    }

    @Override // jb.m
    public void p(int r10, boolean r11) {
        Q(new d(this, r10, r11));
    }

    @Override // jb.m
    public void q(int r10, boolean r11) {
        Q(new f(this, r10, r11));
    }

    @Override // jb.m
    public void r(List<String> r10) {
        Q(new k(this, r10));
    }

    @Override // jb.m
    public void s(int r10) {
        Q(new g(this, r10));
    }

    @Override // jb.m
    public void t(int r10, long r11, int r12) {
        Q(new c(this, r10, r11, r12));
    }

    @Override // jb.m
    public void u() {
        Q(new i(this));
    }

    @Override // jb.m
    public void v(DownloadInfo r10) {
        this.f8023b.v(r10);
    }

    @Override // jb.m
    public u v0(int r10) {
        return this.f8022a.r(r10);
    }

    @Override // jb.m
    public void w(List<String> r10) {
        Q(new j(this, r10));
    }

    @Override // jb.m
    public void x(int r10) {
        lb.a.f(r10);
    }

    @Override // jb.m
    public void y(com.ss.android.socialbase.downloader.model.d r10) {
        com.ss.android.socialbase.downloader.downloader.a.O0(r10, true);
        Q(new a(this, r10));
    }

    @Override // jb.m
    public int y0(int r10) {
        return jb.c.i().g(r10);
    }

    @Override // jb.m
    public void z(int r10) {
        Q(new h(this, r10));
    }
}
