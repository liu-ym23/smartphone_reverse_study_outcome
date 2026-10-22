package a74;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements q {
    public d() {
    }

    @Override // a74.q
    public final void a(JSONObject r3) {
        com.bytedance.badger.utils.m.a().b(new c(r3));
    }

    @Override // a74.q
    public final void a(String r4) {
        com.bytedance.badger.e.g("event_behavior# ", "collect error: " + r4);
        Object r5 = e.b;
        monitor-enter(r5);
        e.d = false;     // Catch: Throwable -> L11
        e.a = 0;     // Catch: Throwable -> L11
        e.f = false;     // Catch: Throwable -> L11
        e.e = 0;     // Catch: Throwable -> L11
        e.g.clear();     // Catch: Throwable -> L11
        e.h.clear();     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        e.c.set(false);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
