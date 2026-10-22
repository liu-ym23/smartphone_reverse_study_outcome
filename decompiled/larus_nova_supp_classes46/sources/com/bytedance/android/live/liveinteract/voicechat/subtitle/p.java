package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;
    public final /* synthetic */ long b;

    public p(LinkmicSubtitleBusinessWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        LinkmicSubtitleBusinessWidget r1 = this.a;
        int r2 = LinkmicSubtitleBusinessWidget.x;
        long r3 = r1.getRoom().getId();
        long r4 = this.b;
        r0.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("room_id", r3);
        LinkMonitorData r6 = LinkMonitorData.AudioSubtitleOepnMonitorData;
        long r8 = TalkRoomBusinessFullLinkMonitor.h(r4);
        TalkRoomBusinessFullLinkMonitor.Y(r6, r8, (Throwable) r7, r5);
    }
}
