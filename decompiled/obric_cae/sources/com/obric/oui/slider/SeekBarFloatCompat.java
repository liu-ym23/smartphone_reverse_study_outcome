package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import he.i;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class SeekBarFloatCompat extends tc.a {
    public SeekBarFloatCompat(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
    }

    private static float c(int r8) {
        String r10 = String.format(Locale.CHINA, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r8 / 100)}, 1));
        i.e(r10, "format(locale, this, *args)");
        return Float.parseFloat(r10);
    }

    public final float getFloatProgress() {
        return c(super.getProgress());
    }

    public final float getMaxValue() {
        return c(getMaxRealValue());
    }

    public final float getMinValue() {
        return c(getMinRealValue());
    }

    public final void setMaxValue(float r8) {
        super.setMaxValue((int) (r8 * 100));
    }

    public final void setMinValue(float r8) {
        super.setMinValue((int) (r8 * 100));
    }

    public final void setProgress(float r8) {
        super.setProgress((int) (r8 * 100));
    }
}
