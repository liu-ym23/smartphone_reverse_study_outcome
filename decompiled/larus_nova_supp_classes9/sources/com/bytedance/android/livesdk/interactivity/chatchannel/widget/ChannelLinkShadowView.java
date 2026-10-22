package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class ChannelLinkShadowView extends ConstraintLayout {
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;

    public int getSuggestedMinimumHeight() {
        return 0;
    }

    public int getSuggestedMinimumWidth() {
        return 0;
    }

    public ChannelLinkShadowView(Context r2) {
        super(r2);
        this.j = true;
        R5(r2, null);
    }

    public void setInvalidateShadowOnSizeChanged(boolean r1) {
        this.j = r1;
    }

    public ChannelLinkShadowView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.j = true;
        R5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r5, AttributeSet r6) {
        int r1 = 0;
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130969051, 2130969639, 2130969903, 2130969904, 2130972507, 2130973788, 2130974026, 2130974030, 2130974623}, 0, 0);
        if (r7 != null) goto L28;
    L8:
        int r8 = (int) (this.b + Math.abs(this.d));
        int r9 = (int) (this.b + Math.abs(this.e));
        if (this.f == false) goto L11;
        int r0 = r8;
    L13:
        if (this.h == false) goto L15;
        int r2 = r9;
    L17:
        if (this.g == true) goto L21;
        r8 = 0;
    L21:
        if (this.i == false) goto L23;
        r1 = r9;
    L23:
        setPadding(r0, r2, r8, r1);
        return;
    L15:
        r2 = 0;
        goto L17
    L11:
        r0 = 0;
        goto L13
    L28:
        this.f = r7.getBoolean(4, true);     // Catch: Throwable -> L25
        this.g = r7.getBoolean(5, true);     // Catch: Throwable -> L25
        this.i = r7.getBoolean(0, true);     // Catch: Throwable -> L25
        this.h = r7.getBoolean(8, true);     // Catch: Throwable -> L25
        this.c = r7.getDimension(1, 0.0f);     // Catch: Throwable -> L25
        this.b = r7.getDimension(7, 0.0f);     // Catch: Throwable -> L25
        this.d = r7.getDimension(2, 0.0f);     // Catch: Throwable -> L25
        this.e = r7.getDimension(3, 0.0f);     // Catch: Throwable -> L25
        this.a = r7.getColor(6, getResources().getColor(2131108214));     // Catch: Throwable -> L25
        r7.recycle();
    L25:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(int r10, int r11) {
        float r0 = this.c;
        float r1 = this.b;
        float r2 = this.d;
        float r3 = this.e;
        int r4 = this.a;
        Bitmap r5 = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);
        Canvas r6 = new Canvas(r5);
        RectF r7 = new RectF(r1, r1, r10 - r1, r11 - r1);
        if (r3 <= 0.0f) goto L6;
        r7.top += r3;
        r7.bottom -= r3;
    L9:
        if (r2 <= 0.0f) goto L12;
        r7.left += r2;
        r7.right -= r2;
    L14:
        Paint r13 = new Paint();
        r13.setAntiAlias(true);
        r13.setColor(0);
        r13.setStyle(Paint.Style.FILL);
        if (isInEditMode() == true) goto L17;
        r13.setShadowLayer(r1, r2, r3, r4);
    L17:
        r6.drawRoundRect(r7, r0, r0, r13);
        setBackground(new BitmapDrawable(getResources(), r5));
        return;
    L12:
        if (r2 >= 0.0f) goto L14;
        r7.left += Math.abs(r2);
        r7.right -= Math.abs(r2);
        goto L14
    L6:
        if (r3 >= 0.0f) goto L9;
        r7.top += Math.abs(r3);
        r7.bottom -= Math.abs(r3);
        goto L9
    }

    public ChannelLinkShadowView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.j = true;
        R5(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 <= 0) goto L12;
        if (r2 > 0) goto L6;
        return;
    L6:
        if (getBackground() != null) goto L8;
    L10:
        S5(r1, r2);
        return;
    L8:
        if (this.j == true) goto L10;
        return;
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
