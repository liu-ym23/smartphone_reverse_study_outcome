package org.msgpack.value;

/* JADX INFO: loaded from: classes3.dex */
public interface ImmutableValue extends Value {
    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default ArrayValue asArrayValue() {
        return asArrayValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableArrayValue asArrayValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default BinaryValue asBinaryValue() {
        return asBinaryValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableBinaryValue asBinaryValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default BooleanValue asBooleanValue() {
        return asBooleanValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableBooleanValue asBooleanValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default FloatValue asFloatValue() {
        return asFloatValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableFloatValue asFloatValue();

    @Override // org.msgpack.value.Value
    ImmutableIntegerValue asIntegerValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default IntegerValue asIntegerValue() {
        return asIntegerValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableMapValue asMapValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default MapValue asMapValue() {
        return asMapValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableNilValue asNilValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default NilValue asNilValue() {
        return asNilValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableRawValue asRawValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default RawValue asRawValue() {
        return asRawValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableStringValue asStringValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default StringValue asStringValue() {
        return asStringValue();
    }

    @Override // org.msgpack.value.Value
    ImmutableTimestampValue asTimestampValue();

    @Override // org.msgpack.value.Value
    /* bridge */ /* synthetic */ default TimestampValue asTimestampValue() {
        return asTimestampValue();
    }
}
