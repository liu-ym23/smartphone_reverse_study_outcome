package mfc;

import android.content.Context;
import android.database.Cursor;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static volatile a b;
    public final PushMultiProcessSharedProvider.b a;

    public final long b() {
        PushMultiProcessSharedProvider.b r0 = this.a;
        r0.getClass();
        long r1 = 0;
        if (PushMultiProcessSharedProvider.h == false) goto L7;
    L19:
        r1 = r0.b.getLong("red_badge_last_request_time", 0);     // Catch: Throwable -> L23
    L26:
        goto L20
    L7:
        if (PushMultiProcessSharedProvider.a(r0.a) == false) goto L19;
        Cursor r2 = PushMultiProcessSharedProvider.b.a(r0.a.getContentResolver(), PushMultiProcessSharedProvider.c(r0.a, "red_badge_last_request_time", "long"));     // Catch: Throwable -> L23
        if (r2 == null) goto L26;
        if (r2.moveToFirst() == false) goto L16;
        long r3 = r2.getLong(0);     // Catch: Throwable -> L22
    L24:
        r2.close();     // Catch: Exception -> L21 Throwable -> L23
    L18:
        r1 = r3;
    L16:
        r3 = 0;
    L20:
        return r1;
    }

    public a(Context r1) {
        this.a = PushMultiProcessSharedProvider.e(r1.getApplicationContext());
    }

    public static synchronized a a(Context r2) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (b != null) goto L7;
        b = new a(r2);     // Catch: Throwable -> L10
    L7:
        a r3 = b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r3;
    }

    public final void c(long r3) {
        PushMultiProcessSharedProvider.a r0 = this.a.b();
        r0.b.put("red_badge_last_request_time", Long.valueOf(r3));
        r0.a();
    }
}
