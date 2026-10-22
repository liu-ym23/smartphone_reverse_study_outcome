package com.bytedance.android.live.recharge.widget;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements Runnable {
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.f a;
    public final /* synthetic */ RechargeCouponBarWidget.b b;

    public j(com.bytedance.android.live.recharge.deal.f r1, RechargeCouponBarWidget.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.zq(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
