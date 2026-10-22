package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements com.bytedance.android.livesdk.log.filter.v {
    public static final b0 a = null;

    public b0() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new b0();
    }

    public final void L9(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        if ((!Intrinsics.areEqual(r5, "livesdk_audience_playmode_room_watch")) == false) goto L14;
        if ((!Intrinsics.areEqual(r5, "livesdk_audience_playmode_room_watch_duration")) == false) goto L14;
        if ((!Intrinsics.areEqual(r5, "livesdk_anchor_playmode_open_success")) == false) goto L14;
        if ((!Intrinsics.areEqual(r5, "livesdk_anchor_playmode_over")) == false) goto L14;
        if (r6.containsKey("play_mode") == true) goto L14;
        r6.put("play_mode", u0.b());
    L14:
        if (Intrinsics.areEqual(r5, "livesdk_chatroom_game_bomb_crown_show") == false) goto L16;
    L27:
        boolean r7 = ii0.a.b;
        r6.put("play_period", ii0.a.f(GuestBattleContext.Companion.b()));
        return;
    L16:
        if (Intrinsics.areEqual(r5, "livesdk_chatroom_game_bomb_crown_change") == true) goto L27;
        if (Intrinsics.areEqual(r5, "livesdk_audience_playmode_room_watch") == true) goto L27;
        if (Intrinsics.areEqual(r5, "livesdk_audience_playmode_room_watch_duration") == true) goto L27;
        if (Intrinsics.areEqual(r5, "livesdk_audience_playmode_room_link") == true) goto L27;
        if (Intrinsics.areEqual(r5, "livesdk_audience_playmode_room_link_duration") == true) goto L27;
        if (Intrinsics.areEqual(r5, "livesdk_chatroom_game_naming_show") == true) goto L27;
    }
}
