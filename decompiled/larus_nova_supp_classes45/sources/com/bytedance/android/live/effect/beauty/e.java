package com.bytedance.android.live.effect.beauty;

import com.bytedance.android.live.effect.template.BeautifyTemplate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[BeautifyTemplate.BeautifyContentType.values().length];
        a = r0;
        BeautifyTemplate.BeautifyContentType r1 = BeautifyTemplate.BeautifyContentType.BEAUTY;
        r0[r1.ordinal()] = 1;
        BeautifyTemplate.BeautifyContentType r2 = BeautifyTemplate.BeautifyContentType.MAKEUPS;
        r0[r2.ordinal()] = 2;
        BeautifyTemplate.BeautifyContentType r4 = BeautifyTemplate.BeautifyContentType.FILTER;
        r0[r4.ordinal()] = 3;
        BeautifyTemplate.BeautifyContentType r6 = BeautifyTemplate.BeautifyContentType.AV_ADJUST;
        r0[r6.ordinal()] = 4;
        BeautifyTemplate.BeautifyContentType r8 = BeautifyTemplate.BeautifyContentType.BODY_BEAUTY;
        r0[r8.ordinal()] = 5;
        int[] r3 = new int[BeautifyTemplate.BeautifyContentType.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[r8.ordinal()] = 5;
        r3[BeautifyTemplate.BeautifyContentType.PRESETS.ordinal()] = 6;
        int[] r5 = new int[BeautifyTemplate.BeautifyContentType.values().length];
        c = r5;
        r5[r6.ordinal()] = 1;
    }
}
