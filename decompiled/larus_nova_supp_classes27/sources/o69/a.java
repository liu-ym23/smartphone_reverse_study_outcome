package o69;

import com.bytedance.keva.Keva;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import yj4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements i {
    public a() {
    }

    public final /* synthetic */ void a() {
    }

    public final /* synthetic */ void b(int r1) {
    }

    public final /* synthetic */ void c() {
    }

    public final /* synthetic */ void d(yj4.b r1) {
    }

    public final /* synthetic */ void e() {
    }

    public final /* synthetic */ void f(int r1) {
    }

    public final /* synthetic */ void g(yj4.a r1) {
    }

    public final /* synthetic */ void h(int r1) {
    }

    public final void i(String r5, long r6, int r8) {
        g49.d.d("DoraGTimeSyncManager", "onPowerCycleInfo: cycleSessionId=" + r5 + ", utcTimeStamp=" + r6 + ", bootTimeMs=" + r8);
        String r0 = b.a;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        b.a = r5;
        if (r5.length() != 0) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L13;
        g49.d.d("DoraGTimeSyncManager", "onPowerCycleInfo: powerCycleSessionId is empty");
        return;
    L13:
        if (e.b() > 0) goto L16;
        g49.d.d("DoraGTimeSyncManager", "onPowerCycleInfo: maxSessionLimit = " + e.b() + " is invalid");
        return;
    L16:
        String r9 = b.a;
        long r10 = r6 - ((long) r8);
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        Object r11 = e.d;     // Catch: Exception -> L33
        monitor-enter(r11);     // Catch: Exception -> L33
        CopyOnWriteArrayList<String> r1 = e.b;     // Catch: Throwable -> L30
        if (r1.contains(r9) == false) goto L25;
        e.e(r9, r10);     // Catch: Throwable -> L30
        monitor-exit(r11);     // Catch: Exception -> L33
        return;
    L25:
        if (r1.size() < e.b()) goto L27;
        String r2 = r1.get(0);     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L30
        e.a(r2);     // Catch: Throwable -> L30
    L27:
        r1.add(r9);     // Catch: Throwable -> L30
        ((Keva) e.a.getValue()).storeLong("dora_g_time_sync_session_" + r9, r10);     // Catch: Throwable -> L30
        e.d();     // Catch: Throwable -> L30
        monitor-exit(r11);     // Catch: Exception -> L33
        return;
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L33:
        e = move-exception;
        g49.d.d("DoraGTimeSyncRepo", "Error adding time deviation: " + e.getMessage());
        return;
    L8:
        r7 = false;
        goto L9
    }
}
