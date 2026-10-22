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
public final class ProtoBuf$Constructor extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Constructor> implements ProtoBuf$ConstructorOrBuilder {
    public static Parser<ProtoBuf$Constructor> PARSER;
    private static final ProtoBuf$Constructor defaultInstance = null;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    private void initFields() {
        this.flags_ = 6;
        this.valueParameter_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$Constructor r0 = new ProtoBuf$Constructor(true);
        defaultInstance = r0;
        r0.initFields();
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
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.valueParameter_.size()) goto L13;
        r1 = r1 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.valueParameter_, r3));
        r3 = r3 + 1;
        goto L11
    L13:
        int r4 = 0;
    L15:
        if (r2 >= this.versionRequirement_.size()) goto L17;
        r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r2)).intValue());
        r2 = r2 + 1;
        goto L15
    L17:
        int r5 = (((r1 + r4) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r5;
        return r5;
    L8:
        r1 = 0;
        goto L9
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
    }

    public boolean hasFlags() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= getValueParameterCount()) goto L17;
        if (getValueParameter(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
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

    public static Builder newBuilder() {
        return Builder.access$13300();
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

    public static ProtoBuf$Constructor getDefaultInstance() {
        return defaultInstance;
    }

    public int getFlags() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Constructor> getParserForType() {
        return PARSER;
    }

    public List<ProtoBuf$ValueParameter> getValueParameterList() {
        return this.valueParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Constructor getDefaultInstanceForType() {
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

    private ProtoBuf$Constructor(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Constructor, ?> r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$13600(ProtoBuf$Constructor r0) {
        return r0.valueParameter_;
    }

    public static /* synthetic */ List access$13700(ProtoBuf$Constructor r0) {
        return r0.versionRequirement_;
    }

    public static /* synthetic */ ByteString access$13900(ProtoBuf$Constructor r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Constructor r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$ValueParameter getValueParameter(int r2) {
        return (ProtoBuf$ValueParameter) ListProtector.get(this.valueParameter_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r6) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L5;
        r6.writeInt32(1, this.flags_);
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r2 >= this.valueParameter_.size()) goto L10;
        r6.writeMessage(2, (MessageLite) ListProtector.get(this.valueParameter_, r2));
        r2 = r2 + 1;
    L10:
        if (r1 >= this.versionRequirement_.size()) goto L12;
        r6.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r1)).intValue());
        r1 = r1 + 1;
        goto L10
    L12:
        r0.writeUntil(19000, r6);
        r6.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Constructor(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$Constructor(CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L60;
        int r7 = r11.readTag();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        if (r7 == 0) goto L37;
        if (r7 != 8) goto L10;
        this.bitField0_ |= 1;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        this.flags_ = r11.readInt32();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        goto L4
    L10:
        if (r7 != 18) goto L12;
        if ((r4 & 2) == 2) goto L34;
        this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        r4 = r4 | 2;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
    L34:
        this.valueParameter_.add((ProtoBuf$ValueParameter) r11.readMessage(ProtoBuf$ValueParameter.PARSER, r12));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        goto L4
    L12:
        if (r7 != 248) goto L14;
        if ((r4 & 4) == 4) goto L30;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        r4 = r4 | 4;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
    L30:
        this.versionRequirement_.add(Integer.valueOf(r11.readInt32()));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        goto L4
    L14:
        if (r7 != 250) goto L16;
        int r8 = r11.pushLimit(r11.readRawVarint32());     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        if ((r4 & 4) == 4) goto L24;
        if (r11.getBytesUntilLimit() <= 0) goto L24;
        this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        r4 = r4 | 4;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
    L24:
        if (r11.getBytesUntilLimit() <= 0) goto L26;
        this.versionRequirement_.add(Integer.valueOf(r11.readInt32()));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        goto L24
    L26:
        r11.popLimit(r8);     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        goto L4
    L16:
        if (parseUnknownField(r11, r2, r12, r7) == true) goto L4;
    L37:
        r3 = true;
        goto L4
    L38:
        th = move-exception;
        if ((r4 & 2) != 2) goto L50;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L50:
        if ((r4 & 4) != 4) goto L78;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L78:
        r2.flush();     // Catch: IOException -> L73 Throwable -> L54
    L54:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L53:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L43:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L38
    L40:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L38
    L60:
        if ((r4 & 2) != 2) goto L63;
        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
    L63:
        if ((r4 & 4) != 4) goto L76;
        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
    L76:
        r2.flush();     // Catch: IOException -> L72 Throwable -> L67
    L67:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L66:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$13502(ProtoBuf$Constructor r0, int r1) {
        r0.flags_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$13602(ProtoBuf$Constructor r0, List r1) {
        r0.valueParameter_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$13702(ProtoBuf$Constructor r0, List r1) {
        r0.versionRequirement_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$13802(ProtoBuf$Constructor r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$Constructor(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Constructor(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
