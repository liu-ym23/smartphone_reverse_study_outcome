package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class StableGridLayoutManager extends GridLayoutManager {
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public StableGridLayoutManager(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
