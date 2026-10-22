package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    private final int finalElement;
    private boolean hasNext;
    private int next;
    private final int step;

    private UIntProgressionIterator(int r10, int r11, int r12) {
        this.finalElement = r11;
        boolean r13 = true;
        int r14 = Integer.compareUnsigned(r10, r11);
        if (r12 <= 0) goto L6;
        if (r14 <= 0) goto L9;
    L8:
        r13 = false;
    L9:
        this.hasNext = r13;
        this.step = UInt.m127constructorimpl(r12);
        if (this.hasNext == true) goto L13;
        r10 = r11;
    L13:
        this.next = r10;
        return;
    L6:
        if (r14 < 0) goto L8;
        goto L8
    }

    public /* synthetic */ UIntProgressionIterator(int r10, int r11, int r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m121boximpl(m1268nextpVg5ArA());
    }

    /* JADX INFO: renamed from: next-pVg5ArA, reason: not valid java name */
    public int m1268nextpVg5ArA() {
        int r10 = this.next;
        if (r10 == this.finalElement) goto L5;
        this.next = UInt.m127constructorimpl(this.step + r10);
    L10:
        return r10;
    L5:
        if (this.hasNext == false) goto L8;
        this.hasNext = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
