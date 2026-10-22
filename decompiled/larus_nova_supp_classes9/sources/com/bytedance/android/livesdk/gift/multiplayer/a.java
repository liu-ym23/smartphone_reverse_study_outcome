package com.bytedance.android.livesdk.gift.multiplayer;

import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DataSource.ScaleType.values().length];
        a = r0;
        DataSource.ScaleType r1 = DataSource.ScaleType.ScaleAspectFitCenter;
        r0[r1.ordinal()] = 1;
        DataSource.ScaleType r2 = DataSource.ScaleType.TopFit;
        r0[r2.ordinal()] = 2;
        DataSource.ScaleType r4 = DataSource.ScaleType.BottomFit;
        r0[r4.ordinal()] = 3;
        DataSource.ScaleType r6 = DataSource.ScaleType.LeftFit;
        r0[r6.ordinal()] = 4;
        DataSource.ScaleType r8 = DataSource.ScaleType.RightFit;
        r0[r8.ordinal()] = 5;
        int[] r3 = new int[DataSource.ScaleType.values().length];
        b = r3;
        r3[DataSource.ScaleType.ScaleToFill.ordinal()] = 1;
        r3[DataSource.ScaleType.ScaleAspectFill.ordinal()] = 2;
        r3[DataSource.ScaleType.TopFill.ordinal()] = 3;
        r3[DataSource.ScaleType.BottomFill.ordinal()] = 4;
        r3[DataSource.ScaleType.LeftFill.ordinal()] = 5;
        r3[DataSource.ScaleType.RightFill.ordinal()] = 6;
        r3[r1.ordinal()] = 7;
        r3[r2.ordinal()] = 8;
        r3[r4.ordinal()] = 9;
        r3[r6.ordinal()] = 10;
        r3[r8.ordinal()] = 11;
    }
}
