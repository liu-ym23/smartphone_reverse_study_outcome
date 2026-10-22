package androidx.arch.core.internal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SafeIterableMap$DescendingIterator<K, V> extends SafeIterableMap.ListIterator<K, V> {
    public SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> r1) {
        return r1.mNext;
    }

    public SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> r1) {
        return r1.mPrevious;
    }

    public SafeIterableMap$DescendingIterator(SafeIterableMap.Entry<K, V> r1, SafeIterableMap.Entry<K, V> r2) {
        super(r1, r2);
    }
}
