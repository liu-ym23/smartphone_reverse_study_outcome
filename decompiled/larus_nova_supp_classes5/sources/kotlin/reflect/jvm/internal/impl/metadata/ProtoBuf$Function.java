package kotlin.reflect.jvm.internal.impl.metadata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$Function extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Function> implements ProtoBuf$FunctionOrBuilder {
    public static Parser<ProtoBuf$Function> PARSER;
    private static final ProtoBuf$Function defaultInstance = null;
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
    private final ByteString unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    private void initFields() {
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

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$Function r0 = new ProtoBuf$Function(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 2) != 2) goto L8;
        int r1 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
    L10:
        if ((this.bitField0_ & 4) != 4) goto L13;
        r1 = r1 + CodedOutputStream.computeInt32Size(2, this.name_);
    L13:
        if ((this.bitField0_ & 8) != 8) goto L15;
        r1 = r1 + CodedOutputStream.computeMessageSize(3, this.returnType_);
    L15:
        int r4 = 0;
    L17:
        if (r4 >= this.typeParameter_.size()) goto L20;
        r1 = r1 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.typeParameter_, r4));
        r4 = r4 + 1;
        goto L17
    L20:
        if ((this.bitField0_ & 32) != 32) goto L22;
        r1 = r1 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
    L22:
        int r5 = 0;
    L24:
        if (r5 >= this.valueParameter_.size()) goto L27;
        r1 = r1 + CodedOutputStream.computeMessageSize(6, (MessageLite) ListProtector.get(this.valueParameter_, r5));
        r5 = r5 + 1;
        goto L24
    L27:
        if ((this.bitField0_ & 16) != 16) goto L30;
        r1 = r1 + CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
    L30:
        if ((this.bitField0_ & 64) != 64) goto L33;
        r1 = r1 + CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
    L33:
        if ((this.bitField0_ & 1) != 1) goto L35;
        r1 = r1 + CodedOutputStream.computeInt32Size(9, this.flags_);
    L35:
        int r3 = 0;
    L37:
        if (r3 >= this.contextReceiverType_.size()) goto L39;
        r1 = r1 + CodedOutputStream.computeMessageSize(10, (MessageLite) ListProtector.get(this.contextReceiverType_, r3));
        r3 = r3 + 1;
        goto L37
    L39:
        int r6 = 0;
        int r7 = 0;
    L41:
        if (r6 >= this.contextReceiverTypeId_.size()) goto L43;
        r7 = r7 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r6)).intValue());
        r6 = r6 + 1;
        goto L41
    L43:
        int r8 = r1 + r7;
        if (getContextReceiverTypeIdList().isEmpty() == true) goto L46;
        r8 = (r8 + 1) + CodedOutputStream.computeInt32SizeNoTag(r7);
    L46:
        this.contextReceiverTypeIdMemoizedSerializedSize = r7;
        if ((this.bitField0_ & 128) != 128) goto L49;
        r8 = r8 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
    L49:
        int r9 = 0;
    L51:
        if (r2 >= this.versionRequirement_.size()) goto L53;
        r9 = r9 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r2)).intValue());
        r2 = r2 + 1;
        goto L51
    L53:
        int r10 = (r8 + r9) + (getVersionRequirementList().size() * 2);
        if ((this.bitField0_ & 256) != 256) goto L56;
        r10 = r10 + CodedOutputStream.computeMessageSize(32, this.contract_);
    L56:
        int r11 = (r10 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r11;
        return r11;
    L8:
        r1 = 0;
        goto L10
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
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
        if (hasReturnType() == true) goto L15;
    L18:
        int r1 = 0;
    L20:
        if (r1 >= getTypeParameterCount()) goto L27;
        if (getTypeParameter(r1).isInitialized() == false) goto L23;
        r1 = r1 + 1;
        goto L20
    L23:
        this.memoizedIsInitialized = 0;
        return false;
    L27:
        if (hasReceiverType() == true) goto L29;
    L32:
        int r2 = 0;
    L34:
        if (r2 >= getContextReceiverTypeCount()) goto L40;
        if (getContextReceiverType(r2).isInitialized() == false) goto L37;
        r2 = r2 + 1;
        goto L34
    L37:
        this.memoizedIsInitialized = 0;
        return false;
    L40:
        int r3 = 0;
    L42:
        if (r3 >= getValueParameterCount()) goto L49;
        if (getValueParameter(r3).isInitialized() == false) goto L45;
        r3 = r3 + 1;
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

    public static Builder newBuilder() {
        return Builder.access$14100();
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

    public static ProtoBuf$Function getDefaultInstance() {
        return defaultInstance;
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public ProtoBuf$Contract getContract() {
        return this.contract_;
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Function> getParserForType() {
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

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public List<ProtoBuf$ValueParameter> getValueParameterList() {
        return this.valueParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Function getDefaultInstanceForType() {
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

    private ProtoBuf$Function(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Function, ?> r2) {
        super(r2);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$14800(ProtoBuf$Function r0) {
        return r0.typeParameter_;
    }

    public static /* synthetic */ List access$15100(ProtoBuf$Function r0) {
        return r0.contextReceiverType_;
    }

    public static /* synthetic */ List access$15200(ProtoBuf$Function r0) {
        return r0.contextReceiverTypeId_;
    }

    public static /* synthetic */ List access$15300(ProtoBuf$Function r0) {
        return r0.valueParameter_;
    }

    public static /* synthetic */ List access$15500(ProtoBuf$Function r0) {
        return r0.versionRequirement_;
    }

    public static /* synthetic */ ByteString access$15800(ProtoBuf$Function r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Function r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Type getContextReceiverType(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.contextReceiverType_, r2);
    }

    public ProtoBuf$TypeParameter getTypeParameter(int r2) {
        return (ProtoBuf$TypeParameter) ListProtector.get(this.typeParameter_, r2);
    }

    public ProtoBuf$ValueParameter getValueParameter(int r2) {
        return (ProtoBuf$ValueParameter) ListProtector.get(this.valueParameter_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r9) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 2) != 2) goto L6;
        r9.writeInt32(1, this.oldFlags_);
    L6:
        if ((this.bitField0_ & 4) != 4) goto L9;
        r9.writeInt32(2, this.name_);
    L9:
        if ((this.bitField0_ & 8) != 8) goto L11;
        r9.writeMessage(3, this.returnType_);
    L11:
        int r1 = 0;
        int r5 = 0;
    L13:
        if (r5 >= this.typeParameter_.size()) goto L16;
        r9.writeMessage(4, (MessageLite) ListProtector.get(this.typeParameter_, r5));
        r5 = r5 + 1;
        goto L13
    L16:
        if ((this.bitField0_ & 32) != 32) goto L18;
        r9.writeMessage(5, this.receiverType_);
    L18:
        int r4 = 0;
    L20:
        if (r4 >= this.valueParameter_.size()) goto L23;
        r9.writeMessage(6, (MessageLite) ListProtector.get(this.valueParameter_, r4));
        r4 = r4 + 1;
        goto L20
    L23:
        if ((this.bitField0_ & 16) != 16) goto L26;
        r9.writeInt32(7, this.returnTypeId_);
    L26:
        if ((this.bitField0_ & 64) != 64) goto L29;
        r9.writeInt32(8, this.receiverTypeId_);
    L29:
        if ((this.bitField0_ & 1) != 1) goto L31;
        r9.writeInt32(9, this.flags_);
    L31:
        int r2 = 0;
    L33:
        if (r2 >= this.contextReceiverType_.size()) goto L36;
        r9.writeMessage(10, (MessageLite) ListProtector.get(this.contextReceiverType_, r2));
        r2 = r2 + 1;
        goto L33
    L36:
        if (getContextReceiverTypeIdList().size() <= 0) goto L38;
        r9.writeRawVarint32(90);
        r9.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
    L38:
        int r3 = 0;
    L40:
        if (r3 >= this.contextReceiverTypeId_.size()) goto L43;
        r9.writeInt32NoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r3)).intValue());
        r3 = r3 + 1;
        goto L40
    L43:
        if ((this.bitField0_ & 128) != 128) goto L46;
        r9.writeMessage(30, this.typeTable_);
    L46:
        if (r1 >= this.versionRequirement_.size()) goto L49;
        r9.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r1)).intValue());
        r1 = r1 + 1;
        goto L46
    L49:
        if ((this.bitField0_ & 256) != 256) goto L51;
        r9.writeMessage(32, this.contract_);
    L51:
        r0.writeUntil(19000, r9);
        r9.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Function(boolean r1) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$Function(CodedInputStream r14, ExtensionRegistryLite r15) throws InvalidProtocolBufferException {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L114;
        int r10 = r14.readTag();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        ProtoBuf$Type.Builder r11 = null;
        ProtoBuf$Contract.Builder r12 = null;
        ProtoBuf$TypeTable.Builder r13 = null;
        ProtoBuf$Type.Builder r16 = null;
        switch(r10) {
            case 0: goto L80;
            case 8: goto L78;
            case 16: goto L77;
            case 26: goto L71;
            case 34: goto L67;
            case 42: goto L60;
            case 50: goto L56;
            case 56: goto L54;
            case 64: goto L53;
            case 72: goto L52;
            case 82: goto L49;
            case 88: goto L45;
            case 90: goto L35;
            case 242: goto L29;
            case 248: goto L25;
            case 250: goto L15;
            case 258: goto L9;
            default: goto L81;
        };     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L9:
        if ((this.bitField0_ & 256) != 256) goto L11;
        r12 = this.contract_.mo380toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L11:
        ProtoBuf$Contract r17 = (ProtoBuf$Contract) r14.readMessage(ProtoBuf$Contract.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.contract_ = r17;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        if (r12 == null) goto L14;
        r12.mergeFrom(r17);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.contract_ = r12.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L14:
        this.bitField0_ |= 256;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L15:
        int r18 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        if ((r4 & 4096) == 4096) goto L21;
        if (r14.getBytesUntilLimit() <= 0) goto L21;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        r4 = r4 | 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L21:
        if (r14.getBytesUntilLimit() <= 0) goto L23;
        this.versionRequirement_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L21
    L23:
        r14.popLimit(r18);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L25:
        if ((r4 & 4096) == 4096) goto L27;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        r4 = r4 | 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L27:
        this.versionRequirement_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L29:
        if ((this.bitField0_ & 128) != 128) goto L31;
        r13 = this.typeTable_.mo380toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L31:
        ProtoBuf$TypeTable r19 = (ProtoBuf$TypeTable) r14.readMessage(ProtoBuf$TypeTable.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.typeTable_ = r19;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        if (r13 == null) goto L34;
        r13.mergeFrom(r19);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.typeTable_ = r13.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L34:
        this.bitField0_ |= 128;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L35:
        int r110 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        if ((r4 & 512) == 512) goto L41;
        if (r14.getBytesUntilLimit() <= 0) goto L41;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        r4 = r4 | 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L41:
        if (r14.getBytesUntilLimit() <= 0) goto L43;
        this.contextReceiverTypeId_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L41
    L43:
        r14.popLimit(r110);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L45:
        if ((r4 & 512) == 512) goto L47;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        r4 = r4 | 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L47:
        this.contextReceiverTypeId_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L49:
        if ((r4 & 256) == 256) goto L51;
        this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        r4 = r4 | 256;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L51:
        this.contextReceiverType_.add((ProtoBuf$Type) r14.readMessage(ProtoBuf$Type.PARSER, r15));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L52:
        this.bitField0_ |= 1;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.flags_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L53:
        this.bitField0_ |= 64;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.receiverTypeId_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L54:
        this.bitField0_ |= 16;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.returnTypeId_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L56:
        if ((r4 & 1024) == 1024) goto L58;
        this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        r4 = r4 | 1024;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L58:
        this.valueParameter_.add((ProtoBuf$ValueParameter) r14.readMessage(ProtoBuf$ValueParameter.PARSER, r15));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L60:
        if ((this.bitField0_ & 32) != 32) goto L62;
        r16 = this.receiverType_.mo380toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L62:
        ProtoBuf$Type r111 = (ProtoBuf$Type) r14.readMessage(ProtoBuf$Type.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.receiverType_ = r111;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        if (r16 == null) goto L65;
        r16.mergeFrom(r111);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.receiverType_ = r16.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L65:
        this.bitField0_ |= 32;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L67:
        if ((r4 & 32) == 32) goto L69;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        r4 = r4 | 32;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L69:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r14.readMessage(ProtoBuf$TypeParameter.PARSER, r15));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L71:
        if ((this.bitField0_ & 8) != 8) goto L73;
        r11 = this.returnType_.mo380toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L73:
        ProtoBuf$Type r112 = (ProtoBuf$Type) r14.readMessage(ProtoBuf$Type.PARSER, r15);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.returnType_ = r112;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        if (r11 == null) goto L76;
        r11.mergeFrom(r112);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.returnType_ = r11.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L76:
        this.bitField0_ |= 8;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L77:
        this.bitField0_ |= 4;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.name_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        goto L4
    L78:
        this.bitField0_ |= 2;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        this.oldFlags_ = r14.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
    L80:
        r3 = true;
        goto L4
    L81:
        if (parseUnknownField(r14, r2, r15, r10) == true) goto L4;
    L83:
        th = move-exception;
        if ((r4 & 32) != 32) goto L95;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L95:
        if ((r4 & 1024) != 1024) goto L98;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L98:
        if ((r4 & 256) != 256) goto L101;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L101:
        if ((r4 & 512) != 512) goto L104;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L104:
        if ((r4 & 4096) != 4096) goto L139;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L139:
        r2.flush();     // Catch: IOException -> L136 Throwable -> L108
    L108:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L107:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L85:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L83
    L88:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L83
    L114:
        if ((r4 & 32) != 32) goto L117;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L117:
        if ((r4 & 1024) != 1024) goto L120;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L120:
        if ((r4 & 256) != 256) goto L123;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L123:
        if ((r4 & 512) != 512) goto L126;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L126:
        if ((r4 & 4096) != 4096) goto L141;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L141:
        r2.flush();     // Catch: IOException -> L135 Throwable -> L130
    L130:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L129:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$14302(ProtoBuf$Function r0, int r1) {
        r0.flags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$14402(ProtoBuf$Function r0, int r1) {
        r0.oldFlags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$14502(ProtoBuf$Function r0, int r1) {
        r0.name_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$14602(ProtoBuf$Function r0, ProtoBuf$Type r1) {
        r0.returnType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$14702(ProtoBuf$Function r0, int r1) {
        r0.returnTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$14802(ProtoBuf$Function r0, List r1) {
        r0.typeParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$14902(ProtoBuf$Function r0, ProtoBuf$Type r1) {
        r0.receiverType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$15002(ProtoBuf$Function r0, int r1) {
        r0.receiverTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$15102(ProtoBuf$Function r0, List r1) {
        r0.contextReceiverType_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$15202(ProtoBuf$Function r0, List r1) {
        r0.contextReceiverTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$15302(ProtoBuf$Function r0, List r1) {
        r0.valueParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$TypeTable access$15402(ProtoBuf$Function r0, ProtoBuf$TypeTable r1) {
        r0.typeTable_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$15502(ProtoBuf$Function r0, List r1) {
        r0.versionRequirement_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Contract access$15602(ProtoBuf$Function r0, ProtoBuf$Contract r1) {
        r0.contract_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$15702(ProtoBuf$Function r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public static ProtoBuf$Function parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
        return PARSER.parseFrom(r1, r2);
    }

    public /* synthetic */ ProtoBuf$Function(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Function(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
