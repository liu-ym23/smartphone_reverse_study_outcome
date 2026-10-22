package kotlin.reflect.jvm.internal.impl.metadata;

import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
    static /* synthetic */ class AnonymousClass1 {
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

                static /* synthetic */ Builder access$3600() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r10 = buildPartial();
                    if (r10.isInitialized() == false) goto L6;
                    return r10;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public Argument buildPartial() {
                    Argument r10 = new Argument(this, null);
                    int r11 = this.bitField0_;
                    int r12 = 1;
                    if ((r11 & 1) == 1) goto L6;
                    r12 = 0;
                L6:
                    Argument.access$3802(r10, this.nameId_);
                    if ((r11 & 2) != 2) goto L9;
                    r12 = r12 | 2;
                L9:
                    Argument.access$3902(r10, this.value_);
                    Argument.access$4002(r10, r12);
                    return r10;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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

                public Builder mergeFrom(Argument r10) {
                    if (r10 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r10.hasNameId() == false) goto L9;
                    setNameId(r10.getNameId());
                L9:
                    if (r10.hasValue() == false) goto L11;
                    mergeValue(r10.getValue());
                L11:
                    setUnknownFields(getUnknownFields().concat(Argument.access$4100(r10)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    Argument r12 = null;
                    Argument r13 = Argument.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r13 == null) goto L6;
                    mergeFrom(r13);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r14 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r12 = r14;
                L14:
                    if (r12 == null) goto L16;
                    mergeFrom(r12);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                    return mergeFrom((Argument) r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                public Builder mergeValue(Value r10) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.value_ = r10;
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.value_ == Value.getDefaultInstance()) goto L7;
                    r10 = Value.newBuilder(this.value_).mergeFrom(r10).buildPartial();
                    goto L7
                }

                public Builder setNameId(int r10) {
                    this.bitField0_ |= 1;
                    this.nameId_ = r10;
                    return this;
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

                    static /* synthetic */ Builder access$2100() {
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
                    public Value build() {
                        Value r10 = buildPartial();
                        if (r10.isInitialized() == false) goto L6;
                        return r10;
                    L6:
                        throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ MessageLite build() {
                        return build();
                    }

                    public Value buildPartial() {
                        Value r10 = new Value(this, null);
                        int r11 = this.bitField0_;
                        int r12 = 1;
                        if ((r11 & 1) == 1) goto L6;
                        r12 = 0;
                    L6:
                        Value.access$2302(r10, this.type_);
                        if ((r11 & 2) != 2) goto L9;
                        r12 = r12 | 2;
                    L9:
                        Value.access$2402(r10, this.intValue_);
                        if ((r11 & 4) != 4) goto L12;
                        r12 = r12 | 4;
                    L12:
                        Value.access$2502(r10, this.floatValue_);
                        if ((r11 & 8) != 8) goto L15;
                        r12 = r12 | 8;
                    L15:
                        Value.access$2602(r10, this.doubleValue_);
                        if ((r11 & 16) != 16) goto L18;
                        r12 = r12 | 16;
                    L18:
                        Value.access$2702(r10, this.stringValue_);
                        if ((r11 & 32) != 32) goto L21;
                        r12 = r12 | 32;
                    L21:
                        Value.access$2802(r10, this.classId_);
                        if ((r11 & 64) != 64) goto L24;
                        r12 = r12 | 64;
                    L24:
                        Value.access$2902(r10, this.enumValueId_);
                        if ((r11 & 128) != 128) goto L27;
                        r12 = r12 | 128;
                    L27:
                        Value.access$3002(r10, this.annotation_);
                        if ((this.bitField0_ & 256) != 256) goto L30;
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    L30:
                        Value.access$3102(r10, this.arrayElement_);
                        if ((r11 & 512) != 512) goto L33;
                        r12 = r12 | 256;
                    L33:
                        Value.access$3202(r10, this.arrayDimensionCount_);
                        if ((r11 & 1024) != 1024) goto L36;
                        r12 = r12 | 512;
                    L36:
                        Value.access$3302(r10, this.flags_);
                        Value.access$3402(r10, r12);
                        return r10;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public /* bridge */ /* synthetic */ Object clone() {
                        return clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public Builder clone() {
                        return create().mergeFrom(buildPartial());
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    /* JADX INFO: renamed from: clone */
                    public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                        return clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                        return clone();
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
                    }

                    public Value getArrayElement(int r10) {
                        return this.arrayElement_.get(r10);
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                        return getDefaultInstanceForType();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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
                        int r10 = 0;
                    L9:
                        if (r10 >= getArrayElementCount()) goto L14;
                        if (getArrayElement(r10).isInitialized() == false) goto L12;
                        r10 = r10 + 1;
                        goto L9
                    L12:
                        return false;
                    L14:
                        return true;
                    L5:
                        if (getAnnotation().isInitialized() == true) goto L7;
                        return false;
                    }

                    public Builder mergeAnnotation(Annotation r10) {
                        if ((this.bitField0_ & 128) == 128) goto L5;
                    L7:
                        this.annotation_ = r10;
                        this.bitField0_ |= 128;
                        return this;
                    L5:
                        if (this.annotation_ == Annotation.getDefaultInstance()) goto L7;
                        r10 = Annotation.newBuilder(this.annotation_).mergeFrom(r10).buildPartial();
                        goto L7
                    }

                    public Builder mergeFrom(Value r10) {
                        if (r10 != Value.getDefaultInstance()) goto L6;
                        return this;
                    L6:
                        if (r10.hasType() == false) goto L9;
                        setType(r10.getType());
                    L9:
                        if (r10.hasIntValue() == false) goto L12;
                        setIntValue(r10.getIntValue());
                    L12:
                        if (r10.hasFloatValue() == false) goto L15;
                        setFloatValue(r10.getFloatValue());
                    L15:
                        if (r10.hasDoubleValue() == false) goto L18;
                        setDoubleValue(r10.getDoubleValue());
                    L18:
                        if (r10.hasStringValue() == false) goto L21;
                        setStringValue(r10.getStringValue());
                    L21:
                        if (r10.hasClassId() == false) goto L24;
                        setClassId(r10.getClassId());
                    L24:
                        if (r10.hasEnumValueId() == false) goto L27;
                        setEnumValueId(r10.getEnumValueId());
                    L27:
                        if (r10.hasAnnotation() == false) goto L30;
                        mergeAnnotation(r10.getAnnotation());
                    L30:
                        if (Value.access$3100(r10).isEmpty() == true) goto L36;
                        if (this.arrayElement_.isEmpty() == false) goto L34;
                        this.arrayElement_ = Value.access$3100(r10);
                        this.bitField0_ &= -257;
                        goto L36
                    L34:
                        ensureArrayElementIsMutable();
                        this.arrayElement_.addAll(Value.access$3100(r10));
                    L36:
                        if (r10.hasArrayDimensionCount() == false) goto L39;
                        setArrayDimensionCount(r10.getArrayDimensionCount());
                    L39:
                        if (r10.hasFlags() == false) goto L41;
                        setFlags(r10.getFlags());
                    L41:
                        setUnknownFields(getUnknownFields().concat(Value.access$3500(r10)));
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                        Value r12 = null;
                        Value r13 = Value.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                        if (r13 == null) goto L6;
                        mergeFrom(r13);
                    L6:
                        return this;
                    L9:
                        e = move-exception;
                        Value r14 = (Value) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                        throw e;     // Catch: Throwable -> L12
                    L12:
                        th = th;
                        r12 = r14;
                    L14:
                        if (r12 == null) goto L16;
                        mergeFrom(r12);
                    L16:
                        throw th;
                    L7:
                        th = th;
                        goto L14
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                        return mergeFrom(r10, r11);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                        return mergeFrom((Value) r10);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                        return mergeFrom(r10, r11);
                    }

                    public Builder setArrayDimensionCount(int r10) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = r10;
                        return this;
                    }

                    public Builder setClassId(int r10) {
                        this.bitField0_ |= 32;
                        this.classId_ = r10;
                        return this;
                    }

                    public Builder setDoubleValue(double r10) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = r10;
                        return this;
                    }

                    public Builder setEnumValueId(int r10) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = r10;
                        return this;
                    }

                    public Builder setFlags(int r10) {
                        this.bitField0_ |= 1024;
                        this.flags_ = r10;
                        return this;
                    }

                    public Builder setFloatValue(float r10) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = r10;
                        return this;
                    }

                    public Builder setIntValue(long r10) {
                        this.bitField0_ |= 2;
                        this.intValue_ = r10;
                        return this;
                    }

                    public Builder setStringValue(int r10) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = r10;
                        return this;
                    }

                    public Builder setType(Type r10) {
                        Objects.requireNonNull(r10);
                        this.bitField0_ |= 1;
                        this.type_ = r10;
                        return this;
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
                        Type r10 = new Type("BYTE", 0, 0, 0);
                        BYTE = r10;
                        Type r11 = new Type("CHAR", 1, 1, 1);
                        CHAR = r11;
                        Type r12 = new Type("SHORT", 2, 2, 2);
                        SHORT = r12;
                        Type r13 = new Type("INT", 3, 3, 3);
                        INT = r13;
                        Type r14 = new Type("LONG", 4, 4, 4);
                        LONG = r14;
                        Type r15 = new Type("FLOAT", 5, 5, 5);
                        FLOAT = r15;
                        Type r16 = new Type("DOUBLE", 6, 6, 6);
                        DOUBLE = r16;
                        Type r17 = new Type("BOOLEAN", 7, 7, 7);
                        BOOLEAN = r17;
                        Type r18 = new Type("STRING", 8, 8, 8);
                        STRING = r18;
                        Type r19 = new Type("CLASS", 9, 9, 9);
                        CLASS = r19;
                        Type r110 = new Type("ENUM", 10, 10, 10);
                        ENUM = r110;
                        Type r111 = new Type("ANNOTATION", 11, 11, 11);
                        ANNOTATION = r111;
                        Type r20 = new Type("ARRAY", 12, 12, 12);
                        ARRAY = r20;
                        $VALUES = new Type[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20};
                        internalValueMap = new AnonymousClass1();
                    }

                    private Type(String r10, int r11, int r12, int r13) {
                        super(r10, r11);
                        this.value = r13;
                    }

                    public static Type valueOf(int r10) {
                        switch(r10) {
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

                    public static Type valueOf(String r10) {
                        return (Type) Enum.valueOf(Type.class, r10);
                    }

                    public static Type[] values() {
                        return (Type[]) $VALUES.clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }
                }

                static {
                    PARSER = new AnonymousClass1();
                    Value r10 = new Value(true);
                    defaultInstance = r10;
                    r10.initFields();
                }

                private Value(CodedInputStream r10, ExtensionRegistryLite r11) {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    ByteString.Output r12 = ByteString.newOutput();
                    CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
                    boolean r14 = false;
                    int r15 = 0;
                L4:
                    if (r14 == true) goto L54;
                    int r16 = r10.readTag();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    switch(r16) {
                        case 0: goto L32;
                        case 8: goto L27;
                        case 16: goto L26;
                        case 29: goto L25;
                        case 33: goto L24;
                        case 40: goto L23;
                        case 48: goto L22;
                        case 56: goto L21;
                        case 66: goto L14;
                        case 74: goto L11;
                        case 80: goto L9;
                        case 88: goto L8;
                        default: goto L33;
                    };     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                L8:
                    this.bitField0_ |= 256;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.arrayDimensionCount_ = r10.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L9:
                    this.bitField0_ |= 512;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.flags_ = r10.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L11:
                    if ((r15 & 256) == 256) goto L13;
                    this.arrayElement_ = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    r15 = r15 | 256;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                L13:
                    this.arrayElement_.add((Value) r10.readMessage(PARSER, r11));     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L14:
                    Builder r17 = null;
                    if ((this.bitField0_ & 128) != 128) goto L17;
                    r17 = this.annotation_.toBuilder();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                L17:
                    Annotation r18 = (Annotation) r10.readMessage(Annotation.PARSER, r11);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.annotation_ = r18;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    if (r17 == null) goto L20;
                    r17.mergeFrom(r18);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.annotation_ = r17.buildPartial();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                L20:
                    this.bitField0_ |= 128;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L21:
                    this.bitField0_ |= 64;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.enumValueId_ = r10.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L22:
                    this.bitField0_ |= 32;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.classId_ = r10.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L23:
                    this.bitField0_ |= 16;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.stringValue_ = r10.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L24:
                    this.bitField0_ |= 8;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.doubleValue_ = r10.readDouble();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L25:
                    this.bitField0_ |= 4;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.floatValue_ = r10.readFloat();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L26:
                    this.bitField0_ |= 2;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.intValue_ = r10.readSInt64();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L27:
                    int r19 = r10.readEnum();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    Type r20 = Type.valueOf(r19);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    if (r20 == null) goto L29;
                    this.bitField0_ |= 1;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    this.type_ = r20;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    goto L4
                L29:
                    r13.writeRawVarint32(r16);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                    r13.writeRawVarint32(r19);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
                L32:
                    r14 = true;
                    goto L4
                L33:
                    if (parseUnknownField(r10, r13, r11, r16) == true) goto L4;
                L35:
                    th = move-exception;
                    if ((r15 & 256) != 256) goto L67;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L67:
                    r13.flush();     // Catch: IOException -> L64 Throwable -> L48
                L48:
                    th = move-exception;
                    this.unknownFields = r12.toByteString();
                    throw th;
                L47:
                    this.unknownFields = r12.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                L40:
                    e = move-exception;
                    throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L35
                L37:
                    e = move-exception;
                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L35
                L54:
                    if ((r15 & 256) != 256) goto L69;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L69:
                    r13.flush();     // Catch: IOException -> L63 Throwable -> L58
                L58:
                    th = move-exception;
                    this.unknownFields = r12.toByteString();
                    throw th;
                L57:
                    this.unknownFields = r12.toByteString();
                    makeExtensionsImmutable();
                }

                /* synthetic */ Value(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
                    this(r10, r11);
                }

                private Value(GeneratedMessageLite.Builder r10) {
                    super(r10);
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = r10.getUnknownFields();
                }

                /* synthetic */ Value(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
                    this(r10);
                }

                private Value(boolean r10) {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                static /* synthetic */ Type access$2302(Value r10, Type r11) {
                    r10.type_ = r11;
                    return r11;
                }

                static /* synthetic */ long access$2402(Value r10, long r11) {
                    r10.intValue_ = r11;
                    return r11;
                }

                static /* synthetic */ float access$2502(Value r10, float r11) {
                    r10.floatValue_ = r11;
                    return r11;
                }

                static /* synthetic */ double access$2602(Value r10, double r11) {
                    r10.doubleValue_ = r11;
                    return r11;
                }

                static /* synthetic */ int access$2702(Value r10, int r11) {
                    r10.stringValue_ = r11;
                    return r11;
                }

                static /* synthetic */ int access$2802(Value r10, int r11) {
                    r10.classId_ = r11;
                    return r11;
                }

                static /* synthetic */ int access$2902(Value r10, int r11) {
                    r10.enumValueId_ = r11;
                    return r11;
                }

                static /* synthetic */ Annotation access$3002(Value r10, Annotation r11) {
                    r10.annotation_ = r11;
                    return r11;
                }

                static /* synthetic */ List access$3100(Value r10) {
                    return r10.arrayElement_;
                }

                static /* synthetic */ List access$3102(Value r10, List r11) {
                    r10.arrayElement_ = r11;
                    return r11;
                }

                static /* synthetic */ int access$3202(Value r10, int r11) {
                    r10.arrayDimensionCount_ = r11;
                    return r11;
                }

                static /* synthetic */ int access$3302(Value r10, int r11) {
                    r10.flags_ = r11;
                    return r11;
                }

                static /* synthetic */ int access$3402(Value r10, int r11) {
                    r10.bitField0_ = r11;
                    return r11;
                }

                static /* synthetic */ ByteString access$3500(Value r10) {
                    return r10.unknownFields;
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

                public static Builder newBuilder(Value r10) {
                    return newBuilder().mergeFrom(r10);
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public Value getArrayElement(int r10) {
                    return this.arrayElement_.get(r10);
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
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
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
                    int r10 = this.memoizedSerializedSize;
                    if (r10 == (-1)) goto L5;
                    return r10;
                L5:
                    int r11 = 0;
                    if ((this.bitField0_ & 1) != 1) goto L8;
                    int r12 = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
                L10:
                    if ((this.bitField0_ & 2) != 2) goto L13;
                    r12 = r12 + CodedOutputStream.computeSInt64Size(2, this.intValue_);
                L13:
                    if ((this.bitField0_ & 4) != 4) goto L16;
                    r12 = r12 + CodedOutputStream.computeFloatSize(3, this.floatValue_);
                L16:
                    if ((this.bitField0_ & 8) != 8) goto L19;
                    r12 = r12 + CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                L19:
                    if ((this.bitField0_ & 16) != 16) goto L22;
                    r12 = r12 + CodedOutputStream.computeInt32Size(5, this.stringValue_);
                L22:
                    if ((this.bitField0_ & 32) != 32) goto L25;
                    r12 = r12 + CodedOutputStream.computeInt32Size(6, this.classId_);
                L25:
                    if ((this.bitField0_ & 64) != 64) goto L28;
                    r12 = r12 + CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                L28:
                    if ((this.bitField0_ & 128) != 128) goto L31;
                    r12 = r12 + CodedOutputStream.computeMessageSize(8, this.annotation_);
                L31:
                    if (r11 >= this.arrayElement_.size()) goto L34;
                    r12 = r12 + CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(r11));
                    r11 = r11 + 1;
                    goto L31
                L34:
                    if ((this.bitField0_ & 512) != 512) goto L37;
                    r12 = r12 + CodedOutputStream.computeInt32Size(10, this.flags_);
                L37:
                    if ((this.bitField0_ & 256) != 256) goto L39;
                    r12 = r12 + CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                L39:
                    int r13 = r12 + this.unknownFields.size();
                    this.memoizedSerializedSize = r13;
                    return r13;
                L8:
                    r12 = 0;
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
                    byte r10 = this.memoizedIsInitialized;
                    if (r10 != 1) goto L6;
                    return true;
                L6:
                    if (r10 != 0) goto L9;
                    return false;
                L9:
                    if (hasAnnotation() == true) goto L11;
                L14:
                    int r11 = 0;
                L16:
                    if (r11 >= getArrayElementCount()) goto L22;
                    if (getArrayElement(r11).isInitialized() == false) goto L19;
                    r11 = r11 + 1;
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
                public Builder newBuilderForType() {
                    return newBuilder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                    return newBuilderForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Builder toBuilder() {
                    return newBuilder(this);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                    return toBuilder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public void writeTo(CodedOutputStream r10) {
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
                    int r11 = 0;
                L28:
                    if (r11 >= this.arrayElement_.size()) goto L31;
                    r10.writeMessage(9, this.arrayElement_.get(r11));
                    r11 = r11 + 1;
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
            }

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            static {
                PARSER = new AnonymousClass1();
                Argument r10 = new Argument(true);
                defaultInstance = r10;
                r10.initFields();
            }

            private Argument(CodedInputStream r10, ExtensionRegistryLite r11) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r12 = ByteString.newOutput();
                CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
                boolean r14 = false;
            L3:
                if (r14 == true) goto L51;
                int r15 = r10.readTag();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r15 == 0) goto L22;
                if (r15 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.nameId_ = r10.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L9:
                if (r15 != 18) goto L11;
                Value.Builder r16 = null;
                if ((this.bitField0_ & 2) != 2) goto L16;
                r16 = this.value_.toBuilder();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            L16:
                Value r17 = (Value) r10.readMessage(Value.PARSER, r11);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.value_ = r17;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r16 == null) goto L19;
                r16.mergeFrom(r17);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.value_ = r16.buildPartial();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
            L19:
                this.bitField0_ |= 2;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L11:
                if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
            L22:
                r14 = true;
                goto L3
            L23:
                th = move-exception;
                r13.flush();     // Catch: IOException -> L45 Throwable -> L33
            L33:
                th = move-exception;
                this.unknownFields = r12.toByteString();
                throw th;
            L32:
                this.unknownFields = r12.toByteString();
                makeExtensionsImmutable();
                throw th;
            L28:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L25:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L51:
                r13.flush();     // Catch: IOException -> L46 Throwable -> L40
            L40:
                th = move-exception;
                this.unknownFields = r12.toByteString();
                throw th;
            L39:
                this.unknownFields = r12.toByteString();
                makeExtensionsImmutable();
            }

            /* synthetic */ Argument(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            private Argument(GeneratedMessageLite.Builder r10) {
                super(r10);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r10.getUnknownFields();
            }

            /* synthetic */ Argument(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
                this(r10);
            }

            private Argument(boolean r10) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            static /* synthetic */ int access$3802(Argument r10, int r11) {
                r10.nameId_ = r11;
                return r11;
            }

            static /* synthetic */ Value access$3902(Argument r10, Value r11) {
                r10.value_ = r11;
                return r11;
            }

            static /* synthetic */ int access$4002(Argument r10, int r11) {
                r10.bitField0_ = r11;
                return r11;
            }

            static /* synthetic */ ByteString access$4100(Argument r10) {
                return r10.unknownFields;
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

            public static Builder newBuilder(Argument r10) {
                return newBuilder().mergeFrom(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
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
                int r10 = this.memoizedSerializedSize;
                if (r10 == (-1)) goto L5;
                return r10;
            L5:
                int r11 = 0;
                if ((this.bitField0_ & 1) != 1) goto L9;
                r11 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
            L9:
                if ((this.bitField0_ & 2) != 2) goto L11;
                r11 = r11 + CodedOutputStream.computeMessageSize(2, this.value_);
            L11:
                int r12 = r11 + this.unknownFields.size();
                this.memoizedSerializedSize = r12;
                return r12;
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
                byte r10 = this.memoizedIsInitialized;
                if (r10 != 1) goto L6;
                return true;
            L6:
                if (r10 != 0) goto L9;
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
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r10) {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r10.writeInt32(1, this.nameId_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L8;
                r10.writeMessage(2, this.value_);
            L8:
                r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$4200() {
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
            public Annotation build() {
                Annotation r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Annotation buildPartial() {
                Annotation r10 = new Annotation(this, null);
                int r11 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r11 = 0;
            L6:
                Annotation.access$4402(r10, this.id_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            L9:
                Annotation.access$4502(r10, this.argument_);
                Annotation.access$4602(r10, r11);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            public Argument getArgument(int r10) {
                return this.argument_.get(r10);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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
                int r10 = 0;
            L7:
                if (r10 >= getArgumentCount()) goto L12;
                if (getArgument(r10).isInitialized() == false) goto L10;
                r10 = r10 + 1;
                goto L7
            L10:
                return false;
            L12:
                return true;
            }

            public Builder mergeFrom(Annotation r10) {
                if (r10 != Annotation.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasId() == false) goto L9;
                setId(r10.getId());
            L9:
                if (Annotation.access$4500(r10).isEmpty() == false) goto L11;
            L14:
                setUnknownFields(getUnknownFields().concat(Annotation.access$4700(r10)));
                return this;
            L11:
                if (this.argument_.isEmpty() == false) goto L13;
                this.argument_ = Annotation.access$4500(r10);
                this.bitField0_ &= -3;
                goto L14
            L13:
                ensureArgumentIsMutable();
                this.argument_.addAll(Annotation.access$4500(r10));
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Annotation r12 = null;
                Annotation r13 = Annotation.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Annotation r14 = (Annotation) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Annotation) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setId(int r10) {
                this.bitField0_ |= 1;
                this.id_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Annotation r10 = new Annotation(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Annotation(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L40;
            int r16 = r10.readTag();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            if (r16 == 0) goto L20;
            if (r16 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            this.id_ = r10.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            if (r16 != 18) goto L12;
            if ((r15 & 2) == 2) goto L17;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            r15 = r15 | 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        L17:
            this.argument_.add((Argument) r10.readMessage(Argument.PARSER, r11));     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L4;
        L20:
            r14 = true;
            goto L4
        L21:
            th = move-exception;
            if ((r15 & 2) != 2) goto L52;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L52:
            r13.flush();     // Catch: IOException -> L50 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L33:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L26:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L23:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L40:
            if ((r15 & 2) != 2) goto L55;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L55:
            r13.flush();     // Catch: IOException -> L49 Throwable -> L44
        L44:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L43:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Annotation(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Annotation(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Annotation(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Annotation(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$4402(Annotation r10, int r11) {
            r10.id_ = r11;
            return r11;
        }

        static /* synthetic */ List access$4500(Annotation r10) {
            return r10.argument_;
        }

        static /* synthetic */ List access$4502(Annotation r10, List r11) {
            r10.argument_ = r11;
            return r11;
        }

        static /* synthetic */ int access$4602(Annotation r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$4700(Annotation r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Annotation r10) {
            return newBuilder().mergeFrom(r10);
        }

        public Argument getArgument(int r10) {
            return this.argument_.get(r10);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
        L10:
            if (r11 >= this.argument_.size()) goto L12;
            r12 = r12 + CodedOutputStream.computeMessageSize(2, this.argument_.get(r11));
            r11 = r11 + 1;
            goto L10
        L12:
            int r13 = r12 + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        L8:
            r12 = 0;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
            return false;
        L9:
            if (hasId() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r11 = 0;
        L14:
            if (r11 >= getArgumentCount()) goto L20;
            if (getArgument(r11).isInitialized() == false) goto L17;
            r11 = r11 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r10.writeInt32(1, this.id_);
        L5:
            int r11 = 0;
        L7:
            if (r11 >= this.argument_.size()) goto L9;
            r10.writeMessage(2, this.argument_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$8700() {
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
            public Class build() {
                Class r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Class buildPartial() {
                Class r10 = new Class(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                Class.access$8902(r10, this.flags_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                Class.access$9002(r10, this.fqName_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                Class.access$9102(r10, this.companionObjectName_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -9;
            L15:
                Class.access$9202(r10, this.typeParameter_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
                this.bitField0_ &= -17;
            L18:
                Class.access$9302(r10, this.supertype_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                this.bitField0_ &= -33;
            L21:
                Class.access$9402(r10, this.supertypeId_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                this.bitField0_ &= -65;
            L24:
                Class.access$9502(r10, this.nestedClassName_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -129;
            L27:
                Class.access$9602(r10, this.contextReceiverType_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -257;
            L30:
                Class.access$9702(r10, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Class.access$9802(r10, this.constructor_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -1025;
            L36:
                Class.access$9902(r10, this.function_);
                if ((this.bitField0_ & 2048) != 2048) goto L39;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -2049;
            L39:
                Class.access$10002(r10, this.property_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -4097;
            L42:
                Class.access$10102(r10, this.typeAlias_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                this.bitField0_ &= -8193;
            L45:
                Class.access$10202(r10, this.enumEntry_);
                if ((this.bitField0_ & 16384) != 16384) goto L48;
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                this.bitField0_ &= -16385;
            L48:
                Class.access$10302(r10, this.sealedSubclassFqName_);
                if ((r11 & 32768) != 32768) goto L51;
                r12 = r12 | 8;
            L51:
                Class.access$10402(r10, this.inlineClassUnderlyingPropertyName_);
                if ((r11 & 65536) != 65536) goto L54;
                r12 = r12 | 16;
            L54:
                Class.access$10502(r10, this.inlineClassUnderlyingType_);
                if ((r11 & 131072) != 131072) goto L57;
                r12 = r12 | 32;
            L57:
                Class.access$10602(r10, this.inlineClassUnderlyingTypeId_);
                if ((this.bitField0_ & 262144) != 262144) goto L60;
                this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ &= -262145;
            L60:
                Class.access$10702(r10, this.multiFieldValueClassUnderlyingName_);
                if ((this.bitField0_ & 524288) != 524288) goto L63;
                this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ &= -524289;
            L63:
                Class.access$10802(r10, this.multiFieldValueClassUnderlyingType_);
                if ((this.bitField0_ & 1048576) != 1048576) goto L66;
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ &= -1048577;
            L66:
                Class.access$10902(r10, this.multiFieldValueClassUnderlyingTypeId_);
                if ((r11 & 2097152) != 2097152) goto L69;
                r12 = r12 | 64;
            L69:
                Class.access$11002(r10, this.typeTable_);
                if ((this.bitField0_ & 4194304) != 4194304) goto L72;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4194305;
            L72:
                Class.access$11102(r10, this.versionRequirement_);
                if ((r11 & 8388608) != 8388608) goto L75;
                r12 = r12 | 128;
            L75:
                Class.access$11202(r10, this.versionRequirementTable_);
                Class.access$11302(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Constructor getConstructor(int r10) {
                return this.constructor_.get(r10);
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public Type getContextReceiverType(int r10) {
                return this.contextReceiverType_.get(r10);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public EnumEntry getEnumEntry(int r10) {
                return this.enumEntry_.get(r10);
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public Function getFunction(int r10) {
                return this.function_.get(r10);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public Type getMultiFieldValueClassUnderlyingType(int r10) {
                return this.multiFieldValueClassUnderlyingType_.get(r10);
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public Property getProperty(int r10) {
                return this.property_.get(r10);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public Type getSupertype(int r10) {
                return this.supertype_.get(r10);
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public TypeAlias getTypeAlias(int r10) {
                return this.typeAlias_.get(r10);
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public TypeParameter getTypeParameter(int r10) {
                return this.typeParameter_.get(r10);
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
                int r10 = 0;
            L7:
                if (r10 >= getTypeParameterCount()) goto L12;
                if (getTypeParameter(r10).isInitialized() == false) goto L10;
                r10 = r10 + 1;
                goto L7
            L10:
                return false;
            L12:
                int r11 = 0;
            L14:
                if (r11 >= getSupertypeCount()) goto L19;
                if (getSupertype(r11).isInitialized() == false) goto L17;
                r11 = r11 + 1;
                goto L14
            L17:
                return false;
            L19:
                int r12 = 0;
            L21:
                if (r12 >= getContextReceiverTypeCount()) goto L26;
                if (getContextReceiverType(r12).isInitialized() == false) goto L24;
                r12 = r12 + 1;
                goto L21
            L24:
                return false;
            L26:
                int r13 = 0;
            L28:
                if (r13 >= getConstructorCount()) goto L33;
                if (getConstructor(r13).isInitialized() == false) goto L31;
                r13 = r13 + 1;
                goto L28
            L31:
                return false;
            L33:
                int r14 = 0;
            L35:
                if (r14 >= getFunctionCount()) goto L40;
                if (getFunction(r14).isInitialized() == false) goto L38;
                r14 = r14 + 1;
                goto L35
            L38:
                return false;
            L40:
                int r15 = 0;
            L42:
                if (r15 >= getPropertyCount()) goto L47;
                if (getProperty(r15).isInitialized() == false) goto L45;
                r15 = r15 + 1;
                goto L42
            L45:
                return false;
            L47:
                int r16 = 0;
            L49:
                if (r16 >= getTypeAliasCount()) goto L54;
                if (getTypeAlias(r16).isInitialized() == false) goto L52;
                r16 = r16 + 1;
                goto L49
            L52:
                return false;
            L54:
                int r17 = 0;
            L56:
                if (r17 >= getEnumEntryCount()) goto L62;
                if (getEnumEntry(r17).isInitialized() == false) goto L59;
                r17 = r17 + 1;
                goto L56
            L59:
                return false;
            L62:
                if (hasInlineClassUnderlyingType() == true) goto L64;
            L66:
                int r18 = 0;
            L68:
                if (r18 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L74;
                if (getMultiFieldValueClassUnderlyingType(r18).isInitialized() == false) goto L71;
                r18 = r18 + 1;
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

            public Builder mergeFrom(Class r10) {
                if (r10 != Class.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasFlags() == false) goto L9;
                setFlags(r10.getFlags());
            L9:
                if (r10.hasFqName() == false) goto L12;
                setFqName(r10.getFqName());
            L12:
                if (r10.hasCompanionObjectName() == false) goto L15;
                setCompanionObjectName(r10.getCompanionObjectName());
            L15:
                if (Class.access$9200(r10).isEmpty() == true) goto L21;
                if (this.typeParameter_.isEmpty() == false) goto L19;
                this.typeParameter_ = Class.access$9200(r10);
                this.bitField0_ &= -9;
                goto L21
            L19:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Class.access$9200(r10));
            L21:
                if (Class.access$9300(r10).isEmpty() == true) goto L27;
                if (this.supertype_.isEmpty() == false) goto L25;
                this.supertype_ = Class.access$9300(r10);
                this.bitField0_ &= -17;
                goto L27
            L25:
                ensureSupertypeIsMutable();
                this.supertype_.addAll(Class.access$9300(r10));
            L27:
                if (Class.access$9400(r10).isEmpty() == true) goto L33;
                if (this.supertypeId_.isEmpty() == false) goto L31;
                this.supertypeId_ = Class.access$9400(r10);
                this.bitField0_ &= -33;
                goto L33
            L31:
                ensureSupertypeIdIsMutable();
                this.supertypeId_.addAll(Class.access$9400(r10));
            L33:
                if (Class.access$9500(r10).isEmpty() == true) goto L39;
                if (this.nestedClassName_.isEmpty() == false) goto L37;
                this.nestedClassName_ = Class.access$9500(r10);
                this.bitField0_ &= -65;
                goto L39
            L37:
                ensureNestedClassNameIsMutable();
                this.nestedClassName_.addAll(Class.access$9500(r10));
            L39:
                if (Class.access$9600(r10).isEmpty() == true) goto L45;
                if (this.contextReceiverType_.isEmpty() == false) goto L43;
                this.contextReceiverType_ = Class.access$9600(r10);
                this.bitField0_ &= -129;
                goto L45
            L43:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Class.access$9600(r10));
            L45:
                if (Class.access$9700(r10).isEmpty() == true) goto L51;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L49;
                this.contextReceiverTypeId_ = Class.access$9700(r10);
                this.bitField0_ &= -257;
                goto L51
            L49:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Class.access$9700(r10));
            L51:
                if (Class.access$9800(r10).isEmpty() == true) goto L57;
                if (this.constructor_.isEmpty() == false) goto L55;
                this.constructor_ = Class.access$9800(r10);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L57
            L55:
                ensureConstructorIsMutable();
                this.constructor_.addAll(Class.access$9800(r10));
            L57:
                if (Class.access$9900(r10).isEmpty() == true) goto L63;
                if (this.function_.isEmpty() == false) goto L61;
                this.function_ = Class.access$9900(r10);
                this.bitField0_ &= -1025;
                goto L63
            L61:
                ensureFunctionIsMutable();
                this.function_.addAll(Class.access$9900(r10));
            L63:
                if (Class.access$10000(r10).isEmpty() == true) goto L69;
                if (this.property_.isEmpty() == false) goto L67;
                this.property_ = Class.access$10000(r10);
                this.bitField0_ &= -2049;
                goto L69
            L67:
                ensurePropertyIsMutable();
                this.property_.addAll(Class.access$10000(r10));
            L69:
                if (Class.access$10100(r10).isEmpty() == true) goto L75;
                if (this.typeAlias_.isEmpty() == false) goto L73;
                this.typeAlias_ = Class.access$10100(r10);
                this.bitField0_ &= -4097;
                goto L75
            L73:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Class.access$10100(r10));
            L75:
                if (Class.access$10200(r10).isEmpty() == true) goto L81;
                if (this.enumEntry_.isEmpty() == false) goto L79;
                this.enumEntry_ = Class.access$10200(r10);
                this.bitField0_ &= -8193;
                goto L81
            L79:
                ensureEnumEntryIsMutable();
                this.enumEntry_.addAll(Class.access$10200(r10));
            L81:
                if (Class.access$10300(r10).isEmpty() == true) goto L87;
                if (this.sealedSubclassFqName_.isEmpty() == false) goto L85;
                this.sealedSubclassFqName_ = Class.access$10300(r10);
                this.bitField0_ &= -16385;
                goto L87
            L85:
                ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.addAll(Class.access$10300(r10));
            L87:
                if (r10.hasInlineClassUnderlyingPropertyName() == false) goto L90;
                setInlineClassUnderlyingPropertyName(r10.getInlineClassUnderlyingPropertyName());
            L90:
                if (r10.hasInlineClassUnderlyingType() == false) goto L93;
                mergeInlineClassUnderlyingType(r10.getInlineClassUnderlyingType());
            L93:
                if (r10.hasInlineClassUnderlyingTypeId() == false) goto L96;
                setInlineClassUnderlyingTypeId(r10.getInlineClassUnderlyingTypeId());
            L96:
                if (Class.access$10700(r10).isEmpty() == true) goto L102;
                if (this.multiFieldValueClassUnderlyingName_.isEmpty() == false) goto L100;
                this.multiFieldValueClassUnderlyingName_ = Class.access$10700(r10);
                this.bitField0_ &= -262145;
                goto L102
            L100:
                ensureMultiFieldValueClassUnderlyingNameIsMutable();
                this.multiFieldValueClassUnderlyingName_.addAll(Class.access$10700(r10));
            L102:
                if (Class.access$10800(r10).isEmpty() == true) goto L108;
                if (this.multiFieldValueClassUnderlyingType_.isEmpty() == false) goto L106;
                this.multiFieldValueClassUnderlyingType_ = Class.access$10800(r10);
                this.bitField0_ &= -524289;
                goto L108
            L106:
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.addAll(Class.access$10800(r10));
            L108:
                if (Class.access$10900(r10).isEmpty() == true) goto L114;
                if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty() == false) goto L112;
                this.multiFieldValueClassUnderlyingTypeId_ = Class.access$10900(r10);
                this.bitField0_ &= -1048577;
                goto L114
            L112:
                ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                this.multiFieldValueClassUnderlyingTypeId_.addAll(Class.access$10900(r10));
            L114:
                if (r10.hasTypeTable() == false) goto L117;
                mergeTypeTable(r10.getTypeTable());
            L117:
                if (Class.access$11100(r10).isEmpty() == true) goto L123;
                if (this.versionRequirement_.isEmpty() == false) goto L121;
                this.versionRequirement_ = Class.access$11100(r10);
                this.bitField0_ &= -4194305;
                goto L123
            L121:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Class.access$11100(r10));
            L123:
                if (r10.hasVersionRequirementTable() == false) goto L125;
                mergeVersionRequirementTable(r10.getVersionRequirementTable());
            L125:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(Class.access$11400(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Class r12 = null;
                Class r13 = Class.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Class r14 = (Class) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Class) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeInlineClassUnderlyingType(Type r10) {
                if ((this.bitField0_ & 65536) == 65536) goto L5;
            L7:
                this.inlineClassUnderlyingType_ = r10;
                this.bitField0_ |= 65536;
                return this;
            L5:
                if (this.inlineClassUnderlyingType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeTypeTable(TypeTable r10) {
                if ((this.bitField0_ & 2097152) == 2097152) goto L5;
            L7:
                this.typeTable_ = r10;
                this.bitField0_ |= 2097152;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                r10 = TypeTable.newBuilder(this.typeTable_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r10) {
                if ((this.bitField0_ & 8388608) == 8388608) goto L5;
            L7:
                this.versionRequirementTable_ = r10;
                this.bitField0_ |= 8388608;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                r10 = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder setCompanionObjectName(int r10) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = r10;
                return this;
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 1;
                this.flags_ = r10;
                return this;
            }

            public Builder setFqName(int r10) {
                this.bitField0_ |= 2;
                this.fqName_ = r10;
                return this;
            }

            public Builder setInlineClassUnderlyingPropertyName(int r10) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = r10;
                return this;
            }

            public Builder setInlineClassUnderlyingTypeId(int r10) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = r10;
                return this;
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
                Kind r10 = new Kind("CLASS", 0, 0, 0);
                CLASS = r10;
                Kind r11 = new Kind("INTERFACE", 1, 1, 1);
                INTERFACE = r11;
                Kind r12 = new Kind("ENUM_CLASS", 2, 2, 2);
                ENUM_CLASS = r12;
                Kind r13 = new Kind("ENUM_ENTRY", 3, 3, 3);
                ENUM_ENTRY = r13;
                Kind r14 = new Kind("ANNOTATION_CLASS", 4, 4, 4);
                ANNOTATION_CLASS = r14;
                Kind r15 = new Kind("OBJECT", 5, 5, 5);
                OBJECT = r15;
                Kind r16 = new Kind("COMPANION_OBJECT", 6, 6, 6);
                COMPANION_OBJECT = r16;
                $VALUES = new Kind[]{r10, r11, r12, r13, r14, r15, r16};
                internalValueMap = new AnonymousClass1();
            }

            private Kind(String r10, int r11, int r12, int r13) {
                super(r10, r11);
                this.value = r13;
            }

            public static Kind valueOf(int r10) {
                switch(r10) {
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

            public static Kind valueOf(String r10) {
                return (Kind) Enum.valueOf(Kind.class, r10);
            }

            public static Kind[] values() {
                return (Kind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Class r10 = new Class(true);
            defaultInstance = r10;
            r10.initFields();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class(CodedInputStream r18, ExtensionRegistryLite r19) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r11 = CodedOutputStream.newInstance(r10, 1);
            boolean r12 = false;
            int r13 = 0;
        L4:
            if (r12 == true) goto L229;
            int r15 = r18.readTag();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            Cloneable r16 = null;
            switch(r15) {
                case 0: goto L159;
                case 8: goto L157;
                case 16: goto L153;
                case 18: goto L144;
                case 24: goto L143;
                case 32: goto L142;
                case 42: goto L139;
                case 50: goto L135;
                case 56: goto L131;
                case 58: goto L122;
                case 66: goto L119;
                case 74: goto L115;
                case 82: goto L111;
                case 90: goto L107;
                case 106: goto L103;
                case 128: goto L99;
                case 130: goto L90;
                case 136: goto L89;
                case 146: goto L83;
                case 152: goto L81;
                case 162: goto L78;
                case 168: goto L74;
                case 170: goto L65;
                case 176: goto L62;
                case 178: goto L53;
                case 186: goto L49;
                case 192: goto L45;
                case 194: goto L35;
                case 242: goto L29;
                case 248: goto L25;
                case 250: goto L15;
                case 258: goto L9;
                default: goto L7;
            };     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L7:
            boolean r14 = true;
            if (parseUnknownField(r18, r11, r19, r15) == true) goto L4;
        L160:
            r12 = r14;
            goto L4
        L15:
            int r17 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if ((r13 & 4194304) == 4194304) goto L21;
            if (r18.getBytesUntilLimit() <= 0) goto L21;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 4194304;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L21:
            if (r18.getBytesUntilLimit() <= 0) goto L23;
            this.versionRequirement_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L21
        L23:
            r18.popLimit(r17);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L156:
            r14 = true;
            goto L4
        L35:
            int r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if ((r13 & 1048576) == 1048576) goto L41;
            if (r18.getBytesUntilLimit() <= 0) goto L41;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 1048576;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L41:
            if (r18.getBytesUntilLimit() <= 0) goto L43;
            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L43:
            r18.popLimit(r110);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L53:
            r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if ((r13 & 262144) == 262144) goto L59;
            if (r18.getBytesUntilLimit() <= 0) goto L59;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 262144;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L59:
            if (r18.getBytesUntilLimit() <= 0) goto L43;
            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L59
        L65:
            r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if ((r13 & 256) == 256) goto L71;
            if (r18.getBytesUntilLimit() <= 0) goto L71;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 256;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L71:
            if (r18.getBytesUntilLimit() <= 0) goto L43;
            this.contextReceiverTypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L71
        L81:
            this.bitField0_ |= 32;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.inlineClassUnderlyingTypeId_ = r18.readInt32();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L89:
            this.bitField0_ |= 8;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.inlineClassUnderlyingPropertyName_ = r18.readInt32();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L90:
            r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if ((r13 & 16384) == 16384) goto L96;
            if (r18.getBytesUntilLimit() <= 0) goto L96;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 16384;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L96:
            if (r18.getBytesUntilLimit() <= 0) goto L43;
            this.sealedSubclassFqName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L96
        L122:
            r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if ((r13 & 64) == 64) goto L128;
            if (r18.getBytesUntilLimit() <= 0) goto L128;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 64;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L128:
            if (r18.getBytesUntilLimit() <= 0) goto L43;
            this.nestedClassName_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L128
        L142:
            this.bitField0_ |= 4;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.companionObjectName_ = r18.readInt32();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L143:
            this.bitField0_ |= 2;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.fqName_ = r18.readInt32();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L144:
            r110 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if ((r13 & 32) == 32) goto L150;
            if (r18.getBytesUntilLimit() <= 0) goto L150;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 32;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L150:
            if (r18.getBytesUntilLimit() <= 0) goto L43;
            this.supertypeId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L150
        L157:
            r14 = true;
            this.bitField0_ |= 1;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.flags_ = r18.readInt32();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L4
        L159:
            r14 = true;
            goto L160
        L9:
            if ((this.bitField0_ & 128) != 128) goto L11;
            r16 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L11:
            VersionRequirementTable.Builder r111 = r16;
            VersionRequirementTable r112 = (VersionRequirementTable) r18.readMessage(VersionRequirementTable.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.versionRequirementTable_ = r112;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if (r111 == 0) goto L14;
            r111.mergeFrom(r112);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.versionRequirementTable_ = r111.buildPartial();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L14:
            this.bitField0_ |= 128;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L25:
            if ((r13 & 4194304) == 4194304) goto L27;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 4194304;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L27:
            List r113 = this.versionRequirement_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            Object r114 = Integer.valueOf(r18.readInt32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L52:
            r113.add(r114);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L29:
            if ((this.bitField0_ & 64) != 64) goto L31;
            r16 = this.typeTable_.toBuilder();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L31:
            TypeTable.Builder r115 = r16;
            TypeTable r116 = (TypeTable) r18.readMessage(TypeTable.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.typeTable_ = r116;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if (r115 == 0) goto L34;
            r115.mergeFrom(r116);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.typeTable_ = r115.buildPartial();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L34:
            this.bitField0_ |= 64;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L45:
            if ((r13 & 1048576) == 1048576) goto L47;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 1048576;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L47:
            r113 = this.multiFieldValueClassUnderlyingTypeId_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = Integer.valueOf(r18.readInt32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L49:
            if ((r13 & 524288) == 524288) goto L51;
            this.multiFieldValueClassUnderlyingType_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 524288;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L51:
            r113 = this.multiFieldValueClassUnderlyingType_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(Type.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L62:
            if ((r13 & 262144) == 262144) goto L64;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 262144;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L64:
            r113 = this.multiFieldValueClassUnderlyingName_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = Integer.valueOf(r18.readInt32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L74:
            if ((r13 & 256) == 256) goto L76;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 256;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L76:
            r113 = this.contextReceiverTypeId_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = Integer.valueOf(r18.readInt32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L78:
            if ((r13 & 128) == 128) goto L80;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 128;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L80:
            r113 = this.contextReceiverType_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(Type.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L83:
            if ((this.bitField0_ & 16) != 16) goto L85;
            r16 = this.inlineClassUnderlyingType_.toBuilder();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L85:
            Type.Builder r117 = r16;
            Type r118 = (Type) r18.readMessage(Type.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.inlineClassUnderlyingType_ = r118;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            if (r117 == 0) goto L88;
            r117.mergeFrom(r118);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            this.inlineClassUnderlyingType_ = r117.buildPartial();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L88:
            this.bitField0_ |= 16;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L156
        L99:
            if ((r13 & 16384) == 16384) goto L101;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 16384;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L101:
            r113 = this.sealedSubclassFqName_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = Integer.valueOf(r18.readInt32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L103:
            if ((r13 & 8192) == 8192) goto L105;
            this.enumEntry_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 8192;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L105:
            r113 = this.enumEntry_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(EnumEntry.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L107:
            if ((r13 & 4096) == 4096) goto L109;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 4096;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L109:
            r113 = this.typeAlias_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(TypeAlias.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L111:
            if ((r13 & 2048) == 2048) goto L113;
            this.property_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 2048;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L113:
            r113 = this.property_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(Property.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L115:
            if ((r13 & 1024) == 1024) goto L117;
            this.function_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 1024;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L117:
            r113 = this.function_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(Function.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L119:
            if ((r13 & 512) == 512) goto L121;
            this.constructor_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 512;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L121:
            r113 = this.constructor_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(Constructor.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L131:
            if ((r13 & 64) == 64) goto L133;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 64;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L133:
            r113 = this.nestedClassName_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = Integer.valueOf(r18.readInt32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L135:
            if ((r13 & 16) == 16) goto L137;
            this.supertype_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 16;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L137:
            r113 = this.supertype_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(Type.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L139:
            if ((r13 & 8) == 8) goto L141;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 8;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L141:
            r113 = this.typeParameter_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = r18.readMessage(TypeParameter.PARSER, r19);     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L153:
            if ((r13 & 32) == 32) goto L155;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r13 = r13 | 32;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
        L155:
            r113 = this.supertypeId_;     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            r114 = Integer.valueOf(r18.readInt32());     // Catch: Throwable -> L164 IOException -> L166 InvalidProtocolBufferException -> L170
            goto L52
        L164:
            th = move-exception;
            if ((r13 & 32) != 32) goto L177;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L177:
            if ((r13 & 8) != 8) goto L180;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L180:
            if ((r13 & 16) != 16) goto L183;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L183:
            if ((r13 & 64) != 64) goto L186;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L186:
            if ((r13 & 512) != 512) goto L189;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L189:
            if ((r13 & 1024) != 1024) goto L192;
            this.function_ = Collections.unmodifiableList(this.function_);
        L192:
            if ((r13 & 2048) != 2048) goto L195;
            this.property_ = Collections.unmodifiableList(this.property_);
        L195:
            if ((r13 & 4096) != 4096) goto L198;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L198:
            if ((r13 & 8192) != 8192) goto L201;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L201:
            if ((r13 & 16384) != 16384) goto L204;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L204:
            if ((r13 & 128) != 128) goto L207;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L207:
            if ((r13 & 256) != 256) goto L210;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L210:
            if ((r13 & 262144) != 262144) goto L213;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L213:
            if ((r13 & 524288) != 524288) goto L216;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L216:
            if ((r13 & 1048576) != 1048576) goto L219;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L219:
            if ((r13 & 4194304) != 4194304) goto L289;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L289:
            r11.flush();     // Catch: IOException -> L284 Throwable -> L223
        L223:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L222:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L170:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L164
        L166:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L164
        L229:
            if ((r13 & 32) != 32) goto L232;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L232:
            if ((r13 & 8) != 8) goto L235;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L235:
            if ((r13 & 16) != 16) goto L238;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L238:
            if ((r13 & 64) != 64) goto L241;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L241:
            if ((r13 & 512) != 512) goto L244;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L244:
            if ((r13 & 1024) != 1024) goto L247;
            this.function_ = Collections.unmodifiableList(this.function_);
        L247:
            if ((r13 & 2048) != 2048) goto L250;
            this.property_ = Collections.unmodifiableList(this.property_);
        L250:
            if ((r13 & 4096) != 4096) goto L253;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L253:
            if ((r13 & 8192) != 8192) goto L256;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L256:
            if ((r13 & 16384) != 16384) goto L259;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L259:
            if ((r13 & 128) != 128) goto L262;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L262:
            if ((r13 & 256) != 256) goto L265;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L265:
            if ((r13 & 262144) != 262144) goto L268;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L268:
            if ((r13 & 524288) != 524288) goto L271;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L271:
            if ((r13 & 1048576) != 1048576) goto L274;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L274:
            if ((r13 & 4194304) != 4194304) goto L286;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L286:
            r11.flush();     // Catch: IOException -> L283 Throwable -> L278
        L278:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L277:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Class(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> r10) {
            super(r10);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Class(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Class(boolean r10) {
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

        static /* synthetic */ List access$10000(Class r10) {
            return r10.property_;
        }

        static /* synthetic */ List access$10002(Class r10, List r11) {
            r10.property_ = r11;
            return r11;
        }

        static /* synthetic */ List access$10100(Class r10) {
            return r10.typeAlias_;
        }

        static /* synthetic */ List access$10102(Class r10, List r11) {
            r10.typeAlias_ = r11;
            return r11;
        }

        static /* synthetic */ List access$10200(Class r10) {
            return r10.enumEntry_;
        }

        static /* synthetic */ List access$10202(Class r10, List r11) {
            r10.enumEntry_ = r11;
            return r11;
        }

        static /* synthetic */ List access$10300(Class r10) {
            return r10.sealedSubclassFqName_;
        }

        static /* synthetic */ List access$10302(Class r10, List r11) {
            r10.sealedSubclassFqName_ = r11;
            return r11;
        }

        static /* synthetic */ int access$10402(Class r10, int r11) {
            r10.inlineClassUnderlyingPropertyName_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$10502(Class r10, Type r11) {
            r10.inlineClassUnderlyingType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$10602(Class r10, int r11) {
            r10.inlineClassUnderlyingTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$10700(Class r10) {
            return r10.multiFieldValueClassUnderlyingName_;
        }

        static /* synthetic */ List access$10702(Class r10, List r11) {
            r10.multiFieldValueClassUnderlyingName_ = r11;
            return r11;
        }

        static /* synthetic */ List access$10800(Class r10) {
            return r10.multiFieldValueClassUnderlyingType_;
        }

        static /* synthetic */ List access$10802(Class r10, List r11) {
            r10.multiFieldValueClassUnderlyingType_ = r11;
            return r11;
        }

        static /* synthetic */ List access$10900(Class r10) {
            return r10.multiFieldValueClassUnderlyingTypeId_;
        }

        static /* synthetic */ List access$10902(Class r10, List r11) {
            r10.multiFieldValueClassUnderlyingTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ TypeTable access$11002(Class r10, TypeTable r11) {
            r10.typeTable_ = r11;
            return r11;
        }

        static /* synthetic */ List access$11100(Class r10) {
            return r10.versionRequirement_;
        }

        static /* synthetic */ List access$11102(Class r10, List r11) {
            r10.versionRequirement_ = r11;
            return r11;
        }

        static /* synthetic */ VersionRequirementTable access$11202(Class r10, VersionRequirementTable r11) {
            r10.versionRequirementTable_ = r11;
            return r11;
        }

        static /* synthetic */ int access$11302(Class r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$11400(Class r10) {
            return r10.unknownFields;
        }

        static /* synthetic */ int access$8902(Class r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$9002(Class r10, int r11) {
            r10.fqName_ = r11;
            return r11;
        }

        static /* synthetic */ int access$9102(Class r10, int r11) {
            r10.companionObjectName_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9200(Class r10) {
            return r10.typeParameter_;
        }

        static /* synthetic */ List access$9202(Class r10, List r11) {
            r10.typeParameter_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9300(Class r10) {
            return r10.supertype_;
        }

        static /* synthetic */ List access$9302(Class r10, List r11) {
            r10.supertype_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9400(Class r10) {
            return r10.supertypeId_;
        }

        static /* synthetic */ List access$9402(Class r10, List r11) {
            r10.supertypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9500(Class r10) {
            return r10.nestedClassName_;
        }

        static /* synthetic */ List access$9502(Class r10, List r11) {
            r10.nestedClassName_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9600(Class r10) {
            return r10.contextReceiverType_;
        }

        static /* synthetic */ List access$9602(Class r10, List r11) {
            r10.contextReceiverType_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9700(Class r10) {
            return r10.contextReceiverTypeId_;
        }

        static /* synthetic */ List access$9702(Class r10, List r11) {
            r10.contextReceiverTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9800(Class r10) {
            return r10.constructor_;
        }

        static /* synthetic */ List access$9802(Class r10, List r11) {
            r10.constructor_ = r11;
            return r11;
        }

        static /* synthetic */ List access$9900(Class r10) {
            return r10.function_;
        }

        static /* synthetic */ List access$9902(Class r10, List r11) {
            r10.function_ = r11;
            return r11;
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

        public static Builder newBuilder(Class r10) {
            return newBuilder().mergeFrom(r10);
        }

        public static Class parseFrom(InputStream r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public Constructor getConstructor(int r10) {
            return this.constructor_.get(r10);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public Type getContextReceiverType(int r10) {
            return this.contextReceiverType_.get(r10);
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
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public EnumEntry getEnumEntry(int r10) {
            return this.enumEntry_.get(r10);
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

        public Function getFunction(int r10) {
            return this.function_.get(r10);
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

        public Type getMultiFieldValueClassUnderlyingType(int r10) {
            return this.multiFieldValueClassUnderlyingType_.get(r10);
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

        public Property getProperty(int r10) {
            return this.property_.get(r10);
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L9:
            int r13 = 0;
            int r14 = 0;
        L11:
            if (r13 >= this.supertypeId_.size()) goto L13;
            r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(r13).intValue());
            r13 = r13 + 1;
            goto L11
        L13:
            int r15 = r12 + r14;
            if (getSupertypeIdList().isEmpty() == true) goto L16;
            r15 = (r15 + 1) + CodedOutputStream.computeInt32SizeNoTag(r14);
        L16:
            this.supertypeIdMemoizedSerializedSize = r14;
            if ((this.bitField0_ & 2) != 2) goto L20;
            r15 = r15 + CodedOutputStream.computeInt32Size(3, this.fqName_);
        L20:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r15 = r15 + CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        L22:
            int r16 = 0;
        L24:
            if (r16 >= this.typeParameter_.size()) goto L26;
            r15 = r15 + CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(r16));
            r16 = r16 + 1;
            goto L24
        L26:
            int r17 = 0;
        L28:
            if (r17 >= this.supertype_.size()) goto L30;
            r15 = r15 + CodedOutputStream.computeMessageSize(6, this.supertype_.get(r17));
            r17 = r17 + 1;
            goto L28
        L30:
            int r18 = 0;
            int r19 = 0;
        L32:
            if (r18 >= this.nestedClassName_.size()) goto L34;
            r19 = r19 + CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(r18).intValue());
            r18 = r18 + 1;
            goto L32
        L34:
            int r20 = r15 + r19;
            if (getNestedClassNameList().isEmpty() == true) goto L37;
            r20 = (r20 + 1) + CodedOutputStream.computeInt32SizeNoTag(r19);
        L37:
            this.nestedClassNameMemoizedSerializedSize = r19;
            int r21 = 0;
        L39:
            if (r21 >= this.constructor_.size()) goto L41;
            r20 = r20 + CodedOutputStream.computeMessageSize(8, this.constructor_.get(r21));
            r21 = r21 + 1;
            goto L39
        L41:
            int r22 = 0;
        L43:
            if (r22 >= this.function_.size()) goto L45;
            r20 = r20 + CodedOutputStream.computeMessageSize(9, this.function_.get(r22));
            r22 = r22 + 1;
            goto L43
        L45:
            int r23 = 0;
        L47:
            if (r23 >= this.property_.size()) goto L49;
            r20 = r20 + CodedOutputStream.computeMessageSize(10, this.property_.get(r23));
            r23 = r23 + 1;
            goto L47
        L49:
            int r24 = 0;
        L51:
            if (r24 >= this.typeAlias_.size()) goto L53;
            r20 = r20 + CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(r24));
            r24 = r24 + 1;
            goto L51
        L53:
            int r25 = 0;
        L55:
            if (r25 >= this.enumEntry_.size()) goto L57;
            r20 = r20 + CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(r25));
            r25 = r25 + 1;
            goto L55
        L57:
            int r26 = 0;
            int r27 = 0;
        L59:
            if (r26 >= this.sealedSubclassFqName_.size()) goto L61;
            r27 = r27 + CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(r26).intValue());
            r26 = r26 + 1;
            goto L59
        L61:
            int r28 = r20 + r27;
            if (getSealedSubclassFqNameList().isEmpty() == true) goto L64;
            r28 = (r28 + 2) + CodedOutputStream.computeInt32SizeNoTag(r27);
        L64:
            this.sealedSubclassFqNameMemoizedSerializedSize = r27;
            if ((this.bitField0_ & 8) != 8) goto L68;
            r28 = r28 + CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
        L68:
            if ((this.bitField0_ & 16) != 16) goto L71;
            r28 = r28 + CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
        L71:
            if ((this.bitField0_ & 32) != 32) goto L73;
            r28 = r28 + CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
        L73:
            int r29 = 0;
        L75:
            if (r29 >= this.contextReceiverType_.size()) goto L77;
            r28 = r28 + CodedOutputStream.computeMessageSize(20, this.contextReceiverType_.get(r29));
            r29 = r29 + 1;
            goto L75
        L77:
            int r30 = 0;
            int r31 = 0;
        L79:
            if (r30 >= this.contextReceiverTypeId_.size()) goto L81;
            r31 = r31 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r30).intValue());
            r30 = r30 + 1;
            goto L79
        L81:
            int r32 = r28 + r31;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L84;
            r32 = (r32 + 2) + CodedOutputStream.computeInt32SizeNoTag(r31);
        L84:
            this.contextReceiverTypeIdMemoizedSerializedSize = r31;
            int r33 = 0;
            int r34 = 0;
        L86:
            if (r33 >= this.multiFieldValueClassUnderlyingName_.size()) goto L88;
            r34 = r34 + CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingName_.get(r33).intValue());
            r33 = r33 + 1;
            goto L86
        L88:
            int r35 = r32 + r34;
            if (getMultiFieldValueClassUnderlyingNameList().isEmpty() == true) goto L91;
            r35 = (r35 + 2) + CodedOutputStream.computeInt32SizeNoTag(r34);
        L91:
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r34;
            int r36 = 0;
        L93:
            if (r36 >= this.multiFieldValueClassUnderlyingType_.size()) goto L95;
            r35 = r35 + CodedOutputStream.computeMessageSize(23, this.multiFieldValueClassUnderlyingType_.get(r36));
            r36 = r36 + 1;
            goto L93
        L95:
            int r37 = 0;
            int r38 = 0;
        L97:
            if (r37 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r38 = r38 + CodedOutputStream.computeInt32SizeNoTag(this.multiFieldValueClassUnderlyingTypeId_.get(r37).intValue());
            r37 = r37 + 1;
            goto L97
        L99:
            int r39 = r35 + r38;
            if (getMultiFieldValueClassUnderlyingTypeIdList().isEmpty() == true) goto L102;
            r39 = (r39 + 2) + CodedOutputStream.computeInt32SizeNoTag(r38);
        L102:
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r38;
            if ((this.bitField0_ & 64) != 64) goto L105;
            r39 = r39 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L105:
            int r40 = 0;
        L107:
            if (r11 >= this.versionRequirement_.size()) goto L109;
            r40 = r40 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L107
        L109:
            int r41 = (r39 + r40) + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) != 128) goto L112;
            r41 = r41 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L112:
            int r42 = (r41 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r42;
            return r42;
        L8:
            r12 = 0;
            goto L9
        }

        public Type getSupertype(int r10) {
            return this.supertype_.get(r10);
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

        public TypeAlias getTypeAlias(int r10) {
            return this.typeAlias_.get(r10);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeParameter getTypeParameter(int r10) {
            return this.typeParameter_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
            return false;
        L9:
            if (hasFqName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r11 = 0;
        L14:
            if (r11 >= getTypeParameterCount()) goto L20;
            if (getTypeParameter(r11).isInitialized() == false) goto L17;
            r11 = r11 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            int r12 = 0;
        L22:
            if (r12 >= getSupertypeCount()) goto L28;
            if (getSupertype(r12).isInitialized() == false) goto L25;
            r12 = r12 + 1;
            goto L22
        L25:
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            int r13 = 0;
        L30:
            if (r13 >= getContextReceiverTypeCount()) goto L36;
            if (getContextReceiverType(r13).isInitialized() == false) goto L33;
            r13 = r13 + 1;
            goto L30
        L33:
            this.memoizedIsInitialized = 0;
            return false;
        L36:
            int r14 = 0;
        L38:
            if (r14 >= getConstructorCount()) goto L44;
            if (getConstructor(r14).isInitialized() == false) goto L41;
            r14 = r14 + 1;
            goto L38
        L41:
            this.memoizedIsInitialized = 0;
            return false;
        L44:
            int r15 = 0;
        L46:
            if (r15 >= getFunctionCount()) goto L52;
            if (getFunction(r15).isInitialized() == false) goto L49;
            r15 = r15 + 1;
            goto L46
        L49:
            this.memoizedIsInitialized = 0;
            return false;
        L52:
            int r16 = 0;
        L54:
            if (r16 >= getPropertyCount()) goto L60;
            if (getProperty(r16).isInitialized() == false) goto L57;
            r16 = r16 + 1;
            goto L54
        L57:
            this.memoizedIsInitialized = 0;
            return false;
        L60:
            int r17 = 0;
        L62:
            if (r17 >= getTypeAliasCount()) goto L68;
            if (getTypeAlias(r17).isInitialized() == false) goto L65;
            r17 = r17 + 1;
            goto L62
        L65:
            this.memoizedIsInitialized = 0;
            return false;
        L68:
            int r18 = 0;
        L70:
            if (r18 >= getEnumEntryCount()) goto L77;
            if (getEnumEntry(r18).isInitialized() == false) goto L73;
            r18 = r18 + 1;
            goto L70
        L73:
            this.memoizedIsInitialized = 0;
            return false;
        L77:
            if (hasInlineClassUnderlyingType() == true) goto L79;
        L82:
            int r19 = 0;
        L84:
            if (r19 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L91;
            if (getMultiFieldValueClassUnderlyingType(r19).isInitialized() == false) goto L87;
            r19 = r19 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.flags_);
        L6:
            if (getSupertypeIdList().size() <= 0) goto L8;
            r10.writeRawVarint32(18);
            r10.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        L8:
            int r12 = 0;
            int r13 = 0;
        L10:
            if (r13 >= this.supertypeId_.size()) goto L13;
            r10.writeInt32NoTag(this.supertypeId_.get(r13).intValue());
            r13 = r13 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r10.writeInt32(3, this.fqName_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r10.writeInt32(4, this.companionObjectName_);
        L18:
            int r14 = 0;
        L20:
            if (r14 >= this.typeParameter_.size()) goto L22;
            r10.writeMessage(5, this.typeParameter_.get(r14));
            r14 = r14 + 1;
            goto L20
        L22:
            int r15 = 0;
        L24:
            if (r15 >= this.supertype_.size()) goto L27;
            r10.writeMessage(6, this.supertype_.get(r15));
            r15 = r15 + 1;
            goto L24
        L27:
            if (getNestedClassNameList().size() <= 0) goto L29;
            r10.writeRawVarint32(58);
            r10.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        L29:
            int r16 = 0;
        L31:
            if (r16 >= this.nestedClassName_.size()) goto L33;
            r10.writeInt32NoTag(this.nestedClassName_.get(r16).intValue());
            r16 = r16 + 1;
            goto L31
        L33:
            int r17 = 0;
        L35:
            if (r17 >= this.constructor_.size()) goto L37;
            r10.writeMessage(8, this.constructor_.get(r17));
            r17 = r17 + 1;
            goto L35
        L37:
            int r18 = 0;
        L39:
            if (r18 >= this.function_.size()) goto L41;
            r10.writeMessage(9, this.function_.get(r18));
            r18 = r18 + 1;
            goto L39
        L41:
            int r19 = 0;
        L43:
            if (r19 >= this.property_.size()) goto L45;
            r10.writeMessage(10, this.property_.get(r19));
            r19 = r19 + 1;
            goto L43
        L45:
            int r20 = 0;
        L47:
            if (r20 >= this.typeAlias_.size()) goto L49;
            r10.writeMessage(11, this.typeAlias_.get(r20));
            r20 = r20 + 1;
            goto L47
        L49:
            int r21 = 0;
        L51:
            if (r21 >= this.enumEntry_.size()) goto L54;
            r10.writeMessage(13, this.enumEntry_.get(r21));
            r21 = r21 + 1;
            goto L51
        L54:
            if (getSealedSubclassFqNameList().size() <= 0) goto L56;
            r10.writeRawVarint32(130);
            r10.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        L56:
            int r22 = 0;
        L58:
            if (r22 >= this.sealedSubclassFqName_.size()) goto L61;
            r10.writeInt32NoTag(this.sealedSubclassFqName_.get(r22).intValue());
            r22 = r22 + 1;
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
            int r23 = 0;
        L71:
            if (r23 >= this.contextReceiverType_.size()) goto L74;
            r10.writeMessage(20, this.contextReceiverType_.get(r23));
            r23 = r23 + 1;
            goto L71
        L74:
            if (getContextReceiverTypeIdList().size() <= 0) goto L76;
            r10.writeRawVarint32(170);
            r10.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L76:
            int r24 = 0;
        L78:
            if (r24 >= this.contextReceiverTypeId_.size()) goto L81;
            r10.writeInt32NoTag(this.contextReceiverTypeId_.get(r24).intValue());
            r24 = r24 + 1;
            goto L78
        L81:
            if (getMultiFieldValueClassUnderlyingNameList().size() <= 0) goto L83;
            r10.writeRawVarint32(178);
            r10.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
        L83:
            int r25 = 0;
        L85:
            if (r25 >= this.multiFieldValueClassUnderlyingName_.size()) goto L87;
            r10.writeInt32NoTag(this.multiFieldValueClassUnderlyingName_.get(r25).intValue());
            r25 = r25 + 1;
            goto L85
        L87:
            int r26 = 0;
        L89:
            if (r26 >= this.multiFieldValueClassUnderlyingType_.size()) goto L92;
            r10.writeMessage(23, this.multiFieldValueClassUnderlyingType_.get(r26));
            r26 = r26 + 1;
            goto L89
        L92:
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() <= 0) goto L94;
            r10.writeRawVarint32(194);
            r10.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
        L94:
            int r27 = 0;
        L96:
            if (r27 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r10.writeInt32NoTag(this.multiFieldValueClassUnderlyingTypeId_.get(r27).intValue());
            r27 = r27 + 1;
            goto L96
        L99:
            if ((this.bitField0_ & 64) != 64) goto L102;
            r10.writeMessage(30, this.typeTable_);
        L102:
            if (r12 >= this.versionRequirement_.size()) goto L105;
            r10.writeInt32(31, this.versionRequirement_.get(r12).intValue());
            r12 = r12 + 1;
            goto L102
        L105:
            if ((this.bitField0_ & 128) != 128) goto L107;
            r10.writeMessage(32, this.versionRequirementTable_);
        L107:
            r11.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$13300() {
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
            public Constructor build() {
                Constructor r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Constructor buildPartial() {
                Constructor r10 = new Constructor(this, null);
                int r11 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r11 = 0;
            L6:
                Constructor.access$13502(r10, this.flags_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -3;
            L9:
                Constructor.access$13602(r10, this.valueParameter_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -5;
            L12:
                Constructor.access$13702(r10, this.versionRequirement_);
                Constructor.access$13802(r10, r11);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public ValueParameter getValueParameter(int r10) {
                return this.valueParameter_.get(r10);
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r10 = 0;
            L4:
                if (r10 >= getValueParameterCount()) goto L10;
                if (getValueParameter(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (extensionsAreInitialized() == true) goto L12;
                return false;
            L12:
                return true;
            }

            public Builder mergeFrom(Constructor r10) {
                if (r10 != Constructor.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasFlags() == false) goto L9;
                setFlags(r10.getFlags());
            L9:
                if (Constructor.access$13600(r10).isEmpty() == true) goto L15;
                if (this.valueParameter_.isEmpty() == false) goto L13;
                this.valueParameter_ = Constructor.access$13600(r10);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Constructor.access$13600(r10));
            L15:
                if (Constructor.access$13700(r10).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(Constructor.access$13900(r10)));
                return this;
            L17:
                if (this.versionRequirement_.isEmpty() == false) goto L19;
                this.versionRequirement_ = Constructor.access$13700(r10);
                this.bitField0_ &= -5;
                goto L20
            L19:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Constructor.access$13700(r10));
                goto L20
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Constructor r12 = null;
                Constructor r13 = Constructor.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Constructor r14 = (Constructor) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Constructor) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 1;
                this.flags_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Constructor r10 = new Constructor(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Constructor(CodedInputStream r11, ExtensionRegistryLite r12) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r10, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L61;
            int r16 = r11.readTag();     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            if (r16 == 0) goto L38;
            if (r16 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            this.flags_ = r11.readInt32();     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            goto L4
        L10:
            if (r16 == 18) goto L33;
            if (r16 != 248) goto L14;
            if ((r15 & 4) == 4) goto L30;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            r15 = r15 | 4;     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
        L30:
            List r17 = this.versionRequirement_;     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            Object r18 = Integer.valueOf(r11.readInt32());     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
        L31:
            r17.add(r18);     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            goto L4
        L14:
            if (r16 != 250) goto L16;
            int r19 = r11.pushLimit(r11.readRawVarint32());     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            if ((r15 & 4) == 4) goto L24;
            if (r11.getBytesUntilLimit() <= 0) goto L24;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            r15 = r15 | 4;     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
        L24:
            if (r11.getBytesUntilLimit() <= 0) goto L26;
            this.versionRequirement_.add(Integer.valueOf(r11.readInt32()));     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            goto L24
        L26:
            r11.popLimit(r19);     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            goto L4
        L16:
            if (parseUnknownField(r11, r13, r12, r16) == true) goto L4;
        L33:
            if ((r15 & 2) == 2) goto L35;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            r15 = r15 | 2;     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
        L35:
            r17 = this.valueParameter_;     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
            r18 = r11.readMessage(ValueParameter.PARSER, r12);     // Catch: Throwable -> L39 IOException -> L41 InvalidProtocolBufferException -> L44
        L38:
            r14 = true;
            goto L4
        L39:
            th = move-exception;
            if ((r15 & 2) != 2) goto L51;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L51:
            if ((r15 & 4) != 4) goto L78;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L78:
            r13.flush();     // Catch: IOException -> L74 Throwable -> L55
        L55:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L54:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L44:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L39
        L41:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L39
        L61:
            if ((r15 & 2) != 2) goto L64;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L64:
            if ((r15 & 4) != 4) goto L76;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L76:
            r13.flush();     // Catch: IOException -> L73 Throwable -> L68
        L68:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L67:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Constructor(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Constructor(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Constructor(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$13502(Constructor r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ List access$13600(Constructor r10) {
            return r10.valueParameter_;
        }

        static /* synthetic */ List access$13602(Constructor r10, List r11) {
            r10.valueParameter_ = r11;
            return r11;
        }

        static /* synthetic */ List access$13700(Constructor r10) {
            return r10.versionRequirement_;
        }

        static /* synthetic */ List access$13702(Constructor r10, List r11) {
            r10.versionRequirement_ = r11;
            return r11;
        }

        static /* synthetic */ int access$13802(Constructor r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$13900(Constructor r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Constructor r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L9:
            int r13 = 0;
        L11:
            if (r13 >= this.valueParameter_.size()) goto L13;
            r12 = r12 + CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(r13));
            r13 = r13 + 1;
            goto L11
        L13:
            int r14 = 0;
        L15:
            if (r11 >= this.versionRequirement_.size()) goto L17;
            r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L15
        L17:
            int r15 = (((r12 + r14) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r15;
            return r15;
        L8:
            r12 = 0;
            goto L9
        }

        public ValueParameter getValueParameter(int r10) {
            return this.valueParameter_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getValueParameterCount()) goto L17;
            if (getValueParameter(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r10.writeInt32(1, this.flags_);
        L5:
            int r12 = 0;
            int r13 = 0;
        L7:
            if (r13 >= this.valueParameter_.size()) goto L10;
            r10.writeMessage(2, this.valueParameter_.get(r13));
            r13 = r13 + 1;
        L10:
            if (r12 >= this.versionRequirement_.size()) goto L12;
            r10.writeInt32(31, this.versionRequirement_.get(r12).intValue());
            r12 = r12 + 1;
            goto L10
        L12:
            r11.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$23500() {
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
            public Contract build() {
                Contract r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Contract buildPartial() {
                Contract r10 = new Contract(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.effect_ = Collections.unmodifiableList(this.effect_);
                this.bitField0_ &= -2;
            L5:
                Contract.access$23702(r10, this.effect_);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Effect getEffect(int r10) {
                return this.effect_.get(r10);
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r10 = 0;
            L4:
                if (r10 >= getEffectCount()) goto L9;
                if (getEffect(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            public Builder mergeFrom(Contract r10) {
                if (r10 != Contract.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Contract.access$23700(r10).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(Contract.access$23800(r10)));
                return this;
            L8:
                if (this.effect_.isEmpty() == false) goto L10;
                this.effect_ = Contract.access$23700(r10);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureEffectIsMutable();
                this.effect_.addAll(Contract.access$23700(r10));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Contract r12 = null;
                Contract r13 = Contract.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Contract r14 = (Contract) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Contract) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Contract r10 = new Contract(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Contract(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            boolean r15 = false;
        L3:
            if (r14 == true) goto L36;
            int r16 = r10.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r16 == 0) goto L16;
            if (r16 != 10) goto L9;
            if ((r15 & true) == true) goto L14;
            this.effect_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r15 = r15 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.effect_.add((Effect) r10.readMessage(Effect.PARSER, r11));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L3;
        L16:
            r14 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r15 & true) != true) goto L48;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L48:
            r13.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L29:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r15 & true) != true) goto L51;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L51:
            r13.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L39:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Contract(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Contract(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Contract(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Contract(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ List access$23700(Contract r10) {
            return r10.effect_;
        }

        static /* synthetic */ List access$23702(Contract r10, List r11) {
            r10.effect_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$23800(Contract r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Contract r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Effect getEffect(int r10) {
            return this.effect_.get(r10);
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.effect_.size()) goto L9;
            r12 = r12 + CodedOutputStream.computeMessageSize(1, this.effect_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = r12 + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getEffectCount()) goto L16;
            if (getEffect(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            int r11 = 0;
        L4:
            if (r11 >= this.effect_.size()) goto L6;
            r10.writeMessage(1, this.effect_.get(r11));
            r11 = r11 + 1;
            goto L4
        L6:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$24000() {
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
            public Effect build() {
                Effect r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Effect buildPartial() {
                Effect r10 = new Effect(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                Effect.access$24202(r10, this.effectType_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                this.bitField0_ &= -3;
            L9:
                Effect.access$24302(r10, this.effectConstructorArgument_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 2;
            L12:
                Effect.access$24402(r10, this.conclusionOfConditionalEffect_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 4;
            L15:
                Effect.access$24502(r10, this.kind_);
                Effect.access$24602(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Expression getEffectConstructorArgument(int r10) {
                return this.effectConstructorArgument_.get(r10);
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
                int r10 = 0;
            L4:
                if (r10 >= getEffectConstructorArgumentCount()) goto L10;
                if (getEffectConstructorArgument(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
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

            public Builder mergeConclusionOfConditionalEffect(Expression r10) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.conclusionOfConditionalEffect_ = r10;
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.conclusionOfConditionalEffect_ == Expression.getDefaultInstance()) goto L7;
                r10 = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeFrom(Effect r10) {
                if (r10 != Effect.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasEffectType() == false) goto L9;
                setEffectType(r10.getEffectType());
            L9:
                if (Effect.access$24300(r10).isEmpty() == true) goto L15;
                if (this.effectConstructorArgument_.isEmpty() == false) goto L13;
                this.effectConstructorArgument_ = Effect.access$24300(r10);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.addAll(Effect.access$24300(r10));
            L15:
                if (r10.hasConclusionOfConditionalEffect() == false) goto L18;
                mergeConclusionOfConditionalEffect(r10.getConclusionOfConditionalEffect());
            L18:
                if (r10.hasKind() == false) goto L20;
                setKind(r10.getKind());
            L20:
                setUnknownFields(getUnknownFields().concat(Effect.access$24700(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Effect r12 = null;
                Effect r13 = Effect.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Effect r14 = (Effect) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Effect) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setEffectType(EffectType r10) {
                Objects.requireNonNull(r10);
                this.bitField0_ |= 1;
                this.effectType_ = r10;
                return this;
            }

            public Builder setKind(InvocationKind r10) {
                Objects.requireNonNull(r10);
                this.bitField0_ |= 8;
                this.kind_ = r10;
                return this;
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
                EffectType r10 = new EffectType("RETURNS_CONSTANT", 0, 0, 0);
                RETURNS_CONSTANT = r10;
                EffectType r11 = new EffectType("CALLS", 1, 1, 1);
                CALLS = r11;
                EffectType r12 = new EffectType("RETURNS_NOT_NULL", 2, 2, 2);
                RETURNS_NOT_NULL = r12;
                $VALUES = new EffectType[]{r10, r11, r12};
                internalValueMap = new AnonymousClass1();
            }

            private EffectType(String r10, int r11, int r12, int r13) {
                super(r10, r11);
                this.value = r13;
            }

            public static EffectType valueOf(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L10;
                return null;
            L10:
                return RETURNS_NOT_NULL;
            L12:
                return CALLS;
            L14:
                return RETURNS_CONSTANT;
            }

            public static EffectType valueOf(String r10) {
                return (EffectType) Enum.valueOf(EffectType.class, r10);
            }

            public static EffectType[] values() {
                return (EffectType[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
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
                InvocationKind r10 = new InvocationKind("AT_MOST_ONCE", 0, 0, 0);
                AT_MOST_ONCE = r10;
                InvocationKind r11 = new InvocationKind("EXACTLY_ONCE", 1, 1, 1);
                EXACTLY_ONCE = r11;
                InvocationKind r12 = new InvocationKind("AT_LEAST_ONCE", 2, 2, 2);
                AT_LEAST_ONCE = r12;
                $VALUES = new InvocationKind[]{r10, r11, r12};
                internalValueMap = new AnonymousClass1();
            }

            private InvocationKind(String r10, int r11, int r12, int r13) {
                super(r10, r11);
                this.value = r13;
            }

            public static InvocationKind valueOf(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L10;
                return null;
            L10:
                return AT_LEAST_ONCE;
            L12:
                return EXACTLY_ONCE;
            L14:
                return AT_MOST_ONCE;
            }

            public static InvocationKind valueOf(String r10) {
                return (InvocationKind) Enum.valueOf(InvocationKind.class, r10);
            }

            public static InvocationKind[] values() {
                return (InvocationKind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Effect r10 = new Effect(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Effect(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L59;
            int r16 = r10.readTag();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r16 == 0) goto L39;
            if (r16 != 8) goto L10;
            int r17 = r10.readEnum();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            EffectType r18 = EffectType.valueOf(r17);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r18 == null) goto L36;
            this.bitField0_ |= 1;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.effectType_ = r18;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L36:
            r13.writeRawVarint32(r16);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L21:
            r13.writeRawVarint32(r17);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L10:
            if (r16 != 18) goto L12;
            if ((r15 & 2) == 2) goto L33;
            this.effectConstructorArgument_ = new ArrayList();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            r15 = r15 | 2;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L33:
            this.effectConstructorArgument_.add((Expression) r10.readMessage(Expression.PARSER, r11));     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L12:
            if (r16 != 26) goto L14;
            Expression.Builder r19 = null;
            if ((this.bitField0_ & 2) != 2) goto L26;
            r19 = this.conclusionOfConditionalEffect_.toBuilder();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L26:
            Expression r20 = (Expression) r10.readMessage(Expression.PARSER, r11);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.conclusionOfConditionalEffect_ = r20;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r19 == null) goto L29;
            r19.mergeFrom(r20);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.conclusionOfConditionalEffect_ = r19.buildPartial();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L29:
            this.bitField0_ |= 2;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L14:
            if (r16 != 32) goto L16;
            r17 = r10.readEnum();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            InvocationKind r21 = InvocationKind.valueOf(r17);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r21 == null) goto L20;
            this.bitField0_ |= 4;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.kind_ = r21;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L20:
            r13.writeRawVarint32(r16);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L21
        L16:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L4;
        L39:
            r14 = true;
            goto L4
        L40:
            th = move-exception;
            if ((r15 & 2) != 2) goto L74;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L74:
            r13.flush();     // Catch: IOException -> L69 Throwable -> L53
        L53:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L52:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L42:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L40
        L45:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L40
        L59:
            if ((r15 & 2) != 2) goto L72;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L72:
            r13.flush();     // Catch: IOException -> L68 Throwable -> L63
        L63:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L62:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Effect(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Effect(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Effect(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Effect(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ EffectType access$24202(Effect r10, EffectType r11) {
            r10.effectType_ = r11;
            return r11;
        }

        static /* synthetic */ List access$24300(Effect r10) {
            return r10.effectConstructorArgument_;
        }

        static /* synthetic */ List access$24302(Effect r10, List r11) {
            r10.effectConstructorArgument_ = r11;
            return r11;
        }

        static /* synthetic */ Expression access$24402(Effect r10, Expression r11) {
            r10.conclusionOfConditionalEffect_ = r11;
            return r11;
        }

        static /* synthetic */ InvocationKind access$24502(Effect r10, InvocationKind r11) {
            r10.kind_ = r11;
            return r11;
        }

        static /* synthetic */ int access$24602(Effect r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$24700(Effect r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Effect r10) {
            return newBuilder().mergeFrom(r10);
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Expression getEffectConstructorArgument(int r10) {
            return this.effectConstructorArgument_.get(r10);
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0;
        L10:
            if (r11 >= this.effectConstructorArgument_.size()) goto L13;
            r12 = r12 + CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(r11));
            r11 = r11 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r12 = r12 + CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r12 = r12 + CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        L18:
            int r13 = r12 + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        L8:
            r12 = 0;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getEffectConstructorArgumentCount()) goto L17;
            if (getEffectConstructorArgument(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r10.writeEnum(1, this.effectType_.getNumber());
        L5:
            int r11 = 0;
        L7:
            if (r11 >= this.effectConstructorArgument_.size()) goto L10;
            r10.writeMessage(2, this.effectConstructorArgument_.get(r11));
            r11 = r11 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r10.writeMessage(3, this.conclusionOfConditionalEffect_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r10.writeEnum(4, this.kind_.getNumber());
        L15:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$20400() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public EnumEntry build() {
                EnumEntry r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public EnumEntry buildPartial() {
                EnumEntry r10 = new EnumEntry(this, null);
                int r11 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r11 = 0;
            L6:
                EnumEntry.access$20602(r10, this.name_);
                EnumEntry.access$20702(r10, r11);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (extensionsAreInitialized() == true) goto L6;
                return false;
            L6:
                return true;
            }

            public Builder mergeFrom(EnumEntry r10) {
                if (r10 != EnumEntry.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasName() == false) goto L8;
                setName(r10.getName());
            L8:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(EnumEntry.access$20800(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                EnumEntry r12 = null;
                EnumEntry r13 = EnumEntry.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                EnumEntry r14 = (EnumEntry) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((EnumEntry) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 1;
                this.name_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            EnumEntry r10 = new EnumEntry(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private EnumEntry(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
        L3:
            if (r14 == true) goto L40;
            int r15 = r10.readTag();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            if (r15 == 0) goto L13;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            this.name_ = r10.readInt32();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
        L13:
            r14 = true;
            goto L3
        L14:
            th = move-exception;
            r13.flush();     // Catch: IOException -> L36 Throwable -> L24
        L24:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L23:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L19:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L16:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L40:
            r13.flush();     // Catch: IOException -> L37 Throwable -> L31
        L31:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L30:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ EnumEntry(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ EnumEntry(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private EnumEntry(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$20602(EnumEntry r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ int access$20702(EnumEntry r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$20800(EnumEntry r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(EnumEntry r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            r11 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L8:
            int r12 = (r11 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r12;
            return r12;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r10.writeInt32(1, this.name_);
        L5:
            r11.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$24900() {
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
            public Expression build() {
                Expression r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Expression buildPartial() {
                Expression r10 = new Expression(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                Expression.access$25102(r10, this.flags_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                Expression.access$25202(r10, this.valueParameterReference_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                Expression.access$25302(r10, this.constantValue_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 8;
            L15:
                Expression.access$25402(r10, this.isInstanceType_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 16;
            L18:
                Expression.access$25502(r10, this.isInstanceTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                this.bitField0_ &= -33;
            L21:
                Expression.access$25602(r10, this.andArgument_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                this.bitField0_ &= -65;
            L24:
                Expression.access$25702(r10, this.orArgument_);
                Expression.access$25802(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            public Expression getAndArgument(int r10) {
                return this.andArgument_.get(r10);
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
            }

            public Expression getOrArgument(int r10) {
                return this.orArgument_.get(r10);
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
                int r10 = 0;
            L9:
                if (r10 >= getAndArgumentCount()) goto L14;
                if (getAndArgument(r10).isInitialized() == false) goto L12;
                r10 = r10 + 1;
                goto L9
            L12:
                return false;
            L14:
                int r11 = 0;
            L16:
                if (r11 >= getOrArgumentCount()) goto L21;
                if (getOrArgument(r11).isInitialized() == false) goto L19;
                r11 = r11 + 1;
                goto L16
            L19:
                return false;
            L21:
                return true;
            L5:
                if (getIsInstanceType().isInitialized() == true) goto L7;
                return false;
            }

            public Builder mergeFrom(Expression r10) {
                if (r10 != Expression.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasFlags() == false) goto L9;
                setFlags(r10.getFlags());
            L9:
                if (r10.hasValueParameterReference() == false) goto L12;
                setValueParameterReference(r10.getValueParameterReference());
            L12:
                if (r10.hasConstantValue() == false) goto L15;
                setConstantValue(r10.getConstantValue());
            L15:
                if (r10.hasIsInstanceType() == false) goto L18;
                mergeIsInstanceType(r10.getIsInstanceType());
            L18:
                if (r10.hasIsInstanceTypeId() == false) goto L21;
                setIsInstanceTypeId(r10.getIsInstanceTypeId());
            L21:
                if (Expression.access$25600(r10).isEmpty() == true) goto L27;
                if (this.andArgument_.isEmpty() == false) goto L25;
                this.andArgument_ = Expression.access$25600(r10);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureAndArgumentIsMutable();
                this.andArgument_.addAll(Expression.access$25600(r10));
            L27:
                if (Expression.access$25700(r10).isEmpty() == false) goto L29;
            L32:
                setUnknownFields(getUnknownFields().concat(Expression.access$25900(r10)));
                return this;
            L29:
                if (this.orArgument_.isEmpty() == false) goto L31;
                this.orArgument_ = Expression.access$25700(r10);
                this.bitField0_ &= -65;
                goto L32
            L31:
                ensureOrArgumentIsMutable();
                this.orArgument_.addAll(Expression.access$25700(r10));
                goto L32
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Expression r12 = null;
                Expression r13 = Expression.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Expression r14 = (Expression) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Expression) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeIsInstanceType(Type r10) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.isInstanceType_ = r10;
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.isInstanceType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.isInstanceType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder setConstantValue(ConstantValue r10) {
                Objects.requireNonNull(r10);
                this.bitField0_ |= 4;
                this.constantValue_ = r10;
                return this;
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 1;
                this.flags_ = r10;
                return this;
            }

            public Builder setIsInstanceTypeId(int r10) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = r10;
                return this;
            }

            public Builder setValueParameterReference(int r10) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = r10;
                return this;
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
                ConstantValue r10 = new ConstantValue("TRUE", 0, 0, 0);
                TRUE = r10;
                ConstantValue r11 = new ConstantValue("FALSE", 1, 1, 1);
                FALSE = r11;
                ConstantValue r12 = new ConstantValue("NULL", 2, 2, 2);
                NULL = r12;
                $VALUES = new ConstantValue[]{r10, r11, r12};
                internalValueMap = new AnonymousClass1();
            }

            private ConstantValue(String r10, int r11, int r12, int r13) {
                super(r10, r11);
                this.value = r13;
            }

            public static ConstantValue valueOf(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L10;
                return null;
            L10:
                return NULL;
            L12:
                return FALSE;
            L14:
                return TRUE;
            }

            public static ConstantValue valueOf(String r10) {
                return (ConstantValue) Enum.valueOf(ConstantValue.class, r10);
            }

            public static ConstantValue[] values() {
                return (ConstantValue[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Expression r10 = new Expression(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Expression(CodedInputStream r12, ExtensionRegistryLite r13) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r11 = CodedOutputStream.newInstance(r10, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L71;
            int r16 = r12.readTag();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r16 == 0) goto L48;
            if (r16 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.flags_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L10:
            if (r16 != 16) goto L12;
            this.bitField0_ |= 2;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.valueParameterReference_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L12:
            if (r16 != 24) goto L14;
            int r17 = r12.readEnum();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            ConstantValue r18 = ConstantValue.valueOf(r17);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r18 == null) goto L43;
            this.bitField0_ |= 4;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.constantValue_ = r18;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L43:
            r11.writeRawVarint32(r16);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r11.writeRawVarint32(r17);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L14:
            if (r16 != 34) goto L16;
            Type.Builder r19 = null;
            if ((this.bitField0_ & 8) != 8) goto L37;
            r19 = this.isInstanceType_.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L37:
            Type r20 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceType_ = r20;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r19 == null) goto L40;
            r19.mergeFrom(r20);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceType_ = r19.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L40:
            this.bitField0_ |= 8;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L16:
            if (r16 != 40) goto L18;
            this.bitField0_ |= 16;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceTypeId_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L18:
            if (r16 == 50) goto L30;
            if (r16 != 58) goto L22;
            if ((r15 & 64) == 64) goto L27;
            this.orArgument_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r15 | 64;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L27:
            List r21 = this.orArgument_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            MessageLite r22 = r12.readMessage(PARSER, r13);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L28:
            r21.add(r22);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L22:
            if (parseUnknownField(r12, r11, r13, r16) == true) goto L4;
        L30:
            if ((r15 & 32) == 32) goto L32;
            this.andArgument_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r15 | 32;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L32:
            r21 = this.andArgument_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r22 = r12.readMessage(PARSER, r13);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L48:
            r14 = true;
            goto L4
        L49:
            th = move-exception;
            if ((r15 & 32) != 32) goto L61;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L61:
            if ((r15 & 64) != 64) goto L87;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L87:
            r11.flush();     // Catch: IOException -> L84 Throwable -> L65
        L65:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L64:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L51:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L54:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L71:
            if ((r15 & 32) != 32) goto L74;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L74:
            if ((r15 & 64) != 64) goto L89;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L89:
            r11.flush();     // Catch: IOException -> L83 Throwable -> L78
        L78:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L77:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Expression(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Expression(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Expression(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Expression(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$25102(Expression r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$25202(Expression r10, int r11) {
            r10.valueParameterReference_ = r11;
            return r11;
        }

        static /* synthetic */ ConstantValue access$25302(Expression r10, ConstantValue r11) {
            r10.constantValue_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$25402(Expression r10, Type r11) {
            r10.isInstanceType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$25502(Expression r10, int r11) {
            r10.isInstanceTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$25600(Expression r10) {
            return r10.andArgument_;
        }

        static /* synthetic */ List access$25602(Expression r10, List r11) {
            r10.andArgument_ = r11;
            return r11;
        }

        static /* synthetic */ List access$25700(Expression r10) {
            return r10.orArgument_;
        }

        static /* synthetic */ List access$25702(Expression r10, List r11) {
            r10.orArgument_ = r11;
            return r11;
        }

        static /* synthetic */ int access$25802(Expression r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$25900(Expression r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Expression r10) {
            return newBuilder().mergeFrom(r10);
        }

        public Expression getAndArgument(int r10) {
            return this.andArgument_.get(r10);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Expression getDefaultInstanceForType() {
            return defaultInstance;
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

        public Expression getOrArgument(int r10) {
            return this.orArgument_.get(r10);
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r12 = r12 + CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r12 = r12 + CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r12 = r12 + CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r12 = r12 + CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        L21:
            int r13 = 0;
        L23:
            if (r13 >= this.andArgument_.size()) goto L26;
            r12 = r12 + CodedOutputStream.computeMessageSize(6, this.andArgument_.get(r13));
            r13 = r13 + 1;
        L26:
            if (r11 >= this.orArgument_.size()) goto L28;
            r12 = r12 + CodedOutputStream.computeMessageSize(7, this.orArgument_.get(r11));
            r11 = r11 + 1;
            goto L26
        L28:
            int r14 = r12 + this.unknownFields.size();
            this.memoizedSerializedSize = r14;
            return r14;
        L8:
            r12 = 0;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
            return false;
        L9:
            if (hasIsInstanceType() == true) goto L11;
        L14:
            int r11 = 0;
        L16:
            if (r11 >= getAndArgumentCount()) goto L22;
            if (getAndArgument(r11).isInitialized() == false) goto L19;
            r11 = r11 + 1;
            goto L16
        L19:
            this.memoizedIsInitialized = 0;
            return false;
        L22:
            int r12 = 0;
        L24:
            if (r12 >= getOrArgumentCount()) goto L30;
            if (getOrArgument(r12).isInitialized() == false) goto L27;
            r12 = r12 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r10.writeInt32(2, this.valueParameterReference_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r10.writeEnum(3, this.constantValue_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r10.writeMessage(4, this.isInstanceType_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r10.writeInt32(5, this.isInstanceTypeId_);
        L17:
            int r11 = 0;
            int r12 = 0;
        L19:
            if (r12 >= this.andArgument_.size()) goto L22;
            r10.writeMessage(6, this.andArgument_.get(r12));
            r12 = r12 + 1;
        L22:
            if (r11 >= this.orArgument_.size()) goto L24;
            r10.writeMessage(7, this.orArgument_.get(r11));
            r11 = r11 + 1;
            goto L22
        L24:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$14100() {
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
            public Function build() {
                Function r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Function buildPartial() {
                Function r10 = new Function(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                Function.access$14302(r10, this.flags_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                Function.access$14402(r10, this.oldFlags_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                Function.access$14502(r10, this.name_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 8;
            L15:
                Function.access$14602(r10, this.returnType_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 16;
            L18:
                Function.access$14702(r10, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Function.access$14802(r10, this.typeParameter_);
                if ((r11 & 64) != 64) goto L24;
                r12 = r12 | 32;
            L24:
                Function.access$14902(r10, this.receiverType_);
                if ((r11 & 128) != 128) goto L27;
                r12 = r12 | 64;
            L27:
                Function.access$15002(r10, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Function.access$15102(r10, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Function.access$15202(r10, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -1025;
            L36:
                Function.access$15302(r10, this.valueParameter_);
                if ((r11 & 2048) != 2048) goto L39;
                r12 = r12 | 128;
            L39:
                Function.access$15402(r10, this.typeTable_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4097;
            L42:
                Function.access$15502(r10, this.versionRequirement_);
                if ((r11 & 8192) != 8192) goto L45;
                r12 = r12 | 256;
            L45:
                Function.access$15602(r10, this.contract_);
                Function.access$15702(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Type getContextReceiverType(int r10) {
                return this.contextReceiverType_.get(r10);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public Contract getContract() {
                return this.contract_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public TypeParameter getTypeParameter(int r10) {
                return this.typeParameter_.get(r10);
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            public ValueParameter getValueParameter(int r10) {
                return this.valueParameter_.get(r10);
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
                int r10 = 0;
            L12:
                if (r10 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r10).isInitialized() == false) goto L15;
                r10 = r10 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r11 = 0;
            L24:
                if (r11 >= getContextReceiverTypeCount()) goto L29;
                if (getContextReceiverType(r11).isInitialized() == false) goto L27;
                r11 = r11 + 1;
                goto L24
            L27:
                return false;
            L29:
                int r12 = 0;
            L31:
                if (r12 >= getValueParameterCount()) goto L37;
                if (getValueParameter(r12).isInitialized() == false) goto L34;
                r12 = r12 + 1;
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

            public Builder mergeContract(Contract r10) {
                if ((this.bitField0_ & 8192) == 8192) goto L5;
            L7:
                this.contract_ = r10;
                this.bitField0_ |= 8192;
                return this;
            L5:
                if (this.contract_ == Contract.getDefaultInstance()) goto L7;
                r10 = Contract.newBuilder(this.contract_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeFrom(Function r10) {
                if (r10 != Function.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasFlags() == false) goto L9;
                setFlags(r10.getFlags());
            L9:
                if (r10.hasOldFlags() == false) goto L12;
                setOldFlags(r10.getOldFlags());
            L12:
                if (r10.hasName() == false) goto L15;
                setName(r10.getName());
            L15:
                if (r10.hasReturnType() == false) goto L18;
                mergeReturnType(r10.getReturnType());
            L18:
                if (r10.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r10.getReturnTypeId());
            L21:
                if (Function.access$14800(r10).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Function.access$14800(r10);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Function.access$14800(r10));
            L27:
                if (r10.hasReceiverType() == false) goto L30;
                mergeReceiverType(r10.getReceiverType());
            L30:
                if (r10.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r10.getReceiverTypeId());
            L33:
                if (Function.access$15100(r10).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Function.access$15100(r10);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Function.access$15100(r10));
            L39:
                if (Function.access$15200(r10).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Function.access$15200(r10);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Function.access$15200(r10));
            L45:
                if (Function.access$15300(r10).isEmpty() == true) goto L51;
                if (this.valueParameter_.isEmpty() == false) goto L49;
                this.valueParameter_ = Function.access$15300(r10);
                this.bitField0_ &= -1025;
                goto L51
            L49:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Function.access$15300(r10));
            L51:
                if (r10.hasTypeTable() == false) goto L54;
                mergeTypeTable(r10.getTypeTable());
            L54:
                if (Function.access$15500(r10).isEmpty() == true) goto L60;
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Function.access$15500(r10);
                this.bitField0_ &= -4097;
                goto L60
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Function.access$15500(r10));
            L60:
                if (r10.hasContract() == false) goto L62;
                mergeContract(r10.getContract());
            L62:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(Function.access$15800(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Function r12 = null;
                Function r13 = Function.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Function r14 = (Function) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Function) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeReceiverType(Type r10) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r10;
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.receiverType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeReturnType(Type r10) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r10;
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.returnType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeTypeTable(TypeTable r10) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.typeTable_ = r10;
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                r10 = TypeTable.newBuilder(this.typeTable_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 1;
                this.flags_ = r10;
                return this;
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 4;
                this.name_ = r10;
                return this;
            }

            public Builder setOldFlags(int r10) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r10;
                return this;
            }

            public Builder setReceiverTypeId(int r10) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r10;
                return this;
            }

            public Builder setReturnTypeId(int r10) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Function r10 = new Function(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Function(CodedInputStream r14, ExtensionRegistryLite r15) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r11 = CodedOutputStream.newInstance(r10, 1);
            boolean r12 = false;
            int r13 = 0;
        L4:
            if (r12 == true) goto L115;
            int r16 = r14.readTag();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            Type.Builder r17 = null;
            Contract.Builder r18 = null;
            TypeTable.Builder r19 = null;
            Type.Builder r110 = null;
            switch(r16) {
                case 0: goto L81;
                case 8: goto L79;
                case 16: goto L78;
                case 26: goto L71;
                case 34: goto L67;
                case 42: goto L61;
                case 50: goto L56;
                case 56: goto L55;
                case 64: goto L54;
                case 72: goto L53;
                case 82: goto L49;
                case 88: goto L45;
                case 90: goto L37;
                case 242: goto L29;
                case 248: goto L24;
                case 250: goto L15;
                case 258: goto L9;
                default: goto L82;
            };     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L9:
            if ((this.bitField0_ & 256) != 256) goto L11;
            r18 = this.contract_.toBuilder();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L11:
            Contract r111 = (Contract) r14.readMessage(Contract.PARSER, r15);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.contract_ = r111;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            if (r18 == null) goto L14;
            r18.mergeFrom(r111);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.contract_ = r18.buildPartial();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L14:
            this.bitField0_ |= 256;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L15:
            int r112 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            int r113 = (r13 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = r13;
            if (r113 == 4096) goto L21;
            r13 = r13;
            if (r14.getBytesUntilLimit() <= 0) goto L21;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = (r13 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L21:
            if (r14.getBytesUntilLimit() <= 0) goto L23;
            this.versionRequirement_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L23:
            r14.popLimit(r112);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L24:
            int r114 = (r13 == true ? 1 : 0) & 4096;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            int r20 = r13;
            if (r114 == 4096) goto L27;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r20 = (r13 == true ? 1 : 0) | 4096;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L27:
            List r115 = this.versionRequirement_;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = r20;
            Object r116 = Integer.valueOf(r14.readInt32());     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L28:
            r115.add(r116);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L29:
            int r117 = 128;
            if ((this.bitField0_ & 128) != 128) goto L32;
            r19 = this.typeTable_.toBuilder();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L32:
            TypeTable r118 = (TypeTable) r14.readMessage(TypeTable.PARSER, r15);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.typeTable_ = r118;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            if (r19 == null) goto L35;
            r19.mergeFrom(r118);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.typeTable_ = r19.buildPartial();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L35:
            int r119 = this.bitField0_;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L36:
            this.bitField0_ = r119 | r117;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L37:
            r112 = r14.pushLimit(r14.readRawVarint32());     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            int r120 = (r13 == true ? 1 : 0) & 512;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = r13;
            if (r120 == 512) goto L43;
            r13 = r13;
            if (r14.getBytesUntilLimit() <= 0) goto L43;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = (r13 == true ? 1 : 0) | 512;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L43:
            if (r14.getBytesUntilLimit() <= 0) goto L23;
            this.contextReceiverTypeId_.add(Integer.valueOf(r14.readInt32()));     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L43
        L45:
            int r121 = (r13 == true ? 1 : 0) & 512;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            int r21 = r13;
            if (r121 == 512) goto L48;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r21 = (r13 == true ? 1 : 0) | 512;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L48:
            r115 = this.contextReceiverTypeId_;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = r21;
            r116 = Integer.valueOf(r14.readInt32());     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L28
        L49:
            int r122 = (r13 == true ? 1 : 0) & 256;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            int r22 = r13;
            if (r122 == 256) goto L52;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r22 = (r13 == true ? 1 : 0) | 256;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L52:
            r115 = this.contextReceiverType_;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = r22;
            r116 = r14.readMessage(Type.PARSER, r15);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L28
        L53:
            this.bitField0_ |= 1;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.flags_ = r14.readInt32();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L54:
            this.bitField0_ |= 64;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.receiverTypeId_ = r14.readInt32();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L55:
            this.bitField0_ |= 16;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.returnTypeId_ = r14.readInt32();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L56:
            int r123 = (r13 == true ? 1 : 0) & 1024;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            int r23 = r13;
            if (r123 == 1024) goto L59;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r23 = (r13 == true ? 1 : 0) | 1024;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L59:
            r115 = this.valueParameter_;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = r23;
            r116 = r14.readMessage(ValueParameter.PARSER, r15);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L28
        L61:
            if ((this.bitField0_ & 32) != 32) goto L63;
            r110 = this.receiverType_.toBuilder();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L63:
            Type r124 = (Type) r14.readMessage(Type.PARSER, r15);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.receiverType_ = r124;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            if (r110 == null) goto L66;
            r110.mergeFrom(r124);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.receiverType_ = r110.buildPartial();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L66:
            this.bitField0_ |= 32;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L67:
            int r125 = (r13 == true ? 1 : 0) & 32;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            int r24 = r13;
            if (r125 == 32) goto L70;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r24 = (r13 == true ? 1 : 0) | 32;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L70:
            r115 = this.typeParameter_;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            r13 = r24;
            r116 = r14.readMessage(TypeParameter.PARSER, r15);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L28
        L71:
            r117 = 8;
            if ((this.bitField0_ & 8) != 8) goto L74;
            r17 = this.returnType_.toBuilder();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L74:
            Type r126 = (Type) r14.readMessage(Type.PARSER, r15);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.returnType_ = r126;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            if (r17 == null) goto L77;
            r17.mergeFrom(r126);     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.returnType_ = r17.buildPartial();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L77:
            r119 = this.bitField0_;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L36
        L78:
            this.bitField0_ |= 4;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.name_ = r14.readInt32();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            goto L4
        L79:
            this.bitField0_ |= 2;     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
            this.oldFlags_ = r14.readInt32();     // Catch: Throwable -> L84 IOException -> L86 InvalidProtocolBufferException -> L89
        L81:
            r12 = true;
            goto L4
        L82:
            if (parseUnknownField(r14, r11, r15, r16) == true) goto L4;
        L84:
            th = move-exception;
            if (((r13 == true ? 1 : 0) & 32) != 32) goto L96;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L96:
            if (((r13 == true ? 1 : 0) & 1024) != 1024) goto L99;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L99:
            if (((r13 == true ? 1 : 0) & 256) != 256) goto L102;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L102:
            if (((r13 == true ? 1 : 0) & 512) != 512) goto L105;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L105:
            if (((r13 == true ? 1 : 0) & 4096) != 4096) goto L139;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L139:
            r11.flush();     // Catch: IOException -> L137 Throwable -> L109
        L109:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L108:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L89:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L84
        L86:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L84
        L115:
            if (((r13 == true ? 1 : 0) & 32) != 32) goto L118;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L118:
            if (((r13 == true ? 1 : 0) & 1024) != 1024) goto L121;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L121:
            if (((r13 == true ? 1 : 0) & 256) != 256) goto L124;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L124:
            if (((r13 == true ? 1 : 0) & 512) != 512) goto L127;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L127:
            if (((r13 == true ? 1 : 0) & 4096) != 4096) goto L142;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L142:
            r11.flush();     // Catch: IOException -> L136 Throwable -> L131
        L131:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L130:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Function(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> r10) {
            super(r10);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Function(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Function(boolean r10) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$14302(Function r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$14402(Function r10, int r11) {
            r10.oldFlags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$14502(Function r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$14602(Function r10, Type r11) {
            r10.returnType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$14702(Function r10, int r11) {
            r10.returnTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$14800(Function r10) {
            return r10.typeParameter_;
        }

        static /* synthetic */ List access$14802(Function r10, List r11) {
            r10.typeParameter_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$14902(Function r10, Type r11) {
            r10.receiverType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$15002(Function r10, int r11) {
            r10.receiverTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$15100(Function r10) {
            return r10.contextReceiverType_;
        }

        static /* synthetic */ List access$15102(Function r10, List r11) {
            r10.contextReceiverType_ = r11;
            return r11;
        }

        static /* synthetic */ List access$15200(Function r10) {
            return r10.contextReceiverTypeId_;
        }

        static /* synthetic */ List access$15202(Function r10, List r11) {
            r10.contextReceiverTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$15300(Function r10) {
            return r10.valueParameter_;
        }

        static /* synthetic */ List access$15302(Function r10, List r11) {
            r10.valueParameter_ = r11;
            return r11;
        }

        static /* synthetic */ TypeTable access$15402(Function r10, TypeTable r11) {
            r10.typeTable_ = r11;
            return r11;
        }

        static /* synthetic */ List access$15500(Function r10) {
            return r10.versionRequirement_;
        }

        static /* synthetic */ List access$15502(Function r10, List r11) {
            r10.versionRequirement_ = r11;
            return r11;
        }

        static /* synthetic */ Contract access$15602(Function r10, Contract r11) {
            r10.contract_ = r11;
            return r11;
        }

        static /* synthetic */ int access$15702(Function r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$15800(Function r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Function r10) {
            return newBuilder().mergeFrom(r10);
        }

        public static Function parseFrom(InputStream r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public Type getContextReceiverType(int r10) {
            return this.contextReceiverType_.get(r10);
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
        public Function getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r12 = r12 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r12 = r12 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r13 = 0;
        L17:
            if (r13 >= this.typeParameter_.size()) goto L20;
            r12 = r12 + CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(r13));
            r13 = r13 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L22;
            r12 = r12 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L22:
            int r14 = 0;
        L24:
            if (r14 >= this.valueParameter_.size()) goto L27;
            r12 = r12 + CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(r14));
            r14 = r14 + 1;
            goto L24
        L27:
            if ((this.bitField0_ & 16) != 16) goto L30;
            r12 = r12 + CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        L30:
            if ((this.bitField0_ & 64) != 64) goto L33;
            r12 = r12 + CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        L33:
            if ((this.bitField0_ & 1) != 1) goto L35;
            r12 = r12 + CodedOutputStream.computeInt32Size(9, this.flags_);
        L35:
            int r15 = 0;
        L37:
            if (r15 >= this.contextReceiverType_.size()) goto L39;
            r12 = r12 + CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(r15));
            r15 = r15 + 1;
            goto L37
        L39:
            int r16 = 0;
            int r17 = 0;
        L41:
            if (r16 >= this.contextReceiverTypeId_.size()) goto L43;
            r17 = r17 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r16).intValue());
            r16 = r16 + 1;
            goto L41
        L43:
            int r18 = r12 + r17;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L46;
            r18 = (r18 + 1) + CodedOutputStream.computeInt32SizeNoTag(r17);
        L46:
            this.contextReceiverTypeIdMemoizedSerializedSize = r17;
            if ((this.bitField0_ & 128) != 128) goto L49;
            r18 = r18 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L49:
            int r19 = 0;
        L51:
            if (r11 >= this.versionRequirement_.size()) goto L53;
            r19 = r19 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L51
        L53:
            int r20 = (r18 + r19) + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) != 256) goto L56;
            r20 = r20 + CodedOutputStream.computeMessageSize(32, this.contract_);
        L56:
            int r21 = (r20 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r21;
            return r21;
        L8:
            r12 = 0;
            goto L10
        }

        public TypeParameter getTypeParameter(int r10) {
            return this.typeParameter_.get(r10);
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

        public ValueParameter getValueParameter(int r10) {
            return this.valueParameter_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r11 = 0;
        L20:
            if (r11 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r11).isInitialized() == false) goto L23;
            r11 = r11 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r12 = 0;
        L34:
            if (r12 >= getContextReceiverTypeCount()) goto L40;
            if (getContextReceiverType(r12).isInitialized() == false) goto L37;
            r12 = r12 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L40:
            int r13 = 0;
        L42:
            if (r13 >= getValueParameterCount()) goto L49;
            if (getValueParameter(r13).isInitialized() == false) goto L45;
            r13 = r13 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r10.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r10.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r10.writeMessage(3, this.returnType_);
        L11:
            int r12 = 0;
            int r13 = 0;
        L13:
            if (r13 >= this.typeParameter_.size()) goto L16;
            r10.writeMessage(4, this.typeParameter_.get(r13));
            r13 = r13 + 1;
            goto L13
        L16:
            if ((this.bitField0_ & 32) != 32) goto L18;
            r10.writeMessage(5, this.receiverType_);
        L18:
            int r14 = 0;
        L20:
            if (r14 >= this.valueParameter_.size()) goto L23;
            r10.writeMessage(6, this.valueParameter_.get(r14));
            r14 = r14 + 1;
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
            int r15 = 0;
        L33:
            if (r15 >= this.contextReceiverType_.size()) goto L36;
            r10.writeMessage(10, this.contextReceiverType_.get(r15));
            r15 = r15 + 1;
            goto L33
        L36:
            if (getContextReceiverTypeIdList().size() <= 0) goto L38;
            r10.writeRawVarint32(90);
            r10.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L38:
            int r16 = 0;
        L40:
            if (r16 >= this.contextReceiverTypeId_.size()) goto L43;
            r10.writeInt32NoTag(this.contextReceiverTypeId_.get(r16).intValue());
            r16 = r16 + 1;
            goto L40
        L43:
            if ((this.bitField0_ & 128) != 128) goto L46;
            r10.writeMessage(30, this.typeTable_);
        L46:
            if (r12 >= this.versionRequirement_.size()) goto L49;
            r10.writeInt32(31, this.versionRequirement_.get(r12).intValue());
            r12 = r12 + 1;
            goto L46
        L49:
            if ((this.bitField0_ & 256) != 256) goto L51;
            r10.writeMessage(32, this.contract_);
        L51:
            r11.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
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
            MemberKind r10 = new MemberKind("DECLARATION", 0, 0, 0);
            DECLARATION = r10;
            MemberKind r11 = new MemberKind("FAKE_OVERRIDE", 1, 1, 1);
            FAKE_OVERRIDE = r11;
            MemberKind r12 = new MemberKind("DELEGATION", 2, 2, 2);
            DELEGATION = r12;
            MemberKind r13 = new MemberKind("SYNTHESIZED", 3, 3, 3);
            SYNTHESIZED = r13;
            $VALUES = new MemberKind[]{r10, r11, r12, r13};
            internalValueMap = new AnonymousClass1();
        }

        private MemberKind(String r10, int r11, int r12, int r13) {
            super(r10, r11);
            this.value = r13;
        }

        public static MemberKind valueOf(int r10) {
            if (r10 == 0) goto L18;
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L12;
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

        public static MemberKind valueOf(String r10) {
            return (MemberKind) Enum.valueOf(MemberKind.class, r10);
        }

        public static MemberKind[] values() {
            return (MemberKind[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
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
            Modality r10 = new Modality("FINAL", 0, 0, 0);
            FINAL = r10;
            Modality r11 = new Modality("OPEN", 1, 1, 1);
            OPEN = r11;
            Modality r12 = new Modality("ABSTRACT", 2, 2, 2);
            ABSTRACT = r12;
            Modality r13 = new Modality("SEALED", 3, 3, 3);
            SEALED = r13;
            $VALUES = new Modality[]{r10, r11, r12, r13};
            internalValueMap = new AnonymousClass1();
        }

        private Modality(String r10, int r11, int r12, int r13) {
            super(r10, r11);
            this.value = r13;
        }

        public static Modality valueOf(int r10) {
            if (r10 == 0) goto L18;
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L12;
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

        public static Modality valueOf(String r10) {
            return (Modality) Enum.valueOf(Modality.class, r10);
        }

        public static Modality[] values() {
            return (Modality[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
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

            static /* synthetic */ Builder access$11600() {
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
            public Package build() {
                Package r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Package buildPartial() {
                Package r10 = new Package(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) != 1) goto L5;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -2;
            L5:
                Package.access$11802(r10, this.function_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -3;
            L8:
                Package.access$11902(r10, this.property_);
                if ((this.bitField0_ & 4) != 4) goto L11;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -5;
            L11:
                Package.access$12002(r10, this.typeAlias_);
                if ((r11 & 8) == 8) goto L15;
                r12 = 0;
            L15:
                Package.access$12102(r10, this.typeTable_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 2;
            L18:
                Package.access$12202(r10, this.versionRequirementTable_);
                Package.access$12302(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Function getFunction(int r10) {
                return this.function_.get(r10);
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public Property getProperty(int r10) {
                return this.property_.get(r10);
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public TypeAlias getTypeAlias(int r10) {
                return this.typeAlias_.get(r10);
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
                int r10 = 0;
            L4:
                if (r10 >= getFunctionCount()) goto L9;
                if (getFunction(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r11 = 0;
            L11:
                if (r11 >= getPropertyCount()) goto L16;
                if (getProperty(r11).isInitialized() == false) goto L14;
                r11 = r11 + 1;
                goto L11
            L14:
                return false;
            L16:
                int r12 = 0;
            L18:
                if (r12 >= getTypeAliasCount()) goto L24;
                if (getTypeAlias(r12).isInitialized() == false) goto L21;
                r12 = r12 + 1;
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

            public Builder mergeFrom(Package r10) {
                if (r10 != Package.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Package.access$11800(r10).isEmpty() == true) goto L12;
                if (this.function_.isEmpty() == false) goto L10;
                this.function_ = Package.access$11800(r10);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureFunctionIsMutable();
                this.function_.addAll(Package.access$11800(r10));
            L12:
                if (Package.access$11900(r10).isEmpty() == true) goto L18;
                if (this.property_.isEmpty() == false) goto L16;
                this.property_ = Package.access$11900(r10);
                this.bitField0_ &= -3;
                goto L18
            L16:
                ensurePropertyIsMutable();
                this.property_.addAll(Package.access$11900(r10));
            L18:
                if (Package.access$12000(r10).isEmpty() == true) goto L24;
                if (this.typeAlias_.isEmpty() == false) goto L22;
                this.typeAlias_ = Package.access$12000(r10);
                this.bitField0_ &= -5;
                goto L24
            L22:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Package.access$12000(r10));
            L24:
                if (r10.hasTypeTable() == false) goto L27;
                mergeTypeTable(r10.getTypeTable());
            L27:
                if (r10.hasVersionRequirementTable() == false) goto L29;
                mergeVersionRequirementTable(r10.getVersionRequirementTable());
            L29:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(Package.access$12400(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Package r12 = null;
                Package r13 = Package.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Package r14 = (Package) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Package) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeTypeTable(TypeTable r10) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.typeTable_ = r10;
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                r10 = TypeTable.newBuilder(this.typeTable_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r10) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.versionRequirementTable_ = r10;
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                r10 = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r10).buildPartial();
                goto L7
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Package r10 = new Package(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Package(CodedInputStream r11, ExtensionRegistryLite r12) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r10, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L74;
            int r16 = r11.readTag();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r16 == 0) goto L48;
            if (r16 == 26) goto L43;
            if (r16 == 34) goto L39;
            if (r16 != 42) goto L13;
            int r17 = (r15 == true ? 1 : 0) & 4;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            int r18 = r15;
            if (r17 == 4) goto L37;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r18 = (r15 == true ? 1 : 0) | 4;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L37:
            List r19 = this.typeAlias_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            MessageLite r20 = r11.readMessage(TypeAlias.PARSER, r12);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r18;
        L38:
            r19.add(r20);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L13:
            VersionRequirementTable.Builder r21 = null;
            TypeTable.Builder r22 = null;
            if (r16 != 242) goto L16;
            if ((this.bitField0_ & 1) != 1) goto L30;
            r22 = this.typeTable_.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L30:
            TypeTable r23 = (TypeTable) r11.readMessage(TypeTable.PARSER, r12);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.typeTable_ = r23;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r22 == null) goto L33;
            r22.mergeFrom(r23);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.typeTable_ = r22.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L33:
            this.bitField0_ |= 1;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L16:
            if (r16 != 258) goto L18;
            if ((this.bitField0_ & 2) != 2) goto L23;
            r21 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L23:
            VersionRequirementTable r24 = (VersionRequirementTable) r11.readMessage(VersionRequirementTable.PARSER, r12);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.versionRequirementTable_ = r24;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r21 == null) goto L26;
            r21.mergeFrom(r24);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.versionRequirementTable_ = r21.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L26:
            this.bitField0_ |= 2;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L18:
            if (parseUnknownField(r11, r13, r12, r16) == true) goto L4;
        L39:
            int r25 = (r15 == true ? 1 : 0) & 2;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            int r26 = r15;
            if (r25 == 2) goto L42;
            this.property_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r26 = (r15 == true ? 1 : 0) | 2;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L42:
            r19 = this.property_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r20 = r11.readMessage(Property.PARSER, r12);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r26;
            goto L38
        L43:
            int r27 = (r15 == true ? 1 : 0) & 1;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            int r28 = r15;
            if (r27 == 1) goto L46;
            this.function_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r28 = (r15 == true ? 1 : 0) | 1;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L46:
            r19 = this.function_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r20 = r11.readMessage(Function.PARSER, r12);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r28;
        L48:
            r14 = true;
            goto L4
        L49:
            th = move-exception;
            if (((r15 == true ? 1 : 0) & 1) != 1) goto L61;
            this.function_ = Collections.unmodifiableList(this.function_);
        L61:
            if (((r15 == true ? 1 : 0) & 2) != 2) goto L64;
            this.property_ = Collections.unmodifiableList(this.property_);
        L64:
            if (((r15 == true ? 1 : 0) & 4) != 4) goto L95;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L95:
            r13.flush();     // Catch: IOException -> L90 Throwable -> L68
        L68:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L67:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L54:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L51:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L74:
            if (((r15 == true ? 1 : 0) & 1) != 1) goto L77;
            this.function_ = Collections.unmodifiableList(this.function_);
        L77:
            if (((r15 == true ? 1 : 0) & 2) != 2) goto L80;
            this.property_ = Collections.unmodifiableList(this.property_);
        L80:
            if (((r15 == true ? 1 : 0) & 4) != 4) goto L93;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L93:
            r13.flush();     // Catch: IOException -> L89 Throwable -> L84
        L84:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L83:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Package(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Package(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Package(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ List access$11800(Package r10) {
            return r10.function_;
        }

        static /* synthetic */ List access$11802(Package r10, List r11) {
            r10.function_ = r11;
            return r11;
        }

        static /* synthetic */ List access$11900(Package r10) {
            return r10.property_;
        }

        static /* synthetic */ List access$11902(Package r10, List r11) {
            r10.property_ = r11;
            return r11;
        }

        static /* synthetic */ List access$12000(Package r10) {
            return r10.typeAlias_;
        }

        static /* synthetic */ List access$12002(Package r10, List r11) {
            r10.typeAlias_ = r11;
            return r11;
        }

        static /* synthetic */ TypeTable access$12102(Package r10, TypeTable r11) {
            r10.typeTable_ = r11;
            return r11;
        }

        static /* synthetic */ VersionRequirementTable access$12202(Package r10, VersionRequirementTable r11) {
            r10.versionRequirementTable_ = r11;
            return r11;
        }

        static /* synthetic */ int access$12302(Package r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$12400(Package r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Package r10) {
            return newBuilder().mergeFrom(r10);
        }

        public static Package parseFrom(InputStream r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public Function getFunction(int r10) {
            return this.function_.get(r10);
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

        public Property getProperty(int r10) {
            return this.property_.get(r10);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
        L7:
            if (r12 >= this.function_.size()) goto L9;
            r13 = r13 + CodedOutputStream.computeMessageSize(3, this.function_.get(r12));
            r12 = r12 + 1;
            goto L7
        L9:
            int r14 = 0;
        L11:
            if (r14 >= this.property_.size()) goto L14;
            r13 = r13 + CodedOutputStream.computeMessageSize(4, this.property_.get(r14));
            r14 = r14 + 1;
        L14:
            if (r11 >= this.typeAlias_.size()) goto L17;
            r13 = r13 + CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(r11));
            r11 = r11 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 1) != 1) goto L20;
            r13 = r13 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L20:
            if ((this.bitField0_ & 2) != 2) goto L22;
            r13 = r13 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L22:
            int r15 = (r13 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r15;
            return r15;
        }

        public TypeAlias getTypeAlias(int r10) {
            return this.typeAlias_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getFunctionCount()) goto L16;
            if (getFunction(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r12 = 0;
        L18:
            if (r12 >= getPropertyCount()) goto L24;
            if (getProperty(r12).isInitialized() == false) goto L21;
            r12 = r12 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L24:
            int r13 = 0;
        L26:
            if (r13 >= getTypeAliasCount()) goto L33;
            if (getTypeAlias(r13).isInitialized() == false) goto L29;
            r13 = r13 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            int r12 = 0;
            int r13 = 0;
        L4:
            if (r13 >= this.function_.size()) goto L6;
            r10.writeMessage(3, this.function_.get(r13));
            r13 = r13 + 1;
            goto L4
        L6:
            int r14 = 0;
        L8:
            if (r14 >= this.property_.size()) goto L11;
            r10.writeMessage(4, this.property_.get(r14));
            r14 = r14 + 1;
        L11:
            if (r12 >= this.typeAlias_.size()) goto L14;
            r10.writeMessage(5, this.typeAlias_.get(r12));
            r12 = r12 + 1;
            goto L11
        L14:
            if ((this.bitField0_ & 1) != 1) goto L17;
            r10.writeMessage(30, this.typeTable_);
        L17:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r10.writeMessage(32, this.versionRequirementTable_);
        L19:
            r11.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$22600() {
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
            public PackageFragment build() {
                PackageFragment r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public PackageFragment buildPartial() {
                PackageFragment r10 = new PackageFragment(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                PackageFragment.access$22802(r10, this.strings_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                PackageFragment.access$22902(r10, this.qualifiedNames_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                PackageFragment.access$23002(r10, this.package_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.class__ = Collections.unmodifiableList(this.class__);
                this.bitField0_ &= -9;
            L15:
                PackageFragment.access$23102(r10, this.class__);
                PackageFragment.access$23202(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Class getClass_(int r10) {
                return this.class__.get(r10);
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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
                int r10 = 0;
            L14:
                if (r10 >= getClass_Count()) goto L20;
                if (getClass_(r10).isInitialized() == false) goto L17;
                r10 = r10 + 1;
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

            public Builder mergeFrom(PackageFragment r10) {
                if (r10 != PackageFragment.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasStrings() == false) goto L9;
                mergeStrings(r10.getStrings());
            L9:
                if (r10.hasQualifiedNames() == false) goto L12;
                mergeQualifiedNames(r10.getQualifiedNames());
            L12:
                if (r10.hasPackage() == false) goto L15;
                mergePackage(r10.getPackage());
            L15:
                if (PackageFragment.access$23100(r10).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(PackageFragment.access$23300(r10)));
                return this;
            L17:
                if (this.class__.isEmpty() == false) goto L19;
                this.class__ = PackageFragment.access$23100(r10);
                this.bitField0_ &= -9;
                goto L20
            L19:
                ensureClass_IsMutable();
                this.class__.addAll(PackageFragment.access$23100(r10));
                goto L20
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                PackageFragment r12 = null;
                PackageFragment r13 = PackageFragment.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                PackageFragment r14 = (PackageFragment) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((PackageFragment) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergePackage(Package r10) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.package_ = r10;
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.package_ == Package.getDefaultInstance()) goto L7;
                r10 = Package.newBuilder(this.package_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeQualifiedNames(QualifiedNameTable r10) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.qualifiedNames_ = r10;
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.qualifiedNames_ == QualifiedNameTable.getDefaultInstance()) goto L7;
                r10 = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeStrings(StringTable r10) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.strings_ = r10;
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.strings_ == StringTable.getDefaultInstance()) goto L7;
                r10 = StringTable.newBuilder(this.strings_).mergeFrom(r10).buildPartial();
                goto L7
            }
        }

        static {
            PARSER = new AnonymousClass1();
            PackageFragment r10 = new PackageFragment(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private PackageFragment(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L65;
            int r16 = r10.readTag();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r16 == 0) goto L45;
            QualifiedNameTable.Builder r17 = null;
            StringTable.Builder r18 = null;
            Package.Builder r19 = null;
            if (r16 != 10) goto L10;
            if ((this.bitField0_ & 1) != 1) goto L40;
            r18 = this.strings_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L40:
            StringTable r20 = (StringTable) r10.readMessage(StringTable.PARSER, r11);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.strings_ = r20;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r18 == null) goto L43;
            r18.mergeFrom(r20);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.strings_ = r18.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L43:
            this.bitField0_ |= 1;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L4
        L10:
            if (r16 == 18) goto L30;
            if (r16 != 26) goto L14;
            int r21 = 4;
            if ((this.bitField0_ & 4) != 4) goto L25;
            r19 = this.package_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L25:
            Package r22 = (Package) r10.readMessage(Package.PARSER, r11);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.package_ = r22;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r19 == null) goto L28;
            r19.mergeFrom(r22);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.package_ = r19.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L28:
            int r23 = this.bitField0_;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L29:
            this.bitField0_ = r23 | r21;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L4
        L14:
            if (r16 != 34) goto L16;
            int r24 = (r15 == true ? 1 : 0) & 8;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            r15 = r15;
            if (r24 == 8) goto L21;
            this.class__ = new ArrayList();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            r15 = (r15 == true ? 1 : 0) | 8;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L21:
            this.class__.add((Class) r10.readMessage(Class.PARSER, r11));     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L4
        L16:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L4;
        L30:
            r21 = 2;
            if ((this.bitField0_ & 2) != 2) goto L33;
            r17 = this.qualifiedNames_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L33:
            QualifiedNameTable r25 = (QualifiedNameTable) r10.readMessage(QualifiedNameTable.PARSER, r11);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.qualifiedNames_ = r25;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r17 == null) goto L36;
            r17.mergeFrom(r25);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.qualifiedNames_ = r17.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L36:
            r23 = this.bitField0_;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L45:
            r14 = true;
            goto L4
        L46:
            th = move-exception;
            if (((r15 == true ? 1 : 0) & 8) != 8) goto L78;
            this.class__ = Collections.unmodifiableList(this.class__);
        L78:
            r13.flush();     // Catch: IOException -> L75 Throwable -> L59
        L59:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L58:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L51:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L46
        L48:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L46
        L65:
            if (((r15 == true ? 1 : 0) & 8) != 8) goto L80;
            this.class__ = Collections.unmodifiableList(this.class__);
        L80:
            r13.flush();     // Catch: IOException -> L74 Throwable -> L69
        L69:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L68:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ PackageFragment(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ PackageFragment(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private PackageFragment(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ StringTable access$22802(PackageFragment r10, StringTable r11) {
            r10.strings_ = r11;
            return r11;
        }

        static /* synthetic */ QualifiedNameTable access$22902(PackageFragment r10, QualifiedNameTable r11) {
            r10.qualifiedNames_ = r11;
            return r11;
        }

        static /* synthetic */ Package access$23002(PackageFragment r10, Package r11) {
            r10.package_ = r11;
            return r11;
        }

        static /* synthetic */ List access$23100(PackageFragment r10) {
            return r10.class__;
        }

        static /* synthetic */ List access$23102(PackageFragment r10, List r11) {
            r10.class__ = r11;
            return r11;
        }

        static /* synthetic */ int access$23202(PackageFragment r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$23300(PackageFragment r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(PackageFragment r10) {
            return newBuilder().mergeFrom(r10);
        }

        public static PackageFragment parseFrom(InputStream r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public Class getClass_(int r10) {
            return this.class__.get(r10);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeMessageSize(1, this.strings_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r12 = r12 + CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r12 = r12 + CodedOutputStream.computeMessageSize(3, this.package_);
        L16:
            if (r11 >= this.class__.size()) goto L18;
            r12 = r12 + CodedOutputStream.computeMessageSize(4, this.class__.get(r11));
            r11 = r11 + 1;
            goto L16
        L18:
            int r13 = (r12 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        L8:
            r12 = 0;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
            return false;
        L9:
            if (hasQualifiedNames() == false) goto L15;
            if (getQualifiedNames().isInitialized() == true) goto L15;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (hasPackage() == true) goto L17;
        L20:
            int r11 = 0;
        L22:
            if (r11 >= getClass_Count()) goto L29;
            if (getClass_(r11).isInitialized() == false) goto L25;
            r11 = r11 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeMessage(1, this.strings_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r10.writeMessage(2, this.qualifiedNames_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r10.writeMessage(3, this.package_);
        L11:
            int r12 = 0;
        L13:
            if (r12 >= this.class__.size()) goto L15;
            r10.writeMessage(4, this.class__.get(r12));
            r12 = r12 + 1;
            goto L13
        L15:
            r11.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$16000() {
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
            public Property build() {
                Property r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Property buildPartial() {
                Property r10 = new Property(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                Property.access$16202(r10, this.flags_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                Property.access$16302(r10, this.oldFlags_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                Property.access$16402(r10, this.name_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 8;
            L15:
                Property.access$16502(r10, this.returnType_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 16;
            L18:
                Property.access$16602(r10, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Property.access$16702(r10, this.typeParameter_);
                if ((r11 & 64) != 64) goto L24;
                r12 = r12 | 32;
            L24:
                Property.access$16802(r10, this.receiverType_);
                if ((r11 & 128) != 128) goto L27;
                r12 = r12 | 64;
            L27:
                Property.access$16902(r10, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Property.access$17002(r10, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Property.access$17102(r10, this.contextReceiverTypeId_);
                if ((r11 & 1024) != 1024) goto L36;
                r12 = r12 | 128;
            L36:
                Property.access$17202(r10, this.setterValueParameter_);
                if ((r11 & 2048) != 2048) goto L39;
                r12 = r12 | 256;
            L39:
                Property.access$17302(r10, this.getterFlags_);
                if ((r11 & 4096) != 4096) goto L42;
                r12 = r12 | 512;
            L42:
                Property.access$17402(r10, this.setterFlags_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -8193;
            L45:
                Property.access$17502(r10, this.versionRequirement_);
                Property.access$17602(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Type getContextReceiverType(int r10) {
                return this.contextReceiverType_.get(r10);
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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

            public TypeParameter getTypeParameter(int r10) {
                return this.typeParameter_.get(r10);
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
                int r10 = 0;
            L12:
                if (r10 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r10).isInitialized() == false) goto L15;
                r10 = r10 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r11 = 0;
            L24:
                if (r11 >= getContextReceiverTypeCount()) goto L30;
                if (getContextReceiverType(r11).isInitialized() == false) goto L27;
                r11 = r11 + 1;
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

            public Builder mergeFrom(Property r10) {
                if (r10 != Property.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasFlags() == false) goto L9;
                setFlags(r10.getFlags());
            L9:
                if (r10.hasOldFlags() == false) goto L12;
                setOldFlags(r10.getOldFlags());
            L12:
                if (r10.hasName() == false) goto L15;
                setName(r10.getName());
            L15:
                if (r10.hasReturnType() == false) goto L18;
                mergeReturnType(r10.getReturnType());
            L18:
                if (r10.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r10.getReturnTypeId());
            L21:
                if (Property.access$16700(r10).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Property.access$16700(r10);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Property.access$16700(r10));
            L27:
                if (r10.hasReceiverType() == false) goto L30;
                mergeReceiverType(r10.getReceiverType());
            L30:
                if (r10.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r10.getReceiverTypeId());
            L33:
                if (Property.access$17000(r10).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Property.access$17000(r10);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Property.access$17000(r10));
            L39:
                if (Property.access$17100(r10).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Property.access$17100(r10);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Property.access$17100(r10));
            L45:
                if (r10.hasSetterValueParameter() == false) goto L48;
                mergeSetterValueParameter(r10.getSetterValueParameter());
            L48:
                if (r10.hasGetterFlags() == false) goto L51;
                setGetterFlags(r10.getGetterFlags());
            L51:
                if (r10.hasSetterFlags() == false) goto L54;
                setSetterFlags(r10.getSetterFlags());
            L54:
                if (Property.access$17500(r10).isEmpty() == false) goto L56;
            L59:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(Property.access$17700(r10)));
                return this;
            L56:
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Property.access$17500(r10);
                this.bitField0_ &= -8193;
                goto L59
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Property.access$17500(r10));
                goto L59
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Property r12 = null;
                Property r13 = Property.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Property r14 = (Property) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Property) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeReceiverType(Type r10) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r10;
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.receiverType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeReturnType(Type r10) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r10;
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.returnType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeSetterValueParameter(ValueParameter r10) {
                if ((this.bitField0_ & 1024) == 1024) goto L5;
            L7:
                this.setterValueParameter_ = r10;
                this.bitField0_ |= 1024;
                return this;
            L5:
                if (this.setterValueParameter_ == ValueParameter.getDefaultInstance()) goto L7;
                r10 = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 1;
                this.flags_ = r10;
                return this;
            }

            public Builder setGetterFlags(int r10) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = r10;
                return this;
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 4;
                this.name_ = r10;
                return this;
            }

            public Builder setOldFlags(int r10) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r10;
                return this;
            }

            public Builder setReceiverTypeId(int r10) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r10;
                return this;
            }

            public Builder setReturnTypeId(int r10) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r10;
                return this;
            }

            public Builder setSetterFlags(int r10) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Property r10 = new Property(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Property(CodedInputStream r13, ExtensionRegistryLite r14) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r11 = CodedOutputStream.newInstance(r10, 1);
            boolean r12 = false;
            int r15 = 0;
        L4:
            if (r12 == true) goto L103;
            int r16 = r13.readTag();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            Type.Builder r17 = null;
            ValueParameter.Builder r18 = null;
            Type.Builder r19 = null;
            switch(r16) {
                case 0: goto L72;
                case 8: goto L70;
                case 16: goto L69;
                case 26: goto L62;
                case 34: goto L58;
                case 42: goto L52;
                case 50: goto L43;
                case 56: goto L42;
                case 64: goto L41;
                case 72: goto L40;
                case 80: goto L39;
                case 88: goto L38;
                case 98: goto L34;
                case 104: goto L30;
                case 106: goto L22;
                case 248: goto L17;
                case 250: goto L8;
                default: goto L73;
            };     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L8:
            int r20 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            int r110 = (r15 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = r15;
            if (r110 == 8192) goto L14;
            r15 = r15;
            if (r13.getBytesUntilLimit() <= 0) goto L14;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = (r15 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L14:
            if (r13.getBytesUntilLimit() <= 0) goto L16;
            this.versionRequirement_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L16:
            r13.popLimit(r20);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L17:
            int r21 = (r15 == true ? 1 : 0) & 8192;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            int r22 = r15;
            if (r21 == 8192) goto L20;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r22 = (r15 == true ? 1 : 0) | 8192;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L20:
            List r23 = this.versionRequirement_;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = r22;
            Object r111 = Integer.valueOf(r13.readInt32());     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L21:
            r23.add(r111);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L22:
            r20 = r13.pushLimit(r13.readRawVarint32());     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            int r112 = (r15 == true ? 1 : 0) & 512;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = r15;
            if (r112 == 512) goto L28;
            r15 = r15;
            if (r13.getBytesUntilLimit() <= 0) goto L28;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = (r15 == true ? 1 : 0) | 512;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L28:
            if (r13.getBytesUntilLimit() <= 0) goto L16;
            this.contextReceiverTypeId_.add(Integer.valueOf(r13.readInt32()));     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L28
        L30:
            int r24 = (r15 == true ? 1 : 0) & 512;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            int r25 = r15;
            if (r24 == 512) goto L33;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r25 = (r15 == true ? 1 : 0) | 512;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L33:
            r23 = this.contextReceiverTypeId_;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = r25;
            r111 = Integer.valueOf(r13.readInt32());     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L21
        L34:
            int r26 = (r15 == true ? 1 : 0) & 256;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            int r27 = r15;
            if (r26 == 256) goto L37;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r27 = (r15 == true ? 1 : 0) | 256;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L37:
            r23 = this.contextReceiverType_;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = r27;
            r111 = r13.readMessage(Type.PARSER, r14);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L21
        L38:
            this.bitField0_ |= 1;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.flags_ = r13.readInt32();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L39:
            this.bitField0_ |= 64;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.receiverTypeId_ = r13.readInt32();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L40:
            this.bitField0_ |= 16;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.returnTypeId_ = r13.readInt32();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L41:
            this.bitField0_ |= 512;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.setterFlags_ = r13.readInt32();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L42:
            this.bitField0_ |= 256;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.getterFlags_ = r13.readInt32();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L43:
            int r113 = 128;
            if ((this.bitField0_ & 128) != 128) goto L46;
            r18 = this.setterValueParameter_.toBuilder();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L46:
            ValueParameter r28 = (ValueParameter) r13.readMessage(ValueParameter.PARSER, r14);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.setterValueParameter_ = r28;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            if (r18 == null) goto L49;
            r18.mergeFrom(r28);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.setterValueParameter_ = r18.buildPartial();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L49:
            int r29 = this.bitField0_;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L50:
            this.bitField0_ = r29 | r113;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L52:
            if ((this.bitField0_ & 32) != 32) goto L54;
            r19 = this.receiverType_.toBuilder();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L54:
            Type r30 = (Type) r13.readMessage(Type.PARSER, r14);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.receiverType_ = r30;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            if (r19 == null) goto L57;
            r19.mergeFrom(r30);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.receiverType_ = r19.buildPartial();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L57:
            this.bitField0_ |= 32;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L58:
            int r31 = (r15 == true ? 1 : 0) & 32;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            int r32 = r15;
            if (r31 == 32) goto L61;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r32 = (r15 == true ? 1 : 0) | 32;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L61:
            r23 = this.typeParameter_;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            r15 = r32;
            r111 = r13.readMessage(TypeParameter.PARSER, r14);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L21
        L62:
            r113 = 8;
            if ((this.bitField0_ & 8) != 8) goto L65;
            r17 = this.returnType_.toBuilder();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L65:
            Type r33 = (Type) r13.readMessage(Type.PARSER, r14);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.returnType_ = r33;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            if (r17 == null) goto L68;
            r17.mergeFrom(r33);     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.returnType_ = r17.buildPartial();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L68:
            r29 = this.bitField0_;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L50
        L69:
            this.bitField0_ |= 4;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.name_ = r13.readInt32();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            goto L4
        L70:
            this.bitField0_ |= 2;     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
            this.oldFlags_ = r13.readInt32();     // Catch: Throwable -> L75 IOException -> L77 InvalidProtocolBufferException -> L80
        L72:
            r12 = true;
            goto L4
        L73:
            if (parseUnknownField(r13, r11, r14, r16) == true) goto L4;
        L75:
            th = move-exception;
            if (((r15 == true ? 1 : 0) & 32) != 32) goto L87;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L87:
            if (((r15 == true ? 1 : 0) & 256) != 256) goto L90;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L90:
            if (((r15 == true ? 1 : 0) & 512) != 512) goto L93;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L93:
            if (((r15 == true ? 1 : 0) & 8192) != 8192) goto L126;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L126:
            r11.flush();     // Catch: IOException -> L122 Throwable -> L97
        L97:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L96:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L80:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L75
        L77:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L75
        L103:
            if (((r15 == true ? 1 : 0) & 32) != 32) goto L106;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L106:
            if (((r15 == true ? 1 : 0) & 256) != 256) goto L109;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L109:
            if (((r15 == true ? 1 : 0) & 512) != 512) goto L112;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L112:
            if (((r15 == true ? 1 : 0) & 8192) != 8192) goto L124;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L124:
            r11.flush();     // Catch: IOException -> L121 Throwable -> L116
        L116:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L115:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Property(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> r10) {
            super(r10);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Property(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Property(boolean r10) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$16202(Property r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$16302(Property r10, int r11) {
            r10.oldFlags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$16402(Property r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$16502(Property r10, Type r11) {
            r10.returnType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$16602(Property r10, int r11) {
            r10.returnTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$16700(Property r10) {
            return r10.typeParameter_;
        }

        static /* synthetic */ List access$16702(Property r10, List r11) {
            r10.typeParameter_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$16802(Property r10, Type r11) {
            r10.receiverType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$16902(Property r10, int r11) {
            r10.receiverTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$17000(Property r10) {
            return r10.contextReceiverType_;
        }

        static /* synthetic */ List access$17002(Property r10, List r11) {
            r10.contextReceiverType_ = r11;
            return r11;
        }

        static /* synthetic */ List access$17100(Property r10) {
            return r10.contextReceiverTypeId_;
        }

        static /* synthetic */ List access$17102(Property r10, List r11) {
            r10.contextReceiverTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ ValueParameter access$17202(Property r10, ValueParameter r11) {
            r10.setterValueParameter_ = r11;
            return r11;
        }

        static /* synthetic */ int access$17302(Property r10, int r11) {
            r10.getterFlags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$17402(Property r10, int r11) {
            r10.setterFlags_ = r11;
            return r11;
        }

        static /* synthetic */ List access$17500(Property r10) {
            return r10.versionRequirement_;
        }

        static /* synthetic */ List access$17502(Property r10, List r11) {
            r10.versionRequirement_ = r11;
            return r11;
        }

        static /* synthetic */ int access$17602(Property r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$17700(Property r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Property r10) {
            return newBuilder().mergeFrom(r10);
        }

        public Type getContextReceiverType(int r10) {
            return this.contextReceiverType_.get(r10);
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
        public Property getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r12 = r12 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r12 = r12 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r13 = 0;
        L17:
            if (r13 >= this.typeParameter_.size()) goto L20;
            r12 = r12 + CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(r13));
            r13 = r13 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r12 = r12 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L23:
            if ((this.bitField0_ & 128) != 128) goto L26;
            r12 = r12 + CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        L26:
            if ((this.bitField0_ & 256) != 256) goto L29;
            r12 = r12 + CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        L29:
            if ((this.bitField0_ & 512) != 512) goto L32;
            r12 = r12 + CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        L32:
            if ((this.bitField0_ & 16) != 16) goto L35;
            r12 = r12 + CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        L35:
            if ((this.bitField0_ & 64) != 64) goto L38;
            r12 = r12 + CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        L38:
            if ((this.bitField0_ & 1) != 1) goto L40;
            r12 = r12 + CodedOutputStream.computeInt32Size(11, this.flags_);
        L40:
            int r14 = 0;
        L42:
            if (r14 >= this.contextReceiverType_.size()) goto L44;
            r12 = r12 + CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(r14));
            r14 = r14 + 1;
            goto L42
        L44:
            int r15 = 0;
            int r16 = 0;
        L46:
            if (r15 >= this.contextReceiverTypeId_.size()) goto L48;
            r16 = r16 + CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(r15).intValue());
            r15 = r15 + 1;
            goto L46
        L48:
            int r17 = r12 + r16;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L51;
            r17 = (r17 + 1) + CodedOutputStream.computeInt32SizeNoTag(r16);
        L51:
            this.contextReceiverTypeIdMemoizedSerializedSize = r16;
            int r18 = 0;
        L53:
            if (r11 >= this.versionRequirement_.size()) goto L55;
            r18 = r18 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L53
        L55:
            int r19 = (((r17 + r18) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r19;
            return r19;
        L8:
            r12 = 0;
            goto L10
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public TypeParameter getTypeParameter(int r10) {
            return this.typeParameter_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r11 = 0;
        L20:
            if (r11 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r11).isInitialized() == false) goto L23;
            r11 = r11 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r12 = 0;
        L34:
            if (r12 >= getContextReceiverTypeCount()) goto L41;
            if (getContextReceiverType(r12).isInitialized() == false) goto L37;
            r12 = r12 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r10.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r10.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r10.writeMessage(3, this.returnType_);
        L11:
            int r12 = 0;
            int r13 = 0;
        L13:
            if (r13 >= this.typeParameter_.size()) goto L16;
            r10.writeMessage(4, this.typeParameter_.get(r13));
            r13 = r13 + 1;
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
            int r14 = 0;
        L38:
            if (r14 >= this.contextReceiverType_.size()) goto L41;
            r10.writeMessage(12, this.contextReceiverType_.get(r14));
            r14 = r14 + 1;
            goto L38
        L41:
            if (getContextReceiverTypeIdList().size() <= 0) goto L43;
            r10.writeRawVarint32(106);
            r10.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L43:
            int r15 = 0;
        L45:
            if (r15 >= this.contextReceiverTypeId_.size()) goto L48;
            r10.writeInt32NoTag(this.contextReceiverTypeId_.get(r15).intValue());
            r15 = r15 + 1;
        L48:
            if (r12 >= this.versionRequirement_.size()) goto L50;
            r10.writeInt32(31, this.versionRequirement_.get(r12).intValue());
            r12 = r12 + 1;
            goto L48
        L50:
            r11.writeUntil(19000, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$1400() {
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
            public QualifiedNameTable build() {
                QualifiedNameTable r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable r10 = new QualifiedNameTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                this.bitField0_ &= -2;
            L5:
                QualifiedNameTable.access$1602(r10, this.qualifiedName_);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public QualifiedName getQualifiedName(int r10) {
                return this.qualifiedName_.get(r10);
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r10 = 0;
            L4:
                if (r10 >= getQualifiedNameCount()) goto L9;
                if (getQualifiedName(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            public Builder mergeFrom(QualifiedNameTable r10) {
                if (r10 != QualifiedNameTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (QualifiedNameTable.access$1600(r10).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(QualifiedNameTable.access$1700(r10)));
                return this;
            L8:
                if (this.qualifiedName_.isEmpty() == false) goto L10;
                this.qualifiedName_ = QualifiedNameTable.access$1600(r10);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.addAll(QualifiedNameTable.access$1600(r10));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                QualifiedNameTable r12 = null;
                QualifiedNameTable r13 = QualifiedNameTable.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                QualifiedNameTable r14 = (QualifiedNameTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((QualifiedNameTable) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
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

                static /* synthetic */ Builder access$700() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public QualifiedName build() {
                    QualifiedName r10 = buildPartial();
                    if (r10.isInitialized() == false) goto L6;
                    return r10;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public QualifiedName buildPartial() {
                    QualifiedName r10 = new QualifiedName(this, null);
                    int r11 = this.bitField0_;
                    int r12 = 1;
                    if ((r11 & 1) == 1) goto L6;
                    r12 = 0;
                L6:
                    QualifiedName.access$902(r10, this.parentQualifiedName_);
                    if ((r11 & 2) != 2) goto L9;
                    r12 = r12 | 2;
                L9:
                    QualifiedName.access$1002(r10, this.shortName_);
                    if ((r11 & 4) != 4) goto L12;
                    r12 = r12 | 4;
                L12:
                    QualifiedName.access$1102(r10, this.kind_);
                    QualifiedName.access$1202(r10, r12);
                    return r10;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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

                public Builder mergeFrom(QualifiedName r10) {
                    if (r10 != QualifiedName.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r10.hasParentQualifiedName() == false) goto L9;
                    setParentQualifiedName(r10.getParentQualifiedName());
                L9:
                    if (r10.hasShortName() == false) goto L12;
                    setShortName(r10.getShortName());
                L12:
                    if (r10.hasKind() == false) goto L14;
                    setKind(r10.getKind());
                L14:
                    setUnknownFields(getUnknownFields().concat(QualifiedName.access$1300(r10)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    QualifiedName r12 = null;
                    QualifiedName r13 = QualifiedName.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r13 == null) goto L6;
                    mergeFrom(r13);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    QualifiedName r14 = (QualifiedName) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r12 = r14;
                L14:
                    if (r12 == null) goto L16;
                    mergeFrom(r12);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                    return mergeFrom((QualifiedName) r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                public Builder setKind(Kind r10) {
                    Objects.requireNonNull(r10);
                    this.bitField0_ |= 4;
                    this.kind_ = r10;
                    return this;
                }

                public Builder setParentQualifiedName(int r10) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = r10;
                    return this;
                }

                public Builder setShortName(int r10) {
                    this.bitField0_ |= 2;
                    this.shortName_ = r10;
                    return this;
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
                    Kind r10 = new Kind("CLASS", 0, 0, 0);
                    CLASS = r10;
                    Kind r11 = new Kind("PACKAGE", 1, 1, 1);
                    PACKAGE = r11;
                    Kind r12 = new Kind("LOCAL", 2, 2, 2);
                    LOCAL = r12;
                    $VALUES = new Kind[]{r10, r11, r12};
                    internalValueMap = new AnonymousClass1();
                }

                private Kind(String r10, int r11, int r12, int r13) {
                    super(r10, r11);
                    this.value = r13;
                }

                public static Kind valueOf(int r10) {
                    if (r10 == 0) goto L14;
                    if (r10 == 1) goto L12;
                    if (r10 == 2) goto L10;
                    return null;
                L10:
                    return LOCAL;
                L12:
                    return PACKAGE;
                L14:
                    return CLASS;
                }

                public static Kind valueOf(String r10) {
                    return (Kind) Enum.valueOf(Kind.class, r10);
                }

                public static Kind[] values() {
                    return (Kind[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }
            }

            static {
                PARSER = new AnonymousClass1();
                QualifiedName r10 = new QualifiedName(true);
                defaultInstance = r10;
                r10.initFields();
            }

            private QualifiedName(CodedInputStream r10, ExtensionRegistryLite r11) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r12 = ByteString.newOutput();
                CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
                boolean r14 = false;
            L3:
                if (r14 == true) goto L49;
                int r15 = r10.readTag();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r15 == 0) goto L22;
                if (r15 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.parentQualifiedName_ = r10.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L9:
                if (r15 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.shortName_ = r10.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L11:
                if (r15 != 24) goto L13;
                int r16 = r10.readEnum();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                Kind r17 = Kind.valueOf(r16);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r17 == null) goto L17;
                this.bitField0_ |= 4;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.kind_ = r17;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L17:
                r13.writeRawVarint32(r15);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                r13.writeRawVarint32(r16);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L13:
                if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
            L22:
                r14 = true;
                goto L3
            L23:
                th = move-exception;
                r13.flush();     // Catch: IOException -> L45 Throwable -> L33
            L33:
                th = move-exception;
                this.unknownFields = r12.toByteString();
                throw th;
            L32:
                this.unknownFields = r12.toByteString();
                makeExtensionsImmutable();
                throw th;
            L28:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L25:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L49:
                r13.flush();     // Catch: IOException -> L46 Throwable -> L40
            L40:
                th = move-exception;
                this.unknownFields = r12.toByteString();
                throw th;
            L39:
                this.unknownFields = r12.toByteString();
                makeExtensionsImmutable();
            }

            /* synthetic */ QualifiedName(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            private QualifiedName(GeneratedMessageLite.Builder r10) {
                super(r10);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r10.getUnknownFields();
            }

            /* synthetic */ QualifiedName(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
                this(r10);
            }

            private QualifiedName(boolean r10) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            static /* synthetic */ int access$1002(QualifiedName r10, int r11) {
                r10.shortName_ = r11;
                return r11;
            }

            static /* synthetic */ Kind access$1102(QualifiedName r10, Kind r11) {
                r10.kind_ = r11;
                return r11;
            }

            static /* synthetic */ int access$1202(QualifiedName r10, int r11) {
                r10.bitField0_ = r11;
                return r11;
            }

            static /* synthetic */ ByteString access$1300(QualifiedName r10) {
                return r10.unknownFields;
            }

            static /* synthetic */ int access$902(QualifiedName r10, int r11) {
                r10.parentQualifiedName_ = r11;
                return r11;
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

            public static Builder newBuilder(QualifiedName r10) {
                return newBuilder().mergeFrom(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
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
                int r10 = this.memoizedSerializedSize;
                if (r10 == (-1)) goto L5;
                return r10;
            L5:
                int r11 = 0;
                if ((this.bitField0_ & 1) != 1) goto L9;
                r11 = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
            L9:
                if ((this.bitField0_ & 2) != 2) goto L12;
                r11 = r11 + CodedOutputStream.computeInt32Size(2, this.shortName_);
            L12:
                if ((this.bitField0_ & 4) != 4) goto L14;
                r11 = r11 + CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
            L14:
                int r12 = r11 + this.unknownFields.size();
                this.memoizedSerializedSize = r12;
                return r12;
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
                byte r10 = this.memoizedIsInitialized;
                if (r10 != 1) goto L6;
                return true;
            L6:
                if (r10 != 0) goto L9;
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
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r10) {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r10.writeInt32(1, this.parentQualifiedName_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r10.writeInt32(2, this.shortName_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r10.writeEnum(3, this.kind_.getNumber());
            L11:
                r10.writeRawBytes(this.unknownFields);
            }
        }

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            PARSER = new AnonymousClass1();
            QualifiedNameTable r10 = new QualifiedNameTable(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private QualifiedNameTable(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            boolean r15 = false;
        L3:
            if (r14 == true) goto L36;
            int r16 = r10.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r16 == 0) goto L16;
            if (r16 != 10) goto L9;
            if ((r15 & true) == true) goto L14;
            this.qualifiedName_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r15 = r15 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.qualifiedName_.add((QualifiedName) r10.readMessage(QualifiedName.PARSER, r11));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L3;
        L16:
            r14 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r15 & true) != true) goto L48;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L48:
            r13.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L29:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r15 & true) != true) goto L51;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L51:
            r13.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L39:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ QualifiedNameTable(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private QualifiedNameTable(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ QualifiedNameTable(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private QualifiedNameTable(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ List access$1600(QualifiedNameTable r10) {
            return r10.qualifiedName_;
        }

        static /* synthetic */ List access$1602(QualifiedNameTable r10, List r11) {
            r10.qualifiedName_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$1700(QualifiedNameTable r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(QualifiedNameTable r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int r10) {
            return this.qualifiedName_.get(r10);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.qualifiedName_.size()) goto L9;
            r12 = r12 + CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = r12 + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getQualifiedNameCount()) goto L16;
            if (getQualifiedName(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            int r11 = 0;
        L4:
            if (r11 >= this.qualifiedName_.size()) goto L6;
            r10.writeMessage(1, this.qualifiedName_.get(r11));
            r11 = r11 + 1;
            goto L4
        L6:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$100() {
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
            public StringTable build() {
                StringTable r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public StringTable buildPartial() {
                StringTable r10 = new StringTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.string_ = this.string_.getUnmodifiableView();
                this.bitField0_ &= -2;
            L5:
                StringTable.access$302(r10, this.string_);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(StringTable r10) {
                if (r10 != StringTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTable.access$300(r10).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(StringTable.access$400(r10)));
                return this;
            L8:
                if (this.string_.isEmpty() == false) goto L10;
                this.string_ = StringTable.access$300(r10);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureStringIsMutable();
                this.string_.addAll(StringTable.access$300(r10));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                StringTable r12 = null;
                StringTable r13 = StringTable.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTable r14 = (StringTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((StringTable) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }
        }

        static {
            PARSER = new AnonymousClass1();
            StringTable r10 = new StringTable(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private StringTable(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            boolean r15 = false;
        L3:
            if (r14 == true) goto L36;
            int r16 = r10.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r16 == 0) goto L16;
            if (r16 != 10) goto L9;
            ByteString r17 = r10.readBytes();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if ((r15 & true) == true) goto L14;
            this.string_ = new LazyStringArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r15 = r15 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.string_.add(r17);     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L3;
        L16:
            r14 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r15 & true) != true) goto L51;
            this.string_ = this.string_.getUnmodifiableView();
        L51:
            r13.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L29:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r15 & true) != true) goto L49;
            this.string_ = this.string_.getUnmodifiableView();
        L49:
            r13.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L39:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ StringTable(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private StringTable(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ StringTable(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private StringTable(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ LazyStringList access$300(StringTable r10) {
            return r10.string_;
        }

        static /* synthetic */ LazyStringList access$302(StringTable r10, LazyStringList r11) {
            r10.string_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$400(StringTable r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(StringTable r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.string_.size()) goto L9;
            r12 = r12 + CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = ((0 + r12) + (getStringList().size() * 1)) + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        }

        public String getString(int r10) {
            return this.string_.get(r10);
        }

        public ProtocolStringList getStringList() {
            return this.string_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            int r11 = 0;
        L4:
            if (r11 >= this.string_.size()) goto L6;
            r10.writeBytes(1, this.string_.getByteString(r11));
            r11 = r11 + 1;
            goto L4
        L6:
            r10.writeRawBytes(this.unknownFields);
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

                static /* synthetic */ Builder access$5000() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r10 = buildPartial();
                    if (r10.isInitialized() == false) goto L6;
                    return r10;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                public Argument buildPartial() {
                    Argument r10 = new Argument(this, null);
                    int r11 = this.bitField0_;
                    int r12 = 1;
                    if ((r11 & 1) == 1) goto L6;
                    r12 = 0;
                L6:
                    Argument.access$5202(r10, this.projection_);
                    if ((r11 & 2) != 2) goto L9;
                    r12 = r12 | 2;
                L9:
                    Argument.access$5302(r10, this.type_);
                    if ((r11 & 4) != 4) goto L12;
                    r12 = r12 | 4;
                L12:
                    Argument.access$5402(r10, this.typeId_);
                    Argument.access$5502(r10, r12);
                    return r10;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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

                public Builder mergeFrom(Argument r10) {
                    if (r10 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r10.hasProjection() == false) goto L9;
                    setProjection(r10.getProjection());
                L9:
                    if (r10.hasType() == false) goto L12;
                    mergeType(r10.getType());
                L12:
                    if (r10.hasTypeId() == false) goto L14;
                    setTypeId(r10.getTypeId());
                L14:
                    setUnknownFields(getUnknownFields().concat(Argument.access$5600(r10)));
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    Argument r12 = null;
                    Argument r13 = Argument.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r13 == null) goto L6;
                    mergeFrom(r13);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r14 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r12 = r14;
                L14:
                    if (r12 == null) goto L16;
                    mergeFrom(r12);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                    return mergeFrom((Argument) r10);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                public Builder mergeType(Type r10) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.type_ = r10;
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.type_ == Type.getDefaultInstance()) goto L7;
                    r10 = Type.newBuilder(this.type_).mergeFrom(r10).buildPartial();
                    goto L7
                }

                public Builder setProjection(Projection r10) {
                    Objects.requireNonNull(r10);
                    this.bitField0_ |= 1;
                    this.projection_ = r10;
                    return this;
                }

                public Builder setTypeId(int r10) {
                    this.bitField0_ |= 4;
                    this.typeId_ = r10;
                    return this;
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
                    Projection r10 = new Projection("IN", 0, 0, 0);
                    IN = r10;
                    Projection r11 = new Projection("OUT", 1, 1, 1);
                    OUT = r11;
                    Projection r12 = new Projection("INV", 2, 2, 2);
                    INV = r12;
                    Projection r13 = new Projection("STAR", 3, 3, 3);
                    STAR = r13;
                    $VALUES = new Projection[]{r10, r11, r12, r13};
                    internalValueMap = new AnonymousClass1();
                }

                private Projection(String r10, int r11, int r12, int r13) {
                    super(r10, r11);
                    this.value = r13;
                }

                public static Projection valueOf(int r10) {
                    if (r10 == 0) goto L18;
                    if (r10 == 1) goto L16;
                    if (r10 == 2) goto L14;
                    if (r10 == 3) goto L12;
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

                public static Projection valueOf(String r10) {
                    return (Projection) Enum.valueOf(Projection.class, r10);
                }

                public static Projection[] values() {
                    return (Projection[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }
            }

            static {
                PARSER = new AnonymousClass1();
                Argument r10 = new Argument(true);
                defaultInstance = r10;
                r10.initFields();
            }

            private Argument(CodedInputStream r10, ExtensionRegistryLite r11) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r12 = ByteString.newOutput();
                CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
                boolean r14 = false;
            L3:
                if (r14 == true) goto L57;
                int r15 = r10.readTag();     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                if (r15 == 0) goto L28;
                if (r15 != 8) goto L9;
                int r16 = r10.readEnum();     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                Projection r17 = Projection.valueOf(r16);     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                if (r17 == null) goto L25;
                this.bitField0_ |= 1;     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                this.projection_ = r17;     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                goto L3
            L25:
                r13.writeRawVarint32(r15);     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                r13.writeRawVarint32(r16);     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                goto L3
            L9:
                if (r15 != 18) goto L11;
                Builder r18 = null;
                if ((this.bitField0_ & 2) != 2) goto L19;
                r18 = this.type_.toBuilder();     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
            L19:
                Type r19 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                this.type_ = r19;     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                if (r18 == null) goto L22;
                r18.mergeFrom(r19);     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                this.type_ = r18.buildPartial();     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
            L22:
                this.bitField0_ |= 2;     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                goto L3
            L11:
                if (r15 != 24) goto L13;
                this.bitField0_ |= 4;     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                this.typeId_ = r10.readInt32();     // Catch: Throwable -> L29 IOException -> L31 InvalidProtocolBufferException -> L34
                goto L3
            L13:
                if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
            L28:
                r14 = true;
                goto L3
            L29:
                th = move-exception;
                r13.flush();     // Catch: IOException -> L51 Throwable -> L39
            L39:
                th = move-exception;
                this.unknownFields = r12.toByteString();
                throw th;
            L38:
                this.unknownFields = r12.toByteString();
                makeExtensionsImmutable();
                throw th;
            L34:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L29
            L31:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L29
            L57:
                r13.flush();     // Catch: IOException -> L52 Throwable -> L46
            L46:
                th = move-exception;
                this.unknownFields = r12.toByteString();
                throw th;
            L45:
                this.unknownFields = r12.toByteString();
                makeExtensionsImmutable();
            }

            /* synthetic */ Argument(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
                this(r10, r11);
            }

            private Argument(GeneratedMessageLite.Builder r10) {
                super(r10);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r10.getUnknownFields();
            }

            /* synthetic */ Argument(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
                this(r10);
            }

            private Argument(boolean r10) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            static /* synthetic */ Projection access$5202(Argument r10, Projection r11) {
                r10.projection_ = r11;
                return r11;
            }

            static /* synthetic */ Type access$5302(Argument r10, Type r11) {
                r10.type_ = r11;
                return r11;
            }

            static /* synthetic */ int access$5402(Argument r10, int r11) {
                r10.typeId_ = r11;
                return r11;
            }

            static /* synthetic */ int access$5502(Argument r10, int r11) {
                r10.bitField0_ = r11;
                return r11;
            }

            static /* synthetic */ ByteString access$5600(Argument r10) {
                return r10.unknownFields;
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

            public static Builder newBuilder(Argument r10) {
                return newBuilder().mergeFrom(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
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
                int r10 = this.memoizedSerializedSize;
                if (r10 == (-1)) goto L5;
                return r10;
            L5:
                int r11 = 0;
                if ((this.bitField0_ & 1) != 1) goto L9;
                r11 = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
            L9:
                if ((this.bitField0_ & 2) != 2) goto L12;
                r11 = r11 + CodedOutputStream.computeMessageSize(2, this.type_);
            L12:
                if ((this.bitField0_ & 4) != 4) goto L14;
                r11 = r11 + CodedOutputStream.computeInt32Size(3, this.typeId_);
            L14:
                int r12 = r11 + this.unknownFields.size();
                this.memoizedSerializedSize = r12;
                return r12;
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
                byte r10 = this.memoizedIsInitialized;
                if (r10 != 1) goto L6;
                return true;
            L6:
                if (r10 != 0) goto L9;
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
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r10) {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r10.writeEnum(1, this.projection_.getNumber());
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r10.writeMessage(2, this.type_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r10.writeInt32(3, this.typeId_);
            L11:
                r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$5700() {
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
            public Type build() {
                Type r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public Type buildPartial() {
                Type r10 = new Type(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) != 1) goto L5;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -2;
            L5:
                Type.access$5902(r10, this.argument_);
                if ((r11 & 2) == 2) goto L9;
                r12 = 0;
            L9:
                Type.access$6002(r10, this.nullable_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 2;
            L12:
                Type.access$6102(r10, this.flexibleTypeCapabilitiesId_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 4;
            L15:
                Type.access$6202(r10, this.flexibleUpperBound_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 8;
            L18:
                Type.access$6302(r10, this.flexibleUpperBoundId_);
                if ((r11 & 32) != 32) goto L21;
                r12 = r12 | 16;
            L21:
                Type.access$6402(r10, this.className_);
                if ((r11 & 64) != 64) goto L24;
                r12 = r12 | 32;
            L24:
                Type.access$6502(r10, this.typeParameter_);
                if ((r11 & 128) != 128) goto L27;
                r12 = r12 | 64;
            L27:
                Type.access$6602(r10, this.typeParameterName_);
                if ((r11 & 256) != 256) goto L30;
                r12 = r12 | 128;
            L30:
                Type.access$6702(r10, this.typeAliasName_);
                if ((r11 & 512) != 512) goto L33;
                r12 = r12 | 256;
            L33:
                Type.access$6802(r10, this.outerType_);
                if ((r11 & 1024) != 1024) goto L36;
                r12 = r12 | 512;
            L36:
                Type.access$6902(r10, this.outerTypeId_);
                if ((r11 & 2048) != 2048) goto L39;
                r12 = r12 | 1024;
            L39:
                Type.access$7002(r10, this.abbreviatedType_);
                if ((r11 & 4096) != 4096) goto L42;
                r12 = r12 | 2048;
            L42:
                Type.access$7102(r10, this.abbreviatedTypeId_);
                if ((r11 & 8192) != 8192) goto L45;
                r12 = r12 | 4096;
            L45:
                Type.access$7202(r10, this.flags_);
                Type.access$7302(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Argument getArgument(int r10) {
                return this.argument_.get(r10);
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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
                int r10 = 0;
            L4:
                if (r10 >= getArgumentCount()) goto L10;
                if (getArgument(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
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

            public Builder mergeAbbreviatedType(Type r10) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.abbreviatedType_ = r10;
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.abbreviatedType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.abbreviatedType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeFlexibleUpperBound(Type r10) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.flexibleUpperBound_ = r10;
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.flexibleUpperBound_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeFrom(Type r10) {
                if (r10 != Type.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Type.access$5900(r10).isEmpty() == true) goto L12;
                if (this.argument_.isEmpty() == false) goto L10;
                this.argument_ = Type.access$5900(r10);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureArgumentIsMutable();
                this.argument_.addAll(Type.access$5900(r10));
            L12:
                if (r10.hasNullable() == false) goto L15;
                setNullable(r10.getNullable());
            L15:
                if (r10.hasFlexibleTypeCapabilitiesId() == false) goto L18;
                setFlexibleTypeCapabilitiesId(r10.getFlexibleTypeCapabilitiesId());
            L18:
                if (r10.hasFlexibleUpperBound() == false) goto L21;
                mergeFlexibleUpperBound(r10.getFlexibleUpperBound());
            L21:
                if (r10.hasFlexibleUpperBoundId() == false) goto L24;
                setFlexibleUpperBoundId(r10.getFlexibleUpperBoundId());
            L24:
                if (r10.hasClassName() == false) goto L27;
                setClassName(r10.getClassName());
            L27:
                if (r10.hasTypeParameter() == false) goto L30;
                setTypeParameter(r10.getTypeParameter());
            L30:
                if (r10.hasTypeParameterName() == false) goto L33;
                setTypeParameterName(r10.getTypeParameterName());
            L33:
                if (r10.hasTypeAliasName() == false) goto L36;
                setTypeAliasName(r10.getTypeAliasName());
            L36:
                if (r10.hasOuterType() == false) goto L39;
                mergeOuterType(r10.getOuterType());
            L39:
                if (r10.hasOuterTypeId() == false) goto L42;
                setOuterTypeId(r10.getOuterTypeId());
            L42:
                if (r10.hasAbbreviatedType() == false) goto L45;
                mergeAbbreviatedType(r10.getAbbreviatedType());
            L45:
                if (r10.hasAbbreviatedTypeId() == false) goto L48;
                setAbbreviatedTypeId(r10.getAbbreviatedTypeId());
            L48:
                if (r10.hasFlags() == false) goto L50;
                setFlags(r10.getFlags());
            L50:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(Type.access$7400(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Type r12 = null;
                Type r13 = Type.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                Type r14 = (Type) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((Type) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeOuterType(Type r10) {
                if ((this.bitField0_ & 512) == 512) goto L5;
            L7:
                this.outerType_ = r10;
                this.bitField0_ |= 512;
                return this;
            L5:
                if (this.outerType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.outerType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder setAbbreviatedTypeId(int r10) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = r10;
                return this;
            }

            public Builder setClassName(int r10) {
                this.bitField0_ |= 32;
                this.className_ = r10;
                return this;
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 8192;
                this.flags_ = r10;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int r10) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = r10;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int r10) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = r10;
                return this;
            }

            public Builder setNullable(boolean r10) {
                this.bitField0_ |= 2;
                this.nullable_ = r10;
                return this;
            }

            public Builder setOuterTypeId(int r10) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = r10;
                return this;
            }

            public Builder setTypeAliasName(int r10) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = r10;
                return this;
            }

            public Builder setTypeParameter(int r10) {
                this.bitField0_ |= 64;
                this.typeParameter_ = r10;
                return this;
            }

            public Builder setTypeParameterName(int r10) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Type r10 = new Type(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private Type(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            boolean r15 = false;
        L3:
            if (r14 == true) goto L66;
            int r16 = r10.readTag();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            Builder r17 = null;
            switch(r16) {
                case 0: goto L44;
                case 8: goto L42;
                case 18: goto L39;
                case 24: goto L37;
                case 32: goto L36;
                case 42: goto L29;
                case 48: goto L28;
                case 56: goto L27;
                case 64: goto L26;
                case 72: goto L25;
                case 82: goto L18;
                case 88: goto L17;
                case 96: goto L16;
                case 106: goto L8;
                case 112: goto L7;
                default: goto L45;
            };     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L7:
            this.bitField0_ |= 2048;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.abbreviatedTypeId_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L8:
            int r18 = 1024;
            if ((this.bitField0_ & 1024) != 1024) goto L11;
            r17 = this.abbreviatedType_.toBuilder();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L11:
            Type r19 = (Type) r10.readMessage(PARSER, r11);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.abbreviatedType_ = r19;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            if (r17 == null) goto L14;
            r17.mergeFrom(r19);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.abbreviatedType_ = r17.buildPartial();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L14:
            int r20 = this.bitField0_;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L15:
            this.bitField0_ = r20 | r18;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L16:
            this.bitField0_ |= 128;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.typeAliasName_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L17:
            this.bitField0_ |= 512;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.outerTypeId_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L18:
            r18 = 256;
            if ((this.bitField0_ & 256) != 256) goto L21;
            r17 = this.outerType_.toBuilder();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L21:
            Type r21 = (Type) r10.readMessage(PARSER, r11);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.outerType_ = r21;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            if (r17 == null) goto L24;
            r17.mergeFrom(r21);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.outerType_ = r17.buildPartial();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L24:
            r20 = this.bitField0_;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L15
        L25:
            this.bitField0_ |= 64;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.typeParameterName_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L26:
            this.bitField0_ |= 8;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.flexibleUpperBoundId_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L27:
            this.bitField0_ |= 32;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.typeParameter_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L28:
            this.bitField0_ |= 16;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.className_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L29:
            r18 = 4;
            if ((this.bitField0_ & 4) != 4) goto L32;
            r17 = this.flexibleUpperBound_.toBuilder();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L32:
            Type r22 = (Type) r10.readMessage(PARSER, r11);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.flexibleUpperBound_ = r22;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            if (r17 == null) goto L35;
            r17.mergeFrom(r22);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.flexibleUpperBound_ = r17.buildPartial();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L35:
            r20 = this.bitField0_;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L15
        L36:
            this.bitField0_ |= 2;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.flexibleTypeCapabilitiesId_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L37:
            this.bitField0_ |= 1;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.nullable_ = r10.readBool();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L39:
            if ((r15 & true) == true) goto L41;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            r15 = r15 | true;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L41:
            this.argument_.add((Argument) r10.readMessage(Argument.PARSER, r11));     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L3
        L42:
            this.bitField0_ |= 4096;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.flags_ = r10.readInt32();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L44:
            r14 = true;
            goto L3
        L45:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L3;
        L47:
            th = move-exception;
            if ((r15 & true) != true) goto L81;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L81:
            r13.flush();     // Catch: IOException -> L76 Throwable -> L60
        L60:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L59:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L52:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L47
        L49:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L47
        L66:
            if ((r15 & true) != true) goto L79;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L79:
            r13.flush();     // Catch: IOException -> L75 Throwable -> L70
        L70:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L69:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ Type(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ Type(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private Type(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ List access$5900(Type r10) {
            return r10.argument_;
        }

        static /* synthetic */ List access$5902(Type r10, List r11) {
            r10.argument_ = r11;
            return r11;
        }

        static /* synthetic */ boolean access$6002(Type r10, boolean r11) {
            r10.nullable_ = r11;
            return r11;
        }

        static /* synthetic */ int access$6102(Type r10, int r11) {
            r10.flexibleTypeCapabilitiesId_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$6202(Type r10, Type r11) {
            r10.flexibleUpperBound_ = r11;
            return r11;
        }

        static /* synthetic */ int access$6302(Type r10, int r11) {
            r10.flexibleUpperBoundId_ = r11;
            return r11;
        }

        static /* synthetic */ int access$6402(Type r10, int r11) {
            r10.className_ = r11;
            return r11;
        }

        static /* synthetic */ int access$6502(Type r10, int r11) {
            r10.typeParameter_ = r11;
            return r11;
        }

        static /* synthetic */ int access$6602(Type r10, int r11) {
            r10.typeParameterName_ = r11;
            return r11;
        }

        static /* synthetic */ int access$6702(Type r10, int r11) {
            r10.typeAliasName_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$6802(Type r10, Type r11) {
            r10.outerType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$6902(Type r10, int r11) {
            r10.outerTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$7002(Type r10, Type r11) {
            r10.abbreviatedType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$7102(Type r10, int r11) {
            r10.abbreviatedTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ int access$7202(Type r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$7302(Type r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$7400(Type r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(Type r10) {
            return newBuilder().mergeFrom(r10);
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public Argument getArgument(int r10) {
            return this.argument_.get(r10);
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
        public Type getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 4096) != 4096) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if (r11 >= this.argument_.size()) goto L13;
            r12 = r12 + CodedOutputStream.computeMessageSize(2, this.argument_.get(r11));
            r11 = r11 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 1) != 1) goto L16;
            r12 = r12 + CodedOutputStream.computeBoolSize(3, this.nullable_);
        L16:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r12 = r12 + CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        L19:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r12 = r12 + CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        L22:
            if ((this.bitField0_ & 16) != 16) goto L25;
            r12 = r12 + CodedOutputStream.computeInt32Size(6, this.className_);
        L25:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r12 = r12 + CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        L28:
            if ((this.bitField0_ & 8) != 8) goto L31;
            r12 = r12 + CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        L31:
            if ((this.bitField0_ & 64) != 64) goto L34;
            r12 = r12 + CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        L34:
            if ((this.bitField0_ & 256) != 256) goto L37;
            r12 = r12 + CodedOutputStream.computeMessageSize(10, this.outerType_);
        L37:
            if ((this.bitField0_ & 512) != 512) goto L40;
            r12 = r12 + CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        L40:
            if ((this.bitField0_ & 128) != 128) goto L43;
            r12 = r12 + CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        L43:
            if ((this.bitField0_ & 1024) != 1024) goto L46;
            r12 = r12 + CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        L46:
            if ((this.bitField0_ & 2048) != 2048) goto L48;
            r12 = r12 + CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
        L48:
            int r13 = (r12 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        L8:
            r12 = 0;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getArgumentCount()) goto L17;
            if (getArgument(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 4096) != 4096) goto L5;
            r10.writeInt32(1, this.flags_);
        L5:
            int r12 = 0;
        L7:
            if (r12 >= this.argument_.size()) goto L10;
            r10.writeMessage(2, this.argument_.get(r12));
            r12 = r12 + 1;
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
            r11.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$19000() {
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
            public TypeAlias build() {
                TypeAlias r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public TypeAlias buildPartial() {
                TypeAlias r10 = new TypeAlias(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                TypeAlias.access$19202(r10, this.flags_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                TypeAlias.access$19302(r10, this.name_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            L12:
                TypeAlias.access$19402(r10, this.typeParameter_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 4;
            L15:
                TypeAlias.access$19502(r10, this.underlyingType_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 8;
            L18:
                TypeAlias.access$19602(r10, this.underlyingTypeId_);
                if ((r11 & 32) != 32) goto L21;
                r12 = r12 | 16;
            L21:
                TypeAlias.access$19702(r10, this.expandedType_);
                if ((r11 & 64) != 64) goto L24;
                r12 = r12 | 32;
            L24:
                TypeAlias.access$19802(r10, this.expandedTypeId_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            L27:
                TypeAlias.access$19902(r10, this.annotation_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            L30:
                TypeAlias.access$20002(r10, this.versionRequirement_);
                TypeAlias.access$20102(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Annotation getAnnotation(int r10) {
                return this.annotation_.get(r10);
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public TypeParameter getTypeParameter(int r10) {
                return this.typeParameter_.get(r10);
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
                int r10 = 0;
            L7:
                if (r10 >= getTypeParameterCount()) goto L13;
                if (getTypeParameter(r10).isInitialized() == false) goto L10;
                r10 = r10 + 1;
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
                int r11 = 0;
            L24:
                if (r11 >= getAnnotationCount()) goto L30;
                if (getAnnotation(r11).isInitialized() == false) goto L27;
                r11 = r11 + 1;
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

            public Builder mergeExpandedType(Type r10) {
                if ((this.bitField0_ & 32) == 32) goto L5;
            L7:
                this.expandedType_ = r10;
                this.bitField0_ |= 32;
                return this;
            L5:
                if (this.expandedType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.expandedType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeFrom(TypeAlias r10) {
                if (r10 != TypeAlias.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasFlags() == false) goto L9;
                setFlags(r10.getFlags());
            L9:
                if (r10.hasName() == false) goto L12;
                setName(r10.getName());
            L12:
                if (TypeAlias.access$19400(r10).isEmpty() == true) goto L18;
                if (this.typeParameter_.isEmpty() == false) goto L16;
                this.typeParameter_ = TypeAlias.access$19400(r10);
                this.bitField0_ &= -5;
                goto L18
            L16:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(TypeAlias.access$19400(r10));
            L18:
                if (r10.hasUnderlyingType() == false) goto L21;
                mergeUnderlyingType(r10.getUnderlyingType());
            L21:
                if (r10.hasUnderlyingTypeId() == false) goto L24;
                setUnderlyingTypeId(r10.getUnderlyingTypeId());
            L24:
                if (r10.hasExpandedType() == false) goto L27;
                mergeExpandedType(r10.getExpandedType());
            L27:
                if (r10.hasExpandedTypeId() == false) goto L30;
                setExpandedTypeId(r10.getExpandedTypeId());
            L30:
                if (TypeAlias.access$19900(r10).isEmpty() == true) goto L36;
                if (this.annotation_.isEmpty() == false) goto L34;
                this.annotation_ = TypeAlias.access$19900(r10);
                this.bitField0_ &= -129;
                goto L36
            L34:
                ensureAnnotationIsMutable();
                this.annotation_.addAll(TypeAlias.access$19900(r10));
            L36:
                if (TypeAlias.access$20000(r10).isEmpty() == false) goto L38;
            L41:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(TypeAlias.access$20200(r10)));
                return this;
            L38:
                if (this.versionRequirement_.isEmpty() == false) goto L40;
                this.versionRequirement_ = TypeAlias.access$20000(r10);
                this.bitField0_ &= -257;
                goto L41
            L40:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(TypeAlias.access$20000(r10));
                goto L41
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                TypeAlias r12 = null;
                TypeAlias r13 = TypeAlias.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeAlias r14 = (TypeAlias) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((TypeAlias) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeUnderlyingType(Type r10) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.underlyingType_ = r10;
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.underlyingType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.underlyingType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder setExpandedTypeId(int r10) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = r10;
                return this;
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 1;
                this.flags_ = r10;
                return this;
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 2;
                this.name_ = r10;
                return this;
            }

            public Builder setUnderlyingTypeId(int r10) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            TypeAlias r10 = new TypeAlias(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private TypeAlias(CodedInputStream r12, ExtensionRegistryLite r13) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r11 = CodedOutputStream.newInstance(r10, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L77;
            int r16 = r12.readTag();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            Type.Builder r17 = null;
            switch(r16) {
                case 0: goto L49;
                case 8: goto L47;
                case 16: goto L46;
                case 26: goto L43;
                case 34: goto L36;
                case 40: goto L34;
                case 50: goto L28;
                case 56: goto L26;
                case 66: goto L23;
                case 248: goto L18;
                case 250: goto L8;
                default: goto L50;
            };     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L8:
            int r18 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            if ((r15 & 256) == 256) goto L14;
            if (r12.getBytesUntilLimit() <= 0) goto L14;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            r15 = r15 | 256;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L14:
            if (r12.getBytesUntilLimit() <= 0) goto L16;
            this.versionRequirement_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L14
        L16:
            r12.popLimit(r18);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L4
        L18:
            if ((r15 & 256) == 256) goto L20;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            r15 = r15 | 256;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L20:
            List r19 = this.versionRequirement_;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            Object r20 = Integer.valueOf(r12.readInt32());     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L21:
            r19.add(r20);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L4
        L23:
            if ((r15 & 128) == 128) goto L25;
            this.annotation_ = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            r15 = r15 | 128;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L25:
            r19 = this.annotation_;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            r20 = r12.readMessage(Annotation.PARSER, r13);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L21
        L26:
            this.bitField0_ |= 32;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.expandedTypeId_ = r12.readInt32();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L4
        L28:
            if ((this.bitField0_ & 16) != 16) goto L30;
            r17 = this.expandedType_.toBuilder();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L30:
            Type r21 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.expandedType_ = r21;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            if (r17 == null) goto L33;
            r17.mergeFrom(r21);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.expandedType_ = r17.buildPartial();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L33:
            this.bitField0_ |= 16;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L4
        L34:
            this.bitField0_ |= 8;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.underlyingTypeId_ = r12.readInt32();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L4
        L36:
            if ((this.bitField0_ & 4) != 4) goto L38;
            r17 = this.underlyingType_.toBuilder();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L38:
            Type r22 = (Type) r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.underlyingType_ = r22;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            if (r17 == null) goto L41;
            r17.mergeFrom(r22);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.underlyingType_ = r17.buildPartial();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L41:
            this.bitField0_ |= 4;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L4
        L43:
            if ((r15 & 4) == 4) goto L45;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            r15 = r15 | 4;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L45:
            r19 = this.typeParameter_;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            r20 = r12.readMessage(TypeParameter.PARSER, r13);     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L21
        L46:
            this.bitField0_ |= 2;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.name_ = r12.readInt32();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            goto L4
        L47:
            this.bitField0_ |= 1;     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
            this.flags_ = r12.readInt32();     // Catch: Throwable -> L52 IOException -> L54 InvalidProtocolBufferException -> L57
        L49:
            r14 = true;
            goto L4
        L50:
            if (parseUnknownField(r12, r11, r13, r16) == true) goto L4;
        L52:
            th = move-exception;
            if ((r15 & 4) != 4) goto L64;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L64:
            if ((r15 & 128) != 128) goto L67;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L67:
            if ((r15 & 256) != 256) goto L98;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L98:
            r11.flush();     // Catch: IOException -> L93 Throwable -> L71
        L71:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L70:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L54:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L52
        L57:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L52
        L77:
            if ((r15 & 4) != 4) goto L80;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L80:
            if ((r15 & 128) != 128) goto L83;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L83:
            if ((r15 & 256) != 256) goto L96;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L96:
            r11.flush();     // Catch: IOException -> L92 Throwable -> L87
        L87:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L86:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ TypeAlias(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ TypeAlias(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private TypeAlias(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$19202(TypeAlias r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$19302(TypeAlias r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ List access$19400(TypeAlias r10) {
            return r10.typeParameter_;
        }

        static /* synthetic */ List access$19402(TypeAlias r10, List r11) {
            r10.typeParameter_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$19502(TypeAlias r10, Type r11) {
            r10.underlyingType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$19602(TypeAlias r10, int r11) {
            r10.underlyingTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$19702(TypeAlias r10, Type r11) {
            r10.expandedType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$19802(TypeAlias r10, int r11) {
            r10.expandedTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ List access$19900(TypeAlias r10) {
            return r10.annotation_;
        }

        static /* synthetic */ List access$19902(TypeAlias r10, List r11) {
            r10.annotation_ = r11;
            return r11;
        }

        static /* synthetic */ List access$20000(TypeAlias r10) {
            return r10.versionRequirement_;
        }

        static /* synthetic */ List access$20002(TypeAlias r10, List r11) {
            r10.versionRequirement_ = r11;
            return r11;
        }

        static /* synthetic */ int access$20102(TypeAlias r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$20200(TypeAlias r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(TypeAlias r10) {
            return newBuilder().mergeFrom(r10);
        }

        public static TypeAlias parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
            return PARSER.parseDelimitedFrom(r10, r11);
        }

        public Annotation getAnnotation(int r10) {
            return this.annotation_.get(r10);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r12 = r12 + CodedOutputStream.computeInt32Size(2, this.name_);
        L12:
            int r13 = 0;
        L14:
            if (r13 >= this.typeParameter_.size()) goto L17;
            r12 = r12 + CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(r13));
            r13 = r13 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 4) != 4) goto L20;
            r12 = r12 + CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        L20:
            if ((this.bitField0_ & 8) != 8) goto L23;
            r12 = r12 + CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        L23:
            if ((this.bitField0_ & 16) != 16) goto L26;
            r12 = r12 + CodedOutputStream.computeMessageSize(6, this.expandedType_);
        L26:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r12 = r12 + CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        L28:
            int r14 = 0;
        L30:
            if (r14 >= this.annotation_.size()) goto L32;
            r12 = r12 + CodedOutputStream.computeMessageSize(8, this.annotation_.get(r14));
            r14 = r14 + 1;
            goto L30
        L32:
            int r15 = 0;
        L34:
            if (r11 >= this.versionRequirement_.size()) goto L36;
            r15 = r15 + CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(r11).intValue());
            r11 = r11 + 1;
            goto L34
        L36:
            int r16 = (((r12 + r15) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r16;
            return r16;
        L8:
            r12 = 0;
            goto L10
        }

        public TypeParameter getTypeParameter(int r10) {
            return this.typeParameter_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r11 = 0;
        L14:
            if (r11 >= getTypeParameterCount()) goto L21;
            if (getTypeParameter(r11).isInitialized() == false) goto L17;
            r11 = r11 + 1;
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
            int r12 = 0;
        L34:
            if (r12 >= getAnnotationCount()) goto L41;
            if (getAnnotation(r12).isInitialized() == false) goto L37;
            r12 = r12 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r10.writeInt32(2, this.name_);
        L8:
            int r12 = 0;
            int r13 = 0;
        L10:
            if (r13 >= this.typeParameter_.size()) goto L13;
            r10.writeMessage(3, this.typeParameter_.get(r13));
            r13 = r13 + 1;
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
            int r14 = 0;
        L26:
            if (r14 >= this.annotation_.size()) goto L29;
            r10.writeMessage(8, this.annotation_.get(r14));
            r14 = r14 + 1;
        L29:
            if (r12 >= this.versionRequirement_.size()) goto L31;
            r10.writeInt32(31, this.versionRequirement_.get(r12).intValue());
            r12 = r12 + 1;
            goto L29
        L31:
            r11.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$7600() {
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
            public TypeParameter build() {
                TypeParameter r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public TypeParameter buildPartial() {
                TypeParameter r10 = new TypeParameter(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                TypeParameter.access$7802(r10, this.id_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                TypeParameter.access$7902(r10, this.name_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                TypeParameter.access$8002(r10, this.reified_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 8;
            L15:
                TypeParameter.access$8102(r10, this.variance_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                this.bitField0_ &= -17;
            L18:
                TypeParameter.access$8202(r10, this.upperBound_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                this.bitField0_ &= -33;
            L21:
                TypeParameter.access$8302(r10, this.upperBoundId_);
                TypeParameter.access$8402(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getUpperBound(int r10) {
                return this.upperBound_.get(r10);
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
                int r10 = 0;
            L10:
                if (r10 >= getUpperBoundCount()) goto L16;
                if (getUpperBound(r10).isInitialized() == false) goto L13;
                r10 = r10 + 1;
                goto L10
            L13:
                return false;
            L16:
                if (extensionsAreInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            public Builder mergeFrom(TypeParameter r10) {
                if (r10 != TypeParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasId() == false) goto L9;
                setId(r10.getId());
            L9:
                if (r10.hasName() == false) goto L12;
                setName(r10.getName());
            L12:
                if (r10.hasReified() == false) goto L15;
                setReified(r10.getReified());
            L15:
                if (r10.hasVariance() == false) goto L18;
                setVariance(r10.getVariance());
            L18:
                if (TypeParameter.access$8200(r10).isEmpty() == true) goto L24;
                if (this.upperBound_.isEmpty() == false) goto L22;
                this.upperBound_ = TypeParameter.access$8200(r10);
                this.bitField0_ &= -17;
                goto L24
            L22:
                ensureUpperBoundIsMutable();
                this.upperBound_.addAll(TypeParameter.access$8200(r10));
            L24:
                if (TypeParameter.access$8300(r10).isEmpty() == false) goto L26;
            L29:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(TypeParameter.access$8500(r10)));
                return this;
            L26:
                if (this.upperBoundId_.isEmpty() == false) goto L28;
                this.upperBoundId_ = TypeParameter.access$8300(r10);
                this.bitField0_ &= -33;
                goto L29
            L28:
                ensureUpperBoundIdIsMutable();
                this.upperBoundId_.addAll(TypeParameter.access$8300(r10));
                goto L29
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                TypeParameter r12 = null;
                TypeParameter r13 = TypeParameter.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeParameter r14 = (TypeParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((TypeParameter) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setId(int r10) {
                this.bitField0_ |= 1;
                this.id_ = r10;
                return this;
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 2;
                this.name_ = r10;
                return this;
            }

            public Builder setReified(boolean r10) {
                this.bitField0_ |= 4;
                this.reified_ = r10;
                return this;
            }

            public Builder setVariance(Variance r10) {
                Objects.requireNonNull(r10);
                this.bitField0_ |= 8;
                this.variance_ = r10;
                return this;
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
                Variance r10 = new Variance("IN", 0, 0, 0);
                IN = r10;
                Variance r11 = new Variance("OUT", 1, 1, 1);
                OUT = r11;
                Variance r12 = new Variance("INV", 2, 2, 2);
                INV = r12;
                $VALUES = new Variance[]{r10, r11, r12};
                internalValueMap = new AnonymousClass1();
            }

            private Variance(String r10, int r11, int r12, int r13) {
                super(r10, r11);
                this.value = r13;
            }

            public static Variance valueOf(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L10;
                return null;
            L10:
                return INV;
            L12:
                return OUT;
            L14:
                return IN;
            }

            public static Variance valueOf(String r10) {
                return (Variance) Enum.valueOf(Variance.class, r10);
            }

            public static Variance[] values() {
                return (Variance[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            TypeParameter r10 = new TypeParameter(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private TypeParameter(CodedInputStream r12, ExtensionRegistryLite r13) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r10 = ByteString.newOutput();
            CodedOutputStream r11 = CodedOutputStream.newInstance(r10, 1);
            boolean r14 = false;
            int r15 = 0;
        L4:
            if (r14 == true) goto L71;
            int r16 = r12.readTag();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r16 == 0) goto L48;
            if (r16 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.id_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L9:
            if (r16 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.name_ = r12.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L11:
            if (r16 != 24) goto L12;
            this.bitField0_ |= 4;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.reified_ = r12.readBool();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L12:
            if (r16 != 32) goto L14;
            int r17 = r12.readEnum();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            Variance r18 = Variance.valueOf(r17);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r18 == null) goto L42;
            this.bitField0_ |= 8;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.variance_ = r18;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L42:
            r11.writeRawVarint32(r16);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r11.writeRawVarint32(r17);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L14:
            if (r16 == 42) goto L37;
            if (r16 != 48) goto L18;
            if ((r15 & 32) == 32) goto L34;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r15 | 32;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L34:
            List r19 = this.upperBoundId_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            Object r20 = Integer.valueOf(r12.readInt32());     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L35:
            r19.add(r20);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L18:
            if (r16 != 50) goto L20;
            int r21 = r12.pushLimit(r12.readRawVarint32());     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if ((r15 & 32) == 32) goto L28;
            if (r12.getBytesUntilLimit() <= 0) goto L28;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r15 | 32;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L28:
            if (r12.getBytesUntilLimit() <= 0) goto L30;
            this.upperBoundId_.add(Integer.valueOf(r12.readInt32()));     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L28
        L30:
            r12.popLimit(r21);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L20:
            if (parseUnknownField(r12, r11, r13, r16) == true) goto L4;
        L37:
            if ((r15 & 16) == 16) goto L39;
            this.upperBound_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r15 = r15 | 16;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L39:
            r19 = this.upperBound_;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r20 = r12.readMessage(Type.PARSER, r13);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L48:
            r14 = true;
            goto L4
        L49:
            th = move-exception;
            if ((r15 & 16) != 16) goto L61;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L61:
            if ((r15 & 32) != 32) goto L88;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L88:
            r11.flush();     // Catch: IOException -> L84 Throwable -> L65
        L65:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L64:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
            throw th;
        L54:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L51:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L71:
            if ((r15 & 16) != 16) goto L74;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L74:
            if ((r15 & 32) != 32) goto L86;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L86:
            r11.flush();     // Catch: IOException -> L83 Throwable -> L78
        L78:
            th = move-exception;
            this.unknownFields = r10.toByteString();
            throw th;
        L77:
            this.unknownFields = r10.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ TypeParameter(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> r10) {
            super(r10);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ TypeParameter(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private TypeParameter(boolean r10) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$7802(TypeParameter r10, int r11) {
            r10.id_ = r11;
            return r11;
        }

        static /* synthetic */ int access$7902(TypeParameter r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ boolean access$8002(TypeParameter r10, boolean r11) {
            r10.reified_ = r11;
            return r11;
        }

        static /* synthetic */ Variance access$8102(TypeParameter r10, Variance r11) {
            r10.variance_ = r11;
            return r11;
        }

        static /* synthetic */ List access$8200(TypeParameter r10) {
            return r10.upperBound_;
        }

        static /* synthetic */ List access$8202(TypeParameter r10, List r11) {
            r10.upperBound_ = r11;
            return r11;
        }

        static /* synthetic */ List access$8300(TypeParameter r10) {
            return r10.upperBoundId_;
        }

        static /* synthetic */ List access$8302(TypeParameter r10, List r11) {
            r10.upperBoundId_ = r11;
            return r11;
        }

        static /* synthetic */ int access$8402(TypeParameter r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$8500(TypeParameter r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(TypeParameter r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r12 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r12 = r12 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r12 = r12 + CodedOutputStream.computeBoolSize(3, this.reified_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r12 = r12 + CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        L18:
            int r13 = 0;
        L20:
            if (r13 >= this.upperBound_.size()) goto L22;
            r12 = r12 + CodedOutputStream.computeMessageSize(5, this.upperBound_.get(r13));
            r13 = r13 + 1;
            goto L20
        L22:
            int r14 = 0;
        L24:
            if (r11 >= this.upperBoundId_.size()) goto L26;
            r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(r11).intValue());
            r11 = r11 + 1;
            goto L24
        L26:
            int r15 = r12 + r14;
            if (getUpperBoundIdList().isEmpty() == true) goto L29;
            r15 = (r15 + 1) + CodedOutputStream.computeInt32SizeNoTag(r14);
        L29:
            this.upperBoundIdMemoizedSerializedSize = r14;
            int r16 = (r15 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r16;
            return r16;
        L8:
            r12 = 0;
            goto L10
        }

        public Type getUpperBound(int r10) {
            return this.upperBound_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
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
            int r11 = 0;
        L18:
            if (r11 >= getUpperBoundCount()) goto L25;
            if (getUpperBound(r11).isInitialized() == false) goto L21;
            r11 = r11 + 1;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
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
            int r12 = 0;
            int r13 = 0;
        L16:
            if (r13 >= this.upperBound_.size()) goto L19;
            r10.writeMessage(5, this.upperBound_.get(r13));
            r13 = r13 + 1;
            goto L16
        L19:
            if (getUpperBoundIdList().size() <= 0) goto L22;
            r10.writeRawVarint32(50);
            r10.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        L22:
            if (r12 >= this.upperBoundId_.size()) goto L24;
            r10.writeInt32NoTag(this.upperBoundId_.get(r12).intValue());
            r12 = r12 + 1;
            goto L22
        L24:
            r11.writeUntil(1000, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$12600() {
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
            public TypeTable build() {
                TypeTable r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public TypeTable buildPartial() {
                TypeTable r10 = new TypeTable(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) != 1) goto L5;
                this.type_ = Collections.unmodifiableList(this.type_);
                this.bitField0_ &= -2;
            L5:
                TypeTable.access$12802(r10, this.type_);
                if ((r11 & 2) == 2) goto L9;
                r12 = 0;
            L9:
                TypeTable.access$12902(r10, this.firstNullable_);
                TypeTable.access$13002(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            public Type getType(int r10) {
                return this.type_.get(r10);
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r10 = 0;
            L4:
                if (r10 >= getTypeCount()) goto L9;
                if (getType(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            public Builder mergeFrom(TypeTable r10) {
                if (r10 != TypeTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (TypeTable.access$12800(r10).isEmpty() == true) goto L12;
                if (this.type_.isEmpty() == false) goto L10;
                this.type_ = TypeTable.access$12800(r10);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureTypeIsMutable();
                this.type_.addAll(TypeTable.access$12800(r10));
            L12:
                if (r10.hasFirstNullable() == false) goto L14;
                setFirstNullable(r10.getFirstNullable());
            L14:
                setUnknownFields(getUnknownFields().concat(TypeTable.access$13100(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                TypeTable r12 = null;
                TypeTable r13 = TypeTable.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeTable r14 = (TypeTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((TypeTable) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setFirstNullable(int r10) {
                this.bitField0_ |= 2;
                this.firstNullable_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            TypeTable r10 = new TypeTable(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private TypeTable(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            boolean r15 = false;
        L3:
            if (r14 == true) goto L39;
            int r16 = r10.readTag();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            if (r16 == 0) goto L19;
            if (r16 != 10) goto L9;
            if ((r15 & true) == true) goto L17;
            this.type_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            r15 = r15 | true;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        L17:
            this.type_.add((Type) r10.readMessage(Type.PARSER, r11));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            goto L3
        L9:
            if (r16 != 16) goto L11;
            this.bitField0_ |= 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            this.firstNullable_ = r10.readInt32();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            goto L3
        L11:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L3;
        L19:
            r14 = true;
            goto L3
        L20:
            th = move-exception;
            if ((r15 & true) != true) goto L51;
            this.type_ = Collections.unmodifiableList(this.type_);
        L51:
            r13.flush();     // Catch: IOException -> L49 Throwable -> L33
        L33:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L32:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L25:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L22:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L39:
            if ((r15 & true) != true) goto L54;
            this.type_ = Collections.unmodifiableList(this.type_);
        L54:
            r13.flush();     // Catch: IOException -> L48 Throwable -> L43
        L43:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L42:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ TypeTable(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private TypeTable(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ TypeTable(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private TypeTable(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ List access$12800(TypeTable r10) {
            return r10.type_;
        }

        static /* synthetic */ List access$12802(TypeTable r10, List r11) {
            r10.type_ = r11;
            return r11;
        }

        static /* synthetic */ int access$12902(TypeTable r10, int r11) {
            r10.firstNullable_ = r11;
            return r11;
        }

        static /* synthetic */ int access$13002(TypeTable r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$13100(TypeTable r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(TypeTable r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.type_.size()) goto L10;
            r12 = r12 + CodedOutputStream.computeMessageSize(1, this.type_.get(r11));
            r11 = r11 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 1) != 1) goto L12;
            r12 = r12 + CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        L12:
            int r13 = r12 + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        }

        public Type getType(int r10) {
            return this.type_.get(r10);
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getTypeCount()) goto L16;
            if (getType(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            int r11 = 0;
        L4:
            if (r11 >= this.type_.size()) goto L7;
            r10.writeMessage(1, this.type_.get(r11));
            r11 = r11 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) != 1) goto L9;
            r10.writeInt32(2, this.firstNullable_);
        L9:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$17900() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public ValueParameter build() {
                ValueParameter r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public ValueParameter buildPartial() {
                ValueParameter r10 = new ValueParameter(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                ValueParameter.access$18102(r10, this.flags_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                ValueParameter.access$18202(r10, this.name_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                ValueParameter.access$18302(r10, this.type_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 8;
            L15:
                ValueParameter.access$18402(r10, this.typeId_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 16;
            L18:
                ValueParameter.access$18502(r10, this.varargElementType_);
                if ((r11 & 32) != 32) goto L21;
                r12 = r12 | 32;
            L21:
                ValueParameter.access$18602(r10, this.varargElementTypeId_);
                ValueParameter.access$18702(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
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

            public Builder mergeFrom(ValueParameter r10) {
                if (r10 != ValueParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasFlags() == false) goto L9;
                setFlags(r10.getFlags());
            L9:
                if (r10.hasName() == false) goto L12;
                setName(r10.getName());
            L12:
                if (r10.hasType() == false) goto L15;
                mergeType(r10.getType());
            L15:
                if (r10.hasTypeId() == false) goto L18;
                setTypeId(r10.getTypeId());
            L18:
                if (r10.hasVarargElementType() == false) goto L21;
                mergeVarargElementType(r10.getVarargElementType());
            L21:
                if (r10.hasVarargElementTypeId() == false) goto L23;
                setVarargElementTypeId(r10.getVarargElementTypeId());
            L23:
                mergeExtensionFields(r10);
                setUnknownFields(getUnknownFields().concat(ValueParameter.access$18800(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                ValueParameter r12 = null;
                ValueParameter r13 = ValueParameter.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                ValueParameter r14 = (ValueParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((ValueParameter) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder mergeType(Type r10) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.type_ = r10;
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.type_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.type_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder mergeVarargElementType(Type r10) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.varargElementType_ = r10;
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.varargElementType_ == Type.getDefaultInstance()) goto L7;
                r10 = Type.newBuilder(this.varargElementType_).mergeFrom(r10).buildPartial();
                goto L7
            }

            public Builder setFlags(int r10) {
                this.bitField0_ |= 1;
                this.flags_ = r10;
                return this;
            }

            public Builder setName(int r10) {
                this.bitField0_ |= 2;
                this.name_ = r10;
                return this;
            }

            public Builder setTypeId(int r10) {
                this.bitField0_ |= 8;
                this.typeId_ = r10;
                return this;
            }

            public Builder setVarargElementTypeId(int r10) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = r10;
                return this;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            ValueParameter r10 = new ValueParameter(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private ValueParameter(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
        L3:
            if (r14 == true) goto L69;
            int r15 = r10.readTag();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r15 == 0) goto L40;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.flags_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L9:
            if (r15 != 16) goto L10;
            this.bitField0_ |= 2;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.name_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L10:
            Type.Builder r16 = null;
            if (r15 != 26) goto L13;
            if ((this.bitField0_ & 4) != 4) goto L33;
            r16 = this.type_.toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L33:
            Type r17 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.type_ = r17;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r16 == null) goto L36;
            r16.mergeFrom(r17);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.type_ = r16.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L36:
            this.bitField0_ |= 4;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L13:
            if (r15 != 34) goto L15;
            if ((this.bitField0_ & 16) != 16) goto L26;
            r16 = this.varargElementType_.toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L26:
            Type r18 = (Type) r10.readMessage(Type.PARSER, r11);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementType_ = r18;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r16 == null) goto L29;
            r16.mergeFrom(r18);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementType_ = r16.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L29:
            this.bitField0_ |= 16;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L15:
            if (r15 != 40) goto L17;
            this.bitField0_ |= 8;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.typeId_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L17:
            if (r15 != 48) goto L19;
            this.bitField0_ |= 32;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementTypeId_ = r10.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L19:
            if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
        L40:
            r14 = true;
            goto L3
        L41:
            th = move-exception;
            r13.flush();     // Catch: IOException -> L63 Throwable -> L51
        L51:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L50:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L43:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L46:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L69:
            r13.flush();     // Catch: IOException -> L64 Throwable -> L58
        L58:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L57:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ ValueParameter(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ ValueParameter(GeneratedMessageLite.ExtendableBuilder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private ValueParameter(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$18102(ValueParameter r10, int r11) {
            r10.flags_ = r11;
            return r11;
        }

        static /* synthetic */ int access$18202(ValueParameter r10, int r11) {
            r10.name_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$18302(ValueParameter r10, Type r11) {
            r10.type_ = r11;
            return r11;
        }

        static /* synthetic */ int access$18402(ValueParameter r10, int r11) {
            r10.typeId_ = r11;
            return r11;
        }

        static /* synthetic */ Type access$18502(ValueParameter r10, Type r11) {
            r10.varargElementType_ = r11;
            return r11;
        }

        static /* synthetic */ int access$18602(ValueParameter r10, int r11) {
            r10.varargElementTypeId_ = r11;
            return r11;
        }

        static /* synthetic */ int access$18702(ValueParameter r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$18800(ValueParameter r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(ValueParameter r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r11 = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.name_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r11 = r11 + CodedOutputStream.computeMessageSize(3, this.type_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r11 = r11 + CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        L18:
            if ((this.bitField0_ & 8) != 8) goto L21;
            r11 = r11 + CodedOutputStream.computeInt32Size(5, this.typeId_);
        L21:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r11 = r11 + CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        L23:
            int r12 = (r11 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r12;
            return r12;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L9;
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
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r11 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r10.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r10.writeMessage(3, this.type_);
        L12:
            if ((this.bitField0_ & 16) != 16) goto L15;
            r10.writeMessage(4, this.varargElementType_);
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r10.writeInt32(5, this.typeId_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r10.writeInt32(6, this.varargElementTypeId_);
        L20:
            r11.writeUntil(200, r10);
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$21000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirement build() {
                VersionRequirement r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public VersionRequirement buildPartial() {
                VersionRequirement r10 = new VersionRequirement(this, null);
                int r11 = this.bitField0_;
                int r12 = 1;
                if ((r11 & 1) == 1) goto L6;
                r12 = 0;
            L6:
                VersionRequirement.access$21202(r10, this.version_);
                if ((r11 & 2) != 2) goto L9;
                r12 = r12 | 2;
            L9:
                VersionRequirement.access$21302(r10, this.versionFull_);
                if ((r11 & 4) != 4) goto L12;
                r12 = r12 | 4;
            L12:
                VersionRequirement.access$21402(r10, this.level_);
                if ((r11 & 8) != 8) goto L15;
                r12 = r12 | 8;
            L15:
                VersionRequirement.access$21502(r10, this.errorCode_);
                if ((r11 & 16) != 16) goto L18;
                r12 = r12 | 16;
            L18:
                VersionRequirement.access$21602(r10, this.message_);
                if ((r11 & 32) != 32) goto L21;
                r12 = r12 | 32;
            L21:
                VersionRequirement.access$21702(r10, this.versionKind_);
                VersionRequirement.access$21802(r10, r12);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(VersionRequirement r10) {
                if (r10 != VersionRequirement.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasVersion() == false) goto L9;
                setVersion(r10.getVersion());
            L9:
                if (r10.hasVersionFull() == false) goto L12;
                setVersionFull(r10.getVersionFull());
            L12:
                if (r10.hasLevel() == false) goto L15;
                setLevel(r10.getLevel());
            L15:
                if (r10.hasErrorCode() == false) goto L18;
                setErrorCode(r10.getErrorCode());
            L18:
                if (r10.hasMessage() == false) goto L21;
                setMessage(r10.getMessage());
            L21:
                if (r10.hasVersionKind() == false) goto L23;
                setVersionKind(r10.getVersionKind());
            L23:
                setUnknownFields(getUnknownFields().concat(VersionRequirement.access$21900(r10)));
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                VersionRequirement r12 = null;
                VersionRequirement r13 = VersionRequirement.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirement r14 = (VersionRequirement) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((VersionRequirement) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            public Builder setErrorCode(int r10) {
                this.bitField0_ |= 8;
                this.errorCode_ = r10;
                return this;
            }

            public Builder setLevel(Level r10) {
                Objects.requireNonNull(r10);
                this.bitField0_ |= 4;
                this.level_ = r10;
                return this;
            }

            public Builder setMessage(int r10) {
                this.bitField0_ |= 16;
                this.message_ = r10;
                return this;
            }

            public Builder setVersion(int r10) {
                this.bitField0_ |= 1;
                this.version_ = r10;
                return this;
            }

            public Builder setVersionFull(int r10) {
                this.bitField0_ |= 2;
                this.versionFull_ = r10;
                return this;
            }

            public Builder setVersionKind(VersionKind r10) {
                Objects.requireNonNull(r10);
                this.bitField0_ |= 32;
                this.versionKind_ = r10;
                return this;
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
                Level r10 = new Level("WARNING", 0, 0, 0);
                WARNING = r10;
                Level r11 = new Level("ERROR", 1, 1, 1);
                ERROR = r11;
                Level r12 = new Level("HIDDEN", 2, 2, 2);
                HIDDEN = r12;
                $VALUES = new Level[]{r10, r11, r12};
                internalValueMap = new AnonymousClass1();
            }

            private Level(String r10, int r11, int r12, int r13) {
                super(r10, r11);
                this.value = r13;
            }

            public static Level valueOf(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L10;
                return null;
            L10:
                return HIDDEN;
            L12:
                return ERROR;
            L14:
                return WARNING;
            }

            public static Level valueOf(String r10) {
                return (Level) Enum.valueOf(Level.class, r10);
            }

            public static Level[] values() {
                return (Level[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
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
                VersionKind r10 = new VersionKind("LANGUAGE_VERSION", 0, 0, 0);
                LANGUAGE_VERSION = r10;
                VersionKind r11 = new VersionKind("COMPILER_VERSION", 1, 1, 1);
                COMPILER_VERSION = r11;
                VersionKind r12 = new VersionKind("API_VERSION", 2, 2, 2);
                API_VERSION = r12;
                $VALUES = new VersionKind[]{r10, r11, r12};
                internalValueMap = new AnonymousClass1();
            }

            private VersionKind(String r10, int r11, int r12, int r13) {
                super(r10, r11);
                this.value = r13;
            }

            public static VersionKind valueOf(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L10;
                return null;
            L10:
                return API_VERSION;
            L12:
                return COMPILER_VERSION;
            L14:
                return LANGUAGE_VERSION;
            }

            public static VersionKind valueOf(String r10) {
                return (VersionKind) Enum.valueOf(VersionKind.class, r10);
            }

            public static VersionKind[] values() {
                return (VersionKind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            VersionRequirement r10 = new VersionRequirement(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private VersionRequirement(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
        L3:
            if (r14 == true) goto L64;
            int r15 = r10.readTag();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            if (r15 == 0) goto L35;
            if (r15 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            this.version_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L3
        L9:
            if (r15 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            this.versionFull_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L3
        L11:
            if (r15 != 24) goto L13;
            int r16 = r10.readEnum();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            Level r17 = Level.valueOf(r16);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            if (r17 == null) goto L30;
            this.bitField0_ |= 4;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            this.level_ = r17;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L3
        L30:
            r13.writeRawVarint32(r15);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
        L24:
            r13.writeRawVarint32(r16);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L3
        L13:
            if (r15 != 32) goto L15;
            this.bitField0_ |= 8;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            this.errorCode_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L3
        L15:
            if (r15 != 40) goto L17;
            this.bitField0_ |= 16;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            this.message_ = r10.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L3
        L17:
            if (r15 != 48) goto L19;
            r16 = r10.readEnum();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            VersionKind r18 = VersionKind.valueOf(r16);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            if (r18 == null) goto L23;
            this.bitField0_ |= 32;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            this.versionKind_ = r18;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L3
        L23:
            r13.writeRawVarint32(r15);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
            goto L24
        L19:
            if (parseUnknownField(r10, r13, r11, r15) == true) goto L3;
        L35:
            r14 = true;
            goto L3
        L36:
            th = move-exception;
            r13.flush();     // Catch: IOException -> L58 Throwable -> L46
        L46:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L45:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L38:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L36
        L41:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L36
        L64:
            r13.flush();     // Catch: IOException -> L59 Throwable -> L53
        L53:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L52:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ VersionRequirement(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private VersionRequirement(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ VersionRequirement(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private VersionRequirement(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ int access$21202(VersionRequirement r10, int r11) {
            r10.version_ = r11;
            return r11;
        }

        static /* synthetic */ int access$21302(VersionRequirement r10, int r11) {
            r10.versionFull_ = r11;
            return r11;
        }

        static /* synthetic */ Level access$21402(VersionRequirement r10, Level r11) {
            r10.level_ = r11;
            return r11;
        }

        static /* synthetic */ int access$21502(VersionRequirement r10, int r11) {
            r10.errorCode_ = r11;
            return r11;
        }

        static /* synthetic */ int access$21602(VersionRequirement r10, int r11) {
            r10.message_ = r11;
            return r11;
        }

        static /* synthetic */ VersionKind access$21702(VersionRequirement r10, VersionKind r11) {
            r10.versionKind_ = r11;
            return r11;
        }

        static /* synthetic */ int access$21802(VersionRequirement r10, int r11) {
            r10.bitField0_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$21900(VersionRequirement r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(VersionRequirement r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r11 = 0 + CodedOutputStream.computeInt32Size(1, this.version_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.versionFull_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r11 = r11 + CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r11 = r11 + CodedOutputStream.computeInt32Size(4, this.errorCode_);
        L18:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r11 = r11 + CodedOutputStream.computeInt32Size(5, this.message_);
        L21:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r11 = r11 + CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
        L23:
            int r12 = r11 + this.unknownFields.size();
            this.memoizedSerializedSize = r12;
            return r12;
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
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r10.writeInt32(1, this.version_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r10.writeInt32(2, this.versionFull_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r10.writeEnum(3, this.level_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r10.writeInt32(4, this.errorCode_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r10.writeInt32(5, this.message_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r10.writeEnum(6, this.versionKind_.getNumber());
        L20:
            r10.writeRawBytes(this.unknownFields);
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

            static /* synthetic */ Builder access$22100() {
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
            public VersionRequirementTable build() {
                VersionRequirementTable r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable r10 = new VersionRequirementTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
                this.bitField0_ &= -2;
            L5:
                VersionRequirementTable.access$22302(r10, this.requirement_);
                return r10;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo1321clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(VersionRequirementTable r10) {
                if (r10 != VersionRequirementTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (VersionRequirementTable.access$22300(r10).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(VersionRequirementTable.access$22400(r10)));
                return this;
            L8:
                if (this.requirement_.isEmpty() == false) goto L10;
                this.requirement_ = VersionRequirementTable.access$22300(r10);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureRequirementIsMutable();
                this.requirement_.addAll(VersionRequirementTable.access$22300(r10));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                VersionRequirementTable r12 = null;
                VersionRequirementTable r13 = VersionRequirementTable.PARSER.parsePartialFrom(r10, r11);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r13 == null) goto L6;
                mergeFrom(r13);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirementTable r14 = (VersionRequirementTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r12 = r14;
            L14:
                if (r12 == null) goto L16;
                mergeFrom(r12);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r10) {
                return mergeFrom((VersionRequirementTable) r10);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }
        }

        static {
            PARSER = new AnonymousClass1();
            VersionRequirementTable r10 = new VersionRequirementTable(true);
            defaultInstance = r10;
            r10.initFields();
        }

        private VersionRequirementTable(CodedInputStream r10, ExtensionRegistryLite r11) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r12 = ByteString.newOutput();
            CodedOutputStream r13 = CodedOutputStream.newInstance(r12, 1);
            boolean r14 = false;
            boolean r15 = false;
        L3:
            if (r14 == true) goto L36;
            int r16 = r10.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r16 == 0) goto L16;
            if (r16 != 10) goto L9;
            if ((r15 & true) == true) goto L14;
            this.requirement_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r15 = r15 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.requirement_.add((VersionRequirement) r10.readMessage(VersionRequirement.PARSER, r11));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r10, r13, r11, r16) == true) goto L3;
        L16:
            r14 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r15 & true) != true) goto L48;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L48:
            r13.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L29:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r15 & true) != true) goto L51;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L51:
            r13.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r12.toByteString();
            throw th;
        L39:
            this.unknownFields = r12.toByteString();
            makeExtensionsImmutable();
        }

        /* synthetic */ VersionRequirementTable(CodedInputStream r10, ExtensionRegistryLite r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        private VersionRequirementTable(GeneratedMessageLite.Builder r10) {
            super(r10);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r10.getUnknownFields();
        }

        /* synthetic */ VersionRequirementTable(GeneratedMessageLite.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        private VersionRequirementTable(boolean r10) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        static /* synthetic */ List access$22300(VersionRequirementTable r10) {
            return r10.requirement_;
        }

        static /* synthetic */ List access$22302(VersionRequirementTable r10, List r11) {
            r10.requirement_ = r11;
            return r11;
        }

        static /* synthetic */ ByteString access$22400(VersionRequirementTable r10) {
            return r10.unknownFields;
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

        public static Builder newBuilder(VersionRequirementTable r10) {
            return newBuilder().mergeFrom(r10);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
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
            int r10 = this.memoizedSerializedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.requirement_.size()) goto L9;
            r12 = r12 + CodedOutputStream.computeMessageSize(1, this.requirement_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = r12 + this.unknownFields.size();
            this.memoizedSerializedSize = r13;
            return r13;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            getSerializedSize();
            int r11 = 0;
        L4:
            if (r11 >= this.requirement_.size()) goto L6;
            r10.writeMessage(1, this.requirement_.get(r11));
            r11 = r11 + 1;
            goto L4
        L6:
            r10.writeRawBytes(this.unknownFields);
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
            Visibility r10 = new Visibility("INTERNAL", 0, 0, 0);
            INTERNAL = r10;
            Visibility r11 = new Visibility("PRIVATE", 1, 1, 1);
            PRIVATE = r11;
            Visibility r12 = new Visibility("PROTECTED", 2, 2, 2);
            PROTECTED = r12;
            Visibility r13 = new Visibility("PUBLIC", 3, 3, 3);
            PUBLIC = r13;
            Visibility r14 = new Visibility("PRIVATE_TO_THIS", 4, 4, 4);
            PRIVATE_TO_THIS = r14;
            Visibility r15 = new Visibility("LOCAL", 5, 5, 5);
            LOCAL = r15;
            $VALUES = new Visibility[]{r10, r11, r12, r13, r14, r15};
            internalValueMap = new AnonymousClass1();
        }

        private Visibility(String r10, int r11, int r12, int r13) {
            super(r10, r11);
            this.value = r13;
        }

        public static Visibility valueOf(int r10) {
            if (r10 == 0) goto L26;
            if (r10 == 1) goto L24;
            if (r10 == 2) goto L22;
            if (r10 == 3) goto L20;
            if (r10 == 4) goto L18;
            if (r10 == 5) goto L16;
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

        public static Visibility valueOf(String r10) {
            return (Visibility) Enum.valueOf(Visibility.class, r10);
        }

        public static Visibility[] values() {
            return (Visibility[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }
}
