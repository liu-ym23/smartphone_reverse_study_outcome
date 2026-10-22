package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.c0;
import ib.j0;
import ib.m0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h extends jb.h.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final jb.m f7997c;

    static {
    }

    public h() {
        this.f7997c = new l(true);
    }

    @Override // jb.h
    public void D(int r10, boolean r11) {
        jb.c.i().s(r10, r11);
    }

    @Override // jb.h
    public j0 F0(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return com.ss.android.socialbase.downloader.utils.h.A(r11.F0(r10));
    }

    @Override // jb.h
    public void H0(int r10, boolean r11, boolean r12) {
        jb.m r13 = this.f7997c;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.H0(r10, r11, r12);
    }

    @Override // jb.h
    public void J0(int r10, int r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.J0(r10, r11);
    }

    @Override // jb.h
    public boolean L(DownloadInfo r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.L(r10);
    }

    @Override // jb.h
    public c0 O(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return com.ss.android.socialbase.downloader.utils.h.l(r11.O(r10));
    }

    @Override // jb.h
    public void O0(int r10, boolean r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.H0(r10, r11, false);
    }

    @Override // jb.h
    public List<DownloadInfo> P(String r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.P(r10);
    }

    @Override // jb.h
    public void U1(com.ss.android.socialbase.downloader.model.a r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.C(com.ss.android.socialbase.downloader.utils.h.m(r10));
    }

    @Override // jb.h
    public boolean Y() {
        jb.m r10 = this.f7997c;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.Y();
    }

    @Override // jb.h
    public void Y0(int r10, int r11, ib.h r12, int r13, boolean r14) {
        jb.m r15 = this.f7997c;
        if (r15 != null) goto L5;
        return;
    L5:
        r15.E(r10, r11, com.ss.android.socialbase.downloader.utils.h.w(r12), com.ss.android.socialbase.downloader.utils.c.f(r13), r14);
    }

    @Override // jb.h
    public void Y1(int r10, c0 r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.J(r10, com.ss.android.socialbase.downloader.utils.h.k(r11));
    }

    @Override // jb.h
    public DownloadInfo a(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.a(r10);
    }

    @Override // jb.h
    public boolean b(DownloadInfo r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.b(r10);
    }

    @Override // jb.h
    public int b0(String r10, String r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.b0(r10, r11);
    }

    @Override // jb.h
    public void c() {
        jb.m r10 = this.f7997c;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.c();
    }

    @Override // jb.h
    public boolean d() {
        jb.m r10 = this.f7997c;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.d();
    }

    @Override // jb.h
    public List<DownloadInfo> e(String r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.e(r10);
    }

    @Override // jb.h
    public void e1(int r10, int r11, ib.h r12, int r13, boolean r14) {
        jb.m r15 = this.f7997c;
        if (r15 != null) goto L5;
        return;
    L5:
        r15.I(r10, r11, com.ss.android.socialbase.downloader.utils.h.w(r12), com.ss.android.socialbase.downloader.utils.c.f(r13), r14);
    }

    @Override // jb.h
    public List<DownloadInfo> f(String r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.f(r10);
    }

    @Override // jb.h
    public boolean f0(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.f0(r10);
    }

    @Override // jb.h
    public List<DownloadInfo> g(String r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.g(r10);
    }

    @Override // jb.h
    public void g1(int r10, int r11, ib.h r12, int r13, boolean r14, boolean r15) {
        jb.m r16 = this.f7997c;
        if (r16 != null) goto L5;
        return;
    L5:
        r16.F(r10, r11, com.ss.android.socialbase.downloader.utils.h.w(r12), com.ss.android.socialbase.downloader.utils.c.f(r13), r14, r15);
    }

    @Override // jb.h
    public boolean h(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.h(r10);
    }

    @Override // jb.h
    public void i(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.i(r10);
    }

    @Override // jb.h
    public long i0(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.i0(r10);
    }

    @Override // jb.h
    public boolean j(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.j(r10);
    }

    @Override // jb.h
    public List<DownloadInfo> k() {
        jb.m r10 = this.f7997c;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.k();
    }

    @Override // jb.h
    public List<DownloadInfo> l(String r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.l(r10);
    }

    @Override // jb.h
    public List<DownloadInfo> m(String r10, String r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.m(r10, r11);
    }

    @Override // jb.h
    public int n(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.n(r10);
    }

    @Override // jb.h
    public DownloadInfo n1(String r10, String r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.G(r10, r11);
    }

    @Override // jb.h
    public boolean o(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.o(r10);
    }

    @Override // jb.h
    public void o0(int r10, boolean r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.o0(r10, r11);
    }

    @Override // jb.h
    public void p(int r10, boolean r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.p(r10, r11);
    }

    @Override // jb.h
    public void q(int r10, boolean r11) {
        jb.m r12 = this.f7997c;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.q(r10, r11);
    }

    @Override // jb.h
    public void r(List<String> r10) {
        jb.m r11 = this.f7997c;
        if (r11 == null) goto L6;
        r11.r(r10);
        return;
    }

    @Override // jb.h
    public void s(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.s(r10);
    }

    @Override // jb.h
    public void t(int r10, long r11, int r12) {
        jb.m r13 = this.f7997c;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.t(r10, r11, r12);
    }

    @Override // jb.h
    public void u() {
        jb.m r10 = this.f7997c;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.u();
    }

    @Override // jb.h
    public ib.f v0(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L7;
        return null;
    L7:
        return com.ss.android.socialbase.downloader.utils.h.p(r11.v0(r10));
    }

    @Override // jb.h
    public void v1(m0 r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.K(com.ss.android.socialbase.downloader.utils.h.B(r10));
    }

    @Override // jb.h
    public void w(List<String> r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.w(r10);
    }

    @Override // jb.h
    public void x(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.x(r10);
    }

    @Override // jb.h
    public int y0(int r10) {
        return jb.c.i().h(r10);
    }

    @Override // jb.h
    public void z(int r10) {
        jb.m r11 = this.f7997c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.z(r10);
    }
}
