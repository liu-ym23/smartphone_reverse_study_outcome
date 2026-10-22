package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[FetchModelType.values().length];
        a = r0;
        FetchModelType r1 = FetchModelType.ORIGIN;
        r0[r1.ordinal()] = 1;
        FetchModelType r2 = FetchModelType.ZIP;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[FetchModelType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
    }
}
