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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class StarGeofenceData extends GeneratedMessageV3 implements StarGeofenceDataOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 9;
    public static final int ADD_TIMESTAMP_FIELD_NUMBER = 10;
    private static final StarGeofenceData DEFAULT_INSTANCE = null;
    public static final int DELETE_TIMESTAMP_FIELD_NUMBER = 11;
    public static final int GEOFENCE_ID_FIELD_NUMBER = 1;
    public static final int GEO_TYPE_FIELD_NUMBER = 8;
    public static final int LATITUDE_FIELD_NUMBER = 3;
    public static final int LONGITUDE_FIELD_NUMBER = 4;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 2;

    @Deprecated
    public static final Parser<StarGeofenceData> PARSER = null;
    public static final int RADIUS_FIELD_NUMBER = 5;
    public static final int RECOVER_TIMESTAMP_FIELD_NUMBER = 13;
    public static final int TRANSITION_TYPE_FIELD_NUMBER = 6;
    public static final int UPDATE_TIMESTAMP_FIELD_NUMBER = 12;
    private static final long serialVersionUID = 0;
    private Internal.LongList addTimestamp_;
    private volatile Object address_;
    private int bitField0_;
    private Internal.LongList deleteTimestamp_;
    private int geoType_;
    private volatile Object geofenceId_;
    private double latitude_;
    private double longitude_;
    private byte memoizedIsInitialized;
    private volatile Object packageName_;
    private int radius_;
    private Internal.LongList recoverTimestamp_;
    private int transitionType_;
    private Internal.LongList updateTimestamp_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StarGeofenceDataOrBuilder {
        private Internal.LongList addTimestamp_;
        private Object address_;
        private int bitField0_;
        private Internal.LongList deleteTimestamp_;
        private int geoType_;
        private Object geofenceId_;
        private double latitude_;
        private double longitude_;
        private Object packageName_;
        private int radius_;
        private Internal.LongList recoverTimestamp_;
        private int transitionType_;
        private Internal.LongList updateTimestamp_;

        private Builder() {
            this.geofenceId_ = "";
            this.packageName_ = "";
            this.address_ = "";
            this.addTimestamp_ = StarGeofenceData.access$2000();
            this.deleteTimestamp_ = StarGeofenceData.access$2300();
            this.updateTimestamp_ = StarGeofenceData.access$2600();
            this.recoverTimestamp_ = StarGeofenceData.access$2900();
        }

        private void buildPartial0(StarGeofenceData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            StarGeofenceData.access$1102(r8, this.geofenceId_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            StarGeofenceData.access$1202(r8, this.packageName_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            StarGeofenceData.access$1302(r8, this.latitude_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            StarGeofenceData.access$1402(r8, this.longitude_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            StarGeofenceData.access$1502(r8, this.radius_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            StarGeofenceData.access$1602(r8, this.transitionType_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            StarGeofenceData.access$1702(r8, this.geoType_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L27;
            StarGeofenceData.access$1802(r8, this.address_);
            r11 = r11 | 128;
        L27:
            StarGeofenceData.access$1976(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(StarGeofenceData r8) {
            if ((this.bitField0_ & 256) == 0) goto L5;
            this.addTimestamp_.makeImmutable();
            this.bitField0_ &= -257;
        L5:
            StarGeofenceData.access$702(r8, this.addTimestamp_);
            if ((this.bitField0_ & 512) == 0) goto L8;
            this.deleteTimestamp_.makeImmutable();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L8:
            StarGeofenceData.access$802(r8, this.deleteTimestamp_);
            if ((this.bitField0_ & 1024) == 0) goto L11;
            this.updateTimestamp_.makeImmutable();
            this.bitField0_ &= -1025;
        L11:
            StarGeofenceData.access$902(r8, this.updateTimestamp_);
            if ((this.bitField0_ & 2048) == 0) goto L14;
            this.recoverTimestamp_.makeImmutable();
            this.bitField0_ &= -2049;
        L14:
            StarGeofenceData.access$1002(r8, this.recoverTimestamp_);
        }

        private void ensureAddTimestampIsMutable() {
            if ((this.bitField0_ & 256) != 0) goto L6;
            this.addTimestamp_ = StarGeofenceData.access$2100(this.addTimestamp_);
            this.bitField0_ |= 256;
            return;
        }

        private void ensureDeleteTimestampIsMutable() {
            if ((this.bitField0_ & 512) != 0) goto L6;
            this.deleteTimestamp_ = StarGeofenceData.access$2400(this.deleteTimestamp_);
            this.bitField0_ |= 512;
            return;
        }

        private void ensureRecoverTimestampIsMutable() {
            if ((this.bitField0_ & 2048) != 0) goto L6;
            this.recoverTimestamp_ = StarGeofenceData.access$3000(this.recoverTimestamp_);
            this.bitField0_ |= 2048;
            return;
        }

        private void ensureUpdateTimestampIsMutable() {
            if ((this.bitField0_ & 1024) != 0) goto L6;
            this.updateTimestamp_ = StarGeofenceData.access$2700(this.updateTimestamp_);
            this.bitField0_ |= 1024;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceData_descriptor;
        }

        public Builder addAddTimestamp(long r8) {
            ensureAddTimestampIsMutable();
            this.addTimestamp_.addLong(r8);
            onChanged();
            return this;
        }

        public Builder addAllAddTimestamp(Iterable<? extends Long> r8) {
            ensureAddTimestampIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.addTimestamp_);
            onChanged();
            return this;
        }

        public Builder addAllDeleteTimestamp(Iterable<? extends Long> r8) {
            ensureDeleteTimestampIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.deleteTimestamp_);
            onChanged();
            return this;
        }

        public Builder addAllRecoverTimestamp(Iterable<? extends Long> r8) {
            ensureRecoverTimestampIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.recoverTimestamp_);
            onChanged();
            return this;
        }

        public Builder addAllUpdateTimestamp(Iterable<? extends Long> r8) {
            ensureUpdateTimestampIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.updateTimestamp_);
            onChanged();
            return this;
        }

        public Builder addDeleteTimestamp(long r8) {
            ensureDeleteTimestampIsMutable();
            this.deleteTimestamp_.addLong(r8);
            onChanged();
            return this;
        }

        public Builder addRecoverTimestamp(long r8) {
            ensureRecoverTimestampIsMutable();
            this.recoverTimestamp_.addLong(r8);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addUpdateTimestamp(long r8) {
            ensureUpdateTimestampIsMutable();
            this.updateTimestamp_.addLong(r8);
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

        public Builder clearAddTimestamp() {
            this.addTimestamp_ = StarGeofenceData.access$2200();
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder clearAddress() {
            this.address_ = StarGeofenceData.getDefaultInstance().getAddress();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearDeleteTimestamp() {
            this.deleteTimestamp_ = StarGeofenceData.access$2500();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearGeoType() {
            this.bitField0_ &= -65;
            this.geoType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGeofenceId() {
            this.geofenceId_ = StarGeofenceData.getDefaultInstance().getGeofenceId();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearLatitude() {
            this.bitField0_ &= -5;
            this.latitude_ = 0.0d;
            onChanged();
            return this;
        }

        public Builder clearLongitude() {
            this.bitField0_ &= -9;
            this.longitude_ = 0.0d;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPackageName() {
            this.packageName_ = StarGeofenceData.getDefaultInstance().getPackageName();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearRadius() {
            this.bitField0_ &= -17;
            this.radius_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRecoverTimestamp() {
            this.recoverTimestamp_ = StarGeofenceData.access$3100();
            this.bitField0_ &= -2049;
            onChanged();
            return this;
        }

        public Builder clearTransitionType() {
            this.bitField0_ &= -33;
            this.transitionType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUpdateTimestamp() {
            this.updateTimestamp_ = StarGeofenceData.access$2800();
            this.bitField0_ &= -1025;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public long getAddTimestamp(int r8) {
            return this.addTimestamp_.getLong(r8);
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public int getAddTimestampCount() {
            return this.addTimestamp_.size();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public List<Long> getAddTimestampList() {
            int r8 = this.bitField0_ & 256;
            Internal.LongList r10 = this.addTimestamp_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public String getAddress() {
            Object r8 = this.address_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.address_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public ByteString getAddressBytes() {
            Object r8 = this.address_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.address_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public long getDeleteTimestamp(int r8) {
            return this.deleteTimestamp_.getLong(r8);
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public int getDeleteTimestampCount() {
            return this.deleteTimestamp_.size();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public List<Long> getDeleteTimestampList() {
            int r8 = this.bitField0_ & 512;
            Internal.LongList r10 = this.deleteTimestamp_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceData_descriptor;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public int getGeoType() {
            return this.geoType_;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public String getGeofenceId() {
            Object r8 = this.geofenceId_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.geofenceId_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public ByteString getGeofenceIdBytes() {
            Object r8 = this.geofenceId_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.geofenceId_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public double getLatitude() {
            return this.latitude_;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public double getLongitude() {
            return this.longitude_;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
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

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public ByteString getPackageNameBytes() {
            Object r8 = this.packageName_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.packageName_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public int getRadius() {
            return this.radius_;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public long getRecoverTimestamp(int r8) {
            return this.recoverTimestamp_.getLong(r8);
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public int getRecoverTimestampCount() {
            return this.recoverTimestamp_.size();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public List<Long> getRecoverTimestampList() {
            int r8 = this.bitField0_ & 2048;
            Internal.LongList r10 = this.recoverTimestamp_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public int getTransitionType() {
            return this.transitionType_;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public long getUpdateTimestamp(int r8) {
            return this.updateTimestamp_.getLong(r8);
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public int getUpdateTimestampCount() {
            return this.updateTimestamp_.size();
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public List<Long> getUpdateTimestampList() {
            int r8 = this.bitField0_ & 1024;
            Internal.LongList r10 = this.updateTimestamp_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasAddress() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasGeoType() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasGeofenceId() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasLatitude() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasLongitude() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasPackageName() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasRadius() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
        public boolean hasTransitionType() {
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
            if (hasGeofenceId() == true) goto L6;
            return false;
        L6:
            if (hasPackageName() == true) goto L9;
            return false;
        L9:
            if (hasLatitude() == true) goto L12;
            return false;
        L12:
            if (hasLongitude() == true) goto L15;
            return false;
        L15:
            if (hasRadius() == true) goto L18;
            return false;
        L18:
            if (hasTransitionType() == true) goto L20;
            return false;
        L20:
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

        public Builder setAddTimestamp(int r8, long r10) {
            ensureAddTimestampIsMutable();
            this.addTimestamp_.setLong(r8, r10);
            onChanged();
            return this;
        }

        public Builder setAddress(String r8) {
            if (r8 == null) goto L6;
            this.address_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setAddressBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.address_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setDeleteTimestamp(int r8, long r10) {
            ensureDeleteTimestampIsMutable();
            this.deleteTimestamp_.setLong(r8, r10);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setGeoType(int r8) {
            this.geoType_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setGeofenceId(String r8) {
            if (r8 == null) goto L6;
            this.geofenceId_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setGeofenceIdBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.geofenceId_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setLatitude(double r8) {
            this.latitude_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setLongitude(double r8) {
            this.longitude_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
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

        public Builder setRadius(int r8) {
            this.radius_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setRecoverTimestamp(int r8, long r10) {
            ensureRecoverTimestampIsMutable();
            this.recoverTimestamp_.setLong(r8, r10);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setTransitionType(int r8) {
            this.transitionType_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setUpdateTimestamp(int r8, long r10) {
            ensureUpdateTimestampIsMutable();
            this.updateTimestamp_.setLong(r8, r10);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.geofenceId_ = "";
            this.packageName_ = "";
            this.address_ = "";
            this.addTimestamp_ = StarGeofenceData.access$2000();
            this.deleteTimestamp_ = StarGeofenceData.access$2300();
            this.updateTimestamp_ = StarGeofenceData.access$2600();
            this.recoverTimestamp_ = StarGeofenceData.access$2900();
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
            return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceData_fieldAccessorTable.ensureFieldAccessorsInitialized(StarGeofenceData.class, Builder.class);
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
        public StarGeofenceData build() {
            StarGeofenceData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public StarGeofenceData buildPartial() {
            StarGeofenceData r8 = new StarGeofenceData(this, null);
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
        public StarGeofenceData getDefaultInstanceForType() {
            return StarGeofenceData.getDefaultInstance();
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
            this.geofenceId_ = "";
            this.packageName_ = "";
            this.latitude_ = 0.0d;
            this.longitude_ = 0.0d;
            this.radius_ = 0;
            this.transitionType_ = 0;
            this.geoType_ = 0;
            this.address_ = "";
            this.addTimestamp_ = StarGeofenceData.access$200();
            this.deleteTimestamp_ = StarGeofenceData.access$300();
            this.updateTimestamp_ = StarGeofenceData.access$400();
            this.recoverTimestamp_ = StarGeofenceData.access$500();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L52;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L49;
            int r12 = r8.readTag();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            switch(r12) {
                case 0: goto L39;
                case 10: goto L37;
                case 18: goto L36;
                case 25: goto L35;
                case 33: goto L34;
                case 40: goto L33;
                case 48: goto L32;
                case 64: goto L31;
                case 74: goto L30;
                case 80: goto L29;
                case 82: goto L25;
                case 88: goto L24;
                case 90: goto L20;
                case 96: goto L19;
                case 98: goto L15;
                case 104: goto L13;
                case 106: goto L8;
                default: goto L40;
            };     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L8:
            int r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureRecoverTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L10:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.recoverTimestamp_.addLong(r8.readUInt64());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L12:
            r8.popLimit(r13);     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L13:
            long r14 = r8.readUInt64();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureRecoverTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            Internal.LongList r15 = this.recoverTimestamp_;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L14:
            r15.addLong(r14);     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L15:
            r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureUpdateTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L17:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.updateTimestamp_.addLong(r8.readUInt64());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L17
        L19:
            r14 = r8.readUInt64();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureUpdateTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            r15 = this.updateTimestamp_;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L14
        L20:
            r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureDeleteTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L22:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.deleteTimestamp_.addLong(r8.readUInt64());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L22
        L24:
            r14 = r8.readUInt64();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureDeleteTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            r15 = this.deleteTimestamp_;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L14
        L25:
            r13 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureAddTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L27:
            if (r8.getBytesUntilLimit() <= 0) goto L12;
            this.addTimestamp_.addLong(r8.readUInt64());     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L27
        L29:
            r14 = r8.readUInt64();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            ensureAddTimestampIsMutable();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            r15 = this.addTimestamp_;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L14
        L30:
            this.address_ = r8.readBytes();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 128;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L31:
            this.geoType_ = r8.readUInt32();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 64;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L32:
            this.transitionType_ = r8.readUInt32();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 32;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L33:
            this.radius_ = r8.readUInt32();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 16;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L34:
            this.longitude_ = r8.readDouble();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 8;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L35:
            this.latitude_ = r8.readDouble();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 4;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L36:
            this.packageName_ = r8.readBytes();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 2;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            goto L4
        L37:
            this.geofenceId_ = r8.readBytes();     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
            this.bitField0_ |= 1;     // Catch: Throwable -> L42 InvalidProtocolBufferException -> L44
        L39:
            r11 = true;
            goto L4
        L40:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L44:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            onChanged();
            throw th;
        L49:
            onChanged();
            return this;
        L52:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof StarGeofenceData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((StarGeofenceData) r8);
        }

        public Builder mergeFrom(StarGeofenceData r8) {
            if (r8 != StarGeofenceData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasGeofenceId() == false) goto L9;
            this.geofenceId_ = StarGeofenceData.access$1100(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (r8.hasPackageName() == false) goto L12;
            this.packageName_ = StarGeofenceData.access$1200(r8);
            this.bitField0_ |= 2;
            onChanged();
        L12:
            if (r8.hasLatitude() == false) goto L15;
            setLatitude(r8.getLatitude());
        L15:
            if (r8.hasLongitude() == false) goto L18;
            setLongitude(r8.getLongitude());
        L18:
            if (r8.hasRadius() == false) goto L21;
            setRadius(r8.getRadius());
        L21:
            if (r8.hasTransitionType() == false) goto L24;
            setTransitionType(r8.getTransitionType());
        L24:
            if (r8.hasGeoType() == false) goto L27;
            setGeoType(r8.getGeoType());
        L27:
            if (r8.hasAddress() == false) goto L30;
            this.address_ = StarGeofenceData.access$1800(r8);
            this.bitField0_ |= 128;
            onChanged();
        L30:
            if (StarGeofenceData.access$700(r8).isEmpty() == true) goto L37;
            if (this.addTimestamp_.isEmpty() == false) goto L34;
            this.addTimestamp_ = StarGeofenceData.access$700(r8);
            this.bitField0_ &= -257;
        L35:
            onChanged();
            goto L37
        L34:
            ensureAddTimestampIsMutable();
            this.addTimestamp_.addAll(StarGeofenceData.access$700(r8));
        L37:
            if (StarGeofenceData.access$800(r8).isEmpty() == true) goto L44;
            if (this.deleteTimestamp_.isEmpty() == false) goto L41;
            this.deleteTimestamp_ = StarGeofenceData.access$800(r8);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L42:
            onChanged();
            goto L44
        L41:
            ensureDeleteTimestampIsMutable();
            this.deleteTimestamp_.addAll(StarGeofenceData.access$800(r8));
        L44:
            if (StarGeofenceData.access$900(r8).isEmpty() == true) goto L51;
            if (this.updateTimestamp_.isEmpty() == false) goto L48;
            this.updateTimestamp_ = StarGeofenceData.access$900(r8);
            this.bitField0_ &= -1025;
        L49:
            onChanged();
            goto L51
        L48:
            ensureUpdateTimestampIsMutable();
            this.updateTimestamp_.addAll(StarGeofenceData.access$900(r8));
        L51:
            if (StarGeofenceData.access$1000(r8).isEmpty() == false) goto L53;
        L57:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L53:
            if (this.recoverTimestamp_.isEmpty() == false) goto L55;
            this.recoverTimestamp_ = StarGeofenceData.access$1000(r8);
            this.bitField0_ &= -2049;
        L56:
            onChanged();
            goto L57
        L55:
            ensureRecoverTimestampIsMutable();
            this.recoverTimestamp_.addAll(StarGeofenceData.access$1000(r8));
            goto L56
        }
    }

    static {
        DEFAULT_INSTANCE = new StarGeofenceData();
        PARSER = new AnonymousClass1();
    }

    private StarGeofenceData() {
        this.geofenceId_ = "";
        this.packageName_ = "";
        this.latitude_ = 0.0d;
        this.longitude_ = 0.0d;
        this.radius_ = 0;
        this.transitionType_ = 0;
        this.geoType_ = 0;
        this.address_ = "";
        this.memoizedIsInitialized = -1;
        this.geofenceId_ = "";
        this.packageName_ = "";
        this.address_ = "";
        this.addTimestamp_ = GeneratedMessage.emptyLongList();
        this.deleteTimestamp_ = GeneratedMessage.emptyLongList();
        this.updateTimestamp_ = GeneratedMessage.emptyLongList();
        this.recoverTimestamp_ = GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$1000(StarGeofenceData r8) {
        return r8.recoverTimestamp_;
    }

    public static /* synthetic */ Internal.LongList access$1002(StarGeofenceData r8, Internal.LongList r10) {
        r8.recoverTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1100(StarGeofenceData r8) {
        return r8.geofenceId_;
    }

    public static /* synthetic */ Object access$1102(StarGeofenceData r8, Object r10) {
        r8.geofenceId_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1200(StarGeofenceData r8) {
        return r8.packageName_;
    }

    public static /* synthetic */ Object access$1202(StarGeofenceData r8, Object r10) {
        r8.packageName_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$1302(StarGeofenceData r8, double r10) {
        r8.latitude_ = r10;
        return r10;
    }

    public static /* synthetic */ double access$1402(StarGeofenceData r8, double r10) {
        r8.longitude_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(StarGeofenceData r8, int r10) {
        r8.radius_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1602(StarGeofenceData r8, int r10) {
        r8.transitionType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1702(StarGeofenceData r8, int r10) {
        r8.geoType_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1800(StarGeofenceData r8) {
        return r8.address_;
    }

    public static /* synthetic */ Object access$1802(StarGeofenceData r8, Object r10) {
        r8.address_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1976(StarGeofenceData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Internal.LongList access$200() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$2000() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$2100(Internal.LongList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.LongList access$2200() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$2300() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$2400(Internal.LongList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.LongList access$2500() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$2600() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$2700(Internal.LongList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.LongList access$2800() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$2900() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$300() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$3000(Internal.LongList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.LongList access$3100() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$400() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$500() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$700(StarGeofenceData r8) {
        return r8.addTimestamp_;
    }

    public static /* synthetic */ Internal.LongList access$702(StarGeofenceData r8, Internal.LongList r10) {
        r8.addTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.LongList access$800(StarGeofenceData r8) {
        return r8.deleteTimestamp_;
    }

    public static /* synthetic */ Internal.LongList access$802(StarGeofenceData r8, Internal.LongList r10) {
        r8.deleteTimestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.LongList access$900(StarGeofenceData r8) {
        return r8.updateTimestamp_;
    }

    public static /* synthetic */ Internal.LongList access$902(StarGeofenceData r8, Internal.LongList r10) {
        r8.updateTimestamp_ = r10;
        return r10;
    }

    public static StarGeofenceData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static StarGeofenceData parseDelimitedFrom(InputStream r8) {
        return (StarGeofenceData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static StarGeofenceData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<StarGeofenceData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof StarGeofenceData) == false) goto L8;
        StarGeofenceData r10 = (StarGeofenceData) r8;
        if (hasGeofenceId() == r10.hasGeofenceId()) goto L13;
        return false;
    L13:
        if (hasGeofenceId() == false) goto L18;
        if (getGeofenceId().equals(r10.getGeofenceId()) == true) goto L18;
        return false;
    L18:
        if (hasPackageName() == r10.hasPackageName()) goto L21;
        return false;
    L21:
        if (hasPackageName() == false) goto L26;
        if (getPackageName().equals(r10.getPackageName()) == true) goto L26;
        return false;
    L26:
        if (hasLatitude() == r10.hasLatitude()) goto L29;
        return false;
    L29:
        if (hasLatitude() == false) goto L34;
        if (Double.doubleToLongBits(getLatitude()) == Double.doubleToLongBits(r10.getLatitude())) goto L34;
        return false;
    L34:
        if (hasLongitude() == r10.hasLongitude()) goto L37;
        return false;
    L37:
        if (hasLongitude() == false) goto L42;
        if (Double.doubleToLongBits(getLongitude()) == Double.doubleToLongBits(r10.getLongitude())) goto L42;
        return false;
    L42:
        if (hasRadius() == r10.hasRadius()) goto L45;
        return false;
    L45:
        if (hasRadius() == false) goto L50;
        if (getRadius() == r10.getRadius()) goto L50;
        return false;
    L50:
        if (hasTransitionType() == r10.hasTransitionType()) goto L53;
        return false;
    L53:
        if (hasTransitionType() == false) goto L58;
        if (getTransitionType() == r10.getTransitionType()) goto L58;
        return false;
    L58:
        if (hasGeoType() == r10.hasGeoType()) goto L61;
        return false;
    L61:
        if (hasGeoType() == false) goto L66;
        if (getGeoType() == r10.getGeoType()) goto L66;
        return false;
    L66:
        if (hasAddress() == r10.hasAddress()) goto L69;
        return false;
    L69:
        if (hasAddress() == false) goto L74;
        if (getAddress().equals(r10.getAddress()) == true) goto L74;
        return false;
    L74:
        if (getAddTimestampList().equals(r10.getAddTimestampList()) == true) goto L77;
        return false;
    L77:
        if (getDeleteTimestampList().equals(r10.getDeleteTimestampList()) == true) goto L80;
        return false;
    L80:
        if (getUpdateTimestampList().equals(r10.getUpdateTimestampList()) == true) goto L83;
        return false;
    L83:
        if (getRecoverTimestampList().equals(r10.getRecoverTimestampList()) == true) goto L86;
        return false;
    L86:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L88;
        return false;
    L88:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public long getAddTimestamp(int r8) {
        return this.addTimestamp_.getLong(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public int getAddTimestampCount() {
        return this.addTimestamp_.size();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public List<Long> getAddTimestampList() {
        return this.addTimestamp_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public String getAddress() {
        Object r8 = this.address_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.address_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public ByteString getAddressBytes() {
        Object r8 = this.address_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.address_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public long getDeleteTimestamp(int r8) {
        return this.deleteTimestamp_.getLong(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public int getDeleteTimestampCount() {
        return this.deleteTimestamp_.size();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public List<Long> getDeleteTimestampList() {
        return this.deleteTimestamp_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public int getGeoType() {
        return this.geoType_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public String getGeofenceId() {
        Object r8 = this.geofenceId_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.geofenceId_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public ByteString getGeofenceIdBytes() {
        Object r8 = this.geofenceId_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.geofenceId_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public double getLatitude() {
        return this.latitude_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public double getLongitude() {
        return this.longitude_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
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

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
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
    public Parser<StarGeofenceData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public int getRadius() {
        return this.radius_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public long getRecoverTimestamp(int r8) {
        return this.recoverTimestamp_.getLong(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public int getRecoverTimestampCount() {
        return this.recoverTimestamp_.size();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public List<Long> getRecoverTimestampList() {
        return this.recoverTimestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.geofenceId_) + 0;
    L10:
        if ((this.bitField0_ & 2) == 0) goto L13;
        r11 = r11 + GeneratedMessage.computeStringSize(2, this.packageName_);
    L13:
        if ((this.bitField0_ & 4) == 0) goto L16;
        r11 = r11 + CodedOutputStream.computeDoubleSize(3, this.latitude_);
    L16:
        if ((this.bitField0_ & 8) == 0) goto L19;
        r11 = r11 + CodedOutputStream.computeDoubleSize(4, this.longitude_);
    L19:
        if ((this.bitField0_ & 16) == 0) goto L22;
        r11 = r11 + CodedOutputStream.computeUInt32Size(5, this.radius_);
    L22:
        if ((this.bitField0_ & 32) == 0) goto L25;
        r11 = r11 + CodedOutputStream.computeUInt32Size(6, this.transitionType_);
    L25:
        if ((this.bitField0_ & 64) == 0) goto L28;
        r11 = r11 + CodedOutputStream.computeUInt32Size(8, this.geoType_);
    L28:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r11 = r11 + GeneratedMessage.computeStringSize(9, this.address_);
    L30:
        int r12 = 0;
        int r13 = 0;
    L32:
        if (r12 >= this.addTimestamp_.size()) goto L34;
        r13 = r13 + CodedOutputStream.computeUInt64SizeNoTag(this.addTimestamp_.getLong(r12));
        r12 = r12 + 1;
        goto L32
    L34:
        int r14 = (getAddTimestampList().size() * 1) + (r11 + r13);
        int r15 = 0;
        int r16 = 0;
    L36:
        if (r15 >= this.deleteTimestamp_.size()) goto L38;
        r16 = r16 + CodedOutputStream.computeUInt64SizeNoTag(this.deleteTimestamp_.getLong(r15));
        r15 = r15 + 1;
        goto L36
    L38:
        int r17 = (getDeleteTimestampList().size() * 1) + (r14 + r16);
        int r18 = 0;
        int r19 = 0;
    L40:
        if (r18 >= this.updateTimestamp_.size()) goto L42;
        r19 = r19 + CodedOutputStream.computeUInt64SizeNoTag(this.updateTimestamp_.getLong(r18));
        r18 = r18 + 1;
        goto L40
    L42:
        int r20 = (getUpdateTimestampList().size() * 1) + (r17 + r19);
        int r21 = 0;
    L44:
        if (r10 >= this.recoverTimestamp_.size()) goto L46;
        r21 = r21 + CodedOutputStream.computeUInt64SizeNoTag(this.recoverTimestamp_.getLong(r10));
        r10 = r10 + 1;
        goto L44
    L46:
        int r22 = getUnknownFields().getSerializedSize() + ((getRecoverTimestampList().size() * 1) + (r20 + r21));
        this.memoizedSize = r22;
        return r22;
    L8:
        r11 = 0;
        goto L10
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public int getTransitionType() {
        return this.transitionType_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public long getUpdateTimestamp(int r8) {
        return this.updateTimestamp_.getLong(r8);
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public int getUpdateTimestampCount() {
        return this.updateTimestamp_.size();
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public List<Long> getUpdateTimestampList() {
        return this.updateTimestamp_;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasAddress() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasGeoType() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasGeofenceId() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasLatitude() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasLongitude() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasPackageName() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasRadius() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.location.geofence.StarGeofenceDataOrBuilder
    public boolean hasTransitionType() {
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
        if (hasGeofenceId() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getGeofenceId().hashCode();
    L9:
        if (hasPackageName() == false) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getPackageName().hashCode();
    L12:
        if (hasLatitude() == false) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashLong(Double.doubleToLongBits(getLatitude()));
    L15:
        if (hasLongitude() == false) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + Internal.hashLong(Double.doubleToLongBits(getLongitude()));
    L18:
        if (hasRadius() == false) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getRadius();
    L21:
        if (hasTransitionType() == false) goto L24;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getTransitionType();
    L24:
        if (hasGeoType() == false) goto L27;
        r10 = defpackage.b.a(r10, 37, 8, 53) + getGeoType();
    L27:
        if (hasAddress() == false) goto L30;
        r10 = defpackage.b.a(r10, 37, 9, 53) + getAddress().hashCode();
    L30:
        if (getAddTimestampCount() <= 0) goto L33;
        r10 = defpackage.b.a(r10, 37, 10, 53) + getAddTimestampList().hashCode();
    L33:
        if (getDeleteTimestampCount() <= 0) goto L36;
        r10 = defpackage.b.a(r10, 37, 11, 53) + getDeleteTimestampList().hashCode();
    L36:
        if (getUpdateTimestampCount() <= 0) goto L39;
        r10 = defpackage.b.a(r10, 37, 12, 53) + getUpdateTimestampList().hashCode();
    L39:
        if (getRecoverTimestampCount() <= 0) goto L41;
        r10 = defpackage.b.a(r10, 37, 13, 53) + getRecoverTimestampList().hashCode();
    L41:
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
        if (hasGeofenceId() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasPackageName() == true) goto L17;
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasLatitude() == true) goto L21;
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasLongitude() == true) goto L25;
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (hasRadius() == true) goto L29;
        this.memoizedIsInitialized = 0;
        return false;
    L29:
        if (hasTransitionType() == true) goto L32;
        this.memoizedIsInitialized = 0;
        return false;
    L32:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new StarGeofenceData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        GeneratedMessage.writeString(r8, 1, this.geofenceId_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        GeneratedMessage.writeString(r8, 2, this.packageName_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeDouble(3, this.latitude_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeDouble(4, this.longitude_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeUInt32(5, this.radius_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeUInt32(6, this.transitionType_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeUInt32(8, this.geoType_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L26;
        GeneratedMessage.writeString(r8, 9, this.address_);
    L26:
        int r10 = 0;
        int r11 = 0;
    L28:
        if (r11 >= this.addTimestamp_.size()) goto L30;
        r8.writeUInt64(10, this.addTimestamp_.getLong(r11));
        r11 = r11 + 1;
        goto L28
    L30:
        int r12 = 0;
    L32:
        if (r12 >= this.deleteTimestamp_.size()) goto L34;
        r8.writeUInt64(11, this.deleteTimestamp_.getLong(r12));
        r12 = r12 + 1;
        goto L32
    L34:
        int r13 = 0;
    L36:
        if (r13 >= this.updateTimestamp_.size()) goto L39;
        r8.writeUInt64(12, this.updateTimestamp_.getLong(r13));
        r13 = r13 + 1;
    L39:
        if (r10 >= this.recoverTimestamp_.size()) goto L41;
        r8.writeUInt64(13, this.recoverTimestamp_.getLong(r10));
        r10 = r10 + 1;
        goto L39
    L41:
        getUnknownFields().writeTo(r8);
    }

    private StarGeofenceData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.geofenceId_ = "";
        this.packageName_ = "";
        this.latitude_ = 0.0d;
        this.longitude_ = 0.0d;
        this.radius_ = 0;
        this.transitionType_ = 0;
        this.geoType_ = 0;
        this.address_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(StarGeofenceData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static StarGeofenceData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StarGeofenceData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static StarGeofenceData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StarGeofenceEvent.internal_static_com_obric_cae_location_geofence_StarGeofenceData_fieldAccessorTable.ensureFieldAccessorsInitialized(StarGeofenceData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ StarGeofenceData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static StarGeofenceData parseFrom(CodedInputStream r8) {
        return (StarGeofenceData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public StarGeofenceData getDefaultInstanceForType() {
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

    public static StarGeofenceData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (StarGeofenceData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static StarGeofenceData parseFrom(InputStream r8) {
        return (StarGeofenceData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static StarGeofenceData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StarGeofenceData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static StarGeofenceData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static StarGeofenceData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static StarGeofenceData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static StarGeofenceData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
