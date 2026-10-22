package com.bytedance.android.live.room;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IMiddlewareMicRoomService extends IService {
    public static final int ANCHOR_STATUS_END = 3;
    public static final int ANCHOR_STATUS_NULL = 0;
    public static final int ANCHOR_STATUS_PREPARE = 1;
    public static final int ANCHOR_STATUS_START = 2;

    boolean isLoyalAudience();

    boolean isMicRoom(IRoom r1);

    void setLoyalAudience(boolean r1);
}
