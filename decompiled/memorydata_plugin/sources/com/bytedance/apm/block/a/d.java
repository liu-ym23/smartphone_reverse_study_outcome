package com.bytedance.apm.block.a;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f1189b = null;
    private static volatile boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile a f1190a;

    public interface a {
        void a(long r1, long[] r3);

        boolean a();

        void b();
    }

    static {
    }

    private d() {
    }

    static /* synthetic */ a a(d r0) {
        return r0.f1190a;
    }

    public static d a() {
        if (f1189b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1189b != null) goto L9;
        f1189b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f1189b;
    }

    public void a(final long[] r3, final long r4) {
        if (this.f1190a != null) goto L6;
        return;
    L6:
        if (this.f1190a.a() == true) goto L10;
        f.a().f1197b.a(new AnonymousClass1(this, r4, r3));
        boolean r2 = true;
    L8:
        c = r2;
        return;
    L10:
        if (c == false) goto L13;
        f.a().f1197b.a(new AnonymousClass2(this));
        r2 = false;
        goto L8
    }
}
