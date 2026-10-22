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
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Property> implements au.o {
    public static final int CONTEXT_RECEIVER_TYPE_FIELD_NUMBER = 12;
    public static final int CONTEXT_RECEIVER_TYPE_ID_FIELD_NUMBER = 13;
    public static final int FLAGS_FIELD_NUMBER = 11;
    public static final int GETTER_FLAGS_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int OLD_FLAGS_FIELD_NUMBER = 1;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int RECEIVER_TYPE_FIELD_NUMBER = 5;
    public static final int RECEIVER_TYPE_ID_FIELD_NUMBER = 10;
    public static final int RETURN_TYPE_FIELD_NUMBER = 3;
    public static final int RETURN_TYPE_ID_FIELD_NUMBER = 9;
    public static final int SETTER_FLAGS_FIELD_NUMBER = 8;
    public static final int SETTER_VALUE_PARAMETER_FIELD_NUMBER = 6;
    public static final int TYPE_PARAMETER_FIELD_NUMBER = 4;
    public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Property f19064a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private int setterFlags_;
    private ProtoBuf$ValueParameter setterValueParameter_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private List<Integer> versionRequirement_;

    static {
        PARSER = new au.b(10);
        ProtoBuf$Property r5 = new ProtoBuf$Property();
        f19064a = r5;
        r5.b();
    }

    public ProtoBuf$Property(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$16202(ProtoBuf$Property r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$16302(ProtoBuf$Property r5, int r10) {
        r5.oldFlags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$16402(ProtoBuf$Property r5, int r10) {
        r5.name_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$16502(ProtoBuf$Property r5, ProtoBuf$Type r10) {
        r5.returnType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$16602(ProtoBuf$Property r5, int r10) {
        r5.returnTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$16700(ProtoBuf$Property r5) {
        return r5.typeParameter_;
    }

    public static /* synthetic */ List access$16702(ProtoBuf$Property r5, List r10) {
        r5.typeParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$16802(ProtoBuf$Property r5, ProtoBuf$Type r10) {
        r5.receiverType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$16902(ProtoBuf$Property r5, int r10) {
        r5.receiverTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$17000(ProtoBuf$Property r5) {
        return r5.contextReceiverType_;
    }

    public static /* synthetic */ List access$17002(ProtoBuf$Property r5, List r10) {
        r5.contextReceiverType_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$17100(ProtoBuf$Property r5) {
        return r5.contextReceiverTypeId_;
    }

    public static /* synthetic */ List access$17102(ProtoBuf$Property r5, List r10) {
        r5.contextReceiverTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$ValueParameter access$17202(ProtoBuf$Property r5, ProtoBuf$ValueParameter r10) {
        r5.setterValueParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$17302(ProtoBuf$Property r5, int r10) {
        r5.getterFlags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$17402(ProtoBuf$Property r5, int r10) {
        r5.setterFlags_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$17500(ProtoBuf$Property r5) {
        return r5.versionRequirement_;
    }

    public static /* synthetic */ List access$17502(ProtoBuf$Property r5, List r10) {
        r5.versionRequirement_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$17602(ProtoBuf$Property r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$17700(ProtoBuf$Property r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Property getDefaultInstance() {
        return f19064a;
    }

    public static au.n newBuilder(ProtoBuf$Property r5) {
        au.n r10 = newBuilder();
        r10.j(r5);
        return r10;
    }

    public static ProtoBuf$Property parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Property parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public final void b() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = Collections.emptyList();
        this.contextReceiverTypeId_ = Collections.emptyList();
        this.setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = Collections.emptyList();
    }

    public ProtoBuf$Type getContextReceiverType(int r5) {
        return this.contextReceiverType_.get(r5);
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    public int getContextReceiverTypeId(int r5) {
        return this.contextReceiverTypeId_.get(r5).intValue();
    }

    public int getContextReceiverTypeIdCount() {
        return this.contextReceiverTypeId_.size();
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public b0 getContextReceiverTypeOrBuilder(int r5) {
        return this.contextReceiverType_.get(r5);
    }

    public List<? extends b0> getContextReceiverTypeOrBuilderList() {
        return this.contextReceiverType_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getGetterFlags() {
        return this.getterFlags_;
    }

    public int getName() {
        return this.name_;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    public ProtoBuf$Type getReceiverType() {
        return this.receiverType_;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public ProtoBuf$Type getReturnType() {
        return this.returnType_;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 2) != 2) goto L8;
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.oldFlags_);
    L10:
        if ((this.bitField0_ & 4) != 4) goto L13;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(2, this.name_);
    L13:
        if ((this.bitField0_ & 8) != 8) goto L15;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(3, this.returnType_);
    L15:
        int r12 = 0;
    L17:
        if (r12 >= this.typeParameter_.size()) goto L20;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(4, this.typeParameter_.get(r12));
        r12 = r12 + 1;
        goto L17
    L20:
        if ((this.bitField0_ & 32) != 32) goto L23;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(5, this.receiverType_);
    L23:
        if ((this.bitField0_ & 128) != 128) goto L26;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(6, this.setterValueParameter_);
    L26:
        if ((this.bitField0_ & 256) != 256) goto L29;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(7, this.getterFlags_);
    L29:
        if ((this.bitField0_ & 512) != 512) goto L32;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(8, this.setterFlags_);
    L32:
        if ((this.bitField0_ & 16) != 16) goto L35;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(9, this.returnTypeId_);
    L35:
        if ((this.bitField0_ & 64) != 64) goto L38;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(10, this.receiverTypeId_);
    L38:
        if ((this.bitField0_ & 1) != 1) goto L40;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(11, this.flags_);
    L40:
        int r13 = 0;
    L42:
        if (r13 >= this.contextReceiverType_.size()) goto L44;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(12, this.contextReceiverType_.get(r13));
        r13 = r13 + 1;
        goto L42
    L44:
        int r14 = 0;
        int r15 = 0;
    L46:
        if (r14 >= this.contextReceiverTypeId_.size()) goto L48;
        r15 = androidx.room.jarjarred.org.antlr.runtime.a.f(r15, this.contextReceiverTypeId_.get(r14));
        r14 = r14 + 1;
        goto L46
    L48:
        int r16 = r11 + r15;
        if (getContextReceiverTypeIdList().isEmpty() == true) goto L51;
        r16 = (r16 + 1) + kotlinx.metadata.internal.protobuf.g.d(r15);
    L51:
        this.contextReceiverTypeIdMemoizedSerializedSize = r15;
        int r17 = 0;
    L53:
        if (r10 >= this.versionRequirement_.size()) goto L55;
        r17 = androidx.room.jarjarred.org.antlr.runtime.a.f(r17, this.versionRequirement_.get(r10));
        r10 = r10 + 1;
        goto L53
    L55:
        int r18 = this.unknownFields.size() + (extensionsSerializedSize() + ((getVersionRequirementList().size() * 2) + (r16 + r17)));
        this.memoizedSerializedSize = r18;
        return r18;
    L8:
        r11 = 0;
        goto L10
    }

    public int getSetterFlags() {
        return this.setterFlags_;
    }

    public ProtoBuf$ValueParameter getSetterValueParameter() {
        return this.setterValueParameter_;
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

    public boolean hasGetterFlags() {
        if ((this.bitField0_ & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasName() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasOldFlags() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasReceiverType() {
        if ((this.bitField0_ & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasReceiverTypeId() {
        if ((this.bitField0_ & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasReturnType() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasReturnTypeId() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasSetterFlags() {
        if ((this.bitField0_ & 512) != 512) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasSetterValueParameter() {
        if ((this.bitField0_ & 128) != 128) goto L5;
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
        if (hasReturnType() == true) goto L15;
    L18:
        int r10 = 0;
    L20:
        if (r10 >= getTypeParameterCount()) goto L27;
        if (getTypeParameter(r10).isInitialized() == false) goto L23;
        r10 = r10 + 1;
        goto L20
    L23:
        this.memoizedIsInitialized = 0;
        return false;
    L27:
        if (hasReceiverType() == true) goto L29;
    L32:
        int r11 = 0;
    L34:
        if (r11 >= getContextReceiverTypeCount()) goto L41;
        if (getContextReceiverType(r11).isInitialized() == false) goto L37;
        r11 = r11 + 1;
        goto L34
    L37:
        this.memoizedIsInitialized = 0;
        return false;
    L41:
        if (hasSetterValueParameter() == false) goto L47;
        if (getSetterValueParameter().isInitialized() == true) goto L47;
        this.memoizedIsInitialized = 0;
        return false;
    L47:
        if (extensionsAreInitialized() == true) goto L50;
        this.memoizedIsInitialized = 0;
        return false;
    L50:
        this.memoizedIsInitialized = 1;
        return true;
    L29:
        if (getReceiverType().isInitialized() == true) goto L32;
        this.memoizedIsInitialized = 0;
        return false;
    L15:
        if (getReturnType().isInitialized() == true) goto L18;
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
        if ((this.bitField0_ & 2) != 2) goto L6;
        r10.n(1, this.oldFlags_);
    L6:
        if ((this.bitField0_ & 4) != 4) goto L9;
        r10.n(2, this.name_);
    L9:
        if ((this.bitField0_ & 8) != 8) goto L11;
        r10.p(3, this.returnType_);
    L11:
        int r11 = 0;
        int r12 = 0;
    L13:
        if (r12 >= this.typeParameter_.size()) goto L16;
        r10.p(4, this.typeParameter_.get(r12));
        r12 = r12 + 1;
        goto L13
    L16:
        if ((this.bitField0_ & 32) != 32) goto L19;
        r10.p(5, this.receiverType_);
    L19:
        if ((this.bitField0_ & 128) != 128) goto L22;
        r10.p(6, this.setterValueParameter_);
    L22:
        if ((this.bitField0_ & 256) != 256) goto L25;
        r10.n(7, this.getterFlags_);
    L25:
        if ((this.bitField0_ & 512) != 512) goto L28;
        r10.n(8, this.setterFlags_);
    L28:
        if ((this.bitField0_ & 16) != 16) goto L31;
        r10.n(9, this.returnTypeId_);
    L31:
        if ((this.bitField0_ & 64) != 64) goto L34;
        r10.n(10, this.receiverTypeId_);
    L34:
        if ((this.bitField0_ & 1) != 1) goto L36;
        r10.n(11, this.flags_);
    L36:
        int r13 = 0;
    L38:
        if (r13 >= this.contextReceiverType_.size()) goto L41;
        r10.p(12, this.contextReceiverType_.get(r13));
        r13 = r13 + 1;
        goto L38
    L41:
        if (getContextReceiverTypeIdList().size() <= 0) goto L43;
        r10.v(106);
        r10.v(this.contextReceiverTypeIdMemoizedSerializedSize);
    L43:
        int r14 = 0;
    L45:
        if (r14 >= this.contextReceiverTypeId_.size()) goto L48;
        r10.o(this.contextReceiverTypeId_.get(r14).intValue());
        r14 = r14 + 1;
    L48:
        if (r11 >= this.versionRequirement_.size()) goto L50;
        r10.n(31, this.versionRequirement_.get(r11).intValue());
        r11 = r11 + 1;
        goto L48
    L50:
        r5.a(19000, r10);
        r10.r(this.unknownFields);
    }

    public static au.n newBuilder() {
        return au.n.i();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Property getDefaultInstanceForType() {
        return f19064a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.n newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.n toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Property parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Property parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Property() {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Property parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Property(kotlinx.metadata.internal.protobuf.f r12, kotlinx.metadata.internal.protobuf.i r13, au.a r14) throws InvalidProtocolBufferException {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        b();
        kotlinx.metadata.internal.protobuf.d r15 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r15, 1);
        boolean r10 = false;
        int r11 = 0;
    L4:
        if (r10 == true) goto L103;
        int r16 = r12.n();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        a0 r17 = null;
        au.t r18 = null;
        a0 r19 = null;
        switch(r16) {
            case 0: goto L9;
            case 8: goto L77;
            case 16: goto L76;
            case 26: goto L70;
            case 34: goto L65;
            case 42: goto L59;
            case 50: goto L52;
            case 56: goto L50;
            case 64: goto L49;
            case 72: goto L48;
            case 80: goto L47;
            case 88: goto L46;
            case 98: goto L42;
            case 104: goto L38;
            case 106: goto L29;
            case 248: goto L25;
            case 250: goto L16;
            default: goto L8;
        };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L9:
        r10 = true;
        goto L4
    L16:
        int r20 = r12.d(r12.k());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        int r21 = (r11 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r21 == 8192) goto L22;
        r11 = r11;
        if (r12.b() <= 0) goto L22;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L22:
        if (r12.b() <= 0) goto L24;
        this.versionRequirement_.add(Integer.valueOf(r12.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L22
    L24:
        r12.c(r20);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L25:
        int r22 = (r11 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r22 == 8192) goto L28;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L28:
        this.versionRequirement_.add(Integer.valueOf(r12.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L29:
        int r23 = r12.d(r12.k());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        int r24 = (r11 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r24 == 512) goto L35;
        r11 = r11;
        if (r12.b() <= 0) goto L35;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L35:
        if (r12.b() <= 0) goto L37;
        this.contextReceiverTypeId_.add(Integer.valueOf(r12.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L35
    L37:
        r12.c(r23);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L38:
        int r25 = (r11 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r25 == 512) goto L41;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L41:
        this.contextReceiverTypeId_.add(Integer.valueOf(r12.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L42:
        int r26 = (r11 == true ? 1 : 0) & 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r26 == 256) goto L45;
        this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L45:
        this.contextReceiverType_.add((ProtoBuf$Type) r12.g(ProtoBuf$Type.PARSER, r13));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L46:
        this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.flags_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L47:
        this.bitField0_ |= 64;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.receiverTypeId_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L48:
        this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.returnTypeId_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L49:
        this.bitField0_ |= 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.setterFlags_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L50:
        this.bitField0_ |= 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.getterFlags_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L52:
        if ((this.bitField0_ & 128) != 128) goto L54;
        r18 = this.setterValueParameter_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L54:
        ProtoBuf$ValueParameter r27 = (ProtoBuf$ValueParameter) r12.g(ProtoBuf$ValueParameter.PARSER, r13);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.setterValueParameter_ = r27;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r18 == null) goto L57;
        r18.i(r27);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.setterValueParameter_ = r18.h();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L57:
        this.bitField0_ |= 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L59:
        if ((this.bitField0_ & 32) != 32) goto L61;
        r19 = this.receiverType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L61:
        ProtoBuf$Type r28 = (ProtoBuf$Type) r12.g(ProtoBuf$Type.PARSER, r13);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.receiverType_ = r28;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r19 == null) goto L64;
        r19.i(r28);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.receiverType_ = r19.h();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L64:
        this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L65:
        int r29 = (r11 == true ? 1 : 0) & 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r29 == 32) goto L68;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L68:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r12.g(ProtoBuf$TypeParameter.PARSER, r13));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L70:
        if ((this.bitField0_ & 8) != 8) goto L72;
        r17 = this.returnType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L72:
        ProtoBuf$Type r30 = (ProtoBuf$Type) r12.g(ProtoBuf$Type.PARSER, r13);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.returnType_ = r30;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r17 == null) goto L75;
        r17.i(r30);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.returnType_ = r17.h();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L75:
        this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L76:
        this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.name_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L77:
        this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.oldFlags_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L8:
        if (parseUnknownField(r12, r5, r13, r16) == true) goto L4;
    L10:
        th = move-exception;
        if (((r11 == true ? 1 : 0) & 32) != 32) goto L87;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L87:
        if (((r11 == true ? 1 : 0) & 256) != 256) goto L90;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L90:
        if (((r11 == true ? 1 : 0) & 512) != 512) goto L93;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L93:
        if (((r11 == true ? 1 : 0) & 8192) != 8192) goto L125;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L125:
        r5.i();     // Catch: IOException -> L122 Throwable -> L97
    L97:
        th = move-exception;
        this.unknownFields = r15.e();
        throw th;
    L96:
        this.unknownFields = r15.e();
        makeExtensionsImmutable();
        throw th;
    L12:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L103:
        if (((r11 == true ? 1 : 0) & 32) != 32) goto L106;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L106:
        if (((r11 == true ? 1 : 0) & 256) != 256) goto L109;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L109:
        if (((r11 == true ? 1 : 0) & 512) != 512) goto L112;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L112:
        if (((r11 == true ? 1 : 0) & 8192) != 8192) goto L127;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L127:
        r5.i();     // Catch: IOException -> L121 Throwable -> L116
    L116:
        th = move-exception;
        this.unknownFields = r15.e();
        throw th;
    L115:
        this.unknownFields = r15.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Property parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Property parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Property parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Property parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Property parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Property) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
