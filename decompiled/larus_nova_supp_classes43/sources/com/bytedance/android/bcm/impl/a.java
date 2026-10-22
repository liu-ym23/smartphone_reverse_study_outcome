package com.bytedance.android.bcm.impl;

import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.LinkedBlockingQueue;
import kc.e;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ e a;

    public a(e r1) {
        this.a = r1;
    }

    public final void a() {
        if (BtmSetting.d.c().c().v() == false) goto L5;
        boolean r0 = BcmParamsCheckerOld.a;
        BcmParamsCheckerOld.g();
    L5:
        boolean r1 = BcmParamsCheckerOld.a;
        if (BcmParamsCheckerOld.b == false) goto L8;
    L10:
        Lazy r10 = BcmParamsCheckerOld.h;
        if (((LinkedBlockingQueue) r10.getValue()).isEmpty() == true) goto L13;
        BcmParamsCheckerOld.a((e) ((LinkedBlockingQueue) r10.getValue()).poll());
        goto L10
    L13:
        BcmParamsCheckerOld.a(this.a);
        return;
    L8:
        if (((LinkedBlockingQueue) BcmParamsCheckerOld.h.getValue()).offer(this.a) == true) goto L16;
        com.bytedance.android.bcm.impl.monitor.b.b(4000, "queue is full", null, null, null, null, 252);
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
