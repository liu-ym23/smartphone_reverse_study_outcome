package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM = null;
    static final Charset ISO_8859_1 = null;
    static final Charset US_ASCII = null;
    static final Charset UTF_8 = null;

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean r10);

        boolean getBoolean(int r10);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Boolean> mutableCopyWithCapacity2(int r10) {
            return mutableCopyWithCapacity(r10);
        }

        @CanIgnoreReturnValue
        boolean setBoolean(int r10, boolean r11);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double r10);

        double getDouble(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Double> mutableCopyWithCapacity2(int r10) {
            return mutableCopyWithCapacity(r10);
        }

        @CanIgnoreReturnValue
        double setDouble(int r10, double r11);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r10);
    }

    public interface EnumVerifier {
        boolean isInRange(int r10);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float r10);

        float getFloat(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Float> mutableCopyWithCapacity2(int r10) {
            return mutableCopyWithCapacity(r10);
        }

        @CanIgnoreReturnValue
        float setFloat(int r10, float r11);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int r10);

        int getInt(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Integer> mutableCopyWithCapacity2(int r10) {
            return mutableCopyWithCapacity(r10);
        }

        @CanIgnoreReturnValue
        int setInt(int r10, int r11);
    }

    public static class IntListAdapter<T> extends AbstractList<T> {
        private final IntConverter<T> converter;
        private final IntList fromList;

        public interface IntConverter<T> {
            T convert(int r10);
        }

        public IntListAdapter(IntList r10, IntConverter<T> r11) {
            this.fromList = r10;
            this.converter = r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r10) {
            return this.converter.convert(this.fromList.getInt(r10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F r10);
        }

        public ListAdapter(List<F> r10, Converter<F, T> r11) {
            this.fromList = r10;
            this.converter = r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r10) {
            return (T) this.converter.convert(this.fromList.get(r10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long r10);

        long getLong(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int r10);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Long> mutableCopyWithCapacity2(int r10) {
            return mutableCopyWithCapacity(r10);
        }

        @CanIgnoreReturnValue
        long setLong(int r10, long r11);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        private final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B r10);

            B doForward(A r10);
        }

        private class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;
            final /* synthetic */ MapAdapter this$0;

            public EntryAdapter(MapAdapter r10, Map.Entry<K, RealValue> r11) {
                this.this$0 = r10;
                this.realEntry = r11;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object r10) {
                if (r10 != this) goto L6;
                return true;
            L6:
                if ((r10 instanceof Map.Entry) == true) goto L9;
                return false;
            L9:
                if (getKey().equals(((Map.Entry) r10).getKey()) == false) goto L14;
                if (getValue().equals(getValue()) == false) goto L14;
                return true;
            L14:
                return false;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.realEntry.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.access$000(this.this$0).doForward(this.realEntry.getValue());
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.realEntry.hashCode();
            }

            @Override // java.util.Map.Entry
            public V setValue(V r10) {
                RealValue r11 = this.realEntry.setValue((RealValue) MapAdapter.access$000(this.this$0).doBackward(r10));
                if (r11 != null) goto L7;
                return null;
            L7:
                return (V) MapAdapter.access$000(this.this$0).doForward(r11);
            }
        }

        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;
            final /* synthetic */ MapAdapter this$0;

            public IteratorAdapter(MapAdapter r10, Iterator<Map.Entry<K, RealValue>> r11) {
                this.this$0 = r10;
                this.realIterator = r11;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return next();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.this$0, this.realIterator.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.realIterator.remove();
            }
        }

        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;
            final /* synthetic */ MapAdapter this$0;

            public SetAdapter(MapAdapter r10, Set<Map.Entry<K, RealValue>> r11) {
                this.this$0 = r10;
                this.realSet = r11;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.this$0, this.realSet.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.realSet.size();
            }
        }

        public MapAdapter(Map<K, RealValue> r10, Converter<RealValue, V> r11) {
            this.realMap = r10;
            this.valueConverter = r11;
        }

        static /* synthetic */ Converter access$000(MapAdapter r10) {
            return r10.valueConverter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> r10, final T r11) {
            return (Converter<Integer, T>) new AnonymousClass1(r10, r11);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this, this.realMap.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r10) {
            RealValue r11 = this.realMap.get(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r11);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r10, V r11) {
            RealValue r12 = this.realMap.put(r10, this.valueConverter.doBackward(r11));
            if (r12 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r12);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int r10);
    }

    static {
        US_ASCII = Charset.forName("US-ASCII");
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] r10 = new byte[0];
        EMPTY_BYTE_ARRAY = r10;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r10);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(r10);
    }

    private Internal() {
    }

    public static byte[] byteArrayDefaultValue(String r10) {
        return r10.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String r10) {
        return ByteBuffer.wrap(byteArrayDefaultValue(r10));
    }

    public static ByteString bytesDefaultValue(String r10) {
        return ByteString.copyFrom(r10.getBytes(ISO_8859_1));
    }

    static <T> T checkNotNull(T r10) {
        Objects.requireNonNull(r10);
        return r10;
    }

    static <T> T checkNotNull(T r10, String r11) {
        Objects.requireNonNull(r10, r11);
        return r10;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer r10) {
        ByteBuffer r11 = r10.duplicate();
        r11.clear();
        ByteBuffer r12 = ByteBuffer.allocate(r11.capacity());
        r12.put(r11);
        r12.clear();
        return r12;
    }

    public static boolean equals(List<byte[]> r10, List<byte[]> r11) {
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L12;
        if (Arrays.equals(r10.get(r12), r11.get(r12)) == false) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer r10, ByteBuffer r11) {
        if (r10.capacity() == r11.capacity()) goto L6;
        return false;
    L6:
        ByteBuffer r12 = r10.duplicate();
        Java8Compatibility.clear(r12);
        ByteBuffer r13 = r11.duplicate();
        Java8Compatibility.clear(r13);
        return r12.equals(r13);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> r10, List<ByteBuffer> r11) {
        if (r10.size() == r11.size()) goto L5;
        return false;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= r10.size()) goto L12;
        if (equalsByteBuffer(r10.get(r12), r11.get(r12)) == false) goto L10;
        r12 = r12 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> r10) {
        java.lang.reflect.Method r11 = r10.getMethod("getDefaultInstance", new Class[0]);     // Catch: Exception -> L4
        return (T) r11.invoke(r11, new Object[0]);
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to get default instance for " + r10, e);
    }

    public static int hashBoolean(boolean r10) {
        if (r10 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashCode(List<byte[]> r10) {
        Iterator<byte[]> r11 = r10.iterator();
        int r12 = 1;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = (r12 * 31) + hashCode(r11.next());
        goto L4
    L6:
        return r12;
    }

    public static int hashCode(byte[] r10) {
        return hashCode(r10, 0, r10.length);
    }

    static int hashCode(byte[] r10, int r11, int r12) {
        int r13 = partialHash(r12, r10, r11, r12);
        if (r13 != 0) goto L6;
        return 1;
    L6:
        return r13;
    }

    public static int hashCodeByteBuffer(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L9;
        int r11 = partialHash(r10.capacity(), r10.array(), r10.arrayOffset(), r10.capacity());
        if (r11 != 0) goto L8;
        return 1;
    L8:
        return r11;
    L9:
        int r12 = 4096;
        if (r10.capacity() > 4096) goto L13;
        r12 = r10.capacity();
    L13:
        byte[] r13 = new byte[r12];
        ByteBuffer r14 = r10.duplicate();
        Java8Compatibility.clear(r14);
        int r15 = r10.capacity();
    L15:
        if (r14.remaining() <= 0) goto L21;
        if (r14.remaining() > r12) goto L19;
        int r16 = r14.remaining();
    L20:
        r14.get(r13, 0, r16);
        r15 = partialHash(r15, r13, 0, r16);
        goto L15
    L19:
        r16 = r12;
        goto L20
    L21:
        if (r15 != 0) goto L24;
        return 1;
    L24:
        return r15;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> r10) {
        Iterator<ByteBuffer> r11 = r10.iterator();
        int r12 = 1;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = (r12 * 31) + hashCodeByteBuffer(r11.next());
        goto L4
    L6:
        return r12;
    }

    public static int hashEnum(EnumLite r10) {
        return r10.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> r10) {
        Iterator<? extends EnumLite> r11 = r10.iterator();
        int r12 = 1;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = (r12 * 31) + hashEnum(r11.next());
        goto L4
    L6:
        return r12;
    }

    public static int hashLong(long r10) {
        return (int) (r10 ^ (r10 >>> 32));
    }

    public static boolean isValidUtf8(ByteString r10) {
        return r10.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] r10) {
        return Utf8.isValidUtf8(r10);
    }

    static Object mergeMessage(Object r10, Object r11) {
        return ((MessageLite) r10).toBuilder().mergeFrom((MessageLite) r11).buildPartial();
    }

    static int partialHash(int r10, byte[] r11, int r12, int r13) {
        int r14 = r12;
    L4:
        if (r14 >= (r12 + r13)) goto L6;
        r10 = (r10 * 31) + r11[r14];
        r14 = r14 + 1;
        goto L4
    L6:
        return r10;
    }

    public static String stringDefaultValue(String r10) {
        return new String(r10.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String r10) {
        return r10.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] r10) {
        return new String(r10, UTF_8);
    }
}
