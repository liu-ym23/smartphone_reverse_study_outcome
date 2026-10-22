package com.ss.android.lark.insets;

import android.graphics.Rect;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class c implements f {
    public static final /* synthetic */ int n = 0;
    public FitSystemCoordinator a;
    public OnApplyWindowInsetsListener b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public final int[] l;
    public final Rect m;

    public static final class a {
    }

    static {
    }

    public abstract WindowInsetsControllerCompat u();

    public final void s() {
        int r0 = this.f;
        boolean r1 = true;
        if (r0 != 0) goto L11;
        FitSystemCoordinator r2 = this.a;
        if (r2 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r2.isDarkMode());
    L8:
        int r4 = WindowInsetsUtils.a;
        p(!Intrinsics.areEqual(r3, Boolean.TRUE));
        return;
    L7:
        r3 = null;
        goto L8
    L11:
        if (ColorUtils.calculateContrast(r0, -1) <= 3.0d) goto L14;
        r1 = false;
    L14:
        p(r1);
    }

    public final void t() {
        int r0 = this.e;
        boolean r1 = true;
        if (r0 != 0) goto L11;
        FitSystemCoordinator r2 = this.a;
        if (r2 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r2.isDarkMode());
    L8:
        int r4 = WindowInsetsUtils.a;
        v(!Intrinsics.areEqual(r3, Boolean.TRUE));
        return;
    L7:
        r3 = null;
        goto L8
    L11:
        if (ColorUtils.calculateContrast(r0, -1) <= 3.0d) goto L14;
        r1 = false;
    L14:
        v(r1);
    }

    public c() {
        this.l = new int[2];
        this.m = new Rect();
    }

    @Override // com.ss.android.lark.insets.f
    public final int a() {
        return this.e;
    }

    @Override // com.ss.android.lark.insets.f
    public final boolean e() {
        return this.i;
    }

    @Override // com.ss.android.lark.insets.f
    public final boolean g() {
        return this.j;
    }

    @Override // com.ss.android.lark.insets.f
    public final int j() {
        return this.k;
    }

    @Override // com.ss.android.lark.insets.f
    public final boolean m() {
        return this.g;
    }

    @Override // com.ss.android.lark.insets.f
    public final void b(int r3) {
        this.e = r3;
        FitSystemCoordinator r0 = this.a;
        if (r0 == null) goto L6;
        r0.a().f = r3;
        r0.invalidate();
    L6:
        if (this.c == false) goto L9;
        t();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void c(boolean r1) {
        this.i = r1;
        FitSystemCoordinator r2 = this.a;
        if (r2 == null) goto L6;
        r2.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void f(boolean r1) {
        this.g = r1;
        FitSystemCoordinator r2 = this.a;
        if (r2 == null) goto L6;
        r2.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void h(boolean r1) {
        this.j = r1;
        FitSystemCoordinator r2 = this.a;
        if (r2 == null) goto L6;
        r2.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void i(int r3) {
        this.f = r3;
        FitSystemCoordinator r0 = this.a;
        if (r0 == null) goto L6;
        r0.a().g = r3;
        r0.invalidate();
    L6:
        if (this.d == false) goto L9;
        s();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void k(boolean r1) {
        this.c = r1;
        if (r1 == false) goto L6;
        t();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void l(int r1) {
        this.k = r1;
        FitSystemCoordinator r2 = this.a;
        if (r2 == null) goto L6;
        r2.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void o(boolean r1) {
        this.h = r1;
        FitSystemCoordinator r2 = this.a;
        if (r2 == null) goto L6;
        r2.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void p(boolean r2) {
        WindowInsetsControllerCompat r0 = u();
        if (r0 == null) goto L6;
        r0.setAppearanceLightNavigationBars(r2);
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void r(boolean r1) {
        this.d = r1;
        if (r1 == false) goto L6;
        s();
        return;
    }

    public final void v(boolean r2) {
        WindowInsetsControllerCompat r0 = u();
        if (r0 == null) goto L6;
        r0.setAppearanceLightStatusBars(r2);
        return;
    }
}
