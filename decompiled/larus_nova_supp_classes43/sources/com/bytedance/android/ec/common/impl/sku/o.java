package com.bytedance.android.ec.common.impl.sku;

import androidx.core.widget.NestedScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o implements Runnable {
    public final /* synthetic */ NestedScrollView a;

    public o(NestedScrollView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NestedScrollView r0 = this.a;     // Catch: Throwable -> L4
        r0.scrollTo(0, r0.getBottom());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
