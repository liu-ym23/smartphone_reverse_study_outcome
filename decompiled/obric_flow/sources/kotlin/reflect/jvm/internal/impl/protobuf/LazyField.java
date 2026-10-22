package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {
    private final MessageLite defaultInstance;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.LazyField$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        public /* synthetic */ LazyEntry(Map.Entry r5, AnonymousClass1 r10) {
            this(r5);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField r5 = this.entry.getValue();
            if (r5 != null) goto L7;
            return null;
        L7:
            return r5.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r5) {
            if ((r5 instanceof MessageLite) == false) goto L7;
            return this.entry.getValue().setValue((MessageLite) r5);
        L7:
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private LazyEntry(Map.Entry<K, LazyField> r5) {
            this.entry = r5;
        }
    }

    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> r5) {
            this.iterator = r5;
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
            Map.Entry<K, Object> r5 = this.iterator.next();
            if ((r5.getValue() instanceof LazyField) == true) goto L5;
            return r5;
        L5:
            return new LazyEntry(r5, null);
        }
    }

    public boolean equals(Object r5) {
        return getValue().equals(r5);
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
