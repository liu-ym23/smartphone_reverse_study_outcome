package com.obric.oui.popover.v2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.Px;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import ea.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b%\u0010)B#\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020\u0007¢\u0006\u0004\b%\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\"\u001a\u00020\u00078F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout;", "Landroid/widget/LinearLayout;", "", "cornerRadius", "", "setCornerRadius", "getCornerRadius", "", TypedValues.Custom.S_COLOR, "setBorderColor", "width", "setBorderWidth", "", "transparent", "setTransparentBg", "getPadding", "getArrowHeight", "j", "F", "getMWidth", "()F", "setMWidth", "(F)V", "mWidth", "k", "getMHeight", "setMHeight", "mHeight", "n", "I", "getMBgColor", "()I", "setMBgColor", "(I)V", "mBgColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OPopoverLayout extends LinearLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f7163s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static float f7164t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7165c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Paint f7166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Path f7167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RectF f7168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f7169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f7170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Bitmap f7171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Canvas f7172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f7176q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Paint f7177r;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        float r10 = 0;
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        f7163s = MathKt.roundToInt(TypedValue.applyDimension(1, r10, r11.getDisplayMetrics()));
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        f7164t = TypedValue.applyDimension(1, 28, r12.getDisplayMetrics());
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        TypedValue.applyDimension(1, r10, r13.getDisplayMetrics());
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        MathKt.roundToInt(TypedValue.applyDimension(1, 36, r14.getDisplayMetrics()));
    }

    public OPopoverLayout(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null);
    }

    public OPopoverLayout(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0);
    }

    public OPopoverLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f7165c = f7164t;
        a(r10, r11);
    }

    public final void a(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f7166g = new Paint();
        this.f7167h = new Path();
        Paint r12 = this.f7166g;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r12.setStyle(Paint.Style.FILL);
        Paint r13 = this.f7166g;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r13.setStrokeCap(Paint.Cap.BUTT);
        Paint r14 = this.f7166g;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r14.setAntiAlias(true);
        Paint r15 = this.f7166g;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r15.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f7173n = ContextCompat.getColor(r10, c.SDPrimary);
    L17:
        Paint r16 = this.f7166g;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r16.setColor(getMBgColor());
        setBackgroundColor(0);
        setClipChildren(false);
    }

    public final int getArrowHeight() {
        return f7163s;
    }

    public final float getCornerRadius() {
        return this.f7165c;
    }

    public final int getMBgColor() {
        int r10 = this.f7174o;
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.f7173n;
    }

    public final float getMHeight() {
        return this.f7170k;
    }

    public final float getMWidth() {
        return this.f7169j;
    }

    public final int getPadding() {
        return f7163s / 2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"CI_DrawAllocation"})
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f7171l != null) goto L5;
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        Resources r12 = r11.getResources();
        Intrinsics.checkNotNullExpressionValue(r12, "context.resources");
        this.f7171l = Bitmap.createBitmap(r12.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r13 = this.f7171l;
        Intrinsics.checkNotNull(r13);
        this.f7172m = new Canvas(r13);
    L5:
        Paint r14 = this.f7166g;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r14.setColor(getMBgColor());
        float r15 = this.f7175p / 2.0f;
        this.f7168i = new RectF(r15, r15, this.f7169j - r15, this.f7170k - r15);
        Path r16 = this.f7167h;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L11:
        r16.reset();
        float r17 = this.f7165c;
        float[] r18 = {r17, r17, r17, r17, r17, r17, r17, r17};
        Path r19 = this.f7167h;
        if (r19 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L14:
        RectF r20 = this.f7168i;
        if (r20 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L17:
        r19.addRoundRect(r20, r18, Path.Direction.CW);
        Canvas r21 = this.f7172m;
        if (r21 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L20:
        Path r22 = this.f7167h;
        if (r22 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L23:
        Paint r23 = this.f7166g;
        if (r23 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L26:
        r21.drawPath(r22, r23);
        if (this.f7177r != null) goto L29;
    L37:
        Bitmap r24 = this.f7171l;
        Intrinsics.checkNotNull(r24);
        r10.drawBitmap(r24, 0.0f, 0.0f, null);
        return;
    L29:
        if (this.f7175p <= 0) goto L37;
        Canvas r25 = this.f7172m;
        if (r25 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L33:
        Path r26 = this.f7167h;
        if (r26 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L36:
        Paint r27 = this.f7177r;
        Intrinsics.checkNotNull(r27);
        r25.drawPath(r26, r27);
        goto L37
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"CI_DrawAllocation"})
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        PopupWindow r16 = new PopupWindow(getChildAt(0), -2, -2, true);
        r16.getContentView().measure(0, 0);
        View r17 = r16.getContentView();
        Intrinsics.checkNotNullExpressionValue(r17, "pop.contentView");
        int r18 = r17.getMeasuredWidth() + (f7163s * 2);
        View r19 = r16.getContentView();
        Intrinsics.checkNotNullExpressionValue(r19, "pop.contentView");
        int r20 = r19.getMeasuredHeight() + (f7163s * 2);
        if (r12 != Integer.MIN_VALUE) goto L6;
        if (r14 != Integer.MIN_VALUE) goto L6;
        setMeasuredDimension(r18, r20);
    L11:
        this.f7169j = getMeasuredWidth();
        this.f7170k = getMeasuredHeight();
        return;
    L6:
        if (r12 != Integer.MIN_VALUE) goto L8;
        setMeasuredDimension(r18, r15);
        goto L11
    L8:
        if (r14 != Integer.MIN_VALUE) goto L10;
        setMeasuredDimension(r13, r20);
        goto L11
    L10:
        setMeasuredDimension(r13, r15);
        goto L11
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 <= 0) goto L17;
        if (r11 <= 0) goto L18;
        Bitmap r14 = this.f7171l;
        if (r14 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r14.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Context r15 = getContext();
        Intrinsics.checkNotNullExpressionValue(r15, "context");
        Resources r16 = r15.getResources();
        Intrinsics.checkNotNullExpressionValue(r16, "context.resources");
        Bitmap r17 = Bitmap.createBitmap(r16.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f7172m = new Canvas(r17);
        this.f7171l = r17;
        b.j("OPopoverLayout", "onSizeChanged, init new bg, w: " + r10 + ", h: " + r11 + ", oldw: " + r12 + ", oldh: " + r13);
        return;
    L14:
        if (r14.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    public final void setBorderColor(int r10) {
        this.f7176q = r10;
    }

    public final void setBorderWidth(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.f7175p = r10;
        if (this.f7177r != null) goto L7;
        this.f7177r = new Paint();
    L7:
        Paint r11 = this.f7177r;
        if (r11 == null) goto L10;
        r11.setStyle(Paint.Style.STROKE);
    L10:
        Paint r12 = this.f7177r;
        if (r12 == null) goto L13;
        r12.setStrokeWidth(this.f7175p);
    L13:
        Paint r13 = this.f7177r;
        if (r13 == null) goto L16;
        r13.setStrokeCap(Paint.Cap.BUTT);
    L16:
        Paint r14 = this.f7177r;
        if (r14 == null) goto L19;
        r14.setStrokeJoin(Paint.Join.MITER);
    L19:
        Paint r15 = this.f7177r;
        if (r15 == null) goto L22;
        r15.setAntiAlias(true);
    L22:
        Paint r16 = this.f7177r;
        if (r16 == null) goto L25;
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L25:
        Paint r17 = this.f7177r;
        if (r17 == null) goto L28;
        r17.setColor(this.f7176q);
    L28:
        Paint r18 = this.f7166g;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L31:
        r18.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r19 = this.f7166g;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L34:
        r19.setStrokeWidth(this.f7175p);
    }

    public final void setCornerRadius(@Px float r10) {
        this.f7165c = r10;
    }

    public final void setMBgColor(int r10) {
        this.f7173n = r10;
    }

    public final void setMHeight(float r10) {
        this.f7170k = r10;
    }

    public final void setMWidth(float r10) {
        this.f7169j = r10;
    }

    public final void setTransparentBg(boolean r10) {
        if (r10 == false) goto L5;
        this.f7173n = 0;
        return;
    }
}
