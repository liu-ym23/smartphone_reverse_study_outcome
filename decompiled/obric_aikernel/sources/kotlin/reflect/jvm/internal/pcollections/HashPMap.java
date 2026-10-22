package kotlin.reflect.jvm.internal.pcollections;

/* JADX INFO: loaded from: classes3.dex */
public final class HashPMap<K, V> {
    private static final HashPMap<Object, Object> EMPTY = null;
    private final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
    private final int size;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[2];
        r11[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (r10 == 1) goto L5;
        r11[1] = "empty";
    L7:
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", r11));
    L5:
        r11[1] = "minus";
        goto L7
    }

    static {
        EMPTY = new HashPMap(IntTreePMap.empty(), 0);
    }

    private HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> r10, int r11) {
        this.intMap = r10;
        this.size = r11;
    }

    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> r10 = (HashPMap<K, V>) EMPTY;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return r10;
    }

    private ConsPStack<MapEntry<K, V>> getEntries(int r10) {
        ConsPStack<MapEntry<K, V>> r11 = this.intMap.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return ConsPStack.empty();
    }

    private static <K, V> int keyIndexIn(ConsPStack<MapEntry<K, V>> r10, Object r11) {
        int r12 = 0;
    L3:
        if (r10 == null) goto L10;
        if (r10.size() <= 0) goto L15;
        if (r10.first.key.equals(r11) == true) goto L8;
        r10 = r10.rest;
        r12 = r12 + 1;
        goto L3
    L8:
        return r12;
    L15:
        return -1;
    L10:
        return -1;
    }

    public boolean containsKey(Object r10) {
        if (keyIndexIn(getEntries(r10.hashCode()), r10) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object r10) {
        ConsPStack r11 = getEntries(r10.hashCode());
    L3:
        if (r11 == null) goto L11;
        if (r11.size() <= 0) goto L16;
        MapEntry r12 = (MapEntry) r11.first;
        if (r12.key.equals(r10) == true) goto L9;
        r11 = r11.rest;
        goto L3
    L9:
        return r12.value;
    L16:
        return null;
    L11:
        return null;
    }

    public HashPMap<K, V> minus(Object r10) {
        ConsPStack<MapEntry<K, V>> r11 = getEntries(r10.hashCode());
        int r12 = keyIndexIn(r11, r10);
        if (r12 != (-1)) goto L5;
        return this;
    L5:
        ConsPStack<MapEntry<K, V>> r13 = r11.minus(r12);
        if (r13.size() != 0) goto L10;
        return new HashPMap(this.intMap.minus(r10.hashCode()), this.size - 1);
    L10:
        return new HashPMap(this.intMap.plus(r10.hashCode(), r13), this.size - 1);
    }

    public HashPMap<K, V> plus(K r10, V r11) {
        ConsPStack<MapEntry<K, V>> r12 = getEntries(r10.hashCode());
        int r13 = r12.size();
        int r14 = keyIndexIn(r12, r10);
        if (r14 == (-1)) goto L5;
        r12 = r12.minus(r14);
    L5:
        ConsPStack<MapEntry<K, V>> r15 = r12.plus(new MapEntry(r10, r11));
        return new HashPMap(this.intMap.plus(r10.hashCode(), r15), (this.size - r13) + r15.size());
    }

    public int size() {
        return this.size;
    }
}
