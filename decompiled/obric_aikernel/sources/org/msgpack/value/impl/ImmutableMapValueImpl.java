package org.msgpack.value.impl;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
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
import org.msgpack.value.MapValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

/* JADX INFO: loaded from: classes3.dex */
public class ImmutableMapValueImpl extends AbstractImmutableValue implements ImmutableMapValue {
    private static final ImmutableMapValueImpl EMPTY = null;
    private final Value[] kvs;

    private static class EntryIterator implements Iterator<Value> {
        private int index;
        private Value[] kvs;

        public EntryIterator(Value[] r10, int r11) {
            this.kvs = r10;
            this.index = r11;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.kvs.length) goto L5;
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
            Value[] r11 = this.kvs;
            if (r10 >= r11.length) goto L7;
            this.index = r10 + 2;
            return r11[r10];
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Value, Value>> {
        private final Value[] kvs;

        EntrySet(Value[] r10) {
            this.kvs = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Value, Value>> iterator() {
            return new EntrySetIterator(this.kvs);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.kvs.length / 2;
        }
    }

    private static class EntrySetIterator implements Iterator<Map.Entry<Value, Value>> {
        private int index;
        private final Value[] kvs;

        EntrySetIterator(Value[] r10) {
            this.kvs = r10;
            this.index = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.kvs.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Map.Entry<Value, Value> next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Map.Entry<Value, Value> next2() {
            int r10 = this.index;
            Value[] r11 = this.kvs;
            if (r10 >= r11.length) goto L7;
            AbstractMap.SimpleImmutableEntry r12 = new AbstractMap.SimpleImmutableEntry(r11[r10], r11[r10 + 1]);
            this.index += 2;
            return r12;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class ImmutableMapValueMap extends AbstractMap<Value, Value> {
        private final Value[] kvs;

        public ImmutableMapValueMap(Value[] r10) {
            this.kvs = r10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Value, Value>> entrySet() {
            return new EntrySet(this.kvs);
        }
    }

    private static class KeySet extends AbstractSet<Value> {
        private Value[] kvs;

        KeySet(Value[] r10) {
            this.kvs = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Value> iterator() {
            return new EntryIterator(this.kvs, 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.kvs.length / 2;
        }
    }

    private static class ValueCollection extends AbstractCollection<Value> {
        private Value[] kvs;

        ValueCollection(Value[] r10) {
            this.kvs = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Value> iterator() {
            return new EntryIterator(this.kvs, 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.kvs.length / 2;
        }
    }

    static {
        EMPTY = new ImmutableMapValueImpl(new Value[0]);
    }

    public ImmutableMapValueImpl(Value[] r10) {
        this.kvs = r10;
    }

    private static void appendJsonKey(StringBuilder r10, Value r11) {
        if (r11.isRawValue() == false) goto L5;
        r10.append(r11.toJson());
        return;
    L5:
        AbstractImmutableRawValue.appendJsonString(r10, r11.toString());
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

    public static ImmutableMapValue empty() {
        return EMPTY;
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
    public ImmutableMapValue asMapValue() {
        return this;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ MapValue asMapValue() {
        return asMapValue();
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

    @Override // org.msgpack.value.MapValue
    public Set<Map.Entry<Value, Value>> entrySet() {
        return new EntrySet(this.kvs);
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
        if (r11.isMapValue() == true) goto L11;
        return false;
    L11:
        MapValue r12 = r11.asMapValue();
        return map().equals(r12.map());
    }

    @Override // org.msgpack.value.MapValue
    public Value[] getKeyValueArray() {
        Value[] r10 = this.kvs;
        return (Value[]) Arrays.copyOf(r10, r10.length);
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.MAP;
    }

    public int hashCode() {
        int r10 = 0;
        int r11 = 0;
    L3:
        Value[] r12 = this.kvs;
        if (r10 >= r12.length) goto L6;
        r11 = r11 + (r12[r10].hashCode() ^ this.kvs[r10 + 1].hashCode());
        r10 = r10 + 2;
        goto L3
    L6:
        return r11;
    }

    @Override // org.msgpack.value.Value
    public ImmutableMapValue immutableValue() {
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

    @Override // org.msgpack.value.MapValue
    public Set<Value> keySet() {
        return new KeySet(this.kvs);
    }

    @Override // org.msgpack.value.MapValue
    public Map<Value, Value> map() {
        return new ImmutableMapValueMap(this.kvs);
    }

    @Override // org.msgpack.value.MapValue
    public int size() {
        return this.kvs.length / 2;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        if (this.kvs.length != 0) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder();
        r10.append("{");
        appendJsonKey(r10, this.kvs[0]);
        r10.append(":");
        r10.append(this.kvs[1].toJson());
        int r11 = 2;
    L8:
        if (r11 >= this.kvs.length) goto L10;
        r10.append(",");
        appendJsonKey(r10, this.kvs[r11]);
        r10.append(":");
        r10.append(this.kvs[r11 + 1].toJson());
        r11 = r11 + 2;
        goto L8
    L10:
        r10.append("}");
        return r10.toString();
    }

    public String toString() {
        if (this.kvs.length != 0) goto L6;
        return "{}";
    L6:
        StringBuilder r10 = new StringBuilder();
        r10.append("{");
        appendString(r10, this.kvs[0]);
        r10.append(":");
        appendString(r10, this.kvs[1]);
        int r11 = 2;
    L8:
        if (r11 >= this.kvs.length) goto L10;
        r10.append(",");
        appendString(r10, this.kvs[r11]);
        r10.append(":");
        appendString(r10, this.kvs[r11 + 1]);
        r11 = r11 + 2;
        goto L8
    L10:
        r10.append("}");
        return r10.toString();
    }

    @Override // org.msgpack.value.MapValue
    public Collection<Value> values() {
        return new ValueCollection(this.kvs);
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r10) {
        r10.packMapHeader(this.kvs.length / 2);
        int r11 = 0;
    L3:
        Value[] r12 = this.kvs;
        if (r11 >= r12.length) goto L6;
        r12[r11].writeTo(r10);
        r11 = r11 + 1;
        goto L3
    }
}
