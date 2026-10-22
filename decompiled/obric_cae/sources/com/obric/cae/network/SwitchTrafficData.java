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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchTrafficData extends GeneratedMessageV3 implements SwitchTrafficDataOrBuilder {
    public static final int APP_DATA_USAGE_FIELD_NUMBER = 3;
    public static final int DATA_USAGE_FIELD_NUMBER = 2;
    private static final SwitchTrafficData DEFAULT_INSTANCE = null;
    public static final int DWELL_TIME_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<SwitchTrafficData> PARSER = null;
    public static final int SOLUTION_TYPE_FIELD_NUMBER = 5;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private List<AppDataUsageData> appDataUsage_;
    private int bitField0_;
    private long dataUsage_;
    private long dwellTime_;
    private byte memoizedIsInitialized;
    private int solutionType_;
    private long timestamp_;

    public static final class AppDataUsageData extends GeneratedMessageV3 implements AppDataUsageDataOrBuilder {
        public static final int DATA_USAGE_FIELD_NUMBER = 2;
        private static final AppDataUsageData DEFAULT_INSTANCE = null;
        public static final int PACKAGE_NAME_FIELD_NUMBER = 1;

        @Deprecated
        public static final Parser<AppDataUsageData> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long dataUsage_;
        private byte memoizedIsInitialized;
        private volatile Object packageName_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AppDataUsageDataOrBuilder {
            private int bitField0_;
            private long dataUsage_;
            private Object packageName_;

            private Builder() {
                this.packageName_ = "";
            }

            private void buildPartial0(AppDataUsageData r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                AppDataUsageData.access$302(r8, this.packageName_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L9;
                AppDataUsageData.access$402(r8, this.dataUsage_);
                r11 = r11 | 2;
            L9:
                AppDataUsageData.access$576(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_AppDataUsageData_descriptor;
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

            public Builder clearDataUsage() {
                this.bitField0_ &= -3;
                this.dataUsage_ = 0;
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

            public Builder clearPackageName() {
                this.packageName_ = AppDataUsageData.getDefaultInstance().getPackageName();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
            public long getDataUsage() {
                return this.dataUsage_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_AppDataUsageData_descriptor;
            }

            @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
            public String getPackageName() {
                Object r8 = this.packageName_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.packageName_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
            public ByteString getPackageNameBytes() {
                Object r8 = this.packageName_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.packageName_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
            public boolean hasDataUsage() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
            public boolean hasPackageName() {
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

            public Builder setDataUsage(long r8) {
                this.dataUsage_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
                return setField(r8, r10);
            }

            public Builder setPackageName(String r8) {
                if (r8 == null) goto L6;
                this.packageName_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setPackageNameBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.packageName_ = r8;
                this.bitField0_ |= 1;
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

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
                this.packageName_ = "";
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
                return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_AppDataUsageData_fieldAccessorTable.ensureFieldAccessorsInitialized(AppDataUsageData.class, Builder.class);
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

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
                this(r8);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
                return addRepeatedField(r8, r10);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AppDataUsageData build() {
                AppDataUsageData r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AppDataUsageData buildPartial() {
                AppDataUsageData r8 = new AppDataUsageData(this, null);
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
            public AppDataUsageData getDefaultInstanceForType() {
                return AppDataUsageData.getDefaultInstance();
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
                this.packageName_ = "";
                this.dataUsage_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L28;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L25;
                int r12 = r8.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                if (r12 == 0) goto L17;
                if (r12 != 10) goto L10;
                this.packageName_ = r8.readBytes();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                this.bitField0_ |= 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                goto L4
            L10:
                if (r12 != 16) goto L12;
                this.dataUsage_ = r8.readUInt64();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                this.bitField0_ |= 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                goto L4
            L12:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L17:
                r11 = true;
                goto L4
            L20:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L18
            L18:
                th = move-exception;
                onChanged();
                throw th;
            L25:
                onChanged();
                return this;
            L28:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof AppDataUsageData) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((AppDataUsageData) r8);
            }

            public Builder mergeFrom(AppDataUsageData r8) {
                if (r8 != AppDataUsageData.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasPackageName() == false) goto L9;
                this.packageName_ = AppDataUsageData.access$300(r8);
                this.bitField0_ |= 1;
                onChanged();
            L9:
                if (r8.hasDataUsage() == false) goto L11;
                setDataUsage(r8.getDataUsage());
            L11:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new AppDataUsageData();
            PARSER = new AnonymousClass1();
        }

        private AppDataUsageData() {
            this.packageName_ = "";
            this.dataUsage_ = 0;
            this.memoizedIsInitialized = -1;
            this.packageName_ = "";
        }

        public static /* synthetic */ Object access$300(AppDataUsageData r8) {
            return r8.packageName_;
        }

        public static /* synthetic */ Object access$302(AppDataUsageData r8, Object r10) {
            r8.packageName_ = r10;
            return r10;
        }

        public static /* synthetic */ long access$402(AppDataUsageData r8, long r10) {
            r8.dataUsage_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$576(AppDataUsageData r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static AppDataUsageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_AppDataUsageData_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AppDataUsageData parseDelimitedFrom(InputStream r8) {
            return (AppDataUsageData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static AppDataUsageData parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<AppDataUsageData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof AppDataUsageData) == false) goto L8;
            AppDataUsageData r10 = (AppDataUsageData) r8;
            if (hasPackageName() == r10.hasPackageName()) goto L13;
            return false;
        L13:
            if (hasPackageName() == false) goto L18;
            if (getPackageName().equals(r10.getPackageName()) == true) goto L18;
            return false;
        L18:
            if (hasDataUsage() == r10.hasDataUsage()) goto L21;
            return false;
        L21:
            if (hasDataUsage() == false) goto L26;
            if (getDataUsage() == r10.getDataUsage()) goto L26;
            return false;
        L26:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L28;
            return false;
        L28:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
        public long getDataUsage() {
            return this.dataUsage_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
        public String getPackageName() {
            Object r8 = this.packageName_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.packageName_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
        public ByteString getPackageNameBytes() {
            Object r8 = this.packageName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.packageName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AppDataUsageData> getParserForType() {
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
            r10 = 0 + GeneratedMessage.computeStringSize(1, this.packageName_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L11;
            r10 = r10 + CodedOutputStream.computeUInt64Size(2, this.dataUsage_);
        L11:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
        public boolean hasDataUsage() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTrafficData.AppDataUsageDataOrBuilder
        public boolean hasPackageName() {
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
            if (hasPackageName() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getPackageName().hashCode();
        L9:
            if (hasDataUsage() == false) goto L11;
            r10 = b.a(r10, 37, 2, 53) + Internal.hashLong(getDataUsage());
        L11:
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
            return new AppDataUsageData();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            GeneratedMessage.writeString(r8, 1, this.packageName_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L8;
            r8.writeUInt64(2, this.dataUsage_);
        L8:
            getUnknownFields().writeTo(r8);
        }

        private AppDataUsageData(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.packageName_ = "";
            this.dataUsage_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(AppDataUsageData r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static AppDataUsageData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (AppDataUsageData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static AppDataUsageData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_AppDataUsageData_fieldAccessorTable.ensureFieldAccessorsInitialized(AppDataUsageData.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ AppDataUsageData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static AppDataUsageData parseFrom(CodedInputStream r8) {
            return (AppDataUsageData) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public AppDataUsageData getDefaultInstanceForType() {
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

        public static AppDataUsageData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (AppDataUsageData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static AppDataUsageData parseFrom(InputStream r8) {
            return (AppDataUsageData) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static AppDataUsageData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (AppDataUsageData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static AppDataUsageData parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static AppDataUsageData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static AppDataUsageData parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static AppDataUsageData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface AppDataUsageDataOrBuilder extends MessageOrBuilder {
        long getDataUsage();

        String getPackageName();

        ByteString getPackageNameBytes();

        boolean hasDataUsage();

        boolean hasPackageName();
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SwitchTrafficDataOrBuilder {
        private RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> appDataUsageBuilder_;
        private List<AppDataUsageData> appDataUsage_;
        private int bitField0_;
        private long dataUsage_;
        private long dwellTime_;
        private int solutionType_;
        private long timestamp_;

        private Builder() {
            this.appDataUsage_ = Collections.emptyList();
        }

        private void buildPartial0(SwitchTrafficData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            SwitchTrafficData.access$1002(r8, this.dwellTime_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            SwitchTrafficData.access$1102(r8, this.dataUsage_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 8) == 0) goto L13;
            SwitchTrafficData.access$1202(r8, this.timestamp_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 16) == 0) goto L15;
            SwitchTrafficData.access$1302(r8, this.solutionType_);
            r11 = r11 | 8;
        L15:
            SwitchTrafficData.access$1476(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(SwitchTrafficData r8) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = this.appDataUsageBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            SwitchTrafficData.access$902(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 4) == 0) goto L7;
            this.appDataUsage_ = Collections.unmodifiableList(this.appDataUsage_);
            this.bitField0_ &= -5;
        L7:
            r11 = this.appDataUsage_;
            goto L9
        }

        private void ensureAppDataUsageIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.appDataUsage_ = new ArrayList(this.appDataUsage_);
            this.bitField0_ |= 4;
            return;
        }

        private RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> getAppDataUsageFieldBuilder() {
            if (this.appDataUsageBuilder_ != null) goto L10;
            List<AppDataUsageData> r8 = this.appDataUsage_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.appDataUsageBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.appDataUsage_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.appDataUsageBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_descriptor;
        }

        public Builder addAllAppDataUsage(Iterable<? extends AppDataUsageData> r8) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = this.appDataUsageBuilder_;
            if (r10 != null) goto L5;
            ensureAppDataUsageIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.appDataUsage_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAppDataUsage(int r8, AppDataUsageData.Builder r10) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r11 = this.appDataUsageBuilder_;
            if (r11 != null) goto L5;
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public AppDataUsageData.Builder addAppDataUsageBuilder() {
            return (AppDataUsageData.Builder) getAppDataUsageFieldBuilder().addBuilder(AppDataUsageData.getDefaultInstance());
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

        public Builder clearAppDataUsage() {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r8 = this.appDataUsageBuilder_;
            if (r8 != null) goto L5;
            this.appDataUsage_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearDataUsage() {
            this.bitField0_ &= -3;
            this.dataUsage_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDwellTime() {
            this.bitField0_ &= -2;
            this.dwellTime_ = 0;
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

        public Builder clearSolutionType() {
            this.bitField0_ &= -17;
            this.solutionType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -9;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public AppDataUsageData getAppDataUsage(int r8) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = this.appDataUsageBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.appDataUsage_.get(r8);
        L6:
            return (AppDataUsageData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public AppDataUsageData.Builder getAppDataUsageBuilder(int r8) {
            return (AppDataUsageData.Builder) getAppDataUsageFieldBuilder().getBuilder(r8);
        }

        public List<AppDataUsageData.Builder> getAppDataUsageBuilderList() {
            return getAppDataUsageFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public int getAppDataUsageCount() {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r8 = this.appDataUsageBuilder_;
            if (r8 != null) goto L7;
            return this.appDataUsage_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public List<AppDataUsageData> getAppDataUsageList() {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r8 = this.appDataUsageBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.appDataUsage_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public AppDataUsageDataOrBuilder getAppDataUsageOrBuilder(int r8) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = this.appDataUsageBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.appDataUsage_.get(r8);
        L6:
            return (AppDataUsageDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public List<? extends AppDataUsageDataOrBuilder> getAppDataUsageOrBuilderList() {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r8 = this.appDataUsageBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.appDataUsage_);
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public long getDataUsage() {
            return this.dataUsage_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_descriptor;
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public long getDwellTime() {
            return this.dwellTime_;
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public int getSolutionType() {
            return this.solutionType_;
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public boolean hasDataUsage() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public boolean hasDwellTime() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public boolean hasSolutionType() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 8) == 0) goto L5;
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

        public Builder removeAppDataUsage(int r8) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = this.appDataUsageBuilder_;
            if (r10 != null) goto L5;
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setAppDataUsage(int r8, AppDataUsageData.Builder r10) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r11 = this.appDataUsageBuilder_;
            if (r11 != null) goto L5;
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setDataUsage(long r8) {
            this.dataUsage_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setDwellTime(long r8) {
            this.dwellTime_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSolutionType(int r8) {
            this.solutionType_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.appDataUsage_ = Collections.emptyList();
        }

        public Builder addAppDataUsage(int r8, AppDataUsageData r10) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r11 = this.appDataUsageBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public AppDataUsageData.Builder addAppDataUsageBuilder(int r8) {
            return (AppDataUsageData.Builder) getAppDataUsageFieldBuilder().addBuilder(r8, AppDataUsageData.getDefaultInstance());
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
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchTrafficData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAppDataUsage(int r8, AppDataUsageData r10) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r11 = this.appDataUsageBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.set(r8, r10);
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

        public Builder addAppDataUsage(AppDataUsageData.Builder r8) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = this.appDataUsageBuilder_;
            if (r10 != null) goto L5;
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.add(r8.build());
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

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchTrafficData build() {
            SwitchTrafficData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchTrafficData buildPartial() {
            SwitchTrafficData r8 = new SwitchTrafficData(this, null);
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
        public SwitchTrafficData getDefaultInstanceForType() {
            return SwitchTrafficData.getDefaultInstance();
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

        public Builder addAppDataUsage(AppDataUsageData r8) {
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = this.appDataUsageBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.add(r8);
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
            this.dwellTime_ = 0;
            this.dataUsage_ = 0;
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r8 = this.appDataUsageBuilder_;
            if (r8 != null) goto L5;
            this.appDataUsage_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -5;
            this.timestamp_ = 0;
            this.solutionType_ = 0;
            return this;
        L5:
            this.appDataUsage_ = null;
            r8.clear();
            goto L6
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
            this.dwellTime_ = r8.readInt64();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 1;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.dataUsage_ = r8.readInt64();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L12:
            if (r12 != 26) goto L14;
            AppDataUsageData r13 = (AppDataUsageData) r8.readMessage(AppDataUsageData.PARSER, r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r14 = this.appDataUsageBuilder_;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            if (r14 == null) goto L24;
            r14.addMessage(r13);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L24:
            ensureAppDataUsageIsMutable();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.appDataUsage_.add(r13);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 8;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.solutionType_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            this.bitField0_ |= 16;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
            goto L4
        L18:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L29:
            r11 = true;
            goto L4
        L32:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            onChanged();
            throw th;
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
            if ((r8 instanceof SwitchTrafficData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((SwitchTrafficData) r8);
        }

        public Builder mergeFrom(SwitchTrafficData r8) {
            if (r8 != SwitchTrafficData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasDwellTime() == false) goto L9;
            setDwellTime(r8.getDwellTime());
        L9:
            if (r8.hasDataUsage() == false) goto L12;
            setDataUsage(r8.getDataUsage());
        L12:
            if (this.appDataUsageBuilder_ != null) goto L21;
            if (SwitchTrafficData.access$900(r8).isEmpty() == true) goto L30;
            if (this.appDataUsage_.isEmpty() == false) goto L18;
            this.appDataUsage_ = SwitchTrafficData.access$900(r8);
            this.bitField0_ &= -5;
        L19:
            onChanged();
            goto L30
        L18:
            ensureAppDataUsageIsMutable();
            this.appDataUsage_.addAll(SwitchTrafficData.access$900(r8));
        L30:
            if (r8.hasTimestamp() == false) goto L33;
            setTimestamp(r8.getTimestamp());
        L33:
            if (r8.hasSolutionType() == false) goto L35;
            setSolutionType(r8.getSolutionType());
        L35:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L21:
            if (SwitchTrafficData.access$900(r8).isEmpty() == true) goto L30;
            if (this.appDataUsageBuilder_.isEmpty() == false) goto L28;
            this.appDataUsageBuilder_.dispose();
            RepeatedFieldBuilderV3<AppDataUsageData, AppDataUsageData.Builder, AppDataUsageDataOrBuilder> r10 = null;
            this.appDataUsageBuilder_ = null;
            this.appDataUsage_ = SwitchTrafficData.access$900(r8);
            this.bitField0_ &= -5;
            if (SwitchTrafficData.access$1500() == false) goto L27;
            r10 = getAppDataUsageFieldBuilder();
        L27:
            this.appDataUsageBuilder_ = r10;
            goto L30
        L28:
            this.appDataUsageBuilder_.addAllMessages(SwitchTrafficData.access$900(r8));
            goto L30
        }
    }

    static {
        DEFAULT_INSTANCE = new SwitchTrafficData();
        PARSER = new AnonymousClass1();
    }

    private SwitchTrafficData() {
        this.dwellTime_ = 0;
        this.dataUsage_ = 0;
        this.timestamp_ = 0;
        this.solutionType_ = 0;
        this.memoizedIsInitialized = -1;
        this.appDataUsage_ = Collections.emptyList();
    }

    public static /* synthetic */ long access$1002(SwitchTrafficData r8, long r10) {
        r8.dwellTime_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1102(SwitchTrafficData r8, long r10) {
        r8.dataUsage_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1202(SwitchTrafficData r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(SwitchTrafficData r8, int r10) {
        r8.solutionType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1476(SwitchTrafficData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1500() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$900(SwitchTrafficData r8) {
        return r8.appDataUsage_;
    }

    public static /* synthetic */ List access$902(SwitchTrafficData r8, List r10) {
        r8.appDataUsage_ = r10;
        return r10;
    }

    public static SwitchTrafficData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SwitchTrafficData parseDelimitedFrom(InputStream r8) {
        return (SwitchTrafficData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static SwitchTrafficData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<SwitchTrafficData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof SwitchTrafficData) == false) goto L8;
        SwitchTrafficData r10 = (SwitchTrafficData) r8;
        if (hasDwellTime() == r10.hasDwellTime()) goto L13;
        return false;
    L13:
        if (hasDwellTime() == false) goto L18;
        if (getDwellTime() == r10.getDwellTime()) goto L18;
        return false;
    L18:
        if (hasDataUsage() == r10.hasDataUsage()) goto L21;
        return false;
    L21:
        if (hasDataUsage() == false) goto L26;
        if (getDataUsage() == r10.getDataUsage()) goto L26;
        return false;
    L26:
        if (getAppDataUsageList().equals(r10.getAppDataUsageList()) == true) goto L29;
        return false;
    L29:
        if (hasTimestamp() == r10.hasTimestamp()) goto L32;
        return false;
    L32:
        if (hasTimestamp() == false) goto L37;
        if (getTimestamp() == r10.getTimestamp()) goto L37;
        return false;
    L37:
        if (hasSolutionType() == r10.hasSolutionType()) goto L40;
        return false;
    L40:
        if (hasSolutionType() == false) goto L45;
        if (getSolutionType() == r10.getSolutionType()) goto L45;
        return false;
    L45:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L47;
        return false;
    L47:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public AppDataUsageData getAppDataUsage(int r8) {
        return this.appDataUsage_.get(r8);
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public int getAppDataUsageCount() {
        return this.appDataUsage_.size();
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public List<AppDataUsageData> getAppDataUsageList() {
        return this.appDataUsage_;
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public AppDataUsageDataOrBuilder getAppDataUsageOrBuilder(int r8) {
        return this.appDataUsage_.get(r8);
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public List<? extends AppDataUsageDataOrBuilder> getAppDataUsageOrBuilderList() {
        return this.appDataUsage_;
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public long getDataUsage() {
        return this.dataUsage_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public long getDwellTime() {
        return this.dwellTime_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SwitchTrafficData> getParserForType() {
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
        int r11 = CodedOutputStream.computeInt64Size(1, this.dwellTime_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeInt64Size(2, this.dataUsage_);
    L13:
        if (r10 >= this.appDataUsage_.size()) goto L16;
        r11 = r11 + CodedOutputStream.computeMessageSize(3, this.appDataUsage_.get(r10));
        r10 = r10 + 1;
        goto L13
    L16:
        if ((this.bitField0_ & 4) == 0) goto L19;
        r11 = r11 + CodedOutputStream.computeInt64Size(4, this.timestamp_);
    L19:
        if ((this.bitField0_ & 8) == 0) goto L21;
        r11 = r11 + CodedOutputStream.computeInt32Size(5, this.solutionType_);
    L21:
        int r12 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public int getSolutionType() {
        return this.solutionType_;
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public boolean hasDataUsage() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public boolean hasDwellTime() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public boolean hasSolutionType() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchTrafficDataOrBuilder
    public boolean hasTimestamp() {
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
        if (hasDwellTime() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Internal.hashLong(getDwellTime());
    L9:
        if (hasDataUsage() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + Internal.hashLong(getDataUsage());
    L12:
        if (getAppDataUsageCount() <= 0) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getAppDataUsageList().hashCode();
    L15:
        if (hasTimestamp() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Internal.hashLong(getTimestamp());
    L18:
        if (hasSolutionType() == false) goto L20;
        r10 = b.a(r10, 37, 5, 53) + getSolutionType();
    L20:
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
        return new SwitchTrafficData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt64(1, this.dwellTime_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L8;
        r8.writeInt64(2, this.dataUsage_);
    L8:
        int r10 = 0;
    L10:
        if (r10 >= this.appDataUsage_.size()) goto L13;
        r8.writeMessage(3, this.appDataUsage_.get(r10));
        r10 = r10 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r8.writeInt64(4, this.timestamp_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r8.writeInt32(5, this.solutionType_);
    L18:
        getUnknownFields().writeTo(r8);
    }

    private SwitchTrafficData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.dwellTime_ = 0;
        this.dataUsage_ = 0;
        this.timestamp_ = 0;
        this.solutionType_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(SwitchTrafficData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static SwitchTrafficData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchTrafficData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static SwitchTrafficData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchTrafficData_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchTrafficData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ SwitchTrafficData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static SwitchTrafficData parseFrom(CodedInputStream r8) {
        return (SwitchTrafficData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public SwitchTrafficData getDefaultInstanceForType() {
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

    public static SwitchTrafficData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (SwitchTrafficData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static SwitchTrafficData parseFrom(InputStream r8) {
        return (SwitchTrafficData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static SwitchTrafficData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchTrafficData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static SwitchTrafficData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchTrafficData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static SwitchTrafficData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchTrafficData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
