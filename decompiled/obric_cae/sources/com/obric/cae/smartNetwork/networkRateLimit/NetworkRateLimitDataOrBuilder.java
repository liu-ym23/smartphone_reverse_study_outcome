package com.obric.cae.smartNetwork.networkRateLimit;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface NetworkRateLimitDataOrBuilder extends MessageOrBuilder {
    CommonData getCommonData();

    CommonDataOrBuilder getCommonDataOrBuilder();

    int getStrategyType();

    boolean hasCommonData();

    boolean hasStrategyType();
}
