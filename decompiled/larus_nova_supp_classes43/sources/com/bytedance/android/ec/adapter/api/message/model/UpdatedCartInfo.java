package com.bytedance.android.ec.adapter.api.message.model;

import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@ProtoMessage("webcast.im.UpdatedCartInfo")
public class UpdatedCartInfo {

    @SerializedName(DeviceDepend.FoldType.HORIZONTAL)
    public RoomCartStateHorizontal horizontal;
    public RoomCartIconsMsg roomCartIcons;

    @SerializedName(DeviceDepend.FoldType.VERTICAL)
    public RoomCartStateVertical vertical;

    public static class RoomCartIconsMsg extends de.a {
        public RoomCartIconsMsg() {
        }
    }

    @ProtoMessage("webcast.data.CartHorizontal")
    public static class RoomCartStateHorizontal extends de.b {
        public RoomCartStateHorizontal() {
        }
    }

    @ProtoMessage("webcast.data.CartVertical")
    public static class RoomCartStateVertical extends de.b {
        public RoomCartStateVertical() {
        }
    }

    public UpdatedCartInfo() {
    }
}
