package com.bytedance.android.live.cloudgrouplive.core;

import com.bytedance.android.live.cloudgrouplive.rtc.AnchorGroupLiveStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[AnchorGroupLiveStatus.values().length];
        a = r0;
        r0[AnchorGroupLiveStatus.WAITING.ordinal()] = 1;
        r0[AnchorGroupLiveStatus.READY.ordinal()] = 2;
        r0[AnchorGroupLiveStatus.PERFORMING.ordinal()] = 3;
    }
}
