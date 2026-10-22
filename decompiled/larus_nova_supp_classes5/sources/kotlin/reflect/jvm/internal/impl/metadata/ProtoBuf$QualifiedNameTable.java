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
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$QualifiedNameTable extends GeneratedMessageLite implements ProtoBuf$QualifiedNameTableOrBuilder {
    public static Parser<ProtoBuf$QualifiedNameTable> PARSER;
    private static final ProtoBuf$QualifiedNameTable defaultInstance = null;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<QualifiedName> qualifiedName_;
    private final ByteString unknownFields;

    public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
        public static Parser<QualifiedName> PARSER;
        private static final QualifiedName defaultInstance = null;
        private int bitField0_;
        private Kind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int parentQualifiedName_;
        private int shortName_;
        private final ByteString unknownFields;

        public static final enum Kind extends Enum<Kind> implements Internal$EnumLite {
            private static final /* synthetic */ Kind[] $VALUES = null;
            public static final Kind CLASS = null;
            public static final Kind LOCAL = null;
            public static final Kind PACKAGE = null;
            private static Internal$EnumLiteMap<Kind> internalValueMap;
            private final int value;

            static {
                Kind r0 = new Kind("CLASS", 0, 0, 0);
                CLASS = r0;
                Kind r1 = new Kind("PACKAGE", 1, 1, 1);
                PACKAGE = r1;
                Kind r3 = new Kind("LOCAL", 2, 2, 2);
                LOCAL = r3;
                $VALUES = new Kind[]{r0, r1, r3};
                internalValueMap = new AnonymousClass1();
            }

            public static Kind[] values() {
                return (Kind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return LOCAL;
            L12:
                return PACKAGE;
            L14:
                return CLASS;
            }

            public static Kind valueOf(String r1) {
                return (Kind) a.a(Kind.class, r1);
            }

            private Kind(String r1, int r2, int r3, int r4) {
                super(r1, r2);
                this.value = r4;
            }
        }

        private void initFields() {
            this.parentQualifiedName_ = -1;
            this.shortName_ = 0;
            this.kind_ = Kind.PACKAGE;
        }

        static {
            PARSER = new AnonymousClass1();
            QualifiedName r0 = new QualifiedName(true);
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
            if ((this.bitField0_ & 1) != 1) goto L9;
            r2 = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r2 = r2 + CodedOutputStream.computeInt32Size(2, this.shortName_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L14;
            r2 = r2 + CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
        L14:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
            return false;
        L9:
            if (hasShortName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$700();
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

        public static QualifiedName getDefaultInstance() {
            return defaultInstance;
        }

        public Kind getKind() {
            return this.kind_;
        }

        public int getParentQualifiedName() {
            return this.parentQualifiedName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<QualifiedName> getParserForType() {
            return PARSER;
        }

        public int getShortName() {
            return this.shortName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public QualifiedName getDefaultInstanceForType() {
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

        private QualifiedName(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$1300(QualifiedName r0) {
            return r0.unknownFields;
        }

        public static Builder newBuilder(QualifiedName r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r3) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r3.writeInt32(1, this.parentQualifiedName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r3.writeInt32(2, this.shortName_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r3.writeEnum(3, this.kind_.getNumber());
        L11:
            r3.writeRawBytes(this.unknownFields);
        }

        private QualifiedName(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private QualifiedName(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L49;
            int r4 = r8.readTag();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            if (r4 == 0) goto L22;
            if (r4 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            this.parentQualifiedName_ = r8.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            goto L3
        L9:
            if (r4 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            this.shortName_ = r8.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            goto L3
        L11:
            if (r4 != 24) goto L13;
            int r5 = r8.readEnum();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            Kind r6 = Kind.valueOf(r5);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            if (r6 == null) goto L17;
            this.bitField0_ |= 4;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            this.kind_ = r6;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            goto L3
        L17:
            r2.writeRawVarint32(r4);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            r2.writeRawVarint32(r5);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            goto L3
        L13:
            if (parseUnknownField(r8, r2, r9, r4) == true) goto L3;
        L22:
            r3 = true;
            goto L3
        L23:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L45 Throwable -> L33
        L33:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L32:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L28:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L23
        L25:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L23
        L49:
            r2.flush();     // Catch: IOException -> L46 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L39:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$1002(QualifiedName r0, int r1) {
            r0.shortName_ = r1;
            return r1;
        }

        public static /* synthetic */ Kind access$1102(QualifiedName r0, Kind r1) {
            r0.kind_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$1202(QualifiedName r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$902(QualifiedName r0, int r1) {
            r0.parentQualifiedName_ = r1;
            return r1;
        }

        public /* synthetic */ QualifiedName(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
            this(r1);
        }

        public /* synthetic */ QualifiedName(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$QualifiedNameTable r0 = new ProtoBuf$QualifiedNameTable(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getQualifiedNameCount() {
        return this.qualifiedName_.size();
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
        if (r1 >= this.qualifiedName_.size()) goto L9;
        r2 = r2 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.qualifiedName_, r1));
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
        if (r1 >= getQualifiedNameCount()) goto L16;
        if (getQualifiedName(r1).isInitialized() == false) goto L13;
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
        this.qualifiedName_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$1400();
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

    public static ProtoBuf$QualifiedNameTable getDefaultInstance() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$QualifiedNameTable> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$QualifiedNameTable getDefaultInstanceForType() {
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

    private ProtoBuf$QualifiedNameTable(GeneratedMessageLite.Builder r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$1600(ProtoBuf$QualifiedNameTable r0) {
        return r0.qualifiedName_;
    }

    public static /* synthetic */ ByteString access$1700(ProtoBuf$QualifiedNameTable r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$QualifiedNameTable r1) {
        return newBuilder().mergeFrom(r1);
    }

    public QualifiedName getQualifiedName(int r2) {
        return (QualifiedName) ListProtector.get(this.qualifiedName_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r4) throws IOException {
        getSerializedSize();
        int r0 = 0;
    L4:
        if (r0 >= this.qualifiedName_.size()) goto L6;
        r4.writeMessage(1, (MessageLite) ListProtector.get(this.qualifiedName_, r0));
        r0 = r0 + 1;
        goto L4
    L6:
        r4.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$QualifiedNameTable(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$QualifiedNameTable(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
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
        this.qualifiedName_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        r4 = r4 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
    L14:
        this.qualifiedName_.add((QualifiedName) r8.readMessage(QualifiedName.PARSER, r9));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        goto L3
    L9:
        if (parseUnknownField(r8, r2, r9, r5) == true) goto L3;
    L16:
        r3 = true;
        goto L3
    L17:
        th = move-exception;
        if ((r4 & true) != true) goto L48;
        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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

    public static /* synthetic */ List access$1602(ProtoBuf$QualifiedNameTable r0, List r1) {
        r0.qualifiedName_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$QualifiedNameTable(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$QualifiedNameTable(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
