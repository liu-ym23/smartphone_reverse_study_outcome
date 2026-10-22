package com.obric.assistant.wakeup.statistics.impl;

import com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public /* synthetic */ class BluetoothScoEstablishStatisticsImpl$b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[IBluetoothScoEstablishStatisticsAPI.Result.values().length];
        r0[IBluetoothScoEstablishStatisticsAPI.Result.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L11:
        r0[IBluetoothScoEstablishStatisticsAPI.Result.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L15:
        r0[IBluetoothScoEstablishStatisticsAPI.Result.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L6:
        a = r0;
    }
}
