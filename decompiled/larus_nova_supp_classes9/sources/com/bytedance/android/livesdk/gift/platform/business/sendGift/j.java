package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ GiftTransaction a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ long e;

    public j(GiftTransaction r1, String r2, int r3, int r4, long r5) {
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
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().J4() == false) goto L27;
        h2 r2 = GiftManagerKt.l(this.a.x.b);
        String r3 = this.b;
        b0 r4 = this.a.x;
        int r5 = this.c;
        int r6 = r0.a(r15);
        long r7 = this.e;
        long r9 = com.bytedance.live.kmp.util.e.b();
        Integer r16 = null;
        if (r2 == null) goto L20;
        Integer r11 = Integer.valueOf(r2.getType());
    L21:
        if (r2 == null) goto L25;
        List<Long> r8 = r2.getAssetIds();
        if (r8 == null) goto L25;
        r16 = Integer.valueOf(r8.size());
    L25:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.O(r3, r4, r5, "0", "0", r6, r7, r9, r11, r16);
        return;
    L20:
        r11 = null;
        goto L21
    L27:
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
