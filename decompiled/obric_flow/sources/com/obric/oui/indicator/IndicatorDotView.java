package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000eR*\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00078\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u000eR*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00078\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u000eR*\u0010&\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u001f8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u0006+"}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotView;", "Landroid/view/View;", "Lcom/obric/oui/indicator/g;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "width", "", "setWidth", "(I)V", "horizontalMargin", "setHorizontalMargin", "margin", "setStartMargin", "setEndMargin", "value", "e", "I", "getDotColor", "()I", "setDotColor", "dotColor", "f", "getStrokeColor", "setStrokeColor", "strokeColor", "", "g", "F", "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "strokeWidth", "h", "getCornerRadius", "setCornerRadius", "cornerRadius", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorDotView extends View implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f13428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f13429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f13430c;
    public final Paint d;
    public int e;
    public int f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13431h;

    @JvmOverloads
    public IndicatorDotView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public float getCornerRadius() {
        return this.f13431h;
    }

    public int getDotColor() {
        return this.e;
    }

    public int getStrokeColor() {
        return this.f;
    }

    public float getStrokeWidth() {
        return this.g;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        RectF r5 = this.f13428a;
        r5.set(0.0f, 0.0f, getWidth(), getHeight());
        com.obric.oui.common.style.o.e(r10, r5, getCornerRadius(), this.f13430c);
        if (getStrokeWidth() <= 0.0f) goto L6;
        RectF r11 = this.f13429b;
        float r12 = 2;
        r11.set(getStrokeWidth() / r12, getStrokeWidth() / r12, getWidth() - (getStrokeWidth() / r12), getHeight() - (getStrokeWidth() / r12));
        com.obric.oui.common.style.o.e(r10, r11, getCornerRadius(), this.d);
        return;
    }

    @Override // com.obric.oui.indicator.g
    public void setCornerRadius(float r5) {
        this.f13431h = r5;
    }

    @Override // com.obric.oui.indicator.g
    public void setDotColor(int r5) {
        if (this.e == r5) goto L5;
        this.e = r5;
    L5:
        this.f13430c.setColor(r5);
    }

    @Override // com.obric.oui.indicator.g
    public void setEndMargin(int r5) {
        ViewGroup.LayoutParams r10 = getLayoutParams();
        ViewGroup.LayoutParams r11 = null;
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10;
    L6:
        if (r12 == null) goto L9;
        r12.setMarginEnd(r5);
        requestLayout();
        r11 = r12;
    L9:
        setLayoutParams(r11);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.g
    public void setHorizontalMargin(int r5) {
        ym.m.r(r5, this);
    }

    @Override // com.obric.oui.indicator.g
    public void setStartMargin(int r5) {
        ViewGroup.LayoutParams r10 = getLayoutParams();
        ViewGroup.LayoutParams r11 = null;
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10;
    L6:
        if (r12 == null) goto L9;
        r12.setMarginStart(r5);
        requestLayout();
        r11 = r12;
    L9:
        setLayoutParams(r11);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.obric.oui.indicator.g
    public void setStrokeColor(int r5) {
        if (this.f == r5) goto L5;
        this.f = r5;
    L5:
        this.d.setColor(r5);
    }

    @Override // com.obric.oui.indicator.g
    public void setStrokeWidth(float r5) {
        if (this.g == r5) goto L6;
        this.g = r5;
    L6:
        this.d.setStrokeWidth(r5);
    }

    public void setWidth(int r5) {
        ym.m.s(r5, this);
    }

    @JvmOverloads
    public IndicatorDotView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ IndicatorDotView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public IndicatorDotView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f13428a = new RectF();
        this.f13429b = new RectF();
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.FILL);
        this.f13430c = r12;
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.STROKE);
        this.d = r13;
        this.e = -7829368;
    }
}
