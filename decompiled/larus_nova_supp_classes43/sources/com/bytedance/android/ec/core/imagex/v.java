package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class v {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ECImageMultiSizeReuseOpt.CacheType.values().length];
        a = r0;
        r0[ECImageMultiSizeReuseOpt.CacheType.REUSE_CACHE.ordinal()] = 1;
        r0[ECImageMultiSizeReuseOpt.CacheType.PRELOAD_REUSE_CACHE.ordinal()] = 2;
    }
}
