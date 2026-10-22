package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.model.LinkFinishResult;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public a(f r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        this.a.i = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r2 = this.b;
        String r4 = this.c;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.B(r2, r4, r8);
        long r3 = this.b;
        com.bytedance.android.live.liveinteract.plantform.utils.x.l(System.currentTimeMillis() - r3, this.c);
        this.a.j.put("data_interact_link_close_request_from", this.c);
        Iterator<uf0.a> r1 = this.a.e.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().u0();
        goto L4
    L6:
        LinkFinishResult r9 = (LinkFinishResult) r8.data;
        TalkRoomLogUtils.V(r9.getTotalApplyNum(), r9.getTotalLinkedNum(), 0);
        this.a.j.put("cmd_finish_video_talk_room_result", Boolean.TRUE);
    }
}
