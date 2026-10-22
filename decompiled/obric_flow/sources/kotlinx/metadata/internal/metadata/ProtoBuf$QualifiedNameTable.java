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
public final class ProtoBuf$QualifiedNameTable extends GeneratedMessageLite implements kotlinx.metadata.internal.protobuf.a0 {
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int QUALIFIED_NAME_FIELD_NUMBER = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$QualifiedNameTable f19065a = null;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<QualifiedName> qualifiedName_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    public static final class QualifiedName extends GeneratedMessageLite implements v {
        public static final int KIND_FIELD_NUMBER = 3;
        public static final int PARENT_QUALIFIED_NAME_FIELD_NUMBER = 1;
        public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
        public static final int SHORT_NAME_FIELD_NUMBER = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final QualifiedName f19066a = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Kind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int parentQualifiedName_;
        private int shortName_;
        private final kotlinx.metadata.internal.protobuf.e unknownFields;

        public static final enum Kind extends Enum<Kind> implements kotlinx.metadata.internal.protobuf.r {
            public static final Kind CLASS = null;
            public static final int CLASS_VALUE = 0;
            public static final Kind LOCAL = null;
            public static final int LOCAL_VALUE = 2;
            public static final Kind PACKAGE = null;
            public static final int PACKAGE_VALUE = 1;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final u f19067a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ Kind[] f19068b = null;
            private final int value;

            static {
                Kind r5 = new Kind("CLASS", 0, 0);
                CLASS = r5;
                Kind r10 = new Kind("PACKAGE", 1, 1);
                PACKAGE = r10;
                Kind r11 = new Kind("LOCAL", 2, 2);
                LOCAL = r11;
                f19068b = new Kind[]{r5, r10, r11};
                f19067a = new u();
            }

            public Kind(String r5, int r10, int r11) {
                super(r5, r10);
                this.value = r11;
            }

            public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
                return f19067a;
            }

            public static Kind valueOf(String r5) {
                return (Kind) Enum.valueOf(Kind.class, r5);
            }

            public static Kind[] values() {
                return (Kind[]) f19068b.clone();
            }

            @Override // kotlinx.metadata.internal.protobuf.r
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int r5) {
                if (r5 == 0) goto L14;
                if (r5 == 1) goto L12;
                if (r5 == 2) goto L10;
                return null;
            L10:
                return LOCAL;
            L12:
                return PACKAGE;
            L14:
                return CLASS;
            }
        }

        static {
            PARSER = new s();
            QualifiedName r5 = new QualifiedName();
            f19066a = r5;
            r5.parentQualifiedName_ = -1;
            r5.shortName_ = 0;
            r5.kind_ = Kind.PACKAGE;
        }

        public QualifiedName(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.f19190a;
        }

        public static /* synthetic */ int access$1002(QualifiedName r5, int r10) {
            r5.shortName_ = r10;
            return r10;
        }

        public static /* synthetic */ Kind access$1102(QualifiedName r5, Kind r10) {
            r5.kind_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$1202(QualifiedName r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$1300(QualifiedName r5) {
            return r5.unknownFields;
        }

        public static /* synthetic */ int access$902(QualifiedName r5, int r10) {
            r5.parentQualifiedName_ = r10;
            return r10;
        }

        public static QualifiedName getDefaultInstance() {
            return f19066a;
        }

        public static t newBuilder(QualifiedName r5) {
            t r10 = newBuilder();
            r10.g(r5);
            return r10;
        }

        public static QualifiedName parseDelimitedFrom(InputStream r5) throws IOException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static QualifiedName parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Kind getKind() {
            return this.kind_;
        }

        public int getParentQualifiedName() {
            return this.parentQualifiedName_;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = kotlinx.metadata.internal.protobuf.g.c(1, this.parentQualifiedName_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(2, this.shortName_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r10 = r10 + kotlinx.metadata.internal.protobuf.g.b(3, this.kind_.getNumber());
        L15:
            int r11 = this.unknownFields.size() + r10;
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r10 = 0;
            goto L10
        }

        public int getShortName() {
            return this.shortName_;
        }

        public boolean hasKind() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasParentQualifiedName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasShortName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
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
            if (hasShortName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y toBuilder() {
            return toBuilder();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public void writeTo(kotlinx.metadata.internal.protobuf.g r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.n(1, this.parentQualifiedName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.n(2, this.shortName_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r5.m(3, this.kind_.getNumber());
        L11:
            r5.r(this.unknownFields);
        }

        public static t newBuilder() {
            t r5 = new t();
            r5.f19140c = -1;
            r5.e = Kind.PACKAGE;
            return r5;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public QualifiedName getDefaultInstanceForType() {
            return f19066a;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public t newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public t toBuilder() {
            return newBuilder(this);
        }

        public static QualifiedName parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
        }

        public static QualifiedName parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
        }

        public QualifiedName() {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
        }

        public static QualifiedName parseFrom(byte[] r5) throws InvalidProtocolBufferException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public QualifiedName(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.parentQualifiedName_ = -1;
            boolean r13 = false;
            this.shortName_ = 0;
            this.kind_ = Kind.PACKAGE;
            kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
            kotlinx.metadata.internal.protobuf.g r14 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
        L3:
            if (r13 == true) goto L50;
            int r15 = r10.n();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            if (r15 == 0) goto L14;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            this.parentQualifiedName_ = r10.k();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (r15 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            this.shortName_ = r10.k();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L11:
            if (r15 != 24) goto L13;
            int r16 = r10.k();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            Kind r17 = Kind.valueOf(r16);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            if (r17 == null) goto L23;
            this.bitField0_ |= 4;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            this.kind_ = r17;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L23:
            r14.v(r15);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            r14.v(r16);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L13:
            if (parseUnknownField(r10, r14, r11, r15) == true) goto L3;
        L14:
            r13 = true;
            goto L3
        L15:
            th = move-exception;
            r14.i();     // Catch: IOException -> L46 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r5.e();
            throw th;
        L33:
            this.unknownFields = r5.e();
            makeExtensionsImmutable();
            throw th;
        L19:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L15
        L17:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L15
        L50:
            r14.i();     // Catch: IOException -> L47 Throwable -> L41
        L41:
            th = move-exception;
            this.unknownFields = r5.e();
            throw th;
        L40:
            this.unknownFields = r5.e();
            makeExtensionsImmutable();
        }

        public static QualifiedName parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
        }

        public static QualifiedName parseFrom(InputStream r5) throws IOException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static QualifiedName parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
        }

        public static QualifiedName parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static QualifiedName parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
            return (QualifiedName) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
        }
    }

    static {
        PARSER = new au.b(11);
        ProtoBuf$QualifiedNameTable r5 = new ProtoBuf$QualifiedNameTable();
        f19065a = r5;
        r5.qualifiedName_ = Collections.emptyList();
    }

    public ProtoBuf$QualifiedNameTable(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ List access$1600(ProtoBuf$QualifiedNameTable r5) {
        return r5.qualifiedName_;
    }

    public static /* synthetic */ List access$1602(ProtoBuf$QualifiedNameTable r5, List r10) {
        r5.qualifiedName_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$1700(ProtoBuf$QualifiedNameTable r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$QualifiedNameTable getDefaultInstance() {
        return f19065a;
    }

    public static r newBuilder(ProtoBuf$QualifiedNameTable r5) {
        r r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$QualifiedNameTable parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    public QualifiedName getQualifiedName(int r5) {
        return this.qualifiedName_.get(r5);
    }

    public int getQualifiedNameCount() {
        return this.qualifiedName_.size();
    }

    public List<QualifiedName> getQualifiedNameList() {
        return this.qualifiedName_;
    }

    public v getQualifiedNameOrBuilder(int r5) {
        return this.qualifiedName_.get(r5);
    }

    public List<? extends v> getQualifiedNameOrBuilderList() {
        return this.qualifiedName_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r10 >= this.qualifiedName_.size()) goto L9;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(1, this.qualifiedName_.get(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        int r12 = this.unknownFields.size() + r11;
        this.memoizedSerializedSize = r12;
        return r12;
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
        if (r10 >= getQualifiedNameCount()) goto L16;
        if (getQualifiedName(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(kotlinx.metadata.internal.protobuf.g r5) throws IOException {
        getSerializedSize();
        int r10 = 0;
    L4:
        if (r10 >= this.qualifiedName_.size()) goto L6;
        r5.p(1, this.qualifiedName_.get(r10));
        r10 = r10 + 1;
        goto L4
    L6:
        r5.r(this.unknownFields);
    }

    public static r newBuilder() {
        r r5 = new r();
        r5.f19138c = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$QualifiedNameTable getDefaultInstanceForType() {
        return f19065a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public r newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public r toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$QualifiedNameTable parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$QualifiedNameTable() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$QualifiedNameTable(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.qualifiedName_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        boolean r15 = false;
    L3:
        if (r14 == true) goto L34;
        int r16 = r10.n();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        if (r16 == 0) goto L10;
        if (r16 != 10) goto L9;
        if (r15 == true) goto L19;
        this.qualifiedName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        r15 = true;
    L19:
        this.qualifiedName_.add((QualifiedName) r10.g(QualifiedName.PARSER, r11));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        goto L3
    L9:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L3;
    L10:
        r14 = true;
        goto L3
    L11:
        th = move-exception;
        if (r15 != true) goto L46;
        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
    L46:
        r5.i();     // Catch: IOException -> L44 Throwable -> L29
    L29:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L28:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L15:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
    L34:
        if (r15 != true) goto L48;
        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
    L48:
        r5.i();     // Catch: IOException -> L43 Throwable -> L38
    L38:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L37:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$QualifiedNameTable parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$QualifiedNameTable) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
