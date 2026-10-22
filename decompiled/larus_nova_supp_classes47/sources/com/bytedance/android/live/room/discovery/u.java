package com.bytedance.android.live.room.discovery;

import android.content.SharedPreferences;
import com.bytedance.android.live.room.discovery.presenter.SoundCardModeManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u implements com.bytedance.android.live.base.model.push.a {
    public final /* synthetic */ String a;

    public final void b() {
    }

    public final void a() {
        SharedPreferences r0 = SoundCardModeManager.a;
        SoundCardModeManager.e(true);
        SoundCardModeManager.d(true, this.a);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_soundcard_button_on", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_page", "sound_card_suggestion"), TuplesKt.to("capability_button_action", "on")}), new Object[]{Room.class});
    }

    public final void c() {
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_common_inner_push", MapsKt.mapOf(TuplesKt.to("business_scene", "sound_card_suggestion")), new Object[]{Room.class});
    }

    public u(String r1) {
        this.a = r1;
    }
}
