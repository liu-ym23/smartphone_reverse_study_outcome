package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$ValueParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$ValueParameter> implements ProtoBuf$ValueParameterOrBuilder {
    public static Parser<ProtoBuf$ValueParameter> PARSER;
    private static final ProtoBuf$ValueParameter defaultInstance = null;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private ProtoBuf$Type type_;
    private final ByteString unknownFields;
    private int varargElementTypeId_;
    private ProtoBuf$Type varargElementType_;

    private void initFields() {
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = ProtoBuf$Type.getDefaultInstance();
        this.typeId_ = 0;
        this.varargElementType_ = ProtoBuf$Type.getDefaultInstance();
        this.varargElementTypeId_ = 0;
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$ValueParameter r0 = new ProtoBuf$ValueParameter(true);
        defaultInstance = r0;
        r0.initFields();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 1) != 1) goto L9;
        r2 = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
    L9:
        if ((this.bitField0_ & 2) != 2) goto L12;
        r2 = r2 + CodedOutputStream.computeInt32Size(2, this.name_);
    L12:
        if ((this.bitField0_ & 4) != 4) goto L15;
        r2 = r2 + CodedOutputStream.computeMessageSize(3, this.type_);
    L15:
        if ((this.bitField0_ & 16) != 16) goto L18;
        r2 = r2 + CodedOutputStream.computeMessageSize(4, this.varargElementType_);
    L18:
        if ((this.bitField0_ & 8) != 8) goto L21;
        r2 = r2 + CodedOutputStream.computeInt32Size(5, this.typeId_);
    L21:
        if ((this.bitField0_ & 32) != 32) goto L23;
        r2 = r2 + CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
    L23:
        int r3 = (r2 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
    }

    public boolean hasFlags() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasName() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasType() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeId() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasVarargElementType() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasVarargElementTypeId() {
        if ((this.bitField0_ & 32) != 32) goto L5;
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
        if (hasName() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasType() == false) goto L19;
        if (getType().isInitialized() == true) goto L19;
        this.memoizedIsInitialized = 0;
        return false;
    L19:
        if (hasVarargElementType() == false) goto L25;
        if (getVarargElementType().isInitialized() == true) goto L25;
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (extensionsAreInitialized() == true) goto L28;
        this.memoizedIsInitialized = 0;
        return false;
    L28:
        this.memoizedIsInitialized = 1;
        return true;
    }

    public static Builder newBuilder() {
        return Builder.access$17900();
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

    public static ProtoBuf$ValueParameter getDefaultInstance() {
        return defaultInstance;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$ValueParameter> getParserForType() {
        return PARSER;
    }

    public ProtoBuf$Type getType() {
        return this.type_;
    }

    public int getTypeId() {
        return this.typeId_;
    }

    public ProtoBuf$Type getVarargElementType() {
        return this.varargElementType_;
    }

    public int getVarargElementTypeId() {
        return this.varargElementTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$ValueParameter getDefaultInstanceForType() {
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

    private ProtoBuf$ValueParameter(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$ValueParameter, ?> r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ ByteString access$18800(ProtoBuf$ValueParameter r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$ValueParameter r1) {
        return newBuilder().mergeFrom(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r5) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r5.writeInt32(1, this.flags_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r5.writeInt32(2, this.name_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L12;
        r5.writeMessage(3, this.type_);
    L12:
        if ((this.bitField0_ & 16) != 16) goto L15;
        r5.writeMessage(4, this.varargElementType_);
    L15:
        if ((this.bitField0_ & 8) != 8) goto L18;
        r5.writeInt32(5, this.typeId_);
    L18:
        if ((this.bitField0_ & 32) != 32) goto L20;
        r5.writeInt32(6, this.varargElementTypeId_);
    L20:
        r0.writeUntil(200, r5);
        r5.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$ValueParameter(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$ValueParameter(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
    L3:
        if (r3 == true) goto L69;
        int r4 = r10.readTag();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        if (r4 == 0) goto L40;
        if (r4 != 8) goto L9;
        this.bitField0_ |= 1;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.flags_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        goto L3
    L9:
        if (r4 != 16) goto L10;
        this.bitField0_ |= 2;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.name_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        goto L3
    L10:
        ProtoBuf$Type.Builder r8 = null;
        if (r4 != 26) goto L13;
        if ((this.bitField0_ & 4) != 4) goto L33;
        r8 = this.type_.mo380toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
    L33:
        ProtoBuf$Type r5 = (ProtoBuf$Type) r10.readMessage(ProtoBuf$Type.PARSER, r11);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.type_ = r5;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        if (r8 == null) goto L36;
        r8.mergeFrom(r5);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.type_ = r8.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
    L36:
        this.bitField0_ |= 4;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        goto L3
    L13:
        if (r4 != 34) goto L15;
        if ((this.bitField0_ & 16) != 16) goto L26;
        r8 = this.varargElementType_.mo380toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
    L26:
        ProtoBuf$Type r6 = (ProtoBuf$Type) r10.readMessage(ProtoBuf$Type.PARSER, r11);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.varargElementType_ = r6;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        if (r8 == null) goto L29;
        r8.mergeFrom(r6);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.varargElementType_ = r8.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
    L29:
        this.bitField0_ |= 16;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        goto L3
    L15:
        if (r4 != 40) goto L17;
        this.bitField0_ |= 8;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.typeId_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        goto L3
    L17:
        if (r4 != 48) goto L19;
        this.bitField0_ |= 32;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        this.varargElementTypeId_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        goto L3
    L19:
        if (parseUnknownField(r10, r2, r11, r4) == true) goto L3;
    L40:
        r3 = true;
        goto L3
    L41:
        th = move-exception;
        r2.flush();     // Catch: IOException -> L63 Throwable -> L51
    L51:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L50:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L43:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L41
    L46:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L41
    L69:
        r2.flush();     // Catch: IOException -> L64 Throwable -> L58
    L58:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L57:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$18102(ProtoBuf$ValueParameter r0, int r1) {
        r0.flags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$18202(ProtoBuf$ValueParameter r0, int r1) {
        r0.name_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$18302(ProtoBuf$ValueParameter r0, ProtoBuf$Type r1) {
        r0.type_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$18402(ProtoBuf$ValueParameter r0, int r1) {
        r0.typeId_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$18502(ProtoBuf$ValueParameter r0, ProtoBuf$Type r1) {
        r0.varargElementType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$18602(ProtoBuf$ValueParameter r0, int r1) {
        r0.varargElementTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$18702(ProtoBuf$ValueParameter r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$ValueParameter(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$ValueParameter(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
