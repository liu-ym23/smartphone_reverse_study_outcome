package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.gamelive.GameRoomStatsResponse.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomStatusResponse;", "", "()V", "closeTitle", "", "getCloseTitle", "()Ljava/lang/String;", "setCloseTitle", "(Ljava/lang/String;)V", "shouldShow", "", "getShouldShow", "()Z", "setShouldShow", "(Z)V", "statusData", "Lcom/bytedance/android/live/broadcast/api/model/RoomStatusData;", "getStatusData", "()Lcom/bytedance/android/live/broadcast/api/model/RoomStatusData;", "setStatusData", "(Lcom/bytedance/android/live/broadcast/api/model/RoomStatusData;)V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStatusResponse implements vh7.h {

    @SerializedName("close_title")
    protected String closeTitle;

    @SerializedName("is_match")
    protected boolean shouldShow;

    @SerializedName("room_stats")
    protected RoomStatusData statusData;

    public RoomStatusResponse() {
        this.closeTitle = "";
    }

    public final String getCloseTitle() {
        return this.closeTitle;
    }

    public final boolean getShouldShow() {
        return this.shouldShow;
    }

    public final RoomStatusData getStatusData() {
        return this.statusData;
    }

    public RoomStatusResponse(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.statusData = new RoomStatusData(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.closeTitle = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.shouldShow = am3.h.a(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.closeTitle != null) goto L31;
        this.closeTitle = "";
        return;
    }

    public final void setCloseTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.closeTitle = r2;
    }

    public final void setShouldShow(boolean r1) {
        this.shouldShow = r1;
    }

    public final void setStatusData(RoomStatusData r1) {
        this.statusData = r1;
    }
}
