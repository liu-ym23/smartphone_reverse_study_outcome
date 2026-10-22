package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public b(f r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r5) {
        Throwable r6 = (Throwable) r5;
        this.a.i = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.b;
        String r3 = this.c;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.A(r1, r3, r6);
        long r2 = this.b;
        com.bytedance.android.live.liveinteract.plantform.utils.x.k(r6, System.currentTimeMillis() - r2, this.c);
        Iterator<uf0.a> r4 = this.a.e.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().l0(r6);
        goto L4
    L6:
        this.a.j.put("cmd_finish_video_talk_room_result", Boolean.FALSE);
    }
}
