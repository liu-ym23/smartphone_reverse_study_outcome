package com.bytedance.ttnet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface TTMultiNetwork$Observer {
    void onMultiNetStateChanged(TTMultiNetwork.State r1, TTMultiNetwork.State r2, long r3);

    void onUserSpecifiedNetworkEnabled(boolean r1, long r2);
}
