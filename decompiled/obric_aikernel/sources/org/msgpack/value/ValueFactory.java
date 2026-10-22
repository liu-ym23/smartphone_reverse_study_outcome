package org.msgpack.value;

import java.math.BigInteger;
import java.time.Instant;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.msgpack.value.impl.ImmutableArrayValueImpl;
import org.msgpack.value.impl.ImmutableBigIntegerValueImpl;
import org.msgpack.value.impl.ImmutableBinaryValueImpl;
import org.msgpack.value.impl.ImmutableBooleanValueImpl;
import org.msgpack.value.impl.ImmutableDoubleValueImpl;
import org.msgpack.value.impl.ImmutableExtensionValueImpl;
import org.msgpack.value.impl.ImmutableLongValueImpl;
import org.msgpack.value.impl.ImmutableMapValueImpl;
import org.msgpack.value.impl.ImmutableNilValueImpl;
import org.msgpack.value.impl.ImmutableStringValueImpl;
import org.msgpack.value.impl.ImmutableTimestampValueImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class ValueFactory {

    public static class MapBuilder {
        private final Map<Value, Value> map;

        public MapBuilder() {
            this.map = new LinkedHashMap();
        }

        public MapValue build() {
            return ValueFactory.newMap(this.map);
        }

        public MapBuilder put(Map.Entry<? extends Value, ? extends Value> r10) {
            put(r10.getKey(), r10.getValue());
            return this;
        }

        public MapBuilder put(Value r10, Value r11) {
            this.map.put(r10, r11);
            return this;
        }

        public MapBuilder putAll(Iterable<? extends Map.Entry<? extends Value, ? extends Value>> r10) {
            Iterator<? extends Map.Entry<? extends Value, ? extends Value>> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<? extends Value, ? extends Value> r12 = r11.next();
            put(r12.getKey(), r12.getValue());
            goto L4
        L6:
            return this;
        }

        public MapBuilder putAll(Map<? extends Value, ? extends Value> r10) {
            Iterator<Map.Entry<? extends Value, ? extends Value>> r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            put(r11.next());
            goto L4
        L6:
            return this;
        }
    }

    private ValueFactory() {
    }

    public static ImmutableArrayValue emptyArray() {
        return ImmutableArrayValueImpl.empty();
    }

    public static ImmutableMapValue emptyMap() {
        return ImmutableMapValueImpl.empty();
    }

    public static ImmutableArrayValue newArray(List<? extends Value> r10) {
        if (r10.isEmpty() == false) goto L7;
        return ImmutableArrayValueImpl.empty();
    L7:
        return new ImmutableArrayValueImpl((Value[]) r10.toArray(new Value[r10.size()]));
    }

    public static ImmutableArrayValue newArray(Value... r10) {
        if (r10.length != 0) goto L7;
        return ImmutableArrayValueImpl.empty();
    L7:
        return new ImmutableArrayValueImpl((Value[]) Arrays.copyOf(r10, r10.length));
    }

    public static ImmutableArrayValue newArray(Value[] r10, boolean r11) {
        if (r10.length == 0) goto L5;
        if (r11 == false) goto L10;
        return new ImmutableArrayValueImpl(r10);
    L10:
        return new ImmutableArrayValueImpl((Value[]) Arrays.copyOf(r10, r10.length));
    L5:
        return ImmutableArrayValueImpl.empty();
    }

    public static ImmutableBinaryValue newBinary(byte[] r10) {
        return newBinary(r10, false);
    }

    public static ImmutableBinaryValue newBinary(byte[] r10, int r11, int r12) {
        return newBinary(r10, r11, r12, false);
    }

    public static ImmutableBinaryValue newBinary(byte[] r10, int r11, int r12, boolean r13) {
        if (r13 == false) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != r10.length) goto L9;
        return new ImmutableBinaryValueImpl(r10);
    L9:
        return new ImmutableBinaryValueImpl(Arrays.copyOfRange(r10, r11, r12));
    }

    public static ImmutableBinaryValue newBinary(byte[] r10, boolean r11) {
        if (r11 == false) goto L6;
        return new ImmutableBinaryValueImpl(r10);
    L6:
        return new ImmutableBinaryValueImpl(Arrays.copyOf(r10, r10.length));
    }

    public static ImmutableBooleanValue newBoolean(boolean r10) {
        if (r10 == false) goto L5;
        return ImmutableBooleanValueImpl.TRUE;
    L5:
        return ImmutableBooleanValueImpl.FALSE;
    }

    public static ImmutableExtensionValue newExtension(byte r10, byte[] r11) {
        return new ImmutableExtensionValueImpl(r10, r11);
    }

    public static ImmutableFloatValue newFloat(double r10) {
        return new ImmutableDoubleValueImpl(r10);
    }

    public static ImmutableFloatValue newFloat(float r10) {
        return new ImmutableDoubleValueImpl(r10);
    }

    public static ImmutableIntegerValue newInteger(byte r10) {
        return new ImmutableLongValueImpl(r10);
    }

    public static ImmutableIntegerValue newInteger(int r10) {
        return new ImmutableLongValueImpl(r10);
    }

    public static ImmutableIntegerValue newInteger(long r10) {
        return new ImmutableLongValueImpl(r10);
    }

    public static ImmutableIntegerValue newInteger(BigInteger r10) {
        return new ImmutableBigIntegerValueImpl(r10);
    }

    public static ImmutableIntegerValue newInteger(short r10) {
        return new ImmutableLongValueImpl(r10);
    }

    public static <K extends Value, V extends Value> ImmutableMapValue newMap(Map<K, V> r10) {
        Value[] r11 = new Value[r10.size() * 2];
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L7;
        Map.Entry<K, V> r14 = r12.next();
        r11[r13] = r14.getKey();
        int r15 = r13 + 1;
        r11[r15] = r14.getValue();
        r13 = r15 + 1;
        goto L4
    L7:
        return new ImmutableMapValueImpl(r11);
    }

    public static ImmutableMapValue newMap(Value... r10) {
        if (r10.length != 0) goto L7;
        return ImmutableMapValueImpl.empty();
    L7:
        return new ImmutableMapValueImpl((Value[]) Arrays.copyOf(r10, r10.length));
    }

    public static ImmutableMapValue newMap(Value[] r10, boolean r11) {
        if (r10.length == 0) goto L5;
        if (r11 == false) goto L10;
        return new ImmutableMapValueImpl(r10);
    L10:
        return new ImmutableMapValueImpl((Value[]) Arrays.copyOf(r10, r10.length));
    L5:
        return ImmutableMapValueImpl.empty();
    }

    @SafeVarargs
    public static MapValue newMap(Map.Entry<? extends Value, ? extends Value>... r10) {
        Value[] r11 = new Value[r10.length * 2];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        int r13 = r12 * 2;
        r11[r13] = r10[r12].getKey();
        r11[r13 + 1] = r10[r12].getValue();
        r12 = r12 + 1;
        goto L4
    L7:
        return newMap(r11, true);
    }

    public static MapBuilder newMapBuilder() {
        return new MapBuilder();
    }

    public static Map.Entry<Value, Value> newMapEntry(Value r10, Value r11) {
        return new AbstractMap.SimpleEntry(r10, r11);
    }

    public static ImmutableNilValue newNil() {
        return ImmutableNilValueImpl.get();
    }

    public static ImmutableStringValue newString(String r10) {
        return new ImmutableStringValueImpl(r10);
    }

    public static ImmutableStringValue newString(byte[] r10) {
        return new ImmutableStringValueImpl(r10);
    }

    public static ImmutableStringValue newString(byte[] r10, int r11, int r12) {
        return newString(r10, r11, r12, false);
    }

    public static ImmutableStringValue newString(byte[] r10, int r11, int r12, boolean r13) {
        if (r13 == false) goto L9;
        if (r11 != 0) goto L9;
        if (r12 != r10.length) goto L9;
        return new ImmutableStringValueImpl(r10);
    L9:
        return new ImmutableStringValueImpl(Arrays.copyOfRange(r10, r11, r12));
    }

    public static ImmutableStringValue newString(byte[] r10, boolean r11) {
        if (r11 == false) goto L6;
        return new ImmutableStringValueImpl(r10);
    L6:
        return new ImmutableStringValueImpl(Arrays.copyOf(r10, r10.length));
    }

    public static ImmutableTimestampValue newTimestamp(long r10) {
        return newTimestamp(Instant.ofEpochMilli(r10));
    }

    public static ImmutableTimestampValue newTimestamp(long r10, int r11) {
        return newTimestamp(Instant.ofEpochSecond(r10, r11));
    }

    public static ImmutableTimestampValue newTimestamp(Instant r10) {
        return new ImmutableTimestampValueImpl(r10);
    }
}
