package com.bytedance.ttnet;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TTWiFiCellSwitcher$1 implements Runnable {
    final /* synthetic */ TTWiFiCellSwitcher this$0;
    final /* synthetic */ int val$currentState;
    final /* synthetic */ TTWiFiCellSwitcher.Observer val$observer;
    final /* synthetic */ int val$previousState;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_ttnet_TTWiFiCellSwitcher$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_TTWiFiCellSwitcher$1__run$___twin___() {
        this.val$observer.onStateChanged(TTWiFiCellSwitcher.State.convertToState(this.val$previousState), TTWiFiCellSwitcher.State.convertToState(this.val$currentState));
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_TTWiFiCellSwitcher$1_com_larus_apm_impl_protector_RunnableLancet_run(TTWiFiCellSwitcher$1 r1) {
        r1.com_bytedance_ttnet_TTWiFiCellSwitcher$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public TTWiFiCellSwitcher$1(TTWiFiCellSwitcher r1, TTWiFiCellSwitcher.Observer r2, int r3, int r4) {
        this.this$0 = r1;
        this.val$observer = r2;
        this.val$previousState = r3;
        this.val$currentState = r4;
    }
}
