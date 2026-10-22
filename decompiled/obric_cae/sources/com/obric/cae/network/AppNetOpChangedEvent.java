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
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class AppNetOpChangedEvent extends GeneratedMessageV3 implements AppNetOpChangedEventOrBuilder {
    private static final AppNetOpChangedEvent DEFAULT_INSTANCE = null;
    public static final int MODE_FIELD_NUMBER = 4;
    public static final int OPCODE_FIELD_NUMBER = 3;

    @Deprecated
    public static final Parser<AppNetOpChangedEvent> PARSER = null;
    public static final int PKGNAME_FIELD_NUMBER = 2;
    public static final int TIMESTAMP_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int mode_;
    private int opCode_;
    private volatile Object pkgName_;
    private long timestamp_;
    private int uid_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AppNetOpChangedEventOrBuilder {
        private int bitField0_;
        private int mode_;
        private int opCode_;
        private Object pkgName_;
        private long timestamp_;
        private int uid_;

        private Builder() {
            this.pkgName_ = "";
        }

        private void buildPartial0(AppNetOpChangedEvent r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            AppNetOpChangedEvent.access$302(r8, this.uid_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            AppNetOpChangedEvent.access$402(r8, this.pkgName_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            AppNetOpChangedEvent.access$502(r8, this.opCode_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            AppNetOpChangedEvent.access$602(r8, this.mode_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L18;
            AppNetOpChangedEvent.access$702(r8, this.timestamp_);
            r11 = r11 | 16;
        L18:
            AppNetOpChangedEvent.access$876(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_AppNetOpChangedEvent_descriptor;
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

        public Builder clearMode() {
            this.bitField0_ &= -9;
            this.mode_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearOpCode() {
            this.bitField0_ &= -5;
            this.opCode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPkgName() {
            this.pkgName_ = AppNetOpChangedEvent.getDefaultInstance().getPkgName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -17;
            this.timestamp_ = 0;
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
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_AppNetOpChangedEvent_descriptor;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public int getMode() {
            return this.mode_;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public int getOpCode() {
            return this.opCode_;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public String getPkgName() {
            Object r8 = this.pkgName_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.pkgName_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public ByteString getPkgNameBytes() {
            Object r8 = this.pkgName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.pkgName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public boolean hasMode() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public boolean hasOpCode() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public boolean hasPkgName() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
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
            if (hasUid() == true) goto L6;
            return false;
        L6:
            if (hasPkgName() == true) goto L9;
            return false;
        L9:
            if (hasOpCode() == true) goto L12;
            return false;
        L12:
            if (hasMode() == true) goto L15;
            return false;
        L15:
            if (hasTimestamp() == true) goto L17;
            return false;
        L17:
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

        public Builder setMode(int r8) {
            this.mode_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setOpCode(int r8) {
            this.opCode_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setPkgName(String r8) {
            if (r8 == null) goto L6;
            this.pkgName_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setPkgNameBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.pkgName_ = r8;
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

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
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
            this.pkgName_ = "";
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
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_AppNetOpChangedEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(AppNetOpChangedEvent.class, Builder.class);
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
        public AppNetOpChangedEvent build() {
            AppNetOpChangedEvent r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AppNetOpChangedEvent buildPartial() {
            AppNetOpChangedEvent r8 = new AppNetOpChangedEvent(this, null);
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
        public AppNetOpChangedEvent getDefaultInstanceForType() {
            return AppNetOpChangedEvent.getDefaultInstance();
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
            this.pkgName_ = "";
            this.opCode_ = 0;
            this.mode_ = 0;
            this.timestamp_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L37;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L34;
            int r12 = r8.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            if (r12 == 0) goto L26;
            if (r12 != 8) goto L10;
            this.uid_ = r8.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L10:
            if (r12 != 18) goto L12;
            this.pkgName_ = r8.readBytes();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.opCode_ = r8.readUInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L14:
            if (r12 != 32) goto L16;
            this.mode_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L16:
            if (r12 != 40) goto L18;
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 16;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L18:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L26:
            r11 = true;
            goto L4
        L27:
            th = move-exception;
            onChanged();
            throw th;
        L29:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L27
        L34:
            onChanged();
            return this;
        L37:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof AppNetOpChangedEvent) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((AppNetOpChangedEvent) r8);
        }

        public Builder mergeFrom(AppNetOpChangedEvent r8) {
            if (r8 != AppNetOpChangedEvent.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasUid() == false) goto L9;
            setUid(r8.getUid());
        L9:
            if (r8.hasPkgName() == false) goto L12;
            this.pkgName_ = AppNetOpChangedEvent.access$400(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasOpCode() == false) goto L15;
            setOpCode(r8.getOpCode());
        L15:
            if (r8.hasMode() == false) goto L18;
            setMode(r8.getMode());
        L18:
            if (r8.hasTimestamp() == false) goto L20;
            setTimestamp(r8.getTimestamp());
        L20:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new AppNetOpChangedEvent();
        PARSER = new AnonymousClass1();
    }

    private AppNetOpChangedEvent() {
        this.uid_ = 0;
        this.pkgName_ = "";
        this.opCode_ = 0;
        this.mode_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
        this.pkgName_ = "";
    }

    public static /* synthetic */ int access$302(AppNetOpChangedEvent r8, int r10) {
        r8.uid_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$400(AppNetOpChangedEvent r8) {
        return r8.pkgName_;
    }

    public static /* synthetic */ Object access$402(AppNetOpChangedEvent r8, Object r10) {
        r8.pkgName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(AppNetOpChangedEvent r8, int r10) {
        r8.opCode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(AppNetOpChangedEvent r8, int r10) {
        r8.mode_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$702(AppNetOpChangedEvent r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$876(AppNetOpChangedEvent r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static AppNetOpChangedEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetpolicyEvent.internal_static_com_obric_cae_network_AppNetOpChangedEvent_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AppNetOpChangedEvent parseDelimitedFrom(InputStream r8) {
        return (AppNetOpChangedEvent) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static AppNetOpChangedEvent parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<AppNetOpChangedEvent> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof AppNetOpChangedEvent) == false) goto L8;
        AppNetOpChangedEvent r10 = (AppNetOpChangedEvent) r8;
        if (hasUid() == r10.hasUid()) goto L13;
        return false;
    L13:
        if (hasUid() == false) goto L18;
        if (getUid() == r10.getUid()) goto L18;
        return false;
    L18:
        if (hasPkgName() == r10.hasPkgName()) goto L21;
        return false;
    L21:
        if (hasPkgName() == false) goto L26;
        if (getPkgName().equals(r10.getPkgName()) == true) goto L26;
        return false;
    L26:
        if (hasOpCode() == r10.hasOpCode()) goto L29;
        return false;
    L29:
        if (hasOpCode() == false) goto L34;
        if (getOpCode() == r10.getOpCode()) goto L34;
        return false;
    L34:
        if (hasMode() == r10.hasMode()) goto L37;
        return false;
    L37:
        if (hasMode() == false) goto L42;
        if (getMode() == r10.getMode()) goto L42;
        return false;
    L42:
        if (hasTimestamp() == r10.hasTimestamp()) goto L45;
        return false;
    L45:
        if (hasTimestamp() == false) goto L50;
        if (getTimestamp() == r10.getTimestamp()) goto L50;
        return false;
    L50:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L52;
        return false;
    L52:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public int getMode() {
        return this.mode_;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public int getOpCode() {
        return this.opCode_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AppNetOpChangedEvent> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public String getPkgName() {
        Object r8 = this.pkgName_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.pkgName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public ByteString getPkgNameBytes() {
        Object r8 = this.pkgName_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.pkgName_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeUInt32Size(1, this.uid_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + GeneratedMessage.computeStringSize(2, this.pkgName_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeUInt32Size(3, this.opCode_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt32Size(4, this.mode_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L20;
        r10 = r10 + CodedOutputStream.computeInt64Size(5, this.timestamp_);
    L20:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public int getUid() {
        return this.uid_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public boolean hasMode() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public boolean hasOpCode() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public boolean hasPkgName() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.AppNetOpChangedEventOrBuilder
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
        r10 = b.a(r10, 37, 1, 53) + getUid();
    L9:
        if (hasPkgName() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getPkgName().hashCode();
    L12:
        if (hasOpCode() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getOpCode();
    L15:
        if (hasMode() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getMode();
    L18:
        if (hasTimestamp() == false) goto L20;
        r10 = b.a(r10, 37, 5, 53) + Internal.hashLong(getTimestamp());
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
        if (r8 != 1) goto L6;
        return true;
    L6:
        if (r8 != 0) goto L9;
        return false;
    L9:
        if (hasUid() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasPkgName() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasOpCode() == true) goto L21;
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasMode() == true) goto L25;
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (hasTimestamp() == true) goto L28;
        this.memoizedIsInitialized = 0;
        return false;
    L28:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new AppNetOpChangedEvent();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeUInt32(1, this.uid_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.pkgName_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeUInt32(3, this.opCode_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt32(4, this.mode_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L17;
        r8.writeInt64(5, this.timestamp_);
    L17:
        getUnknownFields().writeTo(r8);
    }

    private AppNetOpChangedEvent(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.uid_ = 0;
        this.pkgName_ = "";
        this.opCode_ = 0;
        this.mode_ = 0;
        this.timestamp_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(AppNetOpChangedEvent r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static AppNetOpChangedEvent parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AppNetOpChangedEvent) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static AppNetOpChangedEvent parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetpolicyEvent.internal_static_com_obric_cae_network_AppNetOpChangedEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(AppNetOpChangedEvent.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ AppNetOpChangedEvent(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static AppNetOpChangedEvent parseFrom(CodedInputStream r8) {
        return (AppNetOpChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public AppNetOpChangedEvent getDefaultInstanceForType() {
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

    public static AppNetOpChangedEvent parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (AppNetOpChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static AppNetOpChangedEvent parseFrom(InputStream r8) {
        return (AppNetOpChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static AppNetOpChangedEvent parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (AppNetOpChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static AppNetOpChangedEvent parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static AppNetOpChangedEvent parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static AppNetOpChangedEvent parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static AppNetOpChangedEvent parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
