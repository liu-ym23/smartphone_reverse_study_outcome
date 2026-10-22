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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AccelUidCapability extends GeneratedMessageV3 implements AccelUidCapabilityOrBuilder {
    public static final int APPINFO_FIELD_NUMBER = 3;
    private static final AccelUidCapability DEFAULT_INSTANCE = null;

    @Deprecated
    public static final Parser<AccelUidCapability> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private List<AppInfo> appInfo_;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private long timestamp_;

    public static final class AppInfo extends GeneratedMessageV3 implements AppInfoOrBuilder {
        private static final AppInfo DEFAULT_INSTANCE = null;
        public static final int PACKAGENAME_FIELD_NUMBER = 3;

        @Deprecated
        public static final Parser<AppInfo> PARSER = null;
        public static final int STATE_FIELD_NUMBER = 1;
        public static final int UID_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object packageName_;
        private int state_;
        private int uid_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AppInfoOrBuilder {
            private int bitField0_;
            private Object packageName_;
            private int state_;
            private int uid_;

            private Builder() {
                this.packageName_ = "";
            }

            private void buildPartial0(AppInfo r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                AppInfo.access$302(r8, this.state_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                AppInfo.access$402(r8, this.uid_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L12;
                AppInfo.access$502(r8, this.packageName_);
                r11 = r11 | 4;
            L12:
                AppInfo.access$676(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_descriptor;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
                return clearField(r8);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
            }

            public Builder clearPackageName() {
                this.packageName_ = AppInfo.getDefaultInstance().getPackageName();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            public Builder clearState() {
                this.bitField0_ &= -2;
                this.state_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.bitField0_ &= -3;
                this.uid_ = 0;
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_descriptor;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
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

            @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
            public ByteString getPackageNameBytes() {
                Object r8 = this.packageName_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.packageName_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
            public int getState() {
                return this.state_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
            public boolean hasPackageName() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
            public boolean hasState() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
            public boolean hasUid() {
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
                return mergeUnknownFields(r8);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
                return setField(r8, r10);
            }

            public Builder setPackageName(String r8) {
                if (r8 == null) goto L6;
                this.packageName_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setPackageNameBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.packageName_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            L6:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
            }

            public Builder setState(int r8) {
                this.state_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setUid(int r8) {
                this.uid_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AppInfo.class, Builder.class);
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
            public AppInfo build() {
                AppInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AppInfo buildPartial() {
                AppInfo r8 = new AppInfo(this, null);
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
            public AppInfo getDefaultInstanceForType() {
                return AppInfo.getDefaultInstance();
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
                this.state_ = 0;
                this.uid_ = 0;
                this.packageName_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L31;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L28;
                int r12 = r8.readTag();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                if (r12 == 0) goto L20;
                if (r12 != 8) goto L10;
                this.state_ = r8.readInt32();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                this.bitField0_ |= 1;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                goto L4
            L10:
                if (r12 != 16) goto L12;
                this.uid_ = r8.readInt32();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                this.bitField0_ |= 2;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                goto L4
            L12:
                if (r12 != 26) goto L14;
                this.packageName_ = r8.readBytes();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                this.bitField0_ |= 4;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                goto L4
            L14:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L20:
                r11 = true;
                goto L4
            L21:
                th = move-exception;
                onChanged();
                throw th;
            L23:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L21
            L28:
                onChanged();
                return this;
            L31:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof AppInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((AppInfo) r8);
            }

            public Builder mergeFrom(AppInfo r8) {
                if (r8 != AppInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasState() == false) goto L9;
                setState(r8.getState());
            L9:
                if (r8.hasUid() == false) goto L12;
                setUid(r8.getUid());
            L12:
                if (r8.hasPackageName() == false) goto L14;
                this.packageName_ = AppInfo.access$500(r8);
                this.bitField0_ |= 4;
                onChanged();
            L14:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new AppInfo();
            PARSER = new AnonymousClass1();
        }

        private AppInfo() {
            this.state_ = 0;
            this.uid_ = 0;
            this.packageName_ = "";
            this.memoizedIsInitialized = -1;
            this.packageName_ = "";
        }

        public static /* synthetic */ int access$302(AppInfo r8, int r10) {
            r8.state_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$402(AppInfo r8, int r10) {
            r8.uid_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$500(AppInfo r8) {
            return r8.packageName_;
        }

        public static /* synthetic */ Object access$502(AppInfo r8, Object r10) {
            r8.packageName_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$676(AppInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static AppInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static AppInfo parseDelimitedFrom(InputStream r8) {
            return (AppInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static AppInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<AppInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof AppInfo) == false) goto L8;
            AppInfo r10 = (AppInfo) r8;
            if (hasState() == r10.hasState()) goto L13;
            return false;
        L13:
            if (hasState() == false) goto L18;
            if (getState() == r10.getState()) goto L18;
            return false;
        L18:
            if (hasUid() == r10.hasUid()) goto L21;
            return false;
        L21:
            if (hasUid() == false) goto L26;
            if (getUid() == r10.getUid()) goto L26;
            return false;
        L26:
            if (hasPackageName() == r10.hasPackageName()) goto L29;
            return false;
        L29:
            if (hasPackageName() == false) goto L34;
            if (getPackageName().equals(r10.getPackageName()) == true) goto L34;
            return false;
        L34:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L36;
            return false;
        L36:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
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

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
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
        public Parser<AppInfo> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeInt32Size(1, this.state_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeInt32Size(2, this.uid_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            r10 = r10 + GeneratedMessage.computeStringSize(3, this.packageName_);
        L14:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
        public int getState() {
            return this.state_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
        public boolean hasState() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapability.AppInfoOrBuilder
        public boolean hasUid() {
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
            if (hasState() == false) goto L9;
            r10 = defpackage.b.a(r10, 37, 1, 53) + getState();
        L9:
            if (hasUid() == false) goto L12;
            r10 = defpackage.b.a(r10, 37, 2, 53) + getUid();
        L12:
            if (hasPackageName() == false) goto L14;
            r10 = defpackage.b.a(r10, 37, 3, 53) + getPackageName().hashCode();
        L14:
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
            return new AppInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeInt32(1, this.state_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeInt32(2, this.uid_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L11;
            GeneratedMessage.writeString(r8, 3, this.packageName_);
        L11:
            getUnknownFields().writeTo(r8);
        }

        private AppInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.state_ = 0;
            this.uid_ = 0;
            this.packageName_ = "";
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(AppInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static AppInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (AppInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static AppInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_AppInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AppInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ AppInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static AppInfo parseFrom(CodedInputStream r8) {
            return (AppInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public AppInfo getDefaultInstanceForType() {
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

        public static AppInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (AppInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static AppInfo parseFrom(InputStream r8) {
            return (AppInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static AppInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (AppInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static AppInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static AppInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static AppInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static AppInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface AppInfoOrBuilder extends MessageOrBuilder {
        String getPackageName();

        ByteString getPackageNameBytes();

        int getState();

        int getUid();

        boolean hasPackageName();

        boolean hasState();

        boolean hasUid();
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AccelUidCapabilityOrBuilder {
        private RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> appInfoBuilder_;
        private List<AppInfo> appInfo_;
        private int bitField0_;
        private long timestamp_;

        private Builder() {
            this.appInfo_ = Collections.emptyList();
        }

        private void buildPartial0(AccelUidCapability r8) {
            int r10 = 1;
            if ((this.bitField0_ & 1) == 0) goto L5;
            AccelUidCapability.access$1102(r8, this.timestamp_);
        L6:
            AccelUidCapability.access$1276(r8, r10);
            return;
        L5:
            r10 = 0;
            goto L6
        }

        private void buildPartialRepeatedFields(AccelUidCapability r8) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            AccelUidCapability.access$1002(r8, r11);
            return;
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.appInfo_ = Collections.unmodifiableList(this.appInfo_);
            this.bitField0_ &= -3;
        L7:
            r11 = this.appInfo_;
            goto L9
        }

        private void ensureAppInfoIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.appInfo_ = new ArrayList(this.appInfo_);
            this.bitField0_ |= 2;
            return;
        }

        private RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> getAppInfoFieldBuilder() {
            if (this.appInfoBuilder_ != null) goto L10;
            List<AppInfo> r8 = this.appInfo_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.appInfoBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.appInfo_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.appInfoBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_descriptor;
        }

        public Builder addAllAppInfo(Iterable<? extends AppInfo> r8) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 != null) goto L5;
            ensureAppInfoIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.appInfo_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAppInfo(int r8, AppInfo.Builder r10) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r11 = this.appInfoBuilder_;
            if (r11 != null) goto L5;
            ensureAppInfoIsMutable();
            this.appInfo_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public AppInfo.Builder addAppInfoBuilder() {
            return (AppInfo.Builder) getAppInfoFieldBuilder().addBuilder(AppInfo.getDefaultInstance());
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

        public Builder clearAppInfo() {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 != null) goto L5;
            this.appInfo_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -2;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
        public AppInfo getAppInfo(int r8) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.appInfo_.get(r8);
        L6:
            return (AppInfo) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public AppInfo.Builder getAppInfoBuilder(int r8) {
            return (AppInfo.Builder) getAppInfoFieldBuilder().getBuilder(r8);
        }

        public List<AppInfo.Builder> getAppInfoBuilderList() {
            return getAppInfoFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
        public int getAppInfoCount() {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 != null) goto L7;
            return this.appInfo_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
        public List<AppInfo> getAppInfoList() {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.appInfo_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
        public AppInfoOrBuilder getAppInfoOrBuilder(int r8) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.appInfo_.get(r8);
        L6:
            return (AppInfoOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
        public List<? extends AppInfoOrBuilder> getAppInfoOrBuilderList() {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.appInfo_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_descriptor;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
        public boolean hasTimestamp() {
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

        public Builder removeAppInfo(int r8) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 != null) goto L5;
            ensureAppInfoIsMutable();
            this.appInfo_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setAppInfo(int r8, AppInfo.Builder r10) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r11 = this.appInfoBuilder_;
            if (r11 != null) goto L5;
            ensureAppInfoIsMutable();
            this.appInfo_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
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

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.appInfo_ = Collections.emptyList();
        }

        public Builder addAppInfo(int r8, AppInfo r10) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r11 = this.appInfoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureAppInfoIsMutable();
            this.appInfo_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public AppInfo.Builder addAppInfoBuilder(int r8) {
            return (AppInfo.Builder) getAppInfoFieldBuilder().addBuilder(r8, AppInfo.getDefaultInstance());
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
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_fieldAccessorTable.ensureFieldAccessorsInitialized(AccelUidCapability.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAppInfo(int r8, AppInfo r10) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r11 = this.appInfoBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureAppInfoIsMutable();
            this.appInfo_.set(r8, r10);
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

        public Builder addAppInfo(AppInfo.Builder r8) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 != null) goto L5;
            ensureAppInfoIsMutable();
            this.appInfo_.add(r8.build());
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
        public AccelUidCapability build() {
            AccelUidCapability r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AccelUidCapability buildPartial() {
            AccelUidCapability r8 = new AccelUidCapability(this, null);
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
        public AccelUidCapability getDefaultInstanceForType() {
            return AccelUidCapability.getDefaultInstance();
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

        public Builder addAppInfo(AppInfo r8) {
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureAppInfoIsMutable();
            this.appInfo_.add(r8);
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
            this.timestamp_ = 0;
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 != null) goto L5;
            this.appInfo_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            return this;
        L5:
            this.appInfo_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L31;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L28;
            int r12 = r8.readTag();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            if (r12 == 0) goto L20;
            if (r12 != 16) goto L10;
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            this.bitField0_ |= 1;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            goto L4
        L10:
            if (r12 != 26) goto L12;
            AppInfo r13 = (AppInfo) r8.readMessage(AppInfo.PARSER, r10);     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r14 = this.appInfoBuilder_;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            if (r14 == null) goto L16;
            r14.addMessage(r13);     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            goto L4
        L16:
            ensureAppInfoIsMutable();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            this.appInfo_.add(r13);     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
            goto L4
        L12:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L20:
            r11 = true;
            goto L4
        L21:
            th = move-exception;
            onChanged();
            throw th;
        L23:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L21
        L28:
            onChanged();
            return this;
        L31:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof AccelUidCapability) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((AccelUidCapability) r8);
        }

        public Builder mergeFrom(AccelUidCapability r8) {
            if (r8 != AccelUidCapability.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasTimestamp() == false) goto L9;
            setTimestamp(r8.getTimestamp());
        L9:
            if (this.appInfoBuilder_ != null) goto L18;
            if (AccelUidCapability.access$1000(r8).isEmpty() == false) goto L13;
        L26:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L13:
            if (this.appInfo_.isEmpty() == false) goto L15;
            this.appInfo_ = AccelUidCapability.access$1000(r8);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L26
        L15:
            ensureAppInfoIsMutable();
            this.appInfo_.addAll(AccelUidCapability.access$1000(r8));
            goto L16
        L18:
            if (AccelUidCapability.access$1000(r8).isEmpty() == true) goto L26;
            if (this.appInfoBuilder_.isEmpty() == false) goto L25;
            this.appInfoBuilder_.dispose();
            RepeatedFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = null;
            this.appInfoBuilder_ = null;
            this.appInfo_ = AccelUidCapability.access$1000(r8);
            this.bitField0_ &= -3;
            if (AccelUidCapability.access$1300() == false) goto L24;
            r10 = getAppInfoFieldBuilder();
        L24:
            this.appInfoBuilder_ = r10;
            goto L26
        L25:
            this.appInfoBuilder_.addAllMessages(AccelUidCapability.access$1000(r8));
            goto L26
        }
    }

    static {
        DEFAULT_INSTANCE = new AccelUidCapability();
        PARSER = new AnonymousClass1();
    }

    private AccelUidCapability() {
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
        this.appInfo_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$1000(AccelUidCapability r8) {
        return r8.appInfo_;
    }

    public static /* synthetic */ List access$1002(AccelUidCapability r8, List r10) {
        r8.appInfo_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1102(AccelUidCapability r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1276(AccelUidCapability r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1300() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static AccelUidCapability getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AccelUidCapability parseDelimitedFrom(InputStream r8) {
        return (AccelUidCapability) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static AccelUidCapability parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<AccelUidCapability> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof AccelUidCapability) == false) goto L8;
        AccelUidCapability r10 = (AccelUidCapability) r8;
        if (hasTimestamp() == r10.hasTimestamp()) goto L13;
        return false;
    L13:
        if (hasTimestamp() == false) goto L18;
        if (getTimestamp() == r10.getTimestamp()) goto L18;
        return false;
    L18:
        if (getAppInfoList().equals(r10.getAppInfoList()) == true) goto L21;
        return false;
    L21:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L23;
        return false;
    L23:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
    public AppInfo getAppInfo(int r8) {
        return this.appInfo_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
    public int getAppInfoCount() {
        return this.appInfo_.size();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
    public List<AppInfo> getAppInfoList() {
        return this.appInfo_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
    public AppInfoOrBuilder getAppInfoOrBuilder(int r8) {
        return this.appInfo_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
    public List<? extends AppInfoOrBuilder> getAppInfoOrBuilderList() {
        return this.appInfo_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AccelUidCapability> getParserForType() {
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
        int r11 = CodedOutputStream.computeInt64Size(2, this.timestamp_) + 0;
    L10:
        if (r10 >= this.appInfo_.size()) goto L12;
        r11 = r11 + CodedOutputStream.computeMessageSize(3, this.appInfo_.get(r10));
        r10 = r10 + 1;
        goto L10
    L12:
        int r12 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AccelUidCapabilityOrBuilder
    public boolean hasTimestamp() {
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
        if (hasTimestamp() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashLong(getTimestamp());
    L9:
        if (getAppInfoCount() <= 0) goto L11;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getAppInfoList().hashCode();
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
        return new AccelUidCapability();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L5;
        r8.writeInt64(2, this.timestamp_);
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.appInfo_.size()) goto L9;
        r8.writeMessage(3, this.appInfo_.get(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        getUnknownFields().writeTo(r8);
    }

    private AccelUidCapability(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(AccelUidCapability r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static AccelUidCapability parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AccelUidCapability) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static AccelUidCapability parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AccelUidCapability_fieldAccessorTable.ensureFieldAccessorsInitialized(AccelUidCapability.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ AccelUidCapability(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static AccelUidCapability parseFrom(CodedInputStream r8) {
        return (AccelUidCapability) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public AccelUidCapability getDefaultInstanceForType() {
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

    public static AccelUidCapability parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (AccelUidCapability) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static AccelUidCapability parseFrom(InputStream r8) {
        return (AccelUidCapability) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static AccelUidCapability parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AccelUidCapability) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static AccelUidCapability parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static AccelUidCapability parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static AccelUidCapability parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static AccelUidCapability parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
