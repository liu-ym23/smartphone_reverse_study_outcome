package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0013J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0014J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010&\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\bH\u0016J0\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0014J\b\u00100\u001a\u00020\u0018H\u0002J\b\u00101\u001a\u00020\u0018H\u0014J\u0018\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000204H\u0016J\u0010\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u000208H\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/ImageContainerView;", "Lcom/larksuite/component/ui/layout/LKUIRoundableLayout;", "Landroid/graphics/drawable/Drawable$Callback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageDrawable", "Landroid/graphics/drawable/Drawable;", "imageMatrix", "Landroid/graphics/Matrix;", "imageDrawMatrix", "imageWidth", "imageHeight", "imageScaleType", "Landroid/widget/ImageView$ScaleType;", "tempSrc", "Landroid/graphics/RectF;", "tempDst", "setImageDrawable", BuildConfig.FLAVOR, "drawable", "setScaleType", "scaleType", "verifyDrawable", BuildConfig.FLAVOR, "who", "jumpDrawablesToCurrentState", "invalidateDrawable", "hasOverlappingRendering", "setSelected", "selected", "setImageMatrix", "matrix", "updateDrawable", "resizeFromDrawable", "onRtlPropertiesChanged", "layoutDirection", "onLayout", "changed", "left", "top", "right", "bottom", "configureBounds", "drawableStateChanged", "drawableHotspotChanged", "x", BuildConfig.FLAVOR, "y", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageContainerView extends LKUIRoundableLayout implements Drawable.Callback {
    public Drawable r;
    public final Matrix s;
    public Matrix t;
    public int u;
    public int v;
    public ImageView.ScaleType w;
    public final RectF x;
    public final RectF y;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            r0[ImageView.ScaleType.FIT_XY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ImageView.ScaleType.FIT_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public ImageContainerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageContainerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        Drawable r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        ImageView.ScaleType r1 = this.w;
        int r2 = this.u;
        int r3 = this.v;
        int r4 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r5 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r2 < 0) goto L8;
        if (r4 == r2) goto L8;
    L11:
        boolean r8 = false;
    L13:
        Matrix.ScaleToFit r9 = null;
        Matrix r10 = null;
        if (r2 <= 0) goto L62;
        if (r3 <= 0) goto L62;
        if (ImageView.ScaleType.FIT_XY == r1) goto L62;
        r0.setBounds(0, 0, r2, r3);
        if (ImageView.ScaleType.MATRIX == r1) goto L22;
        if (r8 == false) goto L29;
        this.t = null;
        return;
    L29:
        if (ImageView.ScaleType.CENTER != r1) goto L31;
        Matrix r6 = this.s;
        r6.setTranslate(Math.round((r4 - r2) * 0.5f), Math.round((r5 - r3) * 0.5f));
        this.t = r6;
        return;
    L31:
        float r11 = 0.0f;
        if (ImageView.ScaleType.CENTER_CROP != r1) goto L39;
        Matrix r7 = this.s;
        if ((r2 * r5) <= (r4 * r3)) goto L36;
        float r12 = r5 / r3;
        r11 = (r4 - (r2 * r12)) * 0.5f;
        float r13 = 0.0f;
    L37:
        r7.setScale(r12, r12);
        r7.postTranslate(Math.round(r11), Math.round(r13));
        this.t = r7;
        return;
    L36:
        r12 = r4 / r2;
        r13 = (r5 - (r3 * r12)) * 0.5f;
        goto L37
    L39:
        if (ImageView.ScaleType.CENTER_INSIDE != this.w) goto L46;
        Matrix r14 = this.s;
        if (r2 > r4) goto L44;
        if (r3 > r5) goto L44;
        float r15 = 1.0f;
    L45:
        float r16 = Math.round((r4 - (r2 * r15)) * 0.5f);
        float r17 = Math.round((r5 - (r3 * r15)) * 0.5f);
        r14.setScale(r15, r15);
        r14.postTranslate(r16, r17);
        this.t = r14;
        return;
    L44:
        r15 = (float) Math.min(r4 / r2, r5 / r3);
        goto L45
    L46:
        Matrix r18 = this.s;
        int r19 = b.a[r1.ordinal()];
        if (r19 != 1) goto L49;
        r9 = Matrix.ScaleToFit.FILL;
    L59:
        if (r9 == null) goto L61;
        this.x.set(0.0f, 0.0f, r2, r3);
        this.y.set(0.0f, 0.0f, r4, r5);
        r18.setRectToRect(this.x, this.y, r9);
    L61:
        this.t = r18;
        return;
    L49:
        if (r19 != 2) goto L51;
        r9 = Matrix.ScaleToFit.START;
        goto L59
    L51:
        if (r19 != 3) goto L53;
        r9 = Matrix.ScaleToFit.CENTER;
        goto L59
    L53:
        if (r19 != 4) goto L59;
        r9 = Matrix.ScaleToFit.END;
        goto L59
    L22:
        if (this.s.isIdentity() == true) goto L25;
        r10 = this.s;
    L25:
        this.t = r10;
        return;
    L62:
        r0.setBounds(0, 0, r4, r5);
        this.t = null;
        return;
    L8:
        if (r3 < 0) goto L12;
        if (r5 != r3) goto L11;
    L12:
        r8 = true;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void drawableStateChanged() {
        super/*android.widget.FrameLayout*/.drawableStateChanged();
        Drawable r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isStateful() == true) goto L7;
        return;
    L7:
        if (r0.setState(getDrawableState()) == false) goto L12;
        invalidateDrawable(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean hasOverlappingRendering() {
        Drawable r0 = getBackground();
        if (r0 == null) goto L5;
        Drawable r1 = r0.getCurrent();
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void jumpDrawablesToCurrentState() {
        super/*android.widget.FrameLayout*/.jumpDrawablesToCurrentState();
        Drawable r0 = this.r;
        if (r0 == null) goto L6;
        r0.jumpToCurrentState();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        if (r3 != this.r) goto L11;
        int r0 = r3.getIntrinsicWidth();
        int r4 = r3.getIntrinsicHeight();
        if (r0 == this.u) goto L7;
    L8:
        this.u = r0;
        this.v = r4;
        f();
    L9:
        invalidate();
        return;
    L7:
        if (r4 == this.v) goto L9;
    L11:
        super/*android.widget.FrameLayout*/.invalidateDrawable(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super/*android.widget.FrameLayout*/.onDraw(r5);
        Drawable r0 = this.r;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = this.u;
        int r2 = this.v;
        if (r1 == 0) goto L27;
        if (r2 != 0) goto L10;
        return;
    L10:
        if (this.t == null) goto L12;
    L17:
        int r3 = r5.save();
        r5.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L24
        Matrix r4 = this.t;     // Catch: Throwable -> L24
        if (r4 == null) goto L21;
        r5.concat(r4);     // Catch: Throwable -> L24
    L21:
        r0.draw(r5);     // Catch: Throwable -> L24
        r5.restoreToCount(r3);
        return;
    L24:
        th = move-exception;
        r5.restoreToCount(r3);
        throw th;
    L12:
        if (getPaddingTop() != 0) goto L17;
        if (getPaddingLeft() != 0) goto L17;
        r0.draw(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRtlPropertiesChanged(int r2) {
        super/*android.widget.FrameLayout*/.onRtlPropertiesChanged(r2);
        Drawable r0 = this.r;
        if (r0 == null) goto L6;
        DrawableCompat.setLayoutDirection(r0, r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setImageDrawable(Drawable r5) {
        Drawable r0 = this.r;
        if (r0 != r5) goto L5;
        return;
    L5:
        int r1 = this.u;
        int r2 = this.v;
        if (r0 == null) goto L8;
        r0.setCallback(null);
        unscheduleDrawable(r0);
    L8:
        this.r = r5;
        if (r5 == null) goto L14;
        r5.setCallback(this);
        DrawableCompat.setLayoutDirection(r5, getLayoutDirection());
        if (r5.isStateful() == false) goto L13;
        r5.setState(getDrawableState());
    L13:
        this.u = r5.getIntrinsicWidth();
        this.v = r5.getIntrinsicHeight();
        f();
    L16:
        if (r1 == this.u) goto L18;
    L19:
        requestLayout();
    L20:
        invalidate();
        return;
    L18:
        if (r2 == this.v) goto L20;
    L14:
        this.v = -1;
        this.u = -1;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setImageMatrix(Matrix r2) {
        if (r2 != null) goto L4;
    L6:
        if (r2 == null) goto L8;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(this.s, r2) == true) goto L15;
    L12:
        this.s.set(r2);
        f();
        invalidate();
        return;
    L15:
        return;
    L8:
        if (this.s.isIdentity() == false) goto L12;
    L4:
        if (r2.isIdentity() == false) goto L6;
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setScaleType(ImageView.ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        if (this.w != r2) goto L5;
        return;
    L5:
        this.w = r2;
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r3) {
        super/*android.widget.FrameLayout*/.setSelected(r3);
        Drawable r4 = this.r;
        if (r4 == null) goto L16;
        int r0 = r4.getIntrinsicWidth();
        if (r0 >= 0) goto L7;
        r0 = this.u;
    L7:
        int r5 = r4.getIntrinsicHeight();
        if (r5 >= 0) goto L11;
        r5 = this.v;
    L11:
        if (r0 == this.u) goto L13;
    L14:
        this.u = r0;
        this.v = r5;
        requestLayout();
        return;
    L13:
        if (r5 != this.v) goto L14;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (r2 != this.r) goto L5;
    L8:
        return true;
    L5:
        if (super/*android.widget.FrameLayout*/.verifyDrawable(r2) == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void drawableHotspotChanged(float r2, float r3) {
        super/*android.widget.FrameLayout*/.drawableHotspotChanged(r2, r3);
        Drawable r0 = this.r;
        if (r0 == null) goto L6;
        r0.setHotspot(r2, r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageContainerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.s = new Matrix();
        this.w = ImageView.ScaleType.FIT_CENTER;
        this.x = new RectF();
        this.y = new RectF();
        setWillNotDraw(false);
    }

    public /* synthetic */ ImageContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.FrameLayout*/.onLayout(r1, r2, r3, r4, r5);
        f();
    }
}
