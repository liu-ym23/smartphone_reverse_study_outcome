package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface NetworkChangeNotifier$Natives {
    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyConnectionCostChanged(long r1, NetworkChangeNotifier r3, int r4);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyConnectionTypeChanged(long r1, NetworkChangeNotifier r3, int r4, long r5);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyMaxBandwidthChanged(long r1, NetworkChangeNotifier r3, int r4);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyOfNetworkConnect(long r1, NetworkChangeNotifier r3, long r4, boolean r6, int r7);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyOfNetworkDisconnect(long r1, NetworkChangeNotifier r3, boolean r4, long r5);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyOfNetworkSoonToDisconnect(long r1, NetworkChangeNotifier r3, long r4);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    void notifyPurgeActiveNetworkList(long r1, NetworkChangeNotifier r3, long[] r4);
}
