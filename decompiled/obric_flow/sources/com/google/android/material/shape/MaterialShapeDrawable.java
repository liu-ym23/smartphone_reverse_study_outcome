package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint = null;
    private final BitSet containsIncompatibleShadowOp;
    private final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    private MaterialShapeDrawableState drawableState;
    private final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;

    @NonNull
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;

    @NonNull
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;

    @Nullable
    private PorterDuffColorFilter strokeTintFilter;

    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class MaterialShapeDrawableState extends Drawable.ConstantState {
        int alpha;

        @Nullable
        ColorFilter colorFilter;
        float elevation;

        @Nullable
        ElevationOverlayProvider elevationOverlayProvider;

        @Nullable
        ColorStateList fillColor;
        float interpolation;

        @Nullable
        Rect padding;
        Paint.Style paintStyle;
        float parentAbsoluteElevation;
        float scale;
        int shadowCompatMode;
        int shadowCompatOffset;
        int shadowCompatRadius;
        int shadowCompatRotation;

        @NonNull
        ShapeAppearanceModel shapeAppearanceModel;

        @Nullable
        ColorStateList strokeColor;

        @Nullable
        ColorStateList strokeTintList;
        float strokeWidth;

        @Nullable
        ColorStateList tintList;

        @Nullable
        PorterDuff.Mode tintMode;
        float translationZ;
        boolean useTintColorForShadow;

        public MaterialShapeDrawableState(@NonNull ShapeAppearanceModel r5, @Nullable ElevationOverlayProvider r10) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r5;
            this.elevationOverlayProvider = r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable r5 = new MaterialShapeDrawable(this);
            MaterialShapeDrawable.access$302(r5, true);
            return r5;
        }

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState r5) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r5.shapeAppearanceModel;
            this.elevationOverlayProvider = r5.elevationOverlayProvider;
            this.strokeWidth = r5.strokeWidth;
            this.colorFilter = r5.colorFilter;
            this.fillColor = r5.fillColor;
            this.strokeColor = r5.strokeColor;
            this.tintMode = r5.tintMode;
            this.tintList = r5.tintList;
            this.alpha = r5.alpha;
            this.scale = r5.scale;
            this.shadowCompatOffset = r5.shadowCompatOffset;
            this.shadowCompatMode = r5.shadowCompatMode;
            this.useTintColorForShadow = r5.useTintColorForShadow;
            this.interpolation = r5.interpolation;
            this.parentAbsoluteElevation = r5.parentAbsoluteElevation;
            this.elevation = r5.elevation;
            this.translationZ = r5.translationZ;
            this.shadowCompatRadius = r5.shadowCompatRadius;
            this.shadowCompatRotation = r5.shadowCompatRotation;
            this.strokeTintList = r5.strokeTintList;
            this.paintStyle = r5.paintStyle;
            if (r5.padding == null) goto L6;
            this.padding = new Rect(r5.padding);
            return;
        }
    }

    static {
        Paint r5 = new Paint(1);
        clearPaint = r5;
        r5.setColor(-1);
        r5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public static /* synthetic */ BitSet access$000(MaterialShapeDrawable r5) {
        return r5.containsIncompatibleShadowOp;
    }

    public static /* synthetic */ ShapePath.ShadowCompatOperation[] access$100(MaterialShapeDrawable r5) {
        return r5.cornerShadowOperation;
    }

    public static /* synthetic */ ShapePath.ShadowCompatOperation[] access$200(MaterialShapeDrawable r5) {
        return r5.edgeShadowOperation;
    }

    public static /* synthetic */ boolean access$302(MaterialShapeDrawable r5, boolean r10) {
        r5.pathDirty = r10;
        return r10;
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint r5, boolean r10) {
        if (r10 == false) goto L7;
        int r11 = r5.getColor();
        int r12 = compositeElevationOverlayIfNeeded(r11);
        this.resolvedTintColor = r12;
        if (r12 != r11) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r12, PorterDuff.Mode.SRC_IN);
    L7:
        return null;
    }

    private void calculatePath(@NonNull RectF r5, @NonNull Path r10) {
        calculatePathForSize(r5, r10);
        if (this.drawableState.scale == 1.0f) goto L5;
        this.matrix.reset();
        Matrix r11 = this.matrix;
        float r12 = this.drawableState.scale;
        r11.setScale(r12, r12, r5.width() / 2.0f, r5.height() / 2.0f);
        r10.transform(this.matrix);
    L5:
        r10.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        final float r5 = -getStrokeInsetLength();
        ShapeAppearanceModel r10 = getShapeAppearanceModel().withTransformedCornerSizes(new AnonymousClass2(this, r5));
        this.strokeShapeAppearance = r10;
        this.pathProvider.calculatePath(r10, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList r5, @NonNull PorterDuff.Mode r10, boolean r11) {
        int r12 = r5.getColorForState(getState(), 0);
        if (r11 == false) goto L5;
        r12 = compositeElevationOverlayIfNeeded(r12);
    L5:
        this.resolvedTintColor = r12;
        return new PorterDuffColorFilter(r12, r10);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList r5, @Nullable PorterDuff.Mode r10, @NonNull Paint r11, boolean r12) {
        if (r5 == null) goto L7;
        if (r10 == null) goto L7;
        return calculateTintColorTintFilter(r5, r10, r12);
    L7:
        return calculatePaintColorTintFilter(r11, r12);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context r5) {
        return createWithElevationOverlay(r5, 0.0f);
    }

    private void drawCompatShadow(@NonNull Canvas r5) {
        if (this.containsIncompatibleShadowOp.cardinality() <= 0) goto L6;
        Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    L6:
        if (this.drawableState.shadowCompatOffset == 0) goto L8;
        r5.drawPath(this.path, this.shadowRenderer.getShadowPaint());
    L8:
        int r10 = 0;
    L10:
        if (r10 >= 4) goto L13;
        this.cornerShadowOperation[r10].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, r5);
        this.edgeShadowOperation[r10].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, r5);
        r10 = r10 + 1;
        goto L10
    L13:
        if (this.shadowBitmapDrawingEnable == false) goto L17;
        int r11 = getShadowOffsetX();
        int r12 = getShadowOffsetY();
        r5.translate(-r11, -r12);
        r5.drawPath(this.path, clearPaint);
        r5.translate(r11, r12);
        return;
    }

    private void drawFillShape(@NonNull Canvas r10) {
        drawShape(r10, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float r5 = getStrokeInsetLength();
        this.insetRectF.inset(r5, r5);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke() == true) goto L5;
        return 0.0f;
    L5:
        return this.strokePaint.getStrokeWidth() / 2.0f;
    }

    private boolean hasCompatShadow() {
        MaterialShapeDrawableState r5 = this.drawableState;
        int r10 = r5.shadowCompatMode;
        if (r10 != 1) goto L5;
    L11:
        return false;
    L5:
        if (r5.shadowCompatRadius <= 0) goto L11;
        if (r10 != 2) goto L9;
        return true;
    L9:
        if (requiresCompatShadow() == false) goto L11;
        return true;
    }

    private boolean hasFill() {
        Paint.Style r5 = this.drawableState.paintStyle;
        if (r5 != Paint.Style.FILL_AND_STROKE) goto L5;
    L8:
        return true;
    L5:
        if (r5 == Paint.Style.FILL) goto L8;
        return false;
    }

    private boolean hasStroke() {
        Paint.Style r5 = this.drawableState.paintStyle;
        if (r5 == Paint.Style.FILL_AND_STROKE) goto L7;
        if (r5 == Paint.Style.STROKE) goto L7;
    L9:
        return false;
    L7:
        if (this.strokePaint.getStrokeWidth() <= 0.0f) goto L9;
        return true;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@NonNull Canvas r10) {
        if (hasCompatShadow() == true) goto L5;
        return;
    L5:
        r10.save();
        prepareCanvasForShadow(r10);
        if (this.shadowBitmapDrawingEnable == true) goto L9;
        drawCompatShadow(r10);
        r10.restore();
        return;
    L9:
        int r5 = (int) (this.pathBounds.width() - getBounds().width());
        int r11 = (int) (this.pathBounds.height() - getBounds().height());
        if (r5 < 0) goto L15;
        if (r11 < 0) goto L15;
        Bitmap r12 = Bitmap.createBitmap(((this.drawableState.shadowCompatRadius * 2) + ((int) this.pathBounds.width())) + r5, ((this.drawableState.shadowCompatRadius * 2) + ((int) this.pathBounds.height())) + r11, Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(r12);
        float r14 = (getBounds().left - this.drawableState.shadowCompatRadius) - r5;
        float r15 = (getBounds().top - this.drawableState.shadowCompatRadius) - r11;
        r13.translate(-r14, -r15);
        drawCompatShadow(r13);
        r10.drawBitmap(r12, r14, r15, null);
        r12.recycle();
        r10.restore();
        return;
    L15:
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int modulateAlpha(int r5, int r10) {
        return ((r10 + (r10 >>> 7)) * r5) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas r5) {
        r5.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] r5) {
        if (this.drawableState.fillColor == null) goto L7;
        int r10 = this.fillPaint.getColor();
        int r11 = this.drawableState.fillColor.getColorForState(r5, r10);
        if (r10 == r11) goto L7;
        this.fillPaint.setColor(r11);
        boolean r12 = true;
    L9:
        if (this.drawableState.strokeColor == null) goto L14;
        int r13 = this.strokePaint.getColor();
        int r14 = this.drawableState.strokeColor.getColorForState(r5, r13);
        if (r13 == r14) goto L14;
        this.strokePaint.setColor(r14);
        return true;
    L14:
        return r12;
    L7:
        r12 = false;
        goto L9
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter r5 = this.tintFilter;
        PorterDuffColorFilter r10 = this.strokeTintFilter;
        MaterialShapeDrawableState r11 = this.drawableState;
        this.tintFilter = calculateTintFilter(r11.tintList, r11.tintMode, this.fillPaint, true);
        MaterialShapeDrawableState r12 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(r12.strokeTintList, r12.tintMode, this.strokePaint, false);
        MaterialShapeDrawableState r13 = this.drawableState;
        if (r13.useTintColorForShadow == false) goto L6;
        this.shadowRenderer.setShadowColor(r13.tintList.getColorForState(getState(), 0));
    L6:
        if (ObjectsCompat.equals(r5, this.tintFilter) == true) goto L8;
        return true;
    L8:
        if (ObjectsCompat.equals(r10, this.strokeTintFilter) == true) goto L11;
        return true;
    L11:
        return false;
    }

    private void updateZ() {
        float r5 = getZ();
        this.drawableState.shadowCompatRadius = (int) Math.ceil(0.75f * r5);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(r5 * SHADOW_OFFSET_MULTIPLIER);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF r10, @NonNull Path r11) {
        ShapeAppearancePathProvider r5 = this.pathProvider;
        MaterialShapeDrawableState r12 = this.drawableState;
        r5.calculatePath(r12.shapeAppearanceModel, r12.interpolation, r10, this.pathShadowListener, r11);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int compositeElevationOverlayIfNeeded(@ColorInt int r5) {
        float r10 = getZ();
        float r11 = getParentAbsoluteElevation() + r10;
        ElevationOverlayProvider r12 = this.drawableState.elevationOverlayProvider;
        if (r12 != null) goto L5;
        return r5;
    L5:
        return r12.compositeOverlayIfNeeded(r5, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int r10 = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(r10, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int r11 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(r11, this.drawableState.alpha));
        if (this.pathDirty == false) goto L5;
        calculateStrokePath();
        calculatePath(getBoundsAsRectF(), this.path);
        this.pathDirty = false;
    L5:
        maybeDrawCompatShadow(r5);
        if (hasFill() == false) goto L9;
        drawFillShape(r5);
    L9:
        if (hasStroke() == false) goto L11;
        drawStrokeShape(r5);
    L11:
        this.fillPaint.setAlpha(r10);
        this.strokePaint.setAlpha(r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas r10, @NonNull Paint r11, @NonNull Path r12, @NonNull RectF r13) {
        drawShape(r10, r11, r12, this.drawableState.shapeAppearanceModel, r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawStrokeShape(@NonNull Canvas r10) {
        drawShape(r10, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.alpha;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r5) {
        if (this.drawableState.shadowCompatMode != 2) goto L6;
        return;
    L6:
        if (isRoundRect() == false) goto L9;
        float r10 = getTopLeftCornerResolvedSize() * this.drawableState.interpolation;
        r5.setRoundRect(getBounds(), r10);
        return;
    L9:
        calculatePath(getBoundsAsRectF(), this.path);
        DrawableUtils.setOutlineToPath(r5, this.path);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r5) {
        Rect r10 = this.drawableState.padding;
        if (r10 == null) goto L7;
        r5.set(r10);
        return true;
    L7:
        return super.getPadding(r5);
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    @Deprecated
    public void getPathForSize(int r5, int r10, @NonNull Path r11) {
        calculatePathForSize(new RectF(0.0f, 0.0f, r5, r10), r11);
    }

    @ColorInt
    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        MaterialShapeDrawableState r5 = this.drawableState;
        return (int) (Math.sin(Math.toRadians(r5.shadowCompatRotation)) * r5.shadowCompatOffset);
    }

    public int getShadowOffsetY() {
        MaterialShapeDrawableState r5 = this.drawableState;
        return (int) (Math.cos(Math.toRadians(r5.shadowCompatRotation)) * r5.shadowCompatOffset);
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel r5 = getShapeAppearanceModel();
        if ((r5 instanceof ShapePathModel) == true) goto L7;
        return null;
    L7:
        return (ShapePathModel) r5;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect r5 = getBounds();
        this.transparentRegion.set(r5);
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        float r5 = getElevation();
        return getTranslationZ() + r5;
    }

    public void initializeElevationOverlay(Context r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        r10.elevationOverlayProvider = new ElevationOverlayProvider(r5);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider r5 = this.drawableState.elevationOverlayProvider;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isThemeElevationOverlayEnabled() == false) goto L7;
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.elevationOverlayProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPointInTransparentRegion(int r5, int r10) {
        return getTransparentRegion().contains(r5, r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int r5 = this.drawableState.shadowCompatMode;
        if (r5 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r5 == 2) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful() == true) goto L22;
        ColorStateList r5 = this.drawableState.tintList;
        if (r5 != null) goto L7;
    L8:
        ColorStateList r10 = this.drawableState.strokeTintList;
        if (r10 != null) goto L11;
    L12:
        ColorStateList r11 = this.drawableState.strokeColor;
        if (r11 != null) goto L15;
    L16:
        ColorStateList r12 = this.drawableState.fillColor;
        if (r12 != null) goto L19;
    L21:
        return false;
    L19:
        if (r12.isStateful() == false) goto L21;
    L15:
        if (r11.isStateful() == true) goto L22;
    L11:
        if (r10.isStateful() == true) goto L22;
    L7:
        if (r5.isStateful() == false) goto L8;
    L22:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        this.pathDirty = true;
        super.onBoundsChange(r5);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r5) {
        boolean r10 = updateColorsForState(r5);
        boolean r11 = updateTintFilter();
        if (r10 == true) goto L7;
        if (r11 == true) goto L7;
        boolean r12 = false;
    L8:
        if (r12 == false) goto L10;
        invalidateSelf();
    L10:
        return r12;
    L7:
        r12 = true;
        goto L8
    }

    public boolean requiresCompatShadow() {
        if (isRoundRect() == true) goto L7;
        this.path.isConvex();
        return false;
    L7:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.alpha == r5) goto L6;
        r10.alpha = r5;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r5) {
        this.drawableState.colorFilter = r5;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float r5) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(r5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean r5) {
        this.pathProvider.setEdgeIntersectionCheckEnable(r5);
    }

    public void setElevation(float r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.elevation == r5) goto L6;
        r10.elevation = r5;
        updateZ();
        return;
    }

    public void setFillColor(@Nullable ColorStateList r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.fillColor == r5) goto L6;
        r10.fillColor = r5;
        onStateChange(getState());
        return;
    }

    public void setInterpolation(float r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.interpolation == r5) goto L6;
        r10.interpolation = r5;
        this.pathDirty = true;
        invalidateSelf();
        return;
    }

    public void setPadding(int r5, int r10, int r11, int r12) {
        MaterialShapeDrawableState r13 = this.drawableState;
        if (r13.padding != null) goto L5;
        r13.padding = new Rect();
    L5:
        this.drawableState.padding.set(r5, r10, r11, r12);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style r5) {
        this.drawableState.paintStyle = r5;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.parentAbsoluteElevation == r5) goto L6;
        r10.parentAbsoluteElevation = r5;
        updateZ();
        return;
    }

    public void setScale(float r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.scale == r5) goto L6;
        r10.scale = r5;
        invalidateSelf();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean r5) {
        this.shadowBitmapDrawingEnable = r5;
    }

    public void setShadowColor(int r5) {
        this.shadowRenderer.setShadowColor(r5);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.shadowCompatRotation == r5) goto L6;
        r10.shadowCompatRotation = r5;
        invalidateSelfIgnoreShape();
        return;
    }

    public void setShadowCompatibilityMode(int r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.shadowCompatMode == r5) goto L6;
        r10.shadowCompatMode = r5;
        invalidateSelfIgnoreShape();
        return;
    }

    @Deprecated
    public void setShadowElevation(int r5) {
        setElevation(r5);
    }

    @Deprecated
    public void setShadowEnabled(boolean r5) {
        setShadowCompatibilityMode(!r5 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int r5) {
        this.drawableState.shadowCompatRadius = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.shadowCompatOffset == r5) goto L6;
        r10.shadowCompatOffset = r5;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r5) {
        this.drawableState.shapeAppearanceModel = r5;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel r5) {
        setShapeAppearanceModel(r5);
    }

    public void setStroke(float r5, @ColorInt int r10) {
        setStrokeWidth(r5);
        setStrokeColor(ColorStateList.valueOf(r10));
    }

    public void setStrokeColor(@Nullable ColorStateList r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.strokeColor == r5) goto L6;
        r10.strokeColor = r5;
        onStateChange(getState());
        return;
    }

    public void setStrokeTint(ColorStateList r5) {
        this.drawableState.strokeTintList = r5;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float r5) {
        this.drawableState.strokeWidth = r5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r5) {
        setTintList(ColorStateList.valueOf(r5));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r5) {
        this.drawableState.tintList = r5;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.tintMode == r5) goto L6;
        r10.tintMode = r5;
        updateTintFilter();
        invalidateSelfIgnoreShape();
        return;
    }

    public void setTranslationZ(float r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.translationZ == r5) goto L6;
        r10.translationZ = r5;
        updateZ();
        return;
    }

    public void setUseTintColorForShadow(boolean r5) {
        MaterialShapeDrawableState r10 = this.drawableState;
        if (r10.useTintColorForShadow == r5) goto L6;
        r10.useTintColorForShadow = r5;
        invalidateSelf();
        return;
    }

    public void setZ(float r5) {
        setTranslationZ(r5 - getElevation());
    }

    public MaterialShapeDrawable(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        this(ShapeAppearanceModel.builder(r5, r10, r11, r12).build());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(@NonNull Context r5, float r10) {
        return createWithElevationOverlay(r5, r10, null);
    }

    private void drawShape(@NonNull Canvas r5, @NonNull Paint r10, @NonNull Path r11, @NonNull ShapeAppearanceModel r12, @NonNull RectF r13) {
        if (r12.isRoundRect(r13) == false) goto L5;
        float r14 = r12.getTopRightCornerSize().getCornerSize(r13) * this.drawableState.interpolation;
        r5.drawRoundRect(r13, r14, r14, r10);
        return;
    L5:
        r5.drawPath(r11, r10);
    }

    public void setCornerSize(@NonNull CornerSize r5) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(r5));
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel r5) {
        this(r5);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(@NonNull Context r5, float r10, @Nullable ColorStateList r11) {
        if (r11 != null) goto L4;
        r11 = ColorStateList.valueOf(MaterialColors.getColor(r5, R.attr.colorSurface, "MaterialShapeDrawable"));
    L4:
        MaterialShapeDrawable r12 = new MaterialShapeDrawable();
        r12.initializeElevationOverlay(r5);
        r12.setFillColor(r11);
        r12.setElevation(r10);
        return r12;
    }

    public void setStroke(float r5, @Nullable ColorStateList r10) {
        setStrokeWidth(r5);
        setStrokeColor(r10);
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel r5) {
        this(new MaterialShapeDrawableState(r5, null));
    }

    public void setStrokeTint(@ColorInt int r5) {
        setStrokeTint(ColorStateList.valueOf(r5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MaterialShapeDrawable(@NonNull MaterialShapeDrawableState r10) {
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint r5 = new Paint(1);
        this.fillPaint = r5;
        Paint r11 = new Paint(1);
        this.strokePaint = r11;
        this.shadowRenderer = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        ShapeAppearancePathProvider r12 = ShapeAppearancePathProvider.getInstance();
    L6:
        this.pathProvider = r12;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = r10;
        r11.setStyle(Paint.Style.STROKE);
        r5.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new AnonymousClass1(this);
        return;
    L5:
        r12 = new ShapeAppearancePathProvider();
        goto L6
    }
}
