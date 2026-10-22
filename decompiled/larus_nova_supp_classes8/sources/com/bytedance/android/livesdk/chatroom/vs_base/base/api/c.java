package com.bytedance.android.livesdk.chatroom.vs_base.base.api;

import com.bytedance.android.livesdk.room.data.EndReason;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {
    void addLifecycleObserver(jm1.b r1);

    void addLifecycleObserver(jm1.b r1, int r2);

    void addTask(a r1);

    void destroy();

    void endVideo(EndReason r1);

    void enterVideo();
}
