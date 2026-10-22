package gta;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.f0;
import com.ss.android.common.applog.k0;
import com.ss.android.common.applog.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public Context a;

    public final void a() {
        SharedPreferences.Editor r1 = this.a.getSharedPreferences(kta.b.a, 0).edit();     // Catch: Throwable -> L5
        r1.putString("key_task_session", "");     // Catch: Throwable -> L5
        r1.apply();     // Catch: Throwable -> L5
        return;
    }

    public b(Context r2) {
        this.a = r2.getApplicationContext();
        f0.a(r2);
        k0.d().b(new a(this));
    }

    public final void b(g r5) {
        f0 r0 = f0.a(this.a);
        r0.getClass();
        if (r5 != null) goto L5;
        g r6 = null;
    L6:
        if (r6 == null) goto L11;
        v r1 = new v();
        r1.a = r6;
        Context r7 = r0.a;
        AppLog r8 = AppLog.g0.e(r7);
        if (r8 == null) goto L12;
        r8.j(r1);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        g r2 = new g();
        r2.a = r5.a;
        r2.b = r5.b;
        r2.c = r5.c;
        r2.d = r5.d;
        r2.e = r5.e;
        r2.f = r5.f;
        r2.g = r5.g;
        r2.h = r5.h;
        r2.i = r5.i;
        r6 = r2;
        goto L6
    }
}
