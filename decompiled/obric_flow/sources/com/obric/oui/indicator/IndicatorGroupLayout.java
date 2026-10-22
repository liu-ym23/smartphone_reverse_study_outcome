package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010!\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006\""}, d2 = {"Lcom/obric/oui/indicator/IndicatorGroupLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", SVGRenderEngine.DRAW, "", "setDrawBackground", "(Z)V", "d", "I", "getCornerRadius", "()I", "setCornerRadius", "(I)V", "cornerRadius", "value", "e", "Ljava/lang/Integer;", "getFixedContentWidthPx", "()Ljava/lang/Integer;", "setFixedContentWidthPx", "(Ljava/lang/Integer;)V", "fixedContentWidthPx", "f", "getBgColor", "setBgColor", "bgColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorGroupLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f13433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f13434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13435c;
    public int d;
    public Integer e;
    public int f;

    @JvmOverloads
    public IndicatorGroupLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final int getBgColor() {
        return this.f;
    }

    public final int getCornerRadius() {
        return this.d;
    }

    public final Integer getFixedContentWidthPx() {
        return this.e;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.f13435c == false) goto L5;
        RectF r10 = this.f13433a;
        r10.set(0.0f, 0.0f, getWidth(), getHeight());
        com.obric.oui.common.style.o.e(r5, r10, this.d * 1.0f, this.f13434b);
    L5:
        super.onDraw(r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        Integer r11 = this.e;
        if (r11 != null) goto L5;
        return;
    L5:
        int r12 = r11.intValue();
        int r13 = getPaddingLeft() + r12;
        int r14 = View.resolveSize(getPaddingRight() + r13, r5);
        if (getMeasuredWidth() == r14) goto L9;
        setMeasuredDimension(r14, getMeasuredHeight());
        return;
    }

    public final void setBgColor(int r5) {
        if (this.f == r5) goto L5;
        this.f = r5;
    L5:
        this.f13434b.setColor(r5);
    }

    public final void setCornerRadius(int r5) {
        this.d = r5;
    }

    public final void setDrawBackground(boolean r5) {
        this.f13435c = r5;
        invalidate();
    }

    public final void setFixedContentWidthPx(Integer r5) {
        if (Intrinsics.areEqual(this.e, r5) == true) goto L6;
        this.e = r5;
        requestLayout();
        invalidate();
        return;
    }

    @JvmOverloads
    public IndicatorGroupLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ IndicatorGroupLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public IndicatorGroupLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f13433a = new RectF();
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.FILL);
        this.f13434b = r12;
        setBackgroundColor(0);
    }
}
