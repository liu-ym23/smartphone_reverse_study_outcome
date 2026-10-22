package org.msgpack.value.impl;

import org.msgpack.core.MessageTypeCastException;
import org.msgpack.value.ArrayValue;
import org.msgpack.value.BinaryValue;
import org.msgpack.value.BooleanValue;
import org.msgpack.value.ExtensionValue;
import org.msgpack.value.FloatValue;
import org.msgpack.value.ImmutableArrayValue;
import org.msgpack.value.ImmutableBinaryValue;
import org.msgpack.value.ImmutableBooleanValue;
import org.msgpack.value.ImmutableExtensionValue;
import org.msgpack.value.ImmutableFloatValue;
import org.msgpack.value.ImmutableIntegerValue;
import org.msgpack.value.ImmutableMapValue;
import org.msgpack.value.ImmutableNilValue;
import org.msgpack.value.ImmutableNumberValue;
import org.msgpack.value.ImmutableRawValue;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.ImmutableTimestampValue;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.IntegerValue;
import org.msgpack.value.MapValue;
import org.msgpack.value.NilValue;
import org.msgpack.value.NumberValue;
import org.msgpack.value.RawValue;
import org.msgpack.value.StringValue;
import org.msgpack.value.TimestampValue;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractImmutableValue implements ImmutableValue {
    AbstractImmutableValue() {
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ArrayValue asArrayValue() {
        return asArrayValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableArrayValue asArrayValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ BinaryValue asBinaryValue() {
        return asBinaryValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableBinaryValue asBinaryValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ BooleanValue asBooleanValue() {
        return asBooleanValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableBooleanValue asBooleanValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ExtensionValue asExtensionValue() {
        return asExtensionValue();
    }

    @Override // org.msgpack.value.Value
    public ImmutableExtensionValue asExtensionValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ FloatValue asFloatValue() {
        return asFloatValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableFloatValue asFloatValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableIntegerValue asIntegerValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ IntegerValue asIntegerValue() {
        return asIntegerValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableMapValue asMapValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ MapValue asMapValue() {
        return asMapValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableNilValue asNilValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ NilValue asNilValue() {
        return asNilValue();
    }

    @Override // org.msgpack.value.Value
    public ImmutableNumberValue asNumberValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public /* bridge */ /* synthetic */ NumberValue asNumberValue() {
        return asNumberValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableRawValue asRawValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ RawValue asRawValue() {
        return asRawValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableStringValue asStringValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ StringValue asStringValue() {
        return asStringValue();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableTimestampValue asTimestampValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ TimestampValue asTimestampValue() {
        return asTimestampValue();
    }

    @Override // org.msgpack.value.Value
    public boolean isArrayValue() {
        return getValueType().isArrayType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBinaryValue() {
        return getValueType().isBinaryType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBooleanValue() {
        return getValueType().isBooleanType();
    }

    @Override // org.msgpack.value.Value
    public boolean isExtensionValue() {
        return getValueType().isExtensionType();
    }

    @Override // org.msgpack.value.Value
    public boolean isFloatValue() {
        return getValueType().isFloatType();
    }

    @Override // org.msgpack.value.Value
    public boolean isIntegerValue() {
        return getValueType().isIntegerType();
    }

    @Override // org.msgpack.value.Value
    public boolean isMapValue() {
        return getValueType().isMapType();
    }

    @Override // org.msgpack.value.Value
    public boolean isNilValue() {
        return getValueType().isNilType();
    }

    @Override // org.msgpack.value.Value
    public boolean isNumberValue() {
        return getValueType().isNumberType();
    }

    @Override // org.msgpack.value.Value
    public boolean isRawValue() {
        return getValueType().isRawType();
    }

    @Override // org.msgpack.value.Value
    public boolean isStringValue() {
        return getValueType().isStringType();
    }

    @Override // org.msgpack.value.Value
    public boolean isTimestampValue() {
        return false;
    }
}
