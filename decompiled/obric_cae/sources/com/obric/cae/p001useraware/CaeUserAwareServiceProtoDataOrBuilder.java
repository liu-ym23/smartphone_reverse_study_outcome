package com.obric.cae.p001useraware;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CaeUserAwareServiceProtoDataOrBuilder extends MessageOrBuilder {
    HARStateRawData getHARStateRaw(int r8);

    int getHARStateRawCount();

    List<HARStateRawData> getHARStateRawList();

    HARStateRawDataOrBuilder getHARStateRawOrBuilder(int r8);

    List<? extends HARStateRawDataOrBuilder> getHARStateRawOrBuilderList();

    HARUserAwareData getHARUserAware(int r8);

    int getHARUserAwareCount();

    List<HARUserAwareData> getHARUserAwareList();

    HARUserAwareDataOrBuilder getHARUserAwareOrBuilder(int r8);

    List<? extends HARUserAwareDataOrBuilder> getHARUserAwareOrBuilderList();

    UserAwarePrecisionData getUserAwarePrecision(int r8);

    int getUserAwarePrecisionCount();

    List<UserAwarePrecisionData> getUserAwarePrecisionList();

    UserAwarePrecisionDataOrBuilder getUserAwarePrecisionOrBuilder(int r8);

    List<? extends UserAwarePrecisionDataOrBuilder> getUserAwarePrecisionOrBuilderList();

    WifiConnReportData getWifiConnectionReport(int r8);

    int getWifiConnectionReportCount();

    List<WifiConnReportData> getWifiConnectionReportList();

    WifiConnReportDataOrBuilder getWifiConnectionReportOrBuilder(int r8);

    List<? extends WifiConnReportDataOrBuilder> getWifiConnectionReportOrBuilderList();

    WifiPnoStatsReportData getWifiPnoStatsReport(int r8);

    int getWifiPnoStatsReportCount();

    List<WifiPnoStatsReportData> getWifiPnoStatsReportList();

    WifiPnoStatsReportDataOrBuilder getWifiPnoStatsReportOrBuilder(int r8);

    List<? extends WifiPnoStatsReportDataOrBuilder> getWifiPnoStatsReportOrBuilderList();

    WifiScanCountReportData getWifiScanCountReport(int r8);

    int getWifiScanCountReportCount();

    List<WifiScanCountReportData> getWifiScanCountReportList();

    WifiScanCountReportDataOrBuilder getWifiScanCountReportOrBuilder(int r8);

    List<? extends WifiScanCountReportDataOrBuilder> getWifiScanCountReportOrBuilderList();

    WifiScanReportData getWifiScanReport(int r8);

    int getWifiScanReportCount();

    List<WifiScanReportData> getWifiScanReportList();

    WifiScanReportDataOrBuilder getWifiScanReportOrBuilder(int r8);

    List<? extends WifiScanReportDataOrBuilder> getWifiScanReportOrBuilderList();
}
