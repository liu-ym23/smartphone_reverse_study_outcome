package com.bytedance.android.ec.core.imagex;

import com.bytedance.pitaya.api.feature.FeatureCoreFactory;
import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.pitaya.api.feature.IKVStore;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e0 implements Runnable {
    public final /* synthetic */ String a;

    public e0(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L17:
        IFeatureCore r0 = j0.a;     // Catch: Throwable -> L12
        if (j0.a != null) goto L5;
    L6:
        j0.a = FeatureCoreFactory.INSTANCE.getFeatureCore(this.a);     // Catch: Throwable -> L12
        IFeatureCore r1 = j0.a;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        IKVStore r10 = r1.createInMemoryKVStore("ecom_home_fast_scroll_recognize");     // Catch: Throwable -> L12
    L10:
        j0.b = r10;     // Catch: Throwable -> L12
        goto L17
    L9:
        r10 = null;
        goto L10
    L5:
        if (j0.b == null) goto L6;
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
