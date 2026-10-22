package kotlin.reflect.jvm.internal.impl.metadata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$TypeParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeParameter> implements ProtoBuf$TypeParameterOrBuilder {
    public static Parser<ProtoBuf$TypeParameter> PARSER;
    private static final ProtoBuf$TypeParameter defaultInstance = null;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final ByteString unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<ProtoBuf$Type> upperBound_;
    private Variance variance_;

    public static final enum Variance extends Enum<Variance> implements Internal$EnumLite {
        private static final /* synthetic */ Variance[] $VALUES = null;
        public static final Variance IN = null;
        public static final Variance INV = null;
        public static final Variance OUT = null;
        private static Internal$EnumLiteMap<Variance> internalValueMap;
        private final int value;

        static {
            Variance r0 = new Variance("IN", 0, 0, 0);
            IN = r0;
            Variance r1 = new Variance("OUT", 1, 1, 1);
            OUT = r1;
            Variance r3 = new Variance("INV", 2, 2, 2);
            INV = r3;
            $VALUES = new Variance[]{r0, r1, r3};
            internalValueMap = new AnonymousClass1();
        }

        public static Variance[] values() {
            return (Variance[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Variance valueOf(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return INV;
        L12:
            return OUT;
        L14:
            return IN;
        }

        public static Variance valueOf(String r1) {
            return (Variance) a.a(Variance.class, r1);
        }

        private Variance(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.value = r4;
        }
    }

    private void initFields() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = Variance.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$TypeParameter r0 = new ProtoBuf$TypeParameter(true);
        defaultInstance = r0;
        r0.initFields();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r2 = 0;
        if ((this.bitField0_ & 1) != 1) goto L8;
        int r1 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
    L10:
        if ((this.bitField0_ & 2) != 2) goto L13;
        r1 = r1 + CodedOutputStream.computeInt32Size(2, this.name_);
    L13:
        if ((this.bitField0_ & 4) != 4) goto L16;
        r1 = r1 + CodedOutputStream.computeBoolSize(3, this.reified_);
    L16:
        if ((this.bitField0_ & 8) != 8) goto L18;
        r1 = r1 + CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
    L18:
        int r3 = 0;
    L20:
        if (r3 >= this.upperBound_.size()) goto L22;
        r1 = r1 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.upperBound_, r3));
        r3 = r3 + 1;
        goto L20
    L22:
        int r4 = 0;
    L24:
        if (r2 >= this.upperBoundId_.size()) goto L26;
        r4 = r4 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.upperBoundId_, r2)).intValue());
        r2 = r2 + 1;
        goto L24
    L26:
        int r5 = r1 + r4;
        if (getUpperBoundIdList().isEmpty() == true) goto L29;
        r5 = (r5 + 1) + CodedOutputStream.computeInt32SizeNoTag(r4);
    L29:
        this.upperBoundIdMemoizedSerializedSize = r4;
        int r6 = (r5 + extensionsSerializedSize()) + this.unknownFields.size();
        this.memoizedSerializedSize = r6;
        return r6;
    L8:
        r1 = 0;
        goto L10
    }

    public int getUpperBoundCount() {
        return this.upperBound_.size();
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L9;
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
        int r1 = 0;
    L18:
        if (r1 >= getUpperBoundCount()) goto L25;
        if (getUpperBound(r1).isInitialized() == false) goto L21;
        r1 = r1 + 1;
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

    public static Builder newBuilder() {
        return Builder.access$7600();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public Builder newBuilderForType() {
        return newBuilder();
    }

    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$TypeParameter getDefaultInstance() {
        return defaultInstance;
    }

    public int getId() {
        return this.id_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$TypeParameter> getParserForType() {
        return PARSER;
    }

    public boolean getReified() {
        return this.reified_;
    }

    public List<Integer> getUpperBoundIdList() {
        return this.upperBoundId_;
    }

    public List<ProtoBuf$Type> getUpperBoundList() {
        return this.upperBound_;
    }

    public Variance getVariance() {
        return this.variance_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeParameter getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: newBuilderForType */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo379newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: toBuilder */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo380toBuilder() {
        return toBuilder();
    }

    private ProtoBuf$TypeParameter(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeParameter, ?> r2) {
        super(r2);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$8200(ProtoBuf$TypeParameter r0) {
        return r0.upperBound_;
    }

    public static /* synthetic */ List access$8300(ProtoBuf$TypeParameter r0) {
        return r0.upperBoundId_;
    }

    public static /* synthetic */ ByteString access$8500(ProtoBuf$TypeParameter r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$TypeParameter r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Type getUpperBound(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.upperBound_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r6) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r0 = newExtensionWriter();
        if ((this.bitField0_ & 1) != 1) goto L6;
        r6.writeInt32(1, this.id_);
    L6:
        if ((this.bitField0_ & 2) != 2) goto L9;
        r6.writeInt32(2, this.name_);
    L9:
        if ((this.bitField0_ & 4) != 4) goto L12;
        r6.writeBool(3, this.reified_);
    L12:
        if ((this.bitField0_ & 8) != 8) goto L14;
        r6.writeEnum(4, this.variance_.getNumber());
    L14:
        int r1 = 0;
        int r2 = 0;
    L16:
        if (r2 >= this.upperBound_.size()) goto L19;
        r6.writeMessage(5, (MessageLite) ListProtector.get(this.upperBound_, r2));
        r2 = r2 + 1;
        goto L16
    L19:
        if (getUpperBoundIdList().size() <= 0) goto L22;
        r6.writeRawVarint32(50);
        r6.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
    L22:
        if (r1 >= this.upperBoundId_.size()) goto L24;
        r6.writeInt32NoTag(((Integer) ListProtector.get(this.upperBoundId_, r1)).intValue());
        r1 = r1 + 1;
        goto L22
    L24:
        r0.writeUntil(1000, r6);
        r6.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$TypeParameter(boolean r1) {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$TypeParameter(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L70;
        int r7 = r12.readTag();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        if (r7 == 0) goto L47;
        if (r7 != 8) goto L9;
        this.bitField0_ |= 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.id_ = r12.readInt32();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L9:
        if (r7 != 16) goto L11;
        this.bitField0_ |= 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.name_ = r12.readInt32();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L11:
        if (r7 != 24) goto L12;
        this.bitField0_ |= 4;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.reified_ = r12.readBool();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L12:
        if (r7 != 32) goto L14;
        int r9 = r12.readEnum();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        Variance r10 = Variance.valueOf(r9);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        if (r10 == null) goto L41;
        this.bitField0_ |= 8;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        this.variance_ = r10;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L41:
        r2.writeRawVarint32(r7);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        r2.writeRawVarint32(r9);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L14:
        if (r7 != 42) goto L16;
        if ((r4 & 16) == 16) goto L38;
        this.upperBound_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        r4 = r4 | 16;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L38:
        this.upperBound_.add((ProtoBuf$Type) r12.readMessage(ProtoBuf$Type.PARSER, r13));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L16:
        if (r7 != 48) goto L18;
        if ((r4 & 32) == 32) goto L34;
        this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        r4 = r4 | 32;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L34:
        this.upperBoundId_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L18:
        if (r7 != 50) goto L20;
        int r8 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        if ((r4 & 32) == 32) goto L28;
        if (r12.getBytesUntilLimit() <= 0) goto L28;
        this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        r4 = r4 | 32;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
    L28:
        if (r12.getBytesUntilLimit() <= 0) goto L30;
        this.upperBoundId_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L28
    L30:
        r12.popLimit(r8);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        goto L4
    L20:
        if (parseUnknownField(r12, r2, r13, r7) == true) goto L4;
    L47:
        r3 = true;
        goto L4
    L48:
        th = move-exception;
        if ((r4 & 16) != 16) goto L60;
        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
    L60:
        if ((r4 & 32) != 32) goto L86;
        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
    L86:
        r2.flush();     // Catch: IOException -> L83 Throwable -> L64
    L64:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L63:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L50:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L48
    L53:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L48
    L70:
        if ((r4 & 16) != 16) goto L73;
        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
    L73:
        if ((r4 & 32) != 32) goto L88;
        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
    L88:
        r2.flush();     // Catch: IOException -> L82 Throwable -> L77
    L77:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L76:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$7802(ProtoBuf$TypeParameter r0, int r1) {
        r0.id_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$7902(ProtoBuf$TypeParameter r0, int r1) {
        r0.name_ = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$8002(ProtoBuf$TypeParameter r0, boolean r1) {
        r0.reified_ = r1;
        return r1;
    }

    public static /* synthetic */ Variance access$8102(ProtoBuf$TypeParameter r0, Variance r1) {
        r0.variance_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$8202(ProtoBuf$TypeParameter r0, List r1) {
        r0.upperBound_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$8302(ProtoBuf$TypeParameter r0, List r1) {
        r0.upperBoundId_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$8402(ProtoBuf$TypeParameter r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$TypeParameter(GeneratedMessageLite.ExtendableBuilder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$TypeParameter(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
