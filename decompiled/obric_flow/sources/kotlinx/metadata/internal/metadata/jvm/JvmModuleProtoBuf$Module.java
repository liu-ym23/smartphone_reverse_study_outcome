package kotlinx.metadata.internal.metadata.jvm;

import au.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.metadata.ProtoBuf$Annotation;
import kotlinx.metadata.internal.metadata.ProtoBuf$Class;
import kotlinx.metadata.internal.metadata.ProtoBuf$QualifiedNameTable;
import kotlinx.metadata.internal.metadata.ProtoBuf$StringTable;
import kotlinx.metadata.internal.metadata.i;
import kotlinx.metadata.internal.metadata.r;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.b0;
import kotlinx.metadata.internal.protobuf.c0;
import kotlinx.metadata.internal.protobuf.f;
import kotlinx.metadata.internal.protobuf.g;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.u;
import kotlinx.metadata.internal.protobuf.v;
import kotlinx.metadata.internal.protobuf.x;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmModuleProtoBuf$Module extends GeneratedMessageLite implements a0 {
    public static final int ANNOTATION_FIELD_NUMBER = 6;
    public static final int JVM_PACKAGE_NAME_FIELD_NUMBER = 3;
    public static final int METADATA_PARTS_FIELD_NUMBER = 2;
    public static final int OPTIONAL_ANNOTATION_CLASS_FIELD_NUMBER = 16;
    public static final int PACKAGE_PARTS_FIELD_NUMBER = 1;
    public static b0 PARSER = null;
    public static final int QUALIFIED_NAME_TABLE_FIELD_NUMBER = 5;
    public static final int STRING_TABLE_FIELD_NUMBER = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JvmModuleProtoBuf$Module f19117a = null;
    private static final long serialVersionUID = 0;
    private List<ProtoBuf$Annotation> annotation_;
    private int bitField0_;
    private v jvmPackageName_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<JvmModuleProtoBuf$PackageParts> metadataParts_;
    private List<ProtoBuf$Class> optionalAnnotationClass_;
    private List<JvmModuleProtoBuf$PackageParts> packageParts_;
    private ProtoBuf$QualifiedNameTable qualifiedNameTable_;
    private ProtoBuf$StringTable stringTable_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(20);
        JvmModuleProtoBuf$Module r5 = new JvmModuleProtoBuf$Module();
        f19117a = r5;
        r5.a();
    }

    public JvmModuleProtoBuf$Module(m r5, bu.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$1002(JvmModuleProtoBuf$Module r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$1100(JvmModuleProtoBuf$Module r5) {
        return r5.unknownFields;
    }

    public static /* synthetic */ List access$300(JvmModuleProtoBuf$Module r5) {
        return r5.packageParts_;
    }

    public static /* synthetic */ List access$302(JvmModuleProtoBuf$Module r5, List r10) {
        r5.packageParts_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(JvmModuleProtoBuf$Module r5) {
        return r5.metadataParts_;
    }

    public static /* synthetic */ List access$402(JvmModuleProtoBuf$Module r5, List r10) {
        r5.metadataParts_ = r10;
        return r10;
    }

    public static /* synthetic */ v access$500(JvmModuleProtoBuf$Module r5) {
        return r5.jvmPackageName_;
    }

    public static /* synthetic */ v access$502(JvmModuleProtoBuf$Module r5, v r10) {
        r5.jvmPackageName_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$StringTable access$602(JvmModuleProtoBuf$Module r5, ProtoBuf$StringTable r10) {
        r5.stringTable_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$QualifiedNameTable access$702(JvmModuleProtoBuf$Module r5, ProtoBuf$QualifiedNameTable r10) {
        r5.qualifiedNameTable_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$800(JvmModuleProtoBuf$Module r5) {
        return r5.annotation_;
    }

    public static /* synthetic */ List access$802(JvmModuleProtoBuf$Module r5, List r10) {
        r5.annotation_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$900(JvmModuleProtoBuf$Module r5) {
        return r5.optionalAnnotationClass_;
    }

    public static /* synthetic */ List access$902(JvmModuleProtoBuf$Module r5, List r10) {
        r5.optionalAnnotationClass_ = r10;
        return r10;
    }

    public static JvmModuleProtoBuf$Module getDefaultInstance() {
        return f19117a;
    }

    public static bu.b newBuilder(JvmModuleProtoBuf$Module r5) {
        bu.b r10 = newBuilder();
        r10.h(r5);
        return r10;
    }

    public static JvmModuleProtoBuf$Module parseDelimitedFrom(InputStream r5) throws IOException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmModuleProtoBuf$Module parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public final void a() {
        this.packageParts_ = Collections.emptyList();
        this.metadataParts_ = Collections.emptyList();
        this.jvmPackageName_ = u.f19207b;
        this.stringTable_ = ProtoBuf$StringTable.getDefaultInstance();
        this.qualifiedNameTable_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        this.annotation_ = Collections.emptyList();
        this.optionalAnnotationClass_ = Collections.emptyList();
    }

    public ProtoBuf$Annotation getAnnotation(int r5) {
        return this.annotation_.get(r5);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<ProtoBuf$Annotation> getAnnotationList() {
        return this.annotation_;
    }

    public i getAnnotationOrBuilder(int r5) {
        return this.annotation_.get(r5);
    }

    public List<? extends i> getAnnotationOrBuilderList() {
        return this.annotation_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public String getJvmPackageName(int r5) {
        return (String) this.jvmPackageName_.get(r5);
    }

    public kotlinx.metadata.internal.protobuf.e getJvmPackageNameBytes(int r5) {
        return this.jvmPackageName_.getByteString(r5);
    }

    public int getJvmPackageNameCount() {
        return this.jvmPackageName_.size();
    }

    public c0 getJvmPackageNameList() {
        return this.jvmPackageName_;
    }

    public JvmModuleProtoBuf$PackageParts getMetadataParts(int r5) {
        return this.metadataParts_.get(r5);
    }

    public int getMetadataPartsCount() {
        return this.metadataParts_.size();
    }

    public List<JvmModuleProtoBuf$PackageParts> getMetadataPartsList() {
        return this.metadataParts_;
    }

    public bu.d getMetadataPartsOrBuilder(int r5) {
        return this.metadataParts_.get(r5);
    }

    public List<? extends bu.d> getMetadataPartsOrBuilderList() {
        return this.metadataParts_;
    }

    public ProtoBuf$Class getOptionalAnnotationClass(int r5) {
        return this.optionalAnnotationClass_.get(r5);
    }

    public int getOptionalAnnotationClassCount() {
        return this.optionalAnnotationClass_.size();
    }

    public List<ProtoBuf$Class> getOptionalAnnotationClassList() {
        return this.optionalAnnotationClass_;
    }

    public au.d getOptionalAnnotationClassOrBuilder(int r5) {
        return this.optionalAnnotationClass_.get(r5);
    }

    public List<? extends au.d> getOptionalAnnotationClassOrBuilderList() {
        return this.optionalAnnotationClass_;
    }

    public JvmModuleProtoBuf$PackageParts getPackageParts(int r5) {
        return this.packageParts_.get(r5);
    }

    public int getPackagePartsCount() {
        return this.packageParts_.size();
    }

    public List<JvmModuleProtoBuf$PackageParts> getPackagePartsList() {
        return this.packageParts_;
    }

    public bu.d getPackagePartsOrBuilder(int r5) {
        return this.packageParts_.get(r5);
    }

    public List<? extends bu.d> getPackagePartsOrBuilderList() {
        return this.packageParts_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public b0 getParserForType() {
        return PARSER;
    }

    public ProtoBuf$QualifiedNameTable getQualifiedNameTable() {
        return this.qualifiedNameTable_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.packageParts_.size()) goto L9;
        r12 = r12 + g.e(1, this.packageParts_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.metadataParts_.size()) goto L13;
        r12 = r12 + g.e(2, this.metadataParts_.get(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r14 = 0;
        int r15 = 0;
    L15:
        if (r14 >= this.jvmPackageName_.size()) goto L17;
        r15 = r15 + g.a(this.jvmPackageName_.getByteString(r14));
        r14 = r14 + 1;
        goto L15
    L17:
        int r16 = getJvmPackageNameList().size() + (r12 + r15);
        if ((this.bitField0_ & 1) != 1) goto L21;
        r16 = r16 + g.e(4, this.stringTable_);
    L21:
        if ((this.bitField0_ & 2) != 2) goto L23;
        r16 = r16 + g.e(5, this.qualifiedNameTable_);
    L23:
        int r17 = 0;
    L25:
        if (r17 >= this.annotation_.size()) goto L28;
        r16 = r16 + g.e(6, this.annotation_.get(r17));
        r17 = r17 + 1;
    L28:
        if (r10 >= this.optionalAnnotationClass_.size()) goto L30;
        r16 = r16 + g.e(16, this.optionalAnnotationClass_.get(r10));
        r10 = r10 + 1;
        goto L28
    L30:
        int r18 = this.unknownFields.size() + r16;
        this.memoizedSerializedSize = r18;
        return r18;
    }

    public ProtoBuf$StringTable getStringTable() {
        return this.stringTable_;
    }

    public boolean hasQualifiedNameTable() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasStringTable() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
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
        if (r10 >= getPackagePartsCount()) goto L16;
        if (getPackageParts(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        int r11 = 0;
    L18:
        if (r11 >= getMetadataPartsCount()) goto L25;
        if (getMetadataParts(r11).isInitialized() == false) goto L21;
        r11 = r11 + 1;
        goto L18
    L21:
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (hasQualifiedNameTable() == true) goto L27;
    L30:
        int r12 = 0;
    L32:
        if (r12 >= getAnnotationCount()) goto L38;
        if (getAnnotation(r12).isInitialized() == false) goto L35;
        r12 = r12 + 1;
        goto L32
    L35:
        this.memoizedIsInitialized = 0;
        return false;
    L38:
        int r13 = 0;
    L40:
        if (r13 >= getOptionalAnnotationClassCount()) goto L46;
        if (getOptionalAnnotationClass(r13).isInitialized() == false) goto L43;
        r13 = r13 + 1;
        goto L40
    L43:
        this.memoizedIsInitialized = 0;
        return false;
    L46:
        this.memoizedIsInitialized = 1;
        return true;
    L27:
        if (getQualifiedNameTable().isInitialized() == true) goto L30;
        this.memoizedIsInitialized = 0;
        return false;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(g r10) throws IOException {
        getSerializedSize();
        int r5 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.packageParts_.size()) goto L6;
        r10.p(1, this.packageParts_.get(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        int r12 = 0;
    L8:
        if (r12 >= this.metadataParts_.size()) goto L10;
        r10.p(2, this.metadataParts_.get(r12));
        r12 = r12 + 1;
        goto L8
    L10:
        int r13 = 0;
    L12:
        if (r13 >= this.jvmPackageName_.size()) goto L15;
        r10.l(3, this.jvmPackageName_.getByteString(r13));
        r13 = r13 + 1;
        goto L12
    L15:
        if ((this.bitField0_ & 1) != 1) goto L18;
        r10.p(4, this.stringTable_);
    L18:
        if ((this.bitField0_ & 2) != 2) goto L20;
        r10.p(5, this.qualifiedNameTable_);
    L20:
        int r14 = 0;
    L22:
        if (r14 >= this.annotation_.size()) goto L25;
        r10.p(6, this.annotation_.get(r14));
        r14 = r14 + 1;
    L25:
        if (r5 >= this.optionalAnnotationClass_.size()) goto L27;
        r10.p(16, this.optionalAnnotationClass_.get(r5));
        r5 = r5 + 1;
        goto L25
    L27:
        r10.r(this.unknownFields);
    }

    public static bu.b newBuilder() {
        return bu.b.g();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public JvmModuleProtoBuf$Module getDefaultInstanceForType() {
        return f19117a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public bu.b newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public bu.b toBuilder() {
        return newBuilder(this);
    }

    public static JvmModuleProtoBuf$Module parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static JvmModuleProtoBuf$Module parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public JvmModuleProtoBuf$Module() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static JvmModuleProtoBuf$Module parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public JvmModuleProtoBuf$Module(f r12, kotlinx.metadata.internal.protobuf.i r13, bu.a r14) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        a();
        kotlinx.metadata.internal.protobuf.d r15 = new kotlinx.metadata.internal.protobuf.d();
        g r5 = g.j(r15, 1);
        boolean r10 = false;
        int r11 = 0;
    L4:
        if (r10 == true) goto L92;
        int r16 = r12.n();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r16 == 0) goto L23;
        if (r16 != 10) goto L10;
        int r17 = (r11 == true ? 1 : 0) & 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = r11;
        if (r17 == 1) goto L63;
        this.packageParts_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = (r11 == true ? 1 : 0) | 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L63:
        this.packageParts_.add((JvmModuleProtoBuf$PackageParts) r12.g(JvmModuleProtoBuf$PackageParts.PARSER, r13));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L10:
        if (r16 != 18) goto L12;
        int r18 = (r11 == true ? 1 : 0) & 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = r11;
        if (r18 == 2) goto L59;
        this.metadataParts_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = (r11 == true ? 1 : 0) | 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L59:
        this.metadataParts_.add((JvmModuleProtoBuf$PackageParts) r12.g(JvmModuleProtoBuf$PackageParts.PARSER, r13));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L12:
        if (r16 != 26) goto L13;
        x r19 = r12.e();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        int r20 = (r11 == true ? 1 : 0) & 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = r11;
        if (r20 == 4) goto L55;
        this.jvmPackageName_ = new u();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = (r11 == true ? 1 : 0) | 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L55:
        this.jvmPackageName_.a(r19);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L13:
        r r110 = null;
        p r111 = null;
        if (r16 != 34) goto L16;
        if ((this.bitField0_ & 1) != 1) goto L48;
        r111 = this.stringTable_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L48:
        ProtoBuf$StringTable r21 = (ProtoBuf$StringTable) r12.g(ProtoBuf$StringTable.PARSER, r13);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.stringTable_ = r21;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r111 == null) goto L51;
        r111.g(r21);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.stringTable_ = r111.f();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L51:
        this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L16:
        if (r16 != 42) goto L18;
        if ((this.bitField0_ & 2) != 2) goto L41;
        r110 = this.qualifiedNameTable_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L41:
        ProtoBuf$QualifiedNameTable r22 = (ProtoBuf$QualifiedNameTable) r12.g(ProtoBuf$QualifiedNameTable.PARSER, r13);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.qualifiedNameTable_ = r22;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r110 == null) goto L44;
        r110.g(r22);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.qualifiedNameTable_ = r110.f();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L44:
        this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L18:
        if (r16 != 50) goto L20;
        int r23 = (r11 == true ? 1 : 0) & 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = r11;
        if (r23 == 32) goto L37;
        this.annotation_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = (r11 == true ? 1 : 0) | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L37:
        this.annotation_.add((ProtoBuf$Annotation) r12.g(ProtoBuf$Annotation.PARSER, r13));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L20:
        if (r16 != 130) goto L22;
        int r24 = (r11 == true ? 1 : 0) & 64;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = r11;
        if (r24 == 64) goto L33;
        this.optionalAnnotationClass_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r11 = (r11 == true ? 1 : 0) | 64;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L33:
        this.optionalAnnotationClass_.add((ProtoBuf$Class) r12.g(ProtoBuf$Class.PARSER, r13));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L22:
        if (parseUnknownField(r12, r5, r13, r16) == true) goto L4;
    L23:
        r10 = true;
        goto L4
    L24:
        th = move-exception;
        if (((r11 == true ? 1 : 0) & 1) != 1) goto L73;
        this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
    L73:
        if (((r11 == true ? 1 : 0) & 2) != 2) goto L76;
        this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
    L76:
        if (((r11 == true ? 1 : 0) & 4) != 4) goto L79;
        this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
    L79:
        if (((r11 == true ? 1 : 0) & 32) != 32) goto L82;
        this.annotation_ = Collections.unmodifiableList(this.annotation_);
    L82:
        if (((r11 == true ? 1 : 0) & 64) != 64) goto L119;
        this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
    L119:
        r5.i();     // Catch: IOException -> L114 Throwable -> L86
    L86:
        th = move-exception;
        this.unknownFields = r15.e();
        throw th;
    L85:
        this.unknownFields = r15.e();
        makeExtensionsImmutable();
        throw th;
    L26:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L28:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L92:
        if (((r11 == true ? 1 : 0) & 1) != 1) goto L95;
        this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
    L95:
        if (((r11 == true ? 1 : 0) & 2) != 2) goto L98;
        this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
    L98:
        if (((r11 == true ? 1 : 0) & 4) != 4) goto L101;
        this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
    L101:
        if (((r11 == true ? 1 : 0) & 32) != 32) goto L104;
        this.annotation_ = Collections.unmodifiableList(this.annotation_);
    L104:
        if (((r11 == true ? 1 : 0) & 64) != 64) goto L117;
        this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
    L117:
        r5.i();     // Catch: IOException -> L113 Throwable -> L108
    L108:
        th = move-exception;
        this.unknownFields = r15.e();
        throw th;
    L107:
        this.unknownFields = r15.e();
        makeExtensionsImmutable();
    }

    public static JvmModuleProtoBuf$Module parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static JvmModuleProtoBuf$Module parseFrom(InputStream r5) throws IOException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmModuleProtoBuf$Module parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static JvmModuleProtoBuf$Module parseFrom(f r5) throws IOException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmModuleProtoBuf$Module parseFrom(f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (JvmModuleProtoBuf$Module) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
