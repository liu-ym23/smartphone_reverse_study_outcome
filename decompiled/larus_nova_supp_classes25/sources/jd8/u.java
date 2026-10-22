package jd8;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u extends Drawable {
    public final Drawable a;
    public boolean b;
    public int c;
    public ValueAnimator d;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    public u(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "shadow");
        this.a = r2;
        this.c = 255;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.b == false) goto L5;
        return;
    L5:
        this.a.setBounds(getBounds());
        if (this.c >= 255) goto L8;
        int r0 = this.a.getAlpha();
        this.a.setAlpha((this.c * r0) / 255);
        this.a.draw(r5);
        this.a.setAlpha(r0);
        return;
    L8:
        this.a.draw(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
    }
}
