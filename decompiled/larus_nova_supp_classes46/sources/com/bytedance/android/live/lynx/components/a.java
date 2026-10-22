package com.bytedance.android.live.lynx.components;

import com.bytedance.android.live.browser.LynxThreadStrategy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LynxThreadStrategy.values().length];
        a = r0;
        r0[LynxThreadStrategy.MOST_ON_TASM.ordinal()] = 1;
        r0[LynxThreadStrategy.PART_ON_LAYOUT.ordinal()] = 2;
        r0[LynxThreadStrategy.MULTI_THREADS.ordinal()] = 3;
    }
}
