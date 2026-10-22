package org.msgpack.value;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes7.dex */
public final class ValueFactory {

    public static class MapBuilder {
        private final Map<Value, Value> map;

        public MapBuilder() {
            this.map = new LinkedHashMap();
        }

        public MapValue build() {
            return ValueFactory.newMap(this.map);
        }

        public MapBuilder put(Map.Entry<? extends Value, ? extends Value> r4) {
            Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
            put((Value) ZeusTransformUtils.preCheckCast(r5.getKey(), Value.class, "com.obric.memorydata.plugin"), (Value) ZeusTransformUtils.preCheckCast(r5.getValue(), Value.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public MapBuilder put(Value r3, Value r4) {
            Value r5 = (Value) ZeusTransformUtils.wrapperContextForParams(r3, Value.class, "com.obric.memorydata.plugin");
            Value r6 = (Value) ZeusTransformUtils.wrapperContextForParams(r4, Value.class, "com.obric.memorydata.plugin");
            this.map.put(r5, r6);
            return this;
        }

        public MapBuilder putAll(Iterable<? extends Map.Entry<? extends Value, ? extends Value>> r5) {
            Iterator r6 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            put((Value) ZeusTransformUtils.preCheckCast(r0.getKey(), Value.class, "com.obric.memorydata.plugin"), (Value) ZeusTransformUtils.preCheckCast(r0.getValue(), Value.class, "com.obric.memorydata.plugin"));
            goto L4
        L6:
            return this;
        }

        public MapBuilder putAll(Map<? extends Value, ? extends Value> r4) {
            Iterator r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            put((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
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

    public static ImmutableArrayValue newArray(List<? extends Value> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L7;
        return ImmutableArrayValueImpl.empty();
    L7:
        return new ImmutableArrayValueImpl((Value[]) ZeusTransformUtils.preCheckCast(r3.toArray(new Value[r3.size()]), Value[].class, "com.obric.memorydata.plugin"));
    }

    public static ImmutableArrayValue newArray(Value... r3) {
        if (r3.length != 0) goto L7;
        return ImmutableArrayValueImpl.empty();
    L7:
        return new ImmutableArrayValueImpl((Value[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), Value[].class, "com.obric.memorydata.plugin"));
    }

    public static ImmutableArrayValue newArray(Value[] r2, boolean r3) {
        if (r2.length == 0) goto L5;
        if (r3 == false) goto L10;
        return new ImmutableArrayValueImpl(r2);
    L10:
        return new ImmutableArrayValueImpl((Value[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), Value[].class, "com.obric.memorydata.plugin"));
    L5:
        return ImmutableArrayValueImpl.empty();
    }

    public static ImmutableBinaryValue newBinary(byte[] r1) {
        return newBinary(r1, false);
    }

    public static ImmutableBinaryValue newBinary(byte[] r1, int r2, int r3) {
        return newBinary(r1, r2, r3, false);
    }

    public static ImmutableBinaryValue newBinary(byte[] r0, int r1, int r2, boolean r3) {
        if (r3 == false) goto L9;
        if (r1 != 0) goto L9;
        if (r2 != r0.length) goto L9;
        return new ImmutableBinaryValueImpl(r0);
    L9:
        return new ImmutableBinaryValueImpl(Arrays.copyOfRange(r0, r1, r2));
    }

    public static ImmutableBinaryValue newBinary(byte[] r1, boolean r2) {
        if (r2 == false) goto L6;
        return new ImmutableBinaryValueImpl(r1);
    L6:
        return new ImmutableBinaryValueImpl(Arrays.copyOf(r1, r1.length));
    }

    public static ImmutableBooleanValue newBoolean(boolean r0) {
        if (r0 == false) goto L5;
        return ImmutableBooleanValueImpl.TRUE;
    L5:
        return ImmutableBooleanValueImpl.FALSE;
    }

    public static ImmutableExtensionValue newExtension(byte r1, byte[] r2) {
        return new ImmutableExtensionValueImpl(r1, r2);
    }

    public static ImmutableFloatValue newFloat(double r1) {
        return new ImmutableDoubleValueImpl(r1);
    }

    public static ImmutableFloatValue newFloat(float r3) {
        return new ImmutableDoubleValueImpl(r3);
    }

    public static ImmutableIntegerValue newInteger(byte r3) {
        return new ImmutableLongValueImpl(r3);
    }

    public static ImmutableIntegerValue newInteger(int r3) {
        return new ImmutableLongValueImpl(r3);
    }

    public static ImmutableIntegerValue newInteger(long r1) {
        return new ImmutableLongValueImpl(r1);
    }

    public static ImmutableIntegerValue newInteger(BigInteger r1) {
        return new ImmutableBigIntegerValueImpl(r1);
    }

    public static ImmutableIntegerValue newInteger(short r3) {
        return new ImmutableLongValueImpl(r3);
    }

    public static <K extends Value, V extends Value> ImmutableMapValue newMap(Map<K, V> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Value[] r0 = new Value[r7.size() * 2];
        Iterator r8 = r7.entrySet().iterator();
        int r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L7;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0[r2] = (Value) ZeusTransformUtils.preCheckCast(r3.getKey(), Value.class, "com.obric.memorydata.plugin");
        int r4 = r2 + 1;
        r0[r4] = (Value) ZeusTransformUtils.preCheckCast(r3.getValue(), Value.class, "com.obric.memorydata.plugin");
        r2 = r4 + 1;
        goto L4
    L7:
        return new ImmutableMapValueImpl(r0);
    }

    public static ImmutableMapValue newMap(Value... r3) {
        if (r3.length != 0) goto L7;
        return ImmutableMapValueImpl.empty();
    L7:
        return new ImmutableMapValueImpl((Value[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length), Value[].class, "com.obric.memorydata.plugin"));
    }

    public static ImmutableMapValue newMap(Value[] r2, boolean r3) {
        if (r2.length == 0) goto L5;
        if (r3 == false) goto L10;
        return new ImmutableMapValueImpl(r2);
    L10:
        return new ImmutableMapValueImpl((Value[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length), Value[].class, "com.obric.memorydata.plugin"));
    L5:
        return ImmutableMapValueImpl.empty();
    }

    @SafeVarargs
    public static MapValue newMap(Map.Entry<? extends Value, ? extends Value>... r7) {
        Value[] r0 = new Value[r7.length * 2];
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L7;
        int r2 = r1 * 2;
        r0[r2] = (Value) ZeusTransformUtils.preCheckCast(r7[r1].getKey(), Value.class, "com.obric.memorydata.plugin");
        r0[r2 + 1] = (Value) ZeusTransformUtils.preCheckCast(r7[r1].getValue(), Value.class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
        goto L4
    L7:
        return newMap(r0, true);
    }

    public static MapBuilder newMapBuilder() {
        return new MapBuilder();
    }

    public static Map.Entry<Value, Value> newMapEntry(Value r2, Value r3) {
        return new AbstractMap.SimpleEntry((Value) ZeusTransformUtils.wrapperContextForParams(r2, Value.class, "com.obric.memorydata.plugin"), (Value) ZeusTransformUtils.wrapperContextForParams(r3, Value.class, "com.obric.memorydata.plugin"));
    }

    public static ImmutableNilValue newNil() {
        return ImmutableNilValueImpl.get();
    }

    public static ImmutableStringValue newString(String r1) {
        return new ImmutableStringValueImpl(r1);
    }

    public static ImmutableStringValue newString(byte[] r1) {
        return new ImmutableStringValueImpl(r1);
    }

    public static ImmutableStringValue newString(byte[] r1, int r2, int r3) {
        return newString(r1, r2, r3, false);
    }

    public static ImmutableStringValue newString(byte[] r0, int r1, int r2, boolean r3) {
        if (r3 == false) goto L9;
        if (r1 != 0) goto L9;
        if (r2 != r0.length) goto L9;
        return new ImmutableStringValueImpl(r0);
    L9:
        return new ImmutableStringValueImpl(Arrays.copyOfRange(r0, r1, r2));
    }

    public static ImmutableStringValue newString(byte[] r1, boolean r2) {
        if (r2 == false) goto L6;
        return new ImmutableStringValueImpl(r1);
    L6:
        return new ImmutableStringValueImpl(Arrays.copyOf(r1, r1.length));
    }

    public static ImmutableTimestampValue newTimestamp(long r0) {
        return newTimestamp(Instant.ofEpochMilli(r0));
    }

    public static ImmutableTimestampValue newTimestamp(long r2, int r4) {
        return newTimestamp(Instant.ofEpochSecond(r2, r4));
    }

    public static ImmutableTimestampValue newTimestamp(Instant r1) {
        return new ImmutableTimestampValueImpl(r1);
    }
}
