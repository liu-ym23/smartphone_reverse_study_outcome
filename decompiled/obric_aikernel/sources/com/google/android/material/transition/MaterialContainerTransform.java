package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.p;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialContainerTransform extends Transition {
    private static final c DEFAULT_ENTER_THRESHOLDS = null;
    private static final c DEFAULT_ENTER_THRESHOLDS_ARC = null;
    private static final c DEFAULT_RETURN_THRESHOLDS = null;
    private static final c DEFAULT_RETURN_THRESHOLDS_ARC = null;
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String TAG = null;
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = null;
    private boolean appliedThemeValues;

    @ColorInt
    private int containerColor;
    private boolean drawDebugEnabled;

    @IdRes
    private int drawingViewId;
    private boolean elevationShadowEnabled;

    @ColorInt
    private int endContainerColor;
    private float endElevation;

    @Nullable
    private com.google.android.material.shape.l endShapeAppearanceModel;

    @Nullable
    private View endView;

    @IdRes
    private int endViewId;
    private int fadeMode;

    @Nullable
    private b fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;

    @Nullable
    private b scaleMaskProgressThresholds;

    @Nullable
    private b scaleProgressThresholds;

    @ColorInt
    private int scrimColor;

    @Nullable
    private b shapeMaskProgressThresholds;

    @ColorInt
    private int startContainerColor;
    private float startElevation;

    @Nullable
    private com.google.android.material.shape.l startShapeAppearanceModel;

    @Nullable
    private View startView;

    @IdRes
    private int startViewId;
    private int transitionDirection;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f4097c;

        a(MaterialContainerTransform r10, d r11) {
            this.f4097c = r11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            d.a(this.f4097c, r10.getAnimatedFraction());
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @FloatRange(from = 0.0d, to = 1.0d)
        private final float f4098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @FloatRange(from = 0.0d, to = 1.0d)
        private final float f4099b;

        public b(@FloatRange(from = 0.0d, to = 1.0d) float r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
            this.f4098a = r10;
            this.f4099b = r11;
        }

        static /* synthetic */ float a(b r10) {
            return r10.f4098a;
        }

        static /* synthetic */ float b(b r10) {
            return r10.f4099b;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float c() {
            return this.f4099b;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d() {
            return this.f4098a;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private final b f4100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        private final b f4101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        private final b f4102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private final b f4103d;

        private c(@NonNull b r10, @NonNull b r11, @NonNull b r12, @NonNull b r13) {
            this.f4100a = r10;
            this.f4101b = r11;
            this.f4102c = r12;
            this.f4103d = r13;
        }

        /* synthetic */ c(b r10, b r11, b r12, b r13, a r14) {
            this(r10, r11, r12, r13);
        }

        static /* synthetic */ b a(c r10) {
            return r10.f4100a;
        }

        static /* synthetic */ b b(c r10) {
            return r10.f4101b;
        }

        static /* synthetic */ b c(c r10) {
            return r10.f4102c;
        }

        static /* synthetic */ b d(c r10) {
            return r10.f4103d;
        }
    }

    private static final class d extends Drawable {
        private final c A;
        private final com.google.android.material.transition.a B;
        private final f C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private com.google.android.material.transition.c G;
        private h H;
        private RectF I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private float f4104J;
        private float K;
        private float L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f4105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RectF f4106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.android.material.shape.l f4107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f4108d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f4109e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final RectF f4110f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final com.google.android.material.shape.l f4111g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f4112h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Paint f4113i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Paint f4114j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Paint f4115k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Paint f4116l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Paint f4117m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final i f4118n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final PathMeasure f4119o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final float f4120p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final float[] f4121q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f4122r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f4123s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final float f4124t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f4125u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final MaterialShapeDrawable f4126v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final RectF f4127w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final RectF f4128x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final RectF f4129y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final RectF f4130z;

        class a implements l.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f4131a;

            a(d r10) {
                this.f4131a = r10;
            }

            @Override // com.google.android.material.transition.l.c
            public void a(Canvas r10) {
                d.b(this.f4131a).draw(r10);
            }
        }

        class b implements l.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f4132a;

            b(d r10) {
                this.f4132a = r10;
            }

            @Override // com.google.android.material.transition.l.c
            public void a(Canvas r10) {
                d.c(this.f4132a).draw(r10);
            }
        }

        private d(PathMotion r14, View r15, RectF r16, com.google.android.material.shape.l r17, float r18, View r19, RectF r20, com.google.android.material.shape.l r21, float r22, @ColorInt int r23, @ColorInt int r24, @ColorInt int r25, int r26, boolean r27, boolean r28, com.google.android.material.transition.a r29, f r30, c r31, boolean r32) {
            Paint r10 = new Paint();
            this.f4113i = r10;
            Paint r11 = new Paint();
            this.f4114j = r11;
            Paint r12 = new Paint();
            this.f4115k = r12;
            this.f4116l = new Paint();
            Paint r13 = new Paint();
            this.f4117m = r13;
            this.f4118n = new i();
            this.f4121q = new float[]{r16.centerX(), r16.top};
            MaterialShapeDrawable r33 = new MaterialShapeDrawable();
            this.f4126v = r33;
            Paint r34 = new Paint();
            this.E = r34;
            this.F = new Path();
            this.f4105a = r15;
            this.f4106b = r16;
            this.f4107c = r17;
            this.f4108d = r18;
            this.f4109e = r19;
            this.f4110f = r20;
            this.f4111g = r21;
            this.f4112h = r22;
            this.f4122r = r27;
            this.f4125u = r28;
            this.B = r29;
            this.C = r30;
            this.A = r31;
            this.D = r32;
            WindowManager r110 = (WindowManager) r15.getContext().getSystemService("window");
            DisplayMetrics r111 = new DisplayMetrics();
            r110.getDefaultDisplay().getMetrics(r111);
            this.f4123s = r111.widthPixels;
            this.f4124t = r111.heightPixels;
            r10.setColor(r23);
            r11.setColor(r24);
            r12.setColor(r25);
            r33.setFillColor(ColorStateList.valueOf(0));
            r33.setShadowCompatibilityMode(2);
            r33.setShadowBitmapDrawingEnable(false);
            r33.setShadowColor(-7829368);
            RectF r35 = new RectF(r16);
            this.f4127w = r35;
            this.f4128x = new RectF(r35);
            RectF r36 = new RectF(r35);
            this.f4129y = r36;
            this.f4130z = new RectF(r36);
            PointF r37 = m(r16);
            PointF r38 = m(r20);
            PathMeasure r39 = new PathMeasure(r14.getPath(r37.x, r37.y, r38.x, r38.y), false);
            this.f4119o = r39;
            this.f4120p = r39.getLength();
            r13.setStyle(Paint.Style.FILL);
            r13.setShader(l.c(r26));
            r34.setStyle(Paint.Style.STROKE);
            r34.setStrokeWidth(10.0f);
            p(0.0f);
        }

        /* synthetic */ d(PathMotion r10, View r11, RectF r12, com.google.android.material.shape.l r13, float r14, View r15, RectF r16, com.google.android.material.shape.l r17, float r18, int r19, int r110, int r111, int r112, boolean r113, boolean r114, com.google.android.material.transition.a r115, f r116, c r117, boolean r118, a r20) {
            this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118);
        }

        static /* synthetic */ void a(d r10, float r11) {
            r10.o(r11);
        }

        static /* synthetic */ View b(d r10) {
            return r10.f4105a;
        }

        static /* synthetic */ View c(d r10) {
            return r10.f4109e;
        }

        private static float d(RectF r10, float r11) {
            return ((r10.centerX() / (r11 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float e(RectF r10, float r11) {
            return (r10.centerY() / r11) * 1.5f;
        }

        private void f(Canvas r10, RectF r11, Path r12, @ColorInt int r13) {
            PointF r14 = m(r11);
            if (this.L != 0.0f) goto L5;
            r12.reset();
            r12.moveTo(r14.x, r14.y);
            return;
        L5:
            r12.lineTo(r14.x, r14.y);
            this.E.setColor(r13);
            r10.drawPath(r12, this.E);
        }

        private void g(Canvas r10, RectF r11, @ColorInt int r12) {
            this.E.setColor(r12);
            r10.drawRect(r11, this.E);
        }

        private void h(Canvas r10) {
            r10.save();
            r10.clipPath(this.f4118n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            j(r10);
        L6:
            r10.restore();
            return;
        L5:
            i(r10);
            goto L6
        }

        private void i(Canvas r10) {
            MaterialShapeDrawable r11 = this.f4126v;
            RectF r12 = this.I;
            r11.setBounds((int) r12.left, (int) r12.top, (int) r12.right, (int) r12.bottom);
            this.f4126v.setElevation(this.f4104J);
            this.f4126v.setShadowVerticalOffset((int) this.K);
            this.f4126v.setShapeAppearanceModel(this.f4118n.c());
            this.f4126v.draw(r10);
        }

        private void j(Canvas r10) {
            com.google.android.material.shape.l r11 = this.f4118n.c();
            if (r11.u(this.I) == false) goto L5;
            float r12 = r11.r().a(this.I);
            r10.drawRoundRect(this.I, r12, r12, this.f4116l);
            return;
        L5:
            r10.drawPath(this.f4118n.d(), this.f4116l);
        }

        private void k(Canvas r10) {
            n(r10, this.f4115k);
            Rect r11 = getBounds();
            RectF r12 = this.f4129y;
            l.t(r10, r11, r12.left, r12.top, this.H.f4159b, this.G.f4138b, new b(this));
        }

        private void l(Canvas r10) {
            n(r10, this.f4114j);
            Rect r11 = getBounds();
            RectF r12 = this.f4127w;
            l.t(r10, r11, r12.left, r12.top, this.H.f4158a, this.G.f4137a, new a(this));
        }

        private static PointF m(RectF r10) {
            return new PointF(r10.centerX(), r10.top);
        }

        private void n(Canvas r10, Paint r11) {
            if (r11.getColor() != 0) goto L5;
            return;
        L5:
            if (r11.getAlpha() <= 0) goto L9;
            r10.drawRect(getBounds(), r11);
            return;
        }

        private void o(float r10) {
            if (this.L == r10) goto L6;
            p(r10);
            return;
        }

        private void p(float r13) {
            this.L = r13;
            Paint r10 = this.f4117m;
            if (this.f4122r == false) goto L5;
            float r11 = l.j(0.0f, 255.0f, r13);
        L6:
            r10.setAlpha((int) r11);
            this.f4119o.getPosTan(this.f4120p * r13, this.f4121q, null);
            float[] r12 = this.f4121q;
            float r14 = r12[0];
            float r15 = r12[1];
            if (r13 <= 1.0f) goto L9;
        L12:
            if (r13 <= 1.0f) goto L14;
            float r16 = 0.99f;
            float r17 = (r13 - 1.0f) / 0.00999999f;
        L15:
            this.f4119o.getPosTan(this.f4120p * r16, r12, null);
            float[] r18 = this.f4121q;
            r14 = r14 + ((r14 - r18[0]) * r17);
            r15 = r15 + ((r15 - r18[1]) * r17);
        L11:
            float r19 = r14;
            float r110 = r15;
            h r20 = this.C.c(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(b.a(c.b(this.A))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(b.b(c.b(this.A))))).floatValue(), this.f4106b.width(), this.f4106b.height(), this.f4110f.width(), this.f4110f.height());
            this.H = r20;
            RectF r21 = this.f4127w;
            float r22 = r20.f4160c;
            r21.set(r19 - (r22 / 2.0f), r110, (r22 / 2.0f) + r19, r20.f4161d + r110);
            RectF r23 = this.f4129y;
            h r24 = this.H;
            float r25 = r24.f4162e;
            r23.set(r19 - (r25 / 2.0f), r110, r19 + (r25 / 2.0f), r24.f4163f + r110);
            this.f4128x.set(this.f4127w);
            this.f4130z.set(this.f4129y);
            float r26 = ((Float) Preconditions.checkNotNull(Float.valueOf(b.a(c.c(this.A))))).floatValue();
            float r27 = ((Float) Preconditions.checkNotNull(Float.valueOf(b.b(c.c(this.A))))).floatValue();
            boolean r28 = this.C.a(this.H);
            if (r28 == false) goto L19;
            RectF r29 = this.f4128x;
        L20:
            float r30 = l.k(0.0f, 1.0f, r26, r27, r13);
            if (r28 == true) goto L24;
            r30 = 1.0f - r30;
        L24:
            this.C.b(r29, r30, this.H);
            this.I = new RectF(Math.min(this.f4128x.left, this.f4130z.left), Math.min(this.f4128x.top, this.f4130z.top), Math.max(this.f4128x.right, this.f4130z.right), Math.max(this.f4128x.bottom, this.f4130z.bottom));
            this.f4118n.b(r13, this.f4107c, this.f4111g, this.f4127w, this.f4128x, this.f4130z, c.d(this.A));
            this.f4104J = l.j(this.f4108d, this.f4112h, r13);
            float r31 = d(this.I, this.f4123s);
            float r32 = e(this.I, this.f4124t);
            float r33 = this.f4104J;
            float r34 = (int) (r32 * r33);
            this.K = r34;
            this.f4116l.setShadowLayer(r33, (int) (r31 * r33), r34, 754974720);
            this.G = this.B.a(r13, ((Float) Preconditions.checkNotNull(Float.valueOf(b.a(c.a(this.A))))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(b.b(c.a(this.A))))).floatValue(), 0.35f);
            if (this.f4114j.getColor() == 0) goto L28;
            this.f4114j.setAlpha(this.G.f4137a);
        L28:
            if (this.f4115k.getColor() == 0) goto L30;
            this.f4115k.setAlpha(this.G.f4138b);
        L30:
            invalidateSelf();
            return;
        L19:
            r29 = this.f4130z;
            goto L20
        L14:
            r16 = 0.01f;
            r17 = (r13 / 0.01f) * MaterialContainerTransform.ELEVATION_NOT_SET;
            goto L15
        L9:
            if (r13 >= 0.0f) goto L11;
        L5:
            r11 = l.j(255.0f, 0.0f, r13);
            goto L6
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r10) {
            if (this.f4117m.getAlpha() <= 0) goto L6;
            r10.drawRect(getBounds(), this.f4117m);
        L6:
            if (this.D == false) goto L8;
            int r11 = r10.save();
        L10:
            if (this.f4125u == true) goto L12;
        L14:
            this.f4118n.a(r10);
            n(r10, this.f4113i);
            if (this.G.f4139c == false) goto L17;
            l(r10);
            k(r10);
        L19:
            if (this.D == false) goto L22;
            r10.restoreToCount(r11);
            f(r10, this.f4127w, this.F, -65281);
            g(r10, this.f4128x, InputDeviceCompat.SOURCE_ANY);
            g(r10, this.f4127w, -16711936);
            g(r10, this.f4130z, -16711681);
            g(r10, this.f4129y, -16776961);
            return;
        L22:
            return;
        L17:
            k(r10);
            l(r10);
            goto L19
        L12:
            if (this.f4104J <= 0.0f) goto L14;
            h(r10);
            goto L14
        L8:
            r11 = -1;
            goto L10
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r10) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter r10) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    static {
        TAG = MaterialContainerTransform.class.getSimpleName();
        TRANSITION_PROPS = new String[]{PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
        DEFAULT_ENTER_THRESHOLDS = new c(new b(0.0f, 0.25f), new b(0.0f, 1.0f), new b(0.0f, 1.0f), new b(0.0f, 0.75f), null);
        a r14 = null;
        DEFAULT_RETURN_THRESHOLDS = new c(new b(0.6f, 0.9f), new b(0.0f, 1.0f), new b(0.0f, 0.9f), new b(0.3f, 0.9f), r14);
        DEFAULT_ENTER_THRESHOLDS_ARC = new c(new b(0.1f, 0.4f), new b(0.1f, 1.0f), new b(0.1f, 1.0f), new b(0.1f, 0.9f), null);
        DEFAULT_RETURN_THRESHOLDS_ARC = new c(new b(0.6f, 0.9f), new b(0.0f, 0.9f), new b(0.0f, 0.9f), new b(0.2f, 0.9f), r14);
    }

    public MaterialContainerTransform() {
        boolean r10 = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r10 = true;
    L5:
        this.elevationShadowEnabled = r10;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
    }

    public MaterialContainerTransform(@NonNull Context r10, boolean r11) {
        boolean r12 = false;
        this.drawDebugEnabled = false;
        this.holdAtEndEnabled = false;
        this.pathMotionCustom = false;
        this.appliedThemeValues = false;
        this.drawingViewId = R.id.content;
        this.startViewId = -1;
        this.endViewId = -1;
        this.containerColor = 0;
        this.startContainerColor = 0;
        this.endContainerColor = 0;
        this.scrimColor = 1375731712;
        this.transitionDirection = 0;
        this.fadeMode = 0;
        this.fitMode = 0;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r12 = true;
    L5:
        this.elevationShadowEnabled = r12;
        this.startElevation = ELEVATION_NOT_SET;
        this.endElevation = ELEVATION_NOT_SET;
        maybeApplyThemeValues(r10, r11);
        this.appliedThemeValues = true;
    }

    static /* synthetic */ boolean access$300(MaterialContainerTransform r10) {
        return r10.holdAtEndEnabled;
    }

    private c buildThresholdsGroup(boolean r10) {
        PathMotion r11 = getPathMotion();
        if ((r11 instanceof ArcMotion) == false) goto L5;
    L10:
        c r12 = DEFAULT_ENTER_THRESHOLDS_ARC;
        c r13 = DEFAULT_RETURN_THRESHOLDS_ARC;
    L9:
        return getThresholdsOrDefault(r10, r12, r13);
    L5:
        if ((r11 instanceof MaterialArcMotion) == true) goto L10;
        r12 = DEFAULT_ENTER_THRESHOLDS;
        r13 = DEFAULT_RETURN_THRESHOLDS;
        goto L9
    }

    private static RectF calculateDrawableBounds(View r10, @Nullable View r11, float r12, float r13) {
        if (r11 == null) goto L6;
        RectF r14 = l.g(r11);
        r14.offset(r12, r13);
        return r14;
    L6:
        return new RectF(0.0f, 0.0f, r10.getWidth(), r10.getHeight());
    }

    private static com.google.android.material.shape.l captureShapeAppearance(@NonNull View r10, @NonNull RectF r11, @Nullable com.google.android.material.shape.l r12) {
        return l.b(getShapeAppearance(r10, r12), r11);
    }

    private static void captureValues(@NonNull TransitionValues r10, @Nullable View r11, @IdRes int r12, @Nullable com.google.android.material.shape.l r13) {
        if (r12 == (-1)) goto L6;
        r11 = l.f(r10.view, r12);
    L5:
        r10.view = r11;
    L11:
        View r14 = r10.view;
        if (ViewCompat.isLaidOut(r14) == true) goto L18;
        if (r14.getWidth() != 0) goto L18;
        if (r14.getHeight() != 0) goto L18;
        return;
    L18:
        if (r14.getParent() != null) goto L20;
        RectF r15 = l.h(r14);
    L21:
        r10.values.put(PROP_BOUNDS, r15);
        r10.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(r14, r15, r13));
        return;
    L20:
        r15 = l.g(r14);
        goto L21
    L6:
        if (r11 != null) goto L5;
        View r16 = r10.view;
        int r17 = q5.f.mtrl_motion_snapshot_view;
        if ((r16.getTag(r17) instanceof View) == false) goto L11;
        r11 = (View) r10.view.getTag(r17);
        r10.view.setTag(r17, null);
        goto L5
    }

    private static float getElevationOrDefault(float r10, View r11) {
        if (r10 == ELEVATION_NOT_SET) goto L6;
        return r10;
    L6:
        return ViewCompat.getElevation(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.shape.l getShapeAppearance(@NonNull View r10, @Nullable com.google.android.material.shape.l r11) {
        if (r11 == null) goto L4;
        return r11;
    L4:
        int r12 = q5.f.mtrl_motion_snapshot_view;
        if ((r10.getTag(r12) instanceof com.google.android.material.shape.l) == true) goto L7;
        Context r13 = r10.getContext();
        int r14 = getTransitionShapeAppearanceResId(r13);
        if (r14 == (-1)) goto L13;
        return com.google.android.material.shape.l.b(r13, r14, 0).m();
    L13:
        if ((r10 instanceof p) == false) goto L17;
        return ((p) r10).getShapeAppearanceModel();
    L17:
        return com.google.android.material.shape.l.a().m();
    L7:
        return (com.google.android.material.shape.l) r10.getTag(r12);
    }

    private c getThresholdsOrDefault(boolean r10, c r11, c r12) {
        if (r10 == true) goto L6;
        r11 = r12;
    L6:
        return new c((b) l.d(this.fadeProgressThresholds, c.a(r11)), (b) l.d(this.scaleProgressThresholds, c.b(r11)), (b) l.d(this.scaleMaskProgressThresholds, c.c(r11)), (b) l.d(this.shapeMaskProgressThresholds, c.d(r11)), null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context r10) {
        TypedArray r11 = r10.obtainStyledAttributes(new int[]{q5.b.transitionShapeAppearance});
        int r12 = r11.getResourceId(0, -1);
        r11.recycle();
        return r12;
    }

    private boolean isEntering(@NonNull RectF r10, @NonNull RectF r11) {
        int r12 = this.transitionDirection;
        if (r12 == 0) goto L12;
        if (r12 != 1) goto L6;
        return true;
    L6:
        if (r12 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    L12:
        if (l.a(r11) > l.a(r10)) goto L14;
        return false;
    L14:
        return true;
    }

    private void maybeApplyThemeValues(Context r10, boolean r11) {
        l.p(this, r10, q5.b.motionEasingStandard, r5.a.f12674b);
        if (r11 == false) goto L5;
        int r12 = q5.b.motionDurationLong1;
    L6:
        l.o(this, r10, r12);
        if (this.pathMotionCustom == true) goto L10;
        l.q(this, r10, q5.b.motionPath);
        return;
    L10:
        return;
    L5:
        r12 = q5.b.motionDurationMedium2;
        goto L6
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r10) {
        captureValues(r10, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r10) {
        captureValues(r10, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r30, @Nullable TransitionValues r31, @Nullable TransitionValues r32) {
        if (r31 == null) goto L31;
        if (r32 == null) goto L31;
        RectF r10 = (RectF) r31.values.get(PROP_BOUNDS);
        com.google.android.material.shape.l r11 = (com.google.android.material.shape.l) r31.values.get(PROP_SHAPE_APPEARANCE);
        if (r10 == null) goto L30;
        if (r11 == null) goto L30;
        RectF r14 = (RectF) r32.values.get(PROP_BOUNDS);
        com.google.android.material.shape.l r15 = (com.google.android.material.shape.l) r32.values.get(PROP_SHAPE_APPEARANCE);
        if (r14 == null) goto L27;
        if (r15 == null) goto L27;
        final View r12 = r31.view;
        final View r13 = r32.view;
        if (r13.getParent() == null) goto L17;
        View r16 = r13;
    L19:
        if (this.drawingViewId != r16.getId()) goto L21;
        final View r17 = (View) r16.getParent();
        View r18 = r16;
    L22:
        RectF r19 = l.g(r17);
        float r20 = -r19.left;
        float r21 = -r19.top;
        RectF r22 = calculateDrawableBounds(r17, r18, r20, r21);
        r10.offset(r20, r21);
        r14.offset(r20, r21);
        boolean r23 = isEntering(r10, r14);
        if (this.appliedThemeValues == true) goto L25;
        maybeApplyThemeValues(r16.getContext(), r23);
    L25:
        final d r24 = new d(getPathMotion(), r12, r10, r11, getElevationOrDefault(this.startElevation, r12), r13, r14, r15, getElevationOrDefault(this.endElevation, r13), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, r23, this.elevationShadowEnabled, com.google.android.material.transition.b.a(this.fadeMode, r23), g.a(this.fitMode, r23, r10, r14), buildThresholdsGroup(r23), this.drawDebugEnabled, null);
        r24.setBounds(Math.round(r22.left), Math.round(r22.top), Math.round(r22.right), Math.round(r22.bottom));
        ValueAnimator r25 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r25.addUpdateListener(new a(this, r24));
        addListener(new AnonymousClass2(this, r17, r24, r12, r13));
        return r25;
    L21:
        r17 = l.e(r16, this.drawingViewId);
        r18 = null;
        goto L22
    L17:
        r16 = r12;
    L27:
        String r26 = TAG;
        String r27 = "Skipping due to null end bounds. Ensure end view is laid out and measured.";
    L28:
        Log.w(r26, r27);
        return null;
    L30:
        r26 = TAG;
        r27 = "Skipping due to null start bounds. Ensure start view is laid out and measured.";
    L31:
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.containerColor;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    @Nullable
    public com.google.android.material.shape.l getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    @Nullable
    public View getEndView() {
        return this.endView;
    }

    @IdRes
    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    @Nullable
    public b getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @Nullable
    public b getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @Nullable
    public b getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Nullable
    public b getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    @Nullable
    public com.google.android.material.shape.l getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    @Nullable
    public View getStartView() {
        return this.startView;
    }

    @IdRes
    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(@ColorInt int r10) {
        this.containerColor = r10;
        this.startContainerColor = r10;
        this.endContainerColor = r10;
    }

    public void setContainerColor(@ColorInt int r10) {
        this.containerColor = r10;
    }

    public void setDrawDebugEnabled(boolean r10) {
        this.drawDebugEnabled = r10;
    }

    public void setDrawingViewId(@IdRes int r10) {
        this.drawingViewId = r10;
    }

    public void setElevationShadowEnabled(boolean r10) {
        this.elevationShadowEnabled = r10;
    }

    public void setEndContainerColor(@ColorInt int r10) {
        this.endContainerColor = r10;
    }

    public void setEndElevation(float r10) {
        this.endElevation = r10;
    }

    public void setEndShapeAppearanceModel(@Nullable com.google.android.material.shape.l r10) {
        this.endShapeAppearanceModel = r10;
    }

    public void setEndView(@Nullable View r10) {
        this.endView = r10;
    }

    public void setEndViewId(@IdRes int r10) {
        this.endViewId = r10;
    }

    public void setFadeMode(int r10) {
        this.fadeMode = r10;
    }

    public void setFadeProgressThresholds(@Nullable b r10) {
        this.fadeProgressThresholds = r10;
    }

    public void setFitMode(int r10) {
        this.fitMode = r10;
    }

    public void setHoldAtEndEnabled(boolean r10) {
        this.holdAtEndEnabled = r10;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(@Nullable PathMotion r10) {
        super.setPathMotion(r10);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(@Nullable b r10) {
        this.scaleMaskProgressThresholds = r10;
    }

    public void setScaleProgressThresholds(@Nullable b r10) {
        this.scaleProgressThresholds = r10;
    }

    public void setScrimColor(@ColorInt int r10) {
        this.scrimColor = r10;
    }

    public void setShapeMaskProgressThresholds(@Nullable b r10) {
        this.shapeMaskProgressThresholds = r10;
    }

    public void setStartContainerColor(@ColorInt int r10) {
        this.startContainerColor = r10;
    }

    public void setStartElevation(float r10) {
        this.startElevation = r10;
    }

    public void setStartShapeAppearanceModel(@Nullable com.google.android.material.shape.l r10) {
        this.startShapeAppearanceModel = r10;
    }

    public void setStartView(@Nullable View r10) {
        this.startView = r10;
    }

    public void setStartViewId(@IdRes int r10) {
        this.startViewId = r10;
    }

    public void setTransitionDirection(int r10) {
        this.transitionDirection = r10;
    }
}
