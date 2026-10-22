package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmProtoBuf {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmMethodSignature> constructorSignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, Integer> flags = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmMethodSignature> methodSignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmPropertySignature> propertySignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class JvmFieldSignature extends GeneratedMessageLite implements JvmFieldSignatureOrBuilder {
        public static Parser<JvmFieldSignature> PARSER;
        private static final JvmFieldSignature defaultInstance = null;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements JvmFieldSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$2500() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public JvmFieldSignature buildPartial() {
                JvmFieldSignature r5 = new JvmFieldSignature(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                JvmFieldSignature.access$2702(r5, this.name_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                JvmFieldSignature.access$2802(r5, this.desc_);
                JvmFieldSignature.access$2902(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setDesc(int r5) {
                this.bitField0_ |= 2;
                this.desc_ = r5;
                return this;
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 1;
                this.name_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmFieldSignature build() {
                JvmFieldSignature r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((JvmFieldSignature) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmFieldSignature r5) {
                if (r5 != JvmFieldSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasName() == false) goto L9;
                setName(r5.getName());
            L9:
                if (r5.hasDesc() == false) goto L11;
                setDesc(r5.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmFieldSignature.access$3000(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                JvmFieldSignature r11 = null;
                JvmFieldSignature r12 = JvmFieldSignature.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmFieldSignature r13 = (JvmFieldSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            JvmFieldSignature r5 = new JvmFieldSignature(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ JvmFieldSignature(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$2702(JvmFieldSignature r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2802(JvmFieldSignature r5, int r10) {
            r5.desc_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2902(JvmFieldSignature r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$3000(JvmFieldSignature r5) {
            return r5.unknownFields;
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$2500();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = CodedOutputStream.computeInt32Size(1, this.name_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r10 = r10 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L12:
            int r11 = this.unknownFields.size() + r10;
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r10 = 0;
            goto L10
        }

        public boolean hasDesc() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L5;
            return true;
        L5:
            if (r5 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r5.writeInt32(2, this.desc_);
        L8:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ JvmFieldSignature(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(JvmFieldSignature r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private JvmFieldSignature(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private JvmFieldSignature(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmFieldSignature(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
        L3:
            if (r13 == true) goto L43;
            int r14 = r10.readTag();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            if (r14 == 0) goto L12;
            if (r14 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.name_ = r10.readInt32();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L9:
            if (r14 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.desc_ = r10.readInt32();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L11:
            if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
        L12:
            r13 = true;
            goto L3
        L13:
            th = move-exception;
            r12.flush();     // Catch: IOException -> L40 Throwable -> L28
        L28:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L27:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L17:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L15:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L43:
            r12.flush();     // Catch: IOException -> L41 Throwable -> L35
        L35:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L34:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface JvmFieldSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements JvmMethodSignatureOrBuilder {
        public static Parser<JvmMethodSignature> PARSER;
        private static final JvmMethodSignature defaultInstance = null;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements JvmMethodSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$1800() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public JvmMethodSignature buildPartial() {
                JvmMethodSignature r5 = new JvmMethodSignature(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                JvmMethodSignature.access$2002(r5, this.name_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                JvmMethodSignature.access$2102(r5, this.desc_);
                JvmMethodSignature.access$2202(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setDesc(int r5) {
                this.bitField0_ |= 2;
                this.desc_ = r5;
                return this;
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 1;
                this.name_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmMethodSignature build() {
                JvmMethodSignature r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((JvmMethodSignature) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmMethodSignature r5) {
                if (r5 != JvmMethodSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasName() == false) goto L9;
                setName(r5.getName());
            L9:
                if (r5.hasDesc() == false) goto L11;
                setDesc(r5.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmMethodSignature.access$2300(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                JvmMethodSignature r11 = null;
                JvmMethodSignature r12 = JvmMethodSignature.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmMethodSignature r13 = (JvmMethodSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            JvmMethodSignature r5 = new JvmMethodSignature(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ JvmMethodSignature(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$2002(JvmMethodSignature r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2102(JvmMethodSignature r5, int r10) {
            r5.desc_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2202(JvmMethodSignature r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$2300(JvmMethodSignature r5) {
            return r5.unknownFields;
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$1800();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = CodedOutputStream.computeInt32Size(1, this.name_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r10 = r10 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L12:
            int r11 = this.unknownFields.size() + r10;
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r10 = 0;
            goto L10
        }

        public boolean hasDesc() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L5;
            return true;
        L5:
            if (r5 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r5.writeInt32(2, this.desc_);
        L8:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ JvmMethodSignature(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(JvmMethodSignature r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private JvmMethodSignature(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private JvmMethodSignature(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmMethodSignature(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
        L3:
            if (r13 == true) goto L43;
            int r14 = r10.readTag();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            if (r14 == 0) goto L12;
            if (r14 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.name_ = r10.readInt32();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L9:
            if (r14 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.desc_ = r10.readInt32();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L11:
            if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
        L12:
            r13 = true;
            goto L3
        L13:
            th = move-exception;
            r12.flush();     // Catch: IOException -> L40 Throwable -> L28
        L28:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L27:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L17:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L15:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L43:
            r12.flush();     // Catch: IOException -> L41 Throwable -> L35
        L35:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L34:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface JvmMethodSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements JvmPropertySignatureOrBuilder {
        public static Parser<JvmPropertySignature> PARSER;
        private static final JvmPropertySignature defaultInstance = null;
        private int bitField0_;
        private JvmMethodSignature delegateMethod_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements JvmPropertySignatureOrBuilder {
            private int bitField0_;
            private JvmMethodSignature delegateMethod_;
            private JvmFieldSignature field_;
            private JvmMethodSignature getter_;
            private JvmMethodSignature setter_;
            private JvmMethodSignature syntheticMethod_;

            private Builder() {
                this.field_ = JvmFieldSignature.getDefaultInstance();
                this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
                this.getter_ = JvmMethodSignature.getDefaultInstance();
                this.setter_ = JvmMethodSignature.getDefaultInstance();
                this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$3200() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public JvmPropertySignature buildPartial() {
                JvmPropertySignature r5 = new JvmPropertySignature(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                JvmPropertySignature.access$3402(r5, this.field_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                JvmPropertySignature.access$3502(r5, this.syntheticMethod_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                JvmPropertySignature.access$3602(r5, this.getter_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 8;
            L15:
                JvmPropertySignature.access$3702(r5, this.setter_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 16;
            L18:
                JvmPropertySignature.access$3802(r5, this.delegateMethod_);
                JvmPropertySignature.access$3902(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeDelegateMethod(JvmMethodSignature r5) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.delegateMethod_ = r5;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.delegateMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.delegateMethod_ = JvmMethodSignature.newBuilder(this.delegateMethod_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeField(JvmFieldSignature r5) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.field_ = r5;
            L8:
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.field_ == JvmFieldSignature.getDefaultInstance()) goto L7;
                this.field_ = JvmFieldSignature.newBuilder(this.field_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeGetter(JvmMethodSignature r5) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.getter_ = r5;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.getter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.getter_ = JvmMethodSignature.newBuilder(this.getter_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeSetter(JvmMethodSignature r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.setter_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.setter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.setter_ = JvmMethodSignature.newBuilder(this.setter_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature r5) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.syntheticMethod_ = r5;
            L8:
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.syntheticMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.syntheticMethod_ = JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmPropertySignature build() {
                JvmPropertySignature r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((JvmPropertySignature) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(JvmPropertySignature r5) {
                if (r5 != JvmPropertySignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasField() == false) goto L9;
                mergeField(r5.getField());
            L9:
                if (r5.hasSyntheticMethod() == false) goto L12;
                mergeSyntheticMethod(r5.getSyntheticMethod());
            L12:
                if (r5.hasGetter() == false) goto L15;
                mergeGetter(r5.getGetter());
            L15:
                if (r5.hasSetter() == false) goto L18;
                mergeSetter(r5.getSetter());
            L18:
                if (r5.hasDelegateMethod() == false) goto L20;
                mergeDelegateMethod(r5.getDelegateMethod());
            L20:
                setUnknownFields(getUnknownFields().concat(JvmPropertySignature.access$4000(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                JvmPropertySignature r11 = null;
                JvmPropertySignature r12 = JvmPropertySignature.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmPropertySignature r13 = (JvmPropertySignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            JvmPropertySignature r5 = new JvmPropertySignature(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ JvmPropertySignature(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ JvmFieldSignature access$3402(JvmPropertySignature r5, JvmFieldSignature r10) {
            r5.field_ = r10;
            return r10;
        }

        public static /* synthetic */ JvmMethodSignature access$3502(JvmPropertySignature r5, JvmMethodSignature r10) {
            r5.syntheticMethod_ = r10;
            return r10;
        }

        public static /* synthetic */ JvmMethodSignature access$3602(JvmPropertySignature r5, JvmMethodSignature r10) {
            r5.getter_ = r10;
            return r10;
        }

        public static /* synthetic */ JvmMethodSignature access$3702(JvmPropertySignature r5, JvmMethodSignature r10) {
            r5.setter_ = r10;
            return r10;
        }

        public static /* synthetic */ JvmMethodSignature access$3802(JvmPropertySignature r5, JvmMethodSignature r10) {
            r5.delegateMethod_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$3902(JvmPropertySignature r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$4000(JvmPropertySignature r5) {
            return r5.unknownFields;
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
            this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$3200();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public JvmMethodSignature getDelegateMethod() {
            return this.delegateMethod_;
        }

        public JvmFieldSignature getField() {
            return this.field_;
        }

        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = CodedOutputStream.computeMessageSize(1, this.field_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r10 = r10 + CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r10 = r10 + CodedOutputStream.computeMessageSize(3, this.getter_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r10 = r10 + CodedOutputStream.computeMessageSize(4, this.setter_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r10 = r10 + CodedOutputStream.computeMessageSize(5, this.delegateMethod_);
        L21:
            int r11 = this.unknownFields.size() + r10;
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r10 = 0;
            goto L10
        }

        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasDelegateMethod() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasField() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasGetter() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSetter() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSyntheticMethod() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L5;
            return true;
        L5:
            if (r5 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeMessage(1, this.field_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeMessage(2, this.syntheticMethod_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r5.writeMessage(3, this.getter_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r5.writeMessage(4, this.setter_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r5.writeMessage(5, this.delegateMethod_);
        L17:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ JvmPropertySignature(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(JvmPropertySignature r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private JvmPropertySignature(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private JvmPropertySignature(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmPropertySignature(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
        L3:
            if (r13 == true) goto L82;
            int r14 = r10.readTag();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            if (r14 == 0) goto L18;
            JvmMethodSignature.Builder r15 = null;
            JvmFieldSignature.Builder r16 = null;
            JvmMethodSignature.Builder r17 = null;
            JvmMethodSignature.Builder r18 = null;
            JvmMethodSignature.Builder r19 = null;
            if (r14 != 10) goto L9;
            if ((this.bitField0_ & 1) != 1) goto L56;
            r16 = this.field_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L56:
            JvmFieldSignature r20 = (JvmFieldSignature) r10.readMessage(JvmFieldSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.field_ = r20;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            if (r16 == null) goto L59;
            r16.mergeFrom(r20);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.field_ = r16.buildPartial();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L59:
            this.bitField0_ |= 1;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            goto L3
        L9:
            if (r14 != 18) goto L11;
            if ((this.bitField0_ & 2) != 2) goto L49;
            r17 = this.syntheticMethod_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L49:
            JvmMethodSignature r21 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.syntheticMethod_ = r21;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            if (r17 == null) goto L52;
            r17.mergeFrom(r21);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.syntheticMethod_ = r17.buildPartial();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L52:
            this.bitField0_ |= 2;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            goto L3
        L11:
            if (r14 != 26) goto L13;
            if ((this.bitField0_ & 4) != 4) goto L42;
            r18 = this.getter_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L42:
            JvmMethodSignature r22 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.getter_ = r22;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            if (r18 == null) goto L45;
            r18.mergeFrom(r22);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.getter_ = r18.buildPartial();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L45:
            this.bitField0_ |= 4;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            goto L3
        L13:
            if (r14 != 34) goto L15;
            if ((this.bitField0_ & 8) != 8) goto L35;
            r19 = this.setter_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L35:
            JvmMethodSignature r23 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.setter_ = r23;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            if (r19 == null) goto L38;
            r19.mergeFrom(r23);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.setter_ = r19.buildPartial();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L38:
            this.bitField0_ |= 8;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            goto L3
        L15:
            if (r14 != 42) goto L17;
            if ((this.bitField0_ & 16) != 16) goto L28;
            r15 = this.delegateMethod_.toBuilder();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L28:
            JvmMethodSignature r24 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.delegateMethod_ = r24;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            if (r15 == null) goto L31;
            r15.mergeFrom(r24);     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            this.delegateMethod_ = r15.buildPartial();     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
        L31:
            this.bitField0_ |= 16;     // Catch: Throwable -> L19 IOException -> L21 InvalidProtocolBufferException -> L23
            goto L3
        L17:
            if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
        L18:
            r13 = true;
            goto L3
        L19:
            th = move-exception;
            r12.flush();     // Catch: IOException -> L79 Throwable -> L67
        L67:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L66:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L23:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L19
        L21:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L19
        L82:
            r12.flush();     // Catch: IOException -> L80 Throwable -> L74
        L74:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L73:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface JvmPropertySignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements StringTableTypesOrBuilder {
        public static Parser<StringTableTypes> PARSER;
        private static final StringTableTypes defaultInstance = null;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTableTypes, Builder> implements StringTableTypesOrBuilder {
            private int bitField0_;
            private List<Integer> localName_;
            private List<Record> record_;

            private Builder() {
                this.record_ = Collections.emptyList();
                this.localName_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$1200() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureLocalNameIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.localName_ = new ArrayList(this.localName_);
                this.bitField0_ |= 2;
                return;
            }

            private void ensureRecordIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.record_ = new ArrayList(this.record_);
                this.bitField0_ |= 1;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public StringTableTypes buildPartial() {
                StringTableTypes r5 = new StringTableTypes(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.record_ = Collections.unmodifiableList(this.record_);
                this.bitField0_ &= -2;
            L5:
                StringTableTypes.access$1402(r5, this.record_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.localName_ = Collections.unmodifiableList(this.localName_);
                this.bitField0_ &= -3;
            L8:
                StringTableTypes.access$1502(r5, this.localName_);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTableTypes build() {
                StringTableTypes r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((StringTableTypes) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(StringTableTypes r5) {
                if (r5 != StringTableTypes.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTableTypes.access$1400(r5).isEmpty() == true) goto L12;
                if (this.record_.isEmpty() == false) goto L10;
                this.record_ = StringTableTypes.access$1400(r5);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureRecordIsMutable();
                this.record_.addAll(StringTableTypes.access$1400(r5));
            L12:
                if (StringTableTypes.access$1500(r5).isEmpty() == false) goto L14;
            L17:
                setUnknownFields(getUnknownFields().concat(StringTableTypes.access$1600(r5)));
                return this;
            L14:
                if (this.localName_.isEmpty() == false) goto L16;
                this.localName_ = StringTableTypes.access$1500(r5);
                this.bitField0_ &= -3;
                goto L17
            L16:
                ensureLocalNameIsMutable();
                this.localName_.addAll(StringTableTypes.access$1500(r5));
                goto L17
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                StringTableTypes r11 = null;
                StringTableTypes r12 = StringTableTypes.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTableTypes r13 = (StringTableTypes) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        public static final class Record extends GeneratedMessageLite implements RecordOrBuilder {
            public static Parser<Record> PARSER;
            private static final Record defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<Record, Builder> implements RecordOrBuilder {
                private int bitField0_;
                private Operation operation_;
                private int predefinedIndex_;
                private int range_;
                private List<Integer> replaceChar_;
                private Object string_;
                private List<Integer> substringIndex_;

                private Builder() {
                    this.range_ = 1;
                    this.string_ = "";
                    this.operation_ = Operation.NONE;
                    this.substringIndex_ = Collections.emptyList();
                    this.replaceChar_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$200() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void ensureReplaceCharIsMutable() {
                    if ((this.bitField0_ & 32) == 32) goto L6;
                    this.replaceChar_ = new ArrayList(this.replaceChar_);
                    this.bitField0_ |= 32;
                    return;
                }

                private void ensureSubstringIndexIsMutable() {
                    if ((this.bitField0_ & 16) == 16) goto L6;
                    this.substringIndex_ = new ArrayList(this.substringIndex_);
                    this.bitField0_ |= 16;
                    return;
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public Record buildPartial() {
                    Record r5 = new Record(this, null);
                    int r10 = this.bitField0_;
                    int r11 = 1;
                    if ((r10 & 1) == 1) goto L6;
                    r11 = 0;
                L6:
                    Record.access$402(r5, this.range_);
                    if ((r10 & 2) != 2) goto L9;
                    r11 = r11 | 2;
                L9:
                    Record.access$502(r5, this.predefinedIndex_);
                    if ((r10 & 4) != 4) goto L12;
                    r11 = r11 | 4;
                L12:
                    Record.access$602(r5, this.string_);
                    if ((r10 & 8) != 8) goto L15;
                    r11 = r11 | 8;
                L15:
                    Record.access$702(r5, this.operation_);
                    if ((this.bitField0_ & 16) != 16) goto L18;
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                    this.bitField0_ &= -17;
                L18:
                    Record.access$802(r5, this.substringIndex_);
                    if ((this.bitField0_ & 32) != 32) goto L21;
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                    this.bitField0_ &= -33;
                L21:
                    Record.access$902(r5, this.replaceChar_);
                    Record.access$1002(r5, r11);
                    return r5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                public Builder setOperation(Operation r5) {
                    r5.getClass();
                    this.bitField0_ |= 8;
                    this.operation_ = r5;
                    return this;
                }

                public Builder setPredefinedIndex(int r5) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = r5;
                    return this;
                }

                public Builder setRange(int r5) {
                    this.bitField0_ |= 1;
                    this.range_ = r5;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Record build() {
                    Record r5 = buildPartial();
                    if (r5.isInitialized() == false) goto L6;
                    return r5;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                    return mergeFrom((Record) r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Record r5) {
                    if (r5 != Record.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r5.hasRange() == false) goto L9;
                    setRange(r5.getRange());
                L9:
                    if (r5.hasPredefinedIndex() == false) goto L12;
                    setPredefinedIndex(r5.getPredefinedIndex());
                L12:
                    if (r5.hasString() == false) goto L15;
                    this.bitField0_ |= 4;
                    this.string_ = Record.access$600(r5);
                L15:
                    if (r5.hasOperation() == false) goto L18;
                    setOperation(r5.getOperation());
                L18:
                    if (Record.access$800(r5).isEmpty() == true) goto L24;
                    if (this.substringIndex_.isEmpty() == false) goto L22;
                    this.substringIndex_ = Record.access$800(r5);
                    this.bitField0_ &= -17;
                    goto L24
                L22:
                    ensureSubstringIndexIsMutable();
                    this.substringIndex_.addAll(Record.access$800(r5));
                L24:
                    if (Record.access$900(r5).isEmpty() == false) goto L26;
                L29:
                    setUnknownFields(getUnknownFields().concat(Record.access$1100(r5)));
                    return this;
                L26:
                    if (this.replaceChar_.isEmpty() == false) goto L28;
                    this.replaceChar_ = Record.access$900(r5);
                    this.bitField0_ &= -33;
                    goto L29
                L28:
                    ensureReplaceCharIsMutable();
                    this.replaceChar_.addAll(Record.access$900(r5));
                    goto L29
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    Record r11 = null;
                    Record r12 = Record.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r12 == null) goto L6;
                    mergeFrom(r12);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Record r13 = (Record) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r11 = r13;
                L14:
                    if (r11 == null) goto L16;
                    mergeFrom(r11);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }
            }

            public static final enum Operation extends Enum<Operation> implements Internal.EnumLite {
                private static final /* synthetic */ Operation[] $VALUES = null;
                public static final Operation DESC_TO_CLASS_ID = null;
                public static final Operation INTERNAL_TO_CLASS_ID = null;
                public static final Operation NONE = null;
                private static Internal.EnumLiteMap<Operation> internalValueMap;
                private final int value;

                static {
                    Operation r5 = new Operation("NONE", 0, 0, 0);
                    NONE = r5;
                    Operation r10 = new Operation("INTERNAL_TO_CLASS_ID", 1, 1, 1);
                    INTERNAL_TO_CLASS_ID = r10;
                    Operation r11 = new Operation("DESC_TO_CLASS_ID", 2, 2, 2);
                    DESC_TO_CLASS_ID = r11;
                    $VALUES = new Operation[]{r5, r10, r11};
                    internalValueMap = new AnonymousClass1();
                }

                private Operation(String r5, int r10, int r11, int r12) {
                    super(r5, r10);
                    this.value = r12;
                }

                public static Operation valueOf(String r5) {
                    return (Operation) Enum.valueOf(Operation.class, r5);
                }

                public static Operation[] values() {
                    return (Operation[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int r5) {
                    if (r5 == 0) goto L14;
                    if (r5 == 1) goto L12;
                    if (r5 == 2) goto L10;
                    return null;
                L10:
                    return DESC_TO_CLASS_ID;
                L12:
                    return INTERNAL_TO_CLASS_ID;
                L14:
                    return NONE;
                }
            }

            static {
                PARSER = new AnonymousClass1();
                Record r5 = new Record(true);
                defaultInstance = r5;
                r5.initFields();
            }

            public /* synthetic */ Record(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
                this(r5, r10);
            }

            public static /* synthetic */ int access$1002(Record r5, int r10) {
                r5.bitField0_ = r10;
                return r10;
            }

            public static /* synthetic */ ByteString access$1100(Record r5) {
                return r5.unknownFields;
            }

            public static /* synthetic */ int access$402(Record r5, int r10) {
                r5.range_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$502(Record r5, int r10) {
                r5.predefinedIndex_ = r10;
                return r10;
            }

            public static /* synthetic */ Object access$600(Record r5) {
                return r5.string_;
            }

            public static /* synthetic */ Object access$602(Record r5, Object r10) {
                r5.string_ = r10;
                return r10;
            }

            public static /* synthetic */ Operation access$702(Record r5, Operation r10) {
                r5.operation_ = r10;
                return r10;
            }

            public static /* synthetic */ List access$800(Record r5) {
                return r5.substringIndex_;
            }

            public static /* synthetic */ List access$802(Record r5, List r10) {
                r5.substringIndex_ = r10;
                return r10;
            }

            public static /* synthetic */ List access$900(Record r5) {
                return r5.replaceChar_;
            }

            public static /* synthetic */ List access$902(Record r5, List r10) {
                r5.replaceChar_ = r10;
                return r10;
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            public static Builder newBuilder() {
                return Builder.access$200();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Operation getOperation() {
                return this.operation_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Record> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r5 = this.memoizedSerializedSize;
                if (r5 == (-1)) goto L5;
                return r5;
            L5:
                int r10 = 0;
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r11 = CodedOutputStream.computeInt32Size(1, this.range_);
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r11 = r11 + CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
            L13:
                if ((this.bitField0_ & 8) != 8) goto L15;
                r11 = r11 + CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
            L15:
                int r12 = 0;
                int r13 = 0;
            L17:
                if (r12 >= this.substringIndex_.size()) goto L19;
                r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(r12).intValue());
                r12 = r12 + 1;
                goto L17
            L19:
                int r14 = r11 + r13;
                if (getSubstringIndexList().isEmpty() == true) goto L22;
                r14 = (r14 + 1) + CodedOutputStream.computeInt32SizeNoTag(r13);
            L22:
                this.substringIndexMemoizedSerializedSize = r13;
                int r15 = 0;
            L24:
                if (r10 >= this.replaceChar_.size()) goto L26;
                r15 = r15 + CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(r10).intValue());
                r10 = r10 + 1;
                goto L24
            L26:
                int r16 = r14 + r15;
                if (getReplaceCharList().isEmpty() == true) goto L29;
                r16 = (r16 + 1) + CodedOutputStream.computeInt32SizeNoTag(r15);
            L29:
                this.replaceCharMemoizedSerializedSize = r15;
                if ((this.bitField0_ & 4) != 4) goto L32;
                r16 = r16 + CodedOutputStream.computeBytesSize(6, getStringBytes());
            L32:
                int r17 = this.unknownFields.size() + r16;
                this.memoizedSerializedSize = r17;
                return r17;
            L8:
                r11 = 0;
                goto L10
            }

            public String getString() {
                Object r5 = this.string_;
                if ((r5 instanceof String) == true) goto L5;
                ByteString r10 = (ByteString) r5;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L9;
                this.string_ = r11;
            L9:
                return r11;
            L5:
                return (String) r5;
            }

            public ByteString getStringBytes() {
                Object r5 = this.string_;
                if ((r5 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r5);
                this.string_ = r10;
                return r10;
            L7:
                return (ByteString) r5;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasPredefinedIndex() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasRange() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public boolean hasString() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r5 = this.memoizedIsInitialized;
                if (r5 != 1) goto L5;
                return true;
            L5:
                if (r5 != 0) goto L8;
                return false;
            L8:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r5) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r5.writeInt32(1, this.range_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r5.writeInt32(2, this.predefinedIndex_);
            L9:
                if ((this.bitField0_ & 8) != 8) goto L12;
                r5.writeEnum(3, this.operation_.getNumber());
            L12:
                if (getSubstringIndexList().size() <= 0) goto L14;
                r5.writeRawVarint32(34);
                r5.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
            L14:
                int r10 = 0;
                int r11 = 0;
            L16:
                if (r11 >= this.substringIndex_.size()) goto L19;
                r5.writeInt32NoTag(this.substringIndex_.get(r11).intValue());
                r11 = r11 + 1;
                goto L16
            L19:
                if (getReplaceCharList().size() <= 0) goto L22;
                r5.writeRawVarint32(42);
                r5.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
            L22:
                if (r10 >= this.replaceChar_.size()) goto L25;
                r5.writeInt32NoTag(this.replaceChar_.get(r10).intValue());
                r10 = r10 + 1;
                goto L22
            L25:
                if ((this.bitField0_ & 4) != 4) goto L27;
                r5.writeBytes(6, getStringBytes());
            L27:
                r5.writeRawBytes(this.unknownFields);
            }

            public /* synthetic */ Record(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
                this(r5);
            }

            public static Builder newBuilder(Record r5) {
                return newBuilder().mergeFrom(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Record getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            private Record(GeneratedMessageLite.Builder r5) {
                super(r5);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r5.getUnknownFields();
            }

            private Record(boolean r5) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Record(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r5 = ByteString.newOutput();
                CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
                boolean r11 = false;
                int r14 = 0;
            L4:
                if (r11 == true) goto L82;
                int r15 = r12.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                if (r15 == 0) goto L23;
                if (r15 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                this.range_ = r12.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L9:
                if (r15 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                this.predefinedIndex_ = r12.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L11:
                if (r15 != 24) goto L12;
                int r16 = r12.readEnum();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                Operation r17 = Operation.valueOf(r16);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                if (r17 == null) goto L59;
                this.bitField0_ |= 8;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                this.operation_ = r17;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L59:
                r10.writeRawVarint32(r15);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                r10.writeRawVarint32(r16);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L12:
                if (r15 != 32) goto L14;
                if ((r14 & 16) == 16) goto L56;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                r14 = r14 | 16;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            L56:
                this.substringIndex_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L14:
                if (r15 != 34) goto L16;
                int r18 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                if ((r14 & 16) == 16) goto L50;
                if (r12.getBytesUntilLimit() <= 0) goto L50;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                r14 = r14 | 16;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            L50:
                if (r12.getBytesUntilLimit() <= 0) goto L52;
                this.substringIndex_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L50
            L52:
                r12.popLimit(r18);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L16:
                if (r15 != 40) goto L18;
                if ((r14 & 32) == 32) goto L43;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                r14 = r14 | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            L43:
                this.replaceChar_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L18:
                if (r15 != 42) goto L20;
                int r19 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                if ((r14 & 32) == 32) goto L37;
                if (r12.getBytesUntilLimit() <= 0) goto L37;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                r14 = r14 | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            L37:
                if (r12.getBytesUntilLimit() <= 0) goto L39;
                this.replaceChar_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L37
            L39:
                r12.popLimit(r19);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L20:
                if (r15 != 50) goto L22;
                ByteString r20 = r12.readBytes();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                this.bitField0_ |= 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                this.string_ = r20;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
                goto L4
            L22:
                if (parseUnknownField(r12, r10, r13, r15) == true) goto L4;
            L23:
                r11 = true;
                goto L4
            L24:
                th = move-exception;
                if ((r14 & 16) != 16) goto L72;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L72:
                if ((r14 & 32) != 32) goto L97;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L97:
                r10.flush();     // Catch: IOException -> L95 Throwable -> L76
            L76:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L75:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
                throw th;
            L28:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
            L26:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
            L82:
                if ((r14 & 16) != 16) goto L85;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L85:
                if ((r14 & 32) != 32) goto L99;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L99:
                r10.flush();     // Catch: IOException -> L94 Throwable -> L89
            L89:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L88:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
            }
        }

        public interface RecordOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            PARSER = new AnonymousClass1();
            StringTableTypes r5 = new StringTableTypes(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ StringTableTypes(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$1400(StringTableTypes r5) {
            return r5.record_;
        }

        public static /* synthetic */ List access$1402(StringTableTypes r5, List r10) {
            r5.record_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$1500(StringTableTypes r5) {
            return r5.localName_;
        }

        public static /* synthetic */ List access$1502(StringTableTypes r5, List r10) {
            r5.localName_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$1600(StringTableTypes r5) {
            return r5.unknownFields;
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$1200();
        }

        public static StringTableTypes parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseDelimitedFrom(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.record_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.record_.size()) goto L9;
            r12 = r12 + CodedOutputStream.computeMessageSize(1, this.record_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = 0;
        L11:
            if (r10 >= this.localName_.size()) goto L13;
            r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(r10).intValue());
            r10 = r10 + 1;
            goto L11
        L13:
            int r14 = r12 + r13;
            if (getLocalNameList().isEmpty() == true) goto L16;
            r14 = (r14 + 1) + CodedOutputStream.computeInt32SizeNoTag(r13);
        L16:
            this.localNameMemoizedSerializedSize = r13;
            int r15 = this.unknownFields.size() + r14;
            this.memoizedSerializedSize = r15;
            return r15;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L5;
            return true;
        L5:
            if (r5 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            int r10 = 0;
            int r11 = 0;
        L4:
            if (r11 >= this.record_.size()) goto L7;
            r5.writeMessage(1, this.record_.get(r11));
            r11 = r11 + 1;
            goto L4
        L7:
            if (getLocalNameList().size() <= 0) goto L10;
            r5.writeRawVarint32(42);
            r5.writeRawVarint32(this.localNameMemoizedSerializedSize);
        L10:
            if (r10 >= this.localName_.size()) goto L12;
            r5.writeInt32NoTag(this.localName_.get(r10).intValue());
            r10 = r10 + 1;
            goto L10
        L12:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ StringTableTypes(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(StringTableTypes r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private StringTableTypes(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private StringTableTypes(boolean r5) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private StringTableTypes(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            int r14 = 0;
        L4:
            if (r13 == true) goto L58;
            int r15 = r10.readTag();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            if (r15 == 0) goto L15;
            if (r15 != 10) goto L10;
            if ((r14 & 1) == 1) goto L38;
            this.record_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            r14 = r14 | 1;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        L38:
            this.record_.add((Record) r10.readMessage(Record.PARSER, r11));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L10:
            if (r15 != 40) goto L12;
            if ((r14 & 2) == 2) goto L34;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            r14 = r14 | 2;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        L34:
            this.localName_.add(Integer.valueOf(r10.readInt32()));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L12:
            if (r15 != 42) goto L14;
            int r16 = r10.pushLimit(r10.readRawVarint32());     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            if ((r14 & 2) == 2) goto L28;
            if (r10.getBytesUntilLimit() <= 0) goto L28;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            r14 = r14 | 2;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        L28:
            if (r10.getBytesUntilLimit() <= 0) goto L30;
            this.localName_.add(Integer.valueOf(r10.readInt32()));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            goto L28
        L30:
            r10.popLimit(r16);     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
            goto L4
        L14:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L4;
        L15:
            r13 = true;
            goto L4
        L16:
            th = move-exception;
            if ((r14 & 1) != 1) goto L48;
            this.record_ = Collections.unmodifiableList(this.record_);
        L48:
            if ((r14 & 2) != 2) goto L74;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L74:
            r12.flush();     // Catch: IOException -> L71 Throwable -> L52
        L52:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L51:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L20:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L16
        L18:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L16
        L58:
            if ((r14 & 1) != 1) goto L61;
            this.record_ = Collections.unmodifiableList(this.record_);
        L61:
            if ((r14 & 2) != 2) goto L76;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L76:
            r12.flush();     // Catch: IOException -> L70 Throwable -> L65
        L65:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L64:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        ProtoBuf.Constructor r5 = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature r10 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature r11 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType r12 = WireFormat.FieldType.MESSAGE;
        constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(r5, r10, r11, null, 100, r12, JvmMethodSignature.class);
        methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, r12, JvmMethodSignature.class);
        ProtoBuf.Function r13 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType r14 = WireFormat.FieldType.INT32;
        lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(r13, 0, null, null, 101, r14, Integer.class);
        propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, r12, JvmPropertySignature.class);
        flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, r14, Integer.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, r12, false, ProtoBuf.Annotation.class);
        isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, r12, false, ProtoBuf.Annotation.class);
        classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, r14, Integer.class);
        classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, r12, false, ProtoBuf.Property.class);
        anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, r14, Integer.class);
        jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, r14, Integer.class);
        packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, r14, Integer.class);
        packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, r12, false, ProtoBuf.Property.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r5) {
        r5.add(constructorSignature);
        r5.add(methodSignature);
        r5.add(lambdaClassOriginName);
        r5.add(propertySignature);
        r5.add(flags);
        r5.add(typeAnnotation);
        r5.add(isRaw);
        r5.add(typeParameterAnnotation);
        r5.add(classModuleName);
        r5.add(classLocalVariable);
        r5.add(anonymousObjectOriginName);
        r5.add(jvmClassFlags);
        r5.add(packageModuleName);
        r5.add(packageLocalVariable);
    }
}
