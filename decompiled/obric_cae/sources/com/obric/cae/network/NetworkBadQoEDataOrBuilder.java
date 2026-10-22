package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface NetworkBadQoEDataOrBuilder extends MessageOrBuilder {
    NetworkQoE getNetworkQoe(int r8);

    int getNetworkQoeCount();

    List<NetworkQoE> getNetworkQoeList();

    NetworkQoEOrBuilder getNetworkQoeOrBuilder(int r8);

    List<? extends NetworkQoEOrBuilder> getNetworkQoeOrBuilderList();
}
