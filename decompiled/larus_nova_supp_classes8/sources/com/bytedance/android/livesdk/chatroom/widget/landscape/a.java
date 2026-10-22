package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.live.core.utils.NetworkUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[NetworkUtils.NetworkType.values().length];
        a = r0;
        r0[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 1;
        r0[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 2;
        r0[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 3;
        r0[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 4;
        r0[NetworkUtils.NetworkType.MOBILE.ordinal()] = 5;
    }
}
