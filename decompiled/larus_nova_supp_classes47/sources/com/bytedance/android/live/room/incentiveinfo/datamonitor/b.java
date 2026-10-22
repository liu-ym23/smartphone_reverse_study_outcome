package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ AnchorTrafficSupportDataChangeMonitor.b a;

    public b(AnchorTrafficSupportDataChangeMonitor.b r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        String r6 = (String) r5;
        AnchorTrafficSupportDataChangeMonitor.b r7 = this.a;
        AnchorTrafficSupportDataChangeMonitor r0 = r7.b;
        int r1 = w81.b.e;
        w81.a r8 = r0.i.get(Long.valueOf(r7.a));
        if (r8 != null) goto L5;
        r8 = this.a.b.h;
    L5:
        r0.f(w81.b.a.b(r8));
        AnchorTrafficSupportDataChangeMonitor.b r9 = this.a;
        r9.b.m.put(Long.valueOf(r9.a), Boolean.FALSE);
        AnchorTrafficSupportDataChangeMonitor.b r10 = this.a;
        r10.b.i.remove(Long.valueOf(r10.a));
    }
}
