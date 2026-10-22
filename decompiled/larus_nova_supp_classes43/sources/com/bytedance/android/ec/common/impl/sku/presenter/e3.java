package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.core.sku.CommonMarqueeView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e3 implements Runnable {
    public final /* synthetic */ f3 a;

    public e3(f3 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommonMarqueeView r0 = this.a.g;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.requestLayout();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
