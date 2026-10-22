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
import u8.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected TextView f7718c;

    public OTitleBar(@NonNull Context r10) {
        super(r10);
    }

    public OTitleBar(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
    }

    public OTitleBar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        if (getBackground() != null) goto L6;
        setBackgroundColor(ContextCompat.getColor(r10, c.BGPrimary));
        return;
    }

    public TextView getTitleView() {
        return this.f7718c;
    }

    public abstract void setDividerLineBackground(@ColorInt int r10);

    public void setTitle(@StringRes int r10) {
        TextView r11 = this.f7718c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setText(r10);
    }

    public void setTitle(CharSequence r10) {
        TextView r11 = this.f7718c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setText(r10);
    }

    public void setTitleColor(@ColorInt int r10) {
        TextView r11 = this.f7718c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setTextColor(r10);
    }

    public void setTitleSize(float r10) {
        TextView r11 = this.f7718c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setTextSize(r10);
    }

    public void setTitleSizePixel(float r10) {
        TextView r11 = this.f7718c;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.setTextSize(0, r10);
    }
}
