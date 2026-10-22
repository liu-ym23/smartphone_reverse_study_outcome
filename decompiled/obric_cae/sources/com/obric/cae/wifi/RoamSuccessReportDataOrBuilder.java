package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface RoamSuccessReportDataOrBuilder extends MessageOrBuilder {
    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    RoamCandidateAp getRoamApList(int r8);

    int getRoamApListCount();

    List<RoamCandidateAp> getRoamApListList();

    RoamCandidateApOrBuilder getRoamApListOrBuilder(int r8);

    List<? extends RoamCandidateApOrBuilder> getRoamApListOrBuilderList();

    String getRoamResultStatus();

    ByteString getRoamResultStatusBytes();

    int getRoamScanChanFreq(int r8);

    int getRoamScanChanFreqCount();

    List<Integer> getRoamScanChanFreqList();

    int getRoamScanNumAp();

    int getRoamScanNumChan();

    String getRoamScanType();

    ByteString getRoamScanTypeBytes();

    String getRoamTriggerReason();

    ByteString getRoamTriggerReasonBytes();

    int getRoamTriggerRssi();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasRoamResultStatus();

    boolean hasRoamScanNumAp();

    boolean hasRoamScanNumChan();

    boolean hasRoamScanType();

    boolean hasRoamTriggerReason();

    boolean hasRoamTriggerRssi();
}
