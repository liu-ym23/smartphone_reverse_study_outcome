package com.obric.cae.location.geofence;

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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class StarGeofenceProto extends GeneratedMessageV3 implements StarGeofenceProtoOrBuilder {
    public static final int BREACH_EVENT_FIELD_NUMBER = 2;
    private static final StarGeofenceProto DEFAULT_INSTANCE = null;
    public static final int GEOFENCE_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<StarGeofenceProto> PARSER = null;
    private static final long serialVersionUID = 0;
    private List<BreachEventData> breachEvent_;
    private List<StarGeofenceData> geofence_;
    private byte memoizedIsInitialized;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StarGeofenceProtoOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> breachEventBuilder_;
        private List<BreachEventData> breachEvent_;
        private RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> geofenceBuilder_;
        private List<StarGeofenceData> geofence_;

        private Builder() {
            this.geofence_ = Collections.emptyList();
            this.breachEvent_ = Collections.emptyList();
        }

        private void buildPartial0(StarGeofenceProto r8) {
        }

        private void buildPartialRepeatedFields(StarGeofenceProto r8) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r10 = this.geofenceBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            StarGeofenceProto.access$302(r8, r11);
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r12 = this.breachEventBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            StarGeofenceProto.access$402(r8, r13);
            return;
        L12:
            if ((this.bitField0_ & 2) == 0) goto L14;
            this.breachEvent_ = Collections.unmodifiableList(this.breachEvent_);
            this.bitField0_ &= -3;
        L14:
            r13 = this.breachEvent_;
            goto L16
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.geofence_ = Collections.unmodifiableList(this.geofence_);
            this.bitField0_ &= -2;
        L7:
            r11 = this.geofence_;
            goto L9
        }

        private void ensureBreachEventIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.breachEvent_ = new ArrayList(this.breachEvent_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureGeofenceIsMutable() {
            if ((this.bitField0_ & 1) != 0) goto L6;
            this.geofence_ = new ArrayList(this.geofence_);
            this.bitField0_ |= 1;
            return;
        }

        private RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> getBreachEventFieldBuilder() {
            if (this.breachEventBuilder_ != null) goto L10;
            List<BreachEventData> r8 = this.breachEvent_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.breachEventBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.breachEvent_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.breachEventBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceProto_descriptor;
        }

        private RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> getGeofenceFieldBuilder() {
            if (this.geofenceBuilder_ != null) goto L10;
            List<StarGeofenceData> r8 = this.geofence_;
            boolean r10 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r10 = false;
        L8:
            this.geofenceBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.geofence_ = null;
        L10:
            return this.geofenceBuilder_;
        }

        public Builder addAllBreachEvent(Iterable<? extends BreachEventData> r8) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = this.breachEventBuilder_;
            if (r10 != null) goto L5;
            ensureBreachEventIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.breachEvent_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllGeofence(Iterable<? extends StarGeofenceData> r8) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r10 = this.geofenceBuilder_;
            if (r10 != null) goto L5;
            ensureGeofenceIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.geofence_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addBreachEvent(int r8, BreachEventData.Builder r10) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r11 = this.breachEventBuilder_;
            if (r11 != null) goto L5;
            ensureBreachEventIsMutable();
            this.breachEvent_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public BreachEventData.Builder addBreachEventBuilder() {
            return (BreachEventData.Builder) getBreachEventFieldBuilder().addBuilder(BreachEventData.getDefaultInstance());
        }

        public Builder addGeofence(int r8, StarGeofenceData.Builder r10) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r11 = this.geofenceBuilder_;
            if (r11 != null) goto L5;
            ensureGeofenceIsMutable();
            this.geofence_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public StarGeofenceData.Builder addGeofenceBuilder() {
            return (StarGeofenceData.Builder) getGeofenceFieldBuilder().addBuilder(StarGeofenceData.getDefaultInstance());
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

        public Builder clearBreachEvent() {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r8 = this.breachEventBuilder_;
            if (r8 != null) goto L5;
            this.breachEvent_ = Collections.emptyList();
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

        public Builder clearGeofence() {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r8 = this.geofenceBuilder_;
            if (r8 != null) goto L5;
            this.geofence_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public BreachEventData getBreachEvent(int r8) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = this.breachEventBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.breachEvent_.get(r8);
        L6:
            return (BreachEventData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public BreachEventData.Builder getBreachEventBuilder(int r8) {
            return (BreachEventData.Builder) getBreachEventFieldBuilder().getBuilder(r8);
        }

        public List<BreachEventData.Builder> getBreachEventBuilderList() {
            return getBreachEventFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public int getBreachEventCount() {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r8 = this.breachEventBuilder_;
            if (r8 != null) goto L7;
            return this.breachEvent_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public List<BreachEventData> getBreachEventList() {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r8 = this.breachEventBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.breachEvent_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public BreachEventDataOrBuilder getBreachEventOrBuilder(int r8) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = this.breachEventBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.breachEvent_.get(r8);
        L6:
            return (BreachEventDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public List<? extends BreachEventDataOrBuilder> getBreachEventOrBuilderList() {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r8 = this.breachEventBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.breachEvent_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceProto_descriptor;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public StarGeofenceData getGeofence(int r8) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r10 = this.geofenceBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.geofence_.get(r8);
        L6:
            return (StarGeofenceData) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public StarGeofenceData.Builder getGeofenceBuilder(int r8) {
            return (StarGeofenceData.Builder) getGeofenceFieldBuilder().getBuilder(r8);
        }

        public List<StarGeofenceData.Builder> getGeofenceBuilderList() {
            return getGeofenceFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public int getGeofenceCount() {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r8 = this.geofenceBuilder_;
            if (r8 != null) goto L7;
            return this.geofence_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public List<StarGeofenceData> getGeofenceList() {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r8 = this.geofenceBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.geofence_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public StarGeofenceDataOrBuilder getGeofenceOrBuilder(int r8) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r10 = this.geofenceBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.geofence_.get(r8);
        L6:
            return (StarGeofenceDataOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
        public List<? extends StarGeofenceDataOrBuilder> getGeofenceOrBuilderList() {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r8 = this.geofenceBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.geofence_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            int r8 = 0;
        L4:
            if (r8 >= getGeofenceCount()) goto L9;
            if (getGeofence(r8).isInitialized() == false) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return false;
        L9:
            int r10 = 0;
        L11:
            if (r10 >= getBreachEventCount()) goto L16;
            if (getBreachEvent(r10).isInitialized() == false) goto L14;
            r10 = r10 + 1;
            goto L11
        L14:
            return false;
        L16:
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

        public Builder removeBreachEvent(int r8) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = this.breachEventBuilder_;
            if (r10 != null) goto L5;
            ensureBreachEventIsMutable();
            this.breachEvent_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeGeofence(int r8) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r10 = this.geofenceBuilder_;
            if (r10 != null) goto L5;
            ensureGeofenceIsMutable();
            this.geofence_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setBreachEvent(int r8, BreachEventData.Builder r10) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r11 = this.breachEventBuilder_;
            if (r11 != null) goto L5;
            ensureBreachEventIsMutable();
            this.breachEvent_.set(r8, r10.build());
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

        public Builder setGeofence(int r8, StarGeofenceData.Builder r10) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r11 = this.geofenceBuilder_;
            if (r11 != null) goto L5;
            ensureGeofenceIsMutable();
            this.geofence_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
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
            this.geofence_ = Collections.emptyList();
            this.breachEvent_ = Collections.emptyList();
        }

        public Builder addBreachEvent(int r8, BreachEventData r10) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r11 = this.breachEventBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureBreachEventIsMutable();
            this.breachEvent_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public BreachEventData.Builder addBreachEventBuilder(int r8) {
            return (BreachEventData.Builder) getBreachEventFieldBuilder().addBuilder(r8, BreachEventData.getDefaultInstance());
        }

        public Builder addGeofence(int r8, StarGeofenceData r10) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r11 = this.geofenceBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureGeofenceIsMutable();
            this.geofence_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public StarGeofenceData.Builder addGeofenceBuilder(int r8) {
            return (StarGeofenceData.Builder) getGeofenceFieldBuilder().addBuilder(r8, StarGeofenceData.getDefaultInstance());
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
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceProto_fieldAccessorTable.ensureFieldAccessorsInitialized(StarGeofenceProto.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setBreachEvent(int r8, BreachEventData r10) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r11 = this.breachEventBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureBreachEventIsMutable();
            this.breachEvent_.set(r8, r10);
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

        public Builder setGeofence(int r8, StarGeofenceData r10) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r11 = this.geofenceBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureGeofenceIsMutable();
            this.geofence_.set(r8, r10);
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

        public Builder addBreachEvent(BreachEventData.Builder r8) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = this.breachEventBuilder_;
            if (r10 != null) goto L5;
            ensureBreachEventIsMutable();
            this.breachEvent_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addGeofence(StarGeofenceData.Builder r8) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r10 = this.geofenceBuilder_;
            if (r10 != null) goto L5;
            ensureGeofenceIsMutable();
            this.geofence_.add(r8.build());
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
        public StarGeofenceProto build() {
            StarGeofenceProto r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public StarGeofenceProto buildPartial() {
            StarGeofenceProto r8 = new StarGeofenceProto(this, null);
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
        public StarGeofenceProto getDefaultInstanceForType() {
            return StarGeofenceProto.getDefaultInstance();
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

        public Builder addBreachEvent(BreachEventData r8) {
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = this.breachEventBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureBreachEventIsMutable();
            this.breachEvent_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addGeofence(StarGeofenceData r8) {
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r10 = this.geofenceBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureGeofenceIsMutable();
            this.geofence_.add(r8);
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
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r8 = this.geofenceBuilder_;
            if (r8 != null) goto L5;
            this.geofence_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = this.breachEventBuilder_;
            if (r10 != null) goto L9;
            this.breachEvent_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -3;
            return this;
        L9:
            this.breachEvent_ = null;
            r10.clear();
            goto L10
        L5:
            this.geofence_ = null;
            r8.clear();
            goto L6
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
            if (r12 == 10) goto L19;
            if (r12 != 18) goto L12;
            GeneratedMessage.ExtendableMessageOrBuilder r13 = (BreachEventData) r8.readMessage(BreachEventData.PARSER, r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            RepeatedFieldBuilderV3 r14 = this.breachEventBuilder_;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r14 == null) goto L16;
        L18:
            r14.addMessage(r13);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L16:
            ensureBreachEventIsMutable();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            List r15 = this.breachEvent_;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L17:
            r15.add(r13);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L19:
            r13 = (StarGeofenceData) r8.readMessage(StarGeofenceData.PARSER, r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            r14 = this.geofenceBuilder_;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            if (r14 != null) goto L18;
            ensureGeofenceIsMutable();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
            r15 = this.geofence_;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
        L23:
            r11 = true;
            goto L4
        L24:
            th = move-exception;
            onChanged();
            throw th;
        L26:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L24
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
            if ((r8 instanceof StarGeofenceProto) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((StarGeofenceProto) r8);
        }

        public Builder mergeFrom(StarGeofenceProto r8) {
            if (r8 != StarGeofenceProto.getDefaultInstance()) goto L5;
            return this;
        L5:
            RepeatedFieldBuilderV3<BreachEventData, BreachEventData.Builder, BreachEventDataOrBuilder> r10 = null;
            if (this.geofenceBuilder_ != null) goto L15;
            if (StarGeofenceProto.access$300(r8).isEmpty() == true) goto L25;
            if (this.geofence_.isEmpty() == false) goto L12;
            this.geofence_ = StarGeofenceProto.access$300(r8);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L25
        L12:
            ensureGeofenceIsMutable();
            this.geofence_.addAll(StarGeofenceProto.access$300(r8));
        L25:
            if (this.breachEventBuilder_ != null) goto L34;
            if (StarGeofenceProto.access$400(r8).isEmpty() == false) goto L29;
        L42:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L29:
            if (this.breachEvent_.isEmpty() == false) goto L31;
            this.breachEvent_ = StarGeofenceProto.access$400(r8);
            this.bitField0_ &= -3;
        L32:
            onChanged();
            goto L42
        L31:
            ensureBreachEventIsMutable();
            this.breachEvent_.addAll(StarGeofenceProto.access$400(r8));
            goto L32
        L34:
            if (StarGeofenceProto.access$400(r8).isEmpty() == true) goto L42;
            if (this.breachEventBuilder_.isEmpty() == false) goto L41;
            this.breachEventBuilder_.dispose();
            this.breachEventBuilder_ = null;
            this.breachEvent_ = StarGeofenceProto.access$400(r8);
            this.bitField0_ &= -3;
            if (StarGeofenceProto.access$600() == false) goto L40;
            r10 = getBreachEventFieldBuilder();
        L40:
            this.breachEventBuilder_ = r10;
            goto L42
        L41:
            this.breachEventBuilder_.addAllMessages(StarGeofenceProto.access$400(r8));
            goto L42
        L15:
            if (StarGeofenceProto.access$300(r8).isEmpty() == true) goto L25;
            if (this.geofenceBuilder_.isEmpty() == false) goto L23;
            this.geofenceBuilder_.dispose();
            this.geofenceBuilder_ = null;
            this.geofence_ = StarGeofenceProto.access$300(r8);
            this.bitField0_ &= -2;
            if (StarGeofenceProto.access$500() == false) goto L21;
            RepeatedFieldBuilderV3<StarGeofenceData, StarGeofenceData.Builder, StarGeofenceDataOrBuilder> r11 = getGeofenceFieldBuilder();
        L22:
            this.geofenceBuilder_ = r11;
            goto L25
        L21:
            r11 = null;
            goto L22
        L23:
            this.geofenceBuilder_.addAllMessages(StarGeofenceProto.access$300(r8));
            goto L25
        }
    }

    static {
        DEFAULT_INSTANCE = new StarGeofenceProto();
        PARSER = new AnonymousClass1();
    }

    private StarGeofenceProto() {
        this.memoizedIsInitialized = -1;
        this.geofence_ = Collections.emptyList();
        this.breachEvent_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$300(StarGeofenceProto r8) {
        return r8.geofence_;
    }

    public static /* synthetic */ List access$302(StarGeofenceProto r8, List r10) {
        r8.geofence_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(StarGeofenceProto r8) {
        return r8.breachEvent_;
    }

    public static /* synthetic */ List access$402(StarGeofenceProto r8, List r10) {
        r8.breachEvent_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$500() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$600() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static StarGeofenceProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceProto_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static StarGeofenceProto parseDelimitedFrom(InputStream r8) {
        return (StarGeofenceProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static StarGeofenceProto parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<StarGeofenceProto> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof StarGeofenceProto) == false) goto L8;
        StarGeofenceProto r10 = (StarGeofenceProto) r8;
        if (getGeofenceList().equals(r10.getGeofenceList()) == true) goto L13;
        return false;
    L13:
        if (getBreachEventList().equals(r10.getBreachEventList()) == true) goto L16;
        return false;
    L16:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public BreachEventData getBreachEvent(int r8) {
        return this.breachEvent_.get(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public int getBreachEventCount() {
        return this.breachEvent_.size();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public List<BreachEventData> getBreachEventList() {
        return this.breachEvent_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public BreachEventDataOrBuilder getBreachEventOrBuilder(int r8) {
        return this.breachEvent_.get(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public List<? extends BreachEventDataOrBuilder> getBreachEventOrBuilderList() {
        return this.breachEvent_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public StarGeofenceData getGeofence(int r8) {
        return this.geofence_.get(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public int getGeofenceCount() {
        return this.geofence_.size();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public List<StarGeofenceData> getGeofenceList() {
        return this.geofence_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public StarGeofenceDataOrBuilder getGeofenceOrBuilder(int r8) {
        return this.geofence_.get(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceProtoOrBuilder
    public List<? extends StarGeofenceDataOrBuilder> getGeofenceOrBuilderList() {
        return this.geofence_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<StarGeofenceProto> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.geofence_.size()) goto L10;
        r12 = r12 + CodedOutputStream.computeMessageSize(1, this.geofence_.get(r11));
        r11 = r11 + 1;
    L10:
        if (r10 >= this.breachEvent_.size()) goto L12;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.breachEvent_.get(r10));
        r10 = r10 + 1;
        goto L10
    L12:
        int r13 = getUnknownFields().getSerializedSize() + r12;
        this.memoizedSize = r13;
        return r13;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (getGeofenceCount() <= 0) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getGeofenceList().hashCode();
    L9:
        if (getBreachEventCount() <= 0) goto L11;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getBreachEventList().hashCode();
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
        if (r8 != 0) goto L8;
        return false;
    L8:
        int r10 = 0;
    L10:
        if (r10 >= getGeofenceCount()) goto L16;
        if (getGeofence(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        int r11 = 0;
    L18:
        if (r11 >= getBreachEventCount()) goto L24;
        if (getBreachEvent(r11).isInitialized() == false) goto L21;
        r11 = r11 + 1;
        goto L18
    L21:
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
        return new StarGeofenceProto();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.geofence_.size()) goto L7;
        r8.writeMessage(1, this.geofence_.get(r11));
        r11 = r11 + 1;
    L7:
        if (r10 >= this.breachEvent_.size()) goto L9;
        r8.writeMessage(2, this.breachEvent_.get(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        getUnknownFields().writeTo(r8);
    }

    private StarGeofenceProto(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(StarGeofenceProto r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static StarGeofenceProto parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StarGeofenceProto) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static StarGeofenceProto parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceProto_fieldAccessorTable.ensureFieldAccessorsInitialized(StarGeofenceProto.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ StarGeofenceProto(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static StarGeofenceProto parseFrom(CodedInputStream r8) {
        return (StarGeofenceProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public StarGeofenceProto getDefaultInstanceForType() {
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

    public static StarGeofenceProto parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (StarGeofenceProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static StarGeofenceProto parseFrom(InputStream r8) {
        return (StarGeofenceProto) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static StarGeofenceProto parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StarGeofenceProto) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static StarGeofenceProto parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static StarGeofenceProto parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static StarGeofenceProto parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static StarGeofenceProto parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
