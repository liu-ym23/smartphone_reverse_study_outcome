package org.msgpack.value.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
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

/* JADX INFO: loaded from: classes7.dex */
public class ImmutableMapValueImpl extends AbstractImmutableValue implements ImmutableMapValue {
    private static final ImmutableMapValueImpl EMPTY = null;
    private final Value[] kvs;

    private static class EntryIterator implements Iterator<Value> {
        private int index;
        private Value[] kvs;

        public EntryIterator(Value[] r1, int r2) {
            this.kvs = r1;
            this.index = r2;
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
            int r0 = this.index;
            Value[] r1 = this.kvs;
            if (r0 >= r1.length) goto L7;
            this.index = r0 + 2;
            return r1[r0];
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

        EntrySet(Value[] r1) {
            this.kvs = r1;
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

        EntrySetIterator(Value[] r1) {
            this.kvs = r1;
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
            int r0 = this.index;
            Value[] r1 = this.kvs;
            if (r0 >= r1.length) goto L7;
            AbstractMap.SimpleImmutableEntry r2 = new AbstractMap.SimpleImmutableEntry(r1[r0], r1[r0 + 1]);
            this.index += 2;
            return r2;
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

        public ImmutableMapValueMap(Value[] r1) {
            this.kvs = r1;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<Value, Value>> entrySet() {
            return new EntrySet(this.kvs);
        }
    }

    private static class KeySet extends AbstractSet<Value> {
        private Value[] kvs;

        KeySet(Value[] r1) {
            this.kvs = r1;
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

        ValueCollection(Value[] r1) {
            this.kvs = r1;
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

    public ImmutableMapValueImpl(Value[] r1) {
        this.kvs = r1;
    }

    private static void appendJsonKey(StringBuilder r2, Value r3) {
        Value r4 = (Value) ZeusTransformUtils.wrapperContextForParams(r3, Value.class, "com.obric.memorydata.plugin");
        if (r4.isRawValue() == false) goto L5;
        r2.append(r4.toJson());
        return;
    L5:
        ImmutableStringValueImpl.appendJsonString(r2, r4.toString());
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
    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, Value.class) == true) goto L8;
        return false;
    L8:
        Value r5 = (Value) ZeusTransformUtils.preCheckCast(r4, Value.class, "com.obric.memorydata.plugin");
        if (r5.isMapValue() == true) goto L11;
        return false;
    L11:
        MapValue r6 = r5.asMapValue();
        return map().equals(r6.map());
    }

    @Override // org.msgpack.value.MapValue
    public Value[] getKeyValueArray() {
        Value[] r2 = this.kvs;
        return (Value[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), Value[].class, "com.obric.memorydata.plugin");
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.MAP;
    }

    public int hashCode() {
        int r0 = 0;
        int r1 = 0;
    L3:
        Value[] r2 = this.kvs;
        if (r0 >= r2.length) goto L6;
        r1 = r1 + (r2[r0].hashCode() ^ this.kvs[r0 + 1].hashCode());
        r0 = r0 + 2;
        goto L3
    L6:
        return r1;
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
        StringBuilder r0 = new StringBuilder();
        r0.append("{");
        appendJsonKey(r0, this.kvs[0]);
        r0.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r0.append(this.kvs[1].toJson());
        int r2 = 2;
    L8:
        if (r2 >= this.kvs.length) goto L10;
        r0.append(",");
        appendJsonKey(r0, this.kvs[r2]);
        r0.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r0.append(this.kvs[r2 + 1].toJson());
        r2 = r2 + 2;
        goto L8
    L10:
        r0.append("}");
        return r0.toString();
    }

    public String toString() {
        if (this.kvs.length != 0) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder();
        r0.append("{");
        appendString(r0, this.kvs[0]);
        r0.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        appendString(r0, this.kvs[1]);
        int r2 = 2;
    L8:
        if (r2 >= this.kvs.length) goto L10;
        r0.append(",");
        appendString(r0, this.kvs[r2]);
        r0.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        appendString(r0, this.kvs[r2 + 1]);
        r2 = r2 + 2;
        goto L8
    L10:
        r0.append("}");
        return r0.toString();
    }

    @Override // org.msgpack.value.MapValue
    public Collection<Value> values() {
        return new ValueCollection(this.kvs);
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r4) {
        r4.packMapHeader(this.kvs.length / 2);
        int r0 = 0;
    L3:
        Value[] r1 = this.kvs;
        if (r0 >= r1.length) goto L6;
        r1[r0].writeTo(r4);
        r0 = r0 + 1;
        goto L3
    }
}
