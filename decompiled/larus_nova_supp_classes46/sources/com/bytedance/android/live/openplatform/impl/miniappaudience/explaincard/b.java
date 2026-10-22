package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements Runnable {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap<String, zo0.f> r0 = zo0.g.a;     // Catch: Throwable -> L4
        zo0.f r1 = h.b(PerformanceScene.EXPLAIN_CARD);     // Catch: Throwable -> L4
        int r2 = zo0.f.d;     // Catch: Throwable -> L4
        r1.l("card_show_finish", null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
