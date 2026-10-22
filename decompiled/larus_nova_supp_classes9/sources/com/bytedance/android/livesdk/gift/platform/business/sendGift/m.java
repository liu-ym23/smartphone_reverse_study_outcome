package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.revenue.common.r0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ GiftTransaction a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ long e;

    public m(GiftTransaction r1, String r2, int r3, int r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r14) {
        CustomApiServerException r15 = (Throwable) r14;
        if ((r15 instanceof CustomApiServerException) == false) goto L14;
        String r0 = r15.getTraceId();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        r0 = this.b;
    L13:
        GiftTransaction.j(this.a, r15, this.c, this.d, r0);
    L16:
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().J4() == false) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.O(this.b, this.a.x, this.c, "1", "0", r0.a(r15), this.e, com.bytedance.live.kmp.util.e.b(), null, null);
        return;
    L19:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L14:
        GiftTransaction.j(this.a, r15, this.c, this.d, this.b);
        goto L16
    }
}
