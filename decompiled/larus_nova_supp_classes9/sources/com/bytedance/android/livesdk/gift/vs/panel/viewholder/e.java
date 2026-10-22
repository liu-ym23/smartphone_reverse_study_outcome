package com.bytedance.android.livesdk.gift.vs.panel.viewholder;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements Runnable {
    public final /* synthetic */ AbsPanel a;
    public final /* synthetic */ VSGiftDialogViewHolder b;

    public e(AbsPanel r1, VSGiftDialogViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbsPanel r1 = this.a;     // Catch: Throwable -> L7
        IBaseUser r4 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();     // Catch: Throwable -> L7
        VSGiftDialogViewHolder r0 = this.b;     // Catch: Throwable -> L7
        int r5 = VSGiftDialogViewHolder.E;     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.C0022a) == false) goto L5;
        GiftStateMachineConfig.a.C0022a r2 = (GiftStateMachineConfig.a.C0022a) com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i();     // Catch: Throwable -> L7
    L5:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.q(r1, 1, 3, r4, this.b.D));     // Catch: Throwable -> L7
        this.b.getClass();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
