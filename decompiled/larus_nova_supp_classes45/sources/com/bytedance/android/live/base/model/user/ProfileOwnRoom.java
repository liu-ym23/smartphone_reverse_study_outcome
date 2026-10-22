package com.bytedance.android.live.base.model.user;

import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ProfileOwnRoom {

    @SerializedName("room_ids_display")
    List<Integer> roomIdDisplay;

    @SerializedName("room_ids")
    List<Long> roomIdList;

    @SerializedName("room_ids_str")
    List<String> roomIdStrList;

    public ProfileOwnRoom() {
    }

    public boolean canJumpToLiveRoom() {
        if (Lists.isEmpty(this.roomIdDisplay) == false) goto L5;
    L7:
        return true;
    L5:
        if (((Integer) ListProtector.get(this.roomIdDisplay, 0)).intValue() != 0) goto L7;
        return false;
    }

    public long getId() {
        if (Lists.isEmpty(this.roomIdList) == false) goto L6;
        return 0;
    L6:
        return ((Long) ListProtector.get(this.roomIdList, 0)).longValue();
    }

    public List<Long> getRoomIdList() {
        return this.roomIdList;
    }

    public List<String> getRoomIdStrList() {
        return this.roomIdStrList;
    }
}
