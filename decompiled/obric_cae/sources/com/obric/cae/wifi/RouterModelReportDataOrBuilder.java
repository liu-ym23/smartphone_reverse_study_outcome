package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface RouterModelReportDataOrBuilder extends MessageOrBuilder {
    String getBssid();

    ByteString getBssidBytes();

    String getBssidMd5();

    ByteString getBssidMd5Bytes();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    int getMloEnable();

    String getRouterModel();

    ByteString getRouterModelBytes();

    String getRouterType();

    ByteString getRouterTypeBytes();

    String getWifigeneration();

    ByteString getWifigenerationBytes();

    boolean hasBssid();

    boolean hasBssidMd5();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasMloEnable();

    boolean hasRouterModel();

    boolean hasRouterType();

    boolean hasWifigeneration();
}
