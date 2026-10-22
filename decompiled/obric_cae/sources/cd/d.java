package cd;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f3440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f3441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AdaptiveIconDrawable f3442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3443d;

    public d(AdaptiveIconDrawable r8, int r10, float r11) {
        this.f3442c = r8;
        this.f3443d = r11;
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.STROKE);
        r12.setColor(r10);
        r12.setStrokeWidth(r11);
        j r13 = j.f13877a;
        this.f3440a = r12;
        this.f3441b = r8.getIconMask();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r8) {
        i.f(r8, "canvas");
        this.f3442c.draw(r8);
        Path r10 = this.f3441b;
        if (r10 == null) goto L6;
        int r11 = r8.save();
        r8.clipPath(r10);
        Paint r12 = this.f3440a;
        r12.setStrokeWidth(this.f3443d * 2);
        r12.setStrokeJoin(Paint.Join.ROUND);
        r12.setStrokeCap(Paint.Cap.ROUND);
        r8.drawPath(r10, r12);
        r8.restoreToCount(r11);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f3442c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r8) {
        i.f(r8, "bounds");
        super.onBoundsChange(r8);
        this.f3442c.setBounds(r8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r8) {
        this.f3442c.setAlpha(r8);
        this.f3440a.setAlpha(r8);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r8) {
        this.f3442c.setColorFilter(r8);
        this.f3440a.setColorFilter(r8);
        invalidateSelf();
    }
}
