package com.obric.cae.smartNetwork.networkRateLimit;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface NetworkRateLimitProtoOrBuilder extends MessageOrBuilder {
    NetworkRateLimitCancelData getNetworkRateLimitCancelData();

    NetworkRateLimitCancelDataOrBuilder getNetworkRateLimitCancelDataOrBuilder();

    NetworkRateLimitData getNetworkRateLimitData();

    NetworkRateLimitDataOrBuilder getNetworkRateLimitDataOrBuilder();

    boolean hasNetworkRateLimitCancelData();

    boolean hasNetworkRateLimitData();
}
