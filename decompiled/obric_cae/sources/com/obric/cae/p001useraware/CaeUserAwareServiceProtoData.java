package com.obric.cae.p001useraware;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CaeUserAwareServiceProtoData extends GeneratedMessageV3 implements CaeUserAwareServiceProtoDataOrBuilder {
    private static final CaeUserAwareServiceProtoData DEFAULT_INSTANCE = null;
    public static final int HARSTATERAW_FIELD_NUMBER = 6;
    public static final int HARUSERAWARE_FIELD_NUMBER = 5;

    @Deprecated
    public static final Parser<CaeUserAwareServiceProtoData> PARSER = null;
    public static final int USERAWAREPRECISION_FIELD_NUMBER = 3;
    public static final int WIFICONNECTIONREPORT_FIELD_NUMBER = 2;
    public static final int WIFIPNOSTATSREPORT_FIELD_NUMBER = 7;
    public static final int WIFISCANCOUNTREPORT_FIELD_NUMBER = 4;
    public static final int WIFISCANREPORT_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<HARStateRawData> hARStateRaw_;
    private List<HARUserAwareData> hARUserAware_;
    private byte memoizedIsInitialized;
    private List<UserAwarePrecisionData> userAwarePrecision_;
    private List<WifiConnReportData> wifiConnectionReport_;
    private List<WifiPnoStatsReportData> wifiPnoStatsReport_;
    private List<WifiScanCountReportData> wifiScanCountReport_;
    private List<WifiScanReportData> wifiScanReport_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CaeUserAwareServiceProtoDataOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> hARStateRawBuilder_;
        private List<HARStateRawData> hARStateRaw_;
        private RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> hARUserAwareBuilder_;
        private List<HARUserAwareData> hARUserAware_;
        private RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> userAwarePrecisionBuilder_;
        private List<UserAwarePrecisionData> userAwarePrecision_;
        private RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> wifiConnectionReportBuilder_;
        private List<WifiConnReportData> wifiConnectionReport_;
        private RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> wifiPnoStatsReportBuilder_;
        private List<WifiPnoStatsReportData> wifiPnoStatsReport_;
        private RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> wifiScanCountReportBuilder_;
        private List<WifiScanCountReportData> wifiScanCountReport_;
        private RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> wifiScanReportBuilder_;
        private List<WifiScanReportData> wifiScanReport_;

        private Builder() {
            this.wifiScanReport_ = Collections.emptyList();
            this.wifiConnectionReport_ = Collections.emptyList();
            this.userAwarePrecision_ = Collections.emptyList();
            this.wifiScanCountReport_ = Collections.emptyList();
            this.hARUserAware_ = Collections.emptyList();
            this.hARStateRaw_ = Collections.emptyList();
            this.wifiPnoStatsReport_ = Collections.emptyList();
        }

        private void buildPartial0(CaeUserAwareServiceProtoData r8) {
        }

        private void buildPartialRepeatedFields(CaeUserAwareServiceProtoData r8) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r10 = this.wifiScanReportBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            CaeUserAwareServiceProtoData.access$302(r8, r11);
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r12 = this.wifiConnectionReportBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            CaeUserAwareServiceProtoData.access$402(r8, r13);
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r14 = this.userAwarePrecisionBuilder_;
            if (r14 == null) goto L19;
            List r15 = r14.build();
        L23:
            CaeUserAwareServiceProtoData.access$502(r8, r15);
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r16 = this.wifiScanCountReportBuilder_;
            if (r16 == null) goto L26;
            List r17 = r16.build();
        L30:
            CaeUserAwareServiceProtoData.access$602(r8, r17);
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r18 = this.hARUserAwareBuilder_;
            if (r18 == null) goto L33;
            List r19 = r18.build();
        L37:
            CaeUserAwareServiceProtoData.access$702(r8, r19);
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r20 = this.hARStateRawBuilder_;
            if (r20 == null) goto L40;
            List r21 = r20.build();
        L44:
            CaeUserAwareServiceProtoData.access$802(r8, r21);
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r22 = this.wifiPnoStatsReportBuilder_;
            if (r22 == null) goto L47;
            List r23 = r22.build();
        L51:
            CaeUserAwareServiceProtoData.access$902(r8, r23);
            return;
        L47:
            if ((this.bitField0_ & 64) == 0) goto L49;
            this.wifiPnoStatsReport_ = Collections.unmodifiableList(this.wifiPnoStatsReport_);
            this.bitField0_ &= -65;
        L49:
            r23 = this.wifiPnoStatsReport_;
            goto L51
        L40:
            if ((this.bitField0_ & 32) == 0) goto L42;
            this.hARStateRaw_ = Collections.unmodifiableList(this.hARStateRaw_);
            this.bitField0_ &= -33;
        L42:
            r21 = this.hARStateRaw_;
            goto L44
        L33:
            if ((this.bitField0_ & 16) == 0) goto L35;
            this.hARUserAware_ = Collections.unmodifiableList(this.hARUserAware_);
            this.bitField0_ &= -17;
        L35:
            r19 = this.hARUserAware_;
            goto L37
        L26:
            if ((this.bitField0_ & 8) == 0) goto L28;
            this.wifiScanCountReport_ = Collections.unmodifiableList(this.wifiScanCountReport_);
            this.bitField0_ &= -9;
        L28:
            r17 = this.wifiScanCountReport_;
            goto L30
        L19:
            if ((this.bitField0_ & 4) == 0) goto L21;
            this.userAwarePrecision_ = Collections.unmodifiableList(this.userAwarePrecision_);
            this.bitField0_ &= -5;
        L21:
            r15 = this.userAwarePrecision_;
            goto L23
        L12:
            if ((this.bitField0_ & 2) == 0) goto L14;
            this.wifiConnectionReport_ = Collections.unmodifiableList(this.wifiConnectionReport_);
            this.bitField0_ &= -3;
        L14:
            r13 = this.wifiConnectionReport_;
            goto L16
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.wifiScanReport_ = Collections.unmodifiableList(this.wifiScanReport_);
            this.bitField0_ &= -2;
        L7:
            r11 = this.wifiScanReport_;
            goto L9
        }

        private void ensureHARStateRawIsMutable() {
            if ((this.bitField0_ & 32) != 0) goto L6;
            this.hARStateRaw_ = new ArrayList(this.hARStateRaw_);
            this.bitField0_ |= 32;
            return;
        }

        private void ensureHARUserAwareIsMutable() {
            if ((this.bitField0_ & 16) != 0) goto L6;
            this.hARUserAware_ = new ArrayList(this.hARUserAware_);
            this.bitField0_ |= 16;
            return;
        }

        private void ensureUserAwarePrecisionIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.userAwarePrecision_ = new ArrayList(this.userAwarePrecision_);
            this.bitField0_ |= 4;
            return;
        }

        private void ensureWifiConnectionReportIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.wifiConnectionReport_ = new ArrayList(this.wifiConnectionReport_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureWifiPnoStatsReportIsMutable() {
            if ((this.bitField0_ & 64) != 0) goto L6;
            this.wifiPnoStatsReport_ = new ArrayList(this.wifiPnoStatsReport_);
            this.bitField0_ |= 64;
            return;
        }

        private void ensureWifiScanCountReportIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.wifiScanCountReport_ = new ArrayList(this.wifiScanCountReport_);
            this.bitField0_ |= 8;
            return;
        }

        private void ensureWifiScanReportIsMutable() {
            if ((this.bitField0_ & 1) != 0) goto L6;
            this.wifiScanReport_ = new ArrayList(this.wifiScanReport_);
            this.bitField0_ |= 1;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_descriptor;
        }

        private RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> getHARStateRawFieldBuilder() {
            if (this.hARStateRawBuilder_ != null) goto L10;
            List<HARStateRawData> r8 = this.hARStateRaw_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.hARStateRawBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.hARStateRaw_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.hARStateRawBuilder_;
        }

        private RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> getHARUserAwareFieldBuilder() {
            if (this.hARUserAwareBuilder_ != null) goto L10;
            List<HARUserAwareData> r8 = this.hARUserAware_;
            if ((this.bitField0_ & 16) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.hARUserAwareBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.hARUserAware_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.hARUserAwareBuilder_;
        }

        private RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> getUserAwarePrecisionFieldBuilder() {
            if (this.userAwarePrecisionBuilder_ != null) goto L10;
            List<UserAwarePrecisionData> r8 = this.userAwarePrecision_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.userAwarePrecisionBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.userAwarePrecision_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.userAwarePrecisionBuilder_;
        }

        private RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> getWifiConnectionReportFieldBuilder() {
            if (this.wifiConnectionReportBuilder_ != null) goto L10;
            List<WifiConnReportData> r8 = this.wifiConnectionReport_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.wifiConnectionReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiConnectionReport_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.wifiConnectionReportBuilder_;
        }

        private RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> getWifiPnoStatsReportFieldBuilder() {
            if (this.wifiPnoStatsReportBuilder_ != null) goto L10;
            List<WifiPnoStatsReportData> r8 = this.wifiPnoStatsReport_;
            if ((this.bitField0_ & 64) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.wifiPnoStatsReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiPnoStatsReport_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.wifiPnoStatsReportBuilder_;
        }

        private RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> getWifiScanCountReportFieldBuilder() {
            if (this.wifiScanCountReportBuilder_ != null) goto L10;
            List<WifiScanCountReportData> r8 = this.wifiScanCountReport_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.wifiScanCountReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiScanCountReport_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.wifiScanCountReportBuilder_;
        }

        private RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> getWifiScanReportFieldBuilder() {
            if (this.wifiScanReportBuilder_ != null) goto L10;
            List<WifiScanReportData> r8 = this.wifiScanReport_;
            boolean r10 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r10 = false;
        L8:
            this.wifiScanReportBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiScanReport_ = null;
        L10:
            return this.wifiScanReportBuilder_;
        }

        public Builder addAllHARStateRaw(Iterable<? extends HARStateRawData> r8) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r10 = this.hARStateRawBuilder_;
            if (r10 != null) goto L5;
            ensureHARStateRawIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.hARStateRaw_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllHARUserAware(Iterable<? extends HARUserAwareData> r8) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r10 = this.hARUserAwareBuilder_;
            if (r10 != null) goto L5;
            ensureHARUserAwareIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.hARUserAware_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllUserAwarePrecision(Iterable<? extends UserAwarePrecisionData> r8) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r10 = this.userAwarePrecisionBuilder_;
            if (r10 != null) goto L5;
            ensureUserAwarePrecisionIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.userAwarePrecision_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllWifiConnectionReport(Iterable<? extends WifiConnReportData> r8) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r10 = this.wifiConnectionReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiConnectionReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiConnectionReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllWifiPnoStatsReport(Iterable<? extends WifiPnoStatsReportData> r8) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r10 = this.wifiPnoStatsReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiPnoStatsReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiPnoStatsReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllWifiScanCountReport(Iterable<? extends WifiScanCountReportData> r8) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r10 = this.wifiScanCountReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanCountReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiScanCountReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllWifiScanReport(Iterable<? extends WifiScanReportData> r8) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r10 = this.wifiScanReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanReportIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiScanReport_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addHARStateRaw(int r8, HARStateRawData.Builder r10) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r11 = this.hARStateRawBuilder_;
            if (r11 != null) goto L5;
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public HARStateRawData.Builder addHARStateRawBuilder() {
            return (HARStateRawData.Builder) getHARStateRawFieldBuilder().addBuilder(HARStateRawData.getDefaultInstance());
        }

        public Builder addHARUserAware(int r8, HARUserAwareData.Builder r10) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r11 = this.hARUserAwareBuilder_;
            if (r11 != null) goto L5;
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public HARUserAwareData.Builder addHARUserAwareBuilder() {
            return (HARUserAwareData.Builder) getHARUserAwareFieldBuilder().addBuilder(HARUserAwareData.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addUserAwarePrecision(int r8, UserAwarePrecisionData.Builder r10) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r11 = this.userAwarePrecisionBuilder_;
            if (r11 != null) goto L5;
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public UserAwarePrecisionData.Builder addUserAwarePrecisionBuilder() {
            return (UserAwarePrecisionData.Builder) getUserAwarePrecisionFieldBuilder().addBuilder(UserAwarePrecisionData.getDefaultInstance());
        }

        public Builder addWifiConnectionReport(int r8, WifiConnReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r11 = this.wifiConnectionReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiConnReportData.Builder addWifiConnectionReportBuilder() {
            return (WifiConnReportData.Builder) getWifiConnectionReportFieldBuilder().addBuilder(WifiConnReportData.getDefaultInstance());
        }

        public Builder addWifiPnoStatsReport(int r8, WifiPnoStatsReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r11 = this.wifiPnoStatsReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiPnoStatsReportData.Builder addWifiPnoStatsReportBuilder() {
            return (WifiPnoStatsReportData.Builder) getWifiPnoStatsReportFieldBuilder().addBuilder(WifiPnoStatsReportData.getDefaultInstance());
        }

        public Builder addWifiScanCountReport(int r8, WifiScanCountReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r11 = this.wifiScanCountReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiScanCountReportData.Builder addWifiScanCountReportBuilder() {
            return (WifiScanCountReportData.Builder) getWifiScanCountReportFieldBuilder().addBuilder(WifiScanCountReportData.getDefaultInstance());
        }

        public Builder addWifiScanReport(int r8, WifiScanReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r11 = this.wifiScanReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiScanReportData.Builder addWifiScanReportBuilder() {
            return (WifiScanReportData.Builder) getWifiScanReportFieldBuilder().addBuilder(WifiScanReportData.getDefaultInstance());
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearHARStateRaw() {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r8 = this.hARStateRawBuilder_;
            if (r8 != null) goto L5;
            this.hARStateRaw_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearHARUserAware() {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r8 = this.hARUserAwareBuilder_;
            if (r8 != null) goto L5;
            this.hARUserAware_ = Collections.emptyList();
            this.bitField0_ &= -17;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearUserAwarePrecision() {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r8 = this.userAwarePrecisionBuilder_;
            if (r8 != null) goto L5;
            this.userAwarePrecision_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearWifiConnectionReport() {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r8 = this.wifiConnectionReportBuilder_;
            if (r8 != null) goto L5;
            this.wifiConnectionReport_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearWifiPnoStatsReport() {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r8 = this.wifiPnoStatsReportBuilder_;
            if (r8 != null) goto L5;
            this.wifiPnoStatsReport_ = Collections.emptyList();
            this.bitField0_ &= -65;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearWifiScanCountReport() {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r8 = this.wifiScanCountReportBuilder_;
            if (r8 != null) goto L5;
            this.wifiScanCountReport_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearWifiScanReport() {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r8 = this.wifiScanReportBuilder_;
            if (r8 != null) goto L5;
            this.wifiScanReport_ = Collections.emptyList();
            this.bitField0_ &= -2;
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

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_descriptor;
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public HARStateRawData getHARStateRaw(int r8) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r10 = this.hARStateRawBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.hARStateRaw_.get(r8);
        L6:
            return (HARStateRawData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public HARStateRawData.Builder getHARStateRawBuilder(int r8) {
            return (HARStateRawData.Builder) getHARStateRawFieldBuilder().getBuilder(r8);
        }

        public List<HARStateRawData.Builder> getHARStateRawBuilderList() {
            return getHARStateRawFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public int getHARStateRawCount() {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r8 = this.hARStateRawBuilder_;
            if (r8 != null) goto L7;
            return this.hARStateRaw_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<HARStateRawData> getHARStateRawList() {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r8 = this.hARStateRawBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.hARStateRaw_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public HARStateRawDataOrBuilder getHARStateRawOrBuilder(int r8) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r10 = this.hARStateRawBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.hARStateRaw_.get(r8);
        L6:
            return (HARStateRawDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<? extends HARStateRawDataOrBuilder> getHARStateRawOrBuilderList() {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r8 = this.hARStateRawBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.hARStateRaw_);
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public HARUserAwareData getHARUserAware(int r8) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r10 = this.hARUserAwareBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.hARUserAware_.get(r8);
        L6:
            return (HARUserAwareData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public HARUserAwareData.Builder getHARUserAwareBuilder(int r8) {
            return (HARUserAwareData.Builder) getHARUserAwareFieldBuilder().getBuilder(r8);
        }

        public List<HARUserAwareData.Builder> getHARUserAwareBuilderList() {
            return getHARUserAwareFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public int getHARUserAwareCount() {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r8 = this.hARUserAwareBuilder_;
            if (r8 != null) goto L7;
            return this.hARUserAware_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<HARUserAwareData> getHARUserAwareList() {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r8 = this.hARUserAwareBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.hARUserAware_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public HARUserAwareDataOrBuilder getHARUserAwareOrBuilder(int r8) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r10 = this.hARUserAwareBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.hARUserAware_.get(r8);
        L6:
            return (HARUserAwareDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<? extends HARUserAwareDataOrBuilder> getHARUserAwareOrBuilderList() {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r8 = this.hARUserAwareBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.hARUserAware_);
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public UserAwarePrecisionData getUserAwarePrecision(int r8) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r10 = this.userAwarePrecisionBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.userAwarePrecision_.get(r8);
        L6:
            return (UserAwarePrecisionData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public UserAwarePrecisionData.Builder getUserAwarePrecisionBuilder(int r8) {
            return (UserAwarePrecisionData.Builder) getUserAwarePrecisionFieldBuilder().getBuilder(r8);
        }

        public List<UserAwarePrecisionData.Builder> getUserAwarePrecisionBuilderList() {
            return getUserAwarePrecisionFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public int getUserAwarePrecisionCount() {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r8 = this.userAwarePrecisionBuilder_;
            if (r8 != null) goto L7;
            return this.userAwarePrecision_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<UserAwarePrecisionData> getUserAwarePrecisionList() {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r8 = this.userAwarePrecisionBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.userAwarePrecision_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public UserAwarePrecisionDataOrBuilder getUserAwarePrecisionOrBuilder(int r8) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r10 = this.userAwarePrecisionBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.userAwarePrecision_.get(r8);
        L6:
            return (UserAwarePrecisionDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<? extends UserAwarePrecisionDataOrBuilder> getUserAwarePrecisionOrBuilderList() {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r8 = this.userAwarePrecisionBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.userAwarePrecision_);
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiConnReportData getWifiConnectionReport(int r8) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r10 = this.wifiConnectionReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiConnectionReport_.get(r8);
        L6:
            return (WifiConnReportData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiConnReportData.Builder getWifiConnectionReportBuilder(int r8) {
            return (WifiConnReportData.Builder) getWifiConnectionReportFieldBuilder().getBuilder(r8);
        }

        public List<WifiConnReportData.Builder> getWifiConnectionReportBuilderList() {
            return getWifiConnectionReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public int getWifiConnectionReportCount() {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r8 = this.wifiConnectionReportBuilder_;
            if (r8 != null) goto L7;
            return this.wifiConnectionReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<WifiConnReportData> getWifiConnectionReportList() {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r8 = this.wifiConnectionReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiConnectionReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiConnReportDataOrBuilder getWifiConnectionReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r10 = this.wifiConnectionReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiConnectionReport_.get(r8);
        L6:
            return (WifiConnReportDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<? extends WifiConnReportDataOrBuilder> getWifiConnectionReportOrBuilderList() {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r8 = this.wifiConnectionReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiConnectionReport_);
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiPnoStatsReportData getWifiPnoStatsReport(int r8) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r10 = this.wifiPnoStatsReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiPnoStatsReport_.get(r8);
        L6:
            return (WifiPnoStatsReportData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiPnoStatsReportData.Builder getWifiPnoStatsReportBuilder(int r8) {
            return (WifiPnoStatsReportData.Builder) getWifiPnoStatsReportFieldBuilder().getBuilder(r8);
        }

        public List<WifiPnoStatsReportData.Builder> getWifiPnoStatsReportBuilderList() {
            return getWifiPnoStatsReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public int getWifiPnoStatsReportCount() {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r8 = this.wifiPnoStatsReportBuilder_;
            if (r8 != null) goto L7;
            return this.wifiPnoStatsReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<WifiPnoStatsReportData> getWifiPnoStatsReportList() {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r8 = this.wifiPnoStatsReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiPnoStatsReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiPnoStatsReportDataOrBuilder getWifiPnoStatsReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r10 = this.wifiPnoStatsReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiPnoStatsReport_.get(r8);
        L6:
            return (WifiPnoStatsReportDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<? extends WifiPnoStatsReportDataOrBuilder> getWifiPnoStatsReportOrBuilderList() {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r8 = this.wifiPnoStatsReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiPnoStatsReport_);
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiScanCountReportData getWifiScanCountReport(int r8) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r10 = this.wifiScanCountReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiScanCountReport_.get(r8);
        L6:
            return (WifiScanCountReportData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiScanCountReportData.Builder getWifiScanCountReportBuilder(int r8) {
            return (WifiScanCountReportData.Builder) getWifiScanCountReportFieldBuilder().getBuilder(r8);
        }

        public List<WifiScanCountReportData.Builder> getWifiScanCountReportBuilderList() {
            return getWifiScanCountReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public int getWifiScanCountReportCount() {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r8 = this.wifiScanCountReportBuilder_;
            if (r8 != null) goto L7;
            return this.wifiScanCountReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<WifiScanCountReportData> getWifiScanCountReportList() {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r8 = this.wifiScanCountReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiScanCountReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiScanCountReportDataOrBuilder getWifiScanCountReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r10 = this.wifiScanCountReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiScanCountReport_.get(r8);
        L6:
            return (WifiScanCountReportDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<? extends WifiScanCountReportDataOrBuilder> getWifiScanCountReportOrBuilderList() {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r8 = this.wifiScanCountReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiScanCountReport_);
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiScanReportData getWifiScanReport(int r8) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r10 = this.wifiScanReportBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiScanReport_.get(r8);
        L6:
            return (WifiScanReportData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiScanReportData.Builder getWifiScanReportBuilder(int r8) {
            return (WifiScanReportData.Builder) getWifiScanReportFieldBuilder().getBuilder(r8);
        }

        public List<WifiScanReportData.Builder> getWifiScanReportBuilderList() {
            return getWifiScanReportFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public int getWifiScanReportCount() {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r8 = this.wifiScanReportBuilder_;
            if (r8 != null) goto L7;
            return this.wifiScanReport_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<WifiScanReportData> getWifiScanReportList() {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r8 = this.wifiScanReportBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiScanReport_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public WifiScanReportDataOrBuilder getWifiScanReportOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r10 = this.wifiScanReportBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiScanReport_.get(r8);
        L6:
            return (WifiScanReportDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
        public List<? extends WifiScanReportDataOrBuilder> getWifiScanReportOrBuilderList() {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r8 = this.wifiScanReportBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiScanReport_);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder removeHARStateRaw(int r8) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r10 = this.hARStateRawBuilder_;
            if (r10 != null) goto L5;
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeHARUserAware(int r8) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r10 = this.hARUserAwareBuilder_;
            if (r10 != null) goto L5;
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeUserAwarePrecision(int r8) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r10 = this.userAwarePrecisionBuilder_;
            if (r10 != null) goto L5;
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeWifiConnectionReport(int r8) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r10 = this.wifiConnectionReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeWifiPnoStatsReport(int r8) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r10 = this.wifiPnoStatsReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeWifiScanCountReport(int r8) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r10 = this.wifiScanCountReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeWifiScanReport(int r8) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r10 = this.wifiScanReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setHARStateRaw(int r8, HARStateRawData.Builder r10) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r11 = this.hARStateRawBuilder_;
            if (r11 != null) goto L5;
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setHARUserAware(int r8, HARUserAwareData.Builder r10) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r11 = this.hARUserAwareBuilder_;
            if (r11 != null) goto L5;
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setUserAwarePrecision(int r8, UserAwarePrecisionData.Builder r10) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r11 = this.userAwarePrecisionBuilder_;
            if (r11 != null) goto L5;
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setWifiConnectionReport(int r8, WifiConnReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r11 = this.wifiConnectionReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setWifiPnoStatsReport(int r8, WifiPnoStatsReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r11 = this.wifiPnoStatsReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setWifiScanCountReport(int r8, WifiScanCountReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r11 = this.wifiScanCountReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setWifiScanReport(int r8, WifiScanReportData.Builder r10) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r11 = this.wifiScanReportBuilder_;
            if (r11 != null) goto L5;
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.wifiScanReport_ = Collections.emptyList();
            this.wifiConnectionReport_ = Collections.emptyList();
            this.userAwarePrecision_ = Collections.emptyList();
            this.wifiScanCountReport_ = Collections.emptyList();
            this.hARUserAware_ = Collections.emptyList();
            this.hARStateRaw_ = Collections.emptyList();
            this.wifiPnoStatsReport_ = Collections.emptyList();
        }

        public Builder addHARStateRaw(int r8, HARStateRawData r10) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r11 = this.hARStateRawBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public HARStateRawData.Builder addHARStateRawBuilder(int r8) {
            return (HARStateRawData.Builder) getHARStateRawFieldBuilder().addBuilder(r8, HARStateRawData.getDefaultInstance());
        }

        public Builder addHARUserAware(int r8, HARUserAwareData r10) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r11 = this.hARUserAwareBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public HARUserAwareData.Builder addHARUserAwareBuilder(int r8) {
            return (HARUserAwareData.Builder) getHARUserAwareFieldBuilder().addBuilder(r8, HARUserAwareData.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addUserAwarePrecision(int r8, UserAwarePrecisionData r10) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r11 = this.userAwarePrecisionBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public UserAwarePrecisionData.Builder addUserAwarePrecisionBuilder(int r8) {
            return (UserAwarePrecisionData.Builder) getUserAwarePrecisionFieldBuilder().addBuilder(r8, UserAwarePrecisionData.getDefaultInstance());
        }

        public Builder addWifiConnectionReport(int r8, WifiConnReportData r10) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r11 = this.wifiConnectionReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiConnReportData.Builder addWifiConnectionReportBuilder(int r8) {
            return (WifiConnReportData.Builder) getWifiConnectionReportFieldBuilder().addBuilder(r8, WifiConnReportData.getDefaultInstance());
        }

        public Builder addWifiPnoStatsReport(int r8, WifiPnoStatsReportData r10) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r11 = this.wifiPnoStatsReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiPnoStatsReportData.Builder addWifiPnoStatsReportBuilder(int r8) {
            return (WifiPnoStatsReportData.Builder) getWifiPnoStatsReportFieldBuilder().addBuilder(r8, WifiPnoStatsReportData.getDefaultInstance());
        }

        public Builder addWifiScanCountReport(int r8, WifiScanCountReportData r10) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r11 = this.wifiScanCountReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiScanCountReportData.Builder addWifiScanCountReportBuilder(int r8) {
            return (WifiScanCountReportData.Builder) getWifiScanCountReportFieldBuilder().addBuilder(r8, WifiScanCountReportData.getDefaultInstance());
        }

        public Builder addWifiScanReport(int r8, WifiScanReportData r10) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r11 = this.wifiScanReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiScanReportData.Builder addWifiScanReportBuilder(int r8) {
            return (WifiScanReportData.Builder) getWifiScanReportFieldBuilder().addBuilder(r8, WifiScanReportData.getDefaultInstance());
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
            return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeUserAwareServiceProtoData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setHARStateRaw(int r8, HARStateRawData r10) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r11 = this.hARStateRawBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setHARUserAware(int r8, HARUserAwareData r10) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r11 = this.hARUserAwareBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.set(r8, r10);
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

        public Builder setUserAwarePrecision(int r8, UserAwarePrecisionData r10) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r11 = this.userAwarePrecisionBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setWifiConnectionReport(int r8, WifiConnReportData r10) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r11 = this.wifiConnectionReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setWifiPnoStatsReport(int r8, WifiPnoStatsReportData r10) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r11 = this.wifiPnoStatsReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setWifiScanCountReport(int r8, WifiScanCountReportData r10) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r11 = this.wifiScanCountReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setWifiScanReport(int r8, WifiScanReportData r10) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r11 = this.wifiScanReportBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.set(r8, r10);
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

        public Builder addHARStateRaw(HARStateRawData.Builder r8) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r10 = this.hARStateRawBuilder_;
            if (r10 != null) goto L5;
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addHARUserAware(HARUserAwareData.Builder r8) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r10 = this.hARUserAwareBuilder_;
            if (r10 != null) goto L5;
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.add(r8.build());
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

        public Builder addUserAwarePrecision(UserAwarePrecisionData.Builder r8) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r10 = this.userAwarePrecisionBuilder_;
            if (r10 != null) goto L5;
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addWifiConnectionReport(WifiConnReportData.Builder r8) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r10 = this.wifiConnectionReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addWifiPnoStatsReport(WifiPnoStatsReportData.Builder r8) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r10 = this.wifiPnoStatsReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addWifiScanCountReport(WifiScanCountReportData.Builder r8) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r10 = this.wifiScanCountReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addWifiScanReport(WifiScanReportData.Builder r8) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r10 = this.wifiScanReportBuilder_;
            if (r10 != null) goto L5;
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeUserAwareServiceProtoData build() {
            CaeUserAwareServiceProtoData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CaeUserAwareServiceProtoData buildPartial() {
            CaeUserAwareServiceProtoData r8 = new CaeUserAwareServiceProtoData(this, null);
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
        public CaeUserAwareServiceProtoData getDefaultInstanceForType() {
            return CaeUserAwareServiceProtoData.getDefaultInstance();
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

        public Builder addHARStateRaw(HARStateRawData r8) {
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r10 = this.hARStateRawBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addHARUserAware(HARUserAwareData r8) {
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r10 = this.hARUserAwareBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.add(r8);
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

        public Builder addUserAwarePrecision(UserAwarePrecisionData r8) {
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r10 = this.userAwarePrecisionBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addWifiConnectionReport(WifiConnReportData r8) {
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r10 = this.wifiConnectionReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addWifiPnoStatsReport(WifiPnoStatsReportData r8) {
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r10 = this.wifiPnoStatsReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addWifiScanCountReport(WifiScanCountReportData r8) {
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r10 = this.wifiScanCountReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addWifiScanReport(WifiScanReportData r8) {
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r10 = this.wifiScanReportBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.add(r8);
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
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r8 = this.wifiScanReportBuilder_;
            if (r8 != null) goto L5;
            this.wifiScanReport_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r10 = this.wifiConnectionReportBuilder_;
            if (r10 != null) goto L9;
            this.wifiConnectionReport_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -3;
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r11 = this.userAwarePrecisionBuilder_;
            if (r11 != null) goto L13;
            this.userAwarePrecision_ = Collections.emptyList();
        L14:
            this.bitField0_ &= -5;
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r12 = this.wifiScanCountReportBuilder_;
            if (r12 != null) goto L17;
            this.wifiScanCountReport_ = Collections.emptyList();
        L18:
            this.bitField0_ &= -9;
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r13 = this.hARUserAwareBuilder_;
            if (r13 != null) goto L21;
            this.hARUserAware_ = Collections.emptyList();
        L22:
            this.bitField0_ &= -17;
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r14 = this.hARStateRawBuilder_;
            if (r14 != null) goto L25;
            this.hARStateRaw_ = Collections.emptyList();
        L26:
            this.bitField0_ &= -33;
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r15 = this.wifiPnoStatsReportBuilder_;
            if (r15 != null) goto L29;
            this.wifiPnoStatsReport_ = Collections.emptyList();
        L30:
            this.bitField0_ &= -65;
            return this;
        L29:
            this.wifiPnoStatsReport_ = null;
            r15.clear();
            goto L30
        L25:
            this.hARStateRaw_ = null;
            r14.clear();
            goto L26
        L21:
            this.hARUserAware_ = null;
            r13.clear();
            goto L22
        L17:
            this.wifiScanCountReport_ = null;
            r12.clear();
            goto L18
        L13:
            this.userAwarePrecision_ = null;
            r11.clear();
            goto L14
        L9:
            this.wifiConnectionReport_ = null;
            r10.clear();
            goto L10
        L5:
            this.wifiScanReport_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L59;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L56;
            int r12 = r8.readTag();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r12 == 0) goto L48;
            if (r12 == 10) goto L44;
            if (r12 == 18) goto L41;
            if (r12 == 26) goto L38;
            if (r12 == 34) goto L35;
            if (r12 == 42) goto L32;
            if (r12 == 50) goto L29;
            if (r12 != 58) goto L22;
            GeneratedMessage.ExtendableMessageOrBuilder r13 = (WifiPnoStatsReportData) r8.readMessage(WifiPnoStatsReportData.PARSER, r10);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            RepeatedFieldBuilderV3 r14 = this.wifiPnoStatsReportBuilder_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r14 == null) goto L26;
        L28:
            r14.addMessage(r13);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L26:
            ensureWifiPnoStatsReportIsMutable();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            List r15 = this.wifiPnoStatsReport_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
        L27:
            r15.add(r13);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L4
        L22:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L29:
            r13 = (HARStateRawData) r8.readMessage(HARStateRawData.PARSER, r10);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r14 = this.hARStateRawBuilder_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r14 != null) goto L28;
            ensureHARStateRawIsMutable();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r15 = this.hARStateRaw_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L27
        L32:
            r13 = (HARUserAwareData) r8.readMessage(HARUserAwareData.PARSER, r10);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r14 = this.hARUserAwareBuilder_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r14 != null) goto L28;
            ensureHARUserAwareIsMutable();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r15 = this.hARUserAware_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L27
        L35:
            r13 = (WifiScanCountReportData) r8.readMessage(WifiScanCountReportData.PARSER, r10);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r14 = this.wifiScanCountReportBuilder_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r14 != null) goto L28;
            ensureWifiScanCountReportIsMutable();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r15 = this.wifiScanCountReport_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L27
        L38:
            r13 = (UserAwarePrecisionData) r8.readMessage(UserAwarePrecisionData.PARSER, r10);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r14 = this.userAwarePrecisionBuilder_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r14 != null) goto L28;
            ensureUserAwarePrecisionIsMutable();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r15 = this.userAwarePrecision_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L27
        L41:
            r13 = (WifiConnReportData) r8.readMessage(WifiConnReportData.PARSER, r10);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r14 = this.wifiConnectionReportBuilder_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r14 != null) goto L28;
            ensureWifiConnectionReportIsMutable();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r15 = this.wifiConnectionReport_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            goto L27
        L44:
            r13 = (WifiScanReportData) r8.readMessage(WifiScanReportData.PARSER, r10);     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r14 = this.wifiScanReportBuilder_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            if (r14 != null) goto L28;
            ensureWifiScanReportIsMutable();     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
            r15 = this.wifiScanReport_;     // Catch: Throwable -> L49 InvalidProtocolBufferException -> L51
        L48:
            r11 = true;
            goto L4
        L49:
            th = move-exception;
            onChanged();
            throw th;
        L51:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L49
        L56:
            onChanged();
            return this;
        L59:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof CaeUserAwareServiceProtoData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((CaeUserAwareServiceProtoData) r8);
        }

        public Builder mergeFrom(CaeUserAwareServiceProtoData r8) {
            if (r8 != CaeUserAwareServiceProtoData.getDefaultInstance()) goto L5;
            return this;
        L5:
            RepeatedFieldBuilderV3<WifiPnoStatsReportData, WifiPnoStatsReportData.Builder, WifiPnoStatsReportDataOrBuilder> r10 = null;
            if (this.wifiScanReportBuilder_ != null) goto L15;
            if (CaeUserAwareServiceProtoData.access$300(r8).isEmpty() == true) goto L25;
            if (this.wifiScanReport_.isEmpty() == false) goto L12;
            this.wifiScanReport_ = CaeUserAwareServiceProtoData.access$300(r8);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L25
        L12:
            ensureWifiScanReportIsMutable();
            this.wifiScanReport_.addAll(CaeUserAwareServiceProtoData.access$300(r8));
        L25:
            if (this.wifiConnectionReportBuilder_ != null) goto L34;
            if (CaeUserAwareServiceProtoData.access$400(r8).isEmpty() == true) goto L44;
            if (this.wifiConnectionReport_.isEmpty() == false) goto L31;
            this.wifiConnectionReport_ = CaeUserAwareServiceProtoData.access$400(r8);
            this.bitField0_ &= -3;
        L32:
            onChanged();
            goto L44
        L31:
            ensureWifiConnectionReportIsMutable();
            this.wifiConnectionReport_.addAll(CaeUserAwareServiceProtoData.access$400(r8));
        L44:
            if (this.userAwarePrecisionBuilder_ != null) goto L53;
            if (CaeUserAwareServiceProtoData.access$500(r8).isEmpty() == true) goto L63;
            if (this.userAwarePrecision_.isEmpty() == false) goto L50;
            this.userAwarePrecision_ = CaeUserAwareServiceProtoData.access$500(r8);
            this.bitField0_ &= -5;
        L51:
            onChanged();
            goto L63
        L50:
            ensureUserAwarePrecisionIsMutable();
            this.userAwarePrecision_.addAll(CaeUserAwareServiceProtoData.access$500(r8));
        L63:
            if (this.wifiScanCountReportBuilder_ != null) goto L72;
            if (CaeUserAwareServiceProtoData.access$600(r8).isEmpty() == true) goto L82;
            if (this.wifiScanCountReport_.isEmpty() == false) goto L69;
            this.wifiScanCountReport_ = CaeUserAwareServiceProtoData.access$600(r8);
            this.bitField0_ &= -9;
        L70:
            onChanged();
            goto L82
        L69:
            ensureWifiScanCountReportIsMutable();
            this.wifiScanCountReport_.addAll(CaeUserAwareServiceProtoData.access$600(r8));
        L82:
            if (this.hARUserAwareBuilder_ != null) goto L91;
            if (CaeUserAwareServiceProtoData.access$700(r8).isEmpty() == true) goto L101;
            if (this.hARUserAware_.isEmpty() == false) goto L88;
            this.hARUserAware_ = CaeUserAwareServiceProtoData.access$700(r8);
            this.bitField0_ &= -17;
        L89:
            onChanged();
            goto L101
        L88:
            ensureHARUserAwareIsMutable();
            this.hARUserAware_.addAll(CaeUserAwareServiceProtoData.access$700(r8));
        L101:
            if (this.hARStateRawBuilder_ != null) goto L110;
            if (CaeUserAwareServiceProtoData.access$800(r8).isEmpty() == true) goto L120;
            if (this.hARStateRaw_.isEmpty() == false) goto L107;
            this.hARStateRaw_ = CaeUserAwareServiceProtoData.access$800(r8);
            this.bitField0_ &= -33;
        L108:
            onChanged();
            goto L120
        L107:
            ensureHARStateRawIsMutable();
            this.hARStateRaw_.addAll(CaeUserAwareServiceProtoData.access$800(r8));
        L120:
            if (this.wifiPnoStatsReportBuilder_ != null) goto L129;
            if (CaeUserAwareServiceProtoData.access$900(r8).isEmpty() == false) goto L124;
        L137:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L124:
            if (this.wifiPnoStatsReport_.isEmpty() == false) goto L126;
            this.wifiPnoStatsReport_ = CaeUserAwareServiceProtoData.access$900(r8);
            this.bitField0_ &= -65;
        L127:
            onChanged();
            goto L137
        L126:
            ensureWifiPnoStatsReportIsMutable();
            this.wifiPnoStatsReport_.addAll(CaeUserAwareServiceProtoData.access$900(r8));
            goto L127
        L129:
            if (CaeUserAwareServiceProtoData.access$900(r8).isEmpty() == true) goto L137;
            if (this.wifiPnoStatsReportBuilder_.isEmpty() == false) goto L136;
            this.wifiPnoStatsReportBuilder_.dispose();
            this.wifiPnoStatsReportBuilder_ = null;
            this.wifiPnoStatsReport_ = CaeUserAwareServiceProtoData.access$900(r8);
            this.bitField0_ &= -65;
            if (CaeUserAwareServiceProtoData.access$1600() == false) goto L135;
            r10 = getWifiPnoStatsReportFieldBuilder();
        L135:
            this.wifiPnoStatsReportBuilder_ = r10;
            goto L137
        L136:
            this.wifiPnoStatsReportBuilder_.addAllMessages(CaeUserAwareServiceProtoData.access$900(r8));
            goto L137
        L110:
            if (CaeUserAwareServiceProtoData.access$800(r8).isEmpty() == true) goto L120;
            if (this.hARStateRawBuilder_.isEmpty() == false) goto L118;
            this.hARStateRawBuilder_.dispose();
            this.hARStateRawBuilder_ = null;
            this.hARStateRaw_ = CaeUserAwareServiceProtoData.access$800(r8);
            this.bitField0_ &= -33;
            if (CaeUserAwareServiceProtoData.access$1500() == false) goto L116;
            RepeatedFieldBuilderV3<HARStateRawData, HARStateRawData.Builder, HARStateRawDataOrBuilder> r11 = getHARStateRawFieldBuilder();
        L117:
            this.hARStateRawBuilder_ = r11;
            goto L120
        L116:
            r11 = null;
            goto L117
        L118:
            this.hARStateRawBuilder_.addAllMessages(CaeUserAwareServiceProtoData.access$800(r8));
            goto L120
        L91:
            if (CaeUserAwareServiceProtoData.access$700(r8).isEmpty() == true) goto L101;
            if (this.hARUserAwareBuilder_.isEmpty() == false) goto L99;
            this.hARUserAwareBuilder_.dispose();
            this.hARUserAwareBuilder_ = null;
            this.hARUserAware_ = CaeUserAwareServiceProtoData.access$700(r8);
            this.bitField0_ &= -17;
            if (CaeUserAwareServiceProtoData.access$1400() == false) goto L97;
            RepeatedFieldBuilderV3<HARUserAwareData, HARUserAwareData.Builder, HARUserAwareDataOrBuilder> r12 = getHARUserAwareFieldBuilder();
        L98:
            this.hARUserAwareBuilder_ = r12;
            goto L101
        L97:
            r12 = null;
            goto L98
        L99:
            this.hARUserAwareBuilder_.addAllMessages(CaeUserAwareServiceProtoData.access$700(r8));
            goto L101
        L72:
            if (CaeUserAwareServiceProtoData.access$600(r8).isEmpty() == true) goto L82;
            if (this.wifiScanCountReportBuilder_.isEmpty() == false) goto L80;
            this.wifiScanCountReportBuilder_.dispose();
            this.wifiScanCountReportBuilder_ = null;
            this.wifiScanCountReport_ = CaeUserAwareServiceProtoData.access$600(r8);
            this.bitField0_ &= -9;
            if (CaeUserAwareServiceProtoData.access$1300() == false) goto L78;
            RepeatedFieldBuilderV3<WifiScanCountReportData, WifiScanCountReportData.Builder, WifiScanCountReportDataOrBuilder> r13 = getWifiScanCountReportFieldBuilder();
        L79:
            this.wifiScanCountReportBuilder_ = r13;
            goto L82
        L78:
            r13 = null;
            goto L79
        L80:
            this.wifiScanCountReportBuilder_.addAllMessages(CaeUserAwareServiceProtoData.access$600(r8));
            goto L82
        L53:
            if (CaeUserAwareServiceProtoData.access$500(r8).isEmpty() == true) goto L63;
            if (this.userAwarePrecisionBuilder_.isEmpty() == false) goto L61;
            this.userAwarePrecisionBuilder_.dispose();
            this.userAwarePrecisionBuilder_ = null;
            this.userAwarePrecision_ = CaeUserAwareServiceProtoData.access$500(r8);
            this.bitField0_ &= -5;
            if (CaeUserAwareServiceProtoData.access$1200() == false) goto L59;
            RepeatedFieldBuilderV3<UserAwarePrecisionData, UserAwarePrecisionData.Builder, UserAwarePrecisionDataOrBuilder> r14 = getUserAwarePrecisionFieldBuilder();
        L60:
            this.userAwarePrecisionBuilder_ = r14;
            goto L63
        L59:
            r14 = null;
            goto L60
        L61:
            this.userAwarePrecisionBuilder_.addAllMessages(CaeUserAwareServiceProtoData.access$500(r8));
            goto L63
        L34:
            if (CaeUserAwareServiceProtoData.access$400(r8).isEmpty() == true) goto L44;
            if (this.wifiConnectionReportBuilder_.isEmpty() == false) goto L42;
            this.wifiConnectionReportBuilder_.dispose();
            this.wifiConnectionReportBuilder_ = null;
            this.wifiConnectionReport_ = CaeUserAwareServiceProtoData.access$400(r8);
            this.bitField0_ &= -3;
            if (CaeUserAwareServiceProtoData.access$1100() == false) goto L40;
            RepeatedFieldBuilderV3<WifiConnReportData, WifiConnReportData.Builder, WifiConnReportDataOrBuilder> r15 = getWifiConnectionReportFieldBuilder();
        L41:
            this.wifiConnectionReportBuilder_ = r15;
            goto L44
        L40:
            r15 = null;
            goto L41
        L42:
            this.wifiConnectionReportBuilder_.addAllMessages(CaeUserAwareServiceProtoData.access$400(r8));
            goto L44
        L15:
            if (CaeUserAwareServiceProtoData.access$300(r8).isEmpty() == true) goto L25;
            if (this.wifiScanReportBuilder_.isEmpty() == false) goto L23;
            this.wifiScanReportBuilder_.dispose();
            this.wifiScanReportBuilder_ = null;
            this.wifiScanReport_ = CaeUserAwareServiceProtoData.access$300(r8);
            this.bitField0_ &= -2;
            if (CaeUserAwareServiceProtoData.access$1000() == false) goto L21;
            RepeatedFieldBuilderV3<WifiScanReportData, WifiScanReportData.Builder, WifiScanReportDataOrBuilder> r16 = getWifiScanReportFieldBuilder();
        L22:
            this.wifiScanReportBuilder_ = r16;
            goto L25
        L21:
            r16 = null;
            goto L22
        L23:
            this.wifiScanReportBuilder_.addAllMessages(CaeUserAwareServiceProtoData.access$300(r8));
            goto L25
        }
    }

    static {
        DEFAULT_INSTANCE = new CaeUserAwareServiceProtoData();
        PARSER = new AnonymousClass1();
    }

    private CaeUserAwareServiceProtoData() {
        this.memoizedIsInitialized = -1;
        this.wifiScanReport_ = Collections.emptyList();
        this.wifiConnectionReport_ = Collections.emptyList();
        this.userAwarePrecision_ = Collections.emptyList();
        this.wifiScanCountReport_ = Collections.emptyList();
        this.hARUserAware_ = Collections.emptyList();
        this.hARStateRaw_ = Collections.emptyList();
        this.wifiPnoStatsReport_ = Collections.emptyList();
    }

    public static /* synthetic */ boolean access$1000() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1100() {
        return GeneratedMessage.alwaysUseFieldBuilders;
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

    public static /* synthetic */ boolean access$1600() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$300(CaeUserAwareServiceProtoData r8) {
        return r8.wifiScanReport_;
    }

    public static /* synthetic */ List access$302(CaeUserAwareServiceProtoData r8, List r10) {
        r8.wifiScanReport_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(CaeUserAwareServiceProtoData r8) {
        return r8.wifiConnectionReport_;
    }

    public static /* synthetic */ List access$402(CaeUserAwareServiceProtoData r8, List r10) {
        r8.wifiConnectionReport_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$500(CaeUserAwareServiceProtoData r8) {
        return r8.userAwarePrecision_;
    }

    public static /* synthetic */ List access$502(CaeUserAwareServiceProtoData r8, List r10) {
        r8.userAwarePrecision_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$600(CaeUserAwareServiceProtoData r8) {
        return r8.wifiScanCountReport_;
    }

    public static /* synthetic */ List access$602(CaeUserAwareServiceProtoData r8, List r10) {
        r8.wifiScanCountReport_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$700(CaeUserAwareServiceProtoData r8) {
        return r8.hARUserAware_;
    }

    public static /* synthetic */ List access$702(CaeUserAwareServiceProtoData r8, List r10) {
        r8.hARUserAware_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$800(CaeUserAwareServiceProtoData r8) {
        return r8.hARStateRaw_;
    }

    public static /* synthetic */ List access$802(CaeUserAwareServiceProtoData r8, List r10) {
        r8.hARStateRaw_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$900(CaeUserAwareServiceProtoData r8) {
        return r8.wifiPnoStatsReport_;
    }

    public static /* synthetic */ List access$902(CaeUserAwareServiceProtoData r8, List r10) {
        r8.wifiPnoStatsReport_ = r10;
        return r10;
    }

    public static CaeUserAwareServiceProtoData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static CaeUserAwareServiceProtoData parseDelimitedFrom(InputStream r8) {
        return (CaeUserAwareServiceProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static CaeUserAwareServiceProtoData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<CaeUserAwareServiceProtoData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof CaeUserAwareServiceProtoData) == false) goto L8;
        CaeUserAwareServiceProtoData r10 = (CaeUserAwareServiceProtoData) r8;
        if (getWifiScanReportList().equals(r10.getWifiScanReportList()) == true) goto L13;
        return false;
    L13:
        if (getWifiConnectionReportList().equals(r10.getWifiConnectionReportList()) == true) goto L16;
        return false;
    L16:
        if (getUserAwarePrecisionList().equals(r10.getUserAwarePrecisionList()) == true) goto L19;
        return false;
    L19:
        if (getWifiScanCountReportList().equals(r10.getWifiScanCountReportList()) == true) goto L22;
        return false;
    L22:
        if (getHARUserAwareList().equals(r10.getHARUserAwareList()) == true) goto L25;
        return false;
    L25:
        if (getHARStateRawList().equals(r10.getHARStateRawList()) == true) goto L28;
        return false;
    L28:
        if (getWifiPnoStatsReportList().equals(r10.getWifiPnoStatsReportList()) == true) goto L31;
        return false;
    L31:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L33;
        return false;
    L33:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public HARStateRawData getHARStateRaw(int r8) {
        return this.hARStateRaw_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public int getHARStateRawCount() {
        return this.hARStateRaw_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<HARStateRawData> getHARStateRawList() {
        return this.hARStateRaw_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public HARStateRawDataOrBuilder getHARStateRawOrBuilder(int r8) {
        return this.hARStateRaw_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<? extends HARStateRawDataOrBuilder> getHARStateRawOrBuilderList() {
        return this.hARStateRaw_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public HARUserAwareData getHARUserAware(int r8) {
        return this.hARUserAware_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public int getHARUserAwareCount() {
        return this.hARUserAware_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<HARUserAwareData> getHARUserAwareList() {
        return this.hARUserAware_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public HARUserAwareDataOrBuilder getHARUserAwareOrBuilder(int r8) {
        return this.hARUserAware_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<? extends HARUserAwareDataOrBuilder> getHARUserAwareOrBuilderList() {
        return this.hARUserAware_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CaeUserAwareServiceProtoData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.wifiScanReport_.size()) goto L9;
        r12 = r12 + CodedOutputStream.computeMessageSize(1, this.wifiScanReport_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.wifiConnectionReport_.size()) goto L13;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.wifiConnectionReport_.get(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r14 = 0;
    L15:
        if (r14 >= this.userAwarePrecision_.size()) goto L17;
        r12 = r12 + CodedOutputStream.computeMessageSize(3, this.userAwarePrecision_.get(r14));
        r14 = r14 + 1;
        goto L15
    L17:
        int r15 = 0;
    L19:
        if (r15 >= this.wifiScanCountReport_.size()) goto L21;
        r12 = r12 + CodedOutputStream.computeMessageSize(4, this.wifiScanCountReport_.get(r15));
        r15 = r15 + 1;
        goto L19
    L21:
        int r16 = 0;
    L23:
        if (r16 >= this.hARUserAware_.size()) goto L25;
        r12 = r12 + CodedOutputStream.computeMessageSize(5, this.hARUserAware_.get(r16));
        r16 = r16 + 1;
        goto L23
    L25:
        int r17 = 0;
    L27:
        if (r17 >= this.hARStateRaw_.size()) goto L30;
        r12 = r12 + CodedOutputStream.computeMessageSize(6, this.hARStateRaw_.get(r17));
        r17 = r17 + 1;
    L30:
        if (r10 >= this.wifiPnoStatsReport_.size()) goto L32;
        r12 = r12 + CodedOutputStream.computeMessageSize(7, this.wifiPnoStatsReport_.get(r10));
        r10 = r10 + 1;
        goto L30
    L32:
        int r18 = getUnknownFields().getSerializedSize() + r12;
        this.memoizedSize = r18;
        return r18;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public UserAwarePrecisionData getUserAwarePrecision(int r8) {
        return this.userAwarePrecision_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public int getUserAwarePrecisionCount() {
        return this.userAwarePrecision_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<UserAwarePrecisionData> getUserAwarePrecisionList() {
        return this.userAwarePrecision_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public UserAwarePrecisionDataOrBuilder getUserAwarePrecisionOrBuilder(int r8) {
        return this.userAwarePrecision_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<? extends UserAwarePrecisionDataOrBuilder> getUserAwarePrecisionOrBuilderList() {
        return this.userAwarePrecision_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiConnReportData getWifiConnectionReport(int r8) {
        return this.wifiConnectionReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public int getWifiConnectionReportCount() {
        return this.wifiConnectionReport_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<WifiConnReportData> getWifiConnectionReportList() {
        return this.wifiConnectionReport_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiConnReportDataOrBuilder getWifiConnectionReportOrBuilder(int r8) {
        return this.wifiConnectionReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<? extends WifiConnReportDataOrBuilder> getWifiConnectionReportOrBuilderList() {
        return this.wifiConnectionReport_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiPnoStatsReportData getWifiPnoStatsReport(int r8) {
        return this.wifiPnoStatsReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public int getWifiPnoStatsReportCount() {
        return this.wifiPnoStatsReport_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<WifiPnoStatsReportData> getWifiPnoStatsReportList() {
        return this.wifiPnoStatsReport_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiPnoStatsReportDataOrBuilder getWifiPnoStatsReportOrBuilder(int r8) {
        return this.wifiPnoStatsReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<? extends WifiPnoStatsReportDataOrBuilder> getWifiPnoStatsReportOrBuilderList() {
        return this.wifiPnoStatsReport_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiScanCountReportData getWifiScanCountReport(int r8) {
        return this.wifiScanCountReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public int getWifiScanCountReportCount() {
        return this.wifiScanCountReport_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<WifiScanCountReportData> getWifiScanCountReportList() {
        return this.wifiScanCountReport_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiScanCountReportDataOrBuilder getWifiScanCountReportOrBuilder(int r8) {
        return this.wifiScanCountReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<? extends WifiScanCountReportDataOrBuilder> getWifiScanCountReportOrBuilderList() {
        return this.wifiScanCountReport_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiScanReportData getWifiScanReport(int r8) {
        return this.wifiScanReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public int getWifiScanReportCount() {
        return this.wifiScanReport_.size();
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<WifiScanReportData> getWifiScanReportList() {
        return this.wifiScanReport_;
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public WifiScanReportDataOrBuilder getWifiScanReportOrBuilder(int r8) {
        return this.wifiScanReport_.get(r8);
    }

    @Override // com.obric.cae.p001useraware.CaeUserAwareServiceProtoDataOrBuilder
    public List<? extends WifiScanReportDataOrBuilder> getWifiScanReportOrBuilderList() {
        return this.wifiScanReport_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (getWifiScanReportCount() <= 0) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getWifiScanReportList().hashCode();
    L9:
        if (getWifiConnectionReportCount() <= 0) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getWifiConnectionReportList().hashCode();
    L12:
        if (getUserAwarePrecisionCount() <= 0) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getUserAwarePrecisionList().hashCode();
    L15:
        if (getWifiScanCountReportCount() <= 0) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getWifiScanCountReportList().hashCode();
    L18:
        if (getHARUserAwareCount() <= 0) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getHARUserAwareList().hashCode();
    L21:
        if (getHARStateRawCount() <= 0) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getHARStateRawList().hashCode();
    L24:
        if (getWifiPnoStatsReportCount() <= 0) goto L26;
        r10 = b.a(r10, 37, 7, 53) + getWifiPnoStatsReportList().hashCode();
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
        return new CaeUserAwareServiceProtoData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.wifiScanReport_.size()) goto L6;
        r8.writeMessage(1, this.wifiScanReport_.get(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        int r12 = 0;
    L8:
        if (r12 >= this.wifiConnectionReport_.size()) goto L10;
        r8.writeMessage(2, this.wifiConnectionReport_.get(r12));
        r12 = r12 + 1;
        goto L8
    L10:
        int r13 = 0;
    L12:
        if (r13 >= this.userAwarePrecision_.size()) goto L14;
        r8.writeMessage(3, this.userAwarePrecision_.get(r13));
        r13 = r13 + 1;
        goto L12
    L14:
        int r14 = 0;
    L16:
        if (r14 >= this.wifiScanCountReport_.size()) goto L18;
        r8.writeMessage(4, this.wifiScanCountReport_.get(r14));
        r14 = r14 + 1;
        goto L16
    L18:
        int r15 = 0;
    L20:
        if (r15 >= this.hARUserAware_.size()) goto L22;
        r8.writeMessage(5, this.hARUserAware_.get(r15));
        r15 = r15 + 1;
        goto L20
    L22:
        int r16 = 0;
    L24:
        if (r16 >= this.hARStateRaw_.size()) goto L27;
        r8.writeMessage(6, this.hARStateRaw_.get(r16));
        r16 = r16 + 1;
    L27:
        if (r10 >= this.wifiPnoStatsReport_.size()) goto L29;
        r8.writeMessage(7, this.wifiPnoStatsReport_.get(r10));
        r10 = r10 + 1;
        goto L27
    L29:
        getUnknownFields().writeTo(r8);
    }

    private CaeUserAwareServiceProtoData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(CaeUserAwareServiceProtoData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static CaeUserAwareServiceProtoData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeUserAwareServiceProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static CaeUserAwareServiceProtoData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return caeUserAwareEvent.internal_static_com_obric_cae_useraware_CaeUserAwareServiceProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(CaeUserAwareServiceProtoData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ CaeUserAwareServiceProtoData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static CaeUserAwareServiceProtoData parseFrom(CodedInputStream r8) {
        return (CaeUserAwareServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public CaeUserAwareServiceProtoData getDefaultInstanceForType() {
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

    public static CaeUserAwareServiceProtoData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (CaeUserAwareServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static CaeUserAwareServiceProtoData parseFrom(InputStream r8) {
        return (CaeUserAwareServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static CaeUserAwareServiceProtoData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (CaeUserAwareServiceProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static CaeUserAwareServiceProtoData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeUserAwareServiceProtoData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static CaeUserAwareServiceProtoData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static CaeUserAwareServiceProtoData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
