package com.bytedance.android.live.core.tetris.componentx;

import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[LayerIndex.values().length];
        a = r0;
        LayerIndex r1 = LayerIndex.INDEX_SERVICE;
        r0[r1.ordinal()] = 1;
        LayerIndex r2 = LayerIndex.INDEX_XML;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[LayerIndex.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
