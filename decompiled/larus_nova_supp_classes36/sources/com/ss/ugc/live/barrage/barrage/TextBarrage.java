package com.ss.ugc.live.barrage.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class TextBarrage extends AbsBarrage {
    public static final /* synthetic */ KProperty[] B = null;
    public final float A;
    public int q;
    public int r;
    public float s;
    public final Lazy t;
    public int u;
    public final Rect v;
    public final String w;
    public final float x;
    public final int y;
    public final Typeface z;

    static {
        B = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TextBarrage.class), "textPaint", "getTextPaint()Landroid/graphics/Paint;"))};
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public Bitmap h() {
        return null;
    }

    public final Paint q() {
        Lazy r0 = this.t;
        KProperty r1 = B[0];
        return (Paint) r0.getValue();
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void k() {
        r(q());
    }

    @Override // com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void g(Canvas r6) {
        String r0 = this.w;
        RectF r1 = this.f;
        float r2 = r1.left;
        float r3 = this.s;
        if (r3 > 0) goto L6;
        r3 = this.m.b;
    L6:
        r6.drawText(r0, r2 + r3, (r1.bottom - this.u) + this.m.c, q());
    }

    public final void r(Paint r5) {
        Rect r0 = this.v;
        String r1 = this.w;
        r5.getTextBounds(r1, 0, r1.length(), r0);
        Rect r6 = this.v;
        this.u = r6.bottom;
        this.q = r6.width();
        this.r = this.v.height();
        float r3 = 2;
        o(Math.max(this.q, this.A), this.r + (this.m.c * r3));
        if (this.f.width() != (this.A + (this.m.b * 2))) goto L5;
        this.s = (this.f.width() - this.q) / r3;
    L5:
        this.b = true;
        int r7 = this.w.length();
        if (6 <= r7) goto L9;
    L11:
        this.w.length();
        return;
    L9:
        if (10 < r7) goto L11;
    }

    public TextBarrage(String r1, float r2, int r3, Typeface r4, float r5, final AbsBarrage.b r6) {
        super(r6);
        this.w = r1;
        this.x = r2;
        this.y = r3;
        this.z = r4;
        this.A = r5;
        this.s = -1.0f;
        this.t = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextBarrage$textPaint$2(this, r6));
        this.v = new Rect();
    }
}
