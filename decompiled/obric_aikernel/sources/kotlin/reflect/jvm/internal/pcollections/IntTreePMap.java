package kotlin.reflect.jvm.internal.pcollections;

/* JADX INFO: loaded from: classes3.dex */
final class IntTreePMap<V> {
    private static final IntTreePMap<Object> EMPTY = null;
    private final IntTree<V> root;

    static {
        EMPTY = new IntTreePMap(IntTree.EMPTYNODE);
    }

    private IntTreePMap(IntTree<V> r10) {
        this.root = r10;
    }

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) EMPTY;
    }

    private IntTreePMap<V> withRoot(IntTree<V> r10) {
        if (r10 != this.root) goto L6;
        return this;
    L6:
        return new IntTreePMap(r10);
    }

    public V get(int r10) {
        return this.root.get(r10);
    }

    public IntTreePMap<V> minus(int r10) {
        return withRoot(this.root.minus(r10));
    }

    public IntTreePMap<V> plus(int r10, V r11) {
        return withRoot(this.root.plus(r10, r11));
    }
}
