package org.msgpack.value;

import org.msgpack.core.MessagePacker;

/* JADX INFO: loaded from: classes7.dex */
public interface Value {
    ArrayValue asArrayValue();

    BinaryValue asBinaryValue();

    BooleanValue asBooleanValue();

    ExtensionValue asExtensionValue();

    FloatValue asFloatValue();

    IntegerValue asIntegerValue();

    MapValue asMapValue();

    NilValue asNilValue();

    NumberValue asNumberValue();

    RawValue asRawValue();

    StringValue asStringValue();

    TimestampValue asTimestampValue();

    boolean equals(Object r1);

    ValueType getValueType();

    ImmutableValue immutableValue();

    boolean isArrayValue();

    boolean isBinaryValue();

    boolean isBooleanValue();

    boolean isExtensionValue();

    boolean isFloatValue();

    boolean isIntegerValue();

    boolean isMapValue();

    boolean isNilValue();

    boolean isNumberValue();

    boolean isRawValue();

    boolean isStringValue();

    boolean isTimestampValue();

    String toJson();

    void writeTo(MessagePacker r1);
}
