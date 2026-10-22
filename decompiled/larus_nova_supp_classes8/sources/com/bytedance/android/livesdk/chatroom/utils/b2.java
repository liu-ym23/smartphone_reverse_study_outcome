package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b2 {
    public static void a(Bundle r3, Bundle r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.getBoolean("live.intent.extra.FROM_NEW_STYLE", false) == false) goto L14;
        r3.putBoolean("live.intent.extra.FROM_NEW_STYLE", r4.getBoolean("live.intent.extra.FROM_NEW_STYLE", false));
        r3.putString("enter_from_live_source", r4.getString("enter_from_live_source"));
        r3.putString("live.intent.extra.WINDOW_MODE", "full_screen");
        Bundle r0 = com.bytedance.android.livesdk.chatroom.m0.a(r3);
        if (TextUtils.equals(r0.getString("enter_from_merge"), "vs_player_detail") == true) goto L9;
    L10:
        r3.putString("live.intent.extra.FEED_URL", r4.getString("live.intent.extra.FEED_URL", ""));
        return;
    L9:
        if (TextUtils.equals(r0.getString("enter_method"), "vs_relevant_live_panel") == false) goto L10;
        return;
    }

    public static void b(Bundle r3, DataCenter r4) {
        if (r4 == null) goto L8;
        Boolean r0 = Boolean.FALSE;
        if (((Boolean) r4.get("data_live_new_feed_style", r0)).booleanValue() == false) goto L9;
        r3.putBoolean("live.intent.extra.FROM_NEW_STYLE", ((Boolean) r4.get("data_live_new_feed_style", r0)).booleanValue());
        r3.putString("enter_from_live_source", (String) r4.get("data_live_first_enter_source", ""));
        r3.putString("live.intent.extra.WINDOW_MODE", "full_screen");
        r3.putString("live.intent.extra.FEED_URL", (String) r4.get("data_live_new_feed_url", ""));
        return;
    L9:
        return;
    }
}
