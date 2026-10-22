package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.m1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListUserLinkmicContent extends FlexModelBase<m1> implements m1 {

    @SerializedName("anchor_auth_role")
    public int anchorAuthRole;

    @SerializedName("host_back_color")
    public String hostLabelBackgroundColor;

    @SerializedName("host_name")
    public String hostLabelName;

    @SerializedName("host_name_color")
    public String hostLabelNameColor;

    @SerializedName("host_switch")
    public boolean hostSwitch;

    @SerializedName("live_room_mode")
    public long liveRoomMode;

    @SerializedName("anchor_linkmic_id_info")
    public AnchorLinkMicIdInfo mAnchorLinkMicIdInfo;

    @SerializedName("game_name")
    public String mGameName;

    @SerializedName("resource_id")
    public long resourceId;

    @SerializedName("pk_user_role")
    public int role;

    @SerializedName("virtual_tool")
    public String virtualTool;

    public static final enum AnchorAuthRole extends Enum<AnchorAuthRole> {
        public static final AnchorAuthRole AnchorAuthRoleGeneral = null;
        public static final AnchorAuthRole AnchorAuthRoleOrganizer = null;
        public static final /* synthetic */ AnchorAuthRole[] a = null;

        static {
            AnchorAuthRole r0 = new AnchorAuthRole("AnchorAuthRoleGeneral", 0);
            AnchorAuthRoleGeneral = r0;
            AnchorAuthRole r1 = new AnchorAuthRole("AnchorAuthRoleOrganizer", 1);
            AnchorAuthRoleOrganizer = r1;
            a = new AnchorAuthRole[]{r0, r1};
        }

        public static AnchorAuthRole[] values() {
            return (AnchorAuthRole[]) a.clone();
        }

        public static AnchorAuthRole valueOf(String r1) {
            return (AnchorAuthRole) r27.a.a(AnchorAuthRole.class, r1);
        }

        public AnchorAuthRole(String r1, int r2) {
            super(r1, r2);
        }
    }

    public ListUserLinkmicContent() {
        super(m1.class);
    }

    public int getAnchorAuthRole() {
        return this.anchorAuthRole;
    }

    public com.bytedance.android.livesdk.link.model.bridge.j getAnchorLinkMicIdInfo() {
        return this.mAnchorLinkMicIdInfo;
    }

    public String getGameName() {
        return this.mGameName;
    }

    public String getHostLabelBackgroundColor() {
        return this.hostLabelBackgroundColor;
    }

    public String getHostLabelName() {
        return this.hostLabelName;
    }

    public String getHostLabelNameColor() {
        return this.hostLabelNameColor;
    }

    public boolean getHostSwitch() {
        return this.hostSwitch;
    }

    public long getLiveRoomMode() {
        return this.liveRoomMode;
    }

    public String getVirtualTool() {
        return this.virtualTool;
    }
}
