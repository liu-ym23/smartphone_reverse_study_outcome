package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g e;

    public e(b r1, String r2, String r3, long r4, com.bytedance.android.live.revenue.common.g r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
    }

    public final void accept(Object r9) {
        Throwable r10 = (Throwable) r9;
        com.bytedance.android.live.profit.privilege.e r0 = com.bytedance.android.live.profit.privilege.e.a;
        String r1 = this.b;
        String r2 = this.c;
        long r3 = this.d;
        String r4 = q0.a(r10);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        com.bytedance.android.live.profit.privilege.e.q(r1, r2, r3, r4, r0.a(r10), this.a.a.c());
        this.e.d("error " + r10);
    }
}
