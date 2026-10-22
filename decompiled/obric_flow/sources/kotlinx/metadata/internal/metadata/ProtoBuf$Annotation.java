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
public final class ProtoBuf$Annotation extends GeneratedMessageLite implements i {
    public static final int ARGUMENT_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static kotlinx.metadata.internal.protobuf.b0 PARSER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoBuf$Annotation f19038a = null;
    private static final long serialVersionUID = 0;
    private List<Argument> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final kotlinx.metadata.internal.protobuf.e unknownFields;

    public static final class Argument extends GeneratedMessageLite implements g {
        public static final int NAME_ID_FIELD_NUMBER = 1;
        public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Argument f19039a = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final kotlinx.metadata.internal.protobuf.e unknownFields;
        private Value value_;

        public static final class Value extends GeneratedMessageLite implements f {
            public static final int ANNOTATION_FIELD_NUMBER = 8;
            public static final int ARRAY_DIMENSION_COUNT_FIELD_NUMBER = 11;
            public static final int ARRAY_ELEMENT_FIELD_NUMBER = 9;
            public static final int CLASS_ID_FIELD_NUMBER = 6;
            public static final int DOUBLE_VALUE_FIELD_NUMBER = 4;
            public static final int ENUM_VALUE_ID_FIELD_NUMBER = 7;
            public static final int FLAGS_FIELD_NUMBER = 10;
            public static final int FLOAT_VALUE_FIELD_NUMBER = 3;
            public static final int INT_VALUE_FIELD_NUMBER = 2;
            public static kotlinx.metadata.internal.protobuf.b0 PARSER = null;
            public static final int STRING_VALUE_FIELD_NUMBER = 5;
            public static final int TYPE_FIELD_NUMBER = 1;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Value f19040a = null;
            private static final long serialVersionUID = 0;
            private ProtoBuf$Annotation annotation_;
            private int arrayDimensionCount_;
            private List<Value> arrayElement_;
            private int bitField0_;
            private int classId_;
            private double doubleValue_;
            private int enumValueId_;
            private int flags_;
            private float floatValue_;
            private long intValue_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int stringValue_;
            private Type type_;
            private final kotlinx.metadata.internal.protobuf.e unknownFields;

            public static final enum Type extends Enum<Type> implements kotlinx.metadata.internal.protobuf.r {
                public static final Type ANNOTATION = null;
                public static final int ANNOTATION_VALUE = 11;
                public static final Type ARRAY = null;
                public static final int ARRAY_VALUE = 12;
                public static final Type BOOLEAN = null;
                public static final int BOOLEAN_VALUE = 7;
                public static final Type BYTE = null;
                public static final int BYTE_VALUE = 0;
                public static final Type CHAR = null;
                public static final int CHAR_VALUE = 1;
                public static final Type CLASS = null;
                public static final int CLASS_VALUE = 9;
                public static final Type DOUBLE = null;
                public static final int DOUBLE_VALUE = 6;
                public static final Type ENUM = null;
                public static final int ENUM_VALUE = 10;
                public static final Type FLOAT = null;
                public static final int FLOAT_VALUE = 5;
                public static final Type INT = null;
                public static final int INT_VALUE = 3;
                public static final Type LONG = null;
                public static final int LONG_VALUE = 4;
                public static final Type SHORT = null;
                public static final int SHORT_VALUE = 2;
                public static final Type STRING = null;
                public static final int STRING_VALUE = 8;

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final e f19041a = null;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public static final /* synthetic */ Type[] f19042b = null;
                private final int value;

                static {
                    Type r5 = new Type("BYTE", 0, 0);
                    BYTE = r5;
                    Type r10 = new Type("CHAR", 1, 1);
                    CHAR = r10;
                    Type r11 = new Type("SHORT", 2, 2);
                    SHORT = r11;
                    Type r12 = new Type("INT", 3, 3);
                    INT = r12;
                    Type r13 = new Type("LONG", 4, 4);
                    LONG = r13;
                    Type r14 = new Type("FLOAT", 5, 5);
                    FLOAT = r14;
                    Type r15 = new Type("DOUBLE", 6, 6);
                    DOUBLE = r15;
                    Type r16 = new Type("BOOLEAN", 7, 7);
                    BOOLEAN = r16;
                    Type r17 = new Type("STRING", 8, 8);
                    STRING = r17;
                    Type r18 = new Type("CLASS", 9, 9);
                    CLASS = r18;
                    Type r19 = new Type("ENUM", 10, 10);
                    ENUM = r19;
                    Type r110 = new Type("ANNOTATION", 11, 11);
                    ANNOTATION = r110;
                    Type r111 = new Type("ARRAY", 12, 12);
                    ARRAY = r111;
                    f19042b = new Type[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
                    f19041a = new e();
                }

                public Type(String r5, int r10, int r11) {
                    super(r5, r10);
                    this.value = r11;
                }

                public static kotlinx.metadata.internal.protobuf.s internalGetValueMap() {
                    return f19041a;
                }

                public static Type valueOf(String r5) {
                    return (Type) Enum.valueOf(Type.class, r5);
                }

                public static Type[] values() {
                    return (Type[]) f19042b.clone();
                }

                @Override // kotlinx.metadata.internal.protobuf.r
                public final int getNumber() {
                    return this.value;
                }

                public static Type valueOf(int r5) {
                    switch(r5) {
                        case 0: goto L30;
                        case 1: goto L28;
                        case 2: goto L26;
                        case 3: goto L24;
                        case 4: goto L22;
                        case 5: goto L20;
                        case 6: goto L18;
                        case 7: goto L16;
                        case 8: goto L14;
                        case 9: goto L12;
                        case 10: goto L10;
                        case 11: goto L8;
                        case 12: goto L6;
                        default: goto L3;
                    };
                L3:
                    return null;
                L6:
                    return ARRAY;
                L8:
                    return ANNOTATION;
                L10:
                    return ENUM;
                L12:
                    return CLASS;
                L14:
                    return STRING;
                L16:
                    return BOOLEAN;
                L18:
                    return DOUBLE;
                L20:
                    return FLOAT;
                L22:
                    return LONG;
                L24:
                    return INT;
                L26:
                    return SHORT;
                L28:
                    return CHAR;
                L30:
                    return BYTE;
                }
            }

            static {
                PARSER = new c();
                Value r5 = new Value();
                f19040a = r5;
                r5.a();
            }

            public Value(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
                super(r5);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r5.f19190a;
            }

            public static /* synthetic */ Type access$2302(Value r5, Type r10) {
                r5.type_ = r10;
                return r10;
            }

            public static /* synthetic */ long access$2402(Value r5, long r10) {
                r5.intValue_ = r10;
                return r10;
            }

            public static /* synthetic */ float access$2502(Value r5, float r10) {
                r5.floatValue_ = r10;
                return r10;
            }

            public static /* synthetic */ double access$2602(Value r5, double r10) {
                r5.doubleValue_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$2702(Value r5, int r10) {
                r5.stringValue_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$2802(Value r5, int r10) {
                r5.classId_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$2902(Value r5, int r10) {
                r5.enumValueId_ = r10;
                return r10;
            }

            public static /* synthetic */ ProtoBuf$Annotation access$3002(Value r5, ProtoBuf$Annotation r10) {
                r5.annotation_ = r10;
                return r10;
            }

            public static /* synthetic */ List access$3100(Value r5) {
                return r5.arrayElement_;
            }

            public static /* synthetic */ List access$3102(Value r5, List r10) {
                r5.arrayElement_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$3202(Value r5, int r10) {
                r5.arrayDimensionCount_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$3302(Value r5, int r10) {
                r5.flags_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$3402(Value r5, int r10) {
                r5.bitField0_ = r10;
                return r10;
            }

            public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$3500(Value r5) {
                return r5.unknownFields;
            }

            public static Value getDefaultInstance() {
                return f19040a;
            }

            public static d newBuilder(Value r5) {
                d r10 = newBuilder();
                r10.g(r5);
                return r10;
            }

            public static Value parseDelimitedFrom(InputStream r5) throws IOException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
            }

            public static Value parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
            }

            public final void a() {
                this.type_ = Type.BYTE;
                this.intValue_ = 0;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                this.arrayElement_ = Collections.emptyList();
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            public ProtoBuf$Annotation getAnnotation() {
                return this.annotation_;
            }

            public int getArrayDimensionCount() {
                return this.arrayDimensionCount_;
            }

            public Value getArrayElement(int r5) {
                return this.arrayElement_.get(r5);
            }

            public int getArrayElementCount() {
                return this.arrayElement_.size();
            }

            public List<Value> getArrayElementList() {
                return this.arrayElement_;
            }

            public f getArrayElementOrBuilder(int r5) {
                return this.arrayElement_.get(r5);
            }

            public List<? extends f> getArrayElementOrBuilderList() {
                return this.arrayElement_;
            }

            public int getClassId() {
                return this.classId_;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
            public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public double getDoubleValue() {
                return this.doubleValue_;
            }

            public int getEnumValueId() {
                return this.enumValueId_;
            }

            public int getFlags() {
                return this.flags_;
            }

            public float getFloatValue() {
                return this.floatValue_;
            }

            public long getIntValue() {
                return this.intValue_;
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
                int r11 = kotlinx.metadata.internal.protobuf.g.b(1, this.type_.getNumber());
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                long r12 = this.intValue_;
                r11 = r11 + (kotlinx.metadata.internal.protobuf.g.g((r12 >> 63) ^ (r12 << 1)) + kotlinx.metadata.internal.protobuf.g.h(2));
            L13:
                if ((this.bitField0_ & 4) != 4) goto L16;
                r11 = r11 + (kotlinx.metadata.internal.protobuf.g.h(3) + 4);
            L16:
                if ((this.bitField0_ & 8) != 8) goto L19;
                r11 = r11 + (kotlinx.metadata.internal.protobuf.g.h(4) + 8);
            L19:
                if ((this.bitField0_ & 16) != 16) goto L22;
                r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(5, this.stringValue_);
            L22:
                if ((this.bitField0_ & 32) != 32) goto L25;
                r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(6, this.classId_);
            L25:
                if ((this.bitField0_ & 64) != 64) goto L28;
                r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(7, this.enumValueId_);
            L28:
                if ((this.bitField0_ & 128) != 128) goto L31;
                r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(8, this.annotation_);
            L31:
                if (r10 >= this.arrayElement_.size()) goto L34;
                r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(9, this.arrayElement_.get(r10));
                r10 = r10 + 1;
                goto L31
            L34:
                if ((this.bitField0_ & 512) != 512) goto L37;
                r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(10, this.flags_);
            L37:
                if ((this.bitField0_ & 256) != 256) goto L39;
                r11 = r11 + kotlinx.metadata.internal.protobuf.g.c(11, this.arrayDimensionCount_);
            L39:
                int r13 = this.unknownFields.size() + r11;
                this.memoizedSerializedSize = r13;
                return r13;
            L8:
                r11 = 0;
                goto L10
            }

            public int getStringValue() {
                return this.stringValue_;
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasAnnotation() {
                if ((this.bitField0_ & 128) != 128) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasArrayDimensionCount() {
                if ((this.bitField0_ & 256) != 256) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasClassId() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasDoubleValue() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasEnumValueId() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasFlags() {
                if ((this.bitField0_ & 512) != 512) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasFloatValue() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasIntValue() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasStringValue() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
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
                if (hasAnnotation() == true) goto L11;
            L14:
                int r10 = 0;
            L16:
                if (r10 >= getArrayElementCount()) goto L22;
                if (getArrayElement(r10).isInitialized() == false) goto L19;
                r10 = r10 + 1;
                goto L16
            L19:
                this.memoizedIsInitialized = 0;
                return false;
            L22:
                this.memoizedIsInitialized = 1;
                return true;
            L11:
                if (getAnnotation().isInitialized() == true) goto L14;
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
            public void writeTo(kotlinx.metadata.internal.protobuf.g r10) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L5;
                r10.m(1, this.type_.getNumber());
            L5:
                int r5 = 0;
                if ((this.bitField0_ & 2) != 2) goto L9;
                long r11 = this.intValue_;
                r10.x(2, 0);
                long r12 = r11 << 1;
                r10.w((r11 >> 63) ^ r12);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L12;
                float r13 = this.floatValue_;
                r10.x(3, 5);
                r10.t(Float.floatToRawIntBits(r13));
            L12:
                if ((this.bitField0_ & 8) != 8) goto L15;
                double r14 = this.doubleValue_;
                r10.x(4, 1);
                r10.u(Double.doubleToRawLongBits(r14));
            L15:
                if ((this.bitField0_ & 16) != 16) goto L18;
                r10.n(5, this.stringValue_);
            L18:
                if ((this.bitField0_ & 32) != 32) goto L21;
                r10.n(6, this.classId_);
            L21:
                if ((this.bitField0_ & 64) != 64) goto L24;
                r10.n(7, this.enumValueId_);
            L24:
                if ((this.bitField0_ & 128) != 128) goto L27;
                r10.p(8, this.annotation_);
            L27:
                if (r5 >= this.arrayElement_.size()) goto L30;
                r10.p(9, this.arrayElement_.get(r5));
                r5 = r5 + 1;
                goto L27
            L30:
                if ((this.bitField0_ & 512) != 512) goto L33;
                r10.n(10, this.flags_);
            L33:
                if ((this.bitField0_ & 256) != 256) goto L35;
                r10.n(11, this.arrayDimensionCount_);
            L35:
                r10.r(this.unknownFields);
            }

            public static d newBuilder() {
                d r5 = new d();
                r5.f19105c = Type.BYTE;
                r5.f19108j = ProtoBuf$Annotation.getDefaultInstance();
                r5.f19109k = Collections.emptyList();
                return r5;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
            public Value getDefaultInstanceForType() {
                return f19040a;
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
            public d newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
            public d toBuilder() {
                return newBuilder(this);
            }

            public static Value parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
            }

            public static Value parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
            }

            public Value() {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
            }

            public static Value parseFrom(byte[] r5) throws InvalidProtocolBufferException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
            }

            public Value(kotlinx.metadata.internal.protobuf.f r12, kotlinx.metadata.internal.protobuf.i r13, au.a r14) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                a();
                kotlinx.metadata.internal.protobuf.d r15 = new kotlinx.metadata.internal.protobuf.d();
                kotlinx.metadata.internal.protobuf.g r5 = kotlinx.metadata.internal.protobuf.g.j(r15, 1);
                boolean r10 = false;
                char r11 = 0;
            L4:
                if (r10 == true) goto L56;
                int r16 = r12.n();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                switch(r16) {
                    case 0: goto L9;
                    case 8: goto L36;
                    case 16: goto L35;
                    case 29: goto L34;
                    case 33: goto L33;
                    case 40: goto L32;
                    case 48: goto L31;
                    case 56: goto L30;
                    case 66: goto L23;
                    case 74: goto L19;
                    case 80: goto L17;
                    case 88: goto L16;
                    default: goto L8;
                };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            L9:
                r10 = true;
                goto L4
            L16:
                this.bitField0_ |= 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.arrayDimensionCount_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L17:
                this.bitField0_ |= 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.flags_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L19:
                if ((r11 & 256) == 256) goto L21;
                this.arrayElement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                r11 = 256;
            L21:
                this.arrayElement_.add((Value) r12.g(PARSER, r13));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L23:
                if ((this.bitField0_ & 128) != 128) goto L25;
                h r17 = this.annotation_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            L26:
                ProtoBuf$Annotation r18 = (ProtoBuf$Annotation) r12.g(ProtoBuf$Annotation.PARSER, r13);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.annotation_ = r18;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                if (r17 == null) goto L29;
                r17.g(r18);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.annotation_ = r17.f();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            L29:
                this.bitField0_ |= 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L25:
                r17 = null;
                goto L26
            L30:
                this.bitField0_ |= 64;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.enumValueId_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L31:
                this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.classId_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L32:
                this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.stringValue_ = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L33:
                this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.doubleValue_ = Double.longBitsToDouble(r12.j());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L34:
                this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.floatValue_ = Float.intBitsToFloat(r12.i());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L35:
                this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                long r19 = r12.l();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.intValue_ = (-(r19 & 1)) ^ (r19 >>> 1);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L36:
                int r20 = r12.k();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                Type r21 = Type.valueOf(r20);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                if (r21 == null) goto L38;
                this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                this.type_ = r21;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L38:
                r5.v(r16);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                r5.v(r20);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                goto L4
            L8:
                if (parseUnknownField(r12, r5, r13, r16) == true) goto L4;
            L10:
                th = move-exception;
                if ((r11 & 256) != 256) goto L69;
                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
            L69:
                r5.i();     // Catch: IOException -> L66 Throwable -> L50
            L50:
                th = move-exception;
                this.unknownFields = r15.e();
                throw th;
            L49:
                this.unknownFields = r15.e();
                makeExtensionsImmutable();
                throw th;
            L12:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
            L14:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
            L56:
                if ((r11 & 256) != 256) goto L71;
                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
            L71:
                r5.i();     // Catch: IOException -> L65 Throwable -> L60
            L60:
                th = move-exception;
                this.unknownFields = r15.e();
                throw th;
            L59:
                this.unknownFields = r15.e();
                makeExtensionsImmutable();
            }

            public static Value parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
            }

            public static Value parseFrom(InputStream r5) throws IOException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
            }

            public static Value parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
            }

            public static Value parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
            }

            public static Value parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
                return (Value) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
            }
        }

        static {
            PARSER = new a();
            Argument r5 = new Argument();
            f19039a = r5;
            r5.nameId_ = 0;
            r5.value_ = Value.getDefaultInstance();
        }

        public Argument(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.f19190a;
        }

        public static /* synthetic */ int access$3802(Argument r5, int r10) {
            r5.nameId_ = r10;
            return r10;
        }

        public static /* synthetic */ Value access$3902(Argument r5, Value r10) {
            r5.value_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4002(Argument r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$4100(Argument r5) {
            return r5.unknownFields;
        }

        public static Argument getDefaultInstance() {
            return f19039a;
        }

        public static b newBuilder(Argument r5) {
            b r10 = newBuilder();
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

        public int getNameId() {
            return this.nameId_;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public kotlinx.metadata.internal.protobuf.b0 getParserForType() {
            return PARSER;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = kotlinx.metadata.internal.protobuf.g.c(1, this.nameId_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r10 = r10 + kotlinx.metadata.internal.protobuf.g.e(2, this.value_);
        L12:
            int r11 = this.unknownFields.size() + r10;
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r10 = 0;
            goto L10
        }

        public Value getValue() {
            return this.value_;
        }

        public boolean hasNameId() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasValue() {
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
            if (hasNameId() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasValue() == true) goto L17;
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (getValue().isInitialized() == true) goto L20;
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            this.memoizedIsInitialized = 1;
            return true;
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
            r5.n(1, this.nameId_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r5.p(2, this.value_);
        L8:
            r5.r(this.unknownFields);
        }

        public static b newBuilder() {
            b r5 = new b();
            r5.d = Value.getDefaultInstance();
            return r5;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Argument getDefaultInstanceForType() {
            return f19039a;
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
        public b toBuilder() {
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
            boolean r13 = false;
            this.nameId_ = 0;
            this.value_ = Value.getDefaultInstance();
            kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
            kotlinx.metadata.internal.protobuf.g r14 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
        L3:
            if (r13 == true) goto L51;
            int r15 = r10.n();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            if (r15 == 0) goto L12;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.nameId_ = r10.k();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L9:
            if (r15 != 18) goto L11;
            if ((this.bitField0_ & 2) != 2) goto L22;
            d r16 = this.value_.toBuilder();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        L23:
            Value r17 = (Value) r10.g(Value.PARSER, r11);     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.value_ = r17;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            if (r16 == null) goto L26;
            r16.g(r17);     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.value_ = r16.f();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
        L26:
            this.bitField0_ |= 2;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L22:
            r16 = null;
            goto L23
        L11:
            if (parseUnknownField(r10, r14, r11, r15) == true) goto L3;
        L12:
            r13 = true;
            goto L3
        L13:
            th = move-exception;
            r14.i();     // Catch: IOException -> L47 Throwable -> L35
        L35:
            th = move-exception;
            this.unknownFields = r5.e();
            throw th;
        L34:
            this.unknownFields = r5.e();
            makeExtensionsImmutable();
            throw th;
        L15:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L17:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L51:
            r14.i();     // Catch: IOException -> L48 Throwable -> L42
        L42:
            th = move-exception;
            this.unknownFields = r5.e();
            throw th;
        L41:
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
        PARSER = new au.b(0);
        ProtoBuf$Annotation r5 = new ProtoBuf$Annotation();
        f19038a = r5;
        r5.id_ = 0;
        r5.argument_ = Collections.emptyList();
    }

    public ProtoBuf$Annotation(kotlinx.metadata.internal.protobuf.m r5, au.a r10) {
        super(r5);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r5.f19190a;
    }

    public static /* synthetic */ int access$4402(ProtoBuf$Annotation r5, int r10) {
        r5.id_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$4500(ProtoBuf$Annotation r5) {
        return r5.argument_;
    }

    public static /* synthetic */ List access$4502(ProtoBuf$Annotation r5, List r10) {
        r5.argument_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$4602(ProtoBuf$Annotation r5, int r10) {
        r5.bitField0_ = r10;
        return r10;
    }

    public static /* synthetic */ kotlinx.metadata.internal.protobuf.e access$4700(ProtoBuf$Annotation r5) {
        return r5.unknownFields;
    }

    public static ProtoBuf$Annotation getDefaultInstance() {
        return f19038a;
    }

    public static h newBuilder(ProtoBuf$Annotation r5) {
        h r10 = newBuilder();
        r10.g(r5);
        return r10;
    }

    public static ProtoBuf$Annotation parseDelimitedFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Annotation parseFrom(kotlinx.metadata.internal.protobuf.e r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
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

    public g getArgumentOrBuilder(int r5) {
        return this.argument_.get(r5);
    }

    public List<? extends g> getArgumentOrBuilderList() {
        return this.argument_;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public /* bridge */ /* synthetic */ kotlinx.metadata.internal.protobuf.z getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getId() {
        return this.id_;
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
        int r11 = kotlinx.metadata.internal.protobuf.g.c(1, this.id_);
    L10:
        if (r10 >= this.argument_.size()) goto L12;
        r11 = r11 + kotlinx.metadata.internal.protobuf.g.e(2, this.argument_.get(r10));
        r10 = r10 + 1;
        goto L10
    L12:
        int r12 = this.unknownFields.size() + r11;
        this.memoizedSerializedSize = r12;
        return r12;
    L8:
        r11 = 0;
        goto L10
    }

    public boolean hasId() {
        if ((this.bitField0_ & 1) == 1) goto L7;
        return false;
    L7:
        return true;
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
        if (hasId() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        int r10 = 0;
    L14:
        if (r10 >= getArgumentCount()) goto L20;
        if (getArgument(r10).isInitialized() == false) goto L17;
        r10 = r10 + 1;
        goto L14
    L17:
        this.memoizedIsInitialized = 0;
        return false;
    L20:
        this.memoizedIsInitialized = 1;
        return true;
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
        r5.n(1, this.id_);
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.argument_.size()) goto L9;
        r5.p(2, this.argument_.get(r10));
        r10 = r10 + 1;
        goto L7
    L9:
        r5.r(this.unknownFields);
    }

    public static h newBuilder() {
        h r5 = new h();
        r5.d = Collections.emptyList();
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite
    public ProtoBuf$Annotation getDefaultInstanceForType() {
        return f19038a;
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public h newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlinx.metadata.internal.protobuf.GeneratedMessageLite, kotlinx.metadata.internal.protobuf.z
    public h toBuilder() {
        return newBuilder(this);
    }

    public static ProtoBuf$Annotation parseDelimitedFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).c(r5, r10);
    }

    public static ProtoBuf$Annotation parseFrom(kotlinx.metadata.internal.protobuf.e r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).e(r5, r10);
    }

    public ProtoBuf$Annotation() {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = kotlinx.metadata.internal.protobuf.e.f19154a;
    }

    public static ProtoBuf$Annotation parseFrom(byte[] r5) throws InvalidProtocolBufferException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public ProtoBuf$Annotation(kotlinx.metadata.internal.protobuf.f r10, kotlinx.metadata.internal.protobuf.i r11, au.a r12) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        boolean r13 = false;
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
        kotlinx.metadata.internal.protobuf.d r5 = new kotlinx.metadata.internal.protobuf.d();
        kotlinx.metadata.internal.protobuf.g r14 = kotlinx.metadata.internal.protobuf.g.j(r5, 1);
        char r15 = 0;
    L4:
        if (r13 == true) goto L41;
        int r16 = r10.n();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
        if (r16 == 0) goto L13;
        if (r16 != 8) goto L10;
        this.bitField0_ |= 1;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
        this.id_ = r10.k();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
        goto L4
    L10:
        if (r16 != 18) goto L12;
        if ((r15 & 2) == 2) goto L23;
        this.argument_ = new ArrayList();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
        r15 = 2;
    L23:
        this.argument_.add((Argument) r10.g(Argument.PARSER, r11));     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
        goto L4
    L12:
        if (parseUnknownField(r10, r14, r11, r16) == true) goto L4;
    L13:
        r13 = true;
        goto L4
    L14:
        th = move-exception;
        if ((r15 & 2) != 2) goto L56;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L56:
        r14.i();     // Catch: IOException -> L51 Throwable -> L35
    L35:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L34:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
        throw th;
    L18:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L14
    L41:
        if ((r15 & 2) != 2) goto L54;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L54:
        r14.i();     // Catch: IOException -> L50 Throwable -> L45
    L45:
        th = move-exception;
        this.unknownFields = r5.e();
        throw th;
    L44:
        this.unknownFields = r5.e();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$Annotation parseFrom(byte[] r5, kotlinx.metadata.internal.protobuf.i r10) throws InvalidProtocolBufferException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).g(r5, r10);
    }

    public static ProtoBuf$Annotation parseFrom(InputStream r5) throws IOException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Annotation parseFrom(InputStream r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).d(r5, r10);
    }

    public static ProtoBuf$Annotation parseFrom(kotlinx.metadata.internal.protobuf.f r5) throws IOException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, kotlinx.metadata.internal.protobuf.c.f19147a);
    }

    public static ProtoBuf$Annotation parseFrom(kotlinx.metadata.internal.protobuf.f r5, kotlinx.metadata.internal.protobuf.i r10) throws IOException {
        return (ProtoBuf$Annotation) ((kotlinx.metadata.internal.protobuf.c) PARSER).f(r5, r10);
    }
}
