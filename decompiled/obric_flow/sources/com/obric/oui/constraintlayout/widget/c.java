package com.obric.oui.constraintlayout.widget;

import android.view.ViewGroup;
import java.util.HashMap;
import lr.f;
import lr.g;
import lr.h;
import lr.i;
import lr.j;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f13064c;
    public final h d;
    public final g e;
    public final j f;
    public HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f13065h;

    public c() {
        i r5 = new i();
        r5.f19759a = false;
        r5.f19760b = 0;
        r5.f19761c = 0;
        r5.d = 1.0f;
        r5.e = Float.NaN;
        this.f13064c = r5;
        h r10 = new h();
        r10.f19750a = false;
        r10.f19751b = -1;
        r10.f19752c = 0;
        r10.d = null;
        r10.e = -1;
        r10.f = 0;
        r10.g = Float.NaN;
        r10.f19753h = Float.NaN;
        r10.f19754i = Float.NaN;
        r10.f19755j = -1;
        r10.f19756k = null;
        r10.f19757l = -3;
        r10.f19758m = -1;
        this.d = r10;
        g r11 = new g();
        r11.f19715a = false;
        r11.f19717b = false;
        r11.e = -1;
        r11.f = -1;
        r11.g = -1.0f;
        r11.f19724h = true;
        r11.f19726i = -1;
        r11.f19727j = -1;
        r11.f19729k = -1;
        r11.f19731l = -1;
        r11.f19732m = -1;
        r11.f19734n = -1;
        r11.f19736o = -1;
        r11.f19738p = -1;
        r11.f19740q = -1;
        r11.f19741r = -1;
        r11.s = -1;
        r11.f19742t = -1;
        r11.f19743u = -1;
        r11.f19744v = -1;
        r11.f19745w = -1;
        r11.f19746x = 0.5f;
        r11.f19747y = 0.5f;
        r11.f19748z = null;
        r11.A = -1;
        r11.B = 0;
        r11.C = 0.0f;
        r11.D = -1;
        r11.E = -1;
        r11.F = -1;
        r11.G = 0;
        r11.H = 0;
        r11.I = 0;
        r11.J = 0;
        r11.K = 0;
        r11.L = 0;
        r11.M = 0;
        r11.N = Integer.MIN_VALUE;
        r11.O = Integer.MIN_VALUE;
        r11.P = Integer.MIN_VALUE;
        r11.Q = Integer.MIN_VALUE;
        r11.R = Integer.MIN_VALUE;
        r11.S = Integer.MIN_VALUE;
        r11.T = Integer.MIN_VALUE;
        r11.U = -1.0f;
        r11.V = -1.0f;
        r11.W = 0;
        r11.X = 0;
        r11.Y = 0;
        r11.Z = 0;
        r11.f19716a0 = 0;
        r11.f19718b0 = 0;
        r11.f19720c0 = 0;
        r11.f19721d0 = 0;
        r11.f19722e0 = 1.0f;
        r11.f19723f0 = 1.0f;
        r11.g0 = -1;
        r11.f19725h0 = 0;
        r11.i0 = -1;
        r11.f19733m0 = false;
        r11.f19735n0 = false;
        r11.f19737o0 = true;
        r11.f19739p0 = 0;
        this.e = r11;
        j r12 = new j();
        r12.f19763a = false;
        r12.f19764b = 0.0f;
        r12.f19765c = 0.0f;
        r12.d = 0.0f;
        r12.e = 1.0f;
        r12.f = 1.0f;
        r12.g = Float.NaN;
        r12.f19766h = Float.NaN;
        r12.f19767i = -1;
        r12.f19768j = 0.0f;
        r12.f19769k = 0.0f;
        r12.f19770l = 0.0f;
        r12.f19771m = false;
        r12.f19772n = 0.0f;
        this.f = r12;
        this.g = new HashMap();
    }

    public final void a(ConstraintLayout.LayoutParams r5) {
        g r10 = this.e;
        r5.e = r10.f19726i;
        r5.f = r10.f19727j;
        r5.g = r10.f19729k;
        r5.f13010h = r10.f19731l;
        r5.f13012i = r10.f19732m;
        r5.f13013j = r10.f19734n;
        r5.f13015k = r10.f19736o;
        r5.f13017l = r10.f19738p;
        r5.f13018m = r10.f19740q;
        r5.f13020n = r10.f19741r;
        r5.f13022o = r10.s;
        r5.s = r10.f19742t;
        r5.f13029t = r10.f19743u;
        r5.f13030u = r10.f19744v;
        r5.f13031v = r10.f19745w;
        ((ViewGroup.MarginLayoutParams) r5).leftMargin = r10.G;
        ((ViewGroup.MarginLayoutParams) r5).rightMargin = r10.H;
        ((ViewGroup.MarginLayoutParams) r5).topMargin = r10.I;
        ((ViewGroup.MarginLayoutParams) r5).bottomMargin = r10.J;
        r5.A = r10.S;
        r5.B = r10.R;
        r5.f13033x = r10.O;
        r5.f13035z = r10.Q;
        r5.E = r10.f19746x;
        r5.F = r10.f19747y;
        r5.f13024p = r10.A;
        r5.f13026q = r10.B;
        r5.f13028r = r10.C;
        r5.G = r10.f19748z;
        r5.T = r10.D;
        r5.U = r10.E;
        r5.I = r10.U;
        r5.H = r10.V;
        r5.K = r10.X;
        r5.J = r10.W;
        r5.W = r10.f19733m0;
        r5.X = r10.f19735n0;
        r5.L = r10.Y;
        r5.M = r10.Z;
        r5.P = r10.f19716a0;
        r5.Q = r10.f19718b0;
        r5.N = r10.f19720c0;
        r5.O = r10.f19721d0;
        r5.R = r10.f19722e0;
        r5.S = r10.f19723f0;
        r5.V = r10.F;
        r5.f13005c = r10.g;
        r5.f13001a = r10.e;
        r5.f13003b = r10.f;
        ((ViewGroup.MarginLayoutParams) r5).width = r10.f19719c;
        ((ViewGroup.MarginLayoutParams) r5).height = r10.d;
        String r11 = r10.l0;
        if (r11 == null) goto L5;
        r5.Y = r11;
    L5:
        r5.Z = r10.f19739p0;
        r5.setMarginStart(r10.L);
        r5.setMarginEnd(r10.K);
        r5.a();
    }

    public final c b() {
        c r5 = new c();
        r5.e.a(this.e);
        r5.d.a(this.d);
        i r10 = r5.f13064c;
        i r11 = this.f13064c;
        r10.f19759a = r11.f19759a;
        r10.f19760b = r11.f19760b;
        r10.d = r11.d;
        r10.e = r11.e;
        r10.f19761c = r11.f19761c;
        r5.f.a(this.f);
        r5.f13062a = this.f13062a;
        r5.f13065h = this.f13065h;
        return r5;
    }

    public final void c(int r5, ConstraintLayout.LayoutParams r10) {
        this.f13062a = r5;
        int r11 = r10.e;
        g r12 = this.e;
        r12.f19726i = r11;
        r12.f19727j = r10.f;
        r12.f19729k = r10.g;
        r12.f19731l = r10.f13010h;
        r12.f19732m = r10.f13012i;
        r12.f19734n = r10.f13013j;
        r12.f19736o = r10.f13015k;
        r12.f19738p = r10.f13017l;
        r12.f19740q = r10.f13018m;
        r12.f19741r = r10.f13020n;
        r12.s = r10.f13022o;
        r12.f19742t = r10.s;
        r12.f19743u = r10.f13029t;
        r12.f19744v = r10.f13030u;
        r12.f19745w = r10.f13031v;
        r12.f19746x = r10.E;
        r12.f19747y = r10.F;
        r12.f19748z = r10.G;
        r12.A = r10.f13024p;
        r12.B = r10.f13026q;
        r12.C = r10.f13028r;
        r12.D = r10.T;
        r12.E = r10.U;
        r12.F = r10.V;
        r12.g = r10.f13005c;
        r12.e = r10.f13001a;
        r12.f = r10.f13003b;
        r12.f19719c = ((ViewGroup.MarginLayoutParams) r10).width;
        r12.d = ((ViewGroup.MarginLayoutParams) r10).height;
        r12.G = ((ViewGroup.MarginLayoutParams) r10).leftMargin;
        r12.H = ((ViewGroup.MarginLayoutParams) r10).rightMargin;
        r12.I = ((ViewGroup.MarginLayoutParams) r10).topMargin;
        r12.J = ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
        r12.M = r10.D;
        r12.U = r10.I;
        r12.V = r10.H;
        r12.X = r10.K;
        r12.W = r10.J;
        r12.f19733m0 = r10.W;
        r12.f19735n0 = r10.X;
        r12.Y = r10.L;
        r12.Z = r10.M;
        r12.f19716a0 = r10.P;
        r12.f19718b0 = r10.Q;
        r12.f19720c0 = r10.N;
        r12.f19721d0 = r10.O;
        r12.f19722e0 = r10.R;
        r12.f19723f0 = r10.S;
        r12.l0 = r10.Y;
        r12.O = r10.f13033x;
        r12.Q = r10.f13035z;
        r12.N = r10.f13032w;
        r12.P = r10.f13034y;
        r12.S = r10.A;
        r12.R = r10.B;
        r12.T = r10.C;
        r12.f19739p0 = r10.Z;
        r12.K = r10.getMarginEnd();
        r12.L = r10.getMarginStart();
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public final void d(int r5, Constraints.LayoutParams r10) {
        c(r5, r10);
        i r11 = this.f13064c;
        r11.d = r10.f13037r0;
        float r12 = r10.f13040u0;
        j r13 = this.f;
        r13.f19764b = r12;
        r13.f19765c = r10.f13041v0;
        r13.d = r10.f13042w0;
        r13.e = r10.f13043x0;
        r13.f = r10.f13044y0;
        r13.g = r10.f13045z0;
        r13.f19766h = r10.A0;
        r13.f19768j = r10.B0;
        r13.f19769k = r10.C0;
        r13.f19770l = r10.D0;
        r13.f19772n = r10.f13039t0;
        r13.f19771m = r10.f13038s0;
    }
}
