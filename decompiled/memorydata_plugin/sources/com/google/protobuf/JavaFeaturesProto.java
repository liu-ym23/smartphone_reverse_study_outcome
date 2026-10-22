package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaFeaturesProto {
    public static final int JAVA_FIELD_NUMBER = 1001;
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_pb_JavaFeatures_NestInFileClassFeature_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_pb_JavaFeatures_NestInFileClassFeature_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_pb_JavaFeatures_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_pb_JavaFeatures_fieldAccessorTable = null;
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> java_ = null;

    /* JADX INFO: renamed from: com.google.protobuf.JavaFeaturesProto$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class JavaFeatures extends GeneratedMessage implements JavaFeaturesOrBuilder {
        private static final JavaFeatures DEFAULT_INSTANCE = null;
        public static final int LARGE_ENUM_FIELD_NUMBER = 3;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        public static final int NEST_IN_FILE_CLASS_FIELD_NUMBER = 5;
        private static final Parser<JavaFeatures> PARSER = null;
        public static final int USE_OLD_OUTER_CLASSNAME_DEFAULT_FIELD_NUMBER = 4;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean largeEnum_;
        private boolean legacyClosedEnum_;
        private byte memoizedIsInitialized;
        private int nestInFileClass_;
        private boolean useOldOuterClassnameDefault_;
        private int utf8Validation_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements JavaFeaturesOrBuilder {
            private int bitField0_;
            private boolean largeEnum_;
            private boolean legacyClosedEnum_;
            private int nestInFileClass_;
            private boolean useOldOuterClassnameDefault_;
            private int utf8Validation_;

            private Builder() {
                this.utf8Validation_ = 0;
                this.nestInFileClass_ = 0;
            }

            private Builder(AbstractMessage.BuilderParent r3) {
                super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
                this.utf8Validation_ = 0;
                this.nestInFileClass_ = 0;
            }

            /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
                this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            }

            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private void buildPartial0(JavaFeatures r4) {
                int r0 = this.bitField0_;
                if ((r0 & 1) == 0) goto L5;
                JavaFeatures.access$1002(r4, this.legacyClosedEnum_);
                int r1 = 1;
            L7:
                if ((r0 & 2) == 0) goto L10;
                JavaFeatures.access$1102(r4, this.utf8Validation_);
                r1 = r1 | 2;
            L10:
                if ((r0 & 4) == 0) goto L13;
                JavaFeatures.access$1202(r4, this.largeEnum_);
                r1 = r1 | 4;
            L13:
                if ((r0 & 8) == 0) goto L16;
                JavaFeatures.access$1302(r4, this.useOldOuterClassnameDefault_);
                r1 = r1 | 8;
            L16:
                if ((r0 & 16) == 0) goto L18;
                JavaFeatures.access$1402(r4, this.nestInFileClass_);
                r1 = r1 | 16;
            L18:
                JavaFeatures.access$1576(r4, r1);
                return;
            L5:
                r1 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return JavaFeaturesProto.access$000();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures build() {
                JavaFeatures r1 = buildPartial();
                if (r1.isInitialized() == false) goto L6;
                return r1;
            L6:
                throw newUninitializedMessageException(r1);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures buildPartial() {
                JavaFeatures r0 = new JavaFeatures(this, null);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r0);
            L5:
                onBuilt();
                return r0;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.legacyClosedEnum_ = false;
                this.utf8Validation_ = 0;
                this.largeEnum_ = false;
                this.useOldOuterClassnameDefault_ = false;
                this.nestInFileClass_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            public Builder clearLargeEnum() {
                this.bitField0_ &= -5;
                this.largeEnum_ = false;
                onChanged();
                return this;
            }

            public Builder clearLegacyClosedEnum() {
                this.bitField0_ &= -2;
                this.legacyClosedEnum_ = false;
                onChanged();
                return this;
            }

            public Builder clearNestInFileClass() {
                this.bitField0_ &= -17;
                this.nestInFileClass_ = 0;
                onChanged();
                return this;
            }

            public Builder clearUseOldOuterClassnameDefault() {
                this.bitField0_ &= -9;
                this.useOldOuterClassnameDefault_ = false;
                onChanged();
                return this;
            }

            public Builder clearUtf8Validation() {
                this.bitField0_ &= -3;
                this.utf8Validation_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public JavaFeatures getDefaultInstanceForType() {
                return JavaFeatures.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return JavaFeaturesProto.access$000();
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getLargeEnum() {
                return this.largeEnum_;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getLegacyClosedEnum() {
                return this.legacyClosedEnum_;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public NestInFileClassFeature.NestInFileClass getNestInFileClass() {
                NestInFileClassFeature.NestInFileClass r0 = NestInFileClassFeature.NestInFileClass.forNumber(this.nestInFileClass_);
                if (r0 == null) goto L5;
                return r0;
            L5:
                return NestInFileClassFeature.NestInFileClass.NEST_IN_FILE_CLASS_UNKNOWN;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getUseOldOuterClassnameDefault() {
                return this.useOldOuterClassnameDefault_;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public Utf8Validation getUtf8Validation() {
                Utf8Validation r0 = Utf8Validation.forNumber(this.utf8Validation_);
                if (r0 == null) goto L5;
                return r0;
            L5:
                return Utf8Validation.UTF8_VALIDATION_UNKNOWN;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasLargeEnum() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasLegacyClosedEnum() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasNestInFileClass() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasUseOldOuterClassnameDefault() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasUtf8Validation() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return JavaFeaturesProto.access$100().ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                return mergeFrom(r1, r2);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
                return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                return mergeFrom(r1, r2);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r7, ExtensionRegistryLite r8) {
                Objects.requireNonNull(r8);
                boolean r0 = false;
            L3:
                if (r0 == true) goto L40;
                int r1 = r7.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (r1 == 0) goto L32;
                int r3 = 8;
                if (r1 != 8) goto L9;
                this.legacyClosedEnum_ = r7.readBool();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 1;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L9:
                if (r1 != 16) goto L11;
                int r2 = r7.readEnum();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                r3 = 2;
                if (Utf8Validation.forNumber(r2) != null) goto L29;
                mergeUnknownVarintField(2, r2);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L29:
                this.utf8Validation_ = r2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                int r4 = this.bitField0_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            L24:
                this.bitField0_ = r4 | r3;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L11:
                if (r1 != 24) goto L13;
                this.largeEnum_ = r7.readBool();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 4;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L13:
                if (r1 != 32) goto L15;
                this.useOldOuterClassnameDefault_ = r7.readBool();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                r4 = this.bitField0_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L24
            L15:
                if (r1 != 40) goto L17;
                int r5 = r7.readEnum();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (NestInFileClassFeature.NestInFileClass.forNumber(r5) == null) goto L21;
                this.nestInFileClass_ = r5;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 16;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L21:
                mergeUnknownVarintField(5, r5);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L3
            L17:
                if (super.parseUnknownField(r7, r8, r1) == true) goto L3;
            L32:
                r0 = true;
                goto L3
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
            }

            public Builder mergeFrom(JavaFeatures r2) {
                if (r2 != JavaFeatures.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r2.hasLegacyClosedEnum() == false) goto L9;
                setLegacyClosedEnum(r2.getLegacyClosedEnum());
            L9:
                if (r2.hasUtf8Validation() == false) goto L12;
                setUtf8Validation(r2.getUtf8Validation());
            L12:
                if (r2.hasLargeEnum() == false) goto L15;
                setLargeEnum(r2.getLargeEnum());
            L15:
                if (r2.hasUseOldOuterClassnameDefault() == false) goto L18;
                setUseOldOuterClassnameDefault(r2.getUseOldOuterClassnameDefault());
            L18:
                if (r2.hasNestInFileClass() == false) goto L20;
                setNestInFileClass(r2.getNestInFileClass());
            L20:
                mergeUnknownFields(r2.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r3) {
                Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r4, JavaFeatures.class) == true) goto L5;
                super.mergeFrom(r4);
                return this;
            L5:
                return mergeFrom((JavaFeatures) ZeusTransformUtils.preCheckCast(r4, JavaFeatures.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                return mergeFrom(r1, r2);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* synthetic */ Message.Builder mergeFrom(Message r3) {
                return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                return mergeFrom(r1, r2);
            }

            public Builder setLargeEnum(boolean r1) {
                this.largeEnum_ = r1;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setLegacyClosedEnum(boolean r1) {
                this.legacyClosedEnum_ = r1;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setNestInFileClass(NestInFileClassFeature.NestInFileClass r2) {
                Objects.requireNonNull(r2);
                this.bitField0_ |= 16;
                this.nestInFileClass_ = r2.getNumber();
                onChanged();
                return this;
            }

            public Builder setUseOldOuterClassnameDefault(boolean r1) {
                this.useOldOuterClassnameDefault_ = r1;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setUtf8Validation(Utf8Validation r2) {
                Objects.requireNonNull(r2);
                this.bitField0_ |= 2;
                this.utf8Validation_ = r2.getNumber();
                onChanged();
                return this;
            }
        }

        public static final class NestInFileClassFeature extends GeneratedMessage implements NestInFileClassFeatureOrBuilder {
            private static final NestInFileClassFeature DEFAULT_INSTANCE = null;
            private static final Parser<NestInFileClassFeature> PARSER = null;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;

            public static final class Builder extends GeneratedMessage.Builder<Builder> implements NestInFileClassFeatureOrBuilder {
                private Builder() {
                }

                private Builder(AbstractMessage.BuilderParent r3) {
                    super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
                }

                /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
                    this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
                }

                /* synthetic */ Builder(AnonymousClass1 r1) {
                    this();
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return JavaFeaturesProto.access$200();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NestInFileClassFeature build() {
                    NestInFileClassFeature r1 = buildPartial();
                    if (r1.isInitialized() == false) goto L6;
                    return r1;
                L6:
                    throw newUninitializedMessageException(r1);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NestInFileClassFeature buildPartial() {
                    NestInFileClassFeature r0 = new NestInFileClassFeature(this, null);
                    onBuilt();
                    return r0;
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public NestInFileClassFeature getDefaultInstanceForType() {
                    return NestInFileClassFeature.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return JavaFeaturesProto.access$200();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder
                public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return JavaFeaturesProto.access$300().ensureFieldAccessorsInitialized(NestInFileClassFeature.class, Builder.class);
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                    return mergeFrom(r1, r2);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
                    return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                    return mergeFrom(r1, r2);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream r4, ExtensionRegistryLite r5) {
                    Objects.requireNonNull(r5);
                    boolean r0 = false;
                L3:
                    if (r0 == true) goto L16;
                    int r1 = r4.readTag();     // Catch: Throwable -> L9 InvalidProtocolBufferException -> L11
                    if (r1 == 0) goto L8;
                    if (super.parseUnknownField(r4, r5, r1) == true) goto L3;
                L8:
                    r0 = true;
                L11:
                    e = move-exception;
                    throw e.unwrapIOException();     // Catch: Throwable -> L9
                L9:
                    th = move-exception;
                    onChanged();
                    throw th;
                L16:
                    onChanged();
                    return this;
                }

                public Builder mergeFrom(NestInFileClassFeature r2) {
                    if (r2 != NestInFileClassFeature.getDefaultInstance()) goto L5;
                    return this;
                L5:
                    mergeUnknownFields(r2.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message r3) {
                    Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
                    if (ZeusTransformUtils.instanceOf(r4, NestInFileClassFeature.class) == true) goto L5;
                    super.mergeFrom(r4);
                    return this;
                L5:
                    return mergeFrom((NestInFileClassFeature) ZeusTransformUtils.preCheckCast(r4, NestInFileClassFeature.class, "com.obric.memorydata.plugin"));
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                    return mergeFrom(r1, r2);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* synthetic */ Message.Builder mergeFrom(Message r3) {
                    return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                    return mergeFrom(r1, r2);
                }
            }

            public static final enum NestInFileClass extends java.lang.Enum<NestInFileClass> implements ProtocolMessageEnum {
                private static final /* synthetic */ NestInFileClass[] $VALUES = null;
                public static final NestInFileClass LEGACY = null;
                public static final int LEGACY_VALUE = 3;
                public static final NestInFileClass NEST_IN_FILE_CLASS_UNKNOWN = null;
                public static final int NEST_IN_FILE_CLASS_UNKNOWN_VALUE = 0;
                public static final NestInFileClass NO = null;
                public static final int NO_VALUE = 1;
                private static final NestInFileClass[] VALUES = null;
                public static final NestInFileClass YES = null;
                public static final int YES_VALUE = 2;
                private static final Internal.EnumLiteMap<NestInFileClass> internalValueMap = null;
                private final int value;

                private static /* synthetic */ NestInFileClass[] $values() {
                    return new NestInFileClass[]{NEST_IN_FILE_CLASS_UNKNOWN, NO, YES, LEGACY};
                }

                static {
                    NEST_IN_FILE_CLASS_UNKNOWN = new NestInFileClass("NEST_IN_FILE_CLASS_UNKNOWN", 0, 0);
                    NO = new NestInFileClass("NO", 1, 1);
                    YES = new NestInFileClass("YES", 2, 2);
                    LEGACY = new NestInFileClass("LEGACY", 3, 3);
                    $VALUES = $values();
                    RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", NestInFileClass.class.getName());
                    internalValueMap = new AnonymousClass1();
                    VALUES = values();
                }

                private NestInFileClass(String r1, int r2, int r3) {
                    super(r1, r2);
                    this.value = r3;
                }

                public static NestInFileClass forNumber(int r1) {
                    if (r1 == 0) goto L18;
                    if (r1 == 1) goto L16;
                    if (r1 == 2) goto L14;
                    if (r1 == 3) goto L12;
                    return null;
                L12:
                    return LEGACY;
                L14:
                    return YES;
                L16:
                    return NO;
                L18:
                    return NEST_IN_FILE_CLASS_UNKNOWN;
                }

                public static Descriptors.EnumDescriptor getDescriptor() {
                    return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(NestInFileClassFeature.getDescriptor().getEnumTypes().get(0), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
                }

                public static Internal.EnumLiteMap<NestInFileClass> internalGetValueMap() {
                    return internalValueMap;
                }

                @Deprecated
                public static NestInFileClass valueOf(int r0) {
                    return forNumber(r0);
                }

                public static NestInFileClass valueOf(Descriptors.EnumValueDescriptor r2) {
                    if (r2.getType() != getDescriptor()) goto L7;
                    return VALUES[r2.getIndex()];
                L7:
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }

                public static NestInFileClass valueOf(String r2) {
                    return (NestInFileClass) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(NestInFileClass.class, r2), NestInFileClass.class, "com.obric.memorydata.plugin");
                }

                public static NestInFileClass[] values() {
                    return (NestInFileClass[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NestInFileClass[].class, "com.obric.memorydata.plugin");
                }

                @Override // com.google.protobuf.ProtocolMessageEnum
                public final Descriptors.EnumDescriptor getDescriptorForType() {
                    return getDescriptor();
                }

                @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Override // com.google.protobuf.ProtocolMessageEnum
                public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                    return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin");
                }
            }

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", NestInFileClassFeature.class.getName());
                DEFAULT_INSTANCE = new NestInFileClassFeature();
                PARSER = new AnonymousClass1();
            }

            private NestInFileClassFeature() {
                this.memoizedIsInitialized = -1;
            }

            private NestInFileClassFeature(GeneratedMessage.Builder<?> r1) {
                super(r1);
                this.memoizedIsInitialized = -1;
            }

            /* synthetic */ NestInFileClassFeature(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
                this(r1);
            }

            public static NestInFileClassFeature getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return JavaFeaturesProto.access$200();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(NestInFileClassFeature r1) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
            }

            public static NestInFileClassFeature parseDelimitedFrom(InputStream r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(ByteString r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(ByteString r1, ExtensionRegistryLite r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(CodedInputStream r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(InputStream r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(InputStream r1, ExtensionRegistryLite r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(ByteBuffer r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(byte[] r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static NestInFileClassFeature parseFrom(byte[] r1, ExtensionRegistryLite r2) {
                return (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), NestInFileClassFeature.class, "com.obric.memorydata.plugin");
            }

            public static Parser<NestInFileClassFeature> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object r4) {
                if (r4 != this) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r4, NestInFileClassFeature.class) == false) goto L8;
                NestInFileClassFeature r5 = (NestInFileClassFeature) ZeusTransformUtils.preCheckCast(r4, NestInFileClassFeature.class, "com.obric.memorydata.plugin");
                if (getUnknownFields().equals(r5.getUnknownFields()) == true) goto L13;
                return false;
            L13:
                return true;
            L8:
                return super.equals(r4);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NestInFileClassFeature getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<NestInFileClassFeature> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int r0 = this.memoizedSize;
                if (r0 == (-1)) goto L5;
                return r0;
            L5:
                int r1 = getUnknownFields().getSerializedSize() + 0;
                this.memoizedSize = r1;
                return r1;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) goto L5;
                int r0 = ((779 + getDescriptor().hashCode()) * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = r0;
                return r0;
            L5:
                return this.memoizedHashCode;
            }

            @Override // com.google.protobuf.GeneratedMessage
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return JavaFeaturesProto.access$300().ensureFieldAccessorsInitialized(NestInFileClassFeature.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r0 = this.memoizedIsInitialized;
                if (r0 != 1) goto L5;
                return true;
            L5:
                if (r0 != 0) goto L8;
                return false;
            L8:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // com.google.protobuf.AbstractMessage
            public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
                return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"), null);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // com.google.protobuf.AbstractMessage
            public /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
                return newBuilderForType((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                AnonymousClass1 r1 = null;
                if (this != DEFAULT_INSTANCE) goto L6;
                return new Builder(r1);
            L6:
                return new Builder(r1).mergeFrom(this);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
                return toBuilder();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream r1) {
                getUnknownFields().writeTo(r1);
            }
        }

        public interface NestInFileClassFeatureOrBuilder extends MessageOrBuilder {
        }

        public static final enum Utf8Validation extends java.lang.Enum<Utf8Validation> implements ProtocolMessageEnum {
            private static final /* synthetic */ Utf8Validation[] $VALUES = null;
            public static final Utf8Validation DEFAULT = null;
            public static final int DEFAULT_VALUE = 1;
            public static final Utf8Validation UTF8_VALIDATION_UNKNOWN = null;
            public static final int UTF8_VALIDATION_UNKNOWN_VALUE = 0;
            private static final Utf8Validation[] VALUES = null;
            public static final Utf8Validation VERIFY = null;
            public static final int VERIFY_VALUE = 2;
            private static final Internal.EnumLiteMap<Utf8Validation> internalValueMap = null;
            private final int value;

            private static /* synthetic */ Utf8Validation[] $values() {
                return new Utf8Validation[]{UTF8_VALIDATION_UNKNOWN, DEFAULT, VERIFY};
            }

            static {
                UTF8_VALIDATION_UNKNOWN = new Utf8Validation("UTF8_VALIDATION_UNKNOWN", 0, 0);
                DEFAULT = new Utf8Validation("DEFAULT", 1, 1);
                VERIFY = new Utf8Validation("VERIFY", 2, 2);
                $VALUES = $values();
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Utf8Validation.class.getName());
                internalValueMap = new AnonymousClass1();
                VALUES = values();
            }

            private Utf8Validation(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }

            public static Utf8Validation forNumber(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return VERIFY;
            L12:
                return DEFAULT;
            L14:
                return UTF8_VALIDATION_UNKNOWN;
            }

            public static Descriptors.EnumDescriptor getDescriptor() {
                return (Descriptors.EnumDescriptor) ZeusTransformUtils.preCheckCast(JavaFeatures.getDescriptor().getEnumTypes().get(0), Descriptors.EnumDescriptor.class, "com.obric.memorydata.plugin");
            }

            public static Internal.EnumLiteMap<Utf8Validation> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Utf8Validation valueOf(int r0) {
                return forNumber(r0);
            }

            public static Utf8Validation valueOf(Descriptors.EnumValueDescriptor r2) {
                if (r2.getType() != getDescriptor()) goto L7;
                return VALUES[r2.getIndex()];
            L7:
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            public static Utf8Validation valueOf(String r2) {
                return (Utf8Validation) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(Utf8Validation.class, r2), Utf8Validation.class, "com.obric.memorydata.plugin");
            }

            public static Utf8Validation[] values() {
                return (Utf8Validation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Utf8Validation[].class, "com.obric.memorydata.plugin");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return (Descriptors.EnumValueDescriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getValues().get(ordinal()), Descriptors.EnumValueDescriptor.class, "com.obric.memorydata.plugin");
            }
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", JavaFeatures.class.getName());
            DEFAULT_INSTANCE = new JavaFeatures();
            PARSER = new AnonymousClass1();
        }

        private JavaFeatures() {
            this.legacyClosedEnum_ = false;
            this.utf8Validation_ = 0;
            this.largeEnum_ = false;
            this.useOldOuterClassnameDefault_ = false;
            this.nestInFileClass_ = 0;
            this.memoizedIsInitialized = -1;
            this.utf8Validation_ = 0;
            this.nestInFileClass_ = 0;
        }

        private JavaFeatures(GeneratedMessage.Builder<?> r1) {
            super(r1);
            this.legacyClosedEnum_ = false;
            this.utf8Validation_ = 0;
            this.largeEnum_ = false;
            this.useOldOuterClassnameDefault_ = false;
            this.nestInFileClass_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* synthetic */ JavaFeatures(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ boolean access$1002(JavaFeatures r0, boolean r1) {
            r0.legacyClosedEnum_ = r1;
            return r1;
        }

        static /* synthetic */ int access$1102(JavaFeatures r0, int r1) {
            r0.utf8Validation_ = r1;
            return r1;
        }

        static /* synthetic */ boolean access$1202(JavaFeatures r0, boolean r1) {
            r0.largeEnum_ = r1;
            return r1;
        }

        static /* synthetic */ boolean access$1302(JavaFeatures r0, boolean r1) {
            r0.useOldOuterClassnameDefault_ = r1;
            return r1;
        }

        static /* synthetic */ int access$1402(JavaFeatures r0, int r1) {
            r0.nestInFileClass_ = r1;
            return r1;
        }

        static /* synthetic */ int access$1576(JavaFeatures r1, int r2) {
            int r3 = r2 | r1.bitField0_;
            r1.bitField0_ = r3;
            return r3;
        }

        public static JavaFeatures getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return JavaFeaturesProto.access$000();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(JavaFeatures r1) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(ByteString r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(ByteString r1, ExtensionRegistryLite r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(CodedInputStream r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(InputStream r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(InputStream r1, ExtensionRegistryLite r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(ByteBuffer r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(byte[] r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static JavaFeatures parseFrom(byte[] r1, ExtensionRegistryLite r2) {
            return (JavaFeatures) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), JavaFeatures.class, "com.obric.memorydata.plugin");
        }

        public static Parser<JavaFeatures> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, JavaFeatures.class) == false) goto L8;
            JavaFeatures r6 = (JavaFeatures) ZeusTransformUtils.preCheckCast(r5, JavaFeatures.class, "com.obric.memorydata.plugin");
            if (hasLegacyClosedEnum() == r6.hasLegacyClosedEnum()) goto L13;
            return false;
        L13:
            if (hasLegacyClosedEnum() == false) goto L18;
            if (getLegacyClosedEnum() == r6.getLegacyClosedEnum()) goto L18;
            return false;
        L18:
            if (hasUtf8Validation() == r6.hasUtf8Validation()) goto L21;
            return false;
        L21:
            if (hasUtf8Validation() == false) goto L26;
            if (this.utf8Validation_ == r6.utf8Validation_) goto L26;
            return false;
        L26:
            if (hasLargeEnum() == r6.hasLargeEnum()) goto L29;
            return false;
        L29:
            if (hasLargeEnum() == false) goto L34;
            if (getLargeEnum() == r6.getLargeEnum()) goto L34;
            return false;
        L34:
            if (hasUseOldOuterClassnameDefault() == r6.hasUseOldOuterClassnameDefault()) goto L37;
            return false;
        L37:
            if (hasUseOldOuterClassnameDefault() == false) goto L42;
            if (getUseOldOuterClassnameDefault() == r6.getUseOldOuterClassnameDefault()) goto L42;
            return false;
        L42:
            if (hasNestInFileClass() == r6.hasNestInFileClass()) goto L45;
            return false;
        L45:
            if (hasNestInFileClass() == false) goto L50;
            if (this.nestInFileClass_ == r6.nestInFileClass_) goto L50;
            return false;
        L50:
            if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L52;
            return false;
        L52:
            return true;
        L8:
            return super.equals(r5);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public JavaFeatures getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getLargeEnum() {
            return this.largeEnum_;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getLegacyClosedEnum() {
            return this.legacyClosedEnum_;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public NestInFileClassFeature.NestInFileClass getNestInFileClass() {
            NestInFileClassFeature.NestInFileClass r0 = NestInFileClassFeature.NestInFileClass.forNumber(this.nestInFileClass_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return NestInFileClassFeature.NestInFileClass.NEST_IN_FILE_CLASS_UNKNOWN;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<JavaFeatures> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            if ((this.bitField0_ & 1) == 0) goto L9;
            r1 = 0 + CodedOutputStream.computeBoolSize(1, this.legacyClosedEnum_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r1 = r1 + CodedOutputStream.computeEnumSize(2, this.utf8Validation_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r1 = r1 + CodedOutputStream.computeBoolSize(3, this.largeEnum_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r1 = r1 + CodedOutputStream.computeBoolSize(4, this.useOldOuterClassnameDefault_);
        L18:
            if ((this.bitField0_ & 16) == 0) goto L20;
            r1 = r1 + CodedOutputStream.computeEnumSize(5, this.nestInFileClass_);
        L20:
            int r2 = r1 + getUnknownFields().getSerializedSize();
            this.memoizedSize = r2;
            return r2;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getUseOldOuterClassnameDefault() {
            return this.useOldOuterClassnameDefault_;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public Utf8Validation getUtf8Validation() {
            Utf8Validation r0 = Utf8Validation.forNumber(this.utf8Validation_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Utf8Validation.UTF8_VALIDATION_UNKNOWN;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasLargeEnum() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasLegacyClosedEnum() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasNestInFileClass() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasUseOldOuterClassnameDefault() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasUtf8Validation() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) goto L5;
            int r0 = 779 + getDescriptor().hashCode();
            if (hasLegacyClosedEnum() == false) goto L10;
            r0 = (((r0 * 37) + 1) * 53) + Internal.hashBoolean(getLegacyClosedEnum());
        L10:
            if (hasUtf8Validation() == false) goto L13;
            r0 = (((r0 * 37) + 2) * 53) + this.utf8Validation_;
        L13:
            if (hasLargeEnum() == false) goto L16;
            r0 = (((r0 * 37) + 3) * 53) + Internal.hashBoolean(getLargeEnum());
        L16:
            if (hasUseOldOuterClassnameDefault() == false) goto L19;
            r0 = (((r0 * 37) + 4) * 53) + Internal.hashBoolean(getUseOldOuterClassnameDefault());
        L19:
            if (hasNestInFileClass() == false) goto L21;
            r0 = (((r0 * 37) + 5) * 53) + this.nestInFileClass_;
        L21:
            int r1 = (r0 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = r1;
            return r1;
        L5:
            return this.memoizedHashCode;
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return JavaFeaturesProto.access$100().ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
            return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"), null);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.AbstractMessage
        public /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
            return newBuilderForType((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r4) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r4.writeBool(1, this.legacyClosedEnum_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r4.writeEnum(2, this.utf8Validation_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r4.writeBool(3, this.largeEnum_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L15;
            r4.writeBool(4, this.useOldOuterClassnameDefault_);
        L15:
            if ((this.bitField0_ & 16) == 0) goto L17;
            r4.writeEnum(5, this.nestInFileClass_);
        L17:
            getUnknownFields().writeTo(r4);
        }
    }

    public interface JavaFeaturesOrBuilder extends MessageOrBuilder {
        boolean getLargeEnum();

        boolean getLegacyClosedEnum();

        JavaFeatures.NestInFileClassFeature.NestInFileClass getNestInFileClass();

        boolean getUseOldOuterClassnameDefault();

        JavaFeatures.Utf8Validation getUtf8Validation();

        boolean hasLargeEnum();

        boolean hasLegacyClosedEnum();

        boolean hasNestInFileClass();

        boolean hasUseOldOuterClassnameDefault();

        boolean hasUtf8Validation();
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", JavaFeaturesProto.class.getName());
        GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> r0 = GeneratedMessage.newFileScopedGeneratedExtension(JavaFeatures.class, JavaFeatures.getDefaultInstance());
        java_ = r0;
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#google/protobuf/java_features.proto\u0012\u0002pb\u001a google/protobuf/descriptor.proto\"Ù\b\n\fJavaFeatures\u0012\u0090\u0002\n\u0012legacy_closed_enum\u0018\u0001 \u0001(\bBá\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\t\u0012\u0004true\u0018\u0084\u0007¢\u0001\n\u0012\u0005false\u0018ç\u0007²\u0001»\u0001\bè\u0007\u0010è\u0007\u001a²\u0001The legacy closed enum behavior in Java is deprecated and is scheduled to be removed in edition 2025.  See http://protobuf.dev/programming-guides/enum/#java for more information.R\u0010legacyClosedEnum\u0012¯\u0002\n\u000futf8_validation\u0018\u0002 \u0001(\u000e2\u001f.pb.JavaFeatures.Utf8ValidationBä\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\f\u0012\u0007DEFAULT\u0018\u0084\u0007²\u0001È\u0001\bè\u0007\u0010é\u0007\u001a¿\u0001The Java-specific utf8 validation feature is deprecated and is scheduled to be removed in edition 2025.  Utf8 validation behavior should use the global cross-language utf8_validation feature.R\u000eutf8Validation\u0012;\n\nlarge_enum\u0018\u0003 \u0001(\bB\u001c\u0088\u0001\u0001\u0098\u0001\u0006\u0098\u0001\u0001¢\u0001\n\u0012\u0005false\u0018\u0084\u0007²\u0001\u0003\bé\u0007R\tlargeEnum\u0012n\n\u001fuse_old_outer_classname_default\u0018\u0004 \u0001(\bB(\u0088\u0001\u0001\u0098\u0001\u0001¢\u0001\t\u0012\u0004true\u0018\u0084\u0007¢\u0001\n\u0012\u0005false\u0018é\u0007²\u0001\u0006\bé\u0007 é\u0007R\u001buseOldOuterClassnameDefault\u0012\u0090\u0001\n\u0012nest_in_file_class\u0018\u0005 \u0001(\u000e27.pb.JavaFeatures.NestInFileClassFeature.NestInFileClassB*\u0088\u0001\u0002\u0098\u0001\u0003\u0098\u0001\u0006\u0098\u0001\b¢\u0001\u000b\u0012\u0006LEGACY\u0018\u0084\u0007¢\u0001\u0007\u0012\u0002NO\u0018é\u0007²\u0001\u0003\bé\u0007R\u000fnestInFileClass\u001a|\n\u0016NestInFileClassFeature\"X\n\u000fNestInFileClass\u0012\u001e\n\u001aNEST_IN_FILE_CLASS_UNKNOWN\u0010\u0000\u0012\u0006\n\u0002NO\u0010\u0001\u0012\u0007\n\u0003YES\u0010\u0002\u0012\u0014\n\u0006LEGACY\u0010\u0003\u001a\b\"\u0006\bé\u0007 é\u0007J\b\b\u0001\u0010\u0080\u0080\u0080\u0080\u0002\"F\n\u000eUtf8Validation\u0012\u001b\n\u0017UTF8_VALIDATION_UNKNOWN\u0010\u0000\u0012\u000b\n\u0007DEFAULT\u0010\u0001\u0012\n\n\u0006VERIFY\u0010\u0002:B\n\u0004java\u0012\u001b.google.protobuf.FeatureSet\u0018é\u0007 \u0001(\u000b2\u0010.pb.JavaFeaturesR\u0004javaB(\n\u0013com.google.protobufB\u0011JavaFeaturesProto"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor r1 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(getDescriptor().getMessageTypes().get(0), Descriptors.Descriptor.class, "com.obric.memorydata.plugin");
        internal_static_pb_JavaFeatures_descriptor = r1;
        internal_static_pb_JavaFeatures_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r1, new String[]{"LegacyClosedEnum", "Utf8Validation", "LargeEnum", "UseOldOuterClassnameDefault", "NestInFileClass"});
        Descriptors.Descriptor r2 = (Descriptors.Descriptor) ZeusTransformUtils.preCheckCast(r1.getNestedTypes().get(0), Descriptors.Descriptor.class, "com.obric.memorydata.plugin");
        internal_static_pb_JavaFeatures_NestInFileClassFeature_descriptor = r2;
        internal_static_pb_JavaFeatures_NestInFileClassFeature_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r2, new String[0]);
        r0.internalInit((Descriptors.FieldDescriptor) ZeusTransformUtils.preCheckCast(descriptor.getExtensions().get(0), Descriptors.FieldDescriptor.class, "com.obric.memorydata.plugin"));
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    private JavaFeaturesProto() {
    }

    static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_pb_JavaFeatures_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$100() {
        return internal_static_pb_JavaFeatures_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors.Descriptor access$200() {
        return internal_static_pb_JavaFeatures_NestInFileClassFeature_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$300() {
        return internal_static_pb_JavaFeatures_NestInFileClassFeature_fieldAccessorTable;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r0) {
        registerAllExtensions(r0);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r1) {
        r1.add(java_);
    }
}
