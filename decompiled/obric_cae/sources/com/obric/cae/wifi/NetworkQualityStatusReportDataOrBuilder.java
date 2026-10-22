package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface NetworkQualityStatusReportDataOrBuilder extends MessageOrBuilder {
    String getBand();

    String getBand1();

    ByteString getBand1Bytes();

    ByteString getBandBytes();

    String getBssidMd5();

    ByteString getBssidMd5Bytes();

    int getCcalevel();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    int getLost();

    int getMloEnable();

    int getRttms();

    int getRxLinkspeed();

    int getRxRealspeed();

    int getSent();

    int getTxLinkspeed();

    int getTxRealspeed();

    String getWifigeneration();

    ByteString getWifigenerationBytes();

    boolean hasBand();

    boolean hasBand1();

    boolean hasBssidMd5();

    boolean hasCcalevel();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasLost();

    boolean hasMloEnable();

    boolean hasRttms();

    boolean hasRxLinkspeed();

    boolean hasRxRealspeed();

    boolean hasSent();

    boolean hasTxLinkspeed();

    boolean hasTxRealspeed();

    boolean hasWifigeneration();
}
