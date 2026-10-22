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
public final class ProtoBuf$Effect extends GeneratedMessageLite implements n {
    public static final int CONCLUSION_OF_CONDITIONAL_EFFECT_FIELD_NUMBER = 3;
    public static final int EFFECT_CONSTRUCTOR_ARGUMENT_FIELD_NUMBER = 2;
    public static final int EFFECT_TYPE_FIELD_NUMBER = 1;
    public static final int KIND_FIELD_NUMBER = 4;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Effect f19048a = null;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private ProtoBuf$Expression conclusionOfConditionalEffect_;
    private List<ProtoBuf$Expression> effectConstructorArgument_;
    private EffectType effectType_;
    private InvocationKind kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    public static final enum EffectType extends Enum<EffectType> implements kotlinx.metadata.internal.protobuf.r {
        public static final EffectType CALLS = null;
        public static final int CALLS_VALUE = 1;
        public static final EffectType RETURNS_CONSTANT = null;
        public static final int RETURNS_CONSTANT_VALUE = 0;
        public static final EffectType RETURNS_NOT_NULL = null;
        public static final int RETURNS_NOT_NULL_VALUE = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f19049a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EffectType[] f19050b = null;
        private final int value;

        static {
            EffectType r5 = new EffectType("RETURNS_CONSTANT", 0, 0);
            RETURNS_CONSTANT = r5;
            EffectType r10 = new EffectType("CALLS", 1, 1);
            CALLS = r10;
            EffectType r11 = new EffectType("RETURNS_NOT_NULL", 2, 2);
            RETURNS_NOT_NULL = r11;
            f19050b = new EffectType[]{r5, r10, r11};
            f19049a = new l();
        }

        public EffectType(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
            return f19049a;
        }

        public static EffectType valueOf(String r5) {
            return (EffectType) Enum.valueOf(EffectType.class, r5);
        }

        public static EffectType[] values() {
            return (EffectType[]) f19050b.clone();
        }

        @Override // kotlinx.metadata.internal.protobuf.r
        public final int getNumber() {
            return this.value;
        }

        public static EffectType valueOf(int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L10;
            return null;
        L10:
            return RETURNS_NOT_NULL;
        L12:
            return CALLS;
        L14:
            return RETURNS_CONSTANT;
        }
    }

    public static final enum InvocationKind extends Enum<InvocationKind> implements kotlinx.metadata.internal.protobuf.r {
        public static final InvocationKind AT_LEAST_ONCE = null;
        public static final int AT_LEAST_ONCE_VALUE = 2;
        public static final InvocationKind AT_MOST_ONCE = null;
        public static final int AT_MOST_ONCE_VALUE = 0;
        public static final InvocationKind EXACTLY_ONCE = null;
        public static final int EXACTLY_ONCE_VALUE = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f19051a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ InvocationKind[] f19052b = null;
        private final int value;

        static {
            InvocationKind r5 = new InvocationKind("AT_MOST_ONCE", 0, 0);
            AT_MOST_ONCE = r5;
            InvocationKind r10 = new InvocationKind("EXACTLY_ONCE", 1, 1);
            EXACTLY_ONCE = r10;
            InvocationKind r11 = new InvocationKind("AT_LEAST_ONCE", 2, 2);
            AT_LEAST_ONCE = r11;
            f19052b = new InvocationKind[]{r5, r10, r11};
            f19051a = new m();
        }

        public InvocationKind(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
            return f19051a;
        }

        public static InvocationKind valueOf(String r5) {
            return (InvocationKind) Enum.valueOf(InvocationKind.class, r5);
        }

        public static InvocationKind[] values() {
            return (InvocationKind[]) f19052b.clone();
        }

        @Override // kotlinx.metadata.internal.protobuf.r
        public final int getNumber() {
            return this.value;
        }

        public static InvocationKind valueOf(int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 == 2) goto L10;
            return null;
        L10:
            return AT_LEAST_ONCE;
        L12:
            return EXACTLY_ONCE;
        L14:
            return AT_MOST_ONCE;
        }
    }

    static {
        PARSER = new au.b(4);
        ProtoBuf$Effect r5 = new ProtoBuf$Effect();
        f19048a = r5;
        r5.effectType_ = EffectType.RETURNS_CONSTANT;
        r5.effectConstructorArgument_ = Collections.emptyList();
        r5.conclusionOfConditionalEffect_ = ProtoBuf$Expression.getDefaultInstance();
        r5.kind_ = InvocationKind.AT_MOST_ONCE;
    }

    public ProtoBuf$Effect(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ EffectType access$24202(ProtoBuf$Effect r5, EffectType r10) {
        r5.effectType_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$24300(ProtoBuf$Effect r5) {
        return r5.effectConstructorArgument_;
    }

    public static /* synthetic */ List access$24302(ProtoBuf$Effect r5, List r10) {
        r5.effectConstructorArgument_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Expression access$24402(ProtoBuf$Effect r5, ProtoBuf$Expression r10) {
        r5.conclusionOfConditionalEffect_ = r10;
        return r10;
    }

    public static /* synthetic */ InvocationKind access$24502(ProtoBuf$Effect r5, InvocationKind r10) {
        r5.kind_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$24602(ProtoBuf$Effect r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$24700(ProtoBuf$Effect r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Effect getDefaultInstance() {
        return f19048a;
    }

    public static k newBuilder(ProtoBuf$Effect r5) {
        k r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$Effect parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Effect parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Expression getConclusionOfConditionalEffect() {
        return this.conclusionOfConditionalEffect_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public ProtoBuf$Expression getEffectConstructorArgument(int r5) {
        return this.effectConstructorArgument_.get(r5);
    }

    public int getEffectConstructorArgumentCount() {
        return this.effectConstructorArgument_.size();
    }

    public List<ProtoBuf$Expression> getEffectConstructorArgumentList() {
        return this.effectConstructorArgument_;
    }

    public q getEffectConstructorArgumentOrBuilder(int r5) {
        return this.effectConstructorArgument_.get(r5);
    }

    public List<? extends q> getEffectConstructorArgumentOrBuilderList() {
        return this.effectConstructorArgument_;
    }

    public EffectType getEffectType() {
        return this.effectType_;
    }

    public InvocationKind getKind() {
        return this.kind_;
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
        int r11 = kotlinx.metadata.internal.protobuf.g.b(1, this.effectType_.getNumber());
    L10:
        if (r10 >= this.effectConstructorArgument_.size()) goto L13;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(2, this.effectConstructorArgument_.get(r10));
        r10 = r10 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 2) != 2) goto L16;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(3, this.conclusionOfConditionalEffect_);
    L16:
        if ((this.bitField0_ & 4) != 4) goto L18;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.b(4, this.kind_.getNumber());
    L18:
        int r12 = this.unknownFields.size() + r11;
        this.memoizedSerializedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    public boolean hasConclusionOfConditionalEffect() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasEffectType() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasKind() {
        if ((this.bitField0_ & 4) != 4) goto L5;
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
        if (r5 != 0) goto L8;
        return false;
    L8:
        int r10 = 0;
    L10:
        if (r10 >= getEffectConstructorArgumentCount()) goto L17;
        if (getEffectConstructorArgument(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasConclusionOfConditionalEffect() == true) goto L19;
    L22:
        this.memoizedIsInitialized = 1;
        return true;
    L19:
        if (getConclusionOfConditionalEffect().isInitialized() == true) goto L22;
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
        if ((this.bitField0_ & 1) != 1) goto L5;
        r5.m(1, this.effectType_.getNumber());
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.effectConstructorArgument_.size()) goto L10;
        r5.p(2, this.effectConstructorArgument_.get(r10));
        r10 = r10 + 1;
        goto L7
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r5.p(3, this.conclusionOfConditionalEffect_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L15;
        r5.m(4, this.kind_.getNumber());
    L15:
        r5.r(this.unknownFields);
    }

    public static k newBuilder() {
        k r5 = new k();
        r5.f19132c = EffectType.RETURNS_CONSTANT;
        r5.d = Collections.emptyList();
        r5.e = ProtoBuf$Expression.getDefaultInstance();
        r5.f = InvocationKind.AT_MOST_ONCE;
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Effect getDefaultInstanceForType() {
        return f19048a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public k newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public k toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Effect parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Effect parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Effect() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Effect parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Effect(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.effectType_ = EffectType.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = ProtoBuf$Expression.getDefaultInstance();
        this.kind_ = InvocationKind.AT_MOST_ONCE;
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        char r15 = 0;
    L4:
        if (r14 == true) goto L60;
        int r16 = r10.n();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r16 == 0) goto L17;
        if (r16 != 8) goto L10;
        int r17 = r10.k();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        EffectType r18 = EffectType.valueOf(r17);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r18 == null) goto L42;
        this.bitField0_ |= 1;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.effectType_ = r18;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L42:
        r5.v(r16);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r5.v(r17);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L10:
        if (r16 != 18) goto L12;
        if ((r15 & 2) == 2) goto L39;
        this.effectConstructorArgument_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r15 = 2;
    L39:
        this.effectConstructorArgument_.add((ProtoBuf$Expression) r10.g(ProtoBuf$Expression.PARSER, r11));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L12:
        if (r16 != 26) goto L14;
        if ((this.bitField0_ & 2) != 2) goto L31;
        o r19 = this.conclusionOfConditionalEffect_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L32:
        ProtoBuf$Expression r20 = (ProtoBuf$Expression) r10.g(ProtoBuf$Expression.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.conclusionOfConditionalEffect_ = r20;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r19 == null) goto L35;
        r19.g(r20);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.conclusionOfConditionalEffect_ = r19.f();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
    L35:
        this.bitField0_ |= 2;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L31:
        r19 = null;
        goto L32
    L14:
        if (r16 != 32) goto L16;
        int r21 = r10.k();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        InvocationKind r22 = InvocationKind.valueOf(r21);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        if (r22 == null) goto L26;
        this.bitField0_ |= 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        this.kind_ = r22;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L26:
        r5.v(r16);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        r5.v(r21);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        goto L4
    L16:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L4;
    L17:
        r14 = true;
        goto L4
    L18:
        th = move-exception;
        if ((r15 & 2) != 2) goto L72;
        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
    L72:
        r5.i();     // Catch: IOException -> L70 Throwable -> L54
    L54:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L53:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L22:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L18
    L20:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L18
    L60:
        if ((r15 & 2) != 2) goto L75;
        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
    L75:
        r5.i();     // Catch: IOException -> L69 Throwable -> L64
    L64:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L63:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Effect parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Effect parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Effect parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Effect parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Effect parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Effect) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
