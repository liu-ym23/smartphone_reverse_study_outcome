package kotlinx.metadata.internal.metadata.jvm;

import bu.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.b0;
import kotlinx.metadata.internal.protobuf.g;
import kotlinx.metadata.internal.protobuf.i;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmProtoBuf$JvmFieldSignature extends GeneratedMessageLite implements a0 {
    public static final int DESC_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static b0 PARSER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JvmProtoBuf$JvmFieldSignature f19119a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int desc_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(22);
        JvmProtoBuf$JvmFieldSignature r5 = new JvmProtoBuf$JvmFieldSignature();
        f19119a = r5;
        r5.name_ = 0;
        r5.desc_ = 0;
    }

    public JvmProtoBuf$JvmFieldSignature(m r5, bu.e r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$2702(JvmProtoBuf$JvmFieldSignature r5, int r10) {
        r5.name_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2802(JvmProtoBuf$JvmFieldSignature r5, int r10) {
        r5.desc_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2902(JvmProtoBuf$JvmFieldSignature r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$3000(JvmProtoBuf$JvmFieldSignature r5) {
        return r5.unknownFields;
    }

    public static JvmProtoBuf$JvmFieldSignature getDefaultInstance() {
        return f19119a;
    }

    public static f newBuilder(JvmProtoBuf$JvmFieldSignature r5) {
        f r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static JvmProtoBuf$JvmFieldSignature parseDelimitedFrom(InputStream r5) throws IOException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getDesc() {
        return this.desc_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L6;
        return r5;
    L6:
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r10 = g.c(1, this.name_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L12;
        r10 = r10 + g.c(2, this.desc_);
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
    public /* bridge */ /* synthetic */ y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(g r5) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r5.n(1, this.name_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L8;
        r5.n(2, this.desc_);
    L8:
        r5.r(this.unknownFields);
    }

    public static f newBuilder() {
        return new f();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public JvmProtoBuf$JvmFieldSignature getDefaultInstanceForType() {
        return f19119a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public f newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public f toBuilder() {
        return newBuilder(this);
    }

    public static JvmProtoBuf$JvmFieldSignature parseDelimitedFrom(InputStream r5, i r10) throws IOException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(kotlinx.metadata.internal.protobuf.e r5, i r10) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public JvmProtoBuf$JvmFieldSignature() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public JvmProtoBuf$JvmFieldSignature(kotlinx.metadata.internal.protobuf.f r10, i r11, bu.e r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean r13 = false;
        this.name_ = 0;
        this.desc_ = 0;
        kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
        g r14 = g.j(r5, 1);
    L3:
        if (r13 == true) goto L43;
        int r15 = r10.n();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        if (r15 == 0) goto L12;
        if (r15 != 8) goto L9;
        this.bitField0_ |= 1;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        this.name_ = r10.k();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        goto L3
    L9:
        if (r15 != 16) goto L11;
        this.bitField0_ |= 2;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        this.desc_ = r10.k();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        goto L3
    L11:
        if (parseUnknownField(r10, r14, r11, r15) == true) goto L3;
    L12:
        r13 = true;
        goto L3
    L13:
        th = move-exception;
        r14.i();     // Catch: IOException -> L40 Throwable -> L28
    L28:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L27:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
        throw th;
    L17:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
    L15:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L13
    L43:
        r14.i();     // Catch: IOException -> L41 Throwable -> L35
    L35:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L34:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(byte[] r5, i r10) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(InputStream r5) throws IOException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(InputStream r5, i r10) throws IOException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$JvmFieldSignature parseFrom(kotlinx.metadata.internal.protobuf.f r5, i r10) throws IOException {
        return (JvmProtoBuf$JvmFieldSignature) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
