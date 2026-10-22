package org.msgpack.value.impl;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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

/* JADX INFO: loaded from: classes3.dex */
public class ImmutableArrayValueImpl extends AbstractImmutableValue implements ImmutableArrayValue {
    private static final ImmutableArrayValueImpl EMPTY = null;
    private final Value[] array;

    private static class ImmutableArrayValueList extends AbstractList<Value> {
        private final Value[] array;

        public ImmutableArrayValueList(Value[] r10) {
            this.array = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public Value get(int r10) {
            return this.array[r10];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array.length;
        }
    }

    private static class Ite implements Iterator<Value> {
        private final Value[] array;
        private int index;

        public Ite(Value[] r10) {
            this.array = r10;
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
            int r10 = this.index;
            Value[] r11 = this.array;
            if (r10 >= r11.length) goto L7;
            this.index = r10 + 1;
            return r11[r10];
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

    public ImmutableArrayValueImpl(Value[] r10) {
        this.array = r10;
    }

    private static void appendString(StringBuilder r10, Value r11) {
        if (r11.isRawValue() == false) goto L5;
        String r12 = r11.toJson();
    L6:
        r10.append(r12);
        return;
    L5:
        r12 = r11.toString();
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
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Value) == true) goto L8;
        return false;
    L8:
        Value r11 = (Value) r10;
        if ((r11 instanceof ImmutableArrayValueImpl) == false) goto L13;
        return Arrays.equals(this.array, ((ImmutableArrayValueImpl) r11).array);
    L13:
        if (r11.isArrayValue() == true) goto L15;
        return false;
    L15:
        ArrayValue r12 = r11.asArrayValue();
        if (size() == r12.size()) goto L18;
        return false;
    L18:
        Iterator<Value> r13 = r12.iterator();
        int r14 = 0;
    L20:
        if (r14 >= this.array.length) goto L28;
        if (r13.hasNext() == false) goto L27;
        if (this.array[r14].equals(r13.next()) == false) goto L27;
        r14 = r14 + 1;
    L27:
        return false;
    L28:
        return true;
    }

    @Override // org.msgpack.value.ArrayValue
    public Value get(int r10) {
        return this.array[r10];
    }

    @Override // org.msgpack.value.ArrayValue
    public Value getOrNilValue(int r10) {
        Value[] r11 = this.array;
        if (r10 >= r11.length) goto L8;
        if (r10 < 0) goto L8;
        return r11[r10];
    L8:
        return ImmutableNilValueImpl.get();
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.ARRAY;
    }

    public int hashCode() {
        int r10 = 1;
        int r11 = 0;
    L3:
        Value[] r12 = this.array;
        if (r11 >= r12.length) goto L6;
        r10 = (r10 * 31) + r12[r11].hashCode();
        r11 = r11 + 1;
        goto L3
    L6:
        return r10;
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
        return "[]";
    L6:
        StringBuilder r10 = new StringBuilder();
        r10.append("[");
        r10.append(this.array[0].toJson());
        int r11 = 1;
    L8:
        if (r11 >= this.array.length) goto L10;
        r10.append(",");
        r10.append(this.array[r11].toJson());
        r11 = r11 + 1;
        goto L8
    L10:
        r10.append("]");
        return r10.toString();
    }

    public String toString() {
        if (this.array.length != 0) goto L6;
        return "[]";
    L6:
        StringBuilder r10 = new StringBuilder();
        r10.append("[");
        appendString(r10, this.array[0]);
        int r11 = 1;
    L8:
        if (r11 >= this.array.length) goto L10;
        r10.append(",");
        appendString(r10, this.array[r11]);
        r11 = r11 + 1;
        goto L8
    L10:
        r10.append("]");
        return r10.toString();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r10) {
        r10.packArrayHeader(this.array.length);
        int r11 = 0;
    L3:
        Value[] r12 = this.array;
        if (r11 >= r12.length) goto L6;
        r12[r11].writeTo(r10);
        r11 = r11 + 1;
        goto L3
    }
}
