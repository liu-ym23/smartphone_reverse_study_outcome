package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.jsbridge.methods.d1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    String a();

    d1.d b();

    d1.c c();

    User getAnchor();

    long getEndTime();

    String getPromotionId();

    Room getRoom();

    String getRoomId();

    long getStartTime();

    String getTitle();

    String getType();

    String getVideoId();
}
