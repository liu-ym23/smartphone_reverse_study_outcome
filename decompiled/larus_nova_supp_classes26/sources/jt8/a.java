package jt8;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends Drawable {
    public final Paint a;
    public Bitmap b;
    public int c;
    public int d;
    public int e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.d;
    }

    public a(Bitmap r3) {
        this.a = new Paint(2);
        this.c = 255;
        this.b = r3;
        if (r3 == null) goto L5;
        this.d = r3.getWidth();
        this.e = this.b.getHeight();
        return;
    L5:
        this.e = 0;
        this.d = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Bitmap r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L9;
        r5.drawBitmap(this.b, null, getBounds(), this.a);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.c = r2;
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r2) {
        this.a.setFilterBitmap(r2);
    }
}
