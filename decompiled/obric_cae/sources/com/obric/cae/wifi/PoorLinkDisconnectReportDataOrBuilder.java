package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface PoorLinkDisconnectReportDataOrBuilder extends MessageOrBuilder {
    int getAvgThroughputKbps();

    String getBssid();

    ByteString getBssidBytes();

    String getBssidMd5();

    ByteString getBssidMd5Bytes();

    int getDestinationNetwork();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    String getForegroundApp();

    ByteString getForegroundAppBytes();

    int getIsInternetRecovered();

    int getRssi();

    int getTriggerId();

    int getWifiBand();

    boolean hasAvgThroughputKbps();

    boolean hasBssid();

    boolean hasBssidMd5();

    boolean hasDestinationNetwork();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasForegroundApp();

    boolean hasIsInternetRecovered();

    boolean hasRssi();

    boolean hasTriggerId();

    boolean hasWifiBand();
}
