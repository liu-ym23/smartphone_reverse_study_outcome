package com.bytedance.ttnet;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTMultiNetwork$2 implements Runnable {
    final /* synthetic */ int val$currentState;
    final /* synthetic */ long val$currrentTime;
    final /* synthetic */ TTMultiNetwork$Observer val$observer;
    final /* synthetic */ int val$previousState;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_ttnet_TTMultiNetwork$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_TTMultiNetwork$2__run$___twin___() {
        this.val$observer.onMultiNetStateChanged(TTMultiNetwork.State.convertToState(this.val$previousState), TTMultiNetwork.State.convertToState(this.val$currentState), this.val$currrentTime);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_TTMultiNetwork$2_com_larus_apm_impl_protector_RunnableLancet_run(TTMultiNetwork$2 r1) {
        r1.com_bytedance_ttnet_TTMultiNetwork$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public TTMultiNetwork$2(TTMultiNetwork$Observer r1, int r2, int r3, long r4) {
        this.val$observer = r1;
        this.val$previousState = r2;
        this.val$currentState = r3;
        this.val$currrentTime = r4;
    }
}
