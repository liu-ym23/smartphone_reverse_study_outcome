package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CellularInfoDataOrBuilder extends MessageOrBuilder {
    long getCellId();

    int getL2AverageJitter();

    int getL2AverageTput();

    NetworkQoE getNetworkQoe(int r8);

    int getNetworkQoeCount();

    List<NetworkQoE> getNetworkQoeList();

    NetworkQoEOrBuilder getNetworkQoeOrBuilder(int r8);

    List<? extends NetworkQoEOrBuilder> getNetworkQoeOrBuilderList();

    int getRsrp();

    int getSinr();

    int getSubid();

    int getTcpAverageRtt();

    int getTcpRetryRate();

    int getType();

    boolean hasCellId();

    boolean hasL2AverageJitter();

    boolean hasL2AverageTput();

    boolean hasRsrp();

    boolean hasSinr();

    boolean hasSubid();

    boolean hasTcpAverageRtt();

    boolean hasTcpRetryRate();

    boolean hasType();
}
