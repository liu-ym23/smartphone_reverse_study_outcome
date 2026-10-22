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
public final class ProtoBuf$Contract extends GeneratedMessageLite implements ProtoBuf$ContractOrBuilder {
    public static Parser<ProtoBuf$Contract> PARSER;
    private static final ProtoBuf$Contract defaultInstance = null;
    private List<ProtoBuf.Effect> effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Contract, Builder> implements ProtoBuf$ContractOrBuilder {
        private int bitField0_;
        private List<ProtoBuf.Effect> effect_;

        private void maybeForceBuilderInitialization() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            int r1 = 0;
        L4:
            if (r1 >= getEffectCount()) goto L9;
            if (getEffect(r1).isInitialized() == false) goto L7;
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

        private void ensureEffectIsMutable() {
            if ((this.bitField0_ & 1) == 1) goto L6;
            this.effect_ = new ArrayList(this.effect_);
            this.bitField0_ |= 1;
            return;
        }

        public ProtoBuf$Contract buildPartial() {
            ProtoBuf$Contract r0 = new ProtoBuf$Contract(this, null);
            if ((this.bitField0_ & 1) != 1) goto L5;
            this.effect_ = Collections.unmodifiableList(this.effect_);
            this.bitField0_ &= -2;
        L5:
            ProtoBuf$Contract.access$23702(r0, this.effect_);
            return r0;
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        private Builder() {
            this.effect_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ Builder access$23500() {
            return create();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Contract build() {
            ProtoBuf$Contract r0 = buildPartial();
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
        public ProtoBuf$Contract getDefaultInstanceForType() {
            return ProtoBuf$Contract.getDefaultInstance();
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

        public ProtoBuf.Effect getEffect(int r2) {
            return (ProtoBuf.Effect) ListProtector.get(this.effect_, r2);
        }

        public Builder mergeFrom(ProtoBuf$Contract r3) {
            if (r3 != ProtoBuf$Contract.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (ProtoBuf$Contract.access$23700(r3).isEmpty() == false) goto L8;
        L11:
            setUnknownFields(getUnknownFields().concat(ProtoBuf$Contract.access$23800(r3)));
            return this;
        L8:
            if (this.effect_.isEmpty() == false) goto L10;
            this.effect_ = ProtoBuf$Contract.access$23700(r3);
            this.bitField0_ &= -2;
            goto L11
        L10:
            ensureEffectIsMutable();
            this.effect_.addAll(ProtoBuf$Contract.access$23700(r3));
            goto L11
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
            return mergeFrom((ProtoBuf$Contract) r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
            ProtoBuf$Contract r0 = null;
            ProtoBuf$Contract r5 = ProtoBuf$Contract.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
            if (r5 == null) goto L6;
            mergeFrom(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            ProtoBuf$Contract r6 = (ProtoBuf$Contract) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
        ProtoBuf$Contract r0 = new ProtoBuf$Contract(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getEffectCount() {
        return this.effect_.size();
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
        if (r1 >= this.effect_.size()) goto L9;
        r2 = r2 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.effect_, r1));
        r1 = r1 + 1;
        goto L7
    L9:
        int r3 = r2 + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
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
        if (r1 >= getEffectCount()) goto L16;
        if (getEffect(r1).isInitialized() == false) goto L13;
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
        this.effect_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$23500();
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

    public static ProtoBuf$Contract getDefaultInstance() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Contract> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Contract getDefaultInstanceForType() {
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

    private ProtoBuf$Contract(GeneratedMessageLite.Builder r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$23700(ProtoBuf$Contract r0) {
        return r0.effect_;
    }

    public static /* synthetic */ ByteString access$23800(ProtoBuf$Contract r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Contract r1) {
        return newBuilder().mergeFrom(r1);
    }

    public ProtoBuf.Effect getEffect(int r2) {
        return (ProtoBuf.Effect) ListProtector.get(this.effect_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r4) throws IOException {
        getSerializedSize();
        int r0 = 0;
    L4:
        if (r0 >= this.effect_.size()) goto L6;
        r4.writeMessage(1, (MessageLite) ListProtector.get(this.effect_, r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Contract(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$Contract(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        boolean r4 = false;
    L3:
        if (r3 == true) goto L36;
        int r5 = r8.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        if (r5 == 0) goto L16;
        if (r5 != 10) goto L9;
        if ((r4 & true) == true) goto L14;
        this.effect_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
    L14:
        this.effect_.add(r8.readMessage(ProtoBuf.Effect.PARSER, r9));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        goto L3
    L9:
        if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L48;
        this.effect_ = Collections.unmodifiableList(this.effect_);
    L48:
        r2.flush();     // Catch: IOException -> L46 Throwable -> L30
    L30:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L29:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L22:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
    L36:
        if ((r4 & true) != true) goto L51;
        this.effect_ = Collections.unmodifiableList(this.effect_);
    L51:
        r2.flush();     // Catch: IOException -> L45 Throwable -> L40
    L40:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L39:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ List access$23702(ProtoBuf$Contract r0, List r1) {
        r0.effect_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$Contract(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Contract(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
