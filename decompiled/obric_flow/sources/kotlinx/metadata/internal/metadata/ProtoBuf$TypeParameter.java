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
public final class ProtoBuf$TypeParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeParameter> implements e0 {
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int REIFIED_FIELD_NUMBER = 3;
    public static final int UPPER_BOUND_FIELD_NUMBER = 5;
    public static final int UPPER_BOUND_ID_FIELD_NUMBER = 6;
    public static final int VARIANCE_FIELD_NUMBER = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$TypeParameter f19075a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<ProtoBuf$Type> upperBound_;
    private Variance variance_;

    public static final enum Variance extends Enum<Variance> implements kotlinx.metadata.internal.protobuf.r {
        public static final Variance IN = null;
        public static final Variance INV = null;
        public static final int INV_VALUE = 2;
        public static final int IN_VALUE = 0;
        public static final Variance OUT = null;
        public static final int OUT_VALUE = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d0 f19076a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Variance[] f19077b = null;
        private final int value;

        static {
            Variance r5 = new Variance("IN", 0, 0);
            IN = r5;
            Variance r10 = new Variance("OUT", 1, 1);
            OUT = r10;
            Variance r11 = new Variance("INV", 2, 2);
            INV = r11;
            f19077b = new Variance[]{r5, r10, r11};
            f19076a = new d0();
        }

        public Variance(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
            return f19076a;
        }

        public static Variance valueOf(String r5) {
            return (Variance) Enum.valueOf(Variance.class, r5);
        }

        public static Variance[] values() {
            return (Variance[]) f19077b.clone();
        }

        @Override // kotlinx.metadata.internal.protobuf.r
        public final int getNumber() {
            return this.value;
        }

        public static Variance valueOf(int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L10;
            return null;
        L10:
            return INV;
        L12:
            return OUT;
        L14:
            return IN;
        }
    }

    static {
        PARSER = new au.b(15);
        ProtoBuf$TypeParameter r5 = new ProtoBuf$TypeParameter();
        f19075a = r5;
        r5.id_ = 0;
        r5.name_ = 0;
        r5.reified_ = false;
        r5.variance_ = Variance.INV;
        r5.upperBound_ = Collections.emptyList();
        r5.upperBoundId_ = Collections.emptyList();
    }

    public ProtoBuf$TypeParameter(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$7802(ProtoBuf$TypeParameter r5, int r10) {
        r5.id_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$7902(ProtoBuf$TypeParameter r5, int r10) {
        r5.name_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$8002(ProtoBuf$TypeParameter r5, boolean r10) {
        r5.reified_ = r10;
        return r10;
    }

    public static /* synthetic */ Variance access$8102(ProtoBuf$TypeParameter r5, Variance r10) {
        r5.variance_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$8200(ProtoBuf$TypeParameter r5) {
        return r5.upperBound_;
    }

    public static /* synthetic */ List access$8202(ProtoBuf$TypeParameter r5, List r10) {
        r5.upperBound_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$8300(ProtoBuf$TypeParameter r5) {
        return r5.upperBoundId_;
    }

    public static /* synthetic */ List access$8302(ProtoBuf$TypeParameter r5, List r10) {
        r5.upperBoundId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$8402(ProtoBuf$TypeParameter r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$8500(ProtoBuf$TypeParameter r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$TypeParameter getDefaultInstance() {
        return f19075a;
    }

    public static c0 newBuilder(ProtoBuf$TypeParameter r5) {
        c0 r10 = newBuilder();
        r10.i(r5);
        return r10;
    }

    public static ProtoBuf$TypeParameter parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeParameter parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getId() {
        return this.id_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    public boolean getReified() {
        return this.reified_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.id_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(2, this.name_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r11 = r11 + (kotlinx.metadata.internal.protobuf.g.h(3) + 1);
    L16:
        if ((this.bitField0_ & 8) != 8) goto L18;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.b(4, this.variance_.getNumber());
    L18:
        int r12 = 0;
    L20:
        if (r12 >= this.upperBound_.size()) goto L22;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(5, this.upperBound_.get(r12));
        r12 = r12 + 1;
        goto L20
    L22:
        int r13 = 0;
    L24:
        if (r10 >= this.upperBoundId_.size()) goto L26;
        r13 = androidx.room.jarjarred.org.antlr.runtime.a.f(r13, this.upperBoundId_.get(r10));
        r10 = r10 + 1;
        goto L24
    L26:
        int r14 = r11 + r13;
        if (getUpperBoundIdList().isEmpty() == true) goto L29;
        r14 = (r14 + 1) + kotlinx.metadata.internal.protobuf.g.d(r13);
    L29:
        this.upperBoundIdMemoizedSerializedSize = r13;
        int r15 = this.unknownFields.size() + (extensionsSerializedSize() + r14);
        this.memoizedSerializedSize = r15;
        return r15;
    L8:
        r11 = 0;
        goto L10
    }

    public ProtoBuf$Type getUpperBound(int r5) {
        return this.upperBound_.get(r5);
    }

    public int getUpperBoundCount() {
        return this.upperBound_.size();
    }

    public int getUpperBoundId(int r5) {
        return this.upperBoundId_.get(r5).intValue();
    }

    public int getUpperBoundIdCount() {
        return this.upperBoundId_.size();
    }

    public List<Integer> getUpperBoundIdList() {
        return this.upperBoundId_;
    }

    public List<ProtoBuf$Type> getUpperBoundList() {
        return this.upperBound_;
    }

    public b0 getUpperBoundOrBuilder(int r5) {
        return this.upperBound_.get(r5);
    }

    public List<? extends b0> getUpperBoundOrBuilderList() {
        return this.upperBound_;
    }

    public Variance getVariance() {
        return this.variance_;
    }

    public boolean hasId() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasName() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasReified() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasVariance() {
        if ((this.bitField0_ & 8) != 8) goto L5;
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
        if (r5 != 0) goto L9;
        return false;
    L9:
        if (hasId() == true) goto L13;
        this.memoizedIsInitialized = 0;
        return false;
    L13:
        if (hasName() == true) goto L16;
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        int r10 = 0;
    L18:
        if (r10 >= getUpperBoundCount()) goto L25;
        if (getUpperBound(r10).isInitialized() == false) goto L21;
        r10 = r10 + 1;
        goto L18
    L21:
        this.memoizedIsInitialized = 0;
        return false;
    L25:
        if (extensionsAreInitialized() == true) goto L28;
        this.memoizedIsInitialized = 0;
        return false;
    L28:
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
        if ((this.bitField0_ & 1) != 1) goto L6;
        r10.n(1, this.id_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L8;
        r10.n(2, this.name_);
    L8:
        int r11 = 0;
        if ((this.bitField0_ & 4) != 4) goto L12;
        boolean r12 = this.reified_;
        r10.x(3, 0);
        r10.q(r12 ? 1 : 0);
    L12:
        if ((this.bitField0_ & 8) != 8) goto L14;
        r10.m(4, this.variance_.getNumber());
    L14:
        int r13 = 0;
    L16:
        if (r13 >= this.upperBound_.size()) goto L19;
        r10.p(5, this.upperBound_.get(r13));
        r13 = r13 + 1;
        goto L16
    L19:
        if (getUpperBoundIdList().size() <= 0) goto L22;
        r10.v(50);
        r10.v(this.upperBoundIdMemoizedSerializedSize);
    L22:
        if (r11 >= this.upperBoundId_.size()) goto L24;
        r10.o(this.upperBoundId_.get(r11).intValue());
        r11 = r11 + 1;
        goto L22
    L24:
        r5.a(1000, r10);
        r10.r(this.unknownFields);
    }

    public static c0 newBuilder() {
        c0 r5 = new c0();
        r5.f19101h = Variance.INV;
        r5.f19102i = Collections.emptyList();
        r5.f19103j = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$TypeParameter getDefaultInstanceForType() {
        return f19075a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public c0 newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public c0 toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$TypeParameter parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$TypeParameter parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$TypeParameter() {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$TypeParameter parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$TypeParameter(kotlinx.metadata.internal.protobuf.f r12, kotlinx.metadata.internal.protobuf.i r13, au.a r14) throws InvalidProtocolBufferException {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = Variance.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r10 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
        boolean r11 = false;
        int r15 = 0;
    L4:
        if (r11 == true) goto L75;
        int r16 = r12.n();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if (r16 == 0) goto L21;
        if (r16 != 8) goto L9;
        this.bitField0_ |= 1;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        this.id_ = r12.k();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L9:
        if (r16 != 16) goto L11;
        this.bitField0_ |= 2;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        this.name_ = r12.k();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L11:
        if (r16 != 24) goto L12;
        this.bitField0_ |= 4;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if (r12.l() == 0) goto L52;
        boolean r17 = true;
    L53:
        this.reified_ = r17;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L52:
        r17 = false;
        goto L53
    L12:
        if (r16 != 32) goto L14;
        int r18 = r12.k();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        Variance r19 = Variance.valueOf(r18);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if (r19 == null) goto L47;
        this.bitField0_ |= 8;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        this.variance_ = r19;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L47:
        r10.v(r16);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        r10.v(r18);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L14:
        if (r16 != 42) goto L16;
        if ((r15 & 16) == 16) goto L44;
        this.upperBound_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        r15 = r15 | 16;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
    L44:
        this.upperBound_.add((ProtoBuf$Type) r12.g(ProtoBuf$Type.PARSER, r13));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L16:
        if (r16 != 48) goto L18;
        if ((r15 & 32) == 32) goto L40;
        this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        r15 = r15 | 32;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
    L40:
        this.upperBoundId_.add(Integer.valueOf(r12.k()));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L18:
        if (r16 != 50) goto L20;
        int r20 = r12.d(r12.k());     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        if ((r15 & 32) == 32) goto L34;
        if (r12.b() <= 0) goto L34;
        this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        r15 = r15 | 32;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
    L34:
        if (r12.b() <= 0) goto L36;
        this.upperBoundId_.add(Integer.valueOf(r12.k()));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L34
    L36:
        r12.c(r20);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        goto L4
    L20:
        if (parseUnknownField(r12, r10, r13, r16) == true) goto L4;
    L21:
        r11 = true;
        goto L4
    L22:
        th = move-exception;
        if ((r15 & 16) != 16) goto L65;
        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
    L65:
        if ((r15 & 32) != 32) goto L91;
        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
    L91:
        r10.i();     // Catch: IOException -> L88 Throwable -> L69
    L69:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L68:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
        throw th;
    L26:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L22
    L75:
        if ((r15 & 16) != 16) goto L78;
        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
    L78:
        if ((r15 & 32) != 32) goto L93;
        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
    L93:
        r10.i();     // Catch: IOException -> L87 Throwable -> L82
    L82:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L81:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$TypeParameter parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$TypeParameter parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeParameter parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$TypeParameter parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$TypeParameter parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$TypeParameter) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
