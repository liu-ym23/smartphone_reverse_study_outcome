package com.bytedance.android.live.liveinteract.revenue.linkroomfight.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.g0;
import com.bytedance.android.livesdk.multilink.base.model.k;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/GetRoomBattleMatchInfoResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/k;", "", "infoStatus", "I", "getInfoStatus", "()I", "setInfoStatus", "(I)V", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchContent;", "matchContent", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchContent;", "getMatchContent", "()Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchContent;", "setMatchContent", "(Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/api/RoomBattleMatchContent;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetRoomBattleMatchInfoResponse extends FlexModelBase<k> implements k, h {

    @SerializedName("status")
    protected int infoStatus;

    @SerializedName("room_battle_match_content")
    protected RoomBattleMatchContent matchContent;

    public GetRoomBattleMatchInfoResponse() {
        super(k.class);
    }

    /* JADX INFO: renamed from: getMatchContent, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ g0 m294getMatchContent() {
        return getMatchContent();
    }

    public int getInfoStatus() {
        return this.infoStatus;
    }

    public RoomBattleMatchContent getMatchContent() {
        return this.matchContent;
    }

    public GetRoomBattleMatchInfoResponse(g r6) {
        super(k.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.infoStatus = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.matchContent = new RoomBattleMatchContent(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    public void setInfoStatus(int r1) {
        this.infoStatus = r1;
    }

    public void setMatchContent(RoomBattleMatchContent r1) {
        this.matchContent = r1;
    }
}
