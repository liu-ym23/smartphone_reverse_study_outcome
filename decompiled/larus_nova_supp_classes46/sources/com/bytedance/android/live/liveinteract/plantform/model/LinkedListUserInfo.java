package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkedListUserInfo extends FlexModelBase<o> implements o {

    @SerializedName("current_time")
    public long currentTime;

    @SerializedName("expected_leave_time")
    public long expectLeaveTime;

    @SerializedName("join_channel_time")
    public long joinChannelTime;

    public LinkedListUserInfo() {
        super(o.class);
    }

    public String toString() {
        return "LinkedListUserInfo{joinChannelTime=" + this.joinChannelTime + ", expectLeaveTime=" + this.expectLeaveTime + ", currentTime=" + this.currentTime + '}';
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public long getCurrentTime() {
        return this.currentTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public long getExpectLeaveTime() {
        return this.expectLeaveTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public long getJoinChannelTime() {
        return this.joinChannelTime;
    }

    public boolean same(LinkedListUserInfo r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (this.joinChannelTime == r7.joinChannelTime) goto L8;
        return false;
    L8:
        if (this.expectLeaveTime == r7.expectLeaveTime) goto L10;
        return false;
    L10:
        if (this.currentTime != r7.currentTime) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public void setCurrentTime(long r1) {
        this.currentTime = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public void setExpectLeaveTime(long r1) {
        this.expectLeaveTime = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public void setJoinChannelTime(long r1) {
        this.joinChannelTime = r1;
    }

    public static LinkedListUserInfo copy(long r1, long r3, long r5) {
        LinkedListUserInfo r0 = new LinkedListUserInfo();
        r0.joinChannelTime = r1;
        r0.expectLeaveTime = r3;
        r0.currentTime = r5;
        return r0;
    }
}
