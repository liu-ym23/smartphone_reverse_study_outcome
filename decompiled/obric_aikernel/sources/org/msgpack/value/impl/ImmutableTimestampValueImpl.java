package org.msgpack.value.impl;

import java.time.Instant;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.value.ExtensionValue;
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
import org.msgpack.value.TimestampValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes3.dex */
public class ImmutableTimestampValueImpl extends AbstractImmutableValue implements ImmutableExtensionValue, ImmutableTimestampValue {
    private byte[] data;
    private final Instant instant;

    public ImmutableTimestampValueImpl(Instant r10) {
        this.instant = r10;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableArrayValue asArrayValue() {
        return super.asArrayValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableBinaryValue asBinaryValue() {
        return super.asBinaryValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableBooleanValue asBooleanValue() {
        return super.asBooleanValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ExtensionValue asExtensionValue() {
        return asExtensionValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public ImmutableExtensionValue asExtensionValue() {
        return this;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableFloatValue asFloatValue() {
        return super.asFloatValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableIntegerValue asIntegerValue() {
        return super.asIntegerValue();
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
    public /* bridge */ /* synthetic */ ImmutableNumberValue asNumberValue() {
        return super.asNumberValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableRawValue asRawValue() {
        return super.asRawValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableStringValue asStringValue() {
        return super.asStringValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableTimestampValue asTimestampValue() {
        return this;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ TimestampValue asTimestampValue() {
        return asTimestampValue();
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
        if (r11.isExtensionValue() == true) goto L11;
        return false;
    L11:
        ExtensionValue r12 = r11.asExtensionValue();
        if ((r12 instanceof TimestampValue) == false) goto L16;
        return this.instant.equals(((TimestampValue) r12).toInstant());
    L16:
        if ((-1) != r12.getType()) goto L21;
        if (Arrays.equals(getData(), r12.getData()) == false) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // org.msgpack.value.ExtensionValue
    public byte[] getData() {
        if (this.data != null) goto L13;
        long r10 = getEpochSecond();
        int r11 = getNano();
        if ((r10 >>> 34) != 0) goto L10;
        long r12 = (((long) r11) << 34) | r10;
        if (((-4294967296L) & r12) != 0) goto L9;
        byte[] r13 = new byte[4];
        MessageBuffer.wrap(r13).putInt(0, (int) r10);
    L11:
        this.data = r13;
        goto L13
    L9:
        byte[] r14 = new byte[8];
        MessageBuffer.wrap(r14).putLong(0, r12);
        r13 = r14;
        goto L11
    L10:
        byte[] r15 = new byte[12];
        MessageBuffer r16 = MessageBuffer.wrap(r15);
        r16.putInt(0, r11);
        r16.putLong(4, r10);
        r13 = r15;
    L13:
        return this.data;
    }

    @Override // org.msgpack.value.TimestampValue
    public long getEpochSecond() {
        return this.instant.getEpochSecond();
    }

    @Override // org.msgpack.value.TimestampValue
    public int getNano() {
        return this.instant.getNano();
    }

    @Override // org.msgpack.value.ExtensionValue
    public byte getType() {
        return -1;
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.EXTENSION;
    }

    public int hashCode() {
        return this.instant.hashCode();
    }

    @Override // org.msgpack.value.Value
    public ImmutableTimestampValue immutableValue() {
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
    public boolean isTimestampValue() {
        return true;
    }

    @Override // org.msgpack.value.TimestampValue
    public long toEpochMillis() {
        return this.instant.toEpochMilli();
    }

    @Override // org.msgpack.value.TimestampValue
    public Instant toInstant() {
        return this.instant;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        return "\"" + toInstant().toString() + "\"";
    }

    public String toString() {
        return toInstant().toString();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r10) {
        r10.packTimestamp(this.instant);
    }
}
