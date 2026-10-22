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
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f12512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f12513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f12514c;
    public float d;
    public DisplayMetrics e;

    public l(Drawable r5, DisplayMetrics r10) {
        Intrinsics.checkNotNullParameter(r5, "bg");
        Intrinsics.checkNotNullParameter(r10, "displayMetrics");
        Intrinsics.checkNotNullParameter(r5, "bg");
        super(r5);
        Paint r11 = new Paint(1);
        this.f12512a = r11;
        this.d = 16.0f;
        r11.setStyle(Paint.Style.FILL);
        r11.setAntiAlias(true);
        this.e = r10;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        RectF r10 = this.f12514c;
        Paint r11 = this.f12512a;
        int r12 = r5.saveLayer(r10, r11);
        super.draw(r5);
        Bitmap r13 = this.f12513b;
        if (r13 == null) goto L6;
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r5.drawBitmap(r13, 0.0f, 0.0f, r11);
        r11.setXfermode(null);
    L6:
        r5.restoreToCount(r12);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void inflate(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Intrinsics.checkNotNullParameter(r10, "r");
        Intrinsics.checkNotNullParameter(r11, "parser");
        Intrinsics.checkNotNullParameter(r12, "attrs");
        super.inflate(r10, r11, r12, r13);
        int r5 = r11.getDepth();
        this.e = r10.getDisplayMetrics();
        Drawable r14 = null;
    L3:
        int r15 = r11.next();
        if (r15 == 1) goto L19;
        if (r15 != 3) goto L10;
        if (r11.getDepth() <= r5) goto L19;
    L10:
        if (r15 != 2) goto L3;
        if (Intrinsics.areEqual(r11.getName(), "corners") == true) goto L13;
        r14 = Drawable.createFromXmlInner(r10, r11, r12, r13);
        goto L3
    L13:
        int[] r16 = {R.attr.radius};
        if (r13 != null) goto L16;
        TypedArray r17 = r10.obtainAttributes(r12, r16);
    L17:
        this.d = r17.getDimensionPixelSize(0, (int) this.d);
        goto L3
    L16:
        r17 = r13.obtainStyledAttributes(r12, r16, 0, 0);
    L19:
        if (r14 == null) goto L31;
        setDrawable(r14);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable r5 = getDrawable();
        if ((r5 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r5).isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int r10, int r11, int r12, int r13) {
        super.setBounds(r10, r11, r12, r13);
        RectF r5 = new RectF(r10, r11, r12, r13);
        if (Intrinsics.areEqual(r5, this.f12514c) == true) goto L10;
        Bitmap r14 = this.f12513b;
        if (r14 == null) goto L8;
        r14.recycle();
    L8:
        Bitmap r15 = Bitmap.createBitmap(this.e, r12 - r10, r13 - r11, Bitmap.Config.ARGB_8888);
        Canvas r16 = new Canvas(r15);
        float r17 = this.d;
        r16.drawRoundRect(r5, r17, r17, this.f12512a);
        this.f12514c = r5;
        this.f12513b = r15;
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable r5 = getDrawable();
        if ((r5 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r5).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable r5 = getDrawable();
        if ((r5 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r5).stop();
        return;
    }
}
