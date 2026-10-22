package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface l {
    ILiveRoomController a(long r1, int r3);

    void c();

    void d(String r1);

    IRoom f();

    Bundle g(Bundle r1);

    boolean h(DataCenter r1, Bundle r2);

    boolean isMicRoom(IRoom r1);
}
