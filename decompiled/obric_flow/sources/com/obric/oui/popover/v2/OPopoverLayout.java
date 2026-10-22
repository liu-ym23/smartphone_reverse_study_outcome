package com.obric.oui.popover.v2;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import br.c;
import com.obric.common.oui.R$color;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\r2\b\b\u0001\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u000fJ\u0015\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u000fJ\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\t¢\u0006\u0004\b!\u0010 R\"\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0013R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010#\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0013R\"\u0010/\u001a\u00020\t8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\u000f¨\u00060"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverLayout;", "Landroid/widget/LinearLayout;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setBgColor", "(I)V", "", "cornerRadiusDp", "setCornerRadiusDp", "(F)V", "cornerRadius", "setCornerRadius", "getCornerRadius", "()F", "setBorderColor", "width", "setBorderWidth", "", "transparent", "setTransparentBg", "(Z)V", "getPadding", "()I", "getArrowHeight", "e", "F", "getMWidth", "setMWidth", "mWidth", "f", "getMHeight", "setMHeight", "mHeight", "g", "I", "getMBgColor", "setMBgColor", "mBgColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f14159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f14160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f14161c;
    public final RectF d;
    public float e;
    public float f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f14164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f14165k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14166l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1 f14167m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f14168n;

    public OPopoverLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14159a = com.lynx.tasm.utils.a.D(28.0f, this);
        Color.parseColor("#20000000");
        new ArgbEvaluator();
        this.f14161c = new Rect();
        this.d = new RectF();
        this.f14165k = true;
        this.f14167m = MaterialToken.OUI_Bg_Popup;
        this.f14168n = 3;
        a(r5);
    }

    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f14160b = new Paint();
        new Path();
        Paint r5 = this.f14160b;
        Paint r11 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r5 = null;
    L5:
        r5.setStyle(Paint.Style.FILL);
        Paint r12 = this.f14160b;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r12 = null;
    L8:
        r12.setStrokeCap(Paint.Cap.BUTT);
        Paint r13 = this.f14160b;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r13 = null;
    L11:
        boolean r14 = true;
        r13.setAntiAlias(true);
        Paint r15 = this.f14160b;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r15 = null;
    L14:
        r15.setStrokeJoin(Paint.Join.MITER);
        if (getMBgColor() != 0) goto L17;
        this.g = ContextCompat.getColor(r10, R$color.oui_bg_base_3);
    L17:
        Paint r16 = this.f14160b;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L21:
        r11.setColor(getMBgColor());
        setClipChildren(false);
        setOutlineProvider(new c(this, 7));
        setClipToOutline(true);
        setBackgroundColor(0);
        if (a.a.w(this) == true) goto L24;
    L26:
        r14 = false;
    L27:
        this.f14166l = r14;
        b();
        return;
    L24:
        if (n.k() == false) goto L26;
    L20:
        r11 = r16;
        goto L21
    }

    public final void b() {
        if (this.f14165k == true) goto L6;
        return;
    L6:
        if (this.f14166l == true) goto L9;
        return;
    L9:
        if (getMBgColor() != 0) goto L11;
        boolean r5 = a.a.v(this);
    L12:
        com.obric.oui.material.c[] r10 = (com.obric.oui.material.c[]) this.f14167m.invoke(Boolean.valueOf(!r5));
        if (r10 == null) goto L17;
        a.a.y(this, r10, false, this.f14168n, 10);
        return;
    L17:
        return;
    L11:
        r5 = h.j(getMBgColor());
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super.dispatchDraw(r5);
    }

    public final int getArrowHeight() {
        return 0;
    }

    public final float getCornerRadius() {
        return this.f14159a;
    }

    public final int getMBgColor() {
        return this.g;
    }

    public final float getMHeight() {
        return this.f;
    }

    public final float getMWidth() {
        return this.e;
    }

    public final int getPadding() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        n.p(this.f14168n, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n.p(0, this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        boolean r5 = this.f14166l;
        RectF r11 = this.d;
        Paint r12 = null;
        if (r5 == true) goto L12;
        Paint r13 = this.f14160b;
        if (r13 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r13 = null;
    L7:
        r13.setColor(getMBgColor());
        float r14 = this.f14159a;
        Paint r15 = this.f14160b;
        if (r15 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L11:
        r10.drawRoundRect(r11, r14, r14, r12);
    L17:
        Paint r16 = this.f14164j;
        if (r16 != null) goto L21;
        return;
    L21:
        if (this.f14162h <= 0) goto L24;
        float r17 = this.f14159a;
        r10.drawRoundRect(r11, r17, r17, r16);
        return;
    L24:
        return;
    L10:
        r12 = r15;
        goto L11
    L12:
        Paint r18 = this.f14160b;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
    L16:
        r12.getAlpha();
        goto L17
    L15:
        r12 = r18;
        goto L16
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        this.e = getMeasuredWidth();
        this.f = getMeasuredHeight();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
    }

    public final void setBgColor(@ColorInt int r5) {
        if (getMBgColor() != r5) goto L5;
        return;
    L5:
        this.g = r5;
        Paint r10 = this.f14160b;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFillPaint");
        r10 = null;
    L8:
        r10.setColor(getMBgColor());
        b();
    }

    public final void setBorderColor(int r5) {
        this.f14163i = r5;
        if (this.f14164j != null) goto L5;
        this.f14164j = new Paint(1);
    L5:
        Paint r10 = this.f14164j;
        if (r10 == null) goto L10;
        r10.setColor(this.f14163i);
        return;
    }

    public final void setBorderWidth(int r5) {
        if (r5 > 0) goto L4;
        return;
    L4:
        this.f14162h = r5;
        if (this.f14164j != null) goto L7;
        this.f14164j = new Paint(1);
    L7:
        Paint r10 = this.f14164j;
        if (r10 == null) goto L12;
        r10.setStyle(Paint.Style.STROKE);
        r10.setStrokeWidth(this.f14162h);
        r10.setStrokeCap(Paint.Cap.BUTT);
        r10.setStrokeJoin(Paint.Join.MITER);
        r10.setAntiAlias(true);
        r10.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        r10.setColor(this.f14163i);
        return;
    }

    public final void setCornerRadius(@Px float r5) {
        this.f14159a = r5;
    }

    public final void setCornerRadiusDp(float r5) {
        this.f14159a = com.lynx.tasm.utils.a.D(r5, this);
    }

    public final void setMBgColor(int r5) {
        this.g = r5;
    }

    public final void setMHeight(float r5) {
        this.f = r5;
    }

    public final void setMWidth(float r5) {
        this.e = r5;
    }

    public final void setTransparentBg(boolean r5) {
        setClipToOutline(!r5);
        if (r5 == false) goto L5;
        this.g = 0;
    L5:
        invalidateOutline();
        invalidate();
    }

    public OPopoverLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Function1<Boolean, com.obric.oui.material.c[]> r11 = MaterialToken.OUI_Bg_Popup;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r11, "materials");
        super(r5, r10, 0);
        this.f14159a = com.lynx.tasm.utils.a.D(28.0f, this);
        Color.parseColor("#20000000");
        new ArgbEvaluator();
        this.f14161c = new Rect();
        this.d = new RectF();
        this.f14165k = true;
        this.f14167m = r11;
        this.f14168n = 3;
        a(r5);
    }
}
