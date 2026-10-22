package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.impl.service.FeatureManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements Runnable {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public static void a() {
        FeatureManager r0 = FeatureManager.u;
        UserFeatureInRoomFilter r1 = UserFeatureInRoomFilter.y1;
        z90.a.C0301a.a(r0, "live_fuzzy_feedback_count", Integer.valueOf(r1.g().a("key_live_fuzzy_feedback_count")));
        z90.a.C0301a.a(r0, "live_fuzzy_comment_count", Integer.valueOf(r1.g().a("key_live_fuzzy_comment_count")));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
