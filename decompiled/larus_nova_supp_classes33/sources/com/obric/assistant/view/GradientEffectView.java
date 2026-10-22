package com.obric.assistant.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u0012J\b\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\u001cH\u0014J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u00020\u001cH\u0014J\u0006\u0010,\u001a\u00020\u001cJ\u0006\u0010-\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\rJ\u000e\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\rJ\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\rH\u0016J\u000e\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\rJ\u0006\u00106\u001a\u00020\u000bJ\u0006\u00107\u001a\u00020\rJ\u0006\u00108\u001a\u00020\rJ\u0006\u00109\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/assistant/view/GradientEffectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shape", "Lcom/obric/assistant/view/GradientEffectView$Shape;", "cornerRadius", "", "blurRadius", "animationSpeed", "rotationAngle", "animationRunning", "", "lastFrameUptimeMs", "", "rectF", "Landroid/graphics/RectF;", "gradientMatrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "updateGradientShader", "toCancel", "updateGradientMatrix", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawFrame", "onAttachedToWindow", "onVisibilityAggregated", "isVisible", "onDetachedFromWindow", "startAnimation", "stopAnimation", "setShape", "setCornerRadius", "radius", "setBlurRadius", "setAlpha", "alpha", "setAnimationSpeed", "factor", "getShape", "getCornerRadius", "getBlurRadius", "getAnimationSpeed", "Shape", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GradientEffectView extends View {
    public static final int[] k = null;
    public Shape a;
    public float b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public long g;
    public final RectF h;
    public final Matrix i;
    public final Paint j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/view/GradientEffectView$Shape;", "", "<init>", "(Ljava/lang/String;I)V", "RECT", "OVAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Shape extends Enum<Shape> {
        public static final Shape OVAL = null;
        public static final Shape RECT = null;
        public static final /* synthetic */ Shape[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Shape> getEntries() {
            return b;
        }

        static {
            Shape r0 = new Shape("RECT", 0);
            RECT = r0;
            Shape r1 = new Shape("OVAL", 1);
            OVAL = r1;
            Shape[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Shape[] values() {
            return (Shape[]) a.clone();
        }

        public static Shape valueOf(String r1) {
            return (Shape) r27.a.a(Shape.class, r1);
        }

        public Shape(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Shape.values().length];
            r0[Shape.RECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Shape.OVAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public GradientEffectView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GradientEffectView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f = false;
        this.g = 0;
        super.onDetachedFromWindow();
    }

    static {
        String[] r0 = {"#5F85FF", "#FF9090", "#FEC183"};
        ArrayList r1 = new ArrayList(3);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= 3) goto L5;
        r1.add(Integer.valueOf(ColorProtector.parseColor(r0[r4])));
        r4 = r4 + 1;
        goto L3
    L5:
        k = CollectionsKt.toIntArray(r1);
        String[] r2 = {"#FF9595", "#FF9595", "#FF9595"};
        ArrayList r5 = new ArrayList(3);
    L6:
        if (r3 >= 3) goto L8;
        r5.add(Integer.valueOf(ColorProtector.parseColor(r2[r3])));
        r3 = r3 + 1;
        goto L6
    L8:
        CollectionsKt.toIntArray(r5);
    }

    public final void c() {
        Shader r0 = this.j.getShader();
        if (r0 == null) goto L6;
        this.i.reset();
        this.i.postRotate(this.e, getWidth() / 2.0f, getHeight() / 2.0f);
        r0.setLocalMatrix(this.i);
        return;
    }

    public final void b() {
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (isShown() == true) goto L7;
        return;
    L7:
        if (getWindowVisibility() == 0) goto L9;
        return;
    L9:
        if (getAlpha() > 0.0f) goto L11;
        return;
    L11:
        if (this.f == true) goto L18;
        this.f = true;
        this.g = SystemClock.uptimeMillis();
        postInvalidate();
        return;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    public final float getAnimationSpeed() {
        return this.d;
    }

    public final float getBlurRadius() {
        return this.c;
    }

    public final float getCornerRadius() {
        return this.b;
    }

    public final Shape getShape() {
        return this.a;
    }

    public final void a(Canvas r13) {
        super.onDraw(r13);
        float r0 = this.c;
        if (r0 <= 0.0f) goto L5;
        float r1 = r0 * 1.5f;
    L6:
        float r4 = 2 * r1;
        float r2 = getWidth() - r4;
        float r5 = getHeight() - r4;
        if (r2 > 0.0f) goto L9;
        return;
    L9:
        if (r5 > 0.0f) goto L12;
        return;
    L12:
        if (this.f == false) goto L14;
        long r6 = SystemClock.uptimeMillis();
        this.e = (this.e + (((this.d * 360.0f) * RangesKt.coerceAtLeast(r6 - this.g, 0)) / 5000)) % 360.0f;
        this.g = r6;
        c();
    L14:
        this.h.set(r1, r1, r2 + r1, r5 + r1);
        int r3 = b.a[this.a.ordinal()];
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L19;
        r13.drawOval(this.h, this.j);
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L20:
        RectF r7 = this.h;
        float r8 = this.b;
        r13.drawRoundRect(r7, r8, r8, this.j);
        return;
    L5:
        r1 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        a(r2);     // Catch: Throwable -> L8
        if (this.f == false) goto L15;
        postInvalidate();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (this.f == false) goto L12;
        postInvalidate();
    L12:
        throw th;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r3) {
        super.onVisibilityAggregated(r3);
        if (r3 == false) goto L5;
        b();
        return;
    L5:
        this.f = false;
        this.g = 0;
    }

    @Override // android.view.View
    public void setAlpha(float r3) {
        super.setAlpha(r3);
        if (r3 > 0.0f) goto L5;
        this.f = false;
        this.g = 0;
        return;
    L5:
        b();
    }

    public final void setAnimationSpeed(float r2) {
        this.d = Math.max(0.1f, r2);
    }

    public final void setBlurRadius(float r4) {
        this.c = r4;
        Paint r0 = this.j;
        if (r4 <= 0.0f) goto L5;
        BlurMaskFilter r1 = new BlurMaskFilter(r4, BlurMaskFilter.Blur.NORMAL);
    L6:
        r0.setMaskFilter(r1);
        invalidate();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setCornerRadius(float r1) {
        this.b = r1;
        invalidate();
    }

    public final void setShape(Shape r2) {
        Intrinsics.checkNotNullParameter(r2, "shape");
        this.a = r2;
        invalidate();
    }

    public GradientEffectView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = Shape.RECT;
        this.d = 1.0f;
        this.h = new RectF();
        this.i = new Matrix();
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        this.j = r5;
    }

    public /* synthetic */ GradientEffectView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r9, int r10, int r11, int r12) {
        super.onSizeChanged(r9, r10, r11, r12);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L10;
        Paint r13 = this.j;
        LinearGradient r14 = new LinearGradient(0.0f, 0.0f, getWidth(), 0.0f, k, new float[]{0.38f, 0.74f, 1.0f}, Shader.TileMode.CLAMP);
        c();
        r13.setShader(r14);
        return;
    }
}
