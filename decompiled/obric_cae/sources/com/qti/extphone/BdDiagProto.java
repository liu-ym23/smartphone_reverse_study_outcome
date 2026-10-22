package com.qti.extphone;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class BdDiagProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_callInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_callInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_dataInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_dataInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_diagLogInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_diagLogInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_diagLogInfoist_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_diagLogInfoist_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_l2DataList_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_l2DataList_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_l3DataList_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_l3DataList_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_networkInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_networkInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_powerInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_powerInfo_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_rfInfo_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_rfInfo_fieldAccessorTable = null;

    /* JADX INFO: renamed from: com.qti.extphone.BdDiagProto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class callInfo extends GeneratedMessageV3 implements callInfoOrBuilder {
        private static final callInfo DEFAULT_INSTANCE = null;
        public static final int ISCHANGED_FIELD_NUMBER = 1;

        @Deprecated
        public static final Parser<callInfo> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean isChanged_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements callInfoOrBuilder {
            private int bitField0_;
            private boolean isChanged_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(callInfo r8) {
                int r10 = 1;
                if ((this.bitField0_ & 1) == 0) goto L5;
                callInfo.access$8502(r8, this.isChanged_);
            L6:
                callInfo.access$8676(r8, r10);
                return;
            L5:
                r10 = 0;
                goto L6
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$8000();
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

            public Builder clearIsChanged() {
                this.bitField0_ &= -2;
                this.isChanged_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
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
                return BdDiagProto.access$8000();
            }

            @Override // com.qti.extphone.BdDiagProto.callInfoOrBuilder
            public boolean getIsChanged() {
                return this.isChanged_;
            }

            @Override // com.qti.extphone.BdDiagProto.callInfoOrBuilder
            public boolean hasIsChanged() {
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
                if (hasIsChanged() == true) goto L6;
                return false;
            L6:
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

            public Builder setIsChanged(boolean r8) {
                this.isChanged_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
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
                return BdDiagProto.access$8100().ensureFieldAccessorsInitialized(callInfo.class, Builder.class);
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
            public callInfo build() {
                callInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public callInfo buildPartial() {
                callInfo r8 = new callInfo(this, null);
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
            public callInfo getDefaultInstanceForType() {
                return callInfo.getDefaultInstance();
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
                this.isChanged_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L25;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L22;
                int r12 = r8.readTag();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                if (r12 == 0) goto L14;
                if (r12 != 8) goto L10;
                this.isChanged_ = r8.readBool();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                this.bitField0_ |= 1;     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                goto L4
            L10:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L14:
                r11 = true;
                goto L4
            L17:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                onChanged();
                throw th;
            L22:
                onChanged();
                return this;
            L25:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof callInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((callInfo) r8);
            }

            public Builder mergeFrom(callInfo r8) {
                if (r8 != callInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasIsChanged() == false) goto L8;
                setIsChanged(r8.getIsChanged());
            L8:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new callInfo();
            PARSER = new AnonymousClass1();
        }

        private callInfo() {
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ boolean access$8502(callInfo r8, boolean r10) {
            r8.isChanged_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$8676(callInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static callInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$8000();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static callInfo parseDelimitedFrom(InputStream r8) {
            return (callInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static callInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<callInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof callInfo) == false) goto L8;
            callInfo r10 = (callInfo) r8;
            if (hasIsChanged() == r10.hasIsChanged()) goto L13;
            return false;
        L13:
            if (hasIsChanged() == false) goto L18;
            if (getIsChanged() == r10.getIsChanged()) goto L18;
            return false;
        L18:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L20;
            return false;
        L20:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.qti.extphone.BdDiagProto.callInfoOrBuilder
        public boolean getIsChanged() {
            return this.isChanged_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<callInfo> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeBoolSize(1, this.isChanged_);
        L8:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.callInfoOrBuilder
        public boolean hasIsChanged() {
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
            if (hasIsChanged() == false) goto L8;
            r10 = b.a(r10, 37, 1, 53) + Internal.hashBoolean(getIsChanged());
        L8:
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
            if (hasIsChanged() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new callInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L5;
            r8.writeBool(1, this.isChanged_);
        L5:
            getUnknownFields().writeTo(r8);
        }

        private callInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(callInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static callInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (callInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static callInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$8100().ensureFieldAccessorsInitialized(callInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ callInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static callInfo parseFrom(CodedInputStream r8) {
            return (callInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public callInfo getDefaultInstanceForType() {
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

        public static callInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (callInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static callInfo parseFrom(InputStream r8) {
            return (callInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static callInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (callInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static callInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static callInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static callInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static callInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface callInfoOrBuilder extends MessageOrBuilder {
        boolean getIsChanged();

        boolean hasIsChanged();
    }

    public static final class dataInfo extends GeneratedMessageV3 implements dataInfoOrBuilder {
        private static final dataInfo DEFAULT_INSTANCE = null;
        public static final int ISCHANGED_FIELD_NUMBER = 1;
        public static final int L2DATA_FIELD_NUMBER = 3;
        public static final int L3DATA_FIELD_NUMBER = 2;

        @Deprecated
        public static final Parser<dataInfo> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean isChanged_;
        private l2DataList l2Data_;
        private l3DataList l3Data_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements dataInfoOrBuilder {
            private int bitField0_;
            private boolean isChanged_;
            private SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> l2DataBuilder_;
            private l2DataList l2Data_;
            private SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> l3DataBuilder_;
            private l3DataList l3Data_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void buildPartial0(dataInfo r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                dataInfo.access$2802(r8, this.isChanged_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L14;
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r12 = this.l3DataBuilder_;
                if (r12 != null) goto L11;
                l3DataList r13 = this.l3Data_;
            L12:
                dataInfo.access$2902(r8, r13);
                r11 = r11 | 2;
                goto L14
            L11:
                r13 = (l3DataList) r12.build();
            L14:
                if ((r10 & 4) == 0) goto L20;
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r14 = this.l2DataBuilder_;
                if (r14 != null) goto L18;
                l2DataList r15 = this.l2Data_;
            L19:
                dataInfo.access$3002(r8, r15);
                r11 = r11 | 4;
                goto L20
            L18:
                r15 = (l2DataList) r14.build();
            L20:
                dataInfo.access$3176(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$2200();
            }

            private SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> getL2DataFieldBuilder() {
                if (this.l2DataBuilder_ != null) goto L6;
                this.l2DataBuilder_ = new SingleFieldBuilderV3(getL2Data(), getParentForChildren(), isClean());
                this.l2Data_ = null;
            L6:
                return this.l2DataBuilder_;
            }

            private SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> getL3DataFieldBuilder() {
                if (this.l3DataBuilder_ != null) goto L6;
                this.l3DataBuilder_ = new SingleFieldBuilderV3(getL3Data(), getParentForChildren(), isClean());
                this.l3Data_ = null;
            L6:
                return this.l3DataBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (dataInfo.access$2600() == false) goto L6;
                getL3DataFieldBuilder();
                getL2DataFieldBuilder();
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
                return clearField(r8);
            }

            public Builder clearIsChanged() {
                this.bitField0_ &= -2;
                this.isChanged_ = false;
                onChanged();
                return this;
            }

            public Builder clearL2Data() {
                this.bitField0_ &= -5;
                this.l2Data_ = null;
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r8 = this.l2DataBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.l2DataBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            public Builder clearL3Data() {
                this.bitField0_ &= -3;
                this.l3Data_ = null;
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r8 = this.l3DataBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.l3DataBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
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
                return BdDiagProto.access$2200();
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public boolean getIsChanged() {
                return this.isChanged_;
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public l2DataList getL2Data() {
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r8 = this.l2DataBuilder_;
                if (r8 != null) goto L9;
                l2DataList r10 = this.l2Data_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return l2DataList.getDefaultInstance();
            L9:
                return (l2DataList) r8.getMessage();
            }

            public l2DataList.Builder getL2DataBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (l2DataList.Builder) getL2DataFieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public l2DataListOrBuilder getL2DataOrBuilder() {
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r8 = this.l2DataBuilder_;
                if (r8 != null) goto L5;
                l2DataList r10 = this.l2Data_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return l2DataList.getDefaultInstance();
            L5:
                return (l2DataListOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public l3DataList getL3Data() {
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r8 = this.l3DataBuilder_;
                if (r8 != null) goto L9;
                l3DataList r10 = this.l3Data_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return l3DataList.getDefaultInstance();
            L9:
                return (l3DataList) r8.getMessage();
            }

            public l3DataList.Builder getL3DataBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return (l3DataList.Builder) getL3DataFieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public l3DataListOrBuilder getL3DataOrBuilder() {
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r8 = this.l3DataBuilder_;
                if (r8 != null) goto L5;
                l3DataList r10 = this.l3Data_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return l3DataList.getDefaultInstance();
            L5:
                return (l3DataListOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public boolean hasIsChanged() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public boolean hasL2Data() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
            public boolean hasL3Data() {
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
                if (hasIsChanged() == true) goto L6;
                return false;
            L6:
                if (hasL3Data() == true) goto L9;
                return false;
            L9:
                if (hasL2Data() == true) goto L12;
                return false;
            L12:
                if (getL3Data().isInitialized() == true) goto L15;
                return false;
            L15:
                if (getL2Data().isInitialized() == true) goto L17;
                return false;
            L17:
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public Builder mergeL2Data(l2DataList r8) {
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r10 = this.l2DataBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 4;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 4) == 0) goto L11;
                l2DataList r11 = this.l2Data_;
                if (r11 == null) goto L11;
                if (r11 == l2DataList.getDefaultInstance()) goto L11;
                getL2DataBuilder().mergeFrom(r8);
            L11:
                this.l2Data_ = r8;
                goto L13
            }

            public Builder mergeL3Data(l3DataList r8) {
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r10 = this.l3DataBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 2;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 2) == 0) goto L11;
                l3DataList r11 = this.l3Data_;
                if (r11 == null) goto L11;
                if (r11 == l3DataList.getDefaultInstance()) goto L11;
                getL3DataBuilder().mergeFrom(r8);
            L11:
                this.l3Data_ = r8;
                goto L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
                return mergeUnknownFields(r8);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
                return setField(r8, r10);
            }

            public Builder setIsChanged(boolean r8) {
                this.isChanged_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setL2Data(l2DataList.Builder r8) {
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r10 = this.l2DataBuilder_;
                l2DataList r11 = r8.build();
                if (r10 != null) goto L5;
                this.l2Data_ = r11;
            L6:
                this.bitField0_ |= 4;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
                goto L6
            }

            public Builder setL3Data(l3DataList.Builder r8) {
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r10 = this.l3DataBuilder_;
                l3DataList r11 = r8.build();
                if (r10 != null) goto L5;
                this.l3Data_ = r11;
            L6:
                this.bitField0_ |= 2;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
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
                return BdDiagProto.access$2300().ensureFieldAccessorsInitialized(dataInfo.class, Builder.class);
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

            public Builder setL2Data(l2DataList r8) {
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r10 = this.l2DataBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.l2Data_ = r8;
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

            public Builder setL3Data(l3DataList r8) {
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r10 = this.l3DataBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.l3Data_ = r8;
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
            public dataInfo build() {
                dataInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public dataInfo buildPartial() {
                dataInfo r8 = new dataInfo(this, null);
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
            public dataInfo getDefaultInstanceForType() {
                return dataInfo.getDefaultInstance();
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
                this.isChanged_ = false;
                this.l3Data_ = null;
                SingleFieldBuilderV3<l3DataList, l3DataList.Builder, l3DataListOrBuilder> r8 = this.l3DataBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.l3DataBuilder_ = null;
            L5:
                this.l2Data_ = null;
                SingleFieldBuilderV3<l2DataList, l2DataList.Builder, l2DataListOrBuilder> r10 = this.l2DataBuilder_;
                if (r10 == null) goto L8;
                r10.dispose();
                this.l2DataBuilder_ = null;
            L8:
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
                this.isChanged_ = r8.readBool();     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                this.bitField0_ |= 1;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                goto L4
            L10:
                if (r12 != 18) goto L12;
                r8.readMessage(getL3DataFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                this.bitField0_ |= 2;     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
                goto L4
            L12:
                if (r12 != 26) goto L14;
                r8.readMessage(getL2DataFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L21 InvalidProtocolBufferException -> L23
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
                if ((r8 instanceof dataInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((dataInfo) r8);
            }

            public Builder mergeFrom(dataInfo r8) {
                if (r8 != dataInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasIsChanged() == false) goto L9;
                setIsChanged(r8.getIsChanged());
            L9:
                if (r8.hasL3Data() == false) goto L12;
                mergeL3Data(r8.getL3Data());
            L12:
                if (r8.hasL2Data() == false) goto L14;
                mergeL2Data(r8.getL2Data());
            L14:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new dataInfo();
            PARSER = new AnonymousClass1();
        }

        private dataInfo() {
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ boolean access$2600() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$2802(dataInfo r8, boolean r10) {
            r8.isChanged_ = r10;
            return r10;
        }

        public static /* synthetic */ l3DataList access$2902(dataInfo r8, l3DataList r10) {
            r8.l3Data_ = r10;
            return r10;
        }

        public static /* synthetic */ l2DataList access$3002(dataInfo r8, l2DataList r10) {
            r8.l2Data_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$3176(dataInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static dataInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$2200();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static dataInfo parseDelimitedFrom(InputStream r8) {
            return (dataInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static dataInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<dataInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof dataInfo) == false) goto L8;
            dataInfo r10 = (dataInfo) r8;
            if (hasIsChanged() == r10.hasIsChanged()) goto L13;
            return false;
        L13:
            if (hasIsChanged() == false) goto L18;
            if (getIsChanged() == r10.getIsChanged()) goto L18;
            return false;
        L18:
            if (hasL3Data() == r10.hasL3Data()) goto L21;
            return false;
        L21:
            if (hasL3Data() == false) goto L26;
            if (getL3Data().equals(r10.getL3Data()) == true) goto L26;
            return false;
        L26:
            if (hasL2Data() == r10.hasL2Data()) goto L29;
            return false;
        L29:
            if (hasL2Data() == false) goto L34;
            if (getL2Data().equals(r10.getL2Data()) == true) goto L34;
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

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public boolean getIsChanged() {
            return this.isChanged_;
        }

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public l2DataList getL2Data() {
            l2DataList r8 = this.l2Data_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return l2DataList.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public l2DataListOrBuilder getL2DataOrBuilder() {
            l2DataList r8 = this.l2Data_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return l2DataList.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public l3DataList getL3Data() {
            l3DataList r8 = this.l3Data_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return l3DataList.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public l3DataListOrBuilder getL3DataOrBuilder() {
            l3DataList r8 = this.l3Data_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return l3DataList.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<dataInfo> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeBoolSize(1, this.isChanged_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeMessageSize(2, getL3Data());
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            r10 = r10 + CodedOutputStream.computeMessageSize(3, getL2Data());
        L14:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public boolean hasIsChanged() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public boolean hasL2Data() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.dataInfoOrBuilder
        public boolean hasL3Data() {
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
            if (hasIsChanged() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + Internal.hashBoolean(getIsChanged());
        L9:
            if (hasL3Data() == false) goto L12;
            r10 = b.a(r10, 37, 2, 53) + getL3Data().hashCode();
        L12:
            if (hasL2Data() == false) goto L14;
            r10 = b.a(r10, 37, 3, 53) + getL2Data().hashCode();
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
            if (r8 != 1) goto L6;
            return true;
        L6:
            if (r8 != 0) goto L9;
            return false;
        L9:
            if (hasIsChanged() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasL3Data() == true) goto L17;
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (hasL2Data() == true) goto L21;
            this.memoizedIsInitialized = 0;
            return false;
        L21:
            if (getL3Data().isInitialized() == true) goto L25;
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (getL2Data().isInitialized() == true) goto L28;
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
            return new dataInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeBool(1, this.isChanged_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeMessage(2, getL3Data());
        L9:
            if ((this.bitField0_ & 4) == 0) goto L11;
            r8.writeMessage(3, getL2Data());
        L11:
            getUnknownFields().writeTo(r8);
        }

        private dataInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(dataInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static dataInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (dataInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static dataInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$2300().ensureFieldAccessorsInitialized(dataInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ dataInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static dataInfo parseFrom(CodedInputStream r8) {
            return (dataInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public dataInfo getDefaultInstanceForType() {
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

        public static dataInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (dataInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static dataInfo parseFrom(InputStream r8) {
            return (dataInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static dataInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (dataInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static dataInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static dataInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static dataInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static dataInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface dataInfoOrBuilder extends MessageOrBuilder {
        boolean getIsChanged();

        l2DataList getL2Data();

        l2DataListOrBuilder getL2DataOrBuilder();

        l3DataList getL3Data();

        l3DataListOrBuilder getL3DataOrBuilder();

        boolean hasIsChanged();

        boolean hasL2Data();

        boolean hasL3Data();
    }

    public static final class diagLogInfo extends GeneratedMessageV3 implements diagLogInfoOrBuilder {
        public static final int CALL_FIELD_NUMBER = 6;
        public static final int DATAKPI_FIELD_NUMBER = 2;
        private static final diagLogInfo DEFAULT_INSTANCE = null;
        public static final int NETWORK_FIELD_NUMBER = 3;

        @Deprecated
        public static final Parser<diagLogInfo> PARSER = null;
        public static final int POWER_FIELD_NUMBER = 5;
        public static final int RF_FIELD_NUMBER = 4;
        public static final int SLOTID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private callInfo call_;
        private dataInfo dataKpi_;
        private byte memoizedIsInitialized;
        private networkInfo network_;
        private powerInfo power_;
        private rfInfo rf_;
        private int slotId_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements diagLogInfoOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> callBuilder_;
            private callInfo call_;
            private SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> dataKpiBuilder_;
            private dataInfo dataKpi_;
            private SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> networkBuilder_;
            private networkInfo network_;
            private SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> powerBuilder_;
            private powerInfo power_;
            private SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> rfBuilder_;
            private rfInfo rf_;
            private int slotId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void buildPartial0(diagLogInfo r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                diagLogInfo.access$1502(r8, this.slotId_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L14;
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r12 = this.dataKpiBuilder_;
                if (r12 != null) goto L11;
                dataInfo r13 = this.dataKpi_;
            L12:
                diagLogInfo.access$1602(r8, r13);
                r11 = r11 | 2;
                goto L14
            L11:
                r13 = (dataInfo) r12.build();
            L14:
                if ((r10 & 4) == 0) goto L21;
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r14 = this.networkBuilder_;
                if (r14 != null) goto L18;
                networkInfo r15 = this.network_;
            L19:
                diagLogInfo.access$1702(r8, r15);
                r11 = r11 | 4;
                goto L21
            L18:
                r15 = (networkInfo) r14.build();
            L21:
                if ((r10 & 8) == 0) goto L28;
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r16 = this.rfBuilder_;
                if (r16 != null) goto L25;
                rfInfo r17 = this.rf_;
            L26:
                diagLogInfo.access$1802(r8, r17);
                r11 = r11 | 8;
                goto L28
            L25:
                r17 = (rfInfo) r16.build();
            L28:
                if ((r10 & 16) == 0) goto L35;
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r18 = this.powerBuilder_;
                if (r18 != null) goto L32;
                powerInfo r19 = this.power_;
            L33:
                diagLogInfo.access$1902(r8, r19);
                r11 = r11 | 16;
                goto L35
            L32:
                r19 = (powerInfo) r18.build();
            L35:
                if ((r10 & 32) == 0) goto L41;
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r20 = this.callBuilder_;
                if (r20 != null) goto L39;
                callInfo r21 = this.call_;
            L40:
                diagLogInfo.access$2002(r8, r21);
                r11 = r11 | 32;
                goto L41
            L39:
                r21 = (callInfo) r20.build();
            L41:
                diagLogInfo.access$2176(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            private SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> getCallFieldBuilder() {
                if (this.callBuilder_ != null) goto L6;
                this.callBuilder_ = new SingleFieldBuilderV3(getCall(), getParentForChildren(), isClean());
                this.call_ = null;
            L6:
                return this.callBuilder_;
            }

            private SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> getDataKpiFieldBuilder() {
                if (this.dataKpiBuilder_ != null) goto L6;
                this.dataKpiBuilder_ = new SingleFieldBuilderV3(getDataKpi(), getParentForChildren(), isClean());
                this.dataKpi_ = null;
            L6:
                return this.dataKpiBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$900();
            }

            private SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> getNetworkFieldBuilder() {
                if (this.networkBuilder_ != null) goto L6;
                this.networkBuilder_ = new SingleFieldBuilderV3(getNetwork(), getParentForChildren(), isClean());
                this.network_ = null;
            L6:
                return this.networkBuilder_;
            }

            private SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> getPowerFieldBuilder() {
                if (this.powerBuilder_ != null) goto L6;
                this.powerBuilder_ = new SingleFieldBuilderV3(getPower(), getParentForChildren(), isClean());
                this.power_ = null;
            L6:
                return this.powerBuilder_;
            }

            private SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> getRfFieldBuilder() {
                if (this.rfBuilder_ != null) goto L6;
                this.rfBuilder_ = new SingleFieldBuilderV3(getRf(), getParentForChildren(), isClean());
                this.rf_ = null;
            L6:
                return this.rfBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (diagLogInfo.access$1300() == false) goto L6;
                getDataKpiFieldBuilder();
                getNetworkFieldBuilder();
                getRfFieldBuilder();
                getPowerFieldBuilder();
                getCallFieldBuilder();
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

            public Builder clearCall() {
                this.bitField0_ &= -33;
                this.call_ = null;
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r8 = this.callBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.callBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            public Builder clearDataKpi() {
                this.bitField0_ &= -3;
                this.dataKpi_ = null;
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r8 = this.dataKpiBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.dataKpiBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
                return clearField(r8);
            }

            public Builder clearNetwork() {
                this.bitField0_ &= -5;
                this.network_ = null;
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r8 = this.networkBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.networkBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
            }

            public Builder clearPower() {
                this.bitField0_ &= -17;
                this.power_ = null;
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r8 = this.powerBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.powerBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            public Builder clearRf() {
                this.bitField0_ &= -9;
                this.rf_ = null;
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r8 = this.rfBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.rfBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            public Builder clearSlotId() {
                this.bitField0_ &= -2;
                this.slotId_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return clone();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public callInfo getCall() {
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r8 = this.callBuilder_;
                if (r8 != null) goto L9;
                callInfo r10 = this.call_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return callInfo.getDefaultInstance();
            L9:
                return (callInfo) r8.getMessage();
            }

            public callInfo.Builder getCallBuilder() {
                this.bitField0_ |= 32;
                onChanged();
                return (callInfo.Builder) getCallFieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public callInfoOrBuilder getCallOrBuilder() {
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r8 = this.callBuilder_;
                if (r8 != null) goto L5;
                callInfo r10 = this.call_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return callInfo.getDefaultInstance();
            L5:
                return (callInfoOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public dataInfo getDataKpi() {
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r8 = this.dataKpiBuilder_;
                if (r8 != null) goto L9;
                dataInfo r10 = this.dataKpi_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return dataInfo.getDefaultInstance();
            L9:
                return (dataInfo) r8.getMessage();
            }

            public dataInfo.Builder getDataKpiBuilder() {
                this.bitField0_ |= 2;
                onChanged();
                return (dataInfo.Builder) getDataKpiFieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public dataInfoOrBuilder getDataKpiOrBuilder() {
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r8 = this.dataKpiBuilder_;
                if (r8 != null) goto L5;
                dataInfo r10 = this.dataKpi_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return dataInfo.getDefaultInstance();
            L5:
                return (dataInfoOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BdDiagProto.access$900();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public networkInfo getNetwork() {
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r8 = this.networkBuilder_;
                if (r8 != null) goto L9;
                networkInfo r10 = this.network_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return networkInfo.getDefaultInstance();
            L9:
                return (networkInfo) r8.getMessage();
            }

            public networkInfo.Builder getNetworkBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (networkInfo.Builder) getNetworkFieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public networkInfoOrBuilder getNetworkOrBuilder() {
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r8 = this.networkBuilder_;
                if (r8 != null) goto L5;
                networkInfo r10 = this.network_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return networkInfo.getDefaultInstance();
            L5:
                return (networkInfoOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public powerInfo getPower() {
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r8 = this.powerBuilder_;
                if (r8 != null) goto L9;
                powerInfo r10 = this.power_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return powerInfo.getDefaultInstance();
            L9:
                return (powerInfo) r8.getMessage();
            }

            public powerInfo.Builder getPowerBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return (powerInfo.Builder) getPowerFieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public powerInfoOrBuilder getPowerOrBuilder() {
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r8 = this.powerBuilder_;
                if (r8 != null) goto L5;
                powerInfo r10 = this.power_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return powerInfo.getDefaultInstance();
            L5:
                return (powerInfoOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public rfInfo getRf() {
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r8 = this.rfBuilder_;
                if (r8 != null) goto L9;
                rfInfo r10 = this.rf_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return rfInfo.getDefaultInstance();
            L9:
                return (rfInfo) r8.getMessage();
            }

            public rfInfo.Builder getRfBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return (rfInfo.Builder) getRfFieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public rfInfoOrBuilder getRfOrBuilder() {
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r8 = this.rfBuilder_;
                if (r8 != null) goto L5;
                rfInfo r10 = this.rf_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return rfInfo.getDefaultInstance();
            L5:
                return (rfInfoOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public int getSlotId() {
                return this.slotId_;
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public boolean hasCall() {
                if ((this.bitField0_ & 32) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public boolean hasDataKpi() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public boolean hasNetwork() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public boolean hasPower() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public boolean hasRf() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
            public boolean hasSlotId() {
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
                if (hasSlotId() == true) goto L6;
                return false;
            L6:
                if (hasDataKpi() == false) goto L11;
                if (getDataKpi().isInitialized() == true) goto L11;
                return false;
            L11:
                if (hasNetwork() == false) goto L16;
                if (getNetwork().isInitialized() == true) goto L16;
                return false;
            L16:
                if (hasRf() == false) goto L21;
                if (getRf().isInitialized() == true) goto L21;
                return false;
            L21:
                if (hasPower() == false) goto L26;
                if (getPower().isInitialized() == true) goto L26;
                return false;
            L26:
                if (hasCall() == true) goto L28;
                return true;
            L28:
                if (getCall().isInitialized() == true) goto L32;
                return false;
            L32:
                return true;
            }

            public Builder mergeCall(callInfo r8) {
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r10 = this.callBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 32;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 32) == 0) goto L11;
                callInfo r11 = this.call_;
                if (r11 == null) goto L11;
                if (r11 == callInfo.getDefaultInstance()) goto L11;
                getCallBuilder().mergeFrom(r8);
            L11:
                this.call_ = r8;
                goto L13
            }

            public Builder mergeDataKpi(dataInfo r8) {
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r10 = this.dataKpiBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 2;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 2) == 0) goto L11;
                dataInfo r11 = this.dataKpi_;
                if (r11 == null) goto L11;
                if (r11 == dataInfo.getDefaultInstance()) goto L11;
                getDataKpiBuilder().mergeFrom(r8);
            L11:
                this.dataKpi_ = r8;
                goto L13
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public Builder mergeNetwork(networkInfo r8) {
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r10 = this.networkBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 4;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 4) == 0) goto L11;
                networkInfo r11 = this.network_;
                if (r11 == null) goto L11;
                if (r11 == networkInfo.getDefaultInstance()) goto L11;
                getNetworkBuilder().mergeFrom(r8);
            L11:
                this.network_ = r8;
                goto L13
            }

            public Builder mergePower(powerInfo r8) {
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r10 = this.powerBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 16) == 0) goto L11;
                powerInfo r11 = this.power_;
                if (r11 == null) goto L11;
                if (r11 == powerInfo.getDefaultInstance()) goto L11;
                getPowerBuilder().mergeFrom(r8);
            L11:
                this.power_ = r8;
                goto L13
            }

            public Builder mergeRf(rfInfo r8) {
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r10 = this.rfBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 8;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 8) == 0) goto L11;
                rfInfo r11 = this.rf_;
                if (r11 == null) goto L11;
                if (r11 == rfInfo.getDefaultInstance()) goto L11;
                getRfBuilder().mergeFrom(r8);
            L11:
                this.rf_ = r8;
                goto L13
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
                return mergeUnknownFields(r8);
            }

            public Builder setCall(callInfo.Builder r8) {
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r10 = this.callBuilder_;
                callInfo r11 = r8.build();
                if (r10 != null) goto L5;
                this.call_ = r11;
            L6:
                this.bitField0_ |= 32;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
                goto L6
            }

            public Builder setDataKpi(dataInfo.Builder r8) {
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r10 = this.dataKpiBuilder_;
                dataInfo r11 = r8.build();
                if (r10 != null) goto L5;
                this.dataKpi_ = r11;
            L6:
                this.bitField0_ |= 2;
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

            public Builder setNetwork(networkInfo.Builder r8) {
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r10 = this.networkBuilder_;
                networkInfo r11 = r8.build();
                if (r10 != null) goto L5;
                this.network_ = r11;
            L6:
                this.bitField0_ |= 4;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
                goto L6
            }

            public Builder setPower(powerInfo.Builder r8) {
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r10 = this.powerBuilder_;
                powerInfo r11 = r8.build();
                if (r10 != null) goto L5;
                this.power_ = r11;
            L6:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
                goto L6
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
            }

            public Builder setRf(rfInfo.Builder r8) {
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r10 = this.rfBuilder_;
                rfInfo r11 = r8.build();
                if (r10 != null) goto L5;
                this.rf_ = r11;
            L6:
                this.bitField0_ |= 8;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
                goto L6
            }

            public Builder setSlotId(int r8) {
                this.slotId_ = r8;
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
                return BdDiagProto.access$1000().ensureFieldAccessorsInitialized(diagLogInfo.class, Builder.class);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
                return mergeUnknownFields(r8);
            }

            public Builder setCall(callInfo r8) {
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r10 = this.callBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.call_ = r8;
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

            public Builder setDataKpi(dataInfo r8) {
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r10 = this.dataKpiBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.dataKpi_ = r8;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
                return setField(r8, r10);
            }

            public Builder setNetwork(networkInfo r8) {
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r10 = this.networkBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.network_ = r8;
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

            public Builder setPower(powerInfo r8) {
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r10 = this.powerBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.power_ = r8;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
            }

            public Builder setRf(rfInfo r8) {
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r10 = this.rfBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.rf_ = r8;
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
            public diagLogInfo build() {
                diagLogInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public diagLogInfo buildPartial() {
                diagLogInfo r8 = new diagLogInfo(this, null);
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
            public diagLogInfo getDefaultInstanceForType() {
                return diagLogInfo.getDefaultInstance();
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
                this.slotId_ = 0;
                this.dataKpi_ = null;
                SingleFieldBuilderV3<dataInfo, dataInfo.Builder, dataInfoOrBuilder> r8 = this.dataKpiBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.dataKpiBuilder_ = null;
            L5:
                this.network_ = null;
                SingleFieldBuilderV3<networkInfo, networkInfo.Builder, networkInfoOrBuilder> r10 = this.networkBuilder_;
                if (r10 == null) goto L8;
                r10.dispose();
                this.networkBuilder_ = null;
            L8:
                this.rf_ = null;
                SingleFieldBuilderV3<rfInfo, rfInfo.Builder, rfInfoOrBuilder> r11 = this.rfBuilder_;
                if (r11 == null) goto L11;
                r11.dispose();
                this.rfBuilder_ = null;
            L11:
                this.power_ = null;
                SingleFieldBuilderV3<powerInfo, powerInfo.Builder, powerInfoOrBuilder> r12 = this.powerBuilder_;
                if (r12 == null) goto L14;
                r12.dispose();
                this.powerBuilder_ = null;
            L14:
                this.call_ = null;
                SingleFieldBuilderV3<callInfo, callInfo.Builder, callInfoOrBuilder> r13 = this.callBuilder_;
                if (r13 == null) goto L17;
                r13.dispose();
                this.callBuilder_ = null;
            L17:
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
                this.slotId_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 1;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L10:
                if (r12 != 18) goto L12;
                r8.readMessage(getDataKpiFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L12:
                if (r12 != 26) goto L14;
                r8.readMessage(getNetworkFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 4;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L14:
                if (r12 != 34) goto L16;
                r8.readMessage(getRfFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 8;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L16:
                if (r12 != 42) goto L18;
                r8.readMessage(getPowerFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 16;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L18:
                if (r12 != 50) goto L20;
                r8.readMessage(getCallFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 32;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L20:
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
                if ((r8 instanceof diagLogInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((diagLogInfo) r8);
            }

            public Builder mergeFrom(diagLogInfo r8) {
                if (r8 != diagLogInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasSlotId() == false) goto L9;
                setSlotId(r8.getSlotId());
            L9:
                if (r8.hasDataKpi() == false) goto L12;
                mergeDataKpi(r8.getDataKpi());
            L12:
                if (r8.hasNetwork() == false) goto L15;
                mergeNetwork(r8.getNetwork());
            L15:
                if (r8.hasRf() == false) goto L18;
                mergeRf(r8.getRf());
            L18:
                if (r8.hasPower() == false) goto L21;
                mergePower(r8.getPower());
            L21:
                if (r8.hasCall() == false) goto L23;
                mergeCall(r8.getCall());
            L23:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new diagLogInfo();
            PARSER = new AnonymousClass1();
        }

        private diagLogInfo() {
            this.slotId_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ boolean access$1300() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ int access$1502(diagLogInfo r8, int r10) {
            r8.slotId_ = r10;
            return r10;
        }

        public static /* synthetic */ dataInfo access$1602(diagLogInfo r8, dataInfo r10) {
            r8.dataKpi_ = r10;
            return r10;
        }

        public static /* synthetic */ networkInfo access$1702(diagLogInfo r8, networkInfo r10) {
            r8.network_ = r10;
            return r10;
        }

        public static /* synthetic */ rfInfo access$1802(diagLogInfo r8, rfInfo r10) {
            r8.rf_ = r10;
            return r10;
        }

        public static /* synthetic */ powerInfo access$1902(diagLogInfo r8, powerInfo r10) {
            r8.power_ = r10;
            return r10;
        }

        public static /* synthetic */ callInfo access$2002(diagLogInfo r8, callInfo r10) {
            r8.call_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2176(diagLogInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static diagLogInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$900();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static diagLogInfo parseDelimitedFrom(InputStream r8) {
            return (diagLogInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static diagLogInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<diagLogInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof diagLogInfo) == false) goto L8;
            diagLogInfo r10 = (diagLogInfo) r8;
            if (hasSlotId() == r10.hasSlotId()) goto L13;
            return false;
        L13:
            if (hasSlotId() == false) goto L18;
            if (getSlotId() == r10.getSlotId()) goto L18;
            return false;
        L18:
            if (hasDataKpi() == r10.hasDataKpi()) goto L21;
            return false;
        L21:
            if (hasDataKpi() == false) goto L26;
            if (getDataKpi().equals(r10.getDataKpi()) == true) goto L26;
            return false;
        L26:
            if (hasNetwork() == r10.hasNetwork()) goto L29;
            return false;
        L29:
            if (hasNetwork() == false) goto L34;
            if (getNetwork().equals(r10.getNetwork()) == true) goto L34;
            return false;
        L34:
            if (hasRf() == r10.hasRf()) goto L37;
            return false;
        L37:
            if (hasRf() == false) goto L42;
            if (getRf().equals(r10.getRf()) == true) goto L42;
            return false;
        L42:
            if (hasPower() == r10.hasPower()) goto L45;
            return false;
        L45:
            if (hasPower() == false) goto L50;
            if (getPower().equals(r10.getPower()) == true) goto L50;
            return false;
        L50:
            if (hasCall() == r10.hasCall()) goto L53;
            return false;
        L53:
            if (hasCall() == false) goto L58;
            if (getCall().equals(r10.getCall()) == true) goto L58;
            return false;
        L58:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L60;
            return false;
        L60:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public callInfo getCall() {
            callInfo r8 = this.call_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return callInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public callInfoOrBuilder getCallOrBuilder() {
            callInfo r8 = this.call_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return callInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public dataInfo getDataKpi() {
            dataInfo r8 = this.dataKpi_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return dataInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public dataInfoOrBuilder getDataKpiOrBuilder() {
            dataInfo r8 = this.dataKpi_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return dataInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public networkInfo getNetwork() {
            networkInfo r8 = this.network_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return networkInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public networkInfoOrBuilder getNetworkOrBuilder() {
            networkInfo r8 = this.network_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return networkInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<diagLogInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public powerInfo getPower() {
            powerInfo r8 = this.power_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return powerInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public powerInfoOrBuilder getPowerOrBuilder() {
            powerInfo r8 = this.power_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return powerInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public rfInfo getRf() {
            rfInfo r8 = this.rf_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return rfInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public rfInfoOrBuilder getRfOrBuilder() {
            rfInfo r8 = this.rf_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return rfInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r8 = this.memoizedSize;
            if (r8 == (-1)) goto L5;
            return r8;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) == 0) goto L9;
            r10 = 0 + CodedOutputStream.computeInt32Size(1, this.slotId_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeMessageSize(2, getDataKpi());
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + CodedOutputStream.computeMessageSize(3, getNetwork());
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r10 = r10 + CodedOutputStream.computeMessageSize(4, getRf());
        L18:
            if ((this.bitField0_ & 16) == 0) goto L21;
            r10 = r10 + CodedOutputStream.computeMessageSize(5, getPower());
        L21:
            if ((this.bitField0_ & 32) == 0) goto L23;
            r10 = r10 + CodedOutputStream.computeMessageSize(6, getCall());
        L23:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public int getSlotId() {
            return this.slotId_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public boolean hasCall() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public boolean hasDataKpi() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public boolean hasNetwork() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public boolean hasPower() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public boolean hasRf() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoOrBuilder
        public boolean hasSlotId() {
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
            if (hasSlotId() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getSlotId();
        L9:
            if (hasDataKpi() == false) goto L12;
            r10 = b.a(r10, 37, 2, 53) + getDataKpi().hashCode();
        L12:
            if (hasNetwork() == false) goto L15;
            r10 = b.a(r10, 37, 3, 53) + getNetwork().hashCode();
        L15:
            if (hasRf() == false) goto L18;
            r10 = b.a(r10, 37, 4, 53) + getRf().hashCode();
        L18:
            if (hasPower() == false) goto L21;
            r10 = b.a(r10, 37, 5, 53) + getPower().hashCode();
        L21:
            if (hasCall() == false) goto L23;
            r10 = b.a(r10, 37, 6, 53) + getCall().hashCode();
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
            if (r8 != 1) goto L6;
            return true;
        L6:
            if (r8 != 0) goto L9;
            return false;
        L9:
            if (hasSlotId() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasDataKpi() == false) goto L19;
            if (getDataKpi().isInitialized() == true) goto L19;
            this.memoizedIsInitialized = 0;
            return false;
        L19:
            if (hasNetwork() == false) goto L25;
            if (getNetwork().isInitialized() == true) goto L25;
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (hasRf() == false) goto L31;
            if (getRf().isInitialized() == true) goto L31;
            this.memoizedIsInitialized = 0;
            return false;
        L31:
            if (hasPower() == false) goto L37;
            if (getPower().isInitialized() == true) goto L37;
            this.memoizedIsInitialized = 0;
            return false;
        L37:
            if (hasCall() == true) goto L39;
        L42:
            this.memoizedIsInitialized = 1;
            return true;
        L39:
            if (getCall().isInitialized() == true) goto L42;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new diagLogInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeInt32(1, this.slotId_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeMessage(2, getDataKpi());
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r8.writeMessage(3, getNetwork());
        L12:
            if ((this.bitField0_ & 8) == 0) goto L15;
            r8.writeMessage(4, getRf());
        L15:
            if ((this.bitField0_ & 16) == 0) goto L18;
            r8.writeMessage(5, getPower());
        L18:
            if ((this.bitField0_ & 32) == 0) goto L20;
            r8.writeMessage(6, getCall());
        L20:
            getUnknownFields().writeTo(r8);
        }

        private diagLogInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.slotId_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(diagLogInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static diagLogInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (diagLogInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static diagLogInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$1000().ensureFieldAccessorsInitialized(diagLogInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ diagLogInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static diagLogInfo parseFrom(CodedInputStream r8) {
            return (diagLogInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public diagLogInfo getDefaultInstanceForType() {
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

        public static diagLogInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (diagLogInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static diagLogInfo parseFrom(InputStream r8) {
            return (diagLogInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static diagLogInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (diagLogInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static diagLogInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static diagLogInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static diagLogInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static diagLogInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface diagLogInfoOrBuilder extends MessageOrBuilder {
        callInfo getCall();

        callInfoOrBuilder getCallOrBuilder();

        dataInfo getDataKpi();

        dataInfoOrBuilder getDataKpiOrBuilder();

        networkInfo getNetwork();

        networkInfoOrBuilder getNetworkOrBuilder();

        powerInfo getPower();

        powerInfoOrBuilder getPowerOrBuilder();

        rfInfo getRf();

        rfInfoOrBuilder getRfOrBuilder();

        int getSlotId();

        boolean hasCall();

        boolean hasDataKpi();

        boolean hasNetwork();

        boolean hasPower();

        boolean hasRf();

        boolean hasSlotId();
    }

    public static final class diagLogInfoist extends GeneratedMessageV3 implements diagLogInfoistOrBuilder {
        private static final diagLogInfoist DEFAULT_INSTANCE = null;
        public static final int DIAGLOGINFOSLOT0_FIELD_NUMBER = 1;
        public static final int DIAGLOGINFOSLOT1_FIELD_NUMBER = 2;

        @Deprecated
        public static final Parser<diagLogInfoist> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private diagLogInfo diagLogInfoSlot0_;
        private diagLogInfo diagLogInfoSlot1_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements diagLogInfoistOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> diagLogInfoSlot0Builder_;
            private diagLogInfo diagLogInfoSlot0_;
            private SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> diagLogInfoSlot1Builder_;
            private diagLogInfo diagLogInfoSlot1_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private void buildPartial0(diagLogInfoist r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L9;
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r11 = this.diagLogInfoSlot0Builder_;
                if (r11 != null) goto L7;
                diagLogInfo r12 = this.diagLogInfoSlot0_;
            L8:
                diagLogInfoist.access$602(r8, r12);
                int r13 = 1;
            L11:
                if ((r10 & 2) == 0) goto L17;
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r14 = this.diagLogInfoSlot1Builder_;
                if (r14 != null) goto L15;
                diagLogInfo r15 = this.diagLogInfoSlot1_;
            L16:
                diagLogInfoist.access$702(r8, r15);
                r13 = r13 | 2;
                goto L17
            L15:
                r15 = (diagLogInfo) r14.build();
            L17:
                diagLogInfoist.access$876(r8, r13);
                return;
            L7:
                r12 = (diagLogInfo) r11.build();
                goto L8
            L9:
                r13 = 0;
                goto L11
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$000();
            }

            private SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> getDiagLogInfoSlot0FieldBuilder() {
                if (this.diagLogInfoSlot0Builder_ != null) goto L6;
                this.diagLogInfoSlot0Builder_ = new SingleFieldBuilderV3(getDiagLogInfoSlot0(), getParentForChildren(), isClean());
                this.diagLogInfoSlot0_ = null;
            L6:
                return this.diagLogInfoSlot0Builder_;
            }

            private SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> getDiagLogInfoSlot1FieldBuilder() {
                if (this.diagLogInfoSlot1Builder_ != null) goto L6;
                this.diagLogInfoSlot1Builder_ = new SingleFieldBuilderV3(getDiagLogInfoSlot1(), getParentForChildren(), isClean());
                this.diagLogInfoSlot1_ = null;
            L6:
                return this.diagLogInfoSlot1Builder_;
            }

            private void maybeForceBuilderInitialization() {
                if (diagLogInfoist.access$400() == false) goto L6;
                getDiagLogInfoSlot0FieldBuilder();
                getDiagLogInfoSlot1FieldBuilder();
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

            public Builder clearDiagLogInfoSlot0() {
                this.bitField0_ &= -2;
                this.diagLogInfoSlot0_ = null;
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r8 = this.diagLogInfoSlot0Builder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.diagLogInfoSlot0Builder_ = null;
            L5:
                onChanged();
                return this;
            }

            public Builder clearDiagLogInfoSlot1() {
                this.bitField0_ &= -3;
                this.diagLogInfoSlot1_ = null;
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r8 = this.diagLogInfoSlot1Builder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.diagLogInfoSlot1Builder_ = null;
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BdDiagProto.access$000();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
            public diagLogInfo getDiagLogInfoSlot0() {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r8 = this.diagLogInfoSlot0Builder_;
                if (r8 != null) goto L9;
                diagLogInfo r10 = this.diagLogInfoSlot0_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return diagLogInfo.getDefaultInstance();
            L9:
                return (diagLogInfo) r8.getMessage();
            }

            public diagLogInfo.Builder getDiagLogInfoSlot0Builder() {
                this.bitField0_ |= 1;
                onChanged();
                return (diagLogInfo.Builder) getDiagLogInfoSlot0FieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
            public diagLogInfoOrBuilder getDiagLogInfoSlot0OrBuilder() {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r8 = this.diagLogInfoSlot0Builder_;
                if (r8 != null) goto L5;
                diagLogInfo r10 = this.diagLogInfoSlot0_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return diagLogInfo.getDefaultInstance();
            L5:
                return (diagLogInfoOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
            public diagLogInfo getDiagLogInfoSlot1() {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r8 = this.diagLogInfoSlot1Builder_;
                if (r8 != null) goto L9;
                diagLogInfo r10 = this.diagLogInfoSlot1_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return diagLogInfo.getDefaultInstance();
            L9:
                return (diagLogInfo) r8.getMessage();
            }

            public diagLogInfo.Builder getDiagLogInfoSlot1Builder() {
                this.bitField0_ |= 2;
                onChanged();
                return (diagLogInfo.Builder) getDiagLogInfoSlot1FieldBuilder().getBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
            public diagLogInfoOrBuilder getDiagLogInfoSlot1OrBuilder() {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r8 = this.diagLogInfoSlot1Builder_;
                if (r8 != null) goto L5;
                diagLogInfo r10 = this.diagLogInfoSlot1_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return diagLogInfo.getDefaultInstance();
            L5:
                return (diagLogInfoOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
            public boolean hasDiagLogInfoSlot0() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
            public boolean hasDiagLogInfoSlot1() {
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
                if (hasDiagLogInfoSlot0() == true) goto L6;
                return false;
            L6:
                if (hasDiagLogInfoSlot1() == true) goto L9;
                return false;
            L9:
                if (getDiagLogInfoSlot0().isInitialized() == true) goto L12;
                return false;
            L12:
                if (getDiagLogInfoSlot1().isInitialized() == true) goto L14;
                return false;
            L14:
                return true;
            }

            public Builder mergeDiagLogInfoSlot0(diagLogInfo r8) {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r10 = this.diagLogInfoSlot0Builder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 1) == 0) goto L11;
                diagLogInfo r11 = this.diagLogInfoSlot0_;
                if (r11 == null) goto L11;
                if (r11 == diagLogInfo.getDefaultInstance()) goto L11;
                getDiagLogInfoSlot0Builder().mergeFrom(r8);
            L11:
                this.diagLogInfoSlot0_ = r8;
                goto L13
            }

            public Builder mergeDiagLogInfoSlot1(diagLogInfo r8) {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r10 = this.diagLogInfoSlot1Builder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L13:
                this.bitField0_ |= 2;
                onChanged();
                return this;
            L5:
                if ((this.bitField0_ & 2) == 0) goto L11;
                diagLogInfo r11 = this.diagLogInfoSlot1_;
                if (r11 == null) goto L11;
                if (r11 == diagLogInfo.getDefaultInstance()) goto L11;
                getDiagLogInfoSlot1Builder().mergeFrom(r8);
            L11:
                this.diagLogInfoSlot1_ = r8;
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

            public Builder setDiagLogInfoSlot0(diagLogInfo.Builder r8) {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r10 = this.diagLogInfoSlot0Builder_;
                diagLogInfo r11 = r8.build();
                if (r10 != null) goto L5;
                this.diagLogInfoSlot0_ = r11;
            L6:
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
                goto L6
            }

            public Builder setDiagLogInfoSlot1(diagLogInfo.Builder r8) {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r10 = this.diagLogInfoSlot1Builder_;
                diagLogInfo r11 = r8.build();
                if (r10 != null) goto L5;
                this.diagLogInfoSlot1_ = r11;
            L6:
                this.bitField0_ |= 2;
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
                return BdDiagProto.access$100().ensureFieldAccessorsInitialized(diagLogInfoist.class, Builder.class);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
                return mergeUnknownFields(r8);
            }

            public Builder setDiagLogInfoSlot0(diagLogInfo r8) {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r10 = this.diagLogInfoSlot0Builder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.diagLogInfoSlot0_ = r8;
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

            public Builder setDiagLogInfoSlot1(diagLogInfo r8) {
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r10 = this.diagLogInfoSlot1Builder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.diagLogInfoSlot1_ = r8;
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
            public diagLogInfoist build() {
                diagLogInfoist r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public diagLogInfoist buildPartial() {
                diagLogInfoist r8 = new diagLogInfoist(this, null);
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
            public diagLogInfoist getDefaultInstanceForType() {
                return diagLogInfoist.getDefaultInstance();
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
                this.diagLogInfoSlot0_ = null;
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r8 = this.diagLogInfoSlot0Builder_;
                if (r8 == null) goto L5;
                r8.dispose();
                this.diagLogInfoSlot0Builder_ = null;
            L5:
                this.diagLogInfoSlot1_ = null;
                SingleFieldBuilderV3<diagLogInfo, diagLogInfo.Builder, diagLogInfoOrBuilder> r10 = this.diagLogInfoSlot1Builder_;
                if (r10 == null) goto L8;
                r10.dispose();
                this.diagLogInfoSlot1Builder_ = null;
            L8:
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
                r8.readMessage(getDiagLogInfoSlot0FieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                this.bitField0_ |= 1;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                goto L4
            L10:
                if (r12 != 18) goto L12;
                r8.readMessage(getDiagLogInfoSlot1FieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                this.bitField0_ |= 2;     // Catch: Throwable -> L18 InvalidProtocolBufferException -> L20
                goto L4
            L12:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L17:
                r11 = true;
                goto L4
            L18:
                th = move-exception;
                onChanged();
                throw th;
            L20:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L18
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
                if ((r8 instanceof diagLogInfoist) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((diagLogInfoist) r8);
            }

            public Builder mergeFrom(diagLogInfoist r8) {
                if (r8 != diagLogInfoist.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasDiagLogInfoSlot0() == false) goto L9;
                mergeDiagLogInfoSlot0(r8.getDiagLogInfoSlot0());
            L9:
                if (r8.hasDiagLogInfoSlot1() == false) goto L11;
                mergeDiagLogInfoSlot1(r8.getDiagLogInfoSlot1());
            L11:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new diagLogInfoist();
            PARSER = new AnonymousClass1();
        }

        private diagLogInfoist() {
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ boolean access$400() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ diagLogInfo access$602(diagLogInfoist r8, diagLogInfo r10) {
            r8.diagLogInfoSlot0_ = r10;
            return r10;
        }

        public static /* synthetic */ diagLogInfo access$702(diagLogInfoist r8, diagLogInfo r10) {
            r8.diagLogInfoSlot1_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$876(diagLogInfoist r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static diagLogInfoist getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$000();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static diagLogInfoist parseDelimitedFrom(InputStream r8) {
            return (diagLogInfoist) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static diagLogInfoist parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<diagLogInfoist> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof diagLogInfoist) == false) goto L8;
            diagLogInfoist r10 = (diagLogInfoist) r8;
            if (hasDiagLogInfoSlot0() == r10.hasDiagLogInfoSlot0()) goto L13;
            return false;
        L13:
            if (hasDiagLogInfoSlot0() == false) goto L18;
            if (getDiagLogInfoSlot0().equals(r10.getDiagLogInfoSlot0()) == true) goto L18;
            return false;
        L18:
            if (hasDiagLogInfoSlot1() == r10.hasDiagLogInfoSlot1()) goto L21;
            return false;
        L21:
            if (hasDiagLogInfoSlot1() == false) goto L26;
            if (getDiagLogInfoSlot1().equals(r10.getDiagLogInfoSlot1()) == true) goto L26;
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

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
        public diagLogInfo getDiagLogInfoSlot0() {
            diagLogInfo r8 = this.diagLogInfoSlot0_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return diagLogInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
        public diagLogInfoOrBuilder getDiagLogInfoSlot0OrBuilder() {
            diagLogInfo r8 = this.diagLogInfoSlot0_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return diagLogInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
        public diagLogInfo getDiagLogInfoSlot1() {
            diagLogInfo r8 = this.diagLogInfoSlot1_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return diagLogInfo.getDefaultInstance();
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
        public diagLogInfoOrBuilder getDiagLogInfoSlot1OrBuilder() {
            diagLogInfo r8 = this.diagLogInfoSlot1_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return diagLogInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<diagLogInfoist> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeMessageSize(1, getDiagLogInfoSlot0());
        L9:
            if ((this.bitField0_ & 2) == 0) goto L11;
            r10 = r10 + CodedOutputStream.computeMessageSize(2, getDiagLogInfoSlot1());
        L11:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
        public boolean hasDiagLogInfoSlot0() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.qti.extphone.BdDiagProto.diagLogInfoistOrBuilder
        public boolean hasDiagLogInfoSlot1() {
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
            if (hasDiagLogInfoSlot0() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getDiagLogInfoSlot0().hashCode();
        L9:
            if (hasDiagLogInfoSlot1() == false) goto L11;
            r10 = b.a(r10, 37, 2, 53) + getDiagLogInfoSlot1().hashCode();
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
            if (r8 != 1) goto L6;
            return true;
        L6:
            if (r8 != 0) goto L9;
            return false;
        L9:
            if (hasDiagLogInfoSlot0() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasDiagLogInfoSlot1() == true) goto L17;
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (getDiagLogInfoSlot0().isInitialized() == true) goto L21;
            this.memoizedIsInitialized = 0;
            return false;
        L21:
            if (getDiagLogInfoSlot1().isInitialized() == true) goto L24;
            this.memoizedIsInitialized = 0;
            return false;
        L24:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new diagLogInfoist();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeMessage(1, getDiagLogInfoSlot0());
        L6:
            if ((this.bitField0_ & 2) == 0) goto L8;
            r8.writeMessage(2, getDiagLogInfoSlot1());
        L8:
            getUnknownFields().writeTo(r8);
        }

        private diagLogInfoist(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(diagLogInfoist r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static diagLogInfoist parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (diagLogInfoist) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static diagLogInfoist parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$100().ensureFieldAccessorsInitialized(diagLogInfoist.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ diagLogInfoist(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static diagLogInfoist parseFrom(CodedInputStream r8) {
            return (diagLogInfoist) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public diagLogInfoist getDefaultInstanceForType() {
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

        public static diagLogInfoist parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (diagLogInfoist) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static diagLogInfoist parseFrom(InputStream r8) {
            return (diagLogInfoist) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static diagLogInfoist parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (diagLogInfoist) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static diagLogInfoist parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static diagLogInfoist parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static diagLogInfoist parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static diagLogInfoist parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface diagLogInfoistOrBuilder extends MessageOrBuilder {
        diagLogInfo getDiagLogInfoSlot0();

        diagLogInfoOrBuilder getDiagLogInfoSlot0OrBuilder();

        diagLogInfo getDiagLogInfoSlot1();

        diagLogInfoOrBuilder getDiagLogInfoSlot1OrBuilder();

        boolean hasDiagLogInfoSlot0();

        boolean hasDiagLogInfoSlot1();
    }

    public static final class l2DataList extends GeneratedMessageV3 implements l2DataListOrBuilder {
        private static final l2DataList DEFAULT_INSTANCE = null;
        public static final int LTEMACBSRSIZE_FIELD_NUMBER = 3;
        public static final int LTEMACGRANTSIZE_FIELD_NUMBER = 4;
        public static final int LTEPDCPALLNUM_FIELD_NUMBER = 2;
        public static final int LTEPDCPDISCNUM_FIELD_NUMBER = 1;
        public static final int NRMACBSRSIZE_FIELD_NUMBER = 7;
        public static final int NRMACGRANTSIZE_FIELD_NUMBER = 8;
        public static final int NRPDCPALLNUM_FIELD_NUMBER = 6;
        public static final int NRPDCPDISCNUM_FIELD_NUMBER = 5;

        @Deprecated
        public static final Parser<l2DataList> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int lteMacBsrSize_;
        private int lteMacGrantSize_;
        private int ltePdcpAllNum_;
        private int ltePdcpDiscNum_;
        private byte memoizedIsInitialized;
        private int nrMacBsrSize_;
        private int nrMacGrantSize_;
        private int nrPdcpAllNum_;
        private int nrPdcpDiscNum_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements l2DataListOrBuilder {
            private int bitField0_;
            private int lteMacBsrSize_;
            private int lteMacGrantSize_;
            private int ltePdcpAllNum_;
            private int ltePdcpDiscNum_;
            private int nrMacBsrSize_;
            private int nrMacGrantSize_;
            private int nrPdcpAllNum_;
            private int nrPdcpDiscNum_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(l2DataList r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                l2DataList.access$5002(r8, this.ltePdcpDiscNum_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                l2DataList.access$5102(r8, this.ltePdcpAllNum_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                l2DataList.access$5202(r8, this.lteMacBsrSize_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L16;
                l2DataList.access$5302(r8, this.lteMacGrantSize_);
                r11 = r11 | 8;
            L16:
                if ((r10 & 16) == 0) goto L19;
                l2DataList.access$5402(r8, this.nrPdcpDiscNum_);
                r11 = r11 | 16;
            L19:
                if ((r10 & 32) == 0) goto L22;
                l2DataList.access$5502(r8, this.nrPdcpAllNum_);
                r11 = r11 | 32;
            L22:
                if ((r10 & 64) == 0) goto L25;
                l2DataList.access$5602(r8, this.nrMacBsrSize_);
                r11 = r11 | 64;
            L25:
                if ((r10 & 128) == 0) goto L27;
                l2DataList.access$5702(r8, this.nrMacGrantSize_);
                r11 = r11 | 128;
            L27:
                l2DataList.access$5876(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$4500();
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

            public Builder clearLteMacBsrSize() {
                this.bitField0_ &= -5;
                this.lteMacBsrSize_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLteMacGrantSize() {
                this.bitField0_ &= -9;
                this.lteMacGrantSize_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLtePdcpAllNum() {
                this.bitField0_ &= -3;
                this.ltePdcpAllNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLtePdcpDiscNum() {
                this.bitField0_ &= -2;
                this.ltePdcpDiscNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNrMacBsrSize() {
                this.bitField0_ &= -65;
                this.nrMacBsrSize_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNrMacGrantSize() {
                this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
                this.nrMacGrantSize_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNrPdcpAllNum() {
                this.bitField0_ &= -33;
                this.nrPdcpAllNum_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNrPdcpDiscNum() {
                this.bitField0_ &= -17;
                this.nrPdcpDiscNum_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
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
                return BdDiagProto.access$4500();
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getLteMacBsrSize() {
                return this.lteMacBsrSize_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getLteMacGrantSize() {
                return this.lteMacGrantSize_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getLtePdcpAllNum() {
                return this.ltePdcpAllNum_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getLtePdcpDiscNum() {
                return this.ltePdcpDiscNum_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getNrMacBsrSize() {
                return this.nrMacBsrSize_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getNrMacGrantSize() {
                return this.nrMacGrantSize_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getNrPdcpAllNum() {
                return this.nrPdcpAllNum_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public int getNrPdcpDiscNum() {
                return this.nrPdcpDiscNum_;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasLteMacBsrSize() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasLteMacGrantSize() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasLtePdcpAllNum() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasLtePdcpDiscNum() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasNrMacBsrSize() {
                if ((this.bitField0_ & 64) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasNrMacGrantSize() {
                if ((this.bitField0_ & 128) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasNrPdcpAllNum() {
                if ((this.bitField0_ & 32) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
            public boolean hasNrPdcpDiscNum() {
                if ((this.bitField0_ & 16) == 0) goto L5;
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
                if (hasLtePdcpDiscNum() == true) goto L6;
                return false;
            L6:
                if (hasLtePdcpAllNum() == true) goto L9;
                return false;
            L9:
                if (hasLteMacBsrSize() == true) goto L12;
                return false;
            L12:
                if (hasLteMacGrantSize() == true) goto L15;
                return false;
            L15:
                if (hasNrPdcpDiscNum() == true) goto L18;
                return false;
            L18:
                if (hasNrPdcpAllNum() == true) goto L21;
                return false;
            L21:
                if (hasNrMacBsrSize() == true) goto L24;
                return false;
            L24:
                if (hasNrMacGrantSize() == true) goto L26;
                return false;
            L26:
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

            public Builder setLteMacBsrSize(int r8) {
                this.lteMacBsrSize_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setLteMacGrantSize(int r8) {
                this.lteMacGrantSize_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setLtePdcpAllNum(int r8) {
                this.ltePdcpAllNum_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setLtePdcpDiscNum(int r8) {
                this.ltePdcpDiscNum_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setNrMacBsrSize(int r8) {
                this.nrMacBsrSize_ = r8;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setNrMacGrantSize(int r8) {
                this.nrMacGrantSize_ = r8;
                this.bitField0_ |= 128;
                onChanged();
                return this;
            }

            public Builder setNrPdcpAllNum(int r8) {
                this.nrPdcpAllNum_ = r8;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            public Builder setNrPdcpDiscNum(int r8) {
                this.nrPdcpDiscNum_ = r8;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
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
                return BdDiagProto.access$4600().ensureFieldAccessorsInitialized(l2DataList.class, Builder.class);
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
            public l2DataList build() {
                l2DataList r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public l2DataList buildPartial() {
                l2DataList r8 = new l2DataList(this, null);
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
            public l2DataList getDefaultInstanceForType() {
                return l2DataList.getDefaultInstance();
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
                this.ltePdcpDiscNum_ = 0;
                this.ltePdcpAllNum_ = 0;
                this.lteMacBsrSize_ = 0;
                this.lteMacGrantSize_ = 0;
                this.nrPdcpDiscNum_ = 0;
                this.nrPdcpAllNum_ = 0;
                this.nrMacBsrSize_ = 0;
                this.nrMacGrantSize_ = 0;
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
                this.ltePdcpDiscNum_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L9:
                int r13 = 16;
                if (r12 != 16) goto L12;
                this.ltePdcpAllNum_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.lteMacBsrSize_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L14:
                if (r12 != 32) goto L16;
                this.lteMacGrantSize_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L16:
                if (r12 == 40) goto L29;
                if (r12 != 48) goto L19;
                this.nrPdcpAllNum_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L19:
                r13 = 64;
                if (r12 != 56) goto L21;
                this.nrMacBsrSize_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                int r14 = this.bitField0_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            L27:
                this.bitField0_ = r14 | r13;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L21:
                if (r12 != 64) goto L23;
                this.nrMacGrantSize_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                this.bitField0_ |= 128;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
                goto L4
            L23:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L29:
                this.nrPdcpDiscNum_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
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
                if ((r8 instanceof l2DataList) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((l2DataList) r8);
            }

            public Builder mergeFrom(l2DataList r8) {
                if (r8 != l2DataList.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasLtePdcpDiscNum() == false) goto L9;
                setLtePdcpDiscNum(r8.getLtePdcpDiscNum());
            L9:
                if (r8.hasLtePdcpAllNum() == false) goto L12;
                setLtePdcpAllNum(r8.getLtePdcpAllNum());
            L12:
                if (r8.hasLteMacBsrSize() == false) goto L15;
                setLteMacBsrSize(r8.getLteMacBsrSize());
            L15:
                if (r8.hasLteMacGrantSize() == false) goto L18;
                setLteMacGrantSize(r8.getLteMacGrantSize());
            L18:
                if (r8.hasNrPdcpDiscNum() == false) goto L21;
                setNrPdcpDiscNum(r8.getNrPdcpDiscNum());
            L21:
                if (r8.hasNrPdcpAllNum() == false) goto L24;
                setNrPdcpAllNum(r8.getNrPdcpAllNum());
            L24:
                if (r8.hasNrMacBsrSize() == false) goto L27;
                setNrMacBsrSize(r8.getNrMacBsrSize());
            L27:
                if (r8.hasNrMacGrantSize() == false) goto L29;
                setNrMacGrantSize(r8.getNrMacGrantSize());
            L29:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new l2DataList();
            PARSER = new AnonymousClass1();
        }

        private l2DataList() {
            this.ltePdcpDiscNum_ = 0;
            this.ltePdcpAllNum_ = 0;
            this.lteMacBsrSize_ = 0;
            this.lteMacGrantSize_ = 0;
            this.nrPdcpDiscNum_ = 0;
            this.nrPdcpAllNum_ = 0;
            this.nrMacBsrSize_ = 0;
            this.nrMacGrantSize_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$5002(l2DataList r8, int r10) {
            r8.ltePdcpDiscNum_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5102(l2DataList r8, int r10) {
            r8.ltePdcpAllNum_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5202(l2DataList r8, int r10) {
            r8.lteMacBsrSize_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5302(l2DataList r8, int r10) {
            r8.lteMacGrantSize_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5402(l2DataList r8, int r10) {
            r8.nrPdcpDiscNum_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5502(l2DataList r8, int r10) {
            r8.nrPdcpAllNum_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5602(l2DataList r8, int r10) {
            r8.nrMacBsrSize_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5702(l2DataList r8, int r10) {
            r8.nrMacGrantSize_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5876(l2DataList r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static l2DataList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$4500();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static l2DataList parseDelimitedFrom(InputStream r8) {
            return (l2DataList) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static l2DataList parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<l2DataList> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof l2DataList) == false) goto L8;
            l2DataList r10 = (l2DataList) r8;
            if (hasLtePdcpDiscNum() == r10.hasLtePdcpDiscNum()) goto L13;
            return false;
        L13:
            if (hasLtePdcpDiscNum() == false) goto L18;
            if (getLtePdcpDiscNum() == r10.getLtePdcpDiscNum()) goto L18;
            return false;
        L18:
            if (hasLtePdcpAllNum() == r10.hasLtePdcpAllNum()) goto L21;
            return false;
        L21:
            if (hasLtePdcpAllNum() == false) goto L26;
            if (getLtePdcpAllNum() == r10.getLtePdcpAllNum()) goto L26;
            return false;
        L26:
            if (hasLteMacBsrSize() == r10.hasLteMacBsrSize()) goto L29;
            return false;
        L29:
            if (hasLteMacBsrSize() == false) goto L34;
            if (getLteMacBsrSize() == r10.getLteMacBsrSize()) goto L34;
            return false;
        L34:
            if (hasLteMacGrantSize() == r10.hasLteMacGrantSize()) goto L37;
            return false;
        L37:
            if (hasLteMacGrantSize() == false) goto L42;
            if (getLteMacGrantSize() == r10.getLteMacGrantSize()) goto L42;
            return false;
        L42:
            if (hasNrPdcpDiscNum() == r10.hasNrPdcpDiscNum()) goto L45;
            return false;
        L45:
            if (hasNrPdcpDiscNum() == false) goto L50;
            if (getNrPdcpDiscNum() == r10.getNrPdcpDiscNum()) goto L50;
            return false;
        L50:
            if (hasNrPdcpAllNum() == r10.hasNrPdcpAllNum()) goto L53;
            return false;
        L53:
            if (hasNrPdcpAllNum() == false) goto L58;
            if (getNrPdcpAllNum() == r10.getNrPdcpAllNum()) goto L58;
            return false;
        L58:
            if (hasNrMacBsrSize() == r10.hasNrMacBsrSize()) goto L61;
            return false;
        L61:
            if (hasNrMacBsrSize() == false) goto L66;
            if (getNrMacBsrSize() == r10.getNrMacBsrSize()) goto L66;
            return false;
        L66:
            if (hasNrMacGrantSize() == r10.hasNrMacGrantSize()) goto L69;
            return false;
        L69:
            if (hasNrMacGrantSize() == false) goto L74;
            if (getNrMacGrantSize() == r10.getNrMacGrantSize()) goto L74;
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

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getLteMacBsrSize() {
            return this.lteMacBsrSize_;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getLteMacGrantSize() {
            return this.lteMacGrantSize_;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getLtePdcpAllNum() {
            return this.ltePdcpAllNum_;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getLtePdcpDiscNum() {
            return this.ltePdcpDiscNum_;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getNrMacBsrSize() {
            return this.nrMacBsrSize_;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getNrMacGrantSize() {
            return this.nrMacGrantSize_;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getNrPdcpAllNum() {
            return this.nrPdcpAllNum_;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public int getNrPdcpDiscNum() {
            return this.nrPdcpDiscNum_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<l2DataList> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeUInt32Size(1, this.ltePdcpDiscNum_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeUInt32Size(2, this.ltePdcpAllNum_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + CodedOutputStream.computeUInt32Size(3, this.lteMacBsrSize_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r10 = r10 + CodedOutputStream.computeUInt32Size(4, this.lteMacGrantSize_);
        L18:
            if ((this.bitField0_ & 16) == 0) goto L21;
            r10 = r10 + CodedOutputStream.computeUInt32Size(5, this.nrPdcpDiscNum_);
        L21:
            if ((this.bitField0_ & 32) == 0) goto L24;
            r10 = r10 + CodedOutputStream.computeUInt32Size(6, this.nrPdcpAllNum_);
        L24:
            if ((this.bitField0_ & 64) == 0) goto L27;
            r10 = r10 + CodedOutputStream.computeUInt32Size(7, this.nrMacBsrSize_);
        L27:
            if ((this.bitField0_ & 128) == 0) goto L29;
            r10 = r10 + CodedOutputStream.computeUInt32Size(8, this.nrMacGrantSize_);
        L29:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasLteMacBsrSize() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasLteMacGrantSize() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasLtePdcpAllNum() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasLtePdcpDiscNum() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasNrMacBsrSize() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasNrMacGrantSize() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasNrPdcpAllNum() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l2DataListOrBuilder
        public boolean hasNrPdcpDiscNum() {
            if ((this.bitField0_ & 16) == 0) goto L5;
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
            if (hasLtePdcpDiscNum() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getLtePdcpDiscNum();
        L9:
            if (hasLtePdcpAllNum() == false) goto L12;
            r10 = b.a(r10, 37, 2, 53) + getLtePdcpAllNum();
        L12:
            if (hasLteMacBsrSize() == false) goto L15;
            r10 = b.a(r10, 37, 3, 53) + getLteMacBsrSize();
        L15:
            if (hasLteMacGrantSize() == false) goto L18;
            r10 = b.a(r10, 37, 4, 53) + getLteMacGrantSize();
        L18:
            if (hasNrPdcpDiscNum() == false) goto L21;
            r10 = b.a(r10, 37, 5, 53) + getNrPdcpDiscNum();
        L21:
            if (hasNrPdcpAllNum() == false) goto L24;
            r10 = b.a(r10, 37, 6, 53) + getNrPdcpAllNum();
        L24:
            if (hasNrMacBsrSize() == false) goto L27;
            r10 = b.a(r10, 37, 7, 53) + getNrMacBsrSize();
        L27:
            if (hasNrMacGrantSize() == false) goto L29;
            r10 = b.a(r10, 37, 8, 53) + getNrMacGrantSize();
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
            if (r8 != 1) goto L6;
            return true;
        L6:
            if (r8 != 0) goto L9;
            return false;
        L9:
            if (hasLtePdcpDiscNum() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasLtePdcpAllNum() == true) goto L17;
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (hasLteMacBsrSize() == true) goto L21;
            this.memoizedIsInitialized = 0;
            return false;
        L21:
            if (hasLteMacGrantSize() == true) goto L25;
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (hasNrPdcpDiscNum() == true) goto L29;
            this.memoizedIsInitialized = 0;
            return false;
        L29:
            if (hasNrPdcpAllNum() == true) goto L33;
            this.memoizedIsInitialized = 0;
            return false;
        L33:
            if (hasNrMacBsrSize() == true) goto L37;
            this.memoizedIsInitialized = 0;
            return false;
        L37:
            if (hasNrMacGrantSize() == true) goto L40;
            this.memoizedIsInitialized = 0;
            return false;
        L40:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new l2DataList();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeUInt32(1, this.ltePdcpDiscNum_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeUInt32(2, this.ltePdcpAllNum_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r8.writeUInt32(3, this.lteMacBsrSize_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L15;
            r8.writeUInt32(4, this.lteMacGrantSize_);
        L15:
            if ((this.bitField0_ & 16) == 0) goto L18;
            r8.writeUInt32(5, this.nrPdcpDiscNum_);
        L18:
            if ((this.bitField0_ & 32) == 0) goto L21;
            r8.writeUInt32(6, this.nrPdcpAllNum_);
        L21:
            if ((this.bitField0_ & 64) == 0) goto L24;
            r8.writeUInt32(7, this.nrMacBsrSize_);
        L24:
            if ((this.bitField0_ & 128) == 0) goto L26;
            r8.writeUInt32(8, this.nrMacGrantSize_);
        L26:
            getUnknownFields().writeTo(r8);
        }

        private l2DataList(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.ltePdcpDiscNum_ = 0;
            this.ltePdcpAllNum_ = 0;
            this.lteMacBsrSize_ = 0;
            this.lteMacGrantSize_ = 0;
            this.nrPdcpDiscNum_ = 0;
            this.nrPdcpAllNum_ = 0;
            this.nrMacBsrSize_ = 0;
            this.nrMacGrantSize_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(l2DataList r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static l2DataList parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (l2DataList) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static l2DataList parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$4600().ensureFieldAccessorsInitialized(l2DataList.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ l2DataList(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static l2DataList parseFrom(CodedInputStream r8) {
            return (l2DataList) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public l2DataList getDefaultInstanceForType() {
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

        public static l2DataList parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (l2DataList) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static l2DataList parseFrom(InputStream r8) {
            return (l2DataList) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static l2DataList parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (l2DataList) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static l2DataList parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static l2DataList parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static l2DataList parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static l2DataList parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface l2DataListOrBuilder extends MessageOrBuilder {
        int getLteMacBsrSize();

        int getLteMacGrantSize();

        int getLtePdcpAllNum();

        int getLtePdcpDiscNum();

        int getNrMacBsrSize();

        int getNrMacGrantSize();

        int getNrPdcpAllNum();

        int getNrPdcpDiscNum();

        boolean hasLteMacBsrSize();

        boolean hasLteMacGrantSize();

        boolean hasLtePdcpAllNum();

        boolean hasLtePdcpDiscNum();

        boolean hasNrMacBsrSize();

        boolean hasNrMacGrantSize();

        boolean hasNrPdcpAllNum();

        boolean hasNrPdcpDiscNum();
    }

    public static final class l3DataList extends GeneratedMessageV3 implements l3DataListOrBuilder {
        private static final l3DataList DEFAULT_INSTANCE = null;
        public static final int LTERLFALIVECNT_FIELD_NUMBER = 4;
        public static final int LTERLFCAUSEIND_FIELD_NUMBER = 2;
        public static final int LTERLFRRCCNT_FIELD_NUMBER = 3;
        public static final int NETWORKTYPE_FIELD_NUMBER = 1;
        public static final int NRRLFALIVECNT_FIELD_NUMBER = 7;
        public static final int NRRLFCAUSEIND_FIELD_NUMBER = 5;
        public static final int NRRLFRRCCNT_FIELD_NUMBER = 6;

        @Deprecated
        public static final Parser<l3DataList> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int lteRlfAliveCnt_;
        private int lteRlfCauseInd_;
        private int lteRlfRrcCnt_;
        private byte memoizedIsInitialized;
        private int networkType_;
        private int nrRlfAliveCnt_;
        private int nrRlfCauseInd_;
        private int nrRlfRrcCnt_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements l3DataListOrBuilder {
            private int bitField0_;
            private int lteRlfAliveCnt_;
            private int lteRlfCauseInd_;
            private int lteRlfRrcCnt_;
            private int networkType_;
            private int nrRlfAliveCnt_;
            private int nrRlfCauseInd_;
            private int nrRlfRrcCnt_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(l3DataList r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                l3DataList.access$3702(r8, this.networkType_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                l3DataList.access$3802(r8, this.lteRlfCauseInd_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                l3DataList.access$3902(r8, this.lteRlfRrcCnt_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L16;
                l3DataList.access$4002(r8, this.lteRlfAliveCnt_);
                r11 = r11 | 8;
            L16:
                if ((r10 & 16) == 0) goto L19;
                l3DataList.access$4102(r8, this.nrRlfCauseInd_);
                r11 = r11 | 16;
            L19:
                if ((r10 & 32) == 0) goto L22;
                l3DataList.access$4202(r8, this.nrRlfRrcCnt_);
                r11 = r11 | 32;
            L22:
                if ((r10 & 64) == 0) goto L24;
                l3DataList.access$4302(r8, this.nrRlfAliveCnt_);
                r11 = r11 | 64;
            L24:
                l3DataList.access$4476(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$3200();
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

            public Builder clearLteRlfAliveCnt() {
                this.bitField0_ &= -9;
                this.lteRlfAliveCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLteRlfCauseInd() {
                this.bitField0_ &= -3;
                this.lteRlfCauseInd_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLteRlfRrcCnt() {
                this.bitField0_ &= -5;
                this.lteRlfRrcCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNetworkType() {
                this.bitField0_ &= -2;
                this.networkType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNrRlfAliveCnt() {
                this.bitField0_ &= -65;
                this.nrRlfAliveCnt_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNrRlfCauseInd() {
                this.bitField0_ &= -17;
                this.nrRlfCauseInd_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNrRlfRrcCnt() {
                this.bitField0_ &= -33;
                this.nrRlfRrcCnt_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
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
                return BdDiagProto.access$3200();
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public int getLteRlfAliveCnt() {
                return this.lteRlfAliveCnt_;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public int getLteRlfCauseInd() {
                return this.lteRlfCauseInd_;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public int getLteRlfRrcCnt() {
                return this.lteRlfRrcCnt_;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public int getNetworkType() {
                return this.networkType_;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public int getNrRlfAliveCnt() {
                return this.nrRlfAliveCnt_;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public int getNrRlfCauseInd() {
                return this.nrRlfCauseInd_;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public int getNrRlfRrcCnt() {
                return this.nrRlfRrcCnt_;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public boolean hasLteRlfAliveCnt() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public boolean hasLteRlfCauseInd() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public boolean hasLteRlfRrcCnt() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public boolean hasNetworkType() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public boolean hasNrRlfAliveCnt() {
                if ((this.bitField0_ & 64) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public boolean hasNrRlfCauseInd() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
            public boolean hasNrRlfRrcCnt() {
                if ((this.bitField0_ & 32) == 0) goto L5;
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
                if (hasNetworkType() == true) goto L6;
                return false;
            L6:
                if (hasLteRlfCauseInd() == true) goto L9;
                return false;
            L9:
                if (hasLteRlfRrcCnt() == true) goto L12;
                return false;
            L12:
                if (hasLteRlfAliveCnt() == true) goto L15;
                return false;
            L15:
                if (hasNrRlfCauseInd() == true) goto L18;
                return false;
            L18:
                if (hasNrRlfRrcCnt() == true) goto L21;
                return false;
            L21:
                if (hasNrRlfAliveCnt() == true) goto L23;
                return false;
            L23:
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

            public Builder setLteRlfAliveCnt(int r8) {
                this.lteRlfAliveCnt_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setLteRlfCauseInd(int r8) {
                this.lteRlfCauseInd_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setLteRlfRrcCnt(int r8) {
                this.lteRlfRrcCnt_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setNetworkType(int r8) {
                this.networkType_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setNrRlfAliveCnt(int r8) {
                this.nrRlfAliveCnt_ = r8;
                this.bitField0_ |= 64;
                onChanged();
                return this;
            }

            public Builder setNrRlfCauseInd(int r8) {
                this.nrRlfCauseInd_ = r8;
                this.bitField0_ |= 16;
                onChanged();
                return this;
            }

            public Builder setNrRlfRrcCnt(int r8) {
                this.nrRlfRrcCnt_ = r8;
                this.bitField0_ |= 32;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
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
                return BdDiagProto.access$3300().ensureFieldAccessorsInitialized(l3DataList.class, Builder.class);
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
            public l3DataList build() {
                l3DataList r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public l3DataList buildPartial() {
                l3DataList r8 = new l3DataList(this, null);
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
            public l3DataList getDefaultInstanceForType() {
                return l3DataList.getDefaultInstance();
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
                this.networkType_ = 0;
                this.lteRlfCauseInd_ = 0;
                this.lteRlfRrcCnt_ = 0;
                this.lteRlfAliveCnt_ = 0;
                this.nrRlfCauseInd_ = 0;
                this.nrRlfRrcCnt_ = 0;
                this.nrRlfAliveCnt_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L43;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L40;
                int r12 = r8.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (r12 == 0) goto L32;
                if (r12 != 8) goto L10;
                this.networkType_ = r8.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 1;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L10:
                if (r12 != 16) goto L12;
                this.lteRlfCauseInd_ = r8.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.lteRlfRrcCnt_ = r8.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L14:
                if (r12 != 32) goto L16;
                this.lteRlfAliveCnt_ = r8.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 8;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L16:
                if (r12 != 40) goto L18;
                this.nrRlfCauseInd_ = r8.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 16;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L18:
                if (r12 != 48) goto L20;
                this.nrRlfRrcCnt_ = r8.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 32;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L20:
                if (r12 != 56) goto L22;
                this.nrRlfAliveCnt_ = r8.readUInt32();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 64;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L22:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L32:
                r11 = true;
                goto L4
            L33:
                th = move-exception;
                onChanged();
                throw th;
            L35:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L33
            L40:
                onChanged();
                return this;
            L43:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof l3DataList) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((l3DataList) r8);
            }

            public Builder mergeFrom(l3DataList r8) {
                if (r8 != l3DataList.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasNetworkType() == false) goto L9;
                setNetworkType(r8.getNetworkType());
            L9:
                if (r8.hasLteRlfCauseInd() == false) goto L12;
                setLteRlfCauseInd(r8.getLteRlfCauseInd());
            L12:
                if (r8.hasLteRlfRrcCnt() == false) goto L15;
                setLteRlfRrcCnt(r8.getLteRlfRrcCnt());
            L15:
                if (r8.hasLteRlfAliveCnt() == false) goto L18;
                setLteRlfAliveCnt(r8.getLteRlfAliveCnt());
            L18:
                if (r8.hasNrRlfCauseInd() == false) goto L21;
                setNrRlfCauseInd(r8.getNrRlfCauseInd());
            L21:
                if (r8.hasNrRlfRrcCnt() == false) goto L24;
                setNrRlfRrcCnt(r8.getNrRlfRrcCnt());
            L24:
                if (r8.hasNrRlfAliveCnt() == false) goto L26;
                setNrRlfAliveCnt(r8.getNrRlfAliveCnt());
            L26:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new l3DataList();
            PARSER = new AnonymousClass1();
        }

        private l3DataList() {
            this.networkType_ = 0;
            this.lteRlfCauseInd_ = 0;
            this.lteRlfRrcCnt_ = 0;
            this.lteRlfAliveCnt_ = 0;
            this.nrRlfCauseInd_ = 0;
            this.nrRlfRrcCnt_ = 0;
            this.nrRlfAliveCnt_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ int access$3702(l3DataList r8, int r10) {
            r8.networkType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$3802(l3DataList r8, int r10) {
            r8.lteRlfCauseInd_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$3902(l3DataList r8, int r10) {
            r8.lteRlfRrcCnt_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4002(l3DataList r8, int r10) {
            r8.lteRlfAliveCnt_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4102(l3DataList r8, int r10) {
            r8.nrRlfCauseInd_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4202(l3DataList r8, int r10) {
            r8.nrRlfRrcCnt_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4302(l3DataList r8, int r10) {
            r8.nrRlfAliveCnt_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4476(l3DataList r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static l3DataList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$3200();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static l3DataList parseDelimitedFrom(InputStream r8) {
            return (l3DataList) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static l3DataList parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<l3DataList> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof l3DataList) == false) goto L8;
            l3DataList r10 = (l3DataList) r8;
            if (hasNetworkType() == r10.hasNetworkType()) goto L13;
            return false;
        L13:
            if (hasNetworkType() == false) goto L18;
            if (getNetworkType() == r10.getNetworkType()) goto L18;
            return false;
        L18:
            if (hasLteRlfCauseInd() == r10.hasLteRlfCauseInd()) goto L21;
            return false;
        L21:
            if (hasLteRlfCauseInd() == false) goto L26;
            if (getLteRlfCauseInd() == r10.getLteRlfCauseInd()) goto L26;
            return false;
        L26:
            if (hasLteRlfRrcCnt() == r10.hasLteRlfRrcCnt()) goto L29;
            return false;
        L29:
            if (hasLteRlfRrcCnt() == false) goto L34;
            if (getLteRlfRrcCnt() == r10.getLteRlfRrcCnt()) goto L34;
            return false;
        L34:
            if (hasLteRlfAliveCnt() == r10.hasLteRlfAliveCnt()) goto L37;
            return false;
        L37:
            if (hasLteRlfAliveCnt() == false) goto L42;
            if (getLteRlfAliveCnt() == r10.getLteRlfAliveCnt()) goto L42;
            return false;
        L42:
            if (hasNrRlfCauseInd() == r10.hasNrRlfCauseInd()) goto L45;
            return false;
        L45:
            if (hasNrRlfCauseInd() == false) goto L50;
            if (getNrRlfCauseInd() == r10.getNrRlfCauseInd()) goto L50;
            return false;
        L50:
            if (hasNrRlfRrcCnt() == r10.hasNrRlfRrcCnt()) goto L53;
            return false;
        L53:
            if (hasNrRlfRrcCnt() == false) goto L58;
            if (getNrRlfRrcCnt() == r10.getNrRlfRrcCnt()) goto L58;
            return false;
        L58:
            if (hasNrRlfAliveCnt() == r10.hasNrRlfAliveCnt()) goto L61;
            return false;
        L61:
            if (hasNrRlfAliveCnt() == false) goto L66;
            if (getNrRlfAliveCnt() == r10.getNrRlfAliveCnt()) goto L66;
            return false;
        L66:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L68;
            return false;
        L68:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public int getLteRlfAliveCnt() {
            return this.lteRlfAliveCnt_;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public int getLteRlfCauseInd() {
            return this.lteRlfCauseInd_;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public int getLteRlfRrcCnt() {
            return this.lteRlfRrcCnt_;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public int getNetworkType() {
            return this.networkType_;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public int getNrRlfAliveCnt() {
            return this.nrRlfAliveCnt_;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public int getNrRlfCauseInd() {
            return this.nrRlfCauseInd_;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public int getNrRlfRrcCnt() {
            return this.nrRlfRrcCnt_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<l3DataList> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeUInt32Size(1, this.networkType_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeUInt32Size(2, this.lteRlfCauseInd_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + CodedOutputStream.computeUInt32Size(3, this.lteRlfRrcCnt_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r10 = r10 + CodedOutputStream.computeUInt32Size(4, this.lteRlfAliveCnt_);
        L18:
            if ((this.bitField0_ & 16) == 0) goto L21;
            r10 = r10 + CodedOutputStream.computeUInt32Size(5, this.nrRlfCauseInd_);
        L21:
            if ((this.bitField0_ & 32) == 0) goto L24;
            r10 = r10 + CodedOutputStream.computeUInt32Size(6, this.nrRlfRrcCnt_);
        L24:
            if ((this.bitField0_ & 64) == 0) goto L26;
            r10 = r10 + CodedOutputStream.computeUInt32Size(7, this.nrRlfAliveCnt_);
        L26:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public boolean hasLteRlfAliveCnt() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public boolean hasLteRlfCauseInd() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public boolean hasLteRlfRrcCnt() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public boolean hasNetworkType() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public boolean hasNrRlfAliveCnt() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public boolean hasNrRlfCauseInd() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.qti.extphone.BdDiagProto.l3DataListOrBuilder
        public boolean hasNrRlfRrcCnt() {
            if ((this.bitField0_ & 32) == 0) goto L5;
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
            if (hasNetworkType() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getNetworkType();
        L9:
            if (hasLteRlfCauseInd() == false) goto L12;
            r10 = b.a(r10, 37, 2, 53) + getLteRlfCauseInd();
        L12:
            if (hasLteRlfRrcCnt() == false) goto L15;
            r10 = b.a(r10, 37, 3, 53) + getLteRlfRrcCnt();
        L15:
            if (hasLteRlfAliveCnt() == false) goto L18;
            r10 = b.a(r10, 37, 4, 53) + getLteRlfAliveCnt();
        L18:
            if (hasNrRlfCauseInd() == false) goto L21;
            r10 = b.a(r10, 37, 5, 53) + getNrRlfCauseInd();
        L21:
            if (hasNrRlfRrcCnt() == false) goto L24;
            r10 = b.a(r10, 37, 6, 53) + getNrRlfRrcCnt();
        L24:
            if (hasNrRlfAliveCnt() == false) goto L26;
            r10 = b.a(r10, 37, 7, 53) + getNrRlfAliveCnt();
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
            if (r8 != 1) goto L6;
            return true;
        L6:
            if (r8 != 0) goto L9;
            return false;
        L9:
            if (hasNetworkType() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasLteRlfCauseInd() == true) goto L17;
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (hasLteRlfRrcCnt() == true) goto L21;
            this.memoizedIsInitialized = 0;
            return false;
        L21:
            if (hasLteRlfAliveCnt() == true) goto L25;
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (hasNrRlfCauseInd() == true) goto L29;
            this.memoizedIsInitialized = 0;
            return false;
        L29:
            if (hasNrRlfRrcCnt() == true) goto L33;
            this.memoizedIsInitialized = 0;
            return false;
        L33:
            if (hasNrRlfAliveCnt() == true) goto L36;
            this.memoizedIsInitialized = 0;
            return false;
        L36:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new l3DataList();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeUInt32(1, this.networkType_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeUInt32(2, this.lteRlfCauseInd_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r8.writeUInt32(3, this.lteRlfRrcCnt_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L15;
            r8.writeUInt32(4, this.lteRlfAliveCnt_);
        L15:
            if ((this.bitField0_ & 16) == 0) goto L18;
            r8.writeUInt32(5, this.nrRlfCauseInd_);
        L18:
            if ((this.bitField0_ & 32) == 0) goto L21;
            r8.writeUInt32(6, this.nrRlfRrcCnt_);
        L21:
            if ((this.bitField0_ & 64) == 0) goto L23;
            r8.writeUInt32(7, this.nrRlfAliveCnt_);
        L23:
            getUnknownFields().writeTo(r8);
        }

        private l3DataList(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.networkType_ = 0;
            this.lteRlfCauseInd_ = 0;
            this.lteRlfRrcCnt_ = 0;
            this.lteRlfAliveCnt_ = 0;
            this.nrRlfCauseInd_ = 0;
            this.nrRlfRrcCnt_ = 0;
            this.nrRlfAliveCnt_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(l3DataList r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static l3DataList parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (l3DataList) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static l3DataList parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$3300().ensureFieldAccessorsInitialized(l3DataList.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ l3DataList(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static l3DataList parseFrom(CodedInputStream r8) {
            return (l3DataList) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public l3DataList getDefaultInstanceForType() {
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

        public static l3DataList parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (l3DataList) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static l3DataList parseFrom(InputStream r8) {
            return (l3DataList) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static l3DataList parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (l3DataList) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static l3DataList parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static l3DataList parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static l3DataList parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static l3DataList parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface l3DataListOrBuilder extends MessageOrBuilder {
        int getLteRlfAliveCnt();

        int getLteRlfCauseInd();

        int getLteRlfRrcCnt();

        int getNetworkType();

        int getNrRlfAliveCnt();

        int getNrRlfCauseInd();

        int getNrRlfRrcCnt();

        boolean hasLteRlfAliveCnt();

        boolean hasLteRlfCauseInd();

        boolean hasLteRlfRrcCnt();

        boolean hasNetworkType();

        boolean hasNrRlfAliveCnt();

        boolean hasNrRlfCauseInd();

        boolean hasNrRlfRrcCnt();
    }

    public static final class networkInfo extends GeneratedMessageV3 implements networkInfoOrBuilder {
        private static final networkInfo DEFAULT_INSTANCE = null;
        public static final int ISCHANGED_FIELD_NUMBER = 1;

        @Deprecated
        public static final Parser<networkInfo> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean isChanged_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements networkInfoOrBuilder {
            private int bitField0_;
            private boolean isChanged_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(networkInfo r8) {
                int r10 = 1;
                if ((this.bitField0_ & 1) == 0) goto L5;
                networkInfo.access$6402(r8, this.isChanged_);
            L6:
                networkInfo.access$6576(r8, r10);
                return;
            L5:
                r10 = 0;
                goto L6
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$5900();
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

            public Builder clearIsChanged() {
                this.bitField0_ &= -2;
                this.isChanged_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
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
                return BdDiagProto.access$5900();
            }

            @Override // com.qti.extphone.BdDiagProto.networkInfoOrBuilder
            public boolean getIsChanged() {
                return this.isChanged_;
            }

            @Override // com.qti.extphone.BdDiagProto.networkInfoOrBuilder
            public boolean hasIsChanged() {
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
                if (hasIsChanged() == true) goto L6;
                return false;
            L6:
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

            public Builder setIsChanged(boolean r8) {
                this.isChanged_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
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
                return BdDiagProto.access$6000().ensureFieldAccessorsInitialized(networkInfo.class, Builder.class);
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
            public networkInfo build() {
                networkInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public networkInfo buildPartial() {
                networkInfo r8 = new networkInfo(this, null);
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
            public networkInfo getDefaultInstanceForType() {
                return networkInfo.getDefaultInstance();
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
                this.isChanged_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L25;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L22;
                int r12 = r8.readTag();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                if (r12 == 0) goto L14;
                if (r12 != 8) goto L10;
                this.isChanged_ = r8.readBool();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                this.bitField0_ |= 1;     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                goto L4
            L10:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L14:
                r11 = true;
                goto L4
            L17:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                onChanged();
                throw th;
            L22:
                onChanged();
                return this;
            L25:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof networkInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((networkInfo) r8);
            }

            public Builder mergeFrom(networkInfo r8) {
                if (r8 != networkInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasIsChanged() == false) goto L8;
                setIsChanged(r8.getIsChanged());
            L8:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new networkInfo();
            PARSER = new AnonymousClass1();
        }

        private networkInfo() {
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ boolean access$6402(networkInfo r8, boolean r10) {
            r8.isChanged_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6576(networkInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static networkInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$5900();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static networkInfo parseDelimitedFrom(InputStream r8) {
            return (networkInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static networkInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<networkInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof networkInfo) == false) goto L8;
            networkInfo r10 = (networkInfo) r8;
            if (hasIsChanged() == r10.hasIsChanged()) goto L13;
            return false;
        L13:
            if (hasIsChanged() == false) goto L18;
            if (getIsChanged() == r10.getIsChanged()) goto L18;
            return false;
        L18:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L20;
            return false;
        L20:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.qti.extphone.BdDiagProto.networkInfoOrBuilder
        public boolean getIsChanged() {
            return this.isChanged_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<networkInfo> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeBoolSize(1, this.isChanged_);
        L8:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.networkInfoOrBuilder
        public boolean hasIsChanged() {
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
            if (hasIsChanged() == false) goto L8;
            r10 = b.a(r10, 37, 1, 53) + Internal.hashBoolean(getIsChanged());
        L8:
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
            if (hasIsChanged() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new networkInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L5;
            r8.writeBool(1, this.isChanged_);
        L5:
            getUnknownFields().writeTo(r8);
        }

        private networkInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(networkInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static networkInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (networkInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static networkInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$6000().ensureFieldAccessorsInitialized(networkInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ networkInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static networkInfo parseFrom(CodedInputStream r8) {
            return (networkInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public networkInfo getDefaultInstanceForType() {
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

        public static networkInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (networkInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static networkInfo parseFrom(InputStream r8) {
            return (networkInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static networkInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (networkInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static networkInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static networkInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static networkInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static networkInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface networkInfoOrBuilder extends MessageOrBuilder {
        boolean getIsChanged();

        boolean hasIsChanged();
    }

    public static final class powerInfo extends GeneratedMessageV3 implements powerInfoOrBuilder {
        private static final powerInfo DEFAULT_INSTANCE = null;
        public static final int ISCHANGED_FIELD_NUMBER = 1;

        @Deprecated
        public static final Parser<powerInfo> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean isChanged_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements powerInfoOrBuilder {
            private int bitField0_;
            private boolean isChanged_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(powerInfo r8) {
                int r10 = 1;
                if ((this.bitField0_ & 1) == 0) goto L5;
                powerInfo.access$7802(r8, this.isChanged_);
            L6:
                powerInfo.access$7976(r8, r10);
                return;
            L5:
                r10 = 0;
                goto L6
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$7300();
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

            public Builder clearIsChanged() {
                this.bitField0_ &= -2;
                this.isChanged_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
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
                return BdDiagProto.access$7300();
            }

            @Override // com.qti.extphone.BdDiagProto.powerInfoOrBuilder
            public boolean getIsChanged() {
                return this.isChanged_;
            }

            @Override // com.qti.extphone.BdDiagProto.powerInfoOrBuilder
            public boolean hasIsChanged() {
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
                if (hasIsChanged() == true) goto L6;
                return false;
            L6:
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

            public Builder setIsChanged(boolean r8) {
                this.isChanged_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
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
                return BdDiagProto.access$7400().ensureFieldAccessorsInitialized(powerInfo.class, Builder.class);
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
            public powerInfo build() {
                powerInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public powerInfo buildPartial() {
                powerInfo r8 = new powerInfo(this, null);
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
            public powerInfo getDefaultInstanceForType() {
                return powerInfo.getDefaultInstance();
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
                this.isChanged_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L25;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L22;
                int r12 = r8.readTag();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                if (r12 == 0) goto L14;
                if (r12 != 8) goto L10;
                this.isChanged_ = r8.readBool();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                this.bitField0_ |= 1;     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                goto L4
            L10:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L14:
                r11 = true;
                goto L4
            L17:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                onChanged();
                throw th;
            L22:
                onChanged();
                return this;
            L25:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof powerInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((powerInfo) r8);
            }

            public Builder mergeFrom(powerInfo r8) {
                if (r8 != powerInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasIsChanged() == false) goto L8;
                setIsChanged(r8.getIsChanged());
            L8:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new powerInfo();
            PARSER = new AnonymousClass1();
        }

        private powerInfo() {
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ boolean access$7802(powerInfo r8, boolean r10) {
            r8.isChanged_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$7976(powerInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static powerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$7300();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static powerInfo parseDelimitedFrom(InputStream r8) {
            return (powerInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static powerInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<powerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof powerInfo) == false) goto L8;
            powerInfo r10 = (powerInfo) r8;
            if (hasIsChanged() == r10.hasIsChanged()) goto L13;
            return false;
        L13:
            if (hasIsChanged() == false) goto L18;
            if (getIsChanged() == r10.getIsChanged()) goto L18;
            return false;
        L18:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L20;
            return false;
        L20:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.qti.extphone.BdDiagProto.powerInfoOrBuilder
        public boolean getIsChanged() {
            return this.isChanged_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<powerInfo> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeBoolSize(1, this.isChanged_);
        L8:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.powerInfoOrBuilder
        public boolean hasIsChanged() {
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
            if (hasIsChanged() == false) goto L8;
            r10 = b.a(r10, 37, 1, 53) + Internal.hashBoolean(getIsChanged());
        L8:
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
            if (hasIsChanged() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new powerInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L5;
            r8.writeBool(1, this.isChanged_);
        L5:
            getUnknownFields().writeTo(r8);
        }

        private powerInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(powerInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static powerInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (powerInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static powerInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$7400().ensureFieldAccessorsInitialized(powerInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ powerInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static powerInfo parseFrom(CodedInputStream r8) {
            return (powerInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public powerInfo getDefaultInstanceForType() {
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

        public static powerInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (powerInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static powerInfo parseFrom(InputStream r8) {
            return (powerInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static powerInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (powerInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static powerInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static powerInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static powerInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static powerInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface powerInfoOrBuilder extends MessageOrBuilder {
        boolean getIsChanged();

        boolean hasIsChanged();
    }

    public static final class rfInfo extends GeneratedMessageV3 implements rfInfoOrBuilder {
        private static final rfInfo DEFAULT_INSTANCE = null;
        public static final int ISCHANGED_FIELD_NUMBER = 1;

        @Deprecated
        public static final Parser<rfInfo> PARSER = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean isChanged_;
        private byte memoizedIsInitialized;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements rfInfoOrBuilder {
            private int bitField0_;
            private boolean isChanged_;

            private Builder() {
            }

            private Builder(GeneratedMessageV3.BuilderParent r8) {
                super(r8);
            }

            private void buildPartial0(rfInfo r8) {
                int r10 = 1;
                if ((this.bitField0_ & 1) == 0) goto L5;
                rfInfo.access$7102(r8, this.isChanged_);
            L6:
                rfInfo.access$7276(r8, r10);
                return;
            L5:
                r10 = 0;
                goto L6
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return BdDiagProto.access$6600();
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

            public Builder clearIsChanged() {
                this.bitField0_ &= -2;
                this.isChanged_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
                return clearOneof(r8);
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
                return BdDiagProto.access$6600();
            }

            @Override // com.qti.extphone.BdDiagProto.rfInfoOrBuilder
            public boolean getIsChanged() {
                return this.isChanged_;
            }

            @Override // com.qti.extphone.BdDiagProto.rfInfoOrBuilder
            public boolean hasIsChanged() {
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
                if (hasIsChanged() == true) goto L6;
                return false;
            L6:
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

            public Builder setIsChanged(boolean r8) {
                this.isChanged_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
                return setRepeatedField(r8, r10, r11);
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
                return BdDiagProto.access$6700().ensureFieldAccessorsInitialized(rfInfo.class, Builder.class);
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
            public rfInfo build() {
                rfInfo r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public rfInfo buildPartial() {
                rfInfo r8 = new rfInfo(this, null);
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
            public rfInfo getDefaultInstanceForType() {
                return rfInfo.getDefaultInstance();
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
                this.isChanged_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clone() {
                return (Builder) super.clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L25;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L22;
                int r12 = r8.readTag();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                if (r12 == 0) goto L14;
                if (r12 != 8) goto L10;
                this.isChanged_ = r8.readBool();     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                this.bitField0_ |= 1;     // Catch: Throwable -> L15 InvalidProtocolBufferException -> L17
                goto L4
            L10:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L14:
                r11 = true;
                goto L4
            L17:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                onChanged();
                throw th;
            L22:
                onChanged();
                return this;
            L25:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo1clone() {
                return clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof rfInfo) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((rfInfo) r8);
            }

            public Builder mergeFrom(rfInfo r8) {
                if (r8 != rfInfo.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasIsChanged() == false) goto L8;
                setIsChanged(r8.getIsChanged());
            L8:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            DEFAULT_INSTANCE = new rfInfo();
            PARSER = new AnonymousClass1();
        }

        private rfInfo() {
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ boolean access$7102(rfInfo r8, boolean r10) {
            r8.isChanged_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$7276(rfInfo r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static rfInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BdDiagProto.access$6600();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static rfInfo parseDelimitedFrom(InputStream r8) {
            return (rfInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static rfInfo parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<rfInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof rfInfo) == false) goto L8;
            rfInfo r10 = (rfInfo) r8;
            if (hasIsChanged() == r10.hasIsChanged()) goto L13;
            return false;
        L13:
            if (hasIsChanged() == false) goto L18;
            if (getIsChanged() == r10.getIsChanged()) goto L18;
            return false;
        L18:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L20;
            return false;
        L20:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.qti.extphone.BdDiagProto.rfInfoOrBuilder
        public boolean getIsChanged() {
            return this.isChanged_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<rfInfo> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeBoolSize(1, this.isChanged_);
        L8:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.qti.extphone.BdDiagProto.rfInfoOrBuilder
        public boolean hasIsChanged() {
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
            if (hasIsChanged() == false) goto L8;
            r10 = b.a(r10, 37, 1, 53) + Internal.hashBoolean(getIsChanged());
        L8:
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
            if (hasIsChanged() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
            return new rfInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L5;
            r8.writeBool(1, this.isChanged_);
        L5:
            getUnknownFields().writeTo(r8);
        }

        private rfInfo(GeneratedMessageV3.Builder<?> r8) {
            super(r8);
            this.isChanged_ = false;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(rfInfo r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static rfInfo parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (rfInfo) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static rfInfo parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BdDiagProto.access$6700().ensureFieldAccessorsInitialized(rfInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ rfInfo(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static rfInfo parseFrom(CodedInputStream r8) {
            return (rfInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public rfInfo getDefaultInstanceForType() {
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

        public static rfInfo parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (rfInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static rfInfo parseFrom(InputStream r8) {
            return (rfInfo) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static rfInfo parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (rfInfo) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static rfInfo parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static rfInfo parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static rfInfo parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static rfInfo parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface rfInfoOrBuilder extends MessageOrBuilder {
        boolean getIsChanged();

        boolean hasIsChanged();
    }

    static {
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fBdDiagLog.proto\"`\n\u000ediagLogInfoist\u0012&\n\u0010diagLogInfoSlot0\u0018\u0001 \u0002(\u000b2\f.diagLogInfo\u0012&\n\u0010diagLogInfoSlot1\u0018\u0002 \u0002(\u000b2\f.diagLogInfo\"¡\u0001\n\u000bdiagLogInfo\u0012\u000e\n\u0006slotId\u0018\u0001 \u0002(\u0005\u0012\u001a\n\u0007dataKpi\u0018\u0002 \u0001(\u000b2\t.dataInfo\u0012\u001d\n\u0007network\u0018\u0003 \u0001(\u000b2\f.networkInfo\u0012\u0013\n\u0002rf\u0018\u0004 \u0001(\u000b2\u0007.rfInfo\u0012\u0019\n\u0005power\u0018\u0005 \u0001(\u000b2\n.powerInfo\u0012\u0017\n\u0004call\u0018\u0006 \u0001(\u000b2\t.callInfo\"W\n\bdataInfo\u0012\u0011\n\tisChanged\u0018\u0001 \u0002(\b\u0012\u001b\n\u0006l3Data\u0018\u0002 \u0002(\u000b2\u000b.l3DataList\u0012\u001b\n\u0006l2Data\u0018\u0003 \u0002(\u000b2\u000b.l2DataList\"ª\u0001\n\nl3DataList\u0012\u0013\n\u000bnetworkType\u0018\u0001 \u0002(\r\u0012\u0016\n\u000elteRlfCauseInd\u0018\u0002 \u0002(\r\u0012\u0014\n\flteRlfRrcCnt\u0018\u0003 \u0002(\r\u0012\u0016\n\u000elteRlfAliveCnt\u0018\u0004 \u0002(\r\u0012\u0015\n\rnrRlfCauseInd\u0018\u0005 \u0002(\r\u0012\u0013\n\u000bnrRlfRrcCnt\u0018\u0006 \u0002(\r\u0012\u0015\n\rnrRlfAliveCnt\u0018\u0007 \u0002(\r\"Æ\u0001\n\nl2DataList\u0012\u0016\n\u000eltePdcpDiscNum\u0018\u0001 \u0002(\r\u0012\u0015\n\rltePdcpAllNum\u0018\u0002 \u0002(\r\u0012\u0015\n\rlteMacBsrSize\u0018\u0003 \u0002(\r\u0012\u0017\n\u000flteMacGrantSize\u0018\u0004 \u0002(\r\u0012\u0015\n\rnrPdcpDiscNum\u0018\u0005 \u0002(\r\u0012\u0014\n\fnrPdcpAllNum\u0018\u0006 \u0002(\r\u0012\u0014\n\fnrMacBsrSize\u0018\u0007 \u0002(\r\u0012\u0016\n\u000enrMacGrantSize\u0018\b \u0002(\r\" \n\u000bnetworkInfo\u0012\u0011\n\tisChanged\u0018\u0001 \u0002(\b\"\u001b\n\u0006rfInfo\u0012\u0011\n\tisChanged\u0018\u0001 \u0002(\b\"\u001e\n\tpowerInfo\u0012\u0011\n\tisChanged\u0018\u0001 \u0002(\b\"\u001d\n\bcallInfo\u0012\u0011\n\tisChanged\u0018\u0001 \u0002(\bB\u001f\n\u0010com.qti.extphoneB\u000bBdDiagProto"}, new Descriptors.FileDescriptor[0]);
        Descriptors.Descriptor r8 = getDescriptor().getMessageTypes().get(0);
        internal_static_diagLogInfoist_descriptor = r8;
        internal_static_diagLogInfoist_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"DiagLogInfoSlot0", "DiagLogInfoSlot1"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(1);
        internal_static_diagLogInfo_descriptor = r10;
        internal_static_diagLogInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"SlotId", "DataKpi", "Network", "Rf", "Power", "Call"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(2);
        internal_static_dataInfo_descriptor = r11;
        internal_static_dataInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"IsChanged", "L3Data", "L2Data"});
        Descriptors.Descriptor r12 = getDescriptor().getMessageTypes().get(3);
        internal_static_l3DataList_descriptor = r12;
        internal_static_l3DataList_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"NetworkType", "LteRlfCauseInd", "LteRlfRrcCnt", "LteRlfAliveCnt", "NrRlfCauseInd", "NrRlfRrcCnt", "NrRlfAliveCnt"});
        Descriptors.Descriptor r13 = getDescriptor().getMessageTypes().get(4);
        internal_static_l2DataList_descriptor = r13;
        internal_static_l2DataList_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"LtePdcpDiscNum", "LtePdcpAllNum", "LteMacBsrSize", "LteMacGrantSize", "NrPdcpDiscNum", "NrPdcpAllNum", "NrMacBsrSize", "NrMacGrantSize"});
        Descriptors.Descriptor r14 = getDescriptor().getMessageTypes().get(5);
        internal_static_networkInfo_descriptor = r14;
        internal_static_networkInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r14, new String[]{"IsChanged"});
        Descriptors.Descriptor r15 = getDescriptor().getMessageTypes().get(6);
        internal_static_rfInfo_descriptor = r15;
        internal_static_rfInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r15, new String[]{"IsChanged"});
        Descriptors.Descriptor r16 = getDescriptor().getMessageTypes().get(7);
        internal_static_powerInfo_descriptor = r16;
        internal_static_powerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r16, new String[]{"IsChanged"});
        Descriptors.Descriptor r17 = getDescriptor().getMessageTypes().get(8);
        internal_static_callInfo_descriptor = r17;
        internal_static_callInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r17, new String[]{"IsChanged"});
    }

    private BdDiagProto() {
    }

    public static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_diagLogInfoist_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$100() {
        return internal_static_diagLogInfoist_fieldAccessorTable;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$1000() {
        return internal_static_diagLogInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$2200() {
        return internal_static_dataInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$2300() {
        return internal_static_dataInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$3200() {
        return internal_static_l3DataList_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$3300() {
        return internal_static_l3DataList_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$4500() {
        return internal_static_l2DataList_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$4600() {
        return internal_static_l2DataList_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$5900() {
        return internal_static_networkInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$6000() {
        return internal_static_networkInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$6600() {
        return internal_static_rfInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$6700() {
        return internal_static_rfInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$7300() {
        return internal_static_powerInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$7400() {
        return internal_static_powerInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$8000() {
        return internal_static_callInfo_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$8100() {
        return internal_static_callInfo_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$900() {
        return internal_static_diagLogInfo_descriptor;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
    }
}
