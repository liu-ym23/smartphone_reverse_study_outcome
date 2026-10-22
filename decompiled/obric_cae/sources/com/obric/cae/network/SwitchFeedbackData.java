package com.obric.cae.network;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchFeedbackData extends GeneratedMessageV3 implements SwitchFeedbackDataOrBuilder {
    private static final SwitchFeedbackData DEFAULT_INSTANCE = null;
    public static final int FEEDBACK_TYPE_FIELD_NUMBER = 2;
    public static final int NO_SWITCH_INTERVENE_FEATURE_FIELD_NUMBER = 8;
    public static final int NO_SWITCH_INTERVENE_TIMESTAMP_FIELD_NUMBER = 7;

    @Deprecated
    public static final Parser<SwitchFeedbackData> PARSER = null;
    public static final int SOLUTION_TYPE_FIELD_NUMBER = 1;
    public static final int SWITCH_FEATURE_FIELD_NUMBER = 4;
    public static final int SWITCH_INTERVENE_FEATURE_FIELD_NUMBER = 6;
    public static final int SWITCH_INTERVENE_TIMESTAMP_FIELD_NUMBER = 5;
    public static final int SWITCH_TIMESTAMP_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int feedbackType_;
    private byte memoizedIsInitialized;
    private FeatureDataPb noSwitchInterveneFeature_;
    private long noSwitchInterveneTimestamp_;
    private int solutionType_;
    private FeatureDataPb switchFeature_;
    private FeatureDataPb switchInterveneFeature_;
    private long switchInterveneTimestamp_;
    private long switchTimestamp_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SwitchFeedbackDataOrBuilder {
        private int bitField0_;
        private int feedbackType_;
        private SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> noSwitchInterveneFeatureBuilder_;
        private FeatureDataPb noSwitchInterveneFeature_;
        private long noSwitchInterveneTimestamp_;
        private int solutionType_;
        private SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> switchFeatureBuilder_;
        private FeatureDataPb switchFeature_;
        private SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> switchInterveneFeatureBuilder_;
        private FeatureDataPb switchInterveneFeature_;
        private long switchInterveneTimestamp_;
        private long switchTimestamp_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(SwitchFeedbackData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            SwitchFeedbackData.access$402(r8, this.solutionType_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            SwitchFeedbackData.access$502(r8, this.feedbackType_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            SwitchFeedbackData.access$602(r8, this.switchTimestamp_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L20;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r12 = this.switchFeatureBuilder_;
            if (r12 != null) goto L17;
            FeatureDataPb r13 = this.switchFeature_;
        L18:
            SwitchFeedbackData.access$702(r8, r13);
            r11 = r11 | 8;
            goto L20
        L17:
            r13 = (FeatureDataPb) r12.build();
        L20:
            if ((r10 & 16) == 0) goto L23;
            SwitchFeedbackData.access$802(r8, this.switchInterveneTimestamp_);
            r11 = r11 | 16;
        L23:
            if ((r10 & 32) == 0) goto L30;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r14 = this.switchInterveneFeatureBuilder_;
            if (r14 != null) goto L27;
            FeatureDataPb r15 = this.switchInterveneFeature_;
        L28:
            SwitchFeedbackData.access$902(r8, r15);
            r11 = r11 | 32;
            goto L30
        L27:
            r15 = (FeatureDataPb) r14.build();
        L30:
            if ((r10 & 64) == 0) goto L33;
            SwitchFeedbackData.access$1002(r8, this.noSwitchInterveneTimestamp_);
            r11 = r11 | 64;
        L33:
            if ((r10 & 128) == 0) goto L39;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r16 = this.noSwitchInterveneFeatureBuilder_;
            if (r16 != null) goto L37;
            FeatureDataPb r17 = this.noSwitchInterveneFeature_;
        L38:
            SwitchFeedbackData.access$1102(r8, r17);
            r11 = r11 | 128;
            goto L39
        L37:
            r17 = (FeatureDataPb) r16.build();
        L39:
            SwitchFeedbackData.access$1276(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchFeedbackData_descriptor;
        }

        private SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> getNoSwitchInterveneFeatureFieldBuilder() {
            if (this.noSwitchInterveneFeatureBuilder_ != null) goto L6;
            this.noSwitchInterveneFeatureBuilder_ = new SingleFieldBuilderV3(getNoSwitchInterveneFeature(), getParentForChildren(), isClean());
            this.noSwitchInterveneFeature_ = null;
        L6:
            return this.noSwitchInterveneFeatureBuilder_;
        }

        private SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> getSwitchFeatureFieldBuilder() {
            if (this.switchFeatureBuilder_ != null) goto L6;
            this.switchFeatureBuilder_ = new SingleFieldBuilderV3(getSwitchFeature(), getParentForChildren(), isClean());
            this.switchFeature_ = null;
        L6:
            return this.switchFeatureBuilder_;
        }

        private SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> getSwitchInterveneFeatureFieldBuilder() {
            if (this.switchInterveneFeatureBuilder_ != null) goto L6;
            this.switchInterveneFeatureBuilder_ = new SingleFieldBuilderV3(getSwitchInterveneFeature(), getParentForChildren(), isClean());
            this.switchInterveneFeature_ = null;
        L6:
            return this.switchInterveneFeatureBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (SwitchFeedbackData.access$200() == false) goto L6;
            getSwitchFeatureFieldBuilder();
            getSwitchInterveneFeatureFieldBuilder();
            getNoSwitchInterveneFeatureFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
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

        public Builder clearFeedbackType() {
            this.bitField0_ &= -3;
            this.feedbackType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearNoSwitchInterveneFeature() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.noSwitchInterveneFeature_ = null;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.noSwitchInterveneFeatureBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.noSwitchInterveneFeatureBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearNoSwitchInterveneTimestamp() {
            this.bitField0_ &= -65;
            this.noSwitchInterveneTimestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearSolutionType() {
            this.bitField0_ &= -2;
            this.solutionType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchFeature() {
            this.bitField0_ &= -9;
            this.switchFeature_ = null;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.switchFeatureBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchFeatureBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSwitchInterveneFeature() {
            this.bitField0_ &= -33;
            this.switchInterveneFeature_ = null;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.switchInterveneFeatureBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchInterveneFeatureBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSwitchInterveneTimestamp() {
            this.bitField0_ &= -17;
            this.switchInterveneTimestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchTimestamp() {
            this.bitField0_ &= -5;
            this.switchTimestamp_ = 0;
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchFeedbackData_descriptor;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public int getFeedbackType() {
            return this.feedbackType_;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public FeatureDataPb getNoSwitchInterveneFeature() {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.noSwitchInterveneFeatureBuilder_;
            if (r8 != null) goto L9;
            FeatureDataPb r10 = this.noSwitchInterveneFeature_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return FeatureDataPb.getDefaultInstance();
        L9:
            return (FeatureDataPb) r8.getMessage();
        }

        public FeatureDataPb.Builder getNoSwitchInterveneFeatureBuilder() {
            this.bitField0_ |= 128;
            onChanged();
            return (FeatureDataPb.Builder) getNoSwitchInterveneFeatureFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public FeatureDataPbOrBuilder getNoSwitchInterveneFeatureOrBuilder() {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.noSwitchInterveneFeatureBuilder_;
            if (r8 != null) goto L5;
            FeatureDataPb r10 = this.noSwitchInterveneFeature_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return FeatureDataPb.getDefaultInstance();
        L5:
            return (FeatureDataPbOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public long getNoSwitchInterveneTimestamp() {
            return this.noSwitchInterveneTimestamp_;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public int getSolutionType() {
            return this.solutionType_;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public FeatureDataPb getSwitchFeature() {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.switchFeatureBuilder_;
            if (r8 != null) goto L9;
            FeatureDataPb r10 = this.switchFeature_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return FeatureDataPb.getDefaultInstance();
        L9:
            return (FeatureDataPb) r8.getMessage();
        }

        public FeatureDataPb.Builder getSwitchFeatureBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (FeatureDataPb.Builder) getSwitchFeatureFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public FeatureDataPbOrBuilder getSwitchFeatureOrBuilder() {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.switchFeatureBuilder_;
            if (r8 != null) goto L5;
            FeatureDataPb r10 = this.switchFeature_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return FeatureDataPb.getDefaultInstance();
        L5:
            return (FeatureDataPbOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public FeatureDataPb getSwitchInterveneFeature() {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.switchInterveneFeatureBuilder_;
            if (r8 != null) goto L9;
            FeatureDataPb r10 = this.switchInterveneFeature_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return FeatureDataPb.getDefaultInstance();
        L9:
            return (FeatureDataPb) r8.getMessage();
        }

        public FeatureDataPb.Builder getSwitchInterveneFeatureBuilder() {
            this.bitField0_ |= 32;
            onChanged();
            return (FeatureDataPb.Builder) getSwitchInterveneFeatureFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public FeatureDataPbOrBuilder getSwitchInterveneFeatureOrBuilder() {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.switchInterveneFeatureBuilder_;
            if (r8 != null) goto L5;
            FeatureDataPb r10 = this.switchInterveneFeature_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return FeatureDataPb.getDefaultInstance();
        L5:
            return (FeatureDataPbOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public long getSwitchInterveneTimestamp() {
            return this.switchInterveneTimestamp_;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public long getSwitchTimestamp() {
            return this.switchTimestamp_;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasFeedbackType() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasNoSwitchInterveneFeature() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasNoSwitchInterveneTimestamp() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasSolutionType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasSwitchFeature() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasSwitchInterveneFeature() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasSwitchInterveneTimestamp() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
        public boolean hasSwitchTimestamp() {
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

        public Builder mergeNoSwitchInterveneFeature(FeatureDataPb r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.noSwitchInterveneFeatureBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 128) == 0) goto L11;
            FeatureDataPb r11 = this.noSwitchInterveneFeature_;
            if (r11 == null) goto L11;
            if (r11 == FeatureDataPb.getDefaultInstance()) goto L11;
            getNoSwitchInterveneFeatureBuilder().mergeFrom(r8);
        L11:
            this.noSwitchInterveneFeature_ = r8;
            goto L13
        }

        public Builder mergeSwitchFeature(FeatureDataPb r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.switchFeatureBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            FeatureDataPb r11 = this.switchFeature_;
            if (r11 == null) goto L11;
            if (r11 == FeatureDataPb.getDefaultInstance()) goto L11;
            getSwitchFeatureBuilder().mergeFrom(r8);
        L11:
            this.switchFeature_ = r8;
            goto L13
        }

        public Builder mergeSwitchInterveneFeature(FeatureDataPb r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.switchInterveneFeatureBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 32) == 0) goto L11;
            FeatureDataPb r11 = this.switchInterveneFeature_;
            if (r11 == null) goto L11;
            if (r11 == FeatureDataPb.getDefaultInstance()) goto L11;
            getSwitchInterveneFeatureBuilder().mergeFrom(r8);
        L11:
            this.switchInterveneFeature_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setFeedbackType(int r8) {
            this.feedbackType_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setNoSwitchInterveneFeature(FeatureDataPb.Builder r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.noSwitchInterveneFeatureBuilder_;
            FeatureDataPb r11 = r8.build();
            if (r10 != null) goto L5;
            this.noSwitchInterveneFeature_ = r11;
        L6:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setNoSwitchInterveneTimestamp(long r8) {
            this.noSwitchInterveneTimestamp_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSolutionType(int r8) {
            this.solutionType_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setSwitchFeature(FeatureDataPb.Builder r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.switchFeatureBuilder_;
            FeatureDataPb r11 = r8.build();
            if (r10 != null) goto L5;
            this.switchFeature_ = r11;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSwitchInterveneFeature(FeatureDataPb.Builder r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.switchInterveneFeatureBuilder_;
            FeatureDataPb r11 = r8.build();
            if (r10 != null) goto L5;
            this.switchInterveneFeature_ = r11;
        L6:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSwitchInterveneTimestamp(long r8) {
            this.switchInterveneTimestamp_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setSwitchTimestamp(long r8) {
            this.switchTimestamp_ = r8;
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
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchFeedbackData_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchFeedbackData.class, Builder.class);
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

        public Builder setNoSwitchInterveneFeature(FeatureDataPb r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.noSwitchInterveneFeatureBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.noSwitchInterveneFeature_ = r8;
        L9:
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSwitchFeature(FeatureDataPb r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.switchFeatureBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.switchFeature_ = r8;
        L9:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setSwitchInterveneFeature(FeatureDataPb r8) {
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.switchInterveneFeatureBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.switchInterveneFeature_ = r8;
        L9:
            this.bitField0_ |= 32;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
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

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchFeedbackData build() {
            SwitchFeedbackData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchFeedbackData buildPartial() {
            SwitchFeedbackData r8 = new SwitchFeedbackData(this, null);
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
        public SwitchFeedbackData getDefaultInstanceForType() {
            return SwitchFeedbackData.getDefaultInstance();
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
            this.solutionType_ = 0;
            this.feedbackType_ = 0;
            this.switchTimestamp_ = 0;
            this.switchFeature_ = null;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r8 = this.switchFeatureBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchFeatureBuilder_ = null;
        L5:
            this.switchInterveneTimestamp_ = 0;
            this.switchInterveneFeature_ = null;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r10 = this.switchInterveneFeatureBuilder_;
            if (r10 == null) goto L8;
            r10.dispose();
            this.switchInterveneFeatureBuilder_ = null;
        L8:
            this.noSwitchInterveneTimestamp_ = 0;
            this.noSwitchInterveneFeature_ = null;
            SingleFieldBuilderV3<FeatureDataPb, FeatureDataPb.Builder, FeatureDataPbOrBuilder> r11 = this.noSwitchInterveneFeatureBuilder_;
            if (r11 == null) goto L11;
            r11.dispose();
            this.noSwitchInterveneFeatureBuilder_ = null;
        L11:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L46;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L43;
            int r12 = r8.readTag();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r12 == 0) goto L35;
            if (r12 != 8) goto L10;
            this.solutionType_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.feedbackType_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.switchTimestamp_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L14:
            if (r12 != 34) goto L16;
            r8.readMessage(getSwitchFeatureFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.switchInterveneTimestamp_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L18:
            if (r12 != 50) goto L20;
            r8.readMessage(getSwitchInterveneFeatureFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L20:
            if (r12 != 56) goto L22;
            this.noSwitchInterveneTimestamp_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 64;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L22:
            if (r12 != 66) goto L24;
            r8.readMessage(getNoSwitchInterveneFeatureFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 128;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L24:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L35:
            r11 = true;
            goto L4
        L38:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            onChanged();
            throw th;
        L43:
            onChanged();
            return this;
        L46:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof SwitchFeedbackData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((SwitchFeedbackData) r8);
        }

        public Builder mergeFrom(SwitchFeedbackData r8) {
            if (r8 != SwitchFeedbackData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSolutionType() == false) goto L9;
            setSolutionType(r8.getSolutionType());
        L9:
            if (r8.hasFeedbackType() == false) goto L12;
            setFeedbackType(r8.getFeedbackType());
        L12:
            if (r8.hasSwitchTimestamp() == false) goto L15;
            setSwitchTimestamp(r8.getSwitchTimestamp());
        L15:
            if (r8.hasSwitchFeature() == false) goto L18;
            mergeSwitchFeature(r8.getSwitchFeature());
        L18:
            if (r8.hasSwitchInterveneTimestamp() == false) goto L21;
            setSwitchInterveneTimestamp(r8.getSwitchInterveneTimestamp());
        L21:
            if (r8.hasSwitchInterveneFeature() == false) goto L24;
            mergeSwitchInterveneFeature(r8.getSwitchInterveneFeature());
        L24:
            if (r8.hasNoSwitchInterveneTimestamp() == false) goto L27;
            setNoSwitchInterveneTimestamp(r8.getNoSwitchInterveneTimestamp());
        L27:
            if (r8.hasNoSwitchInterveneFeature() == false) goto L29;
            mergeNoSwitchInterveneFeature(r8.getNoSwitchInterveneFeature());
        L29:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new SwitchFeedbackData();
        PARSER = new AnonymousClass1();
    }

    private SwitchFeedbackData() {
        this.solutionType_ = 0;
        this.feedbackType_ = 0;
        this.switchTimestamp_ = 0;
        this.switchInterveneTimestamp_ = 0;
        this.noSwitchInterveneTimestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ long access$1002(SwitchFeedbackData r8, long r10) {
        r8.noSwitchInterveneTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ FeatureDataPb access$1102(SwitchFeedbackData r8, FeatureDataPb r10) {
        r8.noSwitchInterveneFeature_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1276(SwitchFeedbackData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$402(SwitchFeedbackData r8, int r10) {
        r8.solutionType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(SwitchFeedbackData r8, int r10) {
        r8.feedbackType_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$602(SwitchFeedbackData r8, long r10) {
        r8.switchTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ FeatureDataPb access$702(SwitchFeedbackData r8, FeatureDataPb r10) {
        r8.switchFeature_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$802(SwitchFeedbackData r8, long r10) {
        r8.switchInterveneTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ FeatureDataPb access$902(SwitchFeedbackData r8, FeatureDataPb r10) {
        r8.switchInterveneFeature_ = r10;
        return r10;
    }

    public static SwitchFeedbackData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchFeedbackData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SwitchFeedbackData parseDelimitedFrom(InputStream r8) {
        return (SwitchFeedbackData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static SwitchFeedbackData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<SwitchFeedbackData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof SwitchFeedbackData) == false) goto L8;
        SwitchFeedbackData r10 = (SwitchFeedbackData) r8;
        if (hasSolutionType() == r10.hasSolutionType()) goto L13;
        return false;
    L13:
        if (hasSolutionType() == false) goto L18;
        if (getSolutionType() == r10.getSolutionType()) goto L18;
        return false;
    L18:
        if (hasFeedbackType() == r10.hasFeedbackType()) goto L21;
        return false;
    L21:
        if (hasFeedbackType() == false) goto L26;
        if (getFeedbackType() == r10.getFeedbackType()) goto L26;
        return false;
    L26:
        if (hasSwitchTimestamp() == r10.hasSwitchTimestamp()) goto L29;
        return false;
    L29:
        if (hasSwitchTimestamp() == false) goto L34;
        if (getSwitchTimestamp() == r10.getSwitchTimestamp()) goto L34;
        return false;
    L34:
        if (hasSwitchFeature() == r10.hasSwitchFeature()) goto L37;
        return false;
    L37:
        if (hasSwitchFeature() == false) goto L42;
        if (getSwitchFeature().equals(r10.getSwitchFeature()) == true) goto L42;
        return false;
    L42:
        if (hasSwitchInterveneTimestamp() == r10.hasSwitchInterveneTimestamp()) goto L45;
        return false;
    L45:
        if (hasSwitchInterveneTimestamp() == false) goto L50;
        if (getSwitchInterveneTimestamp() == r10.getSwitchInterveneTimestamp()) goto L50;
        return false;
    L50:
        if (hasSwitchInterveneFeature() == r10.hasSwitchInterveneFeature()) goto L53;
        return false;
    L53:
        if (hasSwitchInterveneFeature() == false) goto L58;
        if (getSwitchInterveneFeature().equals(r10.getSwitchInterveneFeature()) == true) goto L58;
        return false;
    L58:
        if (hasNoSwitchInterveneTimestamp() == r10.hasNoSwitchInterveneTimestamp()) goto L61;
        return false;
    L61:
        if (hasNoSwitchInterveneTimestamp() == false) goto L66;
        if (getNoSwitchInterveneTimestamp() == r10.getNoSwitchInterveneTimestamp()) goto L66;
        return false;
    L66:
        if (hasNoSwitchInterveneFeature() == r10.hasNoSwitchInterveneFeature()) goto L69;
        return false;
    L69:
        if (hasNoSwitchInterveneFeature() == false) goto L74;
        if (getNoSwitchInterveneFeature().equals(r10.getNoSwitchInterveneFeature()) == true) goto L74;
        return false;
    L74:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L76;
        return false;
    L76:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public int getFeedbackType() {
        return this.feedbackType_;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public FeatureDataPb getNoSwitchInterveneFeature() {
        FeatureDataPb r8 = this.noSwitchInterveneFeature_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return FeatureDataPb.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public FeatureDataPbOrBuilder getNoSwitchInterveneFeatureOrBuilder() {
        FeatureDataPb r8 = this.noSwitchInterveneFeature_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return FeatureDataPb.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public long getNoSwitchInterveneTimestamp() {
        return this.noSwitchInterveneTimestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SwitchFeedbackData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt32Size(1, this.solutionType_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.feedbackType_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt64Size(3, this.switchTimestamp_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeMessageSize(4, getSwitchFeature());
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt64Size(5, this.switchInterveneTimestamp_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeMessageSize(6, getSwitchInterveneFeature());
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt64Size(7, this.noSwitchInterveneTimestamp_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L29;
        r10 = r10 + CodedOutputStream.computeMessageSize(8, getNoSwitchInterveneFeature());
    L29:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public int getSolutionType() {
        return this.solutionType_;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public FeatureDataPb getSwitchFeature() {
        FeatureDataPb r8 = this.switchFeature_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return FeatureDataPb.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public FeatureDataPbOrBuilder getSwitchFeatureOrBuilder() {
        FeatureDataPb r8 = this.switchFeature_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return FeatureDataPb.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public FeatureDataPb getSwitchInterveneFeature() {
        FeatureDataPb r8 = this.switchInterveneFeature_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return FeatureDataPb.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public FeatureDataPbOrBuilder getSwitchInterveneFeatureOrBuilder() {
        FeatureDataPb r8 = this.switchInterveneFeature_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return FeatureDataPb.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public long getSwitchInterveneTimestamp() {
        return this.switchInterveneTimestamp_;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public long getSwitchTimestamp() {
        return this.switchTimestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasFeedbackType() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasNoSwitchInterveneFeature() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasNoSwitchInterveneTimestamp() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasSolutionType() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasSwitchFeature() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasSwitchInterveneFeature() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasSwitchInterveneTimestamp() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchFeedbackDataOrBuilder
    public boolean hasSwitchTimestamp() {
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
        if (hasSolutionType() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSolutionType();
    L9:
        if (hasFeedbackType() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getFeedbackType();
    L12:
        if (hasSwitchTimestamp() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Internal.hashLong(getSwitchTimestamp());
    L15:
        if (hasSwitchFeature() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getSwitchFeature().hashCode();
    L18:
        if (hasSwitchInterveneTimestamp() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + Internal.hashLong(getSwitchInterveneTimestamp());
    L21:
        if (hasSwitchInterveneFeature() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getSwitchInterveneFeature().hashCode();
    L24:
        if (hasNoSwitchInterveneTimestamp() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + Internal.hashLong(getNoSwitchInterveneTimestamp());
    L27:
        if (hasNoSwitchInterveneFeature() == false) goto L29;
        r10 = b.a(r10, 37, 8, 53) + getNoSwitchInterveneFeature().hashCode();
    L29:
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
        return new SwitchFeedbackData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt32(1, this.solutionType_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.feedbackType_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt64(3, this.switchTimestamp_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeMessage(4, getSwitchFeature());
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt64(5, this.switchInterveneTimestamp_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeMessage(6, getSwitchInterveneFeature());
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt64(7, this.noSwitchInterveneTimestamp_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L26;
        r8.writeMessage(8, getNoSwitchInterveneFeature());
    L26:
        getUnknownFields().writeTo(r8);
    }

    private SwitchFeedbackData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.solutionType_ = 0;
        this.feedbackType_ = 0;
        this.switchTimestamp_ = 0;
        this.switchInterveneTimestamp_ = 0;
        this.noSwitchInterveneTimestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(SwitchFeedbackData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static SwitchFeedbackData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchFeedbackData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static SwitchFeedbackData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchFeedbackData_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchFeedbackData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ SwitchFeedbackData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static SwitchFeedbackData parseFrom(CodedInputStream r8) {
        return (SwitchFeedbackData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public SwitchFeedbackData getDefaultInstanceForType() {
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

    public static SwitchFeedbackData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (SwitchFeedbackData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static SwitchFeedbackData parseFrom(InputStream r8) {
        return (SwitchFeedbackData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static SwitchFeedbackData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchFeedbackData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static SwitchFeedbackData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchFeedbackData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static SwitchFeedbackData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchFeedbackData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
