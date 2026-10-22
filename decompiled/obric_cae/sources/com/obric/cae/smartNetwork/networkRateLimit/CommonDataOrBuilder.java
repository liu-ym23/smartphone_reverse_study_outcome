package com.obric.cae.smartNetwork.networkRateLimit;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface CommonDataOrBuilder extends MessageOrBuilder {
    int getBackgroundAppRate();

    boolean getForegroundAppIsInWhitelist();

    String getForegroundAppPkgName();

    ByteString getForegroundAppPkgNameBytes();

    int getForegroundAppRate();

    int getForegroundAppRttAverage();

    String getIfName();

    ByteString getIfNameBytes();

    int getMaxBandwidthEstimatedValue();

    int getRateCtrlUidNumber();

    float getTemperature();

    boolean hasBackgroundAppRate();

    boolean hasForegroundAppIsInWhitelist();

    boolean hasForegroundAppPkgName();

    boolean hasForegroundAppRate();

    boolean hasForegroundAppRttAverage();

    boolean hasIfName();

    boolean hasMaxBandwidthEstimatedValue();

    boolean hasRateCtrlUidNumber();

    boolean hasTemperature();
}
