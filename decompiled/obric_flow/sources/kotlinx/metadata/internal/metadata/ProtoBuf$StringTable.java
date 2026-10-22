package kotlinx.metadata.internal.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBuf$StringTable extends GeneratedMessageLite implements kotlinx.metadata.internal.protobuf.a0 {
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$StringTable f19069a = null;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private kotlinx.metadata.internal.protobuf.v string_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(12);
        ProtoBuf$StringTable r5 = new ProtoBuf$StringTable();
        f19069a = r5;
        r5.string_ = kotlinx.metadata.internal.protobuf.u.f19207b;
    }

    public ProtoBuf$StringTable(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.v access$300(ProtoBuf$StringTable r5) {
        return r5.string_;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.v access$302(ProtoBuf$StringTable r5, kotlinx.metadata.internal.protobuf.v r10) {
        r5.string_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$400(ProtoBuf$StringTable r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$StringTable getDefaultInstance() {
        return f19069a;
    }

    public static au.p newBuilder(ProtoBuf$StringTable r5) {
        au.p r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$StringTable parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$StringTable parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= this.string_.size()) goto L9;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.a(this.string_.getByteString(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        int r12 = this.unknownFields.size() + (getStringList().size() + r11);
        this.memoizedSerializedSize = r12;
        return r12;
    }

    public String getString(int r5) {
        return (String) this.string_.get(r5);
    }

    public kotlinx.metadata.internal.protobuf.e getStringBytes(int r5) {
        return this.string_.getByteString(r5);
    }

    public int getStringCount() {
        return this.string_.size();
    }

    public kotlinx.metadata.internal.protobuf.c0 getStringList() {
        return this.string_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
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

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(kotlinx.metadata.internal.protobuf.g r5) throws IOException {
        getSerializedSize();
        int r10 = 0;
    L4:
        if (r10 >= this.string_.size()) goto L6;
        r5.l(1, this.string_.getByteString(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        r5.r(this.unknownFields);
    }

    public static au.p newBuilder() {
        au.p r5 = new au.p();
        r5.f768c = kotlinx.metadata.internal.protobuf.u.f19207b;
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$StringTable getDefaultInstanceForType() {
        return f19069a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.p newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.p toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$StringTable parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$StringTable parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$StringTable() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$StringTable parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$StringTable(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.string_ = kotlinx.metadata.internal.protobuf.u.f19207b;
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        boolean r15 = false;
    L3:
        if (r14 == true) goto L35;
        int r16 = r10.n();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if (r16 == 0) goto L10;
        if (r16 != 10) goto L9;
        kotlinx.metadata.internal.protobuf.x r17 = r10.e();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if (r15 == true) goto L20;
        this.string_ = new kotlinx.metadata.internal.protobuf.u();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r15 = true;
    L20:
        this.string_.a(r17);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L3
    L9:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L3;
    L10:
        r14 = true;
        goto L3
    L11:
        th = move-exception;
        if (r15 != true) goto L48;
        this.string_ = this.string_.getUnmodifiableView();
    L48:
        r5.i();     // Catch: IOException -> L45 Throwable -> L30
    L30:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L29:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L15:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L35:
        if (r15 != true) goto L50;
        this.string_ = this.string_.getUnmodifiableView();
    L50:
        r5.i();     // Catch: IOException -> L44 Throwable -> L39
    L39:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L38:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$StringTable parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$StringTable parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$StringTable parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$StringTable parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$StringTable parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$StringTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
