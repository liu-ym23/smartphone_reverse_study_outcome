package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends Drawable implements i {
    public final Context a;
    public final Paint b;
    public final Paint c;
    public float d;
    public float e;
    public float f;
    public float g;
    public int h;
    public int i;
    public float j;
    public int k;

    public static final class a {
    }

    static {
    }

    public final Path b() {
        float r1 = 2;
        float r0 = this.e / r1;
        float r2 = d();
        RectF r3 = new RectF(getBounds().left + r0, (getBounds().top + this.g) + r0, getBounds().right - r0, getBounds().bottom - r0);
        Path r4 = new Path();
        float r5 = this.d;
        r4.addRoundRect(r3, r5, r5, Path.Direction.CCW);
        Path r6 = new Path();
        float r7 = r2 + r0;
        r6.moveTo(r7, r3.top);
        r6.lineTo((this.f + r2) - r0, r3.top);
        r6.lineTo(r2 + (this.f / r1), (r3.top - this.g) - r0);
        r6.lineTo(r7, r3.top);
        r4.op(r6, Path.Op.UNION);
        return r4;
    }

    public final Path c() {
        float r1 = 2;
        float r0 = this.e / r1;
        float r2 = d();
        RectF r3 = new RectF(getBounds().left + r0, getBounds().top + r0, getBounds().right - r0, (getBounds().bottom - this.g) - r0);
        Path r4 = new Path();
        float r5 = this.d;
        r4.addRoundRect(r3, r5, r5, Path.Direction.CCW);
        Path r6 = new Path();
        float r7 = r2 + r0;
        r6.moveTo(r7, r3.bottom);
        r6.lineTo((this.f + r2) - r0, r3.bottom);
        r6.lineTo(r2 + (this.f / r1), (r3.bottom + this.g) + r0);
        r6.lineTo(r7, r3.bottom);
        r4.op(r6, Path.Op.UNION);
        return r4;
    }

    public final float d() {
        int r0 = getBounds().left + MathKt.roundToInt(i.a.a(this, 7));
        int r2 = getBounds().right - MathKt.roundToInt(i.a.a(this, 7));
        float r1 = this.j;
        float r3 = r0;
        if (r1 < r3) goto L8;
        if (r1 > r2) goto L8;
        return r1;
    L8:
        return Math.min(Math.max(r3, r1), r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (getAlpha() != 255) goto L5;
        return -1;
    L5:
        return -3;
    }

    @Override // com.ss.android.lark.newemoji.emojioptions.i
    public final Context a() {
        return this.a;
    }

    public c(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r4;
        Paint r0 = new Paint();
        r0.setStyle(Paint.Style.FILL);
        r0.setAntiAlias(true);
        this.b = r0;
        Paint r1 = new Paint();
        r1.setStyle(Paint.Style.STROKE);
        r1.setAntiAlias(true);
        this.c = r1;
        this.d = i.a.a(this, 8);
        Resources r5 = r4.getResources();
        this.e = TypedValue.applyDimension(1, 0.5f, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()));
        this.f = i.a.a(this, 14);
        this.g = i.a.a(this, 7);
        this.h = ContextCompat.getColor(a(), 2131103351);
        this.i = ContextCompat.getColor(a(), 2131100557);
        this.k = 80;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        this.b.setColor(this.i);
        this.c.setColor(this.h);
        this.c.setStrokeWidth(this.e);
        if (this.k != 48) goto L5;
        Path r0 = c();
    L7:
        if (this.k != 48) goto L9;
        Path r1 = c();
    L10:
        r4.drawPath(r0, this.b);
        r4.drawPath(r1, this.c);
        return;
    L9:
        r1 = b();
        goto L10
    L5:
        r0 = b();
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.b.setAlpha(r2);
        this.c.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.b.setColorFilter(r2);
        this.c.setAlpha(getAlpha());
    }
}
