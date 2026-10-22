package com.ss.android.socialbase.downloader.impls;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import ib.d0;
import ib.k0;
import ib.n0;
import ib.u;
import java.util.List;
import jb.o;

/* JADX INFO: loaded from: classes2.dex */
public class j implements jb.m, jb.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile jb.h f8002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o<IndependentProcessDownloadService> f8003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private jb.m f8004c;

    class a implements n0 {
        a(j r10) {
        }

        @Override // ib.n0
        public void x0(int r10, int r11) {
            if (r11 != 1) goto L6;
            jb.f.u(com.ss.android.socialbase.downloader.downloader.a.h()).j(r10);
            return;
        L6:
            if (r11 != 2) goto L10;
            jb.f.u(com.ss.android.socialbase.downloader.downloader.a.h()).a(r10);
            return;
        }
    }

    static {
    }

    public j() {
        this.f8004c = new l();
        o<IndependentProcessDownloadService> r10 = com.ss.android.socialbase.downloader.downloader.a.I();
        this.f8003b = r10;
        r10.a(this);
    }

    @Override // jb.m
    public boolean A() {
        if (this.f8002a == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // jb.m
    public void B() {
        o<IndependentProcessDownloadService> r10 = this.f8003b;
        if (r10 == null) goto L6;
        r10.B();
        return;
    }

    @Override // jb.m
    public void C(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        o<IndependentProcessDownloadService> r11 = this.f8003b;
        if (r11 == null) goto L8;
        r11.C(r10);
        return;
    }

    @Override // jb.m
    public void D(int r10, boolean r11) {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.D(r10, r11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void E(int r10, int r11, a0 r12, ListenerType r13, boolean r14) {
        if (this.f8002a != null) goto L14;
        return;
    L14:
        jb.h r15 = this.f8002a;     // Catch: RemoteException -> L11
        if (r13 != ListenerType.SUB) goto L8;
        boolean r16 = false;
    L9:
        r15.Y0(r10, r11, com.ss.android.socialbase.downloader.utils.h.x(r12, r16), r13.ordinal(), r14);     // Catch: RemoteException -> L11
        return;
    L8:
        r16 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void F(int r10, int r11, a0 r12, ListenerType r13, boolean r14, boolean r15) {
        if (this.f8002a != null) goto L14;
        return;
    L14:
        jb.h r16 = this.f8002a;     // Catch: RemoteException -> L11
        if (r13 != ListenerType.SUB) goto L8;
        boolean r17 = false;
    L9:
        r16.g1(r10, r11, com.ss.android.socialbase.downloader.utils.h.x(r12, r17), r13.ordinal(), r14, r15);     // Catch: RemoteException -> L11
        return;
    L8:
        r17 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public k0 F0(int r10) {
        if (this.f8002a == null) goto L12;
        return com.ss.android.socialbase.downloader.utils.h.z(this.f8002a.F0(r10));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // jb.m
    @Nullable
    public DownloadInfo G(String r10, String r11) {
        return a(b0(r10, r11));
    }

    @Override // jb.n
    public void H(IBinder r10) {
        this.f8002a = jb.h.a.U0(r10);
        if (com.ss.android.socialbase.downloader.utils.c.F() == false) goto L6;
        K(new a(this));
        return;
    }

    @Override // jb.m
    public void H0(int r10, boolean r11, boolean r12) {
        if (this.f8002a != null) goto L10;
        this.f8004c.H0(r10, r11, r12);
        return;
    L10:
        this.f8002a.H0(r10, r11, r12);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void I(int r10, int r11, a0 r12, ListenerType r13, boolean r14) {
        if (this.f8002a != null) goto L14;
        return;
    L14:
        jb.h r15 = this.f8002a;     // Catch: RemoteException -> L11
        if (r13 != ListenerType.SUB) goto L8;
        boolean r16 = false;
    L9:
        r15.e1(r10, r11, com.ss.android.socialbase.downloader.utils.h.x(r12, r16), r13.ordinal(), r14);     // Catch: RemoteException -> L11
        return;
    L8:
        r16 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void J(int r10, d0 r11) {
        if (this.f8002a == null) goto L11;
        this.f8002a.Y1(r10, com.ss.android.socialbase.downloader.utils.h.l(r11));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // jb.m
    public void J0(int r10, int r11) {
        if (this.f8002a == null) goto L11;
        this.f8002a.J0(r10, r11);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // jb.m
    public void K(n0 r10) {
        if (this.f8002a == null) goto L11;
        this.f8002a.v1(com.ss.android.socialbase.downloader.utils.h.C(r10));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // jb.m
    public boolean L(DownloadInfo r10) {
        if (this.f8002a == null) goto L5;
        this.f8002a.L(r10);     // Catch: RemoteException -> L8
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f8004c.L(r10);
    }

    @Override // jb.n
    public void M() {
        this.f8002a = null;
    }

    @Override // jb.m
    public d0 O(int r10) {
        if (this.f8002a == null) goto L12;
        return com.ss.android.socialbase.downloader.utils.h.k(this.f8002a.O(r10));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // jb.m
    public List<DownloadInfo> P(String r10) {
        if (this.f8002a == null) goto L12;
        return this.f8002a.P(r10);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // jb.m
    public boolean Y() {
        return com.ss.android.socialbase.downloader.downloader.a.a0();
    }

    @Override // jb.m
    @Nullable
    public DownloadInfo a(int r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.a(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f8004c.a(r10);
    }

    @Override // jb.m
    public boolean b(DownloadInfo r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.b(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f8004c.b(r10);
    }

    @Override // jb.m
    public int b0(String r10, String r11) {
        return com.ss.android.socialbase.downloader.downloader.a.u(r10, r11);
    }

    @Override // jb.m
    public void c() {
        if (this.f8002a != null) goto L10;
        this.f8004c.c();
        return;
    L10:
        this.f8002a.c();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public boolean d() {
        if (this.f8002a == null) goto L5;
        return this.f8002a.d();
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f8004c.d();
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> e(String r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.e(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f8004c.e(r10);
    }

    @Override // jb.m
    public List<DownloadInfo> f(String r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.f(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f8004c.f(r10);
    }

    @Override // jb.m
    public boolean f0(int r10) {
        if (this.f8002a != null) goto L10;
        return false;
    L10:
        return this.f8002a.f0(r10);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // jb.m
    public List<DownloadInfo> g(String r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.g(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f8004c.g(r10);
    }

    @Override // jb.m
    public boolean h(int r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.h(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f8004c.h(r10);
    }

    @Override // jb.m
    public void i(int r10) {
        if (this.f8002a != null) goto L10;
        this.f8004c.i(r10);
        return;
    L10:
        this.f8002a.i(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public long i0(int r10) {
        if (this.f8002a != null) goto L10;
        return 0;
    L10:
        return this.f8002a.i0(r10);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // jb.m
    public boolean j(int r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.j(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f8004c.j(r10);
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> k() {
        if (this.f8002a == null) goto L5;
        return this.f8002a.k();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f8004c.k();
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> l(String r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.l(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f8004c.l(r10);
    }

    @Override // jb.m
    @Nullable
    public List<DownloadInfo> m(String r10, String r11) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.m(r10, r11);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f8004c.m(r10, r11);
    }

    @Override // jb.m
    public int n(int r10) {
        if (this.f8002a != null) goto L10;
        return 0;
    L10:
        return this.f8002a.n(r10);
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // jb.m
    public boolean o(int r10) {
        if (this.f8002a != null) goto L10;
        return false;
    L10:
        return this.f8002a.o(r10);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // jb.m
    public void o0(int r10, boolean r11) {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.o0(r10, r11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void p(int r10, boolean r11) {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.p(r10, r11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void q(int r10, boolean r11) {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.q(r10, r11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void r(List<String> r10) {
        if (this.f8002a != null) goto L10;
        this.f8004c.r(r10);
        return;
    L10:
        this.f8002a.r(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void s(int r10) {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.s(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void t(int r10, long r11, int r12) {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.t(r10, r11, r12);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void u() {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.u();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void v(DownloadInfo r10) {
    }

    @Override // jb.m
    public u v0(int r10) {
        if (this.f8002a == null) goto L12;
        return com.ss.android.socialbase.downloader.utils.h.o(this.f8002a.v0(r10));
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    @Override // jb.m
    public void w(List<String> r10) {
        if (this.f8002a != null) goto L10;
        this.f8004c.w(r10);
        return;
    L10:
        this.f8002a.w(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.m
    public void x(int r10) {
        o<IndependentProcessDownloadService> r11 = this.f8003b;
        if (r11 == null) goto L6;
        r11.x(r10);
        return;
    }

    @Override // jb.m
    public void y(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        o<IndependentProcessDownloadService> r11 = this.f8003b;
        if (r11 == null) goto L8;
        r11.y(r10);
        return;
    }

    @Override // jb.m
    public int y0(int r10) {
        if (this.f8002a == null) goto L5;
        return this.f8002a.y0(r10);
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L5:
        return jb.c.i().h(r10);
    }

    @Override // jb.m
    public void z(int r10) {
        if (this.f8002a != null) goto L10;
        return;
    L10:
        this.f8002a.z(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
