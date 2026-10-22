package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.profile.p000enum.DressClickArea;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class t {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[NewProfileTrackUseCase.LogProfileType.values().length];
        a = r0;
        r0[NewProfileTrackUseCase.LogProfileType.POI_VIEW_CLK.ordinal()] = 1;
        int[] r1 = new int[DressClickArea.values().length];
        b = r1;
        r1[DressClickArea.BorderRight.ordinal()] = 1;
        r1[DressClickArea.BorderLeft.ordinal()] = 2;
        r1[DressClickArea.Panel.ordinal()] = 3;
    }
}
