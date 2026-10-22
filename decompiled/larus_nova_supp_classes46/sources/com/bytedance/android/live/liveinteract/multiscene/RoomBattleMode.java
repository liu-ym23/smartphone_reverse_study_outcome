package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.livesdk.chatroom.model.interact.m1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleMode;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/c;", "", "toString", "", "roomBattleModeType", "I", "getRoomBattleModeType", "()I", "setRoomBattleModeType", "(I)V", "Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;", "roomBattleThemeParam", "Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;", "getRoomBattleThemeParam", "()Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;", "setRoomBattleThemeParam", "(Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomBattleMode extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName("room_battle_mode_type")
    protected int roomBattleModeType;

    @SerializedName("room_battle_theme_param")
    protected RoomBattleThemeParam roomBattleThemeParam;

    public RoomBattleMode() {
        super(c.class);
        this.roomBattleModeType = RoomBattleModeType.UNKNOWN.getValue();
    }

    public String toString() {
        return "RoomBattleMode(roomBattleModeType=" + getRoomBattleModeType() + ", roomBattleThemeParam=" + getRoomBattleThemeParam() + ')';
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.c
    public /* bridge */ /* synthetic */ m1 getRoomBattleThemeParam() {
        return getRoomBattleThemeParam();
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.c
    public int getRoomBattleModeType() {
        return this.roomBattleModeType;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.c
    public RoomBattleThemeParam getRoomBattleThemeParam() {
        return this.roomBattleThemeParam;
    }

    public RoomBattleMode(am3.g r7) {
        super(c.class);
        boolean r0 = false;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L12;
        am3.g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        this.roomBattleModeType = r7.i();
        r0 = r0 | true;
        goto L3
    L8:
        if (r3 != 100) goto L9;
        this.roomBattleThemeParam = new RoomBattleThemeParam(r7);
        goto L3
    L9:
        am3.h.d(r4, r7);
        goto L3
    L12:
        r7.d(r1);
        setThreadSafe(true);
        if ((r0 & true) == true) goto L25;
        this.roomBattleModeType = RoomBattleModeType.UNKNOWN.getValue();
        return;
    }

    public void setRoomBattleModeType(int r1) {
        this.roomBattleModeType = r1;
    }

    public void setRoomBattleThemeParam(RoomBattleThemeParam r1) {
        this.roomBattleThemeParam = r1;
    }
}
