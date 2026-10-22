package com.bytedance.android.live.profit.fansclub.transfer;

import android.os.SystemClock;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f;

    public g(b r1, long r2, String r4, String r5, long r6, com.bytedance.android.live.revenue.common.g r8) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
    }

    public final void accept(Object r13) {
        n r14 = (n) r13;
        long r9 = SystemClock.uptimeMillis() - this.b;
        com.bytedance.android.live.profit.privilege.e.a.r(this.c, this.d, this.e, r9, this.a.a.c());
        this.f.a("success");
    }
}
