package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[RandomMatchCheckSource.values().length];
        a = r0;
        RandomMatchCheckSource r1 = RandomMatchCheckSource.PKUserListFragment;
        r0[r1.ordinal()] = 1;
        RandomMatchCheckSource r2 = RandomMatchCheckSource.MultiPKUserListFragment;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[RandomMatchCheckSource.values().length];
        b = r3;
        r3[RandomMatchCheckSource.Setting.ordinal()] = 1;
        r3[r1.ordinal()] = 2;
        r3[r2.ordinal()] = 3;
    }
}
