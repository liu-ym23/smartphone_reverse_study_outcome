package ms.bd.c;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class n2 {
    public static volatile long a;
    public static volatile long b;
    public static volatile long c;
    public static volatile boolean d;
    public static final ConcurrentHashMap e = null;
    public static final j2 f = null;

    static {
        e = new ConcurrentHashMap();
        f = new j2();
    }

    public static synchronized k2 a(String r9) {
        monitor-enter(n2.class);
        if (r9 == null) goto L23;
        if (d == true) goto L11;
        monitor-exit(n2.class);
        return null;
    L11:
        Object r1 = p2.a(67108866, 0, 0, null, null);     // Catch: Throwable -> L24
        if (r1 != null) goto L15;
        monitor-exit(n2.class);
        return null;
    L15:
        c2 r10 = (c2) e.get(r9);     // Catch: Throwable -> L24
        if (r10 != null) goto L19;
        monitor-exit(n2.class);
        return null;
    L19:
        k2 r2 = new k2(r10, d2.b.a, ((Long) r1).longValue());     // Catch: Throwable -> L24
        monitor-exit(n2.class);
        return r2;
    L23:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(Context r12, String r13) {
        monitor-enter(n2.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (d == true) goto L11;
        long r1 = System.nanoTime() / 1000;     // Catch: Throwable -> L13
        Context r10 = r12.getApplicationContext();     // Catch: Throwable -> L13
        d2 r14 = d2.b;     // Catch: Throwable -> L13
        if (r10 == null) goto L9;
        Context r5 = r10.getApplicationContext();     // Catch: Throwable -> L13
    L10:
        r14.a = r5;     // Catch: Throwable -> L13
        f.a.set(1);     // Catch: Throwable -> L13
        g3.a(r10, r13);     // Catch: Throwable -> L13
        c = System.currentTimeMillis() - r1;     // Catch: Throwable -> L13
        p2.a(16777219, 0, 0, null, r10);     // Catch: Throwable -> L13
        a = (System.nanoTime() / 1000) - r1;     // Catch: Throwable -> L13
        d = true;     // Catch: Throwable -> L13
        goto L11
    L9:
        r5 = null;
    L11:
        monitor-exit(n2.class);
    }

    public static synchronized boolean c(final Context r19, final c2 r20) {
        monitor-enter(n2.class);
        if (r19 == null) goto L40;
        if (r20 == null) goto L38;
        String r4 = r20.mAppID;     // Catch: Throwable -> L41
        if (r4 != null) goto L10;
    L12:
        final String r5 = r20.mSDKID;     // Catch: Throwable -> L41
    L13:
        if (r5 == null) goto L36;
        if (r5.length() <= 0) goto L36;
        String r6 = r20.mAdvanceInfo.get("kSt");     // Catch: Throwable -> L41
        if (r6 == null) goto L19;
        r6.equals("1");     // Catch: Throwable -> L41
    L19:
        b(r19, "metasec_ml");     // Catch: Throwable -> L41
        ConcurrentHashMap r3 = e;     // Catch: Throwable -> L41
        if (r3.containsKey(r5) == false) goto L25;
        monitor-exit(n2.class);
        return false;
    L25:
        if (r20.mDefaultReportHost.isEmpty() == true) goto L27;
        p2.a(33554449, 0, 0, r20.mDefaultReportHost, null);     // Catch: Throwable -> L41
    L27:
        String r17 = r20.toNativeValue();     // Catch: Throwable -> L41
        long r7 = System.nanoTime() / 1000;     // Catch: Throwable -> L41
        boolean r8 = ((Boolean) p2.a(67108865, 0, 0, r17, null)).booleanValue();     // Catch: Throwable -> L41
        b = (System.nanoTime() / 1000) - r7;     // Catch: Throwable -> L41
        if (r8 == true) goto L31;
        monitor-exit(n2.class);
        return false;
    L31:
        r3.put(r5, r20);     // Catch: Throwable -> L41
        ThreadMethodProxy.start(new PthreadThreadV2(new m4(r19, r20, r5), "ms/bd/c/n2"));     // Catch: Throwable -> L41
        monitor-exit(n2.class);
        return true;
    L36:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L41
    L10:
        if (r4.length() <= 0) goto L12;
        r5 = r20.mAppID;     // Catch: Throwable -> L41
        goto L13
    L38:
        throw new NullPointerException("config could not be null");     // Catch: Throwable -> L41
    L40:
        throw new NullPointerException("context could not be null");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }
}
