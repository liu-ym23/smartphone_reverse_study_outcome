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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSocketStats extends GeneratedMessageV3 implements AppSocketStatsOrBuilder {
    public static final int APPINFO_FIELD_NUMBER = 4;
    private static final AppSocketStats DEFAULT_INSTANCE = null;
    public static final int ENDTIMESTAMP_FIELD_NUMBER = 3;

    @Deprecated
    public static final Parser<AppSocketStats> PARSER = null;
    public static final int SOCKETSTATS_FIELD_NUMBER = 5;
    public static final int STARTTIMESTAMP_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 1;
    public static final int WIFISTATS_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private AppInfo appInfo_;
    private int bitField0_;
    private long endTimestamp_;
    private byte memoizedIsInitialized;
    private List<SocketStats> socketStats_;
    private long startTimestamp_;
    private int state_;
    private List<WifiStats> wifiStats_;

    public static final class AppInfo extends GeneratedMessageV3 implements AppInfoOrBuilder {
        private static final AppInfo DEFAULT_INSTANCE = null;
        public static final int PACKAGENAME_FIELD_NUMBER = 2;

        @Deprecated
        public static final Parser<AppInfo> PARSER = null;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object packageName_;
        private int uid_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AppInfoOrBuilder {
            private int bitField0_;
            private Object packageName_;
            private int uid_;

            private Builder() {
                this.packageName_ = "";
            }

            private void buildPartial0(AppInfo r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                AppInfo.access$302(r8, this.uid_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L9;
                AppInfo.access$402(r8, this.packageName_);
                r11 = r11 | 2;
            L9:
                AppInfo.access$576(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_descriptor;
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
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.bitField0_ &= -2;
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_descriptor;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
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

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
            public ByteString getPackageNameBytes() {
                Object r8 = this.packageName_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.packageName_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
            public boolean hasPackageName() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
            public boolean hasUid() {
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
                return setField(r8, r10);
            }

            public Builder setPackageName(String r8) {
                if (r8 == null) goto L6;
                this.packageName_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setPackageNameBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.packageName_ = r8;
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

            public Builder setUid(int r8) {
                this.uid_ = r8;
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AppInfo.class, Builder.class);
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
                if (r10 == null) goto L28;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L25;
                int r12 = r8.readTag();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                if (r12 == 0) goto L17;
                if (r12 != 8) goto L10;
                this.uid_ = r8.readInt32();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                this.bitField0_ |= 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                goto L4
            L10:
                if (r12 != 18) goto L12;
                this.packageName_ = r8.readBytes();     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
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
                if (r8.hasUid() == false) goto L9;
                setUid(r8.getUid());
            L9:
                if (r8.hasPackageName() == false) goto L11;
                this.packageName_ = AppInfo.access$400(r8);
                this.bitField0_ |= 2;
                onChanged();
            L11:
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
            this.uid_ = 0;
            this.packageName_ = "";
            this.memoizedIsInitialized = -1;
            this.packageName_ = "";
        }

        public static /* synthetic */ int access$302(AppInfo r8, int r10) {
            r8.uid_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$400(AppInfo r8) {
            return r8.packageName_;
        }

        public static /* synthetic */ Object access$402(AppInfo r8, Object r10) {
            r8.packageName_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$576(AppInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static AppInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_descriptor;
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
            if (hasUid() == r10.hasUid()) goto L13;
            return false;
        L13:
            if (hasUid() == false) goto L18;
            if (getUid() == r10.getUid()) goto L18;
            return false;
        L18:
            if (hasPackageName() == r10.hasPackageName()) goto L21;
            return false;
        L21:
            if (hasPackageName() == false) goto L26;
            if (getPackageName().equals(r10.getPackageName()) == true) goto L26;
            return false;
        L26:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L28;
            return false;
        L28:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
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

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
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
            r10 = 0 + CodedOutputStream.computeInt32Size(1, this.uid_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L11;
            r10 = r10 + GeneratedMessage.computeStringSize(2, this.packageName_);
        L11:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.AppInfoOrBuilder
        public boolean hasUid() {
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
            if (hasUid() == false) goto L9;
            r10 = defpackage.b.a(r10, 37, 1, 53) + getUid();
        L9:
            if (hasPackageName() == false) goto L11;
            r10 = defpackage.b.a(r10, 37, 2, 53) + getPackageName().hashCode();
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
            return new AppInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeInt32(1, this.uid_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L8;
            GeneratedMessage.writeString(r8, 2, this.packageName_);
        L8:
            getUnknownFields().writeTo(r8);
        }

        private AppInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
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
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_AppInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AppInfo.class, Builder.class);
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

        int getUid();

        boolean hasPackageName();

        boolean hasUid();
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AppSocketStatsOrBuilder {
        private SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> appInfoBuilder_;
        private AppInfo appInfo_;
        private int bitField0_;
        private long endTimestamp_;
        private RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> socketStatsBuilder_;
        private List<SocketStats> socketStats_;
        private long startTimestamp_;
        private int state_;
        private RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> wifiStatsBuilder_;
        private List<WifiStats> wifiStats_;

        private Builder() {
            this.socketStats_ = Collections.emptyList();
            this.wifiStats_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(AppSocketStats r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            AppSocketStats.access$3102(r8, this.state_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            AppSocketStats.access$3202(r8, this.startTimestamp_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            AppSocketStats.access$3302(r8, this.endTimestamp_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L19;
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r12 = this.appInfoBuilder_;
            if (r12 != null) goto L17;
            AppInfo r13 = this.appInfo_;
        L18:
            AppSocketStats.access$3402(r8, r13);
            r11 = r11 | 8;
            goto L19
        L17:
            r13 = (AppInfo) r12.build();
        L19:
            AppSocketStats.access$3576(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(AppSocketStats r8) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            AppSocketStats.access$2902(r8, r11);
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r12 = this.wifiStatsBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            AppSocketStats.access$3002(r8, r13);
            return;
        L12:
            if ((this.bitField0_ & 32) == 0) goto L14;
            this.wifiStats_ = Collections.unmodifiableList(this.wifiStats_);
            this.bitField0_ &= -33;
        L14:
            r13 = this.wifiStats_;
            goto L16
        L5:
            if ((this.bitField0_ & 16) == 0) goto L7;
            this.socketStats_ = Collections.unmodifiableList(this.socketStats_);
            this.bitField0_ &= -17;
        L7:
            r11 = this.socketStats_;
            goto L9
        }

        private void ensureSocketStatsIsMutable() {
            if ((this.bitField0_ & 16) != 0) goto L6;
            this.socketStats_ = new ArrayList(this.socketStats_);
            this.bitField0_ |= 16;
            return;
        }

        private void ensureWifiStatsIsMutable() {
            if ((this.bitField0_ & 32) != 0) goto L6;
            this.wifiStats_ = new ArrayList(this.wifiStats_);
            this.bitField0_ |= 32;
            return;
        }

        private SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> getAppInfoFieldBuilder() {
            if (this.appInfoBuilder_ != null) goto L6;
            this.appInfoBuilder_ = new SingleFieldBuilderV3(getAppInfo(), getParentForChildren(), isClean());
            this.appInfo_ = null;
        L6:
            return this.appInfoBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_descriptor;
        }

        private RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> getSocketStatsFieldBuilder() {
            if (this.socketStatsBuilder_ != null) goto L10;
            List<SocketStats> r8 = this.socketStats_;
            if ((this.bitField0_ & 16) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.socketStatsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.socketStats_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.socketStatsBuilder_;
        }

        private RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> getWifiStatsFieldBuilder() {
            if (this.wifiStatsBuilder_ != null) goto L10;
            List<WifiStats> r8 = this.wifiStats_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.wifiStatsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.wifiStats_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.wifiStatsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (AppSocketStats.access$2700() == false) goto L6;
            getAppInfoFieldBuilder();
            getSocketStatsFieldBuilder();
            getWifiStatsFieldBuilder();
            return;
        }

        public Builder addAllSocketStats(Iterable<? extends SocketStats> r8) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 != null) goto L5;
            ensureSocketStatsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.socketStats_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllWifiStats(Iterable<? extends WifiStats> r8) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r10 = this.wifiStatsBuilder_;
            if (r10 != null) goto L5;
            ensureWifiStatsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.wifiStats_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addSocketStats(int r8, SocketStats.Builder r10) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r11 = this.socketStatsBuilder_;
            if (r11 != null) goto L5;
            ensureSocketStatsIsMutable();
            this.socketStats_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public SocketStats.Builder addSocketStatsBuilder() {
            return (SocketStats.Builder) getSocketStatsFieldBuilder().addBuilder(SocketStats.getDefaultInstance());
        }

        public Builder addWifiStats(int r8, WifiStats.Builder r10) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r11 = this.wifiStatsBuilder_;
            if (r11 != null) goto L5;
            ensureWifiStatsIsMutable();
            this.wifiStats_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public WifiStats.Builder addWifiStatsBuilder() {
            return (WifiStats.Builder) getWifiStatsFieldBuilder().addBuilder(WifiStats.getDefaultInstance());
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
            this.bitField0_ &= -9;
            this.appInfo_ = null;
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.appInfoBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearEndTimestamp() {
            this.bitField0_ &= -5;
            this.endTimestamp_ = 0;
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

        public Builder clearSocketStats() {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r8 = this.socketStatsBuilder_;
            if (r8 != null) goto L5;
            this.socketStats_ = Collections.emptyList();
            this.bitField0_ &= -17;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearStartTimestamp() {
            this.bitField0_ &= -3;
            this.startTimestamp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearState() {
            this.bitField0_ &= -2;
            this.state_ = 0;
            onChanged();
            return this;
        }

        public Builder clearWifiStats() {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r8 = this.wifiStatsBuilder_;
            if (r8 != null) goto L5;
            this.wifiStats_ = Collections.emptyList();
            this.bitField0_ &= -33;
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

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public AppInfo getAppInfo() {
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 != null) goto L9;
            AppInfo r10 = this.appInfo_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return AppInfo.getDefaultInstance();
        L9:
            return (AppInfo) r8.getMessage();
        }

        public AppInfo.Builder getAppInfoBuilder() {
            this.bitField0_ |= 8;
            onChanged();
            return (AppInfo.Builder) getAppInfoFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public AppInfoOrBuilder getAppInfoOrBuilder() {
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 != null) goto L5;
            AppInfo r10 = this.appInfo_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return AppInfo.getDefaultInstance();
        L5:
            return (AppInfoOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_descriptor;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public SocketStats getSocketStats(int r8) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.socketStats_.get(r8);
        L6:
            return (SocketStats) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public SocketStats.Builder getSocketStatsBuilder(int r8) {
            return (SocketStats.Builder) getSocketStatsFieldBuilder().getBuilder(r8);
        }

        public List<SocketStats.Builder> getSocketStatsBuilderList() {
            return getSocketStatsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public int getSocketStatsCount() {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r8 = this.socketStatsBuilder_;
            if (r8 != null) goto L7;
            return this.socketStats_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public List<SocketStats> getSocketStatsList() {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r8 = this.socketStatsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.socketStats_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public SocketStatsOrBuilder getSocketStatsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.socketStats_.get(r8);
        L6:
            return (SocketStatsOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public List<? extends SocketStatsOrBuilder> getSocketStatsOrBuilderList() {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r8 = this.socketStatsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.socketStats_);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public int getState() {
            return this.state_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public WifiStats getWifiStats(int r8) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r10 = this.wifiStatsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.wifiStats_.get(r8);
        L6:
            return (WifiStats) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public WifiStats.Builder getWifiStatsBuilder(int r8) {
            return (WifiStats.Builder) getWifiStatsFieldBuilder().getBuilder(r8);
        }

        public List<WifiStats.Builder> getWifiStatsBuilderList() {
            return getWifiStatsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public int getWifiStatsCount() {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r8 = this.wifiStatsBuilder_;
            if (r8 != null) goto L7;
            return this.wifiStats_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public List<WifiStats> getWifiStatsList() {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r8 = this.wifiStatsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.wifiStats_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public WifiStatsOrBuilder getWifiStatsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r10 = this.wifiStatsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.wifiStats_.get(r8);
        L6:
            return (WifiStatsOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public List<? extends WifiStatsOrBuilder> getWifiStatsOrBuilderList() {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r8 = this.wifiStatsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.wifiStats_);
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public boolean hasAppInfo() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public boolean hasEndTimestamp() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public boolean hasStartTimestamp() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
        public boolean hasState() {
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

        public Builder mergeAppInfo(AppInfo r8) {
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 8) == 0) goto L11;
            AppInfo r11 = this.appInfo_;
            if (r11 == null) goto L11;
            if (r11 == AppInfo.getDefaultInstance()) goto L11;
            getAppInfoBuilder().mergeFrom(r8);
        L11:
            this.appInfo_ = r8;
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

        public Builder removeSocketStats(int r8) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 != null) goto L5;
            ensureSocketStatsIsMutable();
            this.socketStats_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeWifiStats(int r8) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r10 = this.wifiStatsBuilder_;
            if (r10 != null) goto L5;
            ensureWifiStatsIsMutable();
            this.wifiStats_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setAppInfo(AppInfo.Builder r8) {
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            AppInfo r11 = r8.build();
            if (r10 != null) goto L5;
            this.appInfo_ = r11;
        L6:
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setEndTimestamp(long r8) {
            this.endTimestamp_ = r8;
            this.bitField0_ |= 4;
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

        public Builder setSocketStats(int r8, SocketStats.Builder r10) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r11 = this.socketStatsBuilder_;
            if (r11 != null) goto L5;
            ensureSocketStatsIsMutable();
            this.socketStats_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setStartTimestamp(long r8) {
            this.startTimestamp_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setState(int r8) {
            this.state_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setWifiStats(int r8, WifiStats.Builder r10) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r11 = this.wifiStatsBuilder_;
            if (r11 != null) goto L5;
            ensureWifiStatsIsMutable();
            this.wifiStats_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.socketStats_ = Collections.emptyList();
            this.wifiStats_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addSocketStats(int r8, SocketStats r10) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r11 = this.socketStatsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSocketStatsIsMutable();
            this.socketStats_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public SocketStats.Builder addSocketStatsBuilder(int r8) {
            return (SocketStats.Builder) getSocketStatsFieldBuilder().addBuilder(r8, SocketStats.getDefaultInstance());
        }

        public Builder addWifiStats(int r8, WifiStats r10) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r11 = this.wifiStatsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiStatsIsMutable();
            this.wifiStats_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public WifiStats.Builder addWifiStatsBuilder(int r8) {
            return (WifiStats.Builder) getWifiStatsFieldBuilder().addBuilder(r8, WifiStats.getDefaultInstance());
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
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_fieldAccessorTable.ensureFieldAccessorsInitialized(AppSocketStats.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAppInfo(AppInfo r8) {
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r10 = this.appInfoBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.appInfo_ = r8;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSocketStats(int r8, SocketStats r10) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r11 = this.socketStatsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSocketStatsIsMutable();
            this.socketStats_.set(r8, r10);
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

        public Builder setWifiStats(int r8, WifiStats r10) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r11 = this.wifiStatsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureWifiStatsIsMutable();
            this.wifiStats_.set(r8, r10);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addSocketStats(SocketStats.Builder r8) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 != null) goto L5;
            ensureSocketStatsIsMutable();
            this.socketStats_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addWifiStats(WifiStats.Builder r8) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r10 = this.wifiStatsBuilder_;
            if (r10 != null) goto L5;
            ensureWifiStatsIsMutable();
            this.wifiStats_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AppSocketStats build() {
            AppSocketStats r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AppSocketStats buildPartial() {
            AppSocketStats r8 = new AppSocketStats(this, null);
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
        public AppSocketStats getDefaultInstanceForType() {
            return AppSocketStats.getDefaultInstance();
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

        public Builder addSocketStats(SocketStats r8) {
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureSocketStatsIsMutable();
            this.socketStats_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addWifiStats(WifiStats r8) {
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r10 = this.wifiStatsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureWifiStatsIsMutable();
            this.wifiStats_.add(r8);
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
            this.state_ = 0;
            this.startTimestamp_ = 0;
            this.endTimestamp_ = 0;
            this.appInfo_ = null;
            SingleFieldBuilderV3<AppInfo, AppInfo.Builder, AppInfoOrBuilder> r8 = this.appInfoBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.appInfoBuilder_ = null;
        L5:
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r10 = this.socketStatsBuilder_;
            if (r10 != null) goto L8;
            this.socketStats_ = Collections.emptyList();
        L9:
            this.bitField0_ &= -17;
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r11 = this.wifiStatsBuilder_;
            if (r11 != null) goto L12;
            this.wifiStats_ = Collections.emptyList();
        L13:
            this.bitField0_ &= -33;
            return this;
        L12:
            this.wifiStats_ = null;
            r11.clear();
            goto L13
        L8:
            this.socketStats_ = null;
            r10.clear();
            goto L9
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
            this.state_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.startTimestamp_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.endTimestamp_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L14:
            if (r12 != 34) goto L16;
            r8.readMessage(getAppInfoFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L16:
            if (r12 == 42) goto L27;
            if (r12 != 50) goto L20;
            GeneratedMessage.ExtendableMessageOrBuilder r13 = (WifiStats) r8.readMessage(WifiStats.PARSER, r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            RepeatedFieldBuilderV3 r14 = this.wifiStatsBuilder_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r14 == null) goto L24;
        L26:
            r14.addMessage(r13);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L24:
            ensureWifiStatsIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            List r15 = this.wifiStats_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L25:
            r15.add(r13);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L20:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L27:
            r13 = (SocketStats) r8.readMessage(SocketStats.PARSER, r10);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            r14 = this.socketStatsBuilder_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            if (r14 != null) goto L26;
            ensureSocketStatsIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            r15 = this.socketStats_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L35:
            r11 = true;
            goto L4
        L36:
            th = move-exception;
            onChanged();
            throw th;
        L38:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L36
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
            if ((r8 instanceof AppSocketStats) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((AppSocketStats) r8);
        }

        public Builder mergeFrom(AppSocketStats r8) {
            if (r8 != AppSocketStats.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasState() == false) goto L9;
            setState(r8.getState());
        L9:
            if (r8.hasStartTimestamp() == false) goto L12;
            setStartTimestamp(r8.getStartTimestamp());
        L12:
            if (r8.hasEndTimestamp() == false) goto L15;
            setEndTimestamp(r8.getEndTimestamp());
        L15:
            if (r8.hasAppInfo() == false) goto L17;
            mergeAppInfo(r8.getAppInfo());
        L17:
            RepeatedFieldBuilderV3<WifiStats, WifiStats.Builder, WifiStatsOrBuilder> r10 = null;
            if (this.socketStatsBuilder_ != null) goto L27;
            if (AppSocketStats.access$2900(r8).isEmpty() == true) goto L37;
            if (this.socketStats_.isEmpty() == false) goto L24;
            this.socketStats_ = AppSocketStats.access$2900(r8);
            this.bitField0_ &= -17;
        L25:
            onChanged();
            goto L37
        L24:
            ensureSocketStatsIsMutable();
            this.socketStats_.addAll(AppSocketStats.access$2900(r8));
        L37:
            if (this.wifiStatsBuilder_ != null) goto L46;
            if (AppSocketStats.access$3000(r8).isEmpty() == false) goto L41;
        L54:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L41:
            if (this.wifiStats_.isEmpty() == false) goto L43;
            this.wifiStats_ = AppSocketStats.access$3000(r8);
            this.bitField0_ &= -33;
        L44:
            onChanged();
            goto L54
        L43:
            ensureWifiStatsIsMutable();
            this.wifiStats_.addAll(AppSocketStats.access$3000(r8));
            goto L44
        L46:
            if (AppSocketStats.access$3000(r8).isEmpty() == true) goto L54;
            if (this.wifiStatsBuilder_.isEmpty() == false) goto L53;
            this.wifiStatsBuilder_.dispose();
            this.wifiStatsBuilder_ = null;
            this.wifiStats_ = AppSocketStats.access$3000(r8);
            this.bitField0_ &= -33;
            if (AppSocketStats.access$3700() == false) goto L52;
            r10 = getWifiStatsFieldBuilder();
        L52:
            this.wifiStatsBuilder_ = r10;
            goto L54
        L53:
            this.wifiStatsBuilder_.addAllMessages(AppSocketStats.access$3000(r8));
            goto L54
        L27:
            if (AppSocketStats.access$2900(r8).isEmpty() == true) goto L37;
            if (this.socketStatsBuilder_.isEmpty() == false) goto L35;
            this.socketStatsBuilder_.dispose();
            this.socketStatsBuilder_ = null;
            this.socketStats_ = AppSocketStats.access$2900(r8);
            this.bitField0_ &= -17;
            if (AppSocketStats.access$3600() == false) goto L33;
            RepeatedFieldBuilderV3<SocketStats, SocketStats.Builder, SocketStatsOrBuilder> r11 = getSocketStatsFieldBuilder();
        L34:
            this.socketStatsBuilder_ = r11;
            goto L37
        L33:
            r11 = null;
            goto L34
        L35:
            this.socketStatsBuilder_.addAllMessages(AppSocketStats.access$2900(r8));
            goto L37
        }
    }

    public static final class SocketStats extends GeneratedMessageV3 implements SocketStatsOrBuilder {
        private static final SocketStats DEFAULT_INSTANCE = null;
        public static final int DSTIP_FIELD_NUMBER = 6;
        public static final int DSTPORT_FIELD_NUMBER = 7;
        public static final int ENDTIMESTAMP_FIELD_NUMBER = 2;
        public static final int INTERFACE_FIELD_NUMBER = 3;

        @Deprecated
        public static final Parser<SocketStats> PARSER = null;
        public static final int SRCIP_FIELD_NUMBER = 4;
        public static final int SRCPORT_FIELD_NUMBER = 5;
        public static final int STARTTIMESTAMP_FIELD_NUMBER = 1;
        public static final int TOTALBYTESRECV_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object dstIp_;
        private int dstPort_;
        private long endTimestamp_;
        private volatile Object interface_;
        private byte memoizedIsInitialized;
        private volatile Object srcIp_;
        private int srcPort_;
        private long startTimestamp_;
        private long totalBytesRecv_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SocketStatsOrBuilder {
            private int bitField0_;
            private Object dstIp_;
            private int dstPort_;
            private long endTimestamp_;
            private Object interface_;
            private Object srcIp_;
            private int srcPort_;
            private long startTimestamp_;
            private long totalBytesRecv_;

            private Builder() {
                this.interface_ = "";
                this.srcIp_ = "";
                this.dstIp_ = "";
            }

            private void buildPartial0(SocketStats r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                SocketStats.access$902(r8, this.startTimestamp_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                SocketStats.access$1002(r8, this.endTimestamp_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                SocketStats.access$1102(r8, this.interface_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L16;
                SocketStats.access$1202(r8, this.srcIp_);
                r11 = r11 | 8;
            L16:
                if ((r10 & 16) == 0) goto L19;
                SocketStats.access$1302(r8, this.srcPort_);
                r11 = r11 | 16;
            L19:
                if ((r10 & 32) == 0) goto L22;
                SocketStats.access$1402(r8, this.dstIp_);
                r11 = r11 | 32;
            L22:
                if ((r10 & 64) == 0) goto L25;
                SocketStats.access$1502(r8, this.dstPort_);
                r11 = r11 | 64;
            L25:
                if ((r10 & 128) == 0) goto L27;
                SocketStats.access$1602(r8, this.totalBytesRecv_);
                r11 = r11 | 128;
            L27:
                SocketStats.access$1776(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_descriptor;
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

            public Builder clearDstIp() {
                this.dstIp_ = SocketStats.getDefaultInstance().getDstIp();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            public Builder clearDstPort() {
                this.bitField0_ &= -65;
                this.dstPort_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEndTimestamp() {
                this.bitField0_ &= -3;
                this.endTimestamp_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
                return clearField(r8);
            }

            public Builder clearInterface() {
                this.interface_ = SocketStats.getDefaultInstance().getInterface();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
            }

            public Builder clearSrcIp() {
                this.srcIp_ = SocketStats.getDefaultInstance().getSrcIp();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public Builder clearSrcPort() {
                this.bitField0_ &= -17;
                this.srcPort_ = 0;
                onChanged();
                return this;
            }

            public Builder clearStartTimestamp() {
                this.bitField0_ &= -2;
                this.startTimestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTotalBytesRecv() {
                this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
                this.totalBytesRecv_ = 0;
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_descriptor;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public String getDstIp() {
                Object r8 = this.dstIp_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.dstIp_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public ByteString getDstIpBytes() {
                Object r8 = this.dstIp_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.dstIp_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public int getDstPort() {
                return this.dstPort_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public long getEndTimestamp() {
                return this.endTimestamp_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public String getInterface() {
                Object r8 = this.interface_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.interface_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public ByteString getInterfaceBytes() {
                Object r8 = this.interface_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.interface_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public String getSrcIp() {
                Object r8 = this.srcIp_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.srcIp_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public ByteString getSrcIpBytes() {
                Object r8 = this.srcIp_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.srcIp_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public int getSrcPort() {
                return this.srcPort_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public long getStartTimestamp() {
                return this.startTimestamp_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public long getTotalBytesRecv() {
                return this.totalBytesRecv_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasDstIp() {
                if ((this.bitField0_ & 32) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasDstPort() {
                if ((this.bitField0_ & 64) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasEndTimestamp() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasInterface() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasSrcIp() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasSrcPort() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasStartTimestamp() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
            public boolean hasTotalBytesRecv() {
                if ((this.bitField0_ & 128) == 0) goto L5;
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

            public Builder setDstIp(String r8) {
                if (r8 == null) goto L6;
                this.dstIp_ = r8;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setDstIpBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.dstIp_ = r8;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setDstPort(int r8) {
                this.dstPort_ = r8;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setEndTimestamp(long r8) {
                this.endTimestamp_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
                return setField(r8, r10);
            }

            public Builder setInterface(String r8) {
                if (r8 == null) goto L6;
                this.interface_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setInterfaceBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.interface_ = r8;
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

            public Builder setSrcIp(String r8) {
                if (r8 == null) goto L6;
                this.srcIp_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setSrcIpBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.srcIp_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setSrcPort(int r8) {
                this.srcPort_ = r8;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setStartTimestamp(long r8) {
                this.startTimestamp_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setTotalBytesRecv(long r8) {
                this.totalBytesRecv_ = r8;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
                return setUnknownFields(r8);
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
                this.interface_ = "";
                this.srcIp_ = "";
                this.dstIp_ = "";
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_fieldAccessorTable.ensureFieldAccessorsInitialized(SocketStats.class, Builder.class);
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
            public SocketStats build() {
                SocketStats r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SocketStats buildPartial() {
                SocketStats r8 = new SocketStats(this, null);
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
            public SocketStats getDefaultInstanceForType() {
                return SocketStats.getDefaultInstance();
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
                this.startTimestamp_ = 0;
                this.endTimestamp_ = 0;
                this.interface_ = "";
                this.srcIp_ = "";
                this.srcPort_ = 0;
                this.dstIp_ = "";
                this.dstPort_ = 0;
                this.totalBytesRecv_ = 0;
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
                if (r12 != 8) goto L9;
                this.startTimestamp_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L9:
                int r13 = 16;
                if (r12 != 16) goto L12;
                this.endTimestamp_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L12:
                if (r12 != 26) goto L14;
                this.interface_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L14:
                if (r12 != 34) goto L16;
                this.srcIp_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L16:
                if (r12 == 40) goto L29;
                if (r12 != 50) goto L19;
                this.dstIp_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L19:
                r13 = 64;
                if (r12 != 56) goto L21;
                this.dstPort_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                int r14 = this.bitField0_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            L27:
                this.bitField0_ = r14 | r13;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L21:
                if (r12 != 64) goto L23;
                this.totalBytesRecv_ = r8.readInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 128;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L23:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L29:
                this.srcPort_ = r8.readInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                r14 = this.bitField0_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            L35:
                r11 = true;
                goto L4
            L36:
                th = move-exception;
                onChanged();
                throw th;
            L38:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L36
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
                if ((r8 instanceof SocketStats) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((SocketStats) r8);
            }

            public Builder mergeFrom(SocketStats r8) {
                if (r8 != SocketStats.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasStartTimestamp() == false) goto L9;
                setStartTimestamp(r8.getStartTimestamp());
            L9:
                if (r8.hasEndTimestamp() == false) goto L12;
                setEndTimestamp(r8.getEndTimestamp());
            L12:
                if (r8.hasInterface() == false) goto L15;
                this.interface_ = SocketStats.access$1100(r8);
                this.bitField0_ |= 4;
                onChanged();
            L15:
                if (r8.hasSrcIp() == false) goto L18;
                this.srcIp_ = SocketStats.access$1200(r8);
                this.bitField0_ |= 8;
                onChanged();
            L18:
                if (r8.hasSrcPort() == false) goto L21;
                setSrcPort(r8.getSrcPort());
            L21:
                if (r8.hasDstIp() == false) goto L24;
                this.dstIp_ = SocketStats.access$1400(r8);
                this.bitField0_ |= 32;
                onChanged();
            L24:
                if (r8.hasDstPort() == false) goto L27;
                setDstPort(r8.getDstPort());
            L27:
                if (r8.hasTotalBytesRecv() == false) goto L29;
                setTotalBytesRecv(r8.getTotalBytesRecv());
            L29:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new SocketStats();
            PARSER = new AnonymousClass1();
        }

        private SocketStats() {
            this.startTimestamp_ = 0;
            this.endTimestamp_ = 0;
            this.interface_ = "";
            this.srcIp_ = "";
            this.srcPort_ = 0;
            this.dstIp_ = "";
            this.dstPort_ = 0;
            this.totalBytesRecv_ = 0;
            this.memoizedIsInitialized = -1;
            this.interface_ = "";
            this.srcIp_ = "";
            this.dstIp_ = "";
        }

        public static /* synthetic */ long access$1002(SocketStats r8, long r10) {
            r8.endTimestamp_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$1100(SocketStats r8) {
            return r8.interface_;
        }

        public static /* synthetic */ Object access$1102(SocketStats r8, Object r10) {
            r8.interface_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$1200(SocketStats r8) {
            return r8.srcIp_;
        }

        public static /* synthetic */ Object access$1202(SocketStats r8, Object r10) {
            r8.srcIp_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1302(SocketStats r8, int r10) {
            r8.srcPort_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$1400(SocketStats r8) {
            return r8.dstIp_;
        }

        public static /* synthetic */ Object access$1402(SocketStats r8, Object r10) {
            r8.dstIp_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1502(SocketStats r8, int r10) {
            r8.dstPort_ = r10;
            return r10;
        }

        public static /* synthetic */ long access$1602(SocketStats r8, long r10) {
            r8.totalBytesRecv_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1776(SocketStats r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static /* synthetic */ long access$902(SocketStats r8, long r10) {
            r8.startTimestamp_ = r10;
            return r10;
        }

        public static SocketStats getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static SocketStats parseDelimitedFrom(InputStream r8) {
            return (SocketStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static SocketStats parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<SocketStats> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof SocketStats) == false) goto L8;
            SocketStats r10 = (SocketStats) r8;
            if (hasStartTimestamp() == r10.hasStartTimestamp()) goto L13;
            return false;
        L13:
            if (hasStartTimestamp() == false) goto L18;
            if (getStartTimestamp() == r10.getStartTimestamp()) goto L18;
            return false;
        L18:
            if (hasEndTimestamp() == r10.hasEndTimestamp()) goto L21;
            return false;
        L21:
            if (hasEndTimestamp() == false) goto L26;
            if (getEndTimestamp() == r10.getEndTimestamp()) goto L26;
            return false;
        L26:
            if (hasInterface() == r10.hasInterface()) goto L29;
            return false;
        L29:
            if (hasInterface() == false) goto L34;
            if (getInterface().equals(r10.getInterface()) == true) goto L34;
            return false;
        L34:
            if (hasSrcIp() == r10.hasSrcIp()) goto L37;
            return false;
        L37:
            if (hasSrcIp() == false) goto L42;
            if (getSrcIp().equals(r10.getSrcIp()) == true) goto L42;
            return false;
        L42:
            if (hasSrcPort() == r10.hasSrcPort()) goto L45;
            return false;
        L45:
            if (hasSrcPort() == false) goto L50;
            if (getSrcPort() == r10.getSrcPort()) goto L50;
            return false;
        L50:
            if (hasDstIp() == r10.hasDstIp()) goto L53;
            return false;
        L53:
            if (hasDstIp() == false) goto L58;
            if (getDstIp().equals(r10.getDstIp()) == true) goto L58;
            return false;
        L58:
            if (hasDstPort() == r10.hasDstPort()) goto L61;
            return false;
        L61:
            if (hasDstPort() == false) goto L66;
            if (getDstPort() == r10.getDstPort()) goto L66;
            return false;
        L66:
            if (hasTotalBytesRecv() == r10.hasTotalBytesRecv()) goto L69;
            return false;
        L69:
            if (hasTotalBytesRecv() == false) goto L74;
            if (getTotalBytesRecv() == r10.getTotalBytesRecv()) goto L74;
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

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public String getDstIp() {
            Object r8 = this.dstIp_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.dstIp_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public ByteString getDstIpBytes() {
            Object r8 = this.dstIp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.dstIp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public int getDstPort() {
            return this.dstPort_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public String getInterface() {
            Object r8 = this.interface_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.interface_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public ByteString getInterfaceBytes() {
            Object r8 = this.interface_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.interface_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SocketStats> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeInt64Size(1, this.startTimestamp_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeInt64Size(2, this.endTimestamp_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + GeneratedMessage.computeStringSize(3, this.interface_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r10 = r10 + GeneratedMessage.computeStringSize(4, this.srcIp_);
        L18:
            if ((this.bitField0_ & 16) == 0) goto L21;
            r10 = r10 + CodedOutputStream.computeInt32Size(5, this.srcPort_);
        L21:
            if ((this.bitField0_ & 32) == 0) goto L24;
            r10 = r10 + GeneratedMessage.computeStringSize(6, this.dstIp_);
        L24:
            if ((this.bitField0_ & 64) == 0) goto L27;
            r10 = r10 + CodedOutputStream.computeInt32Size(7, this.dstPort_);
        L27:
            if ((this.bitField0_ & 128) == 0) goto L29;
            r10 = r10 + CodedOutputStream.computeInt64Size(8, this.totalBytesRecv_);
        L29:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public String getSrcIp() {
            Object r8 = this.srcIp_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.srcIp_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public ByteString getSrcIpBytes() {
            Object r8 = this.srcIp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.srcIp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public int getSrcPort() {
            return this.srcPort_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public long getTotalBytesRecv() {
            return this.totalBytesRecv_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasDstIp() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasDstPort() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasEndTimestamp() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasInterface() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasSrcIp() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasSrcPort() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasStartTimestamp() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.SocketStatsOrBuilder
        public boolean hasTotalBytesRecv() {
            if ((this.bitField0_ & 128) == 0) goto L5;
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
            if (hasStartTimestamp() == false) goto L9;
            r10 = defpackage.b.a(r10, 37, 1, 53) + Internal.hashLong(getStartTimestamp());
        L9:
            if (hasEndTimestamp() == false) goto L12;
            r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashLong(getEndTimestamp());
        L12:
            if (hasInterface() == false) goto L15;
            r10 = defpackage.b.a(r10, 37, 3, 53) + getInterface().hashCode();
        L15:
            if (hasSrcIp() == false) goto L18;
            r10 = defpackage.b.a(r10, 37, 4, 53) + getSrcIp().hashCode();
        L18:
            if (hasSrcPort() == false) goto L21;
            r10 = defpackage.b.a(r10, 37, 5, 53) + getSrcPort();
        L21:
            if (hasDstIp() == false) goto L24;
            r10 = defpackage.b.a(r10, 37, 6, 53) + getDstIp().hashCode();
        L24:
            if (hasDstPort() == false) goto L27;
            r10 = defpackage.b.a(r10, 37, 7, 53) + getDstPort();
        L27:
            if (hasTotalBytesRecv() == false) goto L29;
            r10 = defpackage.b.a(r10, 37, 8, 53) + Internal.hashLong(getTotalBytesRecv());
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
            return new SocketStats();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeInt64(1, this.startTimestamp_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeInt64(2, this.endTimestamp_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            GeneratedMessage.writeString(r8, 3, this.interface_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L15;
            GeneratedMessage.writeString(r8, 4, this.srcIp_);
        L15:
            if ((this.bitField0_ & 16) == 0) goto L18;
            r8.writeInt32(5, this.srcPort_);
        L18:
            if ((this.bitField0_ & 32) == 0) goto L21;
            GeneratedMessage.writeString(r8, 6, this.dstIp_);
        L21:
            if ((this.bitField0_ & 64) == 0) goto L24;
            r8.writeInt32(7, this.dstPort_);
        L24:
            if ((this.bitField0_ & 128) == 0) goto L26;
            r8.writeInt64(8, this.totalBytesRecv_);
        L26:
            getUnknownFields().writeTo(r8);
        }

        private SocketStats(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.startTimestamp_ = 0;
            this.endTimestamp_ = 0;
            this.interface_ = "";
            this.srcIp_ = "";
            this.srcPort_ = 0;
            this.dstIp_ = "";
            this.dstPort_ = 0;
            this.totalBytesRecv_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(SocketStats r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static SocketStats parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (SocketStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static SocketStats parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_SocketStats_fieldAccessorTable.ensureFieldAccessorsInitialized(SocketStats.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ SocketStats(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static SocketStats parseFrom(CodedInputStream r8) {
            return (SocketStats) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public SocketStats getDefaultInstanceForType() {
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

        public static SocketStats parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (SocketStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static SocketStats parseFrom(InputStream r8) {
            return (SocketStats) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static SocketStats parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (SocketStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static SocketStats parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static SocketStats parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static SocketStats parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static SocketStats parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface SocketStatsOrBuilder extends MessageOrBuilder {
        String getDstIp();

        ByteString getDstIpBytes();

        int getDstPort();

        long getEndTimestamp();

        String getInterface();

        ByteString getInterfaceBytes();

        String getSrcIp();

        ByteString getSrcIpBytes();

        int getSrcPort();

        long getStartTimestamp();

        long getTotalBytesRecv();

        boolean hasDstIp();

        boolean hasDstPort();

        boolean hasEndTimestamp();

        boolean hasInterface();

        boolean hasSrcIp();

        boolean hasSrcPort();

        boolean hasStartTimestamp();

        boolean hasTotalBytesRecv();
    }

    public static final class WifiStats extends GeneratedMessageV3 implements WifiStatsOrBuilder {
        private static final WifiStats DEFAULT_INSTANCE = null;
        public static final int L2THROUGHPUT_FIELD_NUMBER = 2;

        @Deprecated
        public static final Parser<WifiStats> PARSER = null;
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int WIFITYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long l2Throughput_;
        private byte memoizedIsInitialized;
        private long timestamp_;
        private int wifiType_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WifiStatsOrBuilder {
            private int bitField0_;
            private long l2Throughput_;
            private long timestamp_;
            private int wifiType_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(WifiStats r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                WifiStats.access$2102(r8, this.wifiType_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                WifiStats.access$2202(r8, this.l2Throughput_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L12;
                WifiStats.access$2302(r8, this.timestamp_);
                r11 = r11 | 4;
            L12:
                WifiStats.access$2476(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_descriptor;
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

            public Builder clearL2Throughput() {
                this.bitField0_ &= -3;
                this.l2Throughput_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -5;
                this.timestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWifiType() {
                this.bitField0_ &= -2;
                this.wifiType_ = 0;
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_descriptor;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
            public long getL2Throughput() {
                return this.l2Throughput_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
            public int getWifiType() {
                return this.wifiType_;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
            public boolean hasL2Throughput() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
            public boolean hasTimestamp() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
            public boolean hasWifiType() {
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
                return setField(r8, r10);
            }

            public Builder setL2Throughput(long r8) {
                this.l2Throughput_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
            }

            public Builder setTimestamp(long r8) {
                this.timestamp_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
                return setUnknownFields(r8);
            }

            public Builder setWifiType(int r8) {
                this.wifiType_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
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
                return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiStats.class, Builder.class);
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
            public WifiStats build() {
                WifiStats r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WifiStats buildPartial() {
                WifiStats r8 = new WifiStats(this, null);
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
            public WifiStats getDefaultInstanceForType() {
                return WifiStats.getDefaultInstance();
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
                this.wifiType_ = 0;
                this.l2Throughput_ = 0;
                this.timestamp_ = 0;
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
                this.wifiType_ = r8.readInt32();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                this.bitField0_ |= 1;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                goto L4
            L10:
                if (r12 != 16) goto L12;
                this.l2Throughput_ = r8.readInt64();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                this.bitField0_ |= 2;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
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
                if ((r8 instanceof WifiStats) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((WifiStats) r8);
            }

            public Builder mergeFrom(WifiStats r8) {
                if (r8 != WifiStats.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasWifiType() == false) goto L9;
                setWifiType(r8.getWifiType());
            L9:
                if (r8.hasL2Throughput() == false) goto L12;
                setL2Throughput(r8.getL2Throughput());
            L12:
                if (r8.hasTimestamp() == false) goto L14;
                setTimestamp(r8.getTimestamp());
            L14:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new WifiStats();
            PARSER = new AnonymousClass1();
        }

        private WifiStats() {
            this.wifiType_ = 0;
            this.l2Throughput_ = 0;
            this.timestamp_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$2102(WifiStats r8, int r10) {
            r8.wifiType_ = r10;
            return r10;
        }

        public static /* synthetic */ long access$2202(WifiStats r8, long r10) {
            r8.l2Throughput_ = r10;
            return r10;
        }

        public static /* synthetic */ long access$2302(WifiStats r8, long r10) {
            r8.timestamp_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2476(WifiStats r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static WifiStats getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static WifiStats parseDelimitedFrom(InputStream r8) {
            return (WifiStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static WifiStats parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<WifiStats> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof WifiStats) == false) goto L8;
            WifiStats r10 = (WifiStats) r8;
            if (hasWifiType() == r10.hasWifiType()) goto L13;
            return false;
        L13:
            if (hasWifiType() == false) goto L18;
            if (getWifiType() == r10.getWifiType()) goto L18;
            return false;
        L18:
            if (hasL2Throughput() == r10.hasL2Throughput()) goto L21;
            return false;
        L21:
            if (hasL2Throughput() == false) goto L26;
            if (getL2Throughput() == r10.getL2Throughput()) goto L26;
            return false;
        L26:
            if (hasTimestamp() == r10.hasTimestamp()) goto L29;
            return false;
        L29:
            if (hasTimestamp() == false) goto L34;
            if (getTimestamp() == r10.getTimestamp()) goto L34;
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

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
        public long getL2Throughput() {
            return this.l2Throughput_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WifiStats> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeInt32Size(1, this.wifiType_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeInt64Size(2, this.l2Throughput_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            r10 = r10 + CodedOutputStream.computeInt64Size(3, this.timestamp_);
        L14:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
        public int getWifiType() {
            return this.wifiType_;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
        public boolean hasL2Throughput() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStats.WifiStatsOrBuilder
        public boolean hasWifiType() {
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
            if (hasWifiType() == false) goto L9;
            r10 = defpackage.b.a(r10, 37, 1, 53) + getWifiType();
        L9:
            if (hasL2Throughput() == false) goto L12;
            r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashLong(getL2Throughput());
        L12:
            if (hasTimestamp() == false) goto L14;
            r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashLong(getTimestamp());
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
            return new WifiStats();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeInt32(1, this.wifiType_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeInt64(2, this.l2Throughput_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L11;
            r8.writeInt64(3, this.timestamp_);
        L11:
            getUnknownFields().writeTo(r8);
        }

        private WifiStats(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.wifiType_ = 0;
            this.l2Throughput_ = 0;
            this.timestamp_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(WifiStats r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static WifiStats parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (WifiStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static WifiStats parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_WifiStats_fieldAccessorTable.ensureFieldAccessorsInitialized(WifiStats.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ WifiStats(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static WifiStats parseFrom(CodedInputStream r8) {
            return (WifiStats) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public WifiStats getDefaultInstanceForType() {
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

        public static WifiStats parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (WifiStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static WifiStats parseFrom(InputStream r8) {
            return (WifiStats) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static WifiStats parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (WifiStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static WifiStats parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static WifiStats parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static WifiStats parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static WifiStats parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface WifiStatsOrBuilder extends MessageOrBuilder {
        long getL2Throughput();

        long getTimestamp();

        int getWifiType();

        boolean hasL2Throughput();

        boolean hasTimestamp();

        boolean hasWifiType();
    }

    static {
        DEFAULT_INSTANCE = new AppSocketStats();
        PARSER = new AnonymousClass1();
    }

    private AppSocketStats() {
        this.state_ = 0;
        this.startTimestamp_ = 0;
        this.endTimestamp_ = 0;
        this.memoizedIsInitialized = -1;
        this.socketStats_ = Collections.emptyList();
        this.wifiStats_ = Collections.emptyList();
    }

    public static /* synthetic */ boolean access$2700() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$2900(AppSocketStats r8) {
        return r8.socketStats_;
    }

    public static /* synthetic */ List access$2902(AppSocketStats r8, List r10) {
        r8.socketStats_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$3000(AppSocketStats r8) {
        return r8.wifiStats_;
    }

    public static /* synthetic */ List access$3002(AppSocketStats r8, List r10) {
        r8.wifiStats_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3102(AppSocketStats r8, int r10) {
        r8.state_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$3202(AppSocketStats r8, long r10) {
        r8.startTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$3302(AppSocketStats r8, long r10) {
        r8.endTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ AppInfo access$3402(AppSocketStats r8, AppInfo r10) {
        r8.appInfo_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$3576(AppSocketStats r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$3600() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$3700() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static AppSocketStats getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AppSocketStats parseDelimitedFrom(InputStream r8) {
        return (AppSocketStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static AppSocketStats parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<AppSocketStats> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof AppSocketStats) == false) goto L8;
        AppSocketStats r10 = (AppSocketStats) r8;
        if (hasState() == r10.hasState()) goto L13;
        return false;
    L13:
        if (hasState() == false) goto L18;
        if (getState() == r10.getState()) goto L18;
        return false;
    L18:
        if (hasStartTimestamp() == r10.hasStartTimestamp()) goto L21;
        return false;
    L21:
        if (hasStartTimestamp() == false) goto L26;
        if (getStartTimestamp() == r10.getStartTimestamp()) goto L26;
        return false;
    L26:
        if (hasEndTimestamp() == r10.hasEndTimestamp()) goto L29;
        return false;
    L29:
        if (hasEndTimestamp() == false) goto L34;
        if (getEndTimestamp() == r10.getEndTimestamp()) goto L34;
        return false;
    L34:
        if (hasAppInfo() == r10.hasAppInfo()) goto L37;
        return false;
    L37:
        if (hasAppInfo() == false) goto L42;
        if (getAppInfo().equals(r10.getAppInfo()) == true) goto L42;
        return false;
    L42:
        if (getSocketStatsList().equals(r10.getSocketStatsList()) == true) goto L45;
        return false;
    L45:
        if (getWifiStatsList().equals(r10.getWifiStatsList()) == true) goto L48;
        return false;
    L48:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L50;
        return false;
    L50:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public AppInfo getAppInfo() {
        AppInfo r8 = this.appInfo_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AppInfo.getDefaultInstance();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public AppInfoOrBuilder getAppInfoOrBuilder() {
        AppInfo r8 = this.appInfo_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return AppInfo.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public long getEndTimestamp() {
        return this.endTimestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AppSocketStats> getParserForType() {
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
        int r11 = CodedOutputStream.computeInt32Size(1, this.state_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeInt64Size(2, this.startTimestamp_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeInt64Size(3, this.endTimestamp_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r11 = r11 + CodedOutputStream.computeMessageSize(4, getAppInfo());
    L18:
        int r12 = 0;
    L20:
        if (r12 >= this.socketStats_.size()) goto L23;
        r11 = r11 + CodedOutputStream.computeMessageSize(5, this.socketStats_.get(r12));
        r12 = r12 + 1;
    L23:
        if (r10 >= this.wifiStats_.size()) goto L25;
        r11 = r11 + CodedOutputStream.computeMessageSize(6, this.wifiStats_.get(r10));
        r10 = r10 + 1;
        goto L23
    L25:
        int r13 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r13;
        return r13;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public SocketStats getSocketStats(int r8) {
        return this.socketStats_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public int getSocketStatsCount() {
        return this.socketStats_.size();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public List<SocketStats> getSocketStatsList() {
        return this.socketStats_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public SocketStatsOrBuilder getSocketStatsOrBuilder(int r8) {
        return this.socketStats_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public List<? extends SocketStatsOrBuilder> getSocketStatsOrBuilderList() {
        return this.socketStats_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public long getStartTimestamp() {
        return this.startTimestamp_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public int getState() {
        return this.state_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public WifiStats getWifiStats(int r8) {
        return this.wifiStats_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public int getWifiStatsCount() {
        return this.wifiStats_.size();
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public List<WifiStats> getWifiStatsList() {
        return this.wifiStats_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public WifiStatsOrBuilder getWifiStatsOrBuilder(int r8) {
        return this.wifiStats_.get(r8);
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public List<? extends WifiStatsOrBuilder> getWifiStatsOrBuilderList() {
        return this.wifiStats_;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public boolean hasAppInfo() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public boolean hasEndTimestamp() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public boolean hasStartTimestamp() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.smartNetwork.netAccel.AppSocketStatsOrBuilder
    public boolean hasState() {
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
        if (hasState() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getState();
    L9:
        if (hasStartTimestamp() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashLong(getStartTimestamp());
    L12:
        if (hasEndTimestamp() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashLong(getEndTimestamp());
    L15:
        if (hasAppInfo() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getAppInfo().hashCode();
    L18:
        if (getSocketStatsCount() <= 0) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getSocketStatsList().hashCode();
    L21:
        if (getWifiStatsCount() <= 0) goto L23;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getWifiStatsList().hashCode();
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
        return new AppSocketStats();
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
        r8.writeInt64(2, this.startTimestamp_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeInt64(3, this.endTimestamp_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L14;
        r8.writeMessage(4, getAppInfo());
    L14:
        int r10 = 0;
        int r11 = 0;
    L16:
        if (r11 >= this.socketStats_.size()) goto L19;
        r8.writeMessage(5, this.socketStats_.get(r11));
        r11 = r11 + 1;
    L19:
        if (r10 >= this.wifiStats_.size()) goto L21;
        r8.writeMessage(6, this.wifiStats_.get(r10));
        r10 = r10 + 1;
        goto L19
    L21:
        getUnknownFields().writeTo(r8);
    }

    private AppSocketStats(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.state_ = 0;
        this.startTimestamp_ = 0;
        this.endTimestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(AppSocketStats r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static AppSocketStats parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AppSocketStats) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static AppSocketStats parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return MultiNetAccelEvent.internal_static_com_obric_cae_smartNetwork_netAccel_AppSocketStats_fieldAccessorTable.ensureFieldAccessorsInitialized(AppSocketStats.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ AppSocketStats(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static AppSocketStats parseFrom(CodedInputStream r8) {
        return (AppSocketStats) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public AppSocketStats getDefaultInstanceForType() {
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

    public static AppSocketStats parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (AppSocketStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static AppSocketStats parseFrom(InputStream r8) {
        return (AppSocketStats) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static AppSocketStats parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AppSocketStats) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static AppSocketStats parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static AppSocketStats parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static AppSocketStats parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static AppSocketStats parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
