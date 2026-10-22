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
public final class ProtoBuf$PackageFragment extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$PackageFragment> {
    public static final int CLASS_FIELD_NUMBER = 4;
    public static final int PACKAGE_FIELD_NUMBER = 3;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int QUALIFIED_NAMES_FIELD_NUMBER = 2;
    public static final int STRINGS_FIELD_NUMBER = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$PackageFragment f19063a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private List<ProtoBuf$Class> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private ProtoBuf$Package package_;
    private ProtoBuf$QualifiedNameTable qualifiedNames_;
    private ProtoBuf$StringTable strings_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(9);
        ProtoBuf$PackageFragment r5 = new ProtoBuf$PackageFragment();
        f19063a = r5;
        r5.strings_ = ProtoBuf$StringTable.getDefaultInstance();
        r5.qualifiedNames_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        r5.package_ = ProtoBuf$Package.getDefaultInstance();
        r5.class__ = Collections.emptyList();
    }

    public ProtoBuf$PackageFragment(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ ProtoBuf$StringTable access$22802(ProtoBuf$PackageFragment r5, ProtoBuf$StringTable r10) {
        r5.strings_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$QualifiedNameTable access$22902(ProtoBuf$PackageFragment r5, ProtoBuf$QualifiedNameTable r10) {
        r5.qualifiedNames_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Package access$23002(ProtoBuf$PackageFragment r5, ProtoBuf$Package r10) {
        r5.package_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$23100(ProtoBuf$PackageFragment r5) {
        return r5.class__;
    }

    public static /* synthetic */ List access$23102(ProtoBuf$PackageFragment r5, List r10) {
        r5.class__ = r10;
        return r10;
    }

    public static /* synthetic */ int access$23202(ProtoBuf$PackageFragment r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$23300(ProtoBuf$PackageFragment r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$PackageFragment getDefaultInstance() {
        return f19063a;
    }

    public static au.m newBuilder(ProtoBuf$PackageFragment r5) {
        au.m r10 = newBuilder();
        r10.i(r5);
        return r10;
    }

    public static ProtoBuf$PackageFragment parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$PackageFragment parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Class getClass_(int r5) {
        return this.class__.get(r5);
    }

    public int getClass_Count() {
        return this.class__.size();
    }

    public List<ProtoBuf$Class> getClass_List() {
        return this.class__;
    }

    public au.d getClass_OrBuilder(int r5) {
        return this.class__.get(r5);
    }

    public List<? extends au.d> getClass_OrBuilderList() {
        return this.class__;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public ProtoBuf$Package getPackage() {
        return this.package_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    public ProtoBuf$QualifiedNameTable getQualifiedNames() {
        return this.qualifiedNames_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r11 = kotlinx.metadata.internal.protobuf.g.e(1, this.strings_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(2, this.qualifiedNames_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(3, this.package_);
    L16:
        if (r10 >= this.class__.size()) goto L18;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(4, this.class__.get(r10));
        r10 = r10 + 1;
        goto L16
    L18:
        int r12 = this.unknownFields.size() + (extensionsSerializedSize() + r11);
        this.memoizedSerializedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    public ProtoBuf$StringTable getStrings() {
        return this.strings_;
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

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L6;
        return true;
    L6:
        if (r5 != 0) goto L9;
        return false;
    L9:
        if (hasQualifiedNames() == false) goto L15;
        if (getQualifiedNames().isInitialized() == true) goto L15;
        this.memoizedIsInitialized = 0;
        return false;
    L15:
        if (hasPackage() == true) goto L17;
    L20:
        int r10 = 0;
    L22:
        if (r10 >= getClass_Count()) goto L29;
        if (getClass_(r10).isInitialized() == false) goto L25;
        r10 = r10 + 1;
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
    public void writeTo(kotlinx.metadata.internal.protobuf.g r5) throws IOException {
        getSerializedSize();
        kotlinx.metadata.internal.protobuf.o r10 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r5.p(1, this.strings_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r5.p(2, this.qualifiedNames_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L11;
        r5.p(3, this.package_);
    L11:
        int r11 = 0;
    L13:
        if (r11 >= this.class__.size()) goto L15;
        r5.p(4, this.class__.get(r11));
        r11 = r11 + 1;
        goto L13
    L15:
        r10.a(200, r5);
        r5.r(this.unknownFields);
    }

    public static au.m newBuilder() {
        au.m r5 = new au.m();
        r5.e = ProtoBuf$StringTable.getDefaultInstance();
        r5.f = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        r5.g = ProtoBuf$Package.getDefaultInstance();
        r5.f755h = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$PackageFragment getDefaultInstanceForType() {
        return f19063a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.m newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public au.m toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$PackageFragment parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$PackageFragment parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$PackageFragment() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$PackageFragment parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$PackageFragment(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.strings_ = ProtoBuf$StringTable.getDefaultInstance();
        this.qualifiedNames_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        this.package_ = ProtoBuf$Package.getDefaultInstance();
        this.class__ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        char r15 = 0;
    L4:
        if (r14 == true) goto L65;
        int r16 = r10.n();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r16 == 0) goto L17;
        au.l r17 = null;
        au.p r18 = null;
        r r19 = null;
        if (r16 != 10) goto L10;
        if ((this.bitField0_ & 1) != 1) goto L45;
        r18 = this.strings_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L45:
        ProtoBuf$StringTable r20 = (ProtoBuf$StringTable) r10.g(ProtoBuf$StringTable.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.strings_ = r20;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r18 == null) goto L48;
        r18.g(r20);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.strings_ = r18.f();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L48:
        this.bitField0_ |= 1;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L10:
        if (r16 != 18) goto L12;
        if ((this.bitField0_ & 2) != 2) goto L38;
        r19 = this.qualifiedNames_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L38:
        ProtoBuf$QualifiedNameTable r21 = (ProtoBuf$QualifiedNameTable) r10.g(ProtoBuf$QualifiedNameTable.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.qualifiedNames_ = r21;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r19 == null) goto L41;
        r19.g(r21);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.qualifiedNames_ = r19.f();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L41:
        this.bitField0_ |= 2;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L12:
        if (r16 != 26) goto L14;
        if ((this.bitField0_ & 4) != 4) goto L31;
        r17 = this.package_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L31:
        ProtoBuf$Package r22 = (ProtoBuf$Package) r10.g(ProtoBuf$Package.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.package_ = r22;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r17 == null) goto L34;
        r17.j(r22);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.package_ = r17.h();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L34:
        this.bitField0_ |= 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L14:
        if (r16 != 34) goto L16;
        int r23 = (r15 == true ? 1 : 0) & '\b';     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r15 = r15;
        if (r23 == 8) goto L27;
        this.class__ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r15 = '\b';
    L27:
        this.class__.add((ProtoBuf$Class) r10.g(ProtoBuf$Class.PARSER, r11));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L16:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L4;
    L17:
        r14 = true;
        goto L4
    L18:
        th = move-exception;
        if (((r15 == true ? 1 : 0) & '\b') != 8) goto L79;
        this.class__ = Collections.unmodifiableList(this.class__);
    L79:
        r5.i();     // Catch: IOException -> L75 Throwable -> L59
    L59:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L58:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L22:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L18
    L20:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L18
    L65:
        if (((r15 == true ? 1 : 0) & '\b') != 8) goto L77;
        this.class__ = Collections.unmodifiableList(this.class__);
    L77:
        r5.i();     // Catch: IOException -> L74 Throwable -> L69
    L69:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L68:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$PackageFragment parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$PackageFragment parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$PackageFragment parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$PackageFragment parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$PackageFragment parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$PackageFragment) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
