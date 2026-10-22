package com.bytedance.apm.launch;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f1414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm.trace.b.a f1415b;

    /* JADX INFO: renamed from: com.bytedance.apm.launch.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.launch.a$a, reason: collision with other inner class name */
    private static final class C0092a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1416a = null;

        static {
            f1416a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1416a;
        }
    }

    private a() {
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return C0092a.a();
    }

    public void a(String r2) {
        Log.e("LaunchAnalysis", "notice!!!+ " + r2);
    }

    public synchronized c b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f1414a != null) goto L6;
        this.f1414a = new c.a().a();     // Catch: Throwable -> L9
    L6:
        c r0 = this.f1414a;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public void b(String r1) {
        if (com.bytedance.apm.b.k() == false) goto L6;
        Log.d("LaunchAnalysis", r1);
        return;
    }

    public synchronized com.bytedance.apm.trace.b.a c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f1415b != null) goto L6;
        this.f1415b = new com.bytedance.apm.trace.b.a.C0093a().a();     // Catch: Throwable -> L9
    L6:
        com.bytedance.apm.trace.b.a r0 = this.f1415b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }
}
