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
public final class ProtoBuf$Package extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Package> implements ProtoBuf$PackageOrBuilder {
    public static Parser<ProtoBuf$Package> PARSER;
    private static final ProtoBuf$Package defaultInstance = null;
    private int bitField0_;
    private List<ProtoBuf$Function> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Property> property_;
    private List<ProtoBuf$TypeAlias> typeAlias_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$Package r0 = new ProtoBuf$Package(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= this.function_.size()) goto L9;
        r3 = r3 + CodedOutputStream.computeMessageSize(3, (MessageLite) ListProtector.get(this.function_, r2));
        r2 = r2 + 1;
        goto L7
    L9:
        int r4 = 0;
    L11:
        if (r4 >= this.property_.size()) goto L14;
        r3 = r3 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.property_, r4));
        r4 = r4 + 1;
    L14:
        if (r1 >= this.typeAlias_.size()) goto L17;
        r3 = r3 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.typeAlias_, r1));
        r1 = r1 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) != 1) goto L20;
        r3 = r3 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
    L20:
        if ((this.bitField0_ & 2) != 2) goto L22;
        r3 = r3 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
    L22:
        int r5 = (r3 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r5;
        return r5;
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public boolean hasTypeTable() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasVersionRequirementTable() {
        if ((this.bitField0_ & 2) != 2) goto L5;
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
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= getFunctionCount()) goto L16;
        if (getFunction(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        int r2 = 0;
    L18:
        if (r2 >= getPropertyCount()) goto L24;
        if (getProperty(r2).isInitialized() == false) goto L21;
        r2 = r2 + 1;
        goto L18
    L21:
        this.memoizedIsInitialized = 0;
        return false;
    L24:
        int r3 = 0;
    L26:
        if (r3 >= getTypeAliasCount()) goto L33;
        if (getTypeAlias(r3).isInitialized() == false) goto L29;
        r3 = r3 + 1;
        goto L26
    L29:
        this.memoizedIsInitialized = 0;
        return false;
    L33:
        if (hasTypeTable() == false) goto L39;
        if (getTypeTable().isInitialized() == true) goto L39;
        this.memoizedIsInitialized = 0;
        return false;
    L39:
        if (extensionsAreInitialized() == true) goto L42;
        this.memoizedIsInitialized = 0;
        return false;
    L42:
        this.memoizedIsInitialized = 1;
        return true;
    }

    private void initFields() {
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.access$11600();
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

    public static ProtoBuf$Package getDefaultInstance() {
        return defaultInstance;
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Package> getParserForType() {
        return PARSER;
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Package getDefaultInstanceForType() {
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

    private ProtoBuf$Package(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Package, ?> r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$11800(ProtoBuf$Package r0) {
        return r0.function_;
    }

    public static /* synthetic */ List access$11900(ProtoBuf$Package r0) {
        return r0.property_;
    }

    public static /* synthetic */ List access$12000(ProtoBuf$Package r0) {
        return r0.typeAlias_;
    }

    public static /* synthetic */ ByteString access$12400(ProtoBuf$Package r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Package r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Function getFunction(int r2) {
        return (ProtoBuf$Function) ListProtector.get(this.function_, r2);
    }

    public ProtoBuf$Property getProperty(int r2) {
        return (ProtoBuf$Property) ListProtector.get(this.property_, r2);
    }

    public ProtoBuf$TypeAlias getTypeAlias(int r2) {
        return (ProtoBuf$TypeAlias) ListProtector.get(this.typeAlias_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r6) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.function_.size()) goto L6;
        r6.writeMessage(3, (MessageLite) ListProtector.get(this.function_, r2));
        r2 = r2 + 1;
        goto L4
    L6:
        int r3 = 0;
    L8:
        if (r3 >= this.property_.size()) goto L11;
        r6.writeMessage(4, (MessageLite) ListProtector.get(this.property_, r3));
        r3 = r3 + 1;
    L11:
        if (r1 >= this.typeAlias_.size()) goto L14;
        r6.writeMessage(5, (MessageLite) ListProtector.get(this.typeAlias_, r1));
        r1 = r1 + 1;
        goto L11
    L14:
        if ((this.bitField0_ & 1) != 1) goto L17;
        r6.writeMessage(30, this.typeTable_);
    L17:
        if ((this.bitField0_ & 2) != 2) goto L19;
        r6.writeMessage(32, this.versionRequirementTable_);
    L19:
        r0.writeUntil(200, r6);
        r6.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Package(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$Package(CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L73;
        int r7 = r11.readTag();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        if (r7 == 0) goto L47;
        if (r7 != 26) goto L10;
        if ((r4 & 1) == 1) goto L45;
        this.function_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        r4 = r4 | 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L45:
        this.function_.add((ProtoBuf$Function) r11.readMessage(ProtoBuf$Function.PARSER, r12));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L10:
        if (r7 != 34) goto L12;
        if ((r4 & 2) == 2) goto L41;
        this.property_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        r4 = r4 | 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L41:
        this.property_.add((ProtoBuf$Property) r11.readMessage(ProtoBuf$Property.PARSER, r12));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L12:
        if (r7 != 42) goto L13;
        if ((r4 & 4) == 4) goto L37;
        this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        r4 = r4 | 4;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L37:
        this.typeAlias_.add((ProtoBuf$TypeAlias) r11.readMessage(ProtoBuf$TypeAlias.PARSER, r12));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L13:
        ProtoBuf$VersionRequirementTable.Builder r9 = null;
        ProtoBuf$TypeTable.Builder r10 = null;
        if (r7 != 242) goto L16;
        if ((this.bitField0_ & 1) != 1) goto L30;
        r10 = this.typeTable_.mo380toBuilder();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L30:
        ProtoBuf$TypeTable r8 = (ProtoBuf$TypeTable) r11.readMessage(ProtoBuf$TypeTable.PARSER, r12);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.typeTable_ = r8;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        if (r10 == null) goto L33;
        r10.mergeFrom(r8);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.typeTable_ = r10.buildPartial();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L33:
        this.bitField0_ |= 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L16:
        if (r7 != 258) goto L18;
        if ((this.bitField0_ & 2) != 2) goto L23;
        r9 = this.versionRequirementTable_.mo380toBuilder();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L23:
        ProtoBuf$VersionRequirementTable r13 = (ProtoBuf$VersionRequirementTable) r11.readMessage(ProtoBuf$VersionRequirementTable.PARSER, r12);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.versionRequirementTable_ = r13;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        if (r9 == null) goto L26;
        r9.mergeFrom(r13);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.versionRequirementTable_ = r9.buildPartial();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L26:
        this.bitField0_ |= 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L18:
        if (parseUnknownField(r11, r2, r12, r7) == true) goto L4;
    L47:
        r3 = true;
        goto L4
    L48:
        th = move-exception;
        if ((r4 & 1) != 1) goto L60;
        this.function_ = Collections.unmodifiableList(this.function_);
    L60:
        if ((r4 & 2) != 2) goto L63;
        this.property_ = Collections.unmodifiableList(this.property_);
    L63:
        if ((r4 & 4) != 4) goto L92;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L92:
        r2.flush();     // Catch: IOException -> L89 Throwable -> L67
    L67:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L66:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L53:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L48
    L50:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L48
    L73:
        if ((r4 & 1) != 1) goto L76;
        this.function_ = Collections.unmodifiableList(this.function_);
    L76:
        if ((r4 & 2) != 2) goto L79;
        this.property_ = Collections.unmodifiableList(this.property_);
    L79:
        if ((r4 & 4) != 4) goto L94;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L94:
        r2.flush();     // Catch: IOException -> L88 Throwable -> L83
    L83:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L82:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ List access$11802(ProtoBuf$Package r0, List r1) {
        r0.function_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$11902(ProtoBuf$Package r0, List r1) {
        r0.property_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$12002(ProtoBuf$Package r0, List r1) {
        r0.typeAlias_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$TypeTable access$12102(ProtoBuf$Package r0, ProtoBuf$TypeTable r1) {
        r0.typeTable_ = r1;
        return r1;
    }

    public static /* synthetic */ ProtoBuf$VersionRequirementTable access$12202(ProtoBuf$Package r0, ProtoBuf$VersionRequirementTable r1) {
        r0.versionRequirementTable_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$12302(ProtoBuf$Package r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public static ProtoBuf$Package parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
        return PARSER.parseFrom(r1, r2);
    }

    public /* synthetic */ ProtoBuf$Package(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Package(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
