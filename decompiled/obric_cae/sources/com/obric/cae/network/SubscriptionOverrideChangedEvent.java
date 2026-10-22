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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionOverrideChangedEvent extends GeneratedMessageV3 implements SubscriptionOverrideChangedEventOrBuilder {
    private static final SubscriptionOverrideChangedEvent DEFAULT_INSTANCE = null;
    public static final int NETWORKTYPES_FIELD_NUMBER = 4;
    public static final int OVERRIDEMASK_FIELD_NUMBER = 2;
    public static final int OVERRIDEVALUE_FIELD_NUMBER = 3;

    @Deprecated
    public static final Parser<SubscriptionOverrideChangedEvent> PARSER = null;
    public static final int SUBID_FIELD_NUMBER = 1;
    private static final Internal.ListAdapter.Converter<Integer, NetworkType> networkTypes_converter_ = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private List<Integer> networkTypes_;
    private int overrideMask_;
    private int overrideValue_;
    private int subId_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SubscriptionOverrideChangedEventOrBuilder {
        private int bitField0_;
        private List<Integer> networkTypes_;
        private int overrideMask_;
        private int overrideValue_;
        private int subId_;

        private Builder() {
            this.networkTypes_ = Collections.emptyList();
        }

        private void buildPartial0(SubscriptionOverrideChangedEvent r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            SubscriptionOverrideChangedEvent.access$402(r8, this.subId_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            SubscriptionOverrideChangedEvent.access$502(r8, this.overrideMask_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L12;
            SubscriptionOverrideChangedEvent.access$602(r8, this.overrideValue_);
            r11 = r11 | 4;
        L12:
            SubscriptionOverrideChangedEvent.access$776(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(SubscriptionOverrideChangedEvent r8) {
            if ((this.bitField0_ & 8) == 0) goto L5;
            this.networkTypes_ = Collections.unmodifiableList(this.networkTypes_);
            this.bitField0_ &= -9;
        L5:
            SubscriptionOverrideChangedEvent.access$302(r8, this.networkTypes_);
        }

        private void ensureNetworkTypesIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.networkTypes_ = new ArrayList(this.networkTypes_);
            this.bitField0_ |= 8;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_descriptor;
        }

        public Builder addAllNetworkTypes(Iterable<? extends NetworkType> r8) {
            ensureNetworkTypesIsMutable();
            Iterator<? extends NetworkType> r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            NetworkType r11 = r10.next();
            this.networkTypes_.add(Integer.valueOf(r11.getNumber()));
            goto L4
        L6:
            onChanged();
            return this;
        }

        public Builder addNetworkTypes(NetworkType r8) {
            if (r8 == null) goto L6;
            ensureNetworkTypesIsMutable();
            this.networkTypes_.add(Integer.valueOf(r8.getNumber()));
            onChanged();
            return this;
        L6:
            throw null;
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

        public Builder clearNetworkTypes() {
            this.networkTypes_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearOverrideMask() {
            this.bitField0_ &= -3;
            this.overrideMask_ = 0;
            onChanged();
            return this;
        }

        public Builder clearOverrideValue() {
            this.bitField0_ &= -5;
            this.overrideValue_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSubId() {
            this.bitField0_ &= -2;
            this.subId_ = 0;
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
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_descriptor;
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public NetworkType getNetworkTypes(int r8) {
            return (NetworkType) SubscriptionOverrideChangedEvent.access$800().convert(this.networkTypes_.get(r8));
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public int getNetworkTypesCount() {
            return this.networkTypes_.size();
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public List<NetworkType> getNetworkTypesList() {
            return new Internal.ListAdapter(this.networkTypes_, SubscriptionOverrideChangedEvent.access$800());
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public int getOverrideMask() {
            return this.overrideMask_;
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public int getOverrideValue() {
            return this.overrideValue_;
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public int getSubId() {
            return this.subId_;
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public boolean hasOverrideMask() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public boolean hasOverrideValue() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
        public boolean hasSubId() {
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
            if (hasSubId() == true) goto L6;
            return false;
        L6:
            if (hasOverrideMask() == true) goto L9;
            return false;
        L9:
            if (hasOverrideValue() == true) goto L11;
            return false;
        L11:
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

        public Builder setNetworkTypes(int r8, NetworkType r10) {
            if (r10 == null) goto L6;
            ensureNetworkTypesIsMutable();
            this.networkTypes_.set(r8, Integer.valueOf(r10.getNumber()));
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setOverrideMask(int r8) {
            this.overrideMask_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setOverrideValue(int r8) {
            this.overrideValue_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSubId(int r8) {
            this.subId_ = r8;
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
            this.networkTypes_ = Collections.emptyList();
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
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(SubscriptionOverrideChangedEvent.class, Builder.class);
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
        public SubscriptionOverrideChangedEvent build() {
            SubscriptionOverrideChangedEvent r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SubscriptionOverrideChangedEvent buildPartial() {
            SubscriptionOverrideChangedEvent r8 = new SubscriptionOverrideChangedEvent(this, null);
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
        public SubscriptionOverrideChangedEvent getDefaultInstanceForType() {
            return SubscriptionOverrideChangedEvent.getDefaultInstance();
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
            this.subId_ = 0;
            this.overrideMask_ = 0;
            this.overrideValue_ = 0;
            this.networkTypes_ = Collections.emptyList();
            this.bitField0_ &= -9;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L47;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L44;
            int r12 = r8.readTag();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            if (r12 == 0) goto L36;
            if (r12 != 8) goto L10;
            this.subId_ = r8.readUInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 1;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L10:
            if (r12 != 16) goto L12;
            this.overrideMask_ = r8.readUInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 2;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L12:
            if (r12 != 24) goto L14;
            this.overrideValue_ = r8.readUInt32();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.bitField0_ |= 4;     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L14:
            if (r12 != 32) goto L16;
            int r13 = r8.readEnum();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            if (NetworkType.forNumber(r13) == null) goto L30;
            ensureNetworkTypesIsMutable();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.networkTypes_.add(Integer.valueOf(r13));     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L30:
            mergeUnknownVarintField(4, r13);     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L16:
            if (r12 != 34) goto L18;
            int r14 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
        L22:
            if (r8.getBytesUntilLimit() <= 0) goto L27;
            int r15 = r8.readEnum();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            if (NetworkType.forNumber(r15) == null) goto L25;
            ensureNetworkTypesIsMutable();     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            this.networkTypes_.add(Integer.valueOf(r15));     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L22
        L25:
            mergeUnknownVarintField(4, r15);     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L22
        L27:
            r8.popLimit(r14);     // Catch: Throwable -> L37 InvalidProtocolBufferException -> L39
            goto L4
        L18:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L36:
            r11 = true;
            goto L4
        L39:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            onChanged();
            throw th;
        L44:
            onChanged();
            return this;
        L47:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof SubscriptionOverrideChangedEvent) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((SubscriptionOverrideChangedEvent) r8);
        }

        public Builder mergeFrom(SubscriptionOverrideChangedEvent r8) {
            if (r8 != SubscriptionOverrideChangedEvent.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSubId() == false) goto L9;
            setSubId(r8.getSubId());
        L9:
            if (r8.hasOverrideMask() == false) goto L12;
            setOverrideMask(r8.getOverrideMask());
        L12:
            if (r8.hasOverrideValue() == false) goto L15;
            setOverrideValue(r8.getOverrideValue());
        L15:
            if (SubscriptionOverrideChangedEvent.access$300(r8).isEmpty() == false) goto L17;
        L21:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L17:
            if (this.networkTypes_.isEmpty() == false) goto L19;
            this.networkTypes_ = SubscriptionOverrideChangedEvent.access$300(r8);
            this.bitField0_ &= -9;
        L20:
            onChanged();
            goto L21
        L19:
            ensureNetworkTypesIsMutable();
            this.networkTypes_.addAll(SubscriptionOverrideChangedEvent.access$300(r8));
            goto L20
        }
    }

    static {
        networkTypes_converter_ = new AnonymousClass1();
        DEFAULT_INSTANCE = new SubscriptionOverrideChangedEvent();
        PARSER = new AnonymousClass2();
    }

    private SubscriptionOverrideChangedEvent() {
        this.subId_ = 0;
        this.overrideMask_ = 0;
        this.overrideValue_ = 0;
        this.memoizedIsInitialized = -1;
        this.networkTypes_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$300(SubscriptionOverrideChangedEvent r8) {
        return r8.networkTypes_;
    }

    public static /* synthetic */ List access$302(SubscriptionOverrideChangedEvent r8, List r10) {
        r8.networkTypes_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$402(SubscriptionOverrideChangedEvent r8, int r10) {
        r8.subId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(SubscriptionOverrideChangedEvent r8, int r10) {
        r8.overrideMask_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$602(SubscriptionOverrideChangedEvent r8, int r10) {
        r8.overrideValue_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$776(SubscriptionOverrideChangedEvent r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Internal.ListAdapter.Converter access$800() {
        return networkTypes_converter_;
    }

    public static SubscriptionOverrideChangedEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetpolicyEvent.internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SubscriptionOverrideChangedEvent parseDelimitedFrom(InputStream r8) {
        return (SubscriptionOverrideChangedEvent) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<SubscriptionOverrideChangedEvent> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof SubscriptionOverrideChangedEvent) == false) goto L8;
        SubscriptionOverrideChangedEvent r10 = (SubscriptionOverrideChangedEvent) r8;
        if (hasSubId() == r10.hasSubId()) goto L13;
        return false;
    L13:
        if (hasSubId() == false) goto L18;
        if (getSubId() == r10.getSubId()) goto L18;
        return false;
    L18:
        if (hasOverrideMask() == r10.hasOverrideMask()) goto L21;
        return false;
    L21:
        if (hasOverrideMask() == false) goto L26;
        if (getOverrideMask() == r10.getOverrideMask()) goto L26;
        return false;
    L26:
        if (hasOverrideValue() == r10.hasOverrideValue()) goto L29;
        return false;
    L29:
        if (hasOverrideValue() == false) goto L34;
        if (getOverrideValue() == r10.getOverrideValue()) goto L34;
        return false;
    L34:
        if (this.networkTypes_.equals(r10.networkTypes_) == true) goto L37;
        return false;
    L37:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L39;
        return false;
    L39:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public NetworkType getNetworkTypes(int r8) {
        return networkTypes_converter_.convert(this.networkTypes_.get(r8));
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public int getNetworkTypesCount() {
        return this.networkTypes_.size();
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public List<NetworkType> getNetworkTypesList() {
        return new Internal.ListAdapter(this.networkTypes_, networkTypes_converter_);
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public int getOverrideMask() {
        return this.overrideMask_;
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public int getOverrideValue() {
        return this.overrideValue_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SubscriptionOverrideChangedEvent> getParserForType() {
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
        int r11 = CodedOutputStream.computeUInt32Size(1, this.subId_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeUInt32Size(2, this.overrideMask_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r11 = r11 + CodedOutputStream.computeUInt32Size(3, this.overrideValue_);
    L15:
        int r12 = 0;
    L17:
        if (r10 >= this.networkTypes_.size()) goto L19;
        r12 = r12 + CodedOutputStream.computeEnumSizeNoTag(this.networkTypes_.get(r10).intValue());
        r10 = r10 + 1;
        goto L17
    L19:
        int r13 = getUnknownFields().getSerializedSize() + ((this.networkTypes_.size() * 1) + (r11 + r12));
        this.memoizedSize = r13;
        return r13;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public int getSubId() {
        return this.subId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public boolean hasOverrideMask() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public boolean hasOverrideValue() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SubscriptionOverrideChangedEventOrBuilder
    public boolean hasSubId() {
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
        if (hasSubId() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSubId();
    L9:
        if (hasOverrideMask() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getOverrideMask();
    L12:
        if (hasOverrideValue() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getOverrideValue();
    L15:
        if (getNetworkTypesCount() <= 0) goto L17;
        r10 = b.a(r10, 37, 4, 53) + this.networkTypes_.hashCode();
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
        if (r8 != 1) goto L6;
        return true;
    L6:
        if (r8 != 0) goto L9;
        return false;
    L9:
        if (hasSubId() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasOverrideMask() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasOverrideValue() == true) goto L20;
        this.memoizedIsInitialized = 0;
        return false;
    L20:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new SubscriptionOverrideChangedEvent();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeUInt32(1, this.subId_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeUInt32(2, this.overrideMask_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L11;
        r8.writeUInt32(3, this.overrideValue_);
    L11:
        int r10 = 0;
    L13:
        if (r10 >= this.networkTypes_.size()) goto L15;
        r8.writeEnum(4, this.networkTypes_.get(r10).intValue());
        r10 = r10 + 1;
        goto L13
    L15:
        getUnknownFields().writeTo(r8);
    }

    private SubscriptionOverrideChangedEvent(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.subId_ = 0;
        this.overrideMask_ = 0;
        this.overrideValue_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(SubscriptionOverrideChangedEvent r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static SubscriptionOverrideChangedEvent parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SubscriptionOverrideChangedEvent) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetpolicyEvent.internal_static_com_obric_cae_network_SubscriptionOverrideChangedEvent_fieldAccessorTable.ensureFieldAccessorsInitialized(SubscriptionOverrideChangedEvent.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ SubscriptionOverrideChangedEvent(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(CodedInputStream r8) {
        return (SubscriptionOverrideChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public SubscriptionOverrideChangedEvent getDefaultInstanceForType() {
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

    public static SubscriptionOverrideChangedEvent parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (SubscriptionOverrideChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static SubscriptionOverrideChangedEvent parseFrom(InputStream r8) {
        return (SubscriptionOverrideChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SubscriptionOverrideChangedEvent) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static SubscriptionOverrideChangedEvent parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
