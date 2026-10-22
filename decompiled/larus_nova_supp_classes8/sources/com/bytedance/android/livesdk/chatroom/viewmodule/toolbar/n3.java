package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.model.LiveBroadcastMusicEffectInfo;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n3 implements zg1.q {
    public final /* synthetic */ m3.g a;
    public final /* synthetic */ Effect b;
    public final /* synthetic */ com.bytedance.android.live.pushstream.d c;

    public final void onResult(boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "failMsg");
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n r2 = r1.getDownLoadingInteractEffectId();
        if (r2 == null) goto L7;
        r2.setValue(null);
    L7:
        boolean r3 = true;
        if (r14 == false) goto L39;
        xs2.b r16 = xs2.b.a();
        String r6 = this.a.a.f.e();
        boolean r8 = this.a.c;
        r16.post(new com.bytedance.android.live.broadcastgame.api.model.f0(r6, ReloadPanelType.FROM_CAHCE, r8, false, 8));
        this.a.a.getClass();
        xs2.b.a().post(new d10.b(true));
        m3.g r17 = this.a;
        if (r17.c == false) goto L28;
        dp1.d.a(this.b.getEffectId());
        if (this.a.b == true) goto L14;
        com.bytedance.android.live.core.utils.f2.c("打开成功", 0);
    L14:
        RoomContext r18 = RoomContext.a.c(r0, m3.a(this.a.a), 0, 2);
        if (r18 == null) goto L26;
        com.bytedance.live.datacontext.n r19 = r18.getBroadcastMusicEffectInfo();
        if (r19 == null) goto L26;
        m3.g r4 = this.a;
        String r9 = r4.e;
        id2.c r5 = r4.a.e;
        if (r5 == null) goto L24;
        String r7 = String.valueOf(r5.a);
        if (r7 == null) goto L24;
        String r10 = r7;
    L25:
        r19.setValue(new LiveBroadcastMusicEffectInfo(r9, r10, null, 4, null));
    L24:
        r10 = "";
    L26:
        m3.a(this.a.a).put("anchor_interact_effect_music_open", Boolean.TRUE);
        return;
    L28:
        if (r17.b == false) goto L32;
        com.bytedance.android.live.pushstream.d r110 = this.c;
        if (r110 == null) goto L32;
        r110.e0("MusicInformationData", "");
    L32:
        RoomContext r111 = RoomContext.a.c(r0, m3.a(this.a.a), 0, 2);
        if (r111 == null) goto L37;
        com.bytedance.live.datacontext.n r112 = r111.getBroadcastMusicEffectInfo();
        if (r112 == null) goto L37;
        r112.setValue(new LiveBroadcastMusicEffectInfo("", "", null, 4, null));
    L37:
        m3.a(this.a.a).put("anchor_interact_effect_music_open", Boolean.FALSE);
        com.bytedance.android.live.core.utils.f2.c("退出成功", 0);
        return;
    L39:
        if (this.a.c == true) goto L41;
        com.bytedance.android.live.core.utils.f2.c("退出失败", 0);
    L48:
        m3 r113 = this.a.a;
        int r114 = m3.g;
        r113.e();
        return;
    L41:
        if (r15.length() > 0) goto L44;
        r3 = false;
    L44:
        if (r3 == false) goto L46;
        com.bytedance.android.live.core.utils.f2.c(r15, 0);
        goto L48
    L46:
        com.bytedance.android.live.core.utils.f2.c("打开失败", 0);
        goto L48
    }

    public n3(m3.g r1, Effect r2, com.bytedance.android.live.pushstream.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
