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
public final class ProtoBuf$TypeAlias extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeAlias> implements ProtoBuf$TypeAliasOrBuilder {
    public static Parser<ProtoBuf$TypeAlias> PARSER;
    private static final ProtoBuf$TypeAlias defaultInstance = null;
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
    private final ByteString unknownFields;
    private List<Integer> versionRequirement_;

    private void initFields() {
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

    static {
        PARSER = new 1();
        ProtoBuf$TypeAlias r0 = new ProtoBuf$TypeAlias(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r1 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
    L10:
        if ((this.bitField0_ & 2) != 2) goto L12;
        r1 = r1 + CodedOutputStream.computeInt32Size(2, this.name_);
    L12:
        int r3 = 0;
    L14:
        if (r3 >= this.typeParameter_.size()) goto L17;
        r1 = r1 + CodedOutputStream.computeMessageSize(3, (MessageLite) ListProtector.get(this.typeParameter_, r3));
        r3 = r3 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 4) != 4) goto L20;
        r1 = r1 + CodedOutputStream.computeMessageSize(4, this.underlyingType_);
    L20:
        if ((this.bitField0_ & 8) != 8) goto L23;
        r1 = r1 + CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
    L23:
        if ((this.bitField0_ & 16) != 16) goto L26;
        r1 = r1 + CodedOutputStream.computeMessageSize(6, this.expandedType_);
    L26:
        if ((this.bitField0_ & 32) != 32) goto L28;
        r1 = r1 + CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
    L28:
        int r4 = 0;
    L30:
        if (r4 >= this.annotation_.size()) goto L32;
        r1 = r1 + CodedOutputStream.computeMessageSize(8, (MessageLite) ListProtector.get(this.annotation_, r4));
        r4 = r4 + 1;
        goto L30
    L32:
        int r5 = 0;
    L34:
        if (r2 >= this.versionRequirement_.size()) goto L36;
        r5 = r5 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r2)).intValue());
        r2 = r2 + 1;
        goto L34
    L36:
        int r6 = (((r1 + r5) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r6;
        return r6;
    L8:
        r1 = 0;
        goto L10
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (hasName() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        int r1 = 0;
    L14:
        if (r1 >= getTypeParameterCount()) goto L21;
        if (getTypeParameter(r1).isInitialized() == false) goto L17;
        r1 = r1 + 1;
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
        int r2 = 0;
    L34:
        if (r2 >= getAnnotationCount()) goto L41;
        if (getAnnotation(r2).isInitialized() == false) goto L37;
        r2 = r2 + 1;
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

    public static Builder newBuilder() {
        return Builder.access$19000();
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

    public static ProtoBuf$TypeAlias getDefaultInstance() {
        return defaultInstance;
    }

    public List<ProtoBuf$Annotation> getAnnotationList() {
        return this.annotation_;
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$TypeAlias> getParserForType() {
        return PARSER;
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public ProtoBuf$Type getUnderlyingType() {
        return this.underlyingType_;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeAlias getDefaultInstanceForType() {
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

    private ProtoBuf$TypeAlias(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeAlias, ?> r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$19400(ProtoBuf$TypeAlias r0) {
        return r0.typeParameter_;
    }

    public static /* synthetic */ List access$19900(ProtoBuf$TypeAlias r0) {
        return r0.annotation_;
    }

    public static /* synthetic */ List access$20000(ProtoBuf$TypeAlias r0) {
        return r0.versionRequirement_;
    }

    public static /* synthetic */ ByteString access$20200(ProtoBuf$TypeAlias r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$TypeAlias r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Annotation getAnnotation(int r2) {
        return (ProtoBuf$Annotation) ListProtector.get(this.annotation_, r2);
    }

    public ProtoBuf$TypeParameter getTypeParameter(int r2) {
        return (ProtoBuf$TypeParameter) ListProtector.get(this.typeParameter_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r6) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r6.writeInt32(1, this.flags_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L8;
        r6.writeInt32(2, this.name_);
    L8:
        int r1 = 0;
        int r2 = 0;
    L10:
        if (r2 >= this.typeParameter_.size()) goto L13;
        r6.writeMessage(3, (MessageLite) ListProtector.get(this.typeParameter_, r2));
        r2 = r2 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r6.writeMessage(4, this.underlyingType_);
    L16:
        if ((this.bitField0_ & 8) != 8) goto L19;
        r6.writeInt32(5, this.underlyingTypeId_);
    L19:
        if ((this.bitField0_ & 16) != 16) goto L22;
        r6.writeMessage(6, this.expandedType_);
    L22:
        if ((this.bitField0_ & 32) != 32) goto L24;
        r6.writeInt32(7, this.expandedTypeId_);
    L24:
        int r3 = 0;
    L26:
        if (r3 >= this.annotation_.size()) goto L29;
        r6.writeMessage(8, (MessageLite) ListProtector.get(this.annotation_, r3));
        r3 = r3 + 1;
    L29:
        if (r1 >= this.versionRequirement_.size()) goto L31;
        r6.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r1)).intValue());
        r1 = r1 + 1;
        goto L29
    L31:
        r0.writeUntil(200, r6);
        r6.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$TypeAlias(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$TypeAlias(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L76;
        int r8 = r12.readTag();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        ProtoBuf$Type.Builder r9 = null;
        switch(r8) {
            case 0: goto L48;
            case 8: goto L46;
            case 16: goto L45;
            case 26: goto L42;
            case 34: goto L35;
            case 40: goto L33;
            case 50: goto L27;
            case 56: goto L25;
            case 66: goto L22;
            case 248: goto L18;
            case 250: goto L8;
            default: goto L49;
        };     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L8:
        int r10 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        if ((r4 & 256) == 256) goto L14;
        if (r12.getBytesUntilLimit() <= 0) goto L14;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        r4 = r4 | 256;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L14:
        if (r12.getBytesUntilLimit() <= 0) goto L16;
        this.versionRequirement_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L14
    L16:
        r12.popLimit(r10);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L18:
        if ((r4 & 256) == 256) goto L20;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        r4 = r4 | 256;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L20:
        this.versionRequirement_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L22:
        if ((r4 & 128) == 128) goto L24;
        this.annotation_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        r4 = r4 | 128;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L24:
        this.annotation_.add((ProtoBuf$Annotation) r12.readMessage(ProtoBuf$Annotation.PARSER, r13));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L25:
        this.bitField0_ |= 32;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.expandedTypeId_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L27:
        if ((this.bitField0_ & 16) != 16) goto L29;
        r9 = this.expandedType_.mo380toBuilder();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L29:
        ProtoBuf$Type r11 = (ProtoBuf$Type) r12.readMessage(ProtoBuf$Type.PARSER, r13);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.expandedType_ = r11;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        if (r9 == null) goto L32;
        r9.mergeFrom(r11);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.expandedType_ = r9.buildPartial();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L32:
        this.bitField0_ |= 16;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L33:
        this.bitField0_ |= 8;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.underlyingTypeId_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L35:
        if ((this.bitField0_ & 4) != 4) goto L37;
        r9 = this.underlyingType_.mo380toBuilder();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L37:
        ProtoBuf$Type r14 = (ProtoBuf$Type) r12.readMessage(ProtoBuf$Type.PARSER, r13);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.underlyingType_ = r14;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        if (r9 == null) goto L40;
        r9.mergeFrom(r14);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.underlyingType_ = r9.buildPartial();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L40:
        this.bitField0_ |= 4;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L42:
        if ((r4 & 4) == 4) goto L44;
        this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        r4 = r4 | 4;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L44:
        this.typeParameter_.add((ProtoBuf$TypeParameter) r12.readMessage(ProtoBuf$TypeParameter.PARSER, r13));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L45:
        this.bitField0_ |= 2;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.name_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        goto L4
    L46:
        this.bitField0_ |= 1;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        this.flags_ = r12.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
    L48:
        r3 = true;
        goto L4
    L49:
        if (parseUnknownField(r12, r2, r13, r8) == true) goto L4;
    L51:
        th = move-exception;
        if ((r4 & 4) != 4) goto L63;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L63:
        if ((r4 & 128) != 128) goto L66;
        this.annotation_ = Collections.unmodifiableList(this.annotation_);
    L66:
        if ((r4 & 256) != 256) goto L95;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L95:
        r2.flush();     // Catch: IOException -> L92 Throwable -> L70
    L70:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L69:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L53:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L51
    L56:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L51
    L76:
        if ((r4 & 4) != 4) goto L79;
        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
    L79:
        if ((r4 & 128) != 128) goto L82;
        this.annotation_ = Collections.unmodifiableList(this.annotation_);
    L82:
        if ((r4 & 256) != 256) goto L97;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L97:
        r2.flush();     // Catch: IOException -> L91 Throwable -> L86
    L86:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L85:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$19202(ProtoBuf$TypeAlias r0, int r1) {
        r0.flags_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$19302(ProtoBuf$TypeAlias r0, int r1) {
        r0.name_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$19402(ProtoBuf$TypeAlias r0, List r1) {
        r0.typeParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$19502(ProtoBuf$TypeAlias r0, ProtoBuf$Type r1) {
        r0.underlyingType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$19602(ProtoBuf$TypeAlias r0, int r1) {
        r0.underlyingTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Type access$19702(ProtoBuf$TypeAlias r0, ProtoBuf$Type r1) {
        r0.expandedType_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$19802(ProtoBuf$TypeAlias r0, int r1) {
        r0.expandedTypeId_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$19902(ProtoBuf$TypeAlias r0, List r1) {
        r0.annotation_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$20002(ProtoBuf$TypeAlias r0, List r1) {
        r0.versionRequirement_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$20102(ProtoBuf$TypeAlias r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public static ProtoBuf$TypeAlias parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
        return PARSER.parseDelimitedFrom(r1, r2);
    }

    public /* synthetic */ ProtoBuf$TypeAlias(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$TypeAlias(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
