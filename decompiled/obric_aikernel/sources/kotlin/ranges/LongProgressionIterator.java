package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.LongIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class LongProgressionIterator extends LongIterator {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    public LongProgressionIterator(long r10, long r11, long r12) {
        this.step = r12;
        this.finalElement = r11;
        boolean r13 = true;
        if (r12 <= 0) goto L8;
        if (r10 <= r11) goto L11;
    L10:
        r13 = false;
    L11:
        this.hasNext = r13;
        if (r13 == true) goto L15;
        r10 = r11;
    L15:
        this.next = r10;
        return;
    L8:
        if (r10 < r11) goto L10;
        goto L10
    }

    public final long getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.LongIterator
    public long nextLong() {
        long r10 = this.next;
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
