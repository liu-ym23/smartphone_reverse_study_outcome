package llc;

import bytekn.foundation.logger.Logger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final ConcurrentHashMap<String, Pair<c0.b, Object>> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static void a(String r11, String r12) {
        ConcurrentHashMap<String, Pair<c0.b, Object>> r2 = a;
        Pair<c0.b, Object> r3 = r2.get(r11);
        if (r3 == null) goto L19;
        Object r4 = r3.getSecond();
        monitor-enter(r4);
        r3.getSecond().notify();     // Catch: Throwable -> L11 Exception -> L13
        int r5 = ((c0.b) r3.getFirst()).a();     // Catch: Throwable -> L11 Exception -> L13
        if (((c0.b) r3.getFirst()).b() != 0) goto L9;
        Logger.INSTANCE.d("LLL", "[结束][" + r12 + "][" + r11 + "][清空]");     // Catch: Throwable -> L11 Exception -> L13
        r2.remove(r11);     // Catch: Throwable -> L11 Exception -> L13
    L22:
    L15:
        monitor-exit(r4);
        return;
    L9:
        Logger.e$default(Logger.INSTANCE, "LLL", "[结束][" + r12 + "][" + r11 + "][" + r5 + ']', null, 4, null);     // Catch: Throwable -> L11 Exception -> L13
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L11 Exception -> L13
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        goto L15
    }

    public static void b(String r6, String r7) {
        monitor-enter(a.class);
        ConcurrentHashMap<String, Pair<c0.b, Object>> r2 = a;     // Catch: Throwable -> L30
        if (r2.get(r6) != null) goto L9;
        Logger.INSTANCE.d("LLL", "[开始][" + r7 + "][" + r6 + "][空]");     // Catch: Throwable -> L30
        r2.put(r6, new Pair(new c0.b(1), new Object()));     // Catch: Throwable -> L30
        monitor-exit(a.class);
        return;
    L9:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(a.class);
        Logger.INSTANCE.w("LLL", "[开始][" + r7 + "][" + r6 + "][等等]");
        Pair<c0.b, Object> r8 = r2.get(r6);
        if (r8 == null) goto L14;
        Object r9 = r8.getSecond();
    L15:
        if (r9 == null) goto L29;
        Object r10 = r8.getSecond();
        monitor-enter(r10);
        ((c0.b) r8.getFirst()).a.incrementAndGet();     // Catch: Throwable -> L20 Exception -> L22
        r8.getSecond().wait();     // Catch: Throwable -> L20 Exception -> L22
    L24:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r10);
        return;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L29:
        return;
    L14:
        r9 = null;
    L30:
        th = move-exception;
        throw th;
    }
}
