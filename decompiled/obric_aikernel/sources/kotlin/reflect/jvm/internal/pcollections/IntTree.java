package kotlin.reflect.jvm.internal.pcollections;

/* JADX INFO: loaded from: classes3.dex */
final class IntTree<V> {
    static final IntTree<Object> EMPTYNODE = null;
    private final long key;
    private final IntTree<V> left;
    private final IntTree<V> right;
    private final int size;
    private final V value;

    static {
        EMPTYNODE = new IntTree();
    }

    private IntTree() {
        this.size = 0;
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private IntTree(long r10, V r11, IntTree<V> r12, IntTree<V> r13) {
        this.key = r10;
        this.value = r11;
        this.left = r12;
        this.right = r13;
        this.size = (r12.size + 1) + r13.size;
    }

    private long minKey() {
        IntTree<V> r10 = this.left;
        if (r10.size != 0) goto L7;
        return this.key;
    L7:
        return r10.minKey() + this.key;
    }

    private static <V> IntTree<V> rebalanced(long r17, V r19, IntTree<V> r20, IntTree<V> r21) {
        int r10 = ((IntTree) r20).size;
        int r11 = ((IntTree) r21).size;
        if ((r10 + r11) <= 1) goto L21;
        if (r10 < (r11 * 5)) goto L13;
        IntTree<V> r12 = ((IntTree) r20).left;
        IntTree<V> r13 = ((IntTree) r20).right;
        if (((IntTree) r13).size >= (((IntTree) r12).size * 2)) goto L10;
        long r14 = ((IntTree) r20).key;
        return new IntTree(r14 + r17, ((IntTree) r20).value, r12, new IntTree(-r14, r19, r13.withKey(((IntTree) r13).key + r14), r21));
    L10:
        IntTree<V> r15 = ((IntTree) r13).left;
        IntTree<V> r16 = ((IntTree) r13).right;
        long r18 = ((IntTree) r13).key;
        long r110 = (((IntTree) r20).key + r18) + r17;
        V r22 = ((IntTree) r13).value;
        IntTree r111 = new IntTree(-r18, ((IntTree) r20).value, r12, r15.withKey(((IntTree) r15).key + r18));
        long r23 = ((IntTree) r20).key;
        long r24 = ((IntTree) r13).key;
        return new IntTree(r110, r22, r111, new IntTree((-r23) - r24, r19, r16.withKey((((IntTree) r16).key + r24) + r23), r21));
    L13:
        if (r11 < (r10 * 5)) goto L21;
        IntTree<V> r25 = ((IntTree) r21).left;
        IntTree<V> r26 = ((IntTree) r21).right;
        if (((IntTree) r25).size >= (((IntTree) r26).size * 2)) goto L18;
        long r27 = ((IntTree) r21).key;
        return new IntTree(r27 + r17, ((IntTree) r21).value, new IntTree(-r27, r19, r20, r25.withKey(((IntTree) r25).key + r27)), r26);
    L18:
        IntTree<V> r28 = ((IntTree) r25).left;
        IntTree<V> r29 = ((IntTree) r25).right;
        long r30 = ((IntTree) r25).key;
        long r112 = ((IntTree) r21).key;
        long r113 = (r30 + r112) + r17;
        V r114 = ((IntTree) r25).value;
        IntTree r115 = new IntTree((-r112) - r30, r19, r20, r28.withKey((((IntTree) r28).key + r30) + r112));
        long r31 = ((IntTree) r25).key;
        return new IntTree(r113, r114, r115, new IntTree(-r31, ((IntTree) r21).value, r29.withKey(((IntTree) r29).key + r31), r26));
    L21:
        return new IntTree(r17, r19, r20, r21);
    }

    private IntTree<V> rebalanced(IntTree<V> r10, IntTree<V> r11) {
        if (r10 != this.left) goto L8;
        if (r11 != this.right) goto L8;
        return this;
    L8:
        return rebalanced(this.key, this.value, r10, r11);
    }

    private IntTree<V> withKey(long r10) {
        if (this.size != 0) goto L5;
    L9:
        return this;
    L5:
        if (r10 == this.key) goto L9;
        return new IntTree(r10, this.value, this.left, this.right);
    }

    V get(long r10) {
        if (this.size != 0) goto L6;
        return null;
    L6:
        long r11 = this.key;
        if (r10 >= r11) goto L12;
        IntTree<V> r12 = this.left;
    L10:
        return r12.get(r10 - r11);
    L12:
        if (r10 <= r11) goto L15;
        r12 = this.right;
        goto L10
    L15:
        return this.value;
    }

    IntTree<V> minus(long r10) {
        if (this.size != 0) goto L5;
        return this;
    L5:
        long r11 = this.key;
        if (r10 >= r11) goto L10;
        return rebalanced(this.left.minus(r10 - r11), this.right);
    L10:
        if (r10 > r11) goto L12;
        IntTree<V> r12 = this.left;
        if (r12.size != 0) goto L17;
        IntTree<V> r13 = this.right;
        return r13.withKey(r13.key + r11);
    L17:
        IntTree<V> r14 = this.right;
        if (r14.size == 0) goto L20;
        long r15 = r14.minKey();
        long r16 = this.key;
        long r17 = r15 + r16;
        V r18 = this.right.get(r17 - r16);
        IntTree<V> r19 = this.right.minus(r17 - this.key);
        IntTree<V> r20 = r19.withKey((r19.key + this.key) - r17);
        IntTree<V> r21 = this.left;
        return rebalanced(r17, r18, r21.withKey((r21.key + this.key) - r17), r20);
    L20:
        return r12.withKey(r12.key + r11);
    L12:
        return rebalanced(this.left, this.right.minus(r10 - r11));
    }

    IntTree<V> plus(long r10, V r11) {
        if (this.size == 0) goto L5;
        long r12 = this.key;
        if (r10 >= r12) goto L11;
        return rebalanced(this.left.plus(r10 - r12, r11), this.right);
    L11:
        if (r10 <= r12) goto L15;
        return rebalanced(this.left, this.right.plus(r10 - r12, r11));
    L15:
        if (r11 != this.value) goto L18;
        return this;
    L18:
        return new IntTree(r10, r11, this.left, this.right);
    L5:
        return new IntTree(r10, r11, this, this);
    }
}
