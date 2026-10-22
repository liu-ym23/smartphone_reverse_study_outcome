package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.LazyField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        private LazyEntry(Map.Entry<K, LazyField> r10) {
            this.entry = r10;
        }

        /* synthetic */ LazyEntry(Map.Entry r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField r10 = this.entry.getValue();
            if (r10 != null) goto L7;
            return null;
        L7:
            return r10.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r10) {
            if ((r10 instanceof MessageLite) == false) goto L7;
            return this.entry.getValue().setValue((MessageLite) r10);
        L7:
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> r10) {
            this.iterator = r10;
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
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> r10 = this.iterator.next();
            if ((r10.getValue() instanceof LazyField) == true) goto L5;
            return r10;
        L5:
            return new LazyEntry(r10, null);
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    public boolean equals(Object r10) {
        return getValue().equals(r10);
    }

    public MessageLite getValue() {
        return getValue(this.defaultInstance);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
