package com.bytedance.android.ec.common.impl.sku.utils;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    static {
    }

    public static int a(int r1, float r10) {
        return ColorUtils.setAlphaComponent(r1, (int) (r10 * 255));
    }
}
