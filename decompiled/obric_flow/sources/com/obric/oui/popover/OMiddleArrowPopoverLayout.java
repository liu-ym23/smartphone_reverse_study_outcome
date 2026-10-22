package com.obric.oui.popover;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u0001:\u0001$B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u0013J\r\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\t¢\u0006\u0004\b \u0010\u001fJ\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&R\"\u0010*\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u001e\u0010\u001d\"\u0004\b)\u0010\u0010R\"\u0010.\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010(\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u0010R\"\u00102\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010(\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u0010R\"\u00107\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010\u0013R\"\u0010=\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0019R\"\u0010A\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010\u0019R\"\u0010E\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00109\u001a\u0004\bC\u0010;\"\u0004\bD\u0010\u0019R\"\u0010I\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00104\u001a\u0004\bG\u0010\u001f\"\u0004\bH\u0010\u0013¨\u0006J"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "cornerRadius", "", "setCornerRadius", "(F)V", "color", "setBorderColor", "(I)V", "width", "setBorderWidth", "", "transparent", "setTransparentBg", "(Z)V", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "()F", "getPadding", "()I", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "()Landroid/graphics/Path;", "Lcom/obric/oui/popover/a;", "getShadowConfig", "()Lcom/obric/oui/popover/a;", "f", "F", "setPadding", "padding", "j", "getMWidth", "setMWidth", "mWidth", "k", "getMHeight", "setMHeight", "mHeight", "q", "I", "getMBgColor", "setMBgColor", "mBgColor", "r", "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "mNeedShadow", "s", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "t", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "u", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMiddleArrowPopoverLayout extends LinearLayout {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float f14080y = 0.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f14081z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14084c;
    public int d;
    public final a e;
    public float f;
    public final Paint g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f14085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Path f14086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f14089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bitmap f14091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Canvas f14092o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Drawable f14093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14095r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f14096t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14098v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14099w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Paint f14100x;

    static {
        f14080y = Integer.min(42, 42) / 2.0f;
        f14081z = 12;
    }

    public OMiddleArrowPopoverLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final int getArrowHeight() {
        return this.f14082a;
    }

    public final float getBubbleOffset() {
        float r5 = Math.max(this.f14089l, this.f14083b);
        int r10 = this.f14090m;
        if (r10 == 0) goto L15;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L18;
        if (r10 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r5, (this.f14087j - this.f14082a) - this.f14083b);
    L18:
        return Math.min(r5, (this.f14088k - this.f14082a) - this.f14083b);
    L19:
        return Math.min(r5, (this.f14088k - this.f14082a) - this.f14083b);
    L15:
        return Math.min(r5, (this.f14087j - this.f14082a) - this.f14083b);
    }

    public final Path getFullPath() {
        Path r5 = this.f14085h;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r5;
    }

    public final int getMAdjustHeight() {
        return this.f14097u;
    }

    public final int getMBgColor() {
        return this.f14094q;
    }

    public final float getMHeight() {
        return this.f14088k;
    }

    public final boolean getMNeedArrow() {
        return this.s;
    }

    public final boolean getMNeedShadow() {
        return this.f14095r;
    }

    public final float getMWidth() {
        return this.f14087j;
    }

    public final float getPadding() {
        return this.f;
    }

    public final a getShadowConfig() {
        return this.e;
    }

    public final boolean getUseDefaultView() {
        return this.f14096t;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f14082a = com.lynx.tasm.utils.a.p(9, getContext());
        this.f14083b = com.lynx.tasm.utils.a.s(getContext(), 18.0f);
        this.f14084c = com.lynx.tasm.utils.a.p(42, getContext());
        this.d = com.lynx.tasm.utils.a.p(42, getContext());
        com.lynx.tasm.utils.a.s(getContext(), f14080y);
        Context r10 = getContext();
        this.f = com.lynx.tasm.utils.a.r(f14081z, r10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f14091n != null) goto L5;
        this.f14091n = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r5 = this.f14091n;
        Intrinsics.checkNotNull(r5);
        this.f14092o = new Canvas(r5);
    L5:
        Paint r11 = this.g;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r11 = null;
    L8:
        r11.setColor(getMBgColor());
        Drawable r12 = this.f14093p;
        if (r12 == null) goto L34;
        int r13 = this.f14090m;
        if (r13 != 0) goto L14;
        float r14 = 270.0f;
    L21:
        int r15 = this.f14082a + ((int) getPadding());
        int r16 = this.f14082a;
        int r17 = (getHeight() - ((int) ((r12.getIntrinsicHeight() * ((getWidth() - r15) - r16)) / r12.getIntrinsicWidth()))) / 2;
        r12.setBounds(r15, r17, getWidth() - r16, getHeight() - r17);
        Canvas r18 = this.f14092o;
        if (r18 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r18 = null;
    L24:
        r18.save();
        Canvas r19 = this.f14092o;
        if (r19 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r19 = null;
    L27:
        r19.rotate(r14, getWidth() / 2.0f, getHeight() / 2.0f);
        Canvas r20 = this.f14092o;
        if (r20 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r20 = null;
    L30:
        r12.draw(r20);
        Canvas r21 = this.f14092o;
        if (r21 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r21 = null;
    L33:
        r21.restore();
        goto L34
    L14:
        if (r13 != 1) goto L16;
        r14 = 180.0f;
        goto L21
    L16:
        if (r13 == 3) goto L18;
        r14 = 0.0f;
        goto L21
    L18:
        r14 = 90.0f;
    L34:
        Bitmap r22 = this.f14091n;
        Intrinsics.checkNotNull(r22);
        r10.drawBitmap(r22, 0.0f, 0.0f, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        Path r5 = null;
        if ((getChildAt(0) instanceof TextView) == false) goto L9;
        View r12 = getChildAt(0);
        if (r12 == null) goto L8;
        TextView r13 = (TextView) r12;
    L10:
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        int r16 = View.MeasureSpec.getMode(r11);
        int r17 = View.MeasureSpec.getSize(r11);
        if (r13 == null) goto L17;
        int r18 = com.lynx.tasm.utils.a.p(276, getContext());
        if (((int) r13.getPaint().measureText(r13.getText().toString())) > r18) goto L16;
        r18 = (int) r13.getPaint().measureText(r13.getText().toString());
    L16:
        int r19 = r13.getPaddingRight() + (r13.getPaddingLeft() + r18);
    L19:
        if (this.f14096t == false) goto L24;
        int r20 = this.f14084c;
        if (r19 <= r20) goto L23;
        r20 = (((int) this.f) * 2) + r19;
    L23:
        int r21 = this.f14082a;
        int r22 = (r21 * 2) + r20;
        int r23 = this.f14098v;
        int r24 = (r23 * 2) + r22;
        int r25 = r23 * 2;
        int r26 = r25 + ((r21 * 2) + this.d);
    L26:
        if (r14 != Integer.MIN_VALUE) goto L29;
        if (r16 != Integer.MIN_VALUE) goto L29;
        setMeasuredDimension(r24, r26);
    L33:
        this.f14087j = getMeasuredWidth();
        float r27 = getMeasuredHeight();
        this.f14088k = r27;
        float r28 = r27 / 2.0f;
        float r110 = (this.f14082a + r28) - (r28 / 1.63f);
        float r29 = r28 / 1.56f;
        Path r30 = this.f14086i;
        if (r30 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r30 = null;
    L36:
        r30.reset();
        Path r31 = this.f14086i;
        if (r31 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r31 = null;
    L39:
        r31.moveTo(0.0f, 0.0f);
        Path r32 = this.f14086i;
        if (r32 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r32 = null;
    L42:
        r32.lineTo(r110, -r29);
        Path r33 = this.f14086i;
        if (r33 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r33 = null;
    L45:
        r33.lineTo(r110, r29);
        Path r34 = this.f14086i;
        if (r34 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r34 = null;
    L48:
        r34.lineTo(0.0f, 0.0f);
        Path r35 = this.f14086i;
        if (r35 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L52:
        r5.close();
        return;
    L51:
        r5 = r35;
    L29:
        if (r14 != Integer.MIN_VALUE) goto L31;
        setMeasuredDimension(r24, r17);
        goto L33
    L31:
        if (r16 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r15, r26);
        goto L33
    L24:
        PopupWindow r36 = new PopupWindow(getChildAt(0), -2, -2, true);
        r36.getContentView().measure(0, 0);
        r24 = r36.getContentView().getMeasuredWidth() + 18;
        r26 = r36.getContentView().getMeasuredHeight() + 18;
        goto L26
    L17:
        r19 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r13 = null;
        goto L10
    }

    public final void setBorderColor(int r5) {
        this.f14099w = r5;
    }

    public final void setBorderWidth(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        this.f14098v = r5;
        if (this.f14100x != null) goto L7;
        this.f14100x = new Paint();
    L7:
        Paint r10 = this.f14100x;
        if (r10 == null) goto L11;
        r10.setStyle(Paint.Style.STROKE);
    L11:
        Paint r11 = this.f14100x;
        if (r11 == null) goto L15;
        r11.setStrokeWidth(this.f14098v);
    L15:
        Paint r12 = this.f14100x;
        if (r12 == null) goto L19;
        r12.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r13 = this.f14100x;
        if (r13 == null) goto L23;
        r13.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r14 = this.f14100x;
        if (r14 == null) goto L27;
        r14.setAntiAlias(true);
    L27:
        Paint r15 = this.f14100x;
        if (r15 == null) goto L31;
        r15.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r16 = this.f14100x;
        if (r16 == null) goto L35;
        r16.setColor(this.f14099w);
    L35:
        Paint r17 = this.g;
        Paint r18 = null;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r17 = null;
    L38:
        r17.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r19 = this.g;
        if (r19 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r18.setStrokeWidth(this.f14098v);
        return;
    L41:
        r18 = r19;
        goto L42
    }

    public final void setBubbleOrientation(int r5) {
        this.f14090m = r5;
    }

    public final void setCornerRadius(@Px float r5) {
    }

    public final void setMAdjustHeight(int r5) {
        this.f14097u = r5;
    }

    public final void setMBgColor(int r5) {
        this.f14094q = r5;
    }

    public final void setMHeight(float r5) {
        this.f14088k = r5;
    }

    public final void setMNeedArrow(boolean r5) {
        this.s = r5;
    }

    public final void setMNeedShadow(boolean r5) {
        this.f14095r = r5;
    }

    public final void setMWidth(float r5) {
        this.f14087j = r5;
    }

    public final void setPadding(float r5) {
        this.f = r5;
    }

    public final void setTransparentBg(boolean r5) {
        if (r5 == false) goto L5;
        this.f14094q = 0;
        setLayerType(1, null);
        return;
    L5:
        setLayerType(1, null);
    }

    public final void setUseDefaultView(boolean r5) {
        this.f14096t = r5;
    }

    public OMiddleArrowPopoverLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0);
    }

    /* JADX INFO: renamed from: getPadding, reason: collision with other method in class */
    public final int m113getPadding() {
        return this.f14082a / 2;
    }

    public OMiddleArrowPopoverLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        a r12 = new a();
        r12.f14122a = 2.0f;
        r12.f14123b = 2.0f;
        r12.f14124c = 5.0f;
        r12.d = ViewCompat.MEASURED_STATE_MASK;
        this.e = r12;
        this.f14089l = 0.75f;
        this.f14090m = 1;
        this.s = true;
        this.f14096t = true;
        new Path();
        new Path();
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f14082a = com.lynx.tasm.utils.a.p(9, r5);
        this.f14083b = com.lynx.tasm.utils.a.s(r5, 18.0f);
        this.f14084c = com.lynx.tasm.utils.a.p(42, r5);
        this.d = com.lynx.tasm.utils.a.p(42, r5);
        com.lynx.tasm.utils.a.s(r5, f14080y);
        this.f = com.lynx.tasm.utils.a.r(f14081z, r5);
        this.g = new Paint();
        this.f14085h = new Path();
        this.f14086i = new Path();
        Paint r13 = this.g;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r13 = null;
    L5:
        r13.setStyle(Paint.Style.FILL);
        Paint r14 = this.g;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r14 = null;
    L8:
        r14.setStrokeCap(Paint.Cap.BUTT);
        Paint r15 = this.g;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r15 = null;
    L11:
        r15.setAntiAlias(true);
        Paint r16 = this.g;
        if (r16 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r16 = null;
    L14:
        r16.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f14094q = ContextCompat.getColor(r5, R$color.SDPrimary);
    L17:
        Paint r17 = this.g;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r17 = null;
    L20:
        r17.setColor(getMBgColor());
        setLayerType(1, null);
        setBackgroundColor(0);
        setClipChildren(false);
        this.f14093p = r5.getDrawable(R$drawable.o_bg_middle_arrow_popover);
    }
}
