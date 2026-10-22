package kotlinx.coroutines;

import kotlin.Unit;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class r0$c implements Runnable, Comparable<r0$c>, m0, kotlinx.coroutines.internal.h0 {
    private volatile Object _heap;
    public long a;
    public int b;

    public final void dispose() {
        monitor-enter(this);
        Object r0 = this._heap;     // Catch: Throwable -> L16
        b0 r1 = t0.a;     // Catch: Throwable -> L16
        if (r0 != r1) goto L8;
        monitor-exit(this);
        return;
    L8:
        if ((r0 instanceof r0$d) == false) goto L10;
        r0$d r2 = (r0$d) r0;     // Catch: Throwable -> L16
    L11:
        if (r2 == null) goto L13;
        r2.d(this);     // Catch: Throwable -> L16
    L13:
        this._heap = r1;     // Catch: Throwable -> L16
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L10:
        r2 = null;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.internal.h0
    public final kotlinx.coroutines.internal.g0<?> a() {
        Object r0 = this._heap;
        if ((r0 instanceof kotlinx.coroutines.internal.g0) == true) goto L7;
        return null;
    L7:
        return (kotlinx.coroutines.internal.g0) r0;
    }

    public String toString() {
        return "Delayed[nanos=" + this.a + ']';
    }

    @Override // kotlinx.coroutines.internal.h0
    public final int getIndex() {
        return this.b;
    }

    public r0$c(long r1) {
        this.a = r1;
        this.b = -1;
    }

    @Override // kotlinx.coroutines.internal.h0
    public final void c(r0$d r3) {
        if (this._heap == t0.a) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this._heap = r3;
        return;
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // java.lang.Comparable
    public final int compareTo(r0$c r5) {
        long r0 = this.a - r5.a;
        if (r0 <= 0) goto L5;
        return 1;
    L5:
        if (r0 >= 0) goto L7;
        return -1;
    L7:
        return 0;
    }

    @Override // kotlinx.coroutines.internal.h0
    public final void setIndex(int r1) {
        this.b = r1;
    }

    public final int d(long r9, r0$d r11, r0 r12) {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (this._heap != t0.a) goto L8;
        monitor-exit(this);
        return 2;
    L8:
        monitor-enter(r11);     // Catch: Throwable -> L40
        Object[] r0 = r11.a;     // Catch: Throwable -> L12
        if (r0 == null) goto L14;
        Object r1 = r0[0];     // Catch: Throwable -> L12
    L15:
        r0$c r2 = (r0$c) r1;     // Catch: Throwable -> L12
        if (r0.w(r12) == false) goto L22;
        monitor-exit(r11);     // Catch: Throwable -> L40
        monitor-exit(this);
        return 1;
    L22:
        if (r2 != null) goto L24;
        r11.c = r9;     // Catch: Throwable -> L12
    L31:
        long r10 = this.a;     // Catch: Throwable -> L12
        long r4 = r11.c;     // Catch: Throwable -> L12
        if ((r10 - r4) >= 0) goto L34;
        this.a = r4;     // Catch: Throwable -> L12
    L34:
        r11.a(this);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L40
        monitor-exit(this);
        return 0;
    L24:
        long r5 = r2.a;     // Catch: Throwable -> L12
        if ((r5 - r9) >= 0) goto L29;
        r9 = r5;
    L29:
        if ((r9 - r11.c) <= 0) goto L31;
        r11.c = r9;     // Catch: Throwable -> L12
        goto L31
    L14:
        r1 = null;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    }
}
