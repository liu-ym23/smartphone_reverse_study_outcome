package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CaeNetworkHandoverProtoOrBuilder extends MessageOrBuilder {
    CaeNetworkHandoverData getNetworkHandoverEvent(int r8);

    int getNetworkHandoverEventCount();

    List<CaeNetworkHandoverData> getNetworkHandoverEventList();

    CaeNetworkHandoverDataOrBuilder getNetworkHandoverEventOrBuilder(int r8);

    List<? extends CaeNetworkHandoverDataOrBuilder> getNetworkHandoverEventOrBuilderList();
}
