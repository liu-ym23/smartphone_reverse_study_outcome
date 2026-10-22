package com.obric.oui.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f14828b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f14829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f14830b;
        private static Field c;
        private static boolean d;

        static {
            Field r0 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            f14829a = r0;     // Catch: ReflectiveOperationException -> L4
            r0.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class r1 = ZeusTransformUtils.forName("android.view.View$AttachInfo", "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L4
            Field r2 = r1.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            f14830b = r2;     // Catch: ReflectiveOperationException -> L4
            r2.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r3 = r1.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            c = r3;     // Catch: ReflectiveOperationException -> L4
            r3.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            d = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }

        public static e a(View r5) {
            if (d == true) goto L5;
        L17:
            return null;
        L5:
            if (r5.isAttachedToWindow() == false) goto L17;
            Object r1 = f14829a.get(r5.getRootView());     // Catch: IllegalAccessException -> L15
            if (r1 == null) goto L17;
            Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(f14830b.get(r1), Rect.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L15
            Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(c.get(r1), Rect.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L15
            if (r3 == null) goto L17;
            if (r0 == null) goto L17;
            e r2 = new b().b(com.obric.oui.view.b.a(r3)).a(com.obric.oui.view.b.a(r0)).a();     // Catch: IllegalAccessException -> L15
            r2.a(r2);     // Catch: IllegalAccessException -> L15
            r2.a(r5.getRootView());     // Catch: IllegalAccessException -> L15
            return r2;
        L15:
            e = move-exception;
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            goto L17
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f14831a;

        public b() {
            if (Build.VERSION.SDK_INT < 30) goto L7;
            c r0 = new f();
        L5:
            this.f14831a = r0;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 29) goto L10;
            r0 = new C0791e();
            goto L5
        L10:
            if (Build.VERSION.SDK_INT < 20) goto L12;
            r0 = new d();
            goto L5
        L12:
            r0 = new c();
            goto L5
        }

        @Deprecated
        public b a(com.obric.oui.view.b r2) {
            this.f14831a.a(r2);
            return this;
        }

        public e a() {
            return this.f14831a.b();
        }

        @Deprecated
        public b b(com.obric.oui.view.b r2) {
            this.f14831a.e(r2);
            return this;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.obric.oui.view.b[] f14832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f14833b;

        c() {
            this(new e((e) ZeusTransformUtils.preCheckCast(null, e.class, "com.obric.memorydata.plugin")));
        }

        c(e r1) {
            this.f14833b = r1;
        }

        public final void a() {
            com.obric.oui.view.b[] r0 = this.f14832a;
            if (r0 == null) goto L22;
            com.obric.oui.view.b r1 = r0[m.a(1)];
            com.obric.oui.view.b r2 = this.f14832a[m.a(2)];
            if (r1 == null) goto L8;
            if (r2 == null) goto L8;
            r1 = com.obric.oui.view.b.a(r1, r2);
        L9:
            a(r1);
        L12:
            com.obric.oui.view.b r3 = this.f14832a[m.a(16)];
            if (r3 == null) goto L15;
            b(r3);
        L15:
            com.obric.oui.view.b r4 = this.f14832a[m.a(32)];
            if (r4 == null) goto L18;
            c(r4);
        L18:
            com.obric.oui.view.b r5 = this.f14832a[m.a(64)];
            if (r5 == null) goto L23;
            d(r5);
            return;
        L23:
            return;
        L8:
            if (r1 != null) goto L9;
            if (r2 == null) goto L12;
            a(r2);
            goto L12
        }

        void a(com.obric.oui.view.b r1) {
        }

        e b() {
            a();
            return this.f14833b;
        }

        void b(com.obric.oui.view.b r1) {
        }

        void c(com.obric.oui.view.b r1) {
        }

        void d(com.obric.oui.view.b r1) {
        }

        void e(com.obric.oui.view.b r1) {
        }
    }

    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f14834b = null;
        private static boolean c = false;
        private static Constructor<WindowInsets> d = null;
        private static boolean e = false;
        private WindowInsets f;
        private com.obric.oui.view.b g;

        static {
        }

        d() {
            this.f = c();
        }

        private static WindowInsets c() {
            if (c == false) goto L31;
        L9:
            Field r0 = f14834b;
            if (r0 == null) goto L18;
            WindowInsets r1 = (WindowInsets) ZeusTransformUtils.preCheckCast(r0.get(null), WindowInsets.class, "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L15
            if (r1 == null) goto L18;
            return new WindowInsets(r1);
        L15:
            e = move-exception;
            Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e);
        L18:
            if (e == false) goto L35;
        L24:
            Constructor<WindowInsets> r2 = d;
            if (r2 != null) goto L33;
        L30:
            return null;
        L33:
            return (WindowInsets) ZeusTransformUtils.preCheckCast(r2.newInstance(new Object[]{new Rect()}), WindowInsets.class, "com.obric.memorydata.plugin");
        L28:
            e = move-exception;
            Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e);
            goto L30
        L35:
            d = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L21
        L23:
            e = true;
        L21:
            e = move-exception;
            Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e);
            goto L23
        L31:
            f14834b = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L6
        L8:
            c = true;
        L6:
            e = move-exception;
            Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
            goto L8
        }

        @Override // com.obric.oui.view.e.c
        void a(com.obric.oui.view.b r5) {
            WindowInsets r0 = this.f;
            if (r0 == null) goto L6;
            this.f = r0.replaceSystemWindowInsets(r5.f14819b, r5.c, r5.d, r5.e);
            return;
        }

        @Override // com.obric.oui.view.e.c
        e b() {
            a();
            e r0 = e.a(this.f);
            r0.a(this.f14832a);
            r0.a(this.g);
            return r0;
        }

        @Override // com.obric.oui.view.e.c
        void e(com.obric.oui.view.b r1) {
            this.g = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.view.e$e, reason: collision with other inner class name */
    private static class C0791e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowInsets.Builder f14835b;

        C0791e() {
            this.f14835b = new WindowInsets.Builder();
        }

        @Override // com.obric.oui.view.e.c
        void a(com.obric.oui.view.b r1) {
            this.f14835b.setSystemWindowInsets(r1.a());
        }

        @Override // com.obric.oui.view.e.c
        e b() {
            a();
            e r0 = e.a(this.f14835b.build());
            r0.a(this.f14832a);
            return r0;
        }

        @Override // com.obric.oui.view.e.c
        void b(com.obric.oui.view.b r1) {
            this.f14835b.setSystemGestureInsets(r1.a());
        }

        @Override // com.obric.oui.view.e.c
        void c(com.obric.oui.view.b r1) {
            this.f14835b.setMandatorySystemGestureInsets(r1.a());
        }

        @Override // com.obric.oui.view.e.c
        void d(com.obric.oui.view.b r1) {
            this.f14835b.setTappableElementInsets(r1.a());
        }

        @Override // com.obric.oui.view.e.c
        void e(com.obric.oui.view.b r1) {
            this.f14835b.setStableInsets(r1.a());
        }
    }

    private static class f extends C0791e {
        f() {
        }
    }

    private static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f14836a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e f14837b;

        static {
            f14836a = new b().a().d().b().a();
        }

        g(e r1) {
            this.f14837b = r1;
        }

        com.obric.oui.view.b a(int r1) {
            return com.obric.oui.view.b.f14818a;
        }

        void a(View r1) {
        }

        void a(com.obric.oui.view.b r1) {
        }

        void a(e r1) {
        }

        public void a(com.obric.oui.view.b[] r1) {
        }

        boolean a() {
            return false;
        }

        com.obric.oui.view.b b(int r1) {
            if ((r1 & 8) != 0) goto L7;
            return com.obric.oui.view.b.f14818a;
        L7:
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public void b(com.obric.oui.view.b r1) {
        }

        void b(e r1) {
        }

        boolean b() {
            return false;
        }

        e c() {
            return this.f14837b;
        }

        e d() {
            return this.f14837b;
        }

        com.obric.oui.view.a e() {
            return null;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
            if (a() != r6.a()) goto L20;
            if (b() != r6.b()) goto L20;
            if (ObjectsCompat.equals(g(), r6.g()) == false) goto L20;
            if (ObjectsCompat.equals(h(), r6.h()) == false) goto L20;
            if (ObjectsCompat.equals(e(), r6.e()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        e f() {
            return this.f14837b;
        }

        com.obric.oui.view.b g() {
            return com.obric.oui.view.b.f14818a;
        }

        com.obric.oui.view.b h() {
            return com.obric.oui.view.b.f14818a;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e()});
        }

        com.obric.oui.view.b i() {
            return g();
        }

        com.obric.oui.view.b j() {
            return g();
        }

        com.obric.oui.view.b k() {
            return g();
        }
    }

    private static class h extends g {
        private static boolean e = false;
        private static Method f;
        private static Class<?> g;
        private static Class<?> h;
        private static Field i;
        private static Field j;
        final WindowInsets c;
        com.obric.oui.view.b d;
        private com.obric.oui.view.b[] k;
        private com.obric.oui.view.b l;
        private e m;

        static {
        }

        h(e r1, WindowInsets r2) {
            super(r1);
            this.l = null;
            this.c = r2;
        }

        h(e r2, h r3) {
            this(r2, new WindowInsets(r3.c));
        }

        private com.obric.oui.view.b b(int r4, boolean r5) {
            com.obric.oui.view.b r0 = com.obric.oui.view.b.f14818a;
            int r1 = 1;
        L4:
            if (r1 > 256) goto L10;
            if ((r4 & r1) == 0) goto L9;
            r0 = com.obric.oui.view.b.a(r0, a(r1, r5));
        L9:
            r1 = r1 << 1;
            goto L4
        L10:
            return r0;
        }

        private com.obric.oui.view.b b(View r4) {
            if (Build.VERSION.SDK_INT >= 30) goto L27;
            if (e == true) goto L7;
            m();
        L7:
            Method r0 = f;
            if (r0 != null) goto L10;
        L25:
            return null;
        L10:
            if (h == null) goto L25;
            if (i == null) goto L25;
            Object r5 = r0.invoke(r4, new Object[0]);     // Catch: ReflectiveOperationException -> L23
            if (r5 != null) goto L19;
            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());     // Catch: ReflectiveOperationException -> L23
            return null;
        L19:
            Rect r6 = (Rect) ZeusTransformUtils.preCheckCast(i.get(j.get(r5)), Rect.class, "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L23
            if (r6 != null) goto L22;
            return null;
        L22:
            return com.obric.oui.view.b.a(r6);
        L23:
            e = move-exception;
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L25
        L27:
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private com.obric.oui.view.b l() {
            e r0 = this.m;
            if (r0 == null) goto L7;
            return r0.f();
        L7:
            return com.obric.oui.view.b.f14818a;
        }

        private static void m() {
            f = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: ReflectiveOperationException -> L5
            g = ZeusTransformUtils.forName("android.view.ViewRootImpl", "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L5
            Class<?> r0 = ZeusTransformUtils.forName("android.view.View$AttachInfo", "com.obric.memorydata.plugin");     // Catch: ReflectiveOperationException -> L5
            h = r0;     // Catch: ReflectiveOperationException -> L5
            i = r0.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L5
            j = g.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L5
            i.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
            j.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        L7:
            e = true;
            return;
        L5:
            e = move-exception;
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L7
        }

        @Override // com.obric.oui.view.e.g
        public com.obric.oui.view.b a(int r2) {
            return b(r2, false);
        }

        public com.obric.oui.view.b a(int r4, boolean r5) {
            if (r4 == 1) goto L63;
            com.obric.oui.view.b r2 = null;
            if (r4 != 2) goto L7;
            if (r5 == false) goto L55;
            com.obric.oui.view.b r6 = l();
            com.obric.oui.view.b r3 = h();
            return com.obric.oui.view.b.a(Math.max(r6.f14819b, r3.f14819b), 0, Math.max(r6.d, r3.d), Math.max(r6.e, r3.e));
        L55:
            com.obric.oui.view.b r7 = g();
            e r8 = this.m;
            if (r8 == null) goto L58;
            r2 = r8.f();
        L58:
            int r9 = r7.e;
            if (r2 == null) goto L62;
            r9 = Math.min(r9, r2.e);
        L62:
            return com.obric.oui.view.b.a(r7.f14819b, 0, r7.d, r9);
        L7:
            if (r4 != 8) goto L9;
            com.obric.oui.view.b[] r10 = this.k;
            if (r10 == null) goto L36;
            r2 = r10[m.a(8)];
        L36:
            if (r2 == null) goto L38;
            return r2;
        L38:
            com.obric.oui.view.b r11 = g();
            com.obric.oui.view.b r12 = l();
            if (r11.e > r12.e) goto L41;
            com.obric.oui.view.b r13 = this.d;
            if (r13 == null) goto L51;
            if (r13.equals(com.obric.oui.view.b.f14818a) == true) goto L51;
            if (this.d.e <= r12.e) goto L51;
            return com.obric.oui.view.b.a(0, 0, 0, this.d.e);
        L51:
            return com.obric.oui.view.b.f14818a;
        L41:
            return com.obric.oui.view.b.a(0, 0, 0, r11.e);
        L9:
            if (r4 == 16) goto L32;
            if (r4 == 32) goto L30;
            if (r4 == 64) goto L28;
            if (r4 != 128) goto L17;
            e r14 = this.m;
            if (r14 == null) goto L21;
            com.obric.oui.view.a r15 = r14.c();
        L22:
            if (r15 == null) goto L26;
            return com.obric.oui.view.b.a(r15.c(), r15.a(), r15.d(), r15.b());
        L26:
            return com.obric.oui.view.b.f14818a;
        L21:
            r15 = e();
            goto L22
        L17:
            return com.obric.oui.view.b.f14818a;
        L28:
            return k();
        L30:
            return j();
        L32:
            return i();
        L63:
            if (r5 == false) goto L67;
            return com.obric.oui.view.b.a(0, Math.max(l().c, g().c), 0, 0);
        L67:
            return com.obric.oui.view.b.a(0, g().c, 0, 0);
        }

        @Override // com.obric.oui.view.e.g
        void a(View r1) {
            com.obric.oui.view.b r2 = b(r1);
            if (r2 != null) goto L5;
            r2 = com.obric.oui.view.b.f14818a;
        L5:
            a(r2);
        }

        @Override // com.obric.oui.view.e.g
        void a(com.obric.oui.view.b r1) {
            this.d = r1;
        }

        @Override // com.obric.oui.view.e.g
        void a(e r1) {
            this.m = r1;
        }

        @Override // com.obric.oui.view.e.g
        public void a(com.obric.oui.view.b[] r1) {
            this.k = r1;
        }

        @Override // com.obric.oui.view.e.g
        boolean a() {
            return this.c.isRound();
        }

        @Override // com.obric.oui.view.e.g
        public com.obric.oui.view.b b(int r2) {
            return b(r2, true);
        }

        @Override // com.obric.oui.view.e.g
        void b(e r2) {
            r2.a(this.m);
            r2.b(this.d);
        }

        @Override // com.obric.oui.view.e.g
        public boolean equals(Object r3) {
            if (super.equals(r3) == true) goto L6;
            return false;
        L6:
            h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin");
            return Objects.equals(this.d, r4.d);
        }

        @Override // com.obric.oui.view.e.g
        final com.obric.oui.view.b g() {
            if (this.l != null) goto L6;
            this.l = com.obric.oui.view.b.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
        L6:
            return this.l;
        }
    }

    private static class i extends h {
        private com.obric.oui.view.b e;

        i(e r1, WindowInsets r2) {
            super(r1, r2);
            this.e = null;
        }

        i(e r1, i r2) {
            super(r1, r2);
            this.e = null;
            this.e = r2.e;
        }

        @Override // com.obric.oui.view.e.g
        public void b(com.obric.oui.view.b r1) {
            this.e = r1;
        }

        @Override // com.obric.oui.view.e.g
        boolean b() {
            return this.c.isConsumed();
        }

        @Override // com.obric.oui.view.e.g
        e c() {
            return e.a(this.c.consumeSystemWindowInsets());
        }

        @Override // com.obric.oui.view.e.g
        e d() {
            return e.a(this.c.consumeStableInsets());
        }

        @Override // com.obric.oui.view.e.g
        final com.obric.oui.view.b h() {
            if (this.e != null) goto L6;
            this.e = com.obric.oui.view.b.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
        L6:
            return this.e;
        }
    }

    private static class j extends i {
        j(e r1, WindowInsets r2) {
            super(r1, r2);
        }

        j(e r1, j r2) {
            super(r1, r2);
        }

        @Override // com.obric.oui.view.e.g
        com.obric.oui.view.a e() {
            return com.obric.oui.view.a.a(this.c.getDisplayCutout());
        }

        @Override // com.obric.oui.view.e.h, com.obric.oui.view.e.g
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
            return false;
        L8:
            j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
            if (Objects.equals(this.c, r6.c) == false) goto L14;
            if (Objects.equals(this.d, r6.d) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // com.obric.oui.view.e.g
        e f() {
            return e.a(this.c.consumeDisplayCutout());
        }

        @Override // com.obric.oui.view.e.g
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    private static class k extends j {
        private com.obric.oui.view.b e;
        private com.obric.oui.view.b f;
        private com.obric.oui.view.b g;

        k(e r1, WindowInsets r2) {
            super(r1, r2);
            this.e = null;
            this.f = null;
            this.g = null;
        }

        k(e r1, k r2) {
            super(r1, r2);
            this.e = null;
            this.f = null;
            this.g = null;
        }

        @Override // com.obric.oui.view.e.i, com.obric.oui.view.e.g
        public void b(com.obric.oui.view.b r1) {
        }

        @Override // com.obric.oui.view.e.g
        com.obric.oui.view.b i() {
            if (this.e != null) goto L6;
            this.e = com.obric.oui.view.b.a(this.c.getSystemGestureInsets());
        L6:
            return this.e;
        }

        @Override // com.obric.oui.view.e.g
        com.obric.oui.view.b j() {
            if (this.f != null) goto L6;
            this.f = com.obric.oui.view.b.a(this.c.getMandatorySystemGestureInsets());
        L6:
            return this.f;
        }

        @Override // com.obric.oui.view.e.g
        com.obric.oui.view.b k() {
            if (this.g != null) goto L6;
            this.g = com.obric.oui.view.b.a(this.c.getTappableElementInsets());
        L6:
            return this.g;
        }
    }

    private static class l extends k {
        static final e e = null;

        static {
            e = e.a(WindowInsets.CONSUMED);
        }

        l(e r1, WindowInsets r2) {
            super(r1, r2);
        }

        l(e r1, l r2) {
            super(r1, r2);
        }

        @Override // com.obric.oui.view.e.h, com.obric.oui.view.e.g
        public com.obric.oui.view.b a(int r1) {
            return com.obric.oui.view.b.a(this.c.getInsets(n.a(r1)));
        }

        @Override // com.obric.oui.view.e.h, com.obric.oui.view.e.g
        final void a(View r1) {
        }

        @Override // com.obric.oui.view.e.h, com.obric.oui.view.e.g
        public com.obric.oui.view.b b(int r1) {
            return com.obric.oui.view.b.a(this.c.getInsetsIgnoringVisibility(n.a(r1)));
        }
    }

    public static final class m {
        public static int a() {
            return 8;
        }

        static int a(int r3) {
            if (r3 != 1) goto L5;
            return 0;
        L5:
            if (r3 != 2) goto L7;
            return 1;
        L7:
            if (r3 != 4) goto L9;
            return 2;
        L9:
            if (r3 != 8) goto L11;
            return 3;
        L11:
            if (r3 != 16) goto L13;
            return 4;
        L13:
            if (r3 != 32) goto L15;
            return 5;
        L15:
            if (r3 != 64) goto L17;
            return 6;
        L17:
            if (r3 != 128) goto L19;
            return 7;
        L19:
            if (r3 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + r3);
        }

        public static int b() {
            return 7;
        }
    }

    private static final class n {
        static int a(int r4) {
            int r1 = 0;
            int r2 = 1;
        L4:
            if (r2 > 256) goto L33;
            if ((r4 & r2) == 0) goto L32;
            if (r2 != 1) goto L9;
            int r3 = WindowInsets.Type.statusBars();
        L31:
            r1 = r1 | r3;
            goto L32
        L9:
            if (r2 != 2) goto L11;
            r3 = WindowInsets.Type.navigationBars();
            goto L31
        L11:
            if (r2 != 4) goto L13;
            r3 = WindowInsets.Type.captionBar();
            goto L31
        L13:
            if (r2 != 8) goto L15;
            r3 = WindowInsets.Type.ime();
            goto L31
        L15:
            if (r2 != 16) goto L17;
            r3 = WindowInsets.Type.systemGestures();
            goto L31
        L17:
            if (r2 != 32) goto L19;
            r3 = WindowInsets.Type.mandatorySystemGestures();
            goto L31
        L19:
            if (r2 != 64) goto L21;
            r3 = WindowInsets.Type.tappableElement();
            goto L31
        L21:
            if (r2 != 128) goto L32;
            r3 = WindowInsets.Type.displayCutout();
        L32:
            r2 = r2 << 1;
            goto L4
        L33:
            return r1;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        e r0 = l.e;
    L6:
        f14827a = r0;
        return;
    L5:
        r0 = g.f14836a;
        goto L6
    }

    private e(WindowInsets r3) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        g r0 = new l(this, r3);
    L5:
        this.f14828b = r0;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        r0 = new k(this, r3);
        goto L5
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L13;
        r0 = new j(this, r3);
        goto L5
    L13:
        if (Build.VERSION.SDK_INT < 21) goto L16;
        r0 = new i(this, r3);
        goto L5
    L16:
        if (Build.VERSION.SDK_INT < 20) goto L18;
        r0 = new h(this, r3);
        goto L5
    L18:
        this.f14828b = new g(this);
    }

    public e(e r4) {
        if (r4 == null) goto L32;
        g r5 = r4.f14828b;
        if (Build.VERSION.SDK_INT < 30) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, l.class) == false) goto L11;
        g r0 = new l(this, (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.memorydata.plugin"));
    L9:
        this.f14828b = r0;
        r5.b(this);
        return;
    L11:
        if (Build.VERSION.SDK_INT < 29) goto L16;
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L16;
        r0 = new k(this, (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin"));
    L16:
        if (Build.VERSION.SDK_INT < 28) goto L21;
        if (ZeusTransformUtils.instanceOf(r5, j.class) == false) goto L21;
        r0 = new j(this, (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin"));
    L21:
        if (Build.VERSION.SDK_INT < 21) goto L26;
        if (ZeusTransformUtils.instanceOf(r5, i.class) == false) goto L26;
        r0 = new i(this, (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin"));
    L26:
        if (Build.VERSION.SDK_INT >= 20) goto L28;
    L30:
        r0 = new g(this);
        goto L9
    L28:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == false) goto L30;
        r0 = new h(this, (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin"));
        goto L9
    L32:
        this.f14828b = new g(this);
    }

    public static e a(WindowInsets r1) {
        return a(r1, null);
    }

    public static e a(WindowInsets r3, View r4) {
        e r0 = new e((WindowInsets) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3), WindowInsets.class, "com.obric.memorydata.plugin"));
        if (r4 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r4.isAttachedToWindow() == false) goto L7;
        r0.a(com.obric.oui.view.d.d(r4));
        r0.a(r4.getRootView());
        goto L7
    }

    public com.obric.oui.view.b a(int r1) {
        return this.f14828b.a(r1);
    }

    @Deprecated
    public e a() {
        return this.f14828b.c();
    }

    void a(View r1) {
        this.f14828b.a(r1);
    }

    void a(com.obric.oui.view.b r1) {
        this.f14828b.b(r1);
    }

    void a(e r1) {
        this.f14828b.a(r1);
    }

    void a(com.obric.oui.view.b[] r1) {
        this.f14828b.a(r1);
    }

    public com.obric.oui.view.b b(int r1) {
        return this.f14828b.b(r1);
    }

    @Deprecated
    public e b() {
        return this.f14828b.d();
    }

    void b(com.obric.oui.view.b r1) {
        this.f14828b.a(r1);
    }

    public com.obric.oui.view.a c() {
        return this.f14828b.e();
    }

    @Deprecated
    public e d() {
        return this.f14828b.f();
    }

    @Deprecated
    public com.obric.oui.view.b e() {
        return this.f14828b.g();
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L10;
        return false;
    L10:
        e r4 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin");
        return ObjectsCompat.equals(this.f14828b, r4.f14828b);
    }

    @Deprecated
    public com.obric.oui.view.b f() {
        return this.f14828b.h();
    }

    public WindowInsets g() {
        if (ZeusTransformUtils.instanceOf(this.f14828b, h.class) == true) goto L7;
        return null;
    L7:
        return ((h) ZeusTransformUtils.preCheckCast(this.f14828b, h.class, "com.obric.memorydata.plugin")).c;
    }

    public int hashCode() {
        g r0 = this.f14828b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }
}
