package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
public class Combinations implements Iterable<int[]> {
    private final IterationOrder iterationOrder;
    private final int k;
    private final int n;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.Combinations$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder = null;

        static {
            int[] r0 = new int[IterationOrder.values().length];
            $SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder = r0;
            r0[IterationOrder.LEXICOGRAPHIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    private static final enum IterationOrder extends Enum<IterationOrder> {
        private static final /* synthetic */ IterationOrder[] $VALUES = null;
        public static final IterationOrder LEXICOGRAPHIC = null;

        static {
            IterationOrder r0 = new IterationOrder("LEXICOGRAPHIC", 0);
            LEXICOGRAPHIC = r0;
            $VALUES = new IterationOrder[]{r0};
        }

        private IterationOrder(String r1, int r2) {
            super(r1, r2);
        }

        public static IterationOrder valueOf(String r2) {
            return (IterationOrder) ZeusTransformUtils.preCheckCast(Enum.valueOf(IterationOrder.class, r2), IterationOrder.class, "com.obric.memorydata.plugin");
        }

        public static IterationOrder[] values() {
            return (IterationOrder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IterationOrder[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class LexicographicComparator implements Serializable, Comparator<int[]> {
        private static final long serialVersionUID = 20130906;
        private final int k;
        private final int n;

        LexicographicComparator(int r1, int r2) {
            this.n = r1;
            this.k = r2;
        }

        private long lexNorm(int[] r7) {
            long r1 = 0;
            int r3 = 0;
        L4:
            if (r3 >= r7.length) goto L12;
            int r4 = r7[r3];
            if (r4 < 0) goto L11;
            int r5 = this.n;
            if (r4 >= r5) goto L11;
            r1 = r1 + ((long) (r7[r3] * ArithmeticUtils.pow(r5, r3)));
            r3 = r3 + 1;
        L11:
            throw new OutOfRangeException(Integer.valueOf(r4), 0, Integer.valueOf(this.n - 1));
        L12:
            return r1;
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(int[] r3, int[] r4) {
            return compare2((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"), (int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r3, int[] r4) {
            int r0 = r3.length;
            int r1 = this.k;
            if (r0 != r1) goto L18;
            if (r4.length != r1) goto L16;
            int[] r5 = MathArrays.copyOf(r3);
            Arrays.sort(r5);
            int[] r6 = MathArrays.copyOf(r4);
            Arrays.sort(r6);
            long r2 = lexNorm(r5);
            long r7 = lexNorm(r6);
            if (r2 >= r7) goto L10;
            return -1;
        L10:
            if (r2 <= r7) goto L13;
            return 1;
        L13:
            return 0;
        L16:
            throw new DimensionMismatchException(r4.length, this.k);
        L18:
            throw new DimensionMismatchException(r3.length, this.k);
        }
    }

    private static class LexicographicIterator implements Iterator<int[]> {
        private final int[] c;
        private int j;
        private final int k;
        private boolean more;

        LexicographicIterator(int r5, int r6) {
            int r0 = 1;
            this.more = true;
            this.k = r6;
            this.c = new int[r6 + 3];
            if (r6 == 0) goto L10;
            if (r6 >= r5) goto L10;
        L6:
            if (r0 > r6) goto L8;
            this.c[r0] = r0 - 1;
            r0 = r0 + 1;
            goto L6
        L8:
            int[] r1 = this.c;
            r1[r6 + 1] = r5;
            r1[r6 + 2] = 0;
            this.j = r6;
            return;
        L10:
            this.more = false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.more;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ int[] next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public int[] next2() {
            if (this.more == false) goto L26;
            int r0 = this.k;
            int[] r1 = new int[r0];
            System.arraycopy(this.c, 1, r1, 0, r0);
            int r2 = this.j;
            if (r2 <= 0) goto L8;
            this.c[r2] = r2;
            this.j = r2 - 1;
            return r1;
        L8:
            int[] r3 = this.c;
            if ((r3[1] + 1) >= r3[2]) goto L12;
            r3[1] = r3[1] + 1;
            return r1;
        L12:
            this.j = 2;
            boolean r4 = false;
            int r5 = 0;
        L13:
            if (r4 == true) goto L19;
            int[] r6 = this.c;
            int r7 = this.j;
            r6[r7 - 1] = r7 - 2;
            int r8 = r6[r7] + 1;
            if (r8 != r6[r7 + 1]) goto L17;
            this.j = r7 + 1;
        L18:
            r5 = r8;
            goto L13
        L17:
            r4 = true;
            goto L18
        L19:
            int r9 = this.j;
            if (r9 <= this.k) goto L23;
            this.more = false;
            return r1;
        L23:
            this.c[r9] = r5;
            this.j = r9 - 1;
            return r1;
        L26:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static class SingletonIterator implements Iterator<int[]> {
        private boolean more;
        private final int[] singleton;

        SingletonIterator(int[] r2) {
            this.more = true;
            this.singleton = r2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.more;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ int[] next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public int[] next2() {
            if (this.more == false) goto L7;
            this.more = false;
            return this.singleton;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<int[]> iterator() {
        int r0 = this.k;
        if (r0 == 0) goto L14;
        if (r0 == this.n) goto L14;
        if (AnonymousClass1.$SwitchMap$org$apache$commons$math3$util$Combinations$IterationOrder[this.iterationOrder.ordinal()] != 1) goto L12;
        return new LexicographicIterator(this.n, this.k);
    L12:
        throw new MathInternalError();
    L14:
        return new SingletonIterator(MathArrays.natural(this.k));
    }
}
