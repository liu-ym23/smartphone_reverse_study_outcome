package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class p extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final LinearInterpolator f14225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.obric.oui.orecyclerview.base.g f14226b;
    protected PointF c;
    protected int d;
    protected int e;
    private final DisplayMetrics f;
    private boolean g;
    private float h;

    public p(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f14225a = new LinearInterpolator();
        this.f14226b = new com.obric.oui.orecyclerview.base.g();
        this.g = false;
        this.d = 0;
        this.e = 0;
        this.f = ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics();
    }

    private int b(int r1, int r2) {
        int r0 = r1 - r2;
        if ((r1 * r0) > 0) goto L6;
        return 0;
    L6:
        return r0;
    }

    private float k() {
        if (this.g == true) goto L6;
        this.h = a(this.f);
        this.g = true;
    L6:
        return this.h;
    }

    public float a(DisplayMetrics r1) {
        return 50.0f / r1.densityDpi;
    }

    public int a() {
        PointF r0 = this.c;
        if (r0 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r0.y == 0.0f) goto L11;
        if (this.c.y <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    }

    public int a(int r3) {
        return (int) Math.ceil(((double) b(r3)) / 0.2d);
    }

    public int a(int r1, int r2, int r3, int r4, int r5) {
        if (r5 == (-1)) goto L20;
        if (r5 != 0) goto L6;
        int r6 = r3 - r1;
        if (r6 <= 0) goto L14;
        return r6;
    L14:
        int r7 = r4 - r2;
        if (r7 >= 0) goto L17;
        return r7;
    L17:
        return 0;
    L6:
        if (r5 != 1) goto L10;
        return r4 - r2;
    L10:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
    L20:
        return r3 - r1;
    }

    public int a(View r11, int r12) {
        RecyclerView.h r0 = e();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.f() == false) goto L11;
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
        return a(r0.i(r11) - r1.topMargin, r0.k(r11) + r1.bottomMargin, r0.D(), r0.B() - r0.F(), r12);
    L11:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void a(int r1, int r2, RecyclerView.s r3, RecyclerView.r.a r4) {
        if (j() != 0) goto L6;
        f();
        return;
    L6:
        this.d = b(this.d, r1);
        int r5 = b(this.e, r2);
        this.e = r5;
        if (this.d != 0) goto L11;
        if (r5 != 0) goto L12;
        a(r4);
        return;
    L12:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void a(View r3, RecyclerView.s r4, RecyclerView.r.a r5) {
        int r6 = b(r3, d());
        int r7 = a(r3, a());
        int r0 = a((int) Math.sqrt((r6 * r6) + (r7 * r7)));
        if (r0 <= 0) goto L6;
        r5.update(-r6, -r7, r0, this.f14226b);
        return;
    }

    public void a(RecyclerView.r.a r5) {
        PointF r0 = d(i());
        if (r0 != null) goto L5;
    L11:
        r5.a(i());
        f();
        return;
    L5:
        if (r0.x == 0.0f) goto L7;
    L9:
        a(r0);
        this.c = r0;
        this.d = (int) (r0.x * 10000.0f);
        this.e = (int) (r0.y * 10000.0f);
        r5.update((int) (this.d * 1.2f), (int) (this.e * 1.2f), (int) (b(10000) * 1.2f), this.f14225a);
        return;
    L7:
        if (r0.y != 0.0f) goto L9;
        goto L9
    }

    public int b(int r1) {
        return (int) Math.ceil(Math.abs(r1) * k());
    }

    public int b(View r11, int r12) {
        RecyclerView.h r0 = e();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if (r0.e() == false) goto L11;
        RecyclerView.LayoutParams r1 = (RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin");
        return a(r0.h(r11) - r1.leftMargin, r0.j(r11) + r1.rightMargin, r0.C(), r0.A() - r0.E(), r12);
    L11:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void b() {
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.r
    public void c() {
        this.e = 0;
        this.d = 0;
        this.c = null;
    }

    public int d() {
        PointF r0 = this.c;
        if (r0 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r0.x == 0.0f) goto L11;
        if (this.c.x <= 0.0f) goto L10;
        return 1;
    L10:
        return -1;
    }
}
