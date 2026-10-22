package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Runnable {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static void a() {
        Pair r0 = TuplesKt.to(Integer.valueOf(s1.q(s1.getContext()).widthPixels), Integer.valueOf(s1.q(s1.getContext()).heightPixels));
        StringBuilder r1 = new StringBuilder();
        r1.append(((Number) r0.getFirst()).intValue());
        r1.append('*');
        r1.append(((Number) r0.getSecond()).intValue());
        String r2 = r1.toString();
        FeatureManager r3 = FeatureManager.u;
        if (z90.a.C0301a.a(r3, "real_metrics", r2) == false) goto L6;
        int r4 = ((Number) r0.getFirst()).intValue();
        int r5 = ((Number) r0.getSecond()).intValue();
        z90.a.C0301a.a(r3, "real_metrics_width", Integer.valueOf(r4));
        z90.a.C0301a.a(r3, "real_metrics_height", Integer.valueOf(r5));
        int r6 = Math.max(r4, r5);
        int r7 = Math.min(r4, r5);
        z90.a.C0301a.a(r3, "real_metrics_long", Integer.valueOf(r6));
        z90.a.C0301a.a(r3, "real_metrics_short", Integer.valueOf(r7));
        return;
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
