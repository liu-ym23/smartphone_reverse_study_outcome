package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.RoomInteractPanelData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/l0;", "", "Lcom/bytedance/android/live/broadcastgame/api/model/b;", "broadcastInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/b;", "Lcom/bytedance/android/live/broadcastgame/api/model/m;", "topArea", "Lcom/bytedance/android/live/broadcastgame/api/model/m;", "gameArea", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 implements vh7.h {

    @SerializedName("broadcast_info")
    public b broadcastInfo;

    @SerializedName("game_area")
    public m gameArea;

    @SerializedName("top_area")
    public m topArea;

    public l0() {
        this.broadcastInfo = null;
        this.topArea = null;
        this.gameArea = null;
    }

    public l0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.broadcastInfo = new b(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.topArea = new m(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.gameArea = new m(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.broadcastInfo != null) goto L19;
        this.broadcastInfo = null;
    L19:
        if (this.topArea != null) goto L22;
        this.topArea = null;
    L22:
        if (this.gameArea != null) goto L37;
        this.gameArea = null;
        return;
    }
}
