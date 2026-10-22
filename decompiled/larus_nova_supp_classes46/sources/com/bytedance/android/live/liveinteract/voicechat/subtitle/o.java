package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;
    public final /* synthetic */ long b;

    public o(LinkmicSubtitleBusinessWidget r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        LinkmicSubtitleBusinessWidget r0 = this.a;
        com.bytedance.android.livesdk.chatroom.model.interact.o r1 = (com.bytedance.android.livesdk.chatroom.model.interact.o) r8.data;
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.getVersionId());
    L6:
        r0.f = r2.longValue();
        TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
        long r4 = this.a.getRoom().getId();
        long r5 = this.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r8, "response");
        JSONObject r6 = new JSONObject();
        r6.put("room_id", r4);
        TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.AudioSubtitleOepnMonitorData, TalkRoomBusinessFullLinkMonitor.h(r5), r8.logId, r6);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
