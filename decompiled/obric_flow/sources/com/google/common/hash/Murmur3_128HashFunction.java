package com.google.common.hash;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Murmur3_128HashFunction extends b implements Serializable {
    static final k GOOD_FAST_HASH_128 = null;
    static final k MURMUR3_128 = null;
    private static final long serialVersionUID = 0;
    private final int seed;

    static {
        MURMUR3_128 = new Murmur3_128HashFunction(0);
        GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(n.f9292a);
    }

    public Murmur3_128HashFunction(int r5) {
        this.seed = r5;
    }

    public int bits() {
        return 128;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Murmur3_128HashFunction) == true) goto L5;
        return false;
    L5:
        if (this.seed != ((Murmur3_128HashFunction) r5).seed) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        int r5 = Murmur3_128HashFunction.class.hashCode();
        return this.seed ^ r5;
    }

    @Override // com.google.common.hash.k
    public l newHasher() {
        int r5 = this.seed;
        x r10 = new x(16);
        long r11 = r5;
        r10.d = r11;
        r10.e = r11;
        r10.f = 0;
        return r10;
    }

    public String toString() {
        int r5 = this.seed;
        StringBuilder r10 = new StringBuilder(32);
        r10.append("Hashing.murmur3_128(");
        r10.append(r5);
        r10.append(")");
        return r10.toString();
    }
}
