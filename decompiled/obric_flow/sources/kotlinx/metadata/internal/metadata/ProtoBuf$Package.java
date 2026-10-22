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
public final class ProtoBuf$Package extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Package> {
    public static final int FUNCTION_FIELD_NUMBER = 3;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int PROPERTY_FIELD_NUMBER = 4;
    public static final int TYPE_ALIAS_FIELD_NUMBER = 5;
    public static final int TYPE_TABLE_FIELD_NUMBER = 30;
    public static final int VERSION_REQUIREMENT_TABLE_FIELD_NUMBER = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Package f19062a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<ProtoBuf$Function> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Property> property_;
    private List<ProtoBuf$TypeAlias> typeAlias_;
    private ProtoBuf$TypeTable typeTable_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;

    static {
        PARSER = new au.b(8);
        ProtoBuf$Package r5 = new ProtoBuf$Package();
        f19062a = r5;
        r5.function_ = Collections.emptyList();
        r5.property_ = Collections.emptyList();
        r5.typeAlias_ = Collections.emptyList();
        r5.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        r5.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
    }

    public ProtoBuf$Package(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ List access$11800(ProtoBuf$Package r5) {
        return r5.function_;
    }

    public static /* synthetic */ List access$11802(ProtoBuf$Package r5, List r10) {
        r5.function_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$11900(ProtoBuf$Package r5) {
        return r5.property_;
    }

    public static /* synthetic */ List access$11902(ProtoBuf$Package r5, List r10) {
        r5.property_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$12000(ProtoBuf$Package r5) {
        return r5.typeAlias_;
    }

    public static /* synthetic */ List access$12002(ProtoBuf$Package r5, List r10) {
        r5.typeAlias_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$TypeTable access$12102(ProtoBuf$Package r5, ProtoBuf$TypeTable r10) {
        r5.typeTable_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$VersionRequirementTable access$12202(ProtoBuf$Package r5, ProtoBuf$VersionRequirementTable r10) {
        r5.versionRequirementTable_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$12302(ProtoBuf$Package r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$12400(ProtoBuf$Package r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Package getDefaultInstance() {
        return f19062a;
    }

    public static au.l newBuilder(ProtoBuf$Package r5) {
        au.l r10 = newBuilder();
        r10.j(r5);
        return r10;
    }

    public static ProtoBuf$Package parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Package parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public ProtoBuf$Function getFunction(int r5) {
        return this.function_.get(r5);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    public au.k getFunctionOrBuilder(int r5) {
        return this.function_.get(r5);
    }

    public List<? extends au.k> getFunctionOrBuilderList() {
        return this.function_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    public ProtoBuf$Property getProperty(int r5) {
        return this.property_.get(r5);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    public au.o getPropertyOrBuilder(int r5) {
        return this.property_.get(r5);
    }

    public List<? extends au.o> getPropertyOrBuilderList() {
        return this.property_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.function_.size()) goto L9;
        r12 = r12 + kotlinx.metadata.internal.protobuf.g.e(3, this.function_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.property_.size()) goto L14;
        r12 = r12 + kotlinx.metadata.internal.protobuf.g.e(4, this.property_.get(r13));
        r13 = r13 + 1;
    L14:
        if (r10 >= this.typeAlias_.size()) goto L17;
        r12 = r12 + kotlinx.metadata.internal.protobuf.g.e(5, this.typeAlias_.get(r10));
        r10 = r10 + 1;
        goto L14
    L17:
        if ((this.bitField0_ & 1) != 1) goto L20;
        r12 = r12 + kotlinx.metadata.internal.protobuf.g.e(30, this.typeTable_);
    L20:
        if ((this.bitField0_ & 2) != 2) goto L22;
        r12 = r12 + kotlinx.metadata.internal.protobuf.g.e(32, this.versionRequirementTable_);
    L22:
        int r14 = this.unknownFields.size() + (extensionsSerializedSize() + r12);
        this.memoizedSerializedSize = r14;
        return r14;
    }

    public ProtoBuf$TypeAlias getTypeAlias(int r5) {
        return this.typeAlias_.get(r5);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
    }

    public au.r getTypeAliasOrBuilder(int r5) {
        return this.typeAlias_.get(r5);
    }

    public List<? extends au.r> getTypeAliasOrBuilderList() {
        return this.typeAlias_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
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

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L6;
        return true;
    L6:
        if (r5 != 0) goto L8;
        return false;
    L8:
        int r10 = 0;
    L10:
        if (r10 >= getFunctionCount()) goto L16;
        if (getFunction(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        int r11 = 0;
    L18:
        if (r11 >= getPropertyCount()) goto L24;
        if (getProperty(r11).isInitialized() == false) goto L21;
        r11 = r11 + 1;
        goto L18
    L21:
        this.memoizedIsInitialized = 0;
        return false;
    L24:
        int r12 = 0;
    L26:
        if (r12 >= getTypeAliasCount()) goto L33;
        if (getTypeAlias(r12).isInitialized() == false) goto L29;
        r12 = r12 + 1;
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
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.function_.size()) goto L6;
        r10.p(3, this.function_.get(r12));
        r12 = r12 + 1;
        goto L4
    L6:
        int r13 = 0;
    L8:
        if (r13 >= this.property_.size()) goto L11;
        r10.p(4, this.property_.get(r13));
        r13 = r13 + 1;
    L11:
        if (r11 >= this.typeAlias_.size()) goto L14;
        r10.p(5, this.typeAlias_.get(r11));
        r11 = r11 + 1;
        goto L11
    L14:
        if ((this.bitField0_ & 1) != 1) goto L17;
        r10.p(30, this.typeTable_);
    L17:
        if ((this.bitField0_ & 2) != 2) goto L19;
        r10.p(32, this.versionRequirementTable_);
    L19:
        r5.a(200, r10);
        r10.r(this.unknownFields);
    }

    public static au.l newBuilder() {
        return au.l.i();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Package getDefaultInstanceForType() {
        return f19062a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.l newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.l toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Package parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Package parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Package() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Package parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Package(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        int r15 = 0;
    L4:
        if (r14 == true) goto L74;
        int r16 = r10.n();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        if (r16 == 0) goto L19;
        if (r16 != 26) goto L10;
        int r17 = (r15 == true ? 1 : 0) & 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r15 = r15;
        if (r17 == 1) goto L51;
        this.function_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r15 = (r15 == true ? 1 : 0) | 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L51:
        this.function_.add((ProtoBuf$Function) r10.g(ProtoBuf$Function.PARSER, r11));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L10:
        if (r16 != 34) goto L12;
        int r18 = (r15 == true ? 1 : 0) & 2;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r15 = r15;
        if (r18 == 2) goto L47;
        this.property_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r15 = (r15 == true ? 1 : 0) | 2;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L47:
        this.property_.add((ProtoBuf$Property) r10.g(ProtoBuf$Property.PARSER, r11));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L12:
        if (r16 != 42) goto L13;
        int r19 = (r15 == true ? 1 : 0) & 4;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r15 = r15;
        if (r19 == 4) goto L43;
        this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        r15 = (r15 == true ? 1 : 0) | 4;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L43:
        this.typeAlias_.add((ProtoBuf$TypeAlias) r10.g(ProtoBuf$TypeAlias.PARSER, r11));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L13:
        au.v r20 = null;
        au.s r21 = null;
        if (r16 != 242) goto L16;
        if ((this.bitField0_ & 1) != 1) goto L36;
        r21 = this.typeTable_.toBuilder();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L36:
        ProtoBuf$TypeTable r22 = (ProtoBuf$TypeTable) r10.g(ProtoBuf$TypeTable.PARSER, r11);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        this.typeTable_ = r22;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        if (r21 == null) goto L39;
        r21.g(r22);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        this.typeTable_ = r21.f();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L39:
        this.bitField0_ |= 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L16:
        if (r16 != 258) goto L18;
        if ((this.bitField0_ & 2) != 2) goto L29;
        r20 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L29:
        ProtoBuf$VersionRequirementTable r23 = (ProtoBuf$VersionRequirementTable) r10.g(ProtoBuf$VersionRequirementTable.PARSER, r11);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        this.versionRequirementTable_ = r23;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        if (r20 == null) goto L32;
        r20.g(r23);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        this.versionRequirementTable_ = r20.f();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
    L32:
        this.bitField0_ |= 2;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        goto L4
    L18:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L4;
    L19:
        r14 = true;
        goto L4
    L20:
        th = move-exception;
        if (((r15 == true ? 1 : 0) & 1) != 1) goto L61;
        this.function_ = Collections.unmodifiableList(this.function_);
    L61:
        if (((r15 == true ? 1 : 0) & 2) != 2) goto L64;
        this.property_ = Collections.unmodifiableList(this.property_);
    L64:
        if (((r15 == true ? 1 : 0) & 4) != 4) goto L93;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L93:
        r5.i();     // Catch: IOException -> L90 Throwable -> L68
    L68:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L67:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L24:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
    L22:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L20
    L74:
        if (((r15 == true ? 1 : 0) & 1) != 1) goto L77;
        this.function_ = Collections.unmodifiableList(this.function_);
    L77:
        if (((r15 == true ? 1 : 0) & 2) != 2) goto L80;
        this.property_ = Collections.unmodifiableList(this.property_);
    L80:
        if (((r15 == true ? 1 : 0) & 4) != 4) goto L95;
        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
    L95:
        r5.i();     // Catch: IOException -> L89 Throwable -> L84
    L84:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L83:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Package parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Package parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Package parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Package parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Package parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Package) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
