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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLiteMap;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProtoBuf$Annotation extends GeneratedMessageLite implements ProtoBuf$AnnotationOrBuilder {
    public static Parser<ProtoBuf$Annotation> PARSER;
    private static final ProtoBuf$Annotation defaultInstance = null;
    private List<Argument> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
        public static Parser<Argument> PARSER;
        private static final Argument defaultInstance = null;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final ByteString unknownFields;
        private Value value_;

        public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
            public static Parser<Value> PARSER;
            private static final Value defaultInstance = null;
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
            private final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
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
                private int stringValue_;
                private Type type_;

                private void maybeForceBuilderInitialization() {
                }

                private static Builder create() {
                    return new Builder();
                }

                private void ensureArrayElementIsMutable() {
                    if ((this.bitField0_ & 256) == 256) goto L6;
                    this.arrayElement_ = new ArrayList(this.arrayElement_);
                    this.bitField0_ |= 256;
                    return;
                }

                public Value buildPartial() {
                    Value r0 = new Value(this, null);
                    int r1 = this.bitField0_;
                    int r3 = 1;
                    if ((r1 & 1) == 1) goto L6;
                    r3 = 0;
                L6:
                    Value.access$2302(r0, this.type_);
                    if ((r1 & 2) != 2) goto L9;
                    r3 = r3 | 2;
                L9:
                    Value.access$2402(r0, this.intValue_);
                    if ((r1 & 4) != 4) goto L12;
                    r3 = r3 | 4;
                L12:
                    Value.access$2502(r0, this.floatValue_);
                    if ((r1 & 8) != 8) goto L15;
                    r3 = r3 | 8;
                L15:
                    Value.access$2602(r0, this.doubleValue_);
                    if ((r1 & 16) != 16) goto L18;
                    r3 = r3 | 16;
                L18:
                    Value.access$2702(r0, this.stringValue_);
                    if ((r1 & 32) != 32) goto L21;
                    r3 = r3 | 32;
                L21:
                    Value.access$2802(r0, this.classId_);
                    if ((r1 & 64) != 64) goto L24;
                    r3 = r3 | 64;
                L24:
                    Value.access$2902(r0, this.enumValueId_);
                    if ((r1 & 128) != 128) goto L27;
                    r3 = r3 | 128;
                L27:
                    Value.access$3002(r0, this.annotation_);
                    if ((this.bitField0_ & 256) != 256) goto L30;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                    this.bitField0_ &= -257;
                L30:
                    Value.access$3102(r0, this.arrayElement_);
                    if ((r1 & 512) != 512) goto L33;
                    r3 = r3 | 256;
                L33:
                    Value.access$3202(r0, this.arrayDimensionCount_);
                    if ((r1 & 1024) != 1024) goto L36;
                    r3 = r3 | 512;
                L36:
                    Value.access$3302(r0, this.flags_);
                    Value.access$3402(r0, r3);
                    return r0;
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public boolean hasAnnotation() {
                    if ((this.bitField0_ & 128) != 128) goto L5;
                    return true;
                L5:
                    return false;
                }

                private Builder() {
                    this.type_ = Type.BYTE;
                    this.annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$2100() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Value build() {
                    Value r0 = buildPartial();
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
                public Value getDefaultInstanceForType() {
                    return Value.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasAnnotation() == true) goto L5;
                L7:
                    int r0 = 0;
                L9:
                    if (r0 >= getArrayElementCount()) goto L14;
                    if (getArrayElement(r0).isInitialized() == false) goto L12;
                    r0 = r0 + 1;
                    goto L9
                L12:
                    return false;
                L14:
                    return true;
                L5:
                    if (getAnnotation().isInitialized() == true) goto L7;
                    return false;
                }

                public ProtoBuf$Annotation getAnnotation() {
                    return this.annotation_;
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
                /* JADX INFO: renamed from: clone, reason: collision with other method in class */
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

                public Value getArrayElement(int r2) {
                    return (Value) ListProtector.get(this.arrayElement_, r2);
                }

                public Builder mergeAnnotation(ProtoBuf$Annotation r4) {
                    if ((this.bitField0_ & 128) == 128) goto L5;
                L7:
                    this.annotation_ = r4;
                L8:
                    this.bitField0_ |= 128;
                    return this;
                L5:
                    if (this.annotation_ == ProtoBuf$Annotation.getDefaultInstance()) goto L7;
                    this.annotation_ = ProtoBuf$Annotation.newBuilder(this.annotation_).mergeFrom(r4).buildPartial();
                    goto L8
                }

                public Builder mergeFrom(Value r3) {
                    if (r3 != Value.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r3.hasType() == false) goto L9;
                    setType(r3.getType());
                L9:
                    if (r3.hasIntValue() == false) goto L12;
                    setIntValue(r3.getIntValue());
                L12:
                    if (r3.hasFloatValue() == false) goto L15;
                    setFloatValue(r3.getFloatValue());
                L15:
                    if (r3.hasDoubleValue() == false) goto L18;
                    setDoubleValue(r3.getDoubleValue());
                L18:
                    if (r3.hasStringValue() == false) goto L21;
                    setStringValue(r3.getStringValue());
                L21:
                    if (r3.hasClassId() == false) goto L24;
                    setClassId(r3.getClassId());
                L24:
                    if (r3.hasEnumValueId() == false) goto L27;
                    setEnumValueId(r3.getEnumValueId());
                L27:
                    if (r3.hasAnnotation() == false) goto L30;
                    mergeAnnotation(r3.getAnnotation());
                L30:
                    if (Value.access$3100(r3).isEmpty() == true) goto L36;
                    if (this.arrayElement_.isEmpty() == false) goto L34;
                    this.arrayElement_ = Value.access$3100(r3);
                    this.bitField0_ &= -257;
                    goto L36
                L34:
                    ensureArrayElementIsMutable();
                    this.arrayElement_.addAll(Value.access$3100(r3));
                L36:
                    if (r3.hasArrayDimensionCount() == false) goto L39;
                    setArrayDimensionCount(r3.getArrayDimensionCount());
                L39:
                    if (r3.hasFlags() == false) goto L41;
                    setFlags(r3.getFlags());
                L41:
                    setUnknownFields(getUnknownFields().concat(Value.access$3500(r3)));
                    return this;
                }

                public Builder setArrayDimensionCount(int r2) {
                    this.bitField0_ |= 512;
                    this.arrayDimensionCount_ = r2;
                    return this;
                }

                public Builder setClassId(int r2) {
                    this.bitField0_ |= 32;
                    this.classId_ = r2;
                    return this;
                }

                public Builder setDoubleValue(double r2) {
                    this.bitField0_ |= 8;
                    this.doubleValue_ = r2;
                    return this;
                }

                public Builder setEnumValueId(int r2) {
                    this.bitField0_ |= 64;
                    this.enumValueId_ = r2;
                    return this;
                }

                public Builder setFlags(int r2) {
                    this.bitField0_ |= 1024;
                    this.flags_ = r2;
                    return this;
                }

                public Builder setFloatValue(float r2) {
                    this.bitField0_ |= 4;
                    this.floatValue_ = r2;
                    return this;
                }

                public Builder setIntValue(long r2) {
                    this.bitField0_ |= 2;
                    this.intValue_ = r2;
                    return this;
                }

                public Builder setStringValue(int r2) {
                    this.bitField0_ |= 16;
                    this.stringValue_ = r2;
                    return this;
                }

                public Builder setType(Type r2) {
                    if (r2 == null) goto L6;
                    this.bitField0_ |= 1;
                    this.type_ = r2;
                    return this;
                L6:
                    throw null;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
                    return mergeFrom((Value) r1);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                    Value r0 = null;
                    Value r5 = Value.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r5 == null) goto L6;
                    mergeFrom(r5);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Value r6 = (Value) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            public static final enum Type extends Enum<Type> implements Internal$EnumLite {
                private static final /* synthetic */ Type[] $VALUES = null;
                public static final Type ANNOTATION = null;
                public static final Type ARRAY = null;
                public static final Type BOOLEAN = null;
                public static final Type BYTE = null;
                public static final Type CHAR = null;
                public static final Type CLASS = null;
                public static final Type DOUBLE = null;
                public static final Type ENUM = null;
                public static final Type FLOAT = null;
                public static final Type INT = null;
                public static final Type LONG = null;
                public static final Type SHORT = null;
                public static final Type STRING = null;
                private static Internal$EnumLiteMap<Type> internalValueMap;
                private final int value;

                static {
                    Type r0 = new Type("BYTE", 0, 0, 0);
                    BYTE = r0;
                    Type r1 = new Type("CHAR", 1, 1, 1);
                    CHAR = r1;
                    Type r3 = new Type("SHORT", 2, 2, 2);
                    SHORT = r3;
                    Type r5 = new Type("INT", 3, 3, 3);
                    INT = r5;
                    Type r7 = new Type("LONG", 4, 4, 4);
                    LONG = r7;
                    Type r9 = new Type("FLOAT", 5, 5, 5);
                    FLOAT = r9;
                    Type r11 = new Type("DOUBLE", 6, 6, 6);
                    DOUBLE = r11;
                    Type r13 = new Type("BOOLEAN", 7, 7, 7);
                    BOOLEAN = r13;
                    Type r15 = new Type("STRING", 8, 8, 8);
                    STRING = r15;
                    Type r14 = new Type("CLASS", 9, 9, 9);
                    CLASS = r14;
                    Type r12 = new Type("ENUM", 10, 10, 10);
                    ENUM = r12;
                    Type r10 = new Type("ANNOTATION", 11, 11, 11);
                    ANNOTATION = r10;
                    Type r8 = new Type("ARRAY", 12, 12, 12);
                    ARRAY = r8;
                    $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
                    internalValueMap = new AnonymousClass1();
                }

                public static Type[] values() {
                    return (Type[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal$EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Type valueOf(int r0) {
                    switch(r0) {
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

                public static Type valueOf(String r1) {
                    return (Type) a.a(Type.class, r1);
                }

                private Type(String r1, int r2, int r3, int r4) {
                    super(r1, r2);
                    this.value = r4;
                }
            }

            static {
                PARSER = new AnonymousClass1();
                Value r0 = new Value(true);
                defaultInstance = r0;
                r0.initFields();
            }

            private void initFields() {
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

            public int getArrayElementCount() {
                return this.arrayElement_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r0 = this.memoizedSerializedSize;
                if (r0 == (-1)) goto L5;
                return r0;
            L5:
                int r2 = 0;
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r1 = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r1 = r1 + CodedOutputStream.computeSInt64Size(2, this.intValue_);
            L13:
                if ((this.bitField0_ & 4) != 4) goto L16;
                r1 = r1 + CodedOutputStream.computeFloatSize(3, this.floatValue_);
            L16:
                if ((this.bitField0_ & 8) != 8) goto L19;
                r1 = r1 + CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
            L19:
                if ((this.bitField0_ & 16) != 16) goto L22;
                r1 = r1 + CodedOutputStream.computeInt32Size(5, this.stringValue_);
            L22:
                if ((this.bitField0_ & 32) != 32) goto L25;
                r1 = r1 + CodedOutputStream.computeInt32Size(6, this.classId_);
            L25:
                if ((this.bitField0_ & 64) != 64) goto L28;
                r1 = r1 + CodedOutputStream.computeInt32Size(7, this.enumValueId_);
            L28:
                if ((this.bitField0_ & 128) != 128) goto L31;
                r1 = r1 + CodedOutputStream.computeMessageSize(8, this.annotation_);
            L31:
                if (r2 >= this.arrayElement_.size()) goto L34;
                r1 = r1 + CodedOutputStream.computeMessageSize(9, (MessageLite) ListProtector.get(this.arrayElement_, r2));
                r2 = r2 + 1;
                goto L31
            L34:
                if ((this.bitField0_ & 512) != 512) goto L37;
                r1 = r1 + CodedOutputStream.computeInt32Size(10, this.flags_);
            L37:
                if ((this.bitField0_ & 256) != 256) goto L39;
                r1 = r1 + CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
            L39:
                int r3 = r1 + this.unknownFields.size();
                this.memoizedSerializedSize = r3;
                return r3;
            L8:
                r1 = 0;
                goto L10
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r0 = this.memoizedIsInitialized;
                if (r0 != 1) goto L6;
                return true;
            L6:
                if (r0 != 0) goto L9;
                return false;
            L9:
                if (hasAnnotation() == true) goto L11;
            L14:
                int r1 = 0;
            L16:
                if (r1 >= getArrayElementCount()) goto L22;
                if (getArrayElement(r1).isInitialized() == false) goto L19;
                r1 = r1 + 1;
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

            public static Builder newBuilder() {
                return Builder.access$2100();
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

            public static Value getDefaultInstance() {
                return defaultInstance;
            }

            public ProtoBuf$Annotation getAnnotation() {
                return this.annotation_;
            }

            public int getArrayDimensionCount() {
                return this.arrayDimensionCount_;
            }

            public List<Value> getArrayElementList() {
                return this.arrayElement_;
            }

            public int getClassId() {
                return this.classId_;
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Value> getParserForType() {
                return PARSER;
            }

            public int getStringValue() {
                return this.stringValue_;
            }

            public Type getType() {
                return this.type_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Value getDefaultInstanceForType() {
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

            private Value(GeneratedMessageLite.Builder r2) {
                super(r2);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r2.getUnknownFields();
            }

            public static /* synthetic */ List access$3100(Value r0) {
                return r0.arrayElement_;
            }

            public static /* synthetic */ ByteString access$3500(Value r0) {
                return r0.unknownFields;
            }

            public static Builder newBuilder(Value r1) {
                return newBuilder().mergeFrom(r1);
            }

            public Value getArrayElement(int r2) {
                return (Value) ListProtector.get(this.arrayElement_, r2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r6) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r6.writeEnum(1, this.type_.getNumber());
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r6.writeSInt64(2, this.intValue_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L12;
                r6.writeFloat(3, this.floatValue_);
            L12:
                if ((this.bitField0_ & 8) != 8) goto L15;
                r6.writeDouble(4, this.doubleValue_);
            L15:
                if ((this.bitField0_ & 16) != 16) goto L18;
                r6.writeInt32(5, this.stringValue_);
            L18:
                if ((this.bitField0_ & 32) != 32) goto L21;
                r6.writeInt32(6, this.classId_);
            L21:
                if ((this.bitField0_ & 64) != 64) goto L24;
                r6.writeInt32(7, this.enumValueId_);
            L24:
                if ((this.bitField0_ & 128) != 128) goto L26;
                r6.writeMessage(8, this.annotation_);
            L26:
                int r0 = 0;
            L28:
                if (r0 >= this.arrayElement_.size()) goto L31;
                r6.writeMessage(9, (MessageLite) ListProtector.get(this.arrayElement_, r0));
                r0 = r0 + 1;
                goto L28
            L31:
                if ((this.bitField0_ & 512) != 512) goto L34;
                r6.writeInt32(10, this.flags_);
            L34:
                if ((this.bitField0_ & 256) != 256) goto L36;
                r6.writeInt32(11, this.arrayDimensionCount_);
            L36:
                r6.writeRawBytes(this.unknownFields);
            }

            private Value(boolean r1) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Value(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r0 = ByteString.newOutput();
                CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
                boolean r3 = false;
                int r4 = 0;
            L4:
                if (r3 == true) goto L55;
                int r6 = r10.readTag();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                switch(r6) {
                    case 0: goto L33;
                    case 8: goto L28;
                    case 16: goto L27;
                    case 29: goto L26;
                    case 33: goto L25;
                    case 40: goto L24;
                    case 48: goto L23;
                    case 56: goto L22;
                    case 66: goto L15;
                    case 74: goto L11;
                    case 80: goto L9;
                    case 88: goto L8;
                    default: goto L34;
                };     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            L8:
                this.bitField0_ |= 256;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.arrayDimensionCount_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L9:
                this.bitField0_ |= 512;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.flags_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L11:
                if ((r4 & 256) == 256) goto L13;
                this.arrayElement_ = new ArrayList();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                r4 = r4 | 256;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            L13:
                this.arrayElement_.add((Value) r10.readMessage(PARSER, r11));     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L15:
                if ((this.bitField0_ & 128) != 128) goto L17;
                Builder r7 = this.annotation_.mo380toBuilder();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            L18:
                ProtoBuf$Annotation r8 = (ProtoBuf$Annotation) r10.readMessage(ProtoBuf$Annotation.PARSER, r11);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.annotation_ = r8;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                if (r7 == null) goto L21;
                r7.mergeFrom(r8);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.annotation_ = r7.buildPartial();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            L21:
                this.bitField0_ |= 128;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L17:
                r7 = null;
                goto L18
            L22:
                this.bitField0_ |= 64;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.enumValueId_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L23:
                this.bitField0_ |= 32;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.classId_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L24:
                this.bitField0_ |= 16;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.stringValue_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L25:
                this.bitField0_ |= 8;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.doubleValue_ = r10.readDouble();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L26:
                this.bitField0_ |= 4;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.floatValue_ = r10.readFloat();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L27:
                this.bitField0_ |= 2;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.intValue_ = r10.readSInt64();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L28:
                int r9 = r10.readEnum();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                Type r12 = Type.valueOf(r9);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                if (r12 == null) goto L30;
                this.bitField0_ |= 1;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                this.type_ = r12;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                goto L4
            L30:
                r2.writeRawVarint32(r6);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                r2.writeRawVarint32(r9);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            L33:
                r3 = true;
                goto L4
            L34:
                if (parseUnknownField(r10, r2, r11, r6) == true) goto L4;
            L36:
                th = move-exception;
                if ((r4 & 256) != 256) goto L68;
                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
            L68:
                r2.flush();     // Catch: IOException -> L65 Throwable -> L49
            L49:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L48:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
                throw th;
            L41:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L36
            L38:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L36
            L55:
                if ((r4 & 256) != 256) goto L70;
                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
            L70:
                r2.flush();     // Catch: IOException -> L64 Throwable -> L59
            L59:
                th = move-exception;
                this.unknownFields = r0.toByteString();
                throw th;
            L58:
                this.unknownFields = r0.toByteString();
                makeExtensionsImmutable();
            }

            public static /* synthetic */ Type access$2302(Value r0, Type r1) {
                r0.type_ = r1;
                return r1;
            }

            public static /* synthetic */ long access$2402(Value r0, long r1) {
                r0.intValue_ = r1;
                return r1;
            }

            public static /* synthetic */ float access$2502(Value r0, float r1) {
                r0.floatValue_ = r1;
                return r1;
            }

            public static /* synthetic */ double access$2602(Value r0, double r1) {
                r0.doubleValue_ = r1;
                return r1;
            }

            public static /* synthetic */ int access$2702(Value r0, int r1) {
                r0.stringValue_ = r1;
                return r1;
            }

            public static /* synthetic */ int access$2802(Value r0, int r1) {
                r0.classId_ = r1;
                return r1;
            }

            public static /* synthetic */ int access$2902(Value r0, int r1) {
                r0.enumValueId_ = r1;
                return r1;
            }

            public static /* synthetic */ ProtoBuf$Annotation access$3002(Value r0, ProtoBuf$Annotation r1) {
                r0.annotation_ = r1;
                return r1;
            }

            public static /* synthetic */ List access$3102(Value r0, List r1) {
                r0.arrayElement_ = r1;
                return r1;
            }

            public static /* synthetic */ int access$3202(Value r0, int r1) {
                r0.arrayDimensionCount_ = r1;
                return r1;
            }

            public static /* synthetic */ int access$3302(Value r0, int r1) {
                r0.flags_ = r1;
                return r1;
            }

            public static /* synthetic */ int access$3402(Value r0, int r1) {
                r0.bitField0_ = r1;
                return r1;
            }

            public /* synthetic */ Value(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
                this(r1);
            }

            public /* synthetic */ Value(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
                this(r1, r2);
            }
        }

        public interface ValueOrBuilder extends MessageLiteOrBuilder {
        }

        private void initFields() {
            this.nameId_ = 0;
            this.value_ = Value.getDefaultInstance();
        }

        static {
            PARSER = new AnonymousClass1();
            Argument r0 = new Argument(true);
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
            r2 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L11;
            r2 = r2 + CodedOutputStream.computeMessageSize(2, this.value_);
        L11:
            int r3 = r2 + this.unknownFields.size();
            this.memoizedSerializedSize = r3;
            return r3;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L6;
            return true;
        L6:
            if (r0 != 0) goto L9;
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

        public static Builder newBuilder() {
            return Builder.access$3600();
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

        public static Argument getDefaultInstance() {
            return defaultInstance;
        }

        public int getNameId() {
            return this.nameId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Argument> getParserForType() {
            return PARSER;
        }

        public Value getValue() {
            return this.value_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Argument getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo379newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo380toBuilder() {
            return toBuilder();
        }

        private Argument(GeneratedMessageLite.Builder r2) {
            super(r2);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r2.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$4100(Argument r0) {
            return r0.unknownFields;
        }

        public static Builder newBuilder(Argument r1) {
            return newBuilder().mergeFrom(r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r3) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r3.writeInt32(1, this.nameId_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r3.writeMessage(2, this.value_);
        L8:
            r3.writeRawBytes(this.unknownFields);
        }

        private Argument(boolean r1) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Argument(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r0 = ByteString.newOutput();
            CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
            boolean r3 = false;
        L3:
            if (r3 == true) goto L52;
            int r4 = r8.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            if (r4 == 0) goto L23;
            if (r4 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            this.nameId_ = r8.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            goto L3
        L9:
            if (r4 != 18) goto L11;
            if ((this.bitField0_ & 2) != 2) goto L16;
            Value.Builder r5 = this.value_.mo380toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
        L17:
            Value r6 = (Value) r8.readMessage(Value.PARSER, r9);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            this.value_ = r6;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            if (r5 == null) goto L20;
            r5.mergeFrom(r6);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            this.value_ = r5.buildPartial();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
        L20:
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            goto L3
        L16:
            r5 = null;
            goto L17
        L11:
            if (parseUnknownField(r8, r2, r9, r4) == true) goto L3;
        L23:
            r3 = true;
            goto L3
        L24:
            th = move-exception;
            r2.flush();     // Catch: IOException -> L46 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L33:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
            throw th;
        L26:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L29:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L52:
            r2.flush();     // Catch: IOException -> L47 Throwable -> L41
        L41:
            th = move-exception;
            this.unknownFields = r0.toByteString();
            throw th;
        L40:
            this.unknownFields = r0.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$3802(Argument r0, int r1) {
            r0.nameId_ = r1;
            return r1;
        }

        public static /* synthetic */ Value access$3902(Argument r0, Value r1) {
            r0.value_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$4002(Argument r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public /* synthetic */ Argument(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
            this(r1);
        }

        public /* synthetic */ Argument(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Annotation, Builder> implements ProtoBuf$AnnotationOrBuilder {
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;

        private void maybeForceBuilderInitialization() {
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureArgumentIsMutable() {
            if ((this.bitField0_ & 2) == 2) goto L6;
            this.argument_ = new ArrayList(this.argument_);
            this.bitField0_ |= 2;
            return;
        }

        public ProtoBuf$Annotation buildPartial() {
            ProtoBuf$Annotation r0 = new ProtoBuf$Annotation(this, null);
            int r2 = 1;
            if ((this.bitField0_ & 1) == 1) goto L6;
            r2 = 0;
        L6:
            ProtoBuf$Annotation.access$4402(r0, this.id_);
            if ((this.bitField0_ & 2) != 2) goto L9;
            this.argument_ = Collections.unmodifiableList(this.argument_);
            this.bitField0_ &= -3;
        L9:
            ProtoBuf$Annotation.access$4502(r0, this.argument_);
            ProtoBuf$Annotation.access$4602(r0, r2);
            return r0;
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private Builder() {
            this.argument_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public static /* synthetic */ Builder access$4200() {
            return create();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Annotation build() {
            ProtoBuf$Annotation r0 = buildPartial();
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
        public ProtoBuf$Annotation getDefaultInstanceForType() {
            return ProtoBuf$Annotation.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            if (hasId() == true) goto L5;
            return false;
        L5:
            int r0 = 0;
        L7:
            if (r0 >= getArgumentCount()) goto L12;
            if (getArgument(r0).isInitialized() == false) goto L10;
            r0 = r0 + 1;
            goto L7
        L10:
            return false;
        L12:
            return true;
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

        public Argument getArgument(int r2) {
            return (Argument) ListProtector.get(this.argument_, r2);
        }

        public Builder mergeFrom(ProtoBuf$Annotation r3) {
            if (r3 != ProtoBuf$Annotation.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r3.hasId() == false) goto L9;
            setId(r3.getId());
        L9:
            if (ProtoBuf$Annotation.access$4500(r3).isEmpty() == false) goto L11;
        L14:
            setUnknownFields(getUnknownFields().concat(ProtoBuf$Annotation.access$4700(r3)));
            return this;
        L11:
            if (this.argument_.isEmpty() == false) goto L13;
            this.argument_ = ProtoBuf$Annotation.access$4500(r3);
            this.bitField0_ &= -3;
            goto L14
        L13:
            ensureArgumentIsMutable();
            this.argument_.addAll(ProtoBuf$Annotation.access$4500(r3));
            goto L14
        }

        public Builder setId(int r2) {
            this.bitField0_ |= 1;
            this.id_ = r2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r1) {
            return mergeFrom((ProtoBuf$Annotation) r1);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public Builder mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
            ProtoBuf$Annotation r0 = null;
            ProtoBuf$Annotation r5 = ProtoBuf$Annotation.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
            if (r5 == null) goto L6;
            mergeFrom(r5);
        L6:
            return this;
        L9:
            e = move-exception;
            ProtoBuf$Annotation r6 = (ProtoBuf$Annotation) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

    private void initFields() {
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
    }

    static {
        PARSER = new AnonymousClass1();
        ProtoBuf$Annotation r0 = new ProtoBuf$Annotation(true);
        defaultInstance = r0;
        r0.initFields();
    }

    public int getArgumentCount() {
        return this.argument_.size();
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
        if (r2 >= this.argument_.size()) goto L12;
        r1 = r1 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.argument_, r2));
        r2 = r2 + 1;
        goto L10
    L12:
        int r3 = r1 + this.unknownFields.size();
        this.memoizedSerializedSize = r3;
        return r3;
    L8:
        r1 = 0;
        goto L10
    }

    public boolean hasId() {
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
        if (r0 != 0) goto L9;
        return false;
    L9:
        if (hasId() == true) goto L12;
        this.memoizedIsInitialized = 0;
        return false;
    L12:
        int r1 = 0;
    L14:
        if (r1 >= getArgumentCount()) goto L20;
        if (getArgument(r1).isInitialized() == false) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        this.memoizedIsInitialized = 0;
        return false;
    L20:
        this.memoizedIsInitialized = 1;
        return true;
    }

    public static Builder newBuilder() {
        return Builder.access$4200();
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

    public static ProtoBuf$Annotation getDefaultInstance() {
        return defaultInstance;
    }

    public List<Argument> getArgumentList() {
        return this.argument_;
    }

    public int getId() {
        return this.id_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Annotation> getParserForType() {
        return PARSER;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Annotation getDefaultInstanceForType() {
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

    private ProtoBuf$Annotation(GeneratedMessageLite.Builder r2) {
        super(r2);
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = r2.getUnknownFields();
    }

    public static /* synthetic */ List access$4500(ProtoBuf$Annotation r0) {
        return r0.argument_;
    }

    public static /* synthetic */ ByteString access$4700(ProtoBuf$Annotation r0) {
        return r0.unknownFields;
    }

    public static Builder newBuilder(ProtoBuf$Annotation r1) {
        return newBuilder().mergeFrom(r1);
    }

    public Argument getArgument(int r2) {
        return (Argument) ListProtector.get(this.argument_, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream r4) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) != 1) goto L5;
        r4.writeInt32(1, this.id_);
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.argument_.size()) goto L9;
        r4.writeMessage(2, (MessageLite) ListProtector.get(this.argument_, r0));
        r0 = r0 + 1;
        goto L7
    L9:
        r4.writeRawBytes(this.unknownFields);
    }

    private ProtoBuf$Annotation(boolean r1) {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$Annotation(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output r0 = ByteString.newOutput();
        CodedOutputStream r2 = CodedOutputStream.newInstance(r0, 1);
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r3 == true) goto L40;
        int r6 = r9.readTag();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        if (r6 == 0) goto L20;
        if (r6 != 8) goto L10;
        this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        this.id_ = r9.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        goto L4
    L10:
        if (r6 != 18) goto L12;
        if ((r4 & 2) == 2) goto L17;
        this.argument_ = new ArrayList();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        r4 = r4 | 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
    L17:
        this.argument_.add((Argument) r9.readMessage(Argument.PARSER, r10));     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        goto L4
    L12:
        if (parseUnknownField(r9, r2, r10, r6) == true) goto L4;
    L20:
        r3 = true;
        goto L4
    L21:
        th = move-exception;
        if ((r4 & 2) != 2) goto L52;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L52:
        r2.flush();     // Catch: IOException -> L50 Throwable -> L34
    L34:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L33:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
        throw th;
    L26:
        e = move-exception;
        throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L23:
        e = move-exception;
        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
    L40:
        if ((r4 & 2) != 2) goto L55;
        this.argument_ = Collections.unmodifiableList(this.argument_);
    L55:
        r2.flush();     // Catch: IOException -> L49 Throwable -> L44
    L44:
        th = move-exception;
        this.unknownFields = r0.toByteString();
        throw th;
    L43:
        this.unknownFields = r0.toByteString();
        makeExtensionsImmutable();
    }

    public static /* synthetic */ int access$4402(ProtoBuf$Annotation r0, int r1) {
        r0.id_ = r1;
        return r1;
    }

    public static /* synthetic */ List access$4502(ProtoBuf$Annotation r0, List r1) {
        r0.argument_ = r1;
        return r1;
    }

    public static /* synthetic */ int access$4602(ProtoBuf$Annotation r0, int r1) {
        r0.bitField0_ = r1;
        return r1;
    }

    public /* synthetic */ ProtoBuf$Annotation(GeneratedMessageLite.Builder r1, ProtoBuf.1 r2) {
        this(r1);
    }

    public /* synthetic */ ProtoBuf$Annotation(CodedInputStream r1, ExtensionRegistryLite r2, ProtoBuf.1 r3) throws InvalidProtocolBufferException {
        this(r1, r2);
    }
}
