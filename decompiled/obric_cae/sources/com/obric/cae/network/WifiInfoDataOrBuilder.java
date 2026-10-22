package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface WifiInfoDataOrBuilder extends MessageOrBuilder {
    String getBssid();

    ByteString getBssidBytes();

    int getFreq();

    int getL2AverageJitter();

    int getL2AverageTput();

    int getLinkspeed();

    NetworkQoE getNetworkQoe(int r8);

    int getNetworkQoeCount();

    List<NetworkQoE> getNetworkQoeList();

    NetworkQoEOrBuilder getNetworkQoeOrBuilder(int r8);

    List<? extends NetworkQoEOrBuilder> getNetworkQoeOrBuilderList();

    int getRssi();

    String getSsid();

    ByteString getSsidBytes();

    int getStandard();

    int getTcpAverageRtt();

    int getTcpRetryRate();

    boolean hasBssid();

    boolean hasFreq();

    boolean hasL2AverageJitter();

    boolean hasL2AverageTput();

    boolean hasLinkspeed();

    boolean hasRssi();

    boolean hasSsid();

    boolean hasStandard();

    boolean hasTcpAverageRtt();

    boolean hasTcpRetryRate();
}
