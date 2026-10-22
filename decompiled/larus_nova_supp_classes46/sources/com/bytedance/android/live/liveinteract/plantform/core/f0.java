package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ h1 b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ long d;

    public f0(y r1, h1 r2, Long r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        this.a.t(this.b);
        TalkRoomBusinessFullLinkMonitor r9 = TalkRoomBusinessFullLinkMonitor.a;
        h1 r0 = this.b;
        Long r1 = this.c;
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        long r3 = this.d;
        TalkRoomBusinessFullLinkMonitor.WrdsStatusType r5 = TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Timeout;
        r9.getClass();
        TalkRoomBusinessFullLinkMonitor.A0(r0, r2, r3, r5);
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
