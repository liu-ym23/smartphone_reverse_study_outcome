package org.msgpack.value.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.BinaryValue;
import org.msgpack.value.ImmutableBinaryValue;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes7.dex */
public class ImmutableBinaryValueImpl extends AbstractImmutableRawValue implements ImmutableBinaryValue {
    public ImmutableBinaryValueImpl(byte[] r1) {
        super(r1);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ BinaryValue asBinaryValue() {
        return asBinaryValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableRawValue, org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableBinaryValue asBinaryValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object r5) {
        if (this != r5) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, Value.class) == true) goto L9;
        return false;
    L9:
        Value r6 = (Value) ZeusTransformUtils.preCheckCast(r5, Value.class, "com.obric.memorydata.plugin");
        if (r6.isBinaryValue() == true) goto L13;
        return false;
    L13:
        if (ZeusTransformUtils.instanceOf(r6, ImmutableBinaryValueImpl.class) == false) goto L17;
        ImmutableBinaryValueImpl r7 = (ImmutableBinaryValueImpl) ZeusTransformUtils.preCheckCast(r6, ImmutableBinaryValueImpl.class, "com.obric.memorydata.plugin");
        return Arrays.equals(this.data, r7.data);
    L17:
        return Arrays.equals(this.data, r6.asBinaryValue().asByteArray());
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.BINARY;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    @Override // org.msgpack.value.Value
    public ImmutableBinaryValue immutableValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
        return immutableValue();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r2) {
        r2.packBinaryHeader(this.data.length);
        r2.writePayload(this.data);
    }
}
