package com.bytedance.android.live.base.model.live;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RoomAttrs implements IRoomAttrs {

    @SerializedName("admin_flag")
    private int adminFlag;

    @SerializedName("fanticket_this_room")
    public long currentRoomContribution;

    @SerializedName("rank_this_room")
    public int currentRoomRank;

    @SerializedName("rank")
    public int rank;

    @SerializedName("silence_flag")
    private int silenceFlag;

    public RoomAttrs() {
    }

    public int hashCode() {
        return (((this.silenceFlag * 31) + this.adminFlag) * 31) + this.rank;
    }

    @Override // com.bytedance.android.live.base.model.live.IRoomAttrs
    public int getAdminFlag() {
        return this.adminFlag;
    }

    @Override // com.bytedance.android.live.base.model.live.IRoomAttrs
    public int getRank() {
        return this.rank;
    }

    @Override // com.bytedance.android.live.base.model.live.IRoomAttrs
    public int getSilenceFlag() {
        return this.silenceFlag;
    }

    public static RoomAttrs from(IRoomAttrs r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof RoomAttrs) == false) goto L9;
        Gson r0 = GsonHelper.get();
        return (RoomAttrs) GsonProtectorUtils.fromJson(r0, GsonProtectorUtils.toJson(r0, r2), RoomAttrs.class);
    L9:
        RoomAttrs r1 = new RoomAttrs();
        r1.initWith(r2);
        return r1;
    }

    private void initWith(IRoomAttrs r2) {
        this.silenceFlag = r2.getSilenceFlag();
        this.adminFlag = r2.getAdminFlag();
        this.rank = r2.getRank();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L21;
        RoomAttrs r6 = (RoomAttrs) r5;
        if (this.silenceFlag == r6.silenceFlag) goto L14;
        return false;
    L14:
        if (this.adminFlag == r6.adminFlag) goto L17;
        return false;
    L17:
        if (this.rank == r6.rank) goto L22;
        return false;
    L22:
        return true;
    }

    public void setAdminFlag(int r1) {
        this.adminFlag = r1;
    }

    public void setRank(int r1) {
        this.rank = r1;
    }

    public void setSilenceFlag(int r1) {
        this.silenceFlag = r1;
    }
}
