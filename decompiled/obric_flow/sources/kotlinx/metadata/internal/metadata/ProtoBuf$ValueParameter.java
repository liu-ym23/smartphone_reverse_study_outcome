package kotlinx.metadata.internal.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBuf$ValueParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$ValueParameter> implements au.u {
    public static final int FLAGS_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 3;
    public static final int TYPE_ID_FIELD_NUMBER = 5;
    public static final int VARARG_ELEMENT_TYPE_FIELD_NUMBER = 4;
    public static final int VARARG_ELEMENT_TYPE_ID_FIELD_NUMBER = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$ValueParameter f19079a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private ProtoBuf$Type type_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private int varargElementTypeId_;
    private ProtoBuf$Type varargElementType_;

    static {
        PARSER = new au.b(17);
        ProtoBuf$ValueParameter r5 = new ProtoBuf$ValueParameter();
        f19079a = r5;
        r5.flags_ = 0;
        r5.name_ = 0;
        r5.type_ = ProtoBuf$Type.getDefaultInstance();
        r5.typeId_ = 0;
        r5.varargElementType_ = ProtoBuf$Type.getDefaultInstance();
        r5.varargElementTypeId_ = 0;
    }

    public ProtoBuf$ValueParameter(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$18102(ProtoBuf$ValueParameter r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$18202(ProtoBuf$ValueParameter r5, int r10) {
        r5.name_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$18302(ProtoBuf$ValueParameter r5, ProtoBuf$Type r10) {
        r5.type_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$18402(ProtoBuf$ValueParameter r5, int r10) {
        r5.typeId_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$18502(ProtoBuf$ValueParameter r5, ProtoBuf$Type r10) {
        r5.varargElementType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$18602(ProtoBuf$ValueParameter r5, int r10) {
        r5.varargElementTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$18702(ProtoBuf$ValueParameter r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$18800(ProtoBuf$ValueParameter r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$ValueParameter getDefaultInstance() {
        return f19079a;
    }

    public static au.t newBuilder(ProtoBuf$ValueParameter r5) {
        au.t r10 = newBuilder();
        r10.i(r5);
        return r10;
    }

    public static ProtoBuf$ValueParameter parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$ValueParameter parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L6;
        return r5;
    L6:
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r10 = kotlinx.metadata.internal.protobuf.g.c(1, this.flags_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(2, this.name_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.e(3, this.type_);
    L16:
        if ((this.bitField0_ & 16) != 16) goto L19;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.e(4, this.varargElementType_);
    L19:
        if ((this.bitField0_ & 8) != 8) goto L22;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(5, this.typeId_);
    L22:
        if ((this.bitField0_ & 32) != 32) goto L24;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(6, this.varargElementTypeId_);
    L24:
        int r11 = extensionsSerializedSize() + r10;
        int r12 = this.unknownFields.size() + r11;
        this.memoizedSerializedSize = r12;
        return r12;
    L8:
        r10 = 0;
        goto L10
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

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L6;
        return true;
    L6:
        if (r5 != 0) goto L9;
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

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(kotlinx.metadata.internal.protobuf.g r5) throws IOException {
        getSerializedSize();
        kotlinx.metadata.internal.protobuf.o r10 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r5.n(1, this.flags_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r5.n(2, this.name_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L12;
        r5.p(3, this.type_);
    L12:
        if ((this.bitField0_ & 16) != 16) goto L15;
        r5.p(4, this.varargElementType_);
    L15:
        if ((this.bitField0_ & 8) != 8) goto L18;
        r5.n(5, this.typeId_);
    L18:
        if ((this.bitField0_ & 32) != 32) goto L20;
        r5.n(6, this.varargElementTypeId_);
    L20:
        r10.a(200, r5);
        r5.r(this.unknownFields);
    }

    public static au.t newBuilder() {
        au.t r5 = new au.t();
        r5.g = ProtoBuf$Type.getDefaultInstance();
        r5.f778i = ProtoBuf$Type.getDefaultInstance();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$ValueParameter getDefaultInstanceForType() {
        return f19079a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.t newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.t toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$ValueParameter parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$ValueParameter parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$ValueParameter() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$ValueParameter parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$ValueParameter(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean r13 = false;
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = ProtoBuf$Type.getDefaultInstance();
        this.typeId_ = 0;
        this.varargElementType_ = ProtoBuf$Type.getDefaultInstance();
        this.varargElementTypeId_ = 0;
        kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r14 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
    L3:
        if (r13 == true) goto L68;
        int r15 = r10.n();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r15 == 0) goto L20;
        if (r15 != 8) goto L9;
        this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.flags_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L9:
        if (r15 != 16) goto L10;
        this.bitField0_ |= 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.name_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L10:
        a0 r16 = null;
        if (r15 != 26) goto L13;
        if ((this.bitField0_ & 4) != 4) goto L39;
        r16 = this.type_.toBuilder();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L39:
        ProtoBuf$Type r17 = (ProtoBuf$Type) r10.g(ProtoBuf$Type.PARSER, r11);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.type_ = r17;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r16 == null) goto L42;
        r16.i(r17);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.type_ = r16.h();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L42:
        this.bitField0_ |= 4;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L13:
        if (r15 != 34) goto L15;
        if ((this.bitField0_ & 16) != 16) goto L32;
        r16 = this.varargElementType_.toBuilder();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L32:
        ProtoBuf$Type r18 = (ProtoBuf$Type) r10.g(ProtoBuf$Type.PARSER, r11);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.varargElementType_ = r18;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r16 == null) goto L35;
        r16.i(r18);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.varargElementType_ = r16.h();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
    L35:
        this.bitField0_ |= 16;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L15:
        if (r15 != 40) goto L17;
        this.bitField0_ |= 8;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.typeId_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L17:
        if (r15 != 48) goto L19;
        this.bitField0_ |= 32;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.varargElementTypeId_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L19:
        if (parseUnknownField(r10, r14, r11, r15) == true) goto L3;
    L20:
        r13 = true;
        goto L3
    L21:
        th = move-exception;
        r14.i();     // Catch: IOException -> L64 Throwable -> L52
    L52:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L51:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
        throw th;
    L23:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L25:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L68:
        r14.i();     // Catch: IOException -> L65 Throwable -> L59
    L59:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L58:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$ValueParameter parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$ValueParameter parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$ValueParameter parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$ValueParameter parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$ValueParameter parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$ValueParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
