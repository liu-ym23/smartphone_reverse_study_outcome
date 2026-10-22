package org.msgpack.value.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.HttpUrl;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ArrayValue;
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
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes7.dex */
public class ImmutableArrayValueImpl extends AbstractImmutableValue implements ImmutableArrayValue {
    private static final ImmutableArrayValueImpl EMPTY = null;
    private final Value[] array;

    private static class ImmutableArrayValueList extends AbstractList<Value> {
        private final Value[] array;

        public ImmutableArrayValueList(Value[] r1) {
            this.array = r1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public Value get(int r1) {
            return this.array[r1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array.length;
        }
    }

    private static class Ite implements Iterator<Value> {
        private final Value[] array;
        private int index;

        public Ite(Value[] r1) {
            this.array = r1;
            this.index = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index == this.array.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Value next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Value next2() {
            int r0 = this.index;
            Value[] r1 = this.array;
            if (r0 >= r1.length) goto L7;
            this.index = r0 + 1;
            return r1[r0];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        EMPTY = new ImmutableArrayValueImpl(new Value[0]);
    }

    public ImmutableArrayValueImpl(Value[] r1) {
        this.array = r1;
    }

    private static void appendString(StringBuilder r2, Value r3) {
        Value r4 = (Value) ZeusTransformUtils.wrapperContextForParams(r3, Value.class, "com.obric.memorydata.plugin");
        if (r4.isRawValue() == false) goto L5;
        String r5 = r4.toJson();
    L6:
        r2.append(r5);
        return;
    L5:
        r5 = r4.toString();
        goto L6
    }

    public static ImmutableArrayValue empty() {
        return EMPTY;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ArrayValue asArrayValue() {
        return asArrayValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableArrayValue asArrayValue() {
        return this;
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
    public /* bridge */ /* synthetic */ ImmutableExtensionValue asExtensionValue() {
        return super.asExtensionValue();
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
        if (ZeusTransformUtils.instanceOf(r7, ImmutableArrayValueImpl.class) == false) goto L13;
        return Arrays.equals(this.array, ((ImmutableArrayValueImpl) ZeusTransformUtils.preCheckCast(r7, ImmutableArrayValueImpl.class, "com.obric.memorydata.plugin")).array);
    L13:
        if (r7.isArrayValue() == true) goto L15;
        return false;
    L15:
        ArrayValue r8 = r7.asArrayValue();
        if (size() == r8.size()) goto L18;
        return false;
    L18:
        Iterator<Value> r9 = r8.iterator();
        int r0 = 0;
    L20:
        if (r0 >= this.array.length) goto L28;
        if (r9.hasNext() == false) goto L27;
        if (this.array[r0].equals(r9.next()) == false) goto L27;
        r0 = r0 + 1;
    L27:
        return false;
    L28:
        return true;
    }

    @Override // org.msgpack.value.ArrayValue
    public Value get(int r1) {
        return this.array[r1];
    }

    @Override // org.msgpack.value.ArrayValue
    public Value getOrNilValue(int r2) {
        Value[] r1 = this.array;
        if (r2 >= r1.length) goto L8;
        if (r2 < 0) goto L8;
        return r1[r2];
    L8:
        return ImmutableNilValueImpl.get();
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.ARRAY;
    }

    public int hashCode() {
        int r0 = 1;
        int r1 = 0;
    L3:
        Value[] r2 = this.array;
        if (r1 >= r2.length) goto L6;
        r0 = (r0 * 31) + r2[r1].hashCode();
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.msgpack.value.Value
    public ImmutableArrayValue immutableValue() {
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
    public /* bridge */ /* synthetic */ boolean isTimestampValue() {
        return super.isTimestampValue();
    }

    @Override // org.msgpack.value.ImmutableArrayValue, org.msgpack.value.ArrayValue, java.lang.Iterable
    public Iterator<Value> iterator() {
        return new Ite(this.array);
    }

    @Override // org.msgpack.value.ImmutableArrayValue, org.msgpack.value.ArrayValue
    public List<Value> list() {
        return new ImmutableArrayValueList(this.array);
    }

    @Override // org.msgpack.value.ArrayValue
    public int size() {
        return this.array.length;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        if (this.array.length != 0) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        r0.append(this.array[0].toJson());
        int r1 = 1;
    L8:
        if (r1 >= this.array.length) goto L10;
        r0.append(",");
        r0.append(this.array[r1].toJson());
        r1 = r1 + 1;
        goto L8
    L10:
        r0.append("]");
        return r0.toString();
    }

    public String toString() {
        if (this.array.length != 0) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        appendString(r0, this.array[0]);
        int r1 = 1;
    L8:
        if (r1 >= this.array.length) goto L10;
        r0.append(",");
        appendString(r0, this.array[r1]);
        r1 = r1 + 1;
        goto L8
    L10:
        r0.append("]");
        return r0.toString();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r4) {
        r4.packArrayHeader(this.array.length);
        int r0 = 0;
    L3:
        Value[] r1 = this.array;
        if (r0 >= r1.length) goto L6;
        r1[r0].writeTo(r4);
        r0 = r0 + 1;
        goto L3
    }
}
