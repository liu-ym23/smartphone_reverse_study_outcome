package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface SwitchNetworkDataOrBuilder extends MessageOrBuilder {
    CellularInfoData getAfterCellular();

    CellularInfoDataOrBuilder getAfterCellularOrBuilder();

    SwitchNetworkData.AfterNetworkCase getAfterNetworkCase();

    WifiInfoData getAfterWifi();

    WifiInfoDataOrBuilder getAfterWifiOrBuilder();

    CellularInfoData getBeforeCellular();

    CellularInfoDataOrBuilder getBeforeCellularOrBuilder();

    SwitchNetworkData.BeforeNetworkCase getBeforeNetworkCase();

    WifiInfoData getBeforeWifi();

    WifiInfoDataOrBuilder getBeforeWifiOrBuilder();

    int getFailedReason();

    String getForegroundApp();

    ByteString getForegroundAppBytes();

    boolean getIsSuccess();

    int getSolutionType();

    long getSwitchConsumeTime();

    int getSwitchMode();

    int getSwitchReason();

    int getSwitchSubReason();

    SwitchTakeTime getSwitchTakeTime();

    SwitchTakeTimeOrBuilder getSwitchTakeTimeOrBuilder();

    int getSwitchTimes();

    long getTimestamp();

    boolean hasAfterCellular();

    boolean hasAfterWifi();

    boolean hasBeforeCellular();

    boolean hasBeforeWifi();

    boolean hasFailedReason();

    boolean hasForegroundApp();

    boolean hasIsSuccess();

    boolean hasSolutionType();

    boolean hasSwitchConsumeTime();

    boolean hasSwitchMode();

    boolean hasSwitchReason();

    boolean hasSwitchSubReason();

    boolean hasSwitchTakeTime();

    boolean hasSwitchTimes();

    boolean hasTimestamp();
}
