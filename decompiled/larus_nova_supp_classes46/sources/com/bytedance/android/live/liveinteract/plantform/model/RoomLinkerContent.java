package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class RoomLinkerContent extends FlexModelBase<g2> implements g2 {

    @SerializedName("anchor_open_id")
    public String anchorId;

    @SerializedName("linked_users")
    public List<com.bytedance.android.livesdk.link.model.bridge.k> linkedUsers;

    @SerializedName("anchor_id")
    public long mAnchorId;

    @SerializedName("is_anchor_background")
    public int mIsGuestAnchorBackground;

    @SerializedName("room_link_silence_status")
    public int mRoomLinkSilenceStatus;

    @SerializedName("version")
    public long mVersion;

    @SerializedName("live_room_mode")
    public long roomLiveMode;

    public RoomLinkerContent() {
        super(g2.class);
        this.mRoomLinkSilenceStatus = 0;
        this.mAnchorId = 0;
        this.mIsGuestAnchorBackground = 0;
        this.anchorId = "";
        this.roomLiveMode = 0;
    }

    public String getAnchorIdString() {
        return String.valueOf(this.mAnchorId);
    }

    public List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedUsers() {
        return KotlinTypeUtilsKt.castElementType(this.linkedUsers);
    }

    public long isGuestAnchorBackground() {
        return this.mIsGuestAnchorBackground;
    }

    public String toString() {
        return "RoomLinkerContent{linkedUsers=" + this.linkedUsers + ", roomLinkSilenceStatus=" + this.mRoomLinkSilenceStatus + ", isGuestAnchorBackground=" + this.mIsGuestAnchorBackground + '}';
    }

    public long getAnchorId() {
        return this.mAnchorId;
    }

    public long getLiveRoomMode() {
        return this.roomLiveMode;
    }

    public long getMVersion() {
        return this.mVersion;
    }

    public int getRoomLinkSilenceStatus() {
        return this.mRoomLinkSilenceStatus;
    }

    public long getVersion() {
        return this.mVersion;
    }
}
