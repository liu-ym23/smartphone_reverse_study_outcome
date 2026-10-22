package kotlin.jvm.internal;

import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PrimitiveSpreadBuilder<T> {
    private int position;
    private final int size;
    private final T[] spreads;

    public PrimitiveSpreadBuilder(int r10) {
        this.size = r10;
        this.spreads = (T[]) new Object[r10];
    }

    private static /* synthetic */ void getSpreads$annotations() {
    }

    public final void addSpread(T r10) {
        Intrinsics.checkNotNullParameter(r10, "spreadArgument");
        T[] r11 = this.spreads;
        int r12 = this.position;
        this.position = r12 + 1;
        r11[r12] = r10;
    }

    protected final int getPosition() {
        return this.position;
    }

    protected abstract int getSize(T r10);

    protected final void setPosition(int r10) {
        this.position = r10;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    protected final int size() {
        int r10 = 0;
        ?? r11 = new IntRange(0, this.size - 1).iterator2();
    L4:
        if (r11.hasNext() == false) goto L10;
        T r12 = this.spreads[r11.nextInt()];
        if (r12 == null) goto L8;
        int r13 = getSize(r12);
    L9:
        r10 = r10 + r13;
        goto L4
    L8:
        r13 = 1;
        goto L9
    L10:
        return r10;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    protected final T toArray(T r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "values");
        Intrinsics.checkNotNullParameter(r11, "result");
        ?? r12 = new IntRange(0, this.size - 1).iterator2();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L10;
        int r15 = r12.nextInt();
        T r16 = this.spreads[r15];
        if (r16 == null) goto L4;
        if (r13 >= r15) goto L9;
        int r17 = r15 - r13;
        System.arraycopy(r10, r13, r11, r14, r17);
        r14 = r14 + r17;
    L9:
        int r18 = getSize(r16);
        System.arraycopy(r16, 0, r11, r14, r18);
        r14 = r14 + r18;
        r13 = r15 + 1;
        goto L4
    L10:
        int r19 = this.size;
        if (r13 >= r19) goto L13;
        System.arraycopy(r10, r13, r11, r14, r19 - r13);
    L13:
        return r11;
    }
}
