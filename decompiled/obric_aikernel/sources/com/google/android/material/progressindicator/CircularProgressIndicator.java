package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import q5.k;

/* JADX INFO: loaded from: classes.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f3510t = 0;

    static {
        f3510t = k.Widget_MaterialComponents_CircularProgressIndicator;
    }

    public CircularProgressIndicator(@NonNull Context r10) {
        this(r10, null);
    }

    public CircularProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12, f3510t);
        s();
    }

    private void s() {
        setIndeterminateDrawable(IndeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.f3495c));
        setProgressDrawable(DeterminateDrawable.createCircularDrawable(getContext(), (CircularProgressIndicatorSpec) this.f3495c));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f3495c).f3513i;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f3495c).f3512h;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f3495c).f3511g;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* bridge */ /* synthetic */ b i(@NonNull Context r10, @NonNull AttributeSet r11) {
        return r(r10, r11);
    }

    CircularProgressIndicatorSpec r(@NonNull Context r10, @NonNull AttributeSet r11) {
        return new CircularProgressIndicatorSpec(r10, r11);
    }

    public void setIndicatorDirection(int r10) {
        ((CircularProgressIndicatorSpec) this.f3495c).f3513i = r10;
        invalidate();
    }

    public void setIndicatorInset(@Px int r10) {
        S r11 = this.f3495c;
        if (((CircularProgressIndicatorSpec) r11).f3512h == r10) goto L6;
        ((CircularProgressIndicatorSpec) r11).f3512h = r10;
        invalidate();
        return;
    }

    public void setIndicatorSize(@Px int r10) {
        int r11 = Math.max(r10, getTrackThickness() * 2);
        S r12 = this.f3495c;
        if (((CircularProgressIndicatorSpec) r12).f3511g == r11) goto L6;
        ((CircularProgressIndicatorSpec) r12).f3511g = r11;
        ((CircularProgressIndicatorSpec) r12).e();
        invalidate();
        return;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int r10) {
        super.setTrackThickness(r10);
        ((CircularProgressIndicatorSpec) this.f3495c).e();
    }
}
