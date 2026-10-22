package com.bytedance.android.btm.impl.page.lifecycle.layer1_outer;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmActivityLifecycleCallbackV2$a implements Runnable {
    public final /* synthetic */ Activity a;

    public BtmActivityLifecycleCallbackV2$a(Activity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BtmActivityLifecycleCallbackV2 r0 = BtmActivityLifecycleCallbackV2.a;     // Catch: Throwable -> L4
        Activity r1 = this.a;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        BtmActivityLifecycleCallbackV2.a(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
