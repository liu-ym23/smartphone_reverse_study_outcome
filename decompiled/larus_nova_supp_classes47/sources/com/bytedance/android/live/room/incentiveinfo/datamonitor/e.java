package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ RoomIndicatorDataChangeMonitor b;

    public e(long r1, RoomIndicatorDataChangeMonitor r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        w81.a r5 = this.b.l.get(Long.valueOf(this.a));
        if (r5 == null) goto L6;
        RoomIndicatorDataChangeMonitor r0 = this.b;
        int r1 = w81.b.e;
        r0.f(w81.b.a.b(r5));
        return;
    }
}
