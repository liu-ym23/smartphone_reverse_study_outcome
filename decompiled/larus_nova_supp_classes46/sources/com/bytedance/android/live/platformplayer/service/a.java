package com.bytedance.android.live.platformplayer.service;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayer;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.live.platformplayer.layout.LivePlayerWidget;
import com.bytedance.android.live.platformplayer.layout.d;
import com.bytedance.android.live.platformplayer.layout.f;
import com.bytedance.android.live.platformplayer.playback.LiveProgressBarWidget;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.player.vr.VrBgImageEventController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import xj1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends IService {
    void C1(ILivePlayerClient r1);

    void F4(ILivePlayerClient r1);

    com.bytedance.android.live.platformplayer.utils.b I(r r1, Context r2);

    LivePlayerWidget S0(RoomSession r1);

    VrEffectDownloader T0();

    void Z2();

    c b0();

    com.bytedance.android.live.platformplayer.effect.b c4();

    f getLivePlayerLayoutContext(d r1);

    com.bytedance.android.live.platformplayer.layout.b getLivePlayerLayoutManager();

    com.bytedance.android.live.platformplayer.layout.c getLivePlayerPosition(IRenderView r1);

    VrBgImageEventController i3();

    LivePlatformPlayer m2(long r1);

    void t1();

    LiveProgressBarWidget u1();
}
