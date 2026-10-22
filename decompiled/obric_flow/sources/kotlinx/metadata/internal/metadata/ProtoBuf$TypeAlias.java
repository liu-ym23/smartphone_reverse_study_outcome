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
public final class ProtoBuf$TypeAlias extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeAlias> implements au.r {
    public static final int ANNOTATION_FIELD_NUMBER = 8;
    public static final int EXPANDED_TYPE_FIELD_NUMBER = 6;
    public static final int EXPANDED_TYPE_ID_FIELD_NUMBER = 7;
    public static final int FLAGS_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int TYPE_PARAMETER_FIELD_NUMBER = 3;
    public static final int UNDERLYING_TYPE_FIELD_NUMBER = 4;
    public static final int UNDERLYING_TYPE_ID_FIELD_NUMBER = 5;
    public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$TypeAlias f19074a = null;
    private static final long serialVersionUID = 0;
    private List<ProtoBuf$Annotation> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private ProtoBuf$Type expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private int underlyingTypeId_;
    private ProtoBuf$Type underlyingType_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private List<Integer> versionRequirement_;

    static {
        PARSER = new au.b(14);
        ProtoBuf$TypeAlias r5 = new ProtoBuf$TypeAlias();
        f19074a = r5;
        r5.b();
    }

    public ProtoBuf$TypeAlias(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$19202(ProtoBuf$TypeAlias r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$19302(ProtoBuf$TypeAlias r5, int r10) {
        r5.name_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$19400(ProtoBuf$TypeAlias r5) {
        return r5.typeParameter_;
    }

    public static /* synthetic */ List access$19402(ProtoBuf$TypeAlias r5, List r10) {
        r5.typeParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$19502(ProtoBuf$TypeAlias r5, ProtoBuf$Type r10) {
        r5.underlyingType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$19602(ProtoBuf$TypeAlias r5, int r10) {
        r5.underlyingTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$19702(ProtoBuf$TypeAlias r5, ProtoBuf$Type r10) {
        r5.expandedType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$19802(ProtoBuf$TypeAlias r5, int r10) {
        r5.expandedTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$19900(ProtoBuf$TypeAlias r5) {
        return r5.annotation_;
    }

    public static /* synthetic */ List access$19902(ProtoBuf$TypeAlias r5, List r10) {
        r5.annotation_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$20000(ProtoBuf$TypeAlias r5) {
        return r5.versionRequirement_;
    }

    public static /* synthetic */ List access$20002(ProtoBuf$TypeAlias r5, List r10) {
        r5.versionRequirement_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$20102(ProtoBuf$TypeAlias r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$20200(ProtoBuf$TypeAlias r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$TypeAlias getDefaultInstance() {
        return f19074a;
    }

    public static au.q newBuilder(ProtoBuf$TypeAlias r5) {
        au.q r10 = newBuilder();
        r10.j(r5);
        return r10;
    }

    public static ProtoBuf$TypeAlias parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeAlias parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public final void b() {
        this.flags_ = 6;
        this.name_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.underlyingType_ = ProtoBuf$Type.getDefaultInstance();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = ProtoBuf$Type.getDefaultInstance();
        this.expandedTypeId_ = 0;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    public ProtoBuf$Annotation getAnnotation(int r5) {
        return this.annotation_.get(r5);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<ProtoBuf$Annotation> getAnnotationList() {
        return this.annotation_;
    }

    public i getAnnotationOrBuilder(int r5) {
        return this.annotation_.get(r5);
    }

    public List<? extends i> getAnnotationOrBuilderList() {
        return this.annotation_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public ProtoBuf$Type getExpandedType() {
        return this.expandedType_;
    }

    public int getExpandedTypeId() {
        return this.expandedTypeId_;
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
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.flags_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L12;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(2, this.name_);
    L12:
        int r12 = 0;
    L14:
        if (r12 >= this.typeParameter_.size()) goto L17;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(3, this.typeParameter_.get(r12));
        r12 = r12 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 4) != 4) goto L20;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(4, this.underlyingType_);
    L20:
        if ((this.bitField0_ & 8) != 8) goto L23;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(5, this.underlyingTypeId_);
    L23:
        if ((this.bitField0_ & 16) != 16) goto L26;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(6, this.expandedType_);
    L26:
        if ((this.bitField0_ & 32) != 32) goto L28;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(7, this.expandedTypeId_);
    L28:
        int r13 = 0;
    L30:
        if (r13 >= this.annotation_.size()) goto L32;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(8, this.annotation_.get(r13));
        r13 = r13 + 1;
        goto L30
    L32:
        int r14 = 0;
    L34:
        if (r10 >= this.versionRequirement_.size()) goto L36;
        r14 = androidx.room.jarjarred.org.antlr.runtime.a.f(r14, this.versionRequirement_.get(r10));
        r10 = r10 + 1;
        goto L34
    L36:
        int r15 = this.unknownFields.size() + (extensionsSerializedSize() + ((getVersionRequirementList().size() * 2) + (r11 + r14)));
        this.memoizedSerializedSize = r15;
        return r15;
    L8:
        r11 = 0;
        goto L10
    }

    public ProtoBuf$TypeParameter getTypeParameter(int r5) {
        return this.typeParameter_.get(r5);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public e0 getTypeParameterOrBuilder(int r5) {
        return this.typeParameter_.get(r5);
    }

    public List<? extends e0> getTypeParameterOrBuilderList() {
        return this.typeParameter_;
    }

    public ProtoBuf$Type getUnderlyingType() {
        return this.underlyingType_;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
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

    public boolean hasExpandedType() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasExpandedTypeId() {
        if ((this.bitField0_ & 32) != 32) goto L5;
        return true;
    L5:
        return false;
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

    public boolean hasUnderlyingType() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasUnderlyingTypeId() {
        if ((this.bitField0_ & 8) != 8) goto L5;
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
        if (hasName() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        int r10 = 0;
    L14:
        if (r10 >= getTypeParameterCount()) goto L21;
        if (getTypeParameter(r10).isInitialized() == false) goto L17;
        r10 = r10 + 1;
        goto L14
    L17:
        this.memoizedIsInitialized = 0;
        return false;
    L21:
        if (hasUnderlyingType() == false) goto L27;
        if (getUnderlyingType().isInitialized() == true) goto L27;
        this.memoizedIsInitialized = 0;
        return false;
    L27:
        if (hasExpandedType() == true) goto L29;
    L32:
        int r11 = 0;
    L34:
        if (r11 >= getAnnotationCount()) goto L41;
        if (getAnnotation(r11).isInitialized() == false) goto L37;
        r11 = r11 + 1;
        goto L34
    L37:
        this.memoizedIsInitialized = 0;
        return false;
    L41:
        if (extensionsAreInitialized() == true) goto L44;
        this.memoizedIsInitialized = 0;
        return false;
    L44:
        this.memoizedIsInitialized = 1;
        return true;
    L29:
        if (getExpandedType().isInitialized() == true) goto L32;
        this.memoizedIsInitialized = 0;
        return false;
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
        if ((this.bitField0_ & 1) != 1) goto L6;
        r10.n(1, this.flags_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L8;
        r10.n(2, this.name_);
    L8:
        int r11 = 0;
        int r12 = 0;
    L10:
        if (r12 >= this.typeParameter_.size()) goto L13;
        r10.p(3, this.typeParameter_.get(r12));
        r12 = r12 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r10.p(4, this.underlyingType_);
    L16:
        if ((this.bitField0_ & 8) != 8) goto L19;
        r10.n(5, this.underlyingTypeId_);
    L19:
        if ((this.bitField0_ & 16) != 16) goto L22;
        r10.p(6, this.expandedType_);
    L22:
        if ((this.bitField0_ & 32) != 32) goto L24;
        r10.n(7, this.expandedTypeId_);
    L24:
        int r13 = 0;
    L26:
        if (r13 >= this.annotation_.size()) goto L29;
        r10.p(8, this.annotation_.get(r13));
        r13 = r13 + 1;
    L29:
        if (r11 >= this.versionRequirement_.size()) goto L31;
        r10.n(31, this.versionRequirement_.get(r11).intValue());
        r11 = r11 + 1;
        goto L29
    L31:
        r5.a(200, r10);
        r10.r(this.unknownFields);
    }

    public static au.q newBuilder() {
        return au.q.i();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$TypeAlias getDefaultInstanceForType() {
        return f19074a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.q newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.q toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$TypeAlias parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$TypeAlias parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$TypeAlias() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$TypeAlias parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$TypeAlias(kotlinx.metadata.internal.protobuf.f r11, kotlinx.metadata.internal.protobuf.i r12, au.a r13) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        b();
        kotlinx.metadata.internal.protobuf.d r14 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r14, 1);
        boolean r10 = false;
        int r15 = 0;
    L4:
        if (r10 == true) goto L77;
        int r16 = r11.n();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        a0 r17 = null;
        switch(r16) {
            case 0: goto L9;
            case 8: goto L54;
            case 16: goto L53;
            case 26: goto L50;
            case 34: goto L43;
            case 40: goto L41;
            case 50: goto L35;
            case 56: goto L33;
            case 66: goto L30;
            case 248: goto L26;
            case 250: goto L16;
            default: goto L8;
        };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L9:
        r10 = true;
        goto L4
    L16:
        int r18 = r11.d(r11.k());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if ((r15 & 256) == 256) goto L22;
        if (r11.b() <= 0) goto L22;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r15 = r15 | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L22:
        if (r11.b() <= 0) goto L24;
        this.versionRequirement_.add(Integer.valueOf(r11.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L22
    L24:
        r11.c(r18);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L26:
        if ((r15 & 256) == 256) goto L28;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r15 = r15 | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L28:
        this.versionRequirement_.add(Integer.valueOf(r11.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L30:
        if ((r15 & 128) == 128) goto L32;
        this.annotation_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r15 = r15 | 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L32:
        this.annotation_.add((ProtoBuf$Annotation) r11.g(ProtoBuf$Annotation.PARSER, r12));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L33:
        this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.expandedTypeId_ = r11.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L35:
        if ((this.bitField0_ & 16) != 16) goto L37;
        r17 = this.expandedType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L37:
        ProtoBuf$Type r19 = (ProtoBuf$Type) r11.g(ProtoBuf$Type.PARSER, r12);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.expandedType_ = r19;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r17 == null) goto L40;
        r17.i(r19);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.expandedType_ = r17.h();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L40:
        this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L41:
        this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.underlyingTypeId_ = r11.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L43:
        if ((this.bitField0_ & 4) != 4) goto L45;
        r17 = this.underlyingType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L45:
        ProtoBuf$Type r20 = (ProtoBuf$Type) r11.g(ProtoBuf$Type.PARSER, r12);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.underlyingType_ = r20;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r17 == null) goto L48;
        r17.i(r20);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.underlyingType_ = r17.h();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L48:
        this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L50:
        if ((r15 & 4) == 4) goto L52;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r15 = r15 | 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L52:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r11.g(ProtoBuf$TypeParameter.PARSER, r12));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L53:
        this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.name_ = r11.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L54:
        this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.flags_ = r11.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L8:
        if (parseUnknownField(r11, r5, r12, r16) == true) goto L4;
    L10:
        th = move-exception;
        if ((r15 & 4) != 4) goto L64;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L64:
        if ((r15 & 128) != 128) goto L67;
        this.annotation_ = Collections.unmodifiableList(this.annotation_);
    L67:
        if ((r15 & 256) != 256) goto L95;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L95:
        r5.i();     // Catch: IOException -> L93 Throwable -> L71
    L71:
        th = move-exception;
        this.unknownFields = r14.e();
        throw th;
    L70:
        this.unknownFields = r14.e();
        makeExtensionsImmutable();
        throw th;
    L14:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L77:
        if ((r15 & 4) != 4) goto L80;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L80:
        if ((r15 & 128) != 128) goto L83;
        this.annotation_ = Collections.unmodifiableList(this.annotation_);
    L83:
        if ((r15 & 256) != 256) goto L97;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L97:
        r5.i();     // Catch: IOException -> L92 Throwable -> L87
    L87:
        th = move-exception;
        this.unknownFields = r14.e();
        throw th;
    L86:
        this.unknownFields = r14.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$TypeAlias parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$TypeAlias parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeAlias parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$TypeAlias parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeAlias parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeAlias) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
