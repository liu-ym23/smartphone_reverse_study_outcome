package com.ss.ugc.clientai.common;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f15808a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.ss.ugc.clientai.common.a.b f15809b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static com.ss.ugc.clientai.common.a.b f15810a;

        static {
            f15810a = new com.ss.ugc.clientai.common.a.b();
        }
    }

    static {
        f15808a = com.ss.ugc.clientai.common.a.a();
        f15809b = null;
    }

    public b() {
    }

    private static com.ss.ugc.clientai.common.a.b a() {
        com.ss.ugc.clientai.common.a.b r0 = f15809b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (com.ss.ugc.clientai.common.a.f15807b == null) goto L21;
        monitor-enter(b.class);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (f15809b != null) goto L14;
        com.ss.ugc.clientai.common.a.b r1 = com.ss.ugc.clientai.common.a.f15807b.c();     // Catch: Throwable -> L17
        f15809b = r1;     // Catch: Throwable -> L17
        if (r1 != null) goto L14;
        f15809b = a.f15810a;     // Catch: Throwable -> L17
    L14:
        monitor-exit(b.class);     // Catch: Throwable -> L17
        return f15809b;
    L21:
        return a.f15810a;
    }

    public static void a(String r1, String r2) {
        a().a(r1, r2);
    }

    public static void a(String r1, String r2, Throwable r3) {
        a().a(r1, r2, r3);
    }

    public static void b(String r1, String r2) {
        a(r1, r2, null);
    }

    public static void b(String r1, String r2, Throwable r3) {
        a().b(r1, r2, r3);
    }

    public static void c(String r1, String r2) {
        b(r1, r2, null);
    }
}
