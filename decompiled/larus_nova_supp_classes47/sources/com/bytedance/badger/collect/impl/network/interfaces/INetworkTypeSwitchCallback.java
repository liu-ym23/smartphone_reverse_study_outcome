package com.bytedance.badger.collect.impl.network.interfaces;

import android.net.Network;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface INetworkTypeSwitchCallback {
    void onComplete(Network r1);

    void onError(Exception r1);
}
