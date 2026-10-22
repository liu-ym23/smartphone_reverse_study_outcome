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
public final class ProtoBuf$PackageFragment extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$PackageFragment> implements ProtoBuf$PackageFragmentOrBuilder {
    public static Parser<ProtoBuf$PackageFragment> PARSER;
    private static final ProtoBuf$PackageFragment defaultInstance = null;
    private int bitField0_;
    private List<ProtoBuf$Class> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private ProtoBuf$Package package_;
    private ProtoBuf$QualifiedNameTable qualifiedNames_;
    private ProtoBuf$StringTable strings_;
    private final ByteString unknownFields;

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$PackageFragment r0 = new ProtoBuf$PackageFragment(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getClass_Count() {
        return this.class__.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r1 = CodedOutputStream.computeMessageSize(1, this.strings_) + 0;
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r1 = r1 + CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r1 = r1 + CodedOutputStream.computeMessageSize(3, this.package_);
    L16:
        if (r2 >= this.class__.size()) goto L18;
        r1 = r1 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.class__, r2));
        r2 = r2 + 1;
        goto L16
    L18:
        int r3 = (r1 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
    L8:
        r1 = 0;
        goto L10
    }

    public boolean hasPackage() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasQualifiedNames() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasStrings() {
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
        if (hasQualifiedNames() == false) goto L15;
        if (getQualifiedNames().isInitialized() == true) goto L15;
        this.memoizedIsInitialized = 0;
        return false;
    L15:
        if (hasPackage() == true) goto L17;
    L20:
        int r1 = 0;
    L22:
        if (r1 >= getClass_Count()) goto L29;
        if (getClass_(r1).isInitialized() == false) goto L25;
        r1 = r1 + 1;
        goto L22
    L25:
        this.memoizedIsInitialized = 0;
        return false;
    L29:
        if (extensionsAreInitialized() == true) goto L32;
        this.memoizedIsInitialized = 0;
        return false;
    L32:
        this.memoizedIsInitialized = 1;
        return true;
    L17:
        if (getPackage().isInitialized() == true) goto L20;
        this.memoizedIsInitialized = 0;
        return false;
    }

    private void initFields() {
        this.strings_ = ProtoBuf$StringTable.getDefaultInstance();
        this.qualifiedNames_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        this.package_ = ProtoBuf$Package.getDefaultInstance();
        this.class__ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$22600();
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

    public static ProtoBuf$PackageFragment getDefaultInstance() {
        return defaultInstance;
    }

    public List<ProtoBuf$Class> getClass_List() {
        return this.class__;
    }

    public ProtoBuf$Package getPackage() {
        return this.package_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$PackageFragment> getParserForType() {
        return PARSER;
    }

    public ProtoBuf$QualifiedNameTable getQualifiedNames() {
        return this.qualifiedNames_;
    }

    public ProtoBuf$StringTable getStrings() {
        return this.strings_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$PackageFragment getDefaultInstanceForType() {
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

    private ProtoBuf$PackageFragment(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$PackageFragment, ?> r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$23100(ProtoBuf$PackageFragment r0) {
        return r0.class__;
    }

    public static /* synthetic */ ByteString access$23300(ProtoBuf$PackageFragment r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$PackageFragment r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Class getClass_(int r2) {
        return (ProtoBuf$Class) ListProtector.get(this.class__, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r5) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r5.writeMessage(1, this.strings_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r5.writeMessage(2, this.qualifiedNames_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L11;
        r5.writeMessage(3, this.package_);
    L11:
        int r1 = 0;
    L13:
        if (r1 >= this.class__.size()) goto L15;
        r5.writeMessage(4, (MessageLite) ListProtector.get(this.class__, r1));
        r1 = r1 + 1;
        goto L13
    L15:
        r0.writeUntil(200, r5);
        r5.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$PackageFragment(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$PackageFragment(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L64;
        int r6 = r10.readTag();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        if (r6 == 0) goto L44;
        ProtoBuf$StringTable.Builder r8 = null;
        if (r6 != 10) goto L10;
        if ((this.bitField0_ & 1) != 1) goto L39;
        r8 = this.strings_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L39:
        ProtoBuf$StringTable r7 = (ProtoBuf$StringTable) r10.readMessage(ProtoBuf$StringTable.PARSER, r11);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.strings_ = r7;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        if (r8 == null) goto L42;
        r8.mergeFrom(r7);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.strings_ = r8.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L42:
        this.bitField0_ |= 1;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L4
    L10:
        if (r6 != 18) goto L12;
        if ((this.bitField0_ & 2) != 2) goto L32;
        r8 = this.qualifiedNames_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L32:
        ProtoBuf$QualifiedNameTable r9 = (ProtoBuf$QualifiedNameTable) r10.readMessage(ProtoBuf$QualifiedNameTable.PARSER, r11);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.qualifiedNames_ = r9;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        if (r8 == null) goto L35;
        r8.mergeFrom(r9);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.qualifiedNames_ = r8.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L35:
        this.bitField0_ |= 2;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L4
    L12:
        if (r6 != 26) goto L14;
        if ((this.bitField0_ & 4) != 4) goto L25;
        r8 = this.package_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L25:
        ProtoBuf$Package r12 = (ProtoBuf$Package) r10.readMessage(ProtoBuf$Package.PARSER, r11);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.package_ = r12;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        if (r8 == null) goto L28;
        r8.mergeFrom(r12);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        this.package_ = r8.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L28:
        this.bitField0_ |= 4;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L4
    L14:
        if (r6 != 34) goto L16;
        if ((r4 & 8) == 8) goto L21;
        this.class__ = new ArrayList();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        r4 = r4 | 8;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
    L21:
        this.class__.add((ProtoBuf$Class) r10.readMessage(ProtoBuf$Class.PARSER, r11));     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        goto L4
    L16:
        if (parseUnknownField(r10, r2, r11, r6) == true) goto L4;
    L44:
        r3 = true;
        goto L4
    L45:
        th = move-exception;
        if ((r4 & 8) != 8) goto L79;
        this.class__ = Collections.unmodifiableList(this.class__);
    L79:
        r2.flush();     // Catch: IOException -> L74 Throwable -> L58
    L58:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L57:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L47:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L45
    L50:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L45
    L64:
        if ((r4 & 8) != 8) goto L77;
        this.class__ = Collections.unmodifiableList(this.class__);
    L77:
        r2.flush();     // Catch: IOException -> L73 Throwable -> L68
    L68:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L67:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ ProtoBuf$StringTable access$22802(ProtoBuf$PackageFragment r0, ProtoBuf$StringTable r1) {
        r0.strings_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$QualifiedNameTable access$22902(ProtoBuf$PackageFragment r0, ProtoBuf$QualifiedNameTable r1) {
        r0.qualifiedNames_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$Package access$23002(ProtoBuf$PackageFragment r0, ProtoBuf$Package r1) {
        r0.package_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$23102(ProtoBuf$PackageFragment r0, List r1) {
        r0.class__ = r1;
        return r1;
    }

    public static /* synthetic */ int access$23202(ProtoBuf$PackageFragment r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public static ProtoBuf$PackageFragment parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
        return PARSER.parseFrom(r1, r2);
    }

    public /* synthetic */ ProtoBuf$PackageFragment(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$PackageFragment(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
