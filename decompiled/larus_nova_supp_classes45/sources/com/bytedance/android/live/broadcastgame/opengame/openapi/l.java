package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudResultType$ClientResultType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class l {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[CloudResultType$ClientResultType.values().length];
        a = r0;
        r0[CloudResultType$ClientResultType.NetworkTimeOut.ordinal()] = 1;
        r0[CloudResultType$ClientResultType.NetworkError.ordinal()] = 2;
        r0[CloudResultType$ClientResultType.ServerError.ordinal()] = 3;
        r0[CloudResultType$ClientResultType.NetworkUnavailable.ordinal()] = 4;
        r0[CloudResultType$ClientResultType.NotLogin.ordinal()] = 5;
    }
}
