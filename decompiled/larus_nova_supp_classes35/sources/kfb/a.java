package kfb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.widget.span.BorderProperty;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a extends Drawable {
    public final Path a;
    public final RectF b;
    public final RectF c;
    public final Paint d;
    public final Matrix e;
    public final RectF f;
    public final Paint g;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        b r0 = (b) this;
        mfb.a r1 = r0.h;
        float r2 = r1.e;
        if (r2 >= 0.0f) goto L5;
        r2 = 0.0f;
    L5:
        float r4 = r1.f;
        if (r4 >= 0.0f) goto L8;
        r4 = 0.0f;
    L8:
        this.b.set(r2, r4, r1.b - r2, r1.c);
        Drawable r3 = r0.h.a;
        if ((r3 instanceof BitmapDrawable) == false) goto L23;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r5 = ((BitmapDrawable) r3).getBitmap();
        if (r5 == null) goto L23;
        if (r5.isRecycled() == true) goto L23;
        this.c.set(this.b);
        this.c.inset(r0.i.getBorderWidthPx(), r0.i.getBorderWidthPx());
        this.e.reset();
        float r6 = r0.h.g;
        if (r6 != 0.0f) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == true) goto L22;
        this.e.setScale(r6, r6);
    L22:
        Matrix r8 = this.e;
        mfb.a r9 = r0.h;
        r8.postTranslate(r9.e, r9.f);
        int r11 = r10.getSaveCount();
        r10.save();
        this.a.reset();
        this.a.addRoundRect(this.c, r0.i.getBorderRadiusPx(), r0.i.getBorderRadiusPx(), Path.Direction.CW);
        r10.clipPath(this.a);
        r10.drawBitmap(r5, this.e, this.d);
        r10.restoreToCount(r11);
        goto L23
    L19:
        r7 = false;
    L23:
        float r12 = r0.i.getBorderWidthPx() / 2;
        this.f.set(this.b);
        this.f.inset(r12, r12);
        this.g.setAntiAlias(true);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setColor(r0.i.getBorderColor());
        this.g.setStrokeWidth(r0.i.getBorderWidthPx());
        this.a.reset();
        this.a.addRoundRect(this.f, r0.i.getBorderRadiusPx(), r0.i.getBorderRadiusPx(), Path.Direction.CW);
        r10.drawPath(this.a, this.g);
    }

    public a(mfb.a r2, BorderProperty r3) {
        Intrinsics.checkNotNullParameter(r2, "drawableParams");
        Intrinsics.checkNotNullParameter(r3, "borderParams");
        this.a = new Path();
        this.b = new RectF();
        this.c = new RectF();
        this.d = new Paint(2);
        this.e = new Matrix();
        this.f = new RectF();
        this.g = new Paint();
    }
}
