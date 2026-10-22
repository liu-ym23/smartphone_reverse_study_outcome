package com.larus.camera.impl.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 92\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0016H\u0016J0\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u0014H\u0014J\u0006\u00100\u001a\u00020\u0012J\u000e\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0014J\u000e\u00103\u001a\u00020%2\u0006\u00104\u001a\u00020#J\u0016\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0007J\b\u00106\u001a\u00020%H\u0002J\f\u00107\u001a\u00020\u0014*\u00020\u0014H\u0002J\u0006\u00108\u001a\u00020%R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/camera/impl/widget/EduCaptureTipView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "recordViewSize", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "cornerBitmaps", "", "Landroid/graphics/Bitmap;", "[Landroid/graphics/Bitmap;", "cornerMatrix", "Landroid/graphics/Matrix;", "[Landroid/graphics/Matrix;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "imageSize", "", "currentDegree", "", "viewWidth", "viewHeight", "drawableMargin", "getDrawableMargin", "()I", "drawableMargin$delegate", "Lkotlin/Lazy;", "bitmapPaint", "Landroid/graphics/Paint;", "animator", "Landroid/animation/ValueAnimator;", "customRectSizeCalculator", "Lcom/larus/camera/impl/widget/RectSizeCalculator;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "onLayout", "changed", "left", "top", "right", "bottom", "getTextView", "rotateTo", "degrees", "customCalRectSize", "calculator", "animate", "calCornerPosition", "degree2Valid", "destroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduCaptureTipView extends FrameLayout {
    public static int l;
    public static int m;
    public final boolean a;
    public final Bitmap[] b;
    public final Matrix[] c;
    public final AppCompatTextView d;
    public final int e;
    public float f;
    public int g;
    public int h;
    public final Lazy i;
    public final Paint j;
    public ValueAnimator k;

    public static final class a {
        public static Pair a(Context r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (EduCaptureTipView.l != 0) goto L5;
        L11:
            int r0 = r3.getResources().getDimensionPixelSize(2131167532);
            int r1 = r3.getResources().getDimensionPixelSize(2131167531);
        L13:
            if ((r4 % 180) != 0) goto L16;
            return TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r1));
        L16:
            return TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r0));
        L5:
            if (EduCaptureTipView.m == 0) goto L11;
            int r5 = r3.getResources().getDimensionPixelSize(2131167530);
            int r2 = EduCaptureTipView.m;
            r1 = r2 / 3;
            if ((r4 % 180) != 0) goto L10;
            r2 = EduCaptureTipView.l;
        L10:
            r0 = r2 - (r5 * 2);
            goto L13
        }
    }

    static {
    }

    public EduCaptureTipView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 6);
    }

    public EduCaptureTipView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 4);
    }

    private final int getDrawableMargin() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final void a() {
        if (this.c != null) goto L5;
        return;
    L5:
        Float r0 = Float.valueOf(this.g);
        if (r0.floatValue() <= 0.0f) goto L8;
        boolean r1 = true;
    L9:
        Float r5 = null;
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L23;
        float r2 = r0.floatValue();
        Float r3 = Float.valueOf(this.h);
        if (r3.floatValue() <= 0.0f) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        r5 = r3;
    L20:
        if (r5 == null) goto L24;
        float r6 = r5.floatValue();
        float r7 = 2;
        float r8 = getMeasuredWidth() / r7;
        float r9 = getMeasuredHeight() / r7;
        float r10 = (r2 - ((r2 - r6) * (Math.abs(this.f) / 90))) - (getDrawableMargin() * 2);
        Matrix r11 = this.c[0];
        r11.reset();
        float r12 = r10 / r7;
        float r13 = r8 - r12;
        float r14 = (r6 / 3) / r7;
        float r15 = r9 - r14;
        r11.setTranslate(r13, r15);
        r11.postRotate(this.f, r8, r9);
        Matrix r16 = this.c[1];
        r16.reset();
        float r17 = r12 + r8;
        r16.setTranslate(r17 - this.e, r15);
        r16.postRotate(this.f, r8, r9);
        Matrix r18 = this.c[2];
        r18.reset();
        int r19 = this.e;
        float r20 = r14 + r9;
        r18.setTranslate(r17 - r19, r20 - r19);
        r18.postRotate(this.f, r8, r9);
        Matrix r21 = this.c[3];
        r21.reset();
        r21.setTranslate(r13, r20 - this.e);
        r21.postRotate(this.f, r8, r9);
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

    public final AppCompatTextView getTextView() {
        return this.d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        Bitmap[] r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c == null) goto L11;
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        r6.drawBitmap(this.b[r2], this.c[r2], this.j);
        r2 = r2 + 1;
        goto L7
    L12:
        return;
    }

    @Override // android.view.View
    public void setAlpha(float r3) {
        super.setAlpha(r3);
        this.j.setAlpha((int) (r3 * 255));
    }

    public EduCaptureTipView(Context r11, AttributeSet r12, int r13) {
        Bitmap[] r1 = null;
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        boolean r14 = true;
    L9:
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12);
        this.a = r14;
        this.d = new AppCompatTextView(r11);
        this.i = LazyKt.lazy(LazyThreadSafetyMode.NONE, new k());
        this.j = new Paint();
        Drawable r3 = ContextCompat.getDrawable(r11, 2131240699);
        if (r3 == null) goto L12;
        Bitmap r15 = DrawableKt.toBitmap$default(r3, 0, 0, null, 7, null);
    L13:
        if (r15 == null) goto L23;
        this.e = r15.getWidth();
        Matrix[] r16 = new Matrix[4];
        int r17 = 0;
    L15:
        if (r17 >= 4) goto L17;
        r16[r17] = new Matrix();
        r17 = r17 + 1;
        goto L15
    L17:
        this.c = r16;
        Matrix r18 = new Matrix();
        r1 = new Bitmap[4];
        int r19 = 0;
    L18:
        if (r19 >= 4) goto L24;
        if (r19 != 0) goto L21;
        Bitmap r4 = r15;
    L22:
        r1[r19] = r4;
        r19 = r19 + 1;
        goto L18
    L21:
        r18.postRotate(90.0f);
        r4 = Bitmap.createBitmap(r15, 0, 0, r15.getWidth(), r15.getHeight(), r18, true);
        Intrinsics.checkNotNull(r4);
    L24:
        this.b = r1;
        this.d.setGravity(17);
        View r110 = this.d;
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, -2);
        r111.gravity = 17;
        Unit r112 = Unit.INSTANCE;
        addView(r110, r111);
        setWillNotDraw(false);
        return;
    L23:
        this.e = 0;
        this.c = null;
        goto L24
    L12:
        r15 = null;
        goto L13
    L8:
        r14 = false;
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (getMeasuredHeight() == this.h) goto L5;
    L6:
        this.g = getMeasuredWidth();
        this.h = getMeasuredHeight();
        if (this.a == false) goto L9;
        l = getMeasuredWidth();
        m = getMeasuredHeight();
    L14:
        a();
        return;
    L9:
        int r6 = m;
        if (r6 == 0) goto L14;
        int r7 = l;
        if (r7 == 0) goto L14;
        this.g = r7;
        this.h = r6;
        goto L14
    L5:
        if (getMeasuredWidth() != this.g) goto L6;
    }
}
