package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class q {
    private volatile AtomicReferenceArray<Object> array;

    public q(int r5) {
        this.array = new AtomicReferenceArray(r5);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int r5) {
        AtomicReferenceArray<Object> r10 = this.array;
        if (r5 < r10.length()) goto L7;
        return null;
    L7:
        return r10.get(r5);
    }

    public final void c(int r10, yt.b r11) {
        AtomicReferenceArray<Object> r5 = this.array;
        int r12 = r5.length();
        if (r10 >= r12) goto L6;
        r5.set(r10, r11);
        return;
    L6:
        AtomicReferenceArray<Object> r13 = new AtomicReferenceArray(RangesKt.coerceAtLeast(r10 + 1, r12 * 2));
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13.set(r14, r5.get(r14));
        r14 = r14 + 1;
        goto L7
    L9:
        r13.set(r10, r11);
        this.array = r13;
    }
}
