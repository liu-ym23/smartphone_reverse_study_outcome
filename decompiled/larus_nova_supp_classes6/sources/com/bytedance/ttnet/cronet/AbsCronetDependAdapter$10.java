package com.bytedance.ttnet.cronet;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ttnet.TTWiFiCellSwitcher;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;
import yx5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class AbsCronetDependAdapter$10 extends ThreadPlus {
    final /* synthetic */ AbsCronetDependAdapter this$0;
    final /* synthetic */ int val$currentState;
    final /* synthetic */ int val$previousState;

    public void run() {
        com_bytedance_ttnet_cronet_AbsCronetDependAdapter$10_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$10__run$___twin___() {
        a.b r0 = a.a(TTWiFiCellSwitcher.class);     // Catch: Exception -> L4
        Class r4 = Integer.TYPE;     // Catch: Exception -> L4
        r0.call("notifyWiFiToCellState", new Class[]{r4, r4}, new Object[]{Integer.valueOf(this.val$previousState), Integer.valueOf(this.val$currentState)});     // Catch: Exception -> L4
    L11:
        this.this$0.onWiFiToCellStateChangedForApp(this.val$previousState, this.val$currentState);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_ttnet_cronet_AbsCronetDependAdapter$10_com_larus_apm_impl_protector_RunnableLancet_run(AbsCronetDependAdapter$10 r1) {
        r1.com_bytedance_ttnet_cronet_AbsCronetDependAdapter$10__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AbsCronetDependAdapter$10(AbsCronetDependAdapter r1, int r2, int r3) {
        this.this$0 = r1;
        this.val$previousState = r2;
        this.val$currentState = r3;
    }
}
