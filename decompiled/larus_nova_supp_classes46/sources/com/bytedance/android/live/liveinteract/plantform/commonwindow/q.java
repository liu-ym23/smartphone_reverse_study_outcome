package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.chatroom.model.interact.t0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public q(s r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r12) {
        com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
        this.a.b = false;
        t0 r0 = (t0) r13.data;
        TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
        long r2 = this.b;
        long r3 = this.c;
        String r14 = r13.logId;
        r1.getClass();
        TalkRoomBusinessFullLinkMonitor.E0(r2, r3, r14);
        x.N(true, this.b, System.currentTimeMillis() - this.c, null);
    }
}
