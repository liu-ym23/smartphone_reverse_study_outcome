package com.obric.cae.connectivity;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CaeConnectivityProtoData extends GeneratedMessageV3 implements CaeConnectivityProtoDataOrBuilder {
    public static final int BLESCANRESULTDATAREPORT_FIELD_NUMBER = 4;
    public static final int CELLULARCELLRECORDREPORT_FIELD_NUMBER = 7;
    private static final CaeConnectivityProtoData DEFAULT_INSTANCE = null;
    public static final int DEVICE_TIME_FIELD_NUMBER = 1;
    public static final int GPSLOCATIONSUMMARYREPORT_FIELD_NUMBER = 5;
    public static final int GPSMEASUREMENTREPORT_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 2;

    @Deprecated
    public static final Parser<CaeConnectivityProtoData> PARSER = null;
    public static final int WIFISCANDATAREPORT_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<BleScanResultDataReport> bleScanResultDataReport_;
    private List<CellularCellRecordReport> cellularCellRecordReport_;
    private long deviceTime_;
    private GpsLocationSummaryReport gpsLocationSummaryReport_;
    private List<GpsMeasurementReport> gpsMeasurementReport_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<WifiScanDataReport> wifiScanDataReport_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CaeConnectivityProtoDataOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> bleScanResultDataReportBuilder_;
        private List<BleScanResultDataReport> bleScanResultDataReport_;
        private RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> cellularCellRecordReportBuilder_;
        private List<CellularCellRecordReport> cellularCellRecordReport_;
        private long deviceTime_;
        private SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> gpsLocationSummaryReportBuilder_;
        private GpsLocationSummaryReport gpsLocationSummaryReport_;
        private RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> gpsMeasurementReportBuilder_;
        private List<GpsMeasurementReport> gpsMeasurementReport_;
        private Object name_;
        private RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> wifiScanDataReportBuilder_;
        private List<WifiScanDataReport> wifiScanDataReport_;

        private Builder() {
            this.name_ = "";
            this.wifiScanDataReport_ = Collections.emptyList();
            this.bleScanResultDataReport_ = Collections.emptyList();
            this.gpsMeasurementReport_ = Collections.emptyList();
            this.cellularCellRecordReport_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(CaeConnectivityProtoData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            CaeConnectivityProtoData.access$802(r8, this.deviceTime_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            CaeConnectivityProtoData.access$902(r8, this.name_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 16) == 0) goto L16;
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r12 = this.gpsLocationSummaryReportBuilder_;
            if (r12 != null) goto L14;
            GpsLocationSummaryReport r13 = this.gpsLocationSummaryReport_;
        L15:
            CaeConnectivityProtoData.access$1002(r8, r13);
            r11 = r11 | 4;
            goto L16
        L14:
            r13 = (GpsLocationSummaryReport) r12.build();
        L16:
            CaeConnectivityProtoData.access$1176(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(CaeConnectivityProtoData r8) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r10 = this.wifiScanDataReportBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            CaeConnectivityProtoData.access$402(r8, r11);
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r12 = this.bleScanResultDataReportBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            CaeConnectivityProtoData.access$502(r8, r13);
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r14 = this.gpsMeasurementReportBuilder_;
            if (r14 == null) goto L19;
            List r15 = r14.build();
        L23:
            CaeConnectivityProtoData.access$602(r8, r15);
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r16 = this.cellularCellRecordReportBuilder_;
            if (r16 == null) goto L26;
            List r17 = r16.build();
        L30:
            CaeConnectivityProtoData.access$702(r8, r17);
            return;
        L26:
            if ((this.bitField0_ & 64) == 0) goto L28;
            this.cellularCellRecordReport_ = Collections.unmodifiableList(this.cellularCellRecordReport_);
            this.bitField0_ &= -65;
        L28:
            r17 = this.cellularCellRecordReport_;
            goto L30
        L19:
            if ((this.bitField0_ & 32) == 0) goto L21;
            this.gpsMeasurementReport_ = Collections.unmodifiableList(this.gpsMeasurementReport_);
            this.bitField0_ &= -33;
        L21:
            r15 = this.gpsMeasurementReport_;
            goto L23
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            this.bleScanResultDataReport_ = Collections.unmodifiableList(this.bleScanResultDataReport_);
            this.bitField0_ &= -9;
        L14:
            r13 = this.bleScanResultDataReport_;
            goto L16
        L5:
            if ((this.bitField0_ & 4) == 0) goto L7;
            this.wifiScanDataReport_ = Collections.unmodifiableList(this.wifiScanDataReport_);
            this.bitField0_ &= -5;
        L7:
            r11 = this.wifiScanDataReport_;
            goto L9
        }

        private void ensureBleScanResultDataReportIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.bleScanResultDataReport_ = new ArrayList(this.bleScanResultDataReport_);
            this.bitField0_ |= 8;
            return;
        }

        private void ensureCellularCellRecordReportIsMutable() {
            if ((this.bitField0_ & 64) != 0) goto L6;
            this.cellularCellRecordReport_ = new ArrayList(this.cellularCellRecordReport_);
            this.bitField0_ |= 64;
            return;
        }

        private void ensureGpsMeasurementReportIsMutable() {
            if ((this.bitField0_ & 32) != 0) goto L6;
            this.gpsMeasurementReport_ = new ArrayList(this.gpsMeasurementReport_);
            this.bitField0_ |= 32;
            return;
        }

        private void ensureWifiScanDataReportIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.wifiScanDataReport_ = new ArrayList(this.wifiScanDataReport_);
            this.bitField0_ |= 4;
            return;
        }

        private RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> getBleScanResultDataReportFieldBuilder() {
            if (this.bleScanResultDataReportBuilder_ != null) goto L10;
            List<BleScanResultDataReport> r8 = this.bleScanResultDataReport_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.bleScanResultDataReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.bleScanResultDataReport_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.bleScanResultDataReportBuilder_;
        }

        private RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> getCellularCellRecordReportFieldBuilder() {
            if (this.cellularCellRecordReportBuilder_ != null) goto L10;
            List<CellularCellRecordReport> r8 = this.cellularCellRecordReport_;
            if ((this.bitField0_ & 64) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.cellularCellRecordReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.cellularCellRecordReport_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.cellularCellRecordReportBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_descriptor;
        }

        private SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> getGpsLocationSummaryReportFieldBuilder() {
            if (this.gpsLocationSummaryReportBuilder_ != null) goto L6;
            this.gpsLocationSummaryReportBuilder_ = new SingleFieldBuilderV3(getGpsLocationSummaryReport(), getParentForChildren(), isClean());
            this.gpsLocationSummaryReport_ = null;
        L6:
            return this.gpsLocationSummaryReportBuilder_;
        }

        private RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> getGpsMeasurementReportFieldBuilder() {
            if (this.gpsMeasurementReportBuilder_ != null) goto L10;
            List<GpsMeasurementReport> r8 = this.gpsMeasurementReport_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.gpsMeasurementReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.gpsMeasurementReport_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.gpsMeasurementReportBuilder_;
        }

        private RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> getWifiScanDataReportFieldBuilder() {
            if (this.wifiScanDataReportBuilder_ != null) goto L10;
            List<WifiScanDataReport> r8 = this.wifiScanDataReport_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.wifiScanDataReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiScanDataReport_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.wifiScanDataReportBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (CaeConnectivityProtoData.access$200() == false) goto L6;
            getWifiScanDataReportFieldBuilder();
            getBleScanResultDataReportFieldBuilder();
            getGpsLocationSummaryReportFieldBuilder();
            getGpsMeasurementReportFieldBuilder();
            getCellularCellRecordReportFieldBuilder();
            return;
        }

        public Builder addAllBleScanResultDataReport(Iterable<? extends BleScanResultDataReport> r8) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r10 = this.bleScanResultDataReportBuilder_;
            if (r10 != null) goto L5;
            ensureBleScanResultDataReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.bleScanResultDataReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllCellularCellRecordReport(Iterable<? extends CellularCellRecordReport> r8) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r10 = this.cellularCellRecordReportBuilder_;
            if (r10 != null) goto L5;
            ensureCellularCellRecordReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.cellularCellRecordReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllGpsMeasurementReport(Iterable<? extends GpsMeasurementReport> r8) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r10 = this.gpsMeasurementReportBuilder_;
            if (r10 != null) goto L5;
            ensureGpsMeasurementReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.gpsMeasurementReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllWifiScanDataReport(Iterable<? extends WifiScanDataReport> r8) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r10 = this.wifiScanDataReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanDataReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiScanDataReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addBleScanResultDataReport(int r8, BleScanResultDataReport.Builder r10) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r11 = this.bleScanResultDataReportBuilder_;
            if (r11 != null) goto L5;
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public BleScanResultDataReport.Builder addBleScanResultDataReportBuilder() {
            return (BleScanResultDataReport.Builder) getBleScanResultDataReportFieldBuilder().addBuilder(BleScanResultDataReport.getDefaultInstance());
        }

        public Builder addCellularCellRecordReport(int r8, CellularCellRecordReport.Builder r10) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r11 = this.cellularCellRecordReportBuilder_;
            if (r11 != null) goto L5;
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public CellularCellRecordReport.Builder addCellularCellRecordReportBuilder() {
            return (CellularCellRecordReport.Builder) getCellularCellRecordReportFieldBuilder().addBuilder(CellularCellRecordReport.getDefaultInstance());
        }

        public Builder addGpsMeasurementReport(int r8, GpsMeasurementReport.Builder r10) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r11 = this.gpsMeasurementReportBuilder_;
            if (r11 != null) goto L5;
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public GpsMeasurementReport.Builder addGpsMeasurementReportBuilder() {
            return (GpsMeasurementReport.Builder) getGpsMeasurementReportFieldBuilder().addBuilder(GpsMeasurementReport.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiScanDataReport(int r8, WifiScanDataReport.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r11 = this.wifiScanDataReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiScanDataReport.Builder addWifiScanDataReportBuilder() {
            return (WifiScanDataReport.Builder) getWifiScanDataReportFieldBuilder().addBuilder(WifiScanDataReport.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearBleScanResultDataReport() {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r8 = this.bleScanResultDataReportBuilder_;
            if (r8 != null) goto L5;
            this.bleScanResultDataReport_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearCellularCellRecordReport() {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r8 = this.cellularCellRecordReportBuilder_;
            if (r8 != null) goto L5;
            this.cellularCellRecordReport_ = Collections.emptyList();
            this.bitField0_ &= -65;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= -2;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearGpsLocationSummaryReport() {
            this.bitField0_ &= -17;
            this.gpsLocationSummaryReport_ = null;
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r8 = this.gpsLocationSummaryReportBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.gpsLocationSummaryReportBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearGpsMeasurementReport() {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r8 = this.gpsMeasurementReportBuilder_;
            if (r8 != null) goto L5;
            this.gpsMeasurementReport_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = CaeConnectivityProtoData.getDefaultInstance().getName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearWifiScanDataReport() {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r8 = this.wifiScanDataReportBuilder_;
            if (r8 != null) goto L5;
            this.wifiScanDataReport_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public BleScanResultDataReport getBleScanResultDataReport(int r8) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r10 = this.bleScanResultDataReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.bleScanResultDataReport_.get(r8);
        L6:
            return (BleScanResultDataReport) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public BleScanResultDataReport.Builder getBleScanResultDataReportBuilder(int r8) {
            return (BleScanResultDataReport.Builder) getBleScanResultDataReportFieldBuilder().getBuilder(r8);
        }

        public List<BleScanResultDataReport.Builder> getBleScanResultDataReportBuilderList() {
            return getBleScanResultDataReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public int getBleScanResultDataReportCount() {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r8 = this.bleScanResultDataReportBuilder_;
            if (r8 != null) goto L7;
            return this.bleScanResultDataReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<BleScanResultDataReport> getBleScanResultDataReportList() {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r8 = this.bleScanResultDataReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.bleScanResultDataReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public BleScanResultDataReportOrBuilder getBleScanResultDataReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r10 = this.bleScanResultDataReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.bleScanResultDataReport_.get(r8);
        L6:
            return (BleScanResultDataReportOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<? extends BleScanResultDataReportOrBuilder> getBleScanResultDataReportOrBuilderList() {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r8 = this.bleScanResultDataReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.bleScanResultDataReport_);
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public CellularCellRecordReport getCellularCellRecordReport(int r8) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r10 = this.cellularCellRecordReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.cellularCellRecordReport_.get(r8);
        L6:
            return (CellularCellRecordReport) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public CellularCellRecordReport.Builder getCellularCellRecordReportBuilder(int r8) {
            return (CellularCellRecordReport.Builder) getCellularCellRecordReportFieldBuilder().getBuilder(r8);
        }

        public List<CellularCellRecordReport.Builder> getCellularCellRecordReportBuilderList() {
            return getCellularCellRecordReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public int getCellularCellRecordReportCount() {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r8 = this.cellularCellRecordReportBuilder_;
            if (r8 != null) goto L7;
            return this.cellularCellRecordReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<CellularCellRecordReport> getCellularCellRecordReportList() {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r8 = this.cellularCellRecordReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.cellularCellRecordReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public CellularCellRecordReportOrBuilder getCellularCellRecordReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r10 = this.cellularCellRecordReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.cellularCellRecordReport_.get(r8);
        L6:
            return (CellularCellRecordReportOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<? extends CellularCellRecordReportOrBuilder> getCellularCellRecordReportOrBuilderList() {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r8 = this.cellularCellRecordReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.cellularCellRecordReport_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_descriptor;
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public GpsLocationSummaryReport getGpsLocationSummaryReport() {
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r8 = this.gpsLocationSummaryReportBuilder_;
            if (r8 != null) goto L9;
            GpsLocationSummaryReport r10 = this.gpsLocationSummaryReport_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return GpsLocationSummaryReport.getDefaultInstance();
        L9:
            return (GpsLocationSummaryReport) r8.getMessage();
        }

        public GpsLocationSummaryReport.Builder getGpsLocationSummaryReportBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (GpsLocationSummaryReport.Builder) getGpsLocationSummaryReportFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public GpsLocationSummaryReportOrBuilder getGpsLocationSummaryReportOrBuilder() {
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r8 = this.gpsLocationSummaryReportBuilder_;
            if (r8 != null) goto L5;
            GpsLocationSummaryReport r10 = this.gpsLocationSummaryReport_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return GpsLocationSummaryReport.getDefaultInstance();
        L5:
            return (GpsLocationSummaryReportOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public GpsMeasurementReport getGpsMeasurementReport(int r8) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r10 = this.gpsMeasurementReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.gpsMeasurementReport_.get(r8);
        L6:
            return (GpsMeasurementReport) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public GpsMeasurementReport.Builder getGpsMeasurementReportBuilder(int r8) {
            return (GpsMeasurementReport.Builder) getGpsMeasurementReportFieldBuilder().getBuilder(r8);
        }

        public List<GpsMeasurementReport.Builder> getGpsMeasurementReportBuilderList() {
            return getGpsMeasurementReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public int getGpsMeasurementReportCount() {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r8 = this.gpsMeasurementReportBuilder_;
            if (r8 != null) goto L7;
            return this.gpsMeasurementReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<GpsMeasurementReport> getGpsMeasurementReportList() {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r8 = this.gpsMeasurementReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.gpsMeasurementReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public GpsMeasurementReportOrBuilder getGpsMeasurementReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r10 = this.gpsMeasurementReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.gpsMeasurementReport_.get(r8);
        L6:
            return (GpsMeasurementReportOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<? extends GpsMeasurementReportOrBuilder> getGpsMeasurementReportOrBuilderList() {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r8 = this.gpsMeasurementReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.gpsMeasurementReport_);
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.name_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public WifiScanDataReport getWifiScanDataReport(int r8) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r10 = this.wifiScanDataReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiScanDataReport_.get(r8);
        L6:
            return (WifiScanDataReport) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiScanDataReport.Builder getWifiScanDataReportBuilder(int r8) {
            return (WifiScanDataReport.Builder) getWifiScanDataReportFieldBuilder().getBuilder(r8);
        }

        public List<WifiScanDataReport.Builder> getWifiScanDataReportBuilderList() {
            return getWifiScanDataReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public int getWifiScanDataReportCount() {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r8 = this.wifiScanDataReportBuilder_;
            if (r8 != null) goto L7;
            return this.wifiScanDataReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<WifiScanDataReport> getWifiScanDataReportList() {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r8 = this.wifiScanDataReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiScanDataReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public WifiScanDataReportOrBuilder getWifiScanDataReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r10 = this.wifiScanDataReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiScanDataReport_.get(r8);
        L6:
            return (WifiScanDataReportOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public List<? extends WifiScanDataReportOrBuilder> getWifiScanDataReportOrBuilderList() {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r8 = this.wifiScanDataReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiScanDataReport_);
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public boolean hasGpsLocationSummaryReport() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
        public boolean hasName() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeGpsLocationSummaryReport(GpsLocationSummaryReport r8) {
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r10 = this.gpsLocationSummaryReportBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            GpsLocationSummaryReport r11 = this.gpsLocationSummaryReport_;
            if (r11 == null) goto L11;
            if (r11 == GpsLocationSummaryReport.getDefaultInstance()) goto L11;
            getGpsLocationSummaryReportBuilder().mergeFrom(r8);
        L11:
            this.gpsLocationSummaryReport_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder removeBleScanResultDataReport(int r8) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r10 = this.bleScanResultDataReportBuilder_;
            if (r10 != null) goto L5;
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeCellularCellRecordReport(int r8) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r10 = this.cellularCellRecordReportBuilder_;
            if (r10 != null) goto L5;
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeGpsMeasurementReport(int r8) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r10 = this.gpsMeasurementReportBuilder_;
            if (r10 != null) goto L5;
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeWifiScanDataReport(int r8) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r10 = this.wifiScanDataReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setBleScanResultDataReport(int r8, BleScanResultDataReport.Builder r10) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r11 = this.bleScanResultDataReportBuilder_;
            if (r11 != null) goto L5;
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setCellularCellRecordReport(int r8, CellularCellRecordReport.Builder r10) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r11 = this.cellularCellRecordReportBuilder_;
            if (r11 != null) goto L5;
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setGpsLocationSummaryReport(GpsLocationSummaryReport.Builder r8) {
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r10 = this.gpsLocationSummaryReportBuilder_;
            GpsLocationSummaryReport r11 = r8.build();
            if (r10 != null) goto L5;
            this.gpsLocationSummaryReport_ = r11;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setGpsMeasurementReport(int r8, GpsMeasurementReport.Builder r10) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r11 = this.gpsMeasurementReportBuilder_;
            if (r11 != null) goto L5;
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setName(String r8) {
            if (r8 == null) goto L6;
            this.name_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.name_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiScanDataReport(int r8, WifiScanDataReport.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r11 = this.wifiScanDataReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.name_ = "";
            this.wifiScanDataReport_ = Collections.emptyList();
            this.bleScanResultDataReport_ = Collections.emptyList();
            this.gpsMeasurementReport_ = Collections.emptyList();
            this.cellularCellRecordReport_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addBleScanResultDataReport(int r8, BleScanResultDataReport r10) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r11 = this.bleScanResultDataReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public BleScanResultDataReport.Builder addBleScanResultDataReportBuilder(int r8) {
            return (BleScanResultDataReport.Builder) getBleScanResultDataReportFieldBuilder().addBuilder(r8, BleScanResultDataReport.getDefaultInstance());
        }

        public Builder addCellularCellRecordReport(int r8, CellularCellRecordReport r10) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r11 = this.cellularCellRecordReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public CellularCellRecordReport.Builder addCellularCellRecordReportBuilder(int r8) {
            return (CellularCellRecordReport.Builder) getCellularCellRecordReportFieldBuilder().addBuilder(r8, CellularCellRecordReport.getDefaultInstance());
        }

        public Builder addGpsMeasurementReport(int r8, GpsMeasurementReport r10) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r11 = this.gpsMeasurementReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public GpsMeasurementReport.Builder addGpsMeasurementReportBuilder(int r8) {
            return (GpsMeasurementReport.Builder) getGpsMeasurementReportFieldBuilder().addBuilder(r8, GpsMeasurementReport.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiScanDataReport(int r8, WifiScanDataReport r10) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r11 = this.wifiScanDataReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiScanDataReport.Builder addWifiScanDataReportBuilder(int r8) {
            return (WifiScanDataReport.Builder) getWifiScanDataReportFieldBuilder().addBuilder(r8, WifiScanDataReport.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeConnectivityProtoData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setBleScanResultDataReport(int r8, BleScanResultDataReport r10) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r11 = this.bleScanResultDataReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setCellularCellRecordReport(int r8, CellularCellRecordReport r10) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r11 = this.cellularCellRecordReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setGpsLocationSummaryReport(GpsLocationSummaryReport r8) {
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r10 = this.gpsLocationSummaryReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.gpsLocationSummaryReport_ = r8;
        L9:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setGpsMeasurementReport(int r8, GpsMeasurementReport r10) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r11 = this.gpsMeasurementReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiScanDataReport(int r8, WifiScanDataReport r10) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r11 = this.wifiScanDataReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addBleScanResultDataReport(BleScanResultDataReport.Builder r8) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r10 = this.bleScanResultDataReportBuilder_;
            if (r10 != null) goto L5;
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addCellularCellRecordReport(CellularCellRecordReport.Builder r8) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r10 = this.cellularCellRecordReportBuilder_;
            if (r10 != null) goto L5;
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addGpsMeasurementReport(GpsMeasurementReport.Builder r8) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r10 = this.gpsMeasurementReportBuilder_;
            if (r10 != null) goto L5;
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiScanDataReport(WifiScanDataReport.Builder r8) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r10 = this.wifiScanDataReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeConnectivityProtoData build() {
            CaeConnectivityProtoData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeConnectivityProtoData buildPartial() {
            CaeConnectivityProtoData r8 = new CaeConnectivityProtoData(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public CaeConnectivityProtoData getDefaultInstanceForType() {
            return CaeConnectivityProtoData.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addBleScanResultDataReport(BleScanResultDataReport r8) {
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r10 = this.bleScanResultDataReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addCellularCellRecordReport(CellularCellRecordReport r8) {
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r10 = this.cellularCellRecordReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addGpsMeasurementReport(GpsMeasurementReport r8) {
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r10 = this.gpsMeasurementReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addWifiScanDataReport(WifiScanDataReport r8) {
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r10 = this.wifiScanDataReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r8) {
            return (Builder) super.clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return (Builder) super.clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (Builder) super.setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.deviceTime_ = 0;
            this.name_ = "";
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r8 = this.wifiScanDataReportBuilder_;
            if (r8 != null) goto L5;
            this.wifiScanDataReport_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -5;
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r10 = this.bleScanResultDataReportBuilder_;
            if (r10 != null) goto L9;
            this.bleScanResultDataReport_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -9;
            this.gpsLocationSummaryReport_ = null;
            SingleFieldBuilderV3<GpsLocationSummaryReport, GpsLocationSummaryReport.Builder, GpsLocationSummaryReportOrBuilder> r11 = this.gpsLocationSummaryReportBuilder_;
            if (r11 == null) goto L13;
            r11.dispose();
            this.gpsLocationSummaryReportBuilder_ = null;
        L13:
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r12 = this.gpsMeasurementReportBuilder_;
            if (r12 != null) goto L16;
            this.gpsMeasurementReport_ = Collections.emptyList();
        L17:
            this.bitField0_ &= -33;
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r13 = this.cellularCellRecordReportBuilder_;
            if (r13 != null) goto L20;
            this.cellularCellRecordReport_ = Collections.emptyList();
        L21:
            this.bitField0_ &= -65;
            return this;
        L20:
            this.cellularCellRecordReport_ = null;
            r13.clear();
            goto L21
        L16:
            this.gpsMeasurementReport_ = null;
            r12.clear();
            goto L17
        L9:
            this.bleScanResultDataReport_ = null;
            r10.clear();
            goto L10
        L5:
            this.wifiScanDataReport_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L53;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L50;
            int r12 = r8.readTag();     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            if (r12 == 0) goto L42;
            if (r12 != 8) goto L10;
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            this.bitField0_ |= 1;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            goto L4
        L10:
            if (r12 != 18) goto L12;
            this.name_ = r8.readBytes();     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            this.bitField0_ |= 2;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            goto L4
        L12:
            if (r12 == 26) goto L36;
            if (r12 == 34) goto L33;
            if (r12 != 42) goto L18;
            r8.readMessage(getGpsLocationSummaryReportFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            this.bitField0_ |= 16;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            goto L4
        L18:
            if (r12 == 50) goto L29;
            if (r12 != 58) goto L22;
            GeneratedMessage.ExtendableMessageOrBuilder r13 = (CellularCellRecordReport) r8.readMessage(CellularCellRecordReport.PARSER, r10);     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            RepeatedFieldBuilderV3 r14 = this.cellularCellRecordReportBuilder_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            if (r14 == null) goto L26;
        L28:
            r14.addMessage(r13);     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            goto L4
        L26:
            ensureCellularCellRecordReportIsMutable();     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            List r15 = this.cellularCellRecordReport_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
        L27:
            r15.add(r13);     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            goto L4
        L22:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L29:
            r13 = (GpsMeasurementReport) r8.readMessage(GpsMeasurementReport.PARSER, r10);     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            r14 = this.gpsMeasurementReportBuilder_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            if (r14 != null) goto L28;
            ensureGpsMeasurementReportIsMutable();     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            r15 = this.gpsMeasurementReport_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            goto L27
        L33:
            r13 = (BleScanResultDataReport) r8.readMessage(BleScanResultDataReport.PARSER, r10);     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            r14 = this.bleScanResultDataReportBuilder_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            if (r14 != null) goto L28;
            ensureBleScanResultDataReportIsMutable();     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            r15 = this.bleScanResultDataReport_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            goto L27
        L36:
            r13 = (WifiScanDataReport) r8.readMessage(WifiScanDataReport.PARSER, r10);     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            r14 = this.wifiScanDataReportBuilder_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            if (r14 != null) goto L28;
            ensureWifiScanDataReportIsMutable();     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
            r15 = this.wifiScanDataReport_;     // Catch: Throwable -> L43 InvalidProtocolBufferException -> L45
        L42:
            r11 = true;
            goto L4
        L45:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            onChanged();
            throw th;
        L50:
            onChanged();
            return this;
        L53:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof CaeConnectivityProtoData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CaeConnectivityProtoData) r8);
        }

        public Builder mergeFrom(CaeConnectivityProtoData r8) {
            if (r8 != CaeConnectivityProtoData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasDeviceTime() == false) goto L9;
            setDeviceTime(r8.getDeviceTime());
        L9:
            if (r8.hasName() == false) goto L11;
            this.name_ = CaeConnectivityProtoData.access$900(r8);
            this.bitField0_ |= 2;
            onChanged();
        L11:
            RepeatedFieldBuilderV3<CellularCellRecordReport, CellularCellRecordReport.Builder, CellularCellRecordReportOrBuilder> r10 = null;
            if (this.wifiScanDataReportBuilder_ != null) goto L21;
            if (CaeConnectivityProtoData.access$400(r8).isEmpty() == true) goto L31;
            if (this.wifiScanDataReport_.isEmpty() == false) goto L18;
            this.wifiScanDataReport_ = CaeConnectivityProtoData.access$400(r8);
            this.bitField0_ &= -5;
        L19:
            onChanged();
            goto L31
        L18:
            ensureWifiScanDataReportIsMutable();
            this.wifiScanDataReport_.addAll(CaeConnectivityProtoData.access$400(r8));
        L31:
            if (this.bleScanResultDataReportBuilder_ != null) goto L40;
            if (CaeConnectivityProtoData.access$500(r8).isEmpty() == true) goto L50;
            if (this.bleScanResultDataReport_.isEmpty() == false) goto L37;
            this.bleScanResultDataReport_ = CaeConnectivityProtoData.access$500(r8);
            this.bitField0_ &= -9;
        L38:
            onChanged();
            goto L50
        L37:
            ensureBleScanResultDataReportIsMutable();
            this.bleScanResultDataReport_.addAll(CaeConnectivityProtoData.access$500(r8));
        L50:
            if (r8.hasGpsLocationSummaryReport() == false) goto L53;
            mergeGpsLocationSummaryReport(r8.getGpsLocationSummaryReport());
        L53:
            if (this.gpsMeasurementReportBuilder_ != null) goto L62;
            if (CaeConnectivityProtoData.access$600(r8).isEmpty() == true) goto L72;
            if (this.gpsMeasurementReport_.isEmpty() == false) goto L59;
            this.gpsMeasurementReport_ = CaeConnectivityProtoData.access$600(r8);
            this.bitField0_ &= -33;
        L60:
            onChanged();
            goto L72
        L59:
            ensureGpsMeasurementReportIsMutable();
            this.gpsMeasurementReport_.addAll(CaeConnectivityProtoData.access$600(r8));
        L72:
            if (this.cellularCellRecordReportBuilder_ != null) goto L81;
            if (CaeConnectivityProtoData.access$700(r8).isEmpty() == false) goto L76;
        L89:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L76:
            if (this.cellularCellRecordReport_.isEmpty() == false) goto L78;
            this.cellularCellRecordReport_ = CaeConnectivityProtoData.access$700(r8);
            this.bitField0_ &= -65;
        L79:
            onChanged();
            goto L89
        L78:
            ensureCellularCellRecordReportIsMutable();
            this.cellularCellRecordReport_.addAll(CaeConnectivityProtoData.access$700(r8));
            goto L79
        L81:
            if (CaeConnectivityProtoData.access$700(r8).isEmpty() == true) goto L89;
            if (this.cellularCellRecordReportBuilder_.isEmpty() == false) goto L88;
            this.cellularCellRecordReportBuilder_.dispose();
            this.cellularCellRecordReportBuilder_ = null;
            this.cellularCellRecordReport_ = CaeConnectivityProtoData.access$700(r8);
            this.bitField0_ &= -65;
            if (CaeConnectivityProtoData.access$1500() == false) goto L87;
            r10 = getCellularCellRecordReportFieldBuilder();
        L87:
            this.cellularCellRecordReportBuilder_ = r10;
            goto L89
        L88:
            this.cellularCellRecordReportBuilder_.addAllMessages(CaeConnectivityProtoData.access$700(r8));
            goto L89
        L62:
            if (CaeConnectivityProtoData.access$600(r8).isEmpty() == true) goto L72;
            if (this.gpsMeasurementReportBuilder_.isEmpty() == false) goto L70;
            this.gpsMeasurementReportBuilder_.dispose();
            this.gpsMeasurementReportBuilder_ = null;
            this.gpsMeasurementReport_ = CaeConnectivityProtoData.access$600(r8);
            this.bitField0_ &= -33;
            if (CaeConnectivityProtoData.access$1400() == false) goto L68;
            RepeatedFieldBuilderV3<GpsMeasurementReport, GpsMeasurementReport.Builder, GpsMeasurementReportOrBuilder> r11 = getGpsMeasurementReportFieldBuilder();
        L69:
            this.gpsMeasurementReportBuilder_ = r11;
            goto L72
        L68:
            r11 = null;
            goto L69
        L70:
            this.gpsMeasurementReportBuilder_.addAllMessages(CaeConnectivityProtoData.access$600(r8));
            goto L72
        L40:
            if (CaeConnectivityProtoData.access$500(r8).isEmpty() == true) goto L50;
            if (this.bleScanResultDataReportBuilder_.isEmpty() == false) goto L48;
            this.bleScanResultDataReportBuilder_.dispose();
            this.bleScanResultDataReportBuilder_ = null;
            this.bleScanResultDataReport_ = CaeConnectivityProtoData.access$500(r8);
            this.bitField0_ &= -9;
            if (CaeConnectivityProtoData.access$1300() == false) goto L46;
            RepeatedFieldBuilderV3<BleScanResultDataReport, BleScanResultDataReport.Builder, BleScanResultDataReportOrBuilder> r12 = getBleScanResultDataReportFieldBuilder();
        L47:
            this.bleScanResultDataReportBuilder_ = r12;
            goto L50
        L46:
            r12 = null;
            goto L47
        L48:
            this.bleScanResultDataReportBuilder_.addAllMessages(CaeConnectivityProtoData.access$500(r8));
            goto L50
        L21:
            if (CaeConnectivityProtoData.access$400(r8).isEmpty() == true) goto L31;
            if (this.wifiScanDataReportBuilder_.isEmpty() == false) goto L29;
            this.wifiScanDataReportBuilder_.dispose();
            this.wifiScanDataReportBuilder_ = null;
            this.wifiScanDataReport_ = CaeConnectivityProtoData.access$400(r8);
            this.bitField0_ &= -5;
            if (CaeConnectivityProtoData.access$1200() == false) goto L27;
            RepeatedFieldBuilderV3<WifiScanDataReport, WifiScanDataReport.Builder, WifiScanDataReportOrBuilder> r13 = getWifiScanDataReportFieldBuilder();
        L28:
            this.wifiScanDataReportBuilder_ = r13;
            goto L31
        L27:
            r13 = null;
            goto L28
        L29:
            this.wifiScanDataReportBuilder_.addAllMessages(CaeConnectivityProtoData.access$400(r8));
            goto L31
        }
    }

    static {
        DEFAULT_INSTANCE = new CaeConnectivityProtoData();
        PARSER = new AnonymousClass1();
    }

    private CaeConnectivityProtoData() {
        this.deviceTime_ = 0;
        this.name_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.wifiScanDataReport_ = Collections.emptyList();
        this.bleScanResultDataReport_ = Collections.emptyList();
        this.gpsMeasurementReport_ = Collections.emptyList();
        this.cellularCellRecordReport_ = Collections.emptyList();
    }

    public static /* synthetic */ GpsLocationSummaryReport access$1002(CaeConnectivityProtoData r8, GpsLocationSummaryReport r10) {
        r8.gpsLocationSummaryReport_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1176(CaeConnectivityProtoData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1300() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1400() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1500() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$400(CaeConnectivityProtoData r8) {
        return r8.wifiScanDataReport_;
    }

    public static /* synthetic */ List access$402(CaeConnectivityProtoData r8, List r10) {
        r8.wifiScanDataReport_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$500(CaeConnectivityProtoData r8) {
        return r8.bleScanResultDataReport_;
    }

    public static /* synthetic */ List access$502(CaeConnectivityProtoData r8, List r10) {
        r8.bleScanResultDataReport_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$600(CaeConnectivityProtoData r8) {
        return r8.gpsMeasurementReport_;
    }

    public static /* synthetic */ List access$602(CaeConnectivityProtoData r8, List r10) {
        r8.gpsMeasurementReport_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$700(CaeConnectivityProtoData r8) {
        return r8.cellularCellRecordReport_;
    }

    public static /* synthetic */ List access$702(CaeConnectivityProtoData r8, List r10) {
        r8.cellularCellRecordReport_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$802(CaeConnectivityProtoData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$900(CaeConnectivityProtoData r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$902(CaeConnectivityProtoData r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static CaeConnectivityProtoData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CaeConnectivityProtoData parseDelimitedFrom(InputStream r8) {
        return (CaeConnectivityProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CaeConnectivityProtoData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CaeConnectivityProtoData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CaeConnectivityProtoData) == false) goto L8;
        CaeConnectivityProtoData r10 = (CaeConnectivityProtoData) r8;
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L13;
        return false;
    L13:
        if (hasDeviceTime() == false) goto L18;
        if (getDeviceTime() == r10.getDeviceTime()) goto L18;
        return false;
    L18:
        if (hasName() == r10.hasName()) goto L21;
        return false;
    L21:
        if (hasName() == false) goto L26;
        if (getName().equals(r10.getName()) == true) goto L26;
        return false;
    L26:
        if (getWifiScanDataReportList().equals(r10.getWifiScanDataReportList()) == true) goto L29;
        return false;
    L29:
        if (getBleScanResultDataReportList().equals(r10.getBleScanResultDataReportList()) == true) goto L32;
        return false;
    L32:
        if (hasGpsLocationSummaryReport() == r10.hasGpsLocationSummaryReport()) goto L35;
        return false;
    L35:
        if (hasGpsLocationSummaryReport() == false) goto L40;
        if (getGpsLocationSummaryReport().equals(r10.getGpsLocationSummaryReport()) == true) goto L40;
        return false;
    L40:
        if (getGpsMeasurementReportList().equals(r10.getGpsMeasurementReportList()) == true) goto L43;
        return false;
    L43:
        if (getCellularCellRecordReportList().equals(r10.getCellularCellRecordReportList()) == true) goto L46;
        return false;
    L46:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L48;
        return false;
    L48:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public BleScanResultDataReport getBleScanResultDataReport(int r8) {
        return this.bleScanResultDataReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public int getBleScanResultDataReportCount() {
        return this.bleScanResultDataReport_.size();
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<BleScanResultDataReport> getBleScanResultDataReportList() {
        return this.bleScanResultDataReport_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public BleScanResultDataReportOrBuilder getBleScanResultDataReportOrBuilder(int r8) {
        return this.bleScanResultDataReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<? extends BleScanResultDataReportOrBuilder> getBleScanResultDataReportOrBuilderList() {
        return this.bleScanResultDataReport_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public CellularCellRecordReport getCellularCellRecordReport(int r8) {
        return this.cellularCellRecordReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public int getCellularCellRecordReportCount() {
        return this.cellularCellRecordReport_.size();
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<CellularCellRecordReport> getCellularCellRecordReportList() {
        return this.cellularCellRecordReport_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public CellularCellRecordReportOrBuilder getCellularCellRecordReportOrBuilder(int r8) {
        return this.cellularCellRecordReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<? extends CellularCellRecordReportOrBuilder> getCellularCellRecordReportOrBuilderList() {
        return this.cellularCellRecordReport_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public GpsLocationSummaryReport getGpsLocationSummaryReport() {
        GpsLocationSummaryReport r8 = this.gpsLocationSummaryReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return GpsLocationSummaryReport.getDefaultInstance();
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public GpsLocationSummaryReportOrBuilder getGpsLocationSummaryReportOrBuilder() {
        GpsLocationSummaryReport r8 = this.gpsLocationSummaryReport_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return GpsLocationSummaryReport.getDefaultInstance();
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public GpsMeasurementReport getGpsMeasurementReport(int r8) {
        return this.gpsMeasurementReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public int getGpsMeasurementReportCount() {
        return this.gpsMeasurementReport_.size();
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<GpsMeasurementReport> getGpsMeasurementReportList() {
        return this.gpsMeasurementReport_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public GpsMeasurementReportOrBuilder getGpsMeasurementReportOrBuilder(int r8) {
        return this.gpsMeasurementReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<? extends GpsMeasurementReportOrBuilder> getGpsMeasurementReportOrBuilderList() {
        return this.gpsMeasurementReport_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.name_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CaeConnectivityProtoData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = CodedOutputStream.computeUInt64Size(1, this.deviceTime_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r11 = r11 + GeneratedMessage.computeStringSize(2, this.name_);
    L12:
        int r12 = 0;
    L14:
        if (r12 >= this.wifiScanDataReport_.size()) goto L16;
        r11 = r11 + CodedOutputStream.computeMessageSize(3, this.wifiScanDataReport_.get(r12));
        r12 = r12 + 1;
        goto L14
    L16:
        int r13 = 0;
    L18:
        if (r13 >= this.bleScanResultDataReport_.size()) goto L21;
        r11 = r11 + CodedOutputStream.computeMessageSize(4, this.bleScanResultDataReport_.get(r13));
        r13 = r13 + 1;
        goto L18
    L21:
        if ((this.bitField0_ & 4) == 0) goto L23;
        r11 = r11 + CodedOutputStream.computeMessageSize(5, getGpsLocationSummaryReport());
    L23:
        int r14 = 0;
    L25:
        if (r14 >= this.gpsMeasurementReport_.size()) goto L28;
        r11 = r11 + CodedOutputStream.computeMessageSize(6, this.gpsMeasurementReport_.get(r14));
        r14 = r14 + 1;
    L28:
        if (r10 >= this.cellularCellRecordReport_.size()) goto L30;
        r11 = r11 + CodedOutputStream.computeMessageSize(7, this.cellularCellRecordReport_.get(r10));
        r10 = r10 + 1;
        goto L28
    L30:
        int r15 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r15;
        return r15;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public WifiScanDataReport getWifiScanDataReport(int r8) {
        return this.wifiScanDataReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public int getWifiScanDataReportCount() {
        return this.wifiScanDataReport_.size();
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<WifiScanDataReport> getWifiScanDataReportList() {
        return this.wifiScanDataReport_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public WifiScanDataReportOrBuilder getWifiScanDataReportOrBuilder(int r8) {
        return this.wifiScanDataReport_.get(r8);
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public List<? extends WifiScanDataReportOrBuilder> getWifiScanDataReportOrBuilderList() {
        return this.wifiScanDataReport_;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public boolean hasGpsLocationSummaryReport() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.connectivity.CaeConnectivityProtoDataOrBuilder
    public boolean hasName() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (hasDeviceTime() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(getDeviceTime());
    L9:
        if (hasName() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getName().hashCode();
    L12:
        if (getWifiScanDataReportCount() <= 0) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getWifiScanDataReportList().hashCode();
    L15:
        if (getBleScanResultDataReportCount() <= 0) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getBleScanResultDataReportList().hashCode();
    L18:
        if (hasGpsLocationSummaryReport() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getGpsLocationSummaryReport().hashCode();
    L21:
        if (getGpsMeasurementReportCount() <= 0) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getGpsMeasurementReportList().hashCode();
    L24:
        if (getCellularCellRecordReportCount() <= 0) goto L26;
        r10 = b.a(r10, 37, 7, 53) + getCellularCellRecordReportList().hashCode();
    L26:
        int r11 = getUnknownFields().hashCode();
        int r12 = r11 + (r10 * 29);
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r8 = this.memoizedIsInitialized;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new CaeConnectivityProtoData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeUInt64(1, this.deviceTime_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        GeneratedMessage.writeString(r8, 2, this.name_);
    L8:
        int r10 = 0;
        int r11 = 0;
    L10:
        if (r11 >= this.wifiScanDataReport_.size()) goto L12;
        r8.writeMessage(3, this.wifiScanDataReport_.get(r11));
        r11 = r11 + 1;
        goto L10
    L12:
        int r12 = 0;
    L14:
        if (r12 >= this.bleScanResultDataReport_.size()) goto L17;
        r8.writeMessage(4, this.bleScanResultDataReport_.get(r12));
        r12 = r12 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 4) == 0) goto L19;
        r8.writeMessage(5, getGpsLocationSummaryReport());
    L19:
        int r13 = 0;
    L21:
        if (r13 >= this.gpsMeasurementReport_.size()) goto L24;
        r8.writeMessage(6, this.gpsMeasurementReport_.get(r13));
        r13 = r13 + 1;
    L24:
        if (r10 >= this.cellularCellRecordReport_.size()) goto L26;
        r8.writeMessage(7, this.cellularCellRecordReport_.get(r10));
        r10 = r10 + 1;
        goto L24
    L26:
        getUnknownFields().writeTo(r8);
    }

    private CaeConnectivityProtoData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.deviceTime_ = 0;
        this.name_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CaeConnectivityProtoData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CaeConnectivityProtoData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeConnectivityProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CaeConnectivityProtoData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeConnectivityDataEvent.internal_static_com_obric_cae_connectivity_CaeConnectivityProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeConnectivityProtoData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CaeConnectivityProtoData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CaeConnectivityProtoData parseFrom(CodedInputStream r8) {
        return (CaeConnectivityProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CaeConnectivityProtoData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    public static CaeConnectivityProtoData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CaeConnectivityProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CaeConnectivityProtoData parseFrom(InputStream r8) {
        return (CaeConnectivityProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CaeConnectivityProtoData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeConnectivityProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CaeConnectivityProtoData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeConnectivityProtoData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CaeConnectivityProtoData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeConnectivityProtoData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
