package kotlin.reflect.jvm.internal.impl.metadata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$Type extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Type> implements ProtoBuf$TypeOrBuilder {
    public static Parser<ProtoBuf$Type> PARSER;
    private static final ProtoBuf$Type defaultInstance = null;
    private int abbreviatedTypeId_;
    private ProtoBuf$Type abbreviatedType_;
    private List<Argument> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private ProtoBuf$Type flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private ProtoBuf$Type outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final ByteString unknownFields;

    public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
        public static Parser<Argument> PARSER;
        private static final Argument defaultInstance = null;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Projection projection_;
        private int typeId_;
        private ProtoBuf$Type type_;
        private final ByteString unknownFields;

        public static final enum Projection extends Enum<Projection> implements Internal$EnumLite {
            private static final /* synthetic */ Projection[] $VALUES = null;
            public static final Projection IN = null;
            public static final Projection INV = null;
            public static final Projection OUT = null;
            public static final Projection STAR = null;
            private static Internal$EnumLiteMap<Projection> internalValueMap;
            private final int value;

            static {
                Projection r0 = new Projection("IN", 0, 0, 0);
                IN = r0;
                Projection r1 = new Projection("OUT", 1, 1, 1);
                OUT = r1;
                Projection r3 = new Projection("INV", 2, 2, 2);
                INV = r3;
                Projection r5 = new Projection("STAR", 3, 3, 3);
                STAR = r5;
                $VALUES = new Projection[]{r0, r1, r3, r5};
                internalValueMap = new AnonymousClass1();
            }

            public static Projection[] values() {
                return (Projection[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Projection valueOf(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return STAR;
            L14:
                return INV;
            L16:
                return OUT;
            L18:
                return IN;
            }

            public static Projection valueOf(String r1) {
                return (Projection) a.a(Projection.class, r1);
            }

            private Projection(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Argument r0 = new Argument(true);
            defaultInstance = r0;
            r0.initFields();
        }

        private void initFields() {
            this.projection_ = Projection.INV;
            this.type_ = ProtoBuf$Type.getDefaultInstance();
            this.typeId_ = 0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r0 = this.memoizedSerializedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r2 = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r2 = r2 + CodedOutputStream.computeMessageSize(2, this.type_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L14;
            r2 = r2 + CodedOutputStream.computeInt32Size(3, this.typeId_);
        L14:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
        }

        public boolean hasProjection() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasType() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeId() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasType() == true) goto L11;
        L14:
            this.memoizedIsInitialized = 1;
            return true;
        L11:
            if (getType().isInitialized() == true) goto L14;
            this.memoizedIsInitialized = 0;
            return false;
        }

        public static Builder newBuilder() {
            return Builder.access$5000();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static Argument getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Argument> getParserForType() {
            return PARSER;
        }

        public Projection getProjection() {
            return this.projection_;
        }

        public ProtoBuf$Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Argument getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        /* JADX INFO: renamed from: newBuilderForType */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo379newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        /* JADX INFO: renamed from: toBuilder */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo380toBuilder() {
            return toBuilder();
        }

        private Argument(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$5600(Argument r0) {
            return r0.unknownFields;
        }

        public static Builder newBuilder(Argument r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r3) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r3.writeEnum(1, this.projection_.getNumber());
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r3.writeMessage(2, this.type_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r3.writeInt32(3, this.typeId_);
        L11:
            r3.writeRawBytes(this.unknownFields);
        }

        private Argument(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Argument(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L58;
            int r4 = r8.readTag();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            if (r4 == 0) goto L29;
            if (r4 != 8) goto L9;
            int r5 = r8.readEnum();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            Projection r6 = Projection.valueOf(r5);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            if (r6 == null) goto L26;
            this.bitField0_ |= 1;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.projection_ = r6;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L3
        L26:
            r2.writeRawVarint32(r4);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            r2.writeRawVarint32(r5);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L3
        L9:
            if (r4 != 18) goto L11;
            if ((this.bitField0_ & 2) != 2) goto L19;
            Builder r7 = this.type_.mo380toBuilder();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L20:
            ProtoBuf$Type r10 = (ProtoBuf$Type) r8.readMessage(ProtoBuf$Type.PARSER, r9);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.type_ = r10;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            if (r7 == null) goto L23;
            r7.mergeFrom(r10);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.type_ = r7.buildPartial();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L23:
            this.bitField0_ |= 2;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L3
        L19:
            r7 = null;
            goto L20
        L11:
            if (r4 != 24) goto L13;
            this.bitField0_ |= 4;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.typeId_ = r8.readInt32();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L3
        L13:
            if (parseUnknownField(r8, r2, r9, r4) == true) goto L3;
        L29:
            r3 = true;
            goto L3
        L30:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L52 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L39:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L32:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L30
        L35:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L30
        L58:
            r2.flush();     // Catch: IOException -> L53 Throwable -> L47
        L47:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L46:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ Projection access$5202(Argument r0, Projection r1) {
            r0.projection_ = r1;
            return r1;
        }

        public static /* synthetic */ ProtoBuf$Type access$5302(Argument r0, ProtoBuf$Type r1) {
            r0.type_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$5402(Argument r0, int r1) {
            r0.typeId_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$5502(Argument r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public /* synthetic */ Argument(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
            this(r1);
        }

        public /* synthetic */ Argument(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Type, Builder> implements ProtoBuf$TypeOrBuilder {
        private int abbreviatedTypeId_;
        private ProtoBuf$Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private ProtoBuf$Type flexibleUpperBound_;
        private boolean nullable_;
        private int outerTypeId_;
        private ProtoBuf$Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;

        private void maybeForceBuilderInitialization() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            int r1 = 0;
        L4:
            if (r1 >= getArgumentCount()) goto L10;
            if (getArgument(r1).isInitialized() == false) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L10:
            if (hasFlexibleUpperBound() == false) goto L15;
            if (getFlexibleUpperBound().isInitialized() == true) goto L15;
            return false;
        L15:
            if (hasOuterType() == false) goto L20;
            if (getOuterType().isInitialized() == true) goto L20;
            return false;
        L20:
            if (hasAbbreviatedType() == false) goto L25;
            if (getAbbreviatedType().isInitialized() == true) goto L25;
            return false;
        L25:
            if (extensionsAreInitialized() == true) goto L27;
            return false;
        L27:
            return true;
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureArgumentIsMutable() {
            if ((this.bitField0_ & 1) == 1) goto L6;
            this.argument_ = new ArrayList(this.argument_);
            this.bitField0_ |= 1;
            return;
        }

        public ProtoBuf$Type buildPartial() {
            ProtoBuf$Type r0 = new ProtoBuf$Type(this, null);
            int r1 = this.bitField0_;
            int r3 = 1;
            if ((r1 & 1) != 1) goto L5;
            this.argument_ = Collections.unmodifiableList(this.argument_);
            this.bitField0_ &= -2;
        L5:
            ProtoBuf$Type.access$5902(r0, this.argument_);
            if ((r1 & 2) == 2) goto L9;
            r3 = 0;
        L9:
            ProtoBuf$Type.access$6002(r0, this.nullable_);
            if ((r1 & 4) != 4) goto L12;
            r3 = r3 | 2;
        L12:
            ProtoBuf$Type.access$6102(r0, this.flexibleTypeCapabilitiesId_);
            if ((r1 & 8) != 8) goto L15;
            r3 = r3 | 4;
        L15:
            ProtoBuf$Type.access$6202(r0, this.flexibleUpperBound_);
            if ((r1 & 16) != 16) goto L18;
            r3 = r3 | 8;
        L18:
            ProtoBuf$Type.access$6302(r0, this.flexibleUpperBoundId_);
            if ((r1 & 32) != 32) goto L21;
            r3 = r3 | 16;
        L21:
            ProtoBuf$Type.access$6402(r0, this.className_);
            if ((r1 & 64) != 64) goto L24;
            r3 = r3 | 32;
        L24:
            ProtoBuf$Type.access$6502(r0, this.typeParameter_);
            if ((r1 & 128) != 128) goto L27;
            r3 = r3 | 64;
        L27:
            ProtoBuf$Type.access$6602(r0, this.typeParameterName_);
            if ((r1 & 256) != 256) goto L30;
            r3 = r3 | 128;
        L30:
            ProtoBuf$Type.access$6702(r0, this.typeAliasName_);
            if ((r1 & 512) != 512) goto L33;
            r3 = r3 | 256;
        L33:
            ProtoBuf$Type.access$6802(r0, this.outerType_);
            if ((r1 & 1024) != 1024) goto L36;
            r3 = r3 | 512;
        L36:
            ProtoBuf$Type.access$6902(r0, this.outerTypeId_);
            if ((r1 & 2048) != 2048) goto L39;
            r3 = r3 | 1024;
        L39:
            ProtoBuf$Type.access$7002(r0, this.abbreviatedType_);
            if ((r1 & 4096) != 4096) goto L42;
            r3 = r3 | 2048;
        L42:
            ProtoBuf$Type.access$7102(r0, this.abbreviatedTypeId_);
            if ((r1 & 8192) != 8192) goto L45;
            r3 = r3 | 4096;
        L45:
            ProtoBuf$Type.access$7202(r0, this.flags_);
            ProtoBuf$Type.access$7302(r0, r3);
            return r0;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public boolean hasAbbreviatedType() {
            if ((this.bitField0_ & 2048) != 2048) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlexibleUpperBound() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasOuterType() {
            if ((this.bitField0_ & 512) != 512) goto L5;
            return true;
        L5:
            return false;
        }

        private Builder() {
            this.argument_ = Collections.emptyList();
            this.flexibleUpperBound_ = ProtoBuf$Type.getDefaultInstance();
            this.outerType_ = ProtoBuf$Type.getDefaultInstance();
            this.abbreviatedType_ = ProtoBuf$Type.getDefaultInstance();
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ Builder access$5700() {
            return create();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Type build() {
            ProtoBuf$Type r0 = buildPartial();
            if (r0.isInitialized() == false) goto L6;
            return r0;
        L6:
            throw AbstractMessageLite.Builder.newUninitializedMessageException(r0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ProtoBuf$Type getDefaultInstanceForType() {
            return ProtoBuf$Type.getDefaultInstance();
        }

        public ProtoBuf$Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public ProtoBuf$Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public ProtoBuf$Type getOuterType() {
            return this.outerType_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo381clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
            return clone();
        }

        public Argument getArgument(int r2) {
            return (Argument) ListProtector.get(this.argument_, r2);
        }

        public Builder mergeAbbreviatedType(ProtoBuf$Type r4) {
            if ((this.bitField0_ & 2048) == 2048) goto L5;
        L7:
            this.abbreviatedType_ = r4;
        L8:
            this.bitField0_ |= 2048;
            return this;
        L5:
            if (this.abbreviatedType_ == ProtoBuf$Type.getDefaultInstance()) goto L7;
            this.abbreviatedType_ = ProtoBuf$Type.newBuilder(this.abbreviatedType_).mergeFrom(r4).buildPartial();
            goto L8
        }

        public Builder mergeFlexibleUpperBound(ProtoBuf$Type r4) {
            if ((this.bitField0_ & 8) == 8) goto L5;
        L7:
            this.flexibleUpperBound_ = r4;
        L8:
            this.bitField0_ |= 8;
            return this;
        L5:
            if (this.flexibleUpperBound_ == ProtoBuf$Type.getDefaultInstance()) goto L7;
            this.flexibleUpperBound_ = ProtoBuf$Type.newBuilder(this.flexibleUpperBound_).mergeFrom(r4).buildPartial();
            goto L8
        }

        public Builder mergeFrom(ProtoBuf$Type r3) {
            if (r3 != ProtoBuf$Type.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (ProtoBuf$Type.access$5900(r3).isEmpty() == true) goto L12;
            if (this.argument_.isEmpty() == false) goto L10;
            this.argument_ = ProtoBuf$Type.access$5900(r3);
            this.bitField0_ &= -2;
            goto L12
        L10:
            ensureArgumentIsMutable();
            this.argument_.addAll(ProtoBuf$Type.access$5900(r3));
        L12:
            if (r3.hasNullable() == false) goto L15;
            setNullable(r3.getNullable());
        L15:
            if (r3.hasFlexibleTypeCapabilitiesId() == false) goto L18;
            setFlexibleTypeCapabilitiesId(r3.getFlexibleTypeCapabilitiesId());
        L18:
            if (r3.hasFlexibleUpperBound() == false) goto L21;
            mergeFlexibleUpperBound(r3.getFlexibleUpperBound());
        L21:
            if (r3.hasFlexibleUpperBoundId() == false) goto L24;
            setFlexibleUpperBoundId(r3.getFlexibleUpperBoundId());
        L24:
            if (r3.hasClassName() == false) goto L27;
            setClassName(r3.getClassName());
        L27:
            if (r3.hasTypeParameter() == false) goto L30;
            setTypeParameter(r3.getTypeParameter());
        L30:
            if (r3.hasTypeParameterName() == false) goto L33;
            setTypeParameterName(r3.getTypeParameterName());
        L33:
            if (r3.hasTypeAliasName() == false) goto L36;
            setTypeAliasName(r3.getTypeAliasName());
        L36:
            if (r3.hasOuterType() == false) goto L39;
            mergeOuterType(r3.getOuterType());
        L39:
            if (r3.hasOuterTypeId() == false) goto L42;
            setOuterTypeId(r3.getOuterTypeId());
        L42:
            if (r3.hasAbbreviatedType() == false) goto L45;
            mergeAbbreviatedType(r3.getAbbreviatedType());
        L45:
            if (r3.hasAbbreviatedTypeId() == false) goto L48;
            setAbbreviatedTypeId(r3.getAbbreviatedTypeId());
        L48:
            if (r3.hasFlags() == false) goto L50;
            setFlags(r3.getFlags());
        L50:
            mergeExtensionFields(r3);
            setUnknownFields(getUnknownFields().concat(ProtoBuf$Type.access$7400(r3)));
            return this;
        }

        public Builder mergeOuterType(ProtoBuf$Type r4) {
            if ((this.bitField0_ & 512) == 512) goto L5;
        L7:
            this.outerType_ = r4;
        L8:
            this.bitField0_ |= 512;
            return this;
        L5:
            if (this.outerType_ == ProtoBuf$Type.getDefaultInstance()) goto L7;
            this.outerType_ = ProtoBuf$Type.newBuilder(this.outerType_).mergeFrom(r4).buildPartial();
            goto L8
        }

        public Builder setAbbreviatedTypeId(int r2) {
            this.bitField0_ |= 4096;
            this.abbreviatedTypeId_ = r2;
            return this;
        }

        public Builder setClassName(int r2) {
            this.bitField0_ |= 32;
            this.className_ = r2;
            return this;
        }

        public Builder setFlags(int r2) {
            this.bitField0_ |= 8192;
            this.flags_ = r2;
            return this;
        }

        public Builder setFlexibleTypeCapabilitiesId(int r2) {
            this.bitField0_ |= 4;
            this.flexibleTypeCapabilitiesId_ = r2;
            return this;
        }

        public Builder setFlexibleUpperBoundId(int r2) {
            this.bitField0_ |= 16;
            this.flexibleUpperBoundId_ = r2;
            return this;
        }

        public Builder setNullable(boolean r2) {
            this.bitField0_ |= 2;
            this.nullable_ = r2;
            return this;
        }

        public Builder setOuterTypeId(int r2) {
            this.bitField0_ |= 1024;
            this.outerTypeId_ = r2;
            return this;
        }

        public Builder setTypeAliasName(int r2) {
            this.bitField0_ |= 256;
            this.typeAliasName_ = r2;
            return this;
        }

        public Builder setTypeParameter(int r2) {
            this.bitField0_ |= 64;
            this.typeParameter_ = r2;
            return this;
        }

        public Builder setTypeParameterName(int r2) {
            this.bitField0_ |= 128;
            this.typeParameterName_ = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
            return mergeFrom((ProtoBuf$Type) r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
            ProtoBuf$Type r0 = null;
            ProtoBuf$Type r5 = ProtoBuf$Type.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
            if (r5 == null) goto L6;
            mergeFrom(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            ProtoBuf$Type r6 = (ProtoBuf$Type) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            mergeFrom(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$Type r0 = new ProtoBuf$Type(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 4096) != 4096) goto L8;
        int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
    L10:
        if (r2 >= this.argument_.size()) goto L13;
        r1 = r1 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.argument_, r2));
        r2 = r2 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 1) != 1) goto L16;
        r1 = r1 + CodedOutputStream.computeBoolSize(3, this.nullable_);
    L16:
        if ((this.bitField0_ & 2) != 2) goto L19;
        r1 = r1 + CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
    L19:
        if ((this.bitField0_ & 4) != 4) goto L22;
        r1 = r1 + CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
    L22:
        if ((this.bitField0_ & 16) != 16) goto L25;
        r1 = r1 + CodedOutputStream.computeInt32Size(6, this.className_);
    L25:
        if ((this.bitField0_ & 32) != 32) goto L28;
        r1 = r1 + CodedOutputStream.computeInt32Size(7, this.typeParameter_);
    L28:
        if ((this.bitField0_ & 8) != 8) goto L31;
        r1 = r1 + CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
    L31:
        if ((this.bitField0_ & 64) != 64) goto L34;
        r1 = r1 + CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
    L34:
        if ((this.bitField0_ & 256) != 256) goto L37;
        r1 = r1 + CodedOutputStream.computeMessageSize(10, this.outerType_);
    L37:
        if ((this.bitField0_ & 512) != 512) goto L40;
        r1 = r1 + CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
    L40:
        if ((this.bitField0_ & 128) != 128) goto L43;
        r1 = r1 + CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
    L43:
        if ((this.bitField0_ & 1024) != 1024) goto L46;
        r1 = r1 + CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
    L46:
        if ((this.bitField0_ & 2048) != 2048) goto L48;
        r1 = r1 + CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
    L48:
        int r3 = (r1 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
    L8:
        r1 = 0;
        goto L10
    }

    public boolean hasAbbreviatedType() {
        if ((this.bitField0_ & 1024) != 1024) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasAbbreviatedTypeId() {
        if ((this.bitField0_ & 2048) != 2048) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasClassName() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlags() {
        if ((this.bitField0_ & 4096) != 4096) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlexibleTypeCapabilitiesId() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlexibleUpperBound() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlexibleUpperBoundId() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasNullable() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasOuterType() {
        if ((this.bitField0_ & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasOuterTypeId() {
        if ((this.bitField0_ & 512) != 512) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeAliasName() {
        if ((this.bitField0_ & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeParameter() {
        if ((this.bitField0_ & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeParameterName() {
        if ((this.bitField0_ & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= getArgumentCount()) goto L17;
        if (getArgument(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasFlexibleUpperBound() == false) goto L23;
        if (getFlexibleUpperBound().isInitialized() == true) goto L23;
        this.memoizedIsInitialized = 0;
        return false;
    L23:
        if (hasOuterType() == false) goto L29;
        if (getOuterType().isInitialized() == true) goto L29;
        this.memoizedIsInitialized = 0;
        return false;
    L29:
        if (hasAbbreviatedType() == false) goto L35;
        if (getAbbreviatedType().isInitialized() == true) goto L35;
        this.memoizedIsInitialized = 0;
        return false;
    L35:
        if (extensionsAreInitialized() == true) goto L38;
        this.memoizedIsInitialized = 0;
        return false;
    L38:
        this.memoizedIsInitialized = 1;
        return true;
    }

    private void initFields() {
        this.argument_ = Collections.emptyList();
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        this.flexibleUpperBound_ = getDefaultInstance();
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = getDefaultInstance();
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = getDefaultInstance();
        this.abbreviatedTypeId_ = 0;
        this.flags_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.access$5700();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: newBuilderForType */
    public Builder mo379newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: toBuilder */
    public Builder mo380toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Type getDefaultInstance() {
        return defaultInstance;
    }

    public ProtoBuf$Type getAbbreviatedType() {
        return this.abbreviatedType_;
    }

    public int getAbbreviatedTypeId() {
        return this.abbreviatedTypeId_;
    }

    public List<Argument> getArgumentList() {
        return this.argument_;
    }

    public int getClassName() {
        return this.className_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFlexibleTypeCapabilitiesId() {
        return this.flexibleTypeCapabilitiesId_;
    }

    public ProtoBuf$Type getFlexibleUpperBound() {
        return this.flexibleUpperBound_;
    }

    public int getFlexibleUpperBoundId() {
        return this.flexibleUpperBoundId_;
    }

    public boolean getNullable() {
        return this.nullable_;
    }

    public ProtoBuf$Type getOuterType() {
        return this.outerType_;
    }

    public int getOuterTypeId() {
        return this.outerTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Type> getParserForType() {
        return PARSER;
    }

    public int getTypeAliasName() {
        return this.typeAliasName_;
    }

    public int getTypeParameter() {
        return this.typeParameter_;
    }

    public int getTypeParameterName() {
        return this.typeParameterName_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Type getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: newBuilderForType */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo379newBuilderForType() {
        return mo379newBuilderForType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: toBuilder */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo380toBuilder() {
        return mo380toBuilder();
    }

    private ProtoBuf$Type(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Type, ?> r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$5900(ProtoBuf$Type r0) {
        return r0.argument_;
    }

    public static /* synthetic */ ByteString access$7400(ProtoBuf$Type r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Type r1) {
        return newBuilder().mergeFrom(r1);
    }

    public Argument getArgument(int r2) {
        return (Argument) ListProtector.get(this.argument_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r6) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 4096) != 4096) goto L5;
        r6.writeInt32(1, this.flags_);
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.argument_.size()) goto L10;
        r6.writeMessage(2, (MessageLite) ListProtector.get(this.argument_, r1));
        r1 = r1 + 1;
        goto L7
    L10:
        if ((this.bitField0_ & 1) != 1) goto L13;
        r6.writeBool(3, this.nullable_);
    L13:
        if ((this.bitField0_ & 2) != 2) goto L16;
        r6.writeInt32(4, this.flexibleTypeCapabilitiesId_);
    L16:
        if ((this.bitField0_ & 4) != 4) goto L19;
        r6.writeMessage(5, this.flexibleUpperBound_);
    L19:
        if ((this.bitField0_ & 16) != 16) goto L22;
        r6.writeInt32(6, this.className_);
    L22:
        if ((this.bitField0_ & 32) != 32) goto L25;
        r6.writeInt32(7, this.typeParameter_);
    L25:
        if ((this.bitField0_ & 8) != 8) goto L28;
        r6.writeInt32(8, this.flexibleUpperBoundId_);
    L28:
        if ((this.bitField0_ & 64) != 64) goto L31;
        r6.writeInt32(9, this.typeParameterName_);
    L31:
        if ((this.bitField0_ & 256) != 256) goto L34;
        r6.writeMessage(10, this.outerType_);
    L34:
        if ((this.bitField0_ & 512) != 512) goto L37;
        r6.writeInt32(11, this.outerTypeId_);
    L37:
        if ((this.bitField0_ & 128) != 128) goto L40;
        r6.writeInt32(12, this.typeAliasName_);
    L40:
        if ((this.bitField0_ & 1024) != 1024) goto L43;
        r6.writeMessage(13, this.abbreviatedType_);
    L43:
        if ((this.bitField0_ & 2048) != 2048) goto L45;
        r6.writeInt32(14, this.abbreviatedTypeId_);
    L45:
        r0.writeUntil(200, r6);
        r6.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Type(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$Type(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L65;
        int r5 = r9.readTag();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        Builder r6 = null;
        switch(r5) {
            case 0: goto L43;
            case 8: goto L41;
            case 18: goto L38;
            case 24: goto L36;
            case 32: goto L35;
            case 42: goto L29;
            case 48: goto L27;
            case 56: goto L26;
            case 64: goto L25;
            case 72: goto L24;
            case 82: goto L18;
            case 88: goto L16;
            case 96: goto L15;
            case 106: goto L9;
            case 112: goto L7;
            default: goto L44;
        };     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L7:
        this.bitField0_ |= 2048;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.abbreviatedTypeId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L9:
        if ((this.bitField0_ & 1024) != 1024) goto L11;
        r6 = this.abbreviatedType_.mo380toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L11:
        ProtoBuf$Type r7 = (ProtoBuf$Type) r9.readMessage(PARSER, r10);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.abbreviatedType_ = r7;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        if (r6 == null) goto L14;
        r6.mergeFrom(r7);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.abbreviatedType_ = r6.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L14:
        this.bitField0_ |= 1024;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L15:
        this.bitField0_ |= 128;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.typeAliasName_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L16:
        this.bitField0_ |= 512;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.outerTypeId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L18:
        if ((this.bitField0_ & 256) != 256) goto L20;
        r6 = this.outerType_.mo380toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L20:
        ProtoBuf$Type r8 = (ProtoBuf$Type) r9.readMessage(PARSER, r10);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.outerType_ = r8;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        if (r6 == null) goto L23;
        r6.mergeFrom(r8);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.outerType_ = r6.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L23:
        this.bitField0_ |= 256;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L24:
        this.bitField0_ |= 64;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.typeParameterName_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L25:
        this.bitField0_ |= 8;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.flexibleUpperBoundId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L26:
        this.bitField0_ |= 32;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.typeParameter_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L27:
        this.bitField0_ |= 16;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.className_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L29:
        if ((this.bitField0_ & 4) != 4) goto L31;
        r6 = this.flexibleUpperBound_.mo380toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L31:
        ProtoBuf$Type r11 = (ProtoBuf$Type) r9.readMessage(PARSER, r10);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.flexibleUpperBound_ = r11;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        if (r6 == null) goto L34;
        r6.mergeFrom(r11);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.flexibleUpperBound_ = r6.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L34:
        this.bitField0_ |= 4;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L35:
        this.bitField0_ |= 2;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.flexibleTypeCapabilitiesId_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L36:
        this.bitField0_ |= 1;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.nullable_ = r9.readBool();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L38:
        if ((r4 & true) == true) goto L40;
        this.argument_ = new ArrayList();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        r4 = r4 | true;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L40:
        this.argument_.add((Argument) r9.readMessage(Argument.PARSER, r10));     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        goto L3
    L41:
        this.bitField0_ |= 4096;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        this.flags_ = r9.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
    L43:
        r3 = true;
        goto L3
    L44:
        if (parseUnknownField(r9, r2, r10, r5) == true) goto L3;
    L46:
        th = move-exception;
        if ((r4 & true) != true) goto L78;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L78:
        r2.flush();     // Catch: IOException -> L75 Throwable -> L59
    L59:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L58:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L51:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L46
    L48:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L46
    L65:
        if ((r4 & true) != true) goto L80;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L80:
        r2.flush();     // Catch: IOException -> L74 Throwable -> L69
    L69:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L68:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ List access$5902(ProtoBuf$Type r0, List r1) {
        r0.argument_ = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$6002(ProtoBuf$Type r0, boolean r1) {
        r0.nullable_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$6102(ProtoBuf$Type r0, int r1) {
        r0.flexibleTypeCapabilitiesId_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$6202(ProtoBuf$Type r0, ProtoBuf$Type r1) {
        r0.flexibleUpperBound_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$6302(ProtoBuf$Type r0, int r1) {
        r0.flexibleUpperBoundId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$6402(ProtoBuf$Type r0, int r1) {
        r0.className_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$6502(ProtoBuf$Type r0, int r1) {
        r0.typeParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$6602(ProtoBuf$Type r0, int r1) {
        r0.typeParameterName_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$6702(ProtoBuf$Type r0, int r1) {
        r0.typeAliasName_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$6802(ProtoBuf$Type r0, ProtoBuf$Type r1) {
        r0.outerType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$6902(ProtoBuf$Type r0, int r1) {
        r0.outerTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$7002(ProtoBuf$Type r0, ProtoBuf$Type r1) {
        r0.abbreviatedType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$7102(ProtoBuf$Type r0, int r1) {
        r0.abbreviatedTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$7202(ProtoBuf$Type r0, int r1) {
        r0.flags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$7302(ProtoBuf$Type r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$Type(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Type(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
