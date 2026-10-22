package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f14819a;

    public OTitleBar(@NonNull Context r5) {
        super(r5);
    }

    public TextView getTitleView() {
        return this.f14819a;
    }

    public abstract void setDividerLineBackground(@ColorInt int r5);

    public void setTitle(CharSequence r5) {
        TextView r10 = this.f14819a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setText(r5);
    }

    public void setTitleColor(@ColorInt int r5) {
        TextView r10 = this.f14819a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setTextColor(r5);
    }

    public void setTitleSize(float r5) {
        TextView r10 = this.f14819a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setTextSize(r5);
    }

    public void setTitleSizePixel(float r5) {
        TextView r10 = this.f14819a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setTextSize(0, r5);
    }

    public OTitleBar(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
    }

    public OTitleBar(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        if (getBackground() != null) goto L6;
        setBackgroundColor(ContextCompat.getColor(r5, R$color.BGPrimary));
        return;
    }

    public void setTitle(@StringRes int r5) {
        TextView r10 = this.f14819a;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setText(r5);
    }
}
