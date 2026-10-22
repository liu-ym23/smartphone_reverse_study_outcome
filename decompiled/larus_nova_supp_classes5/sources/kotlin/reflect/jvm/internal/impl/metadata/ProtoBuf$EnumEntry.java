package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$EnumEntry extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$EnumEntry> implements ProtoBuf$EnumEntryOrBuilder {
    public static Parser<ProtoBuf$EnumEntry> PARSER;
    private static final ProtoBuf$EnumEntry defaultInstance = null;
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private final ByteString unknownFields;

    private void initFields() {
        this.name_ = 0;
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$EnumEntry r0 = new ProtoBuf$EnumEntry(true);
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
        r2 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
    L8:
        int r3 = (r2 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
    }

    public boolean hasName() {
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
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (extensionsAreInitialized() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        this.memoizedIsInitialized = 1;
        return true;
    }

    public static Builder newBuilder() {
        return Builder.access$20400();
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

    public static ProtoBuf$EnumEntry getDefaultInstance() {
        return defaultInstance;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$EnumEntry> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$EnumEntry getDefaultInstanceForType() {
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

    private ProtoBuf$EnumEntry(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$EnumEntry, ?> r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ ByteString access$20800(ProtoBuf$EnumEntry r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$EnumEntry r1) {
        return newBuilder().mergeFrom(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r4) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L5;
        r4.writeInt32(1, this.name_);
    L5:
        r0.writeUntil(200, r4);
        r4.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$EnumEntry(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$EnumEntry(CodedInputStream r7, ExtensionRegistryLite r8) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
    L3:
        if (r3 == true) goto L40;
        int r4 = r7.readTag();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
        if (r4 == 0) goto L13;
        if (r4 != 8) goto L9;
        this.bitField0_ |= 1;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
        this.name_ = r7.readInt32();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
        goto L3
    L9:
        if (parseUnknownField(r7, r2, r8, r4) == true) goto L3;
    L13:
        r3 = true;
        goto L3
    L14:
        th = move-exception;
        r2.flush();     // Catch: IOException -> L36 Throwable -> L24
    L24:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L23:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L19:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L14
    L40:
        r2.flush();     // Catch: IOException -> L37 Throwable -> L31
    L31:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L30:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$20602(ProtoBuf$EnumEntry r0, int r1) {
        r0.name_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$20702(ProtoBuf$EnumEntry r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$EnumEntry(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$EnumEntry(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
