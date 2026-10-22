package com.bytedance.android.ec.common.impl.sku;

import com.bytedance.android.ec.common.impl.sku.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements Runnable {
    public final /* synthetic */ PromotionAutoApplyCouponResponse a;

    public p(PromotionAutoApplyCouponResponse r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a.getToast();     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        com.bytedance.android.ec.sdk.helper.i.a.e(ECAppInfoService.e.getApplicationContext(), r0, false, false);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
