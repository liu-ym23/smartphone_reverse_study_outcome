package kotlinx.metadata.internal.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.b0;
import kotlinx.metadata.internal.protobuf.c0;
import kotlinx.metadata.internal.protobuf.f;
import kotlinx.metadata.internal.protobuf.g;
import kotlinx.metadata.internal.protobuf.i;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.p0;
import kotlinx.metadata.internal.protobuf.u;
import kotlinx.metadata.internal.protobuf.v;
import kotlinx.metadata.internal.protobuf.x;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmModuleProtoBuf$PackageParts extends GeneratedMessageLite implements bu.d {
    public static final int CLASS_WITH_JVM_PACKAGE_NAME_MULTIFILE_FACADE_SHORT_NAME_ID_FIELD_NUMBER = 7;
    public static final int CLASS_WITH_JVM_PACKAGE_NAME_PACKAGE_ID_FIELD_NUMBER = 6;
    public static final int CLASS_WITH_JVM_PACKAGE_NAME_SHORT_NAME_FIELD_NUMBER = 5;
    public static final int MULTIFILE_FACADE_SHORT_NAME_FIELD_NUMBER = 4;
    public static final int MULTIFILE_FACADE_SHORT_NAME_ID_FIELD_NUMBER = 3;
    public static final int PACKAGE_FQ_NAME_FIELD_NUMBER = 1;
    public static b0 PARSER = null;
    public static final int SHORT_CLASS_NAME_FIELD_NUMBER = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JvmModuleProtoBuf$PackageParts f19118a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize;
    private List<Integer> classWithJvmPackageNameMultifileFacadeShortNameId_;
    private int classWithJvmPackageNamePackageIdMemoizedSerializedSize;
    private List<Integer> classWithJvmPackageNamePackageId_;
    private v classWithJvmPackageNameShortName_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int multifileFacadeShortNameIdMemoizedSerializedSize;
    private List<Integer> multifileFacadeShortNameId_;
    private v multifileFacadeShortName_;
    private Object packageFqName_;
    private v shortClassName_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    static {
        PARSER = new au.b(21);
        JvmModuleProtoBuf$PackageParts r5 = new JvmModuleProtoBuf$PackageParts();
        f19118a = r5;
        r5.packageFqName_ = "";
        p0 r10 = u.f19207b;
        r5.shortClassName_ = r10;
        r5.multifileFacadeShortNameId_ = Collections.emptyList();
        r5.multifileFacadeShortName_ = r10;
        r5.classWithJvmPackageNameShortName_ = r10;
        r5.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
        r5.classWithJvmPackageNamePackageId_ = Collections.emptyList();
    }

    public JvmModuleProtoBuf$PackageParts(m r5, bu.a r10) {
        super(r5);
        this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
        this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
        this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ Object access$1500(JvmModuleProtoBuf$PackageParts r5) {
        return r5.packageFqName_;
    }

    public static /* synthetic */ Object access$1502(JvmModuleProtoBuf$PackageParts r5, Object r10) {
        r5.packageFqName_ = r10;
        return r10;
    }

    public static /* synthetic */ v access$1600(JvmModuleProtoBuf$PackageParts r5) {
        return r5.shortClassName_;
    }

    public static /* synthetic */ v access$1602(JvmModuleProtoBuf$PackageParts r5, v r10) {
        r5.shortClassName_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$1700(JvmModuleProtoBuf$PackageParts r5) {
        return r5.multifileFacadeShortNameId_;
    }

    public static /* synthetic */ List access$1702(JvmModuleProtoBuf$PackageParts r5, List r10) {
        r5.multifileFacadeShortNameId_ = r10;
        return r10;
    }

    public static /* synthetic */ v access$1800(JvmModuleProtoBuf$PackageParts r5) {
        return r5.multifileFacadeShortName_;
    }

    public static /* synthetic */ v access$1802(JvmModuleProtoBuf$PackageParts r5, v r10) {
        r5.multifileFacadeShortName_ = r10;
        return r10;
    }

    public static /* synthetic */ v access$1900(JvmModuleProtoBuf$PackageParts r5) {
        return r5.classWithJvmPackageNameShortName_;
    }

    public static /* synthetic */ v access$1902(JvmModuleProtoBuf$PackageParts r5, v r10) {
        r5.classWithJvmPackageNameShortName_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$2000(JvmModuleProtoBuf$PackageParts r5) {
        return r5.classWithJvmPackageNameMultifileFacadeShortNameId_;
    }

    public static /* synthetic */ List access$2002(JvmModuleProtoBuf$PackageParts r5, List r10) {
        r5.classWithJvmPackageNameMultifileFacadeShortNameId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$2100(JvmModuleProtoBuf$PackageParts r5) {
        return r5.classWithJvmPackageNamePackageId_;
    }

    public static /* synthetic */ List access$2102(JvmModuleProtoBuf$PackageParts r5, List r10) {
        r5.classWithJvmPackageNamePackageId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$2202(JvmModuleProtoBuf$PackageParts r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$2300(JvmModuleProtoBuf$PackageParts r5) {
        return r5.unknownFields;
    }

    public static JvmModuleProtoBuf$PackageParts getDefaultInstance() {
        return f19118a;
    }

    public static bu.c newBuilder(JvmModuleProtoBuf$PackageParts r5) {
        bu.c r10 = newBuilder();
        r10.h(r5);
        return r10;
    }

    public static JvmModuleProtoBuf$PackageParts parseDelimitedFrom(InputStream r5) throws IOException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public int getClassWithJvmPackageNameMultifileFacadeShortNameId(int r5) {
        return this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(r5).intValue();
    }

    public int getClassWithJvmPackageNameMultifileFacadeShortNameIdCount() {
        return this.classWithJvmPackageNameMultifileFacadeShortNameId_.size();
    }

    public List<Integer> getClassWithJvmPackageNameMultifileFacadeShortNameIdList() {
        return this.classWithJvmPackageNameMultifileFacadeShortNameId_;
    }

    public int getClassWithJvmPackageNamePackageId(int r5) {
        return this.classWithJvmPackageNamePackageId_.get(r5).intValue();
    }

    public int getClassWithJvmPackageNamePackageIdCount() {
        return this.classWithJvmPackageNamePackageId_.size();
    }

    public List<Integer> getClassWithJvmPackageNamePackageIdList() {
        return this.classWithJvmPackageNamePackageId_;
    }

    public String getClassWithJvmPackageNameShortName(int r5) {
        return (String) this.classWithJvmPackageNameShortName_.get(r5);
    }

    public kotlinx.metadata.internal.protobuf.e getClassWithJvmPackageNameShortNameBytes(int r5) {
        return this.classWithJvmPackageNameShortName_.getByteString(r5);
    }

    public int getClassWithJvmPackageNameShortNameCount() {
        return this.classWithJvmPackageNameShortName_.size();
    }

    public c0 getClassWithJvmPackageNameShortNameList() {
        return this.classWithJvmPackageNameShortName_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public String getMultifileFacadeShortName(int r5) {
        return (String) this.multifileFacadeShortName_.get(r5);
    }

    public kotlinx.metadata.internal.protobuf.e getMultifileFacadeShortNameBytes(int r5) {
        return this.multifileFacadeShortName_.getByteString(r5);
    }

    public int getMultifileFacadeShortNameCount() {
        return this.multifileFacadeShortName_.size();
    }

    public int getMultifileFacadeShortNameId(int r5) {
        return this.multifileFacadeShortNameId_.get(r5).intValue();
    }

    public int getMultifileFacadeShortNameIdCount() {
        return this.multifileFacadeShortNameId_.size();
    }

    public List<Integer> getMultifileFacadeShortNameIdList() {
        return this.multifileFacadeShortNameId_;
    }

    public c0 getMultifileFacadeShortNameList() {
        return this.multifileFacadeShortName_;
    }

    public String getPackageFqName() {
        Object r5 = this.packageFqName_;
        if ((r5 instanceof String) == true) goto L5;
        kotlinx.metadata.internal.protobuf.e r10 = (kotlinx.metadata.internal.protobuf.e) r5;
        String r11 = r10.p();
        if (r10.i() == false) goto L9;
        this.packageFqName_ = r11;
    L9:
        return r11;
    L5:
        return (String) r5;
    }

    public kotlinx.metadata.internal.protobuf.e getPackageFqNameBytes() {
        Object r5 = this.packageFqName_;
        if ((r5 instanceof String) == false) goto L7;
        x r10 = kotlinx.metadata.internal.protobuf.e.d((String) r5);
        this.packageFqName_ = r10;
        return r10;
    L7:
        return (kotlinx.metadata.internal.protobuf.e) r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        kotlinx.metadata.internal.protobuf.e r11 = getPackageFqNameBytes();
        int r12 = g.a(r11) + g.h(1);
    L9:
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r13 >= this.shortClassName_.size()) goto L13;
        r14 = r14 + g.a(this.shortClassName_.getByteString(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r15 = getShortClassNameList().size() + (r12 + r14);
        int r16 = 0;
        int r17 = 0;
    L15:
        if (r16 >= this.multifileFacadeShortNameId_.size()) goto L17;
        r17 = androidx.room.jarjarred.org.antlr.runtime.a.f(r17, this.multifileFacadeShortNameId_.get(r16));
        r16 = r16 + 1;
        goto L15
    L17:
        int r18 = r15 + r17;
        if (getMultifileFacadeShortNameIdList().isEmpty() == true) goto L20;
        r18 = (r18 + 1) + g.d(r17);
    L20:
        this.multifileFacadeShortNameIdMemoizedSerializedSize = r17;
        int r19 = 0;
        int r20 = 0;
    L22:
        if (r19 >= this.multifileFacadeShortName_.size()) goto L24;
        r20 = r20 + g.a(this.multifileFacadeShortName_.getByteString(r19));
        r19 = r19 + 1;
        goto L22
    L24:
        int r21 = getMultifileFacadeShortNameList().size() + (r18 + r20);
        int r22 = 0;
        int r23 = 0;
    L26:
        if (r22 >= this.classWithJvmPackageNameShortName_.size()) goto L28;
        r23 = r23 + g.a(this.classWithJvmPackageNameShortName_.getByteString(r22));
        r22 = r22 + 1;
        goto L26
    L28:
        int r24 = getClassWithJvmPackageNameShortNameList().size() + (r21 + r23);
        int r25 = 0;
        int r26 = 0;
    L30:
        if (r25 >= this.classWithJvmPackageNamePackageId_.size()) goto L32;
        r26 = androidx.room.jarjarred.org.antlr.runtime.a.f(r26, this.classWithJvmPackageNamePackageId_.get(r25));
        r25 = r25 + 1;
        goto L30
    L32:
        int r27 = r24 + r26;
        if (getClassWithJvmPackageNamePackageIdList().isEmpty() == true) goto L35;
        r27 = (r27 + 1) + g.d(r26);
    L35:
        this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = r26;
        int r28 = 0;
    L37:
        if (r10 >= this.classWithJvmPackageNameMultifileFacadeShortNameId_.size()) goto L39;
        r28 = androidx.room.jarjarred.org.antlr.runtime.a.f(r28, this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(r10));
        r10 = r10 + 1;
        goto L37
    L39:
        int r29 = r27 + r28;
        if (getClassWithJvmPackageNameMultifileFacadeShortNameIdList().isEmpty() == true) goto L42;
        r29 = (r29 + 1) + g.d(r28);
    L42:
        this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = r28;
        int r30 = this.unknownFields.size() + r29;
        this.memoizedSerializedSize = r30;
        return r30;
    L8:
        r12 = 0;
        goto L9
    }

    public String getShortClassName(int r5) {
        return (String) this.shortClassName_.get(r5);
    }

    public kotlinx.metadata.internal.protobuf.e getShortClassNameBytes(int r5) {
        return this.shortClassName_.getByteString(r5);
    }

    public int getShortClassNameCount() {
        return this.shortClassName_.size();
    }

    public c0 getShortClassNameList() {
        return this.shortClassName_;
    }

    public boolean hasPackageFqName() {
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
        if (r5 != 0) goto L9;
        return false;
    L9:
        if (hasPackageFqName() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        this.memoizedIsInitialized = 1;
        return true;
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
    public void writeTo(g r5) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) != 1) goto L5;
        r5.l(1, getPackageFqNameBytes());
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r11 >= this.shortClassName_.size()) goto L10;
        r5.l(2, this.shortClassName_.getByteString(r11));
        r11 = r11 + 1;
        goto L7
    L10:
        if (getMultifileFacadeShortNameIdList().size() <= 0) goto L12;
        r5.v(26);
        r5.v(this.multifileFacadeShortNameIdMemoizedSerializedSize);
    L12:
        int r12 = 0;
    L14:
        if (r12 >= this.multifileFacadeShortNameId_.size()) goto L16;
        r5.o(this.multifileFacadeShortNameId_.get(r12).intValue());
        r12 = r12 + 1;
        goto L14
    L16:
        int r13 = 0;
    L18:
        if (r13 >= this.multifileFacadeShortName_.size()) goto L20;
        r5.l(4, this.multifileFacadeShortName_.getByteString(r13));
        r13 = r13 + 1;
        goto L18
    L20:
        int r14 = 0;
    L22:
        if (r14 >= this.classWithJvmPackageNameShortName_.size()) goto L25;
        r5.l(5, this.classWithJvmPackageNameShortName_.getByteString(r14));
        r14 = r14 + 1;
        goto L22
    L25:
        if (getClassWithJvmPackageNamePackageIdList().size() <= 0) goto L27;
        r5.v(50);
        r5.v(this.classWithJvmPackageNamePackageIdMemoizedSerializedSize);
    L27:
        int r15 = 0;
    L29:
        if (r15 >= this.classWithJvmPackageNamePackageId_.size()) goto L32;
        r5.o(this.classWithJvmPackageNamePackageId_.get(r15).intValue());
        r15 = r15 + 1;
        goto L29
    L32:
        if (getClassWithJvmPackageNameMultifileFacadeShortNameIdList().size() <= 0) goto L35;
        r5.v(58);
        r5.v(this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize);
    L35:
        if (r10 >= this.classWithJvmPackageNameMultifileFacadeShortNameId_.size()) goto L37;
        r5.o(this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(r10).intValue());
        r10 = r10 + 1;
        goto L35
    L37:
        r5.r(this.unknownFields);
    }

    public static bu.c newBuilder() {
        return bu.c.g();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public JvmModuleProtoBuf$PackageParts getDefaultInstanceForType() {
        return f19118a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public bu.c newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public bu.c toBuilder() {
        return newBuilder(this);
    }

    public static JvmModuleProtoBuf$PackageParts parseDelimitedFrom(InputStream r5, i r10) throws IOException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(kotlinx.metadata.internal.protobuf.e r5, i r10) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public JvmModuleProtoBuf$PackageParts() {
        this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
        this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
        this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(byte[] r5, i r10) throws InvalidProtocolBufferException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(InputStream r5) throws IOException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public JvmModuleProtoBuf$PackageParts(f r18, i r19, bu.a r20) throws InvalidProtocolBufferException {
        this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
        this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
        this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.packageFqName_ = "";
        p0 r5 = u.f19207b;
        this.shortClassName_ = r5;
        this.multifileFacadeShortNameId_ = Collections.emptyList();
        this.multifileFacadeShortName_ = r5;
        this.classWithJvmPackageNameShortName_ = r5;
        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
        this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r10 = new kotlinx.metadata.internal.protobuf.d();
        boolean r11 = true;
        g r12 = g.j(r10, 1);
        boolean r13 = false;
        int r14 = 0;
    L4:
        if (r13 == true) goto L103;
        int r15 = r18.n();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        switch(r15) {
            case 0: goto L71;
            case 10: goto L69;
            case 18: goto L65;
            case 24: goto L62;
            case 26: goto L52;
            case 34: goto L48;
            case 42: goto L44;
            case 48: goto L41;
            case 50: goto L31;
            case 56: goto L28;
            case 58: goto L17;
            default: goto L8;
        };     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L17:
        int r16 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r14 & 32) == 32) goto L23;
        if (r18.b() <= 0) goto L23;
        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L23:
        if (r18.b() <= 0) goto L25;
        this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(r18.k()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L23
    L25:
        r18.c(r16);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L26:
        boolean r17 = true;
    L72:
        r11 = r17;
        goto L4
    L31:
        int r21 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r14 & 64) == 64) goto L37;
        if (r18.b() <= 0) goto L37;
        this.classWithJvmPackageNamePackageId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L37:
        if (r18.b() <= 0) goto L39;
        this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(r18.k()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L37
    L39:
        r18.c(r21);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L44:
        x r22 = r18.e();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r14 & 16) == 16) goto L47;
        this.classWithJvmPackageNameShortName_ = new u();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 16;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L47:
        this.classWithJvmPackageNameShortName_.a(r22);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L48:
        x r23 = r18.e();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r14 & 8) == 8) goto L51;
        this.multifileFacadeShortName_ = new u();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 8;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L51:
        this.multifileFacadeShortName_.a(r23);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L52:
        int r24 = r18.d(r18.k());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r14 & 4) == 4) goto L58;
        if (r18.b() <= 0) goto L58;
        this.multifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 4;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L58:
        if (r18.b() <= 0) goto L60;
        this.multifileFacadeShortNameId_.add(Integer.valueOf(r18.k()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L58
    L60:
        r18.c(r24);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L65:
        x r25 = r18.e();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if ((r14 & 2) == 2) goto L68;
        this.shortClassName_ = new u();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 2;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L68:
        this.shortClassName_.a(r25);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L69:
        x r26 = r18.e();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r17 = true;
        this.bitField0_ |= 1;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        this.packageFqName_ = r26;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L72
    L71:
        r17 = r11;
        r13 = r17;
        goto L72
    L8:
        if (parseUnknownField(r18, r12, r19, r15) == true) goto L10;
        r13 = r11;
        r17 = r13;
        goto L72
    L10:
        r17 = r11;
        goto L72
    L28:
        if ((r14 & 32) == 32) goto L30;
        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L30:
        this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(r18.k()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L41:
        if ((r14 & 64) == 64) goto L43;
        this.classWithJvmPackageNamePackageId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L43:
        this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(r18.k()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L62:
        if ((r14 & 4) == 4) goto L64;
        this.multifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r14 = r14 | 4;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
    L64:
        this.multifileFacadeShortNameId_.add(Integer.valueOf(r18.k()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L26
    L11:
        th = move-exception;
        if ((r14 & 2) != 2) goto L81;
        this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
    L81:
        if ((r14 & 4) != 4) goto L84;
        this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
    L84:
        if ((r14 & 8) != 8) goto L87;
        this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
    L87:
        if ((r14 & 16) != 16) goto L90;
        this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
    L90:
        if ((r14 & 64) != 64) goto L93;
        this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
    L93:
        if ((r14 & 32) != 32) goto L132;
        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
    L132:
        r12.i();     // Catch: IOException -> L128 Throwable -> L97
    L97:
        th = move-exception;
        this.unknownFields = r10.e();
        throw th;
    L96:
        this.unknownFields = r10.e();
        makeExtensionsImmutable();
        throw th;
    L15:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L103:
        if ((r14 & 2) != 2) goto L106;
        this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
    L106:
        if ((r14 & 4) != 4) goto L109;
        this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
    L109:
        if ((r14 & 8) != 8) goto L112;
        this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
    L112:
        if ((r14 & 16) != 16) goto L115;
        this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
    L115:
        if ((r14 & 64) != 64) goto L118;
        this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
    L118:
        if ((r14 & 32) != 32) goto L130;
        this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
    L130:
        r12.i();     // Catch: IOException -> L127 Throwable -> L122
    L122:
        th = move-exception;
        this.unknownFields = r10.e();
        throw th;
    L121:
        this.unknownFields = r10.e();
        makeExtensionsImmutable();
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(InputStream r5, i r10) throws IOException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(f r5) throws IOException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmModuleProtoBuf$PackageParts parseFrom(f r5, i r10) throws IOException {
        return (JvmModuleProtoBuf$PackageParts) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
