package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.k0;
import com.obric.oui.orecyclerview.widget.q0;
import com.obric.oui.orecyclerview.widget.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends k0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f14063m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f14064n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f14065o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14066p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f14068r;
    public final int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f14069t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14070u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f14071v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f14072w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f14073x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14074y;

    public b(final Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f14063m = com.lynx.tasm.utils.a.s(r5, 8000.0f);
        Lazy r10 = LazyKt.lazy(new WheelLayoutManager$defaultStartColor$2(r5));
        this.f14064n = r10;
        Lazy r11 = LazyKt.lazy(new WheelLayoutManager$defaultEndColor$2(r5));
        this.f14065o = r11;
        this.f14066p = ((Number) r10.getValue()).intValue();
        this.f14067q = ((Number) r11.getValue()).intValue();
        this.f14068r = 30.0f;
        this.s = 3;
        this.f14069t = 0.017453292f;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void I(q0 r5, u0 r10) {
        Intrinsics.checkNotNullParameter(r5, "recycler");
        Intrinsics.checkNotNullParameter(r10, "state");
        if (w() != 0) goto L7;
        n(r5);
        this.f14071v = 0.0f;
        return;
    L7:
        if (this.f14070u != 0) goto L9;
        View r11 = r5.j(0, Long.MAX_VALUE).itemView;
        a(r11, -1, false);
        F(r11);
        int r12 = k0.u(r11);
        this.f14070u = r12;
        this.f14072w = r12 / ((float) Math.tan(this.f14068r * this.f14069t));
        R(r5, this.f13838a.u(r11), r11);
    L9:
        b0(r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final void T(int r5) {
        if (w() != 0) goto L5;
        return;
    L5:
        if (this.f14070u != 0) goto L8;
        return;
    L8:
        if (this.f14073x == false) goto L10;
        int r10 = RangesKt.coerceIn(r5, 0, w() - 1);
    L11:
        this.f14071v = r10 * this.f14070u;
        Q();
        return;
    L10:
        int r11 = this.f14074y;
        r10 = RangesKt.coerceIn(r5, r11, RangesKt.coerceAtLeast((w() - this.f14074y) - 1, r11));
        goto L11
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final int U(int r5, q0 r10, u0 r11) {
        Intrinsics.checkNotNullParameter(r10, "recycler");
        Intrinsics.checkNotNullParameter(r11, "state");
        if (r() == 0) goto L16;
        if (r5 == 0) goto L16;
        if (this.f14070u == 0) goto L16;
        if (w() == 0) goto L16;
        float r12 = RangesKt.coerceAtLeast(w() - 1, 0) * this.f14070u;
        if (this.f14073x == false) goto L13;
        Pair r13 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(r12));
    L14:
        float r14 = RangesKt.coerceIn(this.f14071v + r5, ((Number) r13.component1()).floatValue(), ((Number) r13.component2()).floatValue());
        float r15 = r14 - this.f14071v;
        this.f14071v = r14;
        b0(r10);
        return MathKt.roundToInt(r15);
    L13:
        int r16 = this.f14074y;
        int r17 = RangesKt.coerceAtLeast((w() - this.f14074y) - 1, r16);
        int r18 = this.f14070u;
        r13 = TuplesKt.to(Float.valueOf(r16 * r18), Float.valueOf(r17 * r18));
    L16:
        return 0;
    }

    public final void b0(q0 r17) {
        n(r17);
        int r5 = (this.f13845l - A()) - x();
        if (r5 > 0) goto L5;
        return;
    L5:
        if (this.f14070u == 0) goto L19;
        float r10 = 2.0f;
        float r11 = (r5 / 2.0f) + A();
        float r12 = this.f14071v / this.f14070u;
        float r13 = this.s;
        float r14 = 1;
        int r15 = RangesKt.coerceAtLeast((int) Math.floor((r12 - r13) - r14), 0);
        int r16 = RangesKt.coerceAtMost((int) Math.ceil((r13 + r12) + r14), w() - 1);
        if (r15 > r16) goto L18;
    L9:
        int r18 = r15 + 1;
        View r19 = r17.j(r15, Long.MAX_VALUE).itemView;
        a(r19, -1, false);
        F(r19);
        int r110 = k0.v(r19);
        int r111 = ((((this.f13844k - y()) - z()) - r110) / 2) + y();
        int r112 = MathKt.roundToInt(r11 - (this.f14070u / r10));
        int r113 = this.f14070u + r112;
        Rect r114 = ((RecyclerView.LayoutParams) r19.getLayoutParams()).f13769b;
        r19.layout(r111 + r114.left, r112 + r114.top, (r110 + r111) - r114.right, r113 - r114.bottom);
        float r115 = r15 - r12;
        float r116 = RangesKt.coerceIn(this.f14068r * r115, -90.0f, 90.0f);
        float r117 = this.f14069t * r116;
        float r118 = RangesKt.coerceIn(Math.abs(r116) / 90.0f, 0.0f, 1.0f);
        float r119 = RangesKt.coerceIn(Math.abs(r115), 0.0f, 1.0f);
        float r120 = ((-0.19999999f) * r118) + 1.0f;
        r19.setPivotX(r19.getWidth() / r10);
        r19.setPivotY(r19.getHeight() / r10);
        r19.setRotationX(r116);
        r19.setScaleX(r120);
        r19.setScaleY(r120);
        double r121 = r117;
        int r122 = r16;
        r19.setTranslationY(((float) Math.sin(r121)) * this.f14072w);
        float r20 = (float) Math.cos(r121);
        float r21 = this.f14072w;
        r19.setTranslationZ((r20 * r21) - r21);
        r19.setCameraDistance(this.f14063m);
        if ((r19 instanceof TextView) == false) goto L12;
        TextView r22 = (TextView) r19;
        r22.setTextColor(ColorUtils.blendARGB(this.f14066p, this.f14067q, r119));
        r22.setTypeface(Typeface.create(Typeface.DEFAULT, MathKt.roundToInt(((-150.0f) * r119) + 450.0f), false));
    L12:
        r19.setAlpha(((-0.8f) * r118) + 1.0f);
        if (r15 == r122) goto L20;
        r16 = r122;
        r15 = r18;
        r10 = 2.0f;
        goto L9
    L20:
        return;
    L18:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final boolean d() {
        return true;
    }

    @Override // com.obric.oui.orecyclerview.widget.k0
    public final RecyclerView.LayoutParams p() {
        return new RecyclerView.LayoutParams(-2, -2);
    }
}
