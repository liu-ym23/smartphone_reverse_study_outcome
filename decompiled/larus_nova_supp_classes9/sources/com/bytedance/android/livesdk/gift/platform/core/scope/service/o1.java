package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o1 implements r3.b {
    public final /* synthetic */ GiftMessageService a;

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.r3.b
    public final void a() {
        Disposable r0 = this.a.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L12;
        Disposable r1 = this.a.n;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.n(this.a.l);
        return;
    }

    public o1(GiftMessageService r1) {
        this.a = r1;
    }
}
