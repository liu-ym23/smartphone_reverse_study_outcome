package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface NetworkDetectDataOrBuilder extends MessageOrBuilder {
    int getCellRsrp();

    int getCellSinr();

    int getCellType();

    int getConnectTimeMs();

    int getDetectResult();

    int getDetectRtt();

    int getDetectScene();

    int getDnsTimeMs();

    int getErrorCode();

    int getNetworkType();

    String getRedirectUrl();

    ByteString getRedirectUrlBytes();

    int getResponseCode();

    long getTimestamp();

    int getTlsTimeMs();

    int getTotalTimeMs();

    int getTtfbDurationMs();

    int getWifiFreq();

    int getWifiRssi();

    String getWifiSsid();

    ByteString getWifiSsidBytes();

    boolean hasCellRsrp();

    boolean hasCellSinr();

    boolean hasCellType();

    boolean hasConnectTimeMs();

    boolean hasDetectResult();

    boolean hasDetectRtt();

    boolean hasDetectScene();

    boolean hasDnsTimeMs();

    boolean hasErrorCode();

    boolean hasNetworkType();

    boolean hasRedirectUrl();

    boolean hasResponseCode();

    boolean hasTimestamp();

    boolean hasTlsTimeMs();

    boolean hasTotalTimeMs();

    boolean hasTtfbDurationMs();

    boolean hasWifiFreq();

    boolean hasWifiRssi();

    boolean hasWifiSsid();
}
