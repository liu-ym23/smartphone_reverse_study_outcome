package com.larksuite.component.card.plugin.select;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CenterSmoothScroller extends LinearSmoothScroller {
    public CenterSmoothScroller(Context r1) {
        super(r1);
    }

    public final float calculateSpeedPerPixel(DisplayMetrics r2) {
        return 100.0f / r2.densityDpi;
    }

    public final int calculateDtToFit(int r1, int r2, int r3, int r4, int r5) {
        return (r3 + ((r4 - r3) / 2)) - (r1 + ((r2 - r1) / 2));
    }
}
