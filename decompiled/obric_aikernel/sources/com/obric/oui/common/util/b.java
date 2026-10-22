package com.obric.oui.common.util;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final ColorMatrixColorFilter a(int r10) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r10), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r10), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r10), 0.0f, 0.0f, 0.0f, (Color.alpha(r10) * 1.0f) / 255, 0.0f});
    }
}
