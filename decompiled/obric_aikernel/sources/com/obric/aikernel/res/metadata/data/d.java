package com.obric.aikernel.res.metadata.data;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5091a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f5092b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f5093c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, a> f5094d = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f5095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5096b;

        public a() {
            this.f5095a = new Object();
        }

        public final Object a() {
            return this.f5095a;
        }

        public final int b() {
            return this.f5096b;
        }

        public final void c(int r10) {
            this.f5096b = r10;
        }
    }

    static {
        f5091a = new d();
        f5092b = new ConcurrentHashMap();
        f5093c = new Object();
        f5094d = new LinkedHashMap();
    }

    private d() {
    }

    private final String a(String r10, String r11, long r12) {
        return r10 + 0 + r11 + 0 + r12;
    }

    public static /* synthetic */ void d(d r10, String r11, String r12, long r13, long r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L5;
        r14 = SystemClock.elapsedRealtime();
    L5:
        r10.c(r11, r12, r13, r14);
    }

    public static /* synthetic */ boolean f(d r10, String r11, String r12, long r13, long r14, int r15, Object r16) {
        if ((r15 & 8) == 0) goto L6;
        r14 = SystemClock.elapsedRealtime();
    L6:
        return r10.e(r11, r12, r13, r14);
    }

    public final void b(String r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "md5");
        f5092b.remove(a(r10, r11, r12));
    }

    public final void c(String r10, String r11, long r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "md5");
        Long r14 = Long.valueOf(r13);
        f5092b.put(a(r10, r11, r12), r14);
    }

    public final boolean e(String r10, String r11, long r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "md5");
        Long r14 = f5092b.get(a(r10, r11, r12));
        if (r14 != null) goto L5;
        return false;
    L5:
        long r15 = r13 - r14.longValue();
        if (0 <= r15) goto L8;
        return false;
    L8:
        if (r15 >= 3600000) goto L12;
        return true;
    L12:
        return false;
    }

    public final <T> T g(String r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "block");
        Object r12 = f5093c;
        monitor-enter(r12);
        Map<String, a> r13 = f5094d;     // Catch: Throwable -> L42
        a r14 = r13.get(r10);     // Catch: Throwable -> L42
        if (r14 != null) goto L7;
        r14 = new a();     // Catch: Throwable -> L42
        r13.put(r10, r14);     // Catch: Throwable -> L42
    L7:
        a r15 = r14;     // Catch: Throwable -> L42
        r15.c(r15.b() + 1);     // Catch: Throwable -> L42
        a r16 = r14;     // Catch: Throwable -> L42
        monitor-exit(r12);
        Object r17 = r16.a();     // Catch: Throwable -> L28
        monitor-enter(r17);     // Catch: Throwable -> L28
        T r18 = r11.invoke();     // Catch: Throwable -> L25
        monitor-exit(r17);     // Catch: Throwable -> L28
        monitor-enter(r12);
        r16.c(r16.b() - 1);     // Catch: Throwable -> L22
        if (r16.b() == 0) goto L17;
    L19:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r12);
        return r18;
    L17:
        if (r13.get(r10) != r16) goto L19;
        r13.remove(r10);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        monitor-enter(f5093c);
        r16.c(r16.b() - 1);     // Catch: Throwable -> L39
        if (r16.b() != 0) goto L36;
        Map<String, a> r20 = f5094d;     // Catch: Throwable -> L39
        if (r20.get(r10) != r16) goto L36;
        r20.remove(r10);     // Catch: Throwable -> L39
    L36:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L39
        throw th;
    L39:
        th = move-exception;
        throw th;
    L42:
        th = move-exception;
        throw th;
    }
}
