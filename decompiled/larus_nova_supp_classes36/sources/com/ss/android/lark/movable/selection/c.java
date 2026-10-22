package com.ss.android.lark.movable.selection;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final Function0<ViewGroup> a;
    public final Map<d, com.ss.android.lark.movable.selection.b> b;
    public final int[] c;
    public final int[] d;
    public View e;
    public boolean f;
    public final b g;
    public final a h;
    public final ViewTreeObserverOnScrollChangedListenerC0192c i;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.c();
        }
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.c();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.selection.c$c, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnScrollChangedListenerC0192c implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ c a;

        public ViewTreeObserverOnScrollChangedListenerC0192c(c r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.a.c();
        }
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        this.f = false;
        View r0 = this.e;
        if (r0 == null) goto L10;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L10;
        r1.removeOnPreDrawListener(this.g);
    L10:
        View r2 = this.e;
        if (r2 == null) goto L15;
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3 == null) goto L15;
        r3.removeOnGlobalLayoutListener(this.h);
    L15:
        View r4 = this.e;
        if (r4 == null) goto L20;
        ViewTreeObserver r5 = r4.getViewTreeObserver();
        if (r5 == null) goto L20;
        r5.removeOnScrollChangedListener(this.i);
    L20:
        this.e = null;
    }

    public final void c() {
        ViewGroup r0 = (ViewGroup) this.a.invoke();
        Iterator r1 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        d((d) r2.getKey(), (com.ss.android.lark.movable.selection.b) r2.getValue(), r0);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<? extends ViewGroup> r2) {
        Intrinsics.checkNotNullParameter(r2, "mirrorContainerProvider");
        this.a = r2;
        this.b = new LinkedHashMap();
        this.c = new int[2];
        this.d = new int[2];
        this.g = new b(this);
        this.h = new a(this);
        this.i = new ViewTreeObserverOnScrollChangedListenerC0192c(this);
    }

    public final void a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "origin");
        com.ss.android.lark.movable.selection.b r0 = this.b.remove(r4);
        if (r0 == null) goto L10;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L7;
        ViewGroup r2 = (ViewGroup) r1;
    L8:
        if (r2 == null) goto L10;
        r2.removeView(r0);
        goto L10
    L7:
        r2 = null;
    L10:
        r4.setIsGhost(false);
        if (this.b.isEmpty() == false) goto L14;
        b();
        return;
    }

    public final void d(d r8, com.ss.android.lark.movable.selection.b r9, ViewGroup r10) {
        View r11 = r8.getView();
        Object r0 = r11.getParent();
        Integer r2 = null;
        if ((r0 instanceof View) == false) goto L5;
        View r1 = (View) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1 != r10) goto L10;
        return;
    L10:
        r9.setPivotX(r11.getPivotX());
        r9.setPivotY(r11.getPivotY());
        r9.setRotation(r11.getRotation());
        r9.setRotationX(r11.getRotationX());
        r9.setRotationY(r11.getRotationY());
        r9.setScaleX(r11.getScaleX());
        r9.setScaleY(r11.getScaleY());
        Integer r3 = Integer.valueOf(r11.getWidth());
        if (r3.intValue() <= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L19;
        int r5 = r3.intValue();
    L20:
        Integer r6 = Integer.valueOf(r11.getHeight());
        if (r6.intValue() <= 0) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L26;
        r2 = r6;
    L26:
        if (r2 == null) goto L28;
        int r12 = r2.intValue();
    L30:
        if (r9.getLayoutParams().width == r5) goto L32;
    L33:
        r9.getLayoutParams().width = r5;
        r9.getLayoutParams().height = r12;
        r9.requestLayout();
    L34:
        r1.getLocationOnScreen(this.c);
        r10.getLocationOnScreen(this.d);
        r9.setX((this.c[0] + r11.getX()) - this.d[0]);
        r9.setY((this.c[1] + r11.getY()) - this.d[1]);
        r9.invalidate();
        return;
    L32:
        if (r9.getLayoutParams().height == r12) goto L34;
    L28:
        r12 = r11.getMeasuredHeight();
        goto L30
    L23:
        r7 = false;
        goto L24
    L19:
        r5 = r11.getMeasuredWidth();
        goto L20
    L13:
        r4 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }
}
