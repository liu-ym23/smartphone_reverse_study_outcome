package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ GiftTransaction a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ long e;

    public i(GiftTransaction r1, String r2, int r3, int r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r13) {
        ExtraResponse r14 = (ExtraResponse) r13;
        long r8 = com.bytedance.live.kmp.util.e.b();
        GiftTransaction r0 = this.a;
        p2 r1 = (p2) r14.data;
        String r2 = r14.logId;
        String r3 = this.b;
        int r4 = this.c;
        r0.getClass();
        r1.setLogId(r2);
        r1.setTraceId(r3);
        r1.setReqIndex(r4);
        this.a.e.onNext(r14);
        GiftTransaction.k(this.a, (p2) r14.data, this.d, this.c, this.e, r8);
        if (com.bytedance.android.livesdk.gift.platform.core.f.a().J4() == false) goto L15;
        String r5 = this.b;
        b0 r6 = this.a.x;
        int r7 = this.d;
        long r9 = this.e;
        h1 r10 = ((p2) r14.data).getGift();
        Integer r11 = null;
        if (r10 == null) goto L7;
        Integer r15 = Integer.valueOf(r10.getType());
    L8:
        h1 r16 = ((p2) r14.data).getGift();
        if (r16 == null) goto L13;
        List<Long> r17 = r16.getAssetIds();
        if (r17 == null) goto L13;
        r11 = Integer.valueOf(r17.size());
    L13:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.O(r5, r6, r7, "0", "1", -1, r9, r8, r15, r11);
        return;
    L7:
        r15 = null;
        goto L8
    }
}
