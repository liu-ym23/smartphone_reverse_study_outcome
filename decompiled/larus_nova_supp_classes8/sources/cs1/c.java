package cs1;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static c b;
    public final HashMap<String, WeakReference<b>> a;

    public static c a() {
        if (b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public c() {
        this.a = new HashMap();
    }
}
