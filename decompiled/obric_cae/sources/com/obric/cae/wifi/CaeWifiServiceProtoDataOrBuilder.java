package com.obric.cae.wifi;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface CaeWifiServiceProtoDataOrBuilder extends MessageOrBuilder {
    ConnectionTimeReportData getConnectionTimeReport();

    ConnectionTimeReportDataOrBuilder getConnectionTimeReportOrBuilder();

    LinkLayerQualityReportData getLinkLayerQualityReport();

    LinkLayerQualityReportDataOrBuilder getLinkLayerQualityReportOrBuilder();

    MloLinkLayerQualityReportData getMloLinkLayerQualityReport();

    MloLinkLayerQualityReportDataOrBuilder getMloLinkLayerQualityReportOrBuilder();

    NetworkQualityStatusReportData getNetworkQualityStatusReport();

    NetworkQualityStatusReportDataOrBuilder getNetworkQualityStatusReportOrBuilder();

    PoorLinkDisconnectReportData getPoorLinkDisconnectReport();

    PoorLinkDisconnectReportDataOrBuilder getPoorLinkDisconnectReportOrBuilder();

    PowerStatsReportData getPowerStatsReport();

    PowerStatsReportDataOrBuilder getPowerStatsReportOrBuilder();

    RoamSuccessReportData getRoamSuccessReport();

    RoamSuccessReportDataOrBuilder getRoamSuccessReportOrBuilder();

    RouterModelReportData getRouterModelReport();

    RouterModelReportDataOrBuilder getRouterModelReportOrBuilder();

    StartScanDailyReportData getStartScanDailyReport();

    StartScanDailyReportDataOrBuilder getStartScanDailyReportOrBuilder();

    WakePacketReportData getWakePacketReport();

    WakePacketReportDataOrBuilder getWakePacketReportOrBuilder();

    WlanCrashReportData getWlanCrashReport();

    WlanCrashReportDataOrBuilder getWlanCrashReportOrBuilder();

    boolean hasConnectionTimeReport();

    boolean hasLinkLayerQualityReport();

    boolean hasMloLinkLayerQualityReport();

    boolean hasNetworkQualityStatusReport();

    boolean hasPoorLinkDisconnectReport();

    boolean hasPowerStatsReport();

    boolean hasRoamSuccessReport();

    boolean hasRouterModelReport();

    boolean hasStartScanDailyReport();

    boolean hasWakePacketReport();

    boolean hasWlanCrashReport();
}
