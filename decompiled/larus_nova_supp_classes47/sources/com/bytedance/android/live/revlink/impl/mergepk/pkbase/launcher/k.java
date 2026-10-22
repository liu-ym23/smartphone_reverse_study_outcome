package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ long b;

    public k(j r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        long r0 = this.b - ((long) 3);
        d51.c r8 = d51.c.A0;
        r8.getClass();
        if (r0 <= ((Number) d51.c.f0.getValue(r8, d51.c.a[56])).longValue()) goto L5;
        this.a.a(IPropInfoNotifyResponse.RequestPropCardNotifyType.TypeAvailable.ordinal());
        return;
    L5:
        this.a.a(IPropInfoNotifyResponse.RequestPropCardNotifyType.TypeExpired.ordinal());
    }
}
