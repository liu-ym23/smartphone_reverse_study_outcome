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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchTakeTime extends GeneratedMessageV3 implements SwitchTakeTimeOrBuilder {
    public static final int CELL_OK_TIME_FIELD_NUMBER = 5;
    private static final SwitchTakeTime DEFAULT_INSTANCE = null;
    public static final int OTHER_TIME_FIELD_NUMBER = 6;

    @Deprecated
    public static final Parser<SwitchTakeTime> PARSER = null;
    public static final int PROBE_TIME_FIELD_NUMBER = 3;
    public static final int QOE_BAD_TIME_FIELD_NUMBER = 2;
    public static final int SWITCH_TIME_FIELD_NUMBER = 4;
    public static final int TOTAL_TIME_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int cellOkTime_;
    private byte memoizedIsInitialized;
    private int otherTime_;
    private int probeTime_;
    private int qoeBadTime_;
    private int switchTime_;
    private int totalTime_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SwitchTakeTimeOrBuilder {
        private int bitField0_;
        private int cellOkTime_;
        private int otherTime_;
        private int probeTime_;
        private int qoeBadTime_;
        private int switchTime_;
        private int totalTime_;

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
        }

        private void buildPartial0(SwitchTakeTime r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            SwitchTakeTime.access$302(r8, this.totalTime_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            SwitchTakeTime.access$402(r8, this.qoeBadTime_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            SwitchTakeTime.access$502(r8, this.probeTime_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            SwitchTakeTime.access$602(r8, this.switchTime_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            SwitchTakeTime.access$702(r8, this.cellOkTime_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L21;
            SwitchTakeTime.access$802(r8, this.otherTime_);
            r11 = r11 | 32;
        L21:
            SwitchTakeTime.access$976(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTakeTime_descriptor;
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

        public Builder clearCellOkTime() {
            this.bitField0_ &= -17;
            this.cellOkTime_ = 0;
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

        public Builder clearOtherTime() {
            this.bitField0_ &= -33;
            this.otherTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearProbeTime() {
            this.bitField0_ &= -5;
            this.probeTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearQoeBadTime() {
            this.bitField0_ &= -3;
            this.qoeBadTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchTime() {
            this.bitField0_ &= -9;
            this.switchTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTotalTime() {
            this.bitField0_ &= -2;
            this.totalTime_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public int getCellOkTime() {
            return this.cellOkTime_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTakeTime_descriptor;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public int getOtherTime() {
            return this.otherTime_;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public int getProbeTime() {
            return this.probeTime_;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public int getQoeBadTime() {
            return this.qoeBadTime_;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public int getSwitchTime() {
            return this.switchTime_;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public int getTotalTime() {
            return this.totalTime_;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public boolean hasCellOkTime() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public boolean hasOtherTime() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public boolean hasProbeTime() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public boolean hasQoeBadTime() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public boolean hasSwitchTime() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
        public boolean hasTotalTime() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
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

        public Builder setCellOkTime(int r8) {
            this.cellOkTime_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setOtherTime(int r8) {
            this.otherTime_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setProbeTime(int r8) {
            this.probeTime_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setQoeBadTime(int r8) {
            this.qoeBadTime_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSwitchTime(int r8) {
            this.switchTime_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setTotalTime(int r8) {
            this.totalTime_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTakeTime_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchTakeTime.class, Builder.class);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchTakeTime build() {
            SwitchTakeTime r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchTakeTime buildPartial() {
            SwitchTakeTime r8 = new SwitchTakeTime(this, null);
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
        public SwitchTakeTime getDefaultInstanceForType() {
            return SwitchTakeTime.getDefaultInstance();
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
            this.totalTime_ = 0;
            this.qoeBadTime_ = 0;
            this.probeTime_ = 0;
            this.switchTime_ = 0;
            this.cellOkTime_ = 0;
            this.otherTime_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L40;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L37;
            int r12 = r8.readTag();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            if (r12 == 0) goto L29;
            if (r12 != 8) goto L10;
            this.totalTime_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 1;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.qoeBadTime_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.probeTime_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 4;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.switchTime_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 8;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.cellOkTime_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 16;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L18:
            if (r12 != 48) goto L20;
            this.otherTime_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 32;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L20:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L29:
            r11 = true;
            goto L4
        L30:
            th = move-exception;
            onChanged();
            throw th;
        L32:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L30
        L37:
            onChanged();
            return this;
        L40:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof SwitchTakeTime) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((SwitchTakeTime) r8);
        }

        public Builder mergeFrom(SwitchTakeTime r8) {
            if (r8 != SwitchTakeTime.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasTotalTime() == false) goto L9;
            setTotalTime(r8.getTotalTime());
        L9:
            if (r8.hasQoeBadTime() == false) goto L12;
            setQoeBadTime(r8.getQoeBadTime());
        L12:
            if (r8.hasProbeTime() == false) goto L15;
            setProbeTime(r8.getProbeTime());
        L15:
            if (r8.hasSwitchTime() == false) goto L18;
            setSwitchTime(r8.getSwitchTime());
        L18:
            if (r8.hasCellOkTime() == false) goto L21;
            setCellOkTime(r8.getCellOkTime());
        L21:
            if (r8.hasOtherTime() == false) goto L23;
            setOtherTime(r8.getOtherTime());
        L23:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new SwitchTakeTime();
        PARSER = new AnonymousClass1();
    }

    private SwitchTakeTime() {
        this.totalTime_ = 0;
        this.qoeBadTime_ = 0;
        this.probeTime_ = 0;
        this.switchTime_ = 0;
        this.cellOkTime_ = 0;
        this.otherTime_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static /* synthetic */ int access$302(SwitchTakeTime r8, int r10) {
        r8.totalTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(SwitchTakeTime r8, int r10) {
        r8.qoeBadTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(SwitchTakeTime r8, int r10) {
        r8.probeTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(SwitchTakeTime r8, int r10) {
        r8.switchTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(SwitchTakeTime r8, int r10) {
        r8.cellOkTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(SwitchTakeTime r8, int r10) {
        r8.otherTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$976(SwitchTakeTime r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static SwitchTakeTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTakeTime_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SwitchTakeTime parseDelimitedFrom(InputStream r8) {
        return (SwitchTakeTime) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static SwitchTakeTime parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<SwitchTakeTime> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof SwitchTakeTime) == false) goto L8;
        SwitchTakeTime r10 = (SwitchTakeTime) r8;
        if (hasTotalTime() == r10.hasTotalTime()) goto L13;
        return false;
    L13:
        if (hasTotalTime() == false) goto L18;
        if (getTotalTime() == r10.getTotalTime()) goto L18;
        return false;
    L18:
        if (hasQoeBadTime() == r10.hasQoeBadTime()) goto L21;
        return false;
    L21:
        if (hasQoeBadTime() == false) goto L26;
        if (getQoeBadTime() == r10.getQoeBadTime()) goto L26;
        return false;
    L26:
        if (hasProbeTime() == r10.hasProbeTime()) goto L29;
        return false;
    L29:
        if (hasProbeTime() == false) goto L34;
        if (getProbeTime() == r10.getProbeTime()) goto L34;
        return false;
    L34:
        if (hasSwitchTime() == r10.hasSwitchTime()) goto L37;
        return false;
    L37:
        if (hasSwitchTime() == false) goto L42;
        if (getSwitchTime() == r10.getSwitchTime()) goto L42;
        return false;
    L42:
        if (hasCellOkTime() == r10.hasCellOkTime()) goto L45;
        return false;
    L45:
        if (hasCellOkTime() == false) goto L50;
        if (getCellOkTime() == r10.getCellOkTime()) goto L50;
        return false;
    L50:
        if (hasOtherTime() == r10.hasOtherTime()) goto L53;
        return false;
    L53:
        if (hasOtherTime() == false) goto L58;
        if (getOtherTime() == r10.getOtherTime()) goto L58;
        return false;
    L58:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L60;
        return false;
    L60:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public int getCellOkTime() {
        return this.cellOkTime_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public int getOtherTime() {
        return this.otherTime_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SwitchTakeTime> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public int getProbeTime() {
        return this.probeTime_;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public int getQoeBadTime() {
        return this.qoeBadTime_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt32Size(1, this.totalTime_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.qoeBadTime_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeInt32Size(3, this.probeTime_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.switchTime_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.cellOkTime_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L23;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.otherTime_);
    L23:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public int getSwitchTime() {
        return this.switchTime_;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public int getTotalTime() {
        return this.totalTime_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public boolean hasCellOkTime() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public boolean hasOtherTime() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public boolean hasProbeTime() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public boolean hasQoeBadTime() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public boolean hasSwitchTime() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchTakeTimeOrBuilder
    public boolean hasTotalTime() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (hasTotalTime() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getTotalTime();
    L9:
        if (hasQoeBadTime() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getQoeBadTime();
    L12:
        if (hasProbeTime() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getProbeTime();
    L15:
        if (hasSwitchTime() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getSwitchTime();
    L18:
        if (hasCellOkTime() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getCellOkTime();
    L21:
        if (hasOtherTime() == false) goto L23;
        r10 = b.a(r10, 37, 6, 53) + getOtherTime();
    L23:
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
        return new SwitchTakeTime();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt32(1, this.totalTime_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.qoeBadTime_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt32(3, this.probeTime_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.switchTime_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.cellOkTime_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L20;
        r8.writeInt32(6, this.otherTime_);
    L20:
        getUnknownFields().writeTo(r8);
    }

    private SwitchTakeTime(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.totalTime_ = 0;
        this.qoeBadTime_ = 0;
        this.probeTime_ = 0;
        this.switchTime_ = 0;
        this.cellOkTime_ = 0;
        this.otherTime_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(SwitchTakeTime r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static SwitchTakeTime parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchTakeTime) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static SwitchTakeTime parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTakeTime_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchTakeTime.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ SwitchTakeTime(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static SwitchTakeTime parseFrom(CodedInputStream r8) {
        return (SwitchTakeTime) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public SwitchTakeTime getDefaultInstanceForType() {
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

    public static SwitchTakeTime parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (SwitchTakeTime) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static SwitchTakeTime parseFrom(InputStream r8) {
        return (SwitchTakeTime) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static SwitchTakeTime parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchTakeTime) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static SwitchTakeTime parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchTakeTime parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static SwitchTakeTime parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchTakeTime parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
