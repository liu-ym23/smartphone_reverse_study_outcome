package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface StartScanDailyReportDataOrBuilder extends MessageOrBuilder {
    String getDateKey();

    ByteString getDateKeyBytes();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    int getFullScanCount();

    int getPartialScanCount();

    int getStartScanSuccessCount();

    boolean hasDateKey();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasFullScanCount();

    boolean hasPartialScanCount();

    boolean hasStartScanSuccessCount();
}
