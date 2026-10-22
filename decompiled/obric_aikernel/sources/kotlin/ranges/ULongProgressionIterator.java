package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.3")
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    private ULongProgressionIterator(long r10, long r11, long r12) {
        this.finalElement = r11;
        boolean r13 = true;
        if (r12 <= 0) goto L8;
        if (Long.compareUnsigned(r10, r11) <= 0) goto L11;
    L10:
        r13 = false;
    L11:
        this.hasNext = r13;
        this.step = ULong.m206constructorimpl(r12);
        if (this.hasNext == true) goto L15;
        r10 = r11;
    L15:
        this.next = r10;
        return;
    L8:
        if (Long.compareUnsigned(r10, r11) < 0) goto L10;
        goto L10
    }

    public /* synthetic */ ULongProgressionIterator(long r10, long r11, long r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ ULong next() {
        return ULong.m200boximpl(m1277nextsVKNKU());
    }

    /* JADX INFO: renamed from: next-s-VKNKU, reason: not valid java name */
    public long m1277nextsVKNKU() {
        long r10 = this.next;
        if (r10 == this.finalElement) goto L5;
        this.next = ULong.m206constructorimpl(this.step + r10);
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
