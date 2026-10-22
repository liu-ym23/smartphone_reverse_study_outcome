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
public final class ProtoBuf$Constructor extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Constructor> implements au.f {
    public static final int FLAGS_FIELD_NUMBER = 1;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int VALUE_PARAMETER_FIELD_NUMBER = 2;
    public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Constructor f19046a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    static {
        PARSER = new au.b(2);
        ProtoBuf$Constructor r5 = new ProtoBuf$Constructor();
        f19046a = r5;
        r5.flags_ = 6;
        r5.valueParameter_ = Collections.emptyList();
        r5.versionRequirement_ = Collections.emptyList();
    }

    public ProtoBuf$Constructor(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$13502(ProtoBuf$Constructor r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$13600(ProtoBuf$Constructor r5) {
        return r5.valueParameter_;
    }

    public static /* synthetic */ List access$13602(ProtoBuf$Constructor r5, List r10) {
        r5.valueParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$13700(ProtoBuf$Constructor r5) {
        return r5.versionRequirement_;
    }

    public static /* synthetic */ List access$13702(ProtoBuf$Constructor r5, List r10) {
        r5.versionRequirement_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$13802(ProtoBuf$Constructor r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$13900(ProtoBuf$Constructor r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Constructor getDefaultInstance() {
        return f19046a;
    }

    public static au.e newBuilder(ProtoBuf$Constructor r5) {
        au.e r10 = newBuilder();
        r10.i(r5);
        return r10;
    }

    public static ProtoBuf$Constructor parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Constructor parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.flags_);
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.valueParameter_.size()) goto L13;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(2, this.valueParameter_.get(r12));
        r12 = r12 + 1;
        goto L11
    L13:
        int r13 = 0;
    L15:
        if (r10 >= this.versionRequirement_.size()) goto L17;
        r13 = androidx.room.jarjarred.org.antlr.runtime.a.f(r13, this.versionRequirement_.get(r10));
        r10 = r10 + 1;
        goto L15
    L17:
        int r14 = this.unknownFields.size() + (extensionsSerializedSize() + ((getVersionRequirementList().size() * 2) + (r11 + r13)));
        this.memoizedSerializedSize = r14;
        return r14;
    L8:
        r11 = 0;
        goto L9
    }

    public ProtoBuf$ValueParameter getValueParameter(int r5) {
        return this.valueParameter_.get(r5);
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
    }

    public List<ProtoBuf$ValueParameter> getValueParameterList() {
        return this.valueParameter_;
    }

    public au.u getValueParameterOrBuilder(int r5) {
        return this.valueParameter_.get(r5);
    }

    public List<? extends au.u> getValueParameterOrBuilderList() {
        return this.valueParameter_;
    }

    public int getVersionRequirement(int r5) {
        return this.versionRequirement_.get(r5).intValue();
    }

    public int getVersionRequirementCount() {
        return this.versionRequirement_.size();
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasFlags() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
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
        if (r10 >= getValueParameterCount()) goto L17;
        if (getValueParameter(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (extensionsAreInitialized() == true) goto L20;
        this.memoizedIsInitialized = 0;
        return false;
    L20:
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
    public void writeTo(kotlinx.metadata.internal.protobuf.g r10) throws IOException {
        getSerializedSize();
        kotlinx.metadata.internal.protobuf.o r5 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L5;
        r10.n(1, this.flags_);
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r12 >= this.valueParameter_.size()) goto L10;
        r10.p(2, this.valueParameter_.get(r12));
        r12 = r12 + 1;
    L10:
        if (r11 >= this.versionRequirement_.size()) goto L12;
        r10.n(31, this.versionRequirement_.get(r11).intValue());
        r11 = r11 + 1;
        goto L10
    L12:
        r5.a(19000, r10);
        r10.r(this.unknownFields);
    }

    public static au.e newBuilder() {
        au.e r5 = new au.e();
        r5.e = 6;
        r5.f = Collections.emptyList();
        r5.g = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Constructor getDefaultInstanceForType() {
        return f19046a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.e newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.e toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Constructor parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Constructor parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Constructor() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Constructor parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Constructor(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.flags_ = 6;
        this.valueParameter_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        int r15 = 0;
    L4:
        if (r14 == true) goto L61;
        int r16 = r10.n();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r16 == 0) goto L17;
        if (r16 != 8) goto L10;
        this.bitField0_ |= 1;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.flags_ = r10.k();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L10:
        if (r16 != 18) goto L12;
        if ((r15 & 2) == 2) goto L40;
        this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r15 = r15 | 2;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L40:
        this.valueParameter_.add((ProtoBuf$ValueParameter) r10.g(ProtoBuf$ValueParameter.PARSER, r11));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L12:
        if (r16 != 248) goto L14;
        if ((r15 & 4) == 4) goto L36;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r15 = r15 | 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L36:
        this.versionRequirement_.add(Integer.valueOf(r10.k()));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L14:
        if (r16 != 250) goto L16;
        int r17 = r10.d(r10.k());     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if ((r15 & 4) == 4) goto L30;
        if (r10.b() <= 0) goto L30;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r15 = r15 | 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L30:
        if (r10.b() <= 0) goto L32;
        this.versionRequirement_.add(Integer.valueOf(r10.k()));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L30
    L32:
        r10.c(r17);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L16:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L4;
    L17:
        r14 = true;
        goto L4
    L18:
        th = move-exception;
        if ((r15 & 2) != 2) goto L51;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L51:
        if ((r15 & 4) != 4) goto L79;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L79:
        r5.i();     // Catch: IOException -> L74 Throwable -> L55
    L55:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L54:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L22:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L18
    L20:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L18
    L61:
        if ((r15 & 2) != 2) goto L64;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L64:
        if ((r15 & 4) != 4) goto L77;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L77:
        r5.i();     // Catch: IOException -> L73 Throwable -> L68
    L68:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L67:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Constructor parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Constructor parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Constructor parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Constructor parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Constructor parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Constructor) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
