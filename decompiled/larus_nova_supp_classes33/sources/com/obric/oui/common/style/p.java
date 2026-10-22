package com.obric.oui.common.style;

import android.R;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p extends DrawableWrapper implements Animatable {
    public final Paint a;
    public Bitmap b;
    public RectF c;
    public float d;
    public DisplayMetrics e;

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable r0 = getDrawable();
        if ((r0 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r0).isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable r0 = getDrawable();
        if ((r0 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r0).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable r0 = getDrawable();
        if ((r0 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r0).stop();
        return;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        int r0 = r6.saveLayer(this.c, this.a);
        super.draw(r6);
        Bitmap r1 = this.b;
        if (r1 == null) goto L6;
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r6.drawBitmap(r1, 0.0f, 0.0f, this.a);
        this.a.setXfermode(null);
    L6:
        r6.restoreToCount(r0);
    }

    public p(Drawable r3, DisplayMetrics r4) {
        Intrinsics.checkNotNullParameter(r3, "bg");
        Intrinsics.checkNotNullParameter(r4, "displayMetrics");
        Intrinsics.checkNotNullParameter(r3, "bg");
        super(r3);
        Paint r5 = new Paint(1);
        this.a = r5;
        this.d = 16.0f;
        r5.setStyle(Paint.Style.FILL);
        r5.setAntiAlias(true);
        this.e = r4;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void inflate(Resources r6, XmlPullParser r7, AttributeSet r8, Resources.Theme r9) {
        Intrinsics.checkNotNullParameter(r6, "r");
        Intrinsics.checkNotNullParameter(r7, "parser");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super.inflate(r6, r7, r8, r9);
        int r0 = r7.getDepth();
        this.e = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics());
        Drawable r1 = null;
    L3:
        int r2 = r7.next();
        if (r2 == 1) goto L19;
        if (r2 != 3) goto L10;
        if (r7.getDepth() <= r0) goto L19;
    L10:
        if (r2 != 2) goto L3;
        if (Intrinsics.areEqual(r7.getName(), "corners") == true) goto L13;
        r1 = DrawableWrapper.createFromXmlInner(r6, r7, r8, r9);
        goto L3
    L13:
        int[] r3 = {R.attr.radius};
        if (r9 != null) goto L16;
        TypedArray r4 = r6.obtainAttributes(r8, r3);
    L17:
        this.d = r4.getDimensionPixelSize(0, (int) this.d);
        goto L3
    L16:
        r4 = r9.obtainStyledAttributes(r8, r3, 0, 0);
    L19:
        if (r1 == null) goto L31;
        setDrawable(r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r6, int r7, int r8, int r9) {
        super.setBounds(r6, r7, r8, r9);
        RectF r0 = new RectF(r6, r7, r8, r9);
        if (Intrinsics.areEqual(r0, this.c) == true) goto L10;
        Bitmap r1 = this.b;
        if (r1 == null) goto L8;
        r1.recycle();
    L8:
        Bitmap r10 = Bitmap.createBitmap(this.e, r8 - r6, r9 - r7, Bitmap.Config.ARGB_8888);
        Canvas r11 = new Canvas(r10);
        float r12 = this.d;
        r11.drawRoundRect(r0, r12, r12, this.a);
        this.c = r0;
        this.b = r10;
        return;
    }
}
