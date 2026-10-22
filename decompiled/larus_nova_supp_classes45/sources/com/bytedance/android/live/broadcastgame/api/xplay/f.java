package com.bytedance.android.live.broadcastgame.api.xplay;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f {
    XplayGuestType a();

    String getAppId();

    String getGameName();

    <T> T getService(Class<T> r1);

    void stop();
}
