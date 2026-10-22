package com.obric.oui.popover;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Px;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.c;
import u8.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002IJB\u0011\b\u0016\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CB\u001b\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bB\u0010FB#\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u0012\u0006\u0010G\u001a\u00020\u0006¢\u0006\u0004\bB\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015R\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\u00068F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R\"\u00103\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0018\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010&\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R\"\u0010;\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0018\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#¨\u0006K"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout;", "Landroid/widget/LinearLayout;", "", "cornerRadius", "", "setCornerRadius", "", TypedValues.Custom.S_COLOR, "setBorderColor", "width", "setBorderWidth", "", "transparent", "setTransparentBg", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "getPadding", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "Lcom/obric/oui/popover/OMiddleArrowPopoverLayout$b;", "getShadowConfig", "u", "Z", "getUseDefaultView", "()Z", "setUseDefaultView", "(Z)V", "useDefaultView", "l", "F", "getMHeight", "()F", "setMHeight", "(F)V", "mHeight", "r", "I", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBgColor", "k", "getMWidth", "setMWidth", "mWidth", "s", "getMNeedShadow", "setMNeedShadow", "mNeedShadow", BaseSwitches.V, "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "t", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "g", "getMPadding", "setMPadding", "mPadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OMiddleArrowPopoverLayout extends LinearLayout {
    private static int A;
    private static float B;
    private static int C;
    private static int D;
    private static float E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f7046c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f7048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Path f7049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Path f7050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f7051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f7052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f7053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Bitmap f7055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Canvas f7056p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f7057q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f7058r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f7059s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f7060t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f7061u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f7062v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f7063w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f7064x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f7065y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Paint f7066z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f7068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f7069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7070d;

        public b() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public b(float r10, float r11, float r12, @ColorInt int r13) {
            this.f7067a = r10;
            this.f7068b = r11;
            this.f7069c = r12;
            this.f7070d = r13;
        }

        public /* synthetic */ b(float r10, float r11, float r12, int r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 1) == 0) goto L6;
            r10 = 2.0f;
        L6:
            if ((r14 & 2) == 0) goto L9;
            r11 = 2.0f;
        L9:
            if ((r14 & 4) == 0) goto L12;
            r12 = 5.0f;
        L12:
            if ((r14 & 8) == 0) goto L14;
            r13 = ViewCompat.MEASURED_STATE_MASK;
        L14:
            this(r10, r11, r12, r13);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof b) == false) goto L14;
            b r11 = (b) r10;
            if (Float.compare(this.f7067a, r11.f7067a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f7068b, r11.f7068b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f7069c, r11.f7069c) == 0) goto L12;
            return false;
        L12:
            if (this.f7070d == r11.f7070d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f7067a) * 31) + Float.hashCode(this.f7068b)) * 31) + Float.hashCode(this.f7069c)) * 31) + Integer.hashCode(this.f7070d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f7067a + ", dx=" + this.f7068b + ", dy=" + this.f7069c + ", color=" + this.f7070d + ")";
        }
    }

    static {
        new a(null);
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        A = MathKt.roundToInt(TypedValue.applyDimension(1, 9, r10.getDisplayMetrics()));
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        B = TypedValue.applyDimension(1, 18, r11.getDisplayMetrics());
        float r12 = 42;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        C = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics()));
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        int r15 = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r14.getDisplayMetrics()));
        D = r15;
        E = Integer.min(r15, C) / 2.0f;
    }

    public OMiddleArrowPopoverLayout(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null);
    }

    public OMiddleArrowPopoverLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0);
    }

    public OMiddleArrowPopoverLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7046c = new b(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.f7047g = 12.0f;
        this.f7053m = 0.75f;
        this.f7054n = 1;
        this.f7060t = true;
        this.f7061u = true;
        new Path();
        new Path();
        a(r10, r11);
    }

    private final void b() {
        float r10 = A;
        float r11 = this.f7052l;
        float r12 = (r10 + (r11 / 2.0f)) - ((r11 / 2.0f) / 1.63f);
        float r13 = (r11 / 2.0f) / 1.56f;
        Path r14 = this.f7050j;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        r14.reset();
        Path r15 = this.f7050j;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L8:
        r15.moveTo(0.0f, 0.0f);
        Path r16 = this.f7050j;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L11:
        r16.lineTo(r12, -r13);
        Path r17 = this.f7050j;
        if (r17 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L14:
        r17.lineTo(r12, r13);
        Path r18 = this.f7050j;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L17:
        r18.lineTo(0.0f, 0.0f);
        Path r19 = this.f7050j;
        if (r19 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L20:
        r19.close();
    }

    public final void a(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f7048h = new Paint();
        this.f7049i = new Path();
        this.f7050j = new Path();
        Paint r12 = this.f7048h;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r12.setStyle(Paint.Style.FILL);
        Paint r13 = this.f7048h;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r13.setStrokeCap(Paint.Cap.BUTT);
        Paint r14 = this.f7048h;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r14.setAntiAlias(true);
        Paint r15 = this.f7048h;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r15.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f7058r = ContextCompat.getColor(r10, c.SDPrimary);
    L17:
        Paint r16 = this.f7048h;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r16.setColor(getMBgColor());
        setLayerType(1, null);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f7057q = r10.getDrawable(e.o_bg_middle_arrow_popover);
    }

    public final int getArrowHeight() {
        return A;
    }

    public final float getBubbleOffset() {
        float r10 = Math.max(this.f7053m, B);
        int r11 = this.f7054n;
        if (r11 != 0) goto L5;
    L12:
        float r12 = this.f7051k;
    L14:
        return Math.min(r10, (r12 - A) - B);
    L5:
        if (r11 != 1) goto L7;
    L11:
        r12 = this.f7052l;
        goto L14
    L7:
        if (r11 == 2) goto L11;
        if (r11 == 3) goto L12;
        return 0.0f;
    }

    public final Path getFullPath() {
        Path r10 = this.f7049i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L5:
        return r10;
    }

    public final int getMAdjustHeight() {
        return this.f7062v;
    }

    public final int getMBgColor() {
        int r10 = this.f7063w;
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.f7058r;
    }

    public final float getMHeight() {
        return this.f7052l;
    }

    public final boolean getMNeedArrow() {
        return this.f7060t;
    }

    public final boolean getMNeedShadow() {
        return this.f7059s;
    }

    public final float getMPadding() {
        return this.f7047g;
    }

    public final float getMWidth() {
        return this.f7051k;
    }

    public final int getPadding() {
        return A / 2;
    }

    public final b getShadowConfig() {
        return this.f7046c;
    }

    public final boolean getUseDefaultView() {
        return this.f7061u;
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"CI_DrawAllocation"})
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f7055o != null) goto L5;
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        Resources r12 = r11.getResources();
        Intrinsics.checkNotNullExpressionValue(r12, "context.resources");
        this.f7055o = Bitmap.createBitmap(r12.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r13 = this.f7055o;
        Intrinsics.checkNotNull(r13);
        this.f7056p = new Canvas(r13);
    L5:
        Paint r14 = this.f7048h;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r14.setColor(getMBgColor());
        Drawable r15 = this.f7057q;
        if (r15 == null) goto L33;
        int r16 = this.f7054n;
        if (r16 != 0) goto L13;
        float r17 = 270.0f;
    L20:
        int r18 = A;
        int r19 = ((int) this.f7047g) + r18;
        int r20 = (getHeight() - ((int) ((((getWidth() - r19) - r18) * r15.getIntrinsicHeight()) / r15.getIntrinsicWidth()))) / 2;
        r15.setBounds(r19, r20, getWidth() - r18, getHeight() - r20);
        Canvas r21 = this.f7056p;
        if (r21 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L23:
        r21.save();
        Canvas r22 = this.f7056p;
        if (r22 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L26:
        r22.rotate(r17, getWidth() / 2.0f, getHeight() / 2.0f);
        Canvas r23 = this.f7056p;
        if (r23 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L29:
        r15.draw(r23);
        Canvas r24 = this.f7056p;
        if (r24 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L32:
        r24.restore();
        goto L33
    L13:
        if (r16 != 1) goto L15;
        r17 = 180.0f;
        goto L20
    L15:
        if (r16 == 3) goto L17;
        r17 = 0.0f;
        goto L20
    L17:
        r17 = 90.0f;
    L33:
        Bitmap r25 = this.f7055o;
        Intrinsics.checkNotNull(r25);
        r10.drawBitmap(r25, 0.0f, 0.0f, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"CI_DrawAllocation"})
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if ((getChildAt(0) instanceof TextView) == false) goto L5;
        View r12 = getChildAt(0);
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.widget.TextView");
        TextView r13 = (TextView) r12;
    L6:
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        int r16 = View.MeasureSpec.getMode(r11);
        int r17 = View.MeasureSpec.getSize(r11);
        if (r13 == null) goto L13;
        int r18 = (int) r13.getPaint().measureText(r13.getText().toString());
        float r19 = 276;
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        if (r18 <= MathKt.roundToInt(TypedValue.applyDimension(1, r19, r20.getDisplayMetrics()))) goto L11;
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        int r22 = MathKt.roundToInt(TypedValue.applyDimension(1, r19, r21.getDisplayMetrics()));
    L12:
        int r23 = (r22 + r13.getPaddingLeft()) + r13.getPaddingRight();
    L15:
        if (this.f7061u == false) goto L20;
        int r24 = C;
        if (r23 <= r24) goto L19;
        float r25 = this.f7047g;
        Resources r26 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r26, "Resources.getSystem()");
        r24 = (MathKt.roundToInt(TypedValue.applyDimension(1, r25, r26.getDisplayMetrics())) * 2) + r23;
    L19:
        int r27 = A;
        int r28 = this.f7064x;
        int r29 = (r24 + (r27 * 2)) + (r28 * 2);
        int r30 = (D + (r27 * 2)) + (r28 * 2);
    L22:
        if (r14 != Integer.MIN_VALUE) goto L25;
        if (r16 != Integer.MIN_VALUE) goto L25;
        setMeasuredDimension(r29, r30);
    L29:
        this.f7051k = getMeasuredWidth();
        this.f7052l = getMeasuredHeight();
        b();
        return;
    L25:
        if (r14 != Integer.MIN_VALUE) goto L27;
        setMeasuredDimension(r29, r17);
        goto L29
    L27:
        if (r16 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r15, r30);
        goto L29
    L20:
        PopupWindow r31 = new PopupWindow(getChildAt(0), -2, -2, true);
        r31.getContentView().measure(0, 0);
        View r32 = r31.getContentView();
        Intrinsics.checkNotNullExpressionValue(r32, "pop.contentView");
        r29 = r32.getMeasuredWidth() + (A * 2);
        View r33 = r31.getContentView();
        Intrinsics.checkNotNullExpressionValue(r33, "pop.contentView");
        r30 = r33.getMeasuredHeight() + (A * 2);
        goto L22
    L11:
        r22 = (int) r13.getPaint().measureText(r13.getText().toString());
        goto L12
    L13:
        r23 = getMeasuredWidth();
        goto L15
    L5:
        r13 = null;
        goto L6
    }

    public final void setBorderColor(int r10) {
        this.f7065y = r10;
    }

    public final void setBorderWidth(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f7064x = r10;
        if (this.f7066z != null) goto L7;
        this.f7066z = new Paint();
    L7:
        Paint r11 = this.f7066z;
        if (r11 == null) goto L10;
        r11.setStyle(Paint.Style.STROKE);
    L10:
        Paint r12 = this.f7066z;
        if (r12 == null) goto L13;
        r12.setStrokeWidth(this.f7064x);
    L13:
        Paint r13 = this.f7066z;
        if (r13 == null) goto L16;
        r13.setStrokeCap(Paint.Cap.BUTT);
    L16:
        Paint r14 = this.f7066z;
        if (r14 == null) goto L19;
        r14.setStrokeJoin(Paint.Join.MITER);
    L19:
        Paint r15 = this.f7066z;
        if (r15 == null) goto L22;
        r15.setAntiAlias(true);
    L22:
        Paint r16 = this.f7066z;
        if (r16 == null) goto L25;
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L25:
        Paint r17 = this.f7066z;
        if (r17 == null) goto L28;
        r17.setColor(this.f7065y);
    L28:
        Paint r18 = this.f7048h;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L31:
        r18.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r19 = this.f7048h;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L34:
        r19.setStrokeWidth(this.f7064x);
    }

    public final void setBubbleOrientation(int r10) {
        this.f7054n = r10;
    }

    public final void setCornerRadius(@Px float r10) {
    }

    public final void setMAdjustHeight(int r10) {
        this.f7062v = r10;
    }

    public final void setMBgColor(int r10) {
        this.f7058r = r10;
    }

    public final void setMHeight(float r10) {
        this.f7052l = r10;
    }

    public final void setMNeedArrow(boolean r10) {
        this.f7060t = r10;
    }

    public final void setMNeedShadow(boolean r10) {
        this.f7059s = r10;
    }

    public final void setMPadding(float r10) {
        this.f7047g = r10;
    }

    public final void setMWidth(float r10) {
        this.f7051k = r10;
    }

    public final void setTransparentBg(boolean r10) {
        if (r10 == false) goto L5;
        this.f7058r = 0;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r10) {
        this.f7061u = r10;
    }
}
