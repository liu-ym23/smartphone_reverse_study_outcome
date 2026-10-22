package org.apache.commons.collections4.trie;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class KeyAnalyzer<K> implements Serializable, Comparator<K> {
    public static final int EQUAL_BIT_KEY = -2;
    public static final int NULL_BIT_KEY = -1;
    public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
    private static final long serialVersionUID = -20497563720380683L;

    public KeyAnalyzer() {
    }

    static boolean isEqualBitKey(int r1) {
        if (r1 != (-2)) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isNullBitKey(int r1) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isOutOfBoundsIndex(int r1) {
        if (r1 != (-3)) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isValidBitIndex(int r0) {
        if (r0 < 0) goto L4;
        return true;
    L4:
        return false;
    }

    public abstract int bitIndex(K r1, int r2, int r3, K r4, int r5, int r6);

    public abstract int bitsPerElement();

    @Override // java.util.Comparator
    public int compare(K r2, K r3) {
        if (r2 != null) goto L7;
        if (r3 != null) goto L5;
        return 0;
    L5:
        return -1;
    L7:
        if (r3 != null) goto L11;
        return 1;
    L11:
        return ((Comparable) ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo(r3);
    }

    public abstract boolean isBitSet(K r1, int r2, int r3);

    public abstract boolean isPrefix(K r1, int r2, int r3, K r4);

    public abstract int lengthInBits(K r1);
}
