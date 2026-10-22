package com.larus.camera.impl.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001.B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0012H\u0016J0\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0014J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0010J\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020$J\b\u0010,\u001a\u00020\u001dH\u0002J\f\u0010-\u001a\u00020\u0010*\u00020\u0010H\u0002R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/camera/impl/widget/CaptureFocusFrame;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cornerBitmaps", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "cornerMatrix", "Landroid/graphics/Matrix;", "[Landroid/graphics/Matrix;", "imageSize", "", "currentDegree", "", "viewWidth", "viewHeight", "drawableMargin", "bitmapPaint", "Landroid/graphics/Paint;", "animator", "Landroid/animation/ValueAnimator;", "customRectSizeCalculator", "Lcom/larus/camera/impl/widget/RectSizeCalculator;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "onLayout", "changed", "", "left", "top", "right", "bottom", "rotateTo", "degrees", "animate", "calCornerPosition", "degree2Valid", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureFocusFrame extends FrameLayout {
    public static int j;
    public static int k;
    public final Bitmap[] a;
    public final Matrix[] b;
    public final int c;
    public float d;
    public int e;
    public int f;
    public final int g;
    public final Paint h;
    public ValueAnimator i;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.b != null) goto L5;
        return;
    L5:
        Float r0 = Float.valueOf(this.e);
        if (r0.floatValue() <= 0.0f) goto L8;
        boolean r1 = true;
    L9:
        Float r5 = null;
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L23;
        float r2 = r0.floatValue();
        Float r3 = Float.valueOf(this.f);
        if (r3.floatValue() <= 0.0f) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        r5 = r3;
    L20:
        if (r5 == null) goto L24;
        r5.floatValue();
        float r6 = 2;
        float r7 = getMeasuredWidth() / r6;
        float r8 = getMeasuredHeight() / r6;
        Math.abs(this.d);
        float r9 = r2 - (this.g * 2);
        int r10 = (int) r9;
        j = r10;
        k = r10;
        Matrix r11 = this.b[0];
        r11.reset();
        float r12 = r9 / r6;
        float r13 = r7 - r12;
        float r14 = r8 - r12;
        r11.setTranslate(r13, r14);
        r11.postRotate(this.d, r7, r8);
        Matrix r15 = this.b[1];
        r15.reset();
        float r16 = r7 + r12;
        r15.setTranslate(r16 - this.c, r14);
        r15.postRotate(this.d, r7, r8);
        Matrix r17 = this.b[2];
        r17.reset();
        int r18 = this.c;
        float r19 = r12 + r8;
        r17.setTranslate(r16 - r18, r19 - r18);
        r17.postRotate(this.d, r7, r8);
        Matrix r20 = this.b[3];
        r20.reset();
        r20.setTranslate(r13, r19 - this.c);
        r20.postRotate(this.d, r7, r8);
        return;
    L24:
        return;
    L17:
        r4 = false;
        goto L18
    L23:
        return;
    L8:
        r1 = false;
        goto L9
    }

    public CaptureFocusFrame(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        Bitmap[] r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L11;
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        r6.drawBitmap(this.a[r2], this.b[r2], this.h);
        r2 = r2 + 1;
        goto L7
    L12:
        return;
    }

    @Override // android.view.View
    public void setAlpha(float r3) {
        super.setAlpha(r3);
        this.h.setAlpha((int) (r3 * 255));
    }

    public CaptureFocusFrame(Context r12, AttributeSet r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13);
        Bitmap[] r1 = null;
        this.g = i5.y0(v19.c.b(2130971481, null, 2131167332));
        this.h = new Paint();
        Drawable r2 = ContextCompat.getDrawable(r12, 2131240699);
        if (r2 == null) goto L5;
        Bitmap r14 = DrawableKt.toBitmap$default(r2, 0, 0, null, 7, null);
    L7:
        if (r14 == null) goto L18;
        this.c = r14.getWidth();
        Matrix[] r3 = new Matrix[4];
        int r4 = 0;
    L9:
        if (r4 >= 4) goto L11;
        r3[r4] = new Matrix();
        r4 = r4 + 1;
        goto L9
    L11:
        this.b = r3;
        Matrix r5 = new Matrix();
        Bitmap[] r9 = new Bitmap[4];
        int r10 = 0;
    L12:
        if (r10 >= 4) goto L17;
        if (r10 != 0) goto L15;
        Bitmap r6 = r14;
    L16:
        r9[r10] = r6;
        r10 = r10 + 1;
        goto L12
    L15:
        r5.postRotate(90.0f);
        r6 = Bitmap.createBitmap(r14, 0, 0, r14.getWidth(), r14.getHeight(), r5, true);
        Intrinsics.checkNotNull(r6);
        goto L16
    L17:
        r1 = r9;
    L19:
        this.a = r1;
        setWillNotDraw(false);
        return;
    L18:
        this.c = 0;
        this.b = null;
        goto L19
    L5:
        r14 = null;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (getMeasuredHeight() == this.f) goto L5;
    L6:
        this.e = getMeasuredWidth();
        this.f = getMeasuredHeight();
        a();
        return;
    L5:
        if (getMeasuredWidth() != this.e) goto L6;
    }
}
