package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MapField<K, V> extends MapFieldReflectionAccessor implements MutabilityOracle {
    private final Converter<K, V> converter;
    private volatile boolean isMutable;
    private List<Message> listData;
    private MutabilityAwareMap<K, V> mapData;
    private volatile StorageMode mode;

    private interface Converter<K, V> {
        Message convertKeyAndValueToMessage(K r10, V r11);

        void convertMessageToKeyAndValue(Message r10, Map<K, V> r11);

        Message getMessageDefaultInstance();
    }

    private static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
        private final MapEntry<K, V> defaultEntry;

        public ImmutableMessageConverter(MapEntry<K, V> r10) {
            this.defaultEntry = r10;
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message convertKeyAndValueToMessage(K r10, V r11) {
            return this.defaultEntry.newBuilderForType().setKey(r10).setValue(r11).buildPartial();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.Converter
        public void convertMessageToKeyAndValue(Message r10, Map<K, V> r11) {
            MapEntry r12 = (MapEntry) r10;
            r11.put(r12.getKey(), r12.getValue());
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }
    }

    static class MutabilityAwareMap<K, V> implements Map<K, V> {
        private final Map<K, V> delegate;
        private final MutabilityOracle mutabilityOracle;

        private static class MutabilityAwareCollection<E> implements Collection<E> {
            private final Collection<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            MutabilityAwareCollection(MutabilityOracle r10, Collection<E> r11) {
                this.mutabilityOracle = r10;
                this.delegate = r11;
            }

            @Override // java.util.Collection
            public boolean add(E r10) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> r10) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Collection
            public boolean contains(Object r10) {
                return this.delegate.contains(r10);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> r10) {
                return this.delegate.containsAll(r10);
            }

            @Override // java.util.Collection
            public boolean equals(Object r10) {
                return this.delegate.equals(r10);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Collection
            public boolean remove(Object r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r10);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r10);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r10);
            }

            @Override // java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] r10) {
                return (T[]) this.delegate.toArray(r10);
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        private static class MutabilityAwareIterator<E> implements Iterator<E> {
            private final Iterator<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            MutabilityAwareIterator(MutabilityOracle r10, Iterator<E> r11) {
                this.mutabilityOracle = r10;
                this.delegate = r11;
            }

            public boolean equals(Object r10) {
                return this.delegate.equals(r10);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegate.hasNext();
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.delegate.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.remove();
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        private static class MutabilityAwareSet<E> implements Set<E> {
            private final Set<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            MutabilityAwareSet(MutabilityOracle r10, Set<E> r11) {
                this.mutabilityOracle = r10;
                this.delegate = r11;
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object r10) {
                return this.delegate.contains(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> r10) {
                return this.delegate.containsAll(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object r10) {
                return this.delegate.equals(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new MutabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> r10) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r10);
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] r10) {
                return (T[]) this.delegate.toArray(r10);
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        MutabilityAwareMap(MutabilityOracle r10, Map<K, V> r11) {
            this.mutabilityOracle = r10;
            this.delegate = r11;
        }

        @Override // java.util.Map
        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object r10) {
            return this.delegate.containsKey(r10);
        }

        @Override // java.util.Map
        public boolean containsValue(Object r10) {
            return this.delegate.containsValue(r10);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new MutabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object r10) {
            return this.delegate.equals(r10);
        }

        @Override // java.util.Map
        public V get(Object r10) {
            return this.delegate.get(r10);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.delegate.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new MutabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
        }

        @Override // java.util.Map
        public V put(K r10, V r11) {
            this.mutabilityOracle.ensureMutable();
            Internal.checkNotNull(r10);
            Internal.checkNotNull(r11);
            return this.delegate.put(r10, r11);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r10) {
            this.mutabilityOracle.ensureMutable();
            Iterator<? extends K> r11 = r10.keySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            K r12 = r11.next();
            Internal.checkNotNull(r12);
            Internal.checkNotNull(r10.get(r12));
            goto L4
        L6:
            this.delegate.putAll(r10);
        }

        @Override // java.util.Map
        public V remove(Object r10) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(r10);
        }

        @Override // java.util.Map
        public int size() {
            return this.delegate.size();
        }

        public String toString() {
            return this.delegate.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new MutabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
        }
    }

    private static final enum StorageMode extends java.lang.Enum<StorageMode> {
        private static final /* synthetic */ StorageMode[] $VALUES = null;
        public static final StorageMode BOTH = null;
        public static final StorageMode LIST = null;
        public static final StorageMode MAP = null;

        private static /* synthetic */ StorageMode[] $values() {
            return new StorageMode[]{MAP, LIST, BOTH};
        }

        static {
            MAP = new StorageMode("MAP", 0);
            LIST = new StorageMode("LIST", 1);
            BOTH = new StorageMode("BOTH", 2);
            $VALUES = $values();
        }

        private StorageMode(String r10, int r11) {
            super(r10, r11);
        }

        public static StorageMode valueOf(String r10) {
            return (StorageMode) java.lang.Enum.valueOf(StorageMode.class, r10);
        }

        public static StorageMode[] values() {
            return (StorageMode[]) $VALUES.clone();
        }
    }

    private MapField(MapEntry<K, V> r10, StorageMode r11, Map<K, V> r12) {
        this(new ImmutableMessageConverter(r10), r11, r12);
    }

    private MapField(Converter<K, V> r10, StorageMode r11, Map<K, V> r12) {
        this.converter = r10;
        this.isMutable = true;
        this.mode = r11;
        this.mapData = new MutabilityAwareMap(this, r12);
        this.listData = null;
    }

    private Message convertKeyAndValueToMessage(K r10, V r11) {
        return this.converter.convertKeyAndValueToMessage(r10, r11);
    }

    private MutabilityAwareMap<K, V> convertListToMap(List<Message> r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Message> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        convertMessageToKeyAndValue(r12.next(), r11);
        goto L4
    L7:
        return new MutabilityAwareMap(this, r11);
    }

    private List<Message> convertMapToList(MutabilityAwareMap<K, V> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<K, V>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<K, V> r13 = r12.next();
        r11.add(convertKeyAndValueToMessage(r13.getKey(), r13.getValue()));
        goto L4
    L6:
        return r11;
    }

    private void convertMessageToKeyAndValue(Message r10, Map<K, V> r11) {
        this.converter.convertMessageToKeyAndValue(r10, r11);
    }

    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> r10) {
        return new MapField(r10, StorageMode.MAP, Collections.emptyMap());
    }

    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> r10) {
        return new MapField(r10, StorageMode.MAP, new LinkedHashMap());
    }

    public void clear() {
        this.mapData = new MutabilityAwareMap(this, new LinkedHashMap());
        this.mode = StorageMode.MAP;
    }

    public MapField<K, V> copy() {
        return new MapField(this.converter, StorageMode.MAP, MapFieldLite.copy(getMap()));
    }

    @Override // com.google.protobuf.MutabilityOracle
    public void ensureMutable() {
        if (isMutable() == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof MapField) == true) goto L7;
        return false;
    L7:
        return MapFieldLite.equals(getMap(), ((MapField) r10).getMap());
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getList() {
        StorageMode r10 = this.mode;
        StorageMode r11 = StorageMode.MAP;
        if (r10 != r11) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != r11) goto L8;
        this.listData = convertMapToList(this.mapData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableList(this.listData);
    }

    public Map<K, V> getMap() {
        StorageMode r10 = this.mode;
        StorageMode r11 = StorageMode.LIST;
        if (r10 != r11) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != r11) goto L8;
        this.mapData = convertListToMap(this.listData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableMap(this.mapData);
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    List<Message> getMutableList() {
        StorageMode r10 = this.mode;
        StorageMode r11 = StorageMode.LIST;
        if (r10 == r11) goto L9;
        if (this.mode != StorageMode.MAP) goto L7;
        this.listData = convertMapToList(this.mapData);
    L7:
        this.mapData = null;
        this.mode = r11;
    L9:
        return this.listData;
    }

    public Map<K, V> getMutableMap() {
        StorageMode r10 = this.mode;
        StorageMode r11 = StorageMode.MAP;
        if (r10 == r11) goto L9;
        if (this.mode != StorageMode.LIST) goto L7;
        this.mapData = convertListToMap(this.listData);
    L7:
        this.listData = null;
        this.mode = r11;
    L9:
        return this.mapData;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(getMap());
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapField<K, V> r10) {
        getMutableMap().putAll(MapFieldLite.copy(r10.getMap()));
    }
}
