package com.ss.android.lark.featuregatingv2impl.handler;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregatingv2impl.statistics.metrics.FeatureGatingMetricsTracker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeatureGatingMetricsTracker r0 = FeatureGatingMetricsTracker.a;     // Catch: Throwable -> L4
        FeatureGatingMetricsTracker.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
