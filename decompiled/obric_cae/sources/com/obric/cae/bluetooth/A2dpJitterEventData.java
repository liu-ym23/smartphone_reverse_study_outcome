package com.obric.cae.bluetooth;

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
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterEventData extends GeneratedMessageV3 implements A2dpJitterEventDataOrBuilder {
    private static final A2dpJitterEventData DEFAULT_INSTANCE = null;
    public static final int DELTA_RETRANS_SUM_FIELD_NUMBER = 1;
    public static final int HOST_BUFFER_MARGIN_FIELD_NUMBER = 4;
    public static final int LABEL_FIELD_NUMBER = 13;
    public static final int MACLTXQUEUELENGTH_FIELD_NUMBER = 5;
    public static final int MGLITCHCOUNT_FIELD_NUMBER = 6;
    public static final int MNAKCOUNT_FIELD_NUMBER = 7;
    public static final int MNORXCOUNT_FIELD_NUMBER = 8;
    public static final int MOVERFLOWCOUNT_FIELD_NUMBER = 9;
    public static final int MPACKETTYPE_FIELD_NUMBER = 10;
    public static final int MTXPOWERLEVEL_FIELD_NUMBER = 11;
    public static final int NORX_RATIO_FIELD_NUMBER = 2;

    @Deprecated
    public static final Parser<A2dpJitterEventData> PARSER = null;
    public static final int PROB_FIELD_NUMBER = 12;
    public static final int SILENCE_DURATION_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_FIELD_NUMBER = 14;
    public static final int TIME_TO_BT_RESTART_MS_FIELD_NUMBER = 15;
    public static final int TIME_TO_REVERT_MS_FIELD_NUMBER = 16;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private float deltaRetransSum_;
    private float hostBufferMargin_;
    private int label_;
    private int mAclTxQueueLength_;
    private int mGlitchCount_;
    private int mNakCount_;
    private int mNoRxCount_;
    private int mOverflowCount_;
    private volatile Object mPacketType_;
    private int mTxPowerLevel_;
    private byte memoizedIsInitialized;
    private float noRxRatio_;
    private float prob_;
    private float silenceDuration_;
    private long timeToBtRestartMs_;
    private long timeToRevertMs_;
    private long timestamp_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements A2dpJitterEventDataOrBuilder {
        private int bitField0_;
        private float deltaRetransSum_;
        private float hostBufferMargin_;
        private int label_;
        private int mAclTxQueueLength_;
        private int mGlitchCount_;
        private int mNakCount_;
        private int mNoRxCount_;
        private int mOverflowCount_;
        private Object mPacketType_;
        private int mTxPowerLevel_;
        private float noRxRatio_;
        private float prob_;
        private float silenceDuration_;
        private long timeToBtRestartMs_;
        private long timeToRevertMs_;
        private long timestamp_;

        private Builder() {
            this.mPacketType_ = "";
        }

        private void buildPartial0(A2dpJitterEventData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            A2dpJitterEventData.access$302(r8, this.deltaRetransSum_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            A2dpJitterEventData.access$402(r8, this.noRxRatio_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            A2dpJitterEventData.access$502(r8, this.silenceDuration_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            A2dpJitterEventData.access$602(r8, this.hostBufferMargin_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            A2dpJitterEventData.access$702(r8, this.mAclTxQueueLength_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            A2dpJitterEventData.access$802(r8, this.mGlitchCount_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 64) == 0) goto L25;
            A2dpJitterEventData.access$902(r8, this.mNakCount_);
            r11 = r11 | 64;
        L25:
            if ((r10 & 128) == 0) goto L28;
            A2dpJitterEventData.access$1002(r8, this.mNoRxCount_);
            r11 = r11 | 128;
        L28:
            if ((r10 & 256) == 0) goto L31;
            A2dpJitterEventData.access$1102(r8, this.mOverflowCount_);
            r11 = r11 | 256;
        L31:
            if ((r10 & 512) == 0) goto L34;
            A2dpJitterEventData.access$1202(r8, this.mPacketType_);
            r11 = r11 | 512;
        L34:
            if ((r10 & 1024) == 0) goto L37;
            A2dpJitterEventData.access$1302(r8, this.mTxPowerLevel_);
            r11 = r11 | 1024;
        L37:
            if ((r10 & 2048) == 0) goto L40;
            A2dpJitterEventData.access$1402(r8, this.prob_);
            r11 = r11 | 2048;
        L40:
            if ((r10 & 4096) == 0) goto L43;
            A2dpJitterEventData.access$1502(r8, this.label_);
            r11 = r11 | 4096;
        L43:
            if ((r10 & 8192) == 0) goto L46;
            A2dpJitterEventData.access$1602(r8, this.timestamp_);
            r11 = r11 | 8192;
        L46:
            if ((r10 & 16384) == 0) goto L49;
            A2dpJitterEventData.access$1702(r8, this.timeToBtRestartMs_);
            r11 = r11 | 16384;
        L49:
            if ((r10 & 32768) == 0) goto L51;
            A2dpJitterEventData.access$1802(r8, this.timeToRevertMs_);
            r11 = r11 | 32768;
        L51:
            A2dpJitterEventData.access$1976(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeBluetoothEvent.internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_descriptor;
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

        public Builder clearDeltaRetransSum() {
            this.bitField0_ &= -2;
            this.deltaRetransSum_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearHostBufferMargin() {
            this.bitField0_ &= -9;
            this.hostBufferMargin_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearLabel() {
            this.bitField0_ &= -4097;
            this.label_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMAclTxQueueLength() {
            this.bitField0_ &= -17;
            this.mAclTxQueueLength_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMGlitchCount() {
            this.bitField0_ &= -33;
            this.mGlitchCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMNakCount() {
            this.bitField0_ &= -65;
            this.mNakCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMNoRxCount() {
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            this.mNoRxCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMOverflowCount() {
            this.bitField0_ &= -257;
            this.mOverflowCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMPacketType() {
            this.mPacketType_ = A2dpJitterEventData.getDefaultInstance().getMPacketType();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            onChanged();
            return this;
        }

        public Builder clearMTxPowerLevel() {
            this.bitField0_ &= -1025;
            this.mTxPowerLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNoRxRatio() {
            this.bitField0_ &= -3;
            this.noRxRatio_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearProb() {
            this.bitField0_ &= -2049;
            this.prob_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearSilenceDuration() {
            this.bitField0_ &= -5;
            this.silenceDuration_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearTimeToBtRestartMs() {
            this.bitField0_ &= -16385;
            this.timeToBtRestartMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimeToRevertMs() {
            this.bitField0_ &= -32769;
            this.timeToRevertMs_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -8193;
            this.timestamp_ = 0;
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

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public float getDeltaRetransSum() {
            return this.deltaRetransSum_;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeBluetoothEvent.internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_descriptor;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public float getHostBufferMargin() {
            return this.hostBufferMargin_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public int getLabel() {
            return this.label_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public int getMAclTxQueueLength() {
            return this.mAclTxQueueLength_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public int getMGlitchCount() {
            return this.mGlitchCount_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public int getMNakCount() {
            return this.mNakCount_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public int getMNoRxCount() {
            return this.mNoRxCount_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public int getMOverflowCount() {
            return this.mOverflowCount_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public String getMPacketType() {
            Object r8 = this.mPacketType_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.mPacketType_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public ByteString getMPacketTypeBytes() {
            Object r8 = this.mPacketType_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.mPacketType_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public int getMTxPowerLevel() {
            return this.mTxPowerLevel_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public float getNoRxRatio() {
            return this.noRxRatio_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public float getProb() {
            return this.prob_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public float getSilenceDuration() {
            return this.silenceDuration_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public long getTimeToBtRestartMs() {
            return this.timeToBtRestartMs_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public long getTimeToRevertMs() {
            return this.timeToRevertMs_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasDeltaRetransSum() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasHostBufferMargin() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasLabel() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasMAclTxQueueLength() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasMGlitchCount() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasMNakCount() {
            if ((this.bitField0_ & 64) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasMNoRxCount() {
            if ((this.bitField0_ & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasMOverflowCount() {
            if ((this.bitField0_ & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasMPacketType() {
            if ((this.bitField0_ & 512) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasMTxPowerLevel() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasNoRxRatio() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasProb() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasSilenceDuration() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasTimeToBtRestartMs() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasTimeToRevertMs() {
            if ((this.bitField0_ & 32768) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
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

        public Builder setDeltaRetransSum(float r8) {
            this.deltaRetransSum_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setHostBufferMargin(float r8) {
            this.hostBufferMargin_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setLabel(int r8) {
            this.label_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        public Builder setMAclTxQueueLength(int r8) {
            this.mAclTxQueueLength_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        public Builder setMGlitchCount(int r8) {
            this.mGlitchCount_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setMNakCount(int r8) {
            this.mNakCount_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setMNoRxCount(int r8) {
            this.mNoRxCount_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        public Builder setMOverflowCount(int r8) {
            this.mOverflowCount_ = r8;
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setMPacketType(String r8) {
            if (r8 == null) goto L6;
            this.mPacketType_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setMPacketTypeBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.mPacketType_ = r8;
            this.bitField0_ |= 512;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setMTxPowerLevel(int r8) {
            this.mTxPowerLevel_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setNoRxRatio(float r8) {
            this.noRxRatio_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setProb(float r8) {
            this.prob_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSilenceDuration(float r8) {
            this.silenceDuration_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder setTimeToBtRestartMs(long r8) {
            this.timeToBtRestartMs_ = r8;
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setTimeToRevertMs(long r8) {
            this.timeToRevertMs_ = r8;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.mPacketType_ = "";
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
            return CaeBluetoothEvent.internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_fieldAccessorTable.ensureFieldAccessorsInitialized(A2dpJitterEventData.class, Builder.class);
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
        public A2dpJitterEventData build() {
            A2dpJitterEventData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public A2dpJitterEventData buildPartial() {
            A2dpJitterEventData r8 = new A2dpJitterEventData(this, null);
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
        public A2dpJitterEventData getDefaultInstanceForType() {
            return A2dpJitterEventData.getDefaultInstance();
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
            this.deltaRetransSum_ = 0.0f;
            this.noRxRatio_ = 0.0f;
            this.silenceDuration_ = 0.0f;
            this.hostBufferMargin_ = 0.0f;
            this.mAclTxQueueLength_ = 0;
            this.mGlitchCount_ = 0;
            this.mNakCount_ = 0;
            this.mNoRxCount_ = 0;
            this.mOverflowCount_ = 0;
            this.mPacketType_ = "";
            this.mTxPowerLevel_ = 0;
            this.prob_ = 0.0f;
            this.label_ = 0;
            this.timestamp_ = 0;
            this.timeToBtRestartMs_ = 0;
            this.timeToRevertMs_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L38;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L35;
            int r12 = r8.readTag();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            switch(r12) {
                case 0: goto L25;
                case 13: goto L23;
                case 21: goto L22;
                case 29: goto L21;
                case 37: goto L20;
                case 40: goto L19;
                case 48: goto L18;
                case 56: goto L17;
                case 64: goto L16;
                case 72: goto L15;
                case 82: goto L14;
                case 88: goto L13;
                case 101: goto L12;
                case 104: goto L11;
                case 112: goto L10;
                case 120: goto L9;
                case 128: goto L8;
                default: goto L26;
            };     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
        L8:
            this.timeToRevertMs_ = r8.readInt64();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 32768;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L9:
            this.timeToBtRestartMs_ = r8.readInt64();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 16384;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L10:
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 8192;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L11:
            this.label_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 4096;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L12:
            this.prob_ = r8.readFloat();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 2048;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L13:
            this.mTxPowerLevel_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 1024;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L14:
            this.mPacketType_ = r8.readBytes();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 512;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L15:
            this.mOverflowCount_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 256;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L16:
            this.mNoRxCount_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 128;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L17:
            this.mNakCount_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 64;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L18:
            this.mGlitchCount_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 32;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L19:
            this.mAclTxQueueLength_ = r8.readInt32();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 16;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L20:
            this.hostBufferMargin_ = r8.readFloat();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 8;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L21:
            this.silenceDuration_ = r8.readFloat();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 4;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L22:
            this.noRxRatio_ = r8.readFloat();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 2;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            goto L4
        L23:
            this.deltaRetransSum_ = r8.readFloat();     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
            this.bitField0_ |= 1;     // Catch: Throwable -> L28 InvalidProtocolBufferException -> L30
        L25:
            r11 = true;
            goto L4
        L26:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L28:
            th = move-exception;
            onChanged();
            throw th;
        L30:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L28
        L35:
            onChanged();
            return this;
        L38:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof A2dpJitterEventData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((A2dpJitterEventData) r8);
        }

        public Builder mergeFrom(A2dpJitterEventData r8) {
            if (r8 != A2dpJitterEventData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasDeltaRetransSum() == false) goto L9;
            setDeltaRetransSum(r8.getDeltaRetransSum());
        L9:
            if (r8.hasNoRxRatio() == false) goto L12;
            setNoRxRatio(r8.getNoRxRatio());
        L12:
            if (r8.hasSilenceDuration() == false) goto L15;
            setSilenceDuration(r8.getSilenceDuration());
        L15:
            if (r8.hasHostBufferMargin() == false) goto L18;
            setHostBufferMargin(r8.getHostBufferMargin());
        L18:
            if (r8.hasMAclTxQueueLength() == false) goto L21;
            setMAclTxQueueLength(r8.getMAclTxQueueLength());
        L21:
            if (r8.hasMGlitchCount() == false) goto L24;
            setMGlitchCount(r8.getMGlitchCount());
        L24:
            if (r8.hasMNakCount() == false) goto L27;
            setMNakCount(r8.getMNakCount());
        L27:
            if (r8.hasMNoRxCount() == false) goto L30;
            setMNoRxCount(r8.getMNoRxCount());
        L30:
            if (r8.hasMOverflowCount() == false) goto L33;
            setMOverflowCount(r8.getMOverflowCount());
        L33:
            if (r8.hasMPacketType() == false) goto L36;
            this.mPacketType_ = A2dpJitterEventData.access$1200(r8);
            this.bitField0_ |= 512;
            onChanged();
        L36:
            if (r8.hasMTxPowerLevel() == false) goto L39;
            setMTxPowerLevel(r8.getMTxPowerLevel());
        L39:
            if (r8.hasProb() == false) goto L42;
            setProb(r8.getProb());
        L42:
            if (r8.hasLabel() == false) goto L45;
            setLabel(r8.getLabel());
        L45:
            if (r8.hasTimestamp() == false) goto L48;
            setTimestamp(r8.getTimestamp());
        L48:
            if (r8.hasTimeToBtRestartMs() == false) goto L51;
            setTimeToBtRestartMs(r8.getTimeToBtRestartMs());
        L51:
            if (r8.hasTimeToRevertMs() == false) goto L53;
            setTimeToRevertMs(r8.getTimeToRevertMs());
        L53:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new A2dpJitterEventData();
        PARSER = new AnonymousClass1();
    }

    private A2dpJitterEventData() {
        this.deltaRetransSum_ = 0.0f;
        this.noRxRatio_ = 0.0f;
        this.silenceDuration_ = 0.0f;
        this.hostBufferMargin_ = 0.0f;
        this.mAclTxQueueLength_ = 0;
        this.mGlitchCount_ = 0;
        this.mNakCount_ = 0;
        this.mNoRxCount_ = 0;
        this.mOverflowCount_ = 0;
        this.mPacketType_ = "";
        this.mTxPowerLevel_ = 0;
        this.prob_ = 0.0f;
        this.label_ = 0;
        this.timestamp_ = 0;
        this.timeToBtRestartMs_ = 0;
        this.timeToRevertMs_ = 0;
        this.memoizedIsInitialized = -1;
        this.mPacketType_ = "";
    }

    public static /* synthetic */ int access$1002(A2dpJitterEventData r8, int r10) {
        r8.mNoRxCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(A2dpJitterEventData r8, int r10) {
        r8.mOverflowCount_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1200(A2dpJitterEventData r8) {
        return r8.mPacketType_;
    }

    public static /* synthetic */ Object access$1202(A2dpJitterEventData r8, Object r10) {
        r8.mPacketType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(A2dpJitterEventData r8, int r10) {
        r8.mTxPowerLevel_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$1402(A2dpJitterEventData r8, float r10) {
        r8.prob_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1502(A2dpJitterEventData r8, int r10) {
        r8.label_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1602(A2dpJitterEventData r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1702(A2dpJitterEventData r8, long r10) {
        r8.timeToBtRestartMs_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$1802(A2dpJitterEventData r8, long r10) {
        r8.timeToRevertMs_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1976(A2dpJitterEventData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ float access$302(A2dpJitterEventData r8, float r10) {
        r8.deltaRetransSum_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$402(A2dpJitterEventData r8, float r10) {
        r8.noRxRatio_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$502(A2dpJitterEventData r8, float r10) {
        r8.silenceDuration_ = r10;
        return r10;
    }

    public static /* synthetic */ float access$602(A2dpJitterEventData r8, float r10) {
        r8.hostBufferMargin_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$702(A2dpJitterEventData r8, int r10) {
        r8.mAclTxQueueLength_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(A2dpJitterEventData r8, int r10) {
        r8.mGlitchCount_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(A2dpJitterEventData r8, int r10) {
        r8.mNakCount_ = r10;
        return r10;
    }

    public static A2dpJitterEventData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeBluetoothEvent.internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static A2dpJitterEventData parseDelimitedFrom(InputStream r8) {
        return (A2dpJitterEventData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static A2dpJitterEventData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<A2dpJitterEventData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof A2dpJitterEventData) == false) goto L8;
        A2dpJitterEventData r10 = (A2dpJitterEventData) r8;
        if (hasDeltaRetransSum() == r10.hasDeltaRetransSum()) goto L13;
        return false;
    L13:
        if (hasDeltaRetransSum() == false) goto L18;
        if (Float.floatToIntBits(getDeltaRetransSum()) == Float.floatToIntBits(r10.getDeltaRetransSum())) goto L18;
        return false;
    L18:
        if (hasNoRxRatio() == r10.hasNoRxRatio()) goto L21;
        return false;
    L21:
        if (hasNoRxRatio() == false) goto L26;
        if (Float.floatToIntBits(getNoRxRatio()) == Float.floatToIntBits(r10.getNoRxRatio())) goto L26;
        return false;
    L26:
        if (hasSilenceDuration() == r10.hasSilenceDuration()) goto L29;
        return false;
    L29:
        if (hasSilenceDuration() == false) goto L34;
        if (Float.floatToIntBits(getSilenceDuration()) == Float.floatToIntBits(r10.getSilenceDuration())) goto L34;
        return false;
    L34:
        if (hasHostBufferMargin() == r10.hasHostBufferMargin()) goto L37;
        return false;
    L37:
        if (hasHostBufferMargin() == false) goto L42;
        if (Float.floatToIntBits(getHostBufferMargin()) == Float.floatToIntBits(r10.getHostBufferMargin())) goto L42;
        return false;
    L42:
        if (hasMAclTxQueueLength() == r10.hasMAclTxQueueLength()) goto L45;
        return false;
    L45:
        if (hasMAclTxQueueLength() == false) goto L50;
        if (getMAclTxQueueLength() == r10.getMAclTxQueueLength()) goto L50;
        return false;
    L50:
        if (hasMGlitchCount() == r10.hasMGlitchCount()) goto L53;
        return false;
    L53:
        if (hasMGlitchCount() == false) goto L58;
        if (getMGlitchCount() == r10.getMGlitchCount()) goto L58;
        return false;
    L58:
        if (hasMNakCount() == r10.hasMNakCount()) goto L61;
        return false;
    L61:
        if (hasMNakCount() == false) goto L66;
        if (getMNakCount() == r10.getMNakCount()) goto L66;
        return false;
    L66:
        if (hasMNoRxCount() == r10.hasMNoRxCount()) goto L69;
        return false;
    L69:
        if (hasMNoRxCount() == false) goto L74;
        if (getMNoRxCount() == r10.getMNoRxCount()) goto L74;
        return false;
    L74:
        if (hasMOverflowCount() == r10.hasMOverflowCount()) goto L77;
        return false;
    L77:
        if (hasMOverflowCount() == false) goto L82;
        if (getMOverflowCount() == r10.getMOverflowCount()) goto L82;
        return false;
    L82:
        if (hasMPacketType() == r10.hasMPacketType()) goto L85;
        return false;
    L85:
        if (hasMPacketType() == false) goto L90;
        if (getMPacketType().equals(r10.getMPacketType()) == true) goto L90;
        return false;
    L90:
        if (hasMTxPowerLevel() == r10.hasMTxPowerLevel()) goto L93;
        return false;
    L93:
        if (hasMTxPowerLevel() == false) goto L98;
        if (getMTxPowerLevel() == r10.getMTxPowerLevel()) goto L98;
        return false;
    L98:
        if (hasProb() == r10.hasProb()) goto L101;
        return false;
    L101:
        if (hasProb() == false) goto L106;
        if (Float.floatToIntBits(getProb()) == Float.floatToIntBits(r10.getProb())) goto L106;
        return false;
    L106:
        if (hasLabel() == r10.hasLabel()) goto L109;
        return false;
    L109:
        if (hasLabel() == false) goto L114;
        if (getLabel() == r10.getLabel()) goto L114;
        return false;
    L114:
        if (hasTimestamp() == r10.hasTimestamp()) goto L117;
        return false;
    L117:
        if (hasTimestamp() == false) goto L122;
        if (getTimestamp() == r10.getTimestamp()) goto L122;
        return false;
    L122:
        if (hasTimeToBtRestartMs() == r10.hasTimeToBtRestartMs()) goto L125;
        return false;
    L125:
        if (hasTimeToBtRestartMs() == false) goto L130;
        if (getTimeToBtRestartMs() == r10.getTimeToBtRestartMs()) goto L130;
        return false;
    L130:
        if (hasTimeToRevertMs() == r10.hasTimeToRevertMs()) goto L133;
        return false;
    L133:
        if (hasTimeToRevertMs() == false) goto L138;
        if (getTimeToRevertMs() == r10.getTimeToRevertMs()) goto L138;
        return false;
    L138:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L140;
        return false;
    L140:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public float getDeltaRetransSum() {
        return this.deltaRetransSum_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public float getHostBufferMargin() {
        return this.hostBufferMargin_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public int getLabel() {
        return this.label_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public int getMAclTxQueueLength() {
        return this.mAclTxQueueLength_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public int getMGlitchCount() {
        return this.mGlitchCount_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public int getMNakCount() {
        return this.mNakCount_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public int getMNoRxCount() {
        return this.mNoRxCount_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public int getMOverflowCount() {
        return this.mOverflowCount_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public String getMPacketType() {
        Object r8 = this.mPacketType_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.mPacketType_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public ByteString getMPacketTypeBytes() {
        Object r8 = this.mPacketType_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.mPacketType_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public int getMTxPowerLevel() {
        return this.mTxPowerLevel_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public float getNoRxRatio() {
        return this.noRxRatio_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<A2dpJitterEventData> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public float getProb() {
        return this.prob_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeFloatSize(1, this.deltaRetransSum_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeFloatSize(2, this.noRxRatio_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + CodedOutputStream.computeFloatSize(3, this.silenceDuration_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeFloatSize(4, this.hostBufferMargin_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.mAclTxQueueLength_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.mGlitchCount_);
    L24:
        if ((this.bitField0_ & 64) == 0) goto L27;
        r10 = r10 + CodedOutputStream.computeInt32Size(7, this.mNakCount_);
    L27:
        if ((this.bitField0_ & 128) == 0) goto L30;
        r10 = r10 + CodedOutputStream.computeInt32Size(8, this.mNoRxCount_);
    L30:
        if ((this.bitField0_ & 256) == 0) goto L33;
        r10 = r10 + CodedOutputStream.computeInt32Size(9, this.mOverflowCount_);
    L33:
        if ((this.bitField0_ & 512) == 0) goto L36;
        r10 = r10 + GeneratedMessage.computeStringSize(10, this.mPacketType_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt32Size(11, this.mTxPowerLevel_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeFloatSize(12, this.prob_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeInt32Size(13, this.label_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt64Size(14, this.timestamp_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L51;
        r10 = r10 + CodedOutputStream.computeInt64Size(15, this.timeToBtRestartMs_);
    L51:
        if ((this.bitField0_ & 32768) == 0) goto L53;
        r10 = r10 + CodedOutputStream.computeInt64Size(16, this.timeToRevertMs_);
    L53:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public float getSilenceDuration() {
        return this.silenceDuration_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public long getTimeToBtRestartMs() {
        return this.timeToBtRestartMs_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public long getTimeToRevertMs() {
        return this.timeToRevertMs_;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasDeltaRetransSum() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasHostBufferMargin() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasLabel() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasMAclTxQueueLength() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasMGlitchCount() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasMNakCount() {
        if ((this.bitField0_ & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasMNoRxCount() {
        if ((this.bitField0_ & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasMOverflowCount() {
        if ((this.bitField0_ & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasMPacketType() {
        if ((this.bitField0_ & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasMTxPowerLevel() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasNoRxRatio() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasProb() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasSilenceDuration() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasTimeToBtRestartMs() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasTimeToRevertMs() {
        if ((this.bitField0_ & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.bluetooth.A2dpJitterEventDataOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
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
        if (hasDeltaRetransSum() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + Float.floatToIntBits(getDeltaRetransSum());
    L9:
        if (hasNoRxRatio() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + Float.floatToIntBits(getNoRxRatio());
    L12:
        if (hasSilenceDuration() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + Float.floatToIntBits(getSilenceDuration());
    L15:
        if (hasHostBufferMargin() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Float.floatToIntBits(getHostBufferMargin());
    L18:
        if (hasMAclTxQueueLength() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getMAclTxQueueLength();
    L21:
        if (hasMGlitchCount() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getMGlitchCount();
    L24:
        if (hasMNakCount() == false) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getMNakCount();
    L27:
        if (hasMNoRxCount() == false) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getMNoRxCount();
    L30:
        if (hasMOverflowCount() == false) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getMOverflowCount();
    L33:
        if (hasMPacketType() == false) goto L36;
        r10 = b.a(r10, 37, 10, 53) + getMPacketType().hashCode();
    L36:
        if (hasMTxPowerLevel() == false) goto L39;
        r10 = b.a(r10, 37, 11, 53) + getMTxPowerLevel();
    L39:
        if (hasProb() == false) goto L42;
        r10 = b.a(r10, 37, 12, 53) + Float.floatToIntBits(getProb());
    L42:
        if (hasLabel() == false) goto L45;
        r10 = b.a(r10, 37, 13, 53) + getLabel();
    L45:
        if (hasTimestamp() == false) goto L48;
        r10 = b.a(r10, 37, 14, 53) + Internal.hashLong(getTimestamp());
    L48:
        if (hasTimeToBtRestartMs() == false) goto L51;
        r10 = b.a(r10, 37, 15, 53) + Internal.hashLong(getTimeToBtRestartMs());
    L51:
        if (hasTimeToRevertMs() == false) goto L53;
        r10 = b.a(r10, 37, 16, 53) + Internal.hashLong(getTimeToRevertMs());
    L53:
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
        return new A2dpJitterEventData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeFloat(1, this.deltaRetransSum_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeFloat(2, this.noRxRatio_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        r8.writeFloat(3, this.silenceDuration_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeFloat(4, this.hostBufferMargin_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.mAclTxQueueLength_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.mGlitchCount_);
    L21:
        if ((this.bitField0_ & 64) == 0) goto L24;
        r8.writeInt32(7, this.mNakCount_);
    L24:
        if ((this.bitField0_ & 128) == 0) goto L27;
        r8.writeInt32(8, this.mNoRxCount_);
    L27:
        if ((this.bitField0_ & 256) == 0) goto L30;
        r8.writeInt32(9, this.mOverflowCount_);
    L30:
        if ((this.bitField0_ & 512) == 0) goto L33;
        GeneratedMessage.writeString(r8, 10, this.mPacketType_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt32(11, this.mTxPowerLevel_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeFloat(12, this.prob_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeInt32(13, this.label_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeInt64(14, this.timestamp_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L48;
        r8.writeInt64(15, this.timeToBtRestartMs_);
    L48:
        if ((this.bitField0_ & 32768) == 0) goto L50;
        r8.writeInt64(16, this.timeToRevertMs_);
    L50:
        getUnknownFields().writeTo(r8);
    }

    private A2dpJitterEventData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.deltaRetransSum_ = 0.0f;
        this.noRxRatio_ = 0.0f;
        this.silenceDuration_ = 0.0f;
        this.hostBufferMargin_ = 0.0f;
        this.mAclTxQueueLength_ = 0;
        this.mGlitchCount_ = 0;
        this.mNakCount_ = 0;
        this.mNoRxCount_ = 0;
        this.mOverflowCount_ = 0;
        this.mPacketType_ = "";
        this.mTxPowerLevel_ = 0;
        this.prob_ = 0.0f;
        this.label_ = 0;
        this.timestamp_ = 0;
        this.timeToBtRestartMs_ = 0;
        this.timeToRevertMs_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(A2dpJitterEventData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static A2dpJitterEventData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (A2dpJitterEventData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static A2dpJitterEventData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeBluetoothEvent.internal_static_com_obric_cae_bluetooth_A2dpJitterEventData_fieldAccessorTable.ensureFieldAccessorsInitialized(A2dpJitterEventData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ A2dpJitterEventData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static A2dpJitterEventData parseFrom(CodedInputStream r8) {
        return (A2dpJitterEventData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public A2dpJitterEventData getDefaultInstanceForType() {
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

    public static A2dpJitterEventData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (A2dpJitterEventData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static A2dpJitterEventData parseFrom(InputStream r8) {
        return (A2dpJitterEventData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static A2dpJitterEventData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (A2dpJitterEventData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static A2dpJitterEventData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static A2dpJitterEventData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static A2dpJitterEventData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static A2dpJitterEventData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
