package com.ss.android.common.b;

import android.util.Log;
import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.ss.android.common.b.a f15116a;

    /* JADX INFO: renamed from: com.ss.android.common.b.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements com.ss.android.common.b.a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.ss.android.common.b.a
        public void a(String r1, Throwable r2) {
            ALogService.vSafely("AppLog", r1);     // Catch: Throwable -> L5
            return;
        L5:
            Log.v("AppLog", r1, r2);
        }

        @Override // com.ss.android.common.b.a
        public void b(String r1, Throwable r2) {
            ALogService.dSafely("AppLog", r1);     // Catch: Throwable -> L5
            return;
        L5:
            Log.d("AppLog", r1, r2);
        }

        @Override // com.ss.android.common.b.a
        public void c(String r1, Throwable r2) {
            ALogService.iSafely("AppLog", r1);     // Catch: Throwable -> L5
            return;
        L5:
            Log.i("AppLog", r1, r2);
        }

        @Override // com.ss.android.common.b.a
        public void d(String r1, Throwable r2) {
            ALogService.eSafely("AppLog", r1, r2);     // Catch: Throwable -> L5
            return;
        L5:
            Log.e("AppLog", r1, r2);
        }
    }

    static {
        f15116a = new a(null);
    }

    public static void a(String r1) {
        a(r1, null);
    }

    public static void a(String r1, Throwable r2) {
        com.ss.android.common.b.a r0 = f15116a;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
        return;
    L5:
        Log.v("AppLog", r1, r2);
    }

    public static void b(String r1) {
        b(r1, null);
    }

    public static void b(String r1, Throwable r2) {
        com.ss.android.common.b.a r0 = f15116a;
        if (r0 == null) goto L5;
        r0.b(r1, r2);
        return;
    L5:
        Log.d("AppLog", r1, r2);
    }

    public static void c(String r1) {
        c(r1, null);
    }

    public static void c(String r1, Throwable r2) {
        com.ss.android.common.b.a r0 = f15116a;
        if (r0 == null) goto L5;
        r0.c(r1, r2);
        return;
    L5:
        Log.i("AppLog", r1, r2);
    }

    public static void d(String r1) {
        d(r1, null);
    }

    public static void d(String r1, Throwable r2) {
        com.ss.android.common.b.a r0 = f15116a;
        if (r0 == null) goto L5;
        r0.d(r1, r2);
        return;
    L5:
        Log.e("AppLog", r1, r2);
    }
}
