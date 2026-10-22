package com.lynx.tasm.behavior;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f10198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f10199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f10200c;
    public z d;
    public ViewTreeObserver e;
    public boolean f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f10202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public x f10203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Handler f10204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a0 f10205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f10206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f10207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f10209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f10211r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f10212t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f10213u;

    public b0(String r5) {
        this.f10206m = null;
        this.f10211r = false;
        this.s = false;
        this.f10198a = null;
        this.f = false;
        this.g = 50;
        this.f10207n = 50;
        this.f10201h = 0;
        this.f10202i = null;
        this.f10203j = null;
        this.f10208o = false;
        this.f10209p = new int[2];
        this.f10212t = new int[2];
        this.f10210q = true;
        this.f10213u = r5;
    }

    public final RectF a(LynxContext r10) {
        if (r10 == null) goto L10;
        Activity r11 = kk.a.c(r10);
        int[] r5 = new int[2];
        if (r11 == null) goto L8;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L8;
        r12.getDecorView().getLocationOnScreen(r5);
    L8:
        int r13 = r5[0];
        int r14 = r5[1];
        int[] r15 = this.f10212t;
        return new RectF(r13, r14, r13 + r15[0], r14 + r15[1]);
    L10:
        LynxLog.b(4, this.f10213u, "getWindowRect func failed since context is null");
        return new RectF();
    }

    public final RectF b(LynxBaseUI r10) {
        RectF r5 = new RectF();
        String r11 = this.f10213u;
        if (r10 != null) goto L7;
        LynxLog.b(4, r11, "LynxObserverManager getBoundsOnScreenOfLynxBaseUI failed since ui is null");
        return r5;
    L7:
        if (LynxEnv.inst().enableTransformForPositionCalculation() == false) goto L10;
        RectF r12 = i.a.o(r10, new RectF(0.0f, 0.0f, r10.getWidth(), r10.getHeight()));
        r5.set(r12.left, r12.top, r12.right, r12.bottom);
        return r5;
    L10:
        boolean r13 = r10 instanceof LynxUI;
        int[] r14 = this.f10209p;
        if (r13 == false) goto L19;
        View r15 = ((LynxUI) r10).getView();
        if (r15 != null) goto L15;
        LynxLog.b(4, r11, "LynxObserverManager getLeftAndTopOfBoundsInScreen failed since view is null");
    L16:
        float r16 = r5.left;
        r5.set(r16, r5.top, r10.getWidth() + r16, r5.top + r10.getHeight());
        return r5;
    L15:
        r15.getLocationOnScreen(r14);
        r5.offset(r14[0], r14[1]);
        goto L16
    L19:
        if ((r10 instanceof LynxFlattenUI) == false) goto L31;
        LynxBaseUI r17 = r10.getParentBaseUI();
    L21:
        if (r17 == null) goto L25;
        if ((r17 instanceof LynxUI) == true) goto L25;
        r17 = r17.getParentBaseUI();
    L25:
        if (r17 == null) goto L31;
        View r18 = ((LynxUI) r17).getView();
        if (r18 != null) goto L29;
        LynxLog.b(4, r11, "LynxObserverManager getLeftAndTopOfBoundsInScreen failed since view is null");
    L30:
        r5.offset(-r18.getScrollX(), -r18.getScrollY());
        r5.offset(r10.getLeft(), r10.getTop());
        float r19 = r5.left;
        r5.set(r19, r5.top, r10.getWidth() + r19, r5.top + r10.getHeight());
        goto L31
    L29:
        r18.getLocationOnScreen(r14);
        r5.offset(r14[0], r14[1]);
    L31:
        return r5;
    }

    public final void c() {
        LynxLog.b(2, this.f10213u, "addToObserverTree");
        UIBody r5 = (UIBody) this.f10198a.get();
        if (r5 == null) goto L5;
        LynxContext r10 = r5.getLynxContext();
    L6:
        if (r10 == null) goto L22;
        com.lynx.tasm.u0 r11 = r10.K;
        if (r11 == null) goto L10;
        int r12 = r11.H;
    L11:
        if (r12 <= 0) goto L13;
        this.g = Math.max(16, 1000 / r12);
    L13:
        com.lynx.tasm.u0 r13 = r10.K;
        if (r13 == null) goto L16;
        boolean r14 = r13.f10987z;
    L17:
        this.f10210q = r14;
        if (r13 == null) goto L20;
        boolean r15 = r13.A;
    L21:
        this.f10211r = r15;
        goto L22
    L20:
        r15 = false;
        goto L21
    L16:
        r14 = true;
        goto L17
    L10:
        r12 = 20;
    L22:
        g();
        if (this.f10202i != null) goto L26;
        this.f10202i = new Handler(Looper.getMainLooper());
    L26:
        if (this.f10203j != null) goto L28;
        this.f10203j = new x(this, 1);
    L28:
        this.f10202i.post(this.f10203j);
        if (this.f10204k != null) goto L32;
        this.f10204k = new Handler(Looper.getMainLooper());
    L32:
        if (this.f10205l != null) goto L34;
        this.f10205l = new a0(this);
    L34:
        this.f10204k.postDelayed(this.f10205l, this.f10207n);
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final void d() {
        String r5 = this.f10213u;
        LynxLog.b(2, r5, "destroy");
        Handler r10 = this.f10202i;
        if (r10 == null) goto L5;
        r10.removeCallbacksAndMessages(null);
        this.f10202i = null;
    L5:
        Handler r11 = this.f10204k;
        if (r11 == null) goto L8;
        r11.removeCallbacksAndMessages(null);
        this.f10204k = null;
    L8:
        ViewTreeObserver r12 = this.e;
        if (r12 != null) goto L11;
    L12:
        UIBody.UIBodyView r13 = e();
        if (r13 != null) goto L15;
        LynxLog.b(4, r5, "LynxObserver getViewTreeObserver failed since rootView is null");
        ViewTreeObserver r14 = null;
    L16:
        this.e = r14;
    L17:
        ViewTreeObserver r15 = this.e;
        if (r15 != null) goto L21;
        LynxLog.b(4, r5, "LynxObserverManager remove listeners failed since observer is null");
        return;
    L21:
        r15.removeOnGlobalLayoutListener(this.f10199b);
        this.e.removeOnScrollChangedListener(this.f10200c);
        this.e.removeOnDrawListener(this.d);
        this.e = null;
        this.f10199b = null;
        this.f10200c = null;
        this.d = null;
        return;
    L15:
        r14 = r13.getViewTreeObserver();
        goto L16
    L11:
        if (r12.isAlive() == true) goto L17;
        goto L12
    }

    public final UIBody.UIBodyView e() {
        UIBody r5 = (UIBody) this.f10198a.get();
        if (r5 != null) goto L7;
        LynxLog.b(4, this.f10213u, "LynxObserver getRootView failed since rootUI is null");
        return null;
    L7:
        return r5.f10385a;
    }

    public abstract void f();

    public final void g() {
        UIBody.UIBodyView r5 = e();
        String r10 = this.f10213u;
        if (r5 != null) goto L5;
        LynxLog.b(4, r10, "LynxObserver getViewTreeObserver failed since rootView is null");
        ViewTreeObserver r11 = null;
    L6:
        if (r11 != null) goto L10;
        LynxLog.b(4, r10, "LynxObserverManager add listeners failed since observer is null");
        return;
    L10:
        if (this.f10199b != null) goto L13;
        this.f10199b = new m(this, 1);
    L13:
        if (this.f10200c != null) goto L16;
        this.f10200c = new y(this, 0);
    L16:
        if (this.d != null) goto L19;
        this.d = new z(this, 0);
    L19:
        if (r11 == this.e) goto L22;
        this.e = r11;
        r11.addOnGlobalLayoutListener(this.f10199b);
        this.e.addOnScrollChangedListener(this.f10200c);
        this.e.addOnDrawListener(this.d);
        return;
    L22:
        return;
    L5:
        r11 = r5.getViewTreeObserver();
        goto L6
    }

    public final void h() {
        if (this.f10202i == null) goto L14;
        long r5 = System.currentTimeMillis() - this.f10201h;
        long r10 = this.g;
        if (r5 <= r10) goto L10;
        this.f10201h = System.currentTimeMillis();
        this.f10202i.post(this.f10203j);
        this.s = false;
        return;
    L10:
        if (this.s == false) goto L12;
        return;
    L12:
        this.f10202i.postDelayed(this.f10203j, r10);
        this.s = true;
        return;
    }
}
