package qa;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f10836a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m4 f10837a = null;

        static {
            f10837a = new m4();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f10839b;

        public b() {
            this.f10838a = 0;
            this.f10839b = true;
        }
    }

    public m4() {
        this.f10836a = new b();
        new z();
    }

    public final void a(Context r8) {
        if (this.f10836a != null) goto L5;
        this.f10836a = new b();
    L5:
        b r10 = this.f10836a;
        r10.f10839b = z.i(r8, "a3", true);
        b r11 = this.f10836a;
        if (r8 != null) goto L9;
        r11.getClass();
    L12:
        if (c.f10249c == null) goto L14;
    L23:
        c r12 = c.f10249c;
        monitor-enter(r12);
        if (k4.f10752e != null) goto L30;
        String r13 = h.f10486b;     // Catch: Throwable -> L32
        g r14 = new g();     // Catch: Throwable -> L32
        if (k4.f10752e != null) goto L30;
        k4.f10752e = r14;     // Catch: Throwable -> L32
    L30:
        monitor-exit(r12);
        return;
    L14:
        monitor-enter(c.class);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (c.f10249c != null) goto L18;
        c.f10249c = new c(r8);     // Catch: Throwable -> L20
    L18:
        monitor-exit(c.class);     // Catch: Throwable -> L20
        goto L23
    L9:
        if (r11.f10838a > 0) goto L12;
        r11.f10838a = r8.getApplicationContext().getApplicationInfo().targetSdkVersion;
        goto L12
    }

    public final boolean b() {
        if (this.f10836a != null) goto L5;
        this.f10836a = new b();
    L5:
        b r8 = this.f10836a;
        if (r8.f10839b == false) goto L18;
        int r10 = r8.f10838a;
        if (r10 > 0) goto L11;
        r10 = 28;
    L11:
        if (r10 < 28) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L17;
        return true;
    L17:
        return false;
    L13:
        r11 = false;
        goto L14
    L18:
        return true;
    }
}
