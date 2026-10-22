package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WlanCrashReportDataOrBuilder extends MessageOrBuilder {
    int getCnssPlatQuirks();

    int getConnectedLast();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    String getDeviceDevStateStr();

    ByteString getDeviceDevStateStrBytes();

    String getDeviceExecStr();

    ByteString getDeviceExecStrBytes();

    int getDeviceId();

    long getDeviceTime();

    int getDriverState();

    String getEventType();

    ByteString getEventTypeBytes();

    String getHostDevStateStr();

    ByteString getHostDevStateStrBytes();

    String getHostExecStr();

    ByteString getHostExecStrBytes();

    String getHostHangFunc();

    ByteString getHostHangFuncBytes();

    int getHostHangLine();

    String getHostPmStateStr();

    ByteString getHostPmStateStrBytes();

    int getMhiState();

    int getPciLinkDownInd();

    int getPciLinkState();

    String getRddmSfrInfo();

    ByteString getRddmSfrInfoBytes();

    int getReason();

    String getReasonStr();

    ByteString getReasonStrBytes();

    int getRecoveryCount();

    String getSubReason();

    ByteString getSubReasonBytes();

    String getTriggerSource();

    ByteString getTriggerSourceBytes();

    String getWlanDriverVersion();

    ByteString getWlanDriverVersionBytes();

    String getWlanFwBuildTimestamp();

    ByteString getWlanFwBuildTimestampBytes();

    int getWlanFwVersion();

    String getWlanFwVersionStr();

    ByteString getWlanFwVersionStrBytes();

    boolean hasCnssPlatQuirks();

    boolean hasConnectedLast();

    boolean hasDeviceDate();

    boolean hasDeviceDevStateStr();

    boolean hasDeviceExecStr();

    boolean hasDeviceId();

    boolean hasDeviceTime();

    boolean hasDriverState();

    boolean hasEventType();

    boolean hasHostDevStateStr();

    boolean hasHostExecStr();

    boolean hasHostHangFunc();

    boolean hasHostHangLine();

    boolean hasHostPmStateStr();

    boolean hasMhiState();

    boolean hasPciLinkDownInd();

    boolean hasPciLinkState();

    boolean hasRddmSfrInfo();

    boolean hasReason();

    boolean hasReasonStr();

    boolean hasRecoveryCount();

    boolean hasSubReason();

    boolean hasTriggerSource();

    boolean hasWlanDriverVersion();

    boolean hasWlanFwBuildTimestamp();

    boolean hasWlanFwVersion();

    boolean hasWlanFwVersionStr();
}
