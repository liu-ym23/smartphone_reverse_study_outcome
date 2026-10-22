package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftMostlyUsedStatus;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ long e;

    public z(c0 r1, long r2, int r4, int r5, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final void accept(Object r9) {
        Throwable r6 = (Throwable) r9;
        c0 r10 = this.a;
        long r1 = this.b;
        int r3 = this.c;
        int r4 = this.d;
        r10.getClass();
        uz1.a r11 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.b();
        if (r11 == null) goto L5;
        r11.a(new RefreshGiftMostlyUsedStatus(r1, r3, r4, false));
    L5:
        com.bytedance.android.livesdk.gift.platform.core.b0.a.d(this.b, this.e, this.c, r6);
    }
}
