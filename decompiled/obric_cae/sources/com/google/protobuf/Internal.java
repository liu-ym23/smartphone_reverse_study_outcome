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
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM = null;
    static final Charset ISO_8859_1 = null;
    static final Charset UTF_8 = null;

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean r8);

        boolean getBoolean(int r8);

        @Override // 
        ProtobufList<Boolean> mutableCopyWithCapacity(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Boolean> mutableCopyWithCapacity2(int r8) {
            return mutableCopyWithCapacity(r8);
        }

        @CanIgnoreReturnValue
        boolean setBoolean(int r8, boolean r10);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double r8);

        double getDouble(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Double> mutableCopyWithCapacity(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Double> mutableCopyWithCapacity2(int r8) {
            return mutableCopyWithCapacity(r8);
        }

        @CanIgnoreReturnValue
        double setDouble(int r8, double r10);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r8);
    }

    public interface EnumVerifier {
        boolean isInRange(int r8);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float r8);

        float getFloat(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Float> mutableCopyWithCapacity(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Float> mutableCopyWithCapacity2(int r8) {
            return mutableCopyWithCapacity(r8);
        }

        @CanIgnoreReturnValue
        float setFloat(int r8, float r10);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int r8);

        int getInt(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Integer> mutableCopyWithCapacity(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Integer> mutableCopyWithCapacity2(int r8) {
            return mutableCopyWithCapacity(r8);
        }

        @CanIgnoreReturnValue
        int setInt(int r8, int r10);
    }

    public static class IntListAdapter<T> extends AbstractList<T> {
        private final IntConverter<T> converter;
        private final IntList fromList;

        public interface IntConverter<T> {
            T convert(int r8);
        }

        public IntListAdapter(IntList r8, IntConverter<T> r10) {
            this.fromList = r8;
            this.converter = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r8) {
            return this.converter.convert(this.fromList.getInt(r8));
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
            T convert(F r8);
        }

        public ListAdapter(List<F> r8, Converter<F, T> r10) {
            this.fromList = r8;
            this.converter = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r8) {
            return (T) this.converter.convert(this.fromList.get(r8));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long r8);

        long getLong(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        ProtobufList<Long> mutableCopyWithCapacity(int r8);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
        /* JADX INFO: renamed from: mutableCopyWithCapacity, reason: avoid collision after fix types in other method */
        /* bridge */ /* synthetic */ default ProtobufList<Long> mutableCopyWithCapacity2(int r8) {
            return mutableCopyWithCapacity(r8);
        }

        @CanIgnoreReturnValue
        long setLong(int r8, long r10);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        private final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B r8);

            B doForward(A r8);
        }

        public class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;
            final /* synthetic */ MapAdapter this$0;

            public EntryAdapter(MapAdapter r8, Map.Entry<K, RealValue> r10) {
                this.this$0 = r8;
                this.realEntry = r10;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object r8) {
                if (r8 != this) goto L6;
                return true;
            L6:
                if ((r8 instanceof Map.Entry) == true) goto L9;
                return false;
            L9:
                if (getKey().equals(((Map.Entry) r8).getKey()) == false) goto L14;
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
            public V setValue(V r8) {
                RealValue r10 = this.realEntry.setValue((RealValue) MapAdapter.access$000(this.this$0).doBackward(r8));
                if (r10 != null) goto L7;
                return null;
            L7:
                return (V) MapAdapter.access$000(this.this$0).doForward(r10);
            }
        }

        public class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;
            final /* synthetic */ MapAdapter this$0;

            public IteratorAdapter(MapAdapter r8, Iterator<Map.Entry<K, RealValue>> r10) {
                this.this$0 = r8;
                this.realIterator = r10;
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
            public void remove() {
                this.realIterator.remove();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.this$0, this.realIterator.next());
            }
        }

        public class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;
            final /* synthetic */ MapAdapter this$0;

            public SetAdapter(MapAdapter r8, Set<Map.Entry<K, RealValue>> r10) {
                this.this$0 = r8;
                this.realSet = r10;
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

        public MapAdapter(Map<K, RealValue> r8, Converter<RealValue, V> r10) {
            this.realMap = r8;
            this.valueConverter = r10;
        }

        public static /* synthetic */ Converter access$000(MapAdapter r8) {
            return r8.valueConverter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> r8, final T r10) {
            return (Converter<Integer, T>) new AnonymousClass1(r8, r10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this, this.realMap.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r8) {
            RealValue r10 = this.realMap.get(r8);
            if (r10 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.AbstractMap, java.util.Map
        public V put(K r8, V r10) {
            RealValue r11 = this.realMap.put(r8, this.valueConverter.doBackward(r10));
            if (r11 != null) goto L7;
            return null;
        L7:
            return this.valueConverter.doForward(r11);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int r8);
    }

    static {
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        byte[] r8 = new byte[0];
        EMPTY_BYTE_ARRAY = r8;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r8);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(r8);
    }

    private Internal() {
    }

    public static byte[] byteArrayDefaultValue(String r8) {
        return r8.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String r8) {
        return ByteBuffer.wrap(byteArrayDefaultValue(r8));
    }

    public static ByteString bytesDefaultValue(String r8) {
        return ByteString.copyFrom(r8.getBytes(ISO_8859_1));
    }

    public static <T> T checkNotNull(T r8) {
        if (r8 == null) goto L5;
        return r8;
    L5:
        throw null;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer r8) {
        ByteBuffer r10 = r8.duplicate();
        r10.clear();
        ByteBuffer r11 = ByteBuffer.allocate(r10.capacity());
        r11.put(r10);
        r11.clear();
        return r11;
    }

    public static boolean equals(List<byte[]> r8, List<byte[]> r10) {
        if (r8.size() == r10.size()) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r8.size()) goto L12;
        if (Arrays.equals(r8.get(r11), r10.get(r11)) == false) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer r8, ByteBuffer r10) {
        if (r8.capacity() == r10.capacity()) goto L6;
        return false;
    L6:
        ByteBuffer r11 = r8.duplicate();
        Java8Compatibility.clear(r11);
        ByteBuffer r12 = r10.duplicate();
        Java8Compatibility.clear(r12);
        return r11.equals(r12);
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> r8) {
        java.lang.reflect.Method r10 = r8.getMethod("getDefaultInstance", new Class[0]);     // Catch: Exception -> L4
        return (T) r10.invoke(r10, new Object[0]);
    L4:
        e = move-exception;
        throw new RuntimeException("Failed to get default instance for " + r8, e);
    }

    public static int hashBoolean(boolean r8) {
        if (r8 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashCode(List<byte[]> r8) {
        Iterator<byte[]> r10 = r8.iterator();
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = (r11 * 31) + hashCode(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static int hashCodeByteBuffer(ByteBuffer r8) {
        if (r8.hasArray() == false) goto L9;
        int r10 = partialHash(r8.capacity(), r8.array(), r8.arrayOffset(), r8.capacity());
        if (r10 != 0) goto L8;
        return 1;
    L8:
        return r10;
    L9:
        int r11 = 4096;
        if (r8.capacity() > 4096) goto L13;
        r11 = r8.capacity();
    L13:
        byte[] r12 = new byte[r11];
        ByteBuffer r13 = r8.duplicate();
        Java8Compatibility.clear(r13);
        int r14 = r8.capacity();
    L15:
        if (r13.remaining() <= 0) goto L21;
        if (r13.remaining() > r11) goto L19;
        int r15 = r13.remaining();
    L20:
        r13.get(r12, 0, r15);
        r14 = partialHash(r14, r12, 0, r15);
        goto L15
    L19:
        r15 = r11;
        goto L20
    L21:
        if (r14 != 0) goto L24;
        return 1;
    L24:
        return r14;
    }

    public static int hashEnum(EnumLite r8) {
        return r8.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> r8) {
        Iterator<? extends EnumLite> r10 = r8.iterator();
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = (r11 * 31) + hashEnum(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static int hashLong(long r8) {
        return (int) (r8 ^ (r8 >>> 32));
    }

    public static boolean isValidUtf8(ByteString r8) {
        return r8.isValidUtf8();
    }

    public static Object mergeMessage(Object r8, Object r10) {
        return ((MessageLite) r8).toBuilder().mergeFrom((MessageLite) r10).buildPartial();
    }

    public static int partialHash(int r8, byte[] r10, int r11, int r12) {
        int r13 = r11;
    L4:
        if (r13 >= (r11 + r12)) goto L6;
        r8 = (r8 * 31) + r10[r13];
        r13 = r13 + 1;
        goto L4
    L6:
        return r8;
    }

    public static String stringDefaultValue(String r8) {
        return new String(r8.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String r8) {
        return r8.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] r8) {
        return new String(r8, UTF_8);
    }

    public static <T> T checkNotNull(T r8, String r10) {
        if (r8 == null) goto L5;
        return r8;
    L5:
        throw new NullPointerException(r10);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> r8, List<ByteBuffer> r10) {
        if (r8.size() == r10.size()) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r8.size()) goto L12;
        if (equalsByteBuffer(r8.get(r11), r10.get(r11)) == false) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCode(byte[] r8) {
        return hashCode(r8, 0, r8.length);
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> r8) {
        Iterator<ByteBuffer> r10 = r8.iterator();
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = (r11 * 31) + hashCodeByteBuffer(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static boolean isValidUtf8(byte[] r8) {
        return Utf8.isValidUtf8(r8);
    }

    public static int hashCode(byte[] r8, int r10, int r11) {
        int r12 = partialHash(r11, r8, r10, r11);
        if (r12 != 0) goto L6;
        return 1;
    L6:
        return r12;
    }
}
