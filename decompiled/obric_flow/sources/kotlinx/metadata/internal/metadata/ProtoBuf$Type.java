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
public final class ProtoBuf$Type extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Type> implements b0 {
    public static final int ABBREVIATED_TYPE_FIELD_NUMBER = 13;
    public static final int ABBREVIATED_TYPE_ID_FIELD_NUMBER = 14;
    public static final int ARGUMENT_FIELD_NUMBER = 2;
    public static final int CLASS_NAME_FIELD_NUMBER = 6;
    public static final int FLAGS_FIELD_NUMBER = 1;
    public static final int FLEXIBLE_TYPE_CAPABILITIES_ID_FIELD_NUMBER = 4;
    public static final int FLEXIBLE_UPPER_BOUND_FIELD_NUMBER = 5;
    public static final int FLEXIBLE_UPPER_BOUND_ID_FIELD_NUMBER = 8;
    public static final int NULLABLE_FIELD_NUMBER = 3;
    public static final int OUTER_TYPE_FIELD_NUMBER = 10;
    public static final int OUTER_TYPE_ID_FIELD_NUMBER = 11;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
    public static final int TYPE_ALIAS_NAME_FIELD_NUMBER = 12;
    public static final int TYPE_PARAMETER_FIELD_NUMBER = 7;
    public static final int TYPE_PARAMETER_NAME_FIELD_NUMBER = 9;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Type f19070a = null;
    private static final long serialVersionUID = 0;
    private int abbreviatedTypeId_;
    private ProtoBuf$Type abbreviatedType_;
    private List<Argument> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private ProtoBuf$Type flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private ProtoBuf$Type outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    public static final class Argument extends GeneratedMessageLite implements z {
        public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
        public static final int PROJECTION_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        public static final int TYPE_ID_FIELD_NUMBER = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Argument f19071a = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Projection projection_;
        private int typeId_;
        private ProtoBuf$Type type_;
        private final kotlinx.metadata.internal.protobuf.e unknownFields;

        public static final enum Projection extends Enum<Projection> implements kotlinx.metadata.internal.protobuf.r {
            public static final Projection IN = null;
            public static final Projection INV = null;
            public static final int INV_VALUE = 2;
            public static final int IN_VALUE = 0;
            public static final Projection OUT = null;
            public static final int OUT_VALUE = 1;
            public static final Projection STAR = null;
            public static final int STAR_VALUE = 3;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final y f19072a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ Projection[] f19073b = null;
            private final int value;

            static {
                Projection r5 = new Projection("IN", 0, 0);
                IN = r5;
                Projection r10 = new Projection("OUT", 1, 1);
                OUT = r10;
                Projection r11 = new Projection("INV", 2, 2);
                INV = r11;
                Projection r12 = new Projection("STAR", 3, 3);
                STAR = r12;
                f19073b = new Projection[]{r5, r10, r11, r12};
                f19072a = new y();
            }

            public Projection(String r5, int r10, int r11) {
                super(r5, r10);
                this.value = r11;
            }

            public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
                return f19072a;
            }

            public static Projection valueOf(String r5) {
                return (Projection) Enum.valueOf(Projection.class, r5);
            }

            public static Projection[] values() {
                return (Projection[]) f19073b.clone();
            }

            @Override // kotlinx.metadata.internal.protobuf.r
            public final int getNumber() {
                return this.value;
            }

            public static Projection valueOf(int r5) {
                if (r5 == 0) goto L18;
                if (r5 == 1) goto L16;
                if (r5 == 2) goto L14;
                if (r5 == 3) goto L12;
                return null;
            L12:
                return STAR;
            L14:
                return INV;
            L16:
                return OUT;
            L18:
                return IN;
            }
        }

        static {
            PARSER = new w();
            Argument r5 = new Argument();
            f19071a = r5;
            r5.projection_ = Projection.INV;
            r5.type_ = ProtoBuf$Type.getDefaultInstance();
            r5.typeId_ = 0;
        }

        public Argument(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.f19190a;
        }

        public static /* synthetic */ Projection access$5202(Argument r5, Projection r10) {
            r5.projection_ = r10;
            return r10;
        }

        public static /* synthetic */ ProtoBuf$Type access$5302(Argument r5, ProtoBuf$Type r10) {
            r5.type_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5402(Argument r5, int r10) {
            r5.typeId_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$5502(Argument r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$5600(Argument r5) {
            return r5.unknownFields;
        }

        public static Argument getDefaultInstance() {
            return f19071a;
        }

        public static x newBuilder(Argument r5) {
            x r10 = newBuilder();
            r10.g(r5);
            return r10;
        }

        public static Argument parseDelimitedFrom(InputStream r5) throws IOException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static Argument parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
            return PARSER;
        }

        public Projection getProjection() {
            return this.projection_;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = kotlinx.metadata.internal.protobuf.g.b(1, this.projection_.getNumber());
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r10 = r10 + kotlinx.metadata.internal.protobuf.g.e(2, this.type_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r10 = r10 + kotlinx.metadata.internal.protobuf.g.c(3, this.typeId_);
        L15:
            int r11 = this.unknownFields.size() + r10;
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r10 = 0;
            goto L10
        }

        public ProtoBuf$Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasProjection() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasType() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeId() {
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
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasType() == true) goto L11;
        L14:
            this.memoizedIsInitialized = 1;
            return true;
        L11:
            if (getType().isInitialized() == true) goto L14;
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
            r5.m(1, this.projection_.getNumber());
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.p(2, this.type_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r5.n(3, this.typeId_);
        L11:
            r5.r(this.unknownFields);
        }

        public static x newBuilder() {
            x r5 = new x();
            r5.f19142c = Projection.INV;
            r5.d = ProtoBuf$Type.getDefaultInstance();
            return r5;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Argument getDefaultInstanceForType() {
            return f19071a;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public x newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public x toBuilder() {
            return newBuilder(this);
        }

        public static Argument parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
        }

        public static Argument parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
        }

        public Argument() {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
        }

        public static Argument parseFrom(byte[] r5) throws InvalidProtocolBufferException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public Argument(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.projection_ = Projection.INV;
            this.type_ = ProtoBuf$Type.getDefaultInstance();
            boolean r13 = false;
            this.typeId_ = 0;
            kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
            kotlinx.metadata.internal.protobuf.g r14 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
        L3:
            if (r13 == true) goto L57;
            int r15 = r10.n();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            if (r15 == 0) goto L14;
            if (r15 != 8) goto L9;
            int r16 = r10.k();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            Projection r17 = Projection.valueOf(r16);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            if (r17 == null) goto L32;
            this.bitField0_ |= 1;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            this.projection_ = r17;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L32:
            r14.v(r15);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            r14.v(r16);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (r15 != 18) goto L11;
            if ((this.bitField0_ & 2) != 2) goto L25;
            a0 r18 = this.type_.toBuilder();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
        L26:
            ProtoBuf$Type r19 = (ProtoBuf$Type) r10.g(ProtoBuf$Type.PARSER, r11);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            this.type_ = r19;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            if (r18 == null) goto L29;
            r18.i(r19);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            this.type_ = r18.h();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
        L29:
            this.bitField0_ |= 2;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L25:
            r18 = null;
            goto L26
        L11:
            if (r15 != 24) goto L13;
            this.bitField0_ |= 4;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            this.typeId_ = r10.k();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            goto L3
        L13:
            if (parseUnknownField(r10, r14, r11, r15) == true) goto L3;
        L14:
            r13 = true;
            goto L3
        L15:
            th = move-exception;
            r14.i();     // Catch: IOException -> L53 Throwable -> L41
        L41:
            th = move-exception;
            this.unknownFields = r5.e();
            throw th;
        L40:
            this.unknownFields = r5.e();
            makeExtensionsImmutable();
            throw th;
        L19:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L15
        L17:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L15
        L57:
            r14.i();     // Catch: IOException -> L54 Throwable -> L48
        L48:
            th = move-exception;
            this.unknownFields = r5.e();
            throw th;
        L47:
            this.unknownFields = r5.e();
            makeExtensionsImmutable();
        }

        public static Argument parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
        }

        public static Argument parseFrom(InputStream r5) throws IOException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static Argument parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
        }

        public static Argument parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static Argument parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
            return (Argument) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
        }
    }

    static {
        PARSER = new au.b(13);
        ProtoBuf$Type r5 = new ProtoBuf$Type();
        f19070a = r5;
        r5.b();
    }

    public ProtoBuf$Type(kotlinx.metadata.internal.protobuf.n r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ List access$5900(ProtoBuf$Type r5) {
        return r5.argument_;
    }

    public static /* synthetic */ List access$5902(ProtoBuf$Type r5, List r10) {
        r5.argument_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$6002(ProtoBuf$Type r5, boolean r10) {
        r5.nullable_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6102(ProtoBuf$Type r5, int r10) {
        r5.flexibleTypeCapabilitiesId_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$6202(ProtoBuf$Type r5, ProtoBuf$Type r10) {
        r5.flexibleUpperBound_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6302(ProtoBuf$Type r5, int r10) {
        r5.flexibleUpperBoundId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6402(ProtoBuf$Type r5, int r10) {
        r5.className_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6502(ProtoBuf$Type r5, int r10) {
        r5.typeParameter_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6602(ProtoBuf$Type r5, int r10) {
        r5.typeParameterName_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6702(ProtoBuf$Type r5, int r10) {
        r5.typeAliasName_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$6802(ProtoBuf$Type r5, ProtoBuf$Type r10) {
        r5.outerType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$6902(ProtoBuf$Type r5, int r10) {
        r5.outerTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ ProtoBuf$Type access$7002(ProtoBuf$Type r5, ProtoBuf$Type r10) {
        r5.abbreviatedType_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$7102(ProtoBuf$Type r5, int r10) {
        r5.abbreviatedTypeId_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$7202(ProtoBuf$Type r5, int r10) {
        r5.flags_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$7302(ProtoBuf$Type r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$7400(ProtoBuf$Type r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Type getDefaultInstance() {
        return f19070a;
    }

    public static a0 newBuilder(ProtoBuf$Type r5) {
        a0 r10 = newBuilder();
        r10.i(r5);
        return r10;
    }

    public static ProtoBuf$Type parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Type parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public final void b() {
        this.argument_ = Collections.emptyList();
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        this.flexibleUpperBound_ = getDefaultInstance();
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = getDefaultInstance();
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = getDefaultInstance();
        this.abbreviatedTypeId_ = 0;
        this.flags_ = 0;
    }

    public ProtoBuf$Type getAbbreviatedType() {
        return this.abbreviatedType_;
    }

    public int getAbbreviatedTypeId() {
        return this.abbreviatedTypeId_;
    }

    public Argument getArgument(int r5) {
        return this.argument_.get(r5);
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public List<Argument> getArgumentList() {
        return this.argument_;
    }

    public z getArgumentOrBuilder(int r5) {
        return this.argument_.get(r5);
    }

    public List<? extends z> getArgumentOrBuilderList() {
        return this.argument_;
    }

    public int getClassName() {
        return this.className_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFlexibleTypeCapabilitiesId() {
        return this.flexibleTypeCapabilitiesId_;
    }

    public ProtoBuf$Type getFlexibleUpperBound() {
        return this.flexibleUpperBound_;
    }

    public int getFlexibleUpperBoundId() {
        return this.flexibleUpperBoundId_;
    }

    public boolean getNullable() {
        return this.nullable_;
    }

    public ProtoBuf$Type getOuterType() {
        return this.outerType_;
    }

    public int getOuterTypeId() {
        return this.outerTypeId_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
        return PARSER;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 4096) != 4096) goto L8;
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.flags_);
    L10:
        if (r10 >= this.argument_.size()) goto L13;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(2, this.argument_.get(r10));
        r10 = r10 + 1;
        goto L10
    L13:
        if ((this.bitField0_ & 1) != 1) goto L16;
        r11 = r11 + (kotlinx.metadata.internal.protobuf.g.h(3) + 1);
    L16:
        if ((this.bitField0_ & 2) != 2) goto L19;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(4, this.flexibleTypeCapabilitiesId_);
    L19:
        if ((this.bitField0_ & 4) != 4) goto L22;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(5, this.flexibleUpperBound_);
    L22:
        if ((this.bitField0_ & 16) != 16) goto L25;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(6, this.className_);
    L25:
        if ((this.bitField0_ & 32) != 32) goto L28;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(7, this.typeParameter_);
    L28:
        if ((this.bitField0_ & 8) != 8) goto L31;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(8, this.flexibleUpperBoundId_);
    L31:
        if ((this.bitField0_ & 64) != 64) goto L34;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(9, this.typeParameterName_);
    L34:
        if ((this.bitField0_ & 256) != 256) goto L37;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(10, this.outerType_);
    L37:
        if ((this.bitField0_ & 512) != 512) goto L40;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(11, this.outerTypeId_);
    L40:
        if ((this.bitField0_ & 128) != 128) goto L43;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(12, this.typeAliasName_);
    L43:
        if ((this.bitField0_ & 1024) != 1024) goto L46;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(13, this.abbreviatedType_);
    L46:
        if ((this.bitField0_ & 2048) != 2048) goto L48;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(14, this.abbreviatedTypeId_);
    L48:
        int r12 = this.unknownFields.size() + (extensionsSerializedSize() + r11);
        this.memoizedSerializedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    public int getTypeAliasName() {
        return this.typeAliasName_;
    }

    public int getTypeParameter() {
        return this.typeParameter_;
    }

    public int getTypeParameterName() {
        return this.typeParameterName_;
    }

    public boolean hasAbbreviatedType() {
        if ((this.bitField0_ & 1024) != 1024) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasAbbreviatedTypeId() {
        if ((this.bitField0_ & 2048) != 2048) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasClassName() {
        if ((this.bitField0_ & 16) != 16) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlags() {
        if ((this.bitField0_ & 4096) != 4096) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlexibleTypeCapabilitiesId() {
        if ((this.bitField0_ & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlexibleUpperBound() {
        if ((this.bitField0_ & 4) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasFlexibleUpperBoundId() {
        if ((this.bitField0_ & 8) != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasNullable() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean hasOuterType() {
        if ((this.bitField0_ & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasOuterTypeId() {
        if ((this.bitField0_ & 512) != 512) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeAliasName() {
        if ((this.bitField0_ & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeParameter() {
        if ((this.bitField0_ & 32) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasTypeParameterName() {
        if ((this.bitField0_ & 64) != 64) goto L5;
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
        if (r10 >= getArgumentCount()) goto L17;
        if (getArgument(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L17:
        if (hasFlexibleUpperBound() == false) goto L23;
        if (getFlexibleUpperBound().isInitialized() == true) goto L23;
        this.memoizedIsInitialized = 0;
        return false;
    L23:
        if (hasOuterType() == false) goto L29;
        if (getOuterType().isInitialized() == true) goto L29;
        this.memoizedIsInitialized = 0;
        return false;
    L29:
        if (hasAbbreviatedType() == false) goto L35;
        if (getAbbreviatedType().isInitialized() == true) goto L35;
        this.memoizedIsInitialized = 0;
        return false;
    L35:
        if (extensionsAreInitialized() == true) goto L38;
        this.memoizedIsInitialized = 0;
        return false;
    L38:
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
        if ((this.bitField0_ & 4096) != 4096) goto L5;
        r10.n(1, this.flags_);
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.argument_.size()) goto L10;
        r10.p(2, this.argument_.get(r11));
        r11 = r11 + 1;
        goto L7
    L10:
        if ((this.bitField0_ & 1) != 1) goto L13;
        boolean r12 = this.nullable_;
        r10.x(3, 0);
        r10.q(r12 ? 1 : 0);
    L13:
        if ((this.bitField0_ & 2) != 2) goto L16;
        r10.n(4, this.flexibleTypeCapabilitiesId_);
    L16:
        if ((this.bitField0_ & 4) != 4) goto L19;
        r10.p(5, this.flexibleUpperBound_);
    L19:
        if ((this.bitField0_ & 16) != 16) goto L22;
        r10.n(6, this.className_);
    L22:
        if ((this.bitField0_ & 32) != 32) goto L25;
        r10.n(7, this.typeParameter_);
    L25:
        if ((this.bitField0_ & 8) != 8) goto L28;
        r10.n(8, this.flexibleUpperBoundId_);
    L28:
        if ((this.bitField0_ & 64) != 64) goto L31;
        r10.n(9, this.typeParameterName_);
    L31:
        if ((this.bitField0_ & 256) != 256) goto L34;
        r10.p(10, this.outerType_);
    L34:
        if ((this.bitField0_ & 512) != 512) goto L37;
        r10.n(11, this.outerTypeId_);
    L37:
        if ((this.bitField0_ & 128) != 128) goto L40;
        r10.n(12, this.typeAliasName_);
    L40:
        if ((this.bitField0_ & 1024) != 1024) goto L43;
        r10.p(13, this.abbreviatedType_);
    L43:
        if ((this.bitField0_ & 2048) != 2048) goto L45;
        r10.n(14, this.abbreviatedTypeId_);
    L45:
        r5.a(200, r10);
        r10.r(this.unknownFields);
    }

    public static a0 newBuilder() {
        a0 r5 = new a0();
        r5.e = Collections.emptyList();
        r5.f19088h = getDefaultInstance();
        r5.f19094n = getDefaultInstance();
        r5.f19096p = getDefaultInstance();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Type getDefaultInstanceForType() {
        return f19070a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public a0 newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite.ExtendableMessage, kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public a0 toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Type parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Type parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Type() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Type parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Type(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        b();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r13, 1);
        boolean r14 = false;
        boolean r15 = false;
    L3:
        if (r14 == true) goto L67;
        int r16 = r10.n();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        a0 r17 = null;
        switch(r16) {
            case 0: goto L8;
            case 8: goto L52;
            case 18: goto L49;
            case 24: goto L44;
            case 32: goto L43;
            case 42: goto L37;
            case 48: goto L35;
            case 56: goto L34;
            case 64: goto L33;
            case 72: goto L32;
            case 82: goto L26;
            case 88: goto L24;
            case 96: goto L23;
            case 106: goto L17;
            case 112: goto L15;
            default: goto L7;
        };     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
    L8:
        r14 = true;
        goto L3
    L15:
        this.bitField0_ |= 2048;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.abbreviatedTypeId_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L17:
        if ((this.bitField0_ & 1024) != 1024) goto L19;
        r17 = this.abbreviatedType_.toBuilder();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
    L19:
        ProtoBuf$Type r18 = (ProtoBuf$Type) r10.g(PARSER, r11);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.abbreviatedType_ = r18;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        if (r17 == null) goto L22;
        r17.i(r18);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.abbreviatedType_ = r17.h();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
    L22:
        this.bitField0_ |= 1024;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L23:
        this.bitField0_ |= 128;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.typeAliasName_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L24:
        this.bitField0_ |= 512;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.outerTypeId_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L26:
        if ((this.bitField0_ & 256) != 256) goto L28;
        r17 = this.outerType_.toBuilder();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
    L28:
        ProtoBuf$Type r19 = (ProtoBuf$Type) r10.g(PARSER, r11);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.outerType_ = r19;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        if (r17 == null) goto L31;
        r17.i(r19);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.outerType_ = r17.h();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
    L31:
        this.bitField0_ |= 256;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L32:
        this.bitField0_ |= 64;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.typeParameterName_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L33:
        this.bitField0_ |= 8;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.flexibleUpperBoundId_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L34:
        this.bitField0_ |= 32;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.typeParameter_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L35:
        this.bitField0_ |= 16;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.className_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L37:
        if ((this.bitField0_ & 4) != 4) goto L39;
        r17 = this.flexibleUpperBound_.toBuilder();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
    L39:
        ProtoBuf$Type r20 = (ProtoBuf$Type) r10.g(PARSER, r11);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.flexibleUpperBound_ = r20;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        if (r17 == null) goto L42;
        r17.i(r20);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.flexibleUpperBound_ = r17.h();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
    L42:
        this.bitField0_ |= 4;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L43:
        this.bitField0_ |= 2;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.flexibleTypeCapabilitiesId_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L44:
        this.bitField0_ |= 1;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        if (r10.l() == 0) goto L47;
        boolean r21 = true;
    L48:
        this.nullable_ = r21;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L47:
        r21 = false;
        goto L48
    L49:
        if (r15 == true) goto L51;
        this.argument_ = new ArrayList();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        r15 = true;
    L51:
        this.argument_.add((Argument) r10.g(Argument.PARSER, r11));     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L52:
        this.bitField0_ |= 4096;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        this.flags_ = r10.k();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        goto L3
    L7:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L3;
    L9:
        th = move-exception;
        if (r15 != true) goto L80;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L80:
        r5.i();     // Catch: IOException -> L77 Throwable -> L62
    L62:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L61:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L11:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L9
    L13:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L9
    L67:
        if (r15 != true) goto L82;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L82:
        r5.i();     // Catch: IOException -> L76 Throwable -> L71
    L71:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L70:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Type parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Type parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Type parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Type parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Type parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Type) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
