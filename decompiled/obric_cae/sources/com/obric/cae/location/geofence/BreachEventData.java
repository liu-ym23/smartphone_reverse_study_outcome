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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BreachEventData extends GeneratedMessageV3 implements BreachEventDataOrBuilder {
    public static final int BREACH_HACC_FIELD_NUMBER = 4;
    public static final int BREACH_LATITUDE_FIELD_NUMBER = 2;
    public static final int BREACH_LONGITUDE_FIELD_NUMBER = 3;
    private static final BreachEventData DEFAULT_INSTANCE = null;
    public static final int EVENT_FIELD_NUMBER = 9;
    public static final int EVENT_TIMESTAMP_FIELD_NUMBER = 1;
    public static final int FIRST_BREACH_FIELD_NUMBER = 11;
    public static final int GEOFENCE_ID_FIELD_NUMBER = 8;

    @Deprecated
    public static final Parser<BreachEventData> PARSER = null;
    public static final int PROVIDER_FIELD_NUMBER = 5;
    public static final int RESPONSE_RATE_FIELD_NUMBER = 10;
    public static final int SIM_CARD_STATUS_FIELD_NUMBER = 7;
    public static final int SOURCE_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private float breachHacc_;
    private double breachLatitude_;
    private double breachLongitude_;
    private long eventTimestamp_;
    private Internal.IntList event_;
    private Internal.BooleanList firstBreach_;
    private LazyStringList geofenceId_;
    private byte memoizedIsInitialized;
    private volatile Object provider_;
    private Internal.FloatList responseRate_;
    private int simCardStatus_;
    private int source_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreachEventDataOrBuilder {
        private int bitField0_;
        private float breachHacc_;
        private double breachLatitude_;
        private double breachLongitude_;
        private long eventTimestamp_;
        private Internal.IntList event_;
        private Internal.BooleanList firstBreach_;
        private LazyStringList geofenceId_;
        private Object provider_;
        private Internal.FloatList responseRate_;
        private int simCardStatus_;
        private int source_;

        private Builder() {
            this.provider_ = "";
            this.geofenceId_ = LazyStringArrayList.EMPTY;
            this.event_ = BreachEventData.access$1800();
            this.responseRate_ = BreachEventData.access$2100();
            this.firstBreach_ = BreachEventData.access$2400();
        }

        private void buildPartial0(BreachEventData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            BreachEventData.access$1002(r8, this.eventTimestamp_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            BreachEventData.access$1102(r8, this.breachLatitude_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            BreachEventData.access$1202(r8, this.breachLongitude_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            BreachEventData.access$1302(r8, this.breachHacc_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            BreachEventData.access$1402(r8, this.provider_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            BreachEventData.access$1502(r8, this.source_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L24;
            BreachEventData.access$1602(r8, this.simCardStatus_);
            r11 = r11 | 64;
        L24:
            BreachEventData.access$1776(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(BreachEventData r8) {
            if ((this.bitField0_ & 128) == 0) goto L5;
            this.geofenceId_ = this.geofenceId_.getUnmodifiableView();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        L5:
            BreachEventData.access$602(r8, this.geofenceId_);
            if ((this.bitField0_ & 256) == 0) goto L8;
            this.event_.makeImmutable();
            this.bitField0_ &= -257;
        L8:
            BreachEventData.access$702(r8, this.event_);
            if ((this.bitField0_ & 512) == 0) goto L11;
            this.responseRate_.makeImmutable();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L11:
            BreachEventData.access$802(r8, this.responseRate_);
            if ((this.bitField0_ & 1024) == 0) goto L14;
            this.firstBreach_.makeImmutable();
            this.bitField0_ &= -1025;
        L14:
            BreachEventData.access$902(r8, this.firstBreach_);
        }

        private void ensureEventIsMutable() {
            if ((this.bitField0_ & 256) != 0) goto L6;
            this.event_ = BreachEventData.access$1900(this.event_);
            this.bitField0_ |= 256;
            return;
        }

        private void ensureFirstBreachIsMutable() {
            if ((this.bitField0_ & 1024) != 0) goto L6;
            this.firstBreach_ = BreachEventData.access$2500(this.firstBreach_);
            this.bitField0_ |= 1024;
            return;
        }

        private void ensureGeofenceIdIsMutable() {
            if ((this.bitField0_ & 128) != 0) goto L6;
            this.geofenceId_ = new LazyStringArrayList(this.geofenceId_);
            this.bitField0_ |= 128;
            return;
        }

        private void ensureResponseRateIsMutable() {
            if ((this.bitField0_ & 512) != 0) goto L6;
            this.responseRate_ = BreachEventData.access$2200(this.responseRate_);
            this.bitField0_ |= 512;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_BreachEventData_descriptor;
        }

        public Builder addAllEvent(Iterable<? extends Integer> r8) {
            ensureEventIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.event_);
            onChanged();
            return this;
        }

        public Builder addAllFirstBreach(Iterable<? extends Boolean> r8) {
            ensureFirstBreachIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.firstBreach_);
            onChanged();
            return this;
        }

        public Builder addAllGeofenceId(Iterable<String> r8) {
            ensureGeofenceIdIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.geofenceId_);
            onChanged();
            return this;
        }

        public Builder addAllResponseRate(Iterable<? extends Float> r8) {
            ensureResponseRateIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.responseRate_);
            onChanged();
            return this;
        }

        public Builder addEvent(int r8) {
            ensureEventIsMutable();
            this.event_.addInt(r8);
            onChanged();
            return this;
        }

        public Builder addFirstBreach(boolean r8) {
            ensureFirstBreachIsMutable();
            this.firstBreach_.addBoolean(r8);
            onChanged();
            return this;
        }

        public Builder addGeofenceId(String r8) {
            if (r8 == null) goto L6;
            ensureGeofenceIdIsMutable();
            this.geofenceId_.add(r8);
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder addGeofenceIdBytes(ByteString r8) {
            if (r8 == null) goto L6;
            ensureGeofenceIdIsMutable();
            this.geofenceId_.add(r8);
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addResponseRate(float r8) {
            ensureResponseRateIsMutable();
            this.responseRate_.addFloat(r8);
            onChanged();
            return this;
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

        public Builder clearBreachHacc() {
            this.bitField0_ &= -9;
            this.breachHacc_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearBreachLatitude() {
            this.bitField0_ &= -3;
            this.breachLatitude_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearBreachLongitude() {
            this.bitField0_ &= -5;
            this.breachLongitude_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearEvent() {
            this.event_ = BreachEventData.access$2000();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder clearEventTimestamp() {
            this.bitField0_ &= -2;
            this.eventTimestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearFirstBreach() {
            this.firstBreach_ = BreachEventData.access$2600();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        public Builder clearGeofenceId() {
            this.geofenceId_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearProvider() {
            this.provider_ = BreachEventData.getDefaultInstance().getProvider();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearResponseRate() {
            this.responseRate_ = BreachEventData.access$2300();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            onChanged();
            return this;
        }

        public Builder clearSimCardStatus() {
            this.bitField0_ &= -65;
            this.simCardStatus_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSource() {
            this.bitField0_ &= -33;
            this.source_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public float getBreachHacc() {
            return this.breachHacc_;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public double getBreachLatitude() {
            return this.breachLatitude_;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public double getBreachLongitude() {
            return this.breachLongitude_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_BreachEventData_descriptor;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public int getEvent(int r8) {
            return this.event_.getInt(r8);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public int getEventCount() {
            return this.event_.size();
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public List<Integer> getEventList() {
            int r8 = this.bitField0_ & 256;
            Internal.IntList r10 = this.event_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public long getEventTimestamp() {
            return this.eventTimestamp_;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean getFirstBreach(int r8) {
            return this.firstBreach_.getBoolean(r8);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public int getFirstBreachCount() {
            return this.firstBreach_.size();
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public List<Boolean> getFirstBreachList() {
            int r8 = this.bitField0_ & 1024;
            Internal.BooleanList r10 = this.firstBreach_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public String getGeofenceId(int r8) {
            return this.geofenceId_.get(r8);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public ByteString getGeofenceIdBytes(int r8) {
            return this.geofenceId_.getByteString(r8);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public int getGeofenceIdCount() {
            return this.geofenceId_.size();
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public ProtocolStringList getGeofenceIdList() {
            return this.geofenceId_.getUnmodifiableView();
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public String getProvider() {
            Object r8 = this.provider_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.provider_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public ByteString getProviderBytes() {
            Object r8 = this.provider_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.provider_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public float getResponseRate(int r8) {
            return this.responseRate_.getFloat(r8);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public int getResponseRateCount() {
            return this.responseRate_.size();
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public List<Float> getResponseRateList() {
            int r8 = this.bitField0_ & 512;
            Internal.FloatList r10 = this.responseRate_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public int getSimCardStatus() {
            return this.simCardStatus_;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public int getSource() {
            return this.source_;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean hasBreachHacc() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean hasBreachLatitude() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean hasBreachLongitude() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean hasEventTimestamp() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean hasProvider() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean hasSimCardStatus() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public boolean hasSource() {
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
            if (hasEventTimestamp() == true) goto L6;
            return false;
        L6:
            if (hasBreachLatitude() == true) goto L9;
            return false;
        L9:
            if (hasBreachLongitude() == true) goto L12;
            return false;
        L12:
            if (hasBreachHacc() == true) goto L15;
            return false;
        L15:
            if (hasSimCardStatus() == true) goto L17;
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

        public Builder setBreachHacc(float r8) {
            this.breachHacc_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setBreachLatitude(double r8) {
            this.breachLatitude_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setBreachLongitude(double r8) {
            this.breachLongitude_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setEvent(int r8, int r10) {
            ensureEventIsMutable();
            this.event_.setInt(r8, r10);
            onChanged();
            return this;
        }

        public Builder setEventTimestamp(long r8) {
            this.eventTimestamp_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setFirstBreach(int r8, boolean r10) {
            ensureFirstBreachIsMutable();
            this.firstBreach_.setBoolean(r8, r10);
            onChanged();
            return this;
        }

        public Builder setGeofenceId(int r8, String r10) {
            if (r10 == null) goto L6;
            ensureGeofenceIdIsMutable();
            this.geofenceId_.set(r8, r10);
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setProvider(String r8) {
            if (r8 == null) goto L6;
            this.provider_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setProviderBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.provider_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L6:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setResponseRate(int r8, float r10) {
            ensureResponseRateIsMutable();
            this.responseRate_.setFloat(r8, r10);
            onChanged();
            return this;
        }

        public Builder setSimCardStatus(int r8) {
            this.simCardStatus_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setSource(int r8) {
            this.source_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.provider_ = "";
            this.geofenceId_ = LazyStringArrayList.EMPTY;
            this.event_ = BreachEventData.access$1800();
            this.responseRate_ = BreachEventData.access$2100();
            this.firstBreach_ = BreachEventData.access$2400();
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

        @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
        public /* bridge */ /* synthetic */ List getGeofenceIdList() {
            return getGeofenceIdList();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_BreachEventData_fieldAccessorTable.ensureFieldAccessorsInitialized(BreachEventData.class, Builder.class);
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
        public BreachEventData build() {
            BreachEventData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BreachEventData buildPartial() {
            BreachEventData r8 = new BreachEventData(this, null);
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
        public BreachEventData getDefaultInstanceForType() {
            return BreachEventData.getDefaultInstance();
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
            this.eventTimestamp_ = 0;
            this.breachLatitude_ = 0.0d;
            this.breachLongitude_ = 0.0d;
            this.breachHacc_ = 0.0f;
            this.provider_ = "";
            this.source_ = 0;
            this.simCardStatus_ = 0;
            this.geofenceId_ = LazyStringArrayList.EMPTY;
            this.bitField0_ = 0 & NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.event_ = BreachEventData.access$200();
            this.responseRate_ = BreachEventData.access$300();
            this.firstBreach_ = BreachEventData.access$400();
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
            switch(r12) {
                case 0: goto L33;
                case 8: goto L31;
                case 17: goto L30;
                case 25: goto L29;
                case 37: goto L28;
                case 42: goto L27;
                case 48: goto L26;
                case 56: goto L25;
                case 66: goto L24;
                case 72: goto L23;
                case 74: goto L19;
                case 82: goto L15;
                case 85: goto L14;
                case 88: goto L13;
                case 90: goto L8;
                default: goto L34;
            };     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L8:
            int r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureFirstBreachIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L10:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.firstBreach_.addBoolean(r8.readBool());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L12:
            r8.popLimit(r13);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L13:
            boolean r14 = r8.readBool();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureFirstBreachIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.firstBreach_.addBoolean(r14);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L14:
            float r15 = r8.readFloat();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureResponseRateIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.responseRate_.addFloat(r15);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L15:
            r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureResponseRateIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L17:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.responseRate_.addFloat(r8.readFloat());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L17
        L19:
            r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureEventIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L21:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.event_.addInt(r8.readUInt32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L21
        L23:
            int r16 = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureEventIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.event_.addInt(r16);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L24:
            ByteString r17 = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureGeofenceIdIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.geofenceId_.add(r17);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L25:
            this.simCardStatus_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 64;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L26:
            this.source_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L27:
            this.provider_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 16;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L28:
            this.breachHacc_ = r8.readFloat();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L29:
            this.breachLongitude_ = r8.readDouble();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 4;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L30:
            this.breachLatitude_ = r8.readDouble();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 2;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L31:
            this.eventTimestamp_ = r8.readUInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L33:
            r11 = true;
            goto L4
        L34:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
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
            if ((r8 instanceof BreachEventData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((BreachEventData) r8);
        }

        public Builder mergeFrom(BreachEventData r8) {
            if (r8 != BreachEventData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasEventTimestamp() == false) goto L9;
            setEventTimestamp(r8.getEventTimestamp());
        L9:
            if (r8.hasBreachLatitude() == false) goto L12;
            setBreachLatitude(r8.getBreachLatitude());
        L12:
            if (r8.hasBreachLongitude() == false) goto L15;
            setBreachLongitude(r8.getBreachLongitude());
        L15:
            if (r8.hasBreachHacc() == false) goto L18;
            setBreachHacc(r8.getBreachHacc());
        L18:
            if (r8.hasProvider() == false) goto L21;
            this.provider_ = BreachEventData.access$1400(r8);
            this.bitField0_ |= 16;
            onChanged();
        L21:
            if (r8.hasSource() == false) goto L24;
            setSource(r8.getSource());
        L24:
            if (r8.hasSimCardStatus() == false) goto L27;
            setSimCardStatus(r8.getSimCardStatus());
        L27:
            if (BreachEventData.access$600(r8).isEmpty() == true) goto L34;
            if (this.geofenceId_.isEmpty() == false) goto L31;
            this.geofenceId_ = BreachEventData.access$600(r8);
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        L32:
            onChanged();
            goto L34
        L31:
            ensureGeofenceIdIsMutable();
            this.geofenceId_.addAll(BreachEventData.access$600(r8));
        L34:
            if (BreachEventData.access$700(r8).isEmpty() == true) goto L41;
            if (this.event_.isEmpty() == false) goto L38;
            this.event_ = BreachEventData.access$700(r8);
            this.bitField0_ &= -257;
        L39:
            onChanged();
            goto L41
        L38:
            ensureEventIsMutable();
            this.event_.addAll(BreachEventData.access$700(r8));
        L41:
            if (BreachEventData.access$800(r8).isEmpty() == true) goto L48;
            if (this.responseRate_.isEmpty() == false) goto L45;
            this.responseRate_ = BreachEventData.access$800(r8);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L46:
            onChanged();
            goto L48
        L45:
            ensureResponseRateIsMutable();
            this.responseRate_.addAll(BreachEventData.access$800(r8));
        L48:
            if (BreachEventData.access$900(r8).isEmpty() == false) goto L50;
        L54:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L50:
            if (this.firstBreach_.isEmpty() == false) goto L52;
            this.firstBreach_ = BreachEventData.access$900(r8);
            this.bitField0_ &= -1025;
        L53:
            onChanged();
            goto L54
        L52:
            ensureFirstBreachIsMutable();
            this.firstBreach_.addAll(BreachEventData.access$900(r8));
            goto L53
        }
    }

    static {
        DEFAULT_INSTANCE = new BreachEventData();
        PARSER = new AnonymousClass1();
    }

    private BreachEventData() {
        this.eventTimestamp_ = 0;
        this.breachLatitude_ = 0.0d;
        this.breachLongitude_ = 0.0d;
        this.breachHacc_ = 0.0f;
        this.provider_ = "";
        this.source_ = 0;
        this.simCardStatus_ = 0;
        this.memoizedIsInitialized = -1;
        this.provider_ = "";
        this.geofenceId_ = LazyStringArrayList.EMPTY;
        this.event_ = GeneratedMessage.emptyIntList();
        this.responseRate_ = GeneratedMessage.emptyFloatList();
        this.firstBreach_ = GeneratedMessage.emptyBooleanList();
    }

    public static /* synthetic */ long access$1002(BreachEventData r8, long r10) {
        r8.eventTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$1102(BreachEventData r8, double r10) {
        r8.breachLatitude_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$1202(BreachEventData r8, double r10) {
        r8.breachLongitude_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1302(BreachEventData r8, float r10) {
        r8.breachHacc_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1400(BreachEventData r8) {
        return r8.provider_;
    }

    public static /* synthetic */ Object access$1402(BreachEventData r8, Object r10) {
        r8.provider_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(BreachEventData r8, int r10) {
        r8.source_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(BreachEventData r8, int r10) {
        r8.simCardStatus_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1776(BreachEventData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Internal.IntList access$1800() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Internal.IntList access$1900(Internal.IntList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.IntList access$200() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Internal.IntList access$2000() {
        return GeneratedMessage.emptyIntList();
    }

    public static /* synthetic */ Internal.FloatList access$2100() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$2200(Internal.FloatList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.FloatList access$2300() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.BooleanList access$2400() {
        return GeneratedMessage.emptyBooleanList();
    }

    public static /* synthetic */ Internal.BooleanList access$2500(Internal.BooleanList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.BooleanList access$2600() {
        return GeneratedMessage.emptyBooleanList();
    }

    public static /* synthetic */ Internal.FloatList access$300() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.BooleanList access$400() {
        return GeneratedMessage.emptyBooleanList();
    }

    public static /* synthetic */ LazyStringList access$600(BreachEventData r8) {
        return r8.geofenceId_;
    }

    public static /* synthetic */ LazyStringList access$602(BreachEventData r8, LazyStringList r10) {
        r8.geofenceId_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.IntList access$700(BreachEventData r8) {
        return r8.event_;
    }

    public static /* synthetic */ Internal.IntList access$702(BreachEventData r8, Internal.IntList r10) {
        r8.event_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.FloatList access$800(BreachEventData r8) {
        return r8.responseRate_;
    }

    public static /* synthetic */ Internal.FloatList access$802(BreachEventData r8, Internal.FloatList r10) {
        r8.responseRate_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.BooleanList access$900(BreachEventData r8) {
        return r8.firstBreach_;
    }

    public static /* synthetic */ Internal.BooleanList access$902(BreachEventData r8, Internal.BooleanList r10) {
        r8.firstBreach_ = r10;
        return r10;
    }

    public static BreachEventData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_BreachEventData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BreachEventData parseDelimitedFrom(InputStream r8) {
        return (BreachEventData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static BreachEventData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<BreachEventData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof BreachEventData) == false) goto L8;
        BreachEventData r10 = (BreachEventData) r8;
        if (hasEventTimestamp() == r10.hasEventTimestamp()) goto L13;
        return false;
    L13:
        if (hasEventTimestamp() == false) goto L18;
        if (getEventTimestamp() == r10.getEventTimestamp()) goto L18;
        return false;
    L18:
        if (hasBreachLatitude() == r10.hasBreachLatitude()) goto L21;
        return false;
    L21:
        if (hasBreachLatitude() == false) goto L26;
        if (Double.doubleToLongBits(getBreachLatitude()) == Double.doubleToLongBits(r10.getBreachLatitude())) goto L26;
        return false;
    L26:
        if (hasBreachLongitude() == r10.hasBreachLongitude()) goto L29;
        return false;
    L29:
        if (hasBreachLongitude() == false) goto L34;
        if (Double.doubleToLongBits(getBreachLongitude()) == Double.doubleToLongBits(r10.getBreachLongitude())) goto L34;
        return false;
    L34:
        if (hasBreachHacc() == r10.hasBreachHacc()) goto L37;
        return false;
    L37:
        if (hasBreachHacc() == false) goto L42;
        if (Float.floatToIntBits(getBreachHacc()) == Float.floatToIntBits(r10.getBreachHacc())) goto L42;
        return false;
    L42:
        if (hasProvider() == r10.hasProvider()) goto L45;
        return false;
    L45:
        if (hasProvider() == false) goto L50;
        if (getProvider().equals(r10.getProvider()) == true) goto L50;
        return false;
    L50:
        if (hasSource() == r10.hasSource()) goto L53;
        return false;
    L53:
        if (hasSource() == false) goto L58;
        if (getSource() == r10.getSource()) goto L58;
        return false;
    L58:
        if (hasSimCardStatus() == r10.hasSimCardStatus()) goto L61;
        return false;
    L61:
        if (hasSimCardStatus() == false) goto L66;
        if (getSimCardStatus() == r10.getSimCardStatus()) goto L66;
        return false;
    L66:
        if (getGeofenceIdList().equals(r10.getGeofenceIdList()) == true) goto L69;
        return false;
    L69:
        if (getEventList().equals(r10.getEventList()) == true) goto L72;
        return false;
    L72:
        if (getResponseRateList().equals(r10.getResponseRateList()) == true) goto L75;
        return false;
    L75:
        if (getFirstBreachList().equals(r10.getFirstBreachList()) == true) goto L78;
        return false;
    L78:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L80;
        return false;
    L80:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public float getBreachHacc() {
        return this.breachHacc_;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public double getBreachLatitude() {
        return this.breachLatitude_;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public double getBreachLongitude() {
        return this.breachLongitude_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public int getEvent(int r8) {
        return this.event_.getInt(r8);
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public int getEventCount() {
        return this.event_.size();
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public List<Integer> getEventList() {
        return this.event_;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public long getEventTimestamp() {
        return this.eventTimestamp_;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean getFirstBreach(int r8) {
        return this.firstBreach_.getBoolean(r8);
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public int getFirstBreachCount() {
        return this.firstBreach_.size();
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public List<Boolean> getFirstBreachList() {
        return this.firstBreach_;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public String getGeofenceId(int r8) {
        return this.geofenceId_.get(r8);
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public ByteString getGeofenceIdBytes(int r8) {
        return this.geofenceId_.getByteString(r8);
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public int getGeofenceIdCount() {
        return this.geofenceId_.size();
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public ProtocolStringList getGeofenceIdList() {
        return this.geofenceId_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<BreachEventData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public String getProvider() {
        Object r8 = this.provider_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.provider_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public ByteString getProviderBytes() {
        Object r8 = this.provider_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.provider_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public float getResponseRate(int r8) {
        return this.responseRate_.getFloat(r8);
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public int getResponseRateCount() {
        return this.responseRate_.size();
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public List<Float> getResponseRateList() {
        return this.responseRate_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = CodedOutputStream.computeUInt64Size(1, this.eventTimestamp_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + CodedOutputStream.computeDoubleSize(2, this.breachLatitude_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeDoubleSize(3, this.breachLongitude_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L19;
        r11 = r11 + CodedOutputStream.computeFloatSize(4, this.breachHacc_);
    L19:
        if ((this.bitField0_ & 16) == 0) goto L22;
        r11 = r11 + GeneratedMessage.computeStringSize(5, this.provider_);
    L22:
        if ((this.bitField0_ & 32) == 0) goto L25;
        r11 = r11 + CodedOutputStream.computeUInt32Size(6, this.source_);
    L25:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r11 = r11 + CodedOutputStream.computeUInt32Size(7, this.simCardStatus_);
    L27:
        int r12 = 0;
        int r13 = 0;
    L29:
        if (r12 >= this.geofenceId_.size()) goto L31;
        r13 = r13 + GeneratedMessage.computeStringSizeNoTag(this.geofenceId_.getRaw(r12));
        r12 = r12 + 1;
        goto L29
    L31:
        int r14 = (getGeofenceIdList().size() * 1) + (r11 + r13);
        int r15 = 0;
    L33:
        if (r10 >= this.event_.size()) goto L35;
        r15 = r15 + CodedOutputStream.computeUInt32SizeNoTag(this.event_.getInt(r10));
        r10 = r10 + 1;
        goto L33
    L35:
        int r16 = getUnknownFields().getSerializedSize() + ((getFirstBreachList().size() * 1) + ((getFirstBreachList().size() * 1) + ((getResponseRateList().size() * 1) + ((getResponseRateList().size() * 4) + ((getEventList().size() * 1) + (r14 + r15))))));
        this.memoizedSize = r16;
        return r16;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public int getSimCardStatus() {
        return this.simCardStatus_;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public int getSource() {
        return this.source_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean hasBreachHacc() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean hasBreachLatitude() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean hasBreachLongitude() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean hasEventTimestamp() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean hasProvider() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean hasSimCardStatus() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public boolean hasSource() {
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
        if (hasEventTimestamp() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + Internal.hashLong(getEventTimestamp());
    L9:
        if (hasBreachLatitude() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + Internal.hashLong(Double.doubleToLongBits(getBreachLatitude()));
    L12:
        if (hasBreachLongitude() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashLong(Double.doubleToLongBits(getBreachLongitude()));
    L15:
        if (hasBreachHacc() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + Float.floatToIntBits(getBreachHacc());
    L18:
        if (hasProvider() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getProvider().hashCode();
    L21:
        if (hasSource() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getSource();
    L24:
        if (hasSimCardStatus() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 7, 53) + getSimCardStatus();
    L27:
        if (getGeofenceIdCount() <= 0) goto L30;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getGeofenceIdList().hashCode();
    L30:
        if (getEventCount() <= 0) goto L33;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getEventList().hashCode();
    L33:
        if (getResponseRateCount() <= 0) goto L36;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getResponseRateList().hashCode();
    L36:
        if (getFirstBreachCount() <= 0) goto L38;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getFirstBreachList().hashCode();
    L38:
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
        if (hasEventTimestamp() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasBreachLatitude() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasBreachLongitude() == true) goto L21;
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasBreachHacc() == true) goto L25;
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (hasSimCardStatus() == true) goto L28;
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
        return new BreachEventData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeUInt64(1, this.eventTimestamp_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeDouble(2, this.breachLatitude_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeDouble(3, this.breachLongitude_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeFloat(4, this.breachHacc_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        GeneratedMessage.writeString(r8, 5, this.provider_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeUInt32(6, this.source_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L23;
        r8.writeUInt32(7, this.simCardStatus_);
    L23:
        int r10 = 0;
        int r11 = 0;
    L25:
        if (r11 >= this.geofenceId_.size()) goto L27;
        GeneratedMessage.writeString(r8, 8, this.geofenceId_.getRaw(r11));
        r11 = r11 + 1;
        goto L25
    L27:
        int r12 = 0;
    L29:
        if (r12 >= this.event_.size()) goto L31;
        r8.writeUInt32(9, this.event_.getInt(r12));
        r12 = r12 + 1;
        goto L29
    L31:
        int r13 = 0;
    L33:
        if (r13 >= this.responseRate_.size()) goto L36;
        r8.writeFloat(10, this.responseRate_.getFloat(r13));
        r13 = r13 + 1;
    L36:
        if (r10 >= this.firstBreach_.size()) goto L38;
        r8.writeBool(11, this.firstBreach_.getBoolean(r10));
        r10 = r10 + 1;
        goto L36
    L38:
        getUnknownFields().writeTo(r8);
    }

    private BreachEventData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.eventTimestamp_ = 0;
        this.breachLatitude_ = 0.0d;
        this.breachLongitude_ = 0.0d;
        this.breachHacc_ = 0.0f;
        this.provider_ = "";
        this.source_ = 0;
        this.simCardStatus_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(BreachEventData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static BreachEventData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (BreachEventData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static BreachEventData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.location.geofence.BreachEventDataOrBuilder
    public /* bridge */ /* synthetic */ List getGeofenceIdList() {
        return getGeofenceIdList();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_BreachEventData_fieldAccessorTable.ensureFieldAccessorsInitialized(BreachEventData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ BreachEventData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static BreachEventData parseFrom(CodedInputStream r8) {
        return (BreachEventData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public BreachEventData getDefaultInstanceForType() {
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

    public static BreachEventData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (BreachEventData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static BreachEventData parseFrom(InputStream r8) {
        return (BreachEventData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static BreachEventData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (BreachEventData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static BreachEventData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static BreachEventData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static BreachEventData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static BreachEventData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
