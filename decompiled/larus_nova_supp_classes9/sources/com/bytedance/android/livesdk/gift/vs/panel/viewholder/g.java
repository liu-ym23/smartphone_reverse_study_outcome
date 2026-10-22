package com.bytedance.android.livesdk.gift.vs.panel.viewholder;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements Runnable {
    public final /* synthetic */ VSGiftDialogViewHolder a;

    public g(VSGiftDialogViewHolder r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VSGiftDialogViewHolder r0 = this.a;     // Catch: Throwable -> L4
        int r1 = VSGiftDialogViewHolder.E;     // Catch: Throwable -> L4
        r0.j4();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
