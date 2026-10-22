package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MapField<K, V> extends MapFieldReflectionAccessor implements MutabilityOracle {
    private final Converter<K, V> converter;
    private volatile boolean isMutable;
    private List<Message> listData;
    private MutabilityAwareMap<K, V> mapData;
    private volatile StorageMode mode;

    public interface Converter<K, V> {
        Message convertKeyAndValueToMessage(K r8, V r10);

        void convertMessageToKeyAndValue(Message r8, Map<K, V> r10);

        Message getMessageDefaultInstance();
    }

    public static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
        private final MapEntry<K, V> defaultEntry;

        public ImmutableMessageConverter(MapEntry<K, V> r8) {
            this.defaultEntry = r8;
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message convertKeyAndValueToMessage(K r8, V r10) {
            return this.defaultEntry.newBuilderForType().setKey(r8).setValue(r10).buildPartial();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.Converter
        public void convertMessageToKeyAndValue(Message r8, Map<K, V> r10) {
            MapEntry r11 = (MapEntry) r8;
            r10.put(r11.getKey(), r11.getValue());
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }
    }

    public static class MutabilityAwareMap<K, V> implements Map<K, V> {
        private final Map<K, V> delegate;
        private final MutabilityOracle mutabilityOracle;

        public static class MutabilityAwareCollection<E> implements Collection<E> {
            private final Collection<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutabilityAwareCollection(MutabilityOracle r8, Collection<E> r10) {
                this.mutabilityOracle = r8;
                this.delegate = r10;
            }

            @Override // java.util.Collection
            public boolean add(E r8) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> r8) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Collection
            public boolean contains(Object r8) {
                return this.delegate.contains(r8);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> r8) {
                return this.delegate.containsAll(r8);
            }

            @Override // java.util.Collection
            public boolean equals(Object r8) {
                return this.delegate.equals(r8);
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
            public boolean remove(Object r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r8);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r8);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r8);
            }

            @Override // java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] r8) {
                return (T[]) this.delegate.toArray(r8);
            }
        }

        public static class MutabilityAwareIterator<E> implements Iterator<E> {
            private final Iterator<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutabilityAwareIterator(MutabilityOracle r8, Iterator<E> r10) {
                this.mutabilityOracle = r8;
                this.delegate = r10;
            }

            public boolean equals(Object r8) {
                return this.delegate.equals(r8);
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

        public static class MutabilityAwareSet<E> implements Set<E> {
            private final Set<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutabilityAwareSet(MutabilityOracle r8, Set<E> r10) {
                this.mutabilityOracle = r8;
                this.delegate = r10;
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(r8);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(r8);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object r8) {
                return this.delegate.contains(r8);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> r8) {
                return this.delegate.containsAll(r8);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object r8) {
                return this.delegate.equals(r8);
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
            public boolean remove(Object r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(r8);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(r8);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> r8) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(r8);
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] r8) {
                return (T[]) this.delegate.toArray(r8);
            }
        }

        public MutabilityAwareMap(MutabilityOracle r8, Map<K, V> r10) {
            this.mutabilityOracle = r8;
            this.delegate = r10;
        }

        @Override // java.util.Map
        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object r8) {
            return this.delegate.containsKey(r8);
        }

        @Override // java.util.Map
        public boolean containsValue(Object r8) {
            return this.delegate.containsValue(r8);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new MutabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object r8) {
            return this.delegate.equals(r8);
        }

        @Override // java.util.Map
        public V get(Object r8) {
            return this.delegate.get(r8);
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
        public V put(K r8, V r10) {
            this.mutabilityOracle.ensureMutable();
            Internal.checkNotNull(r8);
            Internal.checkNotNull(r10);
            return this.delegate.put(r8, r10);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r8) {
            this.mutabilityOracle.ensureMutable();
            Iterator<? extends K> r10 = r8.keySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            K r11 = r10.next();
            Internal.checkNotNull(r11);
            Internal.checkNotNull(r8.get(r11));
            goto L4
        L6:
            this.delegate.putAll(r8);
        }

        @Override // java.util.Map
        public V remove(Object r8) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(r8);
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

    public static final enum StorageMode extends java.lang.Enum<StorageMode> {
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

        private StorageMode(String r8, int r10) {
            super(r8, r10);
        }

        public static StorageMode valueOf(String r8) {
            return (StorageMode) java.lang.Enum.valueOf(StorageMode.class, r8);
        }

        public static StorageMode[] values() {
            return (StorageMode[]) $VALUES.clone();
        }
    }

    private MapField(MapEntry<K, V> r8, StorageMode r10, Map<K, V> r11) {
        this(new ImmutableMessageConverter(r8), r10, r11);
    }

    private Message convertKeyAndValueToMessage(K r8, V r10) {
        return this.converter.convertKeyAndValueToMessage(r8, r10);
    }

    private MutabilityAwareMap<K, V> convertListToMap(List<Message> r8) {
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<Message> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        convertMessageToKeyAndValue(r11.next(), r10);
        goto L4
    L7:
        return new MutabilityAwareMap(this, r10);
    }

    private List<Message> convertMapToList(MutabilityAwareMap<K, V> r8) {
        ArrayList r10 = new ArrayList();
        Iterator<Map.Entry<K, V>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<K, V> r12 = r11.next();
        r10.add(convertKeyAndValueToMessage(r12.getKey(), r12.getValue()));
        goto L4
    L6:
        return r10;
    }

    private void convertMessageToKeyAndValue(Message r8, Map<K, V> r10) {
        this.converter.convertMessageToKeyAndValue(r8, r10);
    }

    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> r8) {
        return new MapField(r8, StorageMode.MAP, Collections.emptyMap());
    }

    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> r8) {
        return new MapField(r8, StorageMode.MAP, new LinkedHashMap());
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

    public boolean equals(Object r8) {
        if ((r8 instanceof MapField) == true) goto L7;
        return false;
    L7:
        return MapFieldLite.equals(getMap(), ((MapField) r8).getMap());
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    public List<Message> getList() {
        StorageMode r8 = this.mode;
        StorageMode r10 = StorageMode.MAP;
        if (r8 != r10) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != r10) goto L8;
        this.listData = convertMapToList(this.mapData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableList(this.listData);
    }

    public Map<K, V> getMap() {
        StorageMode r8 = this.mode;
        StorageMode r10 = StorageMode.LIST;
        if (r8 != r10) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mode != r10) goto L8;
        this.mapData = convertListToMap(this.listData);     // Catch: Throwable -> L10
        this.mode = StorageMode.BOTH;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return Collections.unmodifiableMap(this.mapData);
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    public Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    @Override // com.google.protobuf.MapFieldReflectionAccessor
    public List<Message> getMutableList() {
        StorageMode r8 = this.mode;
        StorageMode r10 = StorageMode.LIST;
        if (r8 == r10) goto L9;
        if (this.mode != StorageMode.MAP) goto L7;
        this.listData = convertMapToList(this.mapData);
    L7:
        this.mapData = null;
        this.mode = r10;
    L9:
        return this.listData;
    }

    public Map<K, V> getMutableMap() {
        StorageMode r8 = this.mode;
        StorageMode r10 = StorageMode.MAP;
        if (r8 == r10) goto L9;
        if (this.mode != StorageMode.LIST) goto L7;
        this.mapData = convertListToMap(this.listData);
    L7:
        this.listData = null;
        this.mode = r10;
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

    public void mergeFrom(MapField<K, V> r8) {
        getMutableMap().putAll(MapFieldLite.copy(r8.getMap()));
    }

    private MapField(Converter<K, V> r8, StorageMode r10, Map<K, V> r11) {
        this.converter = r8;
        this.isMutable = true;
        this.mode = r10;
        this.mapData = new MutabilityAwareMap(this, r11);
        this.listData = null;
    }
}
