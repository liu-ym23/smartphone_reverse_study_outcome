package androidx.work;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f2928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile m f2929b;

    public static class a extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2930c;

        public a(int r8) {
            this.f2930c = r8;
        }

        @Override // androidx.work.m
        public final void a(String r8, String r10) {
            if (this.f2930c > 3) goto L6;
            Log.d(r8, r10);
            return;
        }

        @Override // androidx.work.m
        public final void b(String r8, String r10) {
            if (this.f2930c > 6) goto L6;
            Log.e(r8, r10);
            return;
        }

        @Override // androidx.work.m
        public final void c(String r8, String r10, Throwable r11) {
            if (this.f2930c > 6) goto L6;
            Log.e(r8, r10, r11);
            return;
        }

        @Override // androidx.work.m
        public final void e(String r8, String r10) {
            if (this.f2930c > 4) goto L6;
            Log.i(r8, r10);
            return;
        }

        @Override // androidx.work.m
        public final void g(String r8, String r10) {
            if (this.f2930c > 5) goto L6;
            Log.w(r8, r10);
            return;
        }
    }

    static {
        f2928a = new Object();
    }

    public m() {
    }

    public static m d() {
        Object r8 = f2928a;
        monitor-enter(r8);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f2929b != null) goto L7;
        f2929b = new a(3);     // Catch: Throwable -> L10
    L7:
        m r10 = f2929b;     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r10;
    }

    public static String f(String r8) {
        int r10 = r8.length();
        StringBuilder r11 = new StringBuilder(23);
        r11.append("WM-");
        if (r10 < 20) goto L5;
        r8 = r8.substring(0, 20);
    L5:
        r11.append(r8);
        return r11.toString();
    }

    public abstract void a(String r8, String r10);

    public abstract void b(String r8, String r10);

    public abstract void c(String r8, String r10, Throwable r11);

    public abstract void e(String r8, String r10);

    public abstract void g(String r8, String r10);
}
