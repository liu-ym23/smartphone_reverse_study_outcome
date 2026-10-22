package com.ss.ugc.live.barrage.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class StrokeTextBarrage extends TextBarrage {
    public static final /* synthetic */ KProperty[] G = null;
    public final Lazy C;
    public final float D;
    public final int E;
    public final int F;

    static {
        G = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StrokeTextBarrage.class), "strokedTextPaint", "getStrokedTextPaint()Landroid/graphics/Paint;"))};
    }

    @Override // com.ss.ugc.live.barrage.barrage.TextBarrage, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final Bitmap h() {
        return null;
    }

    @Override // com.ss.ugc.live.barrage.barrage.TextBarrage, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public final void k() {
        Lazy r0 = this.C;
        KProperty r1 = G[0];
        r((Paint) r0.getValue());
    }

    @Override // com.ss.ugc.live.barrage.barrage.TextBarrage, com.ss.ugc.live.barrage.barrage.AbsBarrage
    public void g(Canvas r7) {
        float r2 = 0;
        if (this.D <= r2) goto L9;
        String r0 = this.w;
        RectF r3 = this.f;
        float r4 = r3.left;
        float r5 = this.s;
        if (r5 > r2) goto L8;
        r5 = this.m.b;
    L8:
        float r6 = (r3.bottom - this.u) + this.m.c;
        Lazy r8 = this.C;
        KProperty r1 = G[0];
        r7.drawText(r0, r4 + r5, r6, (Paint) r8.getValue());
    L9:
        super.g(r7);
    }

    public StrokeTextBarrage(String r1, final float r2, int r3, final Typeface r4, float r5, final AbsBarrage.b r6, float r7, int r8, int r9) {
        super(r1, r2, r3, r4, r5, r6);
        this.D = r7;
        this.E = r8;
        this.F = r9;
        this.C = LazyKt.lazy(LazyThreadSafetyMode.NONE, new StrokeTextBarrage$strokedTextPaint$2(this, r2, r4, r6));
    }
}
