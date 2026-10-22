package n4a;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o2 {
    public static volatile o2 g;
    public static final Object h = null;
    public LongSparseArray<a> a;
    public LongSparseArray<a> b;
    public LongSparseArray<a> c;
    public LongSparseArray<a> d;
    public final Object e;
    public final Object f;

    public static class a {
        public int a;
        public long b;
        public boolean c;

        public a() {
        }
    }

    static {
        h = new Object();
    }

    public o2() {
        this.e = new Object();
        this.f = new Object();
        this.a = new LongSparseArray();
        this.b = new LongSparseArray();
        this.c = new LongSparseArray();
        this.d = new LongSparseArray();
    }

    public static o2 a() {
        if (g != null) goto L15;
        Object r0 = h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new o2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public final void c(List<n2> r4) {
        if (((ArrayList) r4).isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.e;
        monitor-enter(r0);
        d(r4, this.a, this.b);     // Catch: Throwable -> L10
        LongSparseArray<a> r5 = this.a;     // Catch: Throwable -> L10
        this.a = this.b;     // Catch: Throwable -> L10
        this.b = r5;     // Catch: Throwable -> L10
        r5.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(List<n2> r4) {
        if (((ArrayList) r4).isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.f;
        monitor-enter(r0);
        d(r4, this.c, this.d);     // Catch: Throwable -> L10
        LongSparseArray<a> r5 = this.c;     // Catch: Throwable -> L10
        this.c = this.d;     // Catch: Throwable -> L10
        this.d = r5;     // Catch: Throwable -> L10
        r5.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static short b(LongSparseArray<a> r4, long r5) {
        monitor-enter(r4);
        a r6 = r4.get(r5);     // Catch: Throwable -> L14
        if (r6 != null) goto L8;
        monitor-exit(r4);     // Catch: Throwable -> L14
        return 0;
    L8:
        short r7 = (short) Math.max(1, Math.min(32767, (SystemClock.elapsedRealtime() - r6.b) / 1000));     // Catch: Throwable -> L14
        if (r6.c == true) goto L12;
        r7 = (short) (-r7);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r4);     // Catch: Throwable -> L14
        return r7;
    L14:
        th = move-exception;
        throw th;
    }

    public static void d(List<n2> r8, LongSparseArray<a> r9, LongSparseArray<a> r10) {
        long r0 = SystemClock.elapsedRealtime();
        int r2 = r9.size();
        Iterator r11 = ((ArrayList) r8).iterator();
        if (r2 != 0) goto L9;
    L5:
        if (r11.hasNext() == false) goto L7;
        n2 r12 = (n2) r11.next();
        a r3 = new a();
        r3.a = r12.b();
        r3.b = r0;
        r3.c = false;
        r10.put(r12.a(), r3);
        goto L5
    L7:
        return;
    L9:
        if (r11.hasNext() == false) goto L17;
        n2 r4 = (n2) r11.next();
        long r5 = r4.a();
        a r6 = r9.get(r5);
        if (r6 != null) goto L14;
        r6 = new a();
    L15:
        r6.a = r4.b();
        r6.b = r0;
        r6.c = true;
    L16:
        r10.put(r5, r6);
        goto L9
    L14:
        if (r6.a == r4.b()) goto L16;
    }
}
