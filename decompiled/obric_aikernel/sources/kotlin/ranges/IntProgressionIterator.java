package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class IntProgressionIterator extends IntIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public IntProgressionIterator(int r10, int r11, int r12) {
        this.step = r12;
        this.finalElement = r11;
        boolean r13 = true;
        if (r12 <= 0) goto L6;
        if (r10 <= r11) goto L9;
    L8:
        r13 = false;
    L9:
        this.hasNext = r13;
        if (r13 == true) goto L13;
        r10 = r11;
    L13:
        this.next = r10;
        return;
    L6:
        if (r10 < r11) goto L8;
        goto L8
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int r10 = this.next;
        if (r10 == this.finalElement) goto L5;
        this.next = this.step + r10;
    L10:
        return r10;
    L5:
        if (this.hasNext == false) goto L8;
        this.hasNext = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
