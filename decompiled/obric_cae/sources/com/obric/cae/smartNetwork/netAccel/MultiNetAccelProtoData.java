package com.obric.cae.smartNetwork.netAccel;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiNetAccelProtoData extends GeneratedMessageV3 implements MultiNetAccelProtoDataOrBuilder {
    public static final int ACCELCAPABILITY_FIELD_NUMBER = 1;
    public static final int ACCELUIDCAPABILITY_FIELD_NUMBER = 2;
    public static final int APPSOCKETSTATS_FIELD_NUMBER = 4;
    public static final int AUTODUALWLANCAPABILITY_FIELD_NUMBER = 3;
    private static final MultiNetAccelProtoData DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<MultiNetAccelProtoData> PARSER = null;
    private static final long serialVersionUID = 0;
    private AccelCapability accelCapability_;
    private AccelUidCapability accelUidCapability_;
    private AppSocketStats appSocketStats_;
    private AutoDualWlanCapability autoDualWlanCapability_;
    private int bitField0_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MultiNetAccelProtoDataOrBuilder {
        private SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> accelCapabilityBuilder_;
        private AccelCapability accelCapability_;
        private SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> accelUidCapabilityBuilder_;
        private AccelUidCapability accelUidCapability_;
        private SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> appSocketStatsBuilder_;
        private AppSocketStats appSocketStats_;
        private SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> autoDualWlanCapabilityBuilder_;
        private AutoDualWlanCapability autoDualWlanCapability_;
        private int bitField0_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(MultiNetAccelProtoData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L9;
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r11 = this.accelCapabilityBuilder_;
            if (r11 != null) goto L7;
            AccelCapability r12 = this.accelCapability_;
        L8:
            MultiNetAccelProtoData.access$402(r8, r12);
            int r13 = 1;
        L11:
            if ((r10 & 2) == 0) goto L18;
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r14 = this.accelUidCapabilityBuilder_;
            if (r14 != null) goto L15;
            AccelUidCapability r15 = this.accelUidCapability_;
        L16:
            MultiNetAccelProtoData.access$502(r8, r15);
            r13 = r13 | 2;
            goto L18
        L15:
            r15 = (AccelUidCapability) r14.build();
        L18:
            if ((r10 & 4) == 0) goto L25;
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r16 = this.autoDualWlanCapabilityBuilder_;
            if (r16 != null) goto L22;
            AutoDualWlanCapability r17 = this.autoDualWlanCapability_;
        L23:
            MultiNetAccelProtoData.access$602(r8, r17);
            r13 = r13 | 4;
            goto L25
        L22:
            r17 = (AutoDualWlanCapability) r16.build();
        L25:
            if ((r10 & 8) == 0) goto L31;
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r18 = this.appSocketStatsBuilder_;
            if (r18 != null) goto L29;
            AppSocketStats r19 = this.appSocketStats_;
        L30:
            MultiNetAccelProtoData.access$702(r8, r19);
            r13 = r13 | 8;
            goto L31
        L29:
            r19 = (AppSocketStats) r18.build();
        L31:
            MultiNetAccelProtoData.access$876(r8, r13);
            return;
        L7:
            r12 = (AccelCapability) r11.build();
            goto L8
        L9:
            r13 = 0;
            goto L11
        }

        private SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> getAccelCapabilityFieldBuilder() {
            if (this.accelCapabilityBuilder_ != null) goto L6;
            this.accelCapabilityBuilder_ = new SingleFieldBuilderV3(getAccelCapability(), getParentForChildren(), isClean());
            this.accelCapability_ = null;
        L6:
            return this.accelCapabilityBuilder_;
        }

        private SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> getAccelUidCapabilityFieldBuilder() {
            if (this.accelUidCapabilityBuilder_ != null) goto L6;
            this.accelUidCapabilityBuilder_ = new SingleFieldBuilderV3(getAccelUidCapability(), getParentForChildren(), isClean());
            this.accelUidCapability_ = null;
        L6:
            return this.accelUidCapabilityBuilder_;
        }

        private SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> getAppSocketStatsFieldBuilder() {
            if (this.appSocketStatsBuilder_ != null) goto L6;
            this.appSocketStatsBuilder_ = new SingleFieldBuilderV3(getAppSocketStats(), getParentForChildren(), isClean());
            this.appSocketStats_ = null;
        L6:
            return this.appSocketStatsBuilder_;
        }

        private SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> getAutoDualWlanCapabilityFieldBuilder() {
            if (this.autoDualWlanCapabilityBuilder_ != null) goto L6;
            this.autoDualWlanCapabilityBuilder_ = new SingleFieldBuilderV3(getAutoDualWlanCapability(), getParentForChildren(), isClean());
            this.autoDualWlanCapability_ = null;
        L6:
            return this.autoDualWlanCapabilityBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (MultiNetAccelProtoData.access$200() == false) goto L6;
            getAccelCapabilityFieldBuilder();
            getAccelUidCapabilityFieldBuilder();
            getAutoDualWlanCapabilityFieldBuilder();
            getAppSocketStatsFieldBuilder();
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

        public Builder clearAccelCapability() {
            this.bitField0_ &= -2;
            this.accelCapability_ = null;
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r8 = this.accelCapabilityBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.accelCapabilityBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearAccelUidCapability() {
            this.bitField0_ &= -3;
            this.accelUidCapability_ = null;
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r8 = this.accelUidCapabilityBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.accelUidCapabilityBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearAppSocketStats() {
            this.bitField0_ &= -9;
            this.appSocketStats_ = null;
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r8 = this.appSocketStatsBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.appSocketStatsBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearAutoDualWlanCapability() {
            this.bitField0_ &= -5;
            this.autoDualWlanCapability_ = null;
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r8 = this.autoDualWlanCapabilityBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.autoDualWlanCapabilityBuilder_ = null;
        L5:
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AccelCapability getAccelCapability() {
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r8 = this.accelCapabilityBuilder_;
            if (r8 != null) goto L9;
            AccelCapability r10 = this.accelCapability_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return AccelCapability.getDefaultInstance();
        L9:
            return (AccelCapability) r8.getMessage();
        }

        public AccelCapability.Builder getAccelCapabilityBuilder() {
            this.bitField0_ |= 1;
            onChanged();
            return (AccelCapability.Builder) getAccelCapabilityFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AccelCapabilityOrBuilder getAccelCapabilityOrBuilder() {
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r8 = this.accelCapabilityBuilder_;
            if (r8 != null) goto L5;
            AccelCapability r10 = this.accelCapability_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return AccelCapability.getDefaultInstance();
        L5:
            return (AccelCapabilityOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AccelUidCapability getAccelUidCapability() {
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r8 = this.accelUidCapabilityBuilder_;
            if (r8 != null) goto L9;
            AccelUidCapability r10 = this.accelUidCapability_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return AccelUidCapability.getDefaultInstance();
        L9:
            return (AccelUidCapability) r8.getMessage();
        }

        public AccelUidCapability.Builder getAccelUidCapabilityBuilder() {
            this.bitField0_ |= 2;
            onChanged();
            return (AccelUidCapability.Builder) getAccelUidCapabilityFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AccelUidCapabilityOrBuilder getAccelUidCapabilityOrBuilder() {
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r8 = this.accelUidCapabilityBuilder_;
            if (r8 != null) goto L5;
            AccelUidCapability r10 = this.accelUidCapability_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return AccelUidCapability.getDefaultInstance();
        L5:
            return (AccelUidCapabilityOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AppSocketStats getAppSocketStats() {
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r8 = this.appSocketStatsBuilder_;
            if (r8 != null) goto L9;
            AppSocketStats r10 = this.appSocketStats_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return AppSocketStats.getDefaultInstance();
        L9:
            return (AppSocketStats) r8.getMessage();
        }

        public AppSocketStats.Builder getAppSocketStatsBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (AppSocketStats.Builder) getAppSocketStatsFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AppSocketStatsOrBuilder getAppSocketStatsOrBuilder() {
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r8 = this.appSocketStatsBuilder_;
            if (r8 != null) goto L5;
            AppSocketStats r10 = this.appSocketStats_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return AppSocketStats.getDefaultInstance();
        L5:
            return (AppSocketStatsOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AutoDualWlanCapability getAutoDualWlanCapability() {
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r8 = this.autoDualWlanCapabilityBuilder_;
            if (r8 != null) goto L9;
            AutoDualWlanCapability r10 = this.autoDualWlanCapability_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return AutoDualWlanCapability.getDefaultInstance();
        L9:
            return (AutoDualWlanCapability) r8.getMessage();
        }

        public AutoDualWlanCapability.Builder getAutoDualWlanCapabilityBuilder() {
            this.bitField0_ |= 4;
            onChanged();
            return (AutoDualWlanCapability.Builder) getAutoDualWlanCapabilityFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public AutoDualWlanCapabilityOrBuilder getAutoDualWlanCapabilityOrBuilder() {
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r8 = this.autoDualWlanCapabilityBuilder_;
            if (r8 != null) goto L5;
            AutoDualWlanCapability r10 = this.autoDualWlanCapability_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return AutoDualWlanCapability.getDefaultInstance();
        L5:
            return (AutoDualWlanCapabilityOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_descriptor;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public boolean hasAccelCapability() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public boolean hasAccelUidCapability() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public boolean hasAppSocketStats() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
        public boolean hasAutoDualWlanCapability() {
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

        public Builder mergeAccelCapability(AccelCapability r8) {
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r10 = this.accelCapabilityBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 1) == 0) goto L11;
            AccelCapability r11 = this.accelCapability_;
            if (r11 == null) goto L11;
            if (r11 == AccelCapability.getDefaultInstance()) goto L11;
            getAccelCapabilityBuilder().mergeFrom(r8);
        L11:
            this.accelCapability_ = r8;
            goto L13
        }

        public Builder mergeAccelUidCapability(AccelUidCapability r8) {
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r10 = this.accelUidCapabilityBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L11;
            AccelUidCapability r11 = this.accelUidCapability_;
            if (r11 == null) goto L11;
            if (r11 == AccelUidCapability.getDefaultInstance()) goto L11;
            getAccelUidCapabilityBuilder().mergeFrom(r8);
        L11:
            this.accelUidCapability_ = r8;
            goto L13
        }

        public Builder mergeAppSocketStats(AppSocketStats r8) {
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r10 = this.appSocketStatsBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            AppSocketStats r11 = this.appSocketStats_;
            if (r11 == null) goto L11;
            if (r11 == AppSocketStats.getDefaultInstance()) goto L11;
            getAppSocketStatsBuilder().mergeFrom(r8);
        L11:
            this.appSocketStats_ = r8;
            goto L13
        }

        public Builder mergeAutoDualWlanCapability(AutoDualWlanCapability r8) {
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r10 = this.autoDualWlanCapabilityBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 4) == 0) goto L11;
            AutoDualWlanCapability r11 = this.autoDualWlanCapability_;
            if (r11 == null) goto L11;
            if (r11 == AutoDualWlanCapability.getDefaultInstance()) goto L11;
            getAutoDualWlanCapabilityBuilder().mergeFrom(r8);
        L11:
            this.autoDualWlanCapability_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAccelCapability(AccelCapability.Builder r8) {
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r10 = this.accelCapabilityBuilder_;
            AccelCapability r11 = r8.build();
            if (r10 != null) goto L5;
            this.accelCapability_ = r11;
        L6:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setAccelUidCapability(AccelUidCapability.Builder r8) {
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r10 = this.accelUidCapabilityBuilder_;
            AccelUidCapability r11 = r8.build();
            if (r10 != null) goto L5;
            this.accelUidCapability_ = r11;
        L6:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setAppSocketStats(AppSocketStats.Builder r8) {
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r10 = this.appSocketStatsBuilder_;
            AppSocketStats r11 = r8.build();
            if (r10 != null) goto L5;
            this.appSocketStats_ = r11;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setAutoDualWlanCapability(AutoDualWlanCapability.Builder r8) {
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r10 = this.autoDualWlanCapabilityBuilder_;
            AutoDualWlanCapability r11 = r8.build();
            if (r10 != null) goto L5;
            this.autoDualWlanCapability_ = r11;
        L6:
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
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
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiNetAccelProtoData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAccelCapability(AccelCapability r8) {
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r10 = this.accelCapabilityBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.accelCapability_ = r8;
        L9:
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setAccelUidCapability(AccelUidCapability r8) {
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r10 = this.accelUidCapabilityBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.accelUidCapability_ = r8;
        L9:
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setAppSocketStats(AppSocketStats r8) {
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r10 = this.appSocketStatsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.appSocketStats_ = r8;
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

        public Builder setAutoDualWlanCapability(AutoDualWlanCapability r8) {
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r10 = this.autoDualWlanCapabilityBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.autoDualWlanCapability_ = r8;
        L9:
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
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
        public MultiNetAccelProtoData build() {
            MultiNetAccelProtoData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiNetAccelProtoData buildPartial() {
            MultiNetAccelProtoData r8 = new MultiNetAccelProtoData(this, null);
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
        public MultiNetAccelProtoData getDefaultInstanceForType() {
            return MultiNetAccelProtoData.getDefaultInstance();
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
            this.accelCapability_ = null;
            SingleFieldBuilderV3<AccelCapability, AccelCapability.Builder, AccelCapabilityOrBuilder> r8 = this.accelCapabilityBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.accelCapabilityBuilder_ = null;
        L5:
            this.accelUidCapability_ = null;
            SingleFieldBuilderV3<AccelUidCapability, AccelUidCapability.Builder, AccelUidCapabilityOrBuilder> r10 = this.accelUidCapabilityBuilder_;
            if (r10 == null) goto L8;
            r10.dispose();
            this.accelUidCapabilityBuilder_ = null;
        L8:
            this.autoDualWlanCapability_ = null;
            SingleFieldBuilderV3<AutoDualWlanCapability, AutoDualWlanCapability.Builder, AutoDualWlanCapabilityOrBuilder> r11 = this.autoDualWlanCapabilityBuilder_;
            if (r11 == null) goto L11;
            r11.dispose();
            this.autoDualWlanCapabilityBuilder_ = null;
        L11:
            this.appSocketStats_ = null;
            SingleFieldBuilderV3<AppSocketStats, AppSocketStats.Builder, AppSocketStatsOrBuilder> r12 = this.appSocketStatsBuilder_;
            if (r12 == null) goto L14;
            r12.dispose();
            this.appSocketStatsBuilder_ = null;
        L14:
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L34;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L31;
            int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r12 == 0) goto L23;
            if (r12 != 10) goto L10;
            r8.readMessage(getAccelCapabilityFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            if (r12 != 18) goto L12;
            r8.readMessage(getAccelUidCapabilityFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (r12 != 26) goto L14;
            r8.readMessage(getAutoDualWlanCapabilityFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L14:
            if (r12 != 34) goto L16;
            r8.readMessage(getAppSocketStatsFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L16:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L23:
            r11 = true;
            goto L4
        L26:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            onChanged();
            throw th;
        L31:
            onChanged();
            return this;
        L34:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof MultiNetAccelProtoData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((MultiNetAccelProtoData) r8);
        }

        public Builder mergeFrom(MultiNetAccelProtoData r8) {
            if (r8 != MultiNetAccelProtoData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasAccelCapability() == false) goto L9;
            mergeAccelCapability(r8.getAccelCapability());
        L9:
            if (r8.hasAccelUidCapability() == false) goto L12;
            mergeAccelUidCapability(r8.getAccelUidCapability());
        L12:
            if (r8.hasAutoDualWlanCapability() == false) goto L15;
            mergeAutoDualWlanCapability(r8.getAutoDualWlanCapability());
        L15:
            if (r8.hasAppSocketStats() == false) goto L17;
            mergeAppSocketStats(r8.getAppSocketStats());
        L17:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new MultiNetAccelProtoData();
        PARSER = new AnonymousClass1();
    }

    private MultiNetAccelProtoData() {
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ AccelCapability access$402(MultiNetAccelProtoData r8, AccelCapability r10) {
        r8.accelCapability_ = r10;
        return r10;
    }

    public static /* synthetic */ AccelUidCapability access$502(MultiNetAccelProtoData r8, AccelUidCapability r10) {
        r8.accelUidCapability_ = r10;
        return r10;
    }

    public static /* synthetic */ AutoDualWlanCapability access$602(MultiNetAccelProtoData r8, AutoDualWlanCapability r10) {
        r8.autoDualWlanCapability_ = r10;
        return r10;
    }

    public static /* synthetic */ AppSocketStats access$702(MultiNetAccelProtoData r8, AppSocketStats r10) {
        r8.appSocketStats_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$876(MultiNetAccelProtoData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static MultiNetAccelProtoData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static MultiNetAccelProtoData parseDelimitedFrom(InputStream r8) {
        return (MultiNetAccelProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static MultiNetAccelProtoData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<MultiNetAccelProtoData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof MultiNetAccelProtoData) == false) goto L8;
        MultiNetAccelProtoData r10 = (MultiNetAccelProtoData) r8;
        if (hasAccelCapability() == r10.hasAccelCapability()) goto L13;
        return false;
    L13:
        if (hasAccelCapability() == false) goto L18;
        if (getAccelCapability().equals(r10.getAccelCapability()) == true) goto L18;
        return false;
    L18:
        if (hasAccelUidCapability() == r10.hasAccelUidCapability()) goto L21;
        return false;
    L21:
        if (hasAccelUidCapability() == false) goto L26;
        if (getAccelUidCapability().equals(r10.getAccelUidCapability()) == true) goto L26;
        return false;
    L26:
        if (hasAutoDualWlanCapability() == r10.hasAutoDualWlanCapability()) goto L29;
        return false;
    L29:
        if (hasAutoDualWlanCapability() == false) goto L34;
        if (getAutoDualWlanCapability().equals(r10.getAutoDualWlanCapability()) == true) goto L34;
        return false;
    L34:
        if (hasAppSocketStats() == r10.hasAppSocketStats()) goto L37;
        return false;
    L37:
        if (hasAppSocketStats() == false) goto L42;
        if (getAppSocketStats().equals(r10.getAppSocketStats()) == true) goto L42;
        return false;
    L42:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L44;
        return false;
    L44:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AccelCapability getAccelCapability() {
        AccelCapability r8 = this.accelCapability_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AccelCapability.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AccelCapabilityOrBuilder getAccelCapabilityOrBuilder() {
        AccelCapability r8 = this.accelCapability_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AccelCapability.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AccelUidCapability getAccelUidCapability() {
        AccelUidCapability r8 = this.accelUidCapability_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AccelUidCapability.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AccelUidCapabilityOrBuilder getAccelUidCapabilityOrBuilder() {
        AccelUidCapability r8 = this.accelUidCapability_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AccelUidCapability.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AppSocketStats getAppSocketStats() {
        AppSocketStats r8 = this.appSocketStats_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AppSocketStats.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AppSocketStatsOrBuilder getAppSocketStatsOrBuilder() {
        AppSocketStats r8 = this.appSocketStats_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AppSocketStats.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AutoDualWlanCapability getAutoDualWlanCapability() {
        AutoDualWlanCapability r8 = this.autoDualWlanCapability_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AutoDualWlanCapability.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public AutoDualWlanCapabilityOrBuilder getAutoDualWlanCapabilityOrBuilder() {
        AutoDualWlanCapability r8 = this.autoDualWlanCapability_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AutoDualWlanCapability.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MultiNetAccelProtoData> getParserForType() {
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
        r10 = 0 + CodedOutputStream.computeMessageSize(1, getAccelCapability());
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeMessageSize(2, getAccelUidCapability());
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeMessageSize(3, getAutoDualWlanCapability());
    L15:
        if ((this.bitField0_ & 8) == 0) goto L17;
        r10 = r10 + CodedOutputStream.computeMessageSize(4, getAppSocketStats());
    L17:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public boolean hasAccelCapability() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public boolean hasAccelUidCapability() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public boolean hasAppSocketStats() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.MultiNetAccelProtoDataOrBuilder
    public boolean hasAutoDualWlanCapability() {
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
        if (hasAccelCapability() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getAccelCapability().hashCode();
    L9:
        if (hasAccelUidCapability() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getAccelUidCapability().hashCode();
    L12:
        if (hasAutoDualWlanCapability() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getAutoDualWlanCapability().hashCode();
    L15:
        if (hasAppSocketStats() == false) goto L17;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getAppSocketStats().hashCode();
    L17:
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
        return new MultiNetAccelProtoData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeMessage(1, getAccelCapability());
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeMessage(2, getAccelUidCapability());
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeMessage(3, getAutoDualWlanCapability());
    L12:
        if ((this.bitField0_ & 8) == 0) goto L14;
        r8.writeMessage(4, getAppSocketStats());
    L14:
        getUnknownFields().writeTo(r8);
    }

    private MultiNetAccelProtoData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(MultiNetAccelProtoData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static MultiNetAccelProtoData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (MultiNetAccelProtoData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static MultiNetAccelProtoData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_MultiNetAccelProtoData_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiNetAccelProtoData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ MultiNetAccelProtoData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static MultiNetAccelProtoData parseFrom(CodedInputStream r8) {
        return (MultiNetAccelProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public MultiNetAccelProtoData getDefaultInstanceForType() {
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

    public static MultiNetAccelProtoData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (MultiNetAccelProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static MultiNetAccelProtoData parseFrom(InputStream r8) {
        return (MultiNetAccelProtoData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static MultiNetAccelProtoData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (MultiNetAccelProtoData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static MultiNetAccelProtoData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static MultiNetAccelProtoData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static MultiNetAccelProtoData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static MultiNetAccelProtoData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
