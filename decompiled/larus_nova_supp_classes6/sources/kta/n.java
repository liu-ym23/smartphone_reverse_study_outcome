package kta;

import android.content.Context;
import android.os.SystemClock;
import e84.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import jta.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n {
    public static n b;
    public final Context a;

    public final Map a() {
        long r1 = 100;
        if (g.f() == true) goto L5;
        s r0 = s.b(this.a);
        HashMap r4 = null;
        if (r0.c == false) goto L28;
        r0.a();
        p r3 = r0.g;
        if (r3 != null) goto L23;
        SystemClock.elapsedRealtime();
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        SystemClock.elapsedRealtime();
    L20:
        th = move-exception;
        SystemClock.elapsedRealtime();
        throw th;
    L13:
        if ((r0.a instanceof i) == false) goto L15;
        r1 = 200;
    L15:
        p r2 = r0.f.get(r1, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L17
        SystemClock.elapsedRealtime();
        r3 = r2;
    L23:
        if (r3 != null) goto L25;
        r3 = r0.g;
    L25:
        if (r3 == null) goto L27;
        HashMap r5 = new HashMap();
        s.d(r5, "id", r3.a);
        s.d(r5, "req_id", r3.b);
        s.d(r5, "is_track_limited", String.valueOf(r3.c));
        s.d(r5, "take_ms", String.valueOf(r3.d));
        s.d(r5, "time", String.valueOf(r3.e));
        s.d(r5, "query_times", String.valueOf(r3.f));
        s.d(r5, "hw_id_version_code", String.valueOf(r3.g));
        r4 = r5;
    L27:
        Objects.toString(r4);
    L28:
        return r4;
    L5:
        return k.e(this.a).b(100);
    }

    public final String b() {
        if (g.f() == true) goto L5;
        s r0 = s.b(this.a);
        r0.a();
        p r1 = r0.g;
        if (r1 == null) goto L9;
        String r2 = r1.a;
    L11:
        return r2;
    L9:
        r2 = null;
        goto L11
    L5:
        return k.e(this.a).c();
    }

    public n(Context r1) {
        this.a = r1.getApplicationContext();
    }

    public static n c(Context r2) {
        if (b != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new n(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }
}
