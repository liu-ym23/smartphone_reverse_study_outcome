package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class e0 {
    public WeakReference<UIBody> a;
    public b b;
    public c c;
    public d d;
    public ViewTreeObserver e;
    public boolean f;
    public long g;
    public long h;
    public Handler i;
    public e j;
    public Handler k;
    public f l;
    public RectF m;
    public long n;
    public boolean o;
    public final int[] p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final int[] t;
    public final String u;

    public class a implements Runnable {
        public final /* synthetic */ e0 a;

        public final void a() {
            TraceEvent.beginSection("ObserverManager.ObserverHandler");
            this.a.i();     // Catch: Throwable -> L5
        L7:
            TraceEvent.endSection("ObserverManager.ObserverHandler");
            return;
        L5:
            th = move-exception;
            LLog.e(this.a.u, "observerManager.intersectionObserverHandler failed: " + th.toString());
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(e0 r1) {
            this.a = r1;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ e0 a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.k();
        }

        public b(e0 r1) {
            this.a = r1;
        }
    }

    public class c implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ e0 a;

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.a.k();
        }

        public c(e0 r1) {
            this.a = r1;
        }
    }

    public class d implements ViewTreeObserver.OnDrawListener {
        public final /* synthetic */ e0 a;

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            this.a.k();
        }

        public d(e0 r1) {
            this.a = r1;
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ e0 a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(e0 r1) {
            this.a = r1;
        }
    }

    public static class f implements Runnable {
        public final WeakReference<e0> a;

        public final void a() {
            e0 r0 = this.a.get();
            if (r0 == null) goto L25;
            long r1 = r0.n;
            if (r1 == 0) goto L12;
            Handler r3 = r0.k;
            if (r3 == null) goto L12;
            f r4 = r0.l;
            if (r4 == null) goto L12;
            r3.postDelayed(r4, r1);
        L12:
            if (r0.a.get() != null) goto L14;
            return;
        L14:
            if (r0.f == false) goto L27;
            RectF r2 = r0.d(r0.a.get());
            if (r2.equals(r0.m) == true) goto L23;
            Handler r5 = r0.i;
            if (r5 == null) goto L23;
            e r6 = r0.j;
            if (r6 == null) goto L23;
            r5.post(r6);
        L23:
            r0.m = r2;
            return;
        L27:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(e0 r2) {
            this.a = new WeakReference(r2);
        }
    }

    public void i() {
    }

    public final void b() {
        LLog.i(this.u, "addToObserverTree");
        UIBody r0 = this.a.get();
        if (r0 == null) goto L5;
        LynxContext r1 = r0.getLynxContext();
    L6:
        if (r1 == null) goto L11;
        int r2 = r1.getObserverFrameRate();
        if (r2 <= 0) goto L10;
        this.g = Math.max(16, 1000 / r2);
    L10:
        this.q = r1.getEnableDisexposureWhenLynxHidden();
        this.r = r1.getEnableExposureWhenLayout();
    L11:
        j();
        if (this.i != null) goto L15;
        this.i = new Handler(Looper.getMainLooper());
    L15:
        if (this.j != null) goto L17;
        this.j = new e(this);
    L17:
        this.i.post(this.j);
        if (this.k != null) goto L21;
        this.k = new Handler(Looper.getMainLooper());
    L21:
        if (this.l != null) goto L23;
        this.l = new f(this);
    L23:
        this.k.postDelayed(this.l, this.n);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void c() {
        LLog.i(this.u, "destroy");
        Handler r0 = this.i;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
        this.i = null;
    L5:
        Handler r1 = this.k;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
        this.k = null;
    L8:
        ViewTreeObserver r2 = this.e;
        if (r2 != null) goto L11;
    L12:
        UIBody.UIBodyView r3 = f();
        if (r3 != null) goto L15;
        LLog.e(this.u, "LynxObserver getViewTreeObserver failed since rootView is null");
        ViewTreeObserver r4 = null;
    L16:
        this.e = r4;
    L17:
        ViewTreeObserver r5 = this.e;
        if (r5 != null) goto L21;
        LLog.e(this.u, "LynxObserverManager remove listeners failed since observer is null");
        return;
    L21:
        r5.removeOnGlobalLayoutListener(this.b);
        this.e.removeOnScrollChangedListener(this.c);
        this.e.removeOnDrawListener(this.d);
        this.e = null;
        this.b = null;
        this.c = null;
        this.d = null;
        return;
    L15:
        r4 = r3.getViewTreeObserver();
        goto L16
    L11:
        if (r2.isAlive() == true) goto L17;
        goto L12
    }

    public final UIBody.UIBodyView f() {
        UIBody r0 = this.a.get();
        if (r0 != null) goto L7;
        LLog.e(this.u, "LynxObserver getRootView failed since rootUI is null");
        return null;
    L7:
        return r0.getBodyView();
    }

    public final void h() {
        if (this.f == true) goto L7;
        LLog.e(this.u, "Lynx observerHandler failed since rootView not draw");
        return;
    L7:
        if (this.o == false) goto L10;
        LLog.w(this.u, "Lynx observerHandler failed since inner function is delayed");
        return;
    L10:
        UIThreadUtils.runOnUiThreadImmediately(new a(this));
    }

    public final void k() {
        if (this.i != null) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - this.h;
        long r2 = this.g;
        if (r0 <= r2) goto L9;
        this.h = System.currentTimeMillis();
        this.i.post(this.j);
        this.s = false;
        return;
    L9:
        if (this.s == false) goto L11;
        return;
    L11:
        this.i.postDelayed(this.j, r2);
        this.s = true;
    }

    public final void j() {
        UIBody.UIBodyView r0 = f();
        if (r0 != null) goto L5;
        LLog.e(this.u, "LynxObserver getViewTreeObserver failed since rootView is null");
        ViewTreeObserver r1 = null;
    L6:
        if (r1 != null) goto L10;
        LLog.e(this.u, "LynxObserverManager add listeners failed since observer is null");
        return;
    L10:
        if (this.b != null) goto L13;
        this.b = new b(this);
    L13:
        if (this.c != null) goto L16;
        this.c = new c(this);
    L16:
        if (this.d != null) goto L19;
        this.d = new d(this);
    L19:
        if (r1 == this.e) goto L22;
        this.e = r1;
        r1.addOnGlobalLayoutListener(this.b);
        this.e.addOnScrollChangedListener(this.c);
        this.e.addOnDrawListener(this.d);
        return;
    L22:
        return;
    L5:
        r1 = r0.getViewTreeObserver();
        goto L6
    }

    public e0(String r5) {
        this.m = null;
        this.r = false;
        this.s = false;
        this.a = null;
        this.f = false;
        this.g = 50;
        this.n = 50;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.o = false;
        this.p = new int[2];
        this.t = new int[2];
        this.q = true;
        this.u = r5;
    }

    public final RectF d(LynxBaseUI r6) {
        RectF r0 = new RectF();
        if (r6 != null) goto L7;
        LLog.e(this.u, "LynxObserverManager getBoundsOnScreenOfLynxBaseUI failed since ui is null");
        return r0;
    L7:
        if (LynxEnv.inst().enableTransformForPositionCalculation() == false) goto L11;
        RectF r7 = com.lynx.tasm.behavior.ui.utils.h.f(r6, new RectF(0.0f, 0.0f, r6.getWidth(), r6.getHeight()));
        r0.set(r7.left, r7.top, r7.right, r7.bottom);
        return r0;
    L11:
        if ((r6 instanceof LynxUI) == false) goto L14;
        e(((LynxUI) r6).getView(), r0);
        float r1 = r0.left;
        r0.set(r1, r0.top, r6.getWidth() + r1, r0.top + r6.getHeight());
    L26:
        return r0;
    L14:
        if ((r6 instanceof LynxFlattenUI) == false) goto L26;
        LynxBaseUI r2 = r6.getParentBaseUI();
    L16:
        if (r2 == null) goto L20;
        if ((r2 instanceof LynxUI) == true) goto L20;
        r2 = r2.getParentBaseUI();
    L20:
        if (r2 == null) goto L26;
        View r3 = ((LynxUI) r2).getView();
        e(r3, r0);
        if ((r2 instanceof UIScrollView) == false) goto L24;
        AndroidScrollView r4 = (AndroidScrollView) r3;
        r0.offset(-r4.getRealScrollX(), -r4.getRealScrollY());
    L25:
        r0.offset(r6.getLeft(), r6.getTop());
        float r5 = r0.left;
        r0.set(r5, r0.top, r6.getWidth() + r5, r0.top + r6.getHeight());
        goto L26
    L24:
        r0.offset(-r3.getScrollX(), -r3.getScrollY());
        goto L25
    }

    public final RectF g(LynxContext r8) {
        if (r8 == null) goto L15;
        Activity r9 = r8.getActivity();
        int[] r0 = new int[2];
        if (r9 == null) goto L13;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L13;
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L12:
        r11.getLocationOnScreen(r0);
    L13:
        int r2 = r0[0];
        int r3 = r0[1];
        int[] r6 = this.t;
        return new RectF(r2, r3, r2 + r6[0], r3 + r6[1]);
    L15:
        LLog.e(this.u, "getWindowRect func failed since context is null");
        return new RectF();
    }

    public final void l(LynxContext r4) {
        DisplayMetrics r5 = DisplayMetricsHolder.getRealScreenDisplayMetrics(r4);
        int[] r0 = this.t;
        r0[0] = r5.widthPixels;
        r0[1] = r5.heightPixels;
    }

    public final void e(View r3, RectF r4) {
        if (r3 != null) goto L5;
        LLog.e(this.u, "LynxObserverManager getLeftAndTopOfBoundsInScreen failed since view is null");
        return;
    L5:
        r3.getLocationOnScreen(this.p);
        int[] r5 = this.p;
        r4.offset(r5[0], r5[1]);
    }
}
