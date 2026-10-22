package ue;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import pe.t0;
import ue.y;

/* JADX INFO: loaded from: classes2.dex */
public class x<T extends y & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12634b = null;
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f12635a;

    static {
        f12634b = AtomicIntegerFieldUpdater.newUpdater(x.class, "_size");
    }

    public x() {
    }

    public final void a(t0.c r8) {
        r8.a((t0.d) this);
        T[] r10 = this.f12635a;
        if (r10 != null) goto L6;
        r10 = (T[]) new y[4];
        this.f12635a = r10;
    L8:
        int r11 = b();
        AtomicIntegerFieldUpdater r12 = f12634b;
        r12.set(this, r11 + 1);
        r10[r11] = r8;
        r8.f10073b = r11;
        d(r11);
        return;
    L6:
        if (b() < r10.length) goto L8;
        Object[] r13 = Arrays.copyOf(r10, b() * 2);
        he.i.e(r13, "copyOf(this, newSize)");
        r10 = (T[]) ((y[]) r13);
        this.f12635a = r10;
        goto L8
    }

    public final int b() {
        return f12634b.get(this);
    }

    public final T c(int r8) {
        T[] r10 = this.f12635a;
        he.i.c(r10);
        f12634b.set(this, b() - 1);
        if (r8 >= b()) goto L21;
        e(r8, b());
        int r11 = (r8 - 1) / 2;
        if (r8 <= 0) goto L9;
        T r12 = r10[r8];
        he.i.c(r12);
        T r13 = r10[r11];
        he.i.c(r13);
        if (((Comparable) r12).compareTo(r13) >= 0) goto L9;
        e(r8, r11);
        d(r11);
    L9:
        int r14 = (r8 * 2) + 1;
        if (r14 >= b()) goto L21;
        T[] r15 = this.f12635a;
        he.i.c(r15);
        int r16 = r14 + 1;
        if (r16 >= b()) goto L17;
        T r17 = r15[r16];
        he.i.c(r17);
        T r18 = r15[r14];
        he.i.c(r18);
        if (((Comparable) r17).compareTo(r18) >= 0) goto L17;
        r14 = r16;
    L17:
        T r19 = r15[r8];
        he.i.c(r19);
        T r20 = r15[r14];
        he.i.c(r20);
        if (((Comparable) r19).compareTo(r20) <= 0) goto L21;
        e(r8, r14);
        r8 = r14;
    L21:
        T r21 = r10[b()];
        he.i.c(r21);
        r21.a(null);
        r21.setIndex(-1);
        r10[b()] = null;
        return r21;
    }

    public final void d(int r8) {
    L2:
        if (r8 <= 0) goto L3;
        T[] r10 = this.f12635a;
        he.i.c(r10);
        int r11 = (r8 - 1) / 2;
        T r12 = r10[r11];
        he.i.c(r12);
        T r13 = r10[r8];
        he.i.c(r13);
        if (((Comparable) r12).compareTo(r13) <= 0) goto L6;
        e(r8, r11);
        r8 = r11;
        goto L2
    L6:
        return;
    }

    public final void e(int r8, int r10) {
        T[] r11 = this.f12635a;
        he.i.c(r11);
        T r12 = r11[r10];
        he.i.c(r12);
        T r13 = r11[r8];
        he.i.c(r13);
        r11[r8] = r12;
        r11[r10] = r13;
        r12.setIndex(r8);
        r13.setIndex(r10);
    }
}
