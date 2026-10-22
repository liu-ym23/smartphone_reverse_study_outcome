package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K r1, V r2) {
        this.key = r1;
        this.value = r2;
    }

    public Pair(Pair<? extends K, ? extends V> r2) {
        this(r2.getKey(), r2.getValue());
    }

    public static <K, V> Pair<K, V> create(K r1, V r2) {
        return new Pair(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Pair.class) == true) goto L8;
        return false;
    L8:
        Pair r6 = (Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin");
        K r0 = this.key;
        if (r0 != null) goto L14;
        if (r6.key != null) goto L24;
    L15:
        V r4 = this.value;
        if (r4 != null) goto L21;
        if (r6.value != null) goto L24;
        return true;
    L21:
        if (r4.equals(r6.value) == false) goto L24;
        return true;
    L24:
        return false;
    L14:
        if (r0.equals(r6.key) == false) goto L24;
        goto L15
    }

    public K getFirst() {
        return this.key;
    }

    public K getKey() {
        return this.key;
    }

    public V getSecond() {
        return this.value;
    }

    public V getValue() {
        return this.value;
    }

    public int hashCode() {
        K r0 = this.key;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        V r3 = this.value;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return (r1 >>> 16) ^ ((r2 * 37) + r1);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "[" + getKey() + ", " + getValue() + "]";
    }
}
