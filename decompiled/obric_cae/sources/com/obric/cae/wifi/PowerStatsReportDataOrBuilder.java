package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface PowerStatsReportDataOrBuilder extends MessageOrBuilder {
    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    long getLastSleepTstamp();

    long getSleepEnterCounter();

    int getSleepTime();

    int getTotalOnTime();

    int getWakeLevel();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasLastSleepTstamp();

    boolean hasSleepEnterCounter();

    boolean hasSleepTime();

    boolean hasTotalOnTime();

    boolean hasWakeLevel();
}
