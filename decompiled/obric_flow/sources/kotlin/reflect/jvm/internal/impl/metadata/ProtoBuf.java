package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoBuf {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> PARSER;
        private static final Annotation defaultInstance = null;
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

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_;

                private Builder() {
                    this.value_ = Value.getDefaultInstance();
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$3600() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public Argument buildPartial() {
                    Argument r5 = new Argument(this, null);
                    int r10 = this.bitField0_;
                    int r11 = 1;
                    if ((r10 & 1) == 1) goto L6;
                    r11 = 0;
                L6:
                    Argument.access$3802(r5, this.nameId_);
                    if ((r10 & 2) != 2) goto L9;
                    r11 = r11 | 2;
                L9:
                    Argument.access$3902(r5, this.value_);
                    Argument.access$4002(r5, r11);
                    return r5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
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

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasNameId() == true) goto L6;
                    return false;
                L6:
                    if (hasValue() == true) goto L9;
                    return false;
                L9:
                    if (getValue().isInitialized() == true) goto L11;
                    return false;
                L11:
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                public Builder mergeValue(Value r5) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.value_ = r5;
                L8:
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.value_ == Value.getDefaultInstance()) goto L7;
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(r5).buildPartial();
                    goto L8
                }

                public Builder setNameId(int r5) {
                    this.bitField0_ |= 1;
                    this.nameId_ = r5;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r5 = buildPartial();
                    if (r5.isInitialized() == false) goto L6;
                    return r5;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                    return mergeFrom((Argument) r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Argument r5) {
                    if (r5 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r5.hasNameId() == false) goto L9;
                    setNameId(r5.getNameId());
                L9:
                    if (r5.hasValue() == false) goto L11;
                    mergeValue(r5.getValue());
                L11:
                    setUnknownFields(getUnknownFields().concat(Argument.access$4100(r5)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    Argument r11 = null;
                    Argument r12 = Argument.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r12 == null) goto L6;
                    mergeFrom(r12);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r13 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r11 = r13;
                L14:
                    if (r11 == null) goto L16;
                    mergeFrom(r11);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }
            }

            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> PARSER;
                private static final Value defaultInstance = null;
                private Annotation annotation_;
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
                    private Annotation annotation_;
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

                    private Builder() {
                        this.type_ = Type.BYTE;
                        this.annotation_ = Annotation.getDefaultInstance();
                        this.arrayElement_ = Collections.emptyList();
                        maybeForceBuilderInitialization();
                    }

                    public static /* synthetic */ Builder access$2100() {
                        return create();
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

                    private void maybeForceBuilderInitialization() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ MessageLite build() {
                        return build();
                    }

                    public Value buildPartial() {
                        Value r5 = new Value(this, null);
                        int r10 = this.bitField0_;
                        int r11 = 1;
                        if ((r10 & 1) == 1) goto L6;
                        r11 = 0;
                    L6:
                        Value.access$2302(r5, this.type_);
                        if ((r10 & 2) != 2) goto L9;
                        r11 = r11 | 2;
                    L9:
                        Value.access$2402(r5, this.intValue_);
                        if ((r10 & 4) != 4) goto L12;
                        r11 = r11 | 4;
                    L12:
                        Value.access$2502(r5, this.floatValue_);
                        if ((r10 & 8) != 8) goto L15;
                        r11 = r11 | 8;
                    L15:
                        Value.access$2602(r5, this.doubleValue_);
                        if ((r10 & 16) != 16) goto L18;
                        r11 = r11 | 16;
                    L18:
                        Value.access$2702(r5, this.stringValue_);
                        if ((r10 & 32) != 32) goto L21;
                        r11 = r11 | 32;
                    L21:
                        Value.access$2802(r5, this.classId_);
                        if ((r10 & 64) != 64) goto L24;
                        r11 = r11 | 64;
                    L24:
                        Value.access$2902(r5, this.enumValueId_);
                        if ((r10 & 128) != 128) goto L27;
                        r11 = r11 | 128;
                    L27:
                        Value.access$3002(r5, this.annotation_);
                        if ((this.bitField0_ & 256) != 256) goto L30;
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    L30:
                        Value.access$3102(r5, this.arrayElement_);
                        if ((r10 & 512) != 512) goto L33;
                        r11 = r11 | 256;
                    L33:
                        Value.access$3202(r5, this.arrayDimensionCount_);
                        if ((r10 & 1024) != 1024) goto L36;
                        r11 = r11 | 512;
                    L36:
                        Value.access$3302(r5, this.flags_);
                        Value.access$3402(r5, r11);
                        return r5;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                        return clone();
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Value getArrayElement(int r5) {
                        return this.arrayElement_.get(r5);
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                        return getDefaultInstanceForType();
                    }

                    public boolean hasAnnotation() {
                        if ((this.bitField0_ & 128) != 128) goto L5;
                        return true;
                    L5:
                        return false;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        if (hasAnnotation() == true) goto L5;
                    L7:
                        int r5 = 0;
                    L9:
                        if (r5 >= getArrayElementCount()) goto L14;
                        if (getArrayElement(r5).isInitialized() == false) goto L12;
                        r5 = r5 + 1;
                        goto L9
                    L12:
                        return false;
                    L14:
                        return true;
                    L5:
                        if (getAnnotation().isInitialized() == true) goto L7;
                        return false;
                    }

                    public Builder mergeAnnotation(Annotation r5) {
                        if ((this.bitField0_ & 128) == 128) goto L5;
                    L7:
                        this.annotation_ = r5;
                    L8:
                        this.bitField0_ |= 128;
                        return this;
                    L5:
                        if (this.annotation_ == Annotation.getDefaultInstance()) goto L7;
                        this.annotation_ = Annotation.newBuilder(this.annotation_).mergeFrom(r5).buildPartial();
                        goto L8
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                        return mergeFrom(r5, r10);
                    }

                    public Builder setArrayDimensionCount(int r5) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = r5;
                        return this;
                    }

                    public Builder setClassId(int r5) {
                        this.bitField0_ |= 32;
                        this.classId_ = r5;
                        return this;
                    }

                    public Builder setDoubleValue(double r5) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = r5;
                        return this;
                    }

                    public Builder setEnumValueId(int r5) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = r5;
                        return this;
                    }

                    public Builder setFlags(int r5) {
                        this.bitField0_ |= 1024;
                        this.flags_ = r5;
                        return this;
                    }

                    public Builder setFloatValue(float r5) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = r5;
                        return this;
                    }

                    public Builder setIntValue(long r5) {
                        this.bitField0_ |= 2;
                        this.intValue_ = r5;
                        return this;
                    }

                    public Builder setStringValue(int r5) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = r5;
                        return this;
                    }

                    public Builder setType(Type r5) {
                        r5.getClass();
                        this.bitField0_ |= 1;
                        this.type_ = r5;
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Value build() {
                        Value r5 = buildPartial();
                        if (r5.isInitialized() == false) goto L6;
                        return r5;
                    L6:
                        throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    /* JADX INFO: renamed from: clone */
                    public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                        return clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                        return getDefaultInstanceForType();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                        return mergeFrom((Value) r5);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                        return clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                        return mergeFrom(r5, r10);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public Builder clone() {
                        return create().mergeFrom(buildPartial());
                    }

                    public Builder mergeFrom(Value r5) {
                        if (r5 != Value.getDefaultInstance()) goto L6;
                        return this;
                    L6:
                        if (r5.hasType() == false) goto L9;
                        setType(r5.getType());
                    L9:
                        if (r5.hasIntValue() == false) goto L12;
                        setIntValue(r5.getIntValue());
                    L12:
                        if (r5.hasFloatValue() == false) goto L15;
                        setFloatValue(r5.getFloatValue());
                    L15:
                        if (r5.hasDoubleValue() == false) goto L18;
                        setDoubleValue(r5.getDoubleValue());
                    L18:
                        if (r5.hasStringValue() == false) goto L21;
                        setStringValue(r5.getStringValue());
                    L21:
                        if (r5.hasClassId() == false) goto L24;
                        setClassId(r5.getClassId());
                    L24:
                        if (r5.hasEnumValueId() == false) goto L27;
                        setEnumValueId(r5.getEnumValueId());
                    L27:
                        if (r5.hasAnnotation() == false) goto L30;
                        mergeAnnotation(r5.getAnnotation());
                    L30:
                        if (Value.access$3100(r5).isEmpty() == true) goto L36;
                        if (this.arrayElement_.isEmpty() == false) goto L34;
                        this.arrayElement_ = Value.access$3100(r5);
                        this.bitField0_ &= -257;
                        goto L36
                    L34:
                        ensureArrayElementIsMutable();
                        this.arrayElement_.addAll(Value.access$3100(r5));
                    L36:
                        if (r5.hasArrayDimensionCount() == false) goto L39;
                        setArrayDimensionCount(r5.getArrayDimensionCount());
                    L39:
                        if (r5.hasFlags() == false) goto L41;
                        setFlags(r5.getFlags());
                    L41:
                        setUnknownFields(getUnknownFields().concat(Value.access$3500(r5)));
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                        Value r11 = null;
                        Value r12 = Value.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                        if (r12 == null) goto L6;
                        mergeFrom(r12);
                    L6:
                        return this;
                    L9:
                        e = move-exception;
                        Value r13 = (Value) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                        throw e;     // Catch: Throwable -> L12
                    L12:
                        th = th;
                        r11 = r13;
                    L14:
                        if (r11 == null) goto L16;
                        mergeFrom(r11);
                    L16:
                        throw th;
                    L7:
                        th = th;
                        goto L14
                    }
                }

                public static final enum Type extends Enum<Type> implements Internal.EnumLite {
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
                    private static Internal.EnumLiteMap<Type> internalValueMap;
                    private final int value;

                    static {
                        Type r5 = new Type("BYTE", 0, 0, 0);
                        BYTE = r5;
                        Type r10 = new Type("CHAR", 1, 1, 1);
                        CHAR = r10;
                        Type r11 = new Type("SHORT", 2, 2, 2);
                        SHORT = r11;
                        Type r12 = new Type("INT", 3, 3, 3);
                        INT = r12;
                        Type r13 = new Type("LONG", 4, 4, 4);
                        LONG = r13;
                        Type r14 = new Type("FLOAT", 5, 5, 5);
                        FLOAT = r14;
                        Type r15 = new Type("DOUBLE", 6, 6, 6);
                        DOUBLE = r15;
                        Type r16 = new Type("BOOLEAN", 7, 7, 7);
                        BOOLEAN = r16;
                        Type r17 = new Type("STRING", 8, 8, 8);
                        STRING = r17;
                        Type r18 = new Type("CLASS", 9, 9, 9);
                        CLASS = r18;
                        Type r19 = new Type("ENUM", 10, 10, 10);
                        ENUM = r19;
                        Type r110 = new Type("ANNOTATION", 11, 11, 11);
                        ANNOTATION = r110;
                        Type r111 = new Type("ARRAY", 12, 12, 12);
                        ARRAY = r111;
                        $VALUES = new Type[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
                        internalValueMap = new AnonymousClass1();
                    }

                    private Type(String r5, int r10, int r11, int r12) {
                        super(r5, r10);
                        this.value = r12;
                    }

                    public static Type valueOf(String r5) {
                        return (Type) Enum.valueOf(Type.class, r5);
                    }

                    public static Type[] values() {
                        return (Type[]) $VALUES.clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
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
                    PARSER = new AnonymousClass1();
                    Value r5 = new Value(true);
                    defaultInstance = r5;
                    r5.initFields();
                }

                public /* synthetic */ Value(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
                    this(r5, r10);
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

                public static /* synthetic */ Annotation access$3002(Value r5, Annotation r10) {
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

                public static /* synthetic */ ByteString access$3500(Value r5) {
                    return r5.unknownFields;
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public static Builder newBuilder() {
                    return Builder.access$2100();
                }

                public Annotation getAnnotation() {
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

                public int getClassId() {
                    return this.classId_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public int getSerializedSize() {
                    int r5 = this.memoizedSerializedSize;
                    if (r5 == (-1)) goto L5;
                    return r5;
                L5:
                    int r10 = 0;
                    if ((this.bitField0_ & 1) != 1) goto L8;
                    int r11 = CodedOutputStream.computeEnumSize(1, this.type_.getNumber());
                L10:
                    if ((this.bitField0_ & 2) != 2) goto L13;
                    r11 = r11 + CodedOutputStream.computeSInt64Size(2, this.intValue_);
                L13:
                    if ((this.bitField0_ & 4) != 4) goto L16;
                    r11 = r11 + CodedOutputStream.computeFloatSize(3, this.floatValue_);
                L16:
                    if ((this.bitField0_ & 8) != 8) goto L19;
                    r11 = r11 + CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                L19:
                    if ((this.bitField0_ & 16) != 16) goto L22;
                    r11 = r11 + CodedOutputStream.computeInt32Size(5, this.stringValue_);
                L22:
                    if ((this.bitField0_ & 32) != 32) goto L25;
                    r11 = r11 + CodedOutputStream.computeInt32Size(6, this.classId_);
                L25:
                    if ((this.bitField0_ & 64) != 64) goto L28;
                    r11 = r11 + CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                L28:
                    if ((this.bitField0_ & 128) != 128) goto L31;
                    r11 = r11 + CodedOutputStream.computeMessageSize(8, this.annotation_);
                L31:
                    if (r10 >= this.arrayElement_.size()) goto L34;
                    r11 = r11 + CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(r10));
                    r10 = r10 + 1;
                    goto L31
                L34:
                    if ((this.bitField0_ & 512) != 512) goto L37;
                    r11 = r11 + CodedOutputStream.computeInt32Size(10, this.flags_);
                L37:
                    if ((this.bitField0_ & 256) != 256) goto L39;
                    r11 = r11 + CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                L39:
                    int r12 = this.unknownFields.size() + r11;
                    this.memoizedSerializedSize = r12;
                    return r12;
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

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                    return newBuilderForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                    return toBuilder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public void writeTo(CodedOutputStream r10) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) != 1) goto L6;
                    r10.writeEnum(1, this.type_.getNumber());
                L6:
                    if ((this.bitField0_ & 2) != 2) goto L9;
                    r10.writeSInt64(2, this.intValue_);
                L9:
                    if ((this.bitField0_ & 4) != 4) goto L12;
                    r10.writeFloat(3, this.floatValue_);
                L12:
                    if ((this.bitField0_ & 8) != 8) goto L15;
                    r10.writeDouble(4, this.doubleValue_);
                L15:
                    if ((this.bitField0_ & 16) != 16) goto L18;
                    r10.writeInt32(5, this.stringValue_);
                L18:
                    if ((this.bitField0_ & 32) != 32) goto L21;
                    r10.writeInt32(6, this.classId_);
                L21:
                    if ((this.bitField0_ & 64) != 64) goto L24;
                    r10.writeInt32(7, this.enumValueId_);
                L24:
                    if ((this.bitField0_ & 128) != 128) goto L26;
                    r10.writeMessage(8, this.annotation_);
                L26:
                    int r5 = 0;
                L28:
                    if (r5 >= this.arrayElement_.size()) goto L31;
                    r10.writeMessage(9, this.arrayElement_.get(r5));
                    r5 = r5 + 1;
                    goto L28
                L31:
                    if ((this.bitField0_ & 512) != 512) goto L34;
                    r10.writeInt32(10, this.flags_);
                L34:
                    if ((this.bitField0_ & 256) != 256) goto L36;
                    r10.writeInt32(11, this.arrayDimensionCount_);
                L36:
                    r10.writeRawBytes(this.unknownFields);
                }

                public /* synthetic */ Value(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
                    this(r5);
                }

                public static Builder newBuilder(Value r5) {
                    return newBuilder().mergeFrom(r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder toBuilder() {
                    return newBuilder(this);
                }

                private Value(GeneratedMessageLite.Builder r5) {
                    super(r5);
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = r5.getUnknownFields();
                }

                private Value(boolean r5) {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                private Value(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    ByteString.Output r5 = ByteString.newOutput();
                    CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
                    boolean r13 = false;
                    char r14 = 0;
                L4:
                    if (r13 == true) goto L56;
                    int r15 = r10.readTag();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    switch(r15) {
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
                    r13 = true;
                    goto L4
                L16:
                    this.bitField0_ |= 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.arrayDimensionCount_ = r10.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L17:
                    this.bitField0_ |= 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.flags_ = r10.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L19:
                    if ((r14 & 256) == 256) goto L21;
                    this.arrayElement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    r14 = 256;
                L21:
                    this.arrayElement_.add((Value) r10.readMessage(PARSER, r11));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L23:
                    if ((this.bitField0_ & 128) != 128) goto L25;
                    Builder r16 = this.annotation_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                L26:
                    Annotation r17 = (Annotation) r10.readMessage(Annotation.PARSER, r11);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.annotation_ = r17;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    if (r16 == null) goto L29;
                    r16.mergeFrom(r17);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.annotation_ = r16.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                L29:
                    this.bitField0_ |= 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L25:
                    r16 = null;
                    goto L26
                L30:
                    this.bitField0_ |= 64;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.enumValueId_ = r10.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L31:
                    this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.classId_ = r10.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L32:
                    this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.stringValue_ = r10.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L33:
                    this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.doubleValue_ = r10.readDouble();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L34:
                    this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.floatValue_ = r10.readFloat();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L35:
                    this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.intValue_ = r10.readSInt64();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L36:
                    int r18 = r10.readEnum();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    Type r19 = Type.valueOf(r18);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    if (r19 == null) goto L38;
                    this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    this.type_ = r19;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L38:
                    r12.writeRawVarint32(r15);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    r12.writeRawVarint32(r18);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
                    goto L4
                L8:
                    if (parseUnknownField(r10, r12, r11, r15) == true) goto L4;
                L10:
                    th = move-exception;
                    if ((r14 & 256) != 256) goto L68;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L68:
                    r12.flush();     // Catch: IOException -> L66 Throwable -> L50
                L50:
                    th = move-exception;
                    this.unknownFields = r5.toByteString();
                    throw th;
                L49:
                    this.unknownFields = r5.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                L14:
                    e = move-exception;
                    throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
                L12:
                    e = move-exception;
                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
                L56:
                    if ((r14 & 256) != 256) goto L70;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L70:
                    r12.flush();     // Catch: IOException -> L65 Throwable -> L60
                L60:
                    th = move-exception;
                    this.unknownFields = r5.toByteString();
                    throw th;
                L59:
                    this.unknownFields = r5.toByteString();
                    makeExtensionsImmutable();
                }
            }

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            static {
                PARSER = new AnonymousClass1();
                Argument r5 = new Argument(true);
                defaultInstance = r5;
                r5.initFields();
            }

            public /* synthetic */ Argument(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
                this(r5, r10);
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

            public static /* synthetic */ ByteString access$4100(Argument r5) {
                return r5.unknownFields;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            public static Builder newBuilder() {
                return Builder.access$3600();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public int getNameId() {
                return this.nameId_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r5 = this.memoizedSerializedSize;
                if (r5 == (-1)) goto L6;
                return r5;
            L6:
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r10 = CodedOutputStream.computeInt32Size(1, this.nameId_);
            L10:
                if ((this.bitField0_ & 2) != 2) goto L12;
                r10 = r10 + CodedOutputStream.computeMessageSize(2, this.value_);
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r5) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r5.writeInt32(1, this.nameId_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L8;
                r5.writeMessage(2, this.value_);
            L8:
                r5.writeRawBytes(this.unknownFields);
            }

            public /* synthetic */ Argument(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
                this(r5);
            }

            public static Builder newBuilder(Argument r5) {
                return newBuilder().mergeFrom(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.Builder r5) {
                super(r5);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r5.getUnknownFields();
            }

            private Argument(boolean r5) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Argument(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r5 = ByteString.newOutput();
                CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
                boolean r13 = false;
            L3:
                if (r13 == true) goto L53;
                int r14 = r10.readTag();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
                if (r14 == 0) goto L12;
                if (r14 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
                this.nameId_ = r10.readInt32();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
                goto L3
            L9:
                if (r14 != 18) goto L11;
                if ((this.bitField0_ & 2) != 2) goto L22;
                Value.Builder r15 = this.value_.toBuilder();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            L23:
                Value r16 = (Value) r10.readMessage(Value.PARSER, r11);     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
                this.value_ = r16;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
                if (r15 == null) goto L26;
                r15.mergeFrom(r16);     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
                this.value_ = r15.buildPartial();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            L26:
                this.bitField0_ |= 2;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
                goto L3
            L22:
                r15 = null;
                goto L23
            L11:
                if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
            L12:
                r13 = true;
                goto L3
            L13:
                th = move-exception;
                r12.flush();     // Catch: IOException -> L47 Throwable -> L35
            L35:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L34:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
                throw th;
            L17:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
            L15:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L13
            L53:
                r12.flush();     // Catch: IOException -> L48 Throwable -> L42
            L42:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L41:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private List<Argument> argument_;
            private int bitField0_;
            private int id_;

            private Builder() {
                this.argument_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$4200() {
                return create();
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

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Annotation buildPartial() {
                Annotation r5 = new Annotation(this, null);
                int r10 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r10 = 0;
            L6:
                Annotation.access$4402(r5, this.id_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            L9:
                Annotation.access$4502(r5, this.argument_);
                Annotation.access$4602(r5, r10);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Argument getArgument(int r5) {
                return this.argument_.get(r5);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public boolean hasId() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId() == true) goto L5;
                return false;
            L5:
                int r5 = 0;
            L7:
                if (r5 >= getArgumentCount()) goto L12;
                if (getArgument(r5).isInitialized() == false) goto L10;
                r5 = r5 + 1;
                goto L7
            L10:
                return false;
            L12:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setId(int r5) {
                this.bitField0_ |= 1;
                this.id_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Annotation build() {
                Annotation r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Annotation) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Annotation r5) {
                if (r5 != Annotation.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasId() == false) goto L9;
                setId(r5.getId());
            L9:
                if (Annotation.access$4500(r5).isEmpty() == false) goto L11;
            L14:
                setUnknownFields(getUnknownFields().concat(Annotation.access$4700(r5)));
                return this;
            L11:
                if (this.argument_.isEmpty() == false) goto L13;
                this.argument_ = Annotation.access$4500(r5);
                this.bitField0_ &= -3;
                goto L14
            L13:
                ensureArgumentIsMutable();
                this.argument_.addAll(Annotation.access$4500(r5));
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Annotation r11 = null;
                Annotation r12 = Annotation.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Annotation r13 = (Annotation) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Annotation r5 = new Annotation(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Annotation(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$4402(Annotation r5, int r10) {
            r5.id_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$4500(Annotation r5) {
            return r5.argument_;
        }

        public static /* synthetic */ List access$4502(Annotation r5, List r10) {
            r5.argument_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4602(Annotation r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$4700(Annotation r5) {
            return r5.unknownFields;
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$4200();
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getId() {
            return this.id_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.id_);
        L10:
            if (r10 >= this.argument_.size()) goto L12;
            r11 = r11 + CodedOutputStream.computeMessageSize(2, this.argument_.get(r10));
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r5.writeInt32(1, this.id_);
        L5:
            int r10 = 0;
        L7:
            if (r10 >= this.argument_.size()) goto L9;
            r5.writeMessage(2, this.argument_.get(r10));
            r10 = r10 + 1;
            goto L7
        L9:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Annotation(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Annotation r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Annotation(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Annotation(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Annotation(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            char r14 = 0;
        L4:
            if (r13 == true) goto L41;
            int r15 = r10.readTag();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            if (r15 == 0) goto L13;
            if (r15 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            this.id_ = r10.readInt32();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            goto L4
        L10:
            if (r15 != 18) goto L12;
            if ((r14 & 2) == 2) goto L23;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            r14 = 2;
        L23:
            this.argument_.add((Argument) r10.readMessage(Argument.PARSER, r11));     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L18
            goto L4
        L12:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L4;
        L13:
            r13 = true;
            goto L4
        L14:
            th = move-exception;
            if ((r14 & 2) != 2) goto L53;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L53:
            r12.flush();     // Catch: IOException -> L51 Throwable -> L35
        L35:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L34:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L18:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L16:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L41:
            if ((r14 & 2) != 2) goto L55;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L55:
            r12.flush();     // Catch: IOException -> L50 Throwable -> L45
        L45:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L44:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> PARSER;
        private static final Class defaultInstance = null;
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingTypeId_;
        private List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int bitField0_;
            private int companionObjectName_;
            private List<Constructor> constructor_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private List<EnumEntry> enumEntry_;
            private int flags_;
            private int fqName_;
            private List<Function> function_;
            private int inlineClassUnderlyingPropertyName_;
            private int inlineClassUnderlyingTypeId_;
            private Type inlineClassUnderlyingType_;
            private List<Integer> multiFieldValueClassUnderlyingName_;
            private List<Integer> multiFieldValueClassUnderlyingTypeId_;
            private List<Type> multiFieldValueClassUnderlyingType_;
            private List<Integer> nestedClassName_;
            private List<Property> property_;
            private List<Integer> sealedSubclassFqName_;
            private List<Integer> supertypeId_;
            private List<Type> supertype_;
            private List<TypeAlias> typeAlias_;
            private List<TypeParameter> typeParameter_;
            private TypeTable typeTable_;
            private VersionRequirementTable versionRequirementTable_;
            private List<Integer> versionRequirement_;

            private Builder() {
                this.flags_ = 6;
                this.typeParameter_ = Collections.emptyList();
                this.supertype_ = Collections.emptyList();
                this.supertypeId_ = Collections.emptyList();
                this.nestedClassName_ = Collections.emptyList();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.constructor_ = Collections.emptyList();
                this.function_ = Collections.emptyList();
                this.property_ = Collections.emptyList();
                this.typeAlias_ = Collections.emptyList();
                this.enumEntry_ = Collections.emptyList();
                this.sealedSubclassFqName_ = Collections.emptyList();
                this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
                this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
                this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$8700() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.constructor_ = new ArrayList(this.constructor_);
                this.bitField0_ |= 512;
                return;
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 256;
                return;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 128) == 128) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 128;
                return;
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 8192) == 8192) goto L6;
                this.enumEntry_ = new ArrayList(this.enumEntry_);
                this.bitField0_ |= 8192;
                return;
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1024) == 1024) goto L6;
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1024;
                return;
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 262144) == 262144) goto L6;
                this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ |= 262144;
                return;
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 1048576) == 1048576) goto L6;
                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ |= 1048576;
                return;
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 524288) == 524288) goto L6;
                this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ |= 524288;
                return;
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                this.bitField0_ |= 64;
                return;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2048) == 2048) goto L6;
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2048;
                return;
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 16384) == 16384) goto L6;
                this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                this.bitField0_ |= 16384;
                return;
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.supertypeId_ = new ArrayList(this.supertypeId_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.supertype_ = new ArrayList(this.supertype_);
                this.bitField0_ |= 16;
                return;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4096) == 4096) goto L6;
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4096;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 8;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4194304) == 4194304) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4194304;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Class buildPartial() {
                Class r5 = new Class(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                Class.access$8902(r5, this.flags_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                Class.access$9002(r5, this.fqName_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                Class.access$9102(r5, this.companionObjectName_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -9;
            L15:
                Class.access$9202(r5, this.typeParameter_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
                this.bitField0_ &= -17;
            L18:
                Class.access$9302(r5, this.supertype_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                this.bitField0_ &= -33;
            L21:
                Class.access$9402(r5, this.supertypeId_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                this.bitField0_ &= -65;
            L24:
                Class.access$9502(r5, this.nestedClassName_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -129;
            L27:
                Class.access$9602(r5, this.contextReceiverType_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -257;
            L30:
                Class.access$9702(r5, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
                this.bitField0_ &= -513;
            L33:
                Class.access$9802(r5, this.constructor_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -1025;
            L36:
                Class.access$9902(r5, this.function_);
                if ((this.bitField0_ & 2048) != 2048) goto L39;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -2049;
            L39:
                Class.access$10002(r5, this.property_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -4097;
            L42:
                Class.access$10102(r5, this.typeAlias_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                this.bitField0_ &= -8193;
            L45:
                Class.access$10202(r5, this.enumEntry_);
                if ((this.bitField0_ & 16384) != 16384) goto L48;
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                this.bitField0_ &= -16385;
            L48:
                Class.access$10302(r5, this.sealedSubclassFqName_);
                if ((r10 & 32768) != 32768) goto L51;
                r11 = r11 | 8;
            L51:
                Class.access$10402(r5, this.inlineClassUnderlyingPropertyName_);
                if ((r10 & 65536) != 65536) goto L54;
                r11 = r11 | 16;
            L54:
                Class.access$10502(r5, this.inlineClassUnderlyingType_);
                if ((r10 & 131072) != 131072) goto L57;
                r11 = r11 | 32;
            L57:
                Class.access$10602(r5, this.inlineClassUnderlyingTypeId_);
                if ((this.bitField0_ & 262144) != 262144) goto L60;
                this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ &= -262145;
            L60:
                Class.access$10702(r5, this.multiFieldValueClassUnderlyingName_);
                if ((this.bitField0_ & 524288) != 524288) goto L63;
                this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ &= -524289;
            L63:
                Class.access$10802(r5, this.multiFieldValueClassUnderlyingType_);
                if ((this.bitField0_ & 1048576) != 1048576) goto L66;
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ &= -1048577;
            L66:
                Class.access$10902(r5, this.multiFieldValueClassUnderlyingTypeId_);
                if ((r10 & 2097152) != 2097152) goto L69;
                r11 = r11 | 64;
            L69:
                Class.access$11002(r5, this.typeTable_);
                if ((this.bitField0_ & 4194304) != 4194304) goto L72;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4194305;
            L72:
                Class.access$11102(r5, this.versionRequirement_);
                if ((r10 & 8388608) != 8388608) goto L75;
                r11 = r11 | 128;
            L75:
                Class.access$11202(r5, this.versionRequirementTable_);
                Class.access$11302(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Constructor getConstructor(int r5) {
                return this.constructor_.get(r5);
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public Type getContextReceiverType(int r5) {
                return this.contextReceiverType_.get(r5);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public EnumEntry getEnumEntry(int r5) {
                return this.enumEntry_.get(r5);
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public Function getFunction(int r5) {
                return this.function_.get(r5);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Type getMultiFieldValueClassUnderlyingType(int r5) {
                return this.multiFieldValueClassUnderlyingType_.get(r5);
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public Property getProperty(int r5) {
                return this.property_.get(r5);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Type getSupertype(int r5) {
                return this.supertype_.get(r5);
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public TypeAlias getTypeAlias(int r5) {
                return this.typeAlias_.get(r5);
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeParameter getTypeParameter(int r5) {
                return this.typeParameter_.get(r5);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public boolean hasFqName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasInlineClassUnderlyingType() {
                if ((this.bitField0_ & 65536) != 65536) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2097152) != 2097152) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasFqName() == true) goto L5;
                return false;
            L5:
                int r5 = 0;
            L7:
                if (r5 >= getTypeParameterCount()) goto L12;
                if (getTypeParameter(r5).isInitialized() == false) goto L10;
                r5 = r5 + 1;
                goto L7
            L10:
                return false;
            L12:
                int r10 = 0;
            L14:
                if (r10 >= getSupertypeCount()) goto L19;
                if (getSupertype(r10).isInitialized() == false) goto L17;
                r10 = r10 + 1;
                goto L14
            L17:
                return false;
            L19:
                int r11 = 0;
            L21:
                if (r11 >= getContextReceiverTypeCount()) goto L26;
                if (getContextReceiverType(r11).isInitialized() == false) goto L24;
                r11 = r11 + 1;
                goto L21
            L24:
                return false;
            L26:
                int r12 = 0;
            L28:
                if (r12 >= getConstructorCount()) goto L33;
                if (getConstructor(r12).isInitialized() == false) goto L31;
                r12 = r12 + 1;
                goto L28
            L31:
                return false;
            L33:
                int r13 = 0;
            L35:
                if (r13 >= getFunctionCount()) goto L40;
                if (getFunction(r13).isInitialized() == false) goto L38;
                r13 = r13 + 1;
                goto L35
            L38:
                return false;
            L40:
                int r14 = 0;
            L42:
                if (r14 >= getPropertyCount()) goto L47;
                if (getProperty(r14).isInitialized() == false) goto L45;
                r14 = r14 + 1;
                goto L42
            L45:
                return false;
            L47:
                int r15 = 0;
            L49:
                if (r15 >= getTypeAliasCount()) goto L54;
                if (getTypeAlias(r15).isInitialized() == false) goto L52;
                r15 = r15 + 1;
                goto L49
            L52:
                return false;
            L54:
                int r16 = 0;
            L56:
                if (r16 >= getEnumEntryCount()) goto L62;
                if (getEnumEntry(r16).isInitialized() == false) goto L59;
                r16 = r16 + 1;
                goto L56
            L59:
                return false;
            L62:
                if (hasInlineClassUnderlyingType() == true) goto L64;
            L66:
                int r17 = 0;
            L68:
                if (r17 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L74;
                if (getMultiFieldValueClassUnderlyingType(r17).isInitialized() == false) goto L71;
                r17 = r17 + 1;
                goto L68
            L71:
                return false;
            L74:
                if (hasTypeTable() == false) goto L79;
                if (getTypeTable().isInitialized() == true) goto L79;
                return false;
            L79:
                if (extensionsAreInitialized() == true) goto L81;
                return false;
            L81:
                return true;
            L64:
                if (getInlineClassUnderlyingType().isInitialized() == true) goto L66;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeInlineClassUnderlyingType(Type r5) {
                if ((this.bitField0_ & 65536) == 65536) goto L5;
            L7:
                this.inlineClassUnderlyingType_ = r5;
            L8:
                this.bitField0_ |= 65536;
                return this;
            L5:
                if (this.inlineClassUnderlyingType_ == Type.getDefaultInstance()) goto L7;
                this.inlineClassUnderlyingType_ = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeTypeTable(TypeTable r5) {
                if ((this.bitField0_ & 2097152) == 2097152) goto L5;
            L7:
                this.typeTable_ = r5;
            L8:
                this.bitField0_ |= 2097152;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r5) {
                if ((this.bitField0_ & 8388608) == 8388608) goto L5;
            L7:
                this.versionRequirementTable_ = r5;
            L8:
                this.bitField0_ |= 8388608;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder setCompanionObjectName(int r5) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = r5;
                return this;
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 1;
                this.flags_ = r5;
                return this;
            }

            public Builder setFqName(int r5) {
                this.bitField0_ |= 2;
                this.fqName_ = r5;
                return this;
            }

            public Builder setInlineClassUnderlyingPropertyName(int r5) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = r5;
                return this;
            }

            public Builder setInlineClassUnderlyingTypeId(int r5) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Class build() {
                Class r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Class) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(Class r5) {
                if (r5 != Class.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasFlags() == false) goto L9;
                setFlags(r5.getFlags());
            L9:
                if (r5.hasFqName() == false) goto L12;
                setFqName(r5.getFqName());
            L12:
                if (r5.hasCompanionObjectName() == false) goto L15;
                setCompanionObjectName(r5.getCompanionObjectName());
            L15:
                if (Class.access$9200(r5).isEmpty() == true) goto L21;
                if (this.typeParameter_.isEmpty() == false) goto L19;
                this.typeParameter_ = Class.access$9200(r5);
                this.bitField0_ &= -9;
                goto L21
            L19:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Class.access$9200(r5));
            L21:
                if (Class.access$9300(r5).isEmpty() == true) goto L27;
                if (this.supertype_.isEmpty() == false) goto L25;
                this.supertype_ = Class.access$9300(r5);
                this.bitField0_ &= -17;
                goto L27
            L25:
                ensureSupertypeIsMutable();
                this.supertype_.addAll(Class.access$9300(r5));
            L27:
                if (Class.access$9400(r5).isEmpty() == true) goto L33;
                if (this.supertypeId_.isEmpty() == false) goto L31;
                this.supertypeId_ = Class.access$9400(r5);
                this.bitField0_ &= -33;
                goto L33
            L31:
                ensureSupertypeIdIsMutable();
                this.supertypeId_.addAll(Class.access$9400(r5));
            L33:
                if (Class.access$9500(r5).isEmpty() == true) goto L39;
                if (this.nestedClassName_.isEmpty() == false) goto L37;
                this.nestedClassName_ = Class.access$9500(r5);
                this.bitField0_ &= -65;
                goto L39
            L37:
                ensureNestedClassNameIsMutable();
                this.nestedClassName_.addAll(Class.access$9500(r5));
            L39:
                if (Class.access$9600(r5).isEmpty() == true) goto L45;
                if (this.contextReceiverType_.isEmpty() == false) goto L43;
                this.contextReceiverType_ = Class.access$9600(r5);
                this.bitField0_ &= -129;
                goto L45
            L43:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Class.access$9600(r5));
            L45:
                if (Class.access$9700(r5).isEmpty() == true) goto L51;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L49;
                this.contextReceiverTypeId_ = Class.access$9700(r5);
                this.bitField0_ &= -257;
                goto L51
            L49:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Class.access$9700(r5));
            L51:
                if (Class.access$9800(r5).isEmpty() == true) goto L57;
                if (this.constructor_.isEmpty() == false) goto L55;
                this.constructor_ = Class.access$9800(r5);
                this.bitField0_ &= -513;
                goto L57
            L55:
                ensureConstructorIsMutable();
                this.constructor_.addAll(Class.access$9800(r5));
            L57:
                if (Class.access$9900(r5).isEmpty() == true) goto L63;
                if (this.function_.isEmpty() == false) goto L61;
                this.function_ = Class.access$9900(r5);
                this.bitField0_ &= -1025;
                goto L63
            L61:
                ensureFunctionIsMutable();
                this.function_.addAll(Class.access$9900(r5));
            L63:
                if (Class.access$10000(r5).isEmpty() == true) goto L69;
                if (this.property_.isEmpty() == false) goto L67;
                this.property_ = Class.access$10000(r5);
                this.bitField0_ &= -2049;
                goto L69
            L67:
                ensurePropertyIsMutable();
                this.property_.addAll(Class.access$10000(r5));
            L69:
                if (Class.access$10100(r5).isEmpty() == true) goto L75;
                if (this.typeAlias_.isEmpty() == false) goto L73;
                this.typeAlias_ = Class.access$10100(r5);
                this.bitField0_ &= -4097;
                goto L75
            L73:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Class.access$10100(r5));
            L75:
                if (Class.access$10200(r5).isEmpty() == true) goto L81;
                if (this.enumEntry_.isEmpty() == false) goto L79;
                this.enumEntry_ = Class.access$10200(r5);
                this.bitField0_ &= -8193;
                goto L81
            L79:
                ensureEnumEntryIsMutable();
                this.enumEntry_.addAll(Class.access$10200(r5));
            L81:
                if (Class.access$10300(r5).isEmpty() == true) goto L87;
                if (this.sealedSubclassFqName_.isEmpty() == false) goto L85;
                this.sealedSubclassFqName_ = Class.access$10300(r5);
                this.bitField0_ &= -16385;
                goto L87
            L85:
                ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.addAll(Class.access$10300(r5));
            L87:
                if (r5.hasInlineClassUnderlyingPropertyName() == false) goto L90;
                setInlineClassUnderlyingPropertyName(r5.getInlineClassUnderlyingPropertyName());
            L90:
                if (r5.hasInlineClassUnderlyingType() == false) goto L93;
                mergeInlineClassUnderlyingType(r5.getInlineClassUnderlyingType());
            L93:
                if (r5.hasInlineClassUnderlyingTypeId() == false) goto L96;
                setInlineClassUnderlyingTypeId(r5.getInlineClassUnderlyingTypeId());
            L96:
                if (Class.access$10700(r5).isEmpty() == true) goto L102;
                if (this.multiFieldValueClassUnderlyingName_.isEmpty() == false) goto L100;
                this.multiFieldValueClassUnderlyingName_ = Class.access$10700(r5);
                this.bitField0_ &= -262145;
                goto L102
            L100:
                ensureMultiFieldValueClassUnderlyingNameIsMutable();
                this.multiFieldValueClassUnderlyingName_.addAll(Class.access$10700(r5));
            L102:
                if (Class.access$10800(r5).isEmpty() == true) goto L108;
                if (this.multiFieldValueClassUnderlyingType_.isEmpty() == false) goto L106;
                this.multiFieldValueClassUnderlyingType_ = Class.access$10800(r5);
                this.bitField0_ &= -524289;
                goto L108
            L106:
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.addAll(Class.access$10800(r5));
            L108:
                if (Class.access$10900(r5).isEmpty() == true) goto L114;
                if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty() == false) goto L112;
                this.multiFieldValueClassUnderlyingTypeId_ = Class.access$10900(r5);
                this.bitField0_ &= -1048577;
                goto L114
            L112:
                ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                this.multiFieldValueClassUnderlyingTypeId_.addAll(Class.access$10900(r5));
            L114:
                if (r5.hasTypeTable() == false) goto L117;
                mergeTypeTable(r5.getTypeTable());
            L117:
                if (Class.access$11100(r5).isEmpty() == true) goto L123;
                if (this.versionRequirement_.isEmpty() == false) goto L121;
                this.versionRequirement_ = Class.access$11100(r5);
                this.bitField0_ &= -4194305;
                goto L123
            L121:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Class.access$11100(r5));
            L123:
                if (r5.hasVersionRequirementTable() == false) goto L125;
                mergeVersionRequirementTable(r5.getVersionRequirementTable());
            L125:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(Class.access$11400(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Class r11 = null;
                Class r12 = Class.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Class r13 = (Class) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        public static final enum Kind extends Enum<Kind> implements Internal.EnumLite {
            private static final /* synthetic */ Kind[] $VALUES = null;
            public static final Kind ANNOTATION_CLASS = null;
            public static final Kind CLASS = null;
            public static final Kind COMPANION_OBJECT = null;
            public static final Kind ENUM_CLASS = null;
            public static final Kind ENUM_ENTRY = null;
            public static final Kind INTERFACE = null;
            public static final Kind OBJECT = null;
            private static Internal.EnumLiteMap<Kind> internalValueMap;
            private final int value;

            static {
                Kind r5 = new Kind("CLASS", 0, 0, 0);
                CLASS = r5;
                Kind r10 = new Kind("INTERFACE", 1, 1, 1);
                INTERFACE = r10;
                Kind r11 = new Kind("ENUM_CLASS", 2, 2, 2);
                ENUM_CLASS = r11;
                Kind r12 = new Kind("ENUM_ENTRY", 3, 3, 3);
                ENUM_ENTRY = r12;
                Kind r13 = new Kind("ANNOTATION_CLASS", 4, 4, 4);
                ANNOTATION_CLASS = r13;
                Kind r14 = new Kind("OBJECT", 5, 5, 5);
                OBJECT = r14;
                Kind r15 = new Kind("COMPANION_OBJECT", 6, 6, 6);
                COMPANION_OBJECT = r15;
                $VALUES = new Kind[]{r5, r10, r11, r12, r13, r14, r15};
                internalValueMap = new AnonymousClass1();
            }

            private Kind(String r5, int r10, int r11, int r12) {
                super(r5, r10);
                this.value = r12;
            }

            public static Kind valueOf(String r5) {
                return (Kind) Enum.valueOf(Kind.class, r5);
            }

            public static Kind[] values() {
                return (Kind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int r5) {
                switch(r5) {
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L14;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L8;
                    case 6: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return COMPANION_OBJECT;
            L8:
                return OBJECT;
            L10:
                return ANNOTATION_CLASS;
            L12:
                return ENUM_ENTRY;
            L14:
                return ENUM_CLASS;
            L16:
                return INTERFACE;
            L18:
                return CLASS;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Class r5 = new Class(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Class(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$10000(Class r5) {
            return r5.property_;
        }

        public static /* synthetic */ List access$10002(Class r5, List r10) {
            r5.property_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$10100(Class r5) {
            return r5.typeAlias_;
        }

        public static /* synthetic */ List access$10102(Class r5, List r10) {
            r5.typeAlias_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$10200(Class r5) {
            return r5.enumEntry_;
        }

        public static /* synthetic */ List access$10202(Class r5, List r10) {
            r5.enumEntry_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$10300(Class r5) {
            return r5.sealedSubclassFqName_;
        }

        public static /* synthetic */ List access$10302(Class r5, List r10) {
            r5.sealedSubclassFqName_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$10402(Class r5, int r10) {
            r5.inlineClassUnderlyingPropertyName_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$10502(Class r5, Type r10) {
            r5.inlineClassUnderlyingType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$10602(Class r5, int r10) {
            r5.inlineClassUnderlyingTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$10700(Class r5) {
            return r5.multiFieldValueClassUnderlyingName_;
        }

        public static /* synthetic */ List access$10702(Class r5, List r10) {
            r5.multiFieldValueClassUnderlyingName_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$10800(Class r5) {
            return r5.multiFieldValueClassUnderlyingType_;
        }

        public static /* synthetic */ List access$10802(Class r5, List r10) {
            r5.multiFieldValueClassUnderlyingType_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$10900(Class r5) {
            return r5.multiFieldValueClassUnderlyingTypeId_;
        }

        public static /* synthetic */ List access$10902(Class r5, List r10) {
            r5.multiFieldValueClassUnderlyingTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ TypeTable access$11002(Class r5, TypeTable r10) {
            r5.typeTable_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$11100(Class r5) {
            return r5.versionRequirement_;
        }

        public static /* synthetic */ List access$11102(Class r5, List r10) {
            r5.versionRequirement_ = r10;
            return r10;
        }

        public static /* synthetic */ VersionRequirementTable access$11202(Class r5, VersionRequirementTable r10) {
            r5.versionRequirementTable_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$11302(Class r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$11400(Class r5) {
            return r5.unknownFields;
        }

        public static /* synthetic */ int access$8902(Class r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$9002(Class r5, int r10) {
            r5.fqName_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$9102(Class r5, int r10) {
            r5.companionObjectName_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9200(Class r5) {
            return r5.typeParameter_;
        }

        public static /* synthetic */ List access$9202(Class r5, List r10) {
            r5.typeParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9300(Class r5) {
            return r5.supertype_;
        }

        public static /* synthetic */ List access$9302(Class r5, List r10) {
            r5.supertype_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9400(Class r5) {
            return r5.supertypeId_;
        }

        public static /* synthetic */ List access$9402(Class r5, List r10) {
            r5.supertypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9500(Class r5) {
            return r5.nestedClassName_;
        }

        public static /* synthetic */ List access$9502(Class r5, List r10) {
            r5.nestedClassName_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9600(Class r5) {
            return r5.contextReceiverType_;
        }

        public static /* synthetic */ List access$9602(Class r5, List r10) {
            r5.contextReceiverType_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9700(Class r5) {
            return r5.contextReceiverTypeId_;
        }

        public static /* synthetic */ List access$9702(Class r5, List r10) {
            r5.contextReceiverTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9800(Class r5) {
            return r5.constructor_;
        }

        public static /* synthetic */ List access$9802(Class r5, List r10) {
            r5.constructor_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$9900(Class r5) {
            return r5.function_;
        }

        public static /* synthetic */ List access$9902(Class r5, List r10) {
            r5.function_ = r10;
            return r10;
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$8700();
        }

        public static Class parseFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public Constructor getConstructor(int r5) {
            return this.constructor_.get(r5);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public Type getContextReceiverType(int r5) {
            return this.contextReceiverType_.get(r5);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public EnumEntry getEnumEntry(int r5) {
            return this.enumEntry_.get(r5);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public Function getFunction(int r5) {
            return this.function_.get(r5);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public Type getMultiFieldValueClassUnderlyingType(int r5) {
            return this.multiFieldValueClassUnderlyingType_.get(r5);
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int r5) {
            return this.property_.get(r5);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.flags_);
        L9:
            int r12 = 0;
            int r13 = 0;
        L11:
            if (r12 >= this.supertypeId_.size()) goto L13;
            r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(r12).intValue());
            r12 = r12 + 1;
            goto L11
        L13:
            int r14 = r11 + r13;
            if (getSupertypeIdList().isEmpty() == true) goto L16;
            r14 = (r14 + 1) + CodedOutputStream.computeInt32SizeNoTag(r13);
        L16:
            this.supertypeIdMemoizedSerializedSize = r13;
            if ((this.bitField0_ & 2) != 2) goto L20;
            r14 = r14 + CodedOutputStream.computeInt32Size(3, this.fqName_);
        L20:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r14 = r14 + CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        L22:
            int r15 = 0;
        L24:
            if (r15 >= this.typeParameter_.size()) goto L26;
            r14 = r14 + CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(r15));
            r15 = r15 + 1;
            goto L24
        L26:
            int r16 = 0;
        L28:
            if (r16 >= this.supertype_.size()) goto L30;
            r14 = r14 + CodedOutputStream.computeMessageSize(6, this.supertype_.get(r16));
            r16 = r16 + 1;
            goto L28
        L30:
            int r17 = 0;
            int r18 = 0;
        L32:
            if (r17 >= this.nestedClassName_.size()) goto L34;
            r18 = r18 + CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(r17).intValue());
            r17 = r17 + 1;
            goto L32
        L34:
            int r19 = r14 + r18;
            if (getNestedClassNameList().isEmpty() == true) goto L37;
            r19 = (r19 + 1) + CodedOutputStream.computeInt32SizeNoTag(r18);
        L37:
            this.nestedClassNameMemoizedSerializedSize = r18;
            int r20 = 0;
        L39:
            if (r20 >= this.constructor_.size()) goto L41;
            r19 = r19 + CodedOutputStream.computeMessageSize(8, this.constructor_.get(r20));
            r20 = r20 + 1;
            goto L39
        L41:
            int r21 = 0;
        L43:
            if (r21 >= this.function_.size()) goto L45;
            r19 = r19 + CodedOutputStream.computeMessageSize(9, this.function_.get(r21));
            r21 = r21 + 1;
            goto L43
        L45:
            int r22 = 0;
        L47:
            if (r22 >= this.property_.size()) goto L49;
            r19 = r19 + CodedOutputStream.computeMessageSize(10, this.property_.get(r22));
            r22 = r22 + 1;
            goto L47
        L49:
            int r23 = 0;
        L51:
            if (r23 >= this.typeAlias_.size()) goto L53;
            r19 = r19 + CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(r23));
            r23 = r23 + 1;
            goto L51
        L53:
            int r24 = 0;
        L55:
            if (r24 >= this.enumEntry_.size()) goto L57;
            r19 = r19 + CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(r24));
            r24 = r24 + 1;
            goto L55
        L57:
            int r25 = 0;
            int r26 = 0;
        L59:
            if (r25 >= this.sealedSubclassFqName_.size()) goto L61;
            r26 = r26 + CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(r25).intValue());
            r25 = r25 + 1;
            goto L59
        L61:
            int r27 = r19 + r26;
            if (getSealedSubclassFqNameList().isEmpty() == true) goto L64;
            r27 = (r27 + 2) + CodedOutputStream.computeInt32SizeNoTag(r26);
        L64:
            this.sealedSubclassFqNameMemoizedSerializedSize = r26;
            if ((this.bitField0_ & 8) != 8) goto L68;
            r27 = r27 + CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
        L68:
            if ((this.bitField0_ & 16) != 16) goto L71;
            r27 = r27 + CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
        L71:
            if ((this.bitField0_ & 32) != 32) goto L73;
            r27 = r27 + CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
        L73:
            int r28 = 0;
        L75:
            if (r28 >= this.contextReceiverType_.size()) goto L77;
            r27 = r27 + CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(r28));
            r28 = r28 + 1;
            goto L75
        L77:
            int r29 = 0;
            int r30 = 0;
        L79:
            if (r29 >= this.contextReceiverTypeId_.size()) goto L81;
            r30 = r30 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r29).intValue());
            r29 = r29 + 1;
            goto L79
        L81:
            int r31 = r27 + r30;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L84;
            r31 = (r31 + 2) + CodedOutputStream.computeInt32SizeNoTag(r30);
        L84:
            this.contextReceiverTypeIdMemoizedSerializedSize = r30;
            int r32 = 0;
            int r33 = 0;
        L86:
            if (r32 >= this.multiFieldValueClassUnderlyingName_.size()) goto L88;
            r33 = r33 + CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(r32).intValue());
            r32 = r32 + 1;
            goto L86
        L88:
            int r34 = r31 + r33;
            if (getMultiFieldValueClassUnderlyingNameList().isEmpty() == true) goto L91;
            r34 = (r34 + 2) + CodedOutputStream.computeInt32SizeNoTag(r33);
        L91:
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r33;
            int r35 = 0;
        L93:
            if (r35 >= this.multiFieldValueClassUnderlyingType_.size()) goto L95;
            r34 = r34 + CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(r35));
            r35 = r35 + 1;
            goto L93
        L95:
            int r36 = 0;
            int r37 = 0;
        L97:
            if (r36 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r37 = r37 + CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(r36).intValue());
            r36 = r36 + 1;
            goto L97
        L99:
            int r38 = r34 + r37;
            if (getMultiFieldValueClassUnderlyingTypeIdList().isEmpty() == true) goto L102;
            r38 = (r38 + 2) + CodedOutputStream.computeInt32SizeNoTag(r37);
        L102:
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r37;
            if ((this.bitField0_ & 64) != 64) goto L105;
            r38 = r38 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L105:
            int r39 = 0;
        L107:
            if (r10 >= this.versionRequirement_.size()) goto L109;
            r39 = r39 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r10).intValue());
            r10 = r10 + 1;
            goto L107
        L109:
            int r40 = (getVersionRequirementList().size() * 2) + (r38 + r39);
            if ((this.bitField0_ & 128) != 128) goto L112;
            r40 = r40 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L112:
            int r41 = this.unknownFields.size() + (extensionsSerializedSize() + r40);
            this.memoizedSerializedSize = r41;
            return r41;
        L8:
            r11 = 0;
            goto L9
        }

        public Type getSupertype(int r5) {
            return this.supertype_.get(r5);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public TypeAlias getTypeAlias(int r5) {
            return this.typeAlias_.get(r5);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeParameter getTypeParameter(int r5) {
            return this.typeParameter_.get(r5);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasCompanionObjectName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasFqName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasInlineClassUnderlyingType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasFqName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r10 = 0;
        L14:
            if (r10 >= getTypeParameterCount()) goto L20;
            if (getTypeParameter(r10).isInitialized() == false) goto L17;
            r10 = r10 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            int r11 = 0;
        L22:
            if (r11 >= getSupertypeCount()) goto L28;
            if (getSupertype(r11).isInitialized() == false) goto L25;
            r11 = r11 + 1;
            goto L22
        L25:
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            int r12 = 0;
        L30:
            if (r12 >= getContextReceiverTypeCount()) goto L36;
            if (getContextReceiverType(r12).isInitialized() == false) goto L33;
            r12 = r12 + 1;
            goto L30
        L33:
            this.memoizedIsInitialized = 0;
            return false;
        L36:
            int r13 = 0;
        L38:
            if (r13 >= getConstructorCount()) goto L44;
            if (getConstructor(r13).isInitialized() == false) goto L41;
            r13 = r13 + 1;
            goto L38
        L41:
            this.memoizedIsInitialized = 0;
            return false;
        L44:
            int r14 = 0;
        L46:
            if (r14 >= getFunctionCount()) goto L52;
            if (getFunction(r14).isInitialized() == false) goto L49;
            r14 = r14 + 1;
            goto L46
        L49:
            this.memoizedIsInitialized = 0;
            return false;
        L52:
            int r15 = 0;
        L54:
            if (r15 >= getPropertyCount()) goto L60;
            if (getProperty(r15).isInitialized() == false) goto L57;
            r15 = r15 + 1;
            goto L54
        L57:
            this.memoizedIsInitialized = 0;
            return false;
        L60:
            int r16 = 0;
        L62:
            if (r16 >= getTypeAliasCount()) goto L68;
            if (getTypeAlias(r16).isInitialized() == false) goto L65;
            r16 = r16 + 1;
            goto L62
        L65:
            this.memoizedIsInitialized = 0;
            return false;
        L68:
            int r17 = 0;
        L70:
            if (r17 >= getEnumEntryCount()) goto L77;
            if (getEnumEntry(r17).isInitialized() == false) goto L73;
            r17 = r17 + 1;
            goto L70
        L73:
            this.memoizedIsInitialized = 0;
            return false;
        L77:
            if (hasInlineClassUnderlyingType() == true) goto L79;
        L82:
            int r18 = 0;
        L84:
            if (r18 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L91;
            if (getMultiFieldValueClassUnderlyingType(r18).isInitialized() == false) goto L87;
            r18 = r18 + 1;
            goto L84
        L87:
            this.memoizedIsInitialized = 0;
            return false;
        L91:
            if (hasTypeTable() == false) goto L97;
            if (getTypeTable().isInitialized() == true) goto L97;
            this.memoizedIsInitialized = 0;
            return false;
        L97:
            if (extensionsAreInitialized() == true) goto L100;
            this.memoizedIsInitialized = 0;
            return false;
        L100:
            this.memoizedIsInitialized = 1;
            return true;
        L79:
            if (getInlineClassUnderlyingType().isInitialized() == true) goto L82;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.flags_);
        L6:
            if (getSupertypeIdList().size() <= 0) goto L8;
            r10.writeRawVarint32(18);
            r10.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        L8:
            int r11 = 0;
            int r12 = 0;
        L10:
            if (r12 >= this.supertypeId_.size()) goto L13;
            r10.writeInt32NoTag(this.supertypeId_.get(r12).intValue());
            r12 = r12 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r10.writeInt32(3, this.fqName_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r10.writeInt32(4, this.companionObjectName_);
        L18:
            int r13 = 0;
        L20:
            if (r13 >= this.typeParameter_.size()) goto L22;
            r10.writeMessage(5, this.typeParameter_.get(r13));
            r13 = r13 + 1;
            goto L20
        L22:
            int r14 = 0;
        L24:
            if (r14 >= this.supertype_.size()) goto L27;
            r10.writeMessage(6, this.supertype_.get(r14));
            r14 = r14 + 1;
            goto L24
        L27:
            if (getNestedClassNameList().size() <= 0) goto L29;
            r10.writeRawVarint32(58);
            r10.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        L29:
            int r15 = 0;
        L31:
            if (r15 >= this.nestedClassName_.size()) goto L33;
            r10.writeInt32NoTag(this.nestedClassName_.get(r15).intValue());
            r15 = r15 + 1;
            goto L31
        L33:
            int r16 = 0;
        L35:
            if (r16 >= this.constructor_.size()) goto L37;
            r10.writeMessage(8, this.constructor_.get(r16));
            r16 = r16 + 1;
            goto L35
        L37:
            int r17 = 0;
        L39:
            if (r17 >= this.function_.size()) goto L41;
            r10.writeMessage(9, this.function_.get(r17));
            r17 = r17 + 1;
            goto L39
        L41:
            int r18 = 0;
        L43:
            if (r18 >= this.property_.size()) goto L45;
            r10.writeMessage(10, this.property_.get(r18));
            r18 = r18 + 1;
            goto L43
        L45:
            int r19 = 0;
        L47:
            if (r19 >= this.typeAlias_.size()) goto L49;
            r10.writeMessage(11, this.typeAlias_.get(r19));
            r19 = r19 + 1;
            goto L47
        L49:
            int r20 = 0;
        L51:
            if (r20 >= this.enumEntry_.size()) goto L54;
            r10.writeMessage(13, this.enumEntry_.get(r20));
            r20 = r20 + 1;
            goto L51
        L54:
            if (getSealedSubclassFqNameList().size() <= 0) goto L56;
            r10.writeRawVarint32(130);
            r10.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        L56:
            int r21 = 0;
        L58:
            if (r21 >= this.sealedSubclassFqName_.size()) goto L61;
            r10.writeInt32NoTag(this.sealedSubclassFqName_.get(r21).intValue());
            r21 = r21 + 1;
            goto L58
        L61:
            if ((this.bitField0_ & 8) != 8) goto L64;
            r10.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
        L64:
            if ((this.bitField0_ & 16) != 16) goto L67;
            r10.writeMessage(18, this.inlineClassUnderlyingType_);
        L67:
            if ((this.bitField0_ & 32) != 32) goto L69;
            r10.writeInt32(19, this.inlineClassUnderlyingTypeId_);
        L69:
            int r22 = 0;
        L71:
            if (r22 >= this.contextReceiverType_.size()) goto L74;
            r10.writeMessage(20, this.contextReceiverType_.get(r22));
            r22 = r22 + 1;
            goto L71
        L74:
            if (getContextReceiverTypeIdList().size() <= 0) goto L76;
            r10.writeRawVarint32(170);
            r10.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L76:
            int r23 = 0;
        L78:
            if (r23 >= this.contextReceiverTypeId_.size()) goto L81;
            r10.writeInt32NoTag(this.contextReceiverTypeId_.get(r23).intValue());
            r23 = r23 + 1;
            goto L78
        L81:
            if (getMultiFieldValueClassUnderlyingNameList().size() <= 0) goto L83;
            r10.writeRawVarint32(178);
            r10.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
        L83:
            int r24 = 0;
        L85:
            if (r24 >= this.multiFieldValueClassUnderlyingName_.size()) goto L87;
            r10.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(r24).intValue());
            r24 = r24 + 1;
            goto L85
        L87:
            int r25 = 0;
        L89:
            if (r25 >= this.multiFieldValueClassUnderlyingType_.size()) goto L92;
            r10.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(r25));
            r25 = r25 + 1;
            goto L89
        L92:
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() <= 0) goto L94;
            r10.writeRawVarint32(194);
            r10.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
        L94:
            int r26 = 0;
        L96:
            if (r26 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r10.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(r26).intValue());
            r26 = r26 + 1;
            goto L96
        L99:
            if ((this.bitField0_ & 64) != 64) goto L102;
            r10.writeMessage(30, this.typeTable_);
        L102:
            if (r11 >= this.versionRequirement_.size()) goto L105;
            r10.writeInt32(31, this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L102
        L105:
            if ((this.bitField0_ & 128) != 128) goto L107;
            r10.writeMessage(32, this.versionRequirementTable_);
        L107:
            r5.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Class(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Class r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> r5) {
            super(r5);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Class(boolean r5) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class(CodedInputStream r18, ExtensionRegistryLite r19) throws InvalidProtocolBufferException {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r11 = false;
            int r12 = 0;
        L4:
            if (r11 == true) goto L233;
            int r15 = r18.readTag();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            Cloneable r16 = null;
            switch(r15) {
                case 0: goto L171;
                case 8: goto L169;
                case 16: goto L166;
                case 18: goto L156;
                case 24: goto L155;
                case 32: goto L154;
                case 42: goto L151;
                case 50: goto L147;
                case 56: goto L143;
                case 58: goto L133;
                case 66: goto L130;
                case 74: goto L126;
                case 82: goto L122;
                case 90: goto L118;
                case 106: goto L114;
                case 128: goto L110;
                case 130: goto L100;
                case 136: goto L99;
                case 146: goto L93;
                case 152: goto L91;
                case 162: goto L88;
                case 168: goto L84;
                case 170: goto L74;
                case 176: goto L71;
                case 178: goto L61;
                case 186: goto L58;
                case 192: goto L54;
                case 194: goto L44;
                case 242: goto L38;
                case 248: goto L34;
                case 250: goto L24;
                case 258: goto L18;
                default: goto L8;
            };     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L24:
            int r13 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r12 & 4194304) == 4194304) goto L30;
            if (r18.getBytesUntilLimit() <= 0) goto L30;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 4194304;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L30:
            if (r18.getBytesUntilLimit() <= 0) goto L32;
            this.versionRequirement_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L30
        L32:
            r18.popLimit(r13);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L10:
            boolean r14 = true;
            goto L4
        L44:
            int r17 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r12 & 1048576) == 1048576) goto L50;
            if (r18.getBytesUntilLimit() <= 0) goto L50;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 1048576;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L50:
            if (r18.getBytesUntilLimit() <= 0) goto L52;
            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L50
        L52:
            r18.popLimit(r17);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L61:
            int r20 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r12 & 262144) == 262144) goto L67;
            if (r18.getBytesUntilLimit() <= 0) goto L67;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 262144;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L67:
            if (r18.getBytesUntilLimit() <= 0) goto L69;
            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L67
        L69:
            r18.popLimit(r20);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L74:
            int r21 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r12 & 256) == 256) goto L80;
            if (r18.getBytesUntilLimit() <= 0) goto L80;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 256;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L80:
            if (r18.getBytesUntilLimit() <= 0) goto L82;
            this.contextReceiverTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L80
        L82:
            r18.popLimit(r21);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L91:
            this.bitField0_ |= 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.inlineClassUnderlyingTypeId_ = r18.readInt32();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L99:
            this.bitField0_ |= 8;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.inlineClassUnderlyingPropertyName_ = r18.readInt32();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L100:
            int r22 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r12 & 16384) == 16384) goto L106;
            if (r18.getBytesUntilLimit() <= 0) goto L106;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 16384;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L106:
            if (r18.getBytesUntilLimit() <= 0) goto L108;
            this.sealedSubclassFqName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L106
        L108:
            r18.popLimit(r22);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L133:
            int r23 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r12 & 64) == 64) goto L139;
            if (r18.getBytesUntilLimit() <= 0) goto L139;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L139:
            if (r18.getBytesUntilLimit() <= 0) goto L141;
            this.nestedClassName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L139
        L141:
            r18.popLimit(r23);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L154:
            this.bitField0_ |= 4;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.companionObjectName_ = r18.readInt32();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L155:
            this.bitField0_ |= 2;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.fqName_ = r18.readInt32();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L156:
            int r24 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r12 & 32) == 32) goto L162;
            if (r18.getBytesUntilLimit() <= 0) goto L162;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L162:
            if (r18.getBytesUntilLimit() <= 0) goto L164;
            this.supertypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L162
        L164:
            r18.popLimit(r24);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L169:
            r14 = true;
            this.bitField0_ |= 1;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.flags_ = r18.readInt32();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L4
        L171:
            r14 = true;
            r11 = true;
            goto L4
        L8:
            if (parseUnknownField(r18, r10, r19, r15) == true) goto L10;
            r11 = true;
            goto L10
        L18:
            if ((this.bitField0_ & 128) != 128) goto L20;
            r16 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L20:
            VersionRequirementTable.Builder r110 = r16;
            VersionRequirementTable r111 = (VersionRequirementTable) r18.readMessage(VersionRequirementTable.PARSER, r19);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.versionRequirementTable_ = r111;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r110 == 0) goto L23;
            r110.mergeFrom(r111);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.versionRequirementTable_ = r110.buildPartial();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L23:
            this.bitField0_ |= 128;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L34:
            if ((r12 & 4194304) == 4194304) goto L36;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 4194304;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L36:
            this.versionRequirement_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L38:
            if ((this.bitField0_ & 64) != 64) goto L40;
            r16 = this.typeTable_.toBuilder();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L40:
            TypeTable.Builder r25 = r16;
            TypeTable r112 = (TypeTable) r18.readMessage(TypeTable.PARSER, r19);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.typeTable_ = r112;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r25 == 0) goto L43;
            r25.mergeFrom(r112);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.typeTable_ = r25.buildPartial();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L43:
            this.bitField0_ |= 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L54:
            if ((r12 & 1048576) == 1048576) goto L56;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 1048576;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L56:
            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L58:
            if ((r12 & 524288) == 524288) goto L60;
            this.multiFieldValueClassUnderlyingType_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 524288;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L60:
            this.multiFieldValueClassUnderlyingType_.add((Type) r18.readMessage(Type.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L71:
            if ((r12 & 262144) == 262144) goto L73;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 262144;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L73:
            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L84:
            if ((r12 & 256) == 256) goto L86;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 256;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L86:
            this.contextReceiverTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L88:
            if ((r12 & 128) == 128) goto L90;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 128;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L90:
            this.contextReceiverType_.add((Type) r18.readMessage(Type.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L93:
            if ((this.bitField0_ & 16) != 16) goto L95;
            r16 = this.inlineClassUnderlyingType_.toBuilder();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L95:
            Type.Builder r26 = r16;
            Type r113 = (Type) r18.readMessage(Type.PARSER, r19);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.inlineClassUnderlyingType_ = r113;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r26 == 0) goto L98;
            r26.mergeFrom(r113);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.inlineClassUnderlyingType_ = r26.buildPartial();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L98:
            this.bitField0_ |= 16;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L110:
            if ((r12 & 16384) == 16384) goto L112;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 16384;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L112:
            this.sealedSubclassFqName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L114:
            if ((r12 & 8192) == 8192) goto L116;
            this.enumEntry_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 8192;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L116:
            this.enumEntry_.add((EnumEntry) r18.readMessage(EnumEntry.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L118:
            if ((r12 & 4096) == 4096) goto L120;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 4096;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L120:
            this.typeAlias_.add((TypeAlias) r18.readMessage(TypeAlias.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L122:
            if ((r12 & 2048) == 2048) goto L124;
            this.property_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 2048;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L124:
            this.property_.add((Property) r18.readMessage(Property.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L126:
            if ((r12 & 1024) == 1024) goto L128;
            this.function_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 1024;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L128:
            this.function_.add((Function) r18.readMessage(Function.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L130:
            if ((r12 & 512) == 512) goto L132;
            this.constructor_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 512;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L132:
            this.constructor_.add((Constructor) r18.readMessage(Constructor.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L143:
            if ((r12 & 64) == 64) goto L145;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L145:
            this.nestedClassName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L147:
            if ((r12 & 16) == 16) goto L149;
            this.supertype_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 16;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L149:
            this.supertype_.add((Type) r18.readMessage(Type.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L151:
            if ((r12 & 8) == 8) goto L153;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 8;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L153:
            this.typeParameter_.add((TypeParameter) r18.readMessage(TypeParameter.PARSER, r19));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L166:
            if ((r12 & 32) == 32) goto L168;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r12 = r12 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L168:
            this.supertypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L10
        L11:
            th = move-exception;
            if ((r12 & 32) != 32) goto L181;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L181:
            if ((r12 & 8) != 8) goto L184;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L184:
            if ((r12 & 16) != 16) goto L187;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L187:
            if ((r12 & 64) != 64) goto L190;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L190:
            if ((r12 & 512) != 512) goto L193;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L193:
            if ((r12 & 1024) != 1024) goto L196;
            this.function_ = Collections.unmodifiableList(this.function_);
        L196:
            if ((r12 & 2048) != 2048) goto L199;
            this.property_ = Collections.unmodifiableList(this.property_);
        L199:
            if ((r12 & 4096) != 4096) goto L202;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L202:
            if ((r12 & 8192) != 8192) goto L205;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L205:
            if ((r12 & 16384) != 16384) goto L208;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L208:
            if ((r12 & 128) != 128) goto L211;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L211:
            if ((r12 & 256) != 256) goto L214;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L214:
            if ((r12 & 262144) != 262144) goto L217;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L217:
            if ((r12 & 524288) != 524288) goto L220;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L220:
            if ((r12 & 1048576) != 1048576) goto L223;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L223:
            if ((r12 & 4194304) != 4194304) goto L290;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L290:
            r10.flush();     // Catch: IOException -> L288 Throwable -> L227
        L227:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L226:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L15:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L13:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L233:
            if ((r12 & 32) != 32) goto L236;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L236:
            if ((r12 & 8) != 8) goto L239;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L239:
            if ((r12 & 16) != 16) goto L242;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L242:
            if ((r12 & 64) != 64) goto L245;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L245:
            if ((r12 & 512) != 512) goto L248;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L248:
            if ((r12 & 1024) != 1024) goto L251;
            this.function_ = Collections.unmodifiableList(this.function_);
        L251:
            if ((r12 & 2048) != 2048) goto L254;
            this.property_ = Collections.unmodifiableList(this.property_);
        L254:
            if ((r12 & 4096) != 4096) goto L257;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L257:
            if ((r12 & 8192) != 8192) goto L260;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L260:
            if ((r12 & 16384) != 16384) goto L263;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L263:
            if ((r12 & 128) != 128) goto L266;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L266:
            if ((r12 & 256) != 256) goto L269;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L269:
            if ((r12 & 262144) != 262144) goto L272;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L272:
            if ((r12 & 524288) != 524288) goto L275;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L275:
            if ((r12 & 1048576) != 1048576) goto L278;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L278:
            if ((r12 & 4194304) != 4194304) goto L292;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L292:
            r10.flush();     // Catch: IOException -> L287 Throwable -> L282
        L282:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L281:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> PARSER;
        private static final Constructor defaultInstance = null;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_;
            private List<ValueParameter> valueParameter_;
            private List<Integer> versionRequirement_;

            private Builder() {
                this.flags_ = 6;
                this.valueParameter_ = Collections.emptyList();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$13300() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 2;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Constructor buildPartial() {
                Constructor r5 = new Constructor(this, null);
                int r10 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r10 = 0;
            L6:
                Constructor.access$13502(r5, this.flags_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -3;
            L9:
                Constructor.access$13602(r5, this.valueParameter_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -5;
            L12:
                Constructor.access$13702(r5, this.versionRequirement_);
                Constructor.access$13802(r5, r10);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public ValueParameter getValueParameter(int r5) {
                return this.valueParameter_.get(r5);
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getValueParameterCount()) goto L10;
                if (getValueParameter(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (extensionsAreInitialized() == true) goto L12;
                return false;
            L12:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 1;
                this.flags_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Constructor build() {
                Constructor r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Constructor) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(Constructor r5) {
                if (r5 != Constructor.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasFlags() == false) goto L9;
                setFlags(r5.getFlags());
            L9:
                if (Constructor.access$13600(r5).isEmpty() == true) goto L15;
                if (this.valueParameter_.isEmpty() == false) goto L13;
                this.valueParameter_ = Constructor.access$13600(r5);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Constructor.access$13600(r5));
            L15:
                if (Constructor.access$13700(r5).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(Constructor.access$13900(r5)));
                return this;
            L17:
                if (this.versionRequirement_.isEmpty() == false) goto L19;
                this.versionRequirement_ = Constructor.access$13700(r5);
                this.bitField0_ &= -5;
                goto L20
            L19:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Constructor.access$13700(r5));
                goto L20
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Constructor r11 = null;
                Constructor r12 = Constructor.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Constructor r13 = (Constructor) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Constructor r5 = new Constructor(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Constructor(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$13502(Constructor r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$13600(Constructor r5) {
            return r5.valueParameter_;
        }

        public static /* synthetic */ List access$13602(Constructor r5, List r10) {
            r5.valueParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$13700(Constructor r5) {
            return r5.versionRequirement_;
        }

        public static /* synthetic */ List access$13702(Constructor r5, List r10) {
            r5.versionRequirement_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$13802(Constructor r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$13900(Constructor r5) {
            return r5.unknownFields;
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$13300();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.flags_);
        L9:
            int r12 = 0;
        L11:
            if (r12 >= this.valueParameter_.size()) goto L13;
            r11 = r11 + CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(r12));
            r12 = r12 + 1;
            goto L11
        L13:
            int r13 = 0;
        L15:
            if (r10 >= this.versionRequirement_.size()) goto L17;
            r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r10).intValue());
            r10 = r10 + 1;
            goto L15
        L17:
            int r14 = this.unknownFields.size() + (extensionsSerializedSize() + ((getVersionRequirementList().size() * 2) + (r11 + r13)));
            this.memoizedSerializedSize = r14;
            return r14;
        L8:
            r11 = 0;
            goto L9
        }

        public ValueParameter getValueParameter(int r5) {
            return this.valueParameter_.get(r5);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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
            if (r10 >= getValueParameterCount()) goto L17;
            if (getValueParameter(r10).isInitialized() == false) goto L13;
            r10 = r10 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (extensionsAreInitialized() == true) goto L20;
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r10.writeInt32(1, this.flags_);
        L5:
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r12 >= this.valueParameter_.size()) goto L10;
            r10.writeMessage(2, this.valueParameter_.get(r12));
            r12 = r12 + 1;
        L10:
            if (r11 >= this.versionRequirement_.size()) goto L12;
            r10.writeInt32(31, this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L10
        L12:
            r5.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Constructor(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Constructor r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Constructor(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Constructor(CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            int r14 = 0;
        L4:
            if (r13 == true) goto L61;
            int r15 = r11.readTag();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r15 == 0) goto L17;
            if (r15 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.flags_ = r11.readInt32();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L10:
            if (r15 != 18) goto L12;
            if ((r14 & 2) == 2) goto L40;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r14 = r14 | 2;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L40:
            this.valueParameter_.add((ValueParameter) r11.readMessage(ValueParameter.PARSER, r12));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L12:
            if (r15 != 248) goto L14;
            if ((r14 & 4) == 4) goto L36;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r14 = r14 | 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L36:
            this.versionRequirement_.add(Integer.valueOf(r11.readInt32()));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L14:
            if (r15 != 250) goto L16;
            int r16 = r11.pushLimit(r11.readRawVarint32());     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if ((r14 & 4) == 4) goto L30;
            if (r11.getBytesUntilLimit() <= 0) goto L30;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r14 = r14 | 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L30:
            if (r11.getBytesUntilLimit() <= 0) goto L32;
            this.versionRequirement_.add(Integer.valueOf(r11.readInt32()));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L30
        L32:
            r11.popLimit(r16);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L16:
            if (parseUnknownField(r11, r10, r12, r15) == true) goto L4;
        L17:
            r13 = true;
            goto L4
        L18:
            th = move-exception;
            if ((r14 & 2) != 2) goto L51;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L51:
            if ((r14 & 4) != 4) goto L77;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L77:
            r10.flush();     // Catch: IOException -> L74 Throwable -> L55
        L55:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L54:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L18
        L20:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L18
        L61:
            if ((r14 & 2) != 2) goto L64;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L64:
            if ((r14 & 4) != 4) goto L79;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L79:
            r10.flush();     // Catch: IOException -> L73 Throwable -> L68
        L68:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L67:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static Parser<Contract> PARSER;
        private static final Contract defaultInstance = null;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_;

            private Builder() {
                this.effect_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$23500() {
                return create();
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

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Contract buildPartial() {
                Contract r5 = new Contract(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.effect_ = Collections.unmodifiableList(this.effect_);
                this.bitField0_ &= -2;
            L5:
                Contract.access$23702(r5, this.effect_);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Effect getEffect(int r5) {
                return this.effect_.get(r5);
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getEffectCount()) goto L9;
                if (getEffect(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Contract build() {
                Contract r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Contract) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Contract r5) {
                if (r5 != Contract.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Contract.access$23700(r5).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(Contract.access$23800(r5)));
                return this;
            L8:
                if (this.effect_.isEmpty() == false) goto L10;
                this.effect_ = Contract.access$23700(r5);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureEffectIsMutable();
                this.effect_.addAll(Contract.access$23700(r5));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Contract r11 = null;
                Contract r12 = Contract.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Contract r13 = (Contract) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Contract r5 = new Contract(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Contract(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$23700(Contract r5) {
            return r5.effect_;
        }

        public static /* synthetic */ List access$23702(Contract r5, List r10) {
            r5.effect_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$23800(Contract r5) {
            return r5.unknownFields;
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
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

        public Effect getEffect(int r5) {
            return this.effect_.get(r5);
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r10 >= this.effect_.size()) goto L9;
            r11 = r11 + CodedOutputStream.computeMessageSize(1, this.effect_.get(r10));
            r10 = r10 + 1;
            goto L7
        L9:
            int r12 = this.unknownFields.size() + r11;
            this.memoizedSerializedSize = r12;
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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
            if (r10 >= getEffectCount()) goto L16;
            if (getEffect(r10).isInitialized() == false) goto L13;
            r10 = r10 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            int r10 = 0;
        L4:
            if (r10 >= this.effect_.size()) goto L6;
            r5.writeMessage(1, this.effect_.get(r10));
            r10 = r10 + 1;
            goto L4
        L6:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Contract(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Contract r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Contract(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Contract(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Contract(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            boolean r14 = false;
        L3:
            if (r13 == true) goto L34;
            int r15 = r10.readTag();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r15 == 0) goto L10;
            if (r15 != 10) goto L9;
            if (r14 == true) goto L19;
            this.effect_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r14 = true;
        L19:
            this.effect_.add((Effect) r10.readMessage(Effect.PARSER, r11));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L3
        L9:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L3;
        L10:
            r13 = true;
            goto L3
        L11:
            th = move-exception;
            if (r14 != true) goto L47;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L47:
            r12.flush();     // Catch: IOException -> L44 Throwable -> L29
        L29:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L28:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L15:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L13:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L34:
            if (r14 != true) goto L49;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L49:
            r12.flush();     // Catch: IOException -> L43 Throwable -> L38
        L38:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L37:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ContractOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static Parser<Effect> PARSER;
        private static final Effect defaultInstance = null;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            private int bitField0_;
            private Expression conclusionOfConditionalEffect_;
            private List<Expression> effectConstructorArgument_;
            private EffectType effectType_;
            private InvocationKind kind_;

            private Builder() {
                this.effectType_ = EffectType.RETURNS_CONSTANT;
                this.effectConstructorArgument_ = Collections.emptyList();
                this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
                this.kind_ = InvocationKind.AT_MOST_ONCE;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$24000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                this.bitField0_ |= 2;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Effect buildPartial() {
                Effect r5 = new Effect(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                Effect.access$24202(r5, this.effectType_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                this.bitField0_ &= -3;
            L9:
                Effect.access$24302(r5, this.effectConstructorArgument_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 2;
            L12:
                Effect.access$24402(r5, this.conclusionOfConditionalEffect_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 4;
            L15:
                Effect.access$24502(r5, this.kind_);
                Effect.access$24602(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Expression getEffectConstructorArgument(int r5) {
                return this.effectConstructorArgument_.get(r5);
            }

            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            public boolean hasConclusionOfConditionalEffect() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getEffectConstructorArgumentCount()) goto L10;
                if (getEffectConstructorArgument(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (hasConclusionOfConditionalEffect() == true) goto L12;
                return true;
            L12:
                if (getConclusionOfConditionalEffect().isInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            public Builder mergeConclusionOfConditionalEffect(Expression r5) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.conclusionOfConditionalEffect_ = r5;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.conclusionOfConditionalEffect_ == Expression.getDefaultInstance()) goto L7;
                this.conclusionOfConditionalEffect_ = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setEffectType(EffectType r5) {
                r5.getClass();
                this.bitField0_ |= 1;
                this.effectType_ = r5;
                return this;
            }

            public Builder setKind(InvocationKind r5) {
                r5.getClass();
                this.bitField0_ |= 8;
                this.kind_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Effect build() {
                Effect r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Effect) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Effect r5) {
                if (r5 != Effect.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasEffectType() == false) goto L9;
                setEffectType(r5.getEffectType());
            L9:
                if (Effect.access$24300(r5).isEmpty() == true) goto L15;
                if (this.effectConstructorArgument_.isEmpty() == false) goto L13;
                this.effectConstructorArgument_ = Effect.access$24300(r5);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.addAll(Effect.access$24300(r5));
            L15:
                if (r5.hasConclusionOfConditionalEffect() == false) goto L18;
                mergeConclusionOfConditionalEffect(r5.getConclusionOfConditionalEffect());
            L18:
                if (r5.hasKind() == false) goto L20;
                setKind(r5.getKind());
            L20:
                setUnknownFields(getUnknownFields().concat(Effect.access$24700(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Effect r11 = null;
                Effect r12 = Effect.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Effect r13 = (Effect) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        public static final enum EffectType extends Enum<EffectType> implements Internal.EnumLite {
            private static final /* synthetic */ EffectType[] $VALUES = null;
            public static final EffectType CALLS = null;
            public static final EffectType RETURNS_CONSTANT = null;
            public static final EffectType RETURNS_NOT_NULL = null;
            private static Internal.EnumLiteMap<EffectType> internalValueMap;
            private final int value;

            static {
                EffectType r5 = new EffectType("RETURNS_CONSTANT", 0, 0, 0);
                RETURNS_CONSTANT = r5;
                EffectType r10 = new EffectType("CALLS", 1, 1, 1);
                CALLS = r10;
                EffectType r11 = new EffectType("RETURNS_NOT_NULL", 2, 2, 2);
                RETURNS_NOT_NULL = r11;
                $VALUES = new EffectType[]{r5, r10, r11};
                internalValueMap = new AnonymousClass1();
            }

            private EffectType(String r5, int r10, int r11, int r12) {
                super(r5, r10);
                this.value = r12;
            }

            public static EffectType valueOf(String r5) {
                return (EffectType) Enum.valueOf(EffectType.class, r5);
            }

            public static EffectType[] values() {
                return (EffectType[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
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

        public static final enum InvocationKind extends Enum<InvocationKind> implements Internal.EnumLite {
            private static final /* synthetic */ InvocationKind[] $VALUES = null;
            public static final InvocationKind AT_LEAST_ONCE = null;
            public static final InvocationKind AT_MOST_ONCE = null;
            public static final InvocationKind EXACTLY_ONCE = null;
            private static Internal.EnumLiteMap<InvocationKind> internalValueMap;
            private final int value;

            static {
                InvocationKind r5 = new InvocationKind("AT_MOST_ONCE", 0, 0, 0);
                AT_MOST_ONCE = r5;
                InvocationKind r10 = new InvocationKind("EXACTLY_ONCE", 1, 1, 1);
                EXACTLY_ONCE = r10;
                InvocationKind r11 = new InvocationKind("AT_LEAST_ONCE", 2, 2, 2);
                AT_LEAST_ONCE = r11;
                $VALUES = new InvocationKind[]{r5, r10, r11};
                internalValueMap = new AnonymousClass1();
            }

            private InvocationKind(String r5, int r10, int r11, int r12) {
                super(r5, r10);
                this.value = r12;
            }

            public static InvocationKind valueOf(String r5) {
                return (InvocationKind) Enum.valueOf(InvocationKind.class, r5);
            }

            public static InvocationKind[] values() {
                return (InvocationKind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
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
            PARSER = new AnonymousClass1();
            Effect r5 = new Effect(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Effect(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ EffectType access$24202(Effect r5, EffectType r10) {
            r5.effectType_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$24300(Effect r5) {
            return r5.effectConstructorArgument_;
        }

        public static /* synthetic */ List access$24302(Effect r5, List r10) {
            r5.effectConstructorArgument_ = r10;
            return r10;
        }

        public static /* synthetic */ Expression access$24402(Effect r5, Expression r10) {
            r5.conclusionOfConditionalEffect_ = r10;
            return r10;
        }

        public static /* synthetic */ InvocationKind access$24502(Effect r5, InvocationKind r10) {
            r5.kind_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$24602(Effect r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$24700(Effect r5) {
            return r5.unknownFields;
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public static Builder newBuilder() {
            return Builder.access$24000();
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Expression getEffectConstructorArgument(int r5) {
            return this.effectConstructorArgument_.get(r5);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber());
        L10:
            if (r10 >= this.effectConstructorArgument_.size()) goto L13;
            r11 = r11 + CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(r10));
            r10 = r10 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r11 = r11 + CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r11 = r11 + CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r5.writeEnum(1, this.effectType_.getNumber());
        L5:
            int r10 = 0;
        L7:
            if (r10 >= this.effectConstructorArgument_.size()) goto L10;
            r5.writeMessage(2, this.effectConstructorArgument_.get(r10));
            r10 = r10 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r5.writeMessage(3, this.conclusionOfConditionalEffect_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r5.writeEnum(4, this.kind_.getNumber());
        L15:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Effect(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Effect r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Effect(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Effect(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Effect(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            char r14 = 0;
        L4:
            if (r13 == true) goto L60;
            int r15 = r10.readTag();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r15 == 0) goto L17;
            if (r15 != 8) goto L10;
            int r16 = r10.readEnum();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            EffectType r17 = EffectType.valueOf(r16);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r17 == null) goto L42;
            this.bitField0_ |= 1;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.effectType_ = r17;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L42:
            r12.writeRawVarint32(r15);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r12.writeRawVarint32(r16);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L10:
            if (r15 != 18) goto L12;
            if ((r14 & 2) == 2) goto L39;
            this.effectConstructorArgument_ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r14 = 2;
        L39:
            this.effectConstructorArgument_.add((Expression) r10.readMessage(Expression.PARSER, r11));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L12:
            if (r15 != 26) goto L14;
            if ((this.bitField0_ & 2) != 2) goto L31;
            Expression.Builder r18 = this.conclusionOfConditionalEffect_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L32:
            Expression r19 = (Expression) r10.readMessage(Expression.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.conclusionOfConditionalEffect_ = r19;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r18 == null) goto L35;
            r18.mergeFrom(r19);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.conclusionOfConditionalEffect_ = r18.buildPartial();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L35:
            this.bitField0_ |= 2;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L31:
            r18 = null;
            goto L32
        L14:
            if (r15 != 32) goto L16;
            int r20 = r10.readEnum();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            InvocationKind r21 = InvocationKind.valueOf(r20);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r21 == null) goto L26;
            this.bitField0_ |= 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.kind_ = r21;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L26:
            r12.writeRawVarint32(r15);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r12.writeRawVarint32(r20);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L16:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L4;
        L17:
            r13 = true;
            goto L4
        L18:
            th = move-exception;
            if ((r14 & 2) != 2) goto L75;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L75:
            r12.flush();     // Catch: IOException -> L70 Throwable -> L54
        L54:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L53:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L18
        L20:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L18
        L60:
            if ((r14 & 2) != 2) goto L72;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L72:
            r12.flush();     // Catch: IOException -> L69 Throwable -> L64
        L64:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L63:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface EffectOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> PARSER;
        private static final EnumEntry defaultInstance = null;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$20400() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public EnumEntry buildPartial() {
                EnumEntry r5 = new EnumEntry(this, null);
                int r10 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r10 = 0;
            L6:
                EnumEntry.access$20602(r5, this.name_);
                EnumEntry.access$20702(r5, r10);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (extensionsAreInitialized() == true) goto L6;
                return false;
            L6:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 1;
                this.name_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public EnumEntry build() {
                EnumEntry r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((EnumEntry) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(EnumEntry r5) {
                if (r5 != EnumEntry.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasName() == false) goto L8;
                setName(r5.getName());
            L8:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(EnumEntry.access$20800(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                EnumEntry r11 = null;
                EnumEntry r12 = EnumEntry.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                EnumEntry r13 = (EnumEntry) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            EnumEntry r5 = new EnumEntry(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ EnumEntry(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$20602(EnumEntry r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$20702(EnumEntry r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$20800(EnumEntry r5) {
            return r5.unknownFields;
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$20400();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = CodedOutputStream.computeInt32Size(1, this.name_);
        L9:
            int r11 = extensionsSerializedSize() + r10;
            int r12 = this.unknownFields.size() + r11;
            this.memoizedSerializedSize = r12;
            return r12;
        L8:
            r10 = 0;
            goto L9
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (extensionsAreInitialized() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r10 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r5.writeInt32(1, this.name_);
        L5:
            r10.writeUntil(200, r5);
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ EnumEntry(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(EnumEntry r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private EnumEntry(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private EnumEntry(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
        L3:
            if (r13 == true) goto L41;
            int r14 = r10.readTag();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r14 == 0) goto L10;
            if (r14 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.name_ = r10.readInt32();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L3
        L9:
            if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
        L10:
            r13 = true;
            goto L3
        L11:
            th = move-exception;
            r12.flush();     // Catch: IOException -> L37 Throwable -> L25
        L25:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L24:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L15:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L13:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L41:
            r12.flush();     // Catch: IOException -> L38 Throwable -> L32
        L32:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L31:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static Parser<Expression> PARSER;
        private static final Expression defaultInstance = null;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final ByteString unknownFields;
        private int valueParameterReference_;

        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            private List<Expression> andArgument_;
            private int bitField0_;
            private ConstantValue constantValue_;
            private int flags_;
            private int isInstanceTypeId_;
            private Type isInstanceType_;
            private List<Expression> orArgument_;
            private int valueParameterReference_;

            private Builder() {
                this.constantValue_ = ConstantValue.TRUE;
                this.isInstanceType_ = Type.getDefaultInstance();
                this.andArgument_ = Collections.emptyList();
                this.orArgument_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$24900() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.andArgument_ = new ArrayList(this.andArgument_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.orArgument_ = new ArrayList(this.orArgument_);
                this.bitField0_ |= 64;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Expression buildPartial() {
                Expression r5 = new Expression(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                Expression.access$25102(r5, this.flags_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                Expression.access$25202(r5, this.valueParameterReference_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                Expression.access$25302(r5, this.constantValue_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 8;
            L15:
                Expression.access$25402(r5, this.isInstanceType_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 16;
            L18:
                Expression.access$25502(r5, this.isInstanceTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                this.bitField0_ &= -33;
            L21:
                Expression.access$25602(r5, this.andArgument_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                this.bitField0_ &= -65;
            L24:
                Expression.access$25702(r5, this.orArgument_);
                Expression.access$25802(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Expression getAndArgument(int r5) {
                return this.andArgument_.get(r5);
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Expression getOrArgument(int r5) {
                return this.orArgument_.get(r5);
            }

            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            public boolean hasIsInstanceType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasIsInstanceType() == true) goto L5;
            L7:
                int r5 = 0;
            L9:
                if (r5 >= getAndArgumentCount()) goto L14;
                if (getAndArgument(r5).isInitialized() == false) goto L12;
                r5 = r5 + 1;
                goto L9
            L12:
                return false;
            L14:
                int r10 = 0;
            L16:
                if (r10 >= getOrArgumentCount()) goto L21;
                if (getOrArgument(r10).isInitialized() == false) goto L19;
                r10 = r10 + 1;
                goto L16
            L19:
                return false;
            L21:
                return true;
            L5:
                if (getIsInstanceType().isInitialized() == true) goto L7;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeIsInstanceType(Type r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.isInstanceType_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.isInstanceType_ == Type.getDefaultInstance()) goto L7;
                this.isInstanceType_ = Type.newBuilder(this.isInstanceType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder setConstantValue(ConstantValue r5) {
                r5.getClass();
                this.bitField0_ |= 4;
                this.constantValue_ = r5;
                return this;
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 1;
                this.flags_ = r5;
                return this;
            }

            public Builder setIsInstanceTypeId(int r5) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = r5;
                return this;
            }

            public Builder setValueParameterReference(int r5) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Expression build() {
                Expression r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Expression) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(Expression r5) {
                if (r5 != Expression.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasFlags() == false) goto L9;
                setFlags(r5.getFlags());
            L9:
                if (r5.hasValueParameterReference() == false) goto L12;
                setValueParameterReference(r5.getValueParameterReference());
            L12:
                if (r5.hasConstantValue() == false) goto L15;
                setConstantValue(r5.getConstantValue());
            L15:
                if (r5.hasIsInstanceType() == false) goto L18;
                mergeIsInstanceType(r5.getIsInstanceType());
            L18:
                if (r5.hasIsInstanceTypeId() == false) goto L21;
                setIsInstanceTypeId(r5.getIsInstanceTypeId());
            L21:
                if (Expression.access$25600(r5).isEmpty() == true) goto L27;
                if (this.andArgument_.isEmpty() == false) goto L25;
                this.andArgument_ = Expression.access$25600(r5);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureAndArgumentIsMutable();
                this.andArgument_.addAll(Expression.access$25600(r5));
            L27:
                if (Expression.access$25700(r5).isEmpty() == false) goto L29;
            L32:
                setUnknownFields(getUnknownFields().concat(Expression.access$25900(r5)));
                return this;
            L29:
                if (this.orArgument_.isEmpty() == false) goto L31;
                this.orArgument_ = Expression.access$25700(r5);
                this.bitField0_ &= -65;
                goto L32
            L31:
                ensureOrArgumentIsMutable();
                this.orArgument_.addAll(Expression.access$25700(r5));
                goto L32
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Expression r11 = null;
                Expression r12 = Expression.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Expression r13 = (Expression) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        public static final enum ConstantValue extends Enum<ConstantValue> implements Internal.EnumLite {
            private static final /* synthetic */ ConstantValue[] $VALUES = null;
            public static final ConstantValue FALSE = null;
            public static final ConstantValue NULL = null;
            public static final ConstantValue TRUE = null;
            private static Internal.EnumLiteMap<ConstantValue> internalValueMap;
            private final int value;

            static {
                ConstantValue r5 = new ConstantValue("TRUE", 0, 0, 0);
                TRUE = r5;
                ConstantValue r10 = new ConstantValue("FALSE", 1, 1, 1);
                FALSE = r10;
                ConstantValue r11 = new ConstantValue("NULL", 2, 2, 2);
                NULL = r11;
                $VALUES = new ConstantValue[]{r5, r10, r11};
                internalValueMap = new AnonymousClass1();
            }

            private ConstantValue(String r5, int r10, int r11, int r12) {
                super(r5, r10);
                this.value = r12;
            }

            public static ConstantValue valueOf(String r5) {
                return (ConstantValue) Enum.valueOf(ConstantValue.class, r5);
            }

            public static ConstantValue[] values() {
                return (ConstantValue[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int r5) {
                if (r5 == 0) goto L14;
                if (r5 == 1) goto L12;
                if (r5 == 2) goto L10;
                return null;
            L10:
                return NULL;
            L12:
                return FALSE;
            L14:
                return TRUE;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Expression r5 = new Expression(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Expression(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$25102(Expression r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$25202(Expression r5, int r10) {
            r5.valueParameterReference_ = r10;
            return r10;
        }

        public static /* synthetic */ ConstantValue access$25302(Expression r5, ConstantValue r10) {
            r5.constantValue_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$25402(Expression r5, Type r10) {
            r5.isInstanceType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$25502(Expression r5, int r10) {
            r5.isInstanceTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$25600(Expression r5) {
            return r5.andArgument_;
        }

        public static /* synthetic */ List access$25602(Expression r5, List r10) {
            r5.andArgument_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$25700(Expression r5) {
            return r5.orArgument_;
        }

        public static /* synthetic */ List access$25702(Expression r5, List r10) {
            r5.orArgument_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$25802(Expression r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$25900(Expression r5) {
            return r5.unknownFields;
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$24900();
        }

        public Expression getAndArgument(int r5) {
            return this.andArgument_.get(r5);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getFlags() {
            return this.flags_;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public Expression getOrArgument(int r5) {
            return this.orArgument_.get(r5);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.flags_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r11 = r11 + CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r11 = r11 + CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r11 = r11 + CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        L21:
            int r12 = 0;
        L23:
            if (r12 >= this.andArgument_.size()) goto L26;
            r11 = r11 + CodedOutputStream.computeMessageSize(6, this.andArgument_.get(r12));
            r12 = r12 + 1;
        L26:
            if (r10 >= this.orArgument_.size()) goto L28;
            r11 = r11 + CodedOutputStream.computeMessageSize(7, this.orArgument_.get(r10));
            r10 = r10 + 1;
            goto L26
        L28:
            int r13 = this.unknownFields.size() + r11;
            this.memoizedSerializedSize = r13;
            return r13;
        L8:
            r11 = 0;
            goto L10
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasIsInstanceType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasIsInstanceTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasValueParameterReference() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasIsInstanceType() == true) goto L11;
        L14:
            int r10 = 0;
        L16:
            if (r10 >= getAndArgumentCount()) goto L22;
            if (getAndArgument(r10).isInitialized() == false) goto L19;
            r10 = r10 + 1;
            goto L16
        L19:
            this.memoizedIsInitialized = 0;
            return false;
        L22:
            int r11 = 0;
        L24:
            if (r11 >= getOrArgumentCount()) goto L30;
            if (getOrArgument(r11).isInitialized() == false) goto L27;
            r11 = r11 + 1;
            goto L24
        L27:
            this.memoizedIsInitialized = 0;
            return false;
        L30:
            this.memoizedIsInitialized = 1;
            return true;
        L11:
            if (getIsInstanceType().isInitialized() == true) goto L14;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeInt32(2, this.valueParameterReference_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r5.writeEnum(3, this.constantValue_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r5.writeMessage(4, this.isInstanceType_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r5.writeInt32(5, this.isInstanceTypeId_);
        L17:
            int r10 = 0;
            int r11 = 0;
        L19:
            if (r11 >= this.andArgument_.size()) goto L22;
            r5.writeMessage(6, this.andArgument_.get(r11));
            r11 = r11 + 1;
        L22:
            if (r10 >= this.orArgument_.size()) goto L24;
            r5.writeMessage(7, this.orArgument_.get(r10));
            r10 = r10 + 1;
            goto L22
        L24:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Expression(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Expression r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Expression(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Expression(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Expression(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r11 = false;
            int r14 = 0;
        L4:
            if (r11 == true) goto L72;
            int r15 = r12.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r15 == 0) goto L23;
            if (r15 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.flags_ = r12.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L10:
            if (r15 != 16) goto L12;
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.valueParameterReference_ = r12.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L12:
            if (r15 != 24) goto L14;
            int r16 = r12.readEnum();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            ConstantValue r17 = ConstantValue.valueOf(r16);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r17 == null) goto L49;
            this.bitField0_ |= 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.constantValue_ = r17;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L49:
            r10.writeRawVarint32(r15);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r10.writeRawVarint32(r16);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L14:
            if (r15 != 34) goto L16;
            if ((this.bitField0_ & 8) != 8) goto L42;
            Type.Builder r18 = this.isInstanceType_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L43:
            Type r19 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.isInstanceType_ = r19;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r18 == null) goto L46;
            r18.mergeFrom(r19);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.isInstanceType_ = r18.buildPartial();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L46:
            this.bitField0_ |= 8;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L42:
            r18 = null;
            goto L43
        L16:
            if (r15 != 40) goto L18;
            this.bitField0_ |= 16;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.isInstanceTypeId_ = r12.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L18:
            if (r15 != 50) goto L20;
            if ((r14 & 32) == 32) goto L37;
            this.andArgument_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r14 = r14 | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L37:
            this.andArgument_.add((Expression) r12.readMessage(PARSER, r13));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L20:
            if (r15 != 58) goto L22;
            if ((r14 & 64) == 64) goto L33;
            this.orArgument_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r14 = r14 | 64;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L33:
            this.orArgument_.add((Expression) r12.readMessage(PARSER, r13));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L22:
            if (parseUnknownField(r12, r10, r13, r15) == true) goto L4;
        L23:
            r11 = true;
            goto L4
        L24:
            th = move-exception;
            if ((r14 & 32) != 32) goto L62;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L62:
            if ((r14 & 64) != 64) goto L90;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L90:
            r10.flush();     // Catch: IOException -> L85 Throwable -> L66
        L66:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L65:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L28:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L26:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L72:
            if ((r14 & 32) != 32) goto L75;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L75:
            if ((r14 & 64) != 64) goto L87;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L87:
            r10.flush();     // Catch: IOException -> L84 Throwable -> L79
        L79:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L78:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> PARSER;
        private static final Function defaultInstance = null;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private Contract contract_;
            private int flags_;
            private int name_;
            private int oldFlags_;
            private int receiverTypeId_;
            private Type receiverType_;
            private int returnTypeId_;
            private Type returnType_;
            private List<TypeParameter> typeParameter_;
            private TypeTable typeTable_;
            private List<ValueParameter> valueParameter_;
            private List<Integer> versionRequirement_;

            private Builder() {
                this.flags_ = 6;
                this.oldFlags_ = 6;
                this.returnType_ = Type.getDefaultInstance();
                this.typeParameter_ = Collections.emptyList();
                this.receiverType_ = Type.getDefaultInstance();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.valueParameter_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                this.contract_ = Contract.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$14100() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
                return;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 1024) == 1024) goto L6;
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 1024;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4096) == 4096) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4096;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Function buildPartial() {
                Function r5 = new Function(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                Function.access$14302(r5, this.flags_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                Function.access$14402(r5, this.oldFlags_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                Function.access$14502(r5, this.name_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 8;
            L15:
                Function.access$14602(r5, this.returnType_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 16;
            L18:
                Function.access$14702(r5, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Function.access$14802(r5, this.typeParameter_);
                if ((r10 & 64) != 64) goto L24;
                r11 = r11 | 32;
            L24:
                Function.access$14902(r5, this.receiverType_);
                if ((r10 & 128) != 128) goto L27;
                r11 = r11 | 64;
            L27:
                Function.access$15002(r5, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Function.access$15102(r5, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -513;
            L33:
                Function.access$15202(r5, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -1025;
            L36:
                Function.access$15302(r5, this.valueParameter_);
                if ((r10 & 2048) != 2048) goto L39;
                r11 = r11 | 128;
            L39:
                Function.access$15402(r5, this.typeTable_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4097;
            L42:
                Function.access$15502(r5, this.versionRequirement_);
                if ((r10 & 8192) != 8192) goto L45;
                r11 = r11 | 256;
            L45:
                Function.access$15602(r5, this.contract_);
                Function.access$15702(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Type getContextReceiverType(int r5) {
                return this.contextReceiverType_.get(r5);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Contract getContract() {
                return this.contract_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public TypeParameter getTypeParameter(int r5) {
                return this.typeParameter_.get(r5);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public ValueParameter getValueParameter(int r5) {
                return this.valueParameter_.get(r5);
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public boolean hasContract() {
                if ((this.bitField0_ & 8192) != 8192) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2048) != 2048) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasReturnType() == true) goto L8;
            L10:
                int r5 = 0;
            L12:
                if (r5 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r5).isInitialized() == false) goto L15;
                r5 = r5 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r10 = 0;
            L24:
                if (r10 >= getContextReceiverTypeCount()) goto L29;
                if (getContextReceiverType(r10).isInitialized() == false) goto L27;
                r10 = r10 + 1;
                goto L24
            L27:
                return false;
            L29:
                int r11 = 0;
            L31:
                if (r11 >= getValueParameterCount()) goto L37;
                if (getValueParameter(r11).isInitialized() == false) goto L34;
                r11 = r11 + 1;
                goto L31
            L34:
                return false;
            L37:
                if (hasTypeTable() == false) goto L42;
                if (getTypeTable().isInitialized() == true) goto L42;
                return false;
            L42:
                if (hasContract() == false) goto L47;
                if (getContract().isInitialized() == true) goto L47;
                return false;
            L47:
                if (extensionsAreInitialized() == true) goto L49;
                return false;
            L49:
                return true;
            L20:
                if (getReceiverType().isInitialized() == true) goto L22;
                return false;
            L8:
                if (getReturnType().isInitialized() == true) goto L10;
                return false;
            }

            public Builder mergeContract(Contract r5) {
                if ((this.bitField0_ & 8192) == 8192) goto L5;
            L7:
                this.contract_ = r5;
            L8:
                this.bitField0_ |= 8192;
                return this;
            L5:
                if (this.contract_ == Contract.getDefaultInstance()) goto L7;
                this.contract_ = Contract.newBuilder(this.contract_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeReceiverType(Type r5) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r5;
            L8:
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeReturnType(Type r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeTypeTable(TypeTable r5) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.typeTable_ = r5;
            L8:
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 1;
                this.flags_ = r5;
                return this;
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 4;
                this.name_ = r5;
                return this;
            }

            public Builder setOldFlags(int r5) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r5;
                return this;
            }

            public Builder setReceiverTypeId(int r5) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r5;
                return this;
            }

            public Builder setReturnTypeId(int r5) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Function build() {
                Function r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Function) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(Function r5) {
                if (r5 != Function.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasFlags() == false) goto L9;
                setFlags(r5.getFlags());
            L9:
                if (r5.hasOldFlags() == false) goto L12;
                setOldFlags(r5.getOldFlags());
            L12:
                if (r5.hasName() == false) goto L15;
                setName(r5.getName());
            L15:
                if (r5.hasReturnType() == false) goto L18;
                mergeReturnType(r5.getReturnType());
            L18:
                if (r5.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r5.getReturnTypeId());
            L21:
                if (Function.access$14800(r5).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Function.access$14800(r5);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Function.access$14800(r5));
            L27:
                if (r5.hasReceiverType() == false) goto L30;
                mergeReceiverType(r5.getReceiverType());
            L30:
                if (r5.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r5.getReceiverTypeId());
            L33:
                if (Function.access$15100(r5).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Function.access$15100(r5);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Function.access$15100(r5));
            L39:
                if (Function.access$15200(r5).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Function.access$15200(r5);
                this.bitField0_ &= -513;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Function.access$15200(r5));
            L45:
                if (Function.access$15300(r5).isEmpty() == true) goto L51;
                if (this.valueParameter_.isEmpty() == false) goto L49;
                this.valueParameter_ = Function.access$15300(r5);
                this.bitField0_ &= -1025;
                goto L51
            L49:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Function.access$15300(r5));
            L51:
                if (r5.hasTypeTable() == false) goto L54;
                mergeTypeTable(r5.getTypeTable());
            L54:
                if (Function.access$15500(r5).isEmpty() == true) goto L60;
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Function.access$15500(r5);
                this.bitField0_ &= -4097;
                goto L60
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Function.access$15500(r5));
            L60:
                if (r5.hasContract() == false) goto L62;
                mergeContract(r5.getContract());
            L62:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(Function.access$15800(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Function r11 = null;
                Function r12 = Function.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Function r13 = (Function) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Function r5 = new Function(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Function(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$14302(Function r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$14402(Function r5, int r10) {
            r5.oldFlags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$14502(Function r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$14602(Function r5, Type r10) {
            r5.returnType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$14702(Function r5, int r10) {
            r5.returnTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$14800(Function r5) {
            return r5.typeParameter_;
        }

        public static /* synthetic */ List access$14802(Function r5, List r10) {
            r5.typeParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$14902(Function r5, Type r10) {
            r5.receiverType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$15002(Function r5, int r10) {
            r5.receiverTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$15100(Function r5) {
            return r5.contextReceiverType_;
        }

        public static /* synthetic */ List access$15102(Function r5, List r10) {
            r5.contextReceiverType_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$15200(Function r5) {
            return r5.contextReceiverTypeId_;
        }

        public static /* synthetic */ List access$15202(Function r5, List r10) {
            r5.contextReceiverTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$15300(Function r5) {
            return r5.valueParameter_;
        }

        public static /* synthetic */ List access$15302(Function r5, List r10) {
            r5.valueParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ TypeTable access$15402(Function r5, TypeTable r10) {
            r5.typeTable_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$15500(Function r5) {
            return r5.versionRequirement_;
        }

        public static /* synthetic */ List access$15502(Function r5, List r10) {
            r5.versionRequirement_ = r10;
            return r10;
        }

        public static /* synthetic */ Contract access$15602(Function r5, Contract r10) {
            r5.contract_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$15702(Function r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$15800(Function r5) {
            return r5.unknownFields;
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$14100();
        }

        public static Function parseFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        public Type getContextReceiverType(int r5) {
            return this.contextReceiverType_.get(r5);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public Contract getContract() {
            return this.contract_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.oldFlags_);
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r11 = r11 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r12 = 0;
        L17:
            if (r12 >= this.typeParameter_.size()) goto L20;
            r11 = r11 + CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(r12));
            r12 = r12 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L22;
            r11 = r11 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L22:
            int r13 = 0;
        L24:
            if (r13 >= this.valueParameter_.size()) goto L27;
            r11 = r11 + CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(r13));
            r13 = r13 + 1;
            goto L24
        L27:
            if ((this.bitField0_ & 16) != 16) goto L30;
            r11 = r11 + CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        L30:
            if ((this.bitField0_ & 64) != 64) goto L33;
            r11 = r11 + CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        L33:
            if ((this.bitField0_ & 1) != 1) goto L35;
            r11 = r11 + CodedOutputStream.computeInt32Size(9, this.flags_);
        L35:
            int r14 = 0;
        L37:
            if (r14 >= this.contextReceiverType_.size()) goto L39;
            r11 = r11 + CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(r14));
            r14 = r14 + 1;
            goto L37
        L39:
            int r15 = 0;
            int r16 = 0;
        L41:
            if (r15 >= this.contextReceiverTypeId_.size()) goto L43;
            r16 = r16 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r15).intValue());
            r15 = r15 + 1;
            goto L41
        L43:
            int r17 = r11 + r16;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L46;
            r17 = (r17 + 1) + CodedOutputStream.computeInt32SizeNoTag(r16);
        L46:
            this.contextReceiverTypeIdMemoizedSerializedSize = r16;
            if ((this.bitField0_ & 128) != 128) goto L49;
            r17 = r17 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L49:
            int r18 = 0;
        L51:
            if (r10 >= this.versionRequirement_.size()) goto L53;
            r18 = r18 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r10).intValue());
            r10 = r10 + 1;
            goto L51
        L53:
            int r19 = (getVersionRequirementList().size() * 2) + (r17 + r18);
            if ((this.bitField0_ & 256) != 256) goto L56;
            r19 = r19 + CodedOutputStream.computeMessageSize(32, this.contract_);
        L56:
            int r20 = this.unknownFields.size() + (extensionsSerializedSize() + r19);
            this.memoizedSerializedSize = r20;
            return r20;
        L8:
            r11 = 0;
            goto L10
        }

        public TypeParameter getTypeParameter(int r5) {
            return this.typeParameter_.get(r5);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public ValueParameter getValueParameter(int r5) {
            return this.valueParameter_.get(r5);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r10 = 0;
        L20:
            if (r10 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r10).isInitialized() == false) goto L23;
            r10 = r10 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r11 = 0;
        L34:
            if (r11 >= getContextReceiverTypeCount()) goto L40;
            if (getContextReceiverType(r11).isInitialized() == false) goto L37;
            r11 = r11 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L40:
            int r12 = 0;
        L42:
            if (r12 >= getValueParameterCount()) goto L49;
            if (getValueParameter(r12).isInitialized() == false) goto L45;
            r12 = r12 + 1;
            goto L42
        L45:
            this.memoizedIsInitialized = 0;
            return false;
        L49:
            if (hasTypeTable() == false) goto L55;
            if (getTypeTable().isInitialized() == true) goto L55;
            this.memoizedIsInitialized = 0;
            return false;
        L55:
            if (hasContract() == false) goto L61;
            if (getContract().isInitialized() == true) goto L61;
            this.memoizedIsInitialized = 0;
            return false;
        L61:
            if (extensionsAreInitialized() == true) goto L64;
            this.memoizedIsInitialized = 0;
            return false;
        L64:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getReceiverType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (getReturnType().isInitialized() == true) goto L18;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r10.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r10.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r10.writeMessage(3, this.returnType_);
        L11:
            int r11 = 0;
            int r12 = 0;
        L13:
            if (r12 >= this.typeParameter_.size()) goto L16;
            r10.writeMessage(4, this.typeParameter_.get(r12));
            r12 = r12 + 1;
            goto L13
        L16:
            if ((this.bitField0_ & 32) != 32) goto L18;
            r10.writeMessage(5, this.receiverType_);
        L18:
            int r13 = 0;
        L20:
            if (r13 >= this.valueParameter_.size()) goto L23;
            r10.writeMessage(6, this.valueParameter_.get(r13));
            r13 = r13 + 1;
            goto L20
        L23:
            if ((this.bitField0_ & 16) != 16) goto L26;
            r10.writeInt32(7, this.returnTypeId_);
        L26:
            if ((this.bitField0_ & 64) != 64) goto L29;
            r10.writeInt32(8, this.receiverTypeId_);
        L29:
            if ((this.bitField0_ & 1) != 1) goto L31;
            r10.writeInt32(9, this.flags_);
        L31:
            int r14 = 0;
        L33:
            if (r14 >= this.contextReceiverType_.size()) goto L36;
            r10.writeMessage(10, this.contextReceiverType_.get(r14));
            r14 = r14 + 1;
            goto L33
        L36:
            if (getContextReceiverTypeIdList().size() <= 0) goto L38;
            r10.writeRawVarint32(90);
            r10.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L38:
            int r15 = 0;
        L40:
            if (r15 >= this.contextReceiverTypeId_.size()) goto L43;
            r10.writeInt32NoTag(this.contextReceiverTypeId_.get(r15).intValue());
            r15 = r15 + 1;
            goto L40
        L43:
            if ((this.bitField0_ & 128) != 128) goto L46;
            r10.writeMessage(30, this.typeTable_);
        L46:
            if (r11 >= this.versionRequirement_.size()) goto L49;
            r10.writeInt32(31, this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L46
        L49:
            if ((this.bitField0_ & 256) != 256) goto L51;
            r10.writeMessage(32, this.contract_);
        L51:
            r5.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Function(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Function r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> r5) {
            super(r5);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Function(boolean r5) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Function(CodedInputStream r14, ExtensionRegistryLite r15) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r11 = false;
            int r12 = 0;
        L4:
            if (r11 == true) goto L115;
            int r13 = r14.readTag();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            Type.Builder r16 = null;
            Contract.Builder r17 = null;
            TypeTable.Builder r18 = null;
            Type.Builder r19 = null;
            switch(r13) {
                case 0: goto L9;
                case 8: goto L86;
                case 16: goto L85;
                case 26: goto L79;
                case 34: goto L74;
                case 42: goto L68;
                case 50: goto L63;
                case 56: goto L62;
                case 64: goto L61;
                case 72: goto L60;
                case 82: goto L56;
                case 88: goto L52;
                case 90: goto L43;
                case 242: goto L37;
                case 248: goto L32;
                case 250: goto L23;
                case 258: goto L17;
                default: goto L8;
            };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L9:
            r11 = true;
            goto L4
        L17:
            if ((this.bitField0_ & 256) != 256) goto L19;
            r17 = this.contract_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L19:
            Contract r110 = (Contract) r14.readMessage(Contract.PARSER, r15);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.contract_ = r110;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r17 == null) goto L22;
            r17.mergeFrom(r110);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.contract_ = r17.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L22:
            this.bitField0_ |= 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L23:
            int r111 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            int r112 = (r12 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r112 == 4096) goto L29;
            r12 = r12;
            if (r14.getBytesUntilLimit() <= 0) goto L29;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L29:
            if (r14.getBytesUntilLimit() <= 0) goto L31;
            this.versionRequirement_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L29
        L31:
            r14.popLimit(r111);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L32:
            int r113 = (r12 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r113 == 4096) goto L35;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L35:
            this.versionRequirement_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L37:
            if ((this.bitField0_ & 128) != 128) goto L39;
            r18 = this.typeTable_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L39:
            TypeTable r114 = (TypeTable) r14.readMessage(TypeTable.PARSER, r15);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.typeTable_ = r114;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r18 == null) goto L42;
            r18.mergeFrom(r114);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.typeTable_ = r18.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L42:
            this.bitField0_ |= 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L43:
            int r115 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            int r116 = (r12 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r116 == 512) goto L49;
            r12 = r12;
            if (r14.getBytesUntilLimit() <= 0) goto L49;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L49:
            if (r14.getBytesUntilLimit() <= 0) goto L51;
            this.contextReceiverTypeId_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L49
        L51:
            r14.popLimit(r115);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L52:
            int r117 = (r12 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r117 == 512) goto L55;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L55:
            this.contextReceiverTypeId_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L56:
            int r118 = (r12 == true ? 1 : 0) & 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r118 == 256) goto L59;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L59:
            this.contextReceiverType_.add((Type) r14.readMessage(Type.PARSER, r15));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L60:
            this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.flags_ = r14.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L61:
            this.bitField0_ |= 64;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.receiverTypeId_ = r14.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L62:
            this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.returnTypeId_ = r14.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L63:
            int r119 = (r12 == true ? 1 : 0) & 1024;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r119 == 1024) goto L66;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 1024;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L66:
            this.valueParameter_.add((ValueParameter) r14.readMessage(ValueParameter.PARSER, r15));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L68:
            if ((this.bitField0_ & 32) != 32) goto L70;
            r19 = this.receiverType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L70:
            Type r120 = (Type) r14.readMessage(Type.PARSER, r15);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.receiverType_ = r120;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r19 == null) goto L73;
            r19.mergeFrom(r120);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.receiverType_ = r19.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L73:
            this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L74:
            int r121 = (r12 == true ? 1 : 0) & 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r121 == 32) goto L77;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L77:
            this.typeParameter_.add((TypeParameter) r14.readMessage(TypeParameter.PARSER, r15));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L79:
            if ((this.bitField0_ & 8) != 8) goto L81;
            r16 = this.returnType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L81:
            Type r122 = (Type) r14.readMessage(Type.PARSER, r15);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.returnType_ = r122;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r16 == null) goto L84;
            r16.mergeFrom(r122);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.returnType_ = r16.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L84:
            this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L85:
            this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.name_ = r14.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L86:
            this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.oldFlags_ = r14.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L8:
            if (parseUnknownField(r14, r10, r15, r13) == true) goto L4;
        L10:
            th = move-exception;
            if (((r12 == true ? 1 : 0) & 32) != 32) goto L96;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L96:
            if (((r12 == true ? 1 : 0) & 1024) != 1024) goto L99;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L99:
            if (((r12 == true ? 1 : 0) & 256) != 256) goto L102;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L102:
            if (((r12 == true ? 1 : 0) & 512) != 512) goto L105;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L105:
            if (((r12 == true ? 1 : 0) & 4096) != 4096) goto L140;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L140:
            r10.flush();     // Catch: IOException -> L137 Throwable -> L109
        L109:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L108:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L14:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
        L12:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
        L115:
            if (((r12 == true ? 1 : 0) & 32) != 32) goto L118;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L118:
            if (((r12 == true ? 1 : 0) & 1024) != 1024) goto L121;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L121:
            if (((r12 == true ? 1 : 0) & 256) != 256) goto L124;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L124:
            if (((r12 == true ? 1 : 0) & 512) != 512) goto L127;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L127:
            if (((r12 == true ? 1 : 0) & 4096) != 4096) goto L142;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L142:
            r10.flush();     // Catch: IOException -> L136 Throwable -> L131
        L131:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L130:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final enum MemberKind extends Enum<MemberKind> implements Internal.EnumLite {
        private static final /* synthetic */ MemberKind[] $VALUES = null;
        public static final MemberKind DECLARATION = null;
        public static final MemberKind DELEGATION = null;
        public static final MemberKind FAKE_OVERRIDE = null;
        public static final MemberKind SYNTHESIZED = null;
        private static Internal.EnumLiteMap<MemberKind> internalValueMap;
        private final int value;

        static {
            MemberKind r5 = new MemberKind("DECLARATION", 0, 0, 0);
            DECLARATION = r5;
            MemberKind r10 = new MemberKind("FAKE_OVERRIDE", 1, 1, 1);
            FAKE_OVERRIDE = r10;
            MemberKind r11 = new MemberKind("DELEGATION", 2, 2, 2);
            DELEGATION = r11;
            MemberKind r12 = new MemberKind("SYNTHESIZED", 3, 3, 3);
            SYNTHESIZED = r12;
            $VALUES = new MemberKind[]{r5, r10, r11, r12};
            internalValueMap = new AnonymousClass1();
        }

        private MemberKind(String r5, int r10, int r11, int r12) {
            super(r5, r10);
            this.value = r12;
        }

        public static MemberKind valueOf(String r5) {
            return (MemberKind) Enum.valueOf(MemberKind.class, r5);
        }

        public static MemberKind[] values() {
            return (MemberKind[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int r5) {
            if (r5 == 0) goto L18;
            if (r5 == 1) goto L16;
            if (r5 == 2) goto L14;
            if (r5 == 3) goto L12;
            return null;
        L12:
            return SYNTHESIZED;
        L14:
            return DELEGATION;
        L16:
            return FAKE_OVERRIDE;
        L18:
            return DECLARATION;
        }
    }

    public static final enum Modality extends Enum<Modality> implements Internal.EnumLite {
        private static final /* synthetic */ Modality[] $VALUES = null;
        public static final Modality ABSTRACT = null;
        public static final Modality FINAL = null;
        public static final Modality OPEN = null;
        public static final Modality SEALED = null;
        private static Internal.EnumLiteMap<Modality> internalValueMap;
        private final int value;

        static {
            Modality r5 = new Modality("FINAL", 0, 0, 0);
            FINAL = r5;
            Modality r10 = new Modality("OPEN", 1, 1, 1);
            OPEN = r10;
            Modality r11 = new Modality("ABSTRACT", 2, 2, 2);
            ABSTRACT = r11;
            Modality r12 = new Modality("SEALED", 3, 3, 3);
            SEALED = r12;
            $VALUES = new Modality[]{r5, r10, r11, r12};
            internalValueMap = new AnonymousClass1();
        }

        private Modality(String r5, int r10, int r11, int r12) {
            super(r5, r10);
            this.value = r12;
        }

        public static Modality valueOf(String r5) {
            return (Modality) Enum.valueOf(Modality.class, r5);
        }

        public static Modality[] values() {
            return (Modality[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int r5) {
            if (r5 == 0) goto L18;
            if (r5 == 1) goto L16;
            if (r5 == 2) goto L14;
            if (r5 == 3) goto L12;
            return null;
        L12:
            return SEALED;
        L14:
            return ABSTRACT;
        L16:
            return OPEN;
        L18:
            return FINAL;
        }
    }

    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> PARSER;
        private static final Package defaultInstance = null;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_;
            private List<Property> property_;
            private List<TypeAlias> typeAlias_;
            private TypeTable typeTable_;
            private VersionRequirementTable versionRequirementTable_;

            private Builder() {
                this.function_ = Collections.emptyList();
                this.property_ = Collections.emptyList();
                this.typeAlias_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$11600() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1;
                return;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2;
                return;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Package buildPartial() {
                Package r5 = new Package(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) != 1) goto L5;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -2;
            L5:
                Package.access$11802(r5, this.function_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -3;
            L8:
                Package.access$11902(r5, this.property_);
                if ((this.bitField0_ & 4) != 4) goto L11;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -5;
            L11:
                Package.access$12002(r5, this.typeAlias_);
                if ((r10 & 8) == 8) goto L15;
                r11 = 0;
            L15:
                Package.access$12102(r5, this.typeTable_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 2;
            L18:
                Package.access$12202(r5, this.versionRequirementTable_);
                Package.access$12302(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Function getFunction(int r5) {
                return this.function_.get(r5);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Property getProperty(int r5) {
                return this.property_.get(r5);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public TypeAlias getTypeAlias(int r5) {
                return this.typeAlias_.get(r5);
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getFunctionCount()) goto L9;
                if (getFunction(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r10 = 0;
            L11:
                if (r10 >= getPropertyCount()) goto L16;
                if (getProperty(r10).isInitialized() == false) goto L14;
                r10 = r10 + 1;
                goto L11
            L14:
                return false;
            L16:
                int r11 = 0;
            L18:
                if (r11 >= getTypeAliasCount()) goto L24;
                if (getTypeAlias(r11).isInitialized() == false) goto L21;
                r11 = r11 + 1;
                goto L18
            L21:
                return false;
            L24:
                if (hasTypeTable() == false) goto L29;
                if (getTypeTable().isInitialized() == true) goto L29;
                return false;
            L29:
                if (extensionsAreInitialized() == true) goto L31;
                return false;
            L31:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeTypeTable(TypeTable r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.typeTable_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r5) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.versionRequirementTable_ = r5;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Package build() {
                Package r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Package) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(Package r5) {
                if (r5 != Package.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Package.access$11800(r5).isEmpty() == true) goto L12;
                if (this.function_.isEmpty() == false) goto L10;
                this.function_ = Package.access$11800(r5);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureFunctionIsMutable();
                this.function_.addAll(Package.access$11800(r5));
            L12:
                if (Package.access$11900(r5).isEmpty() == true) goto L18;
                if (this.property_.isEmpty() == false) goto L16;
                this.property_ = Package.access$11900(r5);
                this.bitField0_ &= -3;
                goto L18
            L16:
                ensurePropertyIsMutable();
                this.property_.addAll(Package.access$11900(r5));
            L18:
                if (Package.access$12000(r5).isEmpty() == true) goto L24;
                if (this.typeAlias_.isEmpty() == false) goto L22;
                this.typeAlias_ = Package.access$12000(r5);
                this.bitField0_ &= -5;
                goto L24
            L22:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Package.access$12000(r5));
            L24:
                if (r5.hasTypeTable() == false) goto L27;
                mergeTypeTable(r5.getTypeTable());
            L27:
                if (r5.hasVersionRequirementTable() == false) goto L29;
                mergeVersionRequirementTable(r5.getVersionRequirementTable());
            L29:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(Package.access$12400(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Package r11 = null;
                Package r12 = Package.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Package r13 = (Package) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Package r5 = new Package(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Package(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$11800(Package r5) {
            return r5.function_;
        }

        public static /* synthetic */ List access$11802(Package r5, List r10) {
            r5.function_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$11900(Package r5) {
            return r5.property_;
        }

        public static /* synthetic */ List access$11902(Package r5, List r10) {
            r5.property_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$12000(Package r5) {
            return r5.typeAlias_;
        }

        public static /* synthetic */ List access$12002(Package r5, List r10) {
            r5.typeAlias_ = r10;
            return r10;
        }

        public static /* synthetic */ TypeTable access$12102(Package r5, TypeTable r10) {
            r5.typeTable_ = r10;
            return r10;
        }

        public static /* synthetic */ VersionRequirementTable access$12202(Package r5, VersionRequirementTable r10) {
            r5.versionRequirementTable_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$12302(Package r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$12400(Package r5) {
            return r5.unknownFields;
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$11600();
        }

        public static Package parseFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Function getFunction(int r5) {
            return this.function_.get(r5);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int r5) {
            return this.property_.get(r5);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.function_.size()) goto L9;
            r12 = r12 + CodedOutputStream.computeMessageSize(3, this.function_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = 0;
        L11:
            if (r13 >= this.property_.size()) goto L14;
            r12 = r12 + CodedOutputStream.computeMessageSize(4, this.property_.get(r13));
            r13 = r13 + 1;
        L14:
            if (r10 >= this.typeAlias_.size()) goto L17;
            r12 = r12 + CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(r10));
            r10 = r10 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 1) != 1) goto L20;
            r12 = r12 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L20:
            if ((this.bitField0_ & 2) != 2) goto L22;
            r12 = r12 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L22:
            int r14 = this.unknownFields.size() + (extensionsSerializedSize() + r12);
            this.memoizedSerializedSize = r14;
            return r14;
        }

        public TypeAlias getTypeAlias(int r5) {
            return this.typeAlias_.get(r5);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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
            if (r10 >= getFunctionCount()) goto L16;
            if (getFunction(r10).isInitialized() == false) goto L13;
            r10 = r10 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r11 = 0;
        L18:
            if (r11 >= getPropertyCount()) goto L24;
            if (getProperty(r11).isInitialized() == false) goto L21;
            r11 = r11 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L24:
            int r12 = 0;
        L26:
            if (r12 >= getTypeAliasCount()) goto L33;
            if (getTypeAlias(r12).isInitialized() == false) goto L29;
            r12 = r12 + 1;
            goto L26
        L29:
            this.memoizedIsInitialized = 0;
            return false;
        L33:
            if (hasTypeTable() == false) goto L39;
            if (getTypeTable().isInitialized() == true) goto L39;
            this.memoizedIsInitialized = 0;
            return false;
        L39:
            if (extensionsAreInitialized() == true) goto L42;
            this.memoizedIsInitialized = 0;
            return false;
        L42:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r12 >= this.function_.size()) goto L6;
            r10.writeMessage(3, this.function_.get(r12));
            r12 = r12 + 1;
            goto L4
        L6:
            int r13 = 0;
        L8:
            if (r13 >= this.property_.size()) goto L11;
            r10.writeMessage(4, this.property_.get(r13));
            r13 = r13 + 1;
        L11:
            if (r11 >= this.typeAlias_.size()) goto L14;
            r10.writeMessage(5, this.typeAlias_.get(r11));
            r11 = r11 + 1;
            goto L11
        L14:
            if ((this.bitField0_ & 1) != 1) goto L17;
            r10.writeMessage(30, this.typeTable_);
        L17:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r10.writeMessage(32, this.versionRequirementTable_);
        L19:
            r5.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Package(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Package r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Package(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Package(CodedInputStream r11, ExtensionRegistryLite r12) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            int r14 = 0;
        L4:
            if (r13 == true) goto L74;
            int r15 = r11.readTag();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            if (r15 == 0) goto L19;
            if (r15 != 26) goto L10;
            int r16 = (r14 == true ? 1 : 0) & 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            r14 = r14;
            if (r16 == 1) goto L51;
            this.function_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            r14 = (r14 == true ? 1 : 0) | 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        L51:
            this.function_.add((Function) r11.readMessage(Function.PARSER, r12));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L10:
            if (r15 != 34) goto L12;
            int r17 = (r14 == true ? 1 : 0) & 2;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            r14 = r14;
            if (r17 == 2) goto L47;
            this.property_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            r14 = (r14 == true ? 1 : 0) | 2;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        L47:
            this.property_.add((Property) r11.readMessage(Property.PARSER, r12));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L12:
            if (r15 != 42) goto L13;
            int r18 = (r14 == true ? 1 : 0) & 4;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            r14 = r14;
            if (r18 == 4) goto L43;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            r14 = (r14 == true ? 1 : 0) | 4;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        L43:
            this.typeAlias_.add((TypeAlias) r11.readMessage(TypeAlias.PARSER, r12));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L13:
            VersionRequirementTable.Builder r19 = null;
            TypeTable.Builder r20 = null;
            if (r15 != 242) goto L16;
            if ((this.bitField0_ & 1) != 1) goto L36;
            r20 = this.typeTable_.toBuilder();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        L36:
            TypeTable r21 = (TypeTable) r11.readMessage(TypeTable.PARSER, r12);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            this.typeTable_ = r21;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            if (r20 == null) goto L39;
            r20.mergeFrom(r21);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            this.typeTable_ = r20.buildPartial();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        L39:
            this.bitField0_ |= 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L16:
            if (r15 != 258) goto L18;
            if ((this.bitField0_ & 2) != 2) goto L29;
            r19 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        L29:
            VersionRequirementTable r22 = (VersionRequirementTable) r11.readMessage(VersionRequirementTable.PARSER, r12);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            this.versionRequirementTable_ = r22;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            if (r19 == null) goto L32;
            r19.mergeFrom(r22);     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            this.versionRequirementTable_ = r19.buildPartial();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
        L32:
            this.bitField0_ |= 2;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L24
            goto L4
        L18:
            if (parseUnknownField(r11, r10, r12, r15) == true) goto L4;
        L19:
            r13 = true;
            goto L4
        L20:
            th = move-exception;
            if (((r14 == true ? 1 : 0) & 1) != 1) goto L61;
            this.function_ = Collections.unmodifiableList(this.function_);
        L61:
            if (((r14 == true ? 1 : 0) & 2) != 2) goto L64;
            this.property_ = Collections.unmodifiableList(this.property_);
        L64:
            if (((r14 == true ? 1 : 0) & 4) != 4) goto L92;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L92:
            r10.flush();     // Catch: IOException -> L90 Throwable -> L68
        L68:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L67:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L24:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L22:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L74:
            if (((r14 == true ? 1 : 0) & 1) != 1) goto L77;
            this.function_ = Collections.unmodifiableList(this.function_);
        L77:
            if (((r14 == true ? 1 : 0) & 2) != 2) goto L80;
            this.property_ = Collections.unmodifiableList(this.property_);
        L80:
            if (((r14 == true ? 1 : 0) & 4) != 4) goto L95;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L95:
            r10.flush();     // Catch: IOException -> L89 Throwable -> L84
        L84:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L83:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static Parser<PackageFragment> PARSER;
        private static final PackageFragment defaultInstance = null;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            private int bitField0_;
            private List<Class> class__;
            private Package package_;
            private QualifiedNameTable qualifiedNames_;
            private StringTable strings_;

            private Builder() {
                this.strings_ = StringTable.getDefaultInstance();
                this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
                this.package_ = Package.getDefaultInstance();
                this.class__ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$22600() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.class__ = new ArrayList(this.class__);
                this.bitField0_ |= 8;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public PackageFragment buildPartial() {
                PackageFragment r5 = new PackageFragment(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                PackageFragment.access$22802(r5, this.strings_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                PackageFragment.access$22902(r5, this.qualifiedNames_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                PackageFragment.access$23002(r5, this.package_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.class__ = Collections.unmodifiableList(this.class__);
                this.bitField0_ &= -9;
            L15:
                PackageFragment.access$23102(r5, this.class__);
                PackageFragment.access$23202(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Class getClass_(int r5) {
                return this.class__.get(r5);
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Package getPackage() {
                return this.package_;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            public boolean hasPackage() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasQualifiedNames() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasQualifiedNames() == false) goto L8;
                if (getQualifiedNames().isInitialized() == true) goto L8;
                return false;
            L8:
                if (hasPackage() == true) goto L10;
            L12:
                int r5 = 0;
            L14:
                if (r5 >= getClass_Count()) goto L20;
                if (getClass_(r5).isInitialized() == false) goto L17;
                r5 = r5 + 1;
                goto L14
            L17:
                return false;
            L20:
                if (extensionsAreInitialized() == true) goto L22;
                return false;
            L22:
                return true;
            L10:
                if (getPackage().isInitialized() == true) goto L12;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergePackage(Package r5) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.package_ = r5;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.package_ == Package.getDefaultInstance()) goto L7;
                this.package_ = Package.newBuilder(this.package_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeQualifiedNames(QualifiedNameTable r5) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.qualifiedNames_ = r5;
            L8:
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.qualifiedNames_ == QualifiedNameTable.getDefaultInstance()) goto L7;
                this.qualifiedNames_ = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeStrings(StringTable r5) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.strings_ = r5;
            L8:
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.strings_ == StringTable.getDefaultInstance()) goto L7;
                this.strings_ = StringTable.newBuilder(this.strings_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public PackageFragment build() {
                PackageFragment r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((PackageFragment) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(PackageFragment r5) {
                if (r5 != PackageFragment.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasStrings() == false) goto L9;
                mergeStrings(r5.getStrings());
            L9:
                if (r5.hasQualifiedNames() == false) goto L12;
                mergeQualifiedNames(r5.getQualifiedNames());
            L12:
                if (r5.hasPackage() == false) goto L15;
                mergePackage(r5.getPackage());
            L15:
                if (PackageFragment.access$23100(r5).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(PackageFragment.access$23300(r5)));
                return this;
            L17:
                if (this.class__.isEmpty() == false) goto L19;
                this.class__ = PackageFragment.access$23100(r5);
                this.bitField0_ &= -9;
                goto L20
            L19:
                ensureClass_IsMutable();
                this.class__.addAll(PackageFragment.access$23100(r5));
                goto L20
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                PackageFragment r11 = null;
                PackageFragment r12 = PackageFragment.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                PackageFragment r13 = (PackageFragment) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            PackageFragment r5 = new PackageFragment(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ PackageFragment(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ StringTable access$22802(PackageFragment r5, StringTable r10) {
            r5.strings_ = r10;
            return r10;
        }

        public static /* synthetic */ QualifiedNameTable access$22902(PackageFragment r5, QualifiedNameTable r10) {
            r5.qualifiedNames_ = r10;
            return r10;
        }

        public static /* synthetic */ Package access$23002(PackageFragment r5, Package r10) {
            r5.package_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$23100(PackageFragment r5) {
            return r5.class__;
        }

        public static /* synthetic */ List access$23102(PackageFragment r5, List r10) {
            r5.class__ = r10;
            return r10;
        }

        public static /* synthetic */ int access$23202(PackageFragment r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$23300(PackageFragment r5) {
            return r5.unknownFields;
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$22600();
        }

        public static PackageFragment parseFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        public Class getClass_(int r5) {
            return this.class__.get(r5);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Package getPackage() {
            return this.package_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeMessageSize(1, this.strings_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r11 = r11 + CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r11 = r11 + CodedOutputStream.computeMessageSize(3, this.package_);
        L16:
            if (r10 >= this.class__.size()) goto L18;
            r11 = r11 + CodedOutputStream.computeMessageSize(4, this.class__.get(r10));
            r10 = r10 + 1;
            goto L16
        L18:
            int r12 = this.unknownFields.size() + (extensionsSerializedSize() + r11);
            this.memoizedSerializedSize = r12;
            return r12;
        L8:
            r11 = 0;
            goto L10
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasPackage() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasQualifiedNames() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasStrings() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasQualifiedNames() == false) goto L15;
            if (getQualifiedNames().isInitialized() == true) goto L15;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (hasPackage() == true) goto L17;
        L20:
            int r10 = 0;
        L22:
            if (r10 >= getClass_Count()) goto L29;
            if (getClass_(r10).isInitialized() == false) goto L25;
            r10 = r10 + 1;
            goto L22
        L25:
            this.memoizedIsInitialized = 0;
            return false;
        L29:
            if (extensionsAreInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L32:
            this.memoizedIsInitialized = 1;
            return true;
        L17:
            if (getPackage().isInitialized() == true) goto L20;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r10 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeMessage(1, this.strings_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeMessage(2, this.qualifiedNames_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r5.writeMessage(3, this.package_);
        L11:
            int r11 = 0;
        L13:
            if (r11 >= this.class__.size()) goto L15;
            r5.writeMessage(4, this.class__.get(r11));
            r11 = r11 + 1;
            goto L13
        L15:
            r10.writeUntil(200, r5);
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ PackageFragment(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(PackageFragment r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private PackageFragment(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private PackageFragment(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            char r14 = 0;
        L4:
            if (r13 == true) goto L65;
            int r15 = r10.readTag();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r15 == 0) goto L17;
            Package.Builder r16 = null;
            StringTable.Builder r17 = null;
            QualifiedNameTable.Builder r18 = null;
            if (r15 != 10) goto L10;
            if ((this.bitField0_ & 1) != 1) goto L45;
            r17 = this.strings_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L45:
            StringTable r19 = (StringTable) r10.readMessage(StringTable.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.strings_ = r19;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r17 == null) goto L48;
            r17.mergeFrom(r19);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.strings_ = r17.buildPartial();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L48:
            this.bitField0_ |= 1;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L10:
            if (r15 != 18) goto L12;
            if ((this.bitField0_ & 2) != 2) goto L38;
            r18 = this.qualifiedNames_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L38:
            QualifiedNameTable r20 = (QualifiedNameTable) r10.readMessage(QualifiedNameTable.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.qualifiedNames_ = r20;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r18 == null) goto L41;
            r18.mergeFrom(r20);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.qualifiedNames_ = r18.buildPartial();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L41:
            this.bitField0_ |= 2;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L12:
            if (r15 != 26) goto L14;
            if ((this.bitField0_ & 4) != 4) goto L31;
            r16 = this.package_.toBuilder();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L31:
            Package r21 = (Package) r10.readMessage(Package.PARSER, r11);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.package_ = r21;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            if (r16 == null) goto L34;
            r16.mergeFrom(r21);     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            this.package_ = r16.buildPartial();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
        L34:
            this.bitField0_ |= 4;     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L14:
            if (r15 != 34) goto L16;
            int r22 = (r14 == true ? 1 : 0) & '\b';     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r14 = r14;
            if (r22 == 8) goto L27;
            this.class__ = new ArrayList();     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            r14 = '\b';
        L27:
            this.class__.add((Class) r10.readMessage(Class.PARSER, r11));     // Catch: Throwable -> L18 IOException -> L20 InvalidProtocolBufferException -> L22
            goto L4
        L16:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L4;
        L17:
            r13 = true;
            goto L4
        L18:
            th = move-exception;
            if (((r14 == true ? 1 : 0) & '\b') != 8) goto L80;
            this.class__ = Collections.unmodifiableList(this.class__);
        L80:
            r12.flush();     // Catch: IOException -> L75 Throwable -> L59
        L59:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L58:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L18
        L20:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L18
        L65:
            if (((r14 == true ? 1 : 0) & '\b') != 8) goto L77;
            this.class__ = Collections.unmodifiableList(this.class__);
        L77:
            r12.flush();     // Catch: IOException -> L74 Throwable -> L69
        L69:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L68:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> PARSER;
        private static final Property defaultInstance = null;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private int flags_;
            private int getterFlags_;
            private int name_;
            private int oldFlags_;
            private int receiverTypeId_;
            private Type receiverType_;
            private int returnTypeId_;
            private Type returnType_;
            private int setterFlags_;
            private ValueParameter setterValueParameter_;
            private List<TypeParameter> typeParameter_;
            private List<Integer> versionRequirement_;

            private Builder() {
                this.flags_ = 518;
                this.oldFlags_ = 2054;
                this.returnType_ = Type.getDefaultInstance();
                this.typeParameter_ = Collections.emptyList();
                this.receiverType_ = Type.getDefaultInstance();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.setterValueParameter_ = ValueParameter.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$16000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
                return;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 8192) == 8192) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 8192;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Property buildPartial() {
                Property r5 = new Property(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                Property.access$16202(r5, this.flags_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                Property.access$16302(r5, this.oldFlags_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                Property.access$16402(r5, this.name_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 8;
            L15:
                Property.access$16502(r5, this.returnType_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 16;
            L18:
                Property.access$16602(r5, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Property.access$16702(r5, this.typeParameter_);
                if ((r10 & 64) != 64) goto L24;
                r11 = r11 | 32;
            L24:
                Property.access$16802(r5, this.receiverType_);
                if ((r10 & 128) != 128) goto L27;
                r11 = r11 | 64;
            L27:
                Property.access$16902(r5, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Property.access$17002(r5, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -513;
            L33:
                Property.access$17102(r5, this.contextReceiverTypeId_);
                if ((r10 & 1024) != 1024) goto L36;
                r11 = r11 | 128;
            L36:
                Property.access$17202(r5, this.setterValueParameter_);
                if ((r10 & 2048) != 2048) goto L39;
                r11 = r11 | 256;
            L39:
                Property.access$17302(r5, this.getterFlags_);
                if ((r10 & 4096) != 4096) goto L42;
                r11 = r11 | 512;
            L42:
                Property.access$17402(r5, this.setterFlags_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -8193;
            L45:
                Property.access$17502(r5, this.versionRequirement_);
                Property.access$17602(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Type getContextReceiverType(int r5) {
                return this.contextReceiverType_.get(r5);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            public TypeParameter getTypeParameter(int r5) {
                return this.typeParameter_.get(r5);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasSetterValueParameter() {
                if ((this.bitField0_ & 1024) != 1024) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasReturnType() == true) goto L8;
            L10:
                int r5 = 0;
            L12:
                if (r5 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r5).isInitialized() == false) goto L15;
                r5 = r5 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r10 = 0;
            L24:
                if (r10 >= getContextReceiverTypeCount()) goto L30;
                if (getContextReceiverType(r10).isInitialized() == false) goto L27;
                r10 = r10 + 1;
                goto L24
            L27:
                return false;
            L30:
                if (hasSetterValueParameter() == false) goto L35;
                if (getSetterValueParameter().isInitialized() == true) goto L35;
                return false;
            L35:
                if (extensionsAreInitialized() == true) goto L37;
                return false;
            L37:
                return true;
            L20:
                if (getReceiverType().isInitialized() == true) goto L22;
                return false;
            L8:
                if (getReturnType().isInitialized() == true) goto L10;
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeReceiverType(Type r5) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r5;
            L8:
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeReturnType(Type r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeSetterValueParameter(ValueParameter r5) {
                if ((this.bitField0_ & 1024) == 1024) goto L5;
            L7:
                this.setterValueParameter_ = r5;
            L8:
                this.bitField0_ |= 1024;
                return this;
            L5:
                if (this.setterValueParameter_ == ValueParameter.getDefaultInstance()) goto L7;
                this.setterValueParameter_ = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 1;
                this.flags_ = r5;
                return this;
            }

            public Builder setGetterFlags(int r5) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = r5;
                return this;
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 4;
                this.name_ = r5;
                return this;
            }

            public Builder setOldFlags(int r5) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r5;
                return this;
            }

            public Builder setReceiverTypeId(int r5) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r5;
                return this;
            }

            public Builder setReturnTypeId(int r5) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r5;
                return this;
            }

            public Builder setSetterFlags(int r5) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Property build() {
                Property r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Property) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(Property r5) {
                if (r5 != Property.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasFlags() == false) goto L9;
                setFlags(r5.getFlags());
            L9:
                if (r5.hasOldFlags() == false) goto L12;
                setOldFlags(r5.getOldFlags());
            L12:
                if (r5.hasName() == false) goto L15;
                setName(r5.getName());
            L15:
                if (r5.hasReturnType() == false) goto L18;
                mergeReturnType(r5.getReturnType());
            L18:
                if (r5.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r5.getReturnTypeId());
            L21:
                if (Property.access$16700(r5).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Property.access$16700(r5);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Property.access$16700(r5));
            L27:
                if (r5.hasReceiverType() == false) goto L30;
                mergeReceiverType(r5.getReceiverType());
            L30:
                if (r5.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r5.getReceiverTypeId());
            L33:
                if (Property.access$17000(r5).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Property.access$17000(r5);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Property.access$17000(r5));
            L39:
                if (Property.access$17100(r5).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Property.access$17100(r5);
                this.bitField0_ &= -513;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Property.access$17100(r5));
            L45:
                if (r5.hasSetterValueParameter() == false) goto L48;
                mergeSetterValueParameter(r5.getSetterValueParameter());
            L48:
                if (r5.hasGetterFlags() == false) goto L51;
                setGetterFlags(r5.getGetterFlags());
            L51:
                if (r5.hasSetterFlags() == false) goto L54;
                setSetterFlags(r5.getSetterFlags());
            L54:
                if (Property.access$17500(r5).isEmpty() == false) goto L56;
            L59:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(Property.access$17700(r5)));
                return this;
            L56:
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Property.access$17500(r5);
                this.bitField0_ &= -8193;
                goto L59
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Property.access$17500(r5));
                goto L59
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Property r11 = null;
                Property r12 = Property.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Property r13 = (Property) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Property r5 = new Property(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Property(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$16202(Property r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$16302(Property r5, int r10) {
            r5.oldFlags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$16402(Property r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$16502(Property r5, Type r10) {
            r5.returnType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$16602(Property r5, int r10) {
            r5.returnTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$16700(Property r5) {
            return r5.typeParameter_;
        }

        public static /* synthetic */ List access$16702(Property r5, List r10) {
            r5.typeParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$16802(Property r5, Type r10) {
            r5.receiverType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$16902(Property r5, int r10) {
            r5.receiverTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$17000(Property r5) {
            return r5.contextReceiverType_;
        }

        public static /* synthetic */ List access$17002(Property r5, List r10) {
            r5.contextReceiverType_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$17100(Property r5) {
            return r5.contextReceiverTypeId_;
        }

        public static /* synthetic */ List access$17102(Property r5, List r10) {
            r5.contextReceiverTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ ValueParameter access$17202(Property r5, ValueParameter r10) {
            r5.setterValueParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$17302(Property r5, int r10) {
            r5.getterFlags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$17402(Property r5, int r10) {
            r5.setterFlags_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$17500(Property r5) {
            return r5.versionRequirement_;
        }

        public static /* synthetic */ List access$17502(Property r5, List r10) {
            r5.versionRequirement_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$17602(Property r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$17700(Property r5) {
            return r5.unknownFields;
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$16000();
        }

        public Type getContextReceiverType(int r5) {
            return this.contextReceiverType_.get(r5);
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.oldFlags_);
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r11 = r11 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r12 = 0;
        L17:
            if (r12 >= this.typeParameter_.size()) goto L20;
            r11 = r11 + CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(r12));
            r12 = r12 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r11 = r11 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L23:
            if ((this.bitField0_ & 128) != 128) goto L26;
            r11 = r11 + CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        L26:
            if ((this.bitField0_ & 256) != 256) goto L29;
            r11 = r11 + CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        L29:
            if ((this.bitField0_ & 512) != 512) goto L32;
            r11 = r11 + CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        L32:
            if ((this.bitField0_ & 16) != 16) goto L35;
            r11 = r11 + CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        L35:
            if ((this.bitField0_ & 64) != 64) goto L38;
            r11 = r11 + CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        L38:
            if ((this.bitField0_ & 1) != 1) goto L40;
            r11 = r11 + CodedOutputStream.computeInt32Size(11, this.flags_);
        L40:
            int r13 = 0;
        L42:
            if (r13 >= this.contextReceiverType_.size()) goto L44;
            r11 = r11 + CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(r13));
            r13 = r13 + 1;
            goto L42
        L44:
            int r14 = 0;
            int r15 = 0;
        L46:
            if (r14 >= this.contextReceiverTypeId_.size()) goto L48;
            r15 = r15 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r14).intValue());
            r14 = r14 + 1;
            goto L46
        L48:
            int r16 = r11 + r15;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L51;
            r16 = (r16 + 1) + CodedOutputStream.computeInt32SizeNoTag(r15);
        L51:
            this.contextReceiverTypeIdMemoizedSerializedSize = r15;
            int r17 = 0;
        L53:
            if (r10 >= this.versionRequirement_.size()) goto L55;
            r17 = r17 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r10).intValue());
            r10 = r10 + 1;
            goto L53
        L55:
            int r18 = this.unknownFields.size() + (extensionsSerializedSize() + ((getVersionRequirementList().size() * 2) + (r16 + r17)));
            this.memoizedSerializedSize = r18;
            return r18;
        L8:
            r11 = 0;
            goto L10
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public TypeParameter getTypeParameter(int r5) {
            return this.typeParameter_.get(r5);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasGetterFlags() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSetterFlags() {
            if ((this.bitField0_ & 512) != 512) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSetterValueParameter() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r10 = 0;
        L20:
            if (r10 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r10).isInitialized() == false) goto L23;
            r10 = r10 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r11 = 0;
        L34:
            if (r11 >= getContextReceiverTypeCount()) goto L41;
            if (getContextReceiverType(r11).isInitialized() == false) goto L37;
            r11 = r11 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L41:
            if (hasSetterValueParameter() == false) goto L47;
            if (getSetterValueParameter().isInitialized() == true) goto L47;
            this.memoizedIsInitialized = 0;
            return false;
        L47:
            if (extensionsAreInitialized() == true) goto L50;
            this.memoizedIsInitialized = 0;
            return false;
        L50:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getReceiverType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (getReturnType().isInitialized() == true) goto L18;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r10.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r10.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r10.writeMessage(3, this.returnType_);
        L11:
            int r11 = 0;
            int r12 = 0;
        L13:
            if (r12 >= this.typeParameter_.size()) goto L16;
            r10.writeMessage(4, this.typeParameter_.get(r12));
            r12 = r12 + 1;
            goto L13
        L16:
            if ((this.bitField0_ & 32) != 32) goto L19;
            r10.writeMessage(5, this.receiverType_);
        L19:
            if ((this.bitField0_ & 128) != 128) goto L22;
            r10.writeMessage(6, this.setterValueParameter_);
        L22:
            if ((this.bitField0_ & 256) != 256) goto L25;
            r10.writeInt32(7, this.getterFlags_);
        L25:
            if ((this.bitField0_ & 512) != 512) goto L28;
            r10.writeInt32(8, this.setterFlags_);
        L28:
            if ((this.bitField0_ & 16) != 16) goto L31;
            r10.writeInt32(9, this.returnTypeId_);
        L31:
            if ((this.bitField0_ & 64) != 64) goto L34;
            r10.writeInt32(10, this.receiverTypeId_);
        L34:
            if ((this.bitField0_ & 1) != 1) goto L36;
            r10.writeInt32(11, this.flags_);
        L36:
            int r13 = 0;
        L38:
            if (r13 >= this.contextReceiverType_.size()) goto L41;
            r10.writeMessage(12, this.contextReceiverType_.get(r13));
            r13 = r13 + 1;
            goto L38
        L41:
            if (getContextReceiverTypeIdList().size() <= 0) goto L43;
            r10.writeRawVarint32(106);
            r10.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L43:
            int r14 = 0;
        L45:
            if (r14 >= this.contextReceiverTypeId_.size()) goto L48;
            r10.writeInt32NoTag(this.contextReceiverTypeId_.get(r14).intValue());
            r14 = r14 + 1;
        L48:
            if (r11 >= this.versionRequirement_.size()) goto L50;
            r10.writeInt32(31, this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L48
        L50:
            r5.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Property(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Property r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> r5) {
            super(r5);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Property(boolean r5) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Property(CodedInputStream r13, ExtensionRegistryLite r14) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r11 = false;
            int r12 = 0;
        L4:
            if (r11 == true) goto L103;
            int r15 = r13.readTag();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            Type.Builder r16 = null;
            ValueParameter.Builder r17 = null;
            Type.Builder r18 = null;
            switch(r15) {
                case 0: goto L9;
                case 8: goto L77;
                case 16: goto L76;
                case 26: goto L70;
                case 34: goto L65;
                case 42: goto L59;
                case 50: goto L52;
                case 56: goto L50;
                case 64: goto L49;
                case 72: goto L48;
                case 80: goto L47;
                case 88: goto L46;
                case 98: goto L42;
                case 104: goto L38;
                case 106: goto L29;
                case 248: goto L25;
                case 250: goto L16;
                default: goto L8;
            };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L9:
            r11 = true;
            goto L4
        L16:
            int r19 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            int r110 = (r12 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r110 == 8192) goto L22;
            r12 = r12;
            if (r13.getBytesUntilLimit() <= 0) goto L22;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L22:
            if (r13.getBytesUntilLimit() <= 0) goto L24;
            this.versionRequirement_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L22
        L24:
            r13.popLimit(r19);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L25:
            int r20 = (r12 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r20 == 8192) goto L28;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L28:
            this.versionRequirement_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L29:
            int r21 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            int r111 = (r12 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r111 == 512) goto L35;
            r12 = r12;
            if (r13.getBytesUntilLimit() <= 0) goto L35;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L35:
            if (r13.getBytesUntilLimit() <= 0) goto L37;
            this.contextReceiverTypeId_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L35
        L37:
            r13.popLimit(r21);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L38:
            int r22 = (r12 == true ? 1 : 0) & 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r22 == 512) goto L41;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L41:
            this.contextReceiverTypeId_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L42:
            int r23 = (r12 == true ? 1 : 0) & 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r23 == 256) goto L45;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L45:
            this.contextReceiverType_.add((Type) r13.readMessage(Type.PARSER, r14));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L46:
            this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.flags_ = r13.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L47:
            this.bitField0_ |= 64;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.receiverTypeId_ = r13.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L48:
            this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.returnTypeId_ = r13.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L49:
            this.bitField0_ |= 512;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.setterFlags_ = r13.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L50:
            this.bitField0_ |= 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.getterFlags_ = r13.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L52:
            if ((this.bitField0_ & 128) != 128) goto L54;
            r17 = this.setterValueParameter_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L54:
            ValueParameter r24 = (ValueParameter) r13.readMessage(ValueParameter.PARSER, r14);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.setterValueParameter_ = r24;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r17 == null) goto L57;
            r17.mergeFrom(r24);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.setterValueParameter_ = r17.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L57:
            this.bitField0_ |= 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L59:
            if ((this.bitField0_ & 32) != 32) goto L61;
            r18 = this.receiverType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L61:
            Type r25 = (Type) r13.readMessage(Type.PARSER, r14);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.receiverType_ = r25;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r18 == null) goto L64;
            r18.mergeFrom(r25);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.receiverType_ = r18.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L64:
            this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L65:
            int r26 = (r12 == true ? 1 : 0) & 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = r12;
            if (r26 == 32) goto L68;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r12 = (r12 == true ? 1 : 0) | 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L68:
            this.typeParameter_.add((TypeParameter) r13.readMessage(TypeParameter.PARSER, r14));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L70:
            if ((this.bitField0_ & 8) != 8) goto L72;
            r16 = this.returnType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L72:
            Type r27 = (Type) r13.readMessage(Type.PARSER, r14);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.returnType_ = r27;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r16 == null) goto L75;
            r16.mergeFrom(r27);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.returnType_ = r16.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L75:
            this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L76:
            this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.name_ = r13.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L77:
            this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.oldFlags_ = r13.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L8:
            if (parseUnknownField(r13, r10, r14, r15) == true) goto L4;
        L10:
            th = move-exception;
            if (((r12 == true ? 1 : 0) & 32) != 32) goto L87;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L87:
            if (((r12 == true ? 1 : 0) & 256) != 256) goto L90;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L90:
            if (((r12 == true ? 1 : 0) & 512) != 512) goto L93;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L93:
            if (((r12 == true ? 1 : 0) & 8192) != 8192) goto L125;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L125:
            r10.flush();     // Catch: IOException -> L122 Throwable -> L97
        L97:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L96:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L14:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
        L12:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
        L103:
            if (((r12 == true ? 1 : 0) & 32) != 32) goto L106;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L106:
            if (((r12 == true ? 1 : 0) & 256) != 256) goto L109;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L109:
            if (((r12 == true ? 1 : 0) & 512) != 512) goto L112;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L112:
            if (((r12 == true ? 1 : 0) & 8192) != 8192) goto L127;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L127:
            r10.flush();     // Catch: IOException -> L121 Throwable -> L116
        L116:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L115:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER;
        private static final QualifiedNameTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_;

            private Builder() {
                this.qualifiedName_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$1400() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                this.bitField0_ |= 1;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable r5 = new QualifiedNameTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                this.bitField0_ &= -2;
            L5:
                QualifiedNameTable.access$1602(r5, this.qualifiedName_);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public QualifiedName getQualifiedName(int r5) {
                return this.qualifiedName_.get(r5);
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getQualifiedNameCount()) goto L9;
                if (getQualifiedName(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public QualifiedNameTable build() {
                QualifiedNameTable r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((QualifiedNameTable) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(QualifiedNameTable r5) {
                if (r5 != QualifiedNameTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (QualifiedNameTable.access$1600(r5).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(QualifiedNameTable.access$1700(r5)));
                return this;
            L8:
                if (this.qualifiedName_.isEmpty() == false) goto L10;
                this.qualifiedName_ = QualifiedNameTable.access$1600(r5);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.addAll(QualifiedNameTable.access$1600(r5));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                QualifiedNameTable r11 = null;
                QualifiedNameTable r12 = QualifiedNameTable.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                QualifiedNameTable r13 = (QualifiedNameTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

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

            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int bitField0_;
                private Kind kind_;
                private int parentQualifiedName_;
                private int shortName_;

                private Builder() {
                    this.parentQualifiedName_ = -1;
                    this.kind_ = Kind.PACKAGE;
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$700() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public QualifiedName buildPartial() {
                    QualifiedName r5 = new QualifiedName(this, null);
                    int r10 = this.bitField0_;
                    int r11 = 1;
                    if ((r10 & 1) == 1) goto L6;
                    r11 = 0;
                L6:
                    QualifiedName.access$902(r5, this.parentQualifiedName_);
                    if ((r10 & 2) != 2) goto L9;
                    r11 = r11 | 2;
                L9:
                    QualifiedName.access$1002(r5, this.shortName_);
                    if ((r10 & 4) != 4) goto L12;
                    r11 = r11 | 4;
                L12:
                    QualifiedName.access$1102(r5, this.kind_);
                    QualifiedName.access$1202(r5, r11);
                    return r5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                public boolean hasShortName() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasShortName() == true) goto L6;
                    return false;
                L6:
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                public Builder setKind(Kind r5) {
                    r5.getClass();
                    this.bitField0_ |= 4;
                    this.kind_ = r5;
                    return this;
                }

                public Builder setParentQualifiedName(int r5) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = r5;
                    return this;
                }

                public Builder setShortName(int r5) {
                    this.bitField0_ |= 2;
                    this.shortName_ = r5;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public QualifiedName build() {
                    QualifiedName r5 = buildPartial();
                    if (r5.isInitialized() == false) goto L6;
                    return r5;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                    return mergeFrom((QualifiedName) r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(QualifiedName r5) {
                    if (r5 != QualifiedName.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r5.hasParentQualifiedName() == false) goto L9;
                    setParentQualifiedName(r5.getParentQualifiedName());
                L9:
                    if (r5.hasShortName() == false) goto L12;
                    setShortName(r5.getShortName());
                L12:
                    if (r5.hasKind() == false) goto L14;
                    setKind(r5.getKind());
                L14:
                    setUnknownFields(getUnknownFields().concat(QualifiedName.access$1300(r5)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    QualifiedName r11 = null;
                    QualifiedName r12 = QualifiedName.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r12 == null) goto L6;
                    mergeFrom(r12);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    QualifiedName r13 = (QualifiedName) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r11 = r13;
                L14:
                    if (r11 == null) goto L16;
                    mergeFrom(r11);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }
            }

            public static final enum Kind extends Enum<Kind> implements Internal.EnumLite {
                private static final /* synthetic */ Kind[] $VALUES = null;
                public static final Kind CLASS = null;
                public static final Kind LOCAL = null;
                public static final Kind PACKAGE = null;
                private static Internal.EnumLiteMap<Kind> internalValueMap;
                private final int value;

                static {
                    Kind r5 = new Kind("CLASS", 0, 0, 0);
                    CLASS = r5;
                    Kind r10 = new Kind("PACKAGE", 1, 1, 1);
                    PACKAGE = r10;
                    Kind r11 = new Kind("LOCAL", 2, 2, 2);
                    LOCAL = r11;
                    $VALUES = new Kind[]{r5, r10, r11};
                    internalValueMap = new AnonymousClass1();
                }

                private Kind(String r5, int r10, int r11, int r12) {
                    super(r5, r10);
                    this.value = r12;
                }

                public static Kind valueOf(String r5) {
                    return (Kind) Enum.valueOf(Kind.class, r5);
                }

                public static Kind[] values() {
                    return (Kind[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int r5) {
                    if (r5 == 0) goto L14;
                    if (r5 == 1) goto L12;
                    if (r5 == 2) goto L10;
                    return null;
                L10:
                    return LOCAL;
                L12:
                    return PACKAGE;
                L14:
                    return CLASS;
                }
            }

            static {
                PARSER = new AnonymousClass1();
                QualifiedName r5 = new QualifiedName(true);
                defaultInstance = r5;
                r5.initFields();
            }

            public /* synthetic */ QualifiedName(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
                this(r5, r10);
            }

            public static /* synthetic */ int access$1002(QualifiedName r5, int r10) {
                r5.shortName_ = r10;
                return r10;
            }

            public static /* synthetic */ Kind access$1102(QualifiedName r5, Kind r10) {
                r5.kind_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$1202(QualifiedName r5, int r10) {
                r5.bitField0_ = r10;
                return r10;
            }

            public static /* synthetic */ ByteString access$1300(QualifiedName r5) {
                return r5.unknownFields;
            }

            public static /* synthetic */ int access$902(QualifiedName r5, int r10) {
                r5.parentQualifiedName_ = r10;
                return r10;
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public static Builder newBuilder() {
                return Builder.access$700();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r5 = this.memoizedSerializedSize;
                if (r5 == (-1)) goto L6;
                return r5;
            L6:
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r10 = CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r10 = r10 + CodedOutputStream.computeInt32Size(2, this.shortName_);
            L13:
                if ((this.bitField0_ & 4) != 4) goto L15;
                r10 = r10 + CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
            L15:
                int r11 = this.unknownFields.size() + r10;
                this.memoizedSerializedSize = r11;
                return r11;
            L8:
                r10 = 0;
                goto L10
            }

            public int getShortName() {
                return this.shortName_;
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
                byte r5 = this.memoizedIsInitialized;
                if (r5 != 1) goto L6;
                return true;
            L6:
                if (r5 != 0) goto L9;
                return false;
            L9:
                if (hasShortName() == true) goto L12;
                this.memoizedIsInitialized = 0;
                return false;
            L12:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r5) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r5.writeInt32(1, this.parentQualifiedName_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r5.writeInt32(2, this.shortName_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r5.writeEnum(3, this.kind_.getNumber());
            L11:
                r5.writeRawBytes(this.unknownFields);
            }

            public /* synthetic */ QualifiedName(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
                this(r5);
            }

            public static Builder newBuilder(QualifiedName r5) {
                return newBuilder().mergeFrom(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            private QualifiedName(GeneratedMessageLite.Builder r5) {
                super(r5);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r5.getUnknownFields();
            }

            private QualifiedName(boolean r5) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private QualifiedName(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r5 = ByteString.newOutput();
                CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
                boolean r13 = false;
            L3:
                if (r13 == true) goto L50;
                int r14 = r10.readTag();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                if (r14 == 0) goto L14;
                if (r14 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.parentQualifiedName_ = r10.readInt32();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L9:
                if (r14 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.shortName_ = r10.readInt32();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L11:
                if (r14 != 24) goto L13;
                int r15 = r10.readEnum();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                Kind r16 = Kind.valueOf(r15);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                if (r16 == null) goto L23;
                this.bitField0_ |= 4;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.kind_ = r16;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L23:
                r12.writeRawVarint32(r14);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                r12.writeRawVarint32(r15);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L13:
                if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
            L14:
                r13 = true;
                goto L3
            L15:
                th = move-exception;
                r12.flush();     // Catch: IOException -> L46 Throwable -> L34
            L34:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L33:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
                throw th;
            L19:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L15
            L17:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L15
            L50:
                r12.flush();     // Catch: IOException -> L47 Throwable -> L41
            L41:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L40:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
            }
        }

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            PARSER = new AnonymousClass1();
            QualifiedNameTable r5 = new QualifiedNameTable(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ QualifiedNameTable(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$1600(QualifiedNameTable r5) {
            return r5.qualifiedName_;
        }

        public static /* synthetic */ List access$1602(QualifiedNameTable r5, List r10) {
            r5.qualifiedName_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$1700(QualifiedNameTable r5) {
            return r5.unknownFields;
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int r5) {
            return this.qualifiedName_.get(r5);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r10 >= this.qualifiedName_.size()) goto L9;
            r11 = r11 + CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(r10));
            r10 = r10 + 1;
            goto L7
        L9:
            int r12 = this.unknownFields.size() + r11;
            this.memoizedSerializedSize = r12;
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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
            if (r10 >= getQualifiedNameCount()) goto L16;
            if (getQualifiedName(r10).isInitialized() == false) goto L13;
            r10 = r10 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            int r10 = 0;
        L4:
            if (r10 >= this.qualifiedName_.size()) goto L6;
            r5.writeMessage(1, this.qualifiedName_.get(r10));
            r10 = r10 + 1;
            goto L4
        L6:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ QualifiedNameTable(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(QualifiedNameTable r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private QualifiedNameTable(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private QualifiedNameTable(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private QualifiedNameTable(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            boolean r14 = false;
        L3:
            if (r13 == true) goto L34;
            int r15 = r10.readTag();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r15 == 0) goto L10;
            if (r15 != 10) goto L9;
            if (r14 == true) goto L19;
            this.qualifiedName_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r14 = true;
        L19:
            this.qualifiedName_.add((QualifiedName) r10.readMessage(QualifiedName.PARSER, r11));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L3
        L9:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L3;
        L10:
            r13 = true;
            goto L3
        L11:
            th = move-exception;
            if (r14 != true) goto L47;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L47:
            r12.flush();     // Catch: IOException -> L44 Throwable -> L29
        L29:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L28:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L15:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L13:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L34:
            if (r14 != true) goto L49;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L49:
            r12.flush();     // Catch: IOException -> L43 Throwable -> L38
        L38:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L37:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER;
        private static final StringTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private LazyStringList string_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_;

            private Builder() {
                this.string_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$100() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.string_ = new LazyStringArrayList(this.string_);
                this.bitField0_ |= 1;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public StringTable buildPartial() {
                StringTable r5 = new StringTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.string_ = this.string_.getUnmodifiableView();
                this.bitField0_ &= -2;
            L5:
                StringTable.access$302(r5, this.string_);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTable build() {
                StringTable r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((StringTable) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(StringTable r5) {
                if (r5 != StringTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTable.access$300(r5).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(StringTable.access$400(r5)));
                return this;
            L8:
                if (this.string_.isEmpty() == false) goto L10;
                this.string_ = StringTable.access$300(r5);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureStringIsMutable();
                this.string_.addAll(StringTable.access$300(r5));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                StringTable r11 = null;
                StringTable r12 = StringTable.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTable r13 = (StringTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            StringTable r5 = new StringTable(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ StringTable(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ LazyStringList access$300(StringTable r5) {
            return r5.string_;
        }

        public static /* synthetic */ LazyStringList access$302(StringTable r5, LazyStringList r10) {
            r5.string_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$400(StringTable r5) {
            return r5.unknownFields;
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
        }

        public static Builder newBuilder() {
            return Builder.access$100();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r10 >= this.string_.size()) goto L9;
            r11 = r11 + CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(r10));
            r10 = r10 + 1;
            goto L7
        L9:
            int r12 = this.unknownFields.size() + (getStringList().size() + r11);
            this.memoizedSerializedSize = r12;
            return r12;
        }

        public String getString(int r5) {
            return this.string_.get(r5);
        }

        public ProtocolStringList getStringList() {
            return this.string_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            int r10 = 0;
        L4:
            if (r10 >= this.string_.size()) goto L6;
            r5.writeBytes(1, this.string_.getByteString(r10));
            r10 = r10 + 1;
            goto L4
        L6:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ StringTable(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(StringTable r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private StringTable(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private StringTable(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private StringTable(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            boolean r14 = false;
        L3:
            if (r13 == true) goto L35;
            int r15 = r10.readTag();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r15 == 0) goto L10;
            if (r15 != 10) goto L9;
            ByteString r16 = r10.readBytes();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r14 == true) goto L20;
            this.string_ = new LazyStringArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r14 = true;
        L20:
            this.string_.add(r16);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L3
        L9:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L3;
        L10:
            r13 = true;
            goto L3
        L11:
            th = move-exception;
            if (r14 != true) goto L48;
            this.string_ = this.string_.getUnmodifiableView();
        L48:
            r12.flush();     // Catch: IOException -> L45 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L29:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L15:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L13:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L35:
            if (r14 != true) goto L50;
            this.string_ = this.string_.getUnmodifiableView();
        L50:
            r12.flush();     // Catch: IOException -> L44 Throwable -> L39
        L39:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L38:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> PARSER;
        private static final Type defaultInstance = null;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final ByteString unknownFields;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER;
            private static final Argument defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final ByteString unknownFields;

            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private Projection projection_;
                private int typeId_;
                private Type type_;

                private Builder() {
                    this.projection_ = Projection.INV;
                    this.type_ = Type.getDefaultInstance();
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$5000() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public Argument buildPartial() {
                    Argument r5 = new Argument(this, null);
                    int r10 = this.bitField0_;
                    int r11 = 1;
                    if ((r10 & 1) == 1) goto L6;
                    r11 = 0;
                L6:
                    Argument.access$5202(r5, this.projection_);
                    if ((r10 & 2) != 2) goto L9;
                    r11 = r11 | 2;
                L9:
                    Argument.access$5302(r5, this.type_);
                    if ((r10 & 4) != 4) goto L12;
                    r11 = r11 | 4;
                L12:
                    Argument.access$5402(r5, this.typeId_);
                    Argument.access$5502(r5, r11);
                    return r5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasType() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasType() == true) goto L5;
                    return true;
                L5:
                    if (getType().isInitialized() == true) goto L10;
                    return false;
                L10:
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                public Builder mergeType(Type r5) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.type_ = r5;
                L8:
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.type_ == Type.getDefaultInstance()) goto L7;
                    this.type_ = Type.newBuilder(this.type_).mergeFrom(r5).buildPartial();
                    goto L8
                }

                public Builder setProjection(Projection r5) {
                    r5.getClass();
                    this.bitField0_ |= 1;
                    this.projection_ = r5;
                    return this;
                }

                public Builder setTypeId(int r5) {
                    this.bitField0_ |= 4;
                    this.typeId_ = r5;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r5 = buildPartial();
                    if (r5.isInitialized() == false) goto L6;
                    return r5;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                    return mergeFrom((Argument) r5);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    return mergeFrom(r5, r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                public Builder mergeFrom(Argument r5) {
                    if (r5 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r5.hasProjection() == false) goto L9;
                    setProjection(r5.getProjection());
                L9:
                    if (r5.hasType() == false) goto L12;
                    mergeType(r5.getType());
                L12:
                    if (r5.hasTypeId() == false) goto L14;
                    setTypeId(r5.getTypeId());
                L14:
                    setUnknownFields(getUnknownFields().concat(Argument.access$5600(r5)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                    Argument r11 = null;
                    Argument r12 = Argument.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r12 == null) goto L6;
                    mergeFrom(r12);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r13 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r11 = r13;
                L14:
                    if (r11 == null) goto L16;
                    mergeFrom(r11);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }
            }

            public static final enum Projection extends Enum<Projection> implements Internal.EnumLite {
                private static final /* synthetic */ Projection[] $VALUES = null;
                public static final Projection IN = null;
                public static final Projection INV = null;
                public static final Projection OUT = null;
                public static final Projection STAR = null;
                private static Internal.EnumLiteMap<Projection> internalValueMap;
                private final int value;

                static {
                    Projection r5 = new Projection("IN", 0, 0, 0);
                    IN = r5;
                    Projection r10 = new Projection("OUT", 1, 1, 1);
                    OUT = r10;
                    Projection r11 = new Projection("INV", 2, 2, 2);
                    INV = r11;
                    Projection r12 = new Projection("STAR", 3, 3, 3);
                    STAR = r12;
                    $VALUES = new Projection[]{r5, r10, r11, r12};
                    internalValueMap = new AnonymousClass1();
                }

                private Projection(String r5, int r10, int r11, int r12) {
                    super(r5, r10);
                    this.value = r12;
                }

                public static Projection valueOf(String r5) {
                    return (Projection) Enum.valueOf(Projection.class, r5);
                }

                public static Projection[] values() {
                    return (Projection[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
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
                PARSER = new AnonymousClass1();
                Argument r5 = new Argument(true);
                defaultInstance = r5;
                r5.initFields();
            }

            public /* synthetic */ Argument(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
                this(r5, r10);
            }

            public static /* synthetic */ Projection access$5202(Argument r5, Projection r10) {
                r5.projection_ = r10;
                return r10;
            }

            public static /* synthetic */ Type access$5302(Argument r5, Type r10) {
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

            public static /* synthetic */ ByteString access$5600(Argument r5) {
                return r5.unknownFields;
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            public static Builder newBuilder() {
                return Builder.access$5000();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r5 = this.memoizedSerializedSize;
                if (r5 == (-1)) goto L6;
                return r5;
            L6:
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r10 = CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r10 = r10 + CodedOutputStream.computeMessageSize(2, this.type_);
            L13:
                if ((this.bitField0_ & 4) != 4) goto L15;
                r10 = r10 + CodedOutputStream.computeInt32Size(3, this.typeId_);
            L15:
                int r11 = this.unknownFields.size() + r10;
                this.memoizedSerializedSize = r11;
                return r11;
            L8:
                r10 = 0;
                goto L10
            }

            public Type getType() {
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r5) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r5.writeEnum(1, this.projection_.getNumber());
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r5.writeMessage(2, this.type_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r5.writeInt32(3, this.typeId_);
            L11:
                r5.writeRawBytes(this.unknownFields);
            }

            public /* synthetic */ Argument(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
                this(r5);
            }

            public static Builder newBuilder(Argument r5) {
                return newBuilder().mergeFrom(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.Builder r5) {
                super(r5);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r5.getUnknownFields();
            }

            private Argument(boolean r5) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Argument(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r5 = ByteString.newOutput();
                CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
                boolean r13 = false;
            L3:
                if (r13 == true) goto L59;
                int r14 = r10.readTag();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                if (r14 == 0) goto L14;
                if (r14 != 8) goto L9;
                int r15 = r10.readEnum();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                Projection r16 = Projection.valueOf(r15);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                if (r16 == null) goto L32;
                this.bitField0_ |= 1;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.projection_ = r16;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L32:
                r12.writeRawVarint32(r14);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                r12.writeRawVarint32(r15);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L9:
                if (r14 != 18) goto L11;
                if ((this.bitField0_ & 2) != 2) goto L25;
                Builder r17 = this.type_.toBuilder();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            L26:
                Type r18 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.type_ = r18;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                if (r17 == null) goto L29;
                r17.mergeFrom(r18);     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.type_ = r17.buildPartial();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
            L29:
                this.bitField0_ |= 2;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L25:
                r17 = null;
                goto L26
            L11:
                if (r14 != 24) goto L13;
                this.bitField0_ |= 4;     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                this.typeId_ = r10.readInt32();     // Catch: Throwable -> L15 IOException -> L17 InvalidProtocolBufferException -> L19
                goto L3
            L13:
                if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
            L14:
                r13 = true;
                goto L3
            L15:
                th = move-exception;
                r12.flush();     // Catch: IOException -> L53 Throwable -> L41
            L41:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L40:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
                throw th;
            L19:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L15
            L17:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L15
            L59:
                r12.flush();     // Catch: IOException -> L54 Throwable -> L48
            L48:
                th = move-exception;
                this.unknownFields = r5.toByteString();
                throw th;
            L47:
                this.unknownFields = r5.toByteString();
                makeExtensionsImmutable();
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int abbreviatedTypeId_;
            private Type abbreviatedType_;
            private List<Argument> argument_;
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private Type flexibleUpperBound_;
            private boolean nullable_;
            private int outerTypeId_;
            private Type outerType_;
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;

            private Builder() {
                this.argument_ = Collections.emptyList();
                this.flexibleUpperBound_ = Type.getDefaultInstance();
                this.outerType_ = Type.getDefaultInstance();
                this.abbreviatedType_ = Type.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$5700() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 1;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Type buildPartial() {
                Type r5 = new Type(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) != 1) goto L5;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -2;
            L5:
                Type.access$5902(r5, this.argument_);
                if ((r10 & 2) == 2) goto L9;
                r11 = 0;
            L9:
                Type.access$6002(r5, this.nullable_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 2;
            L12:
                Type.access$6102(r5, this.flexibleTypeCapabilitiesId_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 4;
            L15:
                Type.access$6202(r5, this.flexibleUpperBound_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 8;
            L18:
                Type.access$6302(r5, this.flexibleUpperBoundId_);
                if ((r10 & 32) != 32) goto L21;
                r11 = r11 | 16;
            L21:
                Type.access$6402(r5, this.className_);
                if ((r10 & 64) != 64) goto L24;
                r11 = r11 | 32;
            L24:
                Type.access$6502(r5, this.typeParameter_);
                if ((r10 & 128) != 128) goto L27;
                r11 = r11 | 64;
            L27:
                Type.access$6602(r5, this.typeParameterName_);
                if ((r10 & 256) != 256) goto L30;
                r11 = r11 | 128;
            L30:
                Type.access$6702(r5, this.typeAliasName_);
                if ((r10 & 512) != 512) goto L33;
                r11 = r11 | 256;
            L33:
                Type.access$6802(r5, this.outerType_);
                if ((r10 & 1024) != 1024) goto L36;
                r11 = r11 | 512;
            L36:
                Type.access$6902(r5, this.outerTypeId_);
                if ((r10 & 2048) != 2048) goto L39;
                r11 = r11 | 1024;
            L39:
                Type.access$7002(r5, this.abbreviatedType_);
                if ((r10 & 4096) != 4096) goto L42;
                r11 = r11 | 2048;
            L42:
                Type.access$7102(r5, this.abbreviatedTypeId_);
                if ((r10 & 8192) != 8192) goto L45;
                r11 = r11 | 4096;
            L45:
                Type.access$7202(r5, this.flags_);
                Type.access$7302(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Argument getArgument(int r5) {
                return this.argument_.get(r5);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Type getOuterType() {
                return this.outerType_;
            }

            public boolean hasAbbreviatedType() {
                if ((this.bitField0_ & 2048) != 2048) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasFlexibleUpperBound() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasOuterType() {
                if ((this.bitField0_ & 512) != 512) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getArgumentCount()) goto L10;
                if (getArgument(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (hasFlexibleUpperBound() == false) goto L15;
                if (getFlexibleUpperBound().isInitialized() == true) goto L15;
                return false;
            L15:
                if (hasOuterType() == false) goto L20;
                if (getOuterType().isInitialized() == true) goto L20;
                return false;
            L20:
                if (hasAbbreviatedType() == false) goto L25;
                if (getAbbreviatedType().isInitialized() == true) goto L25;
                return false;
            L25:
                if (extensionsAreInitialized() == true) goto L27;
                return false;
            L27:
                return true;
            }

            public Builder mergeAbbreviatedType(Type r5) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.abbreviatedType_ = r5;
            L8:
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.abbreviatedType_ == Type.getDefaultInstance()) goto L7;
                this.abbreviatedType_ = Type.newBuilder(this.abbreviatedType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeFlexibleUpperBound(Type r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.flexibleUpperBound_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.flexibleUpperBound_ == Type.getDefaultInstance()) goto L7;
                this.flexibleUpperBound_ = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeOuterType(Type r5) {
                if ((this.bitField0_ & 512) == 512) goto L5;
            L7:
                this.outerType_ = r5;
            L8:
                this.bitField0_ |= 512;
                return this;
            L5:
                if (this.outerType_ == Type.getDefaultInstance()) goto L7;
                this.outerType_ = Type.newBuilder(this.outerType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder setAbbreviatedTypeId(int r5) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = r5;
                return this;
            }

            public Builder setClassName(int r5) {
                this.bitField0_ |= 32;
                this.className_ = r5;
                return this;
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 8192;
                this.flags_ = r5;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int r5) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = r5;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int r5) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = r5;
                return this;
            }

            public Builder setNullable(boolean r5) {
                this.bitField0_ |= 2;
                this.nullable_ = r5;
                return this;
            }

            public Builder setOuterTypeId(int r5) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = r5;
                return this;
            }

            public Builder setTypeAliasName(int r5) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = r5;
                return this;
            }

            public Builder setTypeParameter(int r5) {
                this.bitField0_ |= 64;
                this.typeParameter_ = r5;
                return this;
            }

            public Builder setTypeParameterName(int r5) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Type build() {
                Type r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Type) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(Type r5) {
                if (r5 != Type.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Type.access$5900(r5).isEmpty() == true) goto L12;
                if (this.argument_.isEmpty() == false) goto L10;
                this.argument_ = Type.access$5900(r5);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureArgumentIsMutable();
                this.argument_.addAll(Type.access$5900(r5));
            L12:
                if (r5.hasNullable() == false) goto L15;
                setNullable(r5.getNullable());
            L15:
                if (r5.hasFlexibleTypeCapabilitiesId() == false) goto L18;
                setFlexibleTypeCapabilitiesId(r5.getFlexibleTypeCapabilitiesId());
            L18:
                if (r5.hasFlexibleUpperBound() == false) goto L21;
                mergeFlexibleUpperBound(r5.getFlexibleUpperBound());
            L21:
                if (r5.hasFlexibleUpperBoundId() == false) goto L24;
                setFlexibleUpperBoundId(r5.getFlexibleUpperBoundId());
            L24:
                if (r5.hasClassName() == false) goto L27;
                setClassName(r5.getClassName());
            L27:
                if (r5.hasTypeParameter() == false) goto L30;
                setTypeParameter(r5.getTypeParameter());
            L30:
                if (r5.hasTypeParameterName() == false) goto L33;
                setTypeParameterName(r5.getTypeParameterName());
            L33:
                if (r5.hasTypeAliasName() == false) goto L36;
                setTypeAliasName(r5.getTypeAliasName());
            L36:
                if (r5.hasOuterType() == false) goto L39;
                mergeOuterType(r5.getOuterType());
            L39:
                if (r5.hasOuterTypeId() == false) goto L42;
                setOuterTypeId(r5.getOuterTypeId());
            L42:
                if (r5.hasAbbreviatedType() == false) goto L45;
                mergeAbbreviatedType(r5.getAbbreviatedType());
            L45:
                if (r5.hasAbbreviatedTypeId() == false) goto L48;
                setAbbreviatedTypeId(r5.getAbbreviatedTypeId());
            L48:
                if (r5.hasFlags() == false) goto L50;
                setFlags(r5.getFlags());
            L50:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(Type.access$7400(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Type r11 = null;
                Type r12 = Type.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Type r13 = (Type) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Type r5 = new Type(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Type(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$5900(Type r5) {
            return r5.argument_;
        }

        public static /* synthetic */ List access$5902(Type r5, List r10) {
            r5.argument_ = r10;
            return r10;
        }

        public static /* synthetic */ boolean access$6002(Type r5, boolean r10) {
            r5.nullable_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6102(Type r5, int r10) {
            r5.flexibleTypeCapabilitiesId_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$6202(Type r5, Type r10) {
            r5.flexibleUpperBound_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6302(Type r5, int r10) {
            r5.flexibleUpperBoundId_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6402(Type r5, int r10) {
            r5.className_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6502(Type r5, int r10) {
            r5.typeParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6602(Type r5, int r10) {
            r5.typeParameterName_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6702(Type r5, int r10) {
            r5.typeAliasName_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$6802(Type r5, Type r10) {
            r5.outerType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$6902(Type r5, int r10) {
            r5.outerTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$7002(Type r5, Type r10) {
            r5.abbreviatedType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$7102(Type r5, int r10) {
            r5.abbreviatedTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$7202(Type r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$7302(Type r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$7400(Type r5) {
            return r5.unknownFields;
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
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

        public static Builder newBuilder() {
            return Builder.access$5700();
        }

        public Type getAbbreviatedType() {
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

        public int getClassName() {
            return this.className_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Type> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 4096) != 4096) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.flags_);
        L10:
            if (r10 >= this.argument_.size()) goto L13;
            r11 = r11 + CodedOutputStream.computeMessageSize(2, this.argument_.get(r10));
            r10 = r10 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 1) != 1) goto L16;
            r11 = r11 + CodedOutputStream.computeBoolSize(3, this.nullable_);
        L16:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r11 = r11 + CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        L19:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r11 = r11 + CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        L22:
            if ((this.bitField0_ & 16) != 16) goto L25;
            r11 = r11 + CodedOutputStream.computeInt32Size(6, this.className_);
        L25:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r11 = r11 + CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        L28:
            if ((this.bitField0_ & 8) != 8) goto L31;
            r11 = r11 + CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        L31:
            if ((this.bitField0_ & 64) != 64) goto L34;
            r11 = r11 + CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        L34:
            if ((this.bitField0_ & 256) != 256) goto L37;
            r11 = r11 + CodedOutputStream.computeMessageSize(10, this.outerType_);
        L37:
            if ((this.bitField0_ & 512) != 512) goto L40;
            r11 = r11 + CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        L40:
            if ((this.bitField0_ & 128) != 128) goto L43;
            r11 = r11 + CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        L43:
            if ((this.bitField0_ & 1024) != 1024) goto L46;
            r11 = r11 + CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        L46:
            if ((this.bitField0_ & 2048) != 2048) goto L48;
            r11 = r11 + CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            if ((this.bitField0_ & 4096) != 4096) goto L5;
            r10.writeInt32(1, this.flags_);
        L5:
            int r11 = 0;
        L7:
            if (r11 >= this.argument_.size()) goto L10;
            r10.writeMessage(2, this.argument_.get(r11));
            r11 = r11 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 1) != 1) goto L13;
            r10.writeBool(3, this.nullable_);
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r10.writeInt32(4, this.flexibleTypeCapabilitiesId_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L19;
            r10.writeMessage(5, this.flexibleUpperBound_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r10.writeInt32(6, this.className_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r10.writeInt32(7, this.typeParameter_);
        L25:
            if ((this.bitField0_ & 8) != 8) goto L28;
            r10.writeInt32(8, this.flexibleUpperBoundId_);
        L28:
            if ((this.bitField0_ & 64) != 64) goto L31;
            r10.writeInt32(9, this.typeParameterName_);
        L31:
            if ((this.bitField0_ & 256) != 256) goto L34;
            r10.writeMessage(10, this.outerType_);
        L34:
            if ((this.bitField0_ & 512) != 512) goto L37;
            r10.writeInt32(11, this.outerTypeId_);
        L37:
            if ((this.bitField0_ & 128) != 128) goto L40;
            r10.writeInt32(12, this.typeAliasName_);
        L40:
            if ((this.bitField0_ & 1024) != 1024) goto L43;
            r10.writeMessage(13, this.abbreviatedType_);
        L43:
            if ((this.bitField0_ & 2048) != 2048) goto L45;
            r10.writeInt32(14, this.abbreviatedTypeId_);
        L45:
            r5.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Type(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Type r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private Type(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Type(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            boolean r14 = false;
        L3:
            if (r13 == true) goto L63;
            int r15 = r10.readTag();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            Builder r16 = null;
            switch(r15) {
                case 0: goto L8;
                case 8: goto L48;
                case 18: goto L45;
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
            r13 = true;
            goto L3
        L15:
            this.bitField0_ |= 2048;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.abbreviatedTypeId_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L17:
            if ((this.bitField0_ & 1024) != 1024) goto L19;
            r16 = this.abbreviatedType_.toBuilder();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        L19:
            Type r17 = (Type) r10.readMessage(PARSER, r11);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.abbreviatedType_ = r17;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            if (r16 == null) goto L22;
            r16.mergeFrom(r17);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.abbreviatedType_ = r16.buildPartial();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        L22:
            this.bitField0_ |= 1024;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L23:
            this.bitField0_ |= 128;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.typeAliasName_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L24:
            this.bitField0_ |= 512;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.outerTypeId_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L26:
            if ((this.bitField0_ & 256) != 256) goto L28;
            r16 = this.outerType_.toBuilder();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        L28:
            Type r18 = (Type) r10.readMessage(PARSER, r11);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.outerType_ = r18;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            if (r16 == null) goto L31;
            r16.mergeFrom(r18);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.outerType_ = r16.buildPartial();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        L31:
            this.bitField0_ |= 256;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L32:
            this.bitField0_ |= 64;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.typeParameterName_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L33:
            this.bitField0_ |= 8;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.flexibleUpperBoundId_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L34:
            this.bitField0_ |= 32;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.typeParameter_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L35:
            this.bitField0_ |= 16;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.className_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L37:
            if ((this.bitField0_ & 4) != 4) goto L39;
            r16 = this.flexibleUpperBound_.toBuilder();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        L39:
            Type r19 = (Type) r10.readMessage(PARSER, r11);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.flexibleUpperBound_ = r19;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            if (r16 == null) goto L42;
            r16.mergeFrom(r19);     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.flexibleUpperBound_ = r16.buildPartial();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
        L42:
            this.bitField0_ |= 4;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L43:
            this.bitField0_ |= 2;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.flexibleTypeCapabilitiesId_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L44:
            this.bitField0_ |= 1;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.nullable_ = r10.readBool();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L45:
            if (r14 == true) goto L47;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            r14 = true;
        L47:
            this.argument_.add((Argument) r10.readMessage(Argument.PARSER, r11));     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L48:
            this.bitField0_ |= 4096;     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            this.flags_ = r10.readInt32();     // Catch: Throwable -> L9 IOException -> L11 InvalidProtocolBufferException -> L13
            goto L3
        L7:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L3;
        L9:
            th = move-exception;
            if (r14 != true) goto L76;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L76:
            r12.flush();     // Catch: IOException -> L73 Throwable -> L58
        L58:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L57:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L13:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L9
        L11:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L9
        L63:
            if (r14 != true) goto L78;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L78:
            r12.flush();     // Catch: IOException -> L72 Throwable -> L67
        L67:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L66:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> PARSER;
        private static final TypeAlias defaultInstance = null;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private List<Annotation> annotation_;
            private int bitField0_;
            private int expandedTypeId_;
            private Type expandedType_;
            private int flags_;
            private int name_;
            private List<TypeParameter> typeParameter_;
            private int underlyingTypeId_;
            private Type underlyingType_;
            private List<Integer> versionRequirement_;

            private Builder() {
                this.flags_ = 6;
                this.typeParameter_ = Collections.emptyList();
                this.underlyingType_ = Type.getDefaultInstance();
                this.expandedType_ = Type.getDefaultInstance();
                this.annotation_ = Collections.emptyList();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$19000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 128) == 128) goto L6;
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= 128;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 4;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 256;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public TypeAlias buildPartial() {
                TypeAlias r5 = new TypeAlias(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                TypeAlias.access$19202(r5, this.flags_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                TypeAlias.access$19302(r5, this.name_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            L12:
                TypeAlias.access$19402(r5, this.typeParameter_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 4;
            L15:
                TypeAlias.access$19502(r5, this.underlyingType_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 8;
            L18:
                TypeAlias.access$19602(r5, this.underlyingTypeId_);
                if ((r10 & 32) != 32) goto L21;
                r11 = r11 | 16;
            L21:
                TypeAlias.access$19702(r5, this.expandedType_);
                if ((r10 & 64) != 64) goto L24;
                r11 = r11 | 32;
            L24:
                TypeAlias.access$19802(r5, this.expandedTypeId_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            L27:
                TypeAlias.access$19902(r5, this.annotation_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            L30:
                TypeAlias.access$20002(r5, this.versionRequirement_);
                TypeAlias.access$20102(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            public Annotation getAnnotation(int r5) {
                return this.annotation_.get(r5);
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public TypeParameter getTypeParameter(int r5) {
                return this.typeParameter_.get(r5);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            public boolean hasExpandedType() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasUnderlyingType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L5;
                return false;
            L5:
                int r5 = 0;
            L7:
                if (r5 >= getTypeParameterCount()) goto L13;
                if (getTypeParameter(r5).isInitialized() == false) goto L10;
                r5 = r5 + 1;
                goto L7
            L10:
                return false;
            L13:
                if (hasUnderlyingType() == false) goto L18;
                if (getUnderlyingType().isInitialized() == true) goto L18;
                return false;
            L18:
                if (hasExpandedType() == true) goto L20;
            L22:
                int r10 = 0;
            L24:
                if (r10 >= getAnnotationCount()) goto L30;
                if (getAnnotation(r10).isInitialized() == false) goto L27;
                r10 = r10 + 1;
                goto L24
            L27:
                return false;
            L30:
                if (extensionsAreInitialized() == true) goto L32;
                return false;
            L32:
                return true;
            L20:
                if (getExpandedType().isInitialized() == true) goto L22;
                return false;
            }

            public Builder mergeExpandedType(Type r5) {
                if ((this.bitField0_ & 32) == 32) goto L5;
            L7:
                this.expandedType_ = r5;
            L8:
                this.bitField0_ |= 32;
                return this;
            L5:
                if (this.expandedType_ == Type.getDefaultInstance()) goto L7;
                this.expandedType_ = Type.newBuilder(this.expandedType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeUnderlyingType(Type r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.underlyingType_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.underlyingType_ == Type.getDefaultInstance()) goto L7;
                this.underlyingType_ = Type.newBuilder(this.underlyingType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder setExpandedTypeId(int r5) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = r5;
                return this;
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 1;
                this.flags_ = r5;
                return this;
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 2;
                this.name_ = r5;
                return this;
            }

            public Builder setUnderlyingTypeId(int r5) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeAlias build() {
                TypeAlias r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((TypeAlias) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(TypeAlias r5) {
                if (r5 != TypeAlias.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasFlags() == false) goto L9;
                setFlags(r5.getFlags());
            L9:
                if (r5.hasName() == false) goto L12;
                setName(r5.getName());
            L12:
                if (TypeAlias.access$19400(r5).isEmpty() == true) goto L18;
                if (this.typeParameter_.isEmpty() == false) goto L16;
                this.typeParameter_ = TypeAlias.access$19400(r5);
                this.bitField0_ &= -5;
                goto L18
            L16:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(TypeAlias.access$19400(r5));
            L18:
                if (r5.hasUnderlyingType() == false) goto L21;
                mergeUnderlyingType(r5.getUnderlyingType());
            L21:
                if (r5.hasUnderlyingTypeId() == false) goto L24;
                setUnderlyingTypeId(r5.getUnderlyingTypeId());
            L24:
                if (r5.hasExpandedType() == false) goto L27;
                mergeExpandedType(r5.getExpandedType());
            L27:
                if (r5.hasExpandedTypeId() == false) goto L30;
                setExpandedTypeId(r5.getExpandedTypeId());
            L30:
                if (TypeAlias.access$19900(r5).isEmpty() == true) goto L36;
                if (this.annotation_.isEmpty() == false) goto L34;
                this.annotation_ = TypeAlias.access$19900(r5);
                this.bitField0_ &= -129;
                goto L36
            L34:
                ensureAnnotationIsMutable();
                this.annotation_.addAll(TypeAlias.access$19900(r5));
            L36:
                if (TypeAlias.access$20000(r5).isEmpty() == false) goto L38;
            L41:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(TypeAlias.access$20200(r5)));
                return this;
            L38:
                if (this.versionRequirement_.isEmpty() == false) goto L40;
                this.versionRequirement_ = TypeAlias.access$20000(r5);
                this.bitField0_ &= -257;
                goto L41
            L40:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(TypeAlias.access$20000(r5));
                goto L41
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                TypeAlias r11 = null;
                TypeAlias r12 = TypeAlias.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeAlias r13 = (TypeAlias) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            TypeAlias r5 = new TypeAlias(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ TypeAlias(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$19202(TypeAlias r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$19302(TypeAlias r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$19400(TypeAlias r5) {
            return r5.typeParameter_;
        }

        public static /* synthetic */ List access$19402(TypeAlias r5, List r10) {
            r5.typeParameter_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$19502(TypeAlias r5, Type r10) {
            r5.underlyingType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$19602(TypeAlias r5, int r10) {
            r5.underlyingTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$19702(TypeAlias r5, Type r10) {
            r5.expandedType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$19802(TypeAlias r5, int r10) {
            r5.expandedTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$19900(TypeAlias r5) {
            return r5.annotation_;
        }

        public static /* synthetic */ List access$19902(TypeAlias r5, List r10) {
            r5.annotation_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$20000(TypeAlias r5) {
            return r5.versionRequirement_;
        }

        public static /* synthetic */ List access$20002(TypeAlias r5, List r10) {
            r5.versionRequirement_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$20102(TypeAlias r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$20200(TypeAlias r5) {
            return r5.unknownFields;
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$19000();
        }

        public static TypeAlias parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseDelimitedFrom(r5, r10);
        }

        public Annotation getAnnotation(int r5) {
            return this.annotation_.get(r5);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.flags_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.name_);
        L12:
            int r12 = 0;
        L14:
            if (r12 >= this.typeParameter_.size()) goto L17;
            r11 = r11 + CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(r12));
            r12 = r12 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 4) != 4) goto L20;
            r11 = r11 + CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        L20:
            if ((this.bitField0_ & 8) != 8) goto L23;
            r11 = r11 + CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        L23:
            if ((this.bitField0_ & 16) != 16) goto L26;
            r11 = r11 + CodedOutputStream.computeMessageSize(6, this.expandedType_);
        L26:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r11 = r11 + CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        L28:
            int r13 = 0;
        L30:
            if (r13 >= this.annotation_.size()) goto L32;
            r11 = r11 + CodedOutputStream.computeMessageSize(8, this.annotation_.get(r13));
            r13 = r13 + 1;
            goto L30
        L32:
            int r14 = 0;
        L34:
            if (r10 >= this.versionRequirement_.size()) goto L36;
            r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r10).intValue());
            r10 = r10 + 1;
            goto L34
        L36:
            int r15 = this.unknownFields.size() + (extensionsSerializedSize() + ((getVersionRequirementList().size() * 2) + (r11 + r14)));
            this.memoizedSerializedSize = r15;
            return r15;
        L8:
            r11 = 0;
            goto L10
        }

        public TypeParameter getTypeParameter(int r5) {
            return this.typeParameter_.get(r5);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasExpandedType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasExpandedTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
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

        public boolean hasUnderlyingType() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasUnderlyingTypeId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r10 = 0;
        L14:
            if (r10 >= getTypeParameterCount()) goto L21;
            if (getTypeParameter(r10).isInitialized() == false) goto L17;
            r10 = r10 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L21:
            if (hasUnderlyingType() == false) goto L27;
            if (getUnderlyingType().isInitialized() == true) goto L27;
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasExpandedType() == true) goto L29;
        L32:
            int r11 = 0;
        L34:
            if (r11 >= getAnnotationCount()) goto L41;
            if (getAnnotation(r11).isInitialized() == false) goto L37;
            r11 = r11 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L41:
            if (extensionsAreInitialized() == true) goto L44;
            this.memoizedIsInitialized = 0;
            return false;
        L44:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getExpandedType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r10.writeInt32(2, this.name_);
        L8:
            int r11 = 0;
            int r12 = 0;
        L10:
            if (r12 >= this.typeParameter_.size()) goto L13;
            r10.writeMessage(3, this.typeParameter_.get(r12));
            r12 = r12 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r10.writeMessage(4, this.underlyingType_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r10.writeInt32(5, this.underlyingTypeId_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r10.writeMessage(6, this.expandedType_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L24;
            r10.writeInt32(7, this.expandedTypeId_);
        L24:
            int r13 = 0;
        L26:
            if (r13 >= this.annotation_.size()) goto L29;
            r10.writeMessage(8, this.annotation_.get(r13));
            r13 = r13 + 1;
        L29:
            if (r11 >= this.versionRequirement_.size()) goto L31;
            r10.writeInt32(31, this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L29
        L31:
            r5.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ TypeAlias(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(TypeAlias r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private TypeAlias(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeAlias(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r11 = false;
            int r14 = 0;
        L4:
            if (r11 == true) goto L77;
            int r15 = r12.readTag();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            Type.Builder r16 = null;
            switch(r15) {
                case 0: goto L9;
                case 8: goto L54;
                case 16: goto L53;
                case 26: goto L50;
                case 34: goto L43;
                case 40: goto L41;
                case 50: goto L35;
                case 56: goto L33;
                case 66: goto L30;
                case 248: goto L26;
                case 250: goto L16;
                default: goto L8;
            };     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L9:
            r11 = true;
            goto L4
        L16:
            int r17 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if ((r14 & 256) == 256) goto L22;
            if (r12.getBytesUntilLimit() <= 0) goto L22;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r14 = r14 | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L22:
            if (r12.getBytesUntilLimit() <= 0) goto L24;
            this.versionRequirement_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L22
        L24:
            r12.popLimit(r17);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L26:
            if ((r14 & 256) == 256) goto L28;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r14 = r14 | 256;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L28:
            this.versionRequirement_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L30:
            if ((r14 & 128) == 128) goto L32;
            this.annotation_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r14 = r14 | 128;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L32:
            this.annotation_.add((Annotation) r12.readMessage(Annotation.PARSER, r13));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L33:
            this.bitField0_ |= 32;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.expandedTypeId_ = r12.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L35:
            if ((this.bitField0_ & 16) != 16) goto L37;
            r16 = this.expandedType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L37:
            Type r18 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.expandedType_ = r18;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r16 == null) goto L40;
            r16.mergeFrom(r18);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.expandedType_ = r16.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L40:
            this.bitField0_ |= 16;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L41:
            this.bitField0_ |= 8;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.underlyingTypeId_ = r12.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L43:
            if ((this.bitField0_ & 4) != 4) goto L45;
            r16 = this.underlyingType_.toBuilder();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L45:
            Type r19 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.underlyingType_ = r19;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            if (r16 == null) goto L48;
            r16.mergeFrom(r19);     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.underlyingType_ = r16.buildPartial();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L48:
            this.bitField0_ |= 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L50:
            if ((r14 & 4) == 4) goto L52;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            r14 = r14 | 4;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
        L52:
            this.typeParameter_.add((TypeParameter) r12.readMessage(TypeParameter.PARSER, r13));     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L53:
            this.bitField0_ |= 2;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.name_ = r12.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L54:
            this.bitField0_ |= 1;     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            this.flags_ = r12.readInt32();     // Catch: Throwable -> L10 IOException -> L12 InvalidProtocolBufferException -> L14
            goto L4
        L8:
            if (parseUnknownField(r12, r10, r13, r15) == true) goto L4;
        L10:
            th = move-exception;
            if ((r14 & 4) != 4) goto L64;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L64:
            if ((r14 & 128) != 128) goto L67;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L67:
            if ((r14 & 256) != 256) goto L95;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L95:
            r10.flush();     // Catch: IOException -> L93 Throwable -> L71
        L71:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L70:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L14:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L10
        L12:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L10
        L77:
            if ((r14 & 4) != 4) goto L80;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L80:
            if ((r14 & 128) != 128) goto L83;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L83:
            if ((r14 & 256) != 256) goto L98;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L98:
            r10.flush();     // Catch: IOException -> L92 Throwable -> L87
        L87:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L86:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> PARSER;
        private static final TypeParameter defaultInstance = null;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final ByteString unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private List<Integer> upperBoundId_;
            private List<Type> upperBound_;
            private Variance variance_;

            private Builder() {
                this.variance_ = Variance.INV;
                this.upperBound_ = Collections.emptyList();
                this.upperBoundId_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$7600() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.upperBound_ = new ArrayList(this.upperBound_);
                this.bitField0_ |= 16;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public TypeParameter buildPartial() {
                TypeParameter r5 = new TypeParameter(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                TypeParameter.access$7802(r5, this.id_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                TypeParameter.access$7902(r5, this.name_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                TypeParameter.access$8002(r5, this.reified_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 8;
            L15:
                TypeParameter.access$8102(r5, this.variance_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                this.bitField0_ &= -17;
            L18:
                TypeParameter.access$8202(r5, this.upperBound_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                this.bitField0_ &= -33;
            L21:
                TypeParameter.access$8302(r5, this.upperBoundId_);
                TypeParameter.access$8402(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getUpperBound(int r5) {
                return this.upperBound_.get(r5);
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

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId() == true) goto L6;
                return false;
            L6:
                if (hasName() == true) goto L8;
                return false;
            L8:
                int r5 = 0;
            L10:
                if (r5 >= getUpperBoundCount()) goto L16;
                if (getUpperBound(r5).isInitialized() == false) goto L13;
                r5 = r5 + 1;
                goto L10
            L13:
                return false;
            L16:
                if (extensionsAreInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setId(int r5) {
                this.bitField0_ |= 1;
                this.id_ = r5;
                return this;
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 2;
                this.name_ = r5;
                return this;
            }

            public Builder setReified(boolean r5) {
                this.bitField0_ |= 4;
                this.reified_ = r5;
                return this;
            }

            public Builder setVariance(Variance r5) {
                r5.getClass();
                this.bitField0_ |= 8;
                this.variance_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeParameter build() {
                TypeParameter r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((TypeParameter) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(TypeParameter r5) {
                if (r5 != TypeParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasId() == false) goto L9;
                setId(r5.getId());
            L9:
                if (r5.hasName() == false) goto L12;
                setName(r5.getName());
            L12:
                if (r5.hasReified() == false) goto L15;
                setReified(r5.getReified());
            L15:
                if (r5.hasVariance() == false) goto L18;
                setVariance(r5.getVariance());
            L18:
                if (TypeParameter.access$8200(r5).isEmpty() == true) goto L24;
                if (this.upperBound_.isEmpty() == false) goto L22;
                this.upperBound_ = TypeParameter.access$8200(r5);
                this.bitField0_ &= -17;
                goto L24
            L22:
                ensureUpperBoundIsMutable();
                this.upperBound_.addAll(TypeParameter.access$8200(r5));
            L24:
                if (TypeParameter.access$8300(r5).isEmpty() == false) goto L26;
            L29:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(TypeParameter.access$8500(r5)));
                return this;
            L26:
                if (this.upperBoundId_.isEmpty() == false) goto L28;
                this.upperBoundId_ = TypeParameter.access$8300(r5);
                this.bitField0_ &= -33;
                goto L29
            L28:
                ensureUpperBoundIdIsMutable();
                this.upperBoundId_.addAll(TypeParameter.access$8300(r5));
                goto L29
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                TypeParameter r11 = null;
                TypeParameter r12 = TypeParameter.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeParameter r13 = (TypeParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        public static final enum Variance extends Enum<Variance> implements Internal.EnumLite {
            private static final /* synthetic */ Variance[] $VALUES = null;
            public static final Variance IN = null;
            public static final Variance INV = null;
            public static final Variance OUT = null;
            private static Internal.EnumLiteMap<Variance> internalValueMap;
            private final int value;

            static {
                Variance r5 = new Variance("IN", 0, 0, 0);
                IN = r5;
                Variance r10 = new Variance("OUT", 1, 1, 1);
                OUT = r10;
                Variance r11 = new Variance("INV", 2, 2, 2);
                INV = r11;
                $VALUES = new Variance[]{r5, r10, r11};
                internalValueMap = new AnonymousClass1();
            }

            private Variance(String r5, int r10, int r11, int r12) {
                super(r5, r10);
                this.value = r12;
            }

            public static Variance valueOf(String r5) {
                return (Variance) Enum.valueOf(Variance.class, r5);
            }

            public static Variance[] values() {
                return (Variance[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int r5) {
                if (r5 == 0) goto L14;
                if (r5 == 1) goto L12;
                if (r5 == 2) goto L10;
                return null;
            L10:
                return INV;
            L12:
                return OUT;
            L14:
                return IN;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            TypeParameter r5 = new TypeParameter(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ TypeParameter(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$7802(TypeParameter r5, int r10) {
            r5.id_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$7902(TypeParameter r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ boolean access$8002(TypeParameter r5, boolean r10) {
            r5.reified_ = r10;
            return r10;
        }

        public static /* synthetic */ Variance access$8102(TypeParameter r5, Variance r10) {
            r5.variance_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$8200(TypeParameter r5) {
            return r5.upperBound_;
        }

        public static /* synthetic */ List access$8202(TypeParameter r5, List r10) {
            r5.upperBound_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$8300(TypeParameter r5) {
            return r5.upperBoundId_;
        }

        public static /* synthetic */ List access$8302(TypeParameter r5, List r10) {
            r5.upperBoundId_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$8402(TypeParameter r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$8500(TypeParameter r5) {
            return r5.unknownFields;
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$7600();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeInt32Size(1, this.id_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r11 = r11 + CodedOutputStream.computeBoolSize(3, this.reified_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r11 = r11 + CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        L18:
            int r12 = 0;
        L20:
            if (r12 >= this.upperBound_.size()) goto L22;
            r11 = r11 + CodedOutputStream.computeMessageSize(5, this.upperBound_.get(r12));
            r12 = r12 + 1;
            goto L20
        L22:
            int r13 = 0;
        L24:
            if (r10 >= this.upperBoundId_.size()) goto L26;
            r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(r10).intValue());
            r10 = r10 + 1;
            goto L24
        L26:
            int r14 = r11 + r13;
            if (getUpperBoundIdList().isEmpty() == true) goto L29;
            r14 = (r14 + 1) + CodedOutputStream.computeInt32SizeNoTag(r13);
        L29:
            this.upperBoundIdMemoizedSerializedSize = r13;
            int r15 = this.unknownFields.size() + (extensionsSerializedSize() + r14);
            this.memoizedSerializedSize = r15;
            return r15;
        L8:
            r11 = 0;
            goto L10
        }

        public Type getUpperBound(int r5) {
            return this.upperBound_.get(r5);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public Variance getVariance() {
            return this.variance_;
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
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
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
            int r10 = 0;
        L18:
            if (r10 >= getUpperBoundCount()) goto L25;
            if (getUpperBound(r10).isInitialized() == false) goto L21;
            r10 = r10 + 1;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r5 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.id_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r10.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r10.writeBool(3, this.reified_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L14;
            r10.writeEnum(4, this.variance_.getNumber());
        L14:
            int r11 = 0;
            int r12 = 0;
        L16:
            if (r12 >= this.upperBound_.size()) goto L19;
            r10.writeMessage(5, this.upperBound_.get(r12));
            r12 = r12 + 1;
            goto L16
        L19:
            if (getUpperBoundIdList().size() <= 0) goto L22;
            r10.writeRawVarint32(50);
            r10.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        L22:
            if (r11 >= this.upperBoundId_.size()) goto L24;
            r10.writeInt32NoTag(this.upperBoundId_.get(r11).intValue());
            r11 = r11 + 1;
            goto L22
        L24:
            r5.writeUntil(1000, r10);
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ TypeParameter(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(TypeParameter r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> r5) {
            super(r5);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private TypeParameter(boolean r5) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeParameter(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r11 = false;
            int r14 = 0;
        L4:
            if (r11 == true) goto L71;
            int r15 = r12.readTag();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            if (r15 == 0) goto L21;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            this.id_ = r12.readInt32();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L9:
            if (r15 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            this.name_ = r12.readInt32();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L11:
            if (r15 != 24) goto L12;
            this.bitField0_ |= 4;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            this.reified_ = r12.readBool();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (r15 != 32) goto L14;
            int r16 = r12.readEnum();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            Variance r17 = Variance.valueOf(r16);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            if (r17 == null) goto L47;
            this.bitField0_ |= 8;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            this.variance_ = r17;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L47:
            r10.writeRawVarint32(r15);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            r10.writeRawVarint32(r16);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L14:
            if (r15 != 42) goto L16;
            if ((r14 & 16) == 16) goto L44;
            this.upperBound_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            r14 = r14 | 16;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        L44:
            this.upperBound_.add((Type) r12.readMessage(Type.PARSER, r13));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L16:
            if (r15 != 48) goto L18;
            if ((r14 & 32) == 32) goto L40;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            r14 = r14 | 32;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        L40:
            this.upperBoundId_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L18:
            if (r15 != 50) goto L20;
            int r18 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            if ((r14 & 32) == 32) goto L34;
            if (r12.getBytesUntilLimit() <= 0) goto L34;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            r14 = r14 | 32;     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
        L34:
            if (r12.getBytesUntilLimit() <= 0) goto L36;
            this.upperBoundId_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L34
        L36:
            r12.popLimit(r18);     // Catch: Throwable -> L22 IOException -> L24 InvalidProtocolBufferException -> L26
            goto L4
        L20:
            if (parseUnknownField(r12, r10, r13, r15) == true) goto L4;
        L21:
            r11 = true;
            goto L4
        L22:
            th = move-exception;
            if ((r14 & 16) != 16) goto L61;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L61:
            if ((r14 & 32) != 32) goto L87;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L87:
            r10.flush();     // Catch: IOException -> L84 Throwable -> L65
        L65:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L64:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L26:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L22
        L24:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L22
        L71:
            if ((r14 & 16) != 16) goto L74;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L74:
            if ((r14 & 32) != 32) goto L89;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L89:
            r10.flush();     // Catch: IOException -> L83 Throwable -> L78
        L78:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L77:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> PARSER;
        private static final TypeTable defaultInstance = null;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int bitField0_;
            private int firstNullable_;
            private List<Type> type_;

            private Builder() {
                this.type_ = Collections.emptyList();
                this.firstNullable_ = -1;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$12600() {
                return create();
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

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public TypeTable buildPartial() {
                TypeTable r5 = new TypeTable(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) != 1) goto L5;
                this.type_ = Collections.unmodifiableList(this.type_);
                this.bitField0_ &= -2;
            L5:
                TypeTable.access$12802(r5, this.type_);
                if ((r10 & 2) == 2) goto L9;
                r11 = 0;
            L9:
                TypeTable.access$12902(r5, this.firstNullable_);
                TypeTable.access$13002(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getType(int r5) {
                return this.type_.get(r5);
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getTypeCount()) goto L9;
                if (getType(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setFirstNullable(int r5) {
                this.bitField0_ |= 2;
                this.firstNullable_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeTable build() {
                TypeTable r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((TypeTable) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(TypeTable r5) {
                if (r5 != TypeTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (TypeTable.access$12800(r5).isEmpty() == true) goto L12;
                if (this.type_.isEmpty() == false) goto L10;
                this.type_ = TypeTable.access$12800(r5);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureTypeIsMutable();
                this.type_.addAll(TypeTable.access$12800(r5));
            L12:
                if (r5.hasFirstNullable() == false) goto L14;
                setFirstNullable(r5.getFirstNullable());
            L14:
                setUnknownFields(getUnknownFields().concat(TypeTable.access$13100(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                TypeTable r11 = null;
                TypeTable r12 = TypeTable.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeTable r13 = (TypeTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            TypeTable r5 = new TypeTable(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ TypeTable(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$12800(TypeTable r5) {
            return r5.type_;
        }

        public static /* synthetic */ List access$12802(TypeTable r5, List r10) {
            r5.type_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$12902(TypeTable r5, int r10) {
            r5.firstNullable_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$13002(TypeTable r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$13100(TypeTable r5) {
            return r5.unknownFields;
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
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

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r10 >= this.type_.size()) goto L10;
            r11 = r11 + CodedOutputStream.computeMessageSize(1, this.type_.get(r10));
            r10 = r10 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 1) != 1) goto L12;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        L12:
            int r12 = this.unknownFields.size() + r11;
            this.memoizedSerializedSize = r12;
            return r12;
        }

        public Type getType(int r5) {
            return this.type_.get(r5);
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public boolean hasFirstNullable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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
            if (r10 >= getTypeCount()) goto L16;
            if (getType(r10).isInitialized() == false) goto L13;
            r10 = r10 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            int r10 = 0;
        L4:
            if (r10 >= this.type_.size()) goto L7;
            r5.writeMessage(1, this.type_.get(r10));
            r10 = r10 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) != 1) goto L9;
            r5.writeInt32(2, this.firstNullable_);
        L9:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ TypeTable(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(TypeTable r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private TypeTable(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private TypeTable(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeTable(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            boolean r14 = false;
        L3:
            if (r13 == true) goto L37;
            int r15 = r10.readTag();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            if (r15 == 0) goto L12;
            if (r15 != 10) goto L9;
            if (r14 == true) goto L22;
            this.type_ = new ArrayList();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            r14 = true;
        L22:
            this.type_.add((Type) r10.readMessage(Type.PARSER, r11));     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L9:
            if (r15 != 16) goto L11;
            this.bitField0_ |= 1;     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            this.firstNullable_ = r10.readInt32();     // Catch: Throwable -> L13 IOException -> L15 InvalidProtocolBufferException -> L17
            goto L3
        L11:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L3;
        L12:
            r13 = true;
            goto L3
        L13:
            th = move-exception;
            if (r14 != true) goto L49;
            this.type_ = Collections.unmodifiableList(this.type_);
        L49:
            r12.flush();     // Catch: IOException -> L47 Throwable -> L32
        L32:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L31:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L17:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L15:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L13
        L37:
            if (r14 != true) goto L51;
            this.type_ = Collections.unmodifiableList(this.type_);
        L51:
            r12.flush();     // Catch: IOException -> L46 Throwable -> L41
        L41:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L40:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> PARSER;
        private static final ValueParameter defaultInstance = null;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final ByteString unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private Type type_;
            private int varargElementTypeId_;
            private Type varargElementType_;

            private Builder() {
                this.type_ = Type.getDefaultInstance();
                this.varargElementType_ = Type.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$17900() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public ValueParameter buildPartial() {
                ValueParameter r5 = new ValueParameter(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                ValueParameter.access$18102(r5, this.flags_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                ValueParameter.access$18202(r5, this.name_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                ValueParameter.access$18302(r5, this.type_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 8;
            L15:
                ValueParameter.access$18402(r5, this.typeId_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 16;
            L18:
                ValueParameter.access$18502(r5, this.varargElementType_);
                if ((r10 & 32) != 32) goto L21;
                r11 = r11 | 32;
            L21:
                ValueParameter.access$18602(r5, this.varargElementTypeId_);
                ValueParameter.access$18702(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getType() {
                return this.type_;
            }

            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasVarargElementType() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasType() == false) goto L11;
                if (getType().isInitialized() == true) goto L11;
                return false;
            L11:
                if (hasVarargElementType() == false) goto L16;
                if (getVarargElementType().isInitialized() == true) goto L16;
                return false;
            L16:
                if (extensionsAreInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeType(Type r5) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.type_ = r5;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.type_ == Type.getDefaultInstance()) goto L7;
                this.type_ = Type.newBuilder(this.type_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeVarargElementType(Type r5) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.varargElementType_ = r5;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.varargElementType_ == Type.getDefaultInstance()) goto L7;
                this.varargElementType_ = Type.newBuilder(this.varargElementType_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder setFlags(int r5) {
                this.bitField0_ |= 1;
                this.flags_ = r5;
                return this;
            }

            public Builder setName(int r5) {
                this.bitField0_ |= 2;
                this.name_ = r5;
                return this;
            }

            public Builder setTypeId(int r5) {
                this.bitField0_ |= 8;
                this.typeId_ = r5;
                return this;
            }

            public Builder setVarargElementTypeId(int r5) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public ValueParameter build() {
                ValueParameter r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((ValueParameter) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(ValueParameter r5) {
                if (r5 != ValueParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasFlags() == false) goto L9;
                setFlags(r5.getFlags());
            L9:
                if (r5.hasName() == false) goto L12;
                setName(r5.getName());
            L12:
                if (r5.hasType() == false) goto L15;
                mergeType(r5.getType());
            L15:
                if (r5.hasTypeId() == false) goto L18;
                setTypeId(r5.getTypeId());
            L18:
                if (r5.hasVarargElementType() == false) goto L21;
                mergeVarargElementType(r5.getVarargElementType());
            L21:
                if (r5.hasVarargElementTypeId() == false) goto L23;
                setVarargElementTypeId(r5.getVarargElementTypeId());
            L23:
                mergeExtensionFields(r5);
                setUnknownFields(getUnknownFields().concat(ValueParameter.access$18800(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                ValueParameter r11 = null;
                ValueParameter r12 = ValueParameter.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                ValueParameter r13 = (ValueParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            ValueParameter r5 = new ValueParameter(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ ValueParameter(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$18102(ValueParameter r5, int r10) {
            r5.flags_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$18202(ValueParameter r5, int r10) {
            r5.name_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$18302(ValueParameter r5, Type r10) {
            r5.type_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$18402(ValueParameter r5, int r10) {
            r5.typeId_ = r10;
            return r10;
        }

        public static /* synthetic */ Type access$18502(ValueParameter r5, Type r10) {
            r5.varargElementType_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$18602(ValueParameter r5, int r10) {
            r5.varargElementTypeId_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$18702(ValueParameter r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$18800(ValueParameter r5) {
            return r5.unknownFields;
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$17900();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = CodedOutputStream.computeInt32Size(1, this.flags_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r10 = r10 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r10 = r10 + CodedOutputStream.computeMessageSize(3, this.type_);
        L16:
            if ((this.bitField0_ & 16) != 16) goto L19;
            r10 = r10 + CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        L19:
            if ((this.bitField0_ & 8) != 8) goto L22;
            r10 = r10 + CodedOutputStream.computeInt32Size(5, this.typeId_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L24;
            r10 = r10 + CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        L24:
            int r11 = extensionsSerializedSize() + r10;
            int r12 = this.unknownFields.size() + r11;
            this.memoizedSerializedSize = r12;
            return r12;
        L8:
            r10 = 0;
            goto L10
        }

        public Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public boolean hasFlags() {
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

        public boolean hasType() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVarargElementType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVarargElementTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasType() == false) goto L19;
            if (getType().isInitialized() == true) goto L19;
            this.memoizedIsInitialized = 0;
            return false;
        L19:
            if (hasVarargElementType() == false) goto L25;
            if (getVarargElementType().isInitialized() == true) goto L25;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r10 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r5.writeMessage(3, this.type_);
        L12:
            if ((this.bitField0_ & 16) != 16) goto L15;
            r5.writeMessage(4, this.varargElementType_);
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r5.writeInt32(5, this.typeId_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r5.writeInt32(6, this.varargElementTypeId_);
        L20:
            r10.writeUntil(200, r5);
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ ValueParameter(GeneratedMessageLite.ExtendableBuilder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(ValueParameter r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private ValueParameter(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private ValueParameter(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
        L3:
            if (r13 == true) goto L67;
            int r14 = r10.readTag();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            if (r14 == 0) goto L20;
            if (r14 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.flags_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L9:
            if (r14 != 16) goto L10;
            this.bitField0_ |= 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.name_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L10:
            Type.Builder r15 = null;
            if (r14 != 26) goto L13;
            if ((this.bitField0_ & 4) != 4) goto L39;
            r15 = this.type_.toBuilder();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        L39:
            Type r16 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.type_ = r16;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            if (r15 == null) goto L42;
            r15.mergeFrom(r16);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.type_ = r15.buildPartial();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        L42:
            this.bitField0_ |= 4;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L13:
            if (r14 != 34) goto L15;
            if ((this.bitField0_ & 16) != 16) goto L32;
            r15 = this.varargElementType_.toBuilder();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        L32:
            Type r17 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.varargElementType_ = r17;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            if (r15 == null) goto L35;
            r15.mergeFrom(r17);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.varargElementType_ = r15.buildPartial();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
        L35:
            this.bitField0_ |= 16;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L15:
            if (r14 != 40) goto L17;
            this.bitField0_ |= 8;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.typeId_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L17:
            if (r14 != 48) goto L19;
            this.bitField0_ |= 32;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.varargElementTypeId_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L19:
            if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
        L20:
            r13 = true;
            goto L3
        L21:
            th = move-exception;
            r12.flush();     // Catch: IOException -> L64 Throwable -> L52
        L52:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L51:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L25:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L23:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L67:
            r12.flush();     // Catch: IOException -> L65 Throwable -> L59
        L59:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L58:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static Parser<VersionRequirement> PARSER;
        private static final VersionRequirement defaultInstance = null;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final ByteString unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            private int bitField0_;
            private int errorCode_;
            private Level level_;
            private int message_;
            private int versionFull_;
            private VersionKind versionKind_;
            private int version_;

            private Builder() {
                this.level_ = Level.ERROR;
                this.versionKind_ = VersionKind.LANGUAGE_VERSION;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$21000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public VersionRequirement buildPartial() {
                VersionRequirement r5 = new VersionRequirement(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) == 1) goto L6;
                r11 = 0;
            L6:
                VersionRequirement.access$21202(r5, this.version_);
                if ((r10 & 2) != 2) goto L9;
                r11 = r11 | 2;
            L9:
                VersionRequirement.access$21302(r5, this.versionFull_);
                if ((r10 & 4) != 4) goto L12;
                r11 = r11 | 4;
            L12:
                VersionRequirement.access$21402(r5, this.level_);
                if ((r10 & 8) != 8) goto L15;
                r11 = r11 | 8;
            L15:
                VersionRequirement.access$21502(r5, this.errorCode_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 16;
            L18:
                VersionRequirement.access$21602(r5, this.message_);
                if ((r10 & 32) != 32) goto L21;
                r11 = r11 | 32;
            L21:
                VersionRequirement.access$21702(r5, this.versionKind_);
                VersionRequirement.access$21802(r5, r11);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setErrorCode(int r5) {
                this.bitField0_ |= 8;
                this.errorCode_ = r5;
                return this;
            }

            public Builder setLevel(Level r5) {
                r5.getClass();
                this.bitField0_ |= 4;
                this.level_ = r5;
                return this;
            }

            public Builder setMessage(int r5) {
                this.bitField0_ |= 16;
                this.message_ = r5;
                return this;
            }

            public Builder setVersion(int r5) {
                this.bitField0_ |= 1;
                this.version_ = r5;
                return this;
            }

            public Builder setVersionFull(int r5) {
                this.bitField0_ |= 2;
                this.versionFull_ = r5;
                return this;
            }

            public Builder setVersionKind(VersionKind r5) {
                r5.getClass();
                this.bitField0_ |= 32;
                this.versionKind_ = r5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirement build() {
                VersionRequirement r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((VersionRequirement) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(VersionRequirement r5) {
                if (r5 != VersionRequirement.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasVersion() == false) goto L9;
                setVersion(r5.getVersion());
            L9:
                if (r5.hasVersionFull() == false) goto L12;
                setVersionFull(r5.getVersionFull());
            L12:
                if (r5.hasLevel() == false) goto L15;
                setLevel(r5.getLevel());
            L15:
                if (r5.hasErrorCode() == false) goto L18;
                setErrorCode(r5.getErrorCode());
            L18:
                if (r5.hasMessage() == false) goto L21;
                setMessage(r5.getMessage());
            L21:
                if (r5.hasVersionKind() == false) goto L23;
                setVersionKind(r5.getVersionKind());
            L23:
                setUnknownFields(getUnknownFields().concat(VersionRequirement.access$21900(r5)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                VersionRequirement r11 = null;
                VersionRequirement r12 = VersionRequirement.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirement r13 = (VersionRequirement) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        public static final enum Level extends Enum<Level> implements Internal.EnumLite {
            private static final /* synthetic */ Level[] $VALUES = null;
            public static final Level ERROR = null;
            public static final Level HIDDEN = null;
            public static final Level WARNING = null;
            private static Internal.EnumLiteMap<Level> internalValueMap;
            private final int value;

            static {
                Level r5 = new Level("WARNING", 0, 0, 0);
                WARNING = r5;
                Level r10 = new Level("ERROR", 1, 1, 1);
                ERROR = r10;
                Level r11 = new Level("HIDDEN", 2, 2, 2);
                HIDDEN = r11;
                $VALUES = new Level[]{r5, r10, r11};
                internalValueMap = new AnonymousClass1();
            }

            private Level(String r5, int r10, int r11, int r12) {
                super(r5, r10);
                this.value = r12;
            }

            public static Level valueOf(String r5) {
                return (Level) Enum.valueOf(Level.class, r5);
            }

            public static Level[] values() {
                return (Level[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int r5) {
                if (r5 == 0) goto L14;
                if (r5 == 1) goto L12;
                if (r5 == 2) goto L10;
                return null;
            L10:
                return HIDDEN;
            L12:
                return ERROR;
            L14:
                return WARNING;
            }
        }

        public static final enum VersionKind extends Enum<VersionKind> implements Internal.EnumLite {
            private static final /* synthetic */ VersionKind[] $VALUES = null;
            public static final VersionKind API_VERSION = null;
            public static final VersionKind COMPILER_VERSION = null;
            public static final VersionKind LANGUAGE_VERSION = null;
            private static Internal.EnumLiteMap<VersionKind> internalValueMap;
            private final int value;

            static {
                VersionKind r5 = new VersionKind("LANGUAGE_VERSION", 0, 0, 0);
                LANGUAGE_VERSION = r5;
                VersionKind r10 = new VersionKind("COMPILER_VERSION", 1, 1, 1);
                COMPILER_VERSION = r10;
                VersionKind r11 = new VersionKind("API_VERSION", 2, 2, 2);
                API_VERSION = r11;
                $VALUES = new VersionKind[]{r5, r10, r11};
                internalValueMap = new AnonymousClass1();
            }

            private VersionKind(String r5, int r10, int r11, int r12) {
                super(r5, r10);
                this.value = r12;
            }

            public static VersionKind valueOf(String r5) {
                return (VersionKind) Enum.valueOf(VersionKind.class, r5);
            }

            public static VersionKind[] values() {
                return (VersionKind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int r5) {
                if (r5 == 0) goto L14;
                if (r5 == 1) goto L12;
                if (r5 == 2) goto L10;
                return null;
            L10:
                return API_VERSION;
            L12:
                return COMPILER_VERSION;
            L14:
                return LANGUAGE_VERSION;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            VersionRequirement r5 = new VersionRequirement(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ VersionRequirement(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$21202(VersionRequirement r5, int r10) {
            r5.version_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$21302(VersionRequirement r5, int r10) {
            r5.versionFull_ = r10;
            return r10;
        }

        public static /* synthetic */ Level access$21402(VersionRequirement r5, Level r10) {
            r5.level_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$21502(VersionRequirement r5, int r10) {
            r5.errorCode_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$21602(VersionRequirement r5, int r10) {
            r5.message_ = r10;
            return r10;
        }

        public static /* synthetic */ VersionKind access$21702(VersionRequirement r5, VersionKind r10) {
            r5.versionKind_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$21802(VersionRequirement r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$21900(VersionRequirement r5) {
            return r5.unknownFields;
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        public static Builder newBuilder() {
            return Builder.access$21000();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public Level getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L6;
            return r5;
        L6:
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r10 = CodedOutputStream.computeInt32Size(1, this.version_);
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r10 = r10 + CodedOutputStream.computeInt32Size(2, this.versionFull_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r10 = r10 + CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r10 = r10 + CodedOutputStream.computeInt32Size(4, this.errorCode_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r10 = r10 + CodedOutputStream.computeInt32Size(5, this.message_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L24;
            r10 = r10 + CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
        L24:
            int r11 = this.unknownFields.size() + r10;
            this.memoizedSerializedSize = r11;
            return r11;
        L8:
            r10 = 0;
            goto L10
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        public boolean hasErrorCode() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasLevel() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasMessage() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVersion() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasVersionFull() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVersionKind() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r5.writeInt32(1, this.version_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r5.writeInt32(2, this.versionFull_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r5.writeEnum(3, this.level_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r5.writeInt32(4, this.errorCode_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r5.writeInt32(5, this.message_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r5.writeEnum(6, this.versionKind_.getNumber());
        L20:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ VersionRequirement(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(VersionRequirement r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private VersionRequirement(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private VersionRequirement(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private VersionRequirement(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
        L3:
            if (r13 == true) goto L61;
            int r14 = r10.readTag();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            if (r14 == 0) goto L20;
            if (r14 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.version_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L9:
            if (r14 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.versionFull_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L11:
            if (r14 != 24) goto L13;
            int r15 = r10.readEnum();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            Level r16 = Level.valueOf(r15);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            if (r16 == null) goto L35;
            this.bitField0_ |= 4;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.level_ = r16;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L35:
            r12.writeRawVarint32(r14);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            r12.writeRawVarint32(r15);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L13:
            if (r14 != 32) goto L15;
            this.bitField0_ |= 8;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.errorCode_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L15:
            if (r14 != 40) goto L17;
            this.bitField0_ |= 16;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.message_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L17:
            if (r14 != 48) goto L19;
            int r17 = r10.readEnum();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            VersionKind r18 = VersionKind.valueOf(r17);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            if (r18 == null) goto L29;
            this.bitField0_ |= 32;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            this.versionKind_ = r18;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L29:
            r12.writeRawVarint32(r14);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            r12.writeRawVarint32(r17);     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L25
            goto L3
        L19:
            if (parseUnknownField(r10, r12, r11, r14) == true) goto L3;
        L20:
            r13 = true;
            goto L3
        L21:
            th = move-exception;
            r12.flush();     // Catch: IOException -> L58 Throwable -> L46
        L46:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L45:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L25:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L23:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L61:
            r12.flush();     // Catch: IOException -> L59 Throwable -> L53
        L53:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L52:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER;
        private static final VersionRequirementTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_;

            private Builder() {
                this.requirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$22100() {
                return create();
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

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable r5 = new VersionRequirementTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
                this.bitField0_ &= -2;
            L5:
                VersionRequirementTable.access$22302(r5, this.requirement_);
                return r5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirementTable build() {
                VersionRequirementTable r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1400clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((VersionRequirementTable) r5);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder mergeFrom(VersionRequirementTable r5) {
                if (r5 != VersionRequirementTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (VersionRequirementTable.access$22300(r5).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(VersionRequirementTable.access$22400(r5)));
                return this;
            L8:
                if (this.requirement_.isEmpty() == false) goto L10;
                this.requirement_ = VersionRequirementTable.access$22300(r5);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureRequirementIsMutable();
                this.requirement_.addAll(VersionRequirementTable.access$22300(r5));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                VersionRequirementTable r11 = null;
                VersionRequirementTable r12 = VersionRequirementTable.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirementTable r13 = (VersionRequirementTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            VersionRequirementTable r5 = new VersionRequirementTable(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ VersionRequirementTable(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ List access$22300(VersionRequirementTable r5) {
            return r5.requirement_;
        }

        public static /* synthetic */ List access$22302(VersionRequirementTable r5, List r10) {
            r5.requirement_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$22400(VersionRequirementTable r5) {
            return r5.unknownFields;
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r10 >= this.requirement_.size()) goto L9;
            r11 = r11 + CodedOutputStream.computeMessageSize(1, this.requirement_.get(r10));
            r10 = r10 + 1;
            goto L7
        L9:
            int r12 = this.unknownFields.size() + r11;
            this.memoizedSerializedSize = r12;
            return r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            int r10 = 0;
        L4:
            if (r10 >= this.requirement_.size()) goto L6;
            r5.writeMessage(1, this.requirement_.get(r10));
            r10 = r10 + 1;
            goto L4
        L6:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ VersionRequirementTable(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(VersionRequirementTable r5) {
            return newBuilder().mergeFrom(r5);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private VersionRequirementTable(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        private VersionRequirementTable(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private VersionRequirementTable(CodedInputStream r10, ExtensionRegistryLite r11) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r12 = CodedOutputStream.newInstance(r5, 1);
            boolean r13 = false;
            boolean r14 = false;
        L3:
            if (r13 == true) goto L34;
            int r15 = r10.readTag();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if (r15 == 0) goto L10;
            if (r15 != 10) goto L9;
            if (r14 == true) goto L19;
            this.requirement_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r14 = true;
        L19:
            this.requirement_.add((VersionRequirement) r10.readMessage(VersionRequirement.PARSER, r11));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L3
        L9:
            if (parseUnknownField(r10, r12, r11, r15) == true) goto L3;
        L10:
            r13 = true;
            goto L3
        L11:
            th = move-exception;
            if (r14 != true) goto L47;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L47:
            r12.flush();     // Catch: IOException -> L44 Throwable -> L29
        L29:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L28:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L15:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L13:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L34:
            if (r14 != true) goto L49;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L49:
            r12.flush();     // Catch: IOException -> L43 Throwable -> L38
        L38:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L37:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
    }

    public static final enum Visibility extends Enum<Visibility> implements Internal.EnumLite {
        private static final /* synthetic */ Visibility[] $VALUES = null;
        public static final Visibility INTERNAL = null;
        public static final Visibility LOCAL = null;
        public static final Visibility PRIVATE = null;
        public static final Visibility PRIVATE_TO_THIS = null;
        public static final Visibility PROTECTED = null;
        public static final Visibility PUBLIC = null;
        private static Internal.EnumLiteMap<Visibility> internalValueMap;
        private final int value;

        static {
            Visibility r5 = new Visibility("INTERNAL", 0, 0, 0);
            INTERNAL = r5;
            Visibility r10 = new Visibility("PRIVATE", 1, 1, 1);
            PRIVATE = r10;
            Visibility r11 = new Visibility("PROTECTED", 2, 2, 2);
            PROTECTED = r11;
            Visibility r12 = new Visibility("PUBLIC", 3, 3, 3);
            PUBLIC = r12;
            Visibility r13 = new Visibility("PRIVATE_TO_THIS", 4, 4, 4);
            PRIVATE_TO_THIS = r13;
            Visibility r14 = new Visibility("LOCAL", 5, 5, 5);
            LOCAL = r14;
            $VALUES = new Visibility[]{r5, r10, r11, r12, r13, r14};
            internalValueMap = new AnonymousClass1();
        }

        private Visibility(String r5, int r10, int r11, int r12) {
            super(r5, r10);
            this.value = r12;
        }

        public static Visibility valueOf(String r5) {
            return (Visibility) Enum.valueOf(Visibility.class, r5);
        }

        public static Visibility[] values() {
            return (Visibility[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int r5) {
            if (r5 == 0) goto L26;
            if (r5 == 1) goto L24;
            if (r5 == 2) goto L22;
            if (r5 == 3) goto L20;
            if (r5 == 4) goto L18;
            if (r5 == 5) goto L16;
            return null;
        L16:
            return LOCAL;
        L18:
            return PRIVATE_TO_THIS;
        L20:
            return PUBLIC;
        L22:
            return PROTECTED;
        L24:
            return PRIVATE;
        L26:
            return INTERNAL;
        }
    }
}
