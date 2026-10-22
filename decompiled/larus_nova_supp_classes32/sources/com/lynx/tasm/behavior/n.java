package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public static final WeakHashMap<View, g> n = null;
    public final LynxContext a;
    public c b;
    public final float c;
    public boolean d;
    public q e;
    public int f;
    public int g;
    public final Rect h;
    public int i;
    public int j;
    public final WeakHashMap<Object, ViewTreeObserver.OnGlobalLayoutListener> k;
    public final WeakHashMap<Object, f> l;
    public final e m;

    public class a implements Runnable {
        public final /* synthetic */ n a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(n r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ n a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e.d().requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(n r1) {
            this.a = r1;
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ n a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            LLog.d("Lynx", "onGlobalLayout invoked.");
            this.a.b();
        }

        public c(n r1) {
            this.a = r1;
        }
    }

    public static class d {
        public final WeakReference<Object> a;
        public final WeakReference<View> b;
        public final WeakReference<View> c;
        public final boolean d;
        public final float e;

        public final boolean a() {
            if (this.a.get() != null) goto L5;
        L9:
            return false;
        L5:
            if (this.b.get() == null) goto L9;
            if (this.c.get() == null) goto L9;
            return true;
        }

        public final boolean b(Object r2) {
            if (r2 != null) goto L4;
        L6:
            return false;
        L4:
            if (this.a.get() != r2) goto L6;
            return true;
        }

        public d(Object r2, View r3, LynxView r4, boolean r5, float r6) {
            this.a = new WeakReference(r2);
            this.b = new WeakReference(r3);
            this.c = new WeakReference(r4);
            this.d = r5;
            this.e = r6;
        }
    }

    public class e {
        public final WeakHashMap<View, d> a;
        public WeakReference<d> b;
        public WeakReference<Object> c;
        public WeakReference<View> d;
        public View e;
        public View f;
        public g g;
        public p h;
        public int i;
        public float j;
        public boolean k;
        public int l;
        public float m;
        public int n;
        public int o;
        public WeakReference<d> p;
        public Runnable q;
        public View r;
        public final /* synthetic */ n s;

        public class a implements Runnable {
            public final /* synthetic */ e a;

            @Override // java.lang.Runnable
            public final void run() {
                e r0 = this.a;     // Catch: Throwable -> L4
                r0.q = null;     // Catch: Throwable -> L4
                r0.r = null;     // Catch: Throwable -> L4
                r0.n();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r1) {
                this.a = r1;
            }
        }

        public final void e() {
            d r0 = this.p.get();
            if (r0 != null) goto L5;
        L7:
            int r2 = this.n;
            if (r2 != 1) goto L13;
            if (r0 == null) goto L11;
            q(r0);
        L11:
            this.i = this.o;
            v(false);
            return;
        L13:
            if (r2 != 2) goto L20;
            this.i = 0;
            if (r0 == null) goto L17;
            q(r0);
            v(false);
            return;
        L17:
            q(null);
            l(false);
            return;
        L20:
            return;
        L5:
            if (r0.a() == true) goto L7;
            r0 = null;
            goto L7
        }

        public final void g() {
            Runnable r0 = this.q;
            if (r0 == null) goto L7;
            View r1 = this.r;
            if (r1 == null) goto L7;
            r1.removeCallbacks(r0);
        L7:
            this.q = null;
            this.r = null;
        }

        public final d j() {
            d r0 = this.b.get();
            if (r0 != null) goto L5;
        L7:
            return null;
        L5:
            if (r0.a() == false) goto L7;
            return r0;
        }

        public final View m() {
            View r0 = this.e;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Activity r1 = com.lynx.tasm.utils.a.getActivity(this.s.a);
            if (r1 != null) goto L8;
            return null;
        L8:
            if (r1.getWindow() != null) goto L11;
            return null;
        L11:
            return a(r1.getWindow());
        }

        public final void n() {
            if (this.n == 0) goto L5;
            boolean r2 = false;
            if (this.k == true) goto L20;
            e();
            this.n = 0;
            this.o = 0;
            this.p = new WeakReference(null);
            return;
        L20:
            if (Build.VERSION.SDK_INT < 30) goto L28;
            View r0 = this.f;
            if (r0 == null) goto L28;
            WindowInsets r1 = r0.getRootWindowInsets();
            if (r1 == null) goto L28;
            d(r1);
            r2 = true;
        L28:
            if (r2 == true) goto L30;
            e();
        L30:
            h();
            return;
        L5:
            if (this.k == true) goto L7;
            return;
        L7:
            if (Build.VERSION.SDK_INT < 30) goto L15;
            View r3 = this.f;
            if (r3 == null) goto L15;
            WindowInsets r4 = r3.getRootWindowInsets();
            if (r4 == null) goto L15;
            d(r4);
        L15:
            h();
        }

        public final void t() {
            View r0 = this.e;
            if (r0 != null) goto L5;
        L14:
            this.e = null;
            this.h = null;
            return;
        L5:
            if (this.h == null) goto L14;
            ViewTreeObserver r1 = r0.getViewTreeObserver();     // Catch: Exception -> L12
            if (r1 == null) goto L14;
            if (r1.isAlive() == false) goto L14;
            r1.removeOnGlobalFocusChangeListener(this.h);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            LLog.w("Lynx", "stop KeyboardAvoidingContext failed for " + e.toString());
            goto L14
        }

        public final void u() {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 30) goto L12;
            g r3 = this.g;
            if (r3 == null) goto L12;
            r3.b.remove(this);
            if (r3.b.isEmpty() == false) goto L12;
            if (r0 < 30) goto L11;
            r3.a.setWindowInsetsAnimationCallback(null);
        L11:
            n.n.remove(r3.a);
        L12:
            this.f = null;
            this.g = null;
            h();
        }

        public final void h() {
            g();
            this.n = 0;
            this.o = 0;
            this.p = new WeakReference(null);
            this.k = false;
            this.l = 0;
            this.m = 0.0f;
        }

        public final void s() {
            g();
            this.n = 0;
            this.o = 0;
            this.p = new WeakReference(null);
            if (this.k == true) goto L17;
            boolean r4 = true;
            if (Build.VERSION.SDK_INT >= 30) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L12;
        L14:
            boolean r2 = false;
        L15:
            if (r2 == true) goto L17;
        L18:
            l(r4);
            t();
            u();
            this.a.clear();
            this.b = new WeakReference(null);
            this.c = new WeakReference(null);
            this.d = new WeakReference(null);
            this.i = 0;
            return;
        L12:
            if (this.n == 0) goto L14;
            r2 = true;
            goto L15
        L7:
            if (this.g == null) goto L9;
            r1 = true;
        L17:
            r4 = false;
            goto L18
        }

        public e(n r3) {
            this.s = r3;
            this.a = new WeakHashMap();
            this.b = new WeakReference(null);
            this.c = new WeakReference(null);
            this.d = new WeakReference(null);
            this.i = 0;
            this.j = 0.0f;
            this.k = false;
            this.l = 0;
            this.m = 0.0f;
            this.n = 0;
            this.o = 0;
            this.p = new WeakReference(null);
        }

        public static View a(Window r3) {
            View r4 = r3.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r0 = ThreadMethodProxy.currentThread();
            if (r0 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r0, "getDecorView");
        L7:
            return r4;
        }

        public static long k(WindowInsetsAnimation r5) {
            if (Build.VERSION.SDK_INT < 30) goto L8;
            if (r5 == null) goto L8;
            if (r5.getDurationMillis() < 0) goto L8;
            long r0 = r5.getDurationMillis();
        L10:
            return r0 + 80;
        L8:
            r0 = 285;
            goto L10
        }

        public final void b(d r4) {
            if (r4.a() == false) goto L26;
            q(r4);
            r(r4.a.get());
            boolean r1 = true;
            if (this.n != 1) goto L9;
            this.p = new WeakReference(r4);
        L9:
            if (this.k == false) goto L11;
        L23:
            r1 = false;
        L24:
            v(r1);
            return;
        L11:
            if (Build.VERSION.SDK_INT >= 30) goto L13;
        L15:
            boolean r5 = false;
        L16:
            if (r5 == true) goto L18;
        L20:
            boolean r6 = false;
        L21:
            if (r6 == true) goto L23;
        L18:
            if (this.n == 0) goto L20;
            r6 = true;
            goto L21
        L13:
            if (this.g == null) goto L15;
            r5 = true;
            goto L16
        }

        public final boolean d(WindowInsets r7) {
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 30) goto L26;
            if (r7 == null) goto L26;
            if (r0 < 30) goto L8;
            int r1 = Math.max(0, r7.getInsets(WindowInsets.Type.ime()).bottom - r7.getInsets(WindowInsets.Type.navigationBars()).bottom);
        L9:
            d r2 = j();
            if (r2 != null) goto L12;
        L16:
            View r8 = this.d.get();
            if (r8 != null) goto L19;
            this.i = r1;
        L25:
            return true;
        L19:
            int r3 = this.l;
            if (r3 <= 0) goto L23;
            if (r1 <= 0) goto L23;
            float r4 = (this.m * r1) / r3;
        L24:
            this.i = r1;
            c(r8, r4, false);
        L23:
            r4 = 0.0f;
            goto L24
        L12:
            if (r2.a() == false) goto L16;
            this.i = r1;
            c(r2.c.get(), f(r2, r1, r7), false);
            return true;
        L8:
            r1 = 0;
        L26:
            return false;
        }

        public final d i(View r4) {
        L3:
            if (r4 == null) goto L13;
            d r1 = this.a.get(r4);
            if (r1 != null) goto L7;
        L9:
            Object r5 = r4.getParent();
            if ((r5 instanceof View) == true) goto L11;
            r4 = null;
            goto L3
        L11:
            r4 = (View) r5;
            goto L3
        L7:
            if (r1.a() == false) goto L9;
            return r1;
        L13:
            return null;
        }

        public final void l(boolean r4) {
            d r0 = j();
            if (r0 == null) goto L5;
            View r1 = r0.c.get();
        L6:
            if (r1 != null) goto L9;
            r1 = this.d.get();
        L9:
            if (r1 == null) goto L11;
        L12:
            c(r1, 0.0f, r4);
            return;
        L11:
            if (this.j != 0.0f) goto L12;
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void p(long r3) {
            g();
            if (this.n == 0) goto L5;
        L7:
            View r0 = this.f;
            if (r0 != null) goto L10;
            r0 = m();
        L10:
            if (r0 != null) goto L13;
            n();
            return;
        L13:
            this.r = r0;
            a r1 = new a(this);
            this.q = r1;
            r0.postDelayed(r1, r3);
            return;
        L5:
            if (this.k == true) goto L7;
        }

        public final void q(d r2) {
            this.b = new WeakReference(r2);
        }

        public final void r(Object r2) {
            if (r2 == null) goto L5;
            this.c = new WeakReference(r2);
            return;
        }

        public final void v(boolean r5) {
            d r0 = j();
            if (r0 != null) goto L5;
        L9:
            q(null);
            l(r5);
            return;
        L5:
            if (r0.a() == false) goto L9;
            c(r0.c.get(), f(r0, this.i, null), r5);
        }

        public final void c(View r3, float r4, boolean r5) {
            float r6 = Math.max(0.0f, r4);
            if (r3 != null) goto L6;
            this.j = r6;
            return;
        L6:
            this.d = new WeakReference(r3);
            this.j = r6;
            r3.animate().cancel();
            if (r5 == false) goto L9;
            r3.animate().translationY(-r6).setDuration(285).setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f)).start();
            return;
        L9:
            r3.setTranslationY(-r6);
        }

        public final float f(d r20, int r21, WindowInsets r22) {
            if (r20.d == true) goto L5;
            return 0.0f;
        L5:
            View r3 = r20.b.get();
            View r5 = r20.c.get();
            Activity r6 = com.lynx.tasm.utils.a.getActivity(this.s.a);
            if (r3 == null) goto L83;
            if (r5 == null) goto L86;
            if (r6 == null) goto L87;
            View r7 = a(r6.getWindow());
            if (r7 != null) goto L13;
            return 0.0f;
        L13:
            if (r7.getHeight() <= 0) goto L85;
            int r8 = Build.VERSION.SDK_INT;
            if (r8 >= 24) goto L18;
        L20:
            boolean r9 = false;
        L21:
            View r10 = r20.b.get();
            View r12 = r20.c.get();
            if (r10 == null) goto L68;
            if (r12 == null) goto L68;
            if (r7.getHeight() <= 0) goto L68;
            if (r7.getHeight() > 0) goto L30;
            View r17 = r3;
            View r16 = r5;
        L64:
            int r15 = -1;
        L65:
            if (r15 < 0) goto L69;
            int[] r4 = new int[2];
            int[] r11 = new int[2];
            r10.getLocationOnScreen(r4);
            r7.getLocationOnScreen(r11);
            float r0 = ((((r4[1] - r11[1]) + r10.getHeight()) - r12.getTranslationY()) - r15) + r20.e;
            float r13 = 0.0f;
            float r1 = Math.max(0.0f, r0);
        L71:
            if (r1 < r13) goto L73;
            return r1;
        L73:
            if (r21 > 0) goto L75;
            return r13;
        L75:
            q r14 = this.s.e;
            if (r14 == null) goto L78;
            int r18 = r14.e();
            int r19 = 2;
            char r23 = 1;
        L79:
            int[] r24 = new int[r19];
            View r25 = r17;
            r25.getLocationOnScreen(r24);
            return Math.max(0.0f, (r21 - (r18 - ((r24[r23] + r25.getHeight()) - r16.getTranslationY()))) + r20.e);
        L78:
            r19 = 2;
            int[] r26 = new int[2];
            r7.getLocationOnScreen(r26);
            r23 = 1;
            r18 = r26[1] + r7.getHeight();
        L69:
            r13 = 0.0f;
            r1 = -1.0f;
            goto L71
        L30:
            int r110 = r7.getHeight();
            int[] r111 = new int[2];
            r7.getLocationOnScreen(r111);
            if (r8 < 30) goto L45;
            if (r22 != null) goto L34;
            WindowInsets r27 = r7.getRootWindowInsets();
        L35:
            if (r27 == null) goto L45;
            int r28 = r27.getInsets(WindowInsets.Type.ime()).bottom;
            if (r28 <= 0) goto L39;
        L42:
            boolean r29 = true;
        L43:
            if (r29 == false) goto L46;
            int r30 = Math.max(0, Math.min(r110 - r28, r110));
        L47:
            Rect r112 = new Rect();
            r7.getWindowVisibleDisplayFrame(r112);
            r16 = r5;
            int r113 = r111[0];
            r17 = r3;
            if (r112.intersect(new Rect(r113, r111[1], r7.getWidth() + r113, r111[1] + r110)) == false) goto L56;
            int r2 = r112.bottom - r111[1];
            int r114 = r110 - r2;
            if (r114 <= 0) goto L56;
            if (r29 == true) goto L57;
            if (r21 <= 0) goto L56;
            if (r114 < (r21 * 0.5f)) goto L56;
        L57:
            if (r9 == false) goto L60;
            if (r2 < 0) goto L60;
        L63:
            r15 = r2;
        L60:
            if (r30 < 0) goto L62;
            r15 = r30;
            goto L65
        L62:
            if (r2 < 0) goto L64;
        L56:
            r2 = -1;
        L46:
            r30 = -1;
            goto L47
        L39:
            if (r27.isVisible(WindowInsets.Type.ime()) == true) goto L42;
            r29 = false;
            goto L43
        L34:
            r27 = r22;
        L45:
            r29 = false;
        L68:
            r17 = r3;
            r16 = r5;
            goto L69
        L18:
            if (r6.isInMultiWindowMode() == false) goto L20;
            r9 = true;
            goto L21
        L85:
            return 0.0f;
        L87:
            return 0.0f;
        L86:
            return 0.0f;
        L83:
            return 0.0f;
        }

        public final d o(Object r8, View r9, LynxView r10, boolean r11, float r12) {
            if (r8 == null) goto L20;
            if (r9 == null) goto L22;
            d r6 = new d(r8, r9, r10, r11, r12);
            this.a.put(r9, r6);
            if (Build.VERSION.SDK_INT < 30) goto L19;
            View r13 = m();
            if (r13 == null) goto L19;
            if (this.f == r13) goto L13;
        L15:
            u();
            this.f = r13;
            WeakHashMap<View, g> r14 = n.n;
            g r15 = r14.get(r13);
            if (r15 != null) goto L18;
            r15 = new g(r13);
            r14.put(r13, r15);
        L18:
            r15.b.put(this, Boolean.TRUE);
            this.g = r15;
            goto L19
        L13:
            if (this.g == null) goto L15;
        L19:
            return r6;
        L22:
            return null;
        L20:
            return null;
        }
    }

    public interface f {
        void f();

        void g(int r1);
    }

    public static class g {
        public final View a;
        public final WeakHashMap<e, Boolean> b;

        public class a extends WindowInsetsAnimation.Callback {
            public final /* synthetic */ g a;

            public a(g r1) {
                this.a = r1;
                super(1);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onEnd(WindowInsetsAnimation r4) {
                if (g.b(r4) == false) goto L13;
                WindowInsets r5 = this.a.a.getRootWindowInsets();
                Iterator r0 = g.a(this.a).iterator();
            L6:
                if (r0.hasNext() == false) goto L18;
                e r1 = (e) r0.next();
                if (r1.d(r5) == true) goto L12;
                if (r1.n == 0) goto L12;
                r1.e();
            L12:
                r1.h();
                goto L6
            L18:
                return;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final void onPrepare(WindowInsetsAnimation r5) {
                if (g.b(r5) == false) goto L11;
                Iterator r0 = g.a(this.a).iterator();
            L6:
                if (r0.hasNext() == false) goto L15;
                e r1 = (e) r0.next();
                if (r1.k == true) goto L10;
                r1.l = r1.i;
                r1.m = r1.j;
            L10:
                r1.k = true;
                r1.p(e.k(r5));
                goto L6
            L15:
                return;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsets onProgress(WindowInsets r3, List<WindowInsetsAnimation> r4) {
                if (Build.VERSION.SDK_INT < 30) goto L12;
                if (r4 == null) goto L12;
                Iterator<WindowInsetsAnimation> r5 = r4.iterator();
            L8:
                if (r5.hasNext() == false) goto L12;
                if (g.b(r5.next()) == false) goto L8;
                boolean r6 = true;
            L13:
                if (r6 == false) goto L18;
                Iterator r7 = g.a(this.a).iterator();
            L16:
                if (r7.hasNext() == false) goto L18;
                ((e) r7.next()).d(r3);
            L18:
                return r3;
            L12:
                r6 = false;
                goto L13
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation r5, WindowInsetsAnimation.Bounds r6) {
                if (g.b(r5) == false) goto L11;
                Iterator r0 = g.a(this.a).iterator();
            L6:
                if (r0.hasNext() == false) goto L11;
                e r1 = (e) r0.next();
                if (r1.k == true) goto L10;
                r1.l = r1.i;
                r1.m = r1.j;
            L10:
                r1.k = true;
                r1.p(e.k(r5));
            L11:
                return r6;
            }
        }

        public g(View r4) {
            this.b = new WeakHashMap();
            a r0 = new a(this);
            this.a = r4;
            if (Build.VERSION.SDK_INT < 30) goto L6;
            r4.setWindowInsetsAnimationCallback(r0);
            return;
        }

        public static ArrayList a(g r1) {
            r1.getClass();
            return new ArrayList(r1.b.keySet());
        }

        public static boolean b(WindowInsetsAnimation r2) {
            if (Build.VERSION.SDK_INT < 30) goto L8;
            if (r2 == null) goto L8;
            if ((r2.getTypeMask() & WindowInsets.Type.ime()) == 0) goto L8;
            return true;
        L8:
            return false;
        }
    }

    public final synchronized void d() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.d == false) goto L9;
        LLog.d("Lynx", "KeyboardEvent already started");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L9:
        if (UIThreadUtils.isOnUiThread() == true) goto L11;
        UIThreadUtils.runOnUiThread(new a(this));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L11:
        e();     // Catch: Throwable -> L14
        goto L12
    }

    static {
        n = new WeakHashMap();
    }

    public final void b() {
        Activity r3 = com.lynx.tasm.utils.a.getActivity(this.a);     // Catch: Exception -> L47
        if (r3 != null) goto L7;
        LLog.e("Lynx", "KeyboardEvent's context must be Activity.");     // Catch: Exception -> L47
        return;
    L7:
        LynxContext r4 = this.a;     // Catch: Exception -> L47
        View r5 = a(r3.getWindow());     // Catch: Exception -> L47
        boolean r6 = r4.useRelativeKeyboardHeightApi();     // Catch: Exception -> L47
        if (r4.getUIBody() != null) goto L10;
        return;
    L10:
        WeakReference r7 = new WeakReference(r4.getUIBody().getBodyView());     // Catch: Exception -> L47
        this.e.d().getWindowVisibleDisplayFrame(this.h);     // Catch: Exception -> L47
        int r8 = this.e.d().getHeight() + this.h.top;     // Catch: Exception -> L47
        int r9 = this.e.d().getHeight();     // Catch: Exception -> L47
        if (this.g != 0) goto L13;
        this.g = r5.getHeight();     // Catch: Exception -> L47
    L13:
        this.f = this.e.e() - this.h.top;     // Catch: Exception -> L47
        int r10 = r3.getWindow().getWindowManager().getDefaultDisplay().getRotation();     // Catch: Exception -> L47
        int r11 = this.g;     // Catch: Exception -> L47
        int r12 = this.f;     // Catch: Exception -> L47
        double r13 = ((double) r9) / ((double) r12);     // Catch: Exception -> L47
        if (r10 == 0) goto L17;
        if (r10 == 2) goto L17;
    L20:
        int r15 = 0;
        if (r13 >= 0.9d) goto L23;
        boolean r14 = true;
    L24:
        UIBody.UIBodyView r16 = (UIBody.UIBodyView) r7.get();     // Catch: Exception -> L47
        if (r14 == false) goto L27;
        int r17 = (int) ((r11 - r9) / this.c);     // Catch: Exception -> L47
    L28:
        if (r6 == false) goto L31;
        if (r16 == null) goto L31;
        int[] r18 = new int[2];     // Catch: Exception -> L47
        r16.getLocationOnScreen(r18);     // Catch: Exception -> L47
        float r19 = (r18[1] + r16.getHeight()) - r8;     // Catch: Exception -> L47
        float r20 = this.c;     // Catch: Exception -> L47
    L33:
        r15 = (int) (r19 / r20);     // Catch: Exception -> L47
    L34:
        LLog.d("Lynx", "KeyboardEvent visible = " + r14 + ", height = " + r17 + ", compatHeight = " + r15);     // Catch: Exception -> L47
        if (r17 != this.i) goto L39;
        if (r6 == true) goto L38;
    L40:
        Iterator<Map.Entry<Object, ViewTreeObserver.OnGlobalLayoutListener>> r0 = this.k.entrySet().iterator();     // Catch: Exception -> L47
    L42:
        if (r0.hasNext() == false) goto L56;
        Map.Entry<Object, ViewTreeObserver.OnGlobalLayoutListener> r21 = r0.next();     // Catch: Exception -> L47
        if (r21.getKey() == null) goto L42;
        r21.getValue().onGlobalLayout();     // Catch: Exception -> L47
        goto L42
    L56:
        return;
    L38:
        if (r15 == this.j) goto L40;
    L39:
        c(r14, r15);     // Catch: Exception -> L47
        this.i = r17;     // Catch: Exception -> L47
        this.j = r15;     // Catch: Exception -> L47
    L31:
        if (r14 == false) goto L34;
        r19 = r12 - r9;     // Catch: Exception -> L47
        r20 = this.c;     // Catch: Exception -> L47
        goto L33
    L27:
        r17 = 0;
        goto L28
    L23:
        r14 = false;
    L17:
        if (r13 >= 0.4d) goto L20;
        UIThreadUtils.runOnUiThread(new b(this));     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        LLog.e("Lynx", e.getMessage());
    }

    public final void e() {
        LLog.d("Lynx", "KeyboardEvent starting");
        Activity r1 = com.lynx.tasm.utils.a.getActivity(this.a);
        if (r1 != null) goto L7;
        LLog.e("Lynx", "KeyboardEvent's context must be Activity");
        return;
    L7:
        if (this.e != null) goto L9;
        this.e = new q(r1);
    L9:
        e r0 = this.m;
        View r2 = a(r1.getWindow());
        if (r2 != null) goto L13;
        r0.getClass();
    L18:
        c r3 = new c(this);
        this.b = r3;
        q.a(this.e.getWindow()).getViewTreeObserver().addOnGlobalLayoutListener(r3);
        this.e.f();
        this.d = true;
        return;
    L13:
        if (r0.e == r2) goto L15;
    L17:
        r0.t();
        r0.e = r2;
        r0.h = new p(r0);
        r2.getViewTreeObserver().addOnGlobalFocusChangeListener(r0.h);
        goto L18
    L15:
        if (r0.h == null) goto L17;
        goto L17
    }

    public final void f() {
        LLog.d("Lynx", "KeyboardEvent stopping");
        c r1 = this.b;     // Catch: Exception -> L17
        if (r1 == null) goto L15;
        q r2 = this.e;     // Catch: Exception -> L17
        if (r2 == null) goto L15;
        q.a(r2.getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(r1);     // Catch: Exception -> L17
        q r3 = this.e;     // Catch: Exception -> L17
        String r4 = q.a;     // Catch: Exception -> L17
        if (r3.isShowing() == false) goto L15;
        q.b(r3);     // Catch: RuntimeException -> L11 WindowManager.BadTokenException -> L13 Exception -> L17
    L13:
        e = move-exception;
        LLog.w(r4, e.toString());     // Catch: Exception -> L17
    L11:
        e = move-exception;
        LLog.w(r4, e.toString());     // Catch: Exception -> L17
    L15:
        this.m.s();     // Catch: Exception -> L17
    L19:
        this.d = false;
        return;
    L17:
        e = move-exception;
        LLog.w("Lynx", "stop KeyboardEvent failed for " + e.toString());
        goto L19
    }

    public n(LynxContext r3) {
        this.b = null;
        this.d = false;
        this.f = 0;
        this.g = 0;
        this.i = 0;
        this.j = 0;
        this.k = new WeakHashMap();
        this.l = new WeakHashMap();
        this.m = new e(this);
        LLog.d("Lynx", "KeyboardEvent initialized.");
        this.a = r3;
        this.c = r3.getScreenMetrics().density;
        this.h = new Rect();
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void c(boolean r5, int r6) {
        if (this.a.getEventEmitter() == null) goto L9;
        JavaOnlyArray r0 = new JavaOnlyArray();
        if (r5 == false) goto L7;
        String r1 = "on";
    L8:
        r0.pushString(r1);
        r0.pushInt(r6);
        r0.pushInt(r6);
        this.a.sendGlobalEvent("keyboardstatuschanged", r0);
        goto L9
    L7:
        r1 = "off";
    L9:
        Iterator<Map.Entry<Object, f>> r2 = this.l.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        f r3 = r2.next().getValue();
        if (r5 == true) goto L14;
        r3.f();
        goto L11
    L14:
        r3.g((int) (r6 * this.c));
        goto L11
    }
}
