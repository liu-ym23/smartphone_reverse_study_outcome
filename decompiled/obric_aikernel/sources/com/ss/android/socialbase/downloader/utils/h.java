package com.ss.android.socialbase.downloader.utils;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.b0;
import ib.c0;
import ib.d0;
import ib.j0;
import ib.k0;
import ib.m0;
import ib.n0;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f8347a;

    static class a extends ib.e.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.o f8348c;

        a(ib.o r10) {
            this.f8348c = r10;
        }

        @Override // ib.e
        public void E0(DownloadInfo r10, BaseException r11, int r12) {
            this.f8348c.E0(r10, r11, r12);
        }
    }

    static class a0 implements ib.r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.p f8349a;

        a0(ib.p r10) {
            this.f8349a = r10;
        }

        @Override // ib.r
        public void C0() {
            this.f8349a.C0();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static class b extends ib.i.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b0 f8350c;

        b(b0 r10) {
            this.f8350c = r10;
        }

        @Override // ib.i
        public int[] K1() {
            b0 r10 = this.f8350c;
            if ((r10 instanceof ib.d) == true) goto L5;
            return null;
        L5:
            return ((ib.d) r10).b();
        }

        @Override // ib.i
        public String T() {
            return this.f8350c.T();
        }

        @Override // ib.i
        public void Z1(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L10;
            return;
        L10:
            JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L7
            this.f8350c.a(r11);     // Catch: JSONException -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static class c extends ib.g.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.z f8351c;

        c(ib.z r10) {
            this.f8351c = r10;
        }

        @Override // ib.g
        public boolean g2() {
            return this.f8351c.a();
        }
    }

    static class d implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c0 f8352a;

        d(c0 r10) {
            this.f8352a = r10;
        }

        @Override // ib.d0
        public void C(int r10, DownloadInfo r11, String r12, String r13) {
            this.f8352a.C(r10, r11, r12, r13);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.d0
        public String g0() {
            return this.f8352a.g0();
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        @Override // ib.d0
        public boolean s0(boolean r10) {
            return this.f8352a.s0(r10);
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class e implements ib.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.l f8353a;

        e(ib.l r10) {
            this.f8353a = r10;
        }

        @Override // ib.m
        public boolean S(DownloadInfo r10) {
            return this.f8353a.S(r10);
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }

        @Override // ib.m
        public void m0(DownloadInfo r10) {
            this.f8353a.m0(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            throw new BaseException(PointerIconCompat.TYPE_TEXT, e);
        }
    }

    static class f extends ib.l.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.m f8354c;

        f(ib.m r10) {
            this.f8354c = r10;
        }

        @Override // ib.l
        public boolean S(DownloadInfo r10) {
            return this.f8354c.S(r10);
        }

        @Override // ib.l
        public void m0(DownloadInfo r10) {
            this.f8354c.m0(r10);     // Catch: BaseException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalArgumentException(e);
        }
    }

    static class g implements k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j0 f8355a;

        g(j0 r10) {
            this.f8355a = r10;
        }

        @Override // ib.k0
        public boolean B(DownloadInfo r10) {
            return this.f8355a.B(r10);
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }

        @Override // ib.k0
        public boolean J(DownloadInfo r10) {
            return this.f8355a.J(r10);
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }

        @Override // ib.k0
        public boolean e0(DownloadInfo r10) {
            return this.f8355a.e0(r10);
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.h$h, reason: collision with other inner class name */
    static class C0151h implements ib.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.e f8356a;

        C0151h(ib.e r10) {
            this.f8356a = r10;
        }

        @Override // ib.o
        public void E0(DownloadInfo r10, BaseException r11, int r12) {
            if (r10 != null) goto L9;
            return;
        L9:
            this.f8356a.E0(r10, r11, r12);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static class i extends ib.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.i f8357a;

        i(ib.i r10) {
            this.f8357a = r10;
        }

        @Override // ib.b0
        public String T() {
            return this.f8357a.T();
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }

        @Override // ib.b0
        public void a(JSONObject r10) {
            if (r10 != null) goto L9;
            return;
        L9:
            this.f8357a.Z1(r10.toString());     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.d
        public int[] b() {
            return this.f8357a.K1();
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static class j implements ib.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.w f8358a;

        j(ib.w r10) {
            this.f8358a = r10;
        }

        @Override // ib.y
        public boolean a(ib.x r10) {
            return this.f8358a.p1(h.r(r10));
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class k extends com.ss.android.socialbase.downloader.model.a.AbstractBinderC0149a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f8359c;

        k(com.ss.android.socialbase.downloader.model.d r10) {
            this.f8359c = r10;
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.e B1() {
            return h.b(this.f8359c.t());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public DownloadInfo M1() {
            return this.f8359c.y();
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public int N0() {
            return this.f8359c.w().size();
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.l P1(int r10) {
            return h.h(this.f8359c.v(r10));
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.f R1() {
            return h.p(this.f8359c.C());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public j0 V0() {
            return h.A(this.f8359c.H());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.h W0(int r10) {
            ib.a0 r11 = this.f8359c.J(com.ss.android.socialbase.downloader.utils.c.f(r10));
            if (r10 != ListenerType.SUB.ordinal()) goto L5;
            boolean r12 = false;
        L7:
            return h.x(r11, r12);
        L5:
            r12 = true;
            goto L7
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public int[] a1(int r10) {
            return this.f8359c.A(com.ss.android.socialbase.downloader.utils.c.f(r10));
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.q a2() {
            return h.f(this.f8359c.u());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.i b2() {
            return h.y(this.f8359c.G());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.w d1() {
            return h.t(this.f8359c.D());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.g m1() {
            return h.v(this.f8359c.F());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public c0 r1() {
            return h.l(this.f8359c.I());
        }

        @Override // com.ss.android.socialbase.downloader.model.a
        public ib.h w1(int r10, int r11) {
            ib.a0 r12 = this.f8359c.z(com.ss.android.socialbase.downloader.utils.c.f(r10), r11);
            if (r10 != ListenerType.SUB.ordinal()) goto L5;
            boolean r13 = false;
        L7:
            return h.x(r12, r13);
        L5:
            r13 = true;
            goto L7
        }
    }

    static class l extends ib.h.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.a0 f8360c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f8361g;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8362c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ BaseException f8363g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ l f8364h;

            a(l r10, DownloadInfo r11, BaseException r12) {
                this.f8364h = r10;
                this.f8362c = r11;
                this.f8363g = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8364h.f8360c.G(this.f8362c, this.f8363g);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8365c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ BaseException f8366g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ l f8367h;

            b(l r10, DownloadInfo r11, BaseException r12) {
                this.f8367h = r10;
                this.f8365c = r11;
                this.f8366g = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8367h.f8360c.N(this.f8365c, this.f8366g);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8368c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8369g;

            c(l r10, DownloadInfo r11) {
                this.f8369g = r10;
                this.f8368c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((ib.t) this.f8369g.f8360c).U(this.f8368c);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8370c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8371g;

            d(l r10, DownloadInfo r11) {
                this.f8371g = r10;
                this.f8370c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8371g.f8360c.r0(this.f8370c);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8372c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8373g;

            e(l r10, DownloadInfo r11) {
                this.f8373g = r10;
                this.f8372c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8373g.f8360c.D0(this.f8372c);
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8374c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8375g;

            f(l r10, DownloadInfo r11) {
                this.f8375g = r10;
                this.f8374c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8375g.f8360c.Z(this.f8374c);
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8376c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8377g;

            g(l r10, DownloadInfo r11) {
                this.f8377g = r10;
                this.f8376c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8377g.f8360c.l0(this.f8376c);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.h$l$h, reason: collision with other inner class name */
        class RunnableC0152h implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8378c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8379g;

            RunnableC0152h(l r10, DownloadInfo r11) {
                this.f8379g = r10;
                this.f8378c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8379g.f8360c.W(this.f8378c);
            }
        }

        class i implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8380c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ BaseException f8381g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ l f8382h;

            i(l r10, DownloadInfo r11, BaseException r12) {
                this.f8382h = r10;
                this.f8380c = r11;
                this.f8381g = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8382h.f8360c.p0(this.f8380c, this.f8381g);
            }
        }

        class j implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8383c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8384g;

            j(l r10, DownloadInfo r11) {
                this.f8384g = r10;
                this.f8383c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8384g.f8360c.q0(this.f8383c);
            }
        }

        class k implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8385c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8386g;

            k(l r10, DownloadInfo r11) {
                this.f8386g = r10;
                this.f8385c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8386g.f8360c.I(this.f8385c);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.h$l$l, reason: collision with other inner class name */
        class RunnableC0153l implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ DownloadInfo f8387c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ l f8388g;

            RunnableC0153l(l r10, DownloadInfo r11) {
                this.f8388g = r10;
                this.f8387c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8388g.f8360c.R(this.f8387c);
            }
        }

        l(ib.a0 r10, boolean r11) {
            this.f8360c = r10;
            this.f8361g = r11;
        }

        @Override // ib.h
        public void D0(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new e(this, r10));
            return;
        L5:
            this.f8360c.D0(r10);
        }

        @Override // ib.h
        public int E1() {
            return this.f8360c.hashCode();
        }

        @Override // ib.h
        public void G(DownloadInfo r10, BaseException r11) {
            if (this.f8361g == false) goto L5;
            h.a().post(new a(this, r10, r11));
            return;
        L5:
            this.f8360c.G(r10, r11);
        }

        @Override // ib.h
        public void I(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new k(this, r10));
            return;
        L5:
            this.f8360c.I(r10);
        }

        @Override // ib.h
        public void N(DownloadInfo r10, BaseException r11) {
            if (this.f8361g == false) goto L5;
            h.a().post(new b(this, r10, r11));
            return;
        L5:
            this.f8360c.N(r10, r11);
        }

        @Override // ib.h
        public void R(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new RunnableC0153l(this, r10));
            return;
        L5:
            this.f8360c.R(r10);
        }

        @Override // ib.h
        public void U(DownloadInfo r10) {
            ib.a0 r11 = this.f8360c;
            if ((r11 instanceof ib.t) == true) goto L5;
            return;
        L5:
            if (this.f8361g == false) goto L7;
            h.a().post(new c(this, r10));
            return;
        L7:
            ((ib.t) r11).U(r10);
        }

        @Override // ib.h
        public void W(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new RunnableC0152h(this, r10));
            return;
        L5:
            this.f8360c.W(r10);
        }

        @Override // ib.h
        public void Z(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new f(this, r10));
            return;
        L5:
            this.f8360c.Z(r10);
        }

        @Override // ib.h
        public void l0(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new g(this, r10));
            return;
        L5:
            this.f8360c.l0(r10);
        }

        @Override // ib.h
        public void p0(DownloadInfo r10, BaseException r11) {
            if (this.f8361g == false) goto L5;
            h.a().post(new i(this, r10, r11));
            return;
        L5:
            this.f8360c.p0(r10, r11);
        }

        @Override // ib.h
        public void q0(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new j(this, r10));
            return;
        L5:
            this.f8360c.q0(r10);
        }

        @Override // ib.h
        public void r0(DownloadInfo r10) {
            if (this.f8361g == false) goto L5;
            h.a().post(new d(this, r10));
            return;
        L5:
            this.f8360c.r0(r10);
        }
    }

    static class m extends ib.v.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.x f8389c;

        m(ib.x r10) {
            this.f8389c = r10;
        }

        @Override // ib.v
        public void H(List<String> r10) {
            this.f8389c.H(r10);
        }

        @Override // ib.v
        public boolean c0() {
            return this.f8389c.c0();
        }
    }

    static class n extends m0.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n0 f8390c;

        n(n0 r10) {
            this.f8390c = r10;
        }

        @Override // ib.m0
        public void x0(int r10, int r11) {
            this.f8390c.x0(r10, r11);
        }
    }

    static class o implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m0 f8391a;

        o(m0 r10) {
            this.f8391a = r10;
        }

        @Override // ib.n0
        public void x0(int r10, int r11) {
            this.f8391a.x0(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static class p implements ib.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.q f8392a;

        p(ib.q r10) {
            this.f8392a = r10;
        }

        @Override // ib.s
        public boolean a(long r10, long r11, ib.r r12) {
            return this.f8392a.P0(r10, r11, h.d(r12));
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class q extends ib.p.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.r f8393c;

        q(ib.r r10) {
            this.f8393c = r10;
        }

        @Override // ib.p
        public void C0() {
            this.f8393c.C0();
        }
    }

    static class r implements ib.z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.g f8394a;

        r(ib.g r10) {
            this.f8394a = r10;
        }

        @Override // ib.z
        public boolean a() {
            return this.f8394a.g2();
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class s implements ib.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.f f8395a;

        s(ib.f r10) {
            this.f8395a = r10;
        }

        @Override // ib.u
        public Uri K0(String r10, String r11) {
            return this.f8395a.K0(r10, r11);
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static class t implements ib.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.h f8396a;

        t(ib.h r10) {
            this.f8396a = r10;
        }

        @Override // ib.a0
        public void D0(DownloadInfo r10) {
            this.f8396a.D0(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void G(DownloadInfo r10, BaseException r11) {
            this.f8396a.G(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void I(DownloadInfo r10) {
            this.f8396a.I(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void N(DownloadInfo r10, BaseException r11) {
            this.f8396a.N(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void R(DownloadInfo r10) {
            this.f8396a.R(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.t
        public void U(DownloadInfo r10) {
            this.f8396a.U(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void W(DownloadInfo r10) {
            this.f8396a.W(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void Z(DownloadInfo r10) {
            this.f8396a.Z(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void l0(DownloadInfo r10) {
            this.f8396a.l0(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void p0(DownloadInfo r10, BaseException r11) {
            this.f8396a.p0(r10, r11);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void q0(DownloadInfo r10) {
            this.f8396a.q0(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.a0
        public void r0(DownloadInfo r10) {
            this.f8396a.r0(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static class u extends c0.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d0 f8397c;

        u(d0 r10) {
            this.f8397c = r10;
        }

        @Override // ib.c0
        public void C(int r10, DownloadInfo r11, String r12, String r13) {
            this.f8397c.C(r10, r11, r12, r13);
        }

        @Override // ib.c0
        @Nullable
        public String g0() {
            return this.f8397c.g0();
        }

        @Override // ib.c0
        public boolean s0(boolean r10) {
            return this.f8397c.s0(r10);
        }
    }

    static class v extends j0.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k0 f8398c;

        v(k0 r10) {
            this.f8398c = r10;
        }

        @Override // ib.j0
        public boolean B(DownloadInfo r10) {
            return this.f8398c.B(r10);
        }

        @Override // ib.j0
        public boolean J(DownloadInfo r10) {
            return this.f8398c.J(r10);
        }

        @Override // ib.j0
        public boolean e0(DownloadInfo r10) {
            return this.f8398c.e0(r10);
        }
    }

    static class w extends ib.w.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.y f8399c;

        w(ib.y r10) {
            this.f8399c = r10;
        }

        @Override // ib.w
        public boolean p1(ib.v r10) {
            return this.f8399c.a(h.q(r10));
        }
    }

    static class x extends ib.f.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.u f8400c;

        x(ib.u r10) {
            this.f8400c = r10;
        }

        @Override // ib.f
        public Uri K0(String r10, String r11) {
            return this.f8400c.K0(r10, r11);
        }
    }

    static class y implements ib.x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ib.v f8401a;

        y(ib.v r10) {
            this.f8401a = r10;
        }

        @Override // ib.x
        public void H(List<String> r10) {
            this.f8401a.H(r10);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // ib.x
        public boolean c0() {
            return this.f8401a.c0();
        L4:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class z extends ib.q.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ib.s f8402c;

        z(ib.s r10) {
            this.f8402c = r10;
        }

        @Override // ib.q
        public boolean P0(long r10, long r11, ib.p r12) {
            return this.f8402c.a(r10, r11, h.c(r12));
        }
    }

    static {
        f8347a = new Handler(Looper.getMainLooper());
    }

    public static j0 A(k0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new v(r10);
    }

    public static n0 B(m0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new o(r10);
    }

    public static m0 C(n0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new n(r10);
    }

    private static void D(com.ss.android.socialbase.downloader.model.d r10, com.ss.android.socialbase.downloader.model.a r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.N0()) goto L9;
        ib.l r13 = r11.P1(r12);
        if (r13 == null) goto L8;
        r10.b(g(r13));
    L8:
        r12 = r12 + 1;
        goto L4
    }

    private static void E(com.ss.android.socialbase.downloader.model.d r10, com.ss.android.socialbase.downloader.model.a r11, ListenerType r12) {
        ConcurrentHashMap r13 = new ConcurrentHashMap();
        int[] r14 = r11.a1(r12.ordinal());
        if (r14 != null) goto L5;
    L13:
        r10.e0(r13, r12);
        return;
    L5:
        if (r14.length <= 0) goto L13;
        int r15 = 0;
    L8:
        if (r15 >= r14.length) goto L13;
        ib.h r16 = r11.w1(r12.ordinal(), r14[r15]);
        if (r16 == null) goto L12;
        r13.put(Integer.valueOf(r16.E1()), w(r16));
    L12:
        r15 = r15 + 1;
        goto L8
    }

    static /* synthetic */ Handler a() {
        return f8347a;
    }

    public static ib.e b(ib.o r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new a(r10);
    }

    public static ib.r c(ib.p r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new a0(r10);
    }

    public static ib.p d(ib.r r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new q(r10);
    }

    public static ib.s e(ib.q r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new p(r10);
    }

    public static ib.q f(ib.s r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new z(r10);
    }

    public static ib.m g(ib.l r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new e(r10);
    }

    public static ib.l h(ib.m r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new f(r10);
    }

    public static ib.o i(ib.e r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new C0151h(r10);
    }

    public static b0 j(ib.i r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new i(r10);
    }

    public static d0 k(c0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new d(r10);
    }

    public static c0 l(d0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new u(r10);
    }

    public static com.ss.android.socialbase.downloader.model.d m(com.ss.android.socialbase.downloader.model.a r10) {
        if (r10 != null) goto L19;
        return null;
    L19:
        com.ss.android.socialbase.downloader.model.d r11 = new com.ss.android.socialbase.downloader.model.d(r10.M1());     // Catch: RemoteException -> L16
        r11.W(k(r10.r1())).N(u(r10.m1())).l(i(r10.B1())).S(j(r10.b2())).r(s(r10.d1())).m(e(r10.a2())).q(o(r10.R1())).V(z(r10.V0()));     // Catch: RemoteException -> L16
        ListenerType r12 = ListenerType.MAIN;     // Catch: RemoteException -> L16
        ib.h r13 = r10.W0(r12.ordinal());     // Catch: RemoteException -> L16
        if (r13 == null) goto L8;
        r11.Q(r13.hashCode(), w(r13));     // Catch: RemoteException -> L16
    L8:
        ListenerType r14 = ListenerType.SUB;     // Catch: RemoteException -> L16
        ib.h r15 = r10.W0(r14.ordinal());     // Catch: RemoteException -> L16
        if (r15 == null) goto L11;
        r11.j0(r15.hashCode(), w(r15));     // Catch: RemoteException -> L16
    L11:
        ListenerType r16 = ListenerType.NOTIFICATION;     // Catch: RemoteException -> L16
        ib.h r17 = r10.W0(r16.ordinal());     // Catch: RemoteException -> L16
        if (r17 == null) goto L14;
        r11.X(r17.hashCode(), w(r17));     // Catch: RemoteException -> L16
    L14:
        E(r11, r10, r12);     // Catch: RemoteException -> L16
        E(r11, r10, r14);     // Catch: RemoteException -> L16
        E(r11, r10, r16);     // Catch: RemoteException -> L16
        D(r11, r10);     // Catch: RemoteException -> L16
        return r11;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static com.ss.android.socialbase.downloader.model.a n(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new k(r10);
    }

    public static ib.u o(ib.f r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new s(r10);
    }

    public static ib.f p(ib.u r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new x(r10);
    }

    public static ib.x q(ib.v r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new y(r10);
    }

    public static ib.v r(ib.x r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new m(r10);
    }

    public static ib.y s(ib.w r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new j(r10);
    }

    public static ib.w t(ib.y r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new w(r10);
    }

    public static ib.z u(ib.g r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new r(r10);
    }

    public static ib.g v(ib.z r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new c(r10);
    }

    public static ib.a0 w(ib.h r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new t(r10);
    }

    public static ib.h x(ib.a0 r10, boolean r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new l(r10, r11);
    }

    public static ib.i y(b0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new b(r10);
    }

    public static k0 z(j0 r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new g(r10);
    }
}
