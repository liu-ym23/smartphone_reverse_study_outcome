package com.google.android.material.shape;

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
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, p {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint = null;
    private final BitSet containsIncompatibleShadowOp;
    private final n.f[] cornerShadowOperation;
    private a drawableState;
    private final n.f[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final m pathProvider;
    private final m.b pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final com.google.android.material.h.a shadowRenderer;
    private final Paint strokePaint;
    private l strokeShapeAppearance;
    private PorterDuffColorFilter strokeTintFilter;
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l f4038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.google.android.material.elevation.a f4039b;
        public ColorFilter c;
        public ColorStateList d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public a(a r3) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f4038a = r3.f4038a;
            this.f4039b = r3.f4039b;
            this.l = r3.l;
            this.c = r3.c;
            this.d = r3.d;
            this.e = r3.e;
            this.h = r3.h;
            this.g = r3.g;
            this.m = r3.m;
            this.j = r3.j;
            this.s = r3.s;
            this.q = r3.q;
            this.u = r3.u;
            this.k = r3.k;
            this.n = r3.n;
            this.o = r3.o;
            this.p = r3.p;
            this.r = r3.r;
            this.t = r3.t;
            this.f = r3.f;
            this.v = r3.v;
            if (r3.i == null) goto L6;
            this.i = new Rect(r3.i);
            return;
        }

        public a(l r3, com.google.android.material.elevation.a r4) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f4038a = r3;
            this.f4039b = r4;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            MaterialShapeDrawable r0 = new MaterialShapeDrawable(this, null);
            MaterialShapeDrawable.access$402(r0, true);
            return r0;
        }
    }

    static {
        Paint r0 = new Paint(1);
        clearPaint = r0;
        r0.setColor(-1);
        r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new l());
    }

    public MaterialShapeDrawable(Context r3, AttributeSet r4, int r5, int r6) {
        this(l.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, r6).a());
    }

    private MaterialShapeDrawable(a r6) {
        this.cornerShadowOperation = new n.f[4];
        this.edgeShadowOperation = new n.f[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint r0 = new Paint(1);
        this.fillPaint = r0;
        Paint r2 = new Paint(1);
        this.strokePaint = r2;
        this.shadowRenderer = new com.google.android.material.h.a();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        m r3 = m.a();
    L6:
        this.pathProvider = r3;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = r6;
        r2.setStyle(Paint.Style.STROKE);
        r0.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new AnonymousClass1(this);
        return;
    L5:
        r3 = new m();
        goto L6
    }

    /* synthetic */ MaterialShapeDrawable(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    public MaterialShapeDrawable(l r3) {
        this(new a(r3, null));
    }

    @Deprecated
    public MaterialShapeDrawable(o r1) {
        this(r1);
    }

    static /* synthetic */ BitSet access$000(MaterialShapeDrawable r0) {
        return r0.containsIncompatibleShadowOp;
    }

    static /* synthetic */ n.f[] access$100(MaterialShapeDrawable r0) {
        return r0.cornerShadowOperation;
    }

    static /* synthetic */ n.f[] access$200(MaterialShapeDrawable r0) {
        return r0.edgeShadowOperation;
    }

    static /* synthetic */ boolean access$402(MaterialShapeDrawable r0, boolean r1) {
        r0.pathDirty = r1;
        return r1;
    }

    private PorterDuffColorFilter calculatePaintColorTintFilter(Paint r1, boolean r2) {
        if (r2 == false) goto L7;
        int r3 = r1.getColor();
        int r4 = compositeElevationOverlayIfNeeded(r3);
        this.resolvedTintColor = r4;
        if (r4 != r3) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r4, PorterDuff.Mode.SRC_IN);
    L7:
        return null;
    }

    private void calculatePath(RectF r6, Path r7) {
        calculatePathForSize(r6, r7);
        if (this.drawableState.j == 1.0f) goto L5;
        this.matrix.reset();
        this.matrix.setScale(this.drawableState.j, this.drawableState.j, r6.width() / 2.0f, r6.height() / 2.0f);
        r7.transform(this.matrix);
    L5:
        r7.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        final float r0 = -getStrokeInsetLength();
        l r1 = getShapeAppearanceModel().a(new AnonymousClass2(this, r0));
        this.strokeShapeAppearance = r1;
        this.pathProvider.a(r1, this.drawableState.k, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    private PorterDuffColorFilter calculateTintColorTintFilter(ColorStateList r3, PorterDuff.Mode r4, boolean r5) {
        int r6 = r3.getColorForState(getState(), 0);
        if (r5 == false) goto L5;
        r6 = compositeElevationOverlayIfNeeded(r6);
    L5:
        this.resolvedTintColor = r6;
        return new PorterDuffColorFilter(r6, r4);
    }

    private PorterDuffColorFilter calculateTintFilter(ColorStateList r1, PorterDuff.Mode r2, Paint r3, boolean r4) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        return calculateTintColorTintFilter(r1, r2, r4);
    L7:
        return calculatePaintColorTintFilter(r3, r4);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context r2) {
        return createWithElevationOverlay((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), 0.0f);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context r3, float r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        int r0 = com.google.android.material.c.a.a(r5, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"), MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        r1.initializeElevationOverlay(r5);
        r1.setFillColor(ColorStateList.valueOf(r0));
        r1.setElevation(r4);
        return r1;
    }

    private void drawCompatShadow(Canvas r5) {
        if (this.containsIncompatibleShadowOp.cardinality() <= 0) goto L6;
        Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    L6:
        if (this.drawableState.s == 0) goto L8;
        r5.drawPath(this.path, this.shadowRenderer.a());
    L8:
        int r0 = 0;
    L10:
        if (r0 >= 4) goto L13;
        this.cornerShadowOperation[r0].a(this.shadowRenderer, this.drawableState.r, r5);
        this.edgeShadowOperation[r0].a(this.shadowRenderer, this.drawableState.r, r5);
        r0 = r0 + 1;
        goto L10
    L13:
        if (this.shadowBitmapDrawingEnable == false) goto L17;
        int r1 = getShadowOffsetX();
        int r2 = getShadowOffsetY();
        r5.translate(-r1, -r2);
        r5.drawPath(this.path, clearPaint);
        r5.translate(r1, r2);
        return;
    }

    private void drawFillShape(Canvas r7) {
        drawShape(r7, this.fillPaint, this.path, this.drawableState.f4038a, getBoundsAsRectF());
    }

    private void drawShape(Canvas r2, Paint r3, Path r4, l r5, RectF r6) {
        if (r5.a(r6) == false) goto L5;
        float r7 = r5.g().a(r6) * this.drawableState.k;
        r2.drawRoundRect(r6, r7, r7, r3);
        return;
    L5:
        r2.drawPath(r4, r3);
    }

    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float r0 = getStrokeInsetLength();
        this.insetRectF.inset(r0, r0);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke() == true) goto L5;
        return 0.0f;
    L5:
        return this.strokePaint.getStrokeWidth() / 2.0f;
    }

    private boolean hasCompatShadow() {
        if (this.drawableState.q != 1) goto L5;
    L11:
        return false;
    L5:
        if (this.drawableState.r <= 0) goto L11;
        if (this.drawableState.q != 2) goto L9;
        return true;
    L9:
        if (requiresCompatShadow() == false) goto L11;
        return true;
    }

    private boolean hasFill() {
        if (this.drawableState.v != Paint.Style.FILL_AND_STROKE) goto L5;
    L8:
        return true;
    L5:
        if (this.drawableState.v == Paint.Style.FILL) goto L8;
        return false;
    }

    private boolean hasStroke() {
        if (this.drawableState.v == Paint.Style.FILL_AND_STROKE) goto L7;
        if (this.drawableState.v == Paint.Style.STROKE) goto L7;
    L9:
        return false;
    L7:
        if (this.strokePaint.getStrokeWidth() <= 0.0f) goto L9;
        return true;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(Canvas r7) {
        if (hasCompatShadow() == true) goto L5;
        return;
    L5:
        r7.save();
        prepareCanvasForShadow(r7);
        if (this.shadowBitmapDrawingEnable == true) goto L10;
        drawCompatShadow(r7);
    L8:
        r7.restore();
        return;
    L10:
        int r0 = (int) (this.pathBounds.width() - getBounds().width());
        int r1 = (int) (this.pathBounds.height() - getBounds().height());
        if (r0 < 0) goto L15;
        if (r1 < 0) goto L15;
        Bitmap r2 = Bitmap.createBitmap((((int) this.pathBounds.width()) + (this.drawableState.r * 2)) + r0, (((int) this.pathBounds.height()) + (this.drawableState.r * 2)) + r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        float r4 = (getBounds().left - this.drawableState.r) - r0;
        float r5 = (getBounds().top - this.drawableState.r) - r1;
        r3.translate(-r4, -r5);
        drawCompatShadow(r3);
        r7.drawBitmap(r2, r4, r5, null);
        r2.recycle();
    L15:
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int modulateAlpha(int r1, int r2) {
        return (r1 * (r2 + (r2 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(Canvas r5) {
        int r0 = getShadowOffsetX();
        int r1 = getShadowOffsetY();
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L7:
        r5.translate(r0, r1);
        return;
    L5:
        if (this.shadowBitmapDrawingEnable == false) goto L7;
        Rect r2 = r5.getClipBounds();
        r2.inset(-this.drawableState.r, -this.drawableState.r);
        r2.offset(r0, r1);
        r5.clipRect(r2, Region.Op.REPLACE);
        goto L7
    }

    private boolean updateColorsForState(int[] r5) {
        if (this.drawableState.d == null) goto L7;
        int r0 = this.fillPaint.getColor();
        int r2 = this.drawableState.d.getColorForState(r5, r0);
        if (r0 == r2) goto L7;
        this.fillPaint.setColor(r2);
        boolean r1 = true;
    L9:
        if (this.drawableState.e == null) goto L14;
        int r3 = this.strokePaint.getColor();
        int r6 = this.drawableState.e.getColorForState(r5, r3);
        if (r3 == r6) goto L14;
        this.strokePaint.setColor(r6);
        return true;
    L14:
        return r1;
    L7:
        r1 = false;
        goto L9
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter r0 = this.tintFilter;
        PorterDuffColorFilter r1 = this.strokeTintFilter;
        this.tintFilter = calculateTintFilter(this.drawableState.g, this.drawableState.h, this.fillPaint, true);
        this.strokeTintFilter = calculateTintFilter(this.drawableState.f, this.drawableState.h, this.strokePaint, false);
        if (this.drawableState.u == false) goto L6;
        this.shadowRenderer.a(this.drawableState.g.getColorForState(getState(), 0));
    L6:
        if (ObjectsCompat.equals(r0, this.tintFilter) == true) goto L8;
        return true;
    L8:
        if (ObjectsCompat.equals(r1, this.strokeTintFilter) == true) goto L11;
        return true;
    L11:
        return false;
    }

    private void updateZ() {
        float r0 = getZ();
        this.drawableState.r = (int) Math.ceil(0.75f * r0);
        this.drawableState.s = (int) Math.ceil(r0 * 0.25f);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public final void calculatePathForSize(RectF r7, Path r8) {
        this.pathProvider.a(this.drawableState.f4038a, this.drawableState.k, r7, this.pathShadowListener, r8);
    }

    public int compositeElevationOverlayIfNeeded(int r3) {
        float r0 = getZ() + getParentAbsoluteElevation();
        if (this.drawableState.f4039b != null) goto L5;
        return r3;
    L5:
        return this.drawableState.f4039b.a(r3, r0);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int r0 = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(r0, this.drawableState.m));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.l);
        int r1 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(r1, this.drawableState.m));
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
        this.fillPaint.setAlpha(r0);
        this.strokePaint.setAlpha(r1);
    }

    public void drawShape(Canvas r8, Paint r9, Path r10, RectF r11) {
        drawShape(r8, r9, r10, this.drawableState.f4038a, r11);
    }

    public void drawStrokeShape(Canvas r7) {
        drawShape(r7, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.m;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.f4038a.i().a(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.f4038a.h().a(getBoundsAsRectF());
    }

    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.o;
    }

    public ColorStateList getFillColor() {
        return this.drawableState.d;
    }

    public float getInterpolation() {
        return this.drawableState.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r3) {
        if (this.drawableState.q != 2) goto L6;
        return;
    L6:
        if (isRoundRect() == false) goto L9;
        float r0 = getTopLeftCornerResolvedSize() * this.drawableState.k;
        r3.setRoundRect(getBounds(), r0);
        return;
    L9:
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() == false) goto L12;
    L16:
        r3.setConvexPath(this.path);     // Catch: IllegalArgumentException -> L15
        return;
    L19:
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L16;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r2) {
        if (this.drawableState.i == null) goto L7;
        r2.set(this.drawableState.i);
        return true;
    L7:
        return super.getPadding(r2);
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.v;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.n;
    }

    @Deprecated
    public void getPathForSize(int r3, int r4, Path r5) {
        calculatePathForSize(new RectF(0.0f, 0.0f, r3, r4), r5);
    }

    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.j;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.t;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        return (int) (((double) this.drawableState.s) * Math.sin(Math.toRadians(this.drawableState.t)));
    }

    public int getShadowOffsetY() {
        return (int) (((double) this.drawableState.s) * Math.cos(Math.toRadians(this.drawableState.t)));
    }

    public int getShadowRadius() {
        return this.drawableState.r;
    }

    public int getShadowVerticalOffset() {
        return this.drawableState.s;
    }

    @Override // com.google.android.material.shape.p
    public l getShapeAppearanceModel() {
        return this.drawableState.f4038a;
    }

    @Deprecated
    public o getShapedViewModel() {
        l r2 = getShapeAppearanceModel();
        if (ZeusTransformUtils.instanceOf(r2, o.class) == true) goto L7;
        return null;
    L7:
        return (o) ZeusTransformUtils.preCheckCast(r2, o.class, "com.obric.memorydata.plugin");
    }

    public ColorStateList getStrokeColor() {
        return this.drawableState.e;
    }

    public ColorStateList getStrokeTintList() {
        return this.drawableState.f;
    }

    public float getStrokeWidth() {
        return this.drawableState.l;
    }

    public ColorStateList getTintList() {
        return this.drawableState.g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.f4038a.f().a(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.f4038a.g().a(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.p;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect r0 = getBounds();
        this.transparentRegion.set(r0);
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        a r0 = this.drawableState;
        r0.f4039b = new com.google.android.material.elevation.a(r4);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        if (this.drawableState.f4039b != null) goto L5;
    L7:
        return false;
    L5:
        if (this.drawableState.f4039b.a() == false) goto L7;
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.f4039b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPointInTransparentRegion(int r1, int r2) {
        return getTransparentRegion().contains(r1, r2);
    }

    public boolean isRoundRect() {
        return this.drawableState.f4038a.a(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        if (this.drawableState.q != 0) goto L5;
    L8:
        return true;
    L5:
        if (this.drawableState.q == 2) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful() == false) goto L5;
    L22:
        return true;
    L5:
        if (this.drawableState.g == null) goto L9;
        if (this.drawableState.g.isStateful() == true) goto L22;
    L9:
        if (this.drawableState.f == null) goto L13;
        if (this.drawableState.f.isStateful() == true) goto L22;
    L13:
        if (this.drawableState.e == null) goto L17;
        if (this.drawableState.e.isStateful() == true) goto L22;
    L17:
        if (this.drawableState.d != null) goto L19;
    L21:
        return false;
    L19:
        if (this.drawableState.d.isStateful() == false) goto L21;
        goto L21
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new a(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        this.pathDirty = true;
        super.onBoundsChange(r2);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.i.a
    public boolean onStateChange(int[] r2) {
        boolean r3 = updateColorsForState(r2);
        boolean r0 = updateTintFilter();
        if (r3 == true) goto L7;
        if (r0 == true) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
        invalidateSelf();
    L10:
        return r4;
    L7:
        r4 = true;
        goto L8
    }

    public boolean requiresCompatShadow() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L12:
        return true;
    L5:
        if (isRoundRect() == false) goto L7;
    L11:
        return false;
    L7:
        if (this.path.isConvex() == true) goto L11;
        if (Build.VERSION.SDK_INT >= 29) goto L11;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.drawableState.m == r2) goto L6;
        this.drawableState.m = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.drawableState.c = r2;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float r2) {
        setShapeAppearanceModel(this.drawableState.f4038a.a(r2));
    }

    public void setCornerSize(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        setShapeAppearanceModel(this.drawableState.f4038a.a(r4));
    }

    public void setEdgeIntersectionCheckEnable(boolean r1) {
        this.pathProvider.a(r1);
    }

    public void setElevation(float r2) {
        if (this.drawableState.o == r2) goto L6;
        this.drawableState.o = r2;
        updateZ();
        return;
    }

    public void setFillColor(ColorStateList r2) {
        if (this.drawableState.d == r2) goto L6;
        this.drawableState.d = r2;
        onStateChange(getState());
        return;
    }

    public void setInterpolation(float r2) {
        if (this.drawableState.k == r2) goto L6;
        this.drawableState.k = r2;
        this.pathDirty = true;
        invalidateSelf();
        return;
    }

    public void setPadding(int r3, int r4, int r5, int r6) {
        if (this.drawableState.i != null) goto L5;
        a r0 = this.drawableState;
        r0.i = new Rect();
    L5:
        this.drawableState.i.set(r3, r4, r5, r6);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style r2) {
        this.drawableState.v = r2;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float r2) {
        if (this.drawableState.n == r2) goto L6;
        this.drawableState.n = r2;
        updateZ();
        return;
    }

    public void setScale(float r2) {
        if (this.drawableState.j == r2) goto L6;
        this.drawableState.j = r2;
        invalidateSelf();
        return;
    }

    public void setShadowBitmapDrawingEnable(boolean r1) {
        this.shadowBitmapDrawingEnable = r1;
    }

    public void setShadowColor(int r2) {
        this.shadowRenderer.a(r2);
        this.drawableState.u = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int r2) {
        if (this.drawableState.t == r2) goto L6;
        this.drawableState.t = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    public void setShadowCompatibilityMode(int r2) {
        if (this.drawableState.q == r2) goto L6;
        this.drawableState.q = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    @Deprecated
    public void setShadowElevation(int r1) {
        setElevation(r1);
    }

    @Deprecated
    public void setShadowEnabled(boolean r1) {
        setShadowCompatibilityMode(!r1 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int r1) {
        this.drawableState.r = r1;
    }

    public void setShadowVerticalOffset(int r2) {
        if (this.drawableState.s == r2) goto L6;
        this.drawableState.s = r2;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(l r2) {
        this.drawableState.f4038a = r2;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(o r1) {
        setShapeAppearanceModel(r1);
    }

    public void setStroke(float r1, int r2) {
        setStrokeWidth(r1);
        setStrokeColor(ColorStateList.valueOf(r2));
    }

    public void setStroke(float r1, ColorStateList r2) {
        setStrokeWidth(r1);
        setStrokeColor(r2);
    }

    public void setStrokeColor(ColorStateList r2) {
        if (this.drawableState.e == r2) goto L6;
        this.drawableState.e = r2;
        onStateChange(getState());
        return;
    }

    public void setStrokeTint(int r1) {
        setStrokeTint(ColorStateList.valueOf(r1));
    }

    public void setStrokeTint(ColorStateList r2) {
        this.drawableState.f = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float r2) {
        this.drawableState.l = r2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r1) {
        setTintList(ColorStateList.valueOf(r1));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r2) {
        this.drawableState.g = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r2) {
        if (this.drawableState.h == r2) goto L6;
        this.drawableState.h = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
        return;
    }

    public void setTranslationZ(float r2) {
        if (this.drawableState.p == r2) goto L6;
        this.drawableState.p = r2;
        updateZ();
        return;
    }

    public void setUseTintColorForShadow(boolean r2) {
        if (this.drawableState.u == r2) goto L6;
        this.drawableState.u = r2;
        invalidateSelf();
        return;
    }

    public void setZ(float r2) {
        setTranslationZ(r2 - getElevation());
    }
}
