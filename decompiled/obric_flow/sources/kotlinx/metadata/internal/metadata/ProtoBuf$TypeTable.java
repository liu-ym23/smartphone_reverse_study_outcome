package kotlinx.metadata.internal.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBuf$TypeTable extends GeneratedMessageLite implements kotlinx.metadata.internal.protobuf.a0 {
    public static final int FIRST_NULLABLE_FIELD_NUMBER = 2;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$TypeTable f19078a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int firstNullable_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Type> type_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(16);
        ProtoBuf$TypeTable r5 = new ProtoBuf$TypeTable();
        f19078a = r5;
        r5.type_ = Collections.emptyList();
        r5.firstNullable_ = -1;
    }

    public ProtoBuf$TypeTable(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ List access$12800(ProtoBuf$TypeTable r5) {
        return r5.type_;
    }

    public static /* synthetic */ List access$12802(ProtoBuf$TypeTable r5, List r10) {
        r5.type_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$12902(ProtoBuf$TypeTable r5, int r10) {
        r5.firstNullable_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$13002(ProtoBuf$TypeTable r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$13100(ProtoBuf$TypeTable r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$TypeTable getDefaultInstance() {
        return f19078a;
    }

    public static au.s newBuilder(ProtoBuf$TypeTable r5) {
        au.s r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$TypeTable parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeTable parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFirstNullable() {
        return this.firstNullable_;
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
        if (r10 >= this.type_.size()) goto L10;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(1, this.type_.get(r10));
        r10 = r10 + 1;
        goto L7
    L10:
        if ((this.bitField0_ & 1) != 1) goto L12;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(2, this.firstNullable_);
    L12:
        int r12 = this.unknownFields.size() + r11;
        this.memoizedSerializedSize = r12;
        return r12;
    }

    public ProtoBuf$Type getType(int r5) {
        return this.type_.get(r5);
    }

    public int getTypeCount() {
        return this.type_.size();
    }

    public List<ProtoBuf$Type> getTypeList() {
        return this.type_;
    }

    public b0 getTypeOrBuilder(int r5) {
        return this.type_.get(r5);
    }

    public List<? extends b0> getTypeOrBuilderList() {
        return this.type_;
    }

    public boolean hasFirstNullable() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L6;
        return true;
    L6:
        if (r5 != 0) goto L8;
        return false;
    L8:
        int r10 = 0;
    L10:
        if (r10 >= getTypeCount()) goto L16;
        if (getType(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
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
        if (r10 >= this.type_.size()) goto L7;
        r5.p(1, this.type_.get(r10));
        r10 = r10 + 1;
        goto L4
    L7:
        if ((this.bitField0_ & 1) != 1) goto L9;
        r5.n(2, this.firstNullable_);
    L9:
        r5.r(this.unknownFields);
    }

    public static au.s newBuilder() {
        au.s r5 = new au.s();
        r5.f776c = Collections.emptyList();
        r5.d = -1;
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$TypeTable getDefaultInstanceForType() {
        return f19078a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.s newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.s toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$TypeTable parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$TypeTable parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$TypeTable() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$TypeTable parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$TypeTable(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.type_ = Collections.emptyList();
        this.firstNullable_ = -1;
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        boolean r15 = false;
    L3:
        if (r14 == true) goto L37;
        int r16 = r10.n();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        if (r16 == 0) goto L12;
        if (r16 != 10) goto L9;
        if (r15 == true) goto L22;
        this.type_ = new ArrayList();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        r15 = true;
    L22:
        this.type_.add((ProtoBuf$Type) r10.g(ProtoBuf$Type.PARSER, r11));     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        goto L3
    L9:
        if (r16 != 16) goto L11;
        this.bitField0_ |= 1;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        this.firstNullable_ = r10.k();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        goto L3
    L11:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L3;
    L12:
        r14 = true;
        goto L3
    L13:
        th = move-exception;
        if (r15 != true) goto L50;
        this.type_ = Collections.unmodifiableList(this.type_);
    L50:
        r5.i();     // Catch: IOException -> L47 Throwable -> L32
    L32:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L31:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L15:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L13
    L17:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
    L37:
        if (r15 != true) goto L52;
        this.type_ = Collections.unmodifiableList(this.type_);
    L52:
        r5.i();     // Catch: IOException -> L46 Throwable -> L41
    L41:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L40:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$TypeTable parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$TypeTable parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeTable parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$TypeTable parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeTable parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
