package vxb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements fs5.a {
    public final Map<String, Object> a;

    public final void a() {
        monitor-enter(a.class);
        ((ConcurrentHashMap) this.a).clear();     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public a() {
        this.a = new ConcurrentHashMap();
    }
}
