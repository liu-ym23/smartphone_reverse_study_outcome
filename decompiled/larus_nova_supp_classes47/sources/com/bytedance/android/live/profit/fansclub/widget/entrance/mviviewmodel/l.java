package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[FansClubUserStatus.values().length];
        a = r0;
        r0[FansClubUserStatus.Active.ordinal()] = 1;
        r0[FansClubUserStatus.Inactive.ordinal()] = 2;
        int[] r1 = new int[GuardStatus.values().length];
        b = r1;
        r1[GuardStatus.ActiveGuard.ordinal()] = 1;
    }
}
