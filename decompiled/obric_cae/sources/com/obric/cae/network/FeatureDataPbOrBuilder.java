package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface FeatureDataPbOrBuilder extends MessageOrBuilder {
    int getAppCategory();

    int getAppSpeedRate();

    int getCellL2State();

    int getCellRemainingTraffic();

    int getCellUsedTraffic();

    int getCurLocation();

    int getD7CellAppUsed();

    int getD7CellTotalUsed();

    int getD7TrafficAppUsed();

    long getIndex();

    String getPackageName();

    ByteString getPackageNameBytes();

    long getTimestamp();

    int getTotalSpeedRate();

    int getWifiBand();

    int getWifiL2RxTput();

    int getWifiL2TxTput();

    int getWifiL4RecvOooRate();

    int getWifiL4RecvPkts();

    int getWifiL4RecvSpeed();

    int getWifiL4RetryRate();

    int getWifiL4Rtt();

    int getWifiL4SendPkts();

    int getWifiL4SendSpeed();

    int getWifiL4UnackPkts();

    int getWifiRssi();

    boolean hasAppCategory();

    boolean hasAppSpeedRate();

    boolean hasCellL2State();

    boolean hasCellRemainingTraffic();

    boolean hasCellUsedTraffic();

    boolean hasCurLocation();

    boolean hasD7CellAppUsed();

    boolean hasD7CellTotalUsed();

    boolean hasD7TrafficAppUsed();

    boolean hasIndex();

    boolean hasPackageName();

    boolean hasTimestamp();

    boolean hasTotalSpeedRate();

    boolean hasWifiBand();

    boolean hasWifiL2RxTput();

    boolean hasWifiL2TxTput();

    boolean hasWifiL4RecvOooRate();

    boolean hasWifiL4RecvPkts();

    boolean hasWifiL4RecvSpeed();

    boolean hasWifiL4RetryRate();

    boolean hasWifiL4Rtt();

    boolean hasWifiL4SendPkts();

    boolean hasWifiL4SendSpeed();

    boolean hasWifiL4UnackPkts();

    boolean hasWifiRssi();
}
