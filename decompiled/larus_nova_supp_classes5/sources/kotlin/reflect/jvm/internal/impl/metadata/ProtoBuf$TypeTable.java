package kotlin.reflect.jvm.internal.impl.metadata;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$TypeTable extends GeneratedMessageLite implements ProtoBuf$TypeTableOrBuilder {
    public static Parser<ProtoBuf$TypeTable> PARSER;
    private static final ProtoBuf$TypeTable defaultInstance = null;
    private int bitField0_;
    private int firstNullable_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Type> type_;
    private final ByteString unknownFields;

    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$TypeTable, Builder> implements ProtoBuf$TypeTableOrBuilder {
        private int bitField0_;
        private int firstNullable_;
        private List<ProtoBuf$Type> type_;

        private void maybeForceBuilderInitialization() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            int r1 = 0;
        L4:
            if (r1 >= getTypeCount()) goto L9;
            if (getType(r1).isInitialized() == false) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureTypeIsMutable() {
            if ((this.bitField0_ & 1) == 1) goto L6;
            this.type_ = new ArrayList(this.type_);
            this.bitField0_ |= 1;
            return;
        }

        public ProtoBuf$TypeTable buildPartial() {
            ProtoBuf$TypeTable r0 = new ProtoBuf$TypeTable(this, null);
            int r1 = this.bitField0_;
            int r3 = 1;
            if ((r1 & 1) != 1) goto L5;
            this.type_ = Collections.unmodifiableList(this.type_);
            this.bitField0_ &= -2;
        L5:
            ProtoBuf$TypeTable.access$12802(r0, this.type_);
            if ((r1 & 2) == 2) goto L9;
            r3 = 0;
        L9:
            ProtoBuf$TypeTable.access$12902(r0, this.firstNullable_);
            ProtoBuf$TypeTable.access$13002(r0, r3);
            return r0;
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        private Builder() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ Builder access$12600() {
            return create();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$TypeTable build() {
            ProtoBuf$TypeTable r0 = buildPartial();
            if (r0.isInitialized() == false) goto L6;
            return r0;
        L6:
            throw AbstractMessageLite.Builder.newUninitializedMessageException(r0);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ProtoBuf$TypeTable getDefaultInstanceForType() {
            return ProtoBuf$TypeTable.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo381clone() {
            return clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
            return clone();
        }

        public ProtoBuf$Type getType(int r2) {
            return (ProtoBuf$Type) ListProtector.get(this.type_, r2);
        }

        public Builder mergeFrom(ProtoBuf$TypeTable r3) {
            if (r3 != ProtoBuf$TypeTable.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (ProtoBuf$TypeTable.access$12800(r3).isEmpty() == true) goto L12;
            if (this.type_.isEmpty() == false) goto L10;
            this.type_ = ProtoBuf$TypeTable.access$12800(r3);
            this.bitField0_ &= -2;
            goto L12
        L10:
            ensureTypeIsMutable();
            this.type_.addAll(ProtoBuf$TypeTable.access$12800(r3));
        L12:
            if (r3.hasFirstNullable() == false) goto L14;
            setFirstNullable(r3.getFirstNullable());
        L14:
            setUnknownFields(getUnknownFields().concat(ProtoBuf$TypeTable.access$13100(r3)));
            return this;
        }

        public Builder setFirstNullable(int r2) {
            this.bitField0_ |= 2;
            this.firstNullable_ = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
            return mergeFrom((ProtoBuf$TypeTable) r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
            ProtoBuf$TypeTable r0 = null;
            ProtoBuf$TypeTable r5 = ProtoBuf$TypeTable.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
            if (r5 == null) goto L6;
            mergeFrom(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            ProtoBuf$TypeTable r6 = (ProtoBuf$TypeTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            throw e;     // Catch: Throwable -> L12
        L12:
            th = th;
            r0 = r6;
        L14:
            if (r0 == null) goto L16;
            mergeFrom(r0);
        L16:
            throw th;
        L7:
            th = th;
            goto L14
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return mergeFrom(r1, r2);
        }
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$TypeTable r0 = new ProtoBuf$TypeTable(true);
        defaultInstance = r0;
        r0.initFields();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int r0 = this.memoizedSerializedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= this.type_.size()) goto L10;
        r2 = r2 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.type_, r1));
        r1 = r1 + 1;
        goto L7
    L10:
        if ((this.bitField0_ & 1) != 1) goto L12;
        r2 = r2 + CodedOutputStream.computeInt32Size(2, this.firstNullable_);
    L12:
        int r3 = r2 + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
    }

    public int getTypeCount() {
        return this.type_.size();
    }

    public boolean hasFirstNullable() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 0) goto L8;
        return false;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= getTypeCount()) goto L16;
        if (getType(r1).isInitialized() == false) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        this.memoizedIsInitialized = 1;
        return true;
    }

    private void initFields() {
        this.type_ = Collections.emptyList();
        this.firstNullable_ = -1;
    }

    public static Builder newBuilder() {
        return Builder.access$12600();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: newBuilderForType */
    public Builder mo379newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: toBuilder */
    public Builder mo380toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$TypeTable getDefaultInstance() {
        return defaultInstance;
    }

    public int getFirstNullable() {
        return this.firstNullable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$TypeTable> getParserForType() {
        return PARSER;
    }

    public List<ProtoBuf$Type> getTypeList() {
        return this.type_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeTable getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: newBuilderForType */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo379newBuilderForType() {
        return mo379newBuilderForType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    /* JADX INFO: renamed from: toBuilder */
    public /* bridge */ /* synthetic */ MessageLite.Builder mo380toBuilder() {
        return mo380toBuilder();
    }

    private ProtoBuf$TypeTable(GeneratedMessageLite.Builder r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$12800(ProtoBuf$TypeTable r0) {
        return r0.type_;
    }

    public static /* synthetic */ ByteString access$13100(ProtoBuf$TypeTable r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$TypeTable r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf$Type getType(int r2) {
        return (ProtoBuf$Type) ListProtector.get(this.type_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r4) throws IOException {
        getSerializedSize();
        int r0 = 0;
    L4:
        if (r0 >= this.type_.size()) goto L7;
        r4.writeMessage(1, (MessageLite) ListProtector.get(this.type_, r0));
        r0 = r0 + 1;
        goto L4
    L7:
        if ((this.bitField0_ & 1) != 1) goto L9;
        r4.writeInt32(2, this.firstNullable_);
    L9:
        r4.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$TypeTable(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$TypeTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L39;
        int r5 = r8.readTag();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        if (r5 == 0) goto L19;
        if (r5 != 10) goto L9;
        if ((r4 & true) == true) goto L17;
        this.type_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        r4 = r4 | true;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
    L17:
        this.type_.add((ProtoBuf$Type) r8.readMessage(ProtoBuf$Type.PARSER, r9));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        goto L3
    L9:
        if (r5 != 16) goto L11;
        this.bitField0_ |= 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        this.firstNullable_ = r8.readInt32();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        goto L3
    L11:
        if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
    L19:
        r3 = true;
        goto L3
    L20:
        th = move-exception;
        if ((r4 & true) != true) goto L51;
        this.type_ = Collections.unmodifiableList(this.type_);
    L51:
        r2.flush();     // Catch: IOException -> L49 Throwable -> L33
    L33:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L32:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L25:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
    L22:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L20
    L39:
        if ((r4 & true) != true) goto L54;
        this.type_ = Collections.unmodifiableList(this.type_);
    L54:
        r2.flush();     // Catch: IOException -> L48 Throwable -> L43
    L43:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L42:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ List access$12802(ProtoBuf$TypeTable r0, List r1) {
        r0.type_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$12902(ProtoBuf$TypeTable r0, int r1) {
        r0.firstNullable_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$13002(ProtoBuf$TypeTable r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$TypeTable(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$TypeTable(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
