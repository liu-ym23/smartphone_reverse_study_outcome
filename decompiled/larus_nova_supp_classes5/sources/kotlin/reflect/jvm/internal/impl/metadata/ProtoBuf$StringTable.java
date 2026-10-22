package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$StringTable extends GeneratedMessageLite implements ProtoBuf$StringTableOrBuilder {
    public static Parser<ProtoBuf$StringTable> PARSER;
    private static final ProtoBuf$StringTable defaultInstance = null;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private LazyStringList string_;
    private final ByteString unknownFields;

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$StringTable r0 = new ProtoBuf$StringTable(true);
        defaultInstance = r0;
        r0.initFields();
    }

    private void initFields() {
        this.string_ = LazyStringArrayList.EMPTY;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.string_.size()) goto L9;
        r2 = r2 + CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = ((0 + r2) + (getStringList().size() * 1)) + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    public static Builder newBuilder() {
        return Builder.access$100();
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

    public static ProtoBuf$StringTable getDefaultInstance() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$StringTable> getParserForType() {
        return PARSER;
    }

    public ProtocolStringList getStringList() {
        return this.string_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$StringTable getDefaultInstanceForType() {
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

    private ProtoBuf$StringTable(GeneratedMessageLite.Builder r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ LazyStringList access$300(ProtoBuf$StringTable r0) {
        return r0.string_;
    }

    public static /* synthetic */ ByteString access$400(ProtoBuf$StringTable r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$StringTable r1) {
        return newBuilder().mergeFrom(r1);
    }

    public String getString(int r2) {
        return this.string_.get(r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r4) throws IOException {
        getSerializedSize();
        int r0 = 0;
    L4:
        if (r0 >= this.string_.size()) goto L6;
        r4.writeBytes(1, this.string_.getByteString(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$StringTable(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$StringTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L36;
        int r5 = r8.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        if (r5 == 0) goto L16;
        if (r5 != 10) goto L9;
        ByteString r6 = r8.readBytes();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        if ((r4 & true) == true) goto L14;
        this.string_ = new LazyStringArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
    L14:
        this.string_.add(r6);     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        goto L3
    L9:
        if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L51;
        this.string_ = this.string_.getUnmodifiableView();
    L51:
        r2.flush();     // Catch: IOException -> L46 Throwable -> L30
    L30:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L29:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L22:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
    L36:
        if ((r4 & true) != true) goto L49;
        this.string_ = this.string_.getUnmodifiableView();
    L49:
        r2.flush();     // Catch: IOException -> L45 Throwable -> L40
    L40:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L39:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ LazyStringList access$302(ProtoBuf$StringTable r0, LazyStringList r1) {
        r0.string_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$StringTable(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$StringTable(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
