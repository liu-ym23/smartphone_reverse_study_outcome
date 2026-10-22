package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface j {
    float a();

    void forceStopLoadStallMonitor(long r1, boolean r3);

    void onEnterPlay();

    void onEnterRoom();

    void onExitRoom();

    void onModuleStart(String r1, Map<String, String> r2);

    void onModuleStop(String r1);

    void release(int r1);

    void setStreamType(int r1);

    void startLoadStallMonitor(long r1);

    void startTimerMonitor(int r1);

    void stopTimerMonitor(int r1);
}
