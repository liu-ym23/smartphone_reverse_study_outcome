package f1;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.f0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class f extends f0 {

    public class a implements h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f7253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7254b;

        public a(View r8, ArrayList r10) {
            this.f7253a = r8;
            this.f7254b = r10;
        }

        @Override // f1.h.d
        public final void a() {
        }

        @Override // f1.h.d
        public final void b() {
        }

        @Override // f1.h.d
        public final void c() {
        }

        @Override // f1.h.d
        public final void d(h r8) {
            r8.v(this);
            this.f7253a.setVisibility(8);
            ArrayList r10 = this.f7254b;
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            ((View) r10.get(r12)).setVisibility(0);
            r12 = r12 + 1;
            goto L3
        }

        @Override // f1.h.d
        public final void e() {
        }
    }

    public class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f7255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7256b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Object f7257m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7258n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Object f7259o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7260p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ f f7261q;

        public b(f r8, Object r10, ArrayList r11, Object r12, ArrayList r13, Object r14, ArrayList r15) {
            this.f7261q = r8;
            this.f7255a = r10;
            this.f7256b = r11;
            this.f7257m = r12;
            this.f7258n = r13;
            this.f7259o = r14;
            this.f7260p = r15;
        }

        @Override // f1.h.d
        public final void d(h r8) {
            r8.v(this);
        }

        @Override // f1.k, f1.h.d
        public final void e() {
            f r8 = this.f7261q;
            Object r10 = this.f7255a;
            if (r10 == null) goto L5;
            r8.u(r10, this.f7256b, null);
        L5:
            Object r11 = this.f7257m;
            if (r11 == null) goto L8;
            r8.u(r11, this.f7258n, null);
        L8:
            Object r12 = this.f7259o;
            if (r12 == null) goto L12;
            r8.u(r12, this.f7260p, null);
            return;
        }
    }

    public class c extends h.c {
    }

    public f() {
    }

    @Override // androidx.fragment.app.f0
    public final void a(View r8, Object r10) {
        if (r10 == null) goto L5;
        ((h) r10).b(r8);
        return;
    }

    @Override // androidx.fragment.app.f0
    public final void b(Object r8, ArrayList<View> r10) {
        h r11 = (h) r8;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = 0;
        if ((r11 instanceof m) == false) goto L17;
        m r13 = (m) r11;
        int r14 = r13.H.size();
    L8:
        if (r12 >= r14) goto L37;
        if (r12 >= 0) goto L11;
    L14:
        h r15 = null;
    L15:
        b(r15, r10);
        r12 = r12 + 1;
        goto L8
    L11:
        if (r12 >= r13.H.size()) goto L14;
        r15 = r13.H.get(r12);
        goto L15
    L37:
        return;
    L17:
        if (f0.h(r11.f7266o) == true) goto L19;
    L24:
        boolean r16 = true;
    L25:
        if (r16 == false) goto L27;
        return;
    L27:
        if (f0.h(r11.f7267p) == false) goto L36;
        int r17 = r10.size();
    L29:
        if (r12 >= r17) goto L38;
        r11.b(r10.get(r12));
        r12 = r12 + 1;
        goto L29
    L38:
        return;
    L36:
        return;
    L19:
        if (f0.h(null) == false) goto L24;
        if (f0.h(null) == false) goto L24;
        r16 = false;
        goto L25
    }

    @Override // androidx.fragment.app.f0
    public final void c(ViewGroup r8, Object r10) {
        l.a(r8, (h) r10);
    }

    @Override // androidx.fragment.app.f0
    public final boolean e(Object r8) {
        return r8 instanceof h;
    }

    @Override // androidx.fragment.app.f0
    public final Object f(Object r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return ((h) r8).j();
    }

    @Override // androidx.fragment.app.f0
    public final Object i(Object r8, Object r10, Object r11) {
        h r12 = (h) r8;
        h r13 = (h) r10;
        h r14 = (h) r11;
        if (r12 == null) goto L6;
        if (r13 == null) goto L6;
        m r15 = new m();
        r15.H(r12);
        r15.H(r13);
        r15.I = false;
        r12 = r15;
    L11:
        if (r14 == null) goto L17;
        m r16 = new m();
        if (r12 == null) goto L15;
        r16.H(r12);
    L15:
        r16.H(r14);
        return r16;
    L17:
        return r12;
    L6:
        if (r12 != null) goto L11;
        if (r13 == null) goto L10;
        r12 = r13;
        goto L11
    L10:
        r12 = null;
        goto L11
    }

    @Override // androidx.fragment.app.f0
    public final Object j(Object r8, Object r10, Object r11) {
        m r12 = new m();
        if (r8 == null) goto L5;
        r12.H((h) r8);
    L5:
        if (r10 == null) goto L7;
        r12.H((h) r10);
    L7:
        if (r11 == null) goto L9;
        r12.H((h) r11);
    L9:
        return r12;
    }

    @Override // androidx.fragment.app.f0
    public final void l(Object r8, View r10, ArrayList<View> r11) {
        ((h) r8).a(new a(r10, r11));
    }

    @Override // androidx.fragment.app.f0
    public final void m(Object r11, Object r12, ArrayList<View> r13, Object r14, ArrayList<View> r15, Object r16, ArrayList<View> r17) {
        ((h) r11).a(new b(this, r12, r13, r14, r15, r16, r17));
    }

    @Override // androidx.fragment.app.f0
    public final void n(View r8, Object r10) {
        if (r8 == null) goto L5;
        f0.g(r8, new Rect());
        ((h) r10).A(new e());
        return;
    }

    @Override // androidx.fragment.app.f0
    public final void o(Object r8, Rect r10) {
        if (r8 == null) goto L5;
        ((h) r8).A(new c());
        return;
    }

    @Override // androidx.fragment.app.f0
    public final void r(Object r8, View r10, ArrayList<View> r11) {
        m r12 = (m) r8;
        ArrayList<View> r13 = r12.f7267p;
        r13.clear();
        int r14 = r11.size();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        f0.d(r11.get(r15), r13);
        r15 = r15 + 1;
        goto L3
    L5:
        r13.add(r10);
        r11.add(r10);
        b(r12, r11);
    }

    @Override // androidx.fragment.app.f0
    public final void s(Object r8, ArrayList<View> r10, ArrayList<View> r11) {
        m r12 = (m) r8;
        if (r12 == null) goto L6;
        ArrayList<View> r13 = r12.f7267p;
        r13.clear();
        r13.addAll(r11);
        u(r12, r10, r11);
        return;
    }

    @Override // androidx.fragment.app.f0
    public final Object t(Object r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        m r10 = new m();
        r10.H((h) r8);
        return r10;
    }

    public final void u(Object r8, ArrayList<View> r10, ArrayList<View> r11) {
        h r12 = (h) r8;
        int r13 = 0;
        if ((r12 instanceof m) == false) goto L14;
        m r14 = (m) r12;
        int r15 = r14.H.size();
    L5:
        if (r13 >= r15) goto L45;
        if (r13 >= 0) goto L8;
    L11:
        h r16 = null;
    L12:
        u(r16, r10, r11);
        r13 = r13 + 1;
        goto L5
    L8:
        if (r13 >= r14.H.size()) goto L11;
        r16 = r14.H.get(r13);
        goto L12
    L45:
        return;
    L14:
        if (f0.h(r12.f7266o) == true) goto L16;
    L21:
        boolean r17 = true;
    L22:
        if (r17 == true) goto L36;
        ArrayList<View> r18 = r12.f7267p;
        if (r18.size() == r10.size()) goto L26;
        return;
    L26:
        if (r18.containsAll(r10) == false) goto L44;
        if (r11 != null) goto L29;
        int r19 = 0;
    L30:
        if (r13 >= r19) goto L32;
        r12.b(r11.get(r13));
        r13 = r13 + 1;
        goto L30
    L32:
        int r20 = r10.size();
    L33:
        r20 = r20 - 1;
        if (r20 < 0) goto L46;
        r12.w(r10.get(r20));
        goto L33
    L46:
        return;
    L29:
        r19 = r11.size();
        goto L30
    L44:
        return;
    L36:
        return;
    L16:
        if (f0.h(null) == false) goto L21;
        if (f0.h(null) == false) goto L21;
        r17 = false;
        goto L22
    }
}
