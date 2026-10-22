package epc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends Drawable {
    public final Drawable a;
    public final String b;
    public final Paint c;
    public final float d;
    public final float e;
    public final GradientDrawable f;
    public final float g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;

    /* JADX INFO: renamed from: epc.a$a, reason: collision with other inner class name */
    public static final class C0258a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        this.f.setBounds(getBounds());
        this.f.draw(r6);
        Drawable r0 = this.a;
        if (r0 == null) goto L5;
        r0.setBounds(this.h, this.i, this.j, this.k);
        this.a.draw(r6);
    L5:
        r6.drawText(this.b, (this.d / 2) + this.g, getBounds().exactCenterY() + this.e, this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.c.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.c.setColorFilter(r2);
        invalidateSelf();
    }

    public static float a(Context r1, float r2) {
        Resources r3 = r1.getResources();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
    }

    public a(Context r4, Drawable r5, String r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "text");
        this.a = r5;
        this.b = r6;
        Paint r0 = new Paint(1);
        r0.setColor(r8);
        r0.setTextSize(a(r4, 12.0f));
        r0.setTextAlign(Paint.Align.CENTER);
        this.c = r0;
        float r9 = r0.measureText(r6);
        this.d = r9;
        this.e = ((r0.getFontMetrics().bottom - r0.getFontMetrics().top) / 2) - r0.getFontMetrics().bottom;
        GradientDrawable r10 = new GradientDrawable();
        r10.setColor(r7);
        r10.setCornerRadius(a(r4, 4.0f));
        this.f = r10;
        if (r5 == null) goto L5;
        float r1 = a(r4, 18.0f);
    L6:
        this.g = r1 + a(r4, 4.0f);
        this.h = (int) a(r4, 8.0f);
        this.i = (int) (a(r4, 3.0f) + 0.5f);
        this.j = (int) a(r4, 20.0f);
        this.k = (int) a(r4, 15.0f);
        if (r5 == null) goto L9;
        float r11 = a(r4, 22.0f);
    L10:
        setBounds(new Rect((int) a(r4, 4.0f), 0, ((int) (r11 + r9)) + ((int) a(r4, 4.0f)), (int) a(r4, 18.0f)));
        return;
    L9:
        r11 = a(r4, 8.0f);
        goto L10
    L5:
        r1 = a(r4, 4.0f);
        goto L6
    }
}
