package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public b(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        k1 r4 = (k1) ((com.bytedance.android.live.network.response.e) r3).data;
        if (r4 == null) goto L17;
        p2 r5 = r4.getLinkmicPlayModeInfo();
        if (r5 == null) goto L18;
        com.bytedance.android.live.liveinteract.multiscene.a r6 = r5.getTeamFightInfo();
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.getTeamBattleType() != 1) goto L20;
        Integer r7 = je0.d.h();
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.intValue() != 27) goto L21;
        this.a.h.put("stage_is_insert", Boolean.FALSE);
        this.a.Eq();
        this.a.dr(false);
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    }
}
