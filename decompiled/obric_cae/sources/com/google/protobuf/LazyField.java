package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX INFO: renamed from: com.google.protobuf.LazyField$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        private LazyEntry(Map.Entry<K, LazyField> r8) {
            this.entry = r8;
        }

        public LazyField getField() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField r8 = this.entry.getValue();
            if (r8 != null) goto L7;
            return null;
        L7:
            return r8.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r8) {
            if ((r8 instanceof MessageLite) == false) goto L7;
            return this.entry.getValue().setValue((MessageLite) r8);
        L7:
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public /* synthetic */ LazyEntry(Map.Entry r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> r8) {
            this.iterator = r8;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> r8 = this.iterator.next();
            if ((r8.getValue() instanceof LazyField) == true) goto L5;
            return r8;
        L5:
            return new LazyEntry(r8, null);
        }
    }

    public LazyField(MessageLite r8, ExtensionRegistryLite r10, ByteString r11) {
        super(r10, r11);
        this.defaultInstance = r8;
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean containsDefaultInstance() {
        if (super.containsDefaultInstance() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.value == this.defaultInstance) goto L8;
        return false;
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean equals(Object r8) {
        return getValue().equals(r8);
    }

    public MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    @Override // com.google.protobuf.LazyFieldLite
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
