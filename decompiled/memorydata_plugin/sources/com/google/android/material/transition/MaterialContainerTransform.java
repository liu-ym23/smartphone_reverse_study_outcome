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
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialContainerTransform extends Transition {
    private static final b DEFAULT_ENTER_THRESHOLDS = null;
    private static final b DEFAULT_ENTER_THRESHOLDS_ARC = null;
    private static final b DEFAULT_RETURN_THRESHOLDS = null;
    private static final b DEFAULT_RETURN_THRESHOLDS_ARC = null;
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
    private static final String TAG = "MaterialContainerTransform";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = null;
    private boolean appliedThemeValues;
    private int containerColor;
    private boolean drawDebugEnabled;
    private int drawingViewId;
    private boolean elevationShadowEnabled;
    private int endContainerColor;
    private float endElevation;
    private com.google.android.material.shape.l endShapeAppearanceModel;
    private View endView;
    private int endViewId;
    private int fadeMode;
    private a fadeProgressThresholds;
    private int fitMode;
    private boolean holdAtEndEnabled;
    private boolean pathMotionCustom;
    private a scaleMaskProgressThresholds;
    private a scaleProgressThresholds;
    private int scrimColor;
    private a shapeMaskProgressThresholds;
    private int startContainerColor;
    private float startElevation;
    private com.google.android.material.shape.l startShapeAppearanceModel;
    private View startView;
    private int startViewId;
    private int transitionDirection;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f4231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f4232b;

        public a(float r1, float r2) {
            this.f4231a = r1;
            this.f4232b = r2;
        }

        static /* synthetic */ float a(a r0) {
            return r0.f4231a;
        }

        static /* synthetic */ float b(a r0) {
            return r0.f4232b;
        }

        public float a() {
            return this.f4231a;
        }

        public float b() {
            return this.f4232b;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f4233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f4234b;
        private final a c;
        private final a d;

        private b(a r1, a r2, a r3, a r4) {
            this.f4233a = r1;
            this.f4234b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* synthetic */ b(a r1, a r2, a r3, a r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ a a(b r0) {
            return r0.f4233a;
        }

        static /* synthetic */ a b(b r0) {
            return r0.f4234b;
        }

        static /* synthetic */ a c(b r0) {
            return r0.c;
        }

        static /* synthetic */ a d(b r0) {
            return r0.d;
        }
    }

    private static final class c extends Drawable {
        private final b A;
        private final com.google.android.material.transition.a B;
        private final f C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private com.google.android.material.transition.c G;
        private h H;
        private RectF I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private float f4235J;
        private float K;
        private float L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f4236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RectF f4237b;
        private final com.google.android.material.shape.l c;
        private final float d;
        private final View e;
        private final RectF f;
        private final com.google.android.material.shape.l g;
        private final float h;
        private final Paint i;
        private final Paint j;
        private final Paint k;
        private final Paint l;
        private final Paint m;
        private final i n;
        private final PathMeasure o;
        private final float p;
        private final float[] q;
        private final boolean r;
        private final float s;
        private final float t;
        private final boolean u;
        private final MaterialShapeDrawable v;
        private final RectF w;
        private final RectF x;
        private final RectF y;
        private final RectF z;

        private c(PathMotion r17, View r18, RectF r19, com.google.android.material.shape.l r20, float r21, View r22, RectF r23, com.google.android.material.shape.l r24, float r25, int r26, int r27, int r28, int r29, boolean r30, boolean r31, com.google.android.material.transition.a r32, f r33, b r34, boolean r35) {
            com.google.android.material.transition.a r2 = (com.google.android.material.transition.a) ZeusTransformUtils.wrapperContextForParams(r32, com.google.android.material.transition.a.class, "com.obric.memorydata.plugin");
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r33, f.class, "com.obric.memorydata.plugin");
            Paint r5 = new Paint();
            this.i = r5;
            Paint r6 = new Paint();
            this.j = r6;
            Paint r7 = new Paint();
            this.k = r7;
            this.l = new Paint();
            Paint r8 = new Paint();
            this.m = r8;
            this.n = new i();
            this.q = new float[]{r19.centerX(), r19.top};
            MaterialShapeDrawable r11 = new MaterialShapeDrawable();
            this.v = r11;
            Paint r12 = new Paint();
            this.E = r12;
            this.F = new Path();
            this.f4236a = r18;
            this.f4237b = r19;
            this.c = r20;
            this.d = r21;
            this.e = r22;
            this.f = r23;
            this.g = r24;
            this.h = r25;
            this.r = r30;
            this.u = r31;
            this.B = r2;
            this.C = r4;
            this.A = r34;
            this.D = r35;
            WindowManager r3 = (WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r18.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin");
            DisplayMetrics r9 = new DisplayMetrics();
            r3.getDefaultDisplay().getMetrics(r9);
            this.s = r9.widthPixels;
            this.t = r9.heightPixels;
            r5.setColor(r26);
            r6.setColor(r27);
            r7.setColor(r28);
            r11.setFillColor(ColorStateList.valueOf(0));
            r11.setShadowCompatibilityMode(2);
            r11.setShadowBitmapDrawingEnable(false);
            r11.setShadowColor(-7829368);
            RectF r10 = new RectF(r19);
            this.w = r10;
            this.x = new RectF(r10);
            RectF r13 = new RectF(r10);
            this.y = r13;
            this.z = new RectF(r13);
            PointF r14 = a(r19);
            PointF r15 = a(r23);
            PathMeasure r16 = new PathMeasure(r17.getPath(r14.x, r14.y, r15.x, r15.y), false);
            this.o = r16;
            this.p = r16.getLength();
            r8.setStyle(Paint.Style.FILL);
            r8.setShader(l.a(r29));
            r12.setStyle(Paint.Style.STROKE);
            r12.setStrokeWidth(10.0f);
            b(0.0f);
        }

        /* synthetic */ c(PathMotion r21, View r22, RectF r23, com.google.android.material.shape.l r24, float r25, View r26, RectF r27, com.google.android.material.shape.l r28, float r29, int r30, int r31, int r32, int r33, boolean r34, boolean r35, com.google.android.material.transition.a r36, f r37, b r38, boolean r39, AnonymousClass1 r40) {
            this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, (com.google.android.material.transition.a) ZeusTransformUtils.wrapperContextForParams(r36, com.google.android.material.transition.a.class, "com.obric.memorydata.plugin"), (f) ZeusTransformUtils.wrapperContextForParams(r37, f.class, "com.obric.memorydata.plugin"), r38, r39);
        }

        private static float a(RectF r1, float r2) {
            return ((r1.centerX() / (r2 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static PointF a(RectF r2) {
            return new PointF(r2.centerX(), r2.top);
        }

        static /* synthetic */ View a(c r0) {
            return r0.f4236a;
        }

        private void a(float r2) {
            if (this.L == r2) goto L6;
            b(r2);
            return;
        }

        private void a(Canvas r3) {
            r3.save();
            r3.clipPath(this.n.a(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            b(r3);
        L6:
            r3.restore();
            return;
        L5:
            c(r3);
            goto L6
        }

        private void a(Canvas r2, Paint r3) {
            if (r3.getColor() != 0) goto L5;
            return;
        L5:
            if (r3.getAlpha() <= 0) goto L9;
            r2.drawRect(getBounds(), r3);
            return;
        }

        private void a(Canvas r2, RectF r3, int r4) {
            this.E.setColor(r4);
            r2.drawRect(r3, this.E);
        }

        private void a(Canvas r3, RectF r4, Path r5, int r6) {
            PointF r7 = a(r4);
            if (this.L != 0.0f) goto L5;
            r5.reset();
            r5.moveTo(r7.x, r7.y);
            return;
        L5:
            r5.lineTo(r7.x, r7.y);
            this.E.setColor(r6);
            r3.drawPath(r5, this.E);
        }

        static /* synthetic */ void a(c r0, float r1) {
            r0.a(r1);
        }

        private static float b(RectF r0, float r1) {
            return (r0.centerY() / r1) * 1.5f;
        }

        static /* synthetic */ View b(c r0) {
            return r0.e;
        }

        private void b(float r16) {
            this.L = r16;
            Paint r1 = this.m;
            if (this.r == false) goto L5;
            float r2 = l.a(0.0f, 255.0f, r16);
        L6:
            r1.setAlpha((int) r2);
            this.o.getPosTan(this.p * r16, this.q, null);
            float[] r3 = this.q;
            float r4 = r3[0];
            float r6 = r3[1];
            if (r16 <= 1.0f) goto L9;
        L12:
            if (r16 <= 1.0f) goto L14;
            float r7 = 0.99f;
            float r8 = (r16 - 1.0f) / 0.00999999f;
        L15:
            this.o.getPosTan(this.p * r7, r3, null);
            float[] r5 = this.q;
            r4 = r4 + ((r4 - r5[0]) * r8);
            r6 = r6 + ((r6 - r5[1]) * r8);
        L11:
            float r12 = r4;
            float r13 = r6;
            h r9 = this.C.a(r16, ((Float) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(Float.valueOf(a.a(b.b(this.A)))), Float.class, "com.obric.memorydata.plugin")).floatValue(), ((Float) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(Float.valueOf(a.b(b.b(this.A)))), Float.class, "com.obric.memorydata.plugin")).floatValue(), this.f4237b.width(), this.f4237b.height(), this.f.width(), this.f.height());
            this.H = r9;
            this.w.set(r12 - (r9.c / 2.0f), r13, (this.H.c / 2.0f) + r12, this.H.d + r13);
            this.y.set(r12 - (this.H.e / 2.0f), r13, r12 + (this.H.e / 2.0f), this.H.f + r13);
            this.x.set(this.w);
            this.z.set(this.y);
            float r10 = ((Float) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(Float.valueOf(a.a(b.c(this.A)))), Float.class, "com.obric.memorydata.plugin")).floatValue();
            float r11 = ((Float) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(Float.valueOf(a.b(b.c(this.A)))), Float.class, "com.obric.memorydata.plugin")).floatValue();
            boolean r14 = this.C.a(this.H);
            if (r14 == false) goto L19;
            RectF r15 = this.x;
        L20:
            float r17 = l.a(0.0f, 1.0f, r10, r11, r16);
            if (r14 == true) goto L24;
            r17 = 1.0f - r17;
        L24:
            this.C.a(r15, r17, this.H);
            this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
            this.n.a(r16, this.c, this.g, this.w, this.x, this.z, b.d(this.A));
            this.f4235J = l.a(this.d, this.h, r16);
            float r18 = a(this.I, this.s);
            float r19 = b(this.I, this.t);
            float r20 = this.f4235J;
            float r21 = (int) (r19 * r20);
            this.K = r21;
            this.l.setShadowLayer(r20, (int) (r18 * r20), r21, 754974720);
            this.G = this.B.a(r16, ((Float) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(Float.valueOf(a.a(b.a(this.A)))), Float.class, "com.obric.memorydata.plugin")).floatValue(), ((Float) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(Float.valueOf(a.b(b.a(this.A)))), Float.class, "com.obric.memorydata.plugin")).floatValue(), 0.35f);
            if (this.j.getColor() == 0) goto L28;
            this.j.setAlpha(this.G.f4242a);
        L28:
            if (this.k.getColor() == 0) goto L30;
            this.k.setAlpha(this.G.f4243b);
        L30:
            invalidateSelf();
            return;
        L19:
            r15 = this.z;
            goto L20
        L14:
            r7 = 0.01f;
            r8 = (r16 / 0.01f) * (-1.0f);
            goto L15
        L9:
            if (r16 >= 0.0f) goto L11;
        L5:
            r2 = l.a(255.0f, 0.0f, r16);
            goto L6
        }

        private void b(Canvas r3) {
            com.google.android.material.shape.l r0 = this.n.b();
            if (r0.a(this.I) == false) goto L5;
            float r1 = r0.f().a(this.I);
            r3.drawRoundRect(this.I, r1, r1, this.l);
            return;
        L5:
            r3.drawPath(this.n.a(), this.l);
        }

        private void c(Canvas r6) {
            this.v.setBounds((int) this.I.left, (int) this.I.top, (int) this.I.right, (int) this.I.bottom);
            this.v.setElevation(this.f4235J);
            this.v.setShadowVerticalOffset((int) this.K);
            this.v.setShapeAppearanceModel(this.n.b());
            this.v.draw(r6);
        }

        private void d(Canvas r9) {
            a(r9, this.j);
            l.a(r9, getBounds(), this.w.left, this.w.top, this.H.f4256a, this.G.f4242a, new AnonymousClass1(this));
        }

        private void e(Canvas r9) {
            a(r9, this.k);
            l.a(r9, getBounds(), this.y.left, this.y.top, this.H.f4257b, this.G.f4243b, new AnonymousClass2(this));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r4) {
            if (this.m.getAlpha() <= 0) goto L6;
            r4.drawRect(getBounds(), this.m);
        L6:
            if (this.D == false) goto L8;
            int r0 = r4.save();
        L10:
            if (this.u == true) goto L12;
        L14:
            this.n.a(r4);
            a(r4, this.i);
            if (this.G.c == false) goto L17;
            d(r4);
            e(r4);
        L19:
            if (this.D == false) goto L22;
            r4.restoreToCount(r0);
            a(r4, this.w, this.F, -65281);
            a(r4, this.x, InputDeviceCompat.SOURCE_ANY);
            a(r4, this.w, -16711936);
            a(r4, this.z, -16711681);
            a(r4, this.y, -16776961);
            return;
        L22:
            return;
        L17:
            e(r4);
            d(r4);
            goto L19
        L12:
            if (this.f4235J <= 0.0f) goto L14;
            a(r4);
            goto L14
        L8:
            r0 = -1;
            goto L10
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r1) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r1) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    static {
        TRANSITION_PROPS = new String[]{PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
        DEFAULT_ENTER_THRESHOLDS = new b(new a(0.0f, 0.25f), new a(0.0f, 1.0f), new a(0.0f, 1.0f), new a(0.0f, 0.75f), null);
        AnonymousClass1 r14 = null;
        DEFAULT_RETURN_THRESHOLDS = new b(new a(0.6f, 0.9f), new a(0.0f, 1.0f), new a(0.0f, 0.9f), new a(0.3f, 0.9f), r14);
        DEFAULT_ENTER_THRESHOLDS_ARC = new b(new a(0.1f, 0.4f), new a(0.1f, 1.0f), new a(0.1f, 1.0f), new a(0.1f, 0.9f), null);
        DEFAULT_RETURN_THRESHOLDS_ARC = new b(new a(0.6f, 0.9f), new a(0.0f, 0.9f), new a(0.0f, 0.9f), new a(0.2f, 0.9f), r14);
    }

    public MaterialContainerTransform() {
        boolean r0 = false;
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
        r0 = true;
    L5:
        this.elevationShadowEnabled = r0;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
    }

    public MaterialContainerTransform(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
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
        r0 = true;
    L5:
        this.elevationShadowEnabled = r0;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        maybeApplyThemeValues(r7, r6);
        this.appliedThemeValues = true;
    }

    static /* synthetic */ boolean access$300(MaterialContainerTransform r0) {
        return r0.holdAtEndEnabled;
    }

    private b buildThresholdsGroup(boolean r3) {
        PathMotion r0 = getPathMotion();
        if (ZeusTransformUtils.instanceOf(r0, ArcMotion.class) == false) goto L5;
    L10:
        b r1 = DEFAULT_ENTER_THRESHOLDS_ARC;
        b r2 = DEFAULT_RETURN_THRESHOLDS_ARC;
    L9:
        return getThresholdsOrDefault(r3, r1, r2);
    L5:
        if (ZeusTransformUtils.instanceOf(r0, MaterialArcMotion.class) == true) goto L10;
        r1 = DEFAULT_ENTER_THRESHOLDS;
        r2 = DEFAULT_RETURN_THRESHOLDS;
        goto L9
    }

    private static RectF calculateDrawableBounds(View r0, View r1, float r2, float r3) {
        if (r1 == null) goto L6;
        RectF r4 = l.b(r1);
        r4.offset(r2, r3);
        return r4;
    L6:
        return new RectF(0.0f, 0.0f, r0.getWidth(), r0.getHeight());
    }

    private static com.google.android.material.shape.l captureShapeAppearance(View r0, RectF r1, com.google.android.material.shape.l r2) {
        return l.a(getShapeAppearance(r0, r2), r1);
    }

    private static void captureValues(TransitionValues r3, View r4, int r5, com.google.android.material.shape.l r6) {
        if (r5 == (-1)) goto L6;
        r4 = l.a(r3.view, r5);
    L5:
        r3.view = r4;
    L11:
        View r7 = r3.view;
        if (ViewCompat.isLaidOut(r7) == true) goto L18;
        if (r7.getWidth() != 0) goto L18;
        if (r7.getHeight() != 0) goto L18;
        return;
    L18:
        if (r7.getParent() != null) goto L20;
        RectF r8 = l.a(r7);
    L21:
        r3.values.put(PROP_BOUNDS, r8);
        r3.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(r7, r8, r6));
        return;
    L20:
        r8 = l.b(r7);
        goto L21
    L6:
        if (r4 != null) goto L5;
        if (ZeusTransformUtils.instanceOf(r3.view.getTag(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_motion_snapshot_view, OaidModel.KEY_ID, "mtrl_motion_snapshot_view")), View.class) == false) goto L11;
        r4 = (View) ZeusTransformUtils.preCheckCast(r3.view.getTag(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_motion_snapshot_view, OaidModel.KEY_ID, "mtrl_motion_snapshot_view")), View.class, "com.obric.memorydata.plugin");
        r3.view.setTag(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_motion_snapshot_view, OaidModel.KEY_ID, "mtrl_motion_snapshot_view"), null);
        goto L5
    }

    private static float getElevationOrDefault(float r1, View r2) {
        if (r1 == (-1.0f)) goto L6;
        return r1;
    L6:
        return ViewCompat.getElevation(r2);
    }

    private static com.google.android.material.shape.l getShapeAppearance(View r3, com.google.android.material.shape.l r4) {
        if (r4 == null) goto L5;
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r3.getTag(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_motion_snapshot_view, OaidModel.KEY_ID, "mtrl_motion_snapshot_view")), com.google.android.material.shape.l.class) == true) goto L7;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r0 = getTransitionShapeAppearanceResId(r5);
        if (r0 == (-1)) goto L13;
        return com.google.android.material.shape.l.a(r5, r0, 0).a();
    L13:
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L17;
        return ((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).getShapeAppearanceModel();
    L17:
        return com.google.android.material.shape.l.a().a();
    L7:
        return (com.google.android.material.shape.l) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.mtrl_motion_snapshot_view, OaidModel.KEY_ID, "mtrl_motion_snapshot_view")), com.google.android.material.shape.l.class, "com.obric.memorydata.plugin");
    }

    private b getThresholdsOrDefault(boolean r7, b r8, b r9) {
        if (r7 == true) goto L6;
        r8 = r9;
    L6:
        return new b((a) ZeusTransformUtils.preCheckCast(l.a(this.fadeProgressThresholds, b.a(r8)), a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(l.a(this.scaleProgressThresholds, b.b(r8)), a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(l.a(this.scaleMaskProgressThresholds, b.c(r8)), a.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.preCheckCast(l.a(this.shapeMaskProgressThresholds, b.d(r8)), a.class, "com.obric.memorydata.plugin"), null);
    }

    private static int getTransitionShapeAppearanceResId(Context r4) {
        TypedArray r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(new int[]{ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.transitionShapeAppearance, "attr", "transitionShapeAppearance")});
        int r0 = r5.getResourceId(0, -1);
        r5.recycle();
        return r0;
    }

    private boolean isEntering(RectF r4, RectF r5) {
        int r0 = this.transitionDirection;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
    L12:
        if (l.a(r5) > l.a(r4)) goto L14;
        return false;
    L14:
        return true;
    }

    private void maybeApplyThemeValues(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        l.a(this, r6, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.motionEasingStandard, "attr", "motionEasingStandard"), com.google.android.material.a.a.f3742b);
        if (r5 == false) goto L5;
        int r7 = com.obric.memorydata.plugin.R.attr.motionDurationLong1;
        String r0 = "motionDurationLong1";
    L6:
        l.a(this, r6, ZeusTransformUtils.mapRes(r7, "attr", r0));
        if (this.pathMotionCustom == true) goto L10;
        l.b(this, r6, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.motionPath, "attr", "motionPath"));
        return;
    L10:
        return;
    L5:
        r7 = com.obric.memorydata.plugin.R.attr.motionDurationMedium2;
        r0 = "motionDurationMedium2";
        goto L6
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r3) {
        captureValues(r3, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r3) {
        captureValues(r3, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r31, TransitionValues r32, TransitionValues r33) {
        if (r32 == null) goto L31;
        if (r33 == null) goto L31;
        RectF r11 = (RectF) ZeusTransformUtils.preCheckCast(r32.values.get(PROP_BOUNDS), RectF.class, "com.obric.memorydata.plugin");
        com.google.android.material.shape.l r12 = (com.google.android.material.shape.l) ZeusTransformUtils.preCheckCast(r32.values.get(PROP_SHAPE_APPEARANCE), com.google.android.material.shape.l.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L30;
        if (r12 == null) goto L30;
        RectF r15 = (RectF) ZeusTransformUtils.preCheckCast(r33.values.get(PROP_BOUNDS), RectF.class, "com.obric.memorydata.plugin");
        com.google.android.material.shape.l r16 = (com.google.android.material.shape.l) ZeusTransformUtils.preCheckCast(r33.values.get(PROP_SHAPE_APPEARANCE), com.google.android.material.shape.l.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L27;
        if (r16 == null) goto L27;
        final View r4 = r32.view;
        final View r5 = r33.view;
        if (r5.getParent() == null) goto L17;
        View r0 = r5;
    L19:
        if (this.drawingViewId != r0.getId()) goto L21;
        final View r2 = (View) ZeusTransformUtils.preCheckCast(r0.getParent(), View.class, "com.obric.memorydata.plugin");
        View r1 = r0;
    L22:
        RectF r3 = l.b(r2);
        float r8 = -r3.left;
        float r6 = -r3.top;
        RectF r7 = calculateDrawableBounds(r2, r1, r8, r6);
        r11.offset(r8, r6);
        r15.offset(r8, r6);
        boolean r9 = isEntering(r11, r15);
        if (this.appliedThemeValues == true) goto L25;
        maybeApplyThemeValues((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9);
    L25:
        final c r10 = new c(getPathMotion(), r4, r11, r12, getElevationOrDefault(this.startElevation, r4), r5, r15, r16, getElevationOrDefault(this.endElevation, r5), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, r9, this.elevationShadowEnabled, com.google.android.material.transition.b.a(this.fadeMode, r9), g.a(this.fitMode, r9, r11, r15), buildThresholdsGroup(r9), this.drawDebugEnabled, null);
        r10.setBounds(Math.round(r7.left), Math.round(r7.top), Math.round(r7.right), Math.round(r7.bottom));
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r13.addUpdateListener(new AnonymousClass1(this, r10));
        addListener(new AnonymousClass2(this, r2, r10, r4, r5));
        return r13;
    L21:
        r2 = l.b(r0, this.drawingViewId);
        r1 = null;
        goto L22
    L17:
        r0 = r4;
    L27:
        String r14 = TAG;
        String r17 = "Skipping due to null end bounds. Ensure end view is laid out and measured.";
    L28:
        Log.w(r14, r17);
        return null;
    L30:
        r14 = TAG;
        r17 = "Skipping due to null start bounds. Ensure start view is laid out and measured.";
    L31:
        return null;
    }

    public int getContainerColor() {
        return this.containerColor;
    }

    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    public com.google.android.material.shape.l getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    public View getEndView() {
        return this.endView;
    }

    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    public a getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    public a getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    public a getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    public int getScrimColor() {
        return this.scrimColor;
    }

    public a getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    public com.google.android.material.shape.l getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    public View getStartView() {
        return this.startView;
    }

    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Override // androidx.transition.Transition
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

    public void setAllContainerColors(int r1) {
        this.containerColor = r1;
        this.startContainerColor = r1;
        this.endContainerColor = r1;
    }

    public void setContainerColor(int r1) {
        this.containerColor = r1;
    }

    public void setDrawDebugEnabled(boolean r1) {
        this.drawDebugEnabled = r1;
    }

    public void setDrawingViewId(int r1) {
        this.drawingViewId = r1;
    }

    public void setElevationShadowEnabled(boolean r1) {
        this.elevationShadowEnabled = r1;
    }

    public void setEndContainerColor(int r1) {
        this.endContainerColor = r1;
    }

    public void setEndElevation(float r1) {
        this.endElevation = r1;
    }

    public void setEndShapeAppearanceModel(com.google.android.material.shape.l r1) {
        this.endShapeAppearanceModel = r1;
    }

    public void setEndView(View r1) {
        this.endView = r1;
    }

    public void setEndViewId(int r1) {
        this.endViewId = r1;
    }

    public void setFadeMode(int r1) {
        this.fadeMode = r1;
    }

    public void setFadeProgressThresholds(a r1) {
        this.fadeProgressThresholds = r1;
    }

    public void setFitMode(int r1) {
        this.fitMode = r1;
    }

    public void setHoldAtEndEnabled(boolean r1) {
        this.holdAtEndEnabled = r1;
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion r1) {
        super.setPathMotion(r1);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(a r1) {
        this.scaleMaskProgressThresholds = r1;
    }

    public void setScaleProgressThresholds(a r1) {
        this.scaleProgressThresholds = r1;
    }

    public void setScrimColor(int r1) {
        this.scrimColor = r1;
    }

    public void setShapeMaskProgressThresholds(a r1) {
        this.shapeMaskProgressThresholds = r1;
    }

    public void setStartContainerColor(int r1) {
        this.startContainerColor = r1;
    }

    public void setStartElevation(float r1) {
        this.startElevation = r1;
    }

    public void setStartShapeAppearanceModel(com.google.android.material.shape.l r1) {
        this.startShapeAppearanceModel = r1;
    }

    public void setStartView(View r1) {
        this.startView = r1;
    }

    public void setStartViewId(int r1) {
        this.startViewId = r1;
    }

    public void setTransitionDirection(int r1) {
        this.transitionDirection = r1;
    }
}
