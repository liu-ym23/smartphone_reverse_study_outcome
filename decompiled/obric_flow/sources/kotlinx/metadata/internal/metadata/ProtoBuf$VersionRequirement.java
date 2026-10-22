package kotlinx.metadata.internal.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBuf$VersionRequirement extends GeneratedMessageLite implements i0 {
    public static final int ERROR_CODE_FIELD_NUMBER = 4;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 5;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int VERSION_FULL_FIELD_NUMBER = 2;
    public static final int VERSION_KIND_FIELD_NUMBER = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$VersionRequirement f19080a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int errorCode_;
    private Level level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private int versionFull_;
    private VersionKind versionKind_;
    private int version_;

    public static final enum Level extends Enum<Level> implements kotlinx.metadata.internal.protobuf.r {
        public static final Level ERROR = null;
        public static final int ERROR_VALUE = 1;
        public static final Level HIDDEN = null;
        public static final int HIDDEN_VALUE = 2;
        public static final Level WARNING = null;
        public static final int WARNING_VALUE = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g0 f19081a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Level[] f19082b = null;
        private final int value;

        static {
            Level r5 = new Level("WARNING", 0, 0);
            WARNING = r5;
            Level r10 = new Level("ERROR", 1, 1);
            ERROR = r10;
            Level r11 = new Level("HIDDEN", 2, 2);
            HIDDEN = r11;
            f19082b = new Level[]{r5, r10, r11};
            f19081a = new g0();
        }

        public Level(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
            return f19081a;
        }

        public static Level valueOf(String r5) {
            return (Level) Enum.valueOf(Level.class, r5);
        }

        public static Level[] values() {
            return (Level[]) f19082b.clone();
        }

        @Override // kotlinx.metadata.internal.protobuf.r
        public final int getNumber() {
            return this.value;
        }

        public static Level valueOf(int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L10;
            return null;
        L10:
            return HIDDEN;
        L12:
            return ERROR;
        L14:
            return WARNING;
        }
    }

    public static final enum VersionKind extends Enum<VersionKind> implements kotlinx.metadata.internal.protobuf.r {
        public static final VersionKind API_VERSION = null;
        public static final int API_VERSION_VALUE = 2;
        public static final VersionKind COMPILER_VERSION = null;
        public static final int COMPILER_VERSION_VALUE = 1;
        public static final VersionKind LANGUAGE_VERSION = null;
        public static final int LANGUAGE_VERSION_VALUE = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f19083a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ VersionKind[] f19084b = null;
        private final int value;

        static {
            VersionKind r5 = new VersionKind("LANGUAGE_VERSION", 0, 0);
            LANGUAGE_VERSION = r5;
            VersionKind r10 = new VersionKind("COMPILER_VERSION", 1, 1);
            COMPILER_VERSION = r10;
            VersionKind r11 = new VersionKind("API_VERSION", 2, 2);
            API_VERSION = r11;
            f19084b = new VersionKind[]{r5, r10, r11};
            f19083a = new h0();
        }

        public VersionKind(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
            return f19083a;
        }

        public static VersionKind valueOf(String r5) {
            return (VersionKind) Enum.valueOf(VersionKind.class, r5);
        }

        public static VersionKind[] values() {
            return (VersionKind[]) f19084b.clone();
        }

        @Override // kotlinx.metadata.internal.protobuf.r
        public final int getNumber() {
            return this.value;
        }

        public static VersionKind valueOf(int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L10;
            return null;
        L10:
            return API_VERSION;
        L12:
            return COMPILER_VERSION;
        L14:
            return LANGUAGE_VERSION;
        }
    }

    static {
        PARSER = new au.b(18);
        ProtoBuf$VersionRequirement r5 = new ProtoBuf$VersionRequirement();
        f19080a = r5;
        r5.version_ = 0;
        r5.versionFull_ = 0;
        r5.level_ = Level.ERROR;
        r5.errorCode_ = 0;
        r5.message_ = 0;
        r5.versionKind_ = VersionKind.LANGUAGE_VERSION;
    }

    public ProtoBuf$VersionRequirement(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$21202(ProtoBuf$VersionRequirement r5, int r10) {
        r5.version_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$21302(ProtoBuf$VersionRequirement r5, int r10) {
        r5.versionFull_ = r10;
        return r10;
    }

    public static /* synthetic */ Level access$21402(ProtoBuf$VersionRequirement r5, Level r10) {
        r5.level_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$21502(ProtoBuf$VersionRequirement r5, int r10) {
        r5.errorCode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$21602(ProtoBuf$VersionRequirement r5, int r10) {
        r5.message_ = r10;
        return r10;
    }

    public static /* synthetic */ VersionKind access$21702(ProtoBuf$VersionRequirement r5, VersionKind r10) {
        r5.versionKind_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$21802(ProtoBuf$VersionRequirement r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$21900(ProtoBuf$VersionRequirement r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$VersionRequirement getDefaultInstance() {
        return f19080a;
    }

    public static f0 newBuilder(ProtoBuf$VersionRequirement r5) {
        f0 r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$VersionRequirement parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$VersionRequirement parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public Level getLevel() {
        return this.level_;
    }

    public int getMessage() {
        return this.message_;
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
        int r10 = kotlinx.metadata.internal.protobuf.g.c(1, this.version_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(2, this.versionFull_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.b(3, this.level_.getNumber());
    L16:
        if ((this.bitField0_ & 8) != 8) goto L19;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(4, this.errorCode_);
    L19:
        if ((this.bitField0_ & 16) != 16) goto L22;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(5, this.message_);
    L22:
        if ((this.bitField0_ & 32) != 32) goto L24;
        r10 = r10 + kotlinx.metadata.internal.protobuf.g.b(6, this.versionKind_.getNumber());
    L24:
        int r11 = this.unknownFields.size() + r10;
        this.memoizedSerializedSize = r11;
        return r11;
    L8:
        r10 = 0;
        goto L10
    }

    public int getVersion() {
        return this.version_;
    }

    public int getVersionFull() {
        return this.versionFull_;
    }

    public VersionKind getVersionKind() {
        return this.versionKind_;
    }

    public boolean hasErrorCode() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasLevel() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasMessage() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasVersion() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasVersionFull() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasVersionKind() {
        if ((this.bitField0_ & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.a0
    public final boolean isInitialized() {
        byte r5 = this.memoizedIsInitialized;
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 != 0) goto L8;
        return false;
    L8:
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
        r5.n(1, this.version_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r5.n(2, this.versionFull_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L12;
        r5.m(3, this.level_.getNumber());
    L12:
        if ((this.bitField0_ & 8) != 8) goto L15;
        r5.n(4, this.errorCode_);
    L15:
        if ((this.bitField0_ & 16) != 16) goto L18;
        r5.n(5, this.message_);
    L18:
        if ((this.bitField0_ & 32) != 32) goto L20;
        r5.m(6, this.versionKind_.getNumber());
    L20:
        r5.r(this.unknownFields);
    }

    public static f0 newBuilder() {
        f0 r5 = new f0();
        r5.e = Level.ERROR;
        r5.f19114h = VersionKind.LANGUAGE_VERSION;
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$VersionRequirement getDefaultInstanceForType() {
        return f19080a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public f0 newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public f0 toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$VersionRequirement parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$VersionRequirement parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$VersionRequirement() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$VersionRequirement parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$VersionRequirement(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean r13 = false;
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = Level.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r14 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
    L3:
        if (r13 == true) goto L62;
        int r15 = r10.n();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r15 == 0) goto L20;
        if (r15 != 8) goto L9;
        this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.version_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L9:
        if (r15 != 16) goto L11;
        this.bitField0_ |= 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.versionFull_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L11:
        if (r15 != 24) goto L13;
        int r16 = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        Level r17 = Level.valueOf(r16);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r17 == null) goto L35;
        this.bitField0_ |= 4;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.level_ = r17;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L35:
        r14.v(r15);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        r14.v(r16);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L13:
        if (r15 != 32) goto L15;
        this.bitField0_ |= 8;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.errorCode_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L15:
        if (r15 != 40) goto L17;
        this.bitField0_ |= 16;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.message_ = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L17:
        if (r15 != 48) goto L19;
        int r18 = r10.k();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        VersionKind r19 = VersionKind.valueOf(r18);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        if (r19 == null) goto L29;
        this.bitField0_ |= 32;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        this.versionKind_ = r19;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L29:
        r14.v(r15);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        r14.v(r18);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        goto L3
    L19:
        if (parseUnknownField(r10, r14, r11, r15) == true) goto L3;
    L20:
        r13 = true;
        goto L3
    L21:
        th = move-exception;
        r14.i();     // Catch: IOException -> L58 Throwable -> L46
    L46:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L45:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
        throw th;
    L23:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L25:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L62:
        r14.i();     // Catch: IOException -> L59 Throwable -> L53
    L53:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L52:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$VersionRequirement parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$VersionRequirement parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$VersionRequirement parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$VersionRequirement parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$VersionRequirement parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$VersionRequirement) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
