package com.obric.cae.userAware;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiScanDataPairOrBuilder extends MessageOrBuilder {
    WifiScanData getAnchorWifiData();

    WifiScanDataOrBuilder getAnchorWifiDataOrBuilder();

    WifiScanData getNewWifiScanData();

    WifiScanDataOrBuilder getNewWifiScanDataOrBuilder();

    boolean hasAnchorWifiData();

    boolean hasNewWifiScanData();
}
