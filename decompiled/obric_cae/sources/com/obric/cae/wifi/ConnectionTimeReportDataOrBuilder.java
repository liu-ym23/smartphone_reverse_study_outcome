package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface ConnectionTimeReportDataOrBuilder extends MessageOrBuilder {
    String getBand();

    String getBand1();

    ByteString getBand1Bytes();

    ByteString getBandBytes();

    String getBssid();

    ByteString getBssidBytes();

    String getBssidMd5();

    ByteString getBssidMd5Bytes();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    int getFrequency();

    int getFrequency1();

    int getMloEnable();

    long getTimeSeconds();

    String getWifigeneration();

    ByteString getWifigenerationBytes();

    boolean hasBand();

    boolean hasBand1();

    boolean hasBssid();

    boolean hasBssidMd5();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasFrequency();

    boolean hasFrequency1();

    boolean hasMloEnable();

    boolean hasTimeSeconds();

    boolean hasWifigeneration();
}
