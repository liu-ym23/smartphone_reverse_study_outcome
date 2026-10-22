package org.msgpack.value.impl;

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

/* JADX INFO: loaded from: classes3.dex */
public class ImmutableBigIntegerValueImpl extends AbstractImmutableValue implements ImmutableIntegerValue {
    private static final BigInteger BYTE_MAX = null;
    private static final BigInteger BYTE_MIN = null;
    private static final BigInteger INT_MAX = null;
    private static final BigInteger INT_MIN = null;
    private static final BigInteger LONG_MAX = null;
    private static final BigInteger LONG_MIN = null;
    private static final BigInteger SHORT_MAX = null;
    private static final BigInteger SHORT_MIN = null;
    private final BigInteger value;

    static {
        BYTE_MIN = BigInteger.valueOf(-128);
        BYTE_MAX = BigInteger.valueOf(127);
        SHORT_MIN = BigInteger.valueOf(-32768);
        SHORT_MAX = BigInteger.valueOf(32767);
        INT_MIN = BigInteger.valueOf(-2147483648L);
        INT_MAX = BigInteger.valueOf(2147483647L);
        LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
        LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    }

    public ImmutableBigIntegerValueImpl(BigInteger r10) {
        this.value = r10;
    }

    public static MessageFormat mostSuccinctMessageFormat(IntegerValue r10) {
        if (r10.isInByteRange() == false) goto L7;
        return MessageFormat.INT8;
    L7:
        if (r10.isInShortRange() == false) goto L11;
        return MessageFormat.INT16;
    L11:
        if (r10.isInIntRange() == false) goto L15;
        return MessageFormat.INT32;
    L15:
        if (r10.isInLongRange() == false) goto L19;
        return MessageFormat.INT64;
    L19:
        return MessageFormat.UINT64;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableArrayValue asArrayValue() {
        return super.asArrayValue();
    }

    @Override // org.msgpack.value.IntegerValue
    public BigInteger asBigInteger() {
        return this.value;
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
        return this.value.byteValue();
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
        return this.value.intValue();
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
        if (isInLongRange() == false) goto L7;
        return this.value.longValue();
    L7:
        throw new MessageIntegerOverflowException(this.value);
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
        return this.value.shortValue();
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
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Value) == true) goto L8;
        return false;
    L8:
        Value r11 = (Value) r10;
        if (r11.isIntegerValue() == true) goto L11;
        return false;
    L11:
        IntegerValue r12 = r11.asIntegerValue();
        return this.value.equals(r12.toBigInteger());
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.INTEGER;
    }

    public int hashCode() {
        if (INT_MIN.compareTo(this.value) > 0) goto L9;
        if (this.value.compareTo(INT_MAX) > 0) goto L9;
        return (int) this.value.longValue();
    L9:
        if (LONG_MIN.compareTo(this.value) > 0) goto L15;
        if (this.value.compareTo(LONG_MAX) > 0) goto L15;
        long r10 = this.value.longValue();
        return (int) (r10 ^ (r10 >>> 32));
    L15:
        return this.value.hashCode();
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
        if (this.value.compareTo(BYTE_MIN) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.value.compareTo(BYTE_MAX) > 0) goto L7;
        return true;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInIntRange() {
        if (this.value.compareTo(INT_MIN) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.value.compareTo(INT_MAX) > 0) goto L7;
        return true;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInLongRange() {
        if (this.value.compareTo(LONG_MIN) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.value.compareTo(LONG_MAX) > 0) goto L7;
        return true;
    }

    @Override // org.msgpack.value.IntegerValue
    public boolean isInShortRange() {
        if (this.value.compareTo(SHORT_MIN) >= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.value.compareTo(SHORT_MAX) > 0) goto L7;
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
        return mostSuccinctMessageFormat(this);
    }

    @Override // org.msgpack.value.NumberValue
    public BigInteger toBigInteger() {
        return this.value;
    }

    @Override // org.msgpack.value.NumberValue
    public byte toByte() {
        return this.value.byteValue();
    }

    @Override // org.msgpack.value.NumberValue
    public double toDouble() {
        return this.value.doubleValue();
    }

    @Override // org.msgpack.value.NumberValue
    public float toFloat() {
        return this.value.floatValue();
    }

    @Override // org.msgpack.value.NumberValue
    public int toInt() {
        return this.value.intValue();
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        return this.value.toString();
    }

    @Override // org.msgpack.value.NumberValue
    public long toLong() {
        return this.value.longValue();
    }

    @Override // org.msgpack.value.NumberValue
    public short toShort() {
        return this.value.shortValue();
    }

    public String toString() {
        return toJson();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r10) {
        r10.packBigInteger(this.value);
    }
}
