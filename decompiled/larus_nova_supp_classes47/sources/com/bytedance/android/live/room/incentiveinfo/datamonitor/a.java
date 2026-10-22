package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import com.bytedance.android.live.base.model.message.m5;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ AnchorTrafficSupportDataChangeMonitor b;
    public final /* synthetic */ m5 c;

    public a(long r1, AnchorTrafficSupportDataChangeMonitor r3, m5 r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final void accept(Object r4) {
        String r5 = (String) r4;
        AnchorTrafficSupportDataChangeMonitor r6 = this.b;
        int r0 = w81.b.e;
        w81.a r1 = r6.i.get(Long.valueOf(this.a));
        if (r1 != null) goto L5;
        r1 = this.b.h;
    L5:
        r6.f(w81.b.a.b(r1));
        this.b.m.put(Long.valueOf(this.a), Boolean.FALSE);
    }
}
