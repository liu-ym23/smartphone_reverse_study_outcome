package ue;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class s<T> {
    private volatile AtomicReferenceArray<T> array;

    public s(int r8) {
        this.array = new AtomicReferenceArray(r8);
    }

    public final int a() {
        return this.array.length();
    }

    public final T b(int r8) {
        AtomicReferenceArray<T> r10 = this.array;
        if (r8 < r10.length()) goto L7;
        return null;
    L7:
        return r10.get(r8);
    }

    public final void c(int r8, ve.a.C0184a r10) {
        AtomicReferenceArray<T> r11 = this.array;
        int r12 = r11.length();
        if (r8 >= r12) goto L6;
        r11.set(r8, r10);
        return;
    L6:
        int r13 = r8 + 1;
        int r14 = r12 * 2;
        if (r13 >= r14) goto L9;
        r13 = r14;
    L9:
        AtomicReferenceArray<T> r15 = new AtomicReferenceArray(r13);
        int r16 = 0;
    L10:
        if (r16 >= r12) goto L12;
        r15.set(r16, r11.get(r16));
        r16 = r16 + 1;
        goto L10
    L12:
        r15.set(r8, r10);
        this.array = r15;
    }
}
