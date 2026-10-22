package j0;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m0 f8408b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f8409a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f8410a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Field f8411b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Field f8412c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f8413d = false;

        static {
            Field r8 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            f8410a = r8;     // Catch: ReflectiveOperationException -> L4
            r8.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class<?> r10 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L4
            Field r11 = r10.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            f8411b = r11;     // Catch: ReflectiveOperationException -> L4
            r11.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r12 = r10.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            f8412c = r12;     // Catch: ReflectiveOperationException -> L4
            r12.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            f8413d = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8414a;

        public b() {
            this.f8414a = new d();
        }

        public final m0 a() {
            return this.f8414a.f();
        }

        public b(m0 r8) {
            this.f8414a = new d(r8);
        }
    }

    public static class c extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WindowInsets.Builder f8415b;

        public c() {
            this.f8415b = new WindowInsets.Builder();
        }

        @Override // j0.m0.e
        public void b(a0.b r8) {
            this.f8415b.setMandatorySystemGestureInsets(r8.d());
        }

        @Override // j0.m0.e
        public void c(a0.b r8) {
            this.f8415b.setSystemGestureInsets(r8.d());
        }

        @Override // j0.m0.e
        public void d(a0.b r8) {
            this.f8415b.setSystemWindowInsets(r8.d());
        }

        @Override // j0.m0.e
        public void e(a0.b r8) {
            this.f8415b.setTappableElementInsets(r8.d());
        }

        public m0 f() {
            a();
            m0 r8 = m0.h(null, this.f8415b.build());
            r8.f8409a.o(null);
            return r8;
        }

        public void g(a0.b r8) {
            this.f8415b.setStableInsets(r8.d());
        }

        public c(m0 r8) {
            super(r8);
            WindowInsets r10 = r8.g();
            if (r10 == null) goto L5;
            WindowInsets.Builder r11 = new WindowInsets.Builder(r10);
        L6:
            this.f8415b = r11;
            return;
        L5:
            r11 = new WindowInsets.Builder();
            goto L6
        }
    }

    public static class d extends c {
        public d() {
        }

        public d(m0 r8) {
            super(r8);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m0 f8416a;

        public e() {
            this(new m0());
        }

        public final void a() {
        }

        public void b(a0.b r8) {
            throw null;
        }

        public void c(a0.b r8) {
            throw null;
        }

        public void d(a0.b r8) {
            throw null;
        }

        public void e(a0.b r8) {
            throw null;
        }

        public e(m0 r8) {
            this.f8416a = r8;
        }
    }

    public static class f extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f8417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a0.b[] f8418d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a0.b f8419e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public m0 f8420f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public a0.b f8421g;

        public f(m0 r8, WindowInsets r10) {
            super(r8);
            this.f8419e = null;
            this.f8417c = r10;
        }

        @SuppressLint({"WrongConstant"})
        private a0.b q(int r8, boolean r10) {
            a0.b r11 = a0.b.f3e;
            int r12 = 1;
        L4:
            if (r12 > 256) goto L10;
            if ((r8 & r12) == 0) goto L9;
            r11 = a0.b.a(r11, r(r12, r10));
        L9:
            r12 = r12 << 1;
            goto L4
        L10:
            return r11;
        }

        private a0.b s() {
            m0 r8 = this.f8420f;
            if (r8 == null) goto L7;
            return r8.f8409a.h();
        L7:
            return a0.b.f3e;
        }

        private a0.b t(View r8) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // j0.m0.k
        public void d(View r8) {
            a0.b r10 = t(r8);
            if (r10 != null) goto L5;
            r10 = a0.b.f3e;
        L5:
            u(r10);
        }

        @Override // j0.m0.k
        public boolean equals(Object r8) {
            if (super.equals(r8) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.f8421g, ((f) r8).f8421g);
        }

        @Override // j0.m0.k
        public a0.b f(int r8) {
            return q(r8, false);
        }

        @Override // j0.m0.k
        public final a0.b j() {
            if (this.f8419e != null) goto L6;
            WindowInsets r8 = this.f8417c;
            this.f8419e = a0.b.b(r8.getSystemWindowInsetLeft(), r8.getSystemWindowInsetTop(), r8.getSystemWindowInsetRight(), r8.getSystemWindowInsetBottom());
        L6:
            return this.f8419e;
        }

        @Override // j0.m0.k
        public m0 l(int r8, int r10, int r11, int r12) {
            b r13 = new b(m0.h(null, this.f8417c));
            a0.b r14 = m0.f(j(), r8, r10, r11, r12);
            d r15 = r13.f8414a;
            r15.d(r14);
            r15.g(m0.f(h(), r8, r10, r11, r12));
            return r13.a();
        }

        @Override // j0.m0.k
        public boolean n() {
            return this.f8417c.isRound();
        }

        @Override // j0.m0.k
        public void o(a0.b[] r8) {
            this.f8418d = r8;
        }

        @Override // j0.m0.k
        public void p(m0 r8) {
            this.f8420f = r8;
        }

        public a0.b r(int r8, boolean r10) {
            if (r8 == 1) goto L60;
            a0.b r11 = null;
            if (r8 == 2) goto L49;
            a0.b r12 = a0.b.f3e;
            if (r8 != 8) goto L9;
            a0.b[] r13 = this.f8418d;
            if (r13 == null) goto L34;
            r11 = r13[l.a(8)];
        L34:
            if (r11 == null) goto L36;
            return r11;
        L36:
            a0.b r14 = j();
            a0.b r15 = s();
            int r16 = r14.f7d;
            if (r16 > r15.f7d) goto L39;
            a0.b r17 = this.f8421g;
            if (r17 != null) goto L43;
        L48:
            return r12;
        L43:
            if (r17.equals(r12) == true) goto L48;
            int r18 = this.f8421g.f7d;
            if (r18 <= r15.f7d) goto L48;
            return a0.b.b(0, 0, 0, r18);
        L39:
            return a0.b.b(0, 0, 0, r16);
        L9:
            if (r8 == 16) goto L30;
            if (r8 == 32) goto L28;
            if (r8 == 64) goto L26;
            if (r8 == 128) goto L17;
            return r12;
        L17:
            m0 r19 = this.f8420f;
            if (r19 == null) goto L20;
            j0.c r20 = r19.f8409a.e();
        L21:
            if (r20 == null) goto L24;
            DisplayCutout r21 = r20.f8375a;
            return a0.b.b(j0.c.a.d(r21), j0.c.a.f(r21), j0.c.a.e(r21), j0.c.a.c(r21));
        L24:
            return r12;
        L20:
            r20 = e();
            goto L21
        L26:
            return k();
        L28:
            return g();
        L30:
            return i();
        L49:
            if (r10 == false) goto L52;
            a0.b r22 = s();
            a0.b r23 = h();
            return a0.b.b(Math.max(r22.f4a, r23.f4a), 0, Math.max(r22.f6c, r23.f6c), Math.max(r22.f7d, r23.f7d));
        L52:
            a0.b r24 = j();
            m0 r25 = this.f8420f;
            if (r25 == null) goto L55;
            r11 = r25.f8409a.h();
        L55:
            int r26 = r24.f7d;
            if (r11 == null) goto L59;
            r26 = Math.min(r26, r11.f7d);
        L59:
            return a0.b.b(r24.f4a, 0, r24.f6c, r26);
        L60:
            if (r10 == false) goto L64;
            return a0.b.b(0, Math.max(s().f5b, j().f5b), 0, 0);
        L64:
            return a0.b.b(0, j().f5b, 0, 0);
        }

        public void u(a0.b r8) {
            this.f8421g = r8;
        }
    }

    public static class g extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public a0.b f8422h;

        public g(m0 r8, WindowInsets r10) {
            super(r8, r10);
            this.f8422h = null;
        }

        @Override // j0.m0.k
        public m0 b() {
            return m0.h(null, this.f8417c.consumeStableInsets());
        }

        @Override // j0.m0.k
        public m0 c() {
            return m0.h(null, this.f8417c.consumeSystemWindowInsets());
        }

        @Override // j0.m0.k
        public final a0.b h() {
            if (this.f8422h != null) goto L6;
            WindowInsets r8 = this.f8417c;
            this.f8422h = a0.b.b(r8.getStableInsetLeft(), r8.getStableInsetTop(), r8.getStableInsetRight(), r8.getStableInsetBottom());
        L6:
            return this.f8422h;
        }

        @Override // j0.m0.k
        public boolean m() {
            return this.f8417c.isConsumed();
        }
    }

    public static class h extends g {
        public h(m0 r8, WindowInsets r10) {
            super(r8, r10);
        }

        @Override // j0.m0.k
        public m0 a() {
            return m0.h(null, this.f8417c.consumeDisplayCutout());
        }

        @Override // j0.m0.k
        public j0.c e() {
            DisplayCutout r8 = this.f8417c.getDisplayCutout();
            if (r8 != null) goto L6;
            return null;
        L6:
            return new j0.c(r8);
        }

        @Override // j0.m0.f, j0.m0.k
        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof h) == true) goto L8;
            return false;
        L8:
            h r10 = (h) r8;
            WindowInsets r11 = r10.f8417c;
            if (Objects.equals(this.f8417c, r11) == false) goto L14;
            if (Objects.equals(this.f8421g, r10.f8421g) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // j0.m0.k
        public int hashCode() {
            return this.f8417c.hashCode();
        }
    }

    public static class i extends h {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public a0.b f8423i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public a0.b f8424j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public a0.b f8425k;

        public i(m0 r8, WindowInsets r10) {
            super(r8, r10);
            this.f8423i = null;
            this.f8424j = null;
            this.f8425k = null;
        }

        @Override // j0.m0.k
        public a0.b g() {
            if (this.f8424j != null) goto L6;
            this.f8424j = a0.b.c(this.f8417c.getMandatorySystemGestureInsets());
        L6:
            return this.f8424j;
        }

        @Override // j0.m0.k
        public a0.b i() {
            if (this.f8423i != null) goto L6;
            this.f8423i = a0.b.c(this.f8417c.getSystemGestureInsets());
        L6:
            return this.f8423i;
        }

        @Override // j0.m0.k
        public a0.b k() {
            if (this.f8425k != null) goto L6;
            this.f8425k = a0.b.c(this.f8417c.getTappableElementInsets());
        L6:
            return this.f8425k;
        }

        @Override // j0.m0.f, j0.m0.k
        public m0 l(int r8, int r10, int r11, int r12) {
            return m0.h(null, this.f8417c.inset(r8, r10, r11, r12));
        }
    }

    public static class j extends i {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final m0 f8426l = null;

        static {
            f8426l = m0.h(null, WindowInsets.CONSUMED);
        }

        public j(m0 r8, WindowInsets r10) {
            super(r8, r10);
        }

        @Override // j0.m0.f, j0.m0.k
        public final void d(View r8) {
        }

        @Override // j0.m0.f, j0.m0.k
        public a0.b f(int r8) {
            return a0.b.c(this.f8417c.getInsets(m.a(r8)));
        }
    }

    public static class k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final m0 f8427b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m0 f8428a;

        static {
            f8427b = new b().a().f8409a.a().f8409a.b().f8409a.c();
        }

        public k(m0 r8) {
            this.f8428a = r8;
        }

        public m0 a() {
            return this.f8428a;
        }

        public m0 b() {
            return this.f8428a;
        }

        public m0 c() {
            return this.f8428a;
        }

        public void d(View r8) {
        }

        public j0.c e() {
            return null;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof k) == true) goto L8;
            return false;
        L8:
            k r10 = (k) r8;
            if (n() != r10.n()) goto L20;
            if (m() != r10.m()) goto L20;
            if (i0.b.a(j(), r10.j()) == false) goto L20;
            if (i0.b.a(h(), r10.h()) == false) goto L20;
            if (i0.b.a(e(), r10.e()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public a0.b f(int r8) {
            return a0.b.f3e;
        }

        public a0.b g() {
            return j();
        }

        public a0.b h() {
            return a0.b.f3e;
        }

        public int hashCode() {
            return i0.b.b(new Object[]{Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e()});
        }

        public a0.b i() {
            return j();
        }

        public a0.b j() {
            return a0.b.f3e;
        }

        public a0.b k() {
            return j();
        }

        public m0 l(int r8, int r10, int r11, int r12) {
            return f8427b;
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void o(a0.b[] r8) {
        }

        public void p(m0 r8) {
        }
    }

    public static final class l {
        public static int a(int r8) {
            if (r8 != 1) goto L5;
            return 0;
        L5:
            if (r8 != 2) goto L7;
            return 1;
        L7:
            if (r8 != 4) goto L9;
            return 2;
        L9:
            if (r8 != 8) goto L11;
            return 3;
        L11:
            if (r8 != 16) goto L13;
            return 4;
        L13:
            if (r8 != 32) goto L15;
            return 5;
        L15:
            if (r8 != 64) goto L17;
            return 6;
        L17:
            if (r8 != 128) goto L19;
            return 7;
        L19:
            if (r8 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException(defpackage.a.d("type needs to be >= FIRST and <= LAST, type=", r8));
        }
    }

    public static final class m {
        public static int a(int r8) {
            int r10 = 0;
            int r11 = 1;
        L4:
            if (r11 > 256) goto L33;
            if ((r8 & r11) == 0) goto L32;
            if (r11 != 1) goto L9;
            int r12 = WindowInsets.Type.statusBars();
        L31:
            r10 = r10 | r12;
            goto L32
        L9:
            if (r11 != 2) goto L11;
            r12 = WindowInsets.Type.navigationBars();
            goto L31
        L11:
            if (r11 != 4) goto L13;
            r12 = WindowInsets.Type.captionBar();
            goto L31
        L13:
            if (r11 != 8) goto L15;
            r12 = WindowInsets.Type.ime();
            goto L31
        L15:
            if (r11 != 16) goto L17;
            r12 = WindowInsets.Type.systemGestures();
            goto L31
        L17:
            if (r11 != 32) goto L19;
            r12 = WindowInsets.Type.mandatorySystemGestures();
            goto L31
        L19:
            if (r11 != 64) goto L21;
            r12 = WindowInsets.Type.tappableElement();
            goto L31
        L21:
            if (r11 != 128) goto L32;
            r12 = WindowInsets.Type.displayCutout();
        L32:
            r11 = r11 << 1;
            goto L4
        L33:
            return r10;
        }
    }

    static {
        f8408b = j.f8426l;
    }

    public m0() {
        this.f8409a = new k(this);
    }

    public static a0.b f(a0.b r8, int r10, int r11, int r12, int r13) {
        int r14 = Math.max(0, r8.f4a - r10);
        int r15 = Math.max(0, r8.f5b - r11);
        int r16 = Math.max(0, r8.f6c - r12);
        int r17 = Math.max(0, r8.f7d - r13);
        if (r14 != r10) goto L9;
        if (r15 != r11) goto L9;
        if (r16 != r12) goto L9;
        if (r17 != r13) goto L9;
        return r8;
    L9:
        return a0.b.b(r14, r15, r16, r17);
    }

    public static m0 h(View r8, WindowInsets r10) {
        r10.getClass();
        m0 r11 = new m0(r10);
        if (r8 == null) goto L7;
        WeakHashMap<View, h0> r12 = w.f8437a;
        if (w.g.b(r8) == false) goto L7;
        m0 r13 = w.j.a(r8);
        k r14 = r11.f8409a;
        r14.p(r13);
        r14.d(r8.getRootView());
    L7:
        return r11;
    }

    public final a0.b a(int r8) {
        return this.f8409a.f(r8);
    }

    @Deprecated
    public final int b() {
        return this.f8409a.j().f7d;
    }

    @Deprecated
    public final int c() {
        return this.f8409a.j().f4a;
    }

    @Deprecated
    public final int d() {
        return this.f8409a.j().f6c;
    }

    @Deprecated
    public final int e() {
        return this.f8409a.j().f5b;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m0) == true) goto L9;
        return false;
    L9:
        k r10 = ((m0) r8).f8409a;
        return i0.b.a(this.f8409a, r10);
    }

    public final WindowInsets g() {
        k r8 = this.f8409a;
        if ((r8 instanceof f) == true) goto L7;
        return null;
    L7:
        return ((f) r8).f8417c;
    }

    public final int hashCode() {
        k r8 = this.f8409a;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.hashCode();
    }

    public m0(WindowInsets r8) {
        this.f8409a = new j(this, r8);
    }
}
