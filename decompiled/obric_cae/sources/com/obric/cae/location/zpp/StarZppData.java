package com.obric.cae.location.zpp;

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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class StarZppData extends GeneratedMessageV3 implements StarZppDataOrBuilder {
    public static final int CONFIDENCE_FIELD_NUMBER = 3;
    private static final StarZppData DEFAULT_INSTANCE = null;
    public static final int EVAL_FIELD_NUMBER = 5;
    public static final int FEATURE_ARRAY_FIELD_NUMBER = 4;
    public static final int MODEL_VERSION_FIELD_NUMBER = 1;

    @Deprecated
    public static final Parser<StarZppData> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    public static final int ZPP_STRATEGY_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private Internal.FloatList confidence_;
    private Internal.FloatList eval_;
    private Internal.FloatList featureArray_;
    private byte memoizedIsInitialized;
    private volatile Object modelVersion_;
    private Internal.LongList timestamp_;
    private int zppStrategy_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements StarZppDataOrBuilder {
        private int bitField0_;
        private Internal.FloatList confidence_;
        private Internal.FloatList eval_;
        private Internal.FloatList featureArray_;
        private Object modelVersion_;
        private Internal.LongList timestamp_;
        private int zppStrategy_;

        private Builder() {
            this.modelVersion_ = "";
            this.timestamp_ = StarZppData.access$1400();
            this.confidence_ = StarZppData.access$1700();
            this.featureArray_ = StarZppData.access$2000();
            this.eval_ = StarZppData.access$2300();
        }

        private void buildPartial0(StarZppData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            StarZppData.access$1102(r8, this.modelVersion_);
            int r11 = 1;
        L7:
            if ((r10 & 32) == 0) goto L9;
            StarZppData.access$1202(r8, this.zppStrategy_);
            r11 = r11 | 2;
        L9:
            StarZppData.access$1376(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialRepeatedFields(StarZppData r8) {
            if ((this.bitField0_ & 2) == 0) goto L5;
            this.timestamp_.makeImmutable();
            this.bitField0_ &= -3;
        L5:
            StarZppData.access$702(r8, this.timestamp_);
            if ((this.bitField0_ & 4) == 0) goto L8;
            this.confidence_.makeImmutable();
            this.bitField0_ &= -5;
        L8:
            StarZppData.access$802(r8, this.confidence_);
            if ((this.bitField0_ & 8) == 0) goto L11;
            this.featureArray_.makeImmutable();
            this.bitField0_ &= -9;
        L11:
            StarZppData.access$902(r8, this.featureArray_);
            if ((this.bitField0_ & 16) == 0) goto L14;
            this.eval_.makeImmutable();
            this.bitField0_ &= -17;
        L14:
            StarZppData.access$1002(r8, this.eval_);
        }

        private void ensureConfidenceIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.confidence_ = StarZppData.access$1800(this.confidence_);
            this.bitField0_ |= 4;
            return;
        }

        private void ensureEvalIsMutable() {
            if ((this.bitField0_ & 16) != 0) goto L6;
            this.eval_ = StarZppData.access$2400(this.eval_);
            this.bitField0_ |= 16;
            return;
        }

        private void ensureFeatureArrayIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.featureArray_ = StarZppData.access$2100(this.featureArray_);
            this.bitField0_ |= 8;
            return;
        }

        private void ensureTimestampIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.timestamp_ = StarZppData.access$1500(this.timestamp_);
            this.bitField0_ |= 2;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return StarZppEvent.internal_static_com_obric_cae_location_zpp_StarZppData_descriptor;
        }

        public Builder addAllConfidence(Iterable<? extends Float> r8) {
            ensureConfidenceIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.confidence_);
            onChanged();
            return this;
        }

        public Builder addAllEval(Iterable<? extends Float> r8) {
            ensureEvalIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.eval_);
            onChanged();
            return this;
        }

        public Builder addAllFeatureArray(Iterable<? extends Float> r8) {
            ensureFeatureArrayIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.featureArray_);
            onChanged();
            return this;
        }

        public Builder addAllTimestamp(Iterable<? extends Long> r8) {
            ensureTimestampIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.timestamp_);
            onChanged();
            return this;
        }

        public Builder addConfidence(float r8) {
            ensureConfidenceIsMutable();
            this.confidence_.addFloat(r8);
            onChanged();
            return this;
        }

        public Builder addEval(float r8) {
            ensureEvalIsMutable();
            this.eval_.addFloat(r8);
            onChanged();
            return this;
        }

        public Builder addFeatureArray(float r8) {
            ensureFeatureArrayIsMutable();
            this.featureArray_.addFloat(r8);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addTimestamp(long r8) {
            ensureTimestampIsMutable();
            this.timestamp_.addLong(r8);
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

        public Builder clearConfidence() {
            this.confidence_ = StarZppData.access$1900();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearEval() {
            this.eval_ = StarZppData.access$2500();
            this.bitField0_ &= -17;
            onChanged();
            return this;
        }

        public Builder clearFeatureArray() {
            this.featureArray_ = StarZppData.access$2200();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearModelVersion() {
            this.modelVersion_ = StarZppData.getDefaultInstance().getModelVersion();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearTimestamp() {
            this.timestamp_ = StarZppData.access$1600();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearZppStrategy() {
            this.bitField0_ &= -33;
            this.zppStrategy_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public float getConfidence(int r8) {
            return this.confidence_.getFloat(r8);
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public int getConfidenceCount() {
            return this.confidence_.size();
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public List<Float> getConfidenceList() {
            int r8 = this.bitField0_ & 4;
            Internal.FloatList r10 = this.confidence_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return StarZppEvent.internal_static_com_obric_cae_location_zpp_StarZppData_descriptor;
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public float getEval(int r8) {
            return this.eval_.getFloat(r8);
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public int getEvalCount() {
            return this.eval_.size();
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public List<Float> getEvalList() {
            int r8 = this.bitField0_ & 16;
            Internal.FloatList r10 = this.eval_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public float getFeatureArray(int r8) {
            return this.featureArray_.getFloat(r8);
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public int getFeatureArrayCount() {
            return this.featureArray_.size();
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public List<Float> getFeatureArrayList() {
            int r8 = this.bitField0_ & 8;
            Internal.FloatList r10 = this.featureArray_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public String getModelVersion() {
            Object r8 = this.modelVersion_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.modelVersion_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public ByteString getModelVersionBytes() {
            Object r8 = this.modelVersion_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.modelVersion_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public long getTimestamp(int r8) {
            return this.timestamp_.getLong(r8);
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public int getTimestampCount() {
            return this.timestamp_.size();
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public List<Long> getTimestampList() {
            int r8 = this.bitField0_ & 2;
            Internal.LongList r10 = this.timestamp_;
            if (r8 != 0) goto L5;
            return r10;
        L5:
            return Collections.unmodifiableList(r10);
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public int getZppStrategy() {
            return this.zppStrategy_;
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public boolean hasModelVersion() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
        public boolean hasZppStrategy() {
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
            if (hasModelVersion() == true) goto L6;
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

        public Builder setConfidence(int r8, float r10) {
            ensureConfidenceIsMutable();
            this.confidence_.setFloat(r8, r10);
            onChanged();
            return this;
        }

        public Builder setEval(int r8, float r10) {
            ensureEvalIsMutable();
            this.eval_.setFloat(r8, r10);
            onChanged();
            return this;
        }

        public Builder setFeatureArray(int r8, float r10) {
            ensureFeatureArrayIsMutable();
            this.featureArray_.setFloat(r8, r10);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setModelVersion(String r8) {
            if (r8 == null) goto L6;
            this.modelVersion_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setModelVersionBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.modelVersion_ = r8;
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

        public Builder setTimestamp(int r8, long r10) {
            ensureTimestampIsMutable();
            this.timestamp_.setLong(r8, r10);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public Builder setZppStrategy(int r8) {
            this.zppStrategy_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.modelVersion_ = "";
            this.timestamp_ = StarZppData.access$1400();
            this.confidence_ = StarZppData.access$1700();
            this.featureArray_ = StarZppData.access$2000();
            this.eval_ = StarZppData.access$2300();
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
            return StarZppEvent.internal_static_com_obric_cae_location_zpp_StarZppData_fieldAccessorTable.ensureFieldAccessorsInitialized(StarZppData.class, Builder.class);
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
        public StarZppData build() {
            StarZppData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public StarZppData buildPartial() {
            StarZppData r8 = new StarZppData(this, null);
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
        public StarZppData getDefaultInstanceForType() {
            return StarZppData.getDefaultInstance();
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
            this.modelVersion_ = "";
            this.timestamp_ = StarZppData.access$200();
            this.confidence_ = StarZppData.access$300();
            this.featureArray_ = StarZppData.access$400();
            this.eval_ = StarZppData.access$500();
            this.zppStrategy_ = 0;
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
                case 10: goto L31;
                case 16: goto L30;
                case 18: goto L26;
                case 26: goto L22;
                case 29: goto L21;
                case 34: goto L17;
                case 37: goto L16;
                case 42: goto L11;
                case 45: goto L9;
                case 48: goto L8;
                default: goto L34;
            };     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L8:
            this.zppStrategy_ = r8.readUInt32();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L9:
            float r13 = r8.readFloat();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureEvalIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            Internal.FloatList r14 = this.eval_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L10:
            r14.addFloat(r13);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L11:
            int r15 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureEvalIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L13:
            if (r8.getBytesUntilLimit() <= 0) goto L15;
            this.eval_.addFloat(r8.readFloat());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L15:
            r8.popLimit(r15);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L16:
            r13 = r8.readFloat();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureFeatureArrayIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            r14 = this.featureArray_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L10
        L17:
            r15 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureFeatureArrayIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L19:
            if (r8.getBytesUntilLimit() <= 0) goto L15;
            this.featureArray_.addFloat(r8.readFloat());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L19
        L21:
            r13 = r8.readFloat();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureConfidenceIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            r14 = this.confidence_;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L10
        L22:
            r15 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureConfidenceIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L24:
            if (r8.getBytesUntilLimit() <= 0) goto L15;
            this.confidence_.addFloat(r8.readFloat());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L24
        L26:
            r15 = r8.pushLimit(r8.readRawVarint32());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureTimestampIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L28:
            if (r8.getBytesUntilLimit() <= 0) goto L15;
            this.timestamp_.addLong(r8.readUInt64());     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L28
        L30:
            long r16 = r8.readUInt64();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            ensureTimestampIsMutable();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.timestamp_.addLong(r16);     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            goto L4
        L31:
            this.modelVersion_ = r8.readBytes();     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 InvalidProtocolBufferException -> L38
        L33:
            r11 = true;
            goto L4
        L34:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
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
            if ((r8 instanceof StarZppData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((StarZppData) r8);
        }

        public Builder mergeFrom(StarZppData r8) {
            if (r8 != StarZppData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasModelVersion() == false) goto L9;
            this.modelVersion_ = StarZppData.access$1100(r8);
            this.bitField0_ |= 1;
            onChanged();
        L9:
            if (StarZppData.access$700(r8).isEmpty() == true) goto L16;
            if (this.timestamp_.isEmpty() == false) goto L13;
            this.timestamp_ = StarZppData.access$700(r8);
            this.bitField0_ &= -3;
        L14:
            onChanged();
            goto L16
        L13:
            ensureTimestampIsMutable();
            this.timestamp_.addAll(StarZppData.access$700(r8));
        L16:
            if (StarZppData.access$800(r8).isEmpty() == true) goto L23;
            if (this.confidence_.isEmpty() == false) goto L20;
            this.confidence_ = StarZppData.access$800(r8);
            this.bitField0_ &= -5;
        L21:
            onChanged();
            goto L23
        L20:
            ensureConfidenceIsMutable();
            this.confidence_.addAll(StarZppData.access$800(r8));
        L23:
            if (StarZppData.access$900(r8).isEmpty() == true) goto L30;
            if (this.featureArray_.isEmpty() == false) goto L27;
            this.featureArray_ = StarZppData.access$900(r8);
            this.bitField0_ &= -9;
        L28:
            onChanged();
            goto L30
        L27:
            ensureFeatureArrayIsMutable();
            this.featureArray_.addAll(StarZppData.access$900(r8));
        L30:
            if (StarZppData.access$1000(r8).isEmpty() == true) goto L37;
            if (this.eval_.isEmpty() == false) goto L34;
            this.eval_ = StarZppData.access$1000(r8);
            this.bitField0_ &= -17;
        L35:
            onChanged();
            goto L37
        L34:
            ensureEvalIsMutable();
            this.eval_.addAll(StarZppData.access$1000(r8));
        L37:
            if (r8.hasZppStrategy() == false) goto L39;
            setZppStrategy(r8.getZppStrategy());
        L39:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        }
    }

    static {
        DEFAULT_INSTANCE = new StarZppData();
        PARSER = new AnonymousClass1();
    }

    private StarZppData() {
        this.modelVersion_ = "";
        this.zppStrategy_ = 0;
        this.memoizedIsInitialized = -1;
        this.modelVersion_ = "";
        this.timestamp_ = GeneratedMessage.emptyLongList();
        this.confidence_ = GeneratedMessage.emptyFloatList();
        this.featureArray_ = GeneratedMessage.emptyFloatList();
        this.eval_ = GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$1000(StarZppData r8) {
        return r8.eval_;
    }

    public static /* synthetic */ Internal.FloatList access$1002(StarZppData r8, Internal.FloatList r10) {
        r8.eval_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1100(StarZppData r8) {
        return r8.modelVersion_;
    }

    public static /* synthetic */ Object access$1102(StarZppData r8, Object r10) {
        r8.modelVersion_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1202(StarZppData r8, int r10) {
        r8.zppStrategy_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1376(StarZppData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ Internal.LongList access$1400() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$1500(Internal.LongList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.LongList access$1600() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.FloatList access$1700() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$1800(Internal.FloatList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.FloatList access$1900() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.LongList access$200() {
        return GeneratedMessage.emptyLongList();
    }

    public static /* synthetic */ Internal.FloatList access$2000() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$2100(Internal.FloatList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.FloatList access$2200() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$2300() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$2400(Internal.FloatList r8) {
        return GeneratedMessageV3.mutableCopy(r8);
    }

    public static /* synthetic */ Internal.FloatList access$2500() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$300() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$400() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.FloatList access$500() {
        return GeneratedMessage.emptyFloatList();
    }

    public static /* synthetic */ Internal.LongList access$700(StarZppData r8) {
        return r8.timestamp_;
    }

    public static /* synthetic */ Internal.LongList access$702(StarZppData r8, Internal.LongList r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.FloatList access$800(StarZppData r8) {
        return r8.confidence_;
    }

    public static /* synthetic */ Internal.FloatList access$802(StarZppData r8, Internal.FloatList r10) {
        r8.confidence_ = r10;
        return r10;
    }

    public static /* synthetic */ Internal.FloatList access$900(StarZppData r8) {
        return r8.featureArray_;
    }

    public static /* synthetic */ Internal.FloatList access$902(StarZppData r8, Internal.FloatList r10) {
        r8.featureArray_ = r10;
        return r10;
    }

    public static StarZppData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return StarZppEvent.internal_static_com_obric_cae_location_zpp_StarZppData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static StarZppData parseDelimitedFrom(InputStream r8) {
        return (StarZppData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static StarZppData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<StarZppData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof StarZppData) == false) goto L8;
        StarZppData r10 = (StarZppData) r8;
        if (hasModelVersion() == r10.hasModelVersion()) goto L13;
        return false;
    L13:
        if (hasModelVersion() == false) goto L18;
        if (getModelVersion().equals(r10.getModelVersion()) == true) goto L18;
        return false;
    L18:
        if (getTimestampList().equals(r10.getTimestampList()) == true) goto L21;
        return false;
    L21:
        if (getConfidenceList().equals(r10.getConfidenceList()) == true) goto L24;
        return false;
    L24:
        if (getFeatureArrayList().equals(r10.getFeatureArrayList()) == true) goto L27;
        return false;
    L27:
        if (getEvalList().equals(r10.getEvalList()) == true) goto L30;
        return false;
    L30:
        if (hasZppStrategy() == r10.hasZppStrategy()) goto L33;
        return false;
    L33:
        if (hasZppStrategy() == false) goto L38;
        if (getZppStrategy() == r10.getZppStrategy()) goto L38;
        return false;
    L38:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L40;
        return false;
    L40:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public float getConfidence(int r8) {
        return this.confidence_.getFloat(r8);
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public int getConfidenceCount() {
        return this.confidence_.size();
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public List<Float> getConfidenceList() {
        return this.confidence_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public float getEval(int r8) {
        return this.eval_.getFloat(r8);
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public int getEvalCount() {
        return this.eval_.size();
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public List<Float> getEvalList() {
        return this.eval_;
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public float getFeatureArray(int r8) {
        return this.featureArray_.getFloat(r8);
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public int getFeatureArrayCount() {
        return this.featureArray_.size();
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public List<Float> getFeatureArrayList() {
        return this.featureArray_;
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public String getModelVersion() {
        Object r8 = this.modelVersion_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.modelVersion_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public ByteString getModelVersionBytes() {
        Object r8 = this.modelVersion_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.modelVersion_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<StarZppData> getParserForType() {
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
        int r11 = GeneratedMessage.computeStringSize(1, this.modelVersion_) + 0;
    L9:
        int r12 = 0;
    L11:
        if (r10 >= this.timestamp_.size()) goto L13;
        r12 = r12 + CodedOutputStream.computeUInt64SizeNoTag(this.timestamp_.getLong(r10));
        r10 = r10 + 1;
        goto L11
    L13:
        int r13 = (getEvalList().size() * 1) + ((getEvalList().size() * 4) + ((getFeatureArrayList().size() * 1) + ((getFeatureArrayList().size() * 4) + ((getConfidenceList().size() * 1) + ((getConfidenceList().size() * 4) + ((getTimestampList().size() * 1) + (r11 + r12)))))));
        if ((this.bitField0_ & 2) == 0) goto L16;
        r13 = r13 + CodedOutputStream.computeUInt32Size(6, this.zppStrategy_);
    L16:
        int r14 = getUnknownFields().getSerializedSize() + r13;
        this.memoizedSize = r14;
        return r14;
    L8:
        r11 = 0;
        goto L9
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public long getTimestamp(int r8) {
        return this.timestamp_.getLong(r8);
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public int getTimestampCount() {
        return this.timestamp_.size();
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public List<Long> getTimestampList() {
        return this.timestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public int getZppStrategy() {
        return this.zppStrategy_;
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public boolean hasModelVersion() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.location.zpp.StarZppDataOrBuilder
    public boolean hasZppStrategy() {
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
        if (hasModelVersion() == false) goto L9;
        r10 = defpackage.b.a(r10, 37, 1, 53) + getModelVersion().hashCode();
    L9:
        if (getTimestampCount() <= 0) goto L12;
        r10 = defpackage.b.a(r10, 37, 2, 53) + getTimestampList().hashCode();
    L12:
        if (getConfidenceCount() <= 0) goto L15;
        r10 = defpackage.b.a(r10, 37, 3, 53) + getConfidenceList().hashCode();
    L15:
        if (getFeatureArrayCount() <= 0) goto L18;
        r10 = defpackage.b.a(r10, 37, 4, 53) + getFeatureArrayList().hashCode();
    L18:
        if (getEvalCount() <= 0) goto L21;
        r10 = defpackage.b.a(r10, 37, 5, 53) + getEvalList().hashCode();
    L21:
        if (hasZppStrategy() == false) goto L23;
        r10 = defpackage.b.a(r10, 37, 6, 53) + getZppStrategy();
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
        if (hasModelVersion() == true) goto L12;
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
        return new StarZppData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L5;
        GeneratedMessage.writeString(r8, 1, this.modelVersion_);
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r11 >= this.timestamp_.size()) goto L9;
        r8.writeUInt64(2, this.timestamp_.getLong(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.confidence_.size()) goto L13;
        r8.writeFloat(3, this.confidence_.getFloat(r12));
        r12 = r12 + 1;
        goto L11
    L13:
        int r13 = 0;
    L15:
        if (r13 >= this.featureArray_.size()) goto L18;
        r8.writeFloat(4, this.featureArray_.getFloat(r13));
        r13 = r13 + 1;
    L18:
        if (r10 >= this.eval_.size()) goto L21;
        r8.writeFloat(5, this.eval_.getFloat(r10));
        r10 = r10 + 1;
        goto L18
    L21:
        if ((this.bitField0_ & 2) == 0) goto L23;
        r8.writeUInt32(6, this.zppStrategy_);
    L23:
        getUnknownFields().writeTo(r8);
    }

    private StarZppData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.modelVersion_ = "";
        this.zppStrategy_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(StarZppData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static StarZppData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StarZppData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static StarZppData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return StarZppEvent.internal_static_com_obric_cae_location_zpp_StarZppData_fieldAccessorTable.ensureFieldAccessorsInitialized(StarZppData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ StarZppData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static StarZppData parseFrom(CodedInputStream r8) {
        return (StarZppData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public StarZppData getDefaultInstanceForType() {
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

    public static StarZppData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (StarZppData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static StarZppData parseFrom(InputStream r8) {
        return (StarZppData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static StarZppData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (StarZppData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static StarZppData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static StarZppData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static StarZppData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static StarZppData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
