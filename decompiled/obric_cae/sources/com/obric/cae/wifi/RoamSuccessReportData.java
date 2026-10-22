package com.obric.cae.wifi;

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
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class RoamSuccessReportData extends GeneratedMessageV3 implements RoamSuccessReportDataOrBuilder {
    private static final RoamSuccessReportData DEFAULT_INSTANCE = null;
    public static final int DEVICE_DATE_FIELD_NUMBER = 11;
    public static final int DEVICE_TIME_FIELD_NUMBER = 10;
    public static final int EVENT_TYPE_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<RoamSuccessReportData> PARSER = null;
    public static final int ROAM_AP_LIST_FIELD_NUMBER = 9;
    public static final int ROAM_RESULT_STATUS_FIELD_NUMBER = 8;
    public static final int ROAM_SCAN_CHAN_FREQ_FIELD_NUMBER = 7;
    public static final int ROAM_SCAN_NUM_AP_FIELD_NUMBER = 5;
    public static final int ROAM_SCAN_NUM_CHAN_FIELD_NUMBER = 6;
    public static final int ROAM_SCAN_TYPE_FIELD_NUMBER = 4;
    public static final int ROAM_TRIGGER_REASON_FIELD_NUMBER = 2;
    public static final int ROAM_TRIGGER_RSSI_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object deviceDate_;
    private long deviceTime_;
    private volatile Object eventType_;
    private byte memoizedIsInitialized;
    private List<RoamCandidateAp> roamApList_;
    private volatile Object roamResultStatus_;
    private Internal.IntList roamScanChanFreq_;
    private int roamScanNumAp_;
    private int roamScanNumChan_;
    private volatile Object roamScanType_;
    private volatile Object roamTriggerReason_;
    private int roamTriggerRssi_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoamSuccessReportDataOrBuilder {
        private int bitField0_;
        private Object deviceDate_;
        private long deviceTime_;
        private Object eventType_;
        private RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> roamApListBuilder_;
        private List<RoamCandidateAp> roamApList_;
        private Object roamResultStatus_;
        private Internal.IntList roamScanChanFreq_;
        private int roamScanNumAp_;
        private int roamScanNumChan_;
        private Object roamScanType_;
        private Object roamTriggerReason_;
        private int roamTriggerRssi_;

        private Builder() {
            this.eventType_ = "";
            this.roamTriggerReason_ = "";
            this.roamScanType_ = "";
            this.roamScanChanFreq_ = RoamSuccessReportData.access$1700();
            this.roamResultStatus_ = "";
            this.roamApList_ = Collections.emptyList();
            this.deviceDate_ = "";
        }

        private void buildPartial0(RoamSuccessReportData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            RoamSuccessReportData.access$602(r8, this.eventType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            RoamSuccessReportData.access$702(r8, this.roamTriggerReason_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            RoamSuccessReportData.access$802(r8, this.roamTriggerRssi_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            RoamSuccessReportData.access$902(r8, this.roamScanType_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            RoamSuccessReportData.access$1002(r8, this.roamScanNumAp_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            RoamSuccessReportData.access$1102(r8, this.roamScanNumChan_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 128) == 0) goto L25;
            RoamSuccessReportData.access$1202(r8, this.roamResultStatus_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 512) == 0) goto L28;
            RoamSuccessReportData.access$1302(r8, this.deviceTime_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 1024) == 0) goto L30;
            RoamSuccessReportData.access$1402(r8, this.deviceDate_);
            r11 = r11 | 256;
        L30:
            RoamSuccessReportData.access$1576(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(RoamSuccessReportData r8) {
            if ((this.bitField0_ & 64) == 0) goto L5;
            this.roamScanChanFreq_.makeImmutable();
            this.bitField0_ &= -65;
        L5:
            RoamSuccessReportData.access$402(r8, this.roamScanChanFreq_);
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = this.roamApListBuilder_;
            if (r10 == null) goto L8;
            List r11 = r10.build();
        L12:
            RoamSuccessReportData.access$502(r8, r11);
            return;
        L8:
            if ((this.bitField0_ & 256) == 0) goto L10;
            this.roamApList_ = Collections.unmodifiableList(this.roamApList_);
            this.bitField0_ &= -257;
        L10:
            r11 = this.roamApList_;
            goto L12
        }

        private void ensureRoamApListIsMutable() {
            if ((this.bitField0_ & 256) != 0) goto L6;
            this.roamApList_ = new ArrayList(this.roamApList_);
            this.bitField0_ |= 256;
            return;
        }

        private void ensureRoamScanChanFreqIsMutable() {
            if ((this.bitField0_ & 64) != 0) goto L6;
            this.roamScanChanFreq_ = RoamSuccessReportData.access$1800(this.roamScanChanFreq_);
            this.bitField0_ |= 64;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RoamSuccessReportData_descriptor;
        }

        private RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> getRoamApListFieldBuilder() {
            if (this.roamApListBuilder_ != null) goto L10;
            List<RoamCandidateAp> r8 = this.roamApList_;
            if ((this.bitField0_ & 256) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.roamApListBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.roamApList_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.roamApListBuilder_;
        }

        public Builder addAllRoamApList(Iterable<? extends RoamCandidateAp> r8) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = this.roamApListBuilder_;
            if (r10 != null) goto L5;
            ensureRoamApListIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.roamApList_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllRoamScanChanFreq(Iterable<? extends Integer> r8) {
            ensureRoamScanChanFreqIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.roamScanChanFreq_);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRoamApList(int r8, RoamCandidateAp.Builder r10) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r11 = this.roamApListBuilder_;
            if (r11 != null) goto L5;
            ensureRoamApListIsMutable();
            this.roamApList_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public RoamCandidateAp.Builder addRoamApListBuilder() {
            return (RoamCandidateAp.Builder) getRoamApListFieldBuilder().addBuilder(RoamCandidateAp.getDefaultInstance());
        }

        public Builder addRoamScanChanFreq(int r8) {
            ensureRoamScanChanFreqIsMutable();
            this.roamScanChanFreq_.addInt(r8);
            onChanged();
            return this;
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

        public Builder clearDeviceDate() {
            this.deviceDate_ = RoamSuccessReportData.getDefaultInstance().getDeviceDate();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder clearDeviceTime() {
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            this.deviceTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearEventType() {
            this.eventType_ = RoamSuccessReportData.getDefaultInstance().getEventType();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearRoamApList() {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r8 = this.roamApListBuilder_;
            if (r8 != null) goto L5;
            this.roamApList_ = Collections.emptyList();
            this.bitField0_ &= -257;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearRoamResultStatus() {
            this.roamResultStatus_ = RoamSuccessReportData.getDefaultInstance().getRoamResultStatus();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearRoamScanChanFreq() {
            this.roamScanChanFreq_ = RoamSuccessReportData.access$1900();
            this.bitField0_ &= -65;
            onChanged();
            return this;
        }

        public Builder clearRoamScanNumAp() {
            this.bitField0_ &= -17;
            this.roamScanNumAp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRoamScanNumChan() {
            this.bitField0_ &= -33;
            this.roamScanNumChan_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRoamScanType() {
            this.roamScanType_ = RoamSuccessReportData.getDefaultInstance().getRoamScanType();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        public Builder clearRoamTriggerReason() {
            this.roamTriggerReason_ = RoamSuccessReportData.getDefaultInstance().getRoamTriggerReason();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearRoamTriggerRssi() {
            this.bitField0_ &= -5;
            this.roamTriggerRssi_ = 0;
            onChanged();
            return this;
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RoamSuccessReportData_descriptor;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public String getDeviceDate() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.deviceDate_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public ByteString getDeviceDateBytes() {
            Object r8 = this.deviceDate_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.deviceDate_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public long getDeviceTime() {
            return this.deviceTime_;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public String getEventType() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.eventType_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public ByteString getEventTypeBytes() {
            Object r8 = this.eventType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.eventType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public RoamCandidateAp getRoamApList(int r8) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = this.roamApListBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.roamApList_.get(r8);
        L6:
            return (RoamCandidateAp) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public RoamCandidateAp.Builder getRoamApListBuilder(int r8) {
            return (RoamCandidateAp.Builder) getRoamApListFieldBuilder().getBuilder(r8);
        }

        public List<RoamCandidateAp.Builder> getRoamApListBuilderList() {
            return getRoamApListFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public int getRoamApListCount() {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r8 = this.roamApListBuilder_;
            if (r8 != null) goto L7;
            return this.roamApList_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public List<RoamCandidateAp> getRoamApListList() {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r8 = this.roamApListBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.roamApList_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public RoamCandidateApOrBuilder getRoamApListOrBuilder(int r8) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = this.roamApListBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.roamApList_.get(r8);
        L6:
            return (RoamCandidateApOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public List<? extends RoamCandidateApOrBuilder> getRoamApListOrBuilderList() {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r8 = this.roamApListBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.roamApList_);
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public String getRoamResultStatus() {
            Object r8 = this.roamResultStatus_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.roamResultStatus_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public ByteString getRoamResultStatusBytes() {
            Object r8 = this.roamResultStatus_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.roamResultStatus_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public int getRoamScanChanFreq(int r8) {
            return this.roamScanChanFreq_.getInt(r8);
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public int getRoamScanChanFreqCount() {
            return this.roamScanChanFreq_.size();
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public List<Integer> getRoamScanChanFreqList() {
            int r8 = this.bitField0_ & 64;
            Internal.IntList r10 = this.roamScanChanFreq_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public int getRoamScanNumAp() {
            return this.roamScanNumAp_;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public int getRoamScanNumChan() {
            return this.roamScanNumChan_;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public String getRoamScanType() {
            Object r8 = this.roamScanType_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.roamScanType_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public ByteString getRoamScanTypeBytes() {
            Object r8 = this.roamScanType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.roamScanType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public String getRoamTriggerReason() {
            Object r8 = this.roamTriggerReason_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.roamTriggerReason_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public ByteString getRoamTriggerReasonBytes() {
            Object r8 = this.roamTriggerReason_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.roamTriggerReason_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public int getRoamTriggerRssi() {
            return this.roamTriggerRssi_;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasDeviceDate() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasDeviceTime() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasEventType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasRoamResultStatus() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasRoamScanNumAp() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasRoamScanNumChan() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasRoamScanType() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasRoamTriggerReason() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
        public boolean hasRoamTriggerRssi() {
            if ((this.bitField0_ & 4) == 0) goto L5;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder removeRoamApList(int r8) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = this.roamApListBuilder_;
            if (r10 != null) goto L5;
            ensureRoamApListIsMutable();
            this.roamApList_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setDeviceDate(String r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceDateBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.deviceDate_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeviceTime(long r8) {
            this.deviceTime_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setEventType(String r8) {
            if (r8 == null) goto L6;
            this.eventType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEventTypeBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.eventType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRoamApList(int r8, RoamCandidateAp.Builder r10) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r11 = this.roamApListBuilder_;
            if (r11 != null) goto L5;
            ensureRoamApListIsMutable();
            this.roamApList_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setRoamResultStatus(String r8) {
            if (r8 == null) goto L6;
            this.roamResultStatus_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRoamResultStatusBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.roamResultStatus_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRoamScanChanFreq(int r8, int r10) {
            ensureRoamScanChanFreqIsMutable();
            this.roamScanChanFreq_.setInt(r8, r10);
            onChanged();
            return this;
        }

        public Builder setRoamScanNumAp(int r8) {
            this.roamScanNumAp_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setRoamScanNumChan(int r8) {
            this.roamScanNumChan_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setRoamScanType(String r8) {
            if (r8 == null) goto L6;
            this.roamScanType_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRoamScanTypeBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.roamScanType_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRoamTriggerReason(String r8) {
            if (r8 == null) goto L6;
            this.roamTriggerReason_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRoamTriggerReasonBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.roamTriggerReason_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setRoamTriggerRssi(int r8) {
            this.roamTriggerRssi_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.eventType_ = "";
            this.roamTriggerReason_ = "";
            this.roamScanType_ = "";
            this.roamScanChanFreq_ = RoamSuccessReportData.access$1700();
            this.roamResultStatus_ = "";
            this.roamApList_ = Collections.emptyList();
            this.deviceDate_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRoamApList(int r8, RoamCandidateAp r10) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r11 = this.roamApListBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureRoamApListIsMutable();
            this.roamApList_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public RoamCandidateAp.Builder addRoamApListBuilder(int r8) {
            return (RoamCandidateAp.Builder) getRoamApListFieldBuilder().addBuilder(r8, RoamCandidateAp.getDefaultInstance());
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
            return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RoamSuccessReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(RoamSuccessReportData.class, Builder.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRoamApList(int r8, RoamCandidateAp r10) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r11 = this.roamApListBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureRoamApListIsMutable();
            this.roamApList_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRoamApList(RoamCandidateAp.Builder r8) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = this.roamApListBuilder_;
            if (r10 != null) goto L5;
            ensureRoamApListIsMutable();
            this.roamApList_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RoamSuccessReportData build() {
            RoamSuccessReportData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RoamSuccessReportData buildPartial() {
            RoamSuccessReportData r8 = new RoamSuccessReportData(this, null);
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
        public RoamSuccessReportData getDefaultInstanceForType() {
            return RoamSuccessReportData.getDefaultInstance();
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRoamApList(RoamCandidateAp r8) {
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = this.roamApListBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureRoamApListIsMutable();
            this.roamApList_.add(r8);
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
            this.eventType_ = "";
            this.roamTriggerReason_ = "";
            this.roamTriggerRssi_ = 0;
            this.roamScanType_ = "";
            this.roamScanNumAp_ = 0;
            this.roamScanNumChan_ = 0;
            this.roamScanChanFreq_ = RoamSuccessReportData.access$200();
            this.roamResultStatus_ = "";
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r8 = this.roamApListBuilder_;
            if (r8 != null) goto L5;
            this.roamApList_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -257;
            this.deviceTime_ = 0;
            this.deviceDate_ = "";
            return this;
        L5:
            this.roamApList_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L41;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L38;
            int r12 = r8.readTag();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            switch(r12) {
                case 0: goto L28;
                case 10: goto L26;
                case 18: goto L25;
                case 24: goto L24;
                case 34: goto L23;
                case 40: goto L22;
                case 48: goto L21;
                case 56: goto L20;
                case 58: goto L15;
                case 66: goto L14;
                case 74: goto L10;
                case 80: goto L9;
                case 90: goto L8;
                default: goto L29;
            };     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L8:
            this.deviceDate_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 1024;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L9:
            this.deviceTime_ = r8.readUInt64();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 512;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L10:
            RoamCandidateAp r13 = (RoamCandidateAp) r8.readMessage(RoamCandidateAp.PARSER, r10);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r14 = this.roamApListBuilder_;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            if (r14 == null) goto L12;
            r14.addMessage(r13);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L12:
            ensureRoamApListIsMutable();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.roamApList_.add(r13);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L14:
            this.roamResultStatus_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 128;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L15:
            int r15 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            ensureRoamScanChanFreqIsMutable();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L17:
            if (r8.getBytesUntilLimit() <= 0) goto L19;
            this.roamScanChanFreq_.addInt(r8.readInt32());     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L17
        L19:
            r8.popLimit(r15);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L20:
            int r16 = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            ensureRoamScanChanFreqIsMutable();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.roamScanChanFreq_.addInt(r16);     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L21:
            this.roamScanNumChan_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 32;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L22:
            this.roamScanNumAp_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 16;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L23:
            this.roamScanType_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 8;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L24:
            this.roamTriggerRssi_ = r8.readInt32();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 4;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L25:
            this.roamTriggerReason_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 2;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            goto L4
        L26:
            this.eventType_ = r8.readBytes();     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
            this.bitField0_ |= 1;     // Catch: Throwable -> L31 InvalidProtocolBufferException -> L33
        L28:
            r11 = true;
            goto L4
        L29:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L31:
            th = move-exception;
            onChanged();
            throw th;
        L33:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L31
        L38:
            onChanged();
            return this;
        L41:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof RoamSuccessReportData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((RoamSuccessReportData) r8);
        }

        public Builder mergeFrom(RoamSuccessReportData r8) {
            if (r8 != RoamSuccessReportData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventType() == false) goto L9;
            this.eventType_ = RoamSuccessReportData.access$600(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasRoamTriggerReason() == false) goto L12;
            this.roamTriggerReason_ = RoamSuccessReportData.access$700(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasRoamTriggerRssi() == false) goto L15;
            setRoamTriggerRssi(r8.getRoamTriggerRssi());
        L15:
            if (r8.hasRoamScanType() == false) goto L18;
            this.roamScanType_ = RoamSuccessReportData.access$900(r8);
            this.bitField0_ |= 8;
            onChanged();
        L18:
            if (r8.hasRoamScanNumAp() == false) goto L21;
            setRoamScanNumAp(r8.getRoamScanNumAp());
        L21:
            if (r8.hasRoamScanNumChan() == false) goto L24;
            setRoamScanNumChan(r8.getRoamScanNumChan());
        L24:
            if (RoamSuccessReportData.access$400(r8).isEmpty() == true) goto L31;
            if (this.roamScanChanFreq_.isEmpty() == false) goto L28;
            this.roamScanChanFreq_ = RoamSuccessReportData.access$400(r8);
            this.bitField0_ &= -65;
        L29:
            onChanged();
            goto L31
        L28:
            ensureRoamScanChanFreqIsMutable();
            this.roamScanChanFreq_.addAll(RoamSuccessReportData.access$400(r8));
        L31:
            if (r8.hasRoamResultStatus() == false) goto L34;
            this.roamResultStatus_ = RoamSuccessReportData.access$1200(r8);
            this.bitField0_ |= 128;
            onChanged();
        L34:
            if (this.roamApListBuilder_ != null) goto L43;
            if (RoamSuccessReportData.access$500(r8).isEmpty() == true) goto L52;
            if (this.roamApList_.isEmpty() == false) goto L40;
            this.roamApList_ = RoamSuccessReportData.access$500(r8);
            this.bitField0_ &= -257;
        L41:
            onChanged();
            goto L52
        L40:
            ensureRoamApListIsMutable();
            this.roamApList_.addAll(RoamSuccessReportData.access$500(r8));
        L52:
            if (r8.hasDeviceTime() == false) goto L55;
            setDeviceTime(r8.getDeviceTime());
        L55:
            if (r8.hasDeviceDate() == false) goto L57;
            this.deviceDate_ = RoamSuccessReportData.access$1400(r8);
            this.bitField0_ |= 1024;
            onChanged();
        L57:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L43:
            if (RoamSuccessReportData.access$500(r8).isEmpty() == true) goto L52;
            if (this.roamApListBuilder_.isEmpty() == false) goto L50;
            this.roamApListBuilder_.dispose();
            RepeatedFieldBuilderV3<RoamCandidateAp, RoamCandidateAp.Builder, RoamCandidateApOrBuilder> r10 = null;
            this.roamApListBuilder_ = null;
            this.roamApList_ = RoamSuccessReportData.access$500(r8);
            this.bitField0_ &= -257;
            if (RoamSuccessReportData.access$1600() == false) goto L49;
            r10 = getRoamApListFieldBuilder();
        L49:
            this.roamApListBuilder_ = r10;
            goto L52
        L50:
            this.roamApListBuilder_.addAllMessages(RoamSuccessReportData.access$500(r8));
            goto L52
        }
    }

    static {
        DEFAULT_INSTANCE = new RoamSuccessReportData();
        PARSER = new AnonymousClass1();
    }

    private RoamSuccessReportData() {
        this.eventType_ = "";
        this.roamTriggerReason_ = "";
        this.roamTriggerRssi_ = 0;
        this.roamScanType_ = "";
        this.roamScanNumAp_ = 0;
        this.roamScanNumChan_ = 0;
        this.roamResultStatus_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
        this.eventType_ = "";
        this.roamTriggerReason_ = "";
        this.roamScanType_ = "";
        this.roamScanChanFreq_ = GeneratedMessage.emptyIntList();
        this.roamResultStatus_ = "";
        this.roamApList_ = Collections.emptyList();
        this.deviceDate_ = "";
    }

    public static /* synthetic */ int access$1002(RoamSuccessReportData r8, int r10) {
        r8.roamScanNumAp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(RoamSuccessReportData r8, int r10) {
        r8.roamScanNumChan_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1200(RoamSuccessReportData r8) {
        return r8.roamResultStatus_;
    }

    public static /* synthetic */ Object access$1202(RoamSuccessReportData r8, Object r10) {
        r8.roamResultStatus_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1302(RoamSuccessReportData r8, long r10) {
        r8.deviceTime_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1400(RoamSuccessReportData r8) {
        return r8.deviceDate_;
    }

    public static /* synthetic */ Object access$1402(RoamSuccessReportData r8, Object r10) {
        r8.deviceDate_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1576(RoamSuccessReportData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1600() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Internal.IntList access$1700() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Internal.IntList access$1800(Internal.IntList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.IntList access$1900() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Internal.IntList access$200() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Internal.IntList access$400(RoamSuccessReportData r8) {
        return r8.roamScanChanFreq_;
    }

    public static /* synthetic */ Internal.IntList access$402(RoamSuccessReportData r8, Internal.IntList r10) {
        r8.roamScanChanFreq_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$500(RoamSuccessReportData r8) {
        return r8.roamApList_;
    }

    public static /* synthetic */ List access$502(RoamSuccessReportData r8, List r10) {
        r8.roamApList_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$600(RoamSuccessReportData r8) {
        return r8.eventType_;
    }

    public static /* synthetic */ Object access$602(RoamSuccessReportData r8, Object r10) {
        r8.eventType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(RoamSuccessReportData r8) {
        return r8.roamTriggerReason_;
    }

    public static /* synthetic */ Object access$702(RoamSuccessReportData r8, Object r10) {
        r8.roamTriggerReason_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(RoamSuccessReportData r8, int r10) {
        r8.roamTriggerRssi_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$900(RoamSuccessReportData r8) {
        return r8.roamScanType_;
    }

    public static /* synthetic */ Object access$902(RoamSuccessReportData r8, Object r10) {
        r8.roamScanType_ = r10;
        return r10;
    }

    public static RoamSuccessReportData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RoamSuccessReportData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RoamSuccessReportData parseDelimitedFrom(InputStream r8) {
        return (RoamSuccessReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static RoamSuccessReportData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<RoamSuccessReportData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof RoamSuccessReportData) == false) goto L8;
        RoamSuccessReportData r10 = (RoamSuccessReportData) r8;
        if (hasEventType() == r10.hasEventType()) goto L13;
        return false;
    L13:
        if (hasEventType() == false) goto L18;
        if (getEventType().equals(r10.getEventType()) == true) goto L18;
        return false;
    L18:
        if (hasRoamTriggerReason() == r10.hasRoamTriggerReason()) goto L21;
        return false;
    L21:
        if (hasRoamTriggerReason() == false) goto L26;
        if (getRoamTriggerReason().equals(r10.getRoamTriggerReason()) == true) goto L26;
        return false;
    L26:
        if (hasRoamTriggerRssi() == r10.hasRoamTriggerRssi()) goto L29;
        return false;
    L29:
        if (hasRoamTriggerRssi() == false) goto L34;
        if (getRoamTriggerRssi() == r10.getRoamTriggerRssi()) goto L34;
        return false;
    L34:
        if (hasRoamScanType() == r10.hasRoamScanType()) goto L37;
        return false;
    L37:
        if (hasRoamScanType() == false) goto L42;
        if (getRoamScanType().equals(r10.getRoamScanType()) == true) goto L42;
        return false;
    L42:
        if (hasRoamScanNumAp() == r10.hasRoamScanNumAp()) goto L45;
        return false;
    L45:
        if (hasRoamScanNumAp() == false) goto L50;
        if (getRoamScanNumAp() == r10.getRoamScanNumAp()) goto L50;
        return false;
    L50:
        if (hasRoamScanNumChan() == r10.hasRoamScanNumChan()) goto L53;
        return false;
    L53:
        if (hasRoamScanNumChan() == false) goto L58;
        if (getRoamScanNumChan() == r10.getRoamScanNumChan()) goto L58;
        return false;
    L58:
        if (getRoamScanChanFreqList().equals(r10.getRoamScanChanFreqList()) == true) goto L61;
        return false;
    L61:
        if (hasRoamResultStatus() == r10.hasRoamResultStatus()) goto L64;
        return false;
    L64:
        if (hasRoamResultStatus() == false) goto L69;
        if (getRoamResultStatus().equals(r10.getRoamResultStatus()) == true) goto L69;
        return false;
    L69:
        if (getRoamApListList().equals(r10.getRoamApListList()) == true) goto L72;
        return false;
    L72:
        if (hasDeviceTime() == r10.hasDeviceTime()) goto L75;
        return false;
    L75:
        if (hasDeviceTime() == false) goto L80;
        if (getDeviceTime() == r10.getDeviceTime()) goto L80;
        return false;
    L80:
        if (hasDeviceDate() == r10.hasDeviceDate()) goto L83;
        return false;
    L83:
        if (hasDeviceDate() == false) goto L88;
        if (getDeviceDate().equals(r10.getDeviceDate()) == true) goto L88;
        return false;
    L88:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L90;
        return false;
    L90:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public String getDeviceDate() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.deviceDate_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public ByteString getDeviceDateBytes() {
        Object r8 = this.deviceDate_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.deviceDate_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public long getDeviceTime() {
        return this.deviceTime_;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public String getEventType() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.eventType_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public ByteString getEventTypeBytes() {
        Object r8 = this.eventType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.eventType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<RoamSuccessReportData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public RoamCandidateAp getRoamApList(int r8) {
        return this.roamApList_.get(r8);
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public int getRoamApListCount() {
        return this.roamApList_.size();
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public List<RoamCandidateAp> getRoamApListList() {
        return this.roamApList_;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public RoamCandidateApOrBuilder getRoamApListOrBuilder(int r8) {
        return this.roamApList_.get(r8);
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public List<? extends RoamCandidateApOrBuilder> getRoamApListOrBuilderList() {
        return this.roamApList_;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public String getRoamResultStatus() {
        Object r8 = this.roamResultStatus_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.roamResultStatus_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public ByteString getRoamResultStatusBytes() {
        Object r8 = this.roamResultStatus_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.roamResultStatus_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public int getRoamScanChanFreq(int r8) {
        return this.roamScanChanFreq_.getInt(r8);
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public int getRoamScanChanFreqCount() {
        return this.roamScanChanFreq_.size();
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public List<Integer> getRoamScanChanFreqList() {
        return this.roamScanChanFreq_;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public int getRoamScanNumAp() {
        return this.roamScanNumAp_;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public int getRoamScanNumChan() {
        return this.roamScanNumChan_;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public String getRoamScanType() {
        Object r8 = this.roamScanType_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.roamScanType_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public ByteString getRoamScanTypeBytes() {
        Object r8 = this.roamScanType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.roamScanType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public String getRoamTriggerReason() {
        Object r8 = this.roamTriggerReason_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.roamTriggerReason_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public ByteString getRoamTriggerReasonBytes() {
        Object r8 = this.roamTriggerReason_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.roamTriggerReason_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public int getRoamTriggerRssi() {
        return this.roamTriggerRssi_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.eventType_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + GeneratedMessage.computeStringSize(2, this.roamTriggerReason_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeInt32Size(3, this.roamTriggerRssi_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L19;
        r11 = r11 + GeneratedMessage.computeStringSize(4, this.roamScanType_);
    L19:
        if ((this.bitField0_ & 16) == 0) goto L22;
        r11 = r11 + CodedOutputStream.computeInt32Size(5, this.roamScanNumAp_);
    L22:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r11 = r11 + CodedOutputStream.computeInt32Size(6, this.roamScanNumChan_);
    L24:
        int r12 = 0;
        int r13 = 0;
    L26:
        if (r12 >= this.roamScanChanFreq_.size()) goto L28;
        r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(this.roamScanChanFreq_.getInt(r12));
        r12 = r12 + 1;
        goto L26
    L28:
        int r14 = (getRoamScanChanFreqList().size() * 1) + (r11 + r13);
        if ((this.bitField0_ & 64) == 0) goto L32;
        r14 = r14 + GeneratedMessage.computeStringSize(8, this.roamResultStatus_);
    L32:
        if (r10 >= this.roamApList_.size()) goto L35;
        r14 = r14 + CodedOutputStream.computeMessageSize(9, this.roamApList_.get(r10));
        r10 = r10 + 1;
        goto L32
    L35:
        if ((this.bitField0_ & 128) == 0) goto L38;
        r14 = r14 + CodedOutputStream.computeUInt64Size(10, this.deviceTime_);
    L38:
        if ((this.bitField0_ & 256) == 0) goto L40;
        r14 = r14 + GeneratedMessage.computeStringSize(11, this.deviceDate_);
    L40:
        int r15 = getUnknownFields().getSerializedSize() + r14;
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

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasDeviceDate() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasDeviceTime() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasEventType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasRoamResultStatus() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasRoamScanNumAp() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasRoamScanNumChan() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasRoamScanType() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasRoamTriggerReason() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.wifi.RoamSuccessReportDataOrBuilder
    public boolean hasRoamTriggerRssi() {
        if ((this.bitField0_ & 4) == 0) goto L5;
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
        if (hasEventType() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getEventType().hashCode();
    L9:
        if (hasRoamTriggerReason() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getRoamTriggerReason().hashCode();
    L12:
        if (hasRoamTriggerRssi() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getRoamTriggerRssi();
    L15:
        if (hasRoamScanType() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getRoamScanType().hashCode();
    L18:
        if (hasRoamScanNumAp() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getRoamScanNumAp();
    L21:
        if (hasRoamScanNumChan() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getRoamScanNumChan();
    L24:
        if (getRoamScanChanFreqCount() <= 0) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getRoamScanChanFreqList().hashCode();
    L27:
        if (hasRoamResultStatus() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getRoamResultStatus().hashCode();
    L30:
        if (getRoamApListCount() <= 0) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getRoamApListList().hashCode();
    L33:
        if (hasDeviceTime() == false) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + Internal.hashLong(getDeviceTime());
    L36:
        if (hasDeviceDate() == false) goto L38;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getDeviceDate().hashCode();
    L38:
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
        return new RoamSuccessReportData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.eventType_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.roamTriggerReason_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.roamTriggerRssi_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        GeneratedMessage.writeString(r8, 4, this.roamScanType_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.roamScanNumAp_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L20;
        r8.writeInt32(6, this.roamScanNumChan_);
    L20:
        int r10 = 0;
        int r11 = 0;
    L22:
        if (r11 >= this.roamScanChanFreq_.size()) goto L25;
        r8.writeInt32(7, this.roamScanChanFreq_.getInt(r11));
        r11 = r11 + 1;
        goto L22
    L25:
        if ((this.bitField0_ & 64) == 0) goto L28;
        GeneratedMessage.writeString(r8, 8, this.roamResultStatus_);
    L28:
        if (r10 >= this.roamApList_.size()) goto L31;
        r8.writeMessage(9, this.roamApList_.get(r10));
        r10 = r10 + 1;
        goto L28
    L31:
        if ((this.bitField0_ & 128) == 0) goto L34;
        r8.writeUInt64(10, this.deviceTime_);
    L34:
        if ((this.bitField0_ & 256) == 0) goto L36;
        GeneratedMessage.writeString(r8, 11, this.deviceDate_);
    L36:
        getUnknownFields().writeTo(r8);
    }

    private RoamSuccessReportData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventType_ = "";
        this.roamTriggerReason_ = "";
        this.roamTriggerRssi_ = 0;
        this.roamScanType_ = "";
        this.roamScanNumAp_ = 0;
        this.roamScanNumChan_ = 0;
        this.roamResultStatus_ = "";
        this.deviceTime_ = 0;
        this.deviceDate_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(RoamSuccessReportData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static RoamSuccessReportData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (RoamSuccessReportData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static RoamSuccessReportData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeWifiServiceEvent.internal_static_com_obric_cae_wifi_RoamSuccessReportData_fieldAccessorTable.ensureFieldAccessorsInitialized(RoamSuccessReportData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ RoamSuccessReportData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static RoamSuccessReportData parseFrom(CodedInputStream r8) {
        return (RoamSuccessReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public RoamSuccessReportData getDefaultInstanceForType() {
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

    public static RoamSuccessReportData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (RoamSuccessReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static RoamSuccessReportData parseFrom(InputStream r8) {
        return (RoamSuccessReportData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static RoamSuccessReportData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (RoamSuccessReportData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static RoamSuccessReportData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static RoamSuccessReportData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static RoamSuccessReportData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static RoamSuccessReportData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
