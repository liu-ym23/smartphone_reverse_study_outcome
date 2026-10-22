package org.msgpack.value.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessageIntegerOverflowException;
import org.msgpack.core.MessagePacker;
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
import org.msgpack.value.NumberValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes7.dex */
public class ImmutableLongValueImpl extends AbstractImmutableValue implements ImmutableIntegerValue {
    private static final long BYTE_MAX = 127;
    private static final long BYTE_MIN = -128;
    private static final long INT_MAX = 2147483647L;
    private static final long INT_MIN = -2147483648L;
    private static final long SHORT_MAX = 32767;
    private static final long SHORT_MIN = -32768;
    private final long value;

    public ImmutableLongValueImpl(long r1) {
        this.value = r1;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableArrayValue asArrayValue() {
        return super.asArrayValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public BigInteger asBigInteger() {
        return BigInteger.valueOf(this.value);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableBinaryValue asBinaryValue() {
        return super.asBinaryValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableBooleanValue asBooleanValue() {
        return super.asBooleanValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public byte asByte() {
        if (isInByteRange() == false) goto L7;
        return (byte) this.value;
    L7:
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableExtensionValue asExtensionValue() {
        return super.asExtensionValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableFloatValue asFloatValue() {
        return super.asFloatValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public int asInt() {
        if (isInIntRange() == false) goto L7;
        return (int) this.value;
    L7:
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableIntegerValue asIntegerValue() {
        return this;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ IntegerValue asIntegerValue() {
        return asIntegerValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public long asLong() {
        return this.value;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableMapValue asMapValue() {
        return super.asMapValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableNilValue asNilValue() {
        return super.asNilValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public ImmutableNumberValue asNumberValue() {
        return this;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ NumberValue asNumberValue() {
        return asNumberValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableRawValue asRawValue() {
        return super.asRawValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public short asShort() {
        if (isInShortRange() == false) goto L7;
        return (short) this.value;
    L7:
        throw new MessageIntegerOverflowException(this.value);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableStringValue asStringValue() {
        return super.asStringValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableTimestampValue asTimestampValue() {
        return super.asTimestampValue();
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object r6) {
        if (r6 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, Value.class) == true) goto L8;
        return false;
    L8:
        Value r7 = (Value) ZeusTransformUtils.preCheckCast(r6, Value.class, "com.obric.memorydata.plugin");
        if (r7.isIntegerValue() == true) goto L11;
        return false;
    L11:
        IntegerValue r8 = r7.asIntegerValue();
        if (r8.isInLongRange() == true) goto L15;
        return false;
    L15:
        if (this.value != r8.toLong()) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.INTEGER;
    }

    public int hashCode() {
        long r0 = this.value;
        if (INT_MIN > r0) goto L9;
        if (r0 > INT_MAX) goto L9;
        return (int) r0;
    L9:
        return (int) (r0 ^ (r0 >>> 32));
    }

    @Override // org.msgpack.value.Value
    public ImmutableIntegerValue immutableValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
        return immutableValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isArrayValue() {
        return super.isArrayValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isBinaryValue() {
        return super.isBinaryValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isBooleanValue() {
        return super.isBooleanValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isExtensionValue() {
        return super.isExtensionValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isFloatValue() {
        return super.isFloatValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInByteRange() {
        long r0 = this.value;
        if (BYTE_MIN <= r0) goto L5;
    L7:
        return false;
    L5:
        if (r0 > BYTE_MAX) goto L7;
        return true;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInIntRange() {
        long r0 = this.value;
        if (INT_MIN <= r0) goto L5;
    L7:
        return false;
    L5:
        if (r0 > INT_MAX) goto L7;
        return true;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInLongRange() {
        return true;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInShortRange() {
        long r0 = this.value;
        if (SHORT_MIN <= r0) goto L5;
    L7:
        return false;
    L5:
        if (r0 > SHORT_MAX) goto L7;
        return true;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isIntegerValue() {
        return super.isIntegerValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isMapValue() {
        return super.isMapValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isNilValue() {
        return super.isNilValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isNumberValue() {
        return super.isNumberValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isRawValue() {
        return super.isRawValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isStringValue() {
        return super.isStringValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isTimestampValue() {
        return super.isTimestampValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public MessageFormat mostSuccinctMessageFormat() {
        return ImmutableBigIntegerValueImpl.mostSuccinctMessageFormat(this);
    }

    @Override // org.msgpack.value.NumberValue
    public BigInteger toBigInteger() {
        return BigInteger.valueOf(this.value);
    }

    @Override // org.msgpack.value.NumberValue
    public byte toByte() {
        return (byte) this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public double toDouble() {
        return this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public float toFloat() {
        return this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public int toInt() {
        return (int) this.value;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        return Long.toString(this.value);
    }

    @Override // org.msgpack.value.NumberValue
    public long toLong() {
        return this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public short toShort() {
        return (short) this.value;
    }

    public String toString() {
        return toJson();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r3) {
        r3.packLong(this.value);
    }
}
