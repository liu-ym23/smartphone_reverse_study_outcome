package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CharProgressionIterator extends CharIterator {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    public CharProgressionIterator(char r10, char r11, int r12) {
        this.step = r12;
        this.finalElement = r11;
        boolean r13 = true;
        if (r12 <= 0) goto L8;
        if (Intrinsics.compare(r10, r11) <= 0) goto L11;
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
        if (Intrinsics.compare(r10, r11) < 0) goto L10;
        goto L10
    }

    public final int getStep() {
        return this.step;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        int r10 = this.next;
        if (r10 == this.finalElement) goto L5;
        this.next = this.step + r10;
    L11:
        return (char) r10;
    L5:
        if (this.hasNext == false) goto L8;
        this.hasNext = false;
        goto L11
    L8:
        throw new NoSuchElementException();
    }
}
