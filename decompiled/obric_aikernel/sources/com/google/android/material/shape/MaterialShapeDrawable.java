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
import android.os.Build;
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
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, p {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = null;
    private static final Paint clearPaint = null;
    private final BitSet containsIncompatibleShadowOp;
    private final n.g[] cornerShadowOperation;
    private c drawableState;
    private final n.g[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;

    @NonNull
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final m pathProvider;

    @NonNull
    private final m.b pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final a6.a shadowRenderer;
    private final Paint strokePaint;
    private l strokeShapeAppearance;

    @Nullable
    private PorterDuffColorFilter strokeTintFilter;

    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    class a implements m.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialShapeDrawable f3611a;

        a(MaterialShapeDrawable r10) {
            this.f3611a = r10;
        }

        @Override // com.google.android.material.shape.m.b
        public void a(@NonNull n r10, Matrix r11, int r12) {
            MaterialShapeDrawable.access$000(this.f3611a).set(r12, r10.e());
            MaterialShapeDrawable.access$100(this.f3611a)[r12] = r10.f(r11);
        }

        @Override // com.google.android.material.shape.m.b
        public void b(@NonNull n r10, Matrix r11, int r12) {
            MaterialShapeDrawable.access$000(this.f3611a).set(r12 + 4, r10.e());
            MaterialShapeDrawable.access$200(this.f3611a)[r12] = r10.f(r11);
        }
    }

    class b implements l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f3612a;

        b(MaterialShapeDrawable r10, float r11) {
            this.f3612a = r11;
        }

        @Override // com.google.android.material.shape.l.c
        @NonNull
        public com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c r10) {
            if ((r10 instanceof j) == false) goto L6;
            return r10;
        L6:
            return new com.google.android.material.shape.b(this.f3612a, r10);
        }
    }

    static final class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public l f3613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public w5.a f3614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public ColorFilter f3615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public ColorStateList f3616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public ColorStateList f3617e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public ColorStateList f3618f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public ColorStateList f3619g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public PorterDuff.Mode f3620h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public Rect f3621i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f3622j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f3623k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f3624l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f3625m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f3626n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f3627o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f3628p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f3629q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f3630r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f3631s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f3632t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f3633u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f3634v;

        public c(@NonNull c r10) {
            this.f3616d = null;
            this.f3617e = null;
            this.f3618f = null;
            this.f3619g = null;
            this.f3620h = PorterDuff.Mode.SRC_IN;
            this.f3621i = null;
            this.f3622j = 1.0f;
            this.f3623k = 1.0f;
            this.f3625m = 255;
            this.f3626n = 0.0f;
            this.f3627o = 0.0f;
            this.f3628p = 0.0f;
            this.f3629q = 0;
            this.f3630r = 0;
            this.f3631s = 0;
            this.f3632t = 0;
            this.f3633u = false;
            this.f3634v = Paint.Style.FILL_AND_STROKE;
            this.f3613a = r10.f3613a;
            this.f3614b = r10.f3614b;
            this.f3624l = r10.f3624l;
            this.f3615c = r10.f3615c;
            this.f3616d = r10.f3616d;
            this.f3617e = r10.f3617e;
            this.f3620h = r10.f3620h;
            this.f3619g = r10.f3619g;
            this.f3625m = r10.f3625m;
            this.f3622j = r10.f3622j;
            this.f3631s = r10.f3631s;
            this.f3629q = r10.f3629q;
            this.f3633u = r10.f3633u;
            this.f3623k = r10.f3623k;
            this.f3626n = r10.f3626n;
            this.f3627o = r10.f3627o;
            this.f3628p = r10.f3628p;
            this.f3630r = r10.f3630r;
            this.f3632t = r10.f3632t;
            this.f3618f = r10.f3618f;
            this.f3634v = r10.f3634v;
            if (r10.f3621i == null) goto L6;
            this.f3621i = new Rect(r10.f3621i);
            return;
        }

        public c(l r10, w5.a r11) {
            this.f3616d = null;
            this.f3617e = null;
            this.f3618f = null;
            this.f3619g = null;
            this.f3620h = PorterDuff.Mode.SRC_IN;
            this.f3621i = null;
            this.f3622j = 1.0f;
            this.f3623k = 1.0f;
            this.f3625m = 255;
            this.f3626n = 0.0f;
            this.f3627o = 0.0f;
            this.f3628p = 0.0f;
            this.f3629q = 0;
            this.f3630r = 0;
            this.f3631s = 0;
            this.f3632t = 0;
            this.f3633u = false;
            this.f3634v = Paint.Style.FILL_AND_STROKE;
            this.f3613a = r10;
            this.f3614b = r11;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable r10 = new MaterialShapeDrawable(this, null);
            MaterialShapeDrawable.access$402(r10, true);
            return r10;
        }
    }

    static {
        TAG = MaterialShapeDrawable.class.getSimpleName();
        Paint r10 = new Paint(1);
        clearPaint = r10;
        r10.setColor(-1);
        r10.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new l());
    }

    public MaterialShapeDrawable(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        this(l.e(r10, r11, r12, r13).m());
    }

    private MaterialShapeDrawable(@NonNull c r10) {
        this.cornerShadowOperation = new n.g[4];
        this.edgeShadowOperation = new n.g[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint r11 = new Paint(1);
        this.fillPaint = r11;
        Paint r12 = new Paint(1);
        this.strokePaint = r12;
        this.shadowRenderer = new a6.a();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        m r13 = m.k();
    L6:
        this.pathProvider = r13;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = r10;
        r12.setStyle(Paint.Style.STROKE);
        r11.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new a(this);
        return;
    L5:
        r13 = new m();
        goto L6
    }

    /* synthetic */ MaterialShapeDrawable(c r10, a r11) {
        this(r10);
    }

    public MaterialShapeDrawable(@NonNull l r10) {
        this(new c(r10, null));
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull o r10) {
        this(r10);
    }

    static /* synthetic */ BitSet access$000(MaterialShapeDrawable r10) {
        return r10.containsIncompatibleShadowOp;
    }

    static /* synthetic */ n.g[] access$100(MaterialShapeDrawable r10) {
        return r10.cornerShadowOperation;
    }

    static /* synthetic */ n.g[] access$200(MaterialShapeDrawable r10) {
        return r10.edgeShadowOperation;
    }

    static /* synthetic */ boolean access$402(MaterialShapeDrawable r10, boolean r11) {
        r10.pathDirty = r11;
        return r11;
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint r10, boolean r11) {
        if (r11 == false) goto L7;
        int r12 = r10.getColor();
        int r13 = compositeElevationOverlayIfNeeded(r12);
        this.resolvedTintColor = r13;
        if (r13 != r12) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r13, PorterDuff.Mode.SRC_IN);
    L7:
        return null;
    }

    private void calculatePath(@NonNull RectF r10, @NonNull Path r11) {
        calculatePathForSize(r10, r11);
        if (this.drawableState.f3622j == 1.0f) goto L5;
        this.matrix.reset();
        Matrix r12 = this.matrix;
        float r13 = this.drawableState.f3622j;
        r12.setScale(r13, r13, r10.width() / 2.0f, r10.height() / 2.0f);
        r11.transform(this.matrix);
    L5:
        r11.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        float r10 = -getStrokeInsetLength();
        l r11 = getShapeAppearanceModel().y(new b(this, r10));
        this.strokeShapeAppearance = r11;
        this.pathProvider.d(r11, this.drawableState.f3623k, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList r10, @NonNull PorterDuff.Mode r11, boolean r12) {
        int r13 = r10.getColorForState(getState(), 0);
        if (r12 == false) goto L5;
        r13 = compositeElevationOverlayIfNeeded(r13);
    L5:
        this.resolvedTintColor = r13;
        return new PorterDuffColorFilter(r13, r11);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList r10, @Nullable PorterDuff.Mode r11, @NonNull Paint r12, boolean r13) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        return calculateTintColorTintFilter(r10, r11, r13);
    L7:
        return calculatePaintColorTintFilter(r12, r13);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context r10) {
        return createWithElevationOverlay(r10, 0.0f);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context r10, float r11) {
        int r12 = t5.a.c(r10, q5.b.colorSurface, MaterialShapeDrawable.class.getSimpleName());
        MaterialShapeDrawable r13 = new MaterialShapeDrawable();
        r13.initializeElevationOverlay(r10);
        r13.setFillColor(ColorStateList.valueOf(r12));
        r13.setElevation(r11);
        return r13;
    }

    private void drawCompatShadow(@NonNull Canvas r10) {
        if (this.containsIncompatibleShadowOp.cardinality() <= 0) goto L6;
        Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    L6:
        if (this.drawableState.f3631s == 0) goto L8;
        r10.drawPath(this.path, this.shadowRenderer.c());
    L8:
        int r11 = 0;
    L10:
        if (r11 >= 4) goto L13;
        this.cornerShadowOperation[r11].a(this.shadowRenderer, this.drawableState.f3630r, r10);
        this.edgeShadowOperation[r11].a(this.shadowRenderer, this.drawableState.f3630r, r10);
        r11 = r11 + 1;
        goto L10
    L13:
        if (this.shadowBitmapDrawingEnable == false) goto L17;
        int r12 = getShadowOffsetX();
        int r13 = getShadowOffsetY();
        r10.translate(-r12, -r13);
        r10.drawPath(this.path, clearPaint);
        r10.translate(r12, r13);
        return;
    }

    private void drawFillShape(@NonNull Canvas r10) {
        drawShape(r10, this.fillPaint, this.path, this.drawableState.f3613a, getBoundsAsRectF());
    }

    private void drawShape(@NonNull Canvas r10, @NonNull Paint r11, @NonNull Path r12, @NonNull l r13, @NonNull RectF r14) {
        if (r13.u(r14) == false) goto L5;
        float r15 = r13.t().a(r14) * this.drawableState.f3623k;
        r10.drawRoundRect(r14, r15, r15, r11);
        return;
    L5:
        r10.drawPath(r12, r11);
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float r10 = getStrokeInsetLength();
        this.insetRectF.inset(r10, r10);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke() == true) goto L5;
        return 0.0f;
    L5:
        return this.strokePaint.getStrokeWidth() / 2.0f;
    }

    private boolean hasCompatShadow() {
        c r10 = this.drawableState;
        int r11 = r10.f3629q;
        if (r11 != 1) goto L5;
    L11:
        return false;
    L5:
        if (r10.f3630r <= 0) goto L11;
        if (r11 != 2) goto L9;
        return true;
    L9:
        if (requiresCompatShadow() == false) goto L11;
        return true;
    }

    private boolean hasFill() {
        Paint.Style r10 = this.drawableState.f3634v;
        if (r10 != Paint.Style.FILL_AND_STROKE) goto L5;
    L8:
        return true;
    L5:
        if (r10 == Paint.Style.FILL) goto L8;
        return false;
    }

    private boolean hasStroke() {
        Paint.Style r10 = this.drawableState.f3634v;
        if (r10 == Paint.Style.FILL_AND_STROKE) goto L7;
        if (r10 == Paint.Style.STROKE) goto L7;
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
        if (this.shadowBitmapDrawingEnable == true) goto L10;
        drawCompatShadow(r10);
    L8:
        r10.restore();
        return;
    L10:
        int r11 = (int) (this.pathBounds.width() - getBounds().width());
        int r12 = (int) (this.pathBounds.height() - getBounds().height());
        if (r11 < 0) goto L15;
        if (r12 < 0) goto L15;
        Bitmap r13 = Bitmap.createBitmap((((int) this.pathBounds.width()) + (this.drawableState.f3630r * 2)) + r11, (((int) this.pathBounds.height()) + (this.drawableState.f3630r * 2)) + r12, Bitmap.Config.ARGB_8888);
        Canvas r14 = new Canvas(r13);
        float r15 = (getBounds().left - this.drawableState.f3630r) - r11;
        float r16 = (getBounds().top - this.drawableState.f3630r) - r12;
        r14.translate(-r15, -r16);
        drawCompatShadow(r14);
        r10.drawBitmap(r13, r15, r16, null);
        r13.recycle();
    L15:
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int modulateAlpha(int r10, int r11) {
        return (r10 * (r11 + (r11 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas r10) {
        int r11 = getShadowOffsetX();
        int r12 = getShadowOffsetY();
        if (Build.VERSION.SDK_INT < 21) goto L5;
    L7:
        r10.translate(r11, r12);
        return;
    L5:
        if (this.shadowBitmapDrawingEnable == false) goto L7;
        Rect r13 = r10.getClipBounds();
        int r14 = this.drawableState.f3630r;
        r13.inset(-r14, -r14);
        r13.offset(r11, r12);
        r10.clipRect(r13, Region.Op.REPLACE);
        goto L7
    }

    private boolean updateColorsForState(int[] r10) {
        if (this.drawableState.f3616d == null) goto L7;
        int r11 = this.fillPaint.getColor();
        int r12 = this.drawableState.f3616d.getColorForState(r10, r11);
        if (r11 == r12) goto L7;
        this.fillPaint.setColor(r12);
        boolean r13 = true;
    L9:
        if (this.drawableState.f3617e == null) goto L14;
        int r14 = this.strokePaint.getColor();
        int r15 = this.drawableState.f3617e.getColorForState(r10, r14);
        if (r14 == r15) goto L14;
        this.strokePaint.setColor(r15);
        return true;
    L14:
        return r13;
    L7:
        r13 = false;
        goto L9
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter r10 = this.tintFilter;
        PorterDuffColorFilter r11 = this.strokeTintFilter;
        c r12 = this.drawableState;
        this.tintFilter = calculateTintFilter(r12.f3619g, r12.f3620h, this.fillPaint, true);
        c r13 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(r13.f3618f, r13.f3620h, this.strokePaint, false);
        c r14 = this.drawableState;
        if (r14.f3633u == false) goto L6;
        this.shadowRenderer.d(r14.f3619g.getColorForState(getState(), 0));
    L6:
        if (ObjectsCompat.equals(r10, this.tintFilter) == true) goto L8;
        return true;
    L8:
        if (ObjectsCompat.equals(r11, this.strokeTintFilter) == true) goto L11;
        return true;
    L11:
        return false;
    }

    private void updateZ() {
        float r10 = getZ();
        this.drawableState.f3630r = (int) Math.ceil(0.75f * r10);
        this.drawableState.f3631s = (int) Math.ceil(r10 * SHADOW_OFFSET_MULTIPLIER);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected final void calculatePathForSize(@NonNull RectF r10, @NonNull Path r11) {
        m r12 = this.pathProvider;
        c r13 = this.drawableState;
        r12.e(r13.f3613a, r13.f3623k, r10, this.pathShadowListener, r11);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int compositeElevationOverlayIfNeeded(@ColorInt int r10) {
        float r11 = getZ() + getParentAbsoluteElevation();
        w5.a r12 = this.drawableState.f3614b;
        if (r12 != null) goto L5;
        return r10;
    L5:
        return r12.c(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int r11 = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(r11, this.drawableState.f3625m));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.f3624l);
        int r12 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(r12, this.drawableState.f3625m));
        if (this.pathDirty == false) goto L5;
        calculateStrokePath();
        calculatePath(getBoundsAsRectF(), this.path);
        this.pathDirty = false;
    L5:
        maybeDrawCompatShadow(r10);
        if (hasFill() == false) goto L9;
        drawFillShape(r10);
    L9:
        if (hasStroke() == false) goto L11;
        drawStrokeShape(r10);
    L11:
        this.fillPaint.setAlpha(r11);
        this.strokePaint.setAlpha(r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void drawShape(@NonNull Canvas r10, @NonNull Paint r11, @NonNull Path r12, @NonNull RectF r13) {
        drawShape(r10, r11, r12, this.drawableState.f3613a, r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void drawStrokeShape(@NonNull Canvas r10) {
        drawShape(r10, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.f3625m;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.f3613a.j().a(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.f3613a.l().a(getBoundsAsRectF());
    }

    @NonNull
    protected RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.f3627o;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.f3616d;
    }

    public float getInterpolation() {
        return this.drawableState.f3623k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r10) {
        if (this.drawableState.f3629q != 2) goto L6;
        return;
    L6:
        if (isRoundRect() == false) goto L9;
        float r11 = getTopLeftCornerResolvedSize() * this.drawableState.f3623k;
        r10.setRoundRect(getBounds(), r11);
        return;
    L9:
        calculatePath(getBoundsAsRectF(), this.path);
        if (this.path.isConvex() == false) goto L12;
    L16:
        r10.setConvexPath(this.path);     // Catch: IllegalArgumentException -> L15
        return;
    L19:
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L16;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r10) {
        Rect r11 = this.drawableState.f3621i;
        if (r11 == null) goto L7;
        r10.set(r11);
        return true;
    L7:
        return super.getPadding(r10);
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.f3634v;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.f3626n;
    }

    @Deprecated
    public void getPathForSize(int r10, int r11, @NonNull Path r12) {
        calculatePathForSize(new RectF(0.0f, 0.0f, r10, r11), r12);
    }

    @ColorInt
    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.f3622j;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.f3632t;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.f3629q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        c r10 = this.drawableState;
        return (int) (((double) r10.f3631s) * Math.sin(Math.toRadians(r10.f3632t)));
    }

    public int getShadowOffsetY() {
        c r10 = this.drawableState;
        return (int) (((double) r10.f3631s) * Math.cos(Math.toRadians(r10.f3632t)));
    }

    public int getShadowRadius() {
        return this.drawableState.f3630r;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.f3631s;
    }

    @Override // com.google.android.material.shape.p
    @NonNull
    public l getShapeAppearanceModel() {
        return this.drawableState.f3613a;
    }

    @Nullable
    @Deprecated
    public o getShapedViewModel() {
        l r10 = getShapeAppearanceModel();
        if ((r10 instanceof o) == true) goto L7;
        return null;
    L7:
        return (o) r10;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.f3617e;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.f3618f;
    }

    public float getStrokeWidth() {
        return this.drawableState.f3624l;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.f3619g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.f3613a.r().a(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.f3613a.t().a(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.f3628p;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect r10 = getBounds();
        this.transparentRegion.set(r10);
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context r10) {
        c r11 = this.drawableState;
        r11.f3614b = new w5.a(r10);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        w5.a r10 = this.drawableState.f3614b;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.e() == false) goto L7;
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.f3614b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPointInTransparentRegion(int r10, int r11) {
        return getTransparentRegion().contains(r10, r11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.f3613a.u(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int r10 = this.drawableState.f3629q;
        if (r10 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 2) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful() == true) goto L22;
        ColorStateList r10 = this.drawableState.f3619g;
        if (r10 != null) goto L7;
    L8:
        ColorStateList r11 = this.drawableState.f3618f;
        if (r11 != null) goto L11;
    L12:
        ColorStateList r12 = this.drawableState.f3617e;
        if (r12 != null) goto L15;
    L16:
        ColorStateList r13 = this.drawableState.f3616d;
        if (r13 != null) goto L19;
    L21:
        return false;
    L19:
        if (r13.isStateful() == false) goto L21;
    L15:
        if (r12.isStateful() == true) goto L22;
    L11:
        if (r11.isStateful() == true) goto L22;
    L7:
        if (r10.isStateful() == false) goto L8;
    L22:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new c(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        this.pathDirty = true;
        super.onBoundsChange(r10);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.i.b
    protected boolean onStateChange(int[] r10) {
        boolean r11 = updateColorsForState(r10);
        boolean r12 = updateTintFilter();
        if (r11 == true) goto L7;
        if (r12 == true) goto L7;
        boolean r13 = false;
    L8:
        if (r13 == false) goto L10;
        invalidateSelf();
    L10:
        return r13;
    L7:
        r13 = true;
        goto L8
    }

    public boolean requiresCompatShadow() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 21) goto L5;
    L12:
        return true;
    L5:
        if (isRoundRect() == false) goto L7;
    L11:
        return false;
    L7:
        if (this.path.isConvex() == true) goto L11;
        if (r10 >= 29) goto L11;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r10) {
        c r11 = this.drawableState;
        if (r11.f3625m == r10) goto L6;
        r11.f3625m = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.drawableState.f3615c = r10;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float r10) {
        setShapeAppearanceModel(this.drawableState.f3613a.w(r10));
    }

    public void setCornerSize(@NonNull com.google.android.material.shape.c r10) {
        setShapeAppearanceModel(this.drawableState.f3613a.x(r10));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean r10) {
        this.pathProvider.n(r10);
    }

    public void setElevation(float r10) {
        c r11 = this.drawableState;
        if (r11.f3627o == r10) goto L6;
        r11.f3627o = r10;
        updateZ();
        return;
    }

    public void setFillColor(@Nullable ColorStateList r10) {
        c r11 = this.drawableState;
        if (r11.f3616d == r10) goto L6;
        r11.f3616d = r10;
        onStateChange(getState());
        return;
    }

    public void setInterpolation(float r10) {
        c r11 = this.drawableState;
        if (r11.f3623k == r10) goto L6;
        r11.f3623k = r10;
        this.pathDirty = true;
        invalidateSelf();
        return;
    }

    public void setPadding(int r10, int r11, int r12, int r13) {
        c r14 = this.drawableState;
        if (r14.f3621i != null) goto L5;
        r14.f3621i = new Rect();
    L5:
        this.drawableState.f3621i.set(r10, r11, r12, r13);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style r10) {
        this.drawableState.f3634v = r10;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float r10) {
        c r11 = this.drawableState;
        if (r11.f3626n == r10) goto L6;
        r11.f3626n = r10;
        updateZ();
        return;
    }

    public void setScale(float r10) {
        c r11 = this.drawableState;
        if (r11.f3622j == r10) goto L6;
        r11.f3622j = r10;
        invalidateSelf();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean r10) {
        this.shadowBitmapDrawingEnable = r10;
    }

    public void setShadowColor(int r10) {
        this.shadowRenderer.d(r10);
        this.drawableState.f3633u = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int r10) {
        c r11 = this.drawableState;
        if (r11.f3632t == r10) goto L6;
        r11.f3632t = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    public void setShadowCompatibilityMode(int r10) {
        c r11 = this.drawableState;
        if (r11.f3629q == r10) goto L6;
        r11.f3629q = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    @Deprecated
    public void setShadowElevation(int r10) {
        setElevation(r10);
    }

    @Deprecated
    public void setShadowEnabled(boolean r10) {
        setShadowCompatibilityMode(!r10 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int r10) {
        this.drawableState.f3630r = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int r10) {
        c r11 = this.drawableState;
        if (r11.f3631s == r10) goto L6;
        r11.f3631s = r10;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // com.google.android.material.shape.p
    public void setShapeAppearanceModel(@NonNull l r10) {
        this.drawableState.f3613a = r10;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull o r10) {
        setShapeAppearanceModel(r10);
    }

    public void setStroke(float r10, @ColorInt int r11) {
        setStrokeWidth(r10);
        setStrokeColor(ColorStateList.valueOf(r11));
    }

    public void setStroke(float r10, @Nullable ColorStateList r11) {
        setStrokeWidth(r10);
        setStrokeColor(r11);
    }

    public void setStrokeColor(@Nullable ColorStateList r10) {
        c r11 = this.drawableState;
        if (r11.f3617e == r10) goto L6;
        r11.f3617e = r10;
        onStateChange(getState());
        return;
    }

    public void setStrokeTint(@ColorInt int r10) {
        setStrokeTint(ColorStateList.valueOf(r10));
    }

    public void setStrokeTint(ColorStateList r10) {
        this.drawableState.f3618f = r10;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float r10) {
        this.drawableState.f3624l = r10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r10) {
        setTintList(ColorStateList.valueOf(r10));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r10) {
        this.drawableState.f3619g = r10;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r10) {
        c r11 = this.drawableState;
        if (r11.f3620h == r10) goto L6;
        r11.f3620h = r10;
        updateTintFilter();
        invalidateSelfIgnoreShape();
        return;
    }

    public void setTranslationZ(float r10) {
        c r11 = this.drawableState;
        if (r11.f3628p == r10) goto L6;
        r11.f3628p = r10;
        updateZ();
        return;
    }

    public void setUseTintColorForShadow(boolean r10) {
        c r11 = this.drawableState;
        if (r11.f3633u == r10) goto L6;
        r11.f3633u = r10;
        invalidateSelf();
        return;
    }

    public void setZ(float r10) {
        setTranslationZ(r10 - getElevation());
    }
}
