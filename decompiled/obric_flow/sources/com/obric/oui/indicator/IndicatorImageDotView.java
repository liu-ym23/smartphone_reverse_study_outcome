package com.obric.oui.indicator;

import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0007R*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0007R\"\u0010\u001b\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010#\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0007¨\u0006$"}, d2 = {"Lcom/obric/oui/indicator/IndicatorImageDotView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/obric/oui/indicator/g;", "", "width", "", "setWidth", "(I)V", "horizontalMargin", "setHorizontalMargin", "margin", "setStartMargin", "setEndMargin", "value", "a", "I", "getDotColor", "()I", "setDotColor", "dotColor", "", "b", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "c", "getStrokeWidth", "setStrokeWidth", "strokeWidth", "d", "getStrokeColor", "setStrokeColor", "strokeColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IndicatorImageDotView extends AppCompatImageView implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13438c;
    public int d;

    public float getCornerRadius() {
        return this.f13437b;
    }

    public int getDotColor() {
        return this.f13436a;
    }

    public int getStrokeColor() {
        return this.d;
    }

    public float getStrokeWidth() {
        return this.f13438c;
    }

    @Override // com.obric.oui.indicator.g
    public void setCornerRadius(float r5) {
        this.f13437b = r5;
    }

    @Override // com.obric.oui.indicator.g
    public void setDotColor(int r5) {
        if (this.f13436a == r5) goto L5;
        this.f13436a = r5;
    L5:
        setColorFilter(r5);
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
        this.d = r5;
    }

    @Override // com.obric.oui.indicator.g
    public void setStrokeWidth(float r5) {
        this.f13438c = r5;
    }

    public void setWidth(int r5) {
        ym.m.s(r5, this);
    }
}
