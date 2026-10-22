package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.gamelive.GameRoomStatsData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomStatusData;", "", "()V", "commentCount", "", "getCommentCount", "()J", "setCommentCount", "(J)V", "giftCount", "getGiftCount", "setGiftCount", "newFansCount", "getNewFansCount", "setNewFansCount", "roomId", "getRoomId", "setRoomId", "watchCount", "getWatchCount", "setWatchCount", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStatusData implements vh7.h {

    @SerializedName("live_comment_ucnt")
    protected long commentCount;

    @SerializedName("live_consume_ucnt")
    protected long giftCount;

    @SerializedName("live_new_fans_ucnt")
    protected long newFansCount;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("live_watch_ucnt")
    protected long watchCount;

    public RoomStatusData() {
    }

    public final long getCommentCount() {
        return this.commentCount;
    }

    public final long getGiftCount() {
        return this.giftCount;
    }

    public final long getNewFansCount() {
        return this.newFansCount;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getWatchCount() {
        return this.watchCount;
    }

    public RoomStatusData(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.roomId = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.watchCount = r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.newFansCount = r5.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.giftCount = r5.j();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.commentCount = r5.j();
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }

    public final void setCommentCount(long r1) {
        this.commentCount = r1;
    }

    public final void setGiftCount(long r1) {
        this.giftCount = r1;
    }

    public final void setNewFansCount(long r1) {
        this.newFansCount = r1;
    }

    public final void setRoomId(long r1) {
        this.roomId = r1;
    }

    public final void setWatchCount(long r1) {
        this.watchCount = r1;
    }
}
