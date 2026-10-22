package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6401c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6402g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f6403h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f6404i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6405j;

        a(View r10, int r11, int r12, boolean r13, ViewGroup r14) {
            this.f6401c = r10;
            this.f6402g = r11;
            this.f6403h = r12;
            this.f6404i = r13;
            this.f6405j = r14;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Rect r10 = new Rect();
            this.f6401c.getHitRect(r10);
            int r11 = (this.f6402g - r10.width()) / 2;
            int r12 = (this.f6403h - r10.height()) / 2;
            if (r11 < 0) goto L5;
        L7:
            if (r12 < 0) goto L9;
        L11:
            r10.left -= r11;
            r10.top -= r12;
            r10.right += r11;
            r10.bottom += r12;
            this.f6405j.setTouchDelegate(new TouchDelegate(r10, this.f6401c));
            return;
        L9:
            if (this.f6404i == true) goto L11;
            r12 = 0;
            goto L11
        L5:
            if (this.f6404i == true) goto L7;
            r11 = 0;
            goto L7
        }
    }

    static final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6406c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View[] f6407g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f6408h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f6409i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ j f6410j;

        b(View r10, View[] r11, int r12, int r13, j r14) {
            this.f6406c = r10;
            this.f6407g = r11;
            this.f6408h = r12;
            this.f6409i = r13;
            this.f6410j = r14;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View[] r10 = this.f6407g;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L10;
            View r13 = r10[r12];
            r12 = r12 + 1;
            Rect r14 = new Rect();
            r13.getHitRect(r14);
            int r15 = (this.f6408h - r14.width()) / 2;
            int r16 = (this.f6409i - r14.height()) / 2;
            if (r15 >= 0) goto L7;
            r15 = 0;
        L7:
            if (r16 >= 0) goto L9;
            r16 = 0;
        L9:
            r14.left -= r15;
            r14.top -= r16;
            r14.right += r15;
            r14.bottom += r16;
            this.f6410j.a(new TouchDelegate(r14, r13));
            goto L3
        L10:
            this.f6406c.setTouchDelegate(this.f6410j);
        }
    }

    public static final void a(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$expandTouchArea");
        c(r10, r11, r11, false, 4, null);
    }

    public static final void b(View r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$expandTouchArea");
        if (r10.getParent() == null) goto L5;
        ViewParent r14 = r10.getParent();
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r15 = (ViewGroup) r14;
    L6:
        if (r15 == null) goto L9;
        r15.post(new a(r10, r11, r12, r13, r15));
        return;
    L9:
        return;
    L5:
        r15 = null;
        goto L6
    }

    public static /* synthetic */ void c(View r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = false;
    L5:
        b(r10, r11, r12, r13);
    }

    public static final void d(View r10, int r11, int r12, View... r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$increaseHitAreaForViews");
        Intrinsics.checkNotNullParameter(r13, "views");
        r10.post(new b(r10, r13, r11, r12, new j(r10, null, 2, null)));
    }

    public static final boolean e(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$isVisibile");
        if (r10.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void f(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$makeGone");
        r10.setVisibility(8);
    }

    public static final void g(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$makeInvisible");
        r10.setVisibility(4);
    }

    public static final void h(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$makeVisible");
        r10.setVisibility(0);
    }

    public static final void i(View r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$removeFromParent");
        if (r10.getParent() != null) goto L5;
        return;
    L5:
        if ((r10.getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r11 = r10.getParent();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r11).removeView(r10);
        return;
    }

    public static final void j(ViewGroup r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$removeFromParentAndAdd");
        if (r11 == null) goto L5;
        ViewParent r12 = r11.getParent();
    L6:
        if (r12 != null) goto L8;
    L10:
        r10.addView(r11);
        return;
    L8:
        if ((r11.getParent() instanceof ViewGroup) == false) goto L10;
        i(r11);
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public static final void k(View r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$setVisibility");
        if (r11 == false) goto L5;
        h(r10);
        return;
    L5:
        f(r10);
    }
}
