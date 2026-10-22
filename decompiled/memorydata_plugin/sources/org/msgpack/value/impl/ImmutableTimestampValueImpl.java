package org.msgpack.value.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes7.dex */
public class ImmutableTimestampValueImpl extends AbstractImmutableValue implements ImmutableExtensionValue, ImmutableTimestampValue {
    private byte[] data;
    private final Instant instant;

    public ImmutableTimestampValueImpl(Instant r1) {
        this.instant = r1;
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
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Value.class) == true) goto L8;
        return false;
    L8:
        Value r6 = (Value) ZeusTransformUtils.preCheckCast(r5, Value.class, "com.obric.memorydata.plugin");
        if (r6.isExtensionValue() == true) goto L11;
        return false;
    L11:
        ExtensionValue r7 = r6.asExtensionValue();
        if (ZeusTransformUtils.instanceOf(r7, TimestampValue.class) == false) goto L16;
        TimestampValue r8 = (TimestampValue) ZeusTransformUtils.preCheckCast(r7, TimestampValue.class, "com.obric.memorydata.plugin");
        return this.instant.equals(r8.toInstant());
    L16:
        if ((-1) != r7.getType()) goto L21;
        if (Arrays.equals(getData(), r7.getData()) == false) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // org.msgpack.value.ExtensionValue
    public byte[] getData() {
        if (this.data != null) goto L13;
        long r0 = getEpochSecond();
        int r2 = getNano();
        if ((r0 >>> 34) != 0) goto L10;
        long r3 = (((long) r2) << 34) | r0;
        if (((-4294967296L) & r3) != 0) goto L9;
        byte[] r4 = new byte[4];
        MessageBuffer.wrap(r4).putInt(0, (int) r0);
    L11:
        this.data = r4;
        goto L13
    L9:
        byte[] r1 = new byte[8];
        MessageBuffer.wrap(r1).putLong(0, r3);
        r4 = r1;
        goto L11
    L10:
        byte[] r5 = new byte[12];
        MessageBuffer r6 = MessageBuffer.wrap(r5);
        r6.putInt(0, r2);
        r6.putLong(4, r0);
        r4 = r5;
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
    public void writeTo(MessagePacker r1) {
        r1.packTimestamp(this.instant);
    }
}
