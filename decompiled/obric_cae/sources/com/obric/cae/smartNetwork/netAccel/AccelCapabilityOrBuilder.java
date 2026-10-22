package com.obric.cae.smartNetwork.netAccel;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AccelCapabilityOrBuilder extends MessageOrBuilder {
    AccelCapability.CellularInfo getCellularInfo(int r8);

    int getCellularInfoCount();

    List<AccelCapability.CellularInfo> getCellularInfoList();

    AccelCapability.CellularInfoOrBuilder getCellularInfoOrBuilder(int r8);

    List<? extends AccelCapability.CellularInfoOrBuilder> getCellularInfoOrBuilderList();

    int getState();

    long getTimestamp();

    AccelCapability.WifiInfo getWifiInfo(int r8);

    int getWifiInfoCount();

    List<AccelCapability.WifiInfo> getWifiInfoList();

    AccelCapability.WifiInfoOrBuilder getWifiInfoOrBuilder(int r8);

    List<? extends AccelCapability.WifiInfoOrBuilder> getWifiInfoOrBuilderList();

    boolean hasState();

    boolean hasTimestamp();
}
