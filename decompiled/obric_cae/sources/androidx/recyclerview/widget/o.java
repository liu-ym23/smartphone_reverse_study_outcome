package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class o extends RecyclerView.y {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f2545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f2546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PointF f2547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f2548l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2549m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2550n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2551o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2552p;

    public o(Context r8) {
        this.f2545i = new LinearInterpolator();
        this.f2546j = new DecelerateInterpolator();
        this.f2549m = false;
        this.f2551o = 0;
        this.f2552p = 0;
        this.f2548l = r8.getResources().getDisplayMetrics();
    }

    public static int e(int r8, int r10, int r11, int r12, int r13) {
        if (r13 == (-1)) goto L20;
        if (r13 != 0) goto L6;
        int r14 = r11 - r8;
        if (r14 <= 0) goto L14;
        return r14;
    L14:
        int r15 = r12 - r10;
        if (r15 >= 0) goto L17;
        return r15;
    L17:
        return 0;
    L6:
        if (r13 != 1) goto L10;
        return r12 - r10;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r11 - r8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void c(View r8, RecyclerView.y.a r10) {
        PointF r11 = this.f2547k;
        int r12 = -1;
        if (r11 == null) goto L10;
        float r13 = r11.x;
        if (r13 == 0.0f) goto L10;
        if (r13 <= 0.0f) goto L9;
        int r14 = 1;
    L11:
        int r15 = f(r8, r14);
        PointF r16 = this.f2547k;
        if (r16 == null) goto L18;
        float r17 = r16.y;
        if (r17 == 0.0f) goto L18;
        if (r17 <= 0.0f) goto L19;
        r12 = 1;
    L19:
        int r18 = g(r8, r12);
        int r19 = (int) Math.ceil(((double) i((int) Math.sqrt((r18 * r18) + (r15 * r15)))) / 0.3356d);
        if (r19 <= 0) goto L23;
        DecelerateInterpolator r20 = this.f2546j;
        r10.f2357a = -r15;
        r10.f2358b = -r18;
        r10.f2359c = r19;
        r10.f2361e = r20;
        r10.f2362f = true;
        return;
    L23:
        return;
    L18:
        r12 = 0;
        goto L19
    L9:
        r14 = -1;
    L10:
        r14 = 0;
        goto L11
    }

    public int f(View r8, int r10) {
        RecyclerView.o r11 = this.f2351c;
        if (r11 != null) goto L5;
        return 0;
    L5:
        if (r11.e() == false) goto L11;
        RecyclerView.p r12 = (RecyclerView.p) r8.getLayoutParams();
        return e((r8.getLeft() - ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets.left) - ((ViewGroup.MarginLayoutParams) r12).leftMargin, (r8.getRight() + ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets.right) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, r11.D(), r11.f2326n - r11.E(), r10);
    L11:
        return 0;
    }

    public int g(View r8, int r10) {
        RecyclerView.o r11 = this.f2351c;
        if (r11 != null) goto L5;
        return 0;
    L5:
        if (r11.f() == false) goto L11;
        RecyclerView.p r12 = (RecyclerView.p) r8.getLayoutParams();
        return e((r8.getTop() - ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets.top) - ((ViewGroup.MarginLayoutParams) r12).topMargin, (r8.getBottom() + ((RecyclerView.p) r8.getLayoutParams()).mDecorInsets.bottom) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin, r11.F(), r11.f2327o - r11.C(), r10);
    L11:
        return 0;
    }

    public float h(DisplayMetrics r8) {
        return 25.0f / r8.densityDpi;
    }

    public int i(int r8) {
        float r10 = Math.abs(r8);
        if (this.f2549m == true) goto L6;
        this.f2550n = h(this.f2548l);
        this.f2549m = true;
    L6:
        return (int) Math.ceil(r10 * this.f2550n);
    }
}
