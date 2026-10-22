package fb0;

import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a implements j {
    public static final WeakHashMap<a, Object> h = null;
    public static final ThreadLocal i = null;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public c g;

    public a() {
        this(0);
    }

    public abstract int b();

    public abstract boolean d(e r1);

    static {
        h = new WeakHashMap();
        i = new ThreadLocal();
    }

    public void e() {
        c r0 = this.g;
        if (r0 != null) goto L5;
    L23:
        this.b = 0;
        this.g = null;
        return;
    L5:
        if (this.a == (-1)) goto L23;
        e r1 = (e) r0;
        boolean r4 = true;
        if (this.b == 1) goto L10;
        r4 = false;
    L10:
        if (r4 == false) goto L22;
        h r2 = r1.s;
        monitor-enter(r2);
        h r3 = r1.s;     // Catch: Throwable -> L19
        int r5 = this.a;     // Catch: Throwable -> L19
        int[] r6 = r3.a;     // Catch: Throwable -> L19
        int r7 = r6.length;     // Catch: Throwable -> L19
        int r8 = r3.b;     // Catch: Throwable -> L19
        if (r7 != r8) goto L16;
        int[] r9 = new int[r8 + r8];     // Catch: Throwable -> L19
        System.arraycopy(r6, 0, r9, 0, r8);     // Catch: Throwable -> L19
        r3.a = r9;     // Catch: Throwable -> L19
    L16:
        int[] r11 = r3.a;     // Catch: Throwable -> L19
        int r12 = r3.b;     // Catch: Throwable -> L19
        r3.b = r12 + 1;     // Catch: Throwable -> L19
        r11[r12] = r5;     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        this.a = -1;
        goto L23
    }

    public final void finalize() {
        ThreadLocal r0 = i;
        r0.set(a.class);
        e();
        r0.set(null);
    }

    public int a() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public a(int r2) {
        this.c = -1;
        this.d = -1;
        this.g = null;
        this.a = 0;
        this.b = 0;
        WeakHashMap<a, Object> r0 = h;
        monitor-enter(r0);
        r0.put(this, null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(int r3, int r4) {
        this.c = r3;
        this.d = r4;
        if (r3 <= 0) goto L5;
        int r5 = d.a(r3);
    L6:
        this.e = r5;
        if (r4 <= 0) goto L9;
        int r6 = d.a(r4);
    L10:
        this.f = r6;
        int r7 = this.e;
        if (r7 > 4096) goto L13;
        if (r6 > 4096) goto L13;
        return;
    L13:
        String.format("secondBitmap is too large: %d x %d", new Object[]{Integer.valueOf(r7), Integer.valueOf(this.f)});
        new Exception();
        return;
    L9:
        r6 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }
}
