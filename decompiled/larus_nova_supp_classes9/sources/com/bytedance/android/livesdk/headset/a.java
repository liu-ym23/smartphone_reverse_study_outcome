package com.bytedance.android.livesdk.headset;

import com.bytedance.android.livesdkapi.service.HeadsetType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[HeadsetType.values().length];
        a = r0;
        r0[HeadsetType.BluetoothA2DP.ordinal()] = 1;
        r0[HeadsetType.BluetoothSco.ordinal()] = 2;
        r0[HeadsetType.WiredHeadSet.ordinal()] = 3;
        r0[HeadsetType.WiredHeadPhones.ordinal()] = 4;
    }
}
