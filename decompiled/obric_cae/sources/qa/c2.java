package qa;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile c2 f10254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f10255h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LongSparseArray<a> f10256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LongSparseArray<a> f10257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LongSparseArray<a> f10258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LongSparseArray<a> f10259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f10260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f10261f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10264c;

        public a() {
        }
    }

    static {
        f10255h = new Object();
    }

    public c2() {
        this.f10260e = new Object();
        this.f10261f = new Object();
        this.f10256a = new LongSparseArray();
        this.f10257b = new LongSparseArray();
        this.f10258c = new LongSparseArray();
        this.f10259d = new LongSparseArray();
    }

    public static c2 a() {
        if (f10254g != null) goto L15;
        Object r8 = f10255h;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f10254g != null) goto L9;
        f10254g = new c2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L11
    L15:
        return f10254g;
    }

    public static short b(LongSparseArray<a> r8, long r10) {
        monitor-enter(r8);
        a r11 = r8.get(r10);     // Catch: Throwable -> L14
        if (r11 != null) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L14
        return 0;
    L8:
        short r12 = (short) Math.max(1, Math.min(32767, (SystemClock.elapsedRealtime() - r11.f10263b) / 1000));     // Catch: Throwable -> L14
        if (r11.f10264c == true) goto L12;
        r12 = (short) (-r12);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return r12;
    L14:
        th = move-exception;
        throw th;
    }

    public static void d(ArrayList r8, LongSparseArray r10, LongSparseArray r11) {
        long r12 = SystemClock.elapsedRealtime();
        int r13 = r10.size();
        Iterator r14 = r8.iterator();
        if (r13 != 0) goto L9;
    L5:
        if (r14.hasNext() == false) goto L7;
        b2 r15 = (b2) r14.next();
        a r16 = new a();
        r16.f10262a = r15.b();
        r16.f10263b = r12;
        r16.f10264c = false;
        r11.put(r15.a(), r16);
        goto L5
    L7:
        return;
    L9:
        if (r14.hasNext() == false) goto L17;
        b2 r17 = (b2) r14.next();
        long r18 = r17.a();
        a r19 = (a) r10.get(r18);
        if (r19 != null) goto L14;
        r19 = new a();
    L15:
        r19.f10262a = r17.b();
        r19.f10263b = r12;
        r19.f10264c = true;
    L16:
        r11.put(r18, r19);
        goto L9
    L14:
        if (r19.f10262a == r17.b()) goto L16;
    }

    public final void c(ArrayList r8) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        Object r10 = this.f10260e;
        monitor-enter(r10);
        d(r8, this.f10256a, this.f10257b);     // Catch: Throwable -> L10
        LongSparseArray<a> r11 = this.f10256a;     // Catch: Throwable -> L10
        this.f10256a = this.f10257b;     // Catch: Throwable -> L10
        this.f10257b = r11;     // Catch: Throwable -> L10
        r11.clear();     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(ArrayList r8) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        Object r10 = this.f10261f;
        monitor-enter(r10);
        d(r8, this.f10258c, this.f10259d);     // Catch: Throwable -> L10
        LongSparseArray<a> r11 = this.f10258c;     // Catch: Throwable -> L10
        this.f10258c = this.f10259d;     // Catch: Throwable -> L10
        this.f10259d = r11;     // Catch: Throwable -> L10
        r11.clear();     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
