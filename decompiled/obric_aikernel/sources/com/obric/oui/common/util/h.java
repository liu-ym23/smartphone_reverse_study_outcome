package com.obric.oui.common.util;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: classes2.dex */
public class h extends PorterDuffColorFilter {
    public h(@ColorInt int r10) {
        super(r10, PorterDuff.Mode.SRC_ATOP);
    }
}
