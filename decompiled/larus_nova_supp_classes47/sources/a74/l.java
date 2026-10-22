package a74;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements q {
    public final /* synthetic */ m a;

    public l(m r1) {
        this.a = r1;
    }

    @Override // a74.q
    public final void a(String r4) {
        this.a.c.a(r4);     // Catch: Throwable -> L6
        com.bytedance.badger.utils.m r5 = com.bytedance.badger.utils.m.a();
        Runnable r0 = new k();
    L5:
        r5.b(r0);
        return;
    L6:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "callback onError failed: " + th.getMessage());     // Catch: Throwable -> L11
        r5 = com.bytedance.badger.utils.m.a();
        r0 = new k();
    L11:
        th = move-exception;
        com.bytedance.badger.utils.m.a().b(new k());
        throw th;
    }

    @Override // a74.q
    public final void a(final JSONObject r6) {
        com.bytedance.badger.e.f("event_behavior# ", "collect complete... " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L5
        com.bytedance.badger.utils.m r1 = com.bytedance.badger.utils.m.a();     // Catch: Throwable -> L5
        final m r3 = this.a;     // Catch: Throwable -> L5
        r1.b(new i(r3, r6));     // Catch: Throwable -> L5
        com.bytedance.badger.utils.m r7 = com.bytedance.badger.utils.m.a();
        Runnable r0 = new j();
    L8:
        r7.b(r0);
        return;
    L5:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "callback onCompleted failed: " + th.getMessage());     // Catch: Throwable -> L10
        r7 = com.bytedance.badger.utils.m.a();
        r0 = new j();
    L10:
        th = move-exception;
        com.bytedance.badger.utils.m.a().b(new j());
        throw th;
    }
}
