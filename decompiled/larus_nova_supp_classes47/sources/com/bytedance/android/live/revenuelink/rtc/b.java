package com.bytedance.android.live.revenuelink.rtc;

import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorRtcManager a;

    public b(AnchorRtcManager r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        d r7 = this.a.g;
        jy0.b.f(r7.a, "startRtcTimeOut", null, 4);
        m.d(r7.f, r7.d(), "start_time_out", r7.c(), 8);
        Iterator<g> r8 = this.a.e.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        g r0 = r8.next();
        if (r0 == null) goto L4;
        r0.R(10001, new IllegalStateException("start time out"));
        goto L4
    }
}
