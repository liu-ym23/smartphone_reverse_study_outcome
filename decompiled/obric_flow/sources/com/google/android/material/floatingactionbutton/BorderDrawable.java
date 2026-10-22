package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class BorderDrawable extends Drawable {
    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;

    @Nullable
    private ColorStateList borderTint;

    @Dimension
    float borderWidth;

    @ColorInt
    private int bottomInnerStrokeColor;

    @ColorInt
    private int bottomOuterStrokeColor;
    private final RectF boundsRectF;

    @ColorInt
    private int currentBorderTintColor;
    private boolean invalidateShader;

    @NonNull
    private final Paint paint;
    private final ShapeAppearancePathProvider pathProvider;
    private final Rect rect;
    private final RectF rectF;
    private ShapeAppearanceModel shapeAppearanceModel;
    private final Path shapePath;
    private final BorderState state;

    @ColorInt
    private int topInnerStrokeColor;

    @ColorInt
    private int topOuterStrokeColor;

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.BorderDrawable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class BorderState extends Drawable.ConstantState {
        final /* synthetic */ BorderDrawable this$0;

        private BorderState(BorderDrawable r5) {
            this.this$0 = r5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return this.this$0;
        }

        public /* synthetic */ BorderState(BorderDrawable r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public BorderDrawable(ShapeAppearanceModel r5) {
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
        this.shapePath = new Path();
        this.rect = new Rect();
        this.rectF = new RectF();
        this.boundsRectF = new RectF();
        this.state = new BorderState(this, null);
        this.invalidateShader = true;
        this.shapeAppearanceModel = r5;
        Paint r10 = new Paint(1);
        this.paint = r10;
        r10.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader createGradientShader() {
        Rect r5 = this.rect;
        copyBounds(r5);
        float r10 = this.borderWidth / r5.height();
        return new LinearGradient(0.0f, r5.top, 0.0f, r5.bottom, new int[]{ColorUtils.compositeColors(this.topOuterStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.topInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomInnerStrokeColor, this.currentBorderTintColor), ColorUtils.compositeColors(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0.0f, r10, 0.5f, 0.5f, 1.0f - r10, 1.0f}, Shader.TileMode.CLAMP);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        if (this.invalidateShader == false) goto L5;
        this.paint.setShader(createGradientShader());
        this.invalidateShader = false;
    L5:
        float r10 = this.paint.getStrokeWidth() / 2.0f;
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        float r11 = Math.min(this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF()), this.rectF.width() / 2.0f);
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) == false) goto L9;
        this.rectF.inset(r10, r10);
        r5.drawRoundRect(this.rectF, r11, r11, this.paint);
        return;
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.boundsRectF.set(getBounds());
        return this.boundsRectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.borderWidth <= 0.0f) goto L5;
        return -3;
    L5:
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r10) {
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) == false) goto L6;
        float r5 = this.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
        r10.setRoundRect(getBounds(), r5);
        return;
    L6:
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.rectF, this.shapePath);
        DrawableUtils.setOutlineToPath(r10, this.shapePath);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r5) {
        if (this.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) == false) goto L7;
        int r10 = Math.round(this.borderWidth);
        r5.set(r10, r10, r10, r10);
        return true;
    L7:
        return true;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r5 = this.borderTint;
        if (r5 == null) goto L7;
        if (r5.isStateful() == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isStateful() == true) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        this.invalidateShader = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r5) {
        ColorStateList r10 = this.borderTint;
        if (r10 == null) goto L8;
        int r11 = r10.getColorForState(r5, this.currentBorderTintColor);
        if (r11 == this.currentBorderTintColor) goto L8;
        this.invalidateShader = true;
        this.currentBorderTintColor = r11;
    L8:
        if (this.invalidateShader == false) goto L11;
        invalidateSelf();
    L11:
        return this.invalidateShader;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r5) {
        this.paint.setAlpha(r5);
        invalidateSelf();
    }

    public void setBorderTint(@Nullable ColorStateList r5) {
        if (r5 == null) goto L4;
        this.currentBorderTintColor = r5.getColorForState(getState(), this.currentBorderTintColor);
    L4:
        this.borderTint = r5;
        this.invalidateShader = true;
        invalidateSelf();
    }

    public void setBorderWidth(@Dimension float r5) {
        if (this.borderWidth == r5) goto L6;
        this.borderWidth = r5;
        this.paint.setStrokeWidth(r5 * DRAW_STROKE_WIDTH_MULTIPLE);
        this.invalidateShader = true;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r5) {
        this.paint.setColorFilter(r5);
        invalidateSelf();
    }

    public void setGradientColors(@ColorInt int r5, @ColorInt int r10, @ColorInt int r11, @ColorInt int r12) {
        this.topOuterStrokeColor = r5;
        this.topInnerStrokeColor = r10;
        this.bottomOuterStrokeColor = r11;
        this.bottomInnerStrokeColor = r12;
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel r5) {
        this.shapeAppearanceModel = r5;
        invalidateSelf();
    }
}
