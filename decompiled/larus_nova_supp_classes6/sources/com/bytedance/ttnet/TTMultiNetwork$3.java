package com.bytedance.ttnet;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTMultiNetwork$3 implements Runnable {
    final /* synthetic */ long val$currrentTime;
    final /* synthetic */ boolean val$enable;
    final /* synthetic */ TTMultiNetwork$Observer val$observer;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_ttnet_TTMultiNetwork$3_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_TTMultiNetwork$3__run$___twin___() {
        this.val$observer.onUserSpecifiedNetworkEnabled(this.val$enable, this.val$currrentTime);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_TTMultiNetwork$3_com_larus_apm_impl_protector_RunnableLancet_run(TTMultiNetwork$3 r1) {
        r1.com_bytedance_ttnet_TTMultiNetwork$3__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public TTMultiNetwork$3(TTMultiNetwork$Observer r1, boolean r2, long r3) {
        this.val$observer = r1;
        this.val$enable = r2;
        this.val$currrentTime = r3;
    }
}
