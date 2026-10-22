package v8b;

import com.ss.android.lark.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static a a;

    public static synchronized a a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new a();     // Catch: Throwable -> L10
        g.a r1 = g.a;     // Catch: Throwable -> L10
    L7:
        a r2 = a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r2;
    }

    public a() {
    }
}
