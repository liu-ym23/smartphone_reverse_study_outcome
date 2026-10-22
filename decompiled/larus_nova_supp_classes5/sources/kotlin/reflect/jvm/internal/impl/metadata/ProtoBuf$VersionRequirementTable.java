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
public final class ProtoBuf$VersionRequirementTable extends GeneratedMessageLite implements ProtoBuf$VersionRequirementTableOrBuilder {
    public static Parser<ProtoBuf$VersionRequirementTable> PARSER;
    private static final ProtoBuf$VersionRequirementTable defaultInstance = null;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf.VersionRequirement> requirement_;
    private final ByteString unknownFields;

    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$VersionRequirementTable, Builder> implements ProtoBuf$VersionRequirementTableOrBuilder {
        private int bitField0_;
        private List<ProtoBuf.VersionRequirement> requirement_;

        private void maybeForceBuilderInitialization() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureRequirementIsMutable() {
            if ((this.bitField0_ & 1) == 1) goto L6;
            this.requirement_ = new ArrayList(this.requirement_);
            this.bitField0_ |= 1;
            return;
        }

        public ProtoBuf$VersionRequirementTable buildPartial() {
            ProtoBuf$VersionRequirementTable r0 = new ProtoBuf$VersionRequirementTable(this, null);
            if ((this.bitField0_ & 1) != 1) goto L5;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
            this.bitField0_ &= -2;
        L5:
            ProtoBuf$VersionRequirementTable.access$22302(r0, this.requirement_);
            return r0;
        }

        private Builder() {
            this.requirement_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ Builder access$22100() {
            return create();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$VersionRequirementTable build() {
            ProtoBuf$VersionRequirementTable r0 = buildPartial();
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
        public ProtoBuf$VersionRequirementTable getDefaultInstanceForType() {
            return ProtoBuf$VersionRequirementTable.getDefaultInstance();
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

        public Builder mergeFrom(ProtoBuf$VersionRequirementTable r3) {
            if (r3 != ProtoBuf$VersionRequirementTable.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (ProtoBuf$VersionRequirementTable.access$22300(r3).isEmpty() == false) goto L8;
        L11:
            setUnknownFields(getUnknownFields().concat(ProtoBuf$VersionRequirementTable.access$22400(r3)));
            return this;
        L8:
            if (this.requirement_.isEmpty() == false) goto L10;
            this.requirement_ = ProtoBuf$VersionRequirementTable.access$22300(r3);
            this.bitField0_ &= -2;
            goto L11
        L10:
            ensureRequirementIsMutable();
            this.requirement_.addAll(ProtoBuf$VersionRequirementTable.access$22300(r3));
            goto L11
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
            return mergeFrom((ProtoBuf$VersionRequirementTable) r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
            ProtoBuf$VersionRequirementTable r0 = null;
            ProtoBuf$VersionRequirementTable r5 = ProtoBuf$VersionRequirementTable.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
            if (r5 == null) goto L6;
            mergeFrom(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            ProtoBuf$VersionRequirementTable r6 = (ProtoBuf$VersionRequirementTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
        ProtoBuf$VersionRequirementTable r0 = new ProtoBuf$VersionRequirementTable(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getRequirementCount() {
        return this.requirement_.size();
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
        if (r1 >= this.requirement_.size()) goto L9;
        r2 = r2 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.requirement_, r1));
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
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    private void initFields() {
        this.requirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$22100();
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

    public static ProtoBuf$VersionRequirementTable getDefaultInstance() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$VersionRequirementTable> getParserForType() {
        return PARSER;
    }

    public List<ProtoBuf.VersionRequirement> getRequirementList() {
        return this.requirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$VersionRequirementTable getDefaultInstanceForType() {
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

    private ProtoBuf$VersionRequirementTable(GeneratedMessageLite.Builder r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$22300(ProtoBuf$VersionRequirementTable r0) {
        return r0.requirement_;
    }

    public static /* synthetic */ ByteString access$22400(ProtoBuf$VersionRequirementTable r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$VersionRequirementTable r1) {
        return newBuilder().mergeFrom(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r4) throws IOException {
        getSerializedSize();
        int r0 = 0;
    L4:
        if (r0 >= this.requirement_.size()) goto L6;
        r4.writeMessage(1, (MessageLite) ListProtector.get(this.requirement_, r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$VersionRequirementTable(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$VersionRequirementTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
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
        this.requirement_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
    L14:
        this.requirement_.add(r8.readMessage(ProtoBuf.VersionRequirement.PARSER, r9));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        goto L3
    L9:
        if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L48;
        this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
        this.requirement_ = Collections.unmodifiableList(this.requirement_);
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

    public static /* synthetic */ List access$22302(ProtoBuf$VersionRequirementTable r0, List r1) {
        r0.requirement_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$VersionRequirementTable(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$VersionRequirementTable(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
