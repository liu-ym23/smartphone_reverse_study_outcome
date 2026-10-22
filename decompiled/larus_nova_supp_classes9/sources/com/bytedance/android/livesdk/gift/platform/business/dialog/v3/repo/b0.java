package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshMostlyUsedTabPinTopStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0<T> implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public b0(int r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Throwable r5 = (Throwable) r7;
        int r0 = 1;
        if (this.a != 1) goto L5;
        r0 = 2;
    L5:
        uz1.a r8 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r8 == null) goto L8;
        r8.a(new RefreshMostlyUsedTabPinTopStatus(r0, this.b));
    L8:
        com.bytedance.android.livesdk.gift.platform.core.b0.a.e(this.a, this.c, null, r5);
    }
}
