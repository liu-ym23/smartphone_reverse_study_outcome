package org.msgpack.value.impl;

import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.StringValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes3.dex */
public class ImmutableStringValueImpl extends AbstractImmutableRawValue implements ImmutableStringValue {
    public ImmutableStringValueImpl(String r10) {
        super(r10);
    }

    public ImmutableStringValueImpl(byte[] r10) {
        super(r10);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableRawValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableStringValue asStringValue() {
        return this;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ StringValue asStringValue() {
        return asStringValue();
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Value) == true) goto L8;
        return false;
    L8:
        Value r11 = (Value) r10;
        if (r11.isStringValue() == true) goto L12;
        return false;
    L12:
        if ((r11 instanceof ImmutableStringValueImpl) == false) goto L16;
        return Arrays.equals(this.data, ((ImmutableStringValueImpl) r11).data);
    L16:
        return Arrays.equals(this.data, r11.asStringValue().asByteArray());
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.STRING;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    @Override // org.msgpack.value.Value
    public ImmutableStringValue immutableValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
        return immutableValue();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r10) {
        r10.packRawStringHeader(this.data.length);
        r10.writePayload(this.data);
    }
}
