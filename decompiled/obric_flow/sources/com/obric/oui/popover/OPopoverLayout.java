package com.obric.oui.popover;

import ai.j0;
import android.content.Context;
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
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.common.oui.R$color;
import com.obric.oui.common.style.o;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u000fJ\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000fJ\u0015\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000fJ\r\u0010$\u001a\u00020\u0010¢\u0006\u0004\b$\u0010\u0015J\r\u0010%\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\t¢\u0006\u0004\b'\u0010&J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\r\u0010,\u001a\u00020+¢\u0006\u0004\b,\u0010-R\"\u00103\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0019R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u0010&\"\u0004\b7\u0010\u000fR\"\u0010=\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\u0013R\"\u0010A\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010:\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010\u0013R\"\u0010E\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00105\u001a\u0004\bC\u0010&\"\u0004\bD\u0010\u000fR\"\u0010K\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010!R\"\u0010O\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010G\u001a\u0004\bM\u0010I\"\u0004\bN\u0010!R\"\u0010S\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010G\u001a\u0004\bQ\u0010I\"\u0004\bR\u0010!R\"\u0010W\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u00105\u001a\u0004\bU\u0010&\"\u0004\bV\u0010\u000f¨\u0006X"}, d2 = {"Lcom/obric/oui/popover/OPopoverLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadiusDp", "", "setCornerRadiusDp", "(I)V", "", "cornerRadius", "setCornerRadius", "(F)V", "getCornerRadius", "()F", "", "str", "setSubText", "(Ljava/lang/String;)V", "color", "setBorderColor", "width", "setBorderWidth", "", "transparent", "setTransparentBg", "(Z)V", "bubbleOrientation", "setBubbleOrientation", "getBubbleOffset", "getPadding", "()I", "getArrowHeight", "Landroid/graphics/Path;", "getFullPath", "()Landroid/graphics/Path;", "Lcom/obric/oui/popover/c;", "getShadowConfig", "()Lcom/obric/oui/popover/c;", "a", "Ljava/lang/String;", "getMSubTitle", "()Ljava/lang/String;", "setMSubTitle", "mSubTitle", "c", "I", "getMPadding", "setMPadding", "mPadding", "i", "F", "getMWidth", "setMWidth", "mWidth", "j", "getMHeight", "setMHeight", "mHeight", "o", "getMBgColor", "setMBgColor", "mBgColor", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "Z", "getMNeedShadow", "()Z", "setMNeedShadow", "mNeedShadow", "q", "getMNeedArrow", "setMNeedArrow", "mNeedArrow", "r", "getUseDefaultView", "setUseDefaultView", "useDefaultView", "s", "getMAdjustHeight", "setMAdjustHeight", "mAdjustHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout {
    public final float A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f14102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14103c;
    public final Paint d;
    public final Path e;
    public final Path f;
    public RectF g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f14104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f14105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f14107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f14109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Canvas f14110n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14111o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14112p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f14113q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f14114r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f14115t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14116u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14117v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Paint f14118w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Path f14119x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Path f14120y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f14121z;

    public OPopoverLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public static int a(TextView r5) {
        String r10 = r5.getText().toString();
        TextPaint r11 = r5.getPaint();
        if (r11 == null) goto L16;
        if (StringsKt.g(r10, "\n") == false) goto L7;
        int r12 = 0;
        Iterator r13 = StringsKt.K(r10, new String[]{"\n"}, 0, 6).iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        int r14 = (int) r11.measureText((String) r13.next());
        if (r14 <= r12) goto L10;
        r12 = r14;
        goto L10
    L14:
        return r12;
    L7:
        return (int) r11.measureText(r10);
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.text.TextPaint");
    }

    public final int getArrowHeight() {
        return this.f14121z;
    }

    public final float getBubbleOffset() {
        float r5 = Math.max(this.f14107k, this.A);
        int r10 = this.f14108l;
        if (r10 == 0) goto L15;
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L18;
        if (r10 == 3) goto L17;
        return 0.0f;
    L17:
        return Math.min(r5, (this.f14105i - this.f14121z) - this.A);
    L18:
        return Math.min(r5, (this.f14106j - this.f14121z) - this.A);
    L19:
        return Math.min(r5, (this.f14106j - this.f14121z) - this.A);
    L15:
        return Math.min(r5, (this.f14105i - this.f14121z) - this.A);
    }

    public final float getCornerRadius() {
        return this.f14115t;
    }

    public final Path getFullPath() {
        Path r5 = this.e;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        return null;
    L6:
        return r5;
    }

    public final int getMAdjustHeight() {
        return this.s;
    }

    public final int getMBgColor() {
        return this.f14111o;
    }

    public final float getMHeight() {
        return this.f14106j;
    }

    public final boolean getMNeedArrow() {
        return this.f14113q;
    }

    public final boolean getMNeedShadow() {
        return this.f14112p;
    }

    public final int getMPadding() {
        return this.f14103c;
    }

    public final String getMSubTitle() {
        return this.f14101a;
    }

    public final float getMWidth() {
        return this.f14105i;
    }

    public final int getPadding() {
        return this.f14121z / 2;
    }

    public final c getShadowConfig() {
        return this.f14102b;
    }

    public final boolean getUseDefaultView() {
        return this.f14114r;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r17) {
        Paint r5 = this.d;
        Path r10 = this.e;
        float r11 = this.A;
        int r12 = this.f14121z;
        Intrinsics.checkNotNullParameter(r17, "canvas");
        if (this.f14109m != null) goto L6;
        this.f14109m = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Bitmap r13 = this.f14109m;
        Intrinsics.checkNotNull(r13);
        this.f14110n = new Canvas(r13);
    L6:
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        Paint r14 = null;
    L9:
        r14.setColor(getMBgColor());
        float r15 = this.f14105i;
        float r16 = this.f14106j;
        float r18 = Math.max(this.f14107k, r12 + r11);
        Matrix r19 = new Matrix();
        int r110 = this.f14116u;
        int r111 = r110 / 2;
        int r112 = this.f14108l;
        if (r112 != 0) goto L12;
        float r20 = Math.min(r18, (r15 - r12) - r11);
        float r113 = this.f14116u;
        r19.postRotate(90.0f);
        setPadding(0, r111, 0, 0);
    L22:
        setGravity(17);
        float r21 = r12;
        int r22 = this.f14116u;
        float r23 = (r22 / 2) + r21;
        float r24 = r22;
        this.g = new RectF(r23, r23, (this.f14105i - r21) - r24, (this.f14106j - r21) - r24);
        r19.postTranslate(r20, r113);
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        Path r25 = null;
    L26:
        r25.reset();
        Path r26 = this.f14119x;
        r26.reset();
        pp.b r27 = o.f12520a;
        RectF r28 = this.g;
        if (r28 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
        r28 = null;
    L29:
        float r29 = this.f14115t;
        Intrinsics.checkNotNullParameter(r26, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r28, SVGRenderEngine.RECT);
        r26.addPath(o.a(r28, r29));
        boolean r30 = this.f14113q;
        Path r31 = this.f14120y;
        if (r30 == false) goto L35;
        r31.reset();
        Path r32 = this.f;
        if (r32 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r32 = null;
    L34:
        r31.addPath(r32, r19);
        r26.op(r31, Path.Op.UNION);
    L35:
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        Path r33 = null;
    L38:
        r33.addPath(r26);
        if (this.f14112p == false) goto L44;
        if (r5 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        Paint r34 = null;
    L43:
        c r35 = this.f14102b;
        r34.setShadowLayer(r35.f14125a, r35.f14126b, r35.f14127c, r35.d);
        goto L44
    L42:
        r34 = r5;
    L44:
        Canvas r36 = this.f14110n;
        if (r36 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r36 = null;
    L47:
        if (r10 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        Path r37 = null;
    L50:
        if (r5 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r5 = null;
    L52:
        r36.drawPath(r37, r5);
        if (this.f14118w == null) goto L63;
        if (this.f14116u <= 0) goto L63;
        Canvas r38 = this.f14110n;
        if (r38 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r38 = null;
    L59:
        if (r10 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mPath");
        r10 = null;
    L61:
        Paint r39 = this.f14118w;
        Intrinsics.checkNotNull(r39);
        r38.drawPath(r10, r39);
    L63:
        if (this.f14104h == null) goto L68;
        Canvas r40 = this.f14110n;
        if (r40 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mCanvas");
        r40 = null;
    L67:
        Paint r41 = this.f14104h;
        Intrinsics.checkNotNull(r41);
        r40.drawPath(r31, r41);
    L68:
        Bitmap r42 = this.f14109m;
        Intrinsics.checkNotNull(r42);
        r17.drawBitmap(r42, 0.0f, 0.0f, null);
        return;
    L49:
        r37 = r10;
        goto L50
    L37:
        r33 = r10;
        goto L38
    L25:
        r25 = r10;
        goto L26
    L12:
        if (r112 == 1) goto L20;
        if (r112 != 2) goto L15;
        float r43 = r15 - r110;
        r113 = Math.min(r18, (r16 - r12) - r11);
        r19.postRotate(180.0f);
        setPadding(0, 0, r111, 0);
    L19:
        r20 = r43;
        goto L22
    L15:
        if (r112 == 3) goto L17;
        r20 = 0.0f;
        r113 = 0.0f;
        goto L22
    L17:
        r20 = Math.min(r18, (r15 - r12) - r11);
        r113 = r16 - this.f14116u;
        r19.postRotate(270.0f);
        setPadding(0, 0, 0, r111);
        goto L22
    L20:
        r43 = r110;
        r113 = Math.min(r18, (r16 - r12) - r11);
        setPadding(r111, 0, 0, 0);
        goto L19
    L8:
        r14 = r5;
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r5 = 0;
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
        int r18 = a(r13);
        int r19 = this.E;
        if (r18 > r19) goto L16;
        r19 = a(r13);
    L16:
        int r20 = r13.getPaddingRight() + (r13.getPaddingLeft() + r19);
    L19:
        if (this.f14114r == false) goto L28;
        int r21 = this.B;
        if (r20 <= r21) goto L23;
        r21 = (this.f14103c * 2) + r20;
    L23:
        int r22 = this.f14121z * 2;
        int r23 = this.f14116u * 2;
        int r24 = (r21 + r22) + r23;
        int r25 = (r22 + this.C) + r23;
        if (Intrinsics.areEqual(this.f14101a, "") == true) goto L27;
        r5 = this.D;
    L27:
        int r26 = r25 + r5;
    L30:
        if (r14 != Integer.MIN_VALUE) goto L33;
        if (r16 != Integer.MIN_VALUE) goto L33;
        setMeasuredDimension(r24, r26);
    L38:
        this.f14105i = getMeasuredWidth();
        this.f14106j = getMeasuredHeight();
        return;
    L33:
        if (r14 != Integer.MIN_VALUE) goto L35;
        setMeasuredDimension(r24, r17);
        goto L38
    L35:
        if (r16 != Integer.MIN_VALUE) goto L37;
        setMeasuredDimension(r15, r26);
        goto L38
    L37:
        setMeasuredDimension(r15, r17);
        goto L38
    L28:
        PopupWindow r27 = new PopupWindow(getChildAt(0), -2, -2, true);
        r27.getContentView().measure(0, 0);
        int r28 = r27.getContentView().getMeasuredWidth() + (this.f14121z * 2);
        r26 = r27.getContentView().getMeasuredHeight() + (this.f14121z * 2);
        r24 = r28;
        goto L30
    L17:
        r20 = getMeasuredWidth();
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L9:
        r13 = null;
        goto L10
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (r5 <= 0) goto L17;
        if (r10 <= 0) goto L18;
        Bitmap r13 = this.f14109m;
        if (r13 != null) goto L8;
        return;
    L8:
        if (getMeasuredWidth() != 0) goto L10;
        return;
    L10:
        if (getMeasuredHeight() != 0) goto L12;
        return;
    L12:
        if (r13.getHeight() == getMeasuredHeight()) goto L14;
    L15:
        Bitmap r14 = Bitmap.createBitmap(getContext().getResources().getDisplayMetrics(), getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f14110n = new Canvas(r14);
        this.f14109m = r14;
        StringBuilder r15 = j0.v("onSizeChanged, init new bg, w: ", r5, r10, ", h: ", ", oldw: ");
        r15.append(r11);
        r15.append(", oldh: ");
        r15.append(r12);
        ps.a.g("OPopoverLayout", r15.toString());
        return;
    L14:
        if (r13.getWidth() != getMeasuredWidth()) goto L15;
        return;
    L18:
        return;
    }

    public final void setBorderColor(int r5) {
        this.f14117v = r5;
    }

    public final void setBorderWidth(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        this.f14116u = r5;
        if (this.f14118w != null) goto L7;
        this.f14118w = new Paint();
    L7:
        Paint r10 = this.f14118w;
        if (r10 == null) goto L11;
        r10.setStyle(Paint.Style.STROKE);
    L11:
        Paint r11 = this.f14118w;
        if (r11 == null) goto L15;
        r11.setStrokeWidth(this.f14116u);
    L15:
        Paint r12 = this.f14118w;
        if (r12 == null) goto L19;
        r12.setStrokeCap(Paint.Cap.BUTT);
    L19:
        Paint r13 = this.f14118w;
        if (r13 == null) goto L23;
        r13.setStrokeJoin(Paint.Join.MITER);
    L23:
        Paint r14 = this.f14118w;
        if (r14 == null) goto L27;
        r14.setAntiAlias(true);
    L27:
        Paint r15 = this.f14118w;
        if (r15 == null) goto L31;
        r15.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    L31:
        Paint r16 = this.f14118w;
        if (r16 == null) goto L35;
        r16.setColor(this.f14117v);
    L35:
        Paint r17 = this.d;
        Paint r18 = null;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r17 = null;
    L38:
        r17.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint r19 = this.d;
        if (r19 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L42:
        r18.setStrokeWidth(this.f14116u);
        return;
    L41:
        r18 = r19;
        goto L42
    }

    public final void setBubbleOrientation(int r5) {
        this.f14108l = r5;
    }

    public final void setCornerRadius(@Px float r5) {
        this.f14115t = r5;
    }

    public final void setCornerRadiusDp(int r5) {
        this.f14115t = com.lynx.tasm.utils.a.E(r5, this);
    }

    public final void setMAdjustHeight(int r5) {
        this.s = r5;
    }

    public final void setMBgColor(int r5) {
        this.f14111o = r5;
    }

    public final void setMHeight(float r5) {
        this.f14106j = r5;
    }

    public final void setMNeedArrow(boolean r5) {
        this.f14113q = r5;
    }

    public final void setMNeedShadow(boolean r5) {
        this.f14112p = r5;
    }

    public final void setMPadding(int r5) {
        this.f14103c = r5;
    }

    public final void setMSubTitle(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14101a = r5;
    }

    public final void setMWidth(float r5) {
        this.f14105i = r5;
    }

    public final void setSubText(String r5) {
        Intrinsics.checkNotNullParameter(r5, "str");
        this.f14101a = r5;
    }

    public final void setTransparentBg(boolean r5) {
        if (r5 == false) goto L5;
        this.f14111o = 0;
        return;
    }

    public final void setUseDefaultView(boolean r5) {
        this.f14114r = r5;
    }

    public OPopoverLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0);
    }

    public OPopoverLayout(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        this.f14101a = "";
        c r15 = new c();
        r15.f14125a = 2.0f;
        r15.f14126b = 2.0f;
        r15.f14127c = 5.0f;
        r15.d = ViewCompat.MEASURED_STATE_MASK;
        this.f14102b = r15;
        this.f14107k = 0.75f;
        this.f14108l = 1;
        this.f14113q = true;
        this.f14114r = true;
        this.f14119x = new Path();
        this.f14120y = new Path();
        Intrinsics.checkNotNullParameter(r12, "context");
        this.f14121z = com.lynx.tasm.utils.a.B(7, this);
        this.A = com.lynx.tasm.utils.a.E(18, this);
        this.B = com.lynx.tasm.utils.a.B(40, this);
        this.C = com.lynx.tasm.utils.a.B(36, this);
        this.D = com.lynx.tasm.utils.a.B(20, this);
        this.f14103c = com.lynx.tasm.utils.a.B(12, this);
        this.E = com.lynx.tasm.utils.a.B(276, this);
        this.d = new Paint();
        this.e = new Path();
        this.f = new Path();
        Paint r16 = this.d;
        Path r5 = null;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r16 = null;
    L5:
        r16.setStyle(Paint.Style.FILL);
        Paint r17 = this.d;
        if (r17 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r17 = null;
    L8:
        r17.setStrokeCap(Paint.Cap.BUTT);
        Paint r18 = this.d;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r18 = null;
    L11:
        r18.setAntiAlias(true);
        Paint r19 = this.d;
        if (r19 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r19 = null;
    L14:
        r19.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.f14111o = ContextCompat.getColor(r12, R$color.SDPrimary);
    L17:
        Paint r110 = this.d;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r110 = null;
    L20:
        r110.setColor(getMBgColor());
        Path r111 = this.f;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r111 = null;
    L23:
        r111.moveTo(0.0f, 0.0f);
        float r112 = this.f14121z / 7.0f;
        Path r10 = this.f;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r11 = null;
    L27:
        float r113 = r112 * 0.0f;
        float r114 = r112 * 7.0f;
        r11.cubicTo(r113, r112 * (-2.5f), r114, r112 * (-4.0f), r114, r112 * (-10.0f));
        Path r20 = this.f;
        if (r20 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        r20 = null;
    L30:
        r20.lineTo(r114, 10.0f * r112);
        Path r21 = this.f;
        if (r21 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
        Path r22 = null;
    L34:
        r22.cubicTo(r114, r112 * 4.0f, r113, r112 * 2.5f, r113, r113);
        Path r115 = this.f;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mBubbleArrowPath");
    L38:
        r5.close();
        setBackgroundColor(0);
        setClipChildren(false);
        return;
    L37:
        r5 = r115;
        goto L38
    L33:
        r22 = r21;
        goto L34
    L26:
        r11 = r10;
        goto L27
    }
}
