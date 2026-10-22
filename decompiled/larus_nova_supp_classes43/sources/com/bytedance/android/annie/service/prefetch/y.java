package com.bytedance.android.annie.service.prefetch;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.tools.prefetch.ProcessManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.bytedance.ies.tools.prefetch.i.a b;

    public y(String r1, ProcessManager.b r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void accept(Object r10) {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m("PrefetchNetwork", "succeed: " + this.a, null, null, 12);
        this.b.b((com.bytedance.ies.tools.prefetch.i.b) r10);
    }
}
