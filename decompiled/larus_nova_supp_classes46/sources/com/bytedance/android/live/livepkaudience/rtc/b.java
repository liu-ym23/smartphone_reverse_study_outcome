package com.bytedance.android.live.livepkaudience.rtc;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.plantform.core.v;
import gy.h;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        gy.a r7 = this.a.r;
        h r0 = r7.f;
        LiveTracingMonitor.EventModule r2 = LiveTracingMonitor.b(0);
        HashMap r8 = r7.a();
        int r3 = h.d;
        r0.m(r2, "start_time_out", r8, false);
        v r9 = this.a.d;
        if (r9 == null) goto L6;
        r9.R(10001, new IllegalStateException("start time out"));
        return;
    }
}
