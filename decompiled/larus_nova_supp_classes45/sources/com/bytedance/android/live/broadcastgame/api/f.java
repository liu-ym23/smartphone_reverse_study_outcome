package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.AudienceGameWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f {
    void a();

    void b();

    AudienceGameWidget getAudienceGameWidget(boolean r1);

    String getGameCategory();

    void onSei(String r1);

    void stopRunningPlugin(String r1);
}
