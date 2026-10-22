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
public final class ProtoBuf$Expression extends GeneratedMessageLite implements q {
    public static final int AND_ARGUMENT_FIELD_NUMBER = 6;
    public static final int CONSTANT_VALUE_FIELD_NUMBER = 3;
    public static final int FLAGS_FIELD_NUMBER = 1;
    public static final int IS_INSTANCE_TYPE_FIELD_NUMBER = 4;
    public static final int IS_INSTANCE_TYPE_ID_FIELD_NUMBER = 5;
    public static final int OR_ARGUMENT_FIELD_NUMBER = 7;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int VALUE_PARAMETER_REFERENCE_FIELD_NUMBER = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Expression f19054a = null;
    private static final long serialVersionUID = 0;
    private List<ProtoBuf$Expression> andArgument_;
    private int bitField0_;
    private ConstantValue constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private ProtoBuf$Type isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Expression> orArgument_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;
    private int valueParameterReference_;

    public static final enum ConstantValue extends Enum<ConstantValue> implements kotlinx.metadata.internal.protobuf.r {
        public static final ConstantValue FALSE = null;
        public static final int FALSE_VALUE = 1;
        public static final ConstantValue NULL = null;
        public static final int NULL_VALUE = 2;
        public static final ConstantValue TRUE = null;
        public static final int TRUE_VALUE = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f19055a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ConstantValue[] f19056b = null;
        private final int value;

        static {
            ConstantValue r5 = new ConstantValue("TRUE", 0, 0);
            TRUE = r5;
            ConstantValue r10 = new ConstantValue("FALSE", 1, 1);
            FALSE = r10;
            ConstantValue r11 = new ConstantValue("NULL", 2, 2);
            NULL = r11;
            f19056b = new ConstantValue[]{r5, r10, r11};
            f19055a = new p();
        }

        public ConstantValue(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
            return f19055a;
        }

        public static ConstantValue valueOf(String r5) {
            return (ConstantValue) Enum.valueOf(ConstantValue.class, r5);
        }

        public static ConstantValue[] values() {
            return (ConstantValue[]) f19056b.clone();
        }

        @Override // kotlinx.metadata.internal.protobuf.r
        public final int getNumber() {
            return this.value;
        }

        public static ConstantValue valueOf(int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L10;
            return null;
        L10:
            return NULL;
        L12:
            return FALSE;
        L14:
            return TRUE;
        }
    }

    static {
        PARSER = new au.b(6);
        ProtoBuf$Expression r5 = new ProtoBuf$Expression();
        f19054a = r5;
        r5.flags_ = 0;
        r5.valueParameterReference_ = 0;
        r5.constantValue_ = ConstantValue.TRUE;
        r5.isInstanceType_ = ProtoBuf$Type.getDefaultInstance();
        r5.isInstanceTypeId_ = 0;
        r5.andArgument_ = Collections.emptyList();
        r5.orArgument_ = Collections.emptyList();
    }

    public ProtoBuf$Expression(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$25102(ProtoBuf$Expression r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$25202(ProtoBuf$Expression r5, int r10) {
        r5.valueParameterReference_ = r10;
        return r10;
    }

    public static /* synthetic */ ConstantValue access$25302(ProtoBuf$Expression r5, ConstantValue r10) {
        r5.constantValue_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$25402(ProtoBuf$Expression r5, ProtoBuf$Type r10) {
        r5.isInstanceType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$25502(ProtoBuf$Expression r5, int r10) {
        r5.isInstanceTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$25600(ProtoBuf$Expression r5) {
        return r5.andArgument_;
    }

    public static /* synthetic */ List access$25602(ProtoBuf$Expression r5, List r10) {
        r5.andArgument_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$25700(ProtoBuf$Expression r5) {
        return r5.orArgument_;
    }

    public static /* synthetic */ List access$25702(ProtoBuf$Expression r5, List r10) {
        r5.orArgument_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$25802(ProtoBuf$Expression r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$25900(ProtoBuf$Expression r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Expression getDefaultInstance() {
        return f19054a;
    }

    public static o newBuilder(ProtoBuf$Expression r5) {
        o r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$Expression parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Expression parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Expression getAndArgument(int r5) {
        return this.andArgument_.get(r5);
    }

    public int getAndArgumentCount() {
        return this.andArgument_.size();
    }

    public List<ProtoBuf$Expression> getAndArgumentList() {
        return this.andArgument_;
    }

    public q getAndArgumentOrBuilder(int r5) {
        return this.andArgument_.get(r5);
    }

    public List<? extends q> getAndArgumentOrBuilderList() {
        return this.andArgument_;
    }

    public ConstantValue getConstantValue() {
        return this.constantValue_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public ProtoBuf$Type getIsInstanceType() {
        return this.isInstanceType_;
    }

    public int getIsInstanceTypeId() {
        return this.isInstanceTypeId_;
    }

    public ProtoBuf$Expression getOrArgument(int r5) {
        return this.orArgument_.get(r5);
    }

    public int getOrArgumentCount() {
        return this.orArgument_.size();
    }

    public List<ProtoBuf$Expression> getOrArgumentList() {
        return this.orArgument_;
    }

    public q getOrArgumentOrBuilder(int r5) {
        return this.orArgument_.get(r5);
    }

    public List<? extends q> getOrArgumentOrBuilderList() {
        return this.orArgument_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
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
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.flags_);
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(2, this.valueParameterReference_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.b(3, this.constantValue_.getNumber());
    L16:
        if ((this.bitField0_ & 8) != 8) goto L19;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(4, this.isInstanceType_);
    L19:
        if ((this.bitField0_ & 16) != 16) goto L21;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(5, this.isInstanceTypeId_);
    L21:
        int r12 = 0;
    L23:
        if (r12 >= this.andArgument_.size()) goto L26;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(6, this.andArgument_.get(r12));
        r12 = r12 + 1;
    L26:
        if (r10 >= this.orArgument_.size()) goto L28;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(7, this.orArgument_.get(r10));
        r10 = r10 + 1;
        goto L26
    L28:
        int r13 = this.unknownFields.size() + r11;
        this.memoizedSerializedSize = r13;
        return r13;
    L8:
        r11 = 0;
        goto L10
    }

    public int getValueParameterReference() {
        return this.valueParameterReference_;
    }

    public boolean hasConstantValue() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlags() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasIsInstanceType() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasIsInstanceTypeId() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasValueParameterReference() {
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
        if (hasIsInstanceType() == true) goto L11;
    L14:
        int r10 = 0;
    L16:
        if (r10 >= getAndArgumentCount()) goto L22;
        if (getAndArgument(r10).isInitialized() == false) goto L19;
        r10 = r10 + 1;
        goto L16
    L19:
        this.memoizedIsInitialized = 0;
        return false;
    L22:
        int r11 = 0;
    L24:
        if (r11 >= getOrArgumentCount()) goto L30;
        if (getOrArgument(r11).isInitialized() == false) goto L27;
        r11 = r11 + 1;
        goto L24
    L27:
        this.memoizedIsInitialized = 0;
        return false;
    L30:
        this.memoizedIsInitialized = 1;
        return true;
    L11:
        if (getIsInstanceType().isInitialized() == true) goto L14;
        this.memoizedIsInitialized = 0;
        return false;
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
        r5.n(1, this.flags_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r5.n(2, this.valueParameterReference_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L12;
        r5.m(3, this.constantValue_.getNumber());
    L12:
        if ((this.bitField0_ & 8) != 8) goto L15;
        r5.p(4, this.isInstanceType_);
    L15:
        if ((this.bitField0_ & 16) != 16) goto L17;
        r5.n(5, this.isInstanceTypeId_);
    L17:
        int r10 = 0;
        int r11 = 0;
    L19:
        if (r11 >= this.andArgument_.size()) goto L22;
        r5.p(6, this.andArgument_.get(r11));
        r11 = r11 + 1;
    L22:
        if (r10 >= this.orArgument_.size()) goto L24;
        r5.p(7, this.orArgument_.get(r10));
        r10 = r10 + 1;
        goto L22
    L24:
        r5.r(this.unknownFields);
    }

    public static o newBuilder() {
        o r5 = new o();
        r5.e = ConstantValue.TRUE;
        r5.f = ProtoBuf$Type.getDefaultInstance();
        r5.f19135h = Collections.emptyList();
        r5.f19136i = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Expression getDefaultInstanceForType() {
        return f19054a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public o newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public o toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Expression parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Expression parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Expression() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Expression parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Expression(kotlinx.metadata.internal.protobuf.f r11, kotlinx.metadata.internal.protobuf.i r12, au.a r13) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean r14 = false;
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = ConstantValue.TRUE;
        this.isInstanceType_ = ProtoBuf$Type.getDefaultInstance();
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r10 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
        int r15 = 0;
    L4:
        if (r14 == true) goto L72;
        int r16 = r11.n();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r16 == 0) goto L23;
        if (r16 != 8) goto L10;
        this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.flags_ = r11.k();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L10:
        if (r16 != 16) goto L12;
        this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.valueParameterReference_ = r11.k();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L12:
        if (r16 != 24) goto L14;
        int r17 = r11.k();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        ConstantValue r18 = ConstantValue.valueOf(r17);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r18 == null) goto L49;
        this.bitField0_ |= 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.constantValue_ = r18;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L49:
        r10.v(r16);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r10.v(r17);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L14:
        if (r16 != 34) goto L16;
        if ((this.bitField0_ & 8) != 8) goto L42;
        a0 r19 = this.isInstanceType_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L43:
        ProtoBuf$Type r20 = (ProtoBuf$Type) r11.g(ProtoBuf$Type.PARSER, r12);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.isInstanceType_ = r20;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        if (r19 == null) goto L46;
        r19.i(r20);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.isInstanceType_ = r19.h();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L46:
        this.bitField0_ |= 8;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L42:
        r19 = null;
        goto L43
    L16:
        if (r16 != 40) goto L18;
        this.bitField0_ |= 16;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        this.isInstanceTypeId_ = r11.k();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L18:
        if (r16 != 50) goto L20;
        if ((r15 & 32) == 32) goto L37;
        this.andArgument_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r15 = r15 | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L37:
        this.andArgument_.add((ProtoBuf$Expression) r11.g(PARSER, r12));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L20:
        if (r16 != 58) goto L22;
        if ((r15 & 64) == 64) goto L33;
        this.orArgument_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        r15 = r15 | 64;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
    L33:
        this.orArgument_.add((ProtoBuf$Expression) r11.g(PARSER, r12));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        goto L4
    L22:
        if (parseUnknownField(r11, r10, r12, r16) == true) goto L4;
    L23:
        r14 = true;
        goto L4
    L24:
        th = move-exception;
        if ((r15 & 32) != 32) goto L62;
        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
    L62:
        if ((r15 & 64) != 64) goto L88;
        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
    L88:
        r10.i();     // Catch: IOException -> L85 Throwable -> L66
    L66:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L65:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
        throw th;
    L26:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L28:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
    L72:
        if ((r15 & 32) != 32) goto L75;
        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
    L75:
        if ((r15 & 64) != 64) goto L90;
        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
    L90:
        r10.i();     // Catch: IOException -> L84 Throwable -> L79
    L79:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L78:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Expression parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Expression parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Expression parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Expression parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Expression parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Expression) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
