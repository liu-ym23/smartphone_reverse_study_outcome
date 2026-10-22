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
public final class ProtoBuf$Function extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Function> implements au.k {
    public static final int CONTEXT_RECEIVER_TYPE_FIELD_NUMBER = 10;
    public static final int CONTEXT_RECEIVER_TYPE_ID_FIELD_NUMBER = 11;
    public static final int CONTRACT_FIELD_NUMBER = 32;
    public static final int FLAGS_FIELD_NUMBER = 9;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int OLD_FLAGS_FIELD_NUMBER = 1;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int RECEIVER_TYPE_FIELD_NUMBER = 5;
    public static final int RECEIVER_TYPE_ID_FIELD_NUMBER = 8;
    public static final int RETURN_TYPE_FIELD_NUMBER = 3;
    public static final int RETURN_TYPE_ID_FIELD_NUMBER = 7;
    public static final int TYPE_PARAMETER_FIELD_NUMBER = 4;
    public static final int TYPE_TABLE_FIELD_NUMBER = 30;
    public static final int VALUE_PARAMETER_FIELD_NUMBER = 6;
    public static final int VERSION_REQUIREMENT_FIELD_NUMBER = 31;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Function f19057a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private ProtoBuf$Contract contract_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private ProtoBuf$TypeTable typeTable_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    static {
        PARSER = new au.b(7);
        ProtoBuf$Function r5 = new ProtoBuf$Function();
        f19057a = r5;
        r5.b();
    }

    public ProtoBuf$Function(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$14302(ProtoBuf$Function r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$14402(ProtoBuf$Function r5, int r10) {
        r5.oldFlags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$14502(ProtoBuf$Function r5, int r10) {
        r5.name_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$14602(ProtoBuf$Function r5, ProtoBuf$Type r10) {
        r5.returnType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$14702(ProtoBuf$Function r5, int r10) {
        r5.returnTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$14800(ProtoBuf$Function r5) {
        return r5.typeParameter_;
    }

    public static /* synthetic */ List access$14802(ProtoBuf$Function r5, List r10) {
        r5.typeParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$14902(ProtoBuf$Function r5, ProtoBuf$Type r10) {
        r5.receiverType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$15002(ProtoBuf$Function r5, int r10) {
        r5.receiverTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$15100(ProtoBuf$Function r5) {
        return r5.contextReceiverType_;
    }

    public static /* synthetic */ List access$15102(ProtoBuf$Function r5, List r10) {
        r5.contextReceiverType_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$15200(ProtoBuf$Function r5) {
        return r5.contextReceiverTypeId_;
    }

    public static /* synthetic */ List access$15202(ProtoBuf$Function r5, List r10) {
        r5.contextReceiverTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$15300(ProtoBuf$Function r5) {
        return r5.valueParameter_;
    }

    public static /* synthetic */ List access$15302(ProtoBuf$Function r5, List r10) {
        r5.valueParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$TypeTable access$15402(ProtoBuf$Function r5, ProtoBuf$TypeTable r10) {
        r5.typeTable_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$15500(ProtoBuf$Function r5) {
        return r5.versionRequirement_;
    }

    public static /* synthetic */ List access$15502(ProtoBuf$Function r5, List r10) {
        r5.versionRequirement_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Contract access$15602(ProtoBuf$Function r5, ProtoBuf$Contract r10) {
        r5.contract_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$15702(ProtoBuf$Function r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$15800(ProtoBuf$Function r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Function getDefaultInstance() {
        return f19057a;
    }

    public static au.j newBuilder(ProtoBuf$Function r5) {
        au.j r10 = newBuilder();
        r10.j(r5);
        return r10;
    }

    public static ProtoBuf$Function parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Function parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public final void b() {
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = Collections.emptyList();
        this.contextReceiverTypeId_ = Collections.emptyList();
        this.valueParameter_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.contract_ = ProtoBuf$Contract.getDefaultInstance();
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

    public ProtoBuf$Contract getContract() {
        return this.contract_;
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
        if ((this.bitField0_ & 32) != 32) goto L22;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(5, this.receiverType_);
    L22:
        int r13 = 0;
    L24:
        if (r13 >= this.valueParameter_.size()) goto L27;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(6, this.valueParameter_.get(r13));
        r13 = r13 + 1;
        goto L24
    L27:
        if ((this.bitField0_ & 16) != 16) goto L30;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(7, this.returnTypeId_);
    L30:
        if ((this.bitField0_ & 64) != 64) goto L33;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(8, this.receiverTypeId_);
    L33:
        if ((this.bitField0_ & 1) != 1) goto L35;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(9, this.flags_);
    L35:
        int r14 = 0;
    L37:
        if (r14 >= this.contextReceiverType_.size()) goto L39;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(10, this.contextReceiverType_.get(r14));
        r14 = r14 + 1;
        goto L37
    L39:
        int r15 = 0;
        int r16 = 0;
    L41:
        if (r15 >= this.contextReceiverTypeId_.size()) goto L43;
        r16 = androidx.room.jarjarred.org.antlr.runtime.a.f(r16, this.contextReceiverTypeId_.get(r15));
        r15 = r15 + 1;
        goto L41
    L43:
        int r17 = r11 + r16;
        if (getContextReceiverTypeIdList().isEmpty() == true) goto L46;
        r17 = (r17 + 1) + kotlinx.metadata.internal.protobuf.g.d(r16);
    L46:
        this.contextReceiverTypeIdMemoizedSerializedSize = r16;
        if ((this.bitField0_ & 128) != 128) goto L49;
        r17 = r17 + kotlinx.metadata.internal.protobuf.g.e(30, this.typeTable_);
    L49:
        int r18 = 0;
    L51:
        if (r10 >= this.versionRequirement_.size()) goto L53;
        r18 = androidx.room.jarjarred.org.antlr.runtime.a.f(r18, this.versionRequirement_.get(r10));
        r10 = r10 + 1;
        goto L51
    L53:
        int r19 = (getVersionRequirementList().size() * 2) + (r17 + r18);
        if ((this.bitField0_ & 256) != 256) goto L56;
        r19 = r19 + kotlinx.metadata.internal.protobuf.g.e(32, this.contract_);
    L56:
        int r20 = this.unknownFields.size() + (extensionsSerializedSize() + r19);
        this.memoizedSerializedSize = r20;
        return r20;
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

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
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

    public boolean hasContract() {
        if ((this.bitField0_ & 256) != 256) goto L5;
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

    public boolean hasTypeTable() {
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
        if (r11 >= getContextReceiverTypeCount()) goto L40;
        if (getContextReceiverType(r11).isInitialized() == false) goto L37;
        r11 = r11 + 1;
        goto L34
    L37:
        this.memoizedIsInitialized = 0;
        return false;
    L40:
        int r12 = 0;
    L42:
        if (r12 >= getValueParameterCount()) goto L49;
        if (getValueParameter(r12).isInitialized() == false) goto L45;
        r12 = r12 + 1;
        goto L42
    L45:
        this.memoizedIsInitialized = 0;
        return false;
    L49:
        if (hasTypeTable() == false) goto L55;
        if (getTypeTable().isInitialized() == true) goto L55;
        this.memoizedIsInitialized = 0;
        return false;
    L55:
        if (hasContract() == false) goto L61;
        if (getContract().isInitialized() == true) goto L61;
        this.memoizedIsInitialized = 0;
        return false;
    L61:
        if (extensionsAreInitialized() == true) goto L64;
        this.memoizedIsInitialized = 0;
        return false;
    L64:
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
        if ((this.bitField0_ & 32) != 32) goto L18;
        r10.p(5, this.receiverType_);
    L18:
        int r13 = 0;
    L20:
        if (r13 >= this.valueParameter_.size()) goto L23;
        r10.p(6, this.valueParameter_.get(r13));
        r13 = r13 + 1;
        goto L20
    L23:
        if ((this.bitField0_ & 16) != 16) goto L26;
        r10.n(7, this.returnTypeId_);
    L26:
        if ((this.bitField0_ & 64) != 64) goto L29;
        r10.n(8, this.receiverTypeId_);
    L29:
        if ((this.bitField0_ & 1) != 1) goto L31;
        r10.n(9, this.flags_);
    L31:
        int r14 = 0;
    L33:
        if (r14 >= this.contextReceiverType_.size()) goto L36;
        r10.p(10, this.contextReceiverType_.get(r14));
        r14 = r14 + 1;
        goto L33
    L36:
        if (getContextReceiverTypeIdList().size() <= 0) goto L38;
        r10.v(90);
        r10.v(this.contextReceiverTypeIdMemoizedSerializedSize);
    L38:
        int r15 = 0;
    L40:
        if (r15 >= this.contextReceiverTypeId_.size()) goto L43;
        r10.o(this.contextReceiverTypeId_.get(r15).intValue());
        r15 = r15 + 1;
        goto L40
    L43:
        if ((this.bitField0_ & 128) != 128) goto L46;
        r10.p(30, this.typeTable_);
    L46:
        if (r11 >= this.versionRequirement_.size()) goto L49;
        r10.n(31, this.versionRequirement_.get(r11).intValue());
        r11 = r11 + 1;
        goto L46
    L49:
        if ((this.bitField0_ & 256) != 256) goto L51;
        r10.p(32, this.contract_);
    L51:
        r5.a(19000, r10);
        r10.r(this.unknownFields);
    }

    public static au.j newBuilder() {
        return au.j.i();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Function getDefaultInstanceForType() {
        return f19057a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.j newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.j toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Function parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Function parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Function() {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Function parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Function(kotlinx.metadata.internal.protobuf.f r13, kotlinx.metadata.internal.protobuf.i r14, au.a r15) throws InvalidProtocolBufferException {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        b();
        kotlinx.metadata.internal.protobuf.d r16 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r16, 1);
        boolean r10 = false;
        int r11 = 0;
    L4:
        if (r10 == true) goto L115;
        int r12 = r13.n();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        a0 r17 = null;
        au.g r18 = null;
        au.s r19 = null;
        a0 r110 = null;
        switch(r12) {
            case 0: goto L9;
            case 8: goto L86;
            case 16: goto L85;
            case 26: goto L79;
            case 34: goto L74;
            case 42: goto L68;
            case 50: goto L63;
            case 56: goto L62;
            case 64: goto L61;
            case 72: goto L60;
            case 82: goto L56;
            case 88: goto L52;
            case 90: goto L43;
            case 242: goto L37;
            case 248: goto L32;
            case 250: goto L23;
            case 258: goto L17;
            default: goto L8;
        };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L9:
        r10 = true;
        goto L4
    L17:
        if ((this.bitField0_ & 256) != 256) goto L19;
        r18 = this.contract_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L19:
        ProtoBuf$Contract r20 = (ProtoBuf$Contract) r13.g(ProtoBuf$Contract.PARSER, r14);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.contract_ = r20;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r18 == null) goto L22;
        r18.g(r20);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.contract_ = r18.f();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L22:
        this.bitField0_ |= 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L23:
        int r21 = r13.d(r13.k());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        int r111 = (r11 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r111 == 4096) goto L29;
        r11 = r11;
        if (r13.b() <= 0) goto L29;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L29:
        if (r13.b() <= 0) goto L31;
        this.versionRequirement_.add(Integer.valueOf(r13.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L29
    L31:
        r13.c(r21);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L32:
        int r22 = (r11 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r22 == 4096) goto L35;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L35:
        this.versionRequirement_.add(Integer.valueOf(r13.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L37:
        if ((this.bitField0_ & 128) != 128) goto L39;
        r19 = this.typeTable_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L39:
        ProtoBuf$TypeTable r23 = (ProtoBuf$TypeTable) r13.g(ProtoBuf$TypeTable.PARSER, r14);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.typeTable_ = r23;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r19 == null) goto L42;
        r19.g(r23);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.typeTable_ = r19.f();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L42:
        this.bitField0_ |= 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L43:
        int r24 = r13.d(r13.k());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        int r112 = (r11 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r112 == 512) goto L49;
        r11 = r11;
        if (r13.b() <= 0) goto L49;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L49:
        if (r13.b() <= 0) goto L51;
        this.contextReceiverTypeId_.add(Integer.valueOf(r13.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L49
    L51:
        r13.c(r24);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L52:
        int r25 = (r11 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r25 == 512) goto L55;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L55:
        this.contextReceiverTypeId_.add(Integer.valueOf(r13.k()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L56:
        int r26 = (r11 == true ? 1 : 0) & 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r26 == 256) goto L59;
        this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L59:
        this.contextReceiverType_.add((ProtoBuf$Type) r13.g(ProtoBuf$Type.PARSER, r14));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L60:
        this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.flags_ = r13.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L61:
        this.bitField0_ |= 64;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.receiverTypeId_ = r13.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L62:
        this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.returnTypeId_ = r13.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L63:
        int r27 = (r11 == true ? 1 : 0) & 1024;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r27 == 1024) goto L66;
        this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 1024;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L66:
        this.valueParameter_.add((ProtoBuf$ValueParameter) r13.g(ProtoBuf$ValueParameter.PARSER, r14));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L68:
        if ((this.bitField0_ & 32) != 32) goto L70;
        r110 = this.receiverType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L70:
        ProtoBuf$Type r28 = (ProtoBuf$Type) r13.g(ProtoBuf$Type.PARSER, r14);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.receiverType_ = r28;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r110 == null) goto L73;
        r110.i(r28);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.receiverType_ = r110.h();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L73:
        this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L74:
        int r29 = (r11 == true ? 1 : 0) & 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = r11;
        if (r29 == 32) goto L77;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        r11 = (r11 == true ? 1 : 0) | 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L77:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r13.g(ProtoBuf$TypeParameter.PARSER, r14));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L79:
        if ((this.bitField0_ & 8) != 8) goto L81;
        r17 = this.returnType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L81:
        ProtoBuf$Type r30 = (ProtoBuf$Type) r13.g(ProtoBuf$Type.PARSER, r14);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.returnType_ = r30;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        if (r17 == null) goto L84;
        r17.i(r30);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.returnType_ = r17.h();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
    L84:
        this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L85:
        this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.name_ = r13.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L86:
        this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        this.oldFlags_ = r13.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        goto L4
    L8:
        if (parseUnknownField(r13, r5, r14, r12) == true) goto L4;
    L10:
        th = move-exception;
        if (((r11 == true ? 1 : 0) & 32) != 32) goto L96;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L96:
        if (((r11 == true ? 1 : 0) & 1024) != 1024) goto L99;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L99:
        if (((r11 == true ? 1 : 0) & 256) != 256) goto L102;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L102:
        if (((r11 == true ? 1 : 0) & 512) != 512) goto L105;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L105:
        if (((r11 == true ? 1 : 0) & 4096) != 4096) goto L142;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L142:
        r5.i();     // Catch: IOException -> L137 Throwable -> L109
    L109:
        th = move-exception;
        this.unknownFields = r16.e();
        throw th;
    L108:
        this.unknownFields = r16.e();
        makeExtensionsImmutable();
        throw th;
    L14:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L12:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
    L115:
        if (((r11 == true ? 1 : 0) & 32) != 32) goto L118;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L118:
        if (((r11 == true ? 1 : 0) & 1024) != 1024) goto L121;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L121:
        if (((r11 == true ? 1 : 0) & 256) != 256) goto L124;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L124:
        if (((r11 == true ? 1 : 0) & 512) != 512) goto L127;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L127:
        if (((r11 == true ? 1 : 0) & 4096) != 4096) goto L140;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L140:
        r5.i();     // Catch: IOException -> L136 Throwable -> L131
    L131:
        th = move-exception;
        this.unknownFields = r16.e();
        throw th;
    L130:
        this.unknownFields = r16.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Function parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Function parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Function parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Function parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Function parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Function) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
