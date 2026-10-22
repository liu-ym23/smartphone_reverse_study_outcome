package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.core.utils.s;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ AudienceExplainCardWidget a;
    public final /* synthetic */ s b;

    public d(AudienceExplainCardWidget r1, AudienceExplainCardContextService$realShowExplainCard$2$5$runnable$1.AnonymousClass1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.t(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
