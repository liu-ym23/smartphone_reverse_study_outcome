package com.obric.cae.userAware;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface NearElevatorProtoOrBuilder extends MessageOrBuilder {
    int getElevatorId();

    int getElevatorUpdateCnt();

    boolean getIsInElevator();

    WifiScanDataPair getWifiDataPairs(int r8);

    int getWifiDataPairsCount();

    List<WifiScanDataPair> getWifiDataPairsList();

    WifiScanDataPairOrBuilder getWifiDataPairsOrBuilder(int r8);

    List<? extends WifiScanDataPairOrBuilder> getWifiDataPairsOrBuilderList();

    boolean hasElevatorId();

    boolean hasElevatorUpdateCnt();

    boolean hasIsInElevator();
}
