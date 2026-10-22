package a74;

import com.bytedance.android.live.profile.monitor.DataType;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Runnable {
    public final /* synthetic */ JSONObject a;

    public c(JSONObject r1) {
        this.a = r1;
    }

    public final void a() {
        Object r2 = e.b;     // Catch: Throwable -> L35
        monitor-enter(r2);     // Catch: Throwable -> L35
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L6:
        if (e.d == true) goto L10;
    L7:
        monitor-exit(r2);     // Catch: Throwable -> L32
    L8:
        e.c.set(false);
        e.b();
        return;
    L10:
        long r3 = e.e;     // Catch: Throwable -> L32
        com.bytedance.badger.v.d.f0.getClass();     // Catch: Throwable -> L32
        com.bytedance.badger.v.k r5 = com.bytedance.badger.v.d.b0;     // Catch: Throwable -> L32
        KProperty r6 = com.bytedance.badger.v.d.a[54];     // Catch: Throwable -> L32
        if (r3 >= ((Number) r5.a()).longValue()) goto L7;
        JSONObject r4 = this.a;     // Catch: Throwable -> L32
        if (r4 == null) goto L17;
        String r7 = r4.optString(DataType.TRUE, "");     // Catch: Throwable -> L32
    L18:
        JSONObject r8 = this.a;     // Catch: Throwable -> L32
        if (r8 == null) goto L22;
        String r9 = r8.optString("2", "");     // Catch: Throwable -> L32
    L24:
        if (r7.isEmpty() == true) goto L27;
        e.g.addLast(r7);     // Catch: Throwable -> L32
    L27:
        if (r9.isEmpty() == true) goto L29;
        e.h.addLast(r9);     // Catch: Throwable -> L32
    L29:
        e.e++;     // Catch: Throwable -> L32
        com.bytedance.badger.e.f("event_behavior# ", "complete batch =" + e.e);     // Catch: Throwable -> L32
        goto L7
    L22:
        r9 = "";
        goto L24
    L17:
        r7 = "";
    L35:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "onCompleted store failed: " + th.getMessage());     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        e.c.set(false);
        e.b();
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
