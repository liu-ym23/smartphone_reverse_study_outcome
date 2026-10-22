package kotlin.reflect.jvm.internal.impl.metadata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
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
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Property> implements ProtoBuf$PropertyOrBuilder {
    public static Parser<ProtoBuf$Property> PARSER;
    private static final ProtoBuf$Property defaultInstance = null;
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
    private final ByteString unknownFields;
    private List<Integer> versionRequirement_;

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$Property r0 = new ProtoBuf$Property(true);
        defaultInstance = r0;
        r0.initFields();
    }

    private void initFields() {
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
        if ((this.bitField0_ & 32) != 32) goto L23;
        r1 = r1 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
    L23:
        if ((this.bitField0_ & 128) != 128) goto L26;
        r1 = r1 + CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
    L26:
        if ((this.bitField0_ & 256) != 256) goto L29;
        r1 = r1 + CodedOutputStream.computeInt32Size(7, this.getterFlags_);
    L29:
        if ((this.bitField0_ & 512) != 512) goto L32;
        r1 = r1 + CodedOutputStream.computeInt32Size(8, this.setterFlags_);
    L32:
        if ((this.bitField0_ & 16) != 16) goto L35;
        r1 = r1 + CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
    L35:
        if ((this.bitField0_ & 64) != 64) goto L38;
        r1 = r1 + CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
    L38:
        if ((this.bitField0_ & 1) != 1) goto L40;
        r1 = r1 + CodedOutputStream.computeInt32Size(11, this.flags_);
    L40:
        int r3 = 0;
    L42:
        if (r3 >= this.contextReceiverType_.size()) goto L44;
        r1 = r1 + CodedOutputStream.computeMessageSize(12, (MessageLite) ListProtector.get(this.contextReceiverType_, r3));
        r3 = r3 + 1;
        goto L42
    L44:
        int r5 = 0;
        int r6 = 0;
    L46:
        if (r5 >= this.contextReceiverTypeId_.size()) goto L48;
        r6 = r6 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r5)).intValue());
        r5 = r5 + 1;
        goto L46
    L48:
        int r7 = r1 + r6;
        if (getContextReceiverTypeIdList().isEmpty() == true) goto L51;
        r7 = (r7 + 1) + CodedOutputStream.computeInt32SizeNoTag(r6);
    L51:
        this.contextReceiverTypeIdMemoizedSerializedSize = r6;
        int r8 = 0;
    L53:
        if (r2 >= this.versionRequirement_.size()) goto L55;
        r8 = r8 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r2)).intValue());
        r2 = r2 + 1;
        goto L53
    L55:
        int r9 = (((r7 + r8) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r9;
        return r9;
    L8:
        r1 = 0;
        goto L10
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
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
        if (r2 >= getContextReceiverTypeCount()) goto L41;
        if (getContextReceiverType(r2).isInitialized() == false) goto L37;
        r2 = r2 + 1;
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

    public static Builder newBuilder() {
        return Builder.access$16000();
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

    public static ProtoBuf$Property getDefaultInstance() {
        return defaultInstance;
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Property> getParserForType() {
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

    public int getSetterFlags() {
        return this.setterFlags_;
    }

    public ProtoBuf$ValueParameter getSetterValueParameter() {
        return this.setterValueParameter_;
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Property getDefaultInstanceForType() {
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

    private ProtoBuf$Property(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Property, ?> r2) {
        super(r2);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$16700(ProtoBuf$Property r0) {
        return r0.typeParameter_;
    }

    public static /* synthetic */ List access$17000(ProtoBuf$Property r0) {
        return r0.contextReceiverType_;
    }

    public static /* synthetic */ List access$17100(ProtoBuf$Property r0) {
        return r0.contextReceiverTypeId_;
    }

    public static /* synthetic */ List access$17500(ProtoBuf$Property r0) {
        return r0.versionRequirement_;
    }

    public static /* synthetic */ ByteString access$17700(ProtoBuf$Property r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Property r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Type getContextReceiverType(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.contextReceiverType_, r2);
    }

    public ProtoBuf$TypeParameter getTypeParameter(int r2) {
        return (ProtoBuf$TypeParameter) ListProtector.get(this.typeParameter_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 2) != 2) goto L6;
        r8.writeInt32(1, this.oldFlags_);
    L6:
        if ((this.bitField0_ & 4) != 4) goto L9;
        r8.writeInt32(2, this.name_);
    L9:
        if ((this.bitField0_ & 8) != 8) goto L11;
        r8.writeMessage(3, this.returnType_);
    L11:
        int r1 = 0;
        int r5 = 0;
    L13:
        if (r5 >= this.typeParameter_.size()) goto L16;
        r8.writeMessage(4, (MessageLite) ListProtector.get(this.typeParameter_, r5));
        r5 = r5 + 1;
        goto L13
    L16:
        if ((this.bitField0_ & 32) != 32) goto L19;
        r8.writeMessage(5, this.receiverType_);
    L19:
        if ((this.bitField0_ & 128) != 128) goto L22;
        r8.writeMessage(6, this.setterValueParameter_);
    L22:
        if ((this.bitField0_ & 256) != 256) goto L25;
        r8.writeInt32(7, this.getterFlags_);
    L25:
        if ((this.bitField0_ & 512) != 512) goto L28;
        r8.writeInt32(8, this.setterFlags_);
    L28:
        if ((this.bitField0_ & 16) != 16) goto L31;
        r8.writeInt32(9, this.returnTypeId_);
    L31:
        if ((this.bitField0_ & 64) != 64) goto L34;
        r8.writeInt32(10, this.receiverTypeId_);
    L34:
        if ((this.bitField0_ & 1) != 1) goto L36;
        r8.writeInt32(11, this.flags_);
    L36:
        int r2 = 0;
    L38:
        if (r2 >= this.contextReceiverType_.size()) goto L41;
        r8.writeMessage(12, (MessageLite) ListProtector.get(this.contextReceiverType_, r2));
        r2 = r2 + 1;
        goto L38
    L41:
        if (getContextReceiverTypeIdList().size() <= 0) goto L43;
        r8.writeRawVarint32(106);
        r8.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
    L43:
        int r3 = 0;
    L45:
        if (r3 >= this.contextReceiverTypeId_.size()) goto L48;
        r8.writeInt32NoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r3)).intValue());
        r3 = r3 + 1;
    L48:
        if (r1 >= this.versionRequirement_.size()) goto L50;
        r8.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r1)).intValue());
        r1 = r1 + 1;
        goto L48
    L50:
        r0.writeUntil(19000, r8);
        r8.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Property(boolean r1) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$Property(CodedInputStream r13, ExtensionRegistryLite r14) throws InvalidProtocolBufferException {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L102;
        int r9 = r13.readTag();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        ProtoBuf$ValueParameter.Builder r10 = null;
        switch(r9) {
            case 0: goto L71;
            case 8: goto L69;
            case 16: goto L68;
            case 26: goto L62;
            case 34: goto L58;
            case 42: goto L51;
            case 50: goto L44;
            case 56: goto L42;
            case 64: goto L41;
            case 72: goto L40;
            case 80: goto L39;
            case 88: goto L38;
            case 98: goto L35;
            case 104: goto L31;
            case 106: goto L21;
            case 248: goto L18;
            case 250: goto L8;
            default: goto L72;
        };     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L8:
        int r11 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        if ((r4 & 8192) == 8192) goto L14;
        if (r13.getBytesUntilLimit() <= 0) goto L14;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        r4 = r4 | 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L14:
        if (r13.getBytesUntilLimit() <= 0) goto L16;
        this.versionRequirement_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L14
    L16:
        r13.popLimit(r11);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L18:
        if ((r4 & 8192) == 8192) goto L20;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        r4 = r4 | 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L20:
        this.versionRequirement_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L21:
        int r12 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        if ((r4 & 512) == 512) goto L27;
        if (r13.getBytesUntilLimit() <= 0) goto L27;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        r4 = r4 | 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L27:
        if (r13.getBytesUntilLimit() <= 0) goto L29;
        this.contextReceiverTypeId_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L27
    L29:
        r13.popLimit(r12);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L31:
        if ((r4 & 512) == 512) goto L33;
        this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        r4 = r4 | 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L33:
        this.contextReceiverTypeId_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L35:
        if ((r4 & 256) == 256) goto L37;
        this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        r4 = r4 | 256;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L37:
        this.contextReceiverType_.add((ProtoBuf$Type) r13.readMessage(ProtoBuf$Type.PARSER, r14));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L38:
        this.bitField0_ |= 1;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.flags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L39:
        this.bitField0_ |= 64;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.receiverTypeId_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L40:
        this.bitField0_ |= 16;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.returnTypeId_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L41:
        this.bitField0_ |= 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.setterFlags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L42:
        this.bitField0_ |= 256;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.getterFlags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L44:
        if ((this.bitField0_ & 128) != 128) goto L46;
        r10 = this.setterValueParameter_.toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L46:
        ProtoBuf$ValueParameter r15 = (ProtoBuf$ValueParameter) r13.readMessage(ProtoBuf$ValueParameter.PARSER, r14);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.setterValueParameter_ = r15;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        if (r10 == null) goto L49;
        r10.mergeFrom(r15);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.setterValueParameter_ = r10.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L49:
        this.bitField0_ |= 128;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L51:
        if ((this.bitField0_ & 32) != 32) goto L53;
        r10 = this.receiverType_.mo380toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L53:
        ProtoBuf$Type r16 = (ProtoBuf$Type) r13.readMessage(ProtoBuf$Type.PARSER, r14);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.receiverType_ = r16;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        if (r10 == null) goto L56;
        r10.mergeFrom(r16);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.receiverType_ = r10.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L56:
        this.bitField0_ |= 32;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L58:
        if ((r4 & 32) == 32) goto L60;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        r4 = r4 | 32;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L60:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r13.readMessage(ProtoBuf$TypeParameter.PARSER, r14));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L62:
        if ((this.bitField0_ & 8) != 8) goto L64;
        r10 = this.returnType_.mo380toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L64:
        ProtoBuf$Type r17 = (ProtoBuf$Type) r13.readMessage(ProtoBuf$Type.PARSER, r14);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.returnType_ = r17;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        if (r10 == null) goto L67;
        r10.mergeFrom(r17);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.returnType_ = r10.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L67:
        this.bitField0_ |= 8;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L68:
        this.bitField0_ |= 4;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.name_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        goto L4
    L69:
        this.bitField0_ |= 2;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        this.oldFlags_ = r13.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
    L71:
        r3 = true;
        goto L4
    L72:
        if (parseUnknownField(r13, r2, r14, r9) == true) goto L4;
    L74:
        th = move-exception;
        if ((r4 & 32) != 32) goto L86;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L86:
        if ((r4 & 256) != 256) goto L89;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L89:
        if ((r4 & 512) != 512) goto L92;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L92:
        if ((r4 & 8192) != 8192) goto L124;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L124:
        r2.flush();     // Catch: IOException -> L121 Throwable -> L96
    L96:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L95:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L79:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L74
    L76:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L74
    L102:
        if ((r4 & 32) != 32) goto L105;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L105:
        if ((r4 & 256) != 256) goto L108;
        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
    L108:
        if ((r4 & 512) != 512) goto L111;
        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
    L111:
        if ((r4 & 8192) != 8192) goto L126;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L126:
        r2.flush();     // Catch: IOException -> L120 Throwable -> L115
    L115:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L114:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$16202(ProtoBuf$Property r0, int r1) {
        r0.flags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$16302(ProtoBuf$Property r0, int r1) {
        r0.oldFlags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$16402(ProtoBuf$Property r0, int r1) {
        r0.name_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$16502(ProtoBuf$Property r0, ProtoBuf$Type r1) {
        r0.returnType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$16602(ProtoBuf$Property r0, int r1) {
        r0.returnTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$16702(ProtoBuf$Property r0, List r1) {
        r0.typeParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$16802(ProtoBuf$Property r0, ProtoBuf$Type r1) {
        r0.receiverType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$16902(ProtoBuf$Property r0, int r1) {
        r0.receiverTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$17002(ProtoBuf$Property r0, List r1) {
        r0.contextReceiverType_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$17102(ProtoBuf$Property r0, List r1) {
        r0.contextReceiverTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$ValueParameter access$17202(ProtoBuf$Property r0, ProtoBuf$ValueParameter r1) {
        r0.setterValueParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$17302(ProtoBuf$Property r0, int r1) {
        r0.getterFlags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$17402(ProtoBuf$Property r0, int r1) {
        r0.setterFlags_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$17502(ProtoBuf$Property r0, List r1) {
        r0.versionRequirement_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$17602(ProtoBuf$Property r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$Property(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Property(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
