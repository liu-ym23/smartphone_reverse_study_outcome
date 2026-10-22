package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* JADX INFO: loaded from: classes2.dex */
final class ArrayIntIterator extends IntIterator {
    private final int[] array;
    private int index;

    public ArrayIntIterator(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        this.array = r10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.array.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.IntIterator
    public int nextInt() {
        int[] r10 = this.array;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r11 = this.index;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.index = r11 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r10[r11];
    L4:
        e = move-exception;
        this.index--;
        throw new NoSuchElementException(e.getMessage());
    }
}
