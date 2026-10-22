package kotlinx.metadata.internal.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import kotlinx.metadata.internal.protobuf.a0;
import kotlinx.metadata.internal.protobuf.b0;
import kotlinx.metadata.internal.protobuf.f;
import kotlinx.metadata.internal.protobuf.g;
import kotlinx.metadata.internal.protobuf.i;
import kotlinx.metadata.internal.protobuf.m;
import kotlinx.metadata.internal.protobuf.r;
import kotlinx.metadata.internal.protobuf.s;
import kotlinx.metadata.internal.protobuf.x;
import kotlinx.metadata.internal.protobuf.y;
import kotlinx.metadata.internal.protobuf.z;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmProtoBuf$StringTableTypes extends GeneratedMessageLite implements a0 {
    public static final int LOCAL_NAME_FIELD_NUMBER = 5;
    public static b0 PARSER = null;
    public static final int RECORD_FIELD_NUMBER = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JvmProtoBuf$StringTableTypes f19122a = null;
    private static final long serialVersionUID = 0;
    private int localNameMemoizedSerializedSize;
    private List<Integer> localName_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<Record> record_;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    public static final class Record extends GeneratedMessageLite implements e {
        public static final int OPERATION_FIELD_NUMBER = 3;
        public static b0 PARSER = null;
        public static final int PREDEFINED_INDEX_FIELD_NUMBER = 2;
        public static final int RANGE_FIELD_NUMBER = 1;
        public static final int REPLACE_CHAR_FIELD_NUMBER = 5;
        public static final int STRING_FIELD_NUMBER = 6;
        public static final int SUBSTRING_INDEX_FIELD_NUMBER = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Record f19123a = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Operation operation_;
        private int predefinedIndex_;
        private int range_;
        private int replaceCharMemoizedSerializedSize;
        private List<Integer> replaceChar_;
        private Object string_;
        private int substringIndexMemoizedSerializedSize;
        private List<Integer> substringIndex_;
        private final kotlinx.metadata.internal.protobuf.e unknownFields;

        public static final enum Operation extends Enum<Operation> implements r {
            public static final Operation DESC_TO_CLASS_ID = null;
            public static final int DESC_TO_CLASS_ID_VALUE = 2;
            public static final Operation INTERNAL_TO_CLASS_ID = null;
            public static final int INTERNAL_TO_CLASS_ID_VALUE = 1;
            public static final Operation NONE = null;
            public static final int NONE_VALUE = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f19124a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ Operation[] f19125b = null;
            private final int value;

            static {
                Operation r5 = new Operation("NONE", 0, 0);
                NONE = r5;
                Operation r10 = new Operation("INTERNAL_TO_CLASS_ID", 1, 1);
                INTERNAL_TO_CLASS_ID = r10;
                Operation r11 = new Operation("DESC_TO_CLASS_ID", 2, 2);
                DESC_TO_CLASS_ID = r11;
                f19125b = new Operation[]{r5, r10, r11};
                f19124a = new d();
            }

            public Operation(String r5, int r10, int r11) {
                super(r5, r10);
                this.value = r11;
            }

            public static s internalGetValueMap() {
                return f19124a;
            }

            public static Operation valueOf(String r5) {
                return (Operation) Enum.valueOf(Operation.class, r5);
            }

            public static Operation[] values() {
                return (Operation[]) f19125b.clone();
            }

            @Override // kotlinx.metadata.internal.protobuf.r
            public final int getNumber() {
                return this.value;
            }

            public static Operation valueOf(int r5) {
                if (r5 == 0) goto L14;
                if (r5 == 1) goto L12;
                if (r5 == 2) goto L10;
                return null;
            L10:
                return DESC_TO_CLASS_ID;
            L12:
                return INTERNAL_TO_CLASS_ID;
            L14:
                return NONE;
            }
        }

        static {
            PARSER = new b();
            Record r5 = new Record();
            f19123a = r5;
            r5.range_ = 1;
            r5.predefinedIndex_ = 0;
            r5.string_ = "";
            r5.operation_ = Operation.NONE;
            r5.substringIndex_ = Collections.emptyList();
            r5.replaceChar_ = Collections.emptyList();
        }

        public Record(m r5, bu.e r10) {
            super(r5);
            this.substringIndexMemoizedSerializedSize = -1;
            this.replaceCharMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.f19190a;
        }

        public static /* synthetic */ int access$1002(Record r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$1100(Record r5) {
            return r5.unknownFields;
        }

        public static /* synthetic */ int access$402(Record r5, int r10) {
            r5.range_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$502(Record r5, int r10) {
            r5.predefinedIndex_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$600(Record r5) {
            return r5.string_;
        }

        public static /* synthetic */ Object access$602(Record r5, Object r10) {
            r5.string_ = r10;
            return r10;
        }

        public static /* synthetic */ Operation access$702(Record r5, Operation r10) {
            r5.operation_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$800(Record r5) {
            return r5.substringIndex_;
        }

        public static /* synthetic */ List access$802(Record r5, List r10) {
            r5.substringIndex_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$900(Record r5) {
            return r5.replaceChar_;
        }

        public static /* synthetic */ List access$902(Record r5, List r10) {
            r5.replaceChar_ = r10;
            return r10;
        }

        public static Record getDefaultInstance() {
            return f19123a;
        }

        public static c newBuilder(Record r5) {
            c r10 = newBuilder();
            r10.g(r5);
            return r10;
        }

        public static Record parseDelimitedFrom(InputStream r5) throws IOException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static Record parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public /* bridge */ /* synthetic */ z getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Operation getOperation() {
            return this.operation_;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public b0 getParserForType() {
            return PARSER;
        }

        public int getPredefinedIndex() {
            return this.predefinedIndex_;
        }

        public int getRange() {
            return this.range_;
        }

        public int getReplaceChar(int r5) {
            return this.replaceChar_.get(r5).intValue();
        }

        public int getReplaceCharCount() {
            return this.replaceChar_.size();
        }

        public List<Integer> getReplaceCharList() {
            return this.replaceChar_;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = g.c(1, this.range_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r11 = r11 + g.c(2, this.predefinedIndex_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r11 = r11 + g.b(3, this.operation_.getNumber());
        L15:
            int r12 = 0;
            int r13 = 0;
        L17:
            if (r12 >= this.substringIndex_.size()) goto L19;
            r13 = androidx.room.jarjarred.org.antlr.runtime.a.f(r13, this.substringIndex_.get(r12));
            r12 = r12 + 1;
            goto L17
        L19:
            int r14 = r11 + r13;
            if (getSubstringIndexList().isEmpty() == true) goto L22;
            r14 = (r14 + 1) + g.d(r13);
        L22:
            this.substringIndexMemoizedSerializedSize = r13;
            int r15 = 0;
        L24:
            if (r10 >= this.replaceChar_.size()) goto L26;
            r15 = androidx.room.jarjarred.org.antlr.runtime.a.f(r15, this.replaceChar_.get(r10));
            r10 = r10 + 1;
            goto L24
        L26:
            int r16 = r14 + r15;
            if (getReplaceCharList().isEmpty() == true) goto L29;
            r16 = (r16 + 1) + g.d(r15);
        L29:
            this.replaceCharMemoizedSerializedSize = r15;
            if ((this.bitField0_ & 4) != 4) goto L32;
            kotlinx.metadata.internal.protobuf.e r17 = getStringBytes();
            r16 = r16 + (g.a(r17) + g.h(6));
        L32:
            int r18 = this.unknownFields.size() + r16;
            this.memoizedSerializedSize = r18;
            return r18;
        L8:
            r11 = 0;
            goto L10
        }

        public String getString() {
            Object r5 = this.string_;
            if ((r5 instanceof String) == true) goto L5;
            kotlinx.metadata.internal.protobuf.e r10 = (kotlinx.metadata.internal.protobuf.e) r5;
            String r11 = r10.p();
            if (r10.i() == false) goto L9;
            this.string_ = r11;
        L9:
            return r11;
        L5:
            return (String) r5;
        }

        public kotlinx.metadata.internal.protobuf.e getStringBytes() {
            Object r5 = this.string_;
            if ((r5 instanceof String) == false) goto L7;
            x r10 = kotlinx.metadata.internal.protobuf.e.d((String) r5);
            this.string_ = r10;
            return r10;
        L7:
            return (kotlinx.metadata.internal.protobuf.e) r5;
        }

        public int getSubstringIndex(int r5) {
            return this.substringIndex_.get(r5).intValue();
        }

        public int getSubstringIndexCount() {
            return this.substringIndex_.size();
        }

        public List<Integer> getSubstringIndexList() {
            return this.substringIndex_;
        }

        public boolean hasOperation() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasPredefinedIndex() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasRange() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasString() {
            if ((this.bitField0_ & 4) != 4) goto L5;
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
        public /* bridge */ /* synthetic */ y newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public /* bridge */ /* synthetic */ y toBuilder() {
            return toBuilder();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public void writeTo(g r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.n(1, this.range_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.n(2, this.predefinedIndex_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L12;
            r5.m(3, this.operation_.getNumber());
        L12:
            if (getSubstringIndexList().size() <= 0) goto L14;
            r5.v(34);
            r5.v(this.substringIndexMemoizedSerializedSize);
        L14:
            int r10 = 0;
            int r11 = 0;
        L16:
            if (r11 >= this.substringIndex_.size()) goto L19;
            r5.o(this.substringIndex_.get(r11).intValue());
            r11 = r11 + 1;
            goto L16
        L19:
            if (getReplaceCharList().size() <= 0) goto L22;
            r5.v(42);
            r5.v(this.replaceCharMemoizedSerializedSize);
        L22:
            if (r10 >= this.replaceChar_.size()) goto L25;
            r5.o(this.replaceChar_.get(r10).intValue());
            r10 = r10 + 1;
            goto L22
        L25:
            if ((this.bitField0_ & 4) != 4) goto L27;
            r5.l(6, getStringBytes());
        L27:
            r5.r(this.unknownFields);
        }

        public static c newBuilder() {
            c r5 = new c();
            r5.f19129c = 1;
            r5.e = "";
            r5.f = Operation.NONE;
            r5.g = Collections.emptyList();
            r5.f19130h = Collections.emptyList();
            return r5;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Record getDefaultInstanceForType() {
            return f19123a;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public c newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public c toBuilder() {
            return newBuilder(this);
        }

        public static Record parseDelimitedFrom(InputStream r5, i r10) throws IOException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
        }

        public static Record parseFrom(kotlinx.metadata.internal.protobuf.e r5, i r10) throws InvalidProtocolBufferException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
        }

        public Record() {
            this.substringIndexMemoizedSerializedSize = -1;
            this.replaceCharMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
        }

        public static Record parseFrom(byte[] r5) throws InvalidProtocolBufferException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static Record parseFrom(byte[] r5, i r10) throws InvalidProtocolBufferException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
        }

        public Record(f r11, i r12, bu.e r13) throws InvalidProtocolBufferException {
            this.substringIndexMemoizedSerializedSize = -1;
            this.replaceCharMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.range_ = 1;
            boolean r5 = false;
            this.predefinedIndex_ = 0;
            this.string_ = "";
            this.operation_ = Operation.NONE;
            this.substringIndex_ = Collections.emptyList();
            this.replaceChar_ = Collections.emptyList();
            kotlinx.metadata.internal.protobuf.d r10 = new kotlinx.metadata.internal.protobuf.d();
            g r14 = g.j(r10, 1);
            int r15 = 0;
        L4:
            if (r5 == true) goto L82;
            int r16 = r11.n();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r16 == 0) goto L23;
            if (r16 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.range_ = r11.k();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L9:
            if (r16 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.predefinedIndex_ = r11.k();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L11:
            if (r16 != 24) goto L12;
            int r17 = r11.k();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            Operation r18 = Operation.valueOf(r17);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r18 == null) goto L59;
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.operation_ = r18;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L59:
            r14.v(r16);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r14.v(r17);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L12:
            if (r16 != 32) goto L14;
            if ((r15 & 16) == 16) goto L56;
            this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r15 = r15 | 16;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L56:
            this.substringIndex_.add(Integer.valueOf(r11.k()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L14:
            if (r16 != 34) goto L16;
            int r19 = r11.d(r11.k());     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if ((r15 & 16) == 16) goto L50;
            if (r11.b() <= 0) goto L50;
            this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r15 = r15 | 16;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L50:
            if (r11.b() <= 0) goto L52;
            this.substringIndex_.add(Integer.valueOf(r11.k()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L50
        L52:
            r11.c(r19);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L16:
            if (r16 != 40) goto L18;
            if ((r15 & 32) == 32) goto L43;
            this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r15 = r15 | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L43:
            this.replaceChar_.add(Integer.valueOf(r11.k()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L18:
            if (r16 != 42) goto L20;
            int r20 = r11.d(r11.k());     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if ((r15 & 32) == 32) goto L37;
            if (r11.b() <= 0) goto L37;
            this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r15 = r15 | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L37:
            if (r11.b() <= 0) goto L39;
            this.replaceChar_.add(Integer.valueOf(r11.k()));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L37
        L39:
            r11.c(r20);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L20:
            if (r16 != 50) goto L22;
            x r21 = r11.e();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.string_ = r21;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L22:
            if (parseUnknownField(r11, r14, r12, r16) == true) goto L4;
        L23:
            r5 = true;
            goto L4
        L24:
            th = move-exception;
            if ((r15 & 16) != 16) goto L72;
            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
        L72:
            if ((r15 & 32) != 32) goto L98;
            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
        L98:
            r14.i();     // Catch: IOException -> L95 Throwable -> L76
        L76:
            th = move-exception;
            this.unknownFields = r10.e();
            throw th;
        L75:
            this.unknownFields = r10.e();
            makeExtensionsImmutable();
            throw th;
        L26:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L28:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L82:
            if ((r15 & 16) != 16) goto L85;
            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
        L85:
            if ((r15 & 32) != 32) goto L100;
            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
        L100:
            r14.i();     // Catch: IOException -> L94 Throwable -> L89
        L89:
            th = move-exception;
            this.unknownFields = r10.e();
            throw th;
        L88:
            this.unknownFields = r10.e();
            makeExtensionsImmutable();
        }

        public static Record parseFrom(InputStream r5) throws IOException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static Record parseFrom(InputStream r5, i r10) throws IOException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
        }

        public static Record parseFrom(f r5) throws IOException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
        }

        public static Record parseFrom(f r5, i r10) throws IOException {
            return (Record) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
        }
    }

    static {
        PARSER = new au.b(25);
        JvmProtoBuf$StringTableTypes r5 = new JvmProtoBuf$StringTableTypes();
        f19122a = r5;
        r5.record_ = Collections.emptyList();
        r5.localName_ = Collections.emptyList();
    }

    public JvmProtoBuf$StringTableTypes(m r5, bu.e r10) {
        super(r5);
        this.localNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ List access$1400(JvmProtoBuf$StringTableTypes r5) {
        return r5.record_;
    }

    public static /* synthetic */ List access$1402(JvmProtoBuf$StringTableTypes r5, List r10) {
        r5.record_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$1500(JvmProtoBuf$StringTableTypes r5) {
        return r5.localName_;
    }

    public static /* synthetic */ List access$1502(JvmProtoBuf$StringTableTypes r5, List r10) {
        r5.localName_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$1600(JvmProtoBuf$StringTableTypes r5) {
        return r5.unknownFields;
    }

    public static JvmProtoBuf$StringTableTypes getDefaultInstance() {
        return f19122a;
    }

    public static a newBuilder(JvmProtoBuf$StringTableTypes r5) {
        a r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static JvmProtoBuf$StringTableTypes parseDelimitedFrom(InputStream r5) throws IOException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getLocalName(int r5) {
        return this.localName_.get(r5).intValue();
    }

    public int getLocalNameCount() {
        return this.localName_.size();
    }

    public List<Integer> getLocalNameList() {
        return this.localName_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public b0 getParserForType() {
        return PARSER;
    }

    public Record getRecord(int r5) {
        return this.record_.get(r5);
    }

    public int getRecordCount() {
        return this.record_.size();
    }

    public List<Record> getRecordList() {
        return this.record_;
    }

    public e getRecordOrBuilder(int r5) {
        return this.record_.get(r5);
    }

    public List<? extends e> getRecordOrBuilderList() {
        return this.record_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public int getSerializedSize() {
        int r5 = this.memoizedSerializedSize;
        if (r5 == (-1)) goto L5;
        return r5;
    L5:
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.record_.size()) goto L9;
        r12 = r12 + g.e(1, this.record_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r10 >= this.localName_.size()) goto L13;
        r13 = androidx.room.jarjarred.org.antlr.runtime.a.f(r13, this.localName_.get(r10));
        r10 = r10 + 1;
        goto L11
    L13:
        int r14 = r12 + r13;
        if (getLocalNameList().isEmpty() == true) goto L16;
        r14 = (r14 + 1) + g.d(r13);
    L16:
        this.localNameMemoizedSerializedSize = r13;
        int r15 = this.unknownFields.size() + r14;
        this.memoizedSerializedSize = r15;
        return r15;
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
    public /* bridge */ /* synthetic */ y newBuilderForType() {
        return newBuilderForType();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public /* bridge */ /* synthetic */ y toBuilder() {
        return toBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public void writeTo(g r5) throws IOException {
        getSerializedSize();
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.record_.size()) goto L7;
        r5.p(1, this.record_.get(r11));
        r11 = r11 + 1;
        goto L4
    L7:
        if (getLocalNameList().size() <= 0) goto L10;
        r5.v(42);
        r5.v(this.localNameMemoizedSerializedSize);
    L10:
        if (r10 >= this.localName_.size()) goto L12;
        r5.o(this.localName_.get(r10).intValue());
        r10 = r10 + 1;
        goto L10
    L12:
        r5.r(this.unknownFields);
    }

    public static a newBuilder() {
        a r5 = new a();
        r5.f19127c = Collections.emptyList();
        r5.d = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public JvmProtoBuf$StringTableTypes getDefaultInstanceForType() {
        return f19122a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public a newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public a toBuilder() {
        return newBuilder(this);
    }

    public static JvmProtoBuf$StringTableTypes parseDelimitedFrom(InputStream r5, i r10) throws IOException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(kotlinx.metadata.internal.protobuf.e r5, i r10) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public JvmProtoBuf$StringTableTypes() {
        this.localNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public JvmProtoBuf$StringTableTypes(f r10, i r11, bu.e r12) throws InvalidProtocolBufferException {
        this.localNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.record_ = Collections.emptyList();
        this.localName_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r13 = new kotlinx.metadata.internal.protobuf.d();
        g r5 = g.j(r13, 1);
        boolean r14 = false;
        int r15 = 0;
    L4:
        if (r14 == true) goto L58;
        int r16 = r10.n();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        if (r16 == 0) goto L15;
        if (r16 != 10) goto L10;
        if ((r15 & 1) == 1) goto L38;
        this.record_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        r15 = r15 | 1;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
    L38:
        this.record_.add((Record) r10.g(Record.PARSER, r11));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        goto L4
    L10:
        if (r16 != 40) goto L12;
        if ((r15 & 2) == 2) goto L34;
        this.localName_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        r15 = r15 | 2;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
    L34:
        this.localName_.add(Integer.valueOf(r10.k()));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        goto L4
    L12:
        if (r16 != 42) goto L14;
        int r17 = r10.d(r10.k());     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        if ((r15 & 2) == 2) goto L28;
        if (r10.b() <= 0) goto L28;
        this.localName_ = new ArrayList();     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        r15 = r15 | 2;     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
    L28:
        if (r10.b() <= 0) goto L30;
        this.localName_.add(Integer.valueOf(r10.k()));     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        goto L28
    L30:
        r10.c(r17);     // Catch: Throwable -> L16 IOException -> L18 InvalidProtocolBufferException -> L20
        goto L4
    L14:
        if (parseUnknownField(r10, r5, r11, r16) == true) goto L4;
    L15:
        r14 = true;
        goto L4
    L16:
        th = move-exception;
        if ((r15 & 1) != 1) goto L48;
        this.record_ = Collections.unmodifiableList(this.record_);
    L48:
        if ((r15 & 2) != 2) goto L75;
        this.localName_ = Collections.unmodifiableList(this.localName_);
    L75:
        r5.i();     // Catch: IOException -> L71 Throwable -> L52
    L52:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L51:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
        throw th;
    L20:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L16
    L18:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L16
    L58:
        if ((r15 & 1) != 1) goto L61;
        this.record_ = Collections.unmodifiableList(this.record_);
    L61:
        if ((r15 & 2) != 2) goto L73;
        this.localName_ = Collections.unmodifiableList(this.localName_);
    L73:
        r5.i();     // Catch: IOException -> L70 Throwable -> L65
    L65:
        th = move-exception;
        this.unknownFields = r13.e();
        throw th;
    L64:
        this.unknownFields = r13.e();
        makeExtensionsImmutable();
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(byte[] r5, i r10) throws InvalidProtocolBufferException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(InputStream r5) throws IOException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(InputStream r5, i r10) throws IOException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(f r5) throws IOException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static JvmProtoBuf$StringTableTypes parseFrom(f r5, i r10) throws IOException {
        return (JvmProtoBuf$StringTableTypes) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
