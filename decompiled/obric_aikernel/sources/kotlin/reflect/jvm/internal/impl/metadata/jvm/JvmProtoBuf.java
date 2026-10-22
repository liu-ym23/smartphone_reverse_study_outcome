package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
    static /* synthetic */ class AnonymousClass1 {
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

            static /* synthetic */ Builder access$2500() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmFieldSignature build() {
                JvmFieldSignature r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public JvmFieldSignature buildPartial() {
                JvmFieldSignature r10 = new JvmFieldSignature(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                JvmFieldSignature.access$2702(r10, this.name_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                JvmFieldSignature.access$2802(r10, this.desc_);
                JvmFieldSignature.access$2902(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(JvmFieldSignature r10) {
                if (r10 != JvmFieldSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasName() == false) goto L9;
                setName(r10.getName());
            L9:
                if (r10.hasDesc() == false) goto L11;
                setDesc(r10.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmFieldSignature.access$3000(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                JvmFieldSignature r12 = null;
                JvmFieldSignature r13 = JvmFieldSignature.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmFieldSignature r14 = (JvmFieldSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((JvmFieldSignature) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setDesc(int r10) {
                this.bitField0_ |= 2;
                this.desc_ = r10;
                return this;
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 1;
                this.name_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            JvmFieldSignature r10 = new JvmFieldSignature(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private JvmFieldSignature(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
        L3:
            if (r14 == true) goto L43;
            int r15 = r10.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r15 == 0) goto L16;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.name_ = r10.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (r15 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.desc_ = r10.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L11:
            if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
        L16:
            r14 = true;
            goto L3
        L17:
            th = move-exception;
            r13.flush();     // Catch: IOException -> L39 Throwable -> L27
        L27:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L26:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L43:
            r13.flush();     // Catch: IOException -> L40 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L33:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ JvmFieldSignature(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private JvmFieldSignature(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ JvmFieldSignature(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private JvmFieldSignature(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$2702(JvmFieldSignature r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ int access$2802(JvmFieldSignature r10, int r11) {
            r10.desc_ = r11;
            return r11;
        }

        static /* synthetic */ int access$2902(JvmFieldSignature r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$3000(JvmFieldSignature r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(JvmFieldSignature r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r11 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L11;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L11:
            int r12 = r11 + this.unknownFields.size();
            this.memoizedSerializedSize = r12;
            return r12;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r10.writeInt32(2, this.desc_);
        L8:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$1800() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmMethodSignature build() {
                JvmMethodSignature r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public JvmMethodSignature buildPartial() {
                JvmMethodSignature r10 = new JvmMethodSignature(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                JvmMethodSignature.access$2002(r10, this.name_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                JvmMethodSignature.access$2102(r10, this.desc_);
                JvmMethodSignature.access$2202(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(JvmMethodSignature r10) {
                if (r10 != JvmMethodSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasName() == false) goto L9;
                setName(r10.getName());
            L9:
                if (r10.hasDesc() == false) goto L11;
                setDesc(r10.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmMethodSignature.access$2300(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                JvmMethodSignature r12 = null;
                JvmMethodSignature r13 = JvmMethodSignature.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmMethodSignature r14 = (JvmMethodSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((JvmMethodSignature) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setDesc(int r10) {
                this.bitField0_ |= 2;
                this.desc_ = r10;
                return this;
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 1;
                this.name_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            JvmMethodSignature r10 = new JvmMethodSignature(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private JvmMethodSignature(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
        L3:
            if (r14 == true) goto L43;
            int r15 = r10.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r15 == 0) goto L16;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.name_ = r10.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (r15 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.desc_ = r10.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L11:
            if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
        L16:
            r14 = true;
            goto L3
        L17:
            th = move-exception;
            r13.flush();     // Catch: IOException -> L39 Throwable -> L27
        L27:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L26:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L43:
            r13.flush();     // Catch: IOException -> L40 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L33:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ JvmMethodSignature(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private JvmMethodSignature(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ JvmMethodSignature(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private JvmMethodSignature(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$2002(JvmMethodSignature r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ int access$2102(JvmMethodSignature r10, int r11) {
            r10.desc_ = r11;
            return r11;
        }

        static /* synthetic */ int access$2202(JvmMethodSignature r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$2300(JvmMethodSignature r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(JvmMethodSignature r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r11 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L11;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L11:
            int r12 = r11 + this.unknownFields.size();
            this.memoizedSerializedSize = r12;
            return r12;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r10.writeInt32(2, this.desc_);
        L8:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$3200() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmPropertySignature build() {
                JvmPropertySignature r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public JvmPropertySignature buildPartial() {
                JvmPropertySignature r10 = new JvmPropertySignature(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                JvmPropertySignature.access$3402(r10, this.field_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                JvmPropertySignature.access$3502(r10, this.syntheticMethod_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                JvmPropertySignature.access$3602(r10, this.getter_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 8;
            L15:
                JvmPropertySignature.access$3702(r10, this.setter_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 16;
            L18:
                JvmPropertySignature.access$3802(r10, this.delegateMethod_);
                JvmPropertySignature.access$3902(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeDelegateMethod(JvmMethodSignature r10) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.delegateMethod_ = r10;
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.delegateMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                r10 = JvmMethodSignature.newBuilder(this.delegateMethod_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeField(JvmFieldSignature r10) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.field_ = r10;
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.field_ == JvmFieldSignature.getDefaultInstance()) goto L7;
                r10 = JvmFieldSignature.newBuilder(this.field_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeFrom(JvmPropertySignature r10) {
                if (r10 != JvmPropertySignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasField() == false) goto L9;
                mergeField(r10.getField());
            L9:
                if (r10.hasSyntheticMethod() == false) goto L12;
                mergeSyntheticMethod(r10.getSyntheticMethod());
            L12:
                if (r10.hasGetter() == false) goto L15;
                mergeGetter(r10.getGetter());
            L15:
                if (r10.hasSetter() == false) goto L18;
                mergeSetter(r10.getSetter());
            L18:
                if (r10.hasDelegateMethod() == false) goto L20;
                mergeDelegateMethod(r10.getDelegateMethod());
            L20:
                setUnknownFields(getUnknownFields().concat(JvmPropertySignature.access$4000(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                JvmPropertySignature r12 = null;
                JvmPropertySignature r13 = JvmPropertySignature.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmPropertySignature r14 = (JvmPropertySignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((JvmPropertySignature) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeGetter(JvmMethodSignature r10) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.getter_ = r10;
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.getter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                r10 = JvmMethodSignature.newBuilder(this.getter_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeSetter(JvmMethodSignature r10) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.setter_ = r10;
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.setter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                r10 = JvmMethodSignature.newBuilder(this.setter_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature r10) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.syntheticMethod_ = r10;
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.syntheticMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                r10 = JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(r10).buildPartial();
                goto L7
            }
        }

        static {
            PARSER = new AnonymousClass1();
            JvmPropertySignature r10 = new JvmPropertySignature(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private JvmPropertySignature(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
        L3:
            if (r14 == true) goto L83;
            int r15 = r10.readTag();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            if (r15 == 0) goto L56;
            JvmMethodSignature.Builder r16 = null;
            JvmFieldSignature.Builder r17 = null;
            JvmMethodSignature.Builder r18 = null;
            JvmMethodSignature.Builder r19 = null;
            JvmMethodSignature.Builder r20 = null;
            if (r15 != 10) goto L9;
            if ((this.bitField0_ & 1) != 1) goto L51;
            r17 = this.field_.toBuilder();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L51:
            JvmFieldSignature r21 = (JvmFieldSignature) r10.readMessage(JvmFieldSignature.PARSER, r11);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.field_ = r21;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            if (r17 == null) goto L54;
            r17.mergeFrom(r21);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.field_ = r17.buildPartial();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L54:
            this.bitField0_ |= 1;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            goto L3
        L9:
            if (r15 == 18) goto L41;
            if (r15 == 26) goto L34;
            if (r15 == 34) goto L27;
            if (r15 != 42) goto L17;
            int r22 = 16;
            if ((this.bitField0_ & 16) != 16) goto L22;
            r18 = this.delegateMethod_.toBuilder();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L22:
            JvmMethodSignature r23 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.delegateMethod_ = r23;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            if (r18 == null) goto L25;
            r18.mergeFrom(r23);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.delegateMethod_ = r18.buildPartial();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L25:
            int r24 = this.bitField0_;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L26:
            this.bitField0_ = r24 | r22;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            goto L3
        L17:
            if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
        L27:
            r22 = 8;
            if ((this.bitField0_ & 8) != 8) goto L30;
            r19 = this.setter_.toBuilder();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L30:
            JvmMethodSignature r25 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.setter_ = r25;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            if (r19 == null) goto L33;
            r19.mergeFrom(r25);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.setter_ = r19.buildPartial();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L33:
            r24 = this.bitField0_;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            goto L26
        L34:
            r22 = 4;
            if ((this.bitField0_ & 4) != 4) goto L37;
            r20 = this.getter_.toBuilder();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L37:
            JvmMethodSignature r26 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.getter_ = r26;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            if (r20 == null) goto L40;
            r20.mergeFrom(r26);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.getter_ = r20.buildPartial();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L40:
            r24 = this.bitField0_;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            goto L26
        L41:
            r22 = 2;
            if ((this.bitField0_ & 2) != 2) goto L44;
            r16 = this.syntheticMethod_.toBuilder();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L44:
            JvmMethodSignature r27 = (JvmMethodSignature) r10.readMessage(JvmMethodSignature.PARSER, r11);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.syntheticMethod_ = r27;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            if (r16 == null) goto L47;
            r16.mergeFrom(r27);     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
            this.syntheticMethod_ = r16.buildPartial();     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L47:
            r24 = this.bitField0_;     // Catch: Throwable -> L57 IOException -> L59 InvalidProtocolBufferException -> L62
        L56:
            r14 = true;
            goto L3
        L57:
            th = move-exception;
            r13.flush();     // Catch: IOException -> L79 Throwable -> L67
        L67:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L66:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L59:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L57
        L62:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L57
        L83:
            r13.flush();     // Catch: IOException -> L80 Throwable -> L74
        L74:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L73:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ JvmPropertySignature(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private JvmPropertySignature(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ JvmPropertySignature(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private JvmPropertySignature(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ JvmFieldSignature access$3402(JvmPropertySignature r10, JvmFieldSignature r11) {
            r10.field_ = r11;
            return r11;
        }

        static /* synthetic */ JvmMethodSignature access$3502(JvmPropertySignature r10, JvmMethodSignature r11) {
            r10.syntheticMethod_ = r11;
            return r11;
        }

        static /* synthetic */ JvmMethodSignature access$3602(JvmPropertySignature r10, JvmMethodSignature r11) {
            r10.getter_ = r11;
            return r11;
        }

        static /* synthetic */ JvmMethodSignature access$3702(JvmPropertySignature r10, JvmMethodSignature r11) {
            r10.setter_ = r11;
            return r11;
        }

        static /* synthetic */ JvmMethodSignature access$3802(JvmPropertySignature r10, JvmMethodSignature r11) {
            r10.delegateMethod_ = r11;
            return r11;
        }

        static /* synthetic */ int access$3902(JvmPropertySignature r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$4000(JvmPropertySignature r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(JvmPropertySignature r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r11 = 0 + CodedOutputStream.computeMessageSize(1, this.field_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r11 = r11 + CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r11 = r11 + CodedOutputStream.computeMessageSize(3, this.getter_);
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r11 = r11 + CodedOutputStream.computeMessageSize(4, this.setter_);
        L18:
            if ((this.bitField0_ & 16) != 16) goto L20;
            r11 = r11 + CodedOutputStream.computeMessageSize(5, this.delegateMethod_);
        L20:
            int r12 = r11 + this.unknownFields.size();
            this.memoizedSerializedSize = r12;
            return r12;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeMessage(1, this.field_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r10.writeMessage(2, this.syntheticMethod_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r10.writeMessage(3, this.getter_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r10.writeMessage(4, this.setter_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r10.writeMessage(5, this.delegateMethod_);
        L17:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$1200() {
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
            public StringTableTypes build() {
                StringTableTypes r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public StringTableTypes buildPartial() {
                StringTableTypes r10 = new StringTableTypes(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.record_ = Collections.unmodifiableList(this.record_);
                this.bitField0_ &= -2;
            L5:
                StringTableTypes.access$1402(r10, this.record_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.localName_ = Collections.unmodifiableList(this.localName_);
                this.bitField0_ &= -3;
            L8:
                StringTableTypes.access$1502(r10, this.localName_);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(StringTableTypes r10) {
                if (r10 != StringTableTypes.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTableTypes.access$1400(r10).isEmpty() == true) goto L12;
                if (this.record_.isEmpty() == false) goto L10;
                this.record_ = StringTableTypes.access$1400(r10);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureRecordIsMutable();
                this.record_.addAll(StringTableTypes.access$1400(r10));
            L12:
                if (StringTableTypes.access$1500(r10).isEmpty() == false) goto L14;
            L17:
                setUnknownFields(getUnknownFields().concat(StringTableTypes.access$1600(r10)));
                return this;
            L14:
                if (this.localName_.isEmpty() == false) goto L16;
                this.localName_ = StringTableTypes.access$1500(r10);
                this.bitField0_ &= -3;
                goto L17
            L16:
                ensureLocalNameIsMutable();
                this.localName_.addAll(StringTableTypes.access$1500(r10));
                goto L17
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                StringTableTypes r12 = null;
                StringTableTypes r13 = StringTableTypes.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTableTypes r14 = (StringTableTypes) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((StringTableTypes) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
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

                static /* synthetic */ Builder access$200() {
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
                public Record build() {
                    Record r10 = buildPartial();
                    if (r10.isInitialized() == false) goto L6;
                    return r10;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public Record buildPartial() {
                    Record r10 = new Record(this, null);
                    int r11 = this.bitField0_;
                    int r12 = 1;
                    if ((r11 & 1) == 1) goto L6;
                    r12 = 0;
                L6:
                    Record.access$402(r10, this.range_);
                    if ((r11 & 2) != 2) goto L9;
                    r12 = r12 | 2;
                L9:
                    Record.access$502(r10, this.predefinedIndex_);
                    if ((r11 & 4) != 4) goto L12;
                    r12 = r12 | 4;
                L12:
                    Record.access$602(r10, this.string_);
                    if ((r11 & 8) != 8) goto L15;
                    r12 = r12 | 8;
                L15:
                    Record.access$702(r10, this.operation_);
                    if ((this.bitField0_ & 16) != 16) goto L18;
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                    this.bitField0_ &= -17;
                L18:
                    Record.access$802(r10, this.substringIndex_);
                    if ((this.bitField0_ & 32) != 32) goto L21;
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                    this.bitField0_ &= -33;
                L21:
                    Record.access$902(r10, this.replaceChar_);
                    Record.access$1002(r10, r12);
                    return r10;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder mergeFrom(Record r10) {
                    if (r10 != Record.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r10.hasRange() == false) goto L9;
                    setRange(r10.getRange());
                L9:
                    if (r10.hasPredefinedIndex() == false) goto L12;
                    setPredefinedIndex(r10.getPredefinedIndex());
                L12:
                    if (r10.hasString() == false) goto L15;
                    this.bitField0_ |= 4;
                    this.string_ = Record.access$600(r10);
                L15:
                    if (r10.hasOperation() == false) goto L18;
                    setOperation(r10.getOperation());
                L18:
                    if (Record.access$800(r10).isEmpty() == true) goto L24;
                    if (this.substringIndex_.isEmpty() == false) goto L22;
                    this.substringIndex_ = Record.access$800(r10);
                    this.bitField0_ &= -17;
                    goto L24
                L22:
                    ensureSubstringIndexIsMutable();
                    this.substringIndex_.addAll(Record.access$800(r10));
                L24:
                    if (Record.access$900(r10).isEmpty() == false) goto L26;
                L29:
                    setUnknownFields(getUnknownFields().concat(Record.access$1100(r10)));
                    return this;
                L26:
                    if (this.replaceChar_.isEmpty() == false) goto L28;
                    this.replaceChar_ = Record.access$900(r10);
                    this.bitField0_ &= -33;
                    goto L29
                L28:
                    ensureReplaceCharIsMutable();
                    this.replaceChar_.addAll(Record.access$900(r10));
                    goto L29
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    Record r12 = null;
                    Record r13 = Record.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r13 == null) goto L6;
                    mergeFrom(r13);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Record r14 = (Record) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r12 = r14;
                L14:
                    if (r12 == null) goto L16;
                    mergeFrom(r12);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                    return mergeFrom((Record) r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                public Builder setOperation(Operation r10) {
                    Objects.requireNonNull(r10);
                    this.bitField0_ |= 8;
                    this.operation_ = r10;
                    return this;
                }

                public Builder setPredefinedIndex(int r10) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = r10;
                    return this;
                }

                public Builder setRange(int r10) {
                    this.bitField0_ |= 1;
                    this.range_ = r10;
                    return this;
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
                    Operation r10 = new Operation("NONE", 0, 0, 0);
                    NONE = r10;
                    Operation r11 = new Operation("INTERNAL_TO_CLASS_ID", 1, 1, 1);
                    INTERNAL_TO_CLASS_ID = r11;
                    Operation r12 = new Operation("DESC_TO_CLASS_ID", 2, 2, 2);
                    DESC_TO_CLASS_ID = r12;
                    $VALUES = new Operation[]{r10, r11, r12};
                    internalValueMap = new AnonymousClass1();
                }

                private Operation(String r10, int r11, int r12, int r13) {
                    super(r10, r11);
                    this.value = r13;
                }

                public static Operation valueOf(int r10) {
                    if (r10 == 0) goto L14;
                    if (r10 == 1) goto L12;
                    if (r10 == 2) goto L10;
                    return null;
                L10:
                    return DESC_TO_CLASS_ID;
                L12:
                    return INTERNAL_TO_CLASS_ID;
                L14:
                    return NONE;
                }

                public static Operation valueOf(String r10) {
                    return (Operation) Enum.valueOf(Operation.class, r10);
                }

                public static Operation[] values() {
                    return (Operation[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }
            }

            static {
                PARSER = new AnonymousClass1();
                Record r10 = new Record(true);
                defaultInstance = r10;
                r10.initFields();
            }

            private Record(CodedInputStream r12, ExtensionRegistryLite r13) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r10 = ByteString.newOutput();
                CodedOutputStream r11 = CodedOutputStream.newInstance(r10, 1);
                boolean r14 = false;
                int r15 = 0;
            L4:
                if (r14 == true) goto L81;
                int r16 = r12.readTag();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if (r16 == 0) goto L58;
                if (r16 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.range_ = r12.readInt32();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L9:
                if (r16 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.predefinedIndex_ = r12.readInt32();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L11:
                if (r16 != 24) goto L12;
                int r17 = r12.readEnum();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                Operation r18 = Operation.valueOf(r17);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if (r18 == null) goto L53;
                this.bitField0_ |= 8;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.operation_ = r18;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L53:
                r11.writeRawVarint32(r16);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r11.writeRawVarint32(r17);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L12:
                if (r16 == 32) goto L48;
                if (r16 == 34) goto L39;
                if (r16 != 40) goto L18;
                if ((r15 & 32) == 32) goto L37;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r15 = r15 | 32;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L37:
                List<Integer> r19 = this.replaceChar_;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                Integer r20 = Integer.valueOf(r12.readInt32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L38:
                r19.add(r20);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L18:
                if (r16 != 42) goto L20;
                int r21 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if ((r15 & 32) == 32) goto L31;
                if (r12.getBytesUntilLimit() <= 0) goto L31;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r15 = r15 | 32;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L31:
                if (r12.getBytesUntilLimit() <= 0) goto L33;
                this.replaceChar_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L33:
                r12.popLimit(r21);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L20:
                if (r16 != 50) goto L22;
                ByteString r22 = r12.readBytes();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.bitField0_ |= 4;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.string_ = r22;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L22:
                if (parseUnknownField(r12, r11, r13, r16) == true) goto L4;
            L39:
                r21 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if ((r15 & 16) == 16) goto L45;
                if (r12.getBytesUntilLimit() <= 0) goto L45;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r15 = r15 | 16;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L45:
                if (r12.getBytesUntilLimit() <= 0) goto L33;
                this.substringIndex_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L45
            L48:
                if ((r15 & 16) == 16) goto L50;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r15 = r15 | 16;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L50:
                r19 = this.substringIndex_;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r20 = Integer.valueOf(r12.readInt32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L58:
                r14 = true;
                goto L4
            L59:
                th = move-exception;
                if ((r15 & 16) != 16) goto L71;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L71:
                if ((r15 & 32) != 32) goto L97;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L97:
                r11.flush();     // Catch: IOException -> L94 Throwable -> L75
            L75:
                th = move-exception;
                this.unknownFields = r10.toByteString();
                throw th;
            L74:
                this.unknownFields = r10.toByteString();
                makeExtensionsImmutable();
                throw th;
            L64:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L59
            L61:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L59
            L81:
                if ((r15 & 16) != 16) goto L84;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L84:
                if ((r15 & 32) != 32) goto L99;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L99:
                r11.flush();     // Catch: IOException -> L93 Throwable -> L88
            L88:
                th = move-exception;
                this.unknownFields = r10.toByteString();
                throw th;
            L87:
                this.unknownFields = r10.toByteString();
                makeExtensionsImmutable();
            }

            /* synthetic */ Record(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            private Record(GeneratedMessageLite.Builder r10) {
                super(r10);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r10.getUnknownFields();
            }

            /* synthetic */ Record(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
                this(r10);
            }

            private Record(boolean r10) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            static /* synthetic */ int access$1002(Record r10, int r11) {
                r10.bitField0_ = r11;
                return r11;
            }

            static /* synthetic */ ByteString access$1100(Record r10) {
                return r10.unknownFields;
            }

            static /* synthetic */ int access$402(Record r10, int r11) {
                r10.range_ = r11;
                return r11;
            }

            static /* synthetic */ int access$502(Record r10, int r11) {
                r10.predefinedIndex_ = r11;
                return r11;
            }

            static /* synthetic */ Object access$600(Record r10) {
                return r10.string_;
            }

            static /* synthetic */ Object access$602(Record r10, Object r11) {
                r10.string_ = r11;
                return r11;
            }

            static /* synthetic */ Operation access$702(Record r10, Operation r11) {
                r10.operation_ = r11;
                return r11;
            }

            static /* synthetic */ List access$800(Record r10) {
                return r10.substringIndex_;
            }

            static /* synthetic */ List access$802(Record r10, List r11) {
                r10.substringIndex_ = r11;
                return r11;
            }

            static /* synthetic */ List access$900(Record r10) {
                return r10.replaceChar_;
            }

            static /* synthetic */ List access$902(Record r10, List r11) {
                r10.replaceChar_ = r11;
                return r11;
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

            public static Builder newBuilder(Record r10) {
                return newBuilder().mergeFrom(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Record getDefaultInstanceForType() {
                return defaultInstance;
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
                int r10 = this.memoizedSerializedSize;
                if (r10 == (-1)) goto L5;
                return r10;
            L5:
                int r11 = 0;
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r12 = CodedOutputStream.computeInt32Size(1, this.range_) + 0;
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r12 = r12 + CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
            L13:
                if ((this.bitField0_ & 8) != 8) goto L15;
                r12 = r12 + CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
            L15:
                int r13 = 0;
                int r14 = 0;
            L17:
                if (r13 >= this.substringIndex_.size()) goto L19;
                r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(r13).intValue());
                r13 = r13 + 1;
                goto L17
            L19:
                int r15 = r12 + r14;
                if (getSubstringIndexList().isEmpty() == true) goto L22;
                r15 = (r15 + 1) + CodedOutputStream.computeInt32SizeNoTag(r14);
            L22:
                this.substringIndexMemoizedSerializedSize = r14;
                int r16 = 0;
            L24:
                if (r11 >= this.replaceChar_.size()) goto L26;
                r16 = r16 + CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(r11).intValue());
                r11 = r11 + 1;
                goto L24
            L26:
                int r17 = r15 + r16;
                if (getReplaceCharList().isEmpty() == true) goto L29;
                r17 = (r17 + 1) + CodedOutputStream.computeInt32SizeNoTag(r16);
            L29:
                this.replaceCharMemoizedSerializedSize = r16;
                if ((this.bitField0_ & 4) != 4) goto L32;
                r17 = r17 + CodedOutputStream.computeBytesSize(6, getStringBytes());
            L32:
                int r18 = r17 + this.unknownFields.size();
                this.memoizedSerializedSize = r18;
                return r18;
            L8:
                r12 = 0;
                goto L10
            }

            public String getString() {
                Object r10 = this.string_;
                if ((r10 instanceof String) == true) goto L5;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L9;
                this.string_ = r12;
            L9:
                return r12;
            L5:
                return (String) r10;
            }

            public ByteString getStringBytes() {
                Object r10 = this.string_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.string_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
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
                byte r10 = this.memoizedIsInitialized;
                if (r10 != 1) goto L5;
                return true;
            L5:
                if (r10 != 0) goto L8;
                return false;
            L8:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r10) {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r10.writeInt32(1, this.range_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r10.writeInt32(2, this.predefinedIndex_);
            L9:
                if ((this.bitField0_ & 8) != 8) goto L12;
                r10.writeEnum(3, this.operation_.getNumber());
            L12:
                if (getSubstringIndexList().size() <= 0) goto L14;
                r10.writeRawVarint32(34);
                r10.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
            L14:
                int r11 = 0;
                int r12 = 0;
            L16:
                if (r12 >= this.substringIndex_.size()) goto L19;
                r10.writeInt32NoTag(this.substringIndex_.get(r12).intValue());
                r12 = r12 + 1;
                goto L16
            L19:
                if (getReplaceCharList().size() <= 0) goto L22;
                r10.writeRawVarint32(42);
                r10.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
            L22:
                if (r11 >= this.replaceChar_.size()) goto L25;
                r10.writeInt32NoTag(this.replaceChar_.get(r11).intValue());
                r11 = r11 + 1;
                goto L22
            L25:
                if ((this.bitField0_ & 4) != 4) goto L27;
                r10.writeBytes(6, getStringBytes());
            L27:
                r10.writeRawBytes(this.unknownFields);
            }
        }

        public interface RecordOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            PARSER = new AnonymousClass1();
            StringTableTypes r10 = new StringTableTypes(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private StringTableTypes(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L58;
            int r16 = r10.readTag();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            if (r16 == 0) goto L35;
            if (r16 == 10) goto L31;
            if (r16 != 40) goto L12;
            if ((r15 & 2) == 2) goto L28;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            r15 = r15 | 2;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
        L28:
            List r17 = this.localName_;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            Object r18 = Integer.valueOf(r10.readInt32());     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
        L29:
            r17.add(r18);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L4
        L12:
            if (r16 != 42) goto L14;
            int r19 = r10.pushLimit(r10.readRawVarint32());     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            if ((r15 & 2) == 2) goto L22;
            if (r10.getBytesUntilLimit() <= 0) goto L22;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            r15 = r15 | 2;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
        L22:
            if (r10.getBytesUntilLimit() <= 0) goto L24;
            this.localName_.add(Integer.valueOf(r10.readInt32()));     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L22
        L24:
            r10.popLimit(r19);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L4
        L14:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L4;
        L31:
            if ((r15 & 1) == 1) goto L33;
            this.record_ = new ArrayList();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            r15 = r15 | 1;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
        L33:
            r17 = this.record_;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            r18 = r10.readMessage(Record.PARSER, r11);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
        L35:
            r14 = true;
            goto L4
        L36:
            th = move-exception;
            if ((r15 & 1) != 1) goto L48;
            this.record_ = Collections.unmodifiableList(this.record_);
        L48:
            if ((r15 & 2) != 2) goto L76;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L76:
            r13.flush();     // Catch: IOException -> L71 Throwable -> L52
        L52:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L51:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L38:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L36
        L41:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L36
        L58:
            if ((r15 & 1) != 1) goto L61;
            this.record_ = Collections.unmodifiableList(this.record_);
        L61:
            if ((r15 & 2) != 2) goto L74;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L74:
            r13.flush();     // Catch: IOException -> L70 Throwable -> L65
        L65:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L64:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ StringTableTypes(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private StringTableTypes(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ StringTableTypes(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private StringTableTypes(boolean r10) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ List access$1400(StringTableTypes r10) {
            return r10.record_;
        }

        static /* synthetic */ List access$1402(StringTableTypes r10, List r11) {
            r10.record_ = r11;
            return r11;
        }

        static /* synthetic */ List access$1500(StringTableTypes r10) {
            return r10.localName_;
        }

        static /* synthetic */ List access$1502(StringTableTypes r10, List r11) {
            r10.localName_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$1600(StringTableTypes r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(StringTableTypes r10) {
            return newBuilder().mergeFrom(r10);
        }

        public static StringTableTypes parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
            return PARSER.parseDelimitedFrom(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
        L7:
            if (r12 >= this.record_.size()) goto L9;
            r13 = r13 + CodedOutputStream.computeMessageSize(1, this.record_.get(r12));
            r12 = r12 + 1;
            goto L7
        L9:
            int r14 = 0;
        L11:
            if (r11 >= this.localName_.size()) goto L13;
            r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(r11).intValue());
            r11 = r11 + 1;
            goto L11
        L13:
            int r15 = r13 + r14;
            if (getLocalNameList().isEmpty() == true) goto L16;
            r15 = (r15 + 1) + CodedOutputStream.computeInt32SizeNoTag(r14);
        L16:
            this.localNameMemoizedSerializedSize = r14;
            int r16 = r15 + this.unknownFields.size();
            this.memoizedSerializedSize = r16;
            return r16;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r12 >= this.record_.size()) goto L7;
            r10.writeMessage(1, this.record_.get(r12));
            r12 = r12 + 1;
            goto L4
        L7:
            if (getLocalNameList().size() <= 0) goto L10;
            r10.writeRawVarint32(42);
            r10.writeRawVarint32(this.localNameMemoizedSerializedSize);
        L10:
            if (r11 >= this.localName_.size()) goto L12;
            r10.writeInt32NoTag(this.localName_.get(r11).intValue());
            r11 = r11 + 1;
            goto L10
        L12:
            r10.writeRawBytes(this.unknownFields);
        }
    }

    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        ProtoBuf.Constructor r10 = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature r11 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature r12 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType r13 = WireFormat.FieldType.MESSAGE;
        constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(r10, r11, r12, null, 100, r13, JvmMethodSignature.class);
        methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, r13, JvmMethodSignature.class);
        ProtoBuf.Function r14 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType r15 = WireFormat.FieldType.INT32;
        lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(r14, 0, null, null, 101, r15, Integer.class);
        propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, r13, JvmPropertySignature.class);
        flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, r15, Integer.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, r13, false, ProtoBuf.Annotation.class);
        isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, r13, false, ProtoBuf.Annotation.class);
        classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, r15, Integer.class);
        classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, r13, false, ProtoBuf.Property.class);
        anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, r15, Integer.class);
        jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, r15, Integer.class);
        packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, r15, Integer.class);
        packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, r13, false, ProtoBuf.Property.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r10) {
        r10.add(constructorSignature);
        r10.add(methodSignature);
        r10.add(lambdaClassOriginName);
        r10.add(propertySignature);
        r10.add(flags);
        r10.add(typeAnnotation);
        r10.add(isRaw);
        r10.add(typeParameterAnnotation);
        r10.add(classModuleName);
        r10.add(classLocalVariable);
        r10.add(anonymousObjectOriginName);
        r10.add(jvmClassFlags);
        r10.add(packageModuleName);
        r10.add(packageLocalVariable);
    }
}
