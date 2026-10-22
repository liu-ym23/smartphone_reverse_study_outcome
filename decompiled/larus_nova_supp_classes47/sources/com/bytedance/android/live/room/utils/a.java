package com.bytedance.android.live.room.utils;

import android.app.Activity;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    int a();

    boolean b(RoomContext r1);

    void c(DataCenter r1, Activity r2, Room r3, com.bytedance.android.live.base.model.moreliveentrance.b r4, boolean r5);

    boolean enableMoreEntranceMarqueeType();

    String getMoreEntranceTitle();

    boolean interceptLeftSlideOpenDrawer();

    long marqueeDelayTime();

    long marqueeSingleInternalDuration();

    boolean useNewShowStrategy();
}
