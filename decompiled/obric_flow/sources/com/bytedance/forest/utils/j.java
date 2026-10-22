package com.bytedance.forest.utils;

import android.os.AsyncTask;
import com.bytedance.geckox.logger.GeckoLogger;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f4643c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f4644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f4645b;

    static {
        f4643c = new HashMap();
        i r5 = new i();
        ConcurrentHashMap r10 = com.bytedance.iesgurd.a.f6593a;
        if (r10.get("forest-monitor") == null) goto L6;
        GeckoLogger.b("observer with forest-monitor already exist");
        return;
    L6:
        GeckoLogger.a("add observer: forest-monitor");
        r10.put("forest-monitor", r5);
    }

    public j(int r5, int r10) {
        this.f4644a = new n(r5, PoolType.f4583b);
        this.f4645b = new n(r10, PoolType.f4582a);
    }

    public final h a(a r5) {
        if (r5 == null) goto L8;
        h r10 = this.f4645b.b(r5);
        if (r10 == null) goto L7;
        return r10;
    L7:
        return this.f4644a.b(r5);
    L8:
        return null;
    }

    public final h b(a r5, boolean r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r10 == false) goto L15;
        final h r11 = this.f4645b.b(r5);
        if (r11 == null) goto L15;
        com.bytedance.forest.model.p r12 = r11.f4625a;
        if (r12 == null) goto L15;
        if (r12.isCacheProvided$forest_release() != true) goto L15;
        g r13 = q.f4656a;
        p r14 = new p(new MemoryManager$getCache$1(this, r11));
        AsyncTask.THREAD_POOL_EXECUTOR.execute(r14);
        return r11;
    L15:
        return (h) this.f4644a.f4652a.get(r5);
    }
}
