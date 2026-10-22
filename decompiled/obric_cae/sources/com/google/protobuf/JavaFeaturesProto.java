package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class JavaFeaturesProto extends GeneratedFile {
    public static final int JAVA_FIELD_NUMBER = 1001;
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_pb_JavaFeatures_NestInFileClassFeature_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_pb_JavaFeatures_NestInFileClassFeature_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_pb_JavaFeatures_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_pb_JavaFeatures_fieldAccessorTable = null;
    public static final GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> java_ = null;

    /* JADX INFO: renamed from: com.google.protobuf.JavaFeaturesProto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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

            private void buildPartial0(JavaFeatures r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                JavaFeatures.access$1002(r8, this.legacyClosedEnum_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                JavaFeatures.access$1102(r8, this.utf8Validation_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                JavaFeatures.access$1202(r8, this.largeEnum_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L16;
                JavaFeatures.access$1302(r8, this.useOldOuterClassnameDefault_);
                r11 = r11 | 8;
            L16:
                if ((r10 & 16) == 0) goto L18;
                JavaFeatures.access$1402(r8, this.nestInFileClass_);
                r11 = r11 | 16;
            L18:
                JavaFeatures.access$1576(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return JavaFeaturesProto.access$000();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures build() {
                JavaFeatures r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JavaFeatures buildPartial() {
                JavaFeatures r8 = new JavaFeatures(this, null);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r8);
            L5:
                onBuilt();
                return r8;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public JavaFeatures getDefaultInstanceForType() {
                return JavaFeatures.getDefaultInstance();
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
                NestInFileClassFeature.NestInFileClass r8 = NestInFileClassFeature.NestInFileClass.forNumber(this.nestInFileClass_);
                if (r8 == null) goto L5;
                return r8;
            L5:
                return NestInFileClassFeature.NestInFileClass.NEST_IN_FILE_CLASS_UNKNOWN;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getUseOldOuterClassnameDefault() {
                return this.useOldOuterClassnameDefault_;
            }

            @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public Utf8Validation getUtf8Validation() {
                Utf8Validation r8 = Utf8Validation.forNumber(this.utf8Validation_);
                if (r8 == null) goto L5;
                return r8;
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
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public Builder setLargeEnum(boolean r8) {
                this.largeEnum_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setLegacyClosedEnum(boolean r8) {
                this.legacyClosedEnum_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setNestInFileClass(NestInFileClassFeature.NestInFileClass r8) {
                if (r8 == null) goto L6;
                this.bitField0_ |= 16;
                this.nestInFileClass_ = r8.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setUseOldOuterClassnameDefault(boolean r8) {
                this.useOldOuterClassnameDefault_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setUtf8Validation(Utf8Validation r8) {
                if (r8 == null) goto L6;
                this.bitField0_ |= 2;
                this.utf8Validation_ = r8.getNumber();
                onChanged();
                return this;
            L6:
                throw null;
            }

            private Builder(AbstractMessage.BuilderParent r8) {
                super(r8);
                this.utf8Validation_ = 0;
                this.nestInFileClass_ = 0;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
                this(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public /* synthetic */ Builder(AnonymousClass1 r8) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L44;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L41;
                int r12 = r8.readTag();     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                if (r12 == 0) goto L33;
                int r13 = 8;
                if (r12 != 8) goto L10;
                this.legacyClosedEnum_ = r8.readBool();     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                this.bitField0_ |= 1;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                goto L4
            L10:
                if (r12 != 16) goto L12;
                int r14 = r8.readEnum();     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                r13 = 2;
                if (Utf8Validation.forNumber(r14) != null) goto L30;
                mergeUnknownVarintField(2, r14);     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                goto L4
            L30:
                this.utf8Validation_ = r14;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                int r15 = this.bitField0_;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
            L25:
                this.bitField0_ = r15 | r13;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.largeEnum_ = r8.readBool();     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                this.bitField0_ |= 4;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                goto L4
            L14:
                if (r12 != 32) goto L16;
                this.useOldOuterClassnameDefault_ = r8.readBool();     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                r15 = this.bitField0_;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                goto L25
            L16:
                if (r12 != 40) goto L18;
                int r16 = r8.readEnum();     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                if (NestInFileClassFeature.NestInFileClass.forNumber(r16) == null) goto L22;
                this.nestInFileClass_ = r16;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                this.bitField0_ |= 16;     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                goto L4
            L22:
                mergeUnknownVarintField(5, r16);     // Catch: Throwable -> L34 InvalidProtocolBufferException -> L36
                goto L4
            L18:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L33:
                r11 = true;
                goto L4
            L34:
                th = move-exception;
                onChanged();
                throw th;
            L36:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L34
            L41:
                onChanged();
                return this;
            L44:
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            public Builder mergeFrom(JavaFeatures r8) {
                if (r8 != JavaFeatures.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasLegacyClosedEnum() == false) goto L9;
                setLegacyClosedEnum(r8.getLegacyClosedEnum());
            L9:
                if (r8.hasUtf8Validation() == false) goto L12;
                setUtf8Validation(r8.getUtf8Validation());
            L12:
                if (r8.hasLargeEnum() == false) goto L15;
                setLargeEnum(r8.getLargeEnum());
            L15:
                if (r8.hasUseOldOuterClassnameDefault() == false) goto L18;
                setUseOldOuterClassnameDefault(r8.getUseOldOuterClassnameDefault());
            L18:
                if (r8.hasNestInFileClass() == false) goto L20;
                setNestInFileClass(r8.getNestInFileClass());
            L20:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof JavaFeatures) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((JavaFeatures) r8);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
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

                private Builder(AbstractMessage.BuilderParent r8) {
                    super(r8);
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return JavaFeaturesProto.access$200();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NestInFileClassFeature build() {
                    NestInFileClassFeature r8 = buildPartial();
                    if (r8.isInitialized() == false) goto L6;
                    return r8;
                L6:
                    throw AbstractMessage.Builder.newUninitializedMessageException(r8);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NestInFileClassFeature buildPartial() {
                    NestInFileClassFeature r8 = new NestInFileClassFeature(this, null);
                    onBuilt();
                    return r8;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
                public NestInFileClassFeature getDefaultInstanceForType() {
                    return NestInFileClassFeature.getDefaultInstance();
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
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
                }

                public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
                    this(r8);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
                public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                    return mergeFrom(r8);
                }

                public /* synthetic */ Builder(AnonymousClass1 r8) {
                    this();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    return this;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    if (r10 == null) goto L20;
                    boolean r11 = false;
                L4:
                    if (r11 == true) goto L17;
                    int r12 = r8.readTag();     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L12
                    if (r12 == 0) goto L9;
                    if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
                L9:
                    r11 = true;
                L12:
                    e = move-exception;
                    throw e.unwrapIOException();     // Catch: Throwable -> L10
                L10:
                    th = move-exception;
                    onChanged();
                    throw th;
                L17:
                    onChanged();
                    return this;
                L20:
                    throw null;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return clear();
                }

                public Builder mergeFrom(NestInFileClassFeature r8) {
                    if (r8 != NestInFileClassFeature.getDefaultInstance()) goto L5;
                    return this;
                L5:
                    mergeUnknownFields(r8.getUnknownFields());
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message r8) {
                    if ((r8 instanceof NestInFileClassFeature) == true) goto L5;
                    super.mergeFrom(r8);
                    return this;
                L5:
                    return mergeFrom((NestInFileClassFeature) r8);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
                    return mergeFrom(r8);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
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
                    RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "NestInFileClass");
                    internalValueMap = new AnonymousClass1();
                    VALUES = values();
                }

                private NestInFileClass(String r8, int r10, int r11) {
                    super(r8, r10);
                    this.value = r11;
                }

                public static NestInFileClass forNumber(int r8) {
                    if (r8 == 0) goto L18;
                    if (r8 == 1) goto L16;
                    if (r8 == 2) goto L14;
                    if (r8 == 3) goto L12;
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
                    return NestInFileClassFeature.getDescriptor().getEnumTypes().get(0);
                }

                public static Internal.EnumLiteMap<NestInFileClass> internalGetValueMap() {
                    return internalValueMap;
                }

                @Deprecated
                public static NestInFileClass valueOf(int r8) {
                    return forNumber(r8);
                }

                public static NestInFileClass[] values() {
                    return (NestInFileClass[]) $VALUES.clone();
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
                    return getDescriptor().getValues().get(ordinal());
                }

                public static NestInFileClass valueOf(Descriptors.EnumValueDescriptor r8) {
                    if (r8.getType() != getDescriptor()) goto L7;
                    return VALUES[r8.getIndex()];
                L7:
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }

                public static NestInFileClass valueOf(String r8) {
                    return (NestInFileClass) java.lang.Enum.valueOf(NestInFileClass.class, r8);
                }
            }

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "NestInFileClassFeature");
                DEFAULT_INSTANCE = new NestInFileClassFeature();
                PARSER = new AnonymousClass1();
            }

            private NestInFileClassFeature() {
                this.memoizedIsInitialized = -1;
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

            public static NestInFileClassFeature parseDelimitedFrom(InputStream r8) {
                return (NestInFileClassFeature) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
            }

            public static NestInFileClassFeature parseFrom(ByteString r8) {
                return PARSER.parseFrom(r8);
            }

            public static Parser<NestInFileClassFeature> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object r8) {
                if (r8 != this) goto L6;
                return true;
            L6:
                if ((r8 instanceof NestInFileClassFeature) == true) goto L10;
                return super.equals(r8);
            L10:
                if (getUnknownFields().equals(((NestInFileClassFeature) r8).getUnknownFields()) == true) goto L13;
                return false;
            L13:
                return true;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public NestInFileClassFeature getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<NestInFileClassFeature> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int r8 = this.memoizedSize;
                if (r8 == (-1)) goto L5;
                return r8;
            L5:
                int r10 = getUnknownFields().getSerializedSize() + 0;
                this.memoizedSize = r10;
                return r10;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                int r8 = this.memoizedHashCode;
                if (r8 == 0) goto L5;
                return r8;
            L5:
                int r10 = (getDescriptor().hashCode() + 779) * 29;
                int r11 = getUnknownFields().hashCode() + r10;
                this.memoizedHashCode = r11;
                return r11;
            }

            @Override // com.google.protobuf.GeneratedMessage
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return JavaFeaturesProto.access$300().ensureFieldAccessorsInitialized(NestInFileClassFeature.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                AnonymousClass1 r8 = null;
                if (this != DEFAULT_INSTANCE) goto L6;
                return new Builder(r8);
            L6:
                return new Builder(r8).mergeFrom(this);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream r8) {
                getUnknownFields().writeTo(r8);
            }

            private NestInFileClassFeature(GeneratedMessage.Builder<?> r8) {
                super(r8);
                this.memoizedIsInitialized = -1;
            }

            public static Builder newBuilder(NestInFileClassFeature r8) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
            }

            public static NestInFileClassFeature parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
                return (NestInFileClassFeature) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
            }

            public static NestInFileClassFeature parseFrom(ByteString r8, ExtensionRegistryLite r10) {
                return PARSER.parseFrom(r8, r10);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.AbstractMessage
            public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
                return new Builder(r8, null);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
                return toBuilder();
            }

            public /* synthetic */ NestInFileClassFeature(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
                this(r8);
            }

            public static NestInFileClassFeature parseFrom(CodedInputStream r8) {
                return (NestInFileClassFeature) GeneratedMessage.parseWithIOException(PARSER, r8);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            public static NestInFileClassFeature parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return (NestInFileClassFeature) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
            }

            @Override // com.google.protobuf.AbstractMessage
            public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
                return newBuilderForType(r8);
            }

            public static NestInFileClassFeature parseFrom(InputStream r8) {
                return (NestInFileClassFeature) GeneratedMessage.parseWithIOException(PARSER, r8);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            public static NestInFileClassFeature parseFrom(InputStream r8, ExtensionRegistryLite r10) {
                return (NestInFileClassFeature) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
            }

            public static NestInFileClassFeature parseFrom(ByteBuffer r8) {
                return PARSER.parseFrom(r8);
            }

            public static NestInFileClassFeature parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
                return PARSER.parseFrom(r8, r10);
            }

            public static NestInFileClassFeature parseFrom(byte[] r8) {
                return PARSER.parseFrom(r8);
            }

            public static NestInFileClassFeature parseFrom(byte[] r8, ExtensionRegistryLite r10) {
                return PARSER.parseFrom(r8, r10);
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
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Utf8Validation");
                internalValueMap = new AnonymousClass1();
                VALUES = values();
            }

            private Utf8Validation(String r8, int r10, int r11) {
                super(r8, r10);
                this.value = r11;
            }

            public static Utf8Validation forNumber(int r8) {
                if (r8 == 0) goto L14;
                if (r8 == 1) goto L12;
                if (r8 == 2) goto L10;
                return null;
            L10:
                return VERIFY;
            L12:
                return DEFAULT;
            L14:
                return UTF8_VALIDATION_UNKNOWN;
            }

            public static Descriptors.EnumDescriptor getDescriptor() {
                return JavaFeatures.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<Utf8Validation> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Utf8Validation valueOf(int r8) {
                return forNumber(r8);
            }

            public static Utf8Validation[] values() {
                return (Utf8Validation[]) $VALUES.clone();
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
                return getDescriptor().getValues().get(ordinal());
            }

            public static Utf8Validation valueOf(Descriptors.EnumValueDescriptor r8) {
                if (r8.getType() != getDescriptor()) goto L7;
                return VALUES[r8.getIndex()];
            L7:
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            public static Utf8Validation valueOf(String r8) {
                return (Utf8Validation) java.lang.Enum.valueOf(Utf8Validation.class, r8);
            }
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "JavaFeatures");
            DEFAULT_INSTANCE = new JavaFeatures();
            PARSER = new AnonymousClass1();
        }

        private JavaFeatures() {
            this.legacyClosedEnum_ = false;
            this.largeEnum_ = false;
            this.useOldOuterClassnameDefault_ = false;
            this.memoizedIsInitialized = -1;
            this.utf8Validation_ = 0;
            this.nestInFileClass_ = 0;
        }

        public static /* synthetic */ boolean access$1002(JavaFeatures r8, boolean r10) {
            r8.legacyClosedEnum_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1102(JavaFeatures r8, int r10) {
            r8.utf8Validation_ = r10;
            return r10;
        }

        public static /* synthetic */ boolean access$1202(JavaFeatures r8, boolean r10) {
            r8.largeEnum_ = r10;
            return r10;
        }

        public static /* synthetic */ boolean access$1302(JavaFeatures r8, boolean r10) {
            r8.useOldOuterClassnameDefault_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1402(JavaFeatures r8, int r10) {
            r8.nestInFileClass_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1576(JavaFeatures r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
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

        public static JavaFeatures parseDelimitedFrom(InputStream r8) {
            return (JavaFeatures) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static JavaFeatures parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<JavaFeatures> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof JavaFeatures) == false) goto L8;
            JavaFeatures r10 = (JavaFeatures) r8;
            if (hasLegacyClosedEnum() == r10.hasLegacyClosedEnum()) goto L13;
            return false;
        L13:
            if (hasLegacyClosedEnum() == false) goto L18;
            if (getLegacyClosedEnum() == r10.getLegacyClosedEnum()) goto L18;
            return false;
        L18:
            if (hasUtf8Validation() == r10.hasUtf8Validation()) goto L21;
            return false;
        L21:
            if (hasUtf8Validation() == false) goto L26;
            if (this.utf8Validation_ == r10.utf8Validation_) goto L26;
            return false;
        L26:
            if (hasLargeEnum() == r10.hasLargeEnum()) goto L29;
            return false;
        L29:
            if (hasLargeEnum() == false) goto L34;
            if (getLargeEnum() == r10.getLargeEnum()) goto L34;
            return false;
        L34:
            if (hasUseOldOuterClassnameDefault() == r10.hasUseOldOuterClassnameDefault()) goto L37;
            return false;
        L37:
            if (hasUseOldOuterClassnameDefault() == false) goto L42;
            if (getUseOldOuterClassnameDefault() == r10.getUseOldOuterClassnameDefault()) goto L42;
            return false;
        L42:
            if (hasNestInFileClass() == r10.hasNestInFileClass()) goto L45;
            return false;
        L45:
            if (hasNestInFileClass() == false) goto L50;
            if (this.nestInFileClass_ == r10.nestInFileClass_) goto L50;
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
        public JavaFeatures getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
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
            NestInFileClassFeature.NestInFileClass r8 = NestInFileClassFeature.NestInFileClass.forNumber(this.nestInFileClass_);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return NestInFileClassFeature.NestInFileClass.NEST_IN_FILE_CLASS_UNKNOWN;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<JavaFeatures> getParserForType() {
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
            r10 = 0 + CodedOutputStream.computeBoolSize(1, this.legacyClosedEnum_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeEnumSize(2, this.utf8Validation_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + CodedOutputStream.computeBoolSize(3, this.largeEnum_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L18;
            r10 = r10 + CodedOutputStream.computeBoolSize(4, this.useOldOuterClassnameDefault_);
        L18:
            if ((this.bitField0_ & 16) == 0) goto L20;
            r10 = r10 + CodedOutputStream.computeEnumSize(5, this.nestInFileClass_);
        L20:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getUseOldOuterClassnameDefault() {
            return this.useOldOuterClassnameDefault_;
        }

        @Override // com.google.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public Utf8Validation getUtf8Validation() {
            Utf8Validation r8 = Utf8Validation.forNumber(this.utf8Validation_);
            if (r8 == null) goto L5;
            return r8;
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
            int r8 = this.memoizedHashCode;
            if (r8 == 0) goto L5;
            return r8;
        L5:
            int r10 = getDescriptor().hashCode() + 779;
            if (hasLegacyClosedEnum() == false) goto L9;
            r10 = defpackage.b.a(r10, 37, 1, 53) + Internal.hashBoolean(getLegacyClosedEnum());
        L9:
            if (hasUtf8Validation() == false) goto L12;
            r10 = defpackage.b.a(r10, 37, 2, 53) + this.utf8Validation_;
        L12:
            if (hasLargeEnum() == false) goto L15;
            r10 = defpackage.b.a(r10, 37, 3, 53) + Internal.hashBoolean(getLargeEnum());
        L15:
            if (hasUseOldOuterClassnameDefault() == false) goto L18;
            r10 = defpackage.b.a(r10, 37, 4, 53) + Internal.hashBoolean(getUseOldOuterClassnameDefault());
        L18:
            if (hasNestInFileClass() == false) goto L20;
            r10 = defpackage.b.a(r10, 37, 5, 53) + this.nestInFileClass_;
        L20:
            int r11 = getUnknownFields().hashCode();
            int r12 = r11 + (r10 * 29);
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return JavaFeaturesProto.access$100().ensureFieldAccessorsInitialized(JavaFeatures.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r8 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r8);
        L6:
            return new Builder(r8).mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeBool(1, this.legacyClosedEnum_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeEnum(2, this.utf8Validation_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r8.writeBool(3, this.largeEnum_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L15;
            r8.writeBool(4, this.useOldOuterClassnameDefault_);
        L15:
            if ((this.bitField0_ & 16) == 0) goto L17;
            r8.writeEnum(5, this.nestInFileClass_);
        L17:
            getUnknownFields().writeTo(r8);
        }

        private JavaFeatures(GeneratedMessage.Builder<?> r8) {
            super(r8);
            this.legacyClosedEnum_ = false;
            this.utf8Validation_ = 0;
            this.largeEnum_ = false;
            this.useOldOuterClassnameDefault_ = false;
            this.nestInFileClass_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(JavaFeatures r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (JavaFeatures) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static JavaFeatures parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return new Builder(r8, null);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ JavaFeatures(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static JavaFeatures parseFrom(CodedInputStream r8) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public static JavaFeatures parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        public static JavaFeatures parseFrom(InputStream r8) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        public static JavaFeatures parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (JavaFeatures) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static JavaFeatures parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static JavaFeatures parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static JavaFeatures parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static JavaFeatures parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
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
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "JavaFeaturesProto");
        GeneratedMessage.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> r8 = GeneratedMessage.newFileScopedGeneratedExtension(JavaFeatures.class, JavaFeatures.getDefaultInstance());
        java_ = r8;
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#google/protobuf/java_features.proto\u0012\u0002pb\u001a google/protobuf/descriptor.proto\"ß\b\n\fJavaFeatures\u0012\u0090\u0002\n\u0012legacy_closed_enum\u0018\u0001 \u0001(\bBá\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\t\u0012\u0004true\u0018\u0084\u0007¢\u0001\n\u0012\u0005false\u0018ç\u0007²\u0001»\u0001\bè\u0007\u0010è\u0007\u001a²\u0001The legacy closed enum behavior in Java is deprecated and is scheduled to be removed in edition 2025.  See http://protobuf.dev/programming-guides/enum/#java for more information.R\u0010legacyClosedEnum\u0012¯\u0002\n\u000futf8_validation\u0018\u0002 \u0001(\u000e2\u001f.pb.JavaFeatures.Utf8ValidationBä\u0001\u0088\u0001\u0001\u0098\u0001\u0004\u0098\u0001\u0001¢\u0001\f\u0012\u0007DEFAULT\u0018\u0084\u0007²\u0001È\u0001\bè\u0007\u0010é\u0007\u001a¿\u0001The Java-specific utf8 validation feature is deprecated and is scheduled to be removed in edition 2025.  Utf8 validation behavior should use the global cross-language utf8_validation feature.R\u000eutf8Validation\u0012;\n\nlarge_enum\u0018\u0003 \u0001(\bB\u001c\u0088\u0001\u0001\u0098\u0001\u0006\u0098\u0001\u0001¢\u0001\n\u0012\u0005false\u0018\u0084\u0007²\u0001\u0003\bé\u0007R\tlargeEnum\u0012n\n\u001fuse_old_outer_classname_default\u0018\u0004 \u0001(\bB(\u0088\u0001\u0001\u0098\u0001\u0001¢\u0001\t\u0012\u0004true\u0018\u0084\u0007¢\u0001\n\u0012\u0005false\u0018é\u0007²\u0001\u0006\bé\u0007 é\u0007R\u001buseOldOuterClassnameDefault\u0012\u0090\u0001\n\u0012nest_in_file_class\u0018\u0005 \u0001(\u000e27.pb.JavaFeatures.NestInFileClassFeature.NestInFileClassB*\u0088\u0001\u0001\u0098\u0001\u0003\u0098\u0001\u0006\u0098\u0001\b¢\u0001\u000b\u0012\u0006LEGACY\u0018\u0084\u0007¢\u0001\u0007\u0012\u0002NO\u0018é\u0007²\u0001\u0003\bé\u0007R\u000fnestInFileClass\u001a|\n\u0016NestInFileClassFeature\"X\n\u000fNestInFileClass\u0012\u001e\n\u001aNEST_IN_FILE_CLASS_UNKNOWN\u0010\u0000\u0012\u0006\n\u0002NO\u0010\u0001\u0012\u0007\n\u0003YES\u0010\u0002\u0012\u0014\n\u0006LEGACY\u0010\u0003\u001a\b\"\u0006\bé\u0007 é\u0007J\b\b\u0001\u0010\u0080\u0080\u0080\u0080\u0002\"F\n\u000eUtf8Validation\u0012\u001b\n\u0017UTF8_VALIDATION_UNKNOWN\u0010\u0000\u0012\u000b\n\u0007DEFAULT\u0010\u0001\u0012\n\n\u0006VERIFY\u0010\u0002J\u0004\b\u0006\u0010\u0007:B\n\u0004java\u0012\u001b.google.protobuf.FeatureSet\u0018é\u0007 \u0001(\u000b2\u0010.pb.JavaFeaturesR\u0004javaB(\n\u0013com.google.protobufB\u0011JavaFeaturesProto"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor r10 = getDescriptor().getMessageType(0);
        internal_static_pb_JavaFeatures_descriptor = r10;
        internal_static_pb_JavaFeatures_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r10, new String[]{"LegacyClosedEnum", "Utf8Validation", "LargeEnum", "UseOldOuterClassnameDefault", "NestInFileClass"});
        Descriptors.Descriptor r11 = r10.getNestedType(0);
        internal_static_pb_JavaFeatures_NestInFileClassFeature_descriptor = r11;
        internal_static_pb_JavaFeatures_NestInFileClassFeature_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r11, new String[0]);
        r8.internalInit(descriptor.getExtension(0));
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    private JavaFeaturesProto() {
    }

    public static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_pb_JavaFeatures_descriptor;
    }

    public static /* synthetic */ GeneratedMessage.FieldAccessorTable access$100() {
        return internal_static_pb_JavaFeatures_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$200() {
        return internal_static_pb_JavaFeatures_NestInFileClassFeature_descriptor;
    }

    public static /* synthetic */ GeneratedMessage.FieldAccessorTable access$300() {
        return internal_static_pb_JavaFeatures_NestInFileClassFeature_fieldAccessorTable;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
        r8.add(java_);
    }
}
