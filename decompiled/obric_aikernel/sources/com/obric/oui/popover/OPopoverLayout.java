package com.obric.oui.popover;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextPaint;
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
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import o9.q;
import u8.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002TUB\u0011\b\u0016\u0012\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NB\u001b\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\bM\u0010QB#\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010R\u001a\u00020\n¢\u0006\u0004\bM\u0010SJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0019R\"\u0010!\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001e\"\u0004\b+\u0010 R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\"\u00104\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R\"\u0010;\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010#\u001a\u0004\b=\u0010%\"\u0004\b>\u0010'R\"\u0010F\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010J\u001a\u00020\n8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u00106\u001a\u0004\bH\u00108\"\u0004\bI\u0010:¨\u0006V"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout;", "Landroid/widget/LinearLayout;", "", "cornerRadius", "", "setCornerRadius", "getCornerRadius", "", "str", "setSubText", "", TypedValues.Custom.S_COLOR, "setBorderColor", "width", "setBorderWidth", "", "transparent", "setTransparentBg", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "getPadding", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "Lcom/obric/oui/popover/OPopoverLayout$b;", "getShadowConfig", "x", "Z", "getUseDefaultView", "()Z", "setUseDefaultView", "(Z)V", "useDefaultView", "p", "F", "getMHeight", "()F", "setMHeight", "(F)V", "mHeight", BaseSwitches.V, "getMNeedShadow", "setMNeedShadow", "mNeedShadow", "i", "getMPadding", "setMPadding", "mPadding", "w", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "y", "I", "getMAdjustHeight", "()I", "setMAdjustHeight", "(I)V", "mAdjustHeight", "o", "getMWidth", "setMWidth", "mWidth", "c", "Ljava/lang/String;", "getMSubTitle", "()Ljava/lang/String;", "setMSubTitle", "(Ljava/lang/String;)V", "mSubTitle", "u", "getMBgColor", "setMBgColor", "mBgColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OPopoverLayout extends LinearLayout {
    private static int F;
    private static float G;
    private static float H;
    private static int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static int f7102J;
    private static int K;
    private int A;
    private int B;
    private Paint C;
    private final Path D;
    private final Path E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7103c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f7105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f7106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Paint f7107j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Path f7108k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Path f7109l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RectF f7110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Paint f7111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f7112o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f7113p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f7114q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f7115r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Bitmap f7116s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Canvas f7117t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f7118u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f7119v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f7120w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f7121x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f7122y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f7123z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f7125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f7126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7127d;

        public b() {
            this(0.0f, 0.0f, 0.0f, 0, 15, null);
        }

        public b(float r10, float r11, float r12, @ColorInt int r13) {
            this.f7124a = r10;
            this.f7125b = r11;
            this.f7126c = r12;
            this.f7127d = r13;
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

        public final int a() {
            return this.f7127d;
        }

        public final float b() {
            return this.f7125b;
        }

        public final float c() {
            return this.f7126c;
        }

        public final float d() {
            return this.f7124a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof b) == false) goto L14;
            b r11 = (b) r10;
            if (Float.compare(this.f7124a, r11.f7124a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f7125b, r11.f7125b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f7126c, r11.f7126c) == 0) goto L12;
            return false;
        L12:
            if (this.f7127d == r11.f7127d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f7124a) * 31) + Float.hashCode(this.f7125b)) * 31) + Float.hashCode(this.f7126c)) * 31) + Integer.hashCode(this.f7127d);
        }

        public String toString() {
            return "ShadowConfig(radius=" + this.f7124a + ", dx=" + this.f7125b + ", dy=" + this.f7126c + ", color=" + this.f7127d + ")";
        }
    }

    static {
        new a(null);
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        F = MathKt.roundToInt(TypedValue.applyDimension(1, 7, r10.getDisplayMetrics()));
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        G = TypedValue.applyDimension(1, 28, r11.getDisplayMetrics());
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        TypedValue.applyDimension(1, 99, r12.getDisplayMetrics());
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        TypedValue.applyDimension(1, 12, r13.getDisplayMetrics());
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        H = TypedValue.applyDimension(1, 18, r14.getDisplayMetrics());
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        I = MathKt.roundToInt(TypedValue.applyDimension(1, 40, r15.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        f7102J = MathKt.roundToInt(TypedValue.applyDimension(1, 36, r16.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        K = MathKt.roundToInt(TypedValue.applyDimension(1, 20, r17.getDisplayMetrics()));
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
        this.f7103c = "";
        this.f7104g = G;
        this.f7105h = new b(0.0f, 0.0f, 0.0f, 0, 15, null);
        this.f7106i = 12.0f;
        this.f7114q = 0.75f;
        this.f7115r = 1;
        this.f7120w = true;
        this.f7121x = true;
        this.D = new Path();
        this.E = new Path();
        c(r10, r11);
    }

    private final int d(TextView r10) {
        String r11 = r10.getText().toString();
        TextPaint r12 = r10.getPaint();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type android.text.TextPaint");
        int r13 = 0;
        if (StringsKt.contains$default(r11, "\n", false, 2, null) == false) goto L5;
        Iterator r14 = StringsKt.split$default(r11, new String[]{"\n"}, false, 0, 6, null).iterator();
    L8:
        if (r14.hasNext() == false) goto L12;
        int r15 = (int) r12.measureText((String) r14.next());
        if (r15 <= r13) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    L5:
        return (int) r12.measureText(r11);
    }

    private final void f() {
        Path r10 = this.f7109l;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L5:
        r10.moveTo(0.0f, 0.0f);
        float r11 = F / 7.0f;
        Path r12 = this.f7109l;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L8:
        float r13 = r11 * 0.0f;
        float r14 = r11 * 7.0f;
        r12.cubicTo(r13, r11 * (-2.5f), r14, r11 * (-4.0f), r14, r11 * (-10.0f));
        Path r15 = this.f7109l;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L11:
        r15.lineTo(r14, 10.0f * r11);
        Path r16 = this.f7109l;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L14:
        r16.cubicTo(r14, r11 * 4.0f, r13, r11 * 2.5f, r13, r13);
        Path r17 = this.f7109l;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L17:
        r17.close();
    }

    public final int a() {
        return this.f7115r;
    }

    public final Matrix b(float r10, float r11) {
        float r12 = Math.max(this.f7114q, H + F);
        Matrix r13 = new Matrix();
        int r14 = this.A;
        int r15 = r14 / 2;
        int r16 = this.f7115r;
        float r17 = 0.0f;
        if (r16 != 0) goto L5;
        r17 = Math.min(r12, (r10 - F) - H);
        float r18 = this.A;
        r13.postRotate(90.0f);
        setPadding(0, r15, 0, 0);
    L15:
        setGravity(17);
        int r19 = F;
        int r20 = this.A;
        this.f7110m = new RectF(r19 + (r20 / 2), r19 + (r20 / 2), (this.f7112o - r19) - r20, (this.f7113p - r19) - r20);
        r13.postTranslate(r17, r18);
        Path r21 = this.f7108k;
        if (r21 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L18:
        r21.reset();
        this.D.reset();
        q r22 = q.f11614e;
        Path r23 = this.D;
        RectF r24 = this.f7110m;
        if (r24 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L21:
        r22.a(r23, r24, this.f7104g);
        if (this.f7120w == false) goto L27;
        this.E.reset();
        Path r25 = this.E;
        Path r26 = this.f7109l;
        if (r26 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L26:
        r25.addPath(r26, r13);
        this.D.op(this.E, Path.Op.UNION);
    L27:
        Path r27 = this.f7108k;
        if (r27 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L30:
        r27.addPath(this.D);
        return r13;
    L5:
        if (r16 != 1) goto L7;
        r17 = r14;
        r18 = Math.min(r12, (r11 - F) - H);
        setPadding(r15, 0, 0, 0);
        goto L15
    L7:
        if (r16 != 2) goto L9;
        r17 = r10 - r14;
        r18 = Math.min(r12, (r11 - F) - H);
        r13.postRotate(180.0f);
        setPadding(0, 0, r15, 0);
        goto L15
    L9:
        if (r16 == 3) goto L11;
        r18 = 0.0f;
        goto L15
    L11:
        r17 = Math.min(r12, (r10 - F) - H);
        r18 = r11 - this.A;
        r13.postRotate(270.0f);
        setPadding(0, 0, 0, r15);
        goto L15
    }

    public final void c(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f7107j = new Paint();
        this.f7108k = new Path();
        this.f7109l = new Path();
        Paint r12 = this.f7107j;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L5:
        r12.setStyle(Paint.Style.FILL);
        Paint r13 = this.f7107j;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r13.setStrokeCap(Paint.Cap.BUTT);
        Paint r14 = this.f7107j;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r14.setAntiAlias(true);
        Paint r15 = this.f7107j;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L14:
        r15.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f7118u = ContextCompat.getColor(r10, c.SDPrimary);
    L17:
        Paint r16 = this.f7107j;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L20:
        r16.setColor(getMBgColor());
        f();
        setBackgroundColor(0);
        setClipChildren(false);
    }

    public final void e(boolean r10, int r11) {
        if (r10 == true) goto L4;
        Paint r12 = this.f7111n;
        if (r12 == null) goto L23;
        r12.setColor(0);
        return;
    L23:
        return;
    L4:
        if (this.f7111n != null) goto L14;
        Paint r13 = new Paint();
        this.f7111n = r13;
        r13.setStyle(Paint.Style.FILL);
        Paint r14 = this.f7111n;
        if (r14 == null) goto L8;
        r14.setStrokeCap(Paint.Cap.BUTT);
    L8:
        Paint r15 = this.f7111n;
        if (r15 == null) goto L11;
        r15.setStrokeJoin(Paint.Join.MITER);
    L11:
        Paint r16 = this.f7111n;
        if (r16 == null) goto L14;
        r16.setAntiAlias(true);
    L14:
        Paint r17 = this.f7111n;
        if (r17 == null) goto L21;
        r17.setColor(r11);
        return;
    }

    public final int getArrowHeight() {
        return F;
    }

    public final float getBubbleOffset() {
        float r10 = Math.max(this.f7114q, H);
        int r11 = this.f7115r;
        if (r11 != 0) goto L5;
    L12:
        float r12 = this.f7112o;
    L14:
        return Math.min(r10, (r12 - F) - H);
    L5:
        if (r11 != 1) goto L7;
    L11:
        r12 = this.f7113p;
        goto L14
    L7:
        if (r11 == 2) goto L11;
        if (r11 == 3) goto L12;
        return 0.0f;
    }

    public final float getCornerRadius() {
        return this.f7104g;
    }

    public final Path getFullPath() {
        Path r10 = this.f7108k;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L5:
        return r10;
    }

    public final int getMAdjustHeight() {
        return this.f7122y;
    }

    public final int getMBgColor() {
        int r10 = this.f7123z;
        if (r10 == 0) goto L6;
        return r10;
    L6:
        return this.f7118u;
    }

    public final float getMHeight() {
        return this.f7113p;
    }

    public final boolean getMNeedArrow() {
        return this.f7120w;
    }

    public final boolean getMNeedShadow() {
        return this.f7119v;
    }

    public final float getMPadding() {
        return this.f7106i;
    }

    public final String getMSubTitle() {
        return this.f7103c;
    }

    public final float getMWidth() {
        return this.f7112o;
    }

    public final int getPadding() {
        return F / 2;
    }

    public final b getShadowConfig() {
        return this.f7105h;
    }

    public final boolean getUseDefaultView() {
        return this.f7121x;
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"CI_DrawAllocation"})
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f7116s != null) goto L5;
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        Resources r12 = r11.getResources();
        Intrinsics.checkNotNullExpressionValue(r12, "context.resources");
        this.f7116s = Bitmap.createBitmap(r12.getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r13 = this.f7116s;
        Intrinsics.checkNotNull(r13);
        this.f7117t = new Canvas(r13);
    L5:
        Paint r14 = this.f7107j;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L8:
        r14.setColor(getMBgColor());
        b(this.f7112o, this.f7113p);
        if (this.f7119v == false) goto L14;
        Paint r15 = this.f7107j;
        if (r15 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L13:
        r15.setShadowLayer(this.f7105h.d(), this.f7105h.b(), this.f7105h.c(), this.f7105h.a());
    L14:
        Canvas r16 = this.f7117t;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L17:
        Path r17 = this.f7108k;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L20:
        Paint r18 = this.f7107j;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L23:
        r16.drawPath(r17, r18);
        if (this.C == null) goto L35;
        if (this.A <= 0) goto L35;
        Canvas r19 = this.f7117t;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L30:
        Path r20 = this.f7108k;
        if (r20 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
    L33:
        Paint r21 = this.C;
        Intrinsics.checkNotNull(r21);
        r19.drawPath(r20, r21);
    L35:
        if (this.f7111n == null) goto L40;
        Canvas r22 = this.f7117t;
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
    L39:
        Path r23 = this.E;
        Paint r24 = this.f7111n;
        Intrinsics.checkNotNull(r24);
        r22.drawPath(r23, r24);
    L40:
        Bitmap r25 = this.f7116s;
        Intrinsics.checkNotNull(r25);
        r10.drawBitmap(r25, 0.0f, 0.0f, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    @SuppressLint({"CI_DrawAllocation"})
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = 0;
        if ((getChildAt(0) instanceof TextView) == false) goto L5;
        View r13 = getChildAt(0);
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.widget.TextView");
        TextView r14 = (TextView) r13;
    L6:
        int r15 = View.MeasureSpec.getMode(r10);
        int r16 = View.MeasureSpec.getSize(r10);
        int r17 = View.MeasureSpec.getMode(r11);
        int r18 = View.MeasureSpec.getSize(r11);
        if (r14 == null) goto L13;
        int r19 = d(r14);
        float r20 = 276;
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        if (r19 <= MathKt.roundToInt(TypedValue.applyDimension(1, r20, r21.getDisplayMetrics()))) goto L11;
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        int r23 = MathKt.roundToInt(TypedValue.applyDimension(1, r20, r22.getDisplayMetrics()));
    L12:
        int r24 = (r23 + r14.getPaddingLeft()) + r14.getPaddingRight();
    L15:
        if (this.f7121x == false) goto L24;
        int r25 = I;
        if (r24 <= r25) goto L19;
        float r26 = this.f7106i;
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        r25 = (MathKt.roundToInt(TypedValue.applyDimension(1, r26, r27.getDisplayMetrics())) * 2) + r24;
    L19:
        int r28 = F;
        int r29 = this.A;
        int r30 = (r25 + (r28 * 2)) + (r29 * 2);
        int r31 = (f7102J + (r28 * 2)) + (r29 * 2);
        if (Intrinsics.areEqual(this.f7103c, "") == true) goto L23;
        r12 = K;
    L23:
        int r32 = r31 + r12;
    L26:
        if (r15 != Integer.MIN_VALUE) goto L29;
        if (r17 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r30, r32);
    L34:
        this.f7112o = getMeasuredWidth();
        this.f7113p = getMeasuredHeight();
        return;
    L29:
        if (r15 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r30, r18);
        goto L34
    L31:
        if (r17 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r16, r32);
        goto L34
    L33:
        setMeasuredDimension(r16, r18);
        goto L34
    L24:
        PopupWindow r33 = new PopupWindow(getChildAt(0), -2, -2, true);
        r33.getContentView().measure(0, 0);
        View r34 = r33.getContentView();
        Intrinsics.checkNotNullExpressionValue(r34, "pop.contentView");
        int r35 = r34.getMeasuredWidth() + (F * 2);
        View r36 = r33.getContentView();
        Intrinsics.checkNotNullExpressionValue(r36, "pop.contentView");
        r32 = r36.getMeasuredHeight() + (F * 2);
        r30 = r35;
        goto L26
    L11:
        r23 = d(r14);
        goto L12
    L13:
        r24 = getMeasuredWidth();
        goto L15
    L5:
        r14 = null;
        goto L6
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 <= 0) goto L17;
        if (r11 <= 0) goto L18;
        Bitmap r14 = this.f7116s;
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
        this.f7117t = new Canvas(r17);
        this.f7116s = r17;
        ea.b.j("OPopoverLayout", "onSizeChanged, init new bg, w: " + r10 + ", h: " + r11 + ", oldw: " + r12 + ", oldh: " + r13);
        return;
    L14:
        if (r14.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    public final void setBorderColor(int r10) {
        this.B = r10;
    }

    public final void setBorderWidth(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        this.A = r10;
        if (this.C != null) goto L7;
        this.C = new Paint();
    L7:
        Paint r11 = this.C;
        if (r11 == null) goto L10;
        r11.setStyle(Paint.Style.STROKE);
    L10:
        Paint r12 = this.C;
        if (r12 == null) goto L13;
        r12.setStrokeWidth(this.A);
    L13:
        Paint r13 = this.C;
        if (r13 == null) goto L16;
        r13.setStrokeCap(Paint.Cap.BUTT);
    L16:
        Paint r14 = this.C;
        if (r14 == null) goto L19;
        r14.setStrokeJoin(Paint.Join.MITER);
    L19:
        Paint r15 = this.C;
        if (r15 == null) goto L22;
        r15.setAntiAlias(true);
    L22:
        Paint r16 = this.C;
        if (r16 == null) goto L25;
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L25:
        Paint r17 = this.C;
        if (r17 == null) goto L28;
        r17.setColor(this.B);
    L28:
        Paint r18 = this.f7107j;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L31:
        r18.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r19 = this.f7107j;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L34:
        r19.setStrokeWidth(this.A);
    }

    public final void setBubbleOrientation(int r10) {
        this.f7115r = r10;
    }

    public final void setCornerRadius(@Px float r10) {
        this.f7104g = r10;
    }

    public final void setMAdjustHeight(int r10) {
        this.f7122y = r10;
    }

    public final void setMBgColor(int r10) {
        this.f7118u = r10;
    }

    public final void setMHeight(float r10) {
        this.f7113p = r10;
    }

    public final void setMNeedArrow(boolean r10) {
        this.f7120w = r10;
    }

    public final void setMNeedShadow(boolean r10) {
        this.f7119v = r10;
    }

    public final void setMPadding(float r10) {
        this.f7106i = r10;
    }

    public final void setMSubTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7103c = r10;
    }

    public final void setMWidth(float r10) {
        this.f7112o = r10;
    }

    public final void setSubText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "str");
        this.f7103c = r10;
    }

    public final void setTransparentBg(boolean r10) {
        if (r10 == false) goto L5;
        this.f7118u = 0;
        return;
    }

    public final void setUseDefaultView(boolean r10) {
        this.f7121x = r10;
    }
}
