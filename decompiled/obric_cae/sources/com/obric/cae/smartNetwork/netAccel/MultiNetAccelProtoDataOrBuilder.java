package com.obric.cae.smartNetwork.netAccel;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface MultiNetAccelProtoDataOrBuilder extends MessageOrBuilder {
    AccelCapability getAccelCapability();

    AccelCapabilityOrBuilder getAccelCapabilityOrBuilder();

    AccelUidCapability getAccelUidCapability();

    AccelUidCapabilityOrBuilder getAccelUidCapabilityOrBuilder();

    AppSocketStats getAppSocketStats();

    AppSocketStatsOrBuilder getAppSocketStatsOrBuilder();

    AutoDualWlanCapability getAutoDualWlanCapability();

    AutoDualWlanCapabilityOrBuilder getAutoDualWlanCapabilityOrBuilder();

    boolean hasAccelCapability();

    boolean hasAccelUidCapability();

    boolean hasAppSocketStats();

    boolean hasAutoDualWlanCapability();
}
