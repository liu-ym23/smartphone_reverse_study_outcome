package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ GiftMVITabView b;

    public t0(int r1, GiftMVITabView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.x(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
