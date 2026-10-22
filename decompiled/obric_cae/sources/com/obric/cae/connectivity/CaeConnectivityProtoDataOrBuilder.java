package com.obric.cae.connectivity;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CaeConnectivityProtoDataOrBuilder extends MessageOrBuilder {
    BleScanResultDataReport getBleScanResultDataReport(int r8);

    int getBleScanResultDataReportCount();

    List<BleScanResultDataReport> getBleScanResultDataReportList();

    BleScanResultDataReportOrBuilder getBleScanResultDataReportOrBuilder(int r8);

    List<? extends BleScanResultDataReportOrBuilder> getBleScanResultDataReportOrBuilderList();

    CellularCellRecordReport getCellularCellRecordReport(int r8);

    int getCellularCellRecordReportCount();

    List<CellularCellRecordReport> getCellularCellRecordReportList();

    CellularCellRecordReportOrBuilder getCellularCellRecordReportOrBuilder(int r8);

    List<? extends CellularCellRecordReportOrBuilder> getCellularCellRecordReportOrBuilderList();

    long getDeviceTime();

    GpsLocationSummaryReport getGpsLocationSummaryReport();

    GpsLocationSummaryReportOrBuilder getGpsLocationSummaryReportOrBuilder();

    GpsMeasurementReport getGpsMeasurementReport(int r8);

    int getGpsMeasurementReportCount();

    List<GpsMeasurementReport> getGpsMeasurementReportList();

    GpsMeasurementReportOrBuilder getGpsMeasurementReportOrBuilder(int r8);

    List<? extends GpsMeasurementReportOrBuilder> getGpsMeasurementReportOrBuilderList();

    String getName();

    ByteString getNameBytes();

    WifiScanDataReport getWifiScanDataReport(int r8);

    int getWifiScanDataReportCount();

    List<WifiScanDataReport> getWifiScanDataReportList();

    WifiScanDataReportOrBuilder getWifiScanDataReportOrBuilder(int r8);

    List<? extends WifiScanDataReportOrBuilder> getWifiScanDataReportOrBuilderList();

    boolean hasDeviceTime();

    boolean hasGpsLocationSummaryReport();

    boolean hasName();
}
